package DB_Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CIP_Practice_DAO {
	Connection con;
	PreparedStatement state;
	ResultSet result;
	
	public static Connection getconnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test1234");
		return con;
	}
	
	public void closeConn() {
		try {
			state.close();
			result.close();
			con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public int getMaxNo() {
		int no = 0;
		try {
			con = getconnection();
			state = con.prepareStatement("SELECT MAX(CUSTNO) FROM CIP_MEM");
			result = state.executeQuery();
			while(result.next()) {
				no = result.getInt("MAX(CUSTNO)");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return no;
	}

	public CIP_Practice_DTO_mem getMemData(int custno) {
		CIP_Practice_DTO_mem mem = new CIP_Practice_DTO_mem();
		try {
			con = getconnection();
			state = con.prepareStatement("SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, GRADE, CITY FROM CIP_MEM WHERE CUSTNO = " + custno);
			result = state.executeQuery();
			while(result.next()) {
				mem.setCustno(result.getInt("CUSTNO"));
				mem.setCustname(result.getString("CUSTNAME"));
				mem.setPhone(result.getString("PHONE"));
				mem.setAddress(result.getString("ADDRESS"));
				mem.setJoindate(result.getString("JOINDATE"));
				mem.setGrade(result.getString("GRADE"));
				mem.setCity(result.getString("CITY"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return mem;
	}
	
	public List<CIP_Practice_DTO_mem> getMemList() {
		List<CIP_Practice_DTO_mem> memList = new ArrayList<>();
		try {
			con = getconnection();
//		쿼리문으로 할 수 있는것들은 최대한 쿼리문으로 처리한다.
			state = con.prepareStatement("SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, DECODE(GRADE, 'A', 'VIP', 'B', '일반', '직원') GRADE, CITY FROM CIP_MEM ORDER BY CUSTNO");
			result = state.executeQuery();
			while(result.next()) {
				CIP_Practice_DTO_mem mem = new CIP_Practice_DTO_mem();
				mem.setCustno(result.getInt("CUSTNO"));
				mem.setCustname(result.getString("CUSTNAME"));
				mem.setPhone(result.getString("PHONE"));
				mem.setAddress(result.getString("ADDRESS"));
				mem.setJoindate(result.getString("JOINDATE"));
				mem.setGrade(result.getString("GRADE"));
				mem.setCity(result.getString("CITY"));
				memList.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return memList;
	}

	public void insertMem (CIP_Practice_DTO_mem insertMem) {
		try {
			con = getconnection();
			String stateStr = "INSERT INTO CIP_MEM VALUES (?, ?, ?, ?, ?, ?, ?)";
			state = con.prepareStatement(stateStr);
			state.setInt(1, insertMem.getCustno());
			state.setString(2, insertMem.getCustname());
			state.setString(3, insertMem.getPhone());
			state.setString(4, insertMem.getAddress());
			state.setString(5, insertMem.getJoindate());
			state.setString(6, insertMem.getGrade());
			state.setString(7, insertMem.getCity());
			state.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
	}
	
//	서블릿에서 아예 새로운 객체랑 선택한 파라메터를 가져옴. 
	public void updateMem (HttpServletRequest req) {
		try {
			con = getconnection();
			String stateStr = "UPDATE CIP_MEM SET ";
			stateStr += " CUSTNO = " + Integer.parseInt(req.getParameter("custno"));
			stateStr += " ,CUSTNAME = '" + req.getParameter("custname") + "'";
			stateStr += " ,PHONE = '" + req.getParameter("phone") + "'";
			stateStr += " ,ADDRESS = '" + req.getParameter("address") + "'";
			stateStr += " ,JOINDATE = TO_DATE('" + req.getParameter("joindate") + "', 'YYYY-MM-DD')";
			stateStr += " ,GRADE = '" + req.getParameter("grade") + "'";
			stateStr += " ,CITY = '" + req.getParameter("city") + "'";
			stateStr += " WHERE CUSTNO = " + req.getParameter("modifyno");
			state = con.prepareStatement(stateStr);
			state.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
	}
	
	public List<CIP_Practice_DTO_mon> getSellList() {
		List<CIP_Practice_DTO_mon> sellList = new ArrayList<>();
		try {
			con = getconnection();
			String stateStr = "SELECT MEM.CUSTNO, MEM.CUSTNAME, DECODE(MEM.GRADE, 'A', 'VIP', 'B', '일반', '직원') GRADE, SUM(MON.PRICE) FROM CIP_MEM MEM, CIP_MON MON";
			stateStr += " WHERE MEM.CUSTNO = MON.CUSTNO";
			stateStr += " GROUP BY MEM.CUSTNO, MEM.CUSTNAME, MEM.GRADE";
			stateStr += " ORDER BY SUM(MON.PRICE) DESC";
			state = con.prepareStatement(stateStr);
			result = state.executeQuery();
			while(result.next()) {
				CIP_Practice_DTO_mon sell = new CIP_Practice_DTO_mon();
				sell.setCustno(result.getInt("CUSTNO"));
				sell.setCustname(result.getString("CUSTNAME"));
				sell.setGrade(result.getString("GRADE"));
				sell.setTotalPrice(result.getInt("SUM(MON.PRICE)"));
				sellList.add(sell);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return sellList;
	}
	
}
