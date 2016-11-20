package logiclayer;

import persistlayer.*;
import objectlayer.*;

public class UserLogicImpl {
  public static HashMap<String, Object> goCreateANewAccount(String, name, String email, String password){
    
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
}
