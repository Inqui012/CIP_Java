package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Board_DAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL, "test", "test1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public List<Board_DTO> getBoardList() throws Exception {
		List<Board_DTO> boardList = new ArrayList<>();
		String str = "SELECT BOARD_NO, TITLE, USER_ID, TO_CHAR(REG_DATE, 'YYYY.MM.DD') REG_DATE, VIEWS FROM BOARD";

//		자동으로 리소스를 닫아주는 try-with-resource 구문.
//		왜자꾸 에러가 나나 싶었더니 java7 이상부터 쓸수 있는 구문이고, java 9 에서 또 변경사항이 추가되었음.
//		java 8 버전에서는 try의 괄호안에 넣을 관리할 객체는 반드시 새로 생성하는 객체들로만 구성되어야함.
//		java 9 부터는 이미 생성한 객체의 변수를 받아오는 (conn; pstmt; rs) 가 가능하다.
//		프로젝트의 java build 버전을 바꿔야한다.
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str);
				ResultSet rs = state.executeQuery()) {
			while (rs.next()) {
				Board_DTO board = new Board_DTO();
				board.setBoard_no(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setUser_id(rs.getString(3));
				board.setReg_date(rs.getString(4));
				board.setViews(rs.getInt(5));
				boardList.add(board);

			}
		}
		return boardList;
	}
	public void insertBoard(Board_DTO b) throws Exception {
		String str = "insert into board(board_no, user_id, title, content, reg_date, views) values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str)) {
			state.setString(1, b.getUser_id());
			state.setString(2, b.getTitle());
			state.setString(3, b.getContent());
			state.executeUpdate();
		}
	}

	// 게시판 글 수정
	public void updateBoard(Board_DTO b) throws Exception {
		String str = "update board set title = ?, user_id = ?, content = ? where board_no = ?";
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str)) {
			state.setString(1, b.getTitle());
			state.setString(2, b.getUser_id());
			state.setString(3, b.getContent());
			state.setInt(4, b.getBoard_no());
			// 수정된 글이 없을 경우
			if (state.executeUpdate() != 1) {
				throw new Exception("DB에러");
			}
		}
	}

	// 게시판 글 삭제
	public void deleteBoard(int board_no) throws Exception {
		String str = "delete from board where board_no=?";
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str)) {
			state.setInt(1, board_no);
			// 삭제된 글이 없을 경우
			if (state.executeUpdate() != 1) {
				throw new Exception("DB에러");
			}
		}
	}

	public Board_DTO getView(int board_no) throws Exception {
		Board_DTO board = new Board_DTO();
		String str = "select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content from board where board_no=";
		str += board_no;
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str);
				ResultSet rs = state.executeQuery()) {
			rs.next();
			board.setBoard_no(rs.getInt(1));
			board.setTitle(rs.getString(2));
			board.setUser_id(rs.getString(3));
			board.setReg_date(rs.getString(4));
			board.setViews(rs.getInt(5));
			board.setContent(rs.getString(6));
			state.executeQuery();
		}
		return board;
	}
	
	// 게시판 수정 글 보기
	public Board_DTO getViewForEdit(int board_no) throws Exception {
		Board_DTO board = new Board_DTO();
		String str = "select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content from board where board_no=";
		str += board_no;		
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str);
				ResultSet rs = state.executeQuery()) {
			rs.next();
			board.setBoard_no(rs.getInt(1));
			board.setTitle(rs.getString(2));
			board.setUser_id(rs.getString(3));
			board.setReg_date(rs.getString(4));
			board.setViews(rs.getInt(5));
			board.setContent(rs.getString(6));
			state.executeQuery();
		}
		return board;
	}

	// 조회수 증가
	public void updateViews(int board_no) throws Exception {
		String str = "update board set views = (views + 1) where board_no = ?";
		try (Connection con = connect();
				PreparedStatement state = con.prepareStatement(str)) {
			state.setInt(1, board_no);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
