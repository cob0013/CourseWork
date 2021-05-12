#see README for a manual compilation process
CC = gcc
CFLAGS = -g
OBJ = open.o read.o print.o 

scheduler: $(OBJ) scheduler.c
	@echo "Creating the scheduler ..."
	$(CC) -o $@ $^ $(CFLAGS)

%.o: %.c %.h
	@echo "Creating object files ..."
	$(CC) -c $< -o $@

clean:
	rm -rvf *.o scheduler 
