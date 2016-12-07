package persistlayer;

import java.sql.*;
public class UserPersister {
  static Connection con = DbAccessImpl.connect();
 
  public static int goCreateNewAccountSQLPersistLayer(String name, String email, String password){
    
    String addRequest = "insert into User (Name, email, password) values ('" +  name + "','" + email + "','" + password + "');";
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

  
  public static ResultSet goGetLoginInfo(String email, String password){
    String getRequest = "select * from user where email = '" + email + "' AND password = '" + password + "';";
    return DbAccessImpl.retrieve(con, getRequest);
    
  }

  public static void changeCreditCardInfo(int customerId,String name, String billingAddress, String shippingAddress,String cardNumber, String expireDate, String securityCode){
	  String changeRequest= "update account set creditName = '" + name+"',shippingAddr = '" + shippingAddress+"', billingAddr = '" + billingAddress+"' , cardNum = '" + cardNumber+"',expirationDate = '" + expireDate+"',securityCode = '" + securityCode+"' where customerId  = '" + customerId+"'";
	  int whatever = DbAccessImpl.changePassword(con, changeRequest);
  }
  /*
  public static ResultSet getCartInfo(int userId){
	  String query = "select * from orders where customerId = '" + userId + "';";
	  return DbAccessImpl.retrieve(con, query);
  }
	*/
	  
  public static void removeOrder(int orderId){
	  String query ="delete from orders where orderNum ='"+orderId+"';";
	  int whatever = DbAccessImpl.changePassword(con, query);
  }
 
  public static ResultSet checkItems(int userId){
	  String query = "select * from orders where customerId ='"+userId+"';";
	  return DbAccessImpl.retrieve(con, query);
  }
	
  public static ResultSet getMaintainUserInfo(int userId) {
	String query = "select * from user where customerId = '" + userId + "';";
	return DbAccessImpl.retrieve(con, query);
  }
  
  
}
