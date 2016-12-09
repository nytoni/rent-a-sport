package logiclayer;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import objectlayer.Orders;
import persistlayer.UserPersister;

public class ProduceCartLogicImpl {

	public static HashMap<String, Object> produceCartPage(int userId){
		ResultSet rs = UserPersister.getCartInfoForOrder(userId);
		ArrayList<Orders> myOrders = new ArrayList<Orders>();
		
		HashMap<String, Object> data = new HashMap();
		try {
			while(rs.next())
			{
				Orders order= new Orders(rs.getInt("orderNum"),rs.getInt("customerId"), rs.getString("shipDate"),rs.getString("arrivalDate"),rs.getInt("price"),rs.getInt("itemsInOrder"),rs.getString("conditionStat"),rs.getString("dueDate"),rs.getString("orderStatus"));
				myOrders.add(order);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("myOrders",myOrders);
		data.put("userId", userId);
		
		return data;
		//next step is right here
	}
	public static HashMap<String, Object> removeOrder(int userId,int orderId){
		UserPersister.removeOrder(orderId);
		
		boolean iTAI = true;
		int isThereAnItem =0;
		isThereAnItem = ProduceCartLogicImpl.checkItems(userId);
		
		if(isThereAnItem>=1)
		{
			iTAI = true;
		}
		else{
			iTAI = false;
		}
		if(iTAI)
		{
			ResultSet rs = UserPersister.getCartInfoForOrder(userId);
			ArrayList<Orders> myOrders = new ArrayList<Orders>();
			
			HashMap<String, Object> data = new HashMap();
			try {
				while(rs.next())
				{
					Orders order= new Orders(rs.getInt("orderNum"),rs.getInt("customerId"), rs.getString("shipDate"),rs.getString("arrivalDate"),rs.getInt("price"),rs.getInt("itemsInOrder"),rs.getString("conditionStat"),rs.getString("dueDate"),rs.getString("orderStatus"));
					myOrders.add(order);
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.put("myOrders",myOrders);
			data.put("userId", userId);
			data.put("thereIsItem", 1);
			
			return data;
		}
		else{
			HashMap<String,Object> data = new HashMap();
			data.put("userId", userId);
			data.put("thereIsItem", 0);
			return data;
		}
		

		
		
	}
	public static int checkItems(int userId){
		int numberOfResults =0;
		ResultSet result = UserPersister.checkItems(userId);
		
		try {
			while(result.next()){
				
				numberOfResults++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numberOfResults>=1)
		{
			return numberOfResults;
		}
		else 
		{
			return 0;
		}

		
	}
}
	
	
