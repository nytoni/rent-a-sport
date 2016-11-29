package logiclayer;

import persistlayer.*;
import objectlayer.*;

public class UserLogicImpl {
  public static HashMap<String, Object> goCreateANewAccount(String name, String email, String password){
    
   
    
    int result = UserPersister.goCreateNewAccountSQLPersistLayer(name, email, password);
    HashMap<String, Object> data = new HashMap<>();
    
    if(result == 1) {
      data.put("result", 1); 
    } else {
      int userId = UserPersister.getUserId(email);
      User currentUser = new User(userId, name, email, password);
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
          
          User currentUser = new User(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
          data.put("currentUser", currentUser);
          
          data.put("result", 1);
          
        }
      } catch (SQLException e) {
        e.printStackTrace(); 
      }
      
      return data;
  }
}
