/*
 *Carson Barnett (cob0013)
 *Project 4
 *project4_cob0013.cpp
 *used project 4 breifing vidoe
 *compiled w g++ in AU Server
 */


//imports
#include <iostream>
#include <string>
#include <sstream>


using namespace std;


//USE ME FOR TESTING CONTROL
//#define UNIT_TESTING

//triva node structure
struct trivia_node {
    string question;
    string answer;
    int point;
    trivia_node *next;
};

//pointer to trivia node
typedef trivia_node* ptr_node;


//functions
void init_question_list(ptr_node&);
void add_question(ptr_node&);
int ask_question(ptr_node, int);
void Unit_Test();
int size_of_question_list(ptr_node);



int main() {
    
#ifdef UNIT_TESTING
        cout << "***This is a debugging version ***\n";
        Unit_Test();
        cout << "*** End of the Debugging Version ***";
        
#else 
        ptr_node node_list = new trivia_node;
        init_question_list(node_list);
        cout << "*** Welcome to Carson's trivia quiz ***\n";
        string add = "Yes";
        while (add.compare("Yes") == 0) {
            add_question(node_list);
            cout << "Continue? (Yes/No): ";
            getline(cin.ignore(), add);

        }
        cout << endl;
        ask_question(node_list, size_of_question_list(node_list));

        cout << "*** Thank you for playing the trivia quiz game. Goodbye! ***\n";
#endif
    return 0;
}


void init_question_list(ptr_node& q_list) {
    ptr_node q1 = new trivia_node;
    ptr_node q2 = new trivia_node;
    ptr_node q3 = new trivia_node;

    q1->question = "How long was the shortest war on record?";
    q1->answer = "38";
    q1->point = 100;
    q1->next = q2;
    
    q2->question = "What was the Bank of America's original name? "
            "(Hint: Bank of Italy or Bank of Germany)?";
    q2->answer = "Bank of Italy";
    q2->point = 50;
    q2->next = q3;
    
    q3->question = "What is the best-selling video game of all time?"
           " (Hint: Call of Duty or Wii Sports)?";
    q3->answer = "Wii Sports";
    q3->point = 20;
    q3->next = NULL;

    q_list = q1;

}

void add_question(ptr_node& q_list) {
    ptr_node temp = new trivia_node;
    cout << "Enter a question: ";
    getline(cin, temp->question);
    cout << "Enter an answer: ";
    getline(cin, temp->answer);
    cout << "Enter award points: ";
    cin >> temp->point;
    temp->next = q_list;
    q_list = temp;
}

int ask_question(ptr_node q_list, int num_ask) {
        string user_answer;
        ptr_node curr = q_list;
        int num_of_questions = size_of_question_list(q_list);
        int total = 0;
    if (q_list == NULL) {
        return 0;
    }
    if (num_ask < 1) {
        cout << "Warning - the number of trivia to be asked must be equal to "
                "or be larger than 1.\n";
    }
    else if (num_of_questions < num_ask) {
            cout << "Warning - There is only " << num_of_questions << " trivia "
                    "in the list.\n";
                
    }
    else {
        for (int i = 0; i < num_ask; i++) {
            cout << "Question: " << curr->question << endl;
            cout << "Answer: ";
            getline(cin, user_answer);
            if (user_answer.compare(curr->answer) == 0) {
                cout << "Your answer is correct! You receive " << curr->point
                       << " points.\n";
                total += curr-> point;
            }
            else {
                cout << "Your answer is wrong. The correct answer is "
                        << curr->answer << endl;
            }
            cout << "Your Total points: " << total << endl;
            curr = curr->next;
            cout << endl;
        }
    }
    return 0;
}


//rturns size of linked list rather than keeping global variable
int size_of_question_list(ptr_node q_list) {
    int size = 0;
    ptr_node curr = q_list;
    while (curr != NULL) {
        size++;
        curr = curr->next;
    }
    return size;
}


void Unit_Test() {
    ptr_node node_list = new trivia_node;
    init_question_list(node_list);
    cout << "Unit Test Case 1: Ask no question. The program should give "
            "a warning message.\n";
    ask_question(node_list, 0);
    cout << "Case 1 Passed\n\n";
    cout << "Unit Test Case 2.1: Ask 1 question in the linked list."
            " The tester enters an incorrect answer.\n";
    ask_question(node_list, 1);
    
    cout << "Case 2.1 passed\n\n";
    cout << "Unit Test Case 2.2: Ask 1 question in the linked list. "
            "The tester enters the correct answer.\n";
    ask_question(node_list, 1);
    cout << "Case 2.2 passed\n\n";
    cout << "Unit Test Case 3: Ask all the questions of the last trivia "
            "in the linked list.\n";
    ask_question(node_list, 3);
    cout << "Case 3 passed\n\n";
    cout << "Unit Test Case 4: Ask 5 questions in the linked list.\n";
    ask_question(node_list, 5);
    cout << "Case 4 passed\n\n";
}

