#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>



uint64_t i_global;

static void *thread_fn(void *data){
	int i;
	int i_local=0;
	for (i=0;i<20;i++){
		i_local++;
		i_global++;
		usleep(500000);
		printf("Thread: local: %d, global: %d\n", (int)i_local,(int)i_global);

	}
	pthread_exit(NULL);
	return 0;
}



int main(){
	uint64_t i_local=0;
	int i;
	
	pthread_t thread;
	void* data;
	pthread_create(&thread,NULL,thread_fn,(void*)data);
	pthread_join(thread,NULL);

	for (i=0;i<20;i++){
		i_local++;
		i_global++;
		sleep(1);
		printf("Main():  local: %d, global: %d\n",(int)i_local,(int)i_global);

	}
	return 0;
}