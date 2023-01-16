package Meds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	private void disCon() {
		try {
			if(rs != null) {
				rs.close();				
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Meds_DTO_Products> getAllProduct(String opt) {
		List<Meds_DTO_Products> meds = new ArrayList<>();
		String str = "SELECT * FROM MED_PRODUCT" + opt;			
		try {
			con = getConn();
			st = con.prepareStatement(str);
			rs = st.executeQuery();

			while (rs.next()) {
				Meds_DTO_Products med = new Meds_DTO_Products();
				med.setCode(rs.getInt(1));
				med.setName(rs.getString(2));
				med.setMadeby(rs.getString(3));;
				med.setInprice(rs.getInt(4));
				med.setOutprice(rs.getInt(5));
				med.setStored(rs.getInt(6));
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
	
	public Meds_DTO_Products getOneProduct(String code) {
		Meds_DTO_Products med = new Meds_DTO_Products();
		String str = "SELECT * FROM MED_PRODUCT WHERE MED_PRODUCT.CODE = " + code;
		try {
			con = getConn();
			st = con.prepareStatement(str);
			rs = st.executeQuery();
			rs.next();
			med.setCode(rs.getInt(1));
			med.setName(rs.getString(2));
			med.setMadeby(rs.getString(3));
			med.setInprice(rs.getInt(4));
			med.setOutprice(rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return med;
	}
	
	public void editProd(Meds_DTO_Products newMed) {
		String str = "UPDATE MED_PRODUCT PR SET PR.NAME = ?, PR.MADEBY = ?, PR.INPRICE = ?, PR.OUTPRICE = ? WHERE PR.CODE = " + newMed.getCode();
		try {
			con = getConn();
			st = con.prepareStatement(str);
			st.setString(1, newMed.getName());
			st.setString(2, newMed.getMadeby());
			st.setInt(3, newMed.getInprice());
			st.setInt(4, newMed.getOutprice());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}
	
	public List<Meds_DTO_SaleList> getAllSell(){
		List<Meds_DTO_SaleList> sellList = new ArrayList<>();
		String str = "SELECT SL.SALENO, PR.NAME, PR.MADEBY, PR.OUTPRICE, SL.SALE_QUANTITY, SALE_DATE,";
		str += " DECODE(SALE_STATUS, 'S', '판매완료', '환불완료'), PRICE.SUM";
		str += " FROM MED_SALE SL, MED_PRODUCT PR, (SELECT SL.SALENO, SUM(PR.OUTPRICE*SL.SALE_QUANTITY) AS SUM FROM MED_SALE SL, MED_PRODUCT PR WHERE PR.CODE = SL.CODE GROUP BY SL.SALENO) PRICE";
		str += " WHERE PR.CODE = SL.CODE AND PRICE.SALENO = SL.SALENO";
		str += " ORDER BY SALENO";
		try {
			con = getConn();
			st = con.prepareStatement(str);
			rs = st.executeQuery();

			while (rs.next()) {
				boolean flag = false;
				for(int i = 0; i < sellList.size(); i++) {
					if(sellList.get(i).getSellNo() == rs.getInt(1)) {
						sellList.get(i).setSellName(rs.getString(2));
						sellList.get(i).setSellMadeby(rs.getString(3));
						sellList.get(i).setSellOut(rs.getInt(4));
						sellList.get(i).setSellQuantity(rs.getInt(5));
						flag = true;
					}
				}
				if(!flag) {
					Meds_DTO_SaleList sell = new Meds_DTO_SaleList();				
					sell.setSellNo(rs.getInt(1));
					sell.setSellName(rs.getString(2));
					sell.setSellMadeby(rs.getString(3));
					sell.setSellOut(rs.getInt(4));
					sell.setSellQuantity(rs.getInt(5));
					sell.setSellDate(rs.getString(6));
					sell.setSellStatus(rs.getString(7));
					sell.setSellTotal(rs.getString(8));
					sellList.add(sell);					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return sellList;
	}

	public void sellOrder (List<String> medsQuant, List<String> medsCode, String now, String div) {
		String str;
		try {
			con = getConn();
				for(int i = 0; i < medsCode.size(); i++) {
					if(div.equals("sell")) {
						if(i == 0) {
							str = "INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'))";												
						} else {
							str = "INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.CURRVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'))";												
						}						
					} else {
						if(i == 0) {
							str = "INSERT INTO MED_STORE (STORENO, CODE, STORE_QUANTITY, STORE_DATE) VALUES (STORE_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'))";												
						} else {
							str = "INSERT INTO MED_STORE (STORENO, CODE, STORE_QUANTITY, STORE_DATE) VALUES (STORE_SEQ.CURRVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'))";												
						}												
					}
					st = con.prepareStatement(str);
					st.setInt(1, Integer.parseInt(medsCode.get(i)));
					st.setInt(2, Integer.parseInt(medsQuant.get(i)));
					st.setString(3, now);
					st.executeUpdate();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}
	
//	다중상품 재고 계산
	public void updateStock(List<String> medsCode) {
		String str;
		try {
			con = getConn();
			for(int i = 0; i < medsCode.size(); i++) {
				int newStock = getSelled(medsCode.get(i)) + getOrdered(medsCode.get(i));
				str = "UPDATE MED_PRODUCT SET STORED = " + newStock ;
				str += " WHERE MED_PRODUCT.CODE = " + medsCode.get(i);
				st = con.prepareStatement(str);
				st.executeUpdate();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}
	
//	단일상품 재고 계산
	public void updateStock(String medsCode) {
		String str;
		try {
			con = getConn();
			int newStock = getSelled(medsCode) + getOrdered(medsCode);
			str = "UPDATE MED_PRODUCT SET STORED = " + newStock ;
			str += " WHERE MED_PRODUCT.CODE = " + medsCode;
			st = con.prepareStatement(str);
			st.executeUpdate();				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}

	public int getSelled (String code) {
		String str;
		int selled = 0;
		try {
			con = getConn();
			str = "SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0)";
			str += " FROM MED_SALE SA";
			str += " WHERE SA.CODE = " + code;
			st = con.prepareStatement(str);
			rs = st.executeQuery();
			rs.next();
			selled = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selled;
	}
	
	public int getOrdered (String code) {
		String str;
		int ordered = 0;
		try {
			con = getConn();
			str = "SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0)";
			str += " FROM MED_STORE ST";
			str += " WHERE ST.CODE = " + code;
			st = con.prepareStatement(str);
			rs = st.executeQuery();
			rs.next();
			ordered = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordered;		
	}
	
	public List<String> getRefundProd (String saleNo) {
		String str = "SELECT CODE FROM MED_SALE WHERE SALENO = " + saleNo;
		List<String> refundList = new ArrayList<>();
		try {
			con = getConn();
			st = con.prepareStatement(str);
			rs = st.executeQuery();
			while (rs.next()) {
				refundList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return refundList;
	}
	
	public void prodAdd(Meds_DTO_Products newMeds) {
		String str = "INSERT INTO MED_PRODUCT VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			con = getConn();
			st = con.prepareStatement(str);
			st.setString(1, newMeds.getName());
			st.setString(2, newMeds.getMadeby());
			st.setInt(3, newMeds.getInprice());
			st.setInt(4, newMeds.getOutprice());
			st.setInt(5, newMeds.getStored());
			st.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}
	
	public void sellRefund(String saleno) {
		String str = "UPDATE MED_SALE SET SALE_STATUS = 'R' WHERE SALENO = " + saleno;
		try {
			con = getConn();
			st = con.prepareStatement(str);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
	}
	
	public void prodRemove(String codeNo) {
		String str = "DELETE FROM MED_PRODUCT WHERE CODE = " + codeNo;
		try {
			con = getConn();
			st = con.prepareStatement(str);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}		
	}
	
	public void storeRefund (Integer medsCode, Integer medsQuant, String now) {
		String str = "INSERT INTO MED_STORE VALUES (STORE_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'), 'O')";
		try {
			con = getConn();
			st = con.prepareStatement(str);
			st.setInt(1, medsCode);
			st.setInt(2, medsQuant);
			st.setString(3, now);
			st.executeUpdate();
			System.out.println("test");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}	
	}
	
	public int getMaxNum() {
		int nextCode = 0;
		try {
			con = getConn();
			st = con.prepareStatement("SELECT MAX(CODE) FROM MED_PRODUCT");
			rs = st.executeQuery();
			rs.next();
			nextCode = rs.getInt(1) + 1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return nextCode;
	}
}
