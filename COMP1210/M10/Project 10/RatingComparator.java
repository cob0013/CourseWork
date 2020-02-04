import java.util.Comparator; 
// import java.text.DecimalFormat;

/**
*softball player.
*Project 10
*@CarsonBarnett-COMP1210-003
*@4/1/19
*/
public class RatingComparator implements Comparator<SoftballPlayer> {
/**
*compare.
*@return output
*@param p1 input
*@param p2 input
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
      // DecimalFormat decimalFormat = new DecimalFormat("#0.00");
      // String p1Formatted = decimalFormat.format(p1.rating());
      // String p2Formatted = decimalFormat.format(p2.rating());
      double p1Rating = p1.rating();
      double p2Rating = p2.rating();
   
   
   
      if (p1Rating < p2Rating) {
         return 1;
      }
      if (p1Rating > p2Rating) {
         return -1;
      }
      return 0;
   }

}