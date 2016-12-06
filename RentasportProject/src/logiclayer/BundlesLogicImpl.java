package logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistlayer.*;
import logiclayer.*;
import objectlayer.*;

import java.util.*;
import java.io.PrintWriter;
import java.sql.*;

public class BundlesLogicImpl {

	public List<Bundles> getBundleByBundleType(String imgPth)
	{
		MoviePersistImpl mp= new MoviePersistImpl();
		ResultSet rs=mp.getRSBundleTypes(imgPth);
		List<Bundles> bundleList= new ArrayList<Bundles>();		
		try {
		while(rs.next())
		{
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
			b.setOrderNum(rs.getInt("orderNum"));
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
