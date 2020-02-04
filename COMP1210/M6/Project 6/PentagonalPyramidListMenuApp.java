import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
*pp list app w choices.
*
*PROJECT6
*@CarsonBarnett-COMP1210-003
*@2/25/19
*/
public class PentagonalPyramidListMenuApp {
/**
*main method for running the app.
*@param args (not used)
*@throws FileNotFoundException throws
*/
   public static void main(String [] args)
         throws FileNotFoundException {
      String listName = "*** no list name assigned ***";
      String fileName = "no file name";
      ArrayList<PentagonalPyramid> myList = new ArrayList<PentagonalPyramid>();
      PentagonalPyramidList ppList 
         = new PentagonalPyramidList(listName, myList);
      Scanner userInput = new Scanner(System.in);
      char choice = 'Q';
      System.out.println("PentagonalPyramid List System Menu"
         + "\nR - Read File and Create PentagonalPyramid List"
         + "\nP - Print PentagonalPyramid List"
         + "\nS - Print Summary"
         + "\nA - Add PentagonalPyramid"
         + "\nD - Delete PentagonalPyramid"
         + "\nF - Find PentagonalPyramid"
         + "\nE - Edit PentagonalPyramid"
         + "\nQ - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch (choice) {
            case 'R':
               System.out.print("\tFile Name: ");
               fileName = userInput.nextLine();
               ppList = ppList.readFile(fileName);
               System.out.println("\tFile read in and" 
                  + " PentagonalPyramid List created\n");
               break;
            case 'P':
               System.out.print(ppList.toString());
               break;
            case 'S':
               System.out.println("\n" + ppList.summaryInfo() + "\n");
               break;
            case 'A':
               System.out.print("\tLabel: ");
               String addedLabelIn = userInput.nextLine();
               System.out.print("\tBase Edge: ");
               double addedBaseEdgeIn 
                  = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               double addedHeightIn 
                  = Double.parseDouble(userInput.nextLine());
               ppList.addPentagonalPyramid(addedLabelIn,
                  +addedBaseEdgeIn, addedHeightIn);
               System.out.println("\t*** PentagonalPyramid added ***\n");
               break;
            case 'D':
               System.out.print("\tLabel: ");
               String deleted = userInput.nextLine();
               PentagonalPyramid pp = ppList.deletePentagonalPyramid(deleted);
               if (pp != null) {
                  System.out.println("\t\"" + pp.getLabel() + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + deleted + "\" not found\n");
               }
               
              
            
               break;
            case 'F':
               System.out.print("\tLabel: ");
               String find = userInput.nextLine();
               PentagonalPyramid pp2 = ppList.findPentagonalPyramid(find);
               if (pp2 != null) {
                  System.out.println(pp2 + "\n");
               }
               else {
                  System.out.println("\t\"" + find + "\" not found\n");
               }
               break;
            case 'E':
               System.out.print("\tLabel: ");
               String editLabel = userInput.nextLine();
               System.out.print("\tBase Edge: ");
               double editBaseEdge = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               double editHeight = Double.parseDouble(userInput.nextLine());
               boolean edit 
                  = ppList.editPentagonalPyramid(editLabel,
                   +editBaseEdge, editHeight);
               if (edit) {
                  System.out.println("\t\"" 
                     + editLabel
                      + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + editLabel + "\" not found\n");
               }
               
               
               break;
            case 'Q':
               break; 
            default:
               System.out.println("\t*** invalid code ***");
         }
      }
      while (choice != 'Q');   
   }
}