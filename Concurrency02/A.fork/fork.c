#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <sys/types.h>
#include <unistd.h>



uint64_t i_global;


int main(){
	uint64_t i_local = 0;
	uint64_t i = 0;
	
	pid_t pid = getpid();
	for (i=0;i<10;i++){

		i_local++;
		i_global++;
		sleep(1);
		printf("PID: %d, local: %d, global: %d\n", (int)pid,(int)i_local,(int)i_global);

	}
	printf("Return value of forking: %d\n",(int)fork());
	return 0;
}