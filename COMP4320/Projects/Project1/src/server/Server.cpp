#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <iostream>
#include <fstream>
using namespace std;

#define PORT 8080;
#define PACKET_SIZE 512;

int socketfd;

struct sockaddr_in servaddr, cliaddr;


int bind() {
    if ((socketfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    memset(&servaddr, 0 ,sizeof(servaddr));
    memset(&cliaddr, 0, sizeof(cliaddr));

    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = INADDR_ANY;
    servaddr.sin_port = htons(PORT);

    if (::bind(socketfd, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0) {
        perror("bind failed");
        exit(EXIT_FAILURE);
   }
    return 0;
}

int writeFile(ofstream &file, char buffer[])
{
	for (int i = 7; i < PACKET_SIZE; i++)
	{
		if (buffer[i] != '\0')
			file << buffer[i];
	}
	return 0;
}

bool errorCheck(char buffer[]) {
    int sum = 0;
    for (int i = 7; i < PACKET_SIZE; i++) {
        sum += buffer[i];
    }

    try {
        string sumString;
        for (int i = 2; i < 7; i++) {
            sumString += buffer[i];
        }
        int passedSum = stoi(sumString);
        return passedSum == sum;
    }
    catch (std::invalid_argument) {
        return false;
    }
}



int send_response(char response[], socklen_t socketLength) {
    sendto(socketfd, (const char *)response, strlen(response), 0, (const struct sockaddr *)&cliaddr, socketLength);
    cout << "Sending: " << response << endl;
    cout << endl;
    return 0;
}

int getMessage() {
    char buffer[PACKET_SIZE] = {0};
    ofstream file;
    socklen_t socket_length;
    int message_length;

    socket_length = sizeof(cliaddr);
    file.open("out.txt");

    if (!file.is_open()) {
        cout << "Error opening output file." << endl;
        exit(EXIT_FAILURE);
    }
    char prev_sq_number;

    while (1) {
        message_length = recvfrom(socketfd, (char *)buffer, PACKET_SIZE, MSG_WAITALL, (struct sockaddr *)&cliaddr, &socket_length);
        buffer[message_length] = '\0';
        char sq_number = buffer[0];

        if (sq_number == '\0') {
            break;
        }
        else if (sq_number == prev_sq_number) {
            cout << "Dupliacte sequence number in packet " << sq_number << ". A packet was lost" << endl;
        }
        else {
            // need to come back and error check
            cout << "Received packet " << sq_number << ". Performing checking..." << endl;
            if (!errorCheck(buffer) || (sq_number != '0' && sq_number != '1')) {
                cout << "Packet " << sq_number << " is damaged." << endl;
            }
            else {
                cout << "Packet " << sq_number << " is fine" << endl;
            }
        }
        prev_sq_number = sq_number;

        writeFile(file, buffer);
        char resp[18];
        sprintf(resp, "Packet %c received.", sq_number);
        send_response(resp, socket_length);
    }
    cout << "Final packet received. Writing file." << endl;
    file.close();
    char out_header[] = "HTTP/1.0 200 Document Follows\r\nContent-Type: text/plain\r\nContent-Length: xxx\r\n\r\nData";
    send_response(out_header, socket_length);
    return 0;
}

int main() {
    bind();
    getMessage();
    return 0;
}
