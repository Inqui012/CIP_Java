package _01_Start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlTesting
 */

// 테스트. 서블릿을 미리 여러개 만들어놓으면 서버를 시작한 뒤에는 간단하게 url 만으로도 다른 서블릿의 실행결과를 볼 수 있다.
@WebServlet(description = "TestingUrl", urlPatterns = { "/UrlTesting" })
public class UrlTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrlTesting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String testing = "var Test";
		String input = request.getParameter("test");
//		텍스트형식으로 html 태그를 쓰니까 인라인 스타일도 줄 수 있네. 자바 변수도 물론 쓸 수 있고.
//		어펜드를 새로하면 자동으로 줄바꿈이 일어나는듯????? 아님. 안일어남.
//		아까는 body, html 태그도 넣었는데 딱히 넣지 않아도 자동으로 body 안에 태그들이 생성되네. 어펜드 순서대로.
//		아 타이틀 넣으려면 head 태그도 써야하니까 그런가보다
		out.append("<h1 style=\"color:red\">" + testing + "</h1>")
		.append("<form>")
		.append("<input type=\"text\" name=\"test\">")
		.append("<input type=\"submit\"></form><br/>")
		.append(input)
		.append("<div style=\"width:500px; height:500px; background-color:blue; margin:0 auto;\"></div>");			
		if(input.equals("red")) {
			out.append("<h1 style=\"color:blue\">" + testing + "</h1>")
			.append("<div style=\"width:500px; height:500px; background-color:red; margin:0 auto;\"></div>");						
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
