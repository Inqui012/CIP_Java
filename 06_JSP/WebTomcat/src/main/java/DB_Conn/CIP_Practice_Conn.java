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
// 서블릿 경로를 아래처럼 지정해주면 따로 서블릿을 생성하지 않는 이상 모든 요청이 해당 서블릿으로 옴.
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
//		리퀘스트 객체의 캐릿터셋을 여기서도 설정해주지 않으면 한글 깨짐....
		req.setCharacterEncoding("UTF-8");
//		리퀘스트를 받은 주소를 가져온다. 루트 / 폴더 / 최종경로 형셕에서 루트 빼고.
//		그래서 아래 target의 경우는 기본 폴더 /DB_Connectes/ 뒤에 href로 연결된 주소가 찍힘.
		String target = req.getServletPath();
		switch(target) {
		case "/DB_Connected/insert":
			String actv = req.getParameter("actv");
			int nextNo = 0;
			try {
				nextNo = DB.getMaxNo() + 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(actv == null) {
//				등록 페이지에 들어왔지만 form태그의 submit이 실행되지 않은상태.
//				action 에 따로 파라미터를 만들어줘서 일단 그걸로 판단...
				req.setAttribute("custno", nextNo);
				getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Add.jsp").forward(req, resp);				
			} else {
				CIP_Practice_DTO_mem newMem = new CIP_Practice_DTO_mem();
				newMem.setCustno(nextNo);
				newMem.setCustname(req.getParameter("custname"));
				newMem.setPhone(req.getParameter("phone"));
				newMem.setAddress(req.getParameter("address"));
				newMem.setJoindate(req.getParameter("joindate"));
				newMem.setGrade(req.getParameter("grade"));
				newMem.setCity(req.getParameter("city"));
				try {
					DB.insertMem(newMem);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resp.sendRedirect("/WebTomcat/DB_Connected/update");						
			}
			break;
		case "/DB_Connected/update":
			String modifyno = req.getParameter("modifyno");
			String modify = req.getParameter("modify");
			
			if (modifyno == null) {
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
					mem = DB.getMemData(Integer.parseInt(modifyno));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(modify != null && modify.equals("true")) {
					if(modifyCheck(mem, req)) {
						resp.sendRedirect("/WebTomcat/DB_Connected/update");						
					} else {
						try {
							DB.updateMem(req);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						resp.sendRedirect("/WebTomcat/DB_Connected/update");						
					}
				} else {
					req.setAttribute("mem", mem);
					getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Update.jsp").forward(req, resp);					
				}					
			}
			break;
		case "/DB_Connected/sell":
			List<CIP_Practice_DTO_mon> sellList = new ArrayList<>();
			try {
				sellList = DB.getSellList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("sellList", sellList);
			getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice_Sell.jsp").forward(req, resp);
			break;
		case "/DB_Connected/home":
			getServletContext().getRequestDispatcher("/DB_Connected/CIP_Practice.jsp").forward(req, resp);
			break;
		}
	}
	
	public boolean modifyCheck(CIP_Practice_DTO_mem mem, HttpServletRequest req) {
		if(mem.getCustno() != Integer.parseInt(req.getParameter("custno"))) return false;
		if(!mem.getCustname().equals(req.getParameter("custname"))) return false;
		if(!mem.getPhone().equals(req.getParameter("phone"))) return false;
		if(!mem.getAddress().equals(req.getParameter("address"))) return false;
		if(!mem.getJoindate().equals(req.getParameter("joindate"))) return false;
		if(!mem.getGrade().equals(req.getParameter("grade"))) return false;
		if(!mem.getCity().equals(req.getParameter("city"))) return false;
		return true;
	}
}
