import java.util.Scanner;
/**
*accepts raw distance in inches and converts miles,yds,ft,in.
*
*Project 2
*@CarsonBarnett-COMP1210-03
*@1/23/19
*/
public class ImperialDistance {
/**
*combines distances.
*@param args command line argument (not used)
*/
   public static void main(String [] args)
   {
      Scanner userInput = new Scanner(System.in);
      int miles = 0;
      int yards = 0;
      int feet = 0;
      int input = 0; //original inches input
      int inches = 0; //remainder inches
      System.out.print("Enter the raw distance measurement in inches: ");
      input = userInput.nextInt(); //prompt user for input in inches
      if (input < 0) {
         System.out.println("Measurement must be non-negative!");
      }
      else {
         System.out.println();
         System.out.println("Measurement by combined miles,"
            + " yards, feet, inches:");
         miles = input / 63360; //determines amount of miles
         System.out.println("\tmiles: " + miles);
         yards = (input % 63360) / 36; 
      //determines amount of yards using remainder of inches
         System.out.println("\tyards: " + yards); 
         feet = (input % 63360) % 36 / 12; 
      //determines amount of feet using remainder of inches
         System.out.println("\tfeet: " + feet);
         inches = (input % 63360) % 36 % 12; 
      //determines remainder of inches
         System.out.println("\tinches: " + inches);
         System.out.println();
         System.out.println(input + " in = " + miles + " mi, "
            + yards + " yd, " + feet + " ft, " + inches + " in");
      }
   }
}

