#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>


int running = 1;
int var1 = 0;
int var2 = 0;


void* th_fn1(void* lock){
	while (running==1){
		pthread_mutex_lock( (pthread_mutex_t*) lock );
		var1++;
		var2 = var1;
		pthread_mutex_unlock( (pthread_mutex_t*) lock );
	}
	pthread_exit(NULL);
	return lock;
}

void* th_fn2(void* lock){
	int i;
	for (i=0;i<20;i++){
		pthread_mutex_lock( (pthread_mutex_t*) lock );
		printf("Number 1 is %d, number 2 is %d, the difference is %d\n", var1, var2, var2-var1);
		pthread_mutex_unlock( (pthread_mutex_t*) lock );
		usleep(100000);
	}	
	running=0;

	pthread_exit(NULL);
	return lock;
}












int main(){

	pthread_mutex_t lock;
	if (pthread_mutex_init(&lock,NULL) != 0){
		perror("mutex_init fail");
	}


	pthread_t t1, t2;
	
	pthread_create(&t1, NULL, th_fn1,(void*) &lock);
	pthread_create(&t2, NULL, th_fn2,(void*) &lock);

	pthread_join(t1,NULL);
	pthread_join(t2,NULL);

	return 0;
}