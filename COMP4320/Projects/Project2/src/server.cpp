#include "unp.h"
stringstream fileContents;
string file = "TestFile.html";
int n, sd;
struct sockaddr_in server;
char buf[BUFFSIZE];
int checkSum;
int file_size;  
int TIMEOUT = 30;
char WAITING = '?';
char DAMAGEDPACKET = '!';
char DONE = 'd';
struct timeval tv;





void get_data() {
    ifstream file;
    file.open("TestFile.html");
    file_size = 0;
    char c;
    while (!file.eof()) {
        c = file.get();
        file_size += 1;
    }
}

bool error_check(int a, int b) {
    return a == b;
}

int timeout() {
    return -1;
}



int main() {
    int n;
    struct sockaddr_in server, client;
    int slen = sizeof(client);
    server.sin_family = AF_INET;
    server.sin_addr.s_addr = htonl(INADDR_ANY);
    server.sin_port = htons(12345);
    sd = socket(AF_INET, SOCK_DGRAM, 0);
    bind(sd, (struct sockaddr *) &server, sizeof(server));
    n = recvfrom(sd, buf, sizeof(buf), 0, (struct sockaddr*) &client, (socklen_t*)&slen);
    buf[n] = '\0';
    printf("Received: %s\n", buf);
    // timeout
    tv.tv_sec = 5;
    tv.tv_usec = 0;
    setsockopt(sd, SOL_SOCKET, SO_RCVTIMEO, &tv, sizeof(tv));
    char confirm [] = "HTTP/1.0 200 Document Follows\r\nContent-Type: text/plain\r\nContent-Length:\r\n\r\n";
    sendto(sd, confirm, sizeof(confirm), 0, (struct sockaddr *) &client, sizeof(client));
    printf("HTTP/1.0 200 Document Follows\r\nContent-Type: text/plain\r\nContent-Length:%i\r\n\r\n", file_size); 
    cout << "Getting packets from file" << endl;
    get_data();
    fstream file;
    file.open("TestFile.html");
    int checkSum = 0;
    int iteration = 0;
    while (checkSum < file_size) {
        char packet[BUFFSIZE];
        int i = 0;
        while (i < BUFFSIZE - 1) {
            char c;
            c = file.get();
            if (isalpha(c)) {
                packet[i] = c;
            }
            i++;
            checkSum++;
            if (checkSum >= file_size) {
                break;
            }
        }
        // header
        packet[0] = '0' + iteration;
        packet[1] = '0' + (i / 100);
        packet[2] = '0' + ((i % 100) / 10);
        packet[3] = '0' + (i % 10);
        cout << "Packet stored, need to do error checking before sending packet" << endl;
        if (error_check(512, BUFFSIZE)) {
            cout << "Error checking done" << endl;
            while (1) {
                cout << "Sending packet with sequence number " << iteration << " to client" << endl;
                sendto(sd, packet, sizeof(packet), 0, (struct sockaddr *) &client, sizeof(client));
                char ackBuffer [1];
                // ? indicates waiting for ack in this implementation
                ackBuffer[0] = '?';
                char ack = WAITING;
                // waiting to receive ack
                int waitTime = 0;
                recvfrom(sd, ackBuffer, sizeof(ackBuffer), 0, (struct sockaddr*) &client, (socklen_t*)&slen);
                ack = ackBuffer[0];                
                //ack or nack not received, packet needs to be resent
                if (ack == WAITING) {
                    cout << "Timeout, need to resend packet with sequence number: " << iteration << endl;
                    continue;
                }
                // handling NAK
                if (ack == DAMAGEDPACKET) {
                    cout << "NAK Received, need to resend packet" << endl;
                    continue;
                }
                cout << "Received ACK for sequence number: " << iteration << endl;
                break;
            }
        }
        iteration++;
    }
    char terminateMessage [1];
    terminateMessage[0] = DONE;
    sendto(sd, terminateMessage, sizeof(terminateMessage), 0, (struct sockaddr *) &client, sizeof(client));
    cout << "All packets are sent, closing server" << endl;
    close(sd);
    return 0;
}











