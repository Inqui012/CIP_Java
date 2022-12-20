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
	
	public int getMaxNo() throws Exception {
		con = getconnection();
		state = con.prepareStatement("SELECT MAX(CUSTNO) FROM CIP_MEM");
		result = state.executeQuery();
		int no = 0;
		while(result.next()) {
			no = result.getInt("MAX(CUSTNO)");
		}
		state.close();
		con.close();
		return no;
	}

	public CIP_Practice_DTO_mem getMemData(int custno) throws Exception {
		con = getconnection();
		state = con.prepareStatement("SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, GRADE, CITY FROM CIP_MEM WHERE CUSTNO = " + custno);
		result = state.executeQuery();
		CIP_Practice_DTO_mem mem = new CIP_Practice_DTO_mem();
		while(result.next()) {
			mem.setCustno(result.getInt("CUSTNO"));
			mem.setCustname(result.getString("CUSTNAME"));
			mem.setPhone(result.getString("PHONE"));
			mem.setAddress(result.getString("ADDRESS"));
			mem.setJoindate(result.getDate("JOINDATE"));
			mem.setGrade(result.getString("GRADE"));
			mem.setCity(result.getString("CITY"));
		}
		state.close();
		con.close();
		return mem;
	}
	
	public List<CIP_Practice_DTO_mem> getMemList() throws Exception{
		con = getconnection();
		List<CIP_Practice_DTO_mem> memList = new ArrayList<>();
//		쿼리문으로 할 수 있는것들은 최대한 쿼리문으로 처리한다.
		state = con.prepareStatement("SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, DECODE(GRADE, 'A', 'VIP', 'B', '일반', '직원') GRADE, CITY FROM CIP_MEM ORDER BY CUSTNO");
		result = state.executeQuery();
		while(result.next()) {
			CIP_Practice_DTO_mem mem = new CIP_Practice_DTO_mem();
			mem.setCustno(result.getInt("CUSTNO"));
			mem.setCustname(result.getString("CUSTNAME"));
			mem.setPhone(result.getString("PHONE"));
			mem.setAddress(result.getString("ADDRESS"));
			mem.setJoindate(result.getDate("JOINDATE"));
			mem.setGrade(result.getString("GRADE"));
			mem.setCity(result.getString("CITY"));
			memList.add(mem);
		}
		state.close();
		con.close();
		return memList;
	}

	public void insertMem (CIP_Practice_DTO_mem insertMem) throws Exception {
		con = getconnection();
		String stateStr = "INSERT INTO CIP_MEM VALUES (?, ?, ?, ?, ?, ?, ?)";
		state = con.prepareStatement(stateStr);
		state.setInt(1, getMaxNo() + 1);
		state.setString(2, insertMem.getCustname());
		state.setString(3, insertMem.getPhone());
		state.setString(4, insertMem.getAddress());
		state.setDate(5, insertMem.getJoindate());
		state.setString(6, insertMem.getGrade());
		state.setString(7, insertMem.getCity());
		state.executeQuery(stateStr);
		state.close();
		con.close();
	}
	
//	서블릿에서 아예 새로운 객체랑 선택한 파라메터를 가져옴. 
	public void updateMem (CIP_Practice_DTO_mem updateMem, int selectNo) throws Exception {
		con = getconnection();
		String stateStr = "UPDATE CIP_MEM SET ";
		stateStr += " CUSTNO = " + updateMem.getCustno();
		stateStr += " CUSTNAME = " + updateMem.getCustname();
		stateStr += " PHONE = " + updateMem.getPhone();
		stateStr += " ADDRESS = " + updateMem.getAddress();
		stateStr += " JOINDATE = " + updateMem.getJoindate();
		stateStr += " GRADE = " + updateMem.getGrade();
		stateStr += " CITY = " + updateMem.getCity();
		stateStr += " WHERE CUSTNO = " + selectNo;
		state = con.prepareStatement(stateStr);
		state.executeUpdate();
		state.close();
		con.close();
	}
	
	public List<CIP_Practice_DTO_mon> getSellList() throws Exception{
		con = getconnection();
		List<CIP_Practice_DTO_mon> sellList = new ArrayList<>();
		String stateStr = "SELECT MEM.CUSTNO, MEM.CUSTNAME, MEM.GRADE, SUM(MON.PRICE) FROM CIP_MEM MEM, CIP_MON MON";
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
		return sellList;
	}
	
}
