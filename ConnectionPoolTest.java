package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
	public static void main(String[] args) throws SQLException {
		ConnectionPool pool =new ConnectionPool ("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","Siddharth@5948");
	
		Connection con1 = pool.getConnection();
		Connection con2 = pool.getConnection();
		System.out.println(pool.getFreeConnectionCount());
		Connection con3 = pool.getConnection();
		Connection con4 = pool.getConnection();
		Connection con5 = pool.getConnection();
		Connection con6 = pool.getConnection();
		System.out.println(pool.getFreeConnectionCount());
		pool.releaseConnection(con1);
		pool.releaseConnection(con2);
		pool.releaseConnection(con4);
		System.out.println(pool.getFreeConnectionCount());
	
	
	
	}
	
}
