TARGET = main

CFLAGS = -g -Wall -D_GNU_SOURCE

LDFLAGS = -g -lrt -pthread  -lcomedi -lm

SOURCES = $(shell find -name "*.c")

all: $(TARGET)

OBJECTS = $(SOURCES:.c=.o)

%.o : %.c
	gcc $(CFLAGS) -c -o $@ $<

$(TARGET): $(OBJECTS)
	gcc -o $@ $^ $(LDFLAGS) 

clean:
	rm -f $(TARGET) $(OBJECTS)
