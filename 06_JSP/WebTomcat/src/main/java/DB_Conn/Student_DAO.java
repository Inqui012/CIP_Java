package DB_Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_DAO {
// sql 과 자바를 연결하기 위한 객체.
	Connection conn = null;
// sql 쿼리문을 실행하기 위한 객체.
	PreparedStatement statement;
	
//	연결하고싶은 데이터베이스의 계정과 데이터베이스 주소.
//	DIVER의 이름은 데이터베이스 마다 다르다. 아래는 오라클용. 마리아DB라던가 다른 데이터베이스는 다른 이름임.
//	JDBC = Java Database Connectivity. 자바와 DB를 연결해주는 API. DB가 오라클이라서 ojbcd6.jar 사용함.
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
//	접속할 데이터베이스의 주소과 포트번호. 오라클일경우 아래 형식임. 각 DB에 맞게 바꿔줘야함.
//	jdbc:oracle:thin:@데이터베이스 호스트이름 : 접속포트번호 : SID
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
//	DB와의 연결을 시작하는 메소드.
	public void connect() {
		try {
//			해당 드라이버를 구현하는 클래스를 가져옴. 에러처리필요.
			Class.forName(JDBC_DRIVER);
//			연결을 위한 객체에 DriverManager.getConnection(데이터베이스 주소, "접속아이디", "비밀번호") 를 지정한다.
//			마찬가지로 에러처리가 필요하게 됨. 여기서 DB를 연결함.
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	DB와의 연결을 종료하는 메소드.
	public void terminate() {
		try {
//			여기서 사용하는 두 객체는 리소스이고, 리소스는 반드시 사용후 닫아줘야한다.
//			하지 않으면 메모리에 부담이 간다. DB에 계속 연결되어 있는 상태...가 되는 느낌.
//			.close() 명령으로 간단하게 닫을 수 있는것 같네. 에러처리 필요.
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	데이터베이스에서 모든 학생 데이터를 가져오는 메소드.
	public List<Student_Entity> getAll(){
//		데이터베이스를 열어서 참조해야하니까 열고 닫는메소드를 반드시 실행해야한다.
		connect();
//		데이터베이스에서 가져온 각 데이터를 가져올 리스트. 
//		데이터타입은 각 튜플을 저장하기위해 생성한 엔티티클래스가 된다.
		List<Student_Entity> dataList = new ArrayList<>();
		try {
//			쿼리문을 실행하기 위한 객체 statement에 연결된 DB정보가 있는 conn을 붙여서.
//			실행시킬 쿼리문을 직접 prepareStatement메소드의 매개변수로 입력한다.
			statement = conn.prepareStatement("SELECT * FROM STUDENT");
//			설정한 쿼리문을 실행하는 메소드. SELECT문 사용할때? 다른 구문은 다른 메소드를 사용하나.
//			ResultSet 쿼리문을 실행해서 나오는 데이터를 받아오는 객체. 
			ResultSet data = statement.executeQuery();
			
//			.next() 다음 데이터가 있을경우 true를 반환하는 메소드. 자동으로 리스트를 순회한다.
//			아래 while 문으로 모든 데이터를 순회함.
			while(data.next()) {
//				미리생성한 엔티티객체의 setter를 사용하여 데이터를 저장한다.
				Student_Entity stu = new Student_Entity();
				stu.setId(data.getInt("ID"));
				stu.setUsername(data.getString("USERNAME"));
				stu.setUniv(data.getString("UNIV"));
				stu.setBirth(data.getDate("BIRTH"));
				stu.setEmail(data.getString("EMAIL"));
				dataList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			try 문을 실행하고나서는 무조건으로 연결을 닫아야 하기 때문에 종료메소드는 finally 문에 넣는다.
//			만약 try 문에서 에러가 났을때 catch를 통과하여 에러를 보내고, 그 이후에 반드시 연결을 닫기위함.
//			finally 에 없고 밖에 있을경우 오류가 났다면 catch문으로 진행하고 그 이후의 코드가 실행이 안되기 때문에?
			terminate();			
		}
		return dataList;		
	}
	
//	데이터베이스에 학생정보를 추가하는 메소드.
	public void insertData(Student_Entity stu) {
		connect();
//		INSERT 를 작성할때는 미리 스트링 형식으로 구문을 작성하고, 정확하지 않은 데이터부분은 ? 로 표기한다.
//		미리 String 변수로 구문을 작성하는 이유는 ? 에 들어갈 데이터를 따로 넣기 위함임.
		String insVal = "INSERT INTO STUDENT VALUES (ID_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			statement = conn.prepareStatement(insVal);
//			.setString, .setDate 등으로 물음표의 위치를 왼쪽부터 1로 시작해서 위치에 해당하는 값을 각각 설정해준다.
//			메소드는 각 데이터베이스의 데이터타입마다 존재하는듯. 알아서 데이터타입을 변환해준다.
			statement.setString(1, stu.getUsername());
			statement.setString(2, stu.getUniv());
			statement.setDate(3, stu.getBirth());
			statement.setString(4, stu.getEmail());
//			받아올 데이터가 없는 DML구문은 .executeUpdate로 실행한다.
//			DML = insert, delete, update
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			terminate();
		}
	}
}
