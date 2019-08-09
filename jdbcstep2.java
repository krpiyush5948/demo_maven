package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcstep2 {
	
	private static final String url="jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user ="postgres";
	private static final String password="Siddharth@5948";
	public static void main(String[] args) {
		
		try{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt=conn.createStatement();
			
			String tableSql = "CREATE TABLE IF NOT EXISTS employees"
					  + "(emp_id SERIAL PRIMARY KEY , name varchar(30),"
					  + "position varchar(30), salary bigint)";
			stmt.execute(tableSql);
			
			String insertSql = "INSERT INTO employees(name, position, salary)"
					  + " VALUES('sam', 'developer', 9000)";
			int noOfInsert=stmt.executeUpdate(insertSql);
			
			System.out.println("Number of inserts "+ noOfInsert);
			
			String selectSql = "SELECT * FROM employees";
			ResultSet resultSet = stmt.executeQuery(selectSql);
			
		}
		catch(SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());	
		}
	}
	}
