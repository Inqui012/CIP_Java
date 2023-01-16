package Meds;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Meds_Controller
 */
@WebServlet("/")
public class Meds_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Meds_DAO DB;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		DB = new Meds_DAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String url = req.getServletPath();
		String root = req.getContextPath();
		String div = req.getParameter("div");
		switch(url) {
		case "/":
			getServletContext().getRequestDispatcher("/Meds.jsp").forward(req, resp);				
			break;
		case "/sellMeds":
			if(div == null) {
				List<Meds_DTO_Products> medList = DB.getAllProduct(" ORDER BY NAME");
				req.setAttribute("meds", medList);
				getServletContext().getRequestDispatcher("/pages/sell/SellMeds.jsp").forward(req, resp);								
			} else {
				List<String> medsQuant = Arrays.asList(req.getParameterValues("medsQuant"));
				List<String> medsCode = Arrays.asList(req.getParameterValues("medsCode"));
				String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				DB.sellOrder(medsQuant, medsCode, now, div);
				DB.updateStock(medsCode);
				resp.sendRedirect(root + "/sellMeds");
			}
			break;
		case "/sellRefund":
			String refunding = req.getParameter("refund");
			if(refunding == null) {
				List<Meds_DTO_SaleList> sellList = DB.getAllSell();
				req.setAttribute("sellList", sellList);
				getServletContext().getRequestDispatcher("/pages/sell/SellRefund.jsp").forward(req, resp);								
			} else {
				DB.sellRefund(req.getParameter("refundNo"));
				DB.updateStock(DB.getRefundProd(req.getParameter("refundNo")));
				resp.sendRedirect(root + "/sellRefund");
			}
			break;
		case "/prodMag":
			getServletContext().getRequestDispatcher("/pages/prod/ProductManage.jsp").forward(req, resp);				
			break;
		case"/prodAdd":
			String adding = req.getParameter("add");
			if(adding == null) {
				req.setAttribute("nextCode", DB.getMaxNum());			
				getServletContext().getRequestDispatcher("/pages/prod/ProductAdd.jsp").forward(req, resp);								
			} else {
				Meds_DTO_Products newProd = new Meds_DTO_Products();
				newProd.setName(req.getParameter("prodName"));
				newProd.setMadeby(req.getParameter("prodMade"));
				newProd.setInprice(Integer.parseInt(req.getParameter("prodIn")));
				newProd.setOutprice(Integer.parseInt(req.getParameter("prodOut")));
				newProd.setStored(Integer.parseInt(req.getParameter("prodStock")));			
				DB.prodAdd(newProd);
				resp.sendRedirect(root + "/sellMeds");
			}
			break;
		case"/prodEdit":
			String editing = req.getParameter("edit");
			if(editing == null) {
				List<Meds_DTO_Products> medList = DB.getAllProduct(" ORDER BY NAME");
				req.setAttribute("meds", medList);
				getServletContext().getRequestDispatcher("/pages/prod/ProductEdit_List.jsp").forward(req, resp);												
			} else {
				if(editing.equals("N")) {
					req.setAttribute("Selected", DB.getOneProduct(req.getParameter("prodcode")));
					getServletContext().getRequestDispatcher("/pages/prod/ProductEdit_Edit.jsp").forward(req, resp);																	
				} else {
					Meds_DTO_Products newMed = new Meds_DTO_Products();
					newMed.setCode(Integer.parseInt(req.getParameter("prodCode")));
					newMed.setName(req.getParameter("prodName"));
					newMed.setMadeby(req.getParameter("prodMade"));
					newMed.setInprice(Integer.parseInt(req.getParameter("prodIn")));
					newMed.setOutprice(Integer.parseInt(req.getParameter("prodOut")));
					DB.editProd(newMed);
					resp.sendRedirect(root + "/prodEdit");
				}
			}
			break;
		case"/prodRemove":
			String removing = req.getParameter("remove");
			if(removing == null) {
				List<Meds_DTO_Products> medStockZero = DB.getAllProduct(" WHERE STORED = 0");
				req.setAttribute("stockZero", medStockZero);
				getServletContext().getRequestDispatcher("/pages/prod/ProductRemove.jsp").forward(req, resp);								
			} else {
				String removeCode = req.getParameter("prodRemove");
				DB.prodRemove(removeCode);
				resp.sendRedirect(root + "/prodRemove");
			}
			break;
		case"/storeMag":
			getServletContext().getRequestDispatcher("/pages/store/StoreManage.jsp").forward(req, resp);				
			break;
		case"/storeOrder":
			if(div == null) {
				List<Meds_DTO_Products> medStock = DB.getAllProduct(" ORDER BY STORED");
				req.setAttribute("meds", medStock);
				getServletContext().getRequestDispatcher("/pages/store/StoreOrder.jsp").forward(req, resp);				
			} else {
				List<String> medsQuant = Arrays.asList(req.getParameterValues("medsQuant"));
				List<String> medsCode = Arrays.asList(req.getParameterValues("medsCode"));
				String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				DB.sellOrder(medsQuant, medsCode, now, div);
				DB.updateStock(medsCode);
				resp.sendRedirect(root + "/storeOrder");				
			}
			break;
		case"/storeRefund":
			String stRefunding = req.getParameter("refund");
			if(stRefunding == null) {
				List<Meds_DTO_Products> medStoreList = DB.getAllProduct(" ORDER BY NAME");
				req.setAttribute("meds", medStoreList);
				getServletContext().getRequestDispatcher("/pages/store/StoreRefund.jsp").forward(req, resp);								
			} else {
				String medsCode = req.getParameter("prodcode");
				String medsQuant = req.getParameter("refundQuant");
				String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				DB.storeRefund(Integer.parseInt(medsCode), Integer.parseInt(medsQuant), now);
				DB.updateStock(medsCode);
				resp.sendRedirect(root + "/storeRefund");				
			}
			break;
		}
	}	
}

