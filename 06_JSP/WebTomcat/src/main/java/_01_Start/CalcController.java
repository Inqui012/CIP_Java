package _01_Start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		String operator = request.getParameter("option");		
		try {
			int firstNum = Integer.parseInt(request.getParameter("firstNum"));
			int secondNum = Integer.parseInt(request.getParameter("secondNum"));			
			long result = 0;
			switch (operator) {
			case "+":
				result = firstNum + secondNum;
				break;
			case "-":
				result = firstNum - secondNum;
				break;
			case "*":
				result = firstNum * secondNum;
				break;
			case "/":
				result = firstNum / secondNum;
				break;
			case "%":
				result = firstNum % secondNum;
				break;
			}
//		리퀘스트 스코프에 리퀘스트 데이터를 저장함.
			request.setAttribute("output", result);
//		현재 서블릿에 있는 request, responcse 값을 지정한 경로의 파일로 포워딩해서 보낸다.
			getServletContext().getRequestDispatcher("/Calc_MVC_View.jsp").forward(request, response);
		} catch (Exception e) {
			String err = "There is Error";
			request.setAttribute("output", err);
			getServletContext().getRequestDispatcher("/Calc_MVC_View.jsp").forward(request, response);
			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
