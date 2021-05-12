#include <stdio.h>
#include <math.h>
int main() {
	double arr[] = {2, 16, 99, 4, 11, 17, 6, 9, 100, 144};
	double sum = 0;
	double avg;
	int i;
	for (i = 0; i < 10; i++) {
		sum += sqrt(arr[i]);
	}	
	avg = sum / 10;
	printf("The average of the square roots is : %f\n", avg);
	return 0;
}
