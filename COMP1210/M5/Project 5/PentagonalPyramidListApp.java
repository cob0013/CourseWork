import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


/**
*pentagonal pyramid list app.
*
*PROJECT5
*@CarsonBarnett-COMP1210-003
*@2/18/19
*/
public class PentagonalPyramidListApp {
/**
*main metho for pp list app.
*@param args (not used)
*@throws FileNotFoundException asdf
*/
   public static void main(String [] args)
      throws FileNotFoundException {
      ArrayList<PentagonalPyramid> myList = new ArrayList<PentagonalPyramid>();
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();
      Scanner scanFile = new Scanner(new File(fileName));
      String pentagonalPyramidListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         String pentagonalPyramidName = scanFile.nextLine();
         double baseEdge = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine());
         PentagonalPyramid pp = 
            new PentagonalPyramid(pentagonalPyramidName, baseEdge, height);
         myList.add(pp);
      }
      scanFile.close();
      PentagonalPyramidList myPentagonalPyramidList = 
         new PentagonalPyramidList(pentagonalPyramidListName, myList);
      System.out.println(myPentagonalPyramidList);
      System.out.println(myPentagonalPyramidList.summaryInfo());
   }
}