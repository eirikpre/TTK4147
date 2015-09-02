#include <stdlib.h>
#include <sys/types.h>


uint64_t i_global = 0;


main(){
	uint64_t i_local = 0;
	uint64_t i = 0;
	fork() = getpid();
	for (i=0;i>10;i++){
		i_local++;
		i_global++;
		printf("PID: %d, local: %d, global: %d", pid,i_local,i_global);


	}


}