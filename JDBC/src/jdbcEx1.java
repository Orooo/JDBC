import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcEx1 {

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String url = "jdbc:mysql://localhost:3306/dbname";
	String id = "아이디 입력 : ";
	String pw = "패스워드 입력 : ";
	
	public jdbcEx1() {
		try {
			// 드라이버 로딩 (Mysql 또는 Oracle 중에 선택)
			Class.forName("com.mysql.Driver");	//mysql
			// Class.forName("oracle.jdbc.driver.OracleDriver");	//oracle
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			// 커넥션을 가져옴
			con = DriverManager.getConnection(url, id, pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getData() {
		try {
			stmt = con.createStatement();
			// 데이터를 가져옴
			rs = stmt.executeQuery("select user_id, user_name from internal_user" );
			
			while(rs.next()) {
				// 출력
				System.out.println(rs.getString("user_id"));
				System.out.println(rs.getString("user_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			// 자원 반환
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		jdbcEx1 jdbcExample = new jdbcEx1();
		
		jdbcExample.getConnection();
		jdbcExample.getData();
		jdbcExample.closeConnection();
	}
}




