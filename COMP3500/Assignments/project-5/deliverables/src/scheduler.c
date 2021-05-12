/*
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include "scheduler.h"
#include "print.h"
#include "open.h"
#include "read.h"
#include "stats.h"

/*First come first serve policy*/
int fcfs_policy(task_t task_array[], task_t finish_array[], u_int count) {
    u_int i;
    u_int clock = 0;
    task_t ready_queue[MAX_TASK_NUM];
    u_int back_of_q = 0;
    u_int front_of_q = 0;
    u_int done = 0;
    u_int j = 0;


    while (count != done) {
        for (i = j; i < count; i++) {
            if (task_array[i].arrival_time <= clock) {
                task_array[i].remaining_time = task_array[i].burst_time;
                ready_queue[back_of_q] = task_array[i];
                back_of_q++;    
                //makes sure we don't q up stuff from the past
                j++;
            }    
            else {
                break;    
            }
        }    
        if (ready_queue[front_of_q].remaining_time == ready_queue[front_of_q].burst_time) {
            ready_queue[front_of_q].start_time = clock;
        }
        printf("<time %u> process %u is running\n", clock, ready_queue[front_of_q].pid);    
        ready_queue[front_of_q].remaining_time--; 
        if (ready_queue[front_of_q].remaining_time == 0) {
            ready_queue[front_of_q].finish_time = clock;
            finish_array[done] = ready_queue[front_of_q];
            printf("<time %u> process %u is finished...\n", clock, ready_queue[front_of_q].pid);
            done++;
            front_of_q++;
        } 
        clock++;
    }
    return 0;
}

/*Shortest run time first policy*/
int srtf_policy(task_t task_array[], task_t finish_array[], u_int count) {
    u_int i = 0; //for loop
    u_int j = 0; //keeps track of past events
    task_t ready_queue[MAX_TASK_NUM]; //q
    u_int back_of_q = 0; //next spot available in q
    u_int finished_count = 0; //number of finished processes
    u_int clock = 0; //clock 
    u_int INF = UINT_MAX; //max uint to represent infinity
    u_int next_task_index;
    u_int k;
    u_int shortest_rt;
    while (finished_count != count) {
        for (i = j; i < count; i++) {
            if (task_array[i].arrival_time <= clock) {
                task_array[i].remaining_time = task_array[i].burst_time;    
                j++; 
                ready_queue[back_of_q] = task_array[i];
                back_of_q++;
            }    
            else {
                break;    
            } 
        }
        //now we need to find shortest remaining time in q;
        u_int next_task_index;
        k = 0;
        shortest_rt = INF;
        for (k = 0; k < back_of_q; k++) {
            if (ready_queue[k].remaining_time < shortest_rt && ready_queue[k].remaining_time > 0) {
                shortest_rt = ready_queue[k].remaining_time;
                next_task_index = k;    
            }
        }    
        if (shortest_rt != INF) {
            if (ready_queue[next_task_index].remaining_time == ready_queue[next_task_index].burst_time) {
                ready_queue[next_task_index].start_time = clock;
            }
            printf("<time %u> process %u is running\n", clock, ready_queue[next_task_index].pid);    
            ready_queue[next_task_index].remaining_time--;     
            if (ready_queue[next_task_index].remaining_time == 0) {
                ready_queue[next_task_index].finish_time = clock;   
                finish_array[finished_count] = ready_queue[next_task_index];
                printf("time %u> process %u is finished...\n", clock, ready_queue[next_task_index].pid);
                finished_count++;
            }
        }
        clock++;
    }
    printf("<time %u> All processes finish ...\n", clock);
    return 0;    
}

