/**
*invalid category exception.
*/
public class InvalidCategoryException extends Exception {
/**
*constructor.
*@param category in
*/
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }


}