/* project3_cob0013.cpp
* AUTHOR: Carson Barnett (cob0013@auburn.edu)
*compiled in server with g++ 
*used handout as a template, along with google for syntax questions with vectors
*/

#include <iostream>
#include <fstream>
#include <vector>
using namespace std;


const int MAX_SIZE = 100;

//funcions decleration
bool check_file(string);

vector<int> read_file(string);

void write_file(string, vector<int>);

vector<int> merge(vector<int>, vector<int>);

void to_string(string, vector<int>);

// main method

int main() {
	string file1;
	string file2;
	string file3;
	vector<int> numbers1;
	vector<int> numbers2;
	vector<int> numbers3;
	
	cout << "***Welcome to Carson's sorting program***\n";
	

	// gets file name for file1
	do {
		cout << "Enter the first input file name: ";
		cin >> file1;
	} while (cin.fail() || !check_file(file1));
	

	numbers1 = read_file(file1);
	to_string(file1, numbers1);	
	cout << endl;

	// file name for file 2
	do {
		cout << "Enter the second input file name: ";
		cin >> file2;
	} while (cin.fail() || !check_file(file2));

	numbers2 = read_file(file2);
	to_string(file2, numbers2);
	numbers3 = merge(numbers1, numbers2);	
	cout << "The sorted list of " << numbers3.size() << " is: ";

	for (auto i = numbers3.begin(); i != numbers3.end(); ++i) {
		    cout << *i << ' ';
	}

	cout << endl;

	do {
		cout << "Enter the output file name: ";
		cin >> file3;
	} while (cin.fail());

	write_file(file3, numbers3);
	cout << "***Please check the new file -" << file3 << "***\n"
	"*** Goodbye.***\n";	

	return 1;
}

bool check_file(string file) {
	ifstream stream;
        stream.open(file.c_str());   
	if (stream.fail()) {
		stream.close();		
		return false; 
	}
	stream.close();
	return true;
}

vector<int> read_file(string file) {
	ifstream stream;
	vector<int> v;
	int i;

	stream.open(file.c_str());
	while (stream >> i) {
		v.push_back(i);
	}
	stream.close();
	return v;
}

void write_file(string file, vector<int> v) {
	ofstream fileout(file);
	for (const auto &p: v) {
		fileout << p << endl;
	}
	
	fileout.close();
}


vector<int> merge(vector<int> v1, vector<int> v2) {
	vector<int> mergedVector;
	int n1 = v1.size(); 
	int n2 = v2.size();
	int i = 0;
	int j = 0;

	while (i < n1 && j < n2) {
		if (v1[i] < v2[j]) {
			mergedVector.push_back(v1[i++]);
		}
		else {
			mergedVector.push_back(v2[j++]);			
		}
	}
	while (i < n1) {
		mergedVector.push_back(v1[i++]);
	}
	while (j < n2) {
		mergedVector.push_back(v2[j++]);
	}
	return mergedVector;
}


void to_string(string file, vector<int> v) {
	cout<< "The list of " << v.size() << " numbers in " << file << " is:\n";
	for (const auto &p : v) {
		cout << p << endl;
	}
}
