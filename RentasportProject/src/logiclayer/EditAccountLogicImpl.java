
package logiclayer;

import persistlayer.*;
import objectlayer.*;


public class EditAccountLogicImpl {
  public static HashMap<String, Object> changePassword(int userId, String confirmPassword){
    
    int result = UserPersister.changePassword(userId, confirmPassword);
    HashMap<String, Object> data = new HashMap<>();
    
    if(result == 1) {
      data.put("result", 1);
    } else {
       
    }
    
    
  }
  
  public static int checkOldPassword(int userId, String oldPassId){
    ResultSet result = UserPersister.checkOldPassword(userId);
    
    if(result.getString(1) == oldPassId){
      return 1; 
    } else {
      return 0;
    }
    
    
  }
  
  
  
  
}
