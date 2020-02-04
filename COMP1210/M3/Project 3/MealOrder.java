import java.util.Scanner;
import java.text.DecimalFormat;
/**
*program that takes meal orders and other info.
*
*Project 3
*@CarsonBarnett-COMP1210-003
*@1/28/19
*/
public class MealOrder
{
/**
*takes meal orders.
*@param args command line argument (not used)
*/
   public static void main(String [] args)
   {
   
      String code = " ";
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter your order code: ");
      code = userInput.nextLine();
      String codetrimmed = code.trim();
      if (code.length() < 12) { //if invalid code
         System.out.println();
         System.out.println("Invalid Order Code.");
         System.out.println("Order code must have at least 12 characters.");
      }
      else {
         System.out.println();
         String name = codetrimmed.substring(12);
         System.out.println("Name: " + name.trim());
         String adultMeals = codetrimmed.substring(0, 2);
         int am = Integer.parseInt(adultMeals); 
         if (am > 9) { 
            System.out.print("Adult meals: " + adultMeals);
         }
         else {
            System.out.print("Adult meals: " + adultMeals.charAt(1));
         }
         String amprice = codetrimmed.substring(2, 6);
         //price adult meals
         double ampricedouble = Double.parseDouble(amprice);
         //converts to double
         ampricedouble = ampricedouble / 100;
         DecimalFormat df = new DecimalFormat("$#,##0.00");
         //formats decimal
         System.out.println(" at " + df.format(ampricedouble));
         String childMeals = codetrimmed.substring(6, 8);
         int childMealsI = Integer.parseInt(childMeals);
         //child meals
         if (childMealsI > 9) {
            System.out.print("Child meals: " + childMealsI);
         }
         else {
            System.out.print("Child meals: " + childMeals.charAt(1));
         }
         String cmprice = codetrimmed.substring(8, 12);
         double cmpricedouble = Double.parseDouble(cmprice);
         cmpricedouble = cmpricedouble / 100;
         System.out.println(" at " + df.format(cmpricedouble));
         //prints formatted price child meals
         double total = (ampricedouble * am) + (cmpricedouble * childMealsI);
         if (total < 100) {
            System.out.println("Total: " + df.format(total));
         }
         else { //acccounts for discount
            System.out.println("Subtotal: " + df.format(total));
            double discount = (0.15 * total * -1);
            System.out.println("15% Discount: " + df.format(discount));
            double discountedtotal = total + discount;
            System.out.println("Total: " + df.format(discountedtotal));
         }
         int random = (int) (Math.random() * 99999 + 1);
         System.out.println("Lucky Number: " + random);   
      }  
   }
}

