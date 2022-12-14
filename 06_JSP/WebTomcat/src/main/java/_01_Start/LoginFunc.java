package _01_Start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFunc
 */
@WebServlet("/LoginFunc")
public class LoginFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFunc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter output = response.getWriter();
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
//		이야... 서블릿은 css 제대로 먹이려면 html 태그를 전부 써줘야하네.....
		output.append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "    <style>")
		.append("	div.wrap {margin:0 auto; border:1px solid gray; text-align:center;}\r\n"
				+ "	div span {font-size: 2em; font-weight:bold; display: inline-block;}\r\n </style>"
				+ "</head>"
				+ "<body>")
		.append("<h1>Login Servlet</h1><hr>");
		if(id.equals("person") && pw.equals("1234")) {
			output.append("<div class=\"wrap\"><span>")
			.append("Welcome " + id + " !")
			.append("</span></div>");
		} else {
			output.append("<div class=\"wrap\"><span>")
			.append("Fail to Login")
			.append("</span></div></body>"
					+ "</html>");
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
