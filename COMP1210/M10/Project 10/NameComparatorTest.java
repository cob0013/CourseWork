import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays; 


/**
*@CarsonBarnett-COMP1210-003.
*@4/9/19
*/
public class NameComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**test name comparator.*/
   @Test public void compareNameComparatorTest() {
      Outfielder f1 = new Outfielder("50", "Carson Robinson", "RF", 8, 6, 5);
      Infielder f2 = new Infielder("23", "Jackie Barnett", "LF", 9, 9, 9);
      SoftballPlayer[] roster = {f1, f2};
      SoftballTeam team = new SoftballTeam();
      team.setRoster(roster);
      team.setPlayerCount(2);
      SoftballPlayer[] rosterToSort = 
         Arrays.copyOf(team.getRoster(), team.getPlayerCount());
      Arrays.sort(rosterToSort, new NameComparator());  
      Assert.assertEquals("name comparator test", f1, rosterToSort[1]);         
   }
   /**test name comparator same last.*/
   @Test public void compareNameComparatorTestSameLast() {
      Outfielder f1 = new Outfielder("50", "Jackie Barnett", "RF", 8, 6, 5);
      Infielder f2 = new Infielder("23", "Carson Barnett", "LF", 9, 9, 9);
      SoftballPlayer[] roster = {f1, f2};
      SoftballTeam team = new SoftballTeam();
      team.setRoster(roster);
      team.setPlayerCount(2);
      SoftballPlayer[] rosterToSort = 
         Arrays.copyOf(team.getRoster(), team.getPlayerCount());
      Arrays.sort(rosterToSort, new NameComparator());  
      Assert.assertEquals("name comparator test", f2, rosterToSort[0]);   
   }
}
