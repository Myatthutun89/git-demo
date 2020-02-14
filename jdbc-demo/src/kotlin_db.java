import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class kotlin_db {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=00158955";
		Connection conn = DriverManager.getConnection(url);	
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select s.s_name, c.c_name from registration r "
				+ "join student s on r.s_id = s.s_id "
				+ "join course c on r.c_id = c.c_id where r.c_id = 3");
		
		while(rs.next()) {
			System.out.printf("Name : %s, Course : %s%n", rs.getString("s_name"), rs.getString("c_name"));
		}
		conn.close();
	}

}
