# [[ARCHIVE] Hacking #2 - rappels programmation](https://www.youtube.com/watch?v=y5-y4vPqTEU&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=9)

	   Formation   : Hacking - rappels programmation
       YouTube     :
       Auteur      : Jason Champagne
       Compilateur : GCC
       Date        : 15-05-20
       Dernière modification    : 15-05-20


Rappel sur :
- Les variables (Typage stricte en c) ;
- Les structures conditionnelles ;
- Les parcours des structures, les listes (collections) ou un tableaux en langage C ;
- Les procédures, les fonctions et les méthodes sont la même chose ;
- Les portées des variables, le passage en dur ou par variable dans une fonction ;
- Les pointeurs en C ;

```py
#coding:utf-8

monPrenom = "Jason"
monAge = 26
nombrePI = 3.14
inventaire = ["Arc", "Potion", "Cape", "Casque de guerrier"]

if monAge > 18:
    print("Tu es majeur", end="\n") # pas de retour à la ligne : end="" | une tabulation : end="\t"
else:
    print("Tu es mineur")

for it in inventaire:
    print(it)

def maFonction(message): # message de la fonction
    print(message)

#Programme principal
message = "Coucou" # message du programme
maFonction(message)
```

```c
#include <stdio.h>

void maFonction(int nombre) //nombre de la fonction
{
    printf("Md\n", nombre);
}

int main(void)
{
    char monPrenom[] = "Jason"
    int monAge=26;
    float nombrePI = 3.14;

    if(monAge > 18)
        printf("Tu es majeur\n");
    else
        printf("Tu es mineur\n");

    for(int i = 0 ; i != 5 ; i++)
        printf("%c\n", monPrenom[i]);

    int nombre = 14; // nombre du main
    maFonction(nombre); //passage par variable

    /*
        Définition pointeur : Variable qui stocke l'adresse d'une variable

        *ptr    : valeur de la variable pointée
        ptr     : adresse de la variable pointée

        ptr avec %d : adresse du pointeur lui-même

        EXEPTION : A la déclaration (et éventuellement initialisation)
                    *ptr = pointeur
    */
    int nombre = 15;
    int *ptr_nombre = NULL;
    ptre_nombre = &nombre; // pointé sur nombre
    printf("%p\n", ptr_nombre); // adresse du pointeur
    printf("%d\n", ptr_nombre); // adresse décimal du nombre
    printf("%d\n", *ptr_nombre); // valeur de nombre (valeur de la variable pointée)
    *ptre_nombre = 3; // modifier la valeur de la variable pointée
    printf("%d\n", *ptr_nombre);

    return 0;
}
```

>

## Introduction
		
Dans la séance 1, on a vu la présentation de cette formation.

Pour cette seconde séance, nous allons faire quelques rappels en programmation.

Avant de commencer, il faut certains prérequis : 

    -   Il faut avoir suivi la formation en langage C jusqu'à la partie sur les structures de données, jusqu'au Pile notamment. 

    -   Pour Python, au moins toute la partie jusqu'à la programmation orienté objet.

Si on n'as pas suivi une des deux, ce n'est pas bien grave mais alors le rappel que l'on va faire ici va concerner ces deux langages, le langage C et le langage Python.

Nous allons utilisé et retrouvé souvent ces deux langages au cours de cette formation hacking.

Pour commencer on fait un fichier pour le langage C et un fichier pour le langage Python.

Après si on n'a pas vu un des deux, ce n'est pas bien grave. Seulement si on en a vu aucun des deux, c'est mieux de suivre une des deux formations au minimum avant de revenir sur cette séance.

Ces prérequis sont nécessaire pour suivre cette formation et les vidéos qui vont suivre.

Le petits rappels que l'on fait sont très simple, on ne veux pas faire un cours de programmation et de réviser tout ce qui a été vu. C'est simplement pour revoir et se rendre compte si quelque chose cloche dans notre comprehension de certaines notions afin de pouvoir retrouver les vidéos concernant les notions sur lesquels ont a encore des difficultées et des lacunes pour pouvoir les corrigé et attaquer plus sereinnement les vidéos et séances qui suivront la formation Hacking.

## Les variables

La notion la plus importante que l'on retrouve en informatique sont bien sûr les variables et les types de données qui sont associées.

Les variables sont importantes à connaître. Les variables sont tout simplement une manière de stocker une information en mémoire en lui donnant un nom. On donne un nom de variable qui va nous permettre en tant qu'humain de l'identifier très facillement et ensuite d'y stocker un certain type de donnée.

