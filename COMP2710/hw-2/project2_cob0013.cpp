/* project2_cob0013.cpp
* AUTHOR: Carson Barnett (cob0013@auburn.edu)
*compiled in server with g++ 
*used handout as a template
*/
#include <iostream>
#include <stdlib.h>
#include <assert.h>
#include <ctime>
using namespace std;


//varibles

const int AARON_ACCURACY = 33;
const int BOB_ACCURACY = 50;
const int TOTAL_RUNS = 10000;
bool firstShot = true;
bool BobAlive, CharlieAlive, AaronAlive = true;
int aaronWins1 = 0;
int bobWins1 = 0;
int charlieWins1 = 0;
int aaronWins2 = 0;
int bobWins2 = 0; 
int charlieWins2 = 0;

/*
*Input: A_alive indicates wether Aaron is alive
*	B_alive indicaes wether Bob is alive
*	C_alive indicates wether Charlie is alive
*Return: true if at least two are alive
*	otherwise false
*/
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
   return (A_alive && B_alive) || (B_alive && C_alive) || (A_alive && C_alive) ;
}
/*
 * Call by reference
 * Strategy 1: Everyone shoots to kill the highest accuracy player alive
 * Input: B_alive indicates Bob is alive or dead
 * 	  C_alive indicates Aaron is alive or dead
 *Return: Change B_alive into false if Bob is killed
 *	  Change C_alive into false if Charlie is kiled
 */
void Aaron_shoots1(bool& B_alive, bool& C_alive) {
   int r = rand() % 100;
   if (r <= AARON_ACCURACY && C_alive) {
      C_alive = false;
   }
   else if (r <= AARON_ACCURACY && B_alive) {
      B_alive = false;
   }
}

/*Call by reference 
 * Input: A_alive indicates Aaron is alive or dead
 * 		C_alive indicates Charlie is alive or dead
 * Return: Change A_alive into false if Aaron is killed
 * 	   Change C_alive into false if Charlie is killed
 */
void Bob_shoots(bool& A_alive, bool& C_alive) {
   int r = rand() % 100;
   if (r <= BOB_ACCURACY && C_alive) {
      C_alive = false;
   }
   else if (r <= BOB_ACCURACY && A_alive) {
      A_alive = false;
   }
}
/*
 * Call by reference
 * Input: A_alive indicates Aaron is alive or dead
 * 	  B_alive indicates Bob is alive or dead
 *Return: Change A_alive into false if Aaron is killed
 *	  Change B_alive into false if Bob is killed
 */
void Charlie_shoots(bool& A_alive, bool& B_alive) {
   if (B_alive) {
      B_alive = false;
   }
   else if (A_alive) {
      A_alive = false;
   }
}
/*
 * Call by reference
 * Strategy 2: Aaron intentionally misses if both are alive
 * Input: B_alive indicates Bob is alive or dead
 * 	  C_alive indicates Aaron is alive or dead
 * Return: Change B_alive into false if Bob is killed
 * 	   Change C_alive into false if Charlie is killed
 */
void Aaron_shoots2(bool& B_alive, bool& C_alive) {
   if (firstShot) {
      firstShot = false;
      return;
   }
   int r = rand() % 100;
   if (r <= AARON_ACCURACY && C_alive) {
      C_alive = false;
   }
   
   else if (r <= AARON_ACCURACY && B_alive) {
      B_alive = false;
   }
}

//Simple method to implement pause function in linux
void Press_any_key(void);

