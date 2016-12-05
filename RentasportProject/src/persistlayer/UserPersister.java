import java.sql.Connection;
import java.sql.ResultSet;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class UserPersister {
  static Connection con = DbAccessImpl.connect();
 
  public static int goCreateNewAccountSQLPersistLayer(String name, String email, String password){
    
    String addRequest = "insert into UserNames (Name, Email, Password) values ('" +  name + "','" + email + "','" + password + "');";
    return DbAccessImpl.createAccount(con, addRequest);
  
  }//newAccount
 
 public static ResultSet getUserId(String email){
  String idQuery = "select id from UserNames where email = '" + email +"';";
  return DbAccessImpl.retrieve(con, idQuery);
  
 }//getUserId
 
 public static ResultSet getCheckout(int userId){
  String idQuery ="select cardNum from account where customerId ='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
  
 }//getCheckout

 public static ResultSet getReviewOrder(int userId){
  String idQuery = "select * from orders where customerId ='"+userId+
   "' UNION select bundleName, quantity from cart where customerId = '"+userId+"';";
   return DbAccessImpl.retrieve(con,idQuery);
  
}//getReviewOrder

 public static ResultSet getMyCart(int userId){
  String idQuery = "select bundleName, quantity, price from cart where customerId='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
 }//getMyCart

  public static void changePassword(int userId, String confirmPassword){
    String changeRequest = "update user set password = '" + confirmPassword + "' where customerId = '"+userId + "';";
    System.out.println(changeRequest);
    int whatever = DbAccessImpl.changePassword(con, changeRequest);
  }  
  
  public static ResultSet checkOldPassword(int userId){
    String oldPasswordQuery = "select password from user where customerId = '" + userId + "';"; 
    return DbAccessImpl.retrieve(con, oldPasswordQuery);
  }
  
  public static ResultSet goGetLoginInfo(String email, String password){
    String getRequest = "select * from user where email = '" + email + "' AND password = '" + password + "';";
    return DbAccessImpl.retrieve(con, getRequest);
    
  }

  public static void changeCreditCardInfo(int customerId,String name, String billingAddress, String shippingAddress,String cardNumber, String expireDate, String securityCode){
	  String changeRequest= "update account set creditName = '" + name+"',shippingAddr = '" + shippingAddress+"', billingAddr = '" + billingAddress+"' , cardNum = '" + cardNumber+"',expirationDate = '" + expireDate+"',securityCode = '" + securityCode+"' where customerId  = '" + customerId+"'";
	  int whatever = DbAccessImpl.changePassword(con, changeRequest);
  }
  
  
  public static ResultSet getCartInfo(int userId){
	  String query = "select * from orders where customerId = '" + userId + "';";
	  return DbAccessImpl.retrieve(con, query);
  }
  
}
