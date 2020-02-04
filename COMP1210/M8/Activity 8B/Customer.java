/**
*customer program.
*
*ACTIVITY 8B
*@CarsonBarnett-COMP1210-003
*@3/18/19
*/
public class Customer implements Comparable<Customer> {
//instances
   private String name;
   private String location;
   private double balance;
   
 //methods
 /**
 *customer constructor.
 *@param nameIn input for name
 */
   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }
   /**
   *sets location.
   *@param locationIn input for location
   */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
   *checks location two paramaters.
   *@param city input
   *@param state input
   */
   public void setLocation(String city, String state) {
      location = city + ", " + state; 
   }
    /**
   *changes balance.
   *@param amount input for balance
   */
   public void changeBalance(double amount) {
      balance += amount;
   }
   
   /**
   *gets location.
   *@return location
   */
   public String getLocation() {
      return location;
   }
   /**
   *gets balance.
   *@return returns balance
   */
   public double getBalance() {
      return balance;
   }
   /**
   *to string.
   *@return output string
   */
   public String toString() {
      String output = name + "\n" + location + "\n$" + balance;
   
      return output;
   }
   /**
   *compare to.
   *@param obj aj
   *@return compared
   */
   public int compareTo(Customer obj) {
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      }
      else if (this.balance < obj.getBalance()) {
         return -1;
      }
      else {
         return 1;
      }
   
   }

}