package Meds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Meds_DAO {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public Connection getConn() {
		con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "meds", "meds1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void disCon() {
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Meds_DTO_Products> getAllProduct() {
		List<Meds_DTO_Products> meds = new ArrayList<>();
		String str = "SELECT NAME, OUTPRICE FROM MED_PRODUCT";
		try {
			con = getConn();
			st = con.prepareStatement(str);
			rs = st.executeQuery();

			while(rs.next()) {
				Meds_DTO_Products med = new Meds_DTO_Products();
				med.setName(rs.getString(1));
				med.setOutprice(rs.getInt(2));
				meds.add(med);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return meds;
	}
	
	public void sell(HttpServletRequest req) {
		String[] medsName = req.getParameterValues("medsName");
		String[] medsQuant = req.getParameterValues("medsQuant");
		String getCode;
		String str;
		try {
			con = getConn();
			if(medsName.length > 1) {
				for(int i = 0; i < medsName.length; i++) {
					getCode = "SELECT CODE FROM MED_PRODUCT WHERE NAME = '" + medsName[i] + "'";
					st = con.prepareStatement(getCode);
					rs = st.executeQuery();
					str = "INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, ?, ?, TO_DATE('?', 'YYYYMMDD'))";
					st = con.prepareStatement(str);
					st.setInt(1, rs.getInt(1));
					st.setInt(2, Integer.parseInt(medsQuant[i]));
				}
			} else {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Meds_DTO_SaleList newSell = new Meds_DTO_SaleList();
		
	}
}
