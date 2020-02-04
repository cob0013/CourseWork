import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*@CarsonBarnett-COMP1210-003
*@4/2/19
*/
public class PitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**
*getters test.
*/
   @Test public void gettersTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams",
          "RHP", 2.0, .125, 22, 4, 2.85);
      Assert.assertEquals("get wins test", 22, p3.getWins());
      Assert.assertEquals("get losses test", 4, p3.getLosses());
      Assert.assertEquals("get era test", 2.85, p3.getEra(), .0001);
   }
   /**
   *setters test.
   */
   @Test public void settersTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP",
          2.0, .125, 22, 4, 2.85);
      p3.setWins(8);
      p3.setLosses(8);
      p3.setEra(8);
      Assert.assertEquals("get wins test", 8, p3.getWins());
      Assert.assertEquals("get losses test", 8, p3.getLosses());
      Assert.assertEquals("get era test", 8, p3.getEra(), .0001);
   }
   /**
   *stats.
   */
   @Test public void statsTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP",
          2.0, .125, 22, 4, 2.85);
      Assert.assertTrue("stats test", p3.stats().contains("wins, "));
   }
   /**
   *ratings test.
   */
   @Test public void ratingsTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP",
          2.0, .125, 22, 4, 2.85);
      Assert.assertEquals("rating test", 3.740, p3.rating(), .001);
   
   }

}

