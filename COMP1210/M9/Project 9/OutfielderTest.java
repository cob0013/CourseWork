import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*@CarsonBarnett-COMP1210-003
*@4/1/19
*/
public class OutfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**get number.*/
   @Test public void getNumberTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals("get number test", "32", p1.getNumber());
   }
   /**set number.*/
   @Test public void setNumberTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      p1.setNumber("44");
      Assert.assertEquals("set number test", "44", p1.getNumber());
   }
   /**getters test for sp.*/
   @Test public void gettersTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals("get position test", "RF", p1.getPosition());
      Assert.assertEquals("get ba test", .375, p1.getBattingAvg(), .00001);
      Assert.assertEquals("get specializaton factor",
          1, p1.getSpecializationFactor(), .0001);
      SoftballPlayer.resetCount();
      Assert.assertEquals("get count", 0, SoftballPlayer.getCount());
      Assert.assertEquals("get name", "Pat Jones", p1.getName());
   }
   /**setters test sp.*/
   @Test public void settersTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      p1.setPosition("LF");
      p1.setBattingAvg(.459);
      p1.setSpecializationFactor(4);
      SoftballPlayer.resetCount();
      p1.setName("Rick Ross");
      Assert.assertEquals("get position test", "LF", p1.getPosition());
      Assert.assertEquals("get ba test", .459, p1.getBattingAvg(), .00001);
      Assert.assertEquals("get specializaton factor",
          4, p1.getSpecializationFactor(), .0001);
      Assert.assertEquals("get count", 0, SoftballPlayer.getCount());
      Assert.assertEquals("name", "Rick Ross", p1.getName());
   }
   /**to string test.*/
   @Test public void toStringTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertTrue("to string test",
          p1.toString().contains("32 Pat Jones"));
   }
   /**stats test starting w 0 batting avg.*/
   @Test public void statsTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals("stats test", ".375", p1.stats());
   }
   /**stats test starting nonzero.*/
   @Test public void statsTestNonZeroBa() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, 2.77, .950);
      Assert.assertEquals("stats test", "2.770", p1.stats());
   
   
   }
   /**test fieldingavg.*/
   @Test public void getOutfielderFieldingAvgTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals("get fa test", 
         .950, p1.getOutfielderFieldingAvg(), .0001);
   }
   /**set oa test.*/
   @Test public void setOutFielderFieldingAvgTest() {
      Outfielder p1 = new Outfielder("32",
          "Pat Jones", "RF", 1.0, .375, .950);
      p1.setOutfielderFieldingAvg(412);
      Assert.assertEquals("set fa test", 412,
          p1.getOutfielderFieldingAvg(), .0001);
   }
   /**rating test.*/
   @Test public void ratingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals("rating test", 3.5625, p1.rating(), .00001);
   }
   

   
}
