package objectlayer;

public class Cart {
    bundle[] CartInstance;
    //each time something is added to cart create new entry in quant with 
    //number of f bundle purchased
    int[] quant;
    double total;
  
  
  
   public bundle[] getCart(){
      return cartInstance;
   }//getCart
  
  public double getTotal(){
      return total;
  }//getTotal
  
  public void setTotal(double newTotal){
    total = newTotal;
  }//setTotal

  
  
}//Cart
