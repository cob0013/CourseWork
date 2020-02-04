#include <iostream>
using namespace std;


/*
*Input: A_alive indicates wether Aaron is alive
*	B_alive indicaes wether Bob is alive
*	C_alive indicates wether Charlie is alive
*Return: true if at least two are alive
*	otherwise false
*/
 bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
 	return false;
 }
/*
 * Call by reference
 * Strategy 1: Everyone shoots to kill the highest accuracy player alive
 * Input: B_alive indicates Bob is alive or dead
 * 	  C_alive indicates Aaron is alive or dead
 *Return: Change B_alive into false if Bob is killed
 *	  Change C_alive into false if Charlie is kiled
 */
void Aaron_shoots(bool& B_alive, bool& C_alive) {

}
/*Call by reference 
 * Input: A_alive indicates Aaron is alive or dead
 * 		C_alive indicates Charlie is alive or dead
 * Return: Change A_alive into false if Aaron is killed
 * 	   Change C_alive into false if Charlie is killed
 */
void Bob_shoots(bool& A_alive, bool& C_alive) {
}
/*
 * Call by reference
 * Input: A_alive indicates Aaron is alive or dead
 * 	  B_alive indicates Bob is alive or dead
 *Return: Change A_alive into false if Aaron is killed
 *	  Change B_alive into false if Bob is killed
 */
void Charlie_shoots(bool& A_alive, bool& B_alive) {

}
/*
 * Call by reference
 * Strategy 2: Aaron intentionally misses if both are alive
 * Input: B_alive indicates Bob is alive or dead
 * 	  C_alive indicates Aaron is alive or dead
 * Return: Change B_alive into false if Bob is kille
 * 	   Change C_alive into false if Charlie is killed
 */
void Aaron_shoots2(bool& B_alive, bool& C_alive) {

}

//Simple method to implement pause function in linux
void Press_any_key(void);

//Test Prototypes
void test_at_least_two_alive(void);
void test_Aaron_shots1(void);
void test_Bob_shoots(void);
void test_Charlie_shoots(void);
void test_Aaron_shoots2(void);

//VARIABLES
int main() {
    return 0;
}
