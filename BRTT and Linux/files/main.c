#include "io.h"
#include <pthread.h>
#include <unistd.h>
#include <sched.h>
#include <time.h>

int set_cpu(int cpu_number);
void busy_wait(void* data);
void timespec_add_us(struct timespec *t, long us);

void respond(void* data)
{
	set_cpu(1);
	int pin = (int)data;
	struct timespec next;
	while(1){
		while(io_read(pin) != 0){
			clock_gettime(CLOCK_REALTIME, &next);
			timespec_add_us(&next, 1000);
			clock_nanosleep(CLOCK_REALTIME, TIMER_ABSTIME, &next, NULL);
		}
		io_write(pin, 0);
		usleep(5);
		io_write(pin, 1);
	}
}

int main(){
	int i;
	io_init();

	pthread_t threads[3];
	for (i=1; i<4; i++){
		pthread_create(&(threads[i]),NULL,respond,(void*)i);
	}
	for (i=0; i<3; i++){
		pthread_join(threads[i],NULL);
	}

	pthread_t disturbance[10];
	for (i=1; i<4; i++){
		pthread_create(&(disturbance[i]),NULL,busy_wait,(void*)i);
	}
	
	for (i=0; i<10; i++){
		pthread_join(disturbance[i],NULL);
	}


	while(1)
	return 0;
};

int set_cpu(int cpu_number)
{
	// setting cpu set to the selected cpu
	cpu_set_t cpu;
	CPU_ZERO(&cpu);
	CPU_SET(cpu_number, &cpu);
	// set cpu set to current thread and return
	return pthread_setaffinity_np(pthread_self(), sizeof(cpu_set_t),&cpu);
} 

void timespec_add_us(struct timespec *t, long us)
{
	// add microseconds to timespecs nanosecond counter
	t->tv_nsec += us*1000;
	// if wrapping nanosecond counter, increment second counter
	if (t->tv_nsec > 1000000000)
	{
		t->tv_nsec = t->tv_nsec - 1000000000;
		t->tv_sec += 1;
	}
} 

void busy_wait(void* data){
	int i = 1000;
	while(1)
	{
		i= i*1000;
		i= i/1000;
	} 
}




