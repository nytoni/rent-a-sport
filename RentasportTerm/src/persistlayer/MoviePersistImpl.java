package persistlayer;

import java.sql.*;
import persistlayer.*;

public class MoviePersistImpl {
	/*This method returns the ResultSet for the 
	 * query to get the bundle name, pic, and items from DB
	 */
	public ResultSet getRSBundleTypes(String bdlname)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="Select * from bundles where bundleName='"+ bdlname +"'";
		return da.retrieve(con, query);
	}
	
	/*This method returns the ResultSet for the 
	 * query to insert and item into the cart and then another 
	 * query to select all to show that the insert query worked
	 */
	public ResultSet getRSInsertSportPkg(String custId, String bundleName, String qty, String time)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="INSERT INTO cart(customerId, bundleName, quantity, timePeriod) VALUES('"+ custId +"', '"+bundleName+"',"+ qty + ", '" +time+"')"; 
		da.create(con, query);	
		query="Select * from cart";
		return da.retrieve(con, query);
	}
	
}