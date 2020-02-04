import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*pentagonal pyramid list app.
*
*PROJECT5
*@CarsonBarnett-COMP1210-003
*@2/18/19
*/
public class PentagonalPyramidList2 {
//instance variables
   private String listName = "";
   private PentagonalPyramid[] penPyramidList;
   private int numberOfPentagonalPyramids;
    //constructor 
    /**
    *Constructor for pentagonal pyramid list.
    *@param listNameIn user input for list name
    *@param penPyramidListIn user input for Array List Name
    *@param numberOfPentagonalPyramidsIn input
    */
   public PentagonalPyramidList2(String listNameIn,
      PentagonalPyramid[] penPyramidListIn, int numberOfPentagonalPyramidsIn) {
      listName = listNameIn;
      penPyramidList = penPyramidListIn;
      numberOfPentagonalPyramids = numberOfPentagonalPyramidsIn;
   }
   //methods
   /**
   *gets name.
   *@return listName returns the name of list
   */
   public String getName() {
      return listName;
   }
   /**
   *gives number of pps in list.
   *@return penPyramidList.size() returns numbr of pps
   */
   public int numberOfPentagonalPyramids() {
      return numberOfPentagonalPyramids;
   }
   /**
   *gives total surface area.
   *@return surfaceAreaTotal returns total surface area
   */
   public double totalSurfaceArea() {
      int index = 0;
      double surfaceAreaTotal = 0;
      
      while (index < numberOfPentagonalPyramids) {
         PentagonalPyramid surfaceAreaIndividual = penPyramidList[index];
         surfaceAreaTotal += surfaceAreaIndividual.surfaceArea();
         index++; 
         
      }
      return surfaceAreaTotal;
   }
   /**
   *finds total volume for array list.
   *@return volumeTotal returns total volume for all pps
   */
   public double totalVolume() {
      int index = 0;
      double volumeTotal = 0;
      while (index < numberOfPentagonalPyramids) {
         PentagonalPyramid volumeIndividual = penPyramidList[index];
         volumeTotal += volumeIndividual.volume();
         index++; 
      }
      return volumeTotal;
   }
   /**
   *finds average surface area.
   *@return averageSurfaceArea retursn avg sa
   */
   public double averageSurfaceArea() {
      double surfaceAreaTotal = 0;
      double averageSurfaceArea = 0;
      int index = 0;
      while (index < numberOfPentagonalPyramids) {
         PentagonalPyramid surfaceAreaIndividual = penPyramidList[index];
         surfaceAreaTotal += surfaceAreaIndividual.surfaceArea();
         index++;
         averageSurfaceArea = surfaceAreaTotal / numberOfPentagonalPyramids;
      }
      return averageSurfaceArea;   
   }
   /**
   *finds average volume.
   *@return averageVolume returns calculated avg volume
   */
   public double averageVolume() {
      int index = 0;
      double averageVolume = 0;
      double volumeTotal = 0;
      while (index < numberOfPentagonalPyramids) {
         PentagonalPyramid volumeIndividual = penPyramidList[index];
         volumeTotal += volumeIndividual.volume();
         index++; 
         averageVolume = volumeTotal / numberOfPentagonalPyramids;
      }
      return averageVolume;
   }
   /**
   *to string method.
   *@return output returns output
   */
   public String toString() {
      int index = 0;
      String output = listName + "\n" + "\n";
      while (index < numberOfPentagonalPyramids) {
         output +=  penPyramidList[index] + "\n" + "\n";
         index++;
      }
      return output;
   }
   /**
   *gives a summer for PentagonalPyramid.
   *@return output returns string outuput
   */
   public String summaryInfo() {
      int index = 0;
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      output = "";
      output += "----- Summary for " + listName + " -----"
            + "\nNumber of PentagonalPyramid: " + numberOfPentagonalPyramids 
            + "\nTotal Surface Area: "
            + df.format(totalSurfaceArea()) + "\nTotal Volume: "
            + df.format(totalVolume())
            + "\nAverage Surface Area: " + df.format(averageSurfaceArea())
            + "\nAverage Volume: " + df.format(averageVolume());
     
      
       
      return output;
   }
   
   
   
   
   
   
   
   /**
   *gets list of pps.
   *@return penPyramidList returns list
   */
   public PentagonalPyramid[] getList() {
      return penPyramidList;
   }
   /**
   *reads in file.
   *@param fileNameIn input for fileName
   *@throws FileNotFoundException file not found
   *@return returns pp list
   */
   public PentagonalPyramidList2 readFile(String fileNameIn) 
      throws FileNotFoundException {
      String fileName = fileNameIn;
      int numPP = 0;
      PentagonalPyramid[] myList = new PentagonalPyramid[100]; 
      Scanner scanFile = new Scanner(new File(fileName));
      String pentagonalPyramidListName = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine();
         double baseEdge = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine()); 
         PentagonalPyramid pp = 
            new PentagonalPyramid(label, baseEdge, height);
         myList[numPP] = pp;
         numPP++;
      }
      PentagonalPyramidList2 myPentagonalPyramidList =
         new PentagonalPyramidList2(pentagonalPyramidListName,
          myList, numPP);       
      return myPentagonalPyramidList; 
   }
   /**
   *adds a pp.
   *@param lableIn input for label
   *@param baseEdgeIn input for base edge
   *@param heightIn input for height
   */
   public void addPentagonalPyramid(String lableIn,
      double baseEdgeIn, double heightIn) {
      PentagonalPyramid added =
         new PentagonalPyramid(lableIn, baseEdgeIn, heightIn);
      penPyramidList[numberOfPentagonalPyramids] = added;
      numberOfPentagonalPyramids++;
   }
   /**
   *finds pentagonalPyramid.
   *@param labelIn input for the label of the pp
   *@return returns a pp or null
   */
   public PentagonalPyramid findPentagonalPyramid(String labelIn) {
      for (int i = 0; i < numberOfPentagonalPyramids; i++)
      { 
         if (labelIn.toLowerCase()
            .equals(penPyramidList[i].getLabel().toLowerCase())) {
            return penPyramidList[i];
         }
      }
      return null;
   }
   /**
   *deletes a pentagonalPyramid.
   *@param labelIn input for label of pp
   *@return returns pp
   */
   public PentagonalPyramid deletePentagonalPyramid(String labelIn) {
      PentagonalPyramid deleted = null;
      for (int i = 0; i < numberOfPentagonalPyramids; i++) {
         if (labelIn.toLowerCase()
            .equals(penPyramidList[i].getLabel().toLowerCase())) {
            deleted = penPyramidList[i];
            for (int j = i; j < numberOfPentagonalPyramids - 1; j++) {
               penPyramidList[j] = penPyramidList[j + 1];               
            }
            penPyramidList[numberOfPentagonalPyramids - 1] = null;
            numberOfPentagonalPyramids--;
            break;
         }  
      }
      return deleted;
   }
      /**
   *edits pps.
   *@param labelIn input for a pp
   *@param baseEdgeIn input for baseEdge
   *@param heightIn input for height
   *@return returns true or false if edit takes place
   */
   public boolean editPentagonalPyramid(String labelIn, double baseEdgeIn, 
      double heightIn) {
      for (int i = 0; i < numberOfPentagonalPyramids; i++) {
         if (labelIn.toLowerCase()
            .equals(penPyramidList[i].getLabel().toLowerCase())) {
            penPyramidList[i].setBaseEdge(baseEdgeIn);
            penPyramidList[i].setHeight(heightIn);
            return true;
         }
      }
      return false;
   }        
}