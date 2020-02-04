import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays; 
import java.text.DecimalFormat;


/**
*softball player.
*Project 10
*@CarsonBarnett-COMP1210-003
*@4/1/19
*/
public class SoftballTeam {
//instance variable
   private String teamName;
   private SoftballPlayer[] roster;
   private int playerCount;
   private String[] excludedRecords;
   private int excludedCount;
   private int ignoredCount;
   private static int teamCount;
   /**max players.*/
   public static final int MAX_PLAYERS = 24;
   /**max excluded.*/
   public static final int MAX_EXCLUDED = 30;
   //constructor
   /**
   *constructor.
   */
   public SoftballTeam() {
      playerCount = 0;
      teamCount = 0;
      excludedCount = 0;
      ignoredCount = 0;
      roster = new SoftballPlayer[24];
      excludedRecords = new String[30];
      teamCount++;
   }
   //methods
   /**
   *gets team name.
   *@return output
   */
   public String getTeamName() {
      return teamName;
   }
   /**
   *sets team name.
   *@param teamNameIn input
   */
   public void setTeamName(String teamNameIn) {
      teamName = teamNameIn;
   }
   /**
   *get roster.
   *@return output
   */
   public SoftballPlayer[] getRoster() {
      return roster;
   }
   /**
   *sets roster.
   *@param rosterIn input
   */
   public void setRoster(SoftballPlayer[] rosterIn) {
      roster = rosterIn;
   }
   /**
   *gets player count.
   *@return output
   */
   public int getPlayerCount() {
      return playerCount;
   }
   /**
   *set player count.
   *@param playerCountIn input
   */
   public void setPlayerCount(int playerCountIn) {
      playerCount = playerCountIn;
   }
   /**
   *get excluded records.
   *@return output
   */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   /**
   *set excludedRecords.
   *@param excludedRecordsIn input
   */
   public void setExcludedRecords(String[] excludedRecordsIn) {
      excludedRecords = excludedRecordsIn;
   }
   /**
   *get excluded count.
   *@return excluded count
   */
   public int getExcludedCount() {
      return excludedCount;
   }
   /**
   *set excludedCount.
   *@param excludedCountIn input
   */
   public void setExcludedCount(int excludedCountIn) {
      excludedCount = excludedCountIn;
   }
   /**
   *get ignored count.
   *@return ignored
   */
   public int getIgnoredCount() {
      return ignoredCount;
   }
   /**
   *set ignored count.
   *@param ignoredCountIn in
   */
   public void setIgnoredCount(int ignoredCountIn) {
      ignoredCount = ignoredCountIn;
   }
   /**
   *get team  count.
   *@return output
   */
   public static int getTeamCount() {
      return teamCount;
   }
   /**
   *reset team count.
   */
   public static void resetTeamCount() {
      teamCount = 0;
   }
   /**
   *reads file.
   *@param fileName input
   *@throws IOException a
   */
   public void readPlayerFile(String fileName) throws IOException {
      Scanner fileReader = new Scanner(new File(fileName));
      teamName = fileReader.nextLine();
      while (fileReader.hasNext()) {
         String player = fileReader.nextLine();
         Scanner lineReader = new Scanner(player);
         try 
         {
            lineReader.useDelimiter(",");
            char category = lineReader.next().charAt(0);
            String number = lineReader.next();
            String name = lineReader.next();
            String position = lineReader.next();
            double specializationFactor = Double.parseDouble(lineReader.next());
            double battingAverage = Double.parseDouble(lineReader.next());
            SoftballPlayer sbPlayer;
            if (playerCount < MAX_PLAYERS) {
               switch (category) {
                  case 'O':
                     double outfielderFieldingAverage = 
                        Double.parseDouble(lineReader.next());
                     sbPlayer = new Outfielder(number, name,
                        position, specializationFactor,
                        battingAverage, outfielderFieldingAverage);
                     roster[playerCount] = sbPlayer;
                     playerCount++;
                  
                     break; 
                  case 'I': 
                     double infielderFieldingAverage = 
                        Double.parseDouble(lineReader.next());
                     sbPlayer = new Infielder(number,
                        name, position, specializationFactor,
                        battingAverage, infielderFieldingAverage);
                     roster[playerCount] = sbPlayer;
                     playerCount++;
                  
                  
                     break; 
                  case 'P': 
                     int wins = Integer.parseInt(lineReader.next());
                     int losses = Integer.parseInt(lineReader.next());
                     double era = Double.parseDouble(lineReader.next());
                     sbPlayer = new Pitcher(number, name, position, 
                        specializationFactor,
                         battingAverage, wins, losses, era);
                     roster[playerCount] = sbPlayer;
                     playerCount++;
                                
                     break;
                  case 'R': 
                     wins = Integer.parseInt(lineReader.next());
                     losses = Integer.parseInt(lineReader.next());
                     era = Double.parseDouble(lineReader.next());
                     int saves = Integer.parseInt(lineReader.next());
                     sbPlayer = new ReliefPitcher(number,
                        name, position, specializationFactor,
                        battingAverage, wins, losses, era, saves);
                     roster[playerCount] = sbPlayer;
                     playerCount++;               
                     break;
                  default: 
                     throw  
                        new InvalidCategoryException(
                        Character.toString(category));
               }  
                     
            }
            else if (excludedCount < MAX_EXCLUDED) {
               excludedRecords[excludedCount] =
                      "Maximum player count of 24 exceeded for: " + player;
               excludedCount++;
            } 
            else {
               ignoredCount++;
            }  
         }
         catch (InvalidCategoryException e)
         {
            String error = e + " in: " + player;
            excludedRecords[excludedCount] = error;
            excludedCount++;
         }
         catch (NumberFormatException e)
         {
            String error = e + " in: " + player;
            excludedRecords[excludedCount] = error;
            excludedCount++;
         }
           
      }
      fileReader.close();
   }
   /**
   *generate report order.
   *@return report
   */
   public String generateReport() {
      String output = "\n---------------------------------------\n"
         + "Team Report for " + teamName
         + "\n---------------------------------------\n\n";
      for (int i = 0; i < playerCount; i++) {
         output += roster[i] + "\n\n";
      }
      return output;
   }
   /**
   *generate report order by number.
   *@return report
   */
   public String generateReportByNumber() {
      SoftballPlayer[] rosterToSort = Arrays.copyOf(roster, playerCount);
      Arrays.sort(rosterToSort);
      String output = "\n---------------------------------------\n"
         + "Team Report for " + teamName + " (by Number)"
         + "\n---------------------------------------\n";
      for (int i = 0; i < playerCount; i++) {
         output += rosterToSort[i].getNumber()
            +  " " + rosterToSort[i].getName() + " "
            + rosterToSort[i].getPosition() + " " 
            + rosterToSort[i].stats() + "\n";
      }
      return output;
   }
   /**
   *generate report order by name.
   *@return report
   */
   public String generateReportByName() {
      SoftballPlayer[] rosterToSort = Arrays.copyOf(roster, playerCount);
      Arrays.sort(rosterToSort, new NameComparator());
      String output = "\n---------------------------------------\n"
         + "Team Report for " + teamName + " (by Name)"
         + "\n---------------------------------------\n";
      for (int i = 0; i < playerCount; i++) {
         output += rosterToSort[i].getNumber()
            +  " " + rosterToSort[i].getName() + " "
            + rosterToSort[i].getPosition() + " " 
            + rosterToSort[i].stats() + "\n";
      }
      return output;
   }
   /**
   *generate report order by rating.
   *@return report
   */
   public String generateReportByRating() {
      DecimalFormat decimalFormat = new DecimalFormat("0.000");
   
      SoftballPlayer[] rosterToSort = Arrays.copyOf(roster, playerCount);
      Arrays.sort(rosterToSort, new RatingComparator());
      String output = "\n---------------------------------------\n"
         + "Team Report for " + teamName + " (by Rating)"
         + "\n---------------------------------------\n";
      for (int i = 0; i < playerCount; i++) {
         output += decimalFormat.format(rosterToSort[i].rating()) + " " 
            + rosterToSort[i].getNumber()
            +  " " + rosterToSort[i].getName() + " "
            + rosterToSort[i].getPosition() + " " 
            + rosterToSort[i].stats() + "\n";
      }
      return output;
   }
   /**
   *generate excluded records report.
   *@return output
   */
   public String generateExcludedRecordsReport() {
      String output = "\n---------------------------------------\n"
         + "Excluded Records Report"
         + "\n---------------------------------------\n";
      for (int i = 0; i < excludedCount; i++) {
         output += excludedRecords[i] + "\n";
      }
      output += "Number of ignored records from file: " + ignoredCount;
      return output;
   }

   
   
   
   
}