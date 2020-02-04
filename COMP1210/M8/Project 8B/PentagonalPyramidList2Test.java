import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*pentagonal pyramid list test 2.
*@CarsonBarnett-COMP1210-003
*@3/25/19
*/
public class PentagonalPyramidList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
   *test get name.
   */
   @Test public void getNameTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3); 
      Assert.assertEquals("get name test", "listTest", list.getName());
   }
   /**
   *number of pp test.
   */
   @Test public void numberOfPentagonalPyramidsTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list = 
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("npp test", 3, list.numberOfPentagonalPyramids());
   }
   /**
   *total surface area test.
   */
   @Test public void totalSurfaceAreaTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list = 
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("total surface area test", 306175.467,
         list.totalSurfaceArea(), 0.001);
   }
   /**
   *test total volume.
   */
   @Test public void totalVolumeTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("total volume test", 7861815.475,
         list.totalVolume(), .001);
   }
   /**
   *average surface area test.
   */
   @Test public void averageSurfaceAreaTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list = 
          new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("avg sa test", 102058.489,
         list.averageSurfaceArea(), .001);
   }
   /**
   *average volume test.
   */
   @Test public void averageVolumeTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("avg v test", 2620605.158,
         list.averageVolume(), .001);
   }
   /**
   *to string test.
   */
   @Test public void toStringTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      String output = "PentagonalPyramid \"Ex 1\" with base edge"
         + " = 1.0 and height = 2.0 units has:\n"  
         + "\tsurface area = 7.008203 square units\n" 
         + "\tvolume = 1.1469849 cubic units";
      Assert.assertTrue("to string test", list.toString().contains(output));
   }
   /**
   *summary info test.
   */
   @Test public void summaryInfoTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      String output = "Number of PentagonalPyramid: 3\n" 
         + "Total Surface Area: 306,175.467\n" 
         + "Total Volume: 7,861,815.475\n" 
         + "Average Surface Area: 102,058.489\n" 
         + "Average Volume: 2,620,605.158";
      Assert.assertTrue("summary info test", 
         list.summaryInfo().contains(output));
   }
   /**
   *test get list.
   */
   @Test public void getListTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertArrayEquals("get list test", ppArray, list.getList());
   }
   /**
   *tests read file.
   *@throws FileNotFoundException a
   */
   @Test 
    public void readFileTest() throws FileNotFoundException {
      PentagonalPyramid pp1 = new PentagonalPyramid("test1", 5, 5);
      PentagonalPyramid pp2 = new PentagonalPyramid("test2", 5, 5);
      PentagonalPyramid pp3 = new PentagonalPyramid("test3", 5, 5);
      // PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", null, 0);
      list = list.readFile("PentagonalPyramid_data_1.txt");
      Assert.assertEquals("read file test", "PentagonalPyramid Test List",
          list.getName());
   }
   /**
   *test file not found.
   *@throws FileNotFoundException a
   */
   @Test (expected = FileNotFoundException.class)
    public void readFileTestNotFound() throws FileNotFoundException {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = {pp1, pp2, pp3};
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", null, 0);
      list.readFile("asdf");
   }  
   
   
   
   
   
   /**
   *add pp test.
   */
   @Test public void addPentagonalPyramidTest() {
      PentagonalPyramid pp1 = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid pp2 = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      PentagonalPyramid pp3 = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = pp1;
      ppArray[1] = pp2;
      ppArray[2] = pp3;
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      PentagonalPyramid added = new PentagonalPyramid("add test", 7, 7);
      list.addPentagonalPyramid("add test", 7, 7);
      PentagonalPyramid [] updated = list.getList();
      Assert.assertEquals("number++ test", 4,
         list.numberOfPentagonalPyramids());
      Assert.assertEquals("added test", added, updated[3]);
   }
   /**
   *find pentagonalPyramid test true.
   */
   @Test public void findPentagonalPyramidTest() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("find test", 
         ppArray[0], list.findPentagonalPyramid("Ex 1"));
   }
   /**
   *find pp test not found.
   */
   @Test public void findPentagonalPyramidTestNotFoud() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("not found test",
         null, list.findPentagonalPyramid("not in here"));
   }
   /**
   *delete pp false.
   */
   @Test public void deletePentagonalPyramidFalse() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertTrue("deleted false test",
          list.deletePentagonalPyramid("not in list") == null); 
   }
   /**
   *edit pp true.
   */
   @Test public void editPentagonalPyramidTrue() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertTrue("edited", list.editPentagonalPyramid("EX 1", 3, 3));
      Assert.assertEquals("edited", 3, ppArray[0].getBaseEdge(), .000001);
   }
   /**
   *edit pp false.
   */
   @Test public void editPentagonalPyramidFalse() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertFalse("not edited", 
         list.editPentagonalPyramid("not in", 3, 3));
   }
   /**
   *delete pp true.
   */
   @Test public void deletePentagonalPyramidTrue() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      PentagonalPyramid deleted = ppArray[0];
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertTrue("deleted true test",
         list.deletePentagonalPyramid("Ex 1") == deleted);
      Assert.assertEquals("number check", 2, list.numberOfPentagonalPyramids());
   }
   /**
   *pp w smallest base edge test first.
   */
   @Test public void findPentagonalPyramidWithShortestBaseEdgeTestFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("shortest base edge test", ppArray[0],
         list.findPentagonalPyramidWithShortestBaseEdge());
   }
   /**
   *pp w smallest base edge not first.
   */
   @Test public void findPentagonalPyramidWithShortestBaseEdgeTestNotFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 25, 25);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("shortest base edge test", ppArray[1],
         list.findPentagonalPyramidWithShortestBaseEdge());
   }
   /**
   *pp w smallest base edge test null.
   */
   @Test public void findPentagonalPyramidWithShortestBaseEdgeTestNull() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 0);
      Assert.assertTrue("shortest base edge test null",
         list.findPentagonalPyramidWithShortestBaseEdge() == null);
   }
   /**
   *pp w longest base edge test not first.
   */
   @Test public void findPentagonalPyramidWithLongestBaseEdgeTestNotFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("longest base edge test", ppArray[2],
         list.findPentagonalPyramidWithLongestBaseEdge());
   }
   /**
   *pp w longest base edge first.
   */
   @Test public void findPentagonalPyramidWithLongestBaseEdgeFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 500, 5);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("longest base edge test", ppArray[0],
         list.findPentagonalPyramidWithLongestBaseEdge());
   }
  
   /**
   *pp w longest base edge test null.
   */
   @Test public void findPentagonalPyramidWithLongestBaseEdgeTestNull() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 0);
      Assert.assertTrue("longest base edge test null",
         list.findPentagonalPyramidWithLongestBaseEdge() == null);
   }
   /**
   *pp w smallest volume test first.
   */
   @Test public void findPentagonalPyramidWithSmallesttVolumeFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("smallest v", ppArray[0],
         list.findPentagonalPyramidWithSmallestVolume());
   }
   /**
   *pp w smallest volume test not first.
   */
   @Test public void findPentagonalPyramidWithSmallestVolumeNotFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 25, 25);
      ppArray[1] = new PentagonalPyramid("Ex 2", 1, 2);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("smallest v", ppArray[1],
         list.findPentagonalPyramidWithSmallestVolume());
   }
   
   /**
   *pp w smallest volume test null.
   */
   @Test public void findPentagonalPyramidWithSmallestVolumeNull() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 0);
      Assert.assertTrue("ssmallest v null",
         list.findPentagonalPyramidWithSmallestVolume() == null);
   
   }
   /**
   *pp w largest volume test not first.
   */
   @Test public void findPentagonalPyramidWithLargestVolumeNotFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 1, 2);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("shortest base edge test", ppArray[2],
         list.findPentagonalPyramidWithLargestVolume());
   }
   /**
   *pp w largest volume first.
   */
   @Test public void findPentagonalPyramidWithLargestVolumeFirst() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      ppArray[0] = new PentagonalPyramid("Ex 1", 123.4, 900);
      ppArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5);
      ppArray[2] = new PentagonalPyramid("Ex 3", 1, 2);
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 3);
      Assert.assertEquals("largest volume test", ppArray[0],
         list.findPentagonalPyramidWithLargestVolume());
   }
   /**
   *pp w largest volume null.
   */
   @Test public void findPentagonalWithLargestVolumeNull() {
      PentagonalPyramid[] ppArray = new PentagonalPyramid[100];
      PentagonalPyramidList2 list =
         new PentagonalPyramidList2("listTest", ppArray, 0);
      Assert.assertTrue("largest volume test null",
          list.findPentagonalPyramidWithLargestVolume() == null);
   }

}
