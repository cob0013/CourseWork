/**
*relief pitcher.
*project 9
*@CarsonBarnett-COMP1210-003
*@4/3/19
*/
public class ReliefPitcher extends Pitcher {
   private int saves;
   
   /**
   *constructor.
   *@param numberIn input
   *@param nameIn input
   *@param positionIn input
   *@param specializationFactorIn input
   *@param battingAvgIn input
   *@param winsIn input
   *@param lossesIn input
   *@param eraIn input
   *@param savesIn input
   */
   public ReliefPitcher(String numberIn, String nameIn, String positionIn,
          double specializationFactorIn, double battingAvgIn,
        int winsIn, int lossesIn, double eraIn, int savesIn) {
      super(numberIn, nameIn, positionIn, specializationFactorIn, battingAvgIn,
         winsIn, lossesIn, eraIn);
      saves = savesIn;
   }
   /**
   *get saves.
   *@return saves
   */
   public int getSaves() {
      return saves;
   }
   /**
   *set saves.
   *@param savesIn input
   */
   public void setSaves(int savesIn) {
      saves = savesIn;
   }
   /**
   *rating.
   *@return rating
   */
   public double rating() {
      double output = BASE_RATING * specializationFactor
         * (1 / (1 + era)) * ((wins - losses + saves) / 30.0);
      return output;
   }
   /**
   *stats.
   *@return stats
   */
   public String stats() {
      String output = wins + " wins, " + losses + " losses, " 
         + saves + " saves, " + era + " ERA";
      return output;
   }
   
   
  


}