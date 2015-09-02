#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>



uint64_t global_i = 0;
sem_t semaphore;


void* thread_fn(void *data){
	int i;

	for (i=0;i<10;i++){
		sem_wait(&semaphore);
		printf("Thread:%c: %d\n",(char*)data,(int)++global_i);
		sem_post(&semaphore);
		usleep(5000);
	}
	pthread_exit(NULL);
	return data;
}

int main(){

	
	if( sem_init(&semaphore,1,1) < 0){
		perror("sem_init failed");

	}

	pthread_t threads[5];
	char data[5] = {'a','b','c','d','e'};
	int i;
	for (i=0;i<5;i++){

		pthread_create(&(threads[i]),NULL,thread_fn,(void*)data[i]);
		pthread_join(threads[i],NULL);

	}

	return 0;
}