Pour le langage Python, c'est assez pratique car tout est objet et ainsi c'est du typage qui n'est pas explicite et qui n'est certainnement pas stricte, c'est-à-dire que je peux faire simplement :

```py
nomPrenom = "Jason"
```

Simplement en choisissant un nom (qui veut dire au moins quelque chose) et en ouvrant des double-quotes, il va considérer cela comme un str, un string c'est-à-dire une chaîne de charactères.

```py
monAge = 26
```

Comme ceci, il va le considérer comme un nombre entier.

```py
nombrePI = 3.14
```

Comme ceci, il va le prendre comme un flottant.

On peut continuer ainsi pour pleins d'autres choses. Comme Python accepte tous les objets, ça peut accepter les listes, les tuples mais là on reste sur les types standards, connus d'un peu tout le monde et qu'on retrouve dans un petit peu tous les langages.

Cette notion est assez simple. Il faut savoir ce qu'est une variable, à quoi elle sert ?
Et comment on l'utilise et notamment qu'est-ce qu'un entier ? qu'est-ce qu'une chaîne ?

```py
nomPrenom = "Jason" #string (str)
monAge = 26			#entier (int)
nombrePI = 3.14		#flottant (float)
```

En commentaire, on a un string, une chaîne dont le diminutif est str.

Ensuite, on a un entier dont le diminutif est int pour integer.

Enfin un flottant donc un nombre décimale qui est tout simplement appelé float.

Ce sont les 3 types standards à connaître qui sont important.

Rem. Quand on a un simple charactère de chaîne, on l'appelera un char mais on ne le retrouve pas forcément en Python même si on peut travailler sur de simple charactère.

En langage C, c'est différent.

En langage C, on a un typage qui est absolument stricte c'est-à-dire que l'on doit préciser absolument le type de variable que l'on veut.

Donc si je veux par exemple créer un prénom, je dois utiliser char parce que on faire un espèce de tableau de charactères qui va devenir une chaîne de charactères...

```c
char monPrenom[] = "Jason";
```	

... auquel on ajoute un nom de variable monPrenom et on y met un prenom directement à la création.

Ensuite si on veut y mettre un nombre entier, on va y mettre le fameux type entier, integer (int) au quel on ajoute un nom de variable.

```c
int monAge = 26;
```

Dans le tableau (vu au cours) sur les types de variable en C, on a vu qu'il y avait plusieurs types : long, short, etc mais là on se consentre sur les types standards. 

Pour un float, on ferait de cette manière :

```c
float nombrePI = 3.14;
```

Rappel. En informatique, la virgule se fait avec un point.

Voilà nous venons de voir un petit rappel sur les variables, très basique.

Il faut savoir ce qu'est une variable ? Comment on l'utilise ? Comment on crèe des variables dans ces différents langages bien évidemment ? Qu'est-ce qu'un char ? Qu'est-ce qu'une chaîne ? Qu'est qu'un entier ? QU'est-ce qu'un flottant ? Il faut savoir les différencier et savoir dans quel cas, ils sont utiles ou non, tout simplement.

Voilà ce qu'on doit savoir sur les variables. C'est très court, il n'y a pas grand chose mais c'était nécessaire.

## Les conditions et les boucles

On passe au seconde point (2ième sur 4 pour voir le sommaire).

Le second point concerne les conditions et les boucles. On aura a faire aux cours de cette formations et des autres formations sur les langages de programmation que l'on utilise.

On devrait faire usage de structures de contrôles. Ca peut être des structures de conditions ou encore des structures répétitives, notamment les boucles pour pouvoir répéter un certains nombre de fois un traitement. Et les conditions pour éffectuer des tests sur de variables notamment. Ca sert à ça, on peut également faire des tests sur des valeurs en dur.

Une variable en dur, c'est :

```c
char monPrenom[] = "Jason";
int monAge = 26;
float nombrePI = 3.14;
```
				
C'est-à-dire qu'on enregistre notamment 26 en tant que valeur en dur dans mon âge.

Par contre, si j'avais fait :

```c
int truc = 14;
int monAge = truc;
```
	
... ce n'est pas stocker en dur, c'est stocker dans une variable. 

Il faut faire la différence entre stocker en dur ou dans une variable. c'est juste du vocabulaire basique.

Au niveau des conditions, de la syntaxe en Python, on ne met pas d'accolade

```py
if monAge > 18:
	print("Tu est majeur", end="\")
else:
	print("Tu est mineur", end="\")
```
		
rem. Quand on ne veut pas faire de retour à la ligne sur le print(). On met end qui est une variable prévue pour le print() et on dit simplement ceci que la fin n'est pas un retour à la ligne. On pourrait mettre end="\t" pour dire qu'on fait une tabulation à la fin. Si on fait end="\n", ça revient à faire un print à la fin. Et en faisant end="", le print ne passera pas à la ligne.

Voilà comment les conditions fonctionnent. On voit qu'il y a des notions d'opérateurs de comparaisons à connaître. Attention c'est un double égale pour l'égalité, et le simple égale est reservé à l'affectation en informatique. C'est une erreur fréquente chez les débutants.

== Un double égale pour faire une égalité.
!= Un point d'exclammation et un égale pour faire une différence.
<= ou >= Charactère inférieur/supérieur à, toujours suivi d'un égale. Le égale vient toujours après.

Pour le C, on met la condition entre parenthèses puis les instructions entre accolades et puisqu'il n'y en a qu'une, pas besoin d'accolades.

```c
if(monAge > 18)
	printf("Tu est majeur\n");
else
	printf("Tu est mineur\n");
```
	
Grosso modo, on a le même code, on fonctionne de cette manière. Il faut savoir à quoi sert une condition ? Ca permet de faire des tests sur des variables ou des valeurs en dur pour réaliser un certain nombre de traitement si la condition, qui est du coup nommée, est valide. S'il n'est pas validé, on passe dans les autres ou alors on ne passe pas du tout dans un if si on a un qu'un seul if. 

## Les boucles

Les boucles des traitements répétés. On a la boucle for, while ou la boucle do while. La boucle la plus logique en C est la boucle while ou faire tout simplement for.

Par exemple, int i=0 et tant que i est différent 5 (nombre de charactères dans "Jason")... et ainsi afficher chaque charactère du prenom ... avec à chaque fois, un retour à la ligne.

```c
for(int i = 0, i != 5, i++)
	printf("%c\n", monPrenom[i]);
```
	
L'intérêt est de comprendre à quoi servent les boucles. Elles serve,t à réaliser un traitement. Ca peut servir à répéter quelque chose. Ca peut également servir à parcourir comme l'exemple à avec un tableau de charactères. 

Dans le cas de Python, il faut avoir vu les listes où par exemple, on va faire un inventaire :

```py
inventaire = ["Arc", "Potion", "Cape", "Casque de guerrier"]
```
	
Un inventaire est toujours bien à faire dans un jeu vidéo.

Pour parcourir un inventaire, on fait simplement un for :

```py
for it in inventaire:
	print(it)
```
	
On fait un for sur un objet "it" et on print l'objet. On fait un simple parcours. On comprend qu'une boucle ce n'est pas que pour boucler quelque chose mais que derrière ça sert à faire des parcours. Parcourir des structures, des listes, ce qu'on appelle des collections. 

En langage C, on parcours un tableau.

Ca c'était le deuxième point.

## Procédure, fonction, méthode

On attaque un troisième point qui est universelle pour tout les langages. Sur tout les vieux langages, on parle de procédure. Une procédure fait en fait une petite chose et puis c'est tout.

On a ensuite les fonctions qui peuvent retourner des valeurs et on a un l'équivalent en objet qui sont les méthodes. C'est un peu grosso modo la même chose bien que les noms changent même si dans l'absolu, on pourrait différencier une procédure, d'une fonction, d'une méthode.

En effet une méthode est une fonction d'une classe.

Une fonction est une fonction procédurale.

Une procédure, c'est un peu l'ancien nom de la fonction tel que ça fonctionnait à l'époque.

La fonction en Python s'emploi avec le mot clé def :

```py
def maFonction():
    print("Salut !")
```
				
Dans ce cas, elle ne prend pas de paramètres. On fait ensuite un appel de fonction.

```py
maFonction()
```
	
Ce qu'il faut ensuite savoir c'est que si elle prend une information, on pourra utiliser les paramètres qui se trouve en définition de ma fonction :

```py
def maFonction(message):
	print(message)

#Programme prinxipal
maFonction()
```

... mais attention cette variable message n'existe que dans la fonction. Une fois qu'on a quitté la fonction. Cette variable est détruite. En effet, elle n'existe pas dans le programme principale.

Ensuite si on crée une variable message dans le programme principale, ce n'est pas la même variable que dans le programme princdipal.
	
