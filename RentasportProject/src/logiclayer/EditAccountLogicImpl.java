
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
  
  public static HashMap<String, Object> checkOldPassword(int userId, String oldPassId){
    int result = UserPersister.checkOldPassword(userId, oldPassId);
    
    
  }
  
  
  
  
}
