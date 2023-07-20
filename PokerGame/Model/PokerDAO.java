package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokerDAO {
	// 전역변수 설정
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	String data = "";
	PokerPlayer dto = null;


	// getCon : DB에 연결권한 확인
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String db_id = "campus_e_0718_4";
			String db_pw = "smhrd4";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// getClose : DB 자원 반납하는 매서드 (기능)
	public void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 로그인
	public String select(PokerPlayer playerdto) {

		getCon();

		String name = "";
		try {
			String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, playerdto.getId());
			psmt.setString(2, playerdto.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				name = rs.getString(3);
				data += name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return data;
	}

	// 회원가입후 insert 하는 메서드
	public int insert(PokerPlayer playerdto) {
		getCon();

		String sql = "insert into members values(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, playerdto.getId());
			psmt.setString(2, playerdto.getPw());
			psmt.setString(3, playerdto.getName());
			psmt.setInt(4, playerdto.getChip());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return cnt;
	}
	
	// 게임 종료후 칩을 받아 데이터베이스에 저장
	public int upload(PokerPlayer playerdto) {
		
		getCon();
		
		try {
			String sql = "UPDATE MEMBERS SET CHIP = ? WHERE ID = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1,playerdto.getChip());
			psmt.setString(2,playerdto.getId());
			

			cnt = psmt.executeUpdate();

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return cnt;
	}

	
	// 랭킹출력 - 박수완

	public ArrayList<PokerPlayer> ranking() {

		getCon();
		ArrayList<PokerPlayer> list = new ArrayList<PokerPlayer>();

		String sql = "SELECT * FROM MEMBERS ORDER BY CHIP DESC";
		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String name = rs.getString(3);
				int chip = rs.getInt(4);

				dto = new PokerPlayer(id, null, name, chip);

				list.add(dto);

			}

		} catch (SQLException e) {
			System.out.println("SQL문 오류");
		} finally {
			getClose();
		}

		return list;
	}
}
