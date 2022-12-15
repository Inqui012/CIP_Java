package _01_Start;

import java.io.IOException;
import java.util.List;

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
//	아님. 서블릿을 여러번 불러와도 같은 서블릿일 경우 init은 한번만 실행하기 때문에 이렇게 하면 하나의 서블릿에서 하나의 객체를 공유함.
//	서블릿의 실행순서. init > service > doget / dopost
	Product_Service DB;   
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		DB = new Product_Service();
	}
//    서비스 메소드를 오버라이드 하니까 알아서 get/post 찾아서 하는 기능이 없으니... 직접 do인지 post 인지 판단하는 구문을 넣어줘야하나
//    아니네, 포워드를 어떻게 할건지 직접 메소드를 만들어서 실행을 하는구나.
//    컨트롤러에서 바로 서버를 실행시켜야 정상작동함.
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	String view = "";
//    	서버를 처음 시작할때, 파라미터가 없기 때문에 자동으로 /PCont?action=list 로 디스패치를 하게 된다.
//    	디스패치를 하면서 다시 서블릿을 불러오고 이번에는 파라미터값을 가지고 있기 때문에 다른 페이지로 넘어가는 형식.
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
//    		실행되는 파라미터에 따라서 다른 페이지로 넘어간다.
//    		스위치문 메소드에서 실행된 setAttribute의 값을 가진채로 반환된 view 페이지로 넘어가게 된다.
    		getServletContext().getRequestDispatcher("/" + view).forward(request, response);			    		
    	}    	
	}
    private String info(HttpServletRequest request, HttpServletResponse response) {
    	Product prod = DB.selectOne(request.getParameter("code"));
    	request.setAttribute("product", prod);
    	return "Product_MVC_View.jsp";
    }
    private String list(HttpServletRequest request, HttpServletResponse response) {
    	List<Product> prod = DB.selectAll();
    	request.setAttribute("products", prod);
    	return "Product_MVC.jsp";
    }

}
