CC = gcc
PYTHON = PYTHON
CFLAG = -Wall
PROG = prog

SRC = main.c

all: $(PROG)

$(PROG): $(SRC)
	$(CC) -o $(PROG) $(SRC) $(CFLAG)
	
#etapes de compilations
#----------------------

#résultat du pré-processeur
pp:
	gcc main.c -E

#exporter le résultat
ppi:
	gcc -E main.c > main.i
	
#compiler en langage assembleur
com:
	gcc -S main.i

#assembleur vers binaire
bin:
	gcc -c main.s
	
#édition des liens
link:
	gcc main.o 

#options bonus
#-------------

#tout les avertissements ou presque
wall:
	gcc -Wall main.c -o prog
	
#transformer les avertissements comme des erreurs de compilation
error:
	gcc -Wall -Werror main.c -o prog
	
#afficher des avertissements supplémentaires (autrefois -W)
extra:
	gcc -Wall -Wextra main.c -o prog
	
#désactive tous les avertissements
w:
	gcc -w main.c -o prog
	
#traiter la compilation avec la norme ANSI
ansi:
	gcc -ansi main.c -o prog

#plus d'avertissement sur la norme ANSI avec pedantic
peda:
	gcc -ansi -pedantic main.c -o prog

#changer le standard de compilation par défaut (C90)
std:
	gcc -std=c11 main.c -o prog

#générer des infos pour le débogage
g:
	gcc -g main.c -o prog

clean:
	del /p -f $(PROG).exe *.i *.s *.o
	