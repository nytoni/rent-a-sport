import java.sql.Connection;

public class Persister {

	public static int goCreateNewAccountSQLPersistLayer(String firstName, String lastName, String email, String password) {
		
		String addRequest = "insert into UserNames (FirstName, LastName, Email, Password) values ('" + firstName + "','" + lastName + "','" + email + "','" + password +"');";
		
		Connection con = DatabaseAccess.connect();

		return DatabaseAccess.create(con, addRequest);
		
		
	}
	
	
}
