package ro.sda.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class JdbcConnector {
	private static Connection conn;
	
	public static Connection openConnection(){
		String url = "jdbc:mysql://localhost:3306/SdaScheduler?serverTimezone=UTC";    
		String user = "root";
		String pass = "pr0j3ct0";
		try {
			if(conn==null) {
				conn = DriverManager.getConnection(url, user, pass);
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException ex) {  
			return null;
		}
	}
	
		
	


	
}
