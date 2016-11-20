package logiclayer;

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
    
    int result = Persister.goCreateNewAccountSQLPersistLayer(firstName, lastName, email, password);
    
    
  }
}
