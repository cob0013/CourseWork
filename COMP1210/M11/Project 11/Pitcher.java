/**
*pitcher.
*project 9
*@CarsonBarnett-COMP1210-003
*@3/31/19
*/
public class Pitcher extends SoftballPlayer {
   protected int wins;
   protected int losses;
   protected double era;
/**
*constructor.
*@param numberIn input
*@param nameIn input
*@param positionIn input
*@param specializationFactorIn input
*@param battingAverageIn input
*@param winsIn input
*@param lossesIn input
*@param eraIn input
*/
   public Pitcher(String numberIn, String nameIn, String positionIn,
          double specializationFactorIn, double battingAverageIn,
        int winsIn, int lossesIn, double eraIn) {
      super(numberIn, nameIn, positionIn,
          specializationFactorIn, battingAverageIn);
      wins = winsIn;
      losses = lossesIn;
      era = eraIn;
   }   
   /**
   *gets wins.
   *@return wins
   */
   public int getWins() {
      return wins;
   }
   /**
   *sets wins.
   *@param winsIn input
   */
   public void setWins(int winsIn) {
      wins = winsIn;
   }
   /**
   *gets losses.
   *@return losses
   */
   public int getLosses() {
      return losses;
   }
   /**
   *sets losses.
   *@param lossesIn input
   */
   public void setLosses(int lossesIn) {
      losses = lossesIn;
   }
   /**
   *gets era.
   *@return era
   */
   public double getEra() {
      return era;
   }
   /**
   *sets era.
   *@param eraIn input
   */
   public void setEra(double eraIn) {
      era = eraIn;
   }
   /**
   *stats.
   *@return stats
   */
   
   public String stats() {
      String output = wins + " wins, " + losses + " losses, " + era + " ERA";
      return output;
   }
   /**
   *rating.
   *@return rating
   */
   public double rating() {
      double x = 1 / (1 + era);
      double y = (wins - losses) / 25.0;
      return BASE_RATING * specializationFactor * x * y;
   }
}