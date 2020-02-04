import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
*@CarsonBarnett-COMP1210-003
*@4/9/19
*/
public class SoftballPlayersPart2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


  /**no cmd line args.
  *@throws IOException a
  */
   @Test public void noCommandLineArgsTest() throws IOException {
      String[] args = {};
      SoftballPlayersPart2.main(args);
      SoftballTeam.resetTeamCount();
   
      Assert.assertEquals("Team count should be 0. ",
         0, SoftballTeam.getTeamCount());
   }
   /**cmd line args.
   *@throws IOException a
   */
   @Test public void commandLineArgsMainTest() throws IOException {
      SoftballTeam.resetTeamCount();
      SoftballPlayersPart2 app = new SoftballPlayersPart2();
   
      String[] args2 = {"softball_player_data1.csv"};
      SoftballPlayersPart2.main(args2);
   
      Assert.assertEquals("Team count should be 1. ",
         1, SoftballTeam.getTeamCount());
   }      
}


