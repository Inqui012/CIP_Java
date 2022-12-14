package Meds;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		case "/sellMag":
			getServletContext().getRequestDispatcher("/pages/SellManage.jsp").forward(req, resp);				
			break;
		case "/sellMeds":
			if(div == null) {
				List<Meds_DTO_Products> medList = DB.getAllProduct(" ORDER BY NAME");
				req.setAttribute("meds", medList);
				getServletContext().getRequestDispatcher("/pages/SellMeds.jsp").forward(req, resp);								
			} else {
				String[] medsQuant = req.getParameterValues("medsQuant");
				String[] medsCode = req.getParameterValues("medsCode");
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
				getServletContext().getRequestDispatcher("/pages/SellRefund.jsp").forward(req, resp);								
			} else {
				DB.sellRefund(req.getParameter("refundNo"));
				resp.sendRedirect(root + "/sellRefund");
			}
			break;
		case "/prodMag":
			getServletContext().getRequestDispatcher("/pages/ProductManage.jsp").forward(req, resp);				
			break;
		case"/prodAdd":
			String adding = req.getParameter("add");
			if(adding == null) {
				req.setAttribute("nextCode", DB.getMaxNum());			
				getServletContext().getRequestDispatcher("/pages/ProductAdd.jsp").forward(req, resp);								
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
			List<Meds_DTO_Products> medList = DB.getAllProduct(" ORDER BY NAME");
			req.setAttribute("meds", medList);
			getServletContext().getRequestDispatcher("/pages/ProductEdit.jsp").forward(req, resp);								
			break;
		case"/prodRemove":
			String removing = req.getParameter("remove");
			if(removing == null) {
				List<Meds_DTO_Products> medStockZero = DB.getAllProduct(" WHERE STORED = 0");
				req.setAttribute("stockZero", medStockZero);
				getServletContext().getRequestDispatcher("/pages/ProductRemove.jsp").forward(req, resp);								
			} else {
				String removeCode = req.getParameter("prodRemove");
				DB.prodRemove(removeCode);
				resp.sendRedirect(root + "/prodRemove");
			}
			break;
		case"/storeMag":
			getServletContext().getRequestDispatcher("/pages/StoreManage.jsp").forward(req, resp);				
			break;
		case"/storeOrder":
			if(div == null) {
				List<Meds_DTO_Products> medStock = DB.getAllProduct(" ORDER BY STORED");
				req.setAttribute("meds", medStock);
				getServletContext().getRequestDispatcher("/pages/StoreOrder.jsp").forward(req, resp);				
			} else {
				String[] medsQuant = req.getParameterValues("medsQuant");
				String[] medsCode = req.getParameterValues("medsCode");
				String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				DB.sellOrder(medsQuant, medsCode, now, div);
				DB.updateStock(medsCode);
				resp.sendRedirect(root + "/storeOrder");				
			}
			break;
		case"/storeRefund":
			List<Meds_DTO_Products> medStoreList = DB.getAllProduct(" ORDER BY NAME");
			req.setAttribute("meds", medStoreList);
			getServletContext().getRequestDispatcher("/pages/StoreRefund.jsp").forward(req, resp);				
			break;
		case"/salesMag":
			getServletContext().getRequestDispatcher("/pages/SaleManage.jsp").forward(req, resp);				
			break;
		case"/salesDate":
			getServletContext().getRequestDispatcher("/pages/StoreRefund.jsp").forward(req, resp);				
			break;
		case"/salesProd":
			getServletContext().getRequestDispatcher("/pages/StoreRefund.jsp").forward(req, resp);				
			break;
		case"/salesMade":
			getServletContext().getRequestDispatcher("/pages/StoreRefund.jsp").forward(req, resp);				
			break;
		}
	}	
}

