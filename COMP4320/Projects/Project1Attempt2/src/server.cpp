#include "unp.h"
stringstream fileContents;
string file = "TestFile.html";
int n, sd;
struct sockaddr_in server;
char buf[BUFFSIZE];
int checkSum;
int file_size;  
int damage_probability = -1;


bool gremlin(char *packet) {
    if (damage_probability == -1) {
        cout << "Enter damage probability: " << endl;
        cin >> damage_probability;
    }
    cout << "Running gremlin function" << endl;
    float prob = (float) rand() / RAND_MAX;
    int corrupt_bytes;
    if (prob > damage_probability) {
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
    for (int i = 0; i < sizeof(packet); i++) {
        packet[i] = '0';
    }
    return true;
}


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
    char confirm [] = "HTTP/1.0 200 Document Follows\r\nContent-Type: text/plain\r\nContent-Length:\r\n\r\n";
    sendto(sd, confirm, sizeof(confirm), 0, (struct sockaddr *) &client, sizeof(client));
    printf("HTTP/1.0 200 Document Follows\r\nContent-Type: text/plain\r\nContent-Length:%i\r\n\r\n", file_size); 
    cout << "Getting packets from file" << endl;
    get_data();
    fstream file;
    file.open("TestFile.html");
    int checkSum = 0;
    while (checkSum < file_size) {
        char packet[BUFFSIZE];
        int i = 0;
        while (i < BUFFSIZE) {
            char c;
            c = file.get();
            cout << "Making packet" << endl;
            packet[i] = c;
            i++;
            checkSum++;
            if (checkSum >= file_size) {
                break;
            }
        }
        cout << "Packet stored, need to do error checking before sending packet" << endl;
        if (error_check(512, BUFFSIZE)) {
            cout << "Packet is not damaged, sending packet to client" << endl;
            gremlin(packet);
            sendto(sd, packet, sizeof(packet), 0, (struct sockaddr *) &client, sizeof(client));
            
        }
    }
    cout << "All packets are sent, performing final error check" << endl;
    if (error_check(checkSum, file_size)) {
        cout << "None of the packets were damaged, sending to client" << endl;
    }
    
    close(sd);
    

    return 0;
}











