package persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPersister {
  static Connection con = DbAccessImpl.connect();
 
  public static int goCreateNewAccountSQLPersistLayer(String name, String email, String password){
    
    String addRequest = "insert into User (Name, Email, Password) values ('" +  name + "','" + email + "','" + password + "');";
    return DbAccessImpl.createAccount(con, addRequest);
  
  }//newAccount
 
 public static ResultSet getUserId(String email){
  String idQuery = "select id from UserNames where email = '" + email +"';";
  return DbAccessImpl.retrieve(con, idQuery);
 }//getUserId
 
 public static ResultSet getCheckout(String userId){
  String idQuery ="select cardNum,shippingAddr from account where customerId ='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
 }//getCheckout

 public static ResultSet getCart(String time, int quantity, String bundleName, int userId){
	 String idQuery = "select"+time+","+bundleName+","+ quantity +"from cart where customerId ='"+userId+"'AND orderNum IS NULL;";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getcart
  
 public static ResultSet getCartInfo(int userId){
	 String idQuery ="select quantity, bundleName, time from cart where customerId ='"+userId+"'AND orderNum IS NULL;";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getCartInfo
 
 public static ResultSet getOrderPageInfo(int userId){
	 String idQuery ="select shippingAddr, billingAddr, cardNum, expirationDate from account where customerId='"+userId+"';";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getOrderPage
 
 public static int addOrderToDatabase(String query){
	 //add order to database
	 DbAccessImpl db = new DbAccessImpl();
	 return db.create(con, query);	 
 }
 
 public static int findOutOrderNum(String query){
	 	ResultSet rs = DbAccessImpl.retrieve(con,query);
	 	try{
	 		return rs.getInt(1);
	 	}catch(SQLException e){
	 		System.out.println("something went wrong");
	 		return -1;
	 	}
	 // return 1;
 }//findOutOrderNum
 
 public static int addOrderNumToCart(String query){
	 DbAccessImpl db = new DbAccessImpl();
	 return db.create(con, query);	
 }//addOrderNumToCart
 
 
 public static void removeBundleFromCart(String bundleName, int userId){
		String removeCart = "DELETE * from cart where bundleName ='"+bundleName+"' AND userId = '"+userId+"';";
		DbAccessImpl db = new DbAccessImpl();
		db.delete(con,removeCart);
	}//removeBundleFromCart

  public static void changePassword(int userId, String confirmPassword){
    String changeRequest = "update user set password = '" + confirmPassword + "', where customerId = '"+userId + "';";
     DbAccessImpl.changePassword(con, changeRequest);
  }  
  
  public static ResultSet checkOldPassword(int userId){
    String oldPasswordQuery = "select password from user where customerId = '" + userId + "';"; 
    return DbAccessImpl.retrieve(con, oldPasswordQuery);
  }
  
  public static ResultSet goGetLoginInfo(String email, String password){
    String getRequest = "select * from user where email = '" + email + "' AND password = '" + password + "';";
    return DbAccessImpl.retrieve(con, getRequest);
    
  }
                                   
}
