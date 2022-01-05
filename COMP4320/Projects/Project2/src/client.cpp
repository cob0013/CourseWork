#include "unp.h"
float damage_probability = -1;
float drop_probability = -1;
char WAITING = '?';
char DAMAGEDPACKET = '!';
char DONE = 'd';



bool error_check(char *packet) {
    char iteration = packet[0];
    char checkSum1 = packet[1];
    char checkSum2 = packet[2];
    char checkSum3 = packet[3];
    string expectedCheckSum = "";
    expectedCheckSum += checkSum1;
    expectedCheckSum += checkSum2;
    expectedCheckSum += checkSum3;
    int calcExpectedCheckSum = stoi(expectedCheckSum) - 4;
    int actualCheckSum = 0;
    cout << sizeof(packet) << endl;
    for (int i = 4; i < calcExpectedCheckSum; i++) {
        if (packet[i] != '?') {
            cout << packet[i] << endl;
            actualCheckSum += 1;
        }
        else {
            cout << "here" << endl;
        }
    }
    return (calcExpectedCheckSum - 4 == actualCheckSum);
}

bool gremlin(char *packet) {
    if (damage_probability == -1) {
        cout << "Enter damage probability: " << endl;
        cin >> damage_probability;
        cout << "Enter drop probability: " << endl;
        cin >> drop_probability;
    }
    cout << "Running gremlin function" << endl;
    float prob = (float) rand() / RAND_MAX;
    int corrupt_bytes;
    if (prob < drop_probability) {
        return true;
    }
    if (prob < damage_probability || damage_probability == 0) {
        return false;
    }
    float n_corrupt_prob = (float) rand() / RAND_MAX;
    if (n_corrupt_prob < .2) {
        corrupt_bytes = 3;
    }
    if (n_corrupt_prob < .3) {
        corrupt_bytes = 2;
    }
    if (n_corrupt_prob < .5) {
        corrupt_bytes = 1;
    }
   
    if (sizeof(packet) < corrupt_bytes) {
        corrupt_bytes = sizeof(packet);
    }
    for (int i = 4; i < corrupt_bytes; i++) {
        packet[i] = '?';
    }
    return false;
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
    char buff[BUFFSIZE + 4];
    char ackBuff[1];
  
    int i = 0;
    while (1) {
        socklen_t l;
        int n = recvfrom(sd, buff, BUFFSIZE, 0, (struct sockaddr*) &server, &l);
        char sequence = buff[0];
        if (sequence == DONE) {
            break;
        }
        if (i != 0) {
            cout << "Received packet with sequence number: " << sequence << endl;
            bool drop = gremlin(buff);
            if (drop) {
                cout << "Packet with sequence number " << sequence << " was dropped" << endl;
                continue;
            }
            if (!error_check(buff)) {
                cout << "There is an error in this packet" << endl;
                ackBuff[0] = DAMAGEDPACKET;
                sendto(sd, ackBuff, sizeof(ackBuff), 0, (struct sockaddr *) &server, sizeof(server));
            }
            else {
            // ignores header
                cout << "No damage on this packet" << endl;
                cout << "Sending ACK for sequence number: " << sequence << endl;
                ackBuff[0] = sequence;
                sendto(sd, ackBuff, sizeof(ackBuff), 0, (struct sockaddr *) &server, sizeof(server));
                for (int i = 4; i < sizeof(buff) - 5; i++) {
                    file << buff[i];
                    cout << buff[i] << endl;
                }
            }
        }
        else {
            file << buff;
        }
        cout << "Data written" << endl;
        i++;
    }

    cout << "All packets received, closing server" << endl;
    return 0;

}







