import java.util.ArrayList;
import java.text.DecimalFormat;

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
   
   
         
}