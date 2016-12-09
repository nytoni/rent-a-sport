package logiclayer;
import objectlayer.*;
import persistlayer.*;


//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CartLogicImpl {
	 
	public static ArrayList<Items> generateList(int userId){
		ResultSet rset = UserPersister.getCartInfo(userId);
		ArrayList <Items> myList = new ArrayList<Items>();
		
		try{
			
			while( rset.next()){
				int price=0;
				int quantity = Integer.parseInt(rset.getString(1));
				String bn = rset.getString(2);
				String time = rset.getString(3);
				ResultSet priceRS = UserPersister.getCart(time, bn);
				price += Integer.parseInt(priceRS.getString(1)) * quantity;
				Items item = new Items(price, quantity, bn, time);
				myList.add(item);
			}//while 
			return myList;
		}catch(SQLException e){
			System.out.println("fuck you");
			return myList;
		}
	}//ArrayList
  
  //deal with the info from query needed for order
	public static String[] generateOrderInfo(int userId){
		ResultSet rs = UserPersister.getOrderPageInfo(userId);
		
		String[] s = new String[4];
		try{
			s[0] = rs.getString(1);
			s[1] = rs.getString(2);
			s[2] = rs.getString(3);
			s[3] = rs.getString(4);
			return s;
		}catch(SQLException e){
			System.out.println("well fuck");
			return s;
		}
	}//generateOrderInfo
	
  //take all required information for order table and add to database
	public static void addOrder(int userId, int price, int itemsInOrder){
		String condition = "good";
		String orderStatus = "open1";
		Date date = new Date();
		//calculate due date for order
		//dDDate;
		int daysTillDueDate=7;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, daysTillDueDate);
		date = cal.getTime();
		java.sql.Date dDDate = new java.sql.Date(date.getTime());
		//determine current date for ship date
		java.sql.Date sHDate = new java.sql.Date(date.getTime());
		
		//determine current date +5 days for arrival date
		
		cal.setTime(date);
		cal.add(Calendar.DATE, 5);
		date = cal.getTime();
		java.sql.Date aDate = new java.sql.Date(date.getTime());
		//aDate;
    
		//run query for adding
		String query ="INSERT INTO orders (customerId, shipDate,arrivalDate,price,itemsInOrder,conditionStat,dueDate,orderStatus)"+
				"VALUES('"+userId+"','"+sHDate+"','"+aDate+"','"+price+"','"+itemsInOrder+"','"+condition+"','"+dDDate+"','"+orderStatus+"';";
		UserPersister.addOrderToDatabase(query);
		
		//find out newly generated orderNumber
		String query1 = "Select orderNum from orders Where orderStatus = 'open1'";
		int orderNums = UserPersister.findOutOrderNum(query1);
		//query to change orderNums in cart to orderNum
		
		//change orderStatus to open
		String query2 = "INSERT INTO orders (orderStatus) VALUES 'open' where orderStatus = 'open1'";
		UserPersister.addOrderToDatabase(query2);
    
		//add newly generated orderNumber to cart
		String query3 = "INSERT INTO cart (orderNum) VALUES ('"+orderNums+"') WHERE id = '"+userId+"'AND orderNum IS NULL;";
		UserPersister.addOrderNumToCart(query3);
	}//addOrder
	
  //remove a bundle from the cart when required
	public static void removeBundleFromCart(String bundleName, int userId){
		UserPersister.removeBundleFromCart(bundleName, userId);
	}//removeBundleFromCart
	
  //return information required for checkout page
	public static String[] getCheckouts(String userId){
		//UserPersister ul = new UserPersister();
		try{
			ResultSet rs= UserPersister.getCheckout(userId);
			String[] s={ rs.getString(1), rs.getString(2)};
			 return s;
		}catch(SQLException e){
			String[] n={"n", "n"};
			return n;
		}
}//getCheckouts
}
