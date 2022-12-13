package _01_Start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 서블릿을 생성하면 상속과 구현해야 하는 메소드들이 자동으로 구성된 모양으로 생성됨.

/**
 * Servlet implementation class PrintHello
 */
// 해당 클래스가 서블릿이라고 인식할 수 있게 생성된 어노테이션.
// 해당 서블릿의 설명과 어떤 경로일때 해당 서블릿을 실행할건지를 설정한 정보인가?

// 이 파일을 서버에서 돌리면 경로상에 지정된 경로가 나타나고 response 에 설정한 내용이 화면상에 보인다.
@WebServlet(description = "ServletStart", urlPatterns = { "/PrintHello" })
public class PrintHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintHello() {
        super();
        // TODO Auto-generated constructor stub
    }

//    클라이언트의 요청이 get / post 방식인지에 따라서 실행되는 메소드가 다르다. 구분은 어떻게 하는걸까..
//    서블릿은 이렇게 생성하지만, 실행은 컨테이너의 service() 메소드에서 하니까... 거기서 구분하는걸까
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		서버에서 클라이언트에 돌려주는 response 객체에 보낼 데이터를 담아서 보내는 느낌. 근데 리턴타입은 또 아니네
//		response 는 되돌려주는 데이터의 속성이라던가...그런거의 설정인가???
//		아웃풋 스트림인 out 변수에 데이터를 추가하면서 보낼 데이터의 모양을 구성하는듯.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hello World !!</h2><hr>")
		.append("현재 날짜와 시간은: "+ java.time.LocalDateTime.now())
//		새로고침을 누를때마다 값이 바뀌는걸 보니 이 메소드는 새로고침 할 때 다시 생성되는구나.
//		클래스 자체를 새로 만드는걸까?
// 		웹상에서 한 번 연 다음에 앞으로가기 뒤로가기 하면 랜덤숫자 안바뀌네. 새로고침이 아니면 이미 생성한 서블릿을 그대로 유지하나.
		.append("<hr><h2>" + (Math.random() * 100) + "</h2>")
		.append("</body></html>");
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
