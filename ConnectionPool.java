package jdbc;


import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
	
	List<Connection>availableConnection = new ArrayList<Connection>();
	List<Connection>usedConnection =new ArrayList<Connection>();
	
	private final int MAX_CONNECTION =10;
	String URL;
	String USER;
	String PASSWORD;
	
	public ConnectionPool(String url,String user,String password) throws SQLException{
	
		this.URL=url;
		this.USER=user;
		this.PASSWORD=password;
		
		 for(int count=0;count<MAX_CONNECTION;count++) {
			 availableConnection.add(this.createConnection());
		 }
//		System.out.println("connection created");
	}

	private Connection createConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection(this.URL,this.USER,this.PASSWORD);
	}
	
	public Connection getConnection() {
		if(availableConnection.size()==0) {
			System.out.println("All connection is used");
			return null;
		}
		else
		{
			Connection con = availableConnection.remove(availableConnection.size()-1);
			usedConnection.add(con);
			return con;
		}
		
	}
	
	public boolean releaseConnection(Connection con) {
		if (null != con) {
			usedConnection.remove(con);
			availableConnection.add(con);
			return true;
		}
		return false;
	}
	
	public int getFreeConnectionCount() {
		return availableConnection.size();
	
	

}

}
	
	

