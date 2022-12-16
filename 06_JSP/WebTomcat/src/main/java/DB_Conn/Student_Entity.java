package DB_Conn;

// 데이터베이스와 연동할때 Date 타입의 import는 sql 과 연동됨을 생각해서 java.sql 에서 가져와야한다.
import java.sql.Date;

// 데이터베이스의 값을 받기 위한 엔티티클래스 이기 때문에 필드와 getter/setter 만으로 구성됨.
// DO. 데이터만 담을 데이터 오브젝트.
public class Student_Entity {
	private int id;
	private String username;
	private String univ;
	private Date birth;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
