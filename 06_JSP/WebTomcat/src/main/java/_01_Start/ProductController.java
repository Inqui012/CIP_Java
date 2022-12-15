package _01_Start;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/PCont")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	DB 대신에 사용할 클래스를 생성한다. 변수만을 생성해두고 실제 객체 생성은 아래의 서블릿 초기화때 집어넣네
//	초기화때 생성하지 않으면 서블릿을 여러번 불러와도 DB 객체가 변하지 않겠...구나?
//	서블릿의 실행순서. init > service > doget / dopost
	Product_Service DB;   
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		DB = new Product_Service();
	}
//    서비스 메소드를 오버라이드 하니까 알아서 get/post 찾아서 하는 기능이 없으니... 직접 do인지 post 인지 판단하는 구문을 넣어줘야하나
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	String code = request.getParameter("code");
    	String view = "";
    	
    	if(action == null) {
    		getServletContext().getRequestDispatcher("/PCont?action=list").forward(request, response);			
    	} else {
    		switch(action) {
    		case "info":
    			view = info(request, response);
    			break;
    		case "list":
    			view = list(request, response);
    			break;
    		}
    		getServletContext().getRequestDispatcher("/" + view).forward(request, response);			    		
    	}    	
	}



	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
