import java.util.Comparator; 

/**
*softball player.
*Project 10
*@CarsonBarnett-COMP1210-003
*@4/1/19
*/
public class NameComparator implements Comparator<SoftballPlayer> {
/**
*compare.
*@return output
*@param p1 input
*@param p2 input
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
      String p1Name = p1.getName().toLowerCase();
      String p2Name = p2.getName().toLowerCase();
      String p1LastName = p1Name.substring(p1Name.indexOf(' ') + 1);
      String p1FirstName = p1Name.substring(0, p1Name.indexOf(' '));
      String p2LastName = p2Name.substring(p2Name.indexOf(' ') + 1);
      String p2FirstName = p2Name.substring(0, p2Name.indexOf(' '));
      int output = p1LastName.compareTo(p2LastName);
      if (output == 0) {
         output = p1FirstName.compareTo(p2FirstName);
      }
      
      return output;
   }
   
}