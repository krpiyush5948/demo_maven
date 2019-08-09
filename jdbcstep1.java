package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcstep1 {
	
	private static final String url="jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user ="postgres";
	private static final String password="Siddharth@5948";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		if(conn !=null) {
			System.out.println("connected to the database");
		}else {
			System.out.println("connection failed");
		}
	}
	
	private static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
