#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

void* philosopher_left(void* data);
void* philosopher_right(void* data);


static int PHILS = 3;
int alive = 1;

pthread_mutex_t forks[3];

int main(){
	int i = 0;
	pthread_t threads[PHILS];

	pthread_mutex_init(&forks[i],NULL);
	pthread_create(&(threads[i]),NULL,philosopher_right,(void*)i);
	
	for (i=1; i<PHILS; i++){
		pthread_mutex_init(&forks[i],NULL);
		pthread_create(&(threads[i]),NULL,philosopher_left,(void*)i);
		//pthread_join(threads[i],NULL);

	}
	pthread_join(threads[0],NULL);
	for (i=1; i<PHILS; i++){
		pthread_join(threads[i],NULL);

	}

	while(1){};

	return 0;
}

void* philosopher_left(void* data){
	int chair = (int)data;	
	while(alive){
		
	 	pthread_mutex_lock(&forks[chair]);
	 	if (chair==PHILS){
	 		pthread_mutex_lock(&forks[0]);
	 	} 
	 	else{
	 		pthread_mutex_lock(&forks[chair+1]);
	 	}
	 	//eat
	 	printf("Thead:%d is eating\n",chair );
	 	usleep(500000);
	 	pthread_mutex_unlock(&forks[chair]);
	 	pthread_mutex_unlock(&forks[chair+1]);
	 	usleep(500000);
	}
	return data;
}

void* philosopher_right(void* data){
	int chair = (int)data;	
	while(alive){
		if (chair==PHILS){
	 		pthread_mutex_lock(&forks[0]);
	 	} 
	 	else{
	 		pthread_mutex_lock(&forks[chair+1]);
	 	}
	 	pthread_mutex_lock(&forks[chair]);
	 	
	 	//eat
	 	printf("Thead:%d is eating\n",chair );
	 	usleep(500000);
	 	pthread_mutex_unlock(&forks[chair+1]);
	 	pthread_mutex_unlock(&forks[chair]);
	 	usleep(500000);
	}
	return data;
}
