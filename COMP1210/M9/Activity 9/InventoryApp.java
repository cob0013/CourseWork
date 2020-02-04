/**
*main method.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class InventoryApp {
/**
*main method.
*@param args not used
*/
   public static void main(String[] args) {
      InventoryItem.setTaxRate(0.05);
      InventoryItem item1 = new InventoryItem("Oil change kit", 39.00);
      ElectronicsItem item2 = new ElectronicsItem("Cordless phone", 80.00, 1.8);
      OnlineArticle item3 = new OnlineArticle("Java News", 8.50);
      item3.setWordCount(700);
      OnlineBook item4 = new OnlineBook("Java for Noobs",  13.37);
      item4.setAuthor("L.G. Jones"); 
   }



}