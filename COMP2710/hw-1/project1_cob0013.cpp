/* project1_cob0013.cpp
* AUTHOR: Carson Barnett (cob0013@auburn.edu)
*compiled in server with g++ 
*used handout as a template
*/

// update

#include <iostream>
using namespace std;

int main() {
	// variables

   int currentMonth = 0;
   float loanAmount;
   float monthlyPayment;
   float interestRate;
   float interest;
   float monthlyRate;


	// format output
   cout.setf(ios::fixed);
   cout.setf(ios::showpoint);
   cout.precision(2);
	
	// get input and make sure it is valid
   while (true) {
      cout << "Loan Amount: ";
      cin >> loanAmount;
      cout << "Interest Rate (% per year): ";
      cin >> interestRate;
      cout << "Monthly Payments: ";
      cin >> monthlyPayment;
      monthlyRate = interestRate / 12 / 100;
      // checks for illegal input. i.e negative values or infinite interest
     
      if (loanAmount <= 0 || monthlyPayment <= 0 || interestRate <= 0) {
         cout << "Invalid input, inputs must be greaded than 0\n";
         continue;
      }
      if (monthlyRate * loanAmount > monthlyPayment) {
         cout <<"Invalid input, can not cause infinite interest, please try again.\n";
         continue;
      }
      break;
   }

	// Amortization Table

   cout << "********************************************************************************************\n"
       << "\tAmortization Table\n"
       << "*********************************************************************************************\n"
       << "Month\t\tBalance\t\tPayment\t\tRate\t\tInterest\t\tPrincipal" << endl;


   float totalInterest = 0;
   while (loanAmount > 0) {  
      string space = "\t\t";
      // sets header
      if (currentMonth == 0) {
      	// checks formatting
         if (loanAmount >= 1000) {
            space = "\t";
         }
         cout << currentMonth++ <<
            "\t\t$" << loanAmount << space << "N/A\t\tN/A\t\tN/A\t\t\tN/A\n";
      }
      else {
      
         interest = loanAmount * monthlyRate;
         totalInterest += interest;
      
      	// checks to see if payment is too much, to make sure the last payment doensn't overflow
         if (monthlyPayment > loanAmount + interest) {
            monthlyPayment = loanAmount + interest;
         }
         
         loanAmount -= monthlyPayment - interest;
         // checks formatting
         if (loanAmount >= 1000) {
            space = "\t";
         }
         // output for month
         cout << currentMonth++ << "\t\t$" << loanAmount << space <<"$"
             << monthlyPayment << "\t\t" << monthlyRate * 100
             << "\t\t$" << interest << "\t\t\t$" << monthlyPayment - interest
             << endl;
      }
   }
   cout << "*********************************************************************************************\n"
      	<< "It takes " << --currentMonth << " months to pay off the loan.\n"
      	<< "Total interest paid is $" << totalInterest << endl;
   return 0;	
}
