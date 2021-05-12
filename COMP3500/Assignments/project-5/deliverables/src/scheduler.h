/*
 * COMP 3500: Project 5 Scheduling
 * Xiao Qin
 * Version 1.0  11/18/2019
 *
 * This source code shows how to conduct separate compilation.
 *
 * scheduler.h: The header file of scheduler.c
 */
#ifndef _SCHEDULER_H_
#define _SCHEDULER_H_

#define MAX_TASK_NUM 32

typedef unsigned int u_int;

typedef struct task_info {
    u_int pid;
    u_int arrival_time;
    u_int burst_time;
    u_int remaining_time;
    u_int start_time;
    u_int finish_time;
} task_t;

typedef enum {
    FCFS,
    SRTF,
    RR    
} policy_t;



int fcfs_policy(task_t task_array[], task_t finish_array[], u_int count);

int srtf_policy(task_t task_array[], task_t finish_array[], u_int count);

int rr_policy(task_t task_array[], task_t finish_array[], u_int count, u_int quantum);    

void calc_stat_info(task_t finish_array[], u_int count);

void print_stat_data(double avg_waiting_time, double avg_response_time, double avg_turnaround_time, double cpu_usage);
#endif
