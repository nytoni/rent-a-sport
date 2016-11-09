package objectlayer;

public class Bundles {

	private String bundleName;
	private int quantity;
	private String items;
	private int price_wk;
	private int price_2wk;
	private int price_mnth;
	private int price_3mnth;
	private int price_6mnth;
	private String imagePath;
	
	public Bundles()
	{
		bundleName="football";
		quantity=2;
		items="Some Stuff";
		price_wk=10;
		price_2wk=20;
		price_mnth=30;
		price_3mnth=40;
		price_6mnth=50;
		imagePath="./path";
		
	}
	
	public String getBundleName()
	{
		return bundleName;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getItems()
	{
		return items;
	}
	
	public int getPrice_wk()
	{
		return price_wk;
	}
	
	public int getPrice_2wk()
	{
		return price_2wk;
	}
	
	public int getPrice_mnth()
	{
		return price_mnth;
	}
	
	public int getPrice_3mnth()
	{
		return price_3mnth;
	}
	
	public int getPrice_6mnth()
	{
		return price_6mnth;
	}
	
	
	
	
}
