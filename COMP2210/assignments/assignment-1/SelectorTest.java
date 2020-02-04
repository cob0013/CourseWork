import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** kmintest **/
   @Test public void kMinTestBaseCase() {
      int [] a = { 2, 8, 7, 3, 4};
      Assert.assertEquals("Test1", Selector.kmin(a, 1), 2);
      int [] b = {2, 8, 8, 7, 3, 3, 4};
      Assert.assertEquals("Test2", Selector.kmin(b, 3), 4);
      int[] c = {5, 9, 1, 7, 3};
      Assert.assertEquals("Test3", Selector.kmin(c, 3), 5);
      int[] d = {8, 7, 6, 5, 4};
      Assert.assertEquals("Test4", Selector.kmin(d, 5), 8);
      int[] e = {1, 1, 1};
   //    Assert.assertEquals("Test5", Selector.kmin(e,2),
   }
   @Test (expected = IllegalArgumentException.class) public void ksIllegalCases() {
      int[] a = null;
      Selector.kmin(a, 1);
      int[] b = {1, 1, 1, 1};
      Selector.kmax(b, 7);
      Selector.kmax(a, 7);
   }
   
   @Test public void kMaxTestBaseCases() {
      int [] a = { 2, 8, 7, 3, 4};
      Assert.assertEquals("Test1", Selector.kmax(a, 1), 8);
      int [] b = {2, 8, 8, 7, 3, 3, 4};
      Assert.assertEquals("Test2", Selector.kmax(b, 3), 4);
      int[] c = {5, 9, 1, 7, 3};
      Assert.assertEquals("Test3", Selector.kmax(c, 3), 5);
      int[] d = {8, 7, 6, 5, 4};
      Assert.assertEquals("Test4", Selector.kmax(d, 5), 4);
   }
   
   @Test public void rangeTestBaseCases() {
      int [] a = { 2, 8, 7, 3, 4};
      int[] outputA = {2, 3, 4};
      int[] b = {5, 9, 1, 7, 3};
      int[] outputB = {3, 5};
      // Arrays.sort(outputB);
      int[] c = {8, 7, 6, 5, 4};
      int[] outputC = {8, 7, 6, 5, 4};
      // Arrays.sort(outputC);
      int[] d = {2, 8, 8, 7, 3, 3, 4};
      int[] outputD = {7, 3, 3, 4};
      // Arrays.sort(outputD);
      Assert.assertArrayEquals("Test1", Selector.range(a, 1, 5), outputA);
      // Assert.assertArrayEquals(Arrays.sort(Selector.range(b, 3, 5)), Arrays.sort(outputB))
   
   }
   @Test public void ceilingTestBase() {
      int [] a = { 2147483647, 2147483647, 2147483647, 2147483647};
      int[] b = {5, 9, 1, 7, 3};
      int[] c = {8, 7, 6, 5, 4};
      int[] d = {2, 8, 8, 7, 3, 3, 4};
      Assert.assertEquals(2147483647, Selector.ceiling(a, 2147483647));
      Assert.assertEquals(7, Selector.ceiling(b, 7));
      Assert.assertEquals(4, Selector.ceiling(c, 0));
      Assert.assertEquals(7, Selector.ceiling(d, 7));
   
   }
   @Test public void floorTestBase() {
      int[] a = {2 , 8, 7, 3, 4};
      int[] b = {5, 9, 1, 7, 3};
      int[] c = {8, 7, 6, 5, 4};
      int[] d = { 8, 8, 7, 3, 3, 4};
      Assert.assertEquals(4, Selector.floor(a, 6));
      Assert.assertEquals(1, Selector.floor(b, 1));
      Assert.assertEquals(8, Selector.floor(c, 9));
      Assert.assertEquals(4, Selector.floor(d, 5));
   
   }
   
}
