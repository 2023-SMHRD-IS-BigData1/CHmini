package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PokerDAO {
	//전역변수 설정
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			int cnt = 0;
			
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
				
			// 회원가입후 insert 하는 메서드
			public int insert(PokerPlayer playerdto) {
				getCon();
				
			 	String sql = "insert into members values(?,?,?,?)";

				try {
					psmt = conn.prepareStatement(sql);

					psmt.setString(1, playerdto.getId() );
					psmt.setString(2, playerdto.getPw() );
					psmt.setString(3, playerdto.getName() );
					psmt.setInt(4, playerdto.getChip() );
					
					cnt = psmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					getClose();
				}

				return cnt;
			}
}