```py
def maFonction(message):
	print(message)

#Programme prinxipal
message = "Coucou"
maFonction(message)
```
	
Par exemple, la variable message de la fonction va avoir une adresse 1000 dans la mémoire du pc et la variable message du programme principale va avoir l'adresse 1436 par exemple.

C'est pour comprendre que l'emplacement mémoire sera complétement différent.

Pourtant dans notre code, humainnement parlant, on leur a donné le même nom.

Mais pour lui, l'ordinateur ne manipule que des noms, il ne sait faire que ça. Pour lui c'est des adresses mémoires. Pour lui message n'existe pas, monAge n'existe même pas non plus.

En effet, nomPrenom, monAge, nombrePI, inventaire sont juste des adresses.

Mais il faut retenir qu'une variable de même nom dans le programme princdipal et une autre dans la méthode ne sont pas les mêmes. On a la variable message de la fonction et on a la variable message du programme principal. Ce sont deux variables complétement différentes. Il faut faire attention.

On retrouve la même chose pour le langage C :

```c
void maFonction(int nombre)
{
	printf("%d\n", nombre);
}

int main(void)
{
	maFonction(14);
	return 0;
}
```

Pareil, on fait la fonction et on lui passe un nombre. On dit que c'est passé en dur. On a un paramètre.

On peut aussi lui passer d'une autre manière, par une variable :

```c
void maFonction(int nombre)
{
	printf("%d\n", nombre);
}

int main(void)
{
	int nombre = 14;
	maFonction(nombre);
	return 0;
}
```

C'est la même chose, la variable nombre de la fonction main(), donc stockée dans une autre zone mémoire, que la variable nombre de la fonction maFonction().

Au niveau de la portée des variables, une variable (définie de cette manière) n'existe que dans le corps de la fonction où elle a été déclarée. Comme nombre a été déclarée dans main(), dés qu'on arrive au "return 0;", toute les variables de la fonction main() sont détruites.

Le paramètre nombre de la fonction "void maFonction(int nombre)" est une façon de récupérer ce qui vient de l'appel de la fonction. C'est pour ça qu'on le passe en paramètre. Ensuite dés qu'on arrive à l'accolade de fin, toutes les variables qui étaient en paramètres et qu'on aurait pû créer en début de fonctions sont détruites.

```c
void maFonction(int nombre)
{
	int autreVariable = 6;
	printf("%d\n", nombre);
}
```
	
nombre et autreVariable sont détruites à la fin de la fonction. C'est la portée des variables. Elle n'existent que dans leur propre fonction.

C'était un petit rappel super important car ce n'est pas toujours bien compris (revoir les vidéos si nécessaire).

## Les pointeurs

On termine avec une dernière notion qui n'existe pas en Python et qui est importante pour le langage C qui concerne les pointeurs.

C'est très souvent la bête noir des débutants et ceux qui commencent avec le langage C. C'est pourtant super important.

A la création, quand on déclare un pointeur. Que éventuellement, on l'initialise. On va lui mettre une étoile.

Par exemple avec un nombre normale :

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int ptr_nombre = NULL;
	
	return 0;
}
```
	
Si je l'initialise par défaut, on lui met la valeur NULL. On ne met pas de 0, etc. Attention que NULL en langage C, NULL est écrit tout en majuscule et avec deux 'L'. 

```c
int ptr_nombre = NULL;
```

Dans ce cas, on crée un pointeur qui pointe vers rien du tout. 

Si maintenant on essaye d'afficher, le nombre va être 15 et le pointeur n'aurait rien du tout donc c'est NULL.

Si on veux associer directement une valeur à la déclaration, on utilise le symbole esperluette, le "et" commerciale, en passant sur l'adresse de la variable sur lequel je veux pointer.

On peut le pointer sur nombre :

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int ptr_nombre = &nombre;
	
	return 0;
}
```

Dés ce moment là le pointeur va pointer sur cette variable au niveau de la mémoire.

