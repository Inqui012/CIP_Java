package _01_Start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcFunc
 */
@WebServlet("/CalcFunc")
public class CalcFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcFunc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter output = response.getWriter();
		String operator = request.getParameter("option");		
		try {
			int firstNum = Integer.parseInt(request.getParameter("firstNum"));
			int secondNum = Integer.parseInt(request.getParameter("secondNum"));			
			long result;
			switch (operator) {
			case "+":
				result = firstNum + secondNum;
				output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
				.append(String.valueOf(result) + "</h1>");
				break;
			case "-":
				result = firstNum - secondNum;
				output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
				.append(String.valueOf(result) + "</h1>");
				break;
			case "*":
				result = firstNum * secondNum;
				output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
				.append(String.valueOf(result) + "</h1>");
				break;
			case "/":
				result = firstNum / secondNum;
				output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
				.append(String.valueOf(result) + "</h1>");
				break;
			case "%":
				result = firstNum % secondNum;
				output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
				.append(String.valueOf(result) + "</h1>");
				break;
			}
			output.append("<div style=\"width:120px;height: 50px;background-color:blue;text-align: center;line-height: 50px;\">")
			.append("<a href=\"/WebTomcat/Calc_Servlet.html\" style=\"color: white; text-decoration: none;\">Do next</a></div>");
		} catch (Exception e) {
			output.append("<h1 style=\"color:red\">!! Wrong Input !!</h1>")
			.append("<div style=\"width:120px;height: 50px;background-color:red;text-align: center;line-height: 50px;\">")
			.append("<a href=\"/WebTomcat/Calc_Servlet.html\" style=\"color: white; text-decoration: none;\">Go back</a></div>");
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
