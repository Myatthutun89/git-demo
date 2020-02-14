import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCConnectionTest {

	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=00158955";
		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement();
		stmt.execute("update student set s_name = 'Mr.Kyaw Kyaw' where s_id = 1");
//		stmt.executeUpdate("insert into student(s_name) value('Koe Koe')");
		stmt.executeUpdate("delete from student where s_id > 5");
		ResultSet rs = stmt.executeQuery("select * from student");
		
		while(rs.next()) {
			System.out.printf("ID : %d, Name : %s%n", rs.getInt(1),rs.getString("s_name"));
			
		}
		conn.close();
	}

}
