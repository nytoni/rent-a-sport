import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPersister {
  Connection con = DbAccessImpl.connect();
 
  public static int goCreateNewAccountSQLPersistLayer(String firstName, String lastName, String email, String password){
    
    String addRequest = "insert into UserNames (FirstName, LastName, Email, Password) values ('" + firstName + "','" + lastName + "','" + email + "','" + password + "');";
    return DbAccessImpl.createAccount(con, addRequest);
  
  }//newAccount
 
 public static int getUserId(String email){
  String idQuery = "select id from UserNames where email = '" + email +"';";
  return DbAccessImpl.retrieve(con, idQuery);
  
 }//getUserId
 
 public static ResultSet getCheckout(userId){
  String idQuery ="select cardNum from account where customerId ='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
  
 }//getCheckout

 public static resultSet getReviewOrder(userId){
  String idQuery = "select * from orders where customerId ='"+userId+
   "' UNION select bundleName, quantity from cart where customerId = '"+userId+"';";
   return DbAccessImpl.retrieve(con,idQuery);
  
}//getReviewOrder

 public statuc resultSet getMyCart(userId){
  String idQuery = "select bundleName, quantity, price from cart where customerId='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
 }//getMyCart

}
