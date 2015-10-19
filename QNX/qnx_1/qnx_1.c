#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <fcntl.h>
#include <sys/dispatch.h>
#include <sys/mman.h>

struct pid_data{
	pthread_mutex_t pid_mutex;
	pid_t pid;
};

struct msg_info_t{
	pid_t pid;
	pid_t thread_id;
};

struct msg_info_t buffer;
struct pid_data *my_pid_addr;

char reply[2] = "OK";

void program_one(void);
int get_priority();
int set_priority(int);

void msg_server()
{
	set_priority(25);

	int chan_id = ChannelCreate(0); //_NTO_CHF_FIXED_PRIORITY
	int msg_id;
	while(1)
	{
		msg_id = MsgReceive(chan_id, &buffer, sizeof(buffer), 0 );
		printf("SERVER: received msg: PID:%d, THREAD_ID:%d\n", buffer.pid, buffer.thread_id);
		MsgReply(msg_id,0, &reply,sizeof(reply));
	}
}


int main(int argc, char *argv[])
{
	set_priority(25);
	program_one();
	printf("Program One: PID: %d\n", my_pid_addr->pid);
	msg_server(); // only for 4 msgs

	return EXIT_SUCCESS;
}

void program_one(void)
{
	pthread_mutexattr_t myattr;

	int f_desc = shm_open("/sharedpid", O_RDWR | O_CREAT, S_IRWXU);
	ftruncate(f_desc, sizeof(struct pid_data));
	my_pid_addr = (struct pid_data*)mmap(0, sizeof(struct pid_data), PROT_READ | PROT_WRITE, MAP_SHARED, f_desc, 0);

	pthread_mutexattr_init(&myattr);
	pthread_mutexattr_setpshared(&myattr, PTHREAD_PROCESS_SHARED);
	pthread_mutex_init(&(my_pid_addr->pid_mutex), &myattr);
	my_pid_addr->pid = getpid();
}

int set_priority(int priority)
{
	int policy;
	struct sched_param param;
	// check priority in range
	if (priority < 1 || priority > 63) return -1;
	// set priority
	pthread_getschedparam(pthread_self(), &policy, &param);
	param.sched_priority = priority;

	return pthread_setschedparam(pthread_self(), policy, &param);
}

int get_priority()
{
	int policy;
	struct sched_param param;
	// get priority
	pthread_getschedparam(pthread_self(), &policy, &param);
	return param.sched_curpriority;
}




