#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>


static int PHILS = 3;
int alive = 1;

pthread_mutex_t forks[PHILS];

void* philosopher_left(void* chair){

	while (alive){






	}
}














int main(){

	pthread_t threads[PHILS];
	int chair[PHILS];
	int i;
	for (i=0; i<PHILS; i++){
		chair[i] = i+1;
		pthread_create(&(threads[i]),NULL,philosopher_left,(void*)chair[i]);
		pthread_join(threads[i],NULL);


	}
	

	return 0;
}