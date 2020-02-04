/**
*online text item.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public abstract class OnlineTextItem extends InventoryItem {
/**
*constructor.
*@param nameIn input for name
*@param priceIn input for price
*/
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   /**
   *calculate cost.
   *@return price
   */
   public double calculateCost() {
      return price;
   }
   
   


}