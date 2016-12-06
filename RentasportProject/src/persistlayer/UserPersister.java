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

	//query orders table for bundleName quantity from cart where specific customer id
 public static ResultSet getReviewOrder(int userId){
  String idQuery = "select * from orders where customerId ='"+userId+
   "' UNION select bundleName, quantity from cart where customerId = '"+userId+"';";
   return DbAccessImpl.retrieve(con,idQuery);
  
}//getReviewOrder

	//return bundlename quantity and price from cart for a specific userId
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
	//return cardnum and shipping addr from account for specific customerid
	public static ResultSet getCheckout(String userId){
  String idQuery ="select cardNum,shippingAddr from account where customerId ='"+userId+"';";
  return DbAccessImpl.retrieve(con,idQuery);
 }//getCheckout

	//return time bundlename and quantity from cart where certain custerid and ordernum is null
 public static ResultSet getCart(String time, int quantity, String bundleName, int userId){
	 String idQuery = "select"+time+","+bundleName+","+ quantity +"from cart where customerId ='"+userId+"'AND orderNum IS NULL;";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getcart
  
	//return quantity, bundleName and time from cart where specific customerid and ordernum is null
 public static ResultSet getCartInfo(int userId){
	 String idQuery ="select quantity, bundleName, time from cart where customerId ='"+userId+"'AND orderNum IS NULL;";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getCartInfo
 
	return shipping address, billing address, cardnumber and expiration date from account with certain userId
 public static ResultSet getOrderPageInfo(int userId){
	 String idQuery ="select shippingAddr, billingAddr, cardNum, expirationDate from account where customerId='"+userId+"';";
	 return DbAccessImpl.retrieve(con, idQuery);
 }//getOrderPage
 
	//populate all the fields of order table with pre formatted string
 public static int addOrderToDatabase(String query){
	 //add order to database
	 DbAccessImpl db = new DbAccessImpl();
	 return db.create(con, query);	 
 }
 
	//figure out the order number of the recently added order
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
 
	//take the newly found order num and add it the cart entries that do not have an order num and are under certain name
 public static int addOrderNumToCart(String query){
	 DbAccessImpl db = new DbAccessImpl();
	 return db.create(con, query);	
 }//addOrderNumToCart
 
 	//remove a certain bundle name from the cart
 public static void removeBundleFromCart(String bundleName, int userId){
		//String removeCart = "DELETE * from cart where bundleName ='"+bundleName+"' AND userId = '"+userId+"';";
	 	String removeCart = "DELETE from cart where bundleName ='"+bundleName+"' AND userId = '"+userId+"';";
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
  
  
  public static ResultSet getCartInfo(int userId){
	  String query = "select * from orders where customerId = '" + userId + "';";
	  return DbAccessImpl.retrieve(con, query);
  }
	
	  
  public static void removeOrder(int orderId){
	  String query ="delete from orders where orderNum ='"+orderId+"';";
	  int whatever = DbAccessImpl.changePassword(con, query);
  }
 
  public static ResultSet checkItems(int userId){
	  String query = "select * from orders where customerId ='"+userId+"';";
	  return DbAccessImpl.retrieve(con, query);
  }
	
  public static ResultSet goMaintainUserInfo(int userId) {
	String query = "select * from user where customerId = '" + userId + "';";
	return DbAccessImpl.retrieve(con,query);
  }
  
  
}
