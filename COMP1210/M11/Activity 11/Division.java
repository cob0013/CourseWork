/**
*division.
*Activity 10
*@CarsonBarnettCOMP1210-003
*@4/14/19
*/
public class Division {
//methods
/**
*int divide.
*@param numeratorIn input
*@param denominatorIn input
*@return output
*/
   public static  int intDivide(int numeratorIn, int denominatorIn) {
      try {
         return numeratorIn / denominatorIn;
      }
      catch (ArithmeticException e)
      {
         return 0;
      }
      
   }
  /**
*int decimal divide.
*@param numeratorIn input
*@param denominatorIn input
*@return output
*/  
   public static double decimalDivide(int numeratorIn, int denominatorIn) {
      if (denominatorIn == 0) {
         throw new IllegalArgumentException("The denominator "
            + "cannont be zero.");
      }
      return (double) numeratorIn / denominatorIn;
   
   }
   

}