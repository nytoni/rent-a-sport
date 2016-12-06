import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//package logiclayer;
//
//import persistlayer.*;
//import objectlayer.*;

public class UserLogicImpl {
  public static HashMap<String, Object> goCreateANewAccount(String name, String email, String password){
    
   
    
    int result = UserPersister.goCreateNewAccountSQLPersistLayer(name, email, password);
    HashMap<String, Object> data = new HashMap<>();
    
    if(result == 1) {
      data.put("result", 1); 
    } else {
      ResultSet userId = UserPersister.getUserId(email);
      User currentUser = new User(0,null,null,null);
      try {
		currentUser = new User(Integer.parseInt(userId.getString(1)), name, email, password);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      data.put("currentUser", currentUser);
    }
    return data;
    
  }
  public static HashMap<String, Object> logIn(String email, String password){
      ResultSet rset = UserPersister.goGetLoginInfo(email, password);
      HashMap<String, Object> data = new HashMap<>();
      try {
        if(!rset.next()){
          data.put("result", 0);
          data.put("email", email);
        }
        else{
          
          User currentUser = new User(Integer.parseInt(rset.getString(1)), rset.getString(2), rset.getString(3), rset.getString(4));
          data.put("currentUser", currentUser);
          
          data.put("result", 1);
          
        }
      } catch (SQLException e) {
        e.printStackTrace(); 
      }
      
      return data;
  }
	
  public static User maintainUser(int userId){
	ResultSet rset = UserPersister.getMaintainUserInfo(userId);
	try {
		User currentUser = new User(Integer.parseInt(rset.getString(1)), rset.getString(2), rset.getString(3), rset.getString(4));
		return currentUser;	
	
	} catch (SQLException e) {
	   e.printStackTrace();		
	} 
  }
}