//Test Prototypes
void test_at_least_two_alive(void) {
   cout << "Unit Testing 1: Function - at_least_two_alive()\n"
        << "\tCase 1: Aaron alive, Bob alive, Charlie alive\n";	
   assert(true ==  at_least_two_alive(true, true, true));
   cout << "\tCase passed...\n"
        << "\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
   assert(true == at_least_two_alive(false, true, true));
   cout << "\tCase passed...\n"
        << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
   assert(true == at_least_two_alive(true, false, true));
   cout << "\tCase passed...\n"
        << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
   assert(true == at_least_two_alive(true, true, false));
   cout << "\tCase passed...\n"
        << "\tCase 5: Aaron dead, Bob Dead, Charlie Alive\n";
   assert(false == at_least_two_alive(false, false, true));
   cout << "\tCase passed...\n"
        << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
   assert(false == at_least_two_alive(false, true, false));	
   cout << "\tCase passed...\n"
        << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
   assert(false == at_least_two_alive(true, false, false));
   cout << "\tCase passed...\n"
        << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
   assert(false == at_least_two_alive(false, false, false));
   cout << "\tCase passed...\n";
}

void test_Aaron_shoots1(void){
   cout <<"Unit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";
   cout << "\tCase 1: Bob alive, Charlie Alive\n";
   BobAlive = true;
   CharlieAlive = true;
   cout << "\t\tAaron is shooting at Charlie\n";
   Aaron_shoots1(BobAlive, CharlieAlive);
   cout << "\tCase 2: Bob dead, Charlie Alive\n";
   BobAlive = false;
   CharlieAlive = true;
   cout << "\t\tAaron is shooting at Charlie\n";
   Aaron_shoots1(BobAlive, CharlieAlive);
   cout << "\tCase 3: Bob alive, Charlie Dead\n";
   BobAlive = true;
   CharlieAlive = false;
   cout << "\t\tAaron is shooting at Bob\n";
   Aaron_shoots1(BobAlive, CharlieAlive);
}
void test_Bob_shoots(void) {
   cout << "Unit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n"
        << "\tCase 1: Aaron alive, Charlie alive\n"
        << "\t\t Bob is shooting at Charlie\n";
   AaronAlive = true;
   CharlieAlive = true;
   Bob_shoots(AaronAlive, CharlieAlive);
   cout << "\tCase 2: Aaron dead, Charlie alive\n"
        << "\t\tBob is shooting at Charlie\n";
   AaronAlive = false;
   CharlieAlive = true;
   Bob_shoots(AaronAlive, CharlieAlive);
   cout << "\tCase 3: Aaron alive, Charlie dead\n"
        << "\t\t Bob is shotting at Aaron\n";
   AaronAlive = true;
   CharlieAlive = false;
   Bob_shoots(AaronAlive, CharlieAlive);
}
void test_Charlie_shoots(void) {
   cout << "Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n"
             << "\tCase 1: Aaron alive, Bob alive\n"
        << "\t\tCharlie is shooting at Bob\n";
   AaronAlive = true;
   BobAlive = true;
   Charlie_shoots(AaronAlive, BobAlive);
   cout << "\tCase 2: Aaron dead, Bob alive\n"
        << "\t\tCharlie is shooting at Bob\n";
   AaronAlive = false;
   BobAlive = true;
   Charlie_shoots(AaronAlive, BobAlive);
   cout << "\tCase 3: Aaron alive, Bob dead\n"
        << "\t\tCharlie is shooting at Aaron\n";
   AaronAlive = true;
   BobAlive = false;
   Charlie_shoots(AaronAlive, BobAlive);
}
void test_Aaron_shoots2(void) {
   cout << "Unit Testing 5: Funciton Aaron_shoots2(Bob_alive, Charlie_alive)\n"
        << "\tCase 1: Bob alive, Charlie alive\n"
             << "\t\tAaron intentionally misses his first shot\n"
        << "\t\tBoth Bob and Charlie are alive.\n";
   CharlieAlive = true;
   BobAlive = true;
   Aaron_shoots2(BobAlive, CharlieAlive);
   cout << "\tCase 2: Bob dead, Charlie alive\n"
        << "\t\tAaron is shooting at Charlie\n";
   BobAlive = false;
   CharlieAlive = true;
   Aaron_shoots2(BobAlive, CharlieAlive);	
   cout << "\tCase 3: Bob alive, Charlie dead\n"
        << "\t\tAaron is shooting at Bob";
   BobAlive = true;
   CharlieAlive = false;
   Aaron_shoots2(BobAlive, CharlieAlive);

}
//main

