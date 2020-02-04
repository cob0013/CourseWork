/**
*scores class.
*ACTIVITY 7
*@CarsonBarnett-COMP-1210-003
*@3/3/2019
*/
public class Scores {
//instances
   private int[] numbers;
//methods

/**
*constructor.
*@param numbersIn input
*/
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   
   }
   
   /**
   *finds evens.
   *@return returns evens
   */
   public int[] findEvens() {
      int numberEvens = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      int[] evens = new int[numberEvens];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   }
   /**
   *find odds.
   *@return odds
   */
   public int[] findOdds() {
      int numberOdds = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            numberOdds++; 
         }
      }
      int[] odds = new int[numberOdds];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
   }
   
   /**
   *calculates averages.
   *@return calculated averages
   */
   public double calculateAverage() {
      int sum = 0;
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      return (double) sum / (double) numbers.length;
   }
   /**
   *to String.
   *@return returns to string
   */
   public String toString() {
      String result = "";
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      return result;
   }
   /**
   *to String in reverse.
   *@return to string in reverse
   */
   public String toStringInReverse() {
      String result = "";
      for (int i = numbers.length - 1; i > -1; i--) {
         result += numbers[i] + "\t";
      }
      return result;
   }
}