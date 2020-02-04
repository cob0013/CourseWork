import java.io.IOException;
/**
*softball players pt 3.
*/
public class SoftballPlayersPart3 {
/**
*main.
*@param args not used
*/
   public static void main(String[] args) {
      try
      {
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
      catch (IOException e)
      {
         System.out.println("Attempted to read file: " + args[0] 
            + " (No such file or directory)");
         System.out.println("Program ending.");
      }
   
   }
}