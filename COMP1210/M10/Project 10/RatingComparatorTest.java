import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays; 


/**
*@CarsonBarnett-COMP1210-003
*@4/9/19
*/
public class RatingComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** rating comparator. **/
   /**test name comparator.*/
   @Test public void ratingComparatorTest() {
      Outfielder f4 = new Outfielder("50", "Carson Robinson", "RF", 10, 10, 10);
   
      Outfielder f1 = new Outfielder("50", "Carson Robinson", "RF", 9, 9, 9);
      Infielder f2 = new Infielder("23", "Jackie Barnett", "LF", 7, 7, 7);
      Infielder f3 = new Infielder("40", "Jackie Robinson", "LF", 8, 8, 8);
      Outfielder f5 = new Outfielder("50", "adsfas asdf", "RF", 9, 9, 9);
      SoftballPlayer[] roster = {f4, f1, f2, f3, f5};
      SoftballTeam team = new SoftballTeam();
      team.setRoster(roster);
      team.setPlayerCount(5);
      SoftballPlayer[] rosterToSort
          = Arrays.copyOf(team.getRoster(), team.getPlayerCount());
      Arrays.sort(rosterToSort, new RatingComparator());  
      Assert.assertEquals("name comparator test", f1, rosterToSort[1]);   
      Assert.assertEquals("name comparator test", f2, rosterToSort[4]); 
      Assert.assertEquals("name comparator test", f3, rosterToSort[3]);    
      Assert.assertEquals("name comparator test", f5, rosterToSort[2]);
      Assert.assertEquals("name comparator test", f4, rosterToSort[0]);         
         
     
        
      
   }
}
