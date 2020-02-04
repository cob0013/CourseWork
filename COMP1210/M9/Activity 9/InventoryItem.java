/**
*inventory item activity.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class InventoryItem {
//instances
   protected String name;
   protected double price;
   private static double taxRate = 0;
//constructor
/**
*constructor.
*@param nameIn input for name
*@param priceIn input for price
*/
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }
   
   //methods
   /**
   *gets name.
   *@return name
   */
   public String getName() {
      return name;
   }
   /**
   *calculates cost.
   *@return calculated cost
   */
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   /**
   *sets tax rate.
   *@param taxRateIn input for tax rate
   */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   /**
   *string to string.
   *@return string
   */
   public String toString() {
      return name + ": $" + calculateCost();
   }

}