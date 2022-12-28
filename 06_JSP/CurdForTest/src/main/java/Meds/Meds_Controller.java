package Meds;

import java.io.IOException;
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
		switch(url) {
		case "/sellMag":
			getServletContext().getRequestDispatcher("/pages/SellManage.jsp").forward(req, resp);				
			break;
		case "/sellMeds":
			String selling = req.getParameter("sell");
			if(selling == null) {
				List<Meds_DTO_Products> meds = DB.getAllProduct();
				req.setAttribute("meds", meds);
				getServletContext().getRequestDispatcher("/pages/SellMeds.jsp").forward(req, resp);								
			} else {
				DB.sell(req);
			}
			break;
		case "/sellRefund":
			getServletContext().getRequestDispatcher("/pages/SellRefund.jsp").forward(req, resp);				
			break;
		case "/prodMag":
			getServletContext().getRequestDispatcher("/pages/ProductManage.jsp").forward(req, resp);				
			break;
		case"/prodAdd":
			getServletContext().getRequestDispatcher("/pages/ProductAdd.jsp").forward(req, resp);				
			break;
		case"/prodRemove":
			getServletContext().getRequestDispatcher("/pages/ProductRemove.jsp").forward(req, resp);				
			break;
		case"/storeMag":
			getServletContext().getRequestDispatcher("/pages/StoreManage.jsp").forward(req, resp);				
			break;
		case"/storeOrder":
			getServletContext().getRequestDispatcher("/pages/StoreOrder.jsp").forward(req, resp);				
			break;
		case"/storeRefund":
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

