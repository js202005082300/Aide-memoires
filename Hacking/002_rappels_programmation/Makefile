CC = gcc
PYTHON = PYTHON
CFLAG = -Wall
PROG = ./prog

SRC = main.c

all: $(PROG)

$(PROG): $(SRC)
	$(CC) -o $(PROG) $(SRC) $(CFLAG)
	
py:
	python script.py

clean:
	rm -f $(PROG)