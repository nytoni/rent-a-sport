package objectlayer;

public enum Orders {
        String Addr;
        //occupy Cc from database
      String[] cC;
      String newCC;
      String newBillAddress;
      String newCCV;
      String newName;
  
      String CCUsed;
  
  
   public String getAddr(){
      return getAddr;
  }//getAddr
  
  public void setCreditCard(){
    //if I decide ites necessary I will add coder here to occupy 
    //credit cards from database
  }//setCreditCard
 
  public void SetNewCC(int newCredit){
    newCC = newCredit;
  }//setnewCC
  
  public void setNewBillAddr(String addr){
      newBillAddress = addr;
  }//setNewBillAddr
  
  public void setNewCCV(String newC){
    newCCV = newC;
  }//setNewCCV
  
  public void setNewName(String name){
    newName= name;
  }//setnewName
  
  public void setCCUsed(int index){
    CCUsed = cC[index];
  
  public int addCCtoData(){
    if(newCCV==null||newBillAddress==null||newCC==null||newName==null){
        return 0;
    }else{
        //execute database add command in if; return 0 if failed 1 if successful
        return 1;
    }//else
}
