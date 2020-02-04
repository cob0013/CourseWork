/**
*Items list.
*activity 10
*@CarsonBarnett-COMP1210
*@4/7/19
*/
public class ItemsList {
   private InventoryItem[] inventory;
   private int count;
   //constructor
   /**
   *Constructor.
   */
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   //methods
   /**
   *add item.
   *@param itemIn input
   */
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
   /**
   *calculate total.
   *@param electronicsSurcharge in
   *@return output
   */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         }
      
      }
      return total;
   }
   /**
   *to string.
   *@return output
   */
   public String toString() {
      String output = "All inventory:\n\n";
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
      return output;
   }
   
   
}
