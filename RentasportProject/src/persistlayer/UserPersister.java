import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPersister {
  Connection con = DbAccessImpl.connect();
 
  public static int goCreateNewAccountSQLPersistLayer(String name, String email, String password){
    
    String addRequest = "insert into UserNames (Name, Email, Password) values ('" +  name + "','" + email + "','" + password + "');";
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

  public static void changePassword(int userId, String confirmPassword){
    String changeRequest = "update user set password = '" + confirmPassword + "', where customerId = '"+userId + "';";
    int whatever = DbAccessImpl.changePassword(con, changeRequest);
  }  
  
  public static ResultSet checkOldPassword(int userId){
    String oldPasswordQuery = "select password from user where customerId = '" + userId + "';"; 
    return DbAcessImpl.retrieve(con, oldPasswordQuery);
  }
  
  public static ResultSet goGetLoginInfo(String email, String password){
    String getRequest = "select * from user where email = '" + email + "' AND password = '" + password + "';";
    return DatabaseAccess.retrieve(con, getRequest);
    
  }
                                   
}
