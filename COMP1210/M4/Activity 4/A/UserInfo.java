/**
*create and test userinfo class.
*
*Activity 4A
*@CarsonBarnett-COMP1210-003
*@2/4/19
*/
public class UserInfo {
  /**
*userinfo method.
*@param args command line argument (not used)
*/

//instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;
   

//constructor 
    /**
   *userinfo constructor.
   *@param firstNameIn takes first name of user
   *@param lastNameIn takes last name of user
         */

   public UserInfo(String firstNameIn, String lastNameIn) {
   
   
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
//methods
  /**
*userinfo to string.
*@return returns output
   */
   public String toString() {
   
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      }
       
      return output;
   }
   /**
   *sets location.
  *@param locationIn input for location
   
   */
   public void setLocation(String locationIn) { 
      location = locationIn;
   }
   /**
   *boolean sets age.
   *@param ageIn user input for age
   *@return isSet returns true or false
   */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   /**
   *gets age.
   *@return returns age
   */
   public int getAge() {
      return age;
   }  
   /**
   *gets location.
   *@return location
   */
   public String getLocation() {
      return location;
   }
   /**
   *allows user to log on.
   */
   public void logOff() {
      status = OFFLINE;
   }
   /**
   *allows user to log on.
   */
   public void logOn() {
      status = ONLINE;
   }
}