De là comment accéder aux valeurs ?

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int ptr_nombre = &nombre;
	
	printf("%p\n", ptr_nombre);
	
	return 0;
}
```
	
Si je fait %p, je vais afficher l'adresse du pointeur. Donc on va savoir où est stocker cette variable dans la mémoire de mon ordinateur. 

```c
printf("%d\n", ptr_nombre);
```

Si en revanche, je fait %d, je ne vais pas avoir la valeur de la variable nombre. En effet, ptr_nombre pointe vers une autre variable qui pointe vers son adresse en mémoire, qui va me donner l'adresse, sous forme décimale, de nombre, où il est stocké dans la mémoire. Si je veux la valeur, il faut ajouter l'étoile * :

```c
printf("%d\n", *ptr_nombre);
```
	
Une étoile dans un affichage comme ci-dessus ou dans une affectation signifie la valeur de la variable que tu pointe. Donc il va à l'adresse de ce qui est pointé ici par "*ptr_nombre", donc c'est nombre. ET comme on a mis étoile, il va prendre la valeur de nombre. Ce serra bien 15.

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int *ptr_nombre = &nombre;
	
	printf("%d\n", *ptr_nombre);
	
	return 0;
}
```

Ce code affichera 15.

Si on fait une affectation, c'est pareil.

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int *ptr_nombre = &nombre;
	
	ptr_nombre = 15; // NE VEUT RIEN DIRE.
	
	printf("%d\n", *ptr_nombre);
	
	return 0;
}
```

On lui dit maintenant : "ptr_nombre pointe vers 15" avec ptr_nombre = 15; ce qui ne veux absolument rien dire.

Par contre, on peut lui dire sans problème : 

```c
#include <stdio.h>

int main(void)
{
	int nombre = 15;
	int nombre2 = 6;
	int *ptr_nombre = &nombre;
	
	ptr_nombre = &nombre2;
	
	printf("%d\n", *ptr_nombre);
	
	return 0;
}
```
	
Ainsi, on pointe vers le nombre2 : 

```c
ptr_nombre = &nombre2;
```

Si on veux modifier la valeur, on utilise une étoile :

```c
*ptr_nombre = 3;
```
	
Si on teste le printf(), il nous affichera 3 et plus 15.

> La seul chose à savoir (voir la vidéo sur les pointeurs), c'est que si :

```c
*ptr = valeur de la variable pointée
ptr = adresse de la variable pointée
	
afficher ptr avec %d : adresse du pointeur lui-même.
	
EXCEPTION : A la déclaration (et éventuellement initialisation parce qu'on est pas obliger d'initialiser au début)

			*ptr = pointeur
```
	
Rem. En effet, on pourrait faire un pointeur comme ce qui suit, ce qui n'est pas propre du tout.
```c
int *ptr_nombre;
```
	Le mieux est de l'initialiser à NULL par défaut :
```c
int *ptr_nombre = NULL;
```

C'est la seul exception (*ptr = pointeur), c'est à dire qu'au moment où l'on déclare, c'est le seul moment où l'on met quand même l'étoile. Pourtant, on a dit que l'étoile était la valeur de la variable pointée.

```c
int *ptr_nombre = NULL;
```

A ce niveau, on a encore rien créé donc quand on met l'étoile au début, c'est pour dire on veux un pointeur.

Par contre, une fois que le pointeur a été déclaré. A partir du moment, on l'on met l'étoile, comme il est déjà créé, il va effectivement prendre la valeur de la variable pointée.

## En résumé

Si certaines choses ne paraissent pas clair. Il est recommandé de voir les vidéos en questions au sujet des 
boucles, des variables, des pointeurs.

Ici ce sont vraiment les bases, tout ceci va être manipulé tout le temps. Les pointeurs vont être manipulés
de manière basique comme on manipulerait des entiers.

Pour continuer la formation, il faut être à l'aise avec les pointeurs. Il faut donc acquérir les connaissances
suffisantes pour poursuivre la formation. 

Il faut maitriser tout ces rappels de programmation, il faut savoir ce qu'est un pointeur et à quoi cela sert.

Si on est pas capable de donner à quelqu'un la définition d'un pointeur de manière très simple, c'est
embêtant. Pourtant un pointeur est très simple.
		
Un pointeur, c'est juste une donnée qui pointe vers une variable, c'est tout.

C'est juste une variable qui stocke l'adresse d'une autre.

## Définition pointeur :

C'est une variable. On le crée comme une variable sauf qu'on met une étoile.
C'est une variable qui stocke l'adresse d'une autre variable.
C'est la définition la plus simple.
Un pointeur on y stocke que des adresses d'autres variables et c'est sur ces autres variables qu'on a un entier, un charactère, un float, etc.

Nous aurons vu quelques petits rappels dans cette vidéo.
Pour la suite, les 6 premières vidéos, nous verons de la théorie et de nouvelles notions pour la prochaine séance.