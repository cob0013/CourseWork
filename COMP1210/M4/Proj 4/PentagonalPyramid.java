import java.text.DecimalFormat;
/**
*defines PentagonalPyramid objects.
*
*Project 4
*@CarsonBarnett-COMP1210-003
*@2/4/19
*/
public class PentagonalPyramid {
//instance variables
   private String label = " ";
   private double baseEdge = 0;
   private double height = 0;
//contstructor
/**
*pentagonal pyramid constructor.
*@param labelIn user input for label
*@param baseEdgeIn user input for baseEdge
*@param heightIn user input for height
*/
   public PentagonalPyramid(String labelIn, double baseEdgeIn,
      double heightIn) {
      setLabel(labelIn);
      setBaseEdge(baseEdgeIn);
      setHeight(heightIn);
      
   }

//methods
/**
*gets label.
*@return label returns label
*/
   public String getLabel() {
      return label;
   }
   /**
   *sets label.
   *@param labelIn userinput for label
   *@return isSet returns if it is set or not
   */
   public boolean setLabel(String labelIn) {
      boolean isSet = false;
      if (labelIn == null) {
         isSet = false; }
      else {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
      
      
   }
   /**
   *gets base edge.
   *@return returns baseEdgeIn
   */
   public double getBaseEdge() {
      return baseEdge;
   }
   /**
   *sets base edge.
   *@param baseEdgeIn user input for base edge
   *@return returns isSet true or false
   */
   public boolean setBaseEdge(double baseEdgeIn) {
      boolean isSet = false;
      if (baseEdgeIn > 0) {
         baseEdge = baseEdgeIn;
         isSet = true;
      }
      else {
         isSet = false;
      }
      return isSet;
   } 
   /**
   *gets height value.
   *@return returns heihgt
   */
   public double getHeight() {
      return height; }
     /**
     *sets height value.
     *@param heightIn user input for height
     *@return returns if height is set or not
     */
   public boolean setHeight(double heightIn) {
      boolean isSet = false;
      if (heightIn > 0) {
         height = heightIn;
         isSet = true;
      }
      else {
         isSet = false;
      }
      return isSet;
     
   }
   /**
   *calculates surface area.
   *@return returns surfaceArea
   */
   public double surfaceArea() {
      double surfaceArea = ((5.0 / 4.0) * Math.tan(Math.toRadians(54))
         * Math.pow(baseEdge, 2.0))
         + ((5.0 * baseEdge / 2.0) * Math.sqrt(Math.pow(height, 2.0) 
         + Math.pow(((baseEdge * Math.tan(Math.toRadians(54))) / 2.0), 2.0)));
      
      return surfaceArea;
      
   }
   /**
   *calculates volume.
   *@return returns calculated volume
   */
   public double volume() {
      double volume = (5.0 / 12.0) * Math.tan(Math.toRadians(54)) 
         * height * (Math.pow(baseEdge, 2));
      return volume;
   }
   /**
   *string to string.
   *@return returns output
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0######");
      String output = "PentagonalPyramid \"" 
         + label + "\" with base edge = " + baseEdge + " and height = " 
         + height + " units has:\n\tsurface area = " + df.format(surfaceArea())
         + " square units\n\tvolume = " + df.format(volume()) + " cubic units";
      return output; }
}