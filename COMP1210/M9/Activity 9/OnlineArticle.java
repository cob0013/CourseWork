/**
*online article.
*Activity 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class OnlineArticle extends OnlineTextItem {
   private int wordCount;
/**
*constructor.
*@param nameIn input for name
*@param priceIn input for price
*/
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }
   /**
   *sets word count.
   *@param wordCountIn input for word count
   */
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
   

}
