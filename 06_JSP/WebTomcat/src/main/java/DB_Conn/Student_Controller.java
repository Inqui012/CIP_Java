package DB_Conn;

import java.io.IOException;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student_Controller
 */
@WebServlet("/Student_Controller")
public class Student_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Student_DAO DB;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	DB = new Student_DAO();
    }
    	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	if(action == null) {
    		getServletContext().getRequestDispatcher("/Student_Controller?action=select").forward(request, response);
    	} else {
    		switch(action) {
    		case "select":
    			request.setAttribute("StuList", DB.getAll());
    			break;
    		case "insert":
    			String birth_pattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    			String birth = request.getParameter("birth");
    			if(Pattern.matches(birth_pattern, birth)) {
    				Student_Entity stu = new Student_Entity();
    				stu.setUsername(request.getParameter("username"));
    				stu.setUniv(request.getParameter("univ"));
    				stu.setBirth(Date.valueOf(birth));
    				stu.setEmail(request.getParameter("email"));
    				DB.insertData(stu);    				
    				request.setAttribute("StuList", DB.getAll());
    			} else {
    				request.setAttribute("err", true);
    				request.setAttribute("StuList", DB.getAll());
    			}    			
    			break;
    		}
    		getServletContext().getRequestDispatcher("/DB_Connected/Student_Info.jsp").forward(request, response);
    	}
	}
}
