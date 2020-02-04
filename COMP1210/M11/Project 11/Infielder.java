/**
*infielder.
*project 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class Infielder extends SoftballPlayer {
//fields
   private double infielderFieldingAvg;
//constructor
/**
*constructor.
*@param numberIn input
*@param nameIn input
*@param positionIn input
*@param specializationFactorIn input
*@param battingAverageIn input
*@param infielderFieldingAvgIn input
*/
   public Infielder(String numberIn, String nameIn, String positionIn,
      double specializationFactorIn, double battingAverageIn,
          double infielderFieldingAvgIn) {
      super(numberIn, nameIn, positionIn,
         specializationFactorIn, battingAverageIn);
      infielderFieldingAvg = infielderFieldingAvgIn;
   }   
   //methods
   /**
   *gets infielder fielding avg.
   *@return avg
   */
   public double getInfielderFieldingAvg() {
      return infielderFieldingAvg;
   }
   /**
   *sets in fielding avg.
   *@param infielderFieldingAvgIn input
   */
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn) {
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
   
   /**
   *rating.
   *@return rating
   */
   public double rating() {
      return BASE_RATING * specializationFactor
         * battingAvg * infielderFieldingAvg;
   }
   
 
}