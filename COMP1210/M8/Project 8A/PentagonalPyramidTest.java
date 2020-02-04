import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
*pp test.
*@CarsonBarnett-COMP1210-003
*@3/18/19
*/
public class PentagonalPyramidTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *test of getters.
   */
   @Test public void gettersTest() {
      PentagonalPyramid p = new PentagonalPyramid("test", 1, 2);
      Assert.assertEquals("get label", "test", p.getLabel());
      Assert.assertEquals("get base edge", 1, p.getBaseEdge(), 0.000001);
      Assert.assertEquals("get height", 2, p.getHeight(), 0.000001);
   
   }
/**
*test of setters set.
*/
   @Test public void settersTestTrue() {
      PentagonalPyramid p = new PentagonalPyramid("test", 1, 2);
      Assert.assertTrue(p.setLabel("set"));
      Assert.assertEquals("set label", "set", p.getLabel());
      Assert.assertTrue(p.setBaseEdge(10));
      Assert.assertEquals("set base edge", 10, p.getBaseEdge(), 0.000001);
      Assert.assertTrue(p.setHeight(10));
      Assert.assertEquals("set height", 10, p.getHeight(), 0.00001);
   }
   /**
   *test setters false.
   */
   @Test public void settersTestFalse() {
      PentagonalPyramid p = new PentagonalPyramid("test", 1, 2);
      Assert.assertFalse(p.setLabel(null));
      Assert.assertFalse(p.setBaseEdge(-5));
      Assert.assertFalse(p.setHeight(-5));
   }
/**
*surface area test.
*/
   @Test public void surfaceAreaTest() {
      PentagonalPyramid p = new PentagonalPyramid("test", 1, 2);
      Assert.assertEquals("surface area", 7.008203, p.surfaceArea(), .000001);
   }
   /**
   *test volume.
   */
   @Test public void volumeTest() {
      PentagonalPyramid p = new PentagonalPyramid("test", 1, 2);
      Assert.assertEquals("volume", 1.1469849, p.volume(), .000001);
   }
   /**
   *equals test.
   */
   @Test public void equalsTest() {
   //true
      PentagonalPyramid p1 = new PentagonalPyramid("p1", 1, 2);
      PentagonalPyramid p2 = new PentagonalPyramid("p1", 1, 2);
      Assert.assertEquals("equals test", true, p1.equals(p2));
   //height
      p1 = new PentagonalPyramid("p1", 1, 2);
      p2 = new PentagonalPyramid("p1", 1, 3);
      Assert.assertEquals("false equals height", false, p1.equals(p2));
      //baseEdge
      p1 = new PentagonalPyramid("p1", 1, 2);
      p2 = new PentagonalPyramid("p1", 2, 2);
      Assert.assertEquals("false equals baseEdge", false, p1.equals(p2));
      //label
      p1 = new PentagonalPyramid("p1", 1, 2); 
      p2 = new PentagonalPyramid("p2", 1, 2);
      Assert.assertEquals("false equals label", false, p1.equals(p2));
      Assert.assertEquals("false equals string", false, p1.equals("")); //non pp
   }
   /**
   *is it even a pp.
   */
   
   
   /**
   *tests reset count.
   */
   @Test public void resetCountTest() {
      PentagonalPyramid.resetCount();
      Assert.assertEquals("reset count test", 0, PentagonalPyramid.getCount());
   
   }
   /**
   *tests get count.
   */
   @Test public void getCountTest() {
      PentagonalPyramid.resetCount();
      PentagonalPyramid p1 = new PentagonalPyramid("p1", 2, 4);
      PentagonalPyramid p2 = new PentagonalPyramid("p2", 3, 5);
      PentagonalPyramid p3 = new PentagonalPyramid("p3", 4, 6);
      Assert.assertEquals("get count test", 3, PentagonalPyramid.getCount()); 
   }
   /**
   *test to string.
   */
   @Test public void toStringTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      Assert.assertEquals("to string test", "PentagonalPyramid \"Ex 1\""
         + " with base edge = 1.0 and height = 2.0 units has:\n"
         + "\tsurface area = 7.008203 square units\n" 
         + "\tvolume = 1.1469849 cubic units", pp1.toString()); 
   }
   /**
   *hash code test.
   */
   @Test public void hashCodeTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("p1", 3, 4);
      Assert.assertEquals("hash code", 0, pp1.hashCode());
   }
  
}
