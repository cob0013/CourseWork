import java.io.IOException;

/**
*softballplayerspart2.
*project 10
*@CarsonBarnett-COMP1210-003
*@4/9/19
*/
public class SoftballPlayersPart2 {
/**
*main.
*@param args not used
*@throws IOException a
*/
   public static void main(String[] args) throws IOException {
      
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else {
         SoftballTeam team = new SoftballTeam();
         team.readPlayerFile(args[0]);
         System.out.print(team.generateReport());
         System.out.print(team.generateReportByNumber());
         System.out.print(team.generateReportByName());
         System.out.print(team.generateReportByRating());
         System.out.print(team.generateExcludedRecordsReport());
      }
   }
}