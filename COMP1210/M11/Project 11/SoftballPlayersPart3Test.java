import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;


/**
*@CarsonBarnett
*@4/15/19
*/
public class SoftballPlayersPart3Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


/**no cmd line args.
  *@throws IOException a
  */
   @Test public void noCommandLineArgsTest()  {
      String[] args = {};
      SoftballPlayersPart3.main(args);
      SoftballTeam.resetTeamCount();
   
      Assert.assertEquals("Team count should be 0. ",
         0, SoftballTeam.getTeamCount());
   }
   /**cmd line args.
   *@throws IOException a
   */
   @Test public void commandLineArgsMainTest() {
      SoftballTeam.resetTeamCount();
      SoftballPlayersPart3 app = new SoftballPlayersPart3();
   
      String[] args2 = {"softball_player_data1.csv"};
      SoftballPlayersPart3.main(args2);
   
      Assert.assertEquals("Team count should be 1. ",
         1, SoftballTeam.getTeamCount());
   }  
}
