#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <time.h>
#include <signal.h>
#include <pthread.h>
//#include <sys/time.h>

#include "miniproject.h"

# define timercmp(a, b, CMP)                                                  \
  (((a)->tv_sec == (b)->tv_sec) ?                                             \
   ((a)->tv_nsec CMP (b)->tv_nsec) :                                          \
   ((a)->tv_sec CMP (b)->tv_sec))



const double Ki = 800;
const double Kp = 10;

double y,error,previous_error,u,integral;
double reference = 1.0;

struct udp_conn udp_socket;

pthread_mutex_t udp_lock;
pthread_mutex_t rcv_y;
pthread_mutex_t rcv_sig;

int receive_from_server(char *);
void send_to_server(char *);
void* udp_server( void *);
void* pid_controller( void *);
void* response_process( void* a );

int main ( void ) 
{
	////////////////////////// SETUP UDP /////////////////////////////////
	char* LOCAL_IP = "127.0.0.1";
 	int UDP_PORT = 9999;
	if ( udp_init_client(&udp_socket, UDP_PORT, LOCAL_IP) == 1) {
		printf("Error_udp_init");
		return 1;
	}
	
	pthread_t udp_thread;
	pthread_mutex_init(&udp_lock,NULL);
	
	pthread_create(&udp_thread, NULL, udp_server, NULL);
	pthread_join(udp_thread,NULL);		

	////////////////////////// SETUP INTERAL PROCESS ////////////////////
	pthread_t pid_thread;
	
	pthread_mutex_init(&rcv_y,NULL);
	pthread_mutex_lock(&rcv_y);

	pthread_create(&pid_thread, NULL, pid_controller, NULL);
	pthread_join(pid_thread,NULL);

	///////////////////////// SETUP RESPONSE PROCESS /////////////////////
/*
	pthread_t response_thread;
	
	pthread_mutex_init(&rcv_sig,NULL);
	pthread_mutex_lock(&rcv_sig);

	pthread_create(&response_thread, NULL, resonse_process, NULL);
	pthread_join(response_thread,NULL);
*/
	while(1){
	usleep(5000);
	}
	udp_close( &udp_socket );
	return 0;
}


void* pid_controller( void* a )
{
	struct timespec period,end;
	char* buffer = "123123133";
	
	clock_gettime(CLOCK_REALTIME, &period);
	clock_gettime(CLOCK_REALTIME, &end);
	timespec_add_us(&end, 500 * 1000);
	
	while ( timercmp( &period, &end, <) )
	{
		send_to_server("GET");
		pthread_mutex_lock(&rcv_y);
	
		///////////// CALCULATE VALUE //////////////////
		error = reference - y;  
		integral = integral + (error*0.001*4.0);
		u = Kp * error + Ki * integral;
		previous_error = error;

		sprintf(buffer,"SET:%.3f",u);
		send_to_server(buffer);

		timespec_add_us(&period, 1000);
		clock_nanosleep2(&period);
	}
	send_to_server("STOP");
	return a;
} 

void* udp_server( void* a )
{
	char* buffer = "GET_ACK:123.456";
	while(1)
	{
		if (receive_from_server(buffer) > 0 )
		{
			switch(*buffer)
			{
			case 'G' : 
				y = atof( *(&buffer+8) );
				pthread_mutex_unlock(&rcv_y);
				break;

			case 'S' : 
				pthread_mutex_unlock(&rcv_sig);
				break;
			default : 
				printf("Received: %s",buffer);
				break;
			}	
		}  
	}
	return a;
}

void* response_process( void* a )
{
	char* buffer = "SIGNAL_ACK";
	while ( 1 )
	{
		pthread_mutex_lock(&rcv_sig);
		send_to_server(buffer);
	}
	return a;
}

void send_to_server(char * data) 
{	
	pthread_mutex_lock(&udp_lock);
	udp_send(&udp_socket, data , strlen(data)+1);
	pthread_mutex_unlock(&udp_lock);
}

int receive_from_server(char * data)
{	
	pthread_mutex_lock(&udp_lock);
	int length = udp_receive(&udp_socket, data , strlen(data)+1);
	pthread_mutex_unlock(&udp_lock);
	return length;
}








