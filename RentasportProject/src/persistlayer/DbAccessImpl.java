package persistlayer;

import java.sql.*;

public class DbAccessImpl {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName(DbAccessConfiguration.DRIVE_NAME);
			con = DriverManager.getConnection(DbAccessConfiguration.CONNECTION_URL, 
												DbAccessConfiguration.DB_CONNECTION_USERNAME, 
													DbAccessConfiguration.DB_CONNECTION_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//The method to retrieve and manipulate data from the sql table 
	public static ResultSet retrieve (Connection con, String query) {
		ResultSet rset = null;
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
			return rset;
		}
	}
	
	public int create(Connection con, String query)
	{
		int rowCount=5;
		try 
		{
			//Statement stmt = con.createStatement();
			//rowCount = stmt.executeUpdate(query);
			PreparedStatement ps= con.prepareStatement(query);
			//ps.execute();
			ps.executeUpdate();
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return rowCount;
		}
	}
	
	public static int createAccount(Connection con, String query){
		int result = 0;
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e){
			e.printStackTrace();	
		}
		return result;
	}
	public static int changePassword(Connection con, String query){
		int result = 0;
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e){
			e.printStackTrace();	
		}
		return result;
	}

	public int delete(Connection con, String query)
	{
		int rowCount=5;
		try 
		{
			PreparedStatement stmt= con.prepareStatement(query);
			stmt.execute();
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return rowCount;
		}
	}
	
	public void disconnect(Connection con)
	{
		 try {con.close();} 
		 catch (SQLException e){e.printStackTrace();}
	}
	
}

/*
import java.sql.*;

public class DbAccessImpl {
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName(DbAccessConfiguration.DRIVE_NAME);
			con = DriverManager.getConnection(DbAccessConfiguration.CONNECTION_URL, 
												DbAccessConfiguration.DB_CONNECTION_USERNAME, 
													DbAccessConfiguration.DB_CONNECTION_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//The method to retrieve and manipulate data from the sql table 
	public ResultSet retrieve (Connection con, String query) {
		ResultSet rset = null;
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
			return rset;
		}
	}
	
	public int create(Connection con, String query)
	{
		int rowCount=5;
		try 
		{
			//Statement stmt = con.createStatement();
			//rowCount = stmt.executeUpdate(query);
			PreparedStatement ps= con.prepareStatement(query);
			//ps.execute();
			ps.executeUpdate();
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return rowCount;
		}
	}

	public int delete(Connection con, String query)
	{
		int rowCount=5;
		try 
		{
			PreparedStatement stmt= con.prepareStatement(query);
			stmt.execute();
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return rowCount;
		}
	}
	
	public void disconnect(Connection con)
	{
		 try {con.close();} 
		 catch (SQLException e){e.printStackTrace();}
	}
}
*/