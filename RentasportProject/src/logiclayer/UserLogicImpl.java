package logiclayer;

import persistlayer.*;
import objectlayer.*;

public class UserLogicImpl {
  public static HashMap<String, Object> goCreateANewAccount(String name, String email, String password){
    
    String firstName = "";
    String lastName = "";
    
    if(name.contains(" ")){
      String [] parts = name.split(" ");
      firstName = parts[0];
      lastName = parts[1];
      
    } else {
      firstName = name;
      lastName = "";
    }
    
    int result = UserPersister.goCreateNewAccountSQLPersistLayer(firstName, lastName, email, password);
    HashMap<String, Object> data = new HashMap<>();
    
    if(result == 1) {
      data.put("result", 1); 
    } else {
      int userId = UserPersister.getUserId(email);
      User currentUser = new User(userId, firstName, lastName, email, password);
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
          data.put("result", 1);
          data.put("customerId", rset.getString(1));
          data.put("name", rset.getString(2));
          data.put("password", rset.getString(3));
          data.put("email", rset.getString(4));
          
        }
      } catch (SQLException e) {
        e.printStackTrace(); 
      }
      
      return data;
  }
}
