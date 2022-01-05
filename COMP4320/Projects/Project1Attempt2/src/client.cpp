#include "unp.h"


bool error_check(int a, int b) {
    return a == b;
}

int main(int argc, char **argv) {
    int sd;
    struct sockaddr_in server;
    struct hostent *hp;
    sd = socket(AF_INET, SOCK_DGRAM, 0);
    server.sin_family = AF_INET;
    server.sin_port = htons(12345);
    hp = gethostbyname(argv[1]);
    bcopy(hp->h_addr, &(server.sin_addr), hp->h_length);
    sendto(sd, "GET TestFile.html HTTP/1.0", 26, 0, (struct sockaddr *) &server, sizeof(server));
    printf("Sending HTTP Get Request to server\n");
    fstream file;
    file.open("OutputClient.txt");
    char buff[BUFFSIZE];
  
    
    while (1) {
        socklen_t l;
        int n = recvfrom(sd, buff, BUFFSIZE, 0, (struct sockaddr*) &server, &l);
        cout << "Received Packet from server, writing data to output file" << endl;
        if (!error_check(BUFFSIZE, n)) {
            cout << "Packet has errors" << endl;
        }
        file << buff;
        cout << "Data written" << endl;
    }

    cout << "All packets received, closing server" << endl;

}







