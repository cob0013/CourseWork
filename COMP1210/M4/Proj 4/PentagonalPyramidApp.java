import java.util.Scanner;
/**
*reads and creates pentagonal pyramid object.
*
*Project 4
*@CarsonBarnett-COMP1210-003
*@2/4/19
*/
public class PentagonalPyramidApp
{
/**
*pentagonal pyramid app.
*@param args argument (not used)
*/
   public static void main(String [] args) 
   {
      String labelInput = " ";
      double heightInput = 0;
      double baseEdgeInput = 0;
      Scanner userInput = new Scanner(System.in);
      System.out.println("Enter label, base edge," 
         + " and height for a pentagonal pyramid.");
      System.out.print("\tlabel: ");
      labelInput = userInput.nextLine();
      System.out.print("\tbase edge: ");
      baseEdgeInput = Double.parseDouble(userInput.nextLine());
      if (baseEdgeInput <= 0) {
         System.out.println("Error: base edge must be greater than 0.");
      }
      else {
         System.out.print("\theight: ");
         heightInput = Double.parseDouble(userInput.nextLine());
         if (heightInput <= 0) {
            System.out.println("Error: height must be greater than 0.");
         }
         else { 
            System.out.println();
            PentagonalPyramid output =
               new PentagonalPyramid(labelInput, baseEdgeInput, heightInput);
            System.out.println(output);
         }
      }
   }
}