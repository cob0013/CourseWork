/**
*online book.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class OnlineBook extends OnlineTextItem {
   protected String author;
/**
*constructor.
*@param nameIn input for name
*@param priceIn input for price
*/
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   
   }
   /**
   *to string.
   *@return to string
   */
   public String toString() {
      return name + " - " + author + ": $" + price;
   
   }
   /**
   *set author.
   *@param authorIn input for author
   */
   public void setAuthor(String authorIn) {
      author = authorIn;
   
   }

}