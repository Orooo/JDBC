import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcEx1 {

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String url = "jdbc:mysql://localhost:3306/dbname";
	String id = "���̵� �Է� : ";
	String pw = "�н����� �Է� : ";
	
	public jdbcEx1() {
		try {
			// ����̹� �ε� (Mysql �Ǵ� Oracle �߿� ����)
			Class.forName("com.mysql.Driver");	//mysql
			// Class.forName("oracle.jdbc.driver.OracleDriver");	//oracle
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			// Ŀ�ؼ��� ������
			con = DriverManager.getConnection(url, id, pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getData() {
		try {
			stmt = con.createStatement();
			// �����͸� ������
			rs = stmt.executeQuery("select user_id, user_name from internal_user" );
			
			while(rs.next()) {
				// ���
				System.out.println(rs.getString("user_id"));
				System.out.println(rs.getString("user_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			// �ڿ� ��ȯ
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




