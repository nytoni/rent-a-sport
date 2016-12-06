import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//package logiclayer;

//import persistlayer.*;
//import objectlayer.*;


public class EditAccountLogicImpl {
  public static HashMap<String, Object> changePassword(int userId, String confirmPassword){
    
    //go down ladder and change to void
	 System.out.println(confirmPassword);
    UserPersister.changePassword(userId, confirmPassword);
    HashMap<String, Object> data = new HashMap<>();
    data.put("userId", userId);
 
    return data;
    
    
  }
  
public static HashMap<String, Object> changeCreditCardInfo(int customerId,String name, String billingAddress, String shippingAddress,String cardNumber, String expireDate, String securityCode){

	    UserPersister.changeCreditCardInfo(customerId,name, billingAddress,shippingAddress,cardNumber,expireDate,securityCode);
	    HashMap<String, Object> data = new HashMap<>();
	    data.put("userId", customerId);
	  
	    return data;
  }
  
  public static int checkOldPassword(int userId, String oldPassId) throws SQLException{
	  
	 
    ResultSet result = UserPersister.checkOldPassword(userId);

    String password = "";
    while(result.next())
    {
    	password = result.getString("password");
    }

    if(password.equals(oldPassId)){
    	System.out.println("1");
      return 1; 
    } 
    else {//nothing prints out in else for some reason
    	System.out.print("0");
      return 0;
    }
  }
  
  
}
