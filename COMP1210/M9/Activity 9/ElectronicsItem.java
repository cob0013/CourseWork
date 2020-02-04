/**
*electronics item.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class ElectronicsItem extends InventoryItem {
//instances
   protected double weight;
   /**shipping cost.*/
   public static final double SHIPPING_COST = 1.5;
   
   /**
   *constructor.
   *@param nameIn input for name
   *@param priceIn input for price
   *@param weightIn input for weight
   */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }
      /**
      *caclulates cost.
      *@return returns calculated cost
      */
   public double calculateCost() {
      return super.calculateCost() +  (SHIPPING_COST * weight); 
   }
         
      



}