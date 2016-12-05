package objectlayer;

public class Cart {

		private int customerId;
		private int orderNum;
		private String bundleName;
		private int quantity;
		private String time;
		
		public Cart()
		{
			customerId=1001;
			orderNum=1212;
			bundleName="football";
			quantity=1;
			time="price_wk";
		}
		
		public int getCustomerId()
		{
			return customerId;
		}
		
		public int getOrderNum()
		{
			return orderNum;
		}
		
		public String getBundleName()
		{
			return bundleName;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		
		public String getTime()
		{
			return time;
		}
		
		public void getCustomerId(int cid)
		{
			this.customerId= cid;
		}
		
		public void getOrderNum(int ordNum)
		{
			this.orderNum= ordNum;
		}
		
		public void getBundleName(String bundleNm)
		{
			this.bundleName= bundleNm;
		}
		
		public void getQuantity(int qty)
		{
			this.quantity=qty;
		}
		
		public void getTime(String t)
		{
			this.time=t;
		}

}