int main() {
   cout << "*** Welcome to Carson's Duel Simulator***\n";
   srand(time(0));
   test_at_least_two_alive();
   cout << "Press any key to continue...\n";
   cin.get();
   test_Aaron_shoots1();
   cout << "Press any key to continue...\n";
   cin.get();
   test_Bob_shoots();
   cout << "Press any key to continue...\n";
   cin.get();
   test_Charlie_shoots();
   cout << "Press any key to continue...\n";
   cin.get();
   test_Aaron_shoots2();
   cout << "Press any key to continue...\n";
   cin.get();
   cout << "Ready to test strategy 1 (run 10000 times):\n";
   cout << "Press any key to continue...\n";
   cin.get();
   
   for (int i = 0; i < TOTAL_RUNS; i++) {
      AaronAlive = true;
      CharlieAlive = true;
      BobAlive = true;
      while (at_least_two_alive(AaronAlive, BobAlive, CharlieAlive)) {
         if (AaronAlive) {
            Aaron_shoots1(BobAlive, CharlieAlive);
         }
         if (BobAlive) {
            Bob_shoots(AaronAlive, CharlieAlive);
         }
         if (CharlieAlive) {
            Charlie_shoots(AaronAlive, BobAlive);
         }
      }
      if (AaronAlive) {
         aaronWins1++;
      }
      if (BobAlive) {
         bobWins1++;
      }
      if (CharlieAlive) {
         charlieWins1++;
      }
   }
   cout << "Aaron won " << aaronWins1 << "/10000 duels or " << static_cast<double>(aaronWins1) / TOTAL_RUNS * 100 << "%\n"
       << "Bob won " << bobWins1 << "/10000 duels or " << static_cast<double>(bobWins1) / TOTAL_RUNS * 100 << "%\n"
       << "Charlie won " << charlieWins1 << "/10000 duels or " << static_cast<double>(charlieWins1) / TOTAL_RUNS * 100 << "%\n\n";

   cout << "Ready to test strategy 2 (run 10000 times):\n"
       << "Press any key to continue...\n";
   cin.get();

   for (int i = 0; i < TOTAL_RUNS; i++) {
      AaronAlive = true;
      CharlieAlive = true;
      BobAlive = true;
      firstShot = true;
      while (at_least_two_alive(AaronAlive, BobAlive, CharlieAlive)) {
         if (AaronAlive) {
            Aaron_shoots2(BobAlive, CharlieAlive);
         }
         if (BobAlive) {
            Bob_shoots(AaronAlive, CharlieAlive);
         }
         if (CharlieAlive) {
            Charlie_shoots(AaronAlive, BobAlive);
         }
      }
      if (AaronAlive) {
         aaronWins2++;
      }
      if (BobAlive) {
         bobWins2++;
      }
      if (CharlieAlive) {
         charlieWins2++;
      }
   }

   cout << "Aaron won " << aaronWins2 << "/10000 duels or " << static_cast<double>(aaronWins2) / TOTAL_RUNS * 100 << "%\n"
       << "Bob won " << bobWins2 << "/10000 duels or " << static_cast<double>(bobWins2) / TOTAL_RUNS * 100 << "%\n"
       << "Charlie won " << charlieWins2 << "/10000 duels or " << static_cast<double>(charlieWins2) / TOTAL_RUNS * 100 << "%\n\n";

   if (aaronWins1 > aaronWins2) {
      cout << "Strategy 1 is better than strategy 2.\n";
   }
   else {
      cout << "Strategy 2 is better than strategy 1.\n";
   }
   return 0;
}
