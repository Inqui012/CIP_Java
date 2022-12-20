package DB_Conn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CIP_Practice_Conn
 */
@WebServlet("/")
public class CIP_Practice_Conn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CIP_Practice_DAO DB;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		DB = new CIP_Practice_DAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getServletPath();
		switch(target) {
		case "/DB_Connected/insert":
			int nextNo = 0;
			try {
				nextNo = DB.getMaxNo() + 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.setAttribute("custno", nextNo);
			getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Add.jsp").forward(req, resp);
			break;
		case "/DB_Connected/update":
			String custno = req.getParameter("custno");
			if (custno == null) {
				List<CIP_Practice_DTO_mem> memberList = new ArrayList<>();
				try {
					memberList = DB.getMemList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("memList", memberList);				
				getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_List.jsp").forward(req, resp);
			} else {
				CIP_Practice_DTO_mem mem = new CIP_Practice_DTO_mem();
				try {
					mem = DB.getMemData(Integer.parseInt(custno));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("mem", mem);
				getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Update.jsp").forward(req, resp);
			}
			break;
		case "/DB_Connected/sell":
			getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Sell.jsp").forward(req, resp);
			break;
		case "/DB_Connected/home":
			getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice.jsp").forward(req, resp);
			break;
		}
	}	
}
