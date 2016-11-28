
package logiclayer;

import persistlayer.*;
import objectlayer.*;


public class EditAccountLogicImpl {
  public static HashMap<String, Object> changePassword(int userId, String confirmPassword){
    
    int result = UserPersister.changePassword(userId, confirmPassword);
    
    
    
  }
}
