
import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
*@CarsonBarnett-COMP1210-003
*@4/3/19
*/
public class ReliefPitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**get saves test.*/
   @Test public void getSaves() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals("get saves test", 17, p4.getSaves());
   }
         /**set saves test.*/
   @Test public void setSaves() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      p4.setSaves(6);
      Assert.assertEquals("set saves test", 6, p4.getSaves());
   }
   /**rating test.*/
   @Test public void rating() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals("rating test", 2.474, p4.rating(), .001);
   }
   /**stats test.*/
   @Test public void statsTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
         2.0, .125, 5, 4, 3.85, 17);
      Assert.assertTrue("stats test",
          p4.stats().contains("4 losses, 17 saves"));
   }
         

  
}
