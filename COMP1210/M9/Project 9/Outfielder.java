// import java.text.DecimalFormat;
/**
*outfeilder.
*project 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class Outfielder extends SoftballPlayer {
//instances
   private double outfielderFieldingAvg;
//constructor
/**
*constructor.
*@param numberIn input
*@param nameIn input
*@param positionIn input
*@param specializationFactorIn input
*@param battingAverageIn input
*@param outfielderFieldingAvgIn input
*/
   public Outfielder(String numberIn, String nameIn, String positionIn,
      double specializationFactorIn, double battingAverageIn,
          double outfielderFieldingAvgIn) {
      super(numberIn, nameIn, positionIn,
          specializationFactorIn, battingAverageIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
   *gets outfielder avg.
   *@return avg
   */
   public double getOutfielderFieldingAvg() {
      return outfielderFieldingAvg;
   }
   /**
   *sets oa.
   *@param outfielderFieldingAvgIn input
   */
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn) {
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
   *rating.
   *@return returns rating
   */
   public double rating() {
      double format = BASE_RATING 
         * specializationFactor *  battingAvg * outfielderFieldingAvg;
      return format;
      // return decimalFormat.format(output);
   }
}