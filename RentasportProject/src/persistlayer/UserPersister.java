import java.sql.Connection;

public class UserPersister {
 
  public static int goCreateNewAccountSQLPersistLayer(String firstName, String lastName, String email, String password){
    
    String addRequest = "insert into UserNames (FirstName, LastName, Email, Password) values ('" + firstName + "','" + lastName + "','" + email + "','" + password + "');";
    
    Connection con = DbAccessImpl.connect();
    return DbAccessImpl.createAccount(con, addRequest);
  
  }
 
 public static int getUserId(String email){
  String idQuery = "select id from UserNames where email = '" + email "';";
  Connection con = DbAccessImpl.connect();
  return DbAccessImpl.retrieve(con, idQuery);
  
 }



}
