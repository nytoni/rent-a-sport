package objectlayer;

public class Items {
	int price;
	int quantity;
	String bundleName;
	String time;
	
	//constructor 
	public Items(int p, int q, String bN, String t){
		super();
		price = p;
		quantity = q;
		bundleName = bN;
		time = t;
	}
	//autogenerated getters and setters from here on out
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}