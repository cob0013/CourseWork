import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
// import java.util.Arrays; 


/**
*@CarsonBarnett-COMP1210-003.
*@4/9/19
*/
public class SoftballTeamTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**getters and setters test.*/
   @Test public void gettersAndSettersTest() {
      SoftballTeam team = new SoftballTeam();
      team.setTeamName("Auburn");
      Assert.assertEquals("get name test", "Auburn", team.getTeamName());
      SoftballPlayer[] roster = new SoftballPlayer[20];
      team.setRoster(roster);
      Assert.assertArrayEquals("get roster test", roster, team.getRoster());
      team.setPlayerCount(20);
      Assert.assertEquals("get player Count", 20, team.getPlayerCount());
      String[] excluded = {"excluded1", "excluded2"};
      team.setExcludedRecords(excluded);
      Assert.assertArrayEquals("get excluded records", excluded,
          team.getExcludedRecords());
      team.setExcludedCount(50);
      Assert.assertEquals("get excluded count", 50, team.getExcludedCount());
      team.setIgnoredCount(50);
      Assert.assertEquals("get ignored count", 50, team.getIgnoredCount());
      SoftballTeam.resetTeamCount();
      Assert.assertEquals("get team count", 0, SoftballTeam.getTeamCount());
   }

  /** read large file test.
  *@throws IOException a
  */
   @Test public void readLargeFileTest() throws IOException {
   
      SoftballTeam team = new SoftballTeam();
      team.setPlayerCount(0);
   
      team.readPlayerFile("softball_player_data3.large_team_file.csv");
      Assert.assertTrue("test", team.generateReport().contains("Jodi Doe"));
      Assert.assertTrue("test", team.generateReport().contains("Janie Doe"));
      Assert.assertTrue("test", team.generateReport().contains("Lois Gibson"));
      Assert.assertTrue("test", team.generateReport().contains("Green Lan"));
      Assert.assertFalse("test", team.generateReport().contains("Nola Austin"));
      Assert.assertEquals("get player Count", 24, team.getPlayerCount());
      Assert.assertEquals("get excluded count", 30, team.getExcludedCount());
      Assert.assertEquals("get ignored count", 5, team.getIgnoredCount());
      Assert.assertEquals("rosterread file", 
         team.getRoster()[0].getName(), "Jodi Doe");
   }
   // /**read blank file.
//    *@throws IOException a
//    */
   // @Test (expected = IOException.class) 
   //    public void readFileThatDoesntExist() throws IOException {
      // SoftballTeam team = new SoftballTeam();
      // team.setPlayerCount(0);
      // team.readPlayerFile("blank");
   // 
   // }
         /**generate report test.
         *@throws IOException a
         */
   @Test public void generateReportTest() throws IOException {
      SoftballTeam team = new SoftballTeam();
      team.readPlayerFile(
         "softball_player_data3.large_team_file.csv");
      Assert.assertTrue(team.generateReport().contains(
         "My Biggest Team File")); 
   }
    /**generate report by number test.
    *@throws IOException a
    */
   @Test public void generateReportByNumberTest() throws IOException {
      SoftballTeam team = new SoftballTeam();
      team.readPlayerFile("softball_player_data3.large_team_file.csv");
   
   
      Assert.assertTrue(team.generateReportByNumber().contains("by Number"));
      Assert.assertTrue(team.generateReportByNumber().contains("23"));
   
   }
   /**generate report by name test.
   *@throws IOException a
   */
   @Test public void generateReportByNameTest() throws IOException {
      SoftballTeam team = new SoftballTeam();
      team.readPlayerFile("softball_player_data3.large_team_file.csv");
   
      Assert.assertTrue(team.generateReportByName().contains("by Name"));
      Assert.assertTrue(team.generateReportByName().contains("Jodi Doe"));
   
   }
   /**generate report by rating test.
   *@throws IOException a
   */
   @Test public void generateReportByRatingTest() throws IOException {
      SoftballTeam team = new SoftballTeam();
      team.readPlayerFile("softball_player_data3.large_team_file.csv");
      Assert.assertTrue(team.generateReportByRating().contains("2.915"));
   
      Assert.assertTrue(team.generateReportByRating().contains("Jodi Doe"));
   
   }
   /**generate excluded report test.
   *@throws IOException a
   */
   @Test public void generateExcludedReportTest() throws IOException {
      SoftballTeam team = new SoftballTeam();
      team.readPlayerFile("softball_player_data3.large_team_file.csv");
      Assert.assertTrue(team.generateExcludedRecordsReport().contains(
         "Excluded Records"));
      Assert.assertTrue(team.generateExcludedRecordsReport().contains(
          "Brice Wayne"));
   }
}