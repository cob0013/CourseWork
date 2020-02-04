import java.util.Scanner;
/**
*solves an equation for x,y,z.
*
*Project 2
*@CarsonBarnett-COMP1210-03
*@1/23/19
*/

public class Solver
{
/**
*solves simple equation with inputs x,y,x.
*@param args command line(not used)
*/
   public static void main(String [] args)
   {
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double y = 0;
      double z = 0;
      double result = 0;
      System.out.println("result = (10x + 4.1) (5y + 8.7) / z");
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble(); //promt user for x
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble(); //prompt user for y
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble(); //promt user for z
      if (z == 0) {
         result = 0.0;
      }
      else { //calculates result
         result = (10 * x + 4.1) * (5 * y + 8.7) / z;
      }
      System.out.print("result = " + result);
   }
}