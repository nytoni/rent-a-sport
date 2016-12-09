package objectlayer;

public class Orders {

	int orderNum;
	int customerId;
	String shipDate;
	String arrivalDate;
	int price;
	int itemsInOrder;

	String conditionStat;
	String dueDate;
	String orderStatus;
	
	public Orders(int orderNum, int customerId, String shipDate, String arrivalDate, int price, int itemsInOrder,
			 String conditionStat, String dueDate, String orderStatus) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.shipDate = shipDate;
		this.arrivalDate = arrivalDate;
		this.price = price;
		this.itemsInOrder = itemsInOrder;
	
		this.conditionStat = conditionStat;
		this.dueDate = dueDate;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getItemsInOrder() {
		return itemsInOrder;
	}
	public void setItemsInOrder(int itemsInOrder) {
		this.itemsInOrder = itemsInOrder;
	}

	public String getConditionStat() {
		return conditionStat;
	}
	public void setConditionStat(String conditionStat) {
		this.conditionStat = conditionStat;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
}
