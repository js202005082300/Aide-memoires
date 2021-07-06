CC = gcc
SRC = $(wildcard *.c)
OBJ = $(SRC:.c=.o)

WINDOWS = yes

ifeq ($(WINDOWS), yes)
	EXEC = prog.exe
else
	EXEC = prog
endif

all : $(EXEC)

%.o : %.c
	$(CC) -o $@ -c $<

$(EXEC) : $(OBJ)
	$(CC) -o $@ $^

clean :
	rm -rf *.o

mrproper : clean
	rm -rf $(EXEC)
