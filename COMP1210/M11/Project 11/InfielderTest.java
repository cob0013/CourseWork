import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*@CarsonBarnett-COMP1210-003
*@4/2/19
*/
public class InfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *get inf avg test.
   */
   @Test public void getInfielderFieldingAvgTest() {
      Infielder p2 = new Infielder("23",
         "Jackie Smith", "3B", 1.25, .275, .850);
      Assert.assertEquals("get in avg test",
         .850, p2.getInfielderFieldingAvg(), .0001);
   }
   /**
   *set infavg test.
   */
   @Test public void setInfielderFieldingAvgTest() {
      Infielder p2 = new Infielder("23",
         "Jackie Smith", "3B", 1.25, .275, .850);
      p2.setInfielderFieldingAvg(50);
      Assert.assertEquals("get in avg test",
         50, p2.getInfielderFieldingAvg(), .0001); 
   }
   /**
   *rating test.
   */
   @Test public void ratingTest() {
      Infielder p2 = new Infielder("23",
         "Jackie Smith", "3B", 1.25, .275, .850);
      Assert.assertEquals("rating test", 2.922, p2.rating(), .001);
   
   }


  
}
