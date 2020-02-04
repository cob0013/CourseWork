import java.text.DecimalFormat;

/**
*softball player.
*Project 9
*@CarsonBarnett-COMP1210-003
*@4/1/19
*/
public abstract class SoftballPlayer {
//variables
   protected String number;
   protected String name;
   protected String position;
   protected double specializationFactor;
   protected double battingAvg;
   
   protected static int count = 0;
   /**base rating.*/
   public static final int BASE_RATING = 10;
   
   //constructor 
   /**
   *constructor.
   *@param numberIn input
   *@param nameIn input
   *@param positionIn input
   *@param specializationFactorIn input
   *@param battingAvgIn input
   */
   public SoftballPlayer(String numberIn, String nameIn, 
      String positionIn, double specializationFactorIn,
         double battingAvgIn) {
      number = numberIn;
      name = nameIn;
      position = positionIn;
      specializationFactor = specializationFactorIn;
      battingAvg = battingAvgIn;
      count++;
   }
   
   //methods
   /**
   *gets number.
   *@return number
   */
   public String getNumber() {
      return number;
   }
   
   /**
   *sets number.
   *@param numberIn input 
   */
   public void setNumber(String numberIn) {
      number = numberIn;
   }
   /**
   *gets name.
   *@return name
   */
   public String getName() {
      return name;
   }
   /**
   *sets name.
   *@param nameIn input
   */
   public void setName(String nameIn) {
      name = nameIn;
   }
   /**
   *gets position.
   *@return position
   */
   public String getPosition() {
      return position;  
   }
   /**
   *sets position.
   *@param positionIn input
   */
   public void setPosition(String positionIn) {
      position = positionIn;
   }
   /**
   *gets batting avg.
   *@return avg
   */
   public double getBattingAvg() {
      return battingAvg;
   }
   /**
   *sets batting avg.
   *@param battingAvgIn input
   */
   public void setBattingAvg(double battingAvgIn) {
      battingAvg = battingAvgIn;
   }
   /**get specialization factor.
   *@return specializationFactor
   */
   public double getSpecializationFactor() {
      return specializationFactor;
   }
   /**
   *sets specialization factor.
   *@param specializationFactorIn input
   */
   public void setSpecializationFactor(double specializationFactorIn) {
      specializationFactor = specializationFactorIn;  
   }
   /**
   *gets count.
   *@return count
   */
   public static int getCount() {
      return count;
   }
   /**
   *sets count.
   */
   public static void resetCount() {
      count = 0;
   }
   /**
   *stats.
   *@return stats
   */
   public String stats() {
      DecimalFormat decimalFormat = new DecimalFormat("##.000");
      // String output = Double.toString(battingAvg);
      // if (output.charAt(0) == '0') {
         // return output.substring(1);
      // }
      return decimalFormat.format(getBattingAvg());
   }
   /**
   *to string.
   *@return string
   */
   public String toString() {
      DecimalFormat decimalFormat = new DecimalFormat("##.000");
   
      String output = number + " " + name + " (" + position + ") " + stats()
         + "\n" + "Specialization Factor: " + specializationFactor
          + " (" + this.getClass() + ") " + "Rating: "   
          + decimalFormat.format(rating());
      return output;
   }
   /**
   *rating.
   *@return rating
   */
   public abstract double rating();
   
   
   
   
   
   
   


}