import java.util.ArrayList;
   
/**
*temperatures class.
*
*ACTIVITY6
*@CarsonBarnett-COMP1210-003
*@2/24/19
*/
public class Temperatures {
//instance variables
   private ArrayList<Integer> temperatures;
//constructor
/**
*Temperatures constructor.
*@param temperaturesIn input for temps
*/
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }
   /**
   *gets lowest temp.
   *@return lowest temp
   */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i); 
         }
      }
      return low;
   }
   /**
   *gets highest temp.
   *@return highest temp
   */
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   /**
   *lower minimum.         
   *@param lowIn input
   *@return returns lower min
   */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   /**
   *higher maximum.
   *@param highIn input
   *@return returns output
   */
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   /**
   *to string.
   *@return output returns ouut
   */
   public String toString() {
      return "\tTemperatures: " + temperatures 
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   }
}