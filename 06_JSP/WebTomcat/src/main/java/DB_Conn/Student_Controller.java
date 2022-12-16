package DB_Conn;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class Student_Controller
 */
@WebServlet("/Student_Controller")
public class Student_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Student_DAO DB;
	private Student_Entity stu;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	DB = new Student_DAO();
    	stu = new Student_Entity();
    }
    	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
//    	이거는 한페이지에서 모든걸 다하고... 리스트는 계속 보여줄거니까 이렇게 해도 되겠다.
//    	지금은 코드가 짧아서 그냥 service 메소드에 모든걸 때려넣었지만 코드가 길어지고 분기점이 많아진다면 다른 메소드로 구성하는게 보기에 깔끔하겠다.
//    	그럴경우 각 메소드는 내부에서 .setAttribute 와 같은 기능을 실행하고 이후에 이동할 페이지의 주소를 리턴한다.
    	request.setAttribute("StuList", DB.getAll());
//    	페이지를 판단할 파라메터 action 이 null 인지를 판단하는 구문은 반드시 필요한듯.
//    	이거 없이 그냥 equal로 바로 가면 null 이라 비교가 안된다고 오류난다.
    	if(action == null) {
    		getServletContext().getRequestDispatcher("/DB_Connected/Student_Info.jsp").forward(request, response);
    	} else {
    		if(action.equals("insert")) {
//	 			생일데이터는 Date 타입인데 이건 형식이 맞아야 변환이 가능해서 일단 regex로 패턴 매치를 시도함.
    			String birth_pattern = "^\\d{4}\\-([1-9]|1[012])\\-([1-9]|[12][0-9]|3[01])$";
    			String birth = request.getParameter("birth");
// 				생일 패턴이 맞을경우. 다른값들은 null이여도 일단은 들어감.
// 				만약 데이터베이스에 not null 같은 제약조건이 있으면 그것도 여기서 판단을 해야겠네
// 				아니....지..... DAO에서 연결해서...넣으려고 할때 오류나면 catch로 넘어가고 db닫고...
// 				그쪽에서 처리해도 되겠구나.
    			if(Pattern.matches(birth_pattern, birth)) {
//    				이거 매번 서비스 실행할때마다 새로운 객체를 생성하지 않나...이것도 init 에 넣는게 효율적이지 않을까?
//    				Student_Entity stu = new Student_Entity();
//    				init에 넣어도 되네......
//    				엔티티객체에 생성자 안만들었으니 값 넣으려면 전부 set 메소드 써야...하나
//    				이거 한꺼번에 할 수 있는 라이브러리가 있대.....
    				
    				try {
//    					BeanUtils.populate(데이터를 담을객체, 파라메터를 가져올객체.getParameterMap());
//    					지정한 객체에 request가 가지고 있는 모든 파라메터를 Map 형식으로 가져와서 넣어준다.
//    					BeanUilts 라는 라이브러리. 오류처리 필요. 데이터양이 많을때는 이게 훨씬 낫겠다.
						BeanUtils.populate(stu, request.getParameterMap());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
    				
//    				stu.setUsername(request.getParameter("username"));
//    				stu.setUniv(request.getParameter("univ"));
//    				java.sql.Date 에는 .valueOf(); 메소드가 있는데 스트링타입의 문자열이나 LocalDate 타입의 변수를 sql Date 로 변환해준다.
//    				문자열을 입력할때에는 포맷이 yyyy-mm-dd 형식을 맞춰야 오류없이 변환이 가능함.
//    				stu.setBirth(Date.valueOf(birth));
//    				stu.setEmail(request.getParameter("email"));
    				DB.insertData(stu);    				
    				request.setAttribute("StuList", DB.getAll());
    			} else {
    				request.setAttribute("err", true);
    				request.setAttribute("StuList", DB.getAll());
    			}    			
    		
    		}
    		getServletContext().getRequestDispatcher("/DB_Connected/Student_Info.jsp").forward(request, response);
    	}
	}
}
