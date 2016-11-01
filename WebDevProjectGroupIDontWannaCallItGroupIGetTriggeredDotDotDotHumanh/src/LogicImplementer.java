import java.util.HashMap;

public class LogicImplementer {
	
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
		
		
		int result = Persister.goCreateNewAccountSQLPersistLayer(firstName, lastName, email, password);
		
		HashMap<String, Object> data = new HashMap<>();
		
		if(result ==1){
			data.put("result", 1);
			
		} else {
			data.put("result", 0);
			data.put("firstName", firstName);
			data.put("lastName", lastName);
			data.put("email", email);
			data.put("password", password);
			data.put("fullName", name);
		}
		
		return data;
		
		
	}
	
	
}
