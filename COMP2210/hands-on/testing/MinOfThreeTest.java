import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   @Test public void min1Test1() {
      int actual = MinOfThree.min1(1,2,3);
      int expected = 1;
      Assert.assertEquals("Test 1", actual, expected);
   }
   
   @Test public void min1Test2() {
      int actual = MinOfThree.min1(2,1,3);
      int expected = 1;
      Assert.assertEquals("Test 2", actual, expected);
   }
   
   @Test public void min1Test3() {
      int actual = MinOfThree.min1(2,3,1);
      int expected = 1;
      Assert.assertEquals("Test 2", actual, expected);
   }
   @Test public void min1Test4() {
      int actual = MinOfThree.min1(1,1,2);
      int expected = 1;
      Assert.assertEquals("Test 2", actual, expected);
   }
   
   @Test public void min2Test1() {
      int actual = MinOfThree.min2(1,2,3);
      int expected = 1;
      Assert.assertEquals("Test 1", actual, expected);
   }
   
   @Test public void min2Test2() {
      int actual = MinOfThree.min2(2,1,3);
      int expected = 1;
      Assert.assertEquals("Test 2", actual, expected);
   }
   
   @Test public void min2Test3() {
      int actual = MinOfThree.min2(2,3,1);
      int expected = 1;
      Assert.assertEquals("Test 2", actual, expected);
   }
}
