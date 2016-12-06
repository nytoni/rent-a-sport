package logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistlayer.*;
import objectlayer.*;

public class BundlesLogicImpl {

	/*This method returns the list for the 
	 * query to get results from DB to display
	 * on the corresponding sport package pages
	 */
	public List<Bundles> getBundleByBundleType(String imgPth)
	{
		MoviePersistImpl mp= new MoviePersistImpl();
		ResultSet rs=mp.getRSBundleTypes(imgPth);
		List<Bundles> bundleList= new ArrayList<Bundles>();		
		System.out.println("HI1");
		try {
		while(rs.next())
		{
			System.out.println("HI2");
			Bundles b=new Bundles();
			b.setBundleName(rs.getString("bundleName"));
			b.setItems(rs.getString("items"));
			b.setImagePath(rs.getString("imagePath"));
			bundleList.add(b);
		}	
		}
		catch (SQLException e) 
		{e.printStackTrace();}
		
		return bundleList;
	}
	
	/*This method returns the List of the items  
	 *from DB needed to show on the result page
	 */
	public List<Cart> getBundleBySportPkg(String custId, String bundleName, String qty, String time)
	{
		MoviePersistImpl mp= new MoviePersistImpl();
		ResultSet rs=mp.getRSInsertSportPkg(custId, bundleName, qty, time);
		List<Cart> cartList= new ArrayList<Cart>();		
		try {
		while(rs.next())
		{
			Cart b=new Cart();
			b.setCustomerId(rs.getInt("customerId"));
			b.setBundleName(rs.getString("bundleName"));
			b.setQuantity(rs.getInt("quantity"));
			b.setTime(rs.getString("timePeriod"));
			cartList.add(b);
		}	
		}
		catch (SQLException e) 
		{e.printStackTrace();}	
		return cartList;
	}
}