/*round robin policy*/
int rr_policy(task_t task_array[], task_t finish_array[], u_int count, u_int quantum) {
        u_int i;
        u_int j = 0;
        u_int back_of_q = 0;
        task_t ready_queue[MAX_TASK_NUM];
        u_int finished_count = 0;
        u_int front_of_q = 0;
        u_int waiting = 0;
        u_int turn = 0;
        u_int clock = 0;
        u_int quantum_count = quantum;
        while (finished_count != count) {
            for (i = j; i < count; i++) {
                if (task_array[i].arrival_time <= clock) {
                    task_array[i].remaining_time = task_array[i].burst_time;
                    ready_queue[back_of_q] = task_array[i];
                    j++;        
                    waiting++;
                    back_of_q++;
                }
                else {
                    break;    
                }    
            }
                if (waiting > 0) {
                    if (quantum_count == 0) {
                        //need to find a new turn spot    
                        turn = (turn + 1) % back_of_q; 
                        while (ready_queue[turn].remaining_time <= 0) {
                            turn = (turn + 1) % back_of_q;
                        }        
                       quantum_count = quantum; //reset quantum count
                    }
                
                //run the proc
                    printf("<time %u> process %u is running\n", clock, ready_queue[turn].pid);
                    ready_queue[turn].remaining_time--; 
                    quantum_count--;
                 
                    if (ready_queue[turn].remaining_time == 0) {
                        waiting--; 
                        quantum_count == 0;    
                        ready_queue[turn].finish_time = clock;
                        finish_array[finished_count] = ready_queue[turn];
                        printf("<time %u> process %u is finished...\n", clock, ready_queue[turn].pid);
                        finished_count++;
                    }
                }
                clock++;
            }    
        
        printf("<time %u> All processes finish ...\n", clock);
    return 0;    
}


/*computes and prints stat info*/
void calc_stat_info(task_t finished_array[], u_int count) {
    u_int waiting_total = 0;
    u_int response_total = 0;
    u_int turnaround_total = 0;
    u_int total_burst = 0;    
    u_int i; 
    for (i = 0; i < count; i++) {
        waiting_total += (finished_array[i].finish_time - finished_array[i].arrival_time) - finished_array[i].burst_time;
        turnaround_total += finished_array[i].finish_time - finished_array[i].arrival_time;    
        response_total += finished_array[i].start_time - finished_array[i].arrival_time; 
        total_burst += finished_array[i].burst_time;
    } 
    double resp_avg = (double) response_total/ count;
    double turn_avg = (double) turnaround_total / count; 
    double waiting_avg = (double) waiting_total / count;
    double cpu_usage = (double) total_burst / finished_array[count - 1].finish_time * 100.0;
    print_stat_data(resp_avg, turn_avg, waiting_avg, cpu_usage);
}
    

/*prints and formats data */
void print_stat_data(double avg_waiting_time, double avg_response_time, double avg_turnaround_time, double cpu_usage) {
    printf("====================\n");
    printf("Average waiting time: %f\n", avg_waiting_time);
    printf("Average response time: %f\n", avg_response_time);
    printf("Average turnaround time: %f\n", avg_turnaround_time);
    printf("Overall CPU usage: %f\n", cpu_usage);    
}


int main( int argc, char *argv[] )  {
    char *file_name; /* file name from the commandline */
    FILE *fp; /* file descriptor */
    task_t task_array[MAX_TASK_NUM];
    task_t finish_array[MAX_TASK_NUM];
    int error_code;
    u_int i;
    u_int count;
    policy_t my_policy; 
    stat_info_t stat_info;
    int time_quantum;
    if (argc <= 2 || argc > 4) {
        printf("Usage: scheduler file_name [FCFS|RR|SRFT] [time_quantum]\n");    
        return EXIT_FAILURE;
    }
    if (strcmp(argv[2], "RR") == 0) {
        if (argc == 4) {
            //rr w time quantum set to argv[3]  
            time_quantum = atoi(argv[3]);
            my_policy = RR;
        }    
        else {
            printf("Please enter time quantum for the RR policy!\n");    
            return EXIT_FAILURE;
        }
    } 
    else if (strcmp(argv[2], "FCFS") == 0) {
        my_policy = FCFS;    
        printf("here\n");
    }
    else if (strcmp(argv[2], "SRTF") == 0) {
        my_policy = SRTF;     
        printf("here2\n");    
    }
    else {
        printf("Usage: scheduler file_name [FCFS|RR|SRFT] [time_quantum]\n");    
        return EXIT_FAILURE;
    }
    printf("%d\n", my_policy);
    error_code = open_file(argv[1], &fp);
    if (error_code == 1)
        return EXIT_FAILURE;
    read_file(fp, task_array, &count);
    print_task_list(task_array, count);
    switch(my_policy) {
        case FCFS:
            fcfs_policy(task_array, finish_array, count);
            break;
        case SRTF:
            srtf_policy(task_array, finish_array, count);
            break;
        case RR:
            rr_policy(task_array, finish_array, count, time_quantum);
            break;
        default:
            printf("should not have gotten here\n");
    }  
    calc_stat_info(finish_array, count);
    fclose(fp);

    return EXIT_SUCCESS;
}
