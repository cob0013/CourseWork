/**
*provides methods to perform on an int.
*
*ACTIVITY5
*@CarsonBarnett-COMP1210-003
*@2/17/19
*/
public class NumberOperations {
//instance variables
   private int number;

//constructor
/**
*constructor for numberOperations.
*@param numberIn number input
*/
   public NumberOperations(int numberIn) {
      number = numberIn;
   
   }
   //methods
   /**
   *gets value.
   *@return int returns value
   */
   public int getValue() {
      return number;
   }
   /**
   *odds under.
   *@return string returns odds under
   */
   public String oddsUnder() {
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++; //count
      }
      return output;
   }
   /**
   *powers to under.
   *@return string two under
   */
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t"; //concatenate to output
         powers = powers * 2; //get next power of 2
      }
      return output;
   }
   /**
   *is greater.
   *@param compareNumber input int
   *@return int number
   */ 
   public int isGreater(int compareNumber) {
      if (number > compareNumber) {
         return 1;
      }
      else if (number < compareNumber) {
         return -1;
      }
      else {
         return 0;
      }
   }
   /**
   *string to string.
   *@return string returns toString
   */
   public String toString() {
      return number + "";
   }
   
  
}