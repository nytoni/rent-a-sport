package persistlayer;
import java.sql.*;

public interface DbAccessInterface 
{
	public Connection connect();
	
	public ResultSet retrieve (Connection con, String query);

	public int create (Connection con, String query);
	
	public static int createAccount(Connection con, String query){
		return 0;
	}
	
	public static int changePassword(Connection con, String query){
		return 0;
	}
	
	public int delete (Connection con, String query);
	
	public void disconnect(Connection con);
}