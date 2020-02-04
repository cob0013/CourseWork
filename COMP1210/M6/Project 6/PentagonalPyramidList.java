import java.util.ArrayList;
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
public class PentagonalPyramidList {
//instance variables
   private String listName = "";
   private ArrayList<PentagonalPyramid> penPyramidList
      = new ArrayList<PentagonalPyramid>();
    //constructor 
    /**
    *Constructor for pentagonal pyramid list.
    *@param listNameIn user input for list name
    *@param penPyramidListIn user input for Array List Name
    */
   public PentagonalPyramidList(String listNameIn,
      ArrayList<PentagonalPyramid> penPyramidListIn) {
      listName = listNameIn;
      penPyramidList = penPyramidListIn;
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
      return penPyramidList.size();
   }
   /**
   *gives total surface area.
   *@return surfaceAreaTotal returns total surface area
   */
   public double totalSurfaceArea() {
     
      int index = 0;
      double surfaceAreaTotal = 0;
      
      while (index < penPyramidList.size()) {
         PentagonalPyramid surfaceAreaIndividual = penPyramidList.get(index);
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
      while (index < penPyramidList.size()) {
         PentagonalPyramid volumeIndividual = penPyramidList.get(index);
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
      while (index < penPyramidList.size()) {
         PentagonalPyramid surfaceAreaIndividual = penPyramidList.get(index);
         surfaceAreaTotal += surfaceAreaIndividual.surfaceArea();
         index++;
         averageSurfaceArea = surfaceAreaTotal / penPyramidList.size();
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
      while (index < penPyramidList.size()) {
         PentagonalPyramid volumeIndividual = penPyramidList.get(index);
         volumeTotal += volumeIndividual.volume();
         index++; 
         averageVolume = volumeTotal / penPyramidList.size();
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
      while (index < penPyramidList.size()) {
         output +=  penPyramidList.get(index) + "\n" + "\n";
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
            + "\nNumber of PentagonalPyramid: " + penPyramidList.size() 
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
   public ArrayList<PentagonalPyramid> getList() {
      return penPyramidList;
   }
   /**
   *reads in file.
   *@param fileNameIn input for fileName
   *@throws FileNotFoundException file not found
   *@return returns pp list
   */
   public PentagonalPyramidList readFile(String fileNameIn) 
      throws FileNotFoundException {
      String fileName = fileNameIn;
      ArrayList<PentagonalPyramid> myList = new ArrayList<PentagonalPyramid>(); 
      Scanner scanFile = new Scanner(new File(fileName));
      String pentagonalPyramidListName = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine();
         double baseEdge = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine()); 
         PentagonalPyramid pp = 
            new PentagonalPyramid(label, baseEdge, height);
         myList.add(pp);
      }
      PentagonalPyramidList myPentagonalPyramidList =
         new PentagonalPyramidList(pentagonalPyramidListName, myList);       
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
      penPyramidList.add(added);
   }
   /**
   *finds pentagonalPyramid.
   *@param labelIn input for the label of the pp
   *@return returns a pp or null
   */
   public PentagonalPyramid findPentagonalPyramid(String labelIn) {
      for (int i = 0; i < penPyramidList.size(); i++)
      { 
         if (labelIn.toLowerCase()
            .equals(penPyramidList.get(i).getLabel().toLowerCase())) {
            return penPyramidList.get(i);
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
      for (int i = 0; i < penPyramidList.size(); i++) {
         if (labelIn.toLowerCase()
            .equals(penPyramidList.get(i).getLabel().toLowerCase())) {
            PentagonalPyramid pp = penPyramidList.get(i);
            penPyramidList.remove(i);
            return pp;
         }
      }
      return null;
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
      for (int i = 0; i < penPyramidList.size(); i++) {
         if (labelIn.toLowerCase()
            .equals(penPyramidList.get(i).getLabel().toLowerCase())) {
            penPyramidList.get(i).setBaseEdge(baseEdgeIn);
            penPyramidList.get(i).setHeight(heightIn);
            return true;
         }
      }
      return false;
   }        
}