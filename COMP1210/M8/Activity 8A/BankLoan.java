/**
*bank loan program.
*
*Activity 8A
*@CarsonBarnett-COMP1210-003
*@3/18/19
*/
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int   loansCreated = 0;
/**
*bank loan constructor.
*@param customerNameIn input for custromer name
*@param interestRateIn input for interest rate
*/
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
   *checks if amount is valid.
   *@param amount amount tested
   *@return true or false
   */
   public static boolean isAmountValid(double amount) {
      return amount >= 0;
   }
   /**
   *checks in debt.
   *@return true or false
   *@param loan input for loan
   */
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }
/**
*borrows from bank.
*@return true or false
*@param amount amount 
*/
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }
/**
*pays bank.
*@return amount 
*@param amountPaid paid amount
*/
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   /**
   *gets balance.
   *@return returns balance
   */
   
   public double getBalance() {
      return balance;
   }
   /**
   *sets interest rate.
   *@return returns true or false
   *@param interestRateIn input for interest rate
   */
   
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   /**
   *gets interest rate.
   *@return returns interest rate
   */
   public double getInterestRate() {
      return interestRate;
   }
   /**
   *charges interest.
   */
   
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   /**
   *acceses loans created.
   *@return loans created
   */
   public static int getLoansCreated() {
      return loansCreated;
   }
   
   /**
   *resets loans created.
   */
   public static void resetLoansCreated() {
      loansCreated = 0; 
   }
   /**
   *to string.
   *@return output
   */
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }

}
