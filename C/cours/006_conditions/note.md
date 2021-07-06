# [6. Conditions](https://www.youtube.com/watch?v=_MP8yZjQCgk)

Bonjour à tous et bienvenue pour cette 6e séance sur le langage c.

Maintenant que vous avez vu les opérateurs, nous allons en voir d'autres mais nous allons surtout parler d'une nouvelle notion de ce langage et d'autres langages de programmation d'ailleurs on va parler des conditions.

Une condition c'est très rapidement une manière d'effectuer des tests de vérification sur des variables en général ou même sur des valeurs en dur éventuellement ou sur des retours de fonction mais ça on le verra par la suite quand on abordera les fonctions pour vérifier certaines choses.

Par exemple qu'est-ce qu'on fait si le résultat attendu est validé, ou si le test a échoué, voilà on va vraiment réagir en fonction du résultat obtenu par rapport à ces tests qui sont effectués.

On parle de **structure conditionnelle** c'est-à-dire réaliser des traitements sous la condition que quelque chose est vrai, est valider ou pas.

On va regarder ça ensemble avec des petits exemples assez basiques puisque le but c'est de vous présenter les nouvelles syntaxes que l'on va présenter dans cette séance et surtout les nouvelles notions notamment la notion des structures conditionnelles.

## if

La première structure très simple ça va être une structure en if() donc on va parler aussi de else().

if() va être un mot-clé qu'on va utiliser pour dire *si*, si quelque chose est validé d'accord nous allons regarder par rapport à ça.

D'abord nous allons partir d'une simple variable, cet exemple ne sera pas forcément très intéressant ou très parlant mais c'est surtout histoire de ne pas alourdir où complexifier la notion donc je vais rester sur quelque chose de très basique c'est à dire un nombre que je saisie en dur c'est à dire manuellement ici dans mon code `int nombre = 0;`.

```c
#include <stdio.h>

int main(void)
{
    int nombre = 0;

    return 0;
}
```

Voilà on récupère l'information en dur car on ne va pas commencer à faire du scanf(), de la saisie et cetera ça ne servira à rien pour ce que j'ai à vous expliquer ici.

Ici je vais faire un test tout simple, je vais faire une condition donc un if() avec notre mot-clé puis des parenthèses et entre les parenthèses sont mais le test que l'on veut effectuer.

```c
#include <stdio.h>

int main(void)
{
    int nombre = 0;

    return 0;
}
```

Par exemple moi je veux voir que nombre est égal à 0, s'il est égal à 0 je veux pouvoir le dire si ce n'est pas le cas qu'on dise autre chose mais ça on le fera par la suite donc je vais mettre `if(nombre == 0)`.

```c
#include <stdio.h>

int main(void)
{
    int nombre = 0;

	if(nombre == 0)

    return 0;
}
```

Voilà ça c'est le test que l'on veut vérifier.

Voilà en fonction de ça je vais vérifier un certain nombre de choses et pour ça je vais d'abord commencer par ouvrir des accolades mais sachez que si vous n'avez qu'une seule instruction dans le if(), les accolades sont facultatives.

Voyez les accolades c'est comme pour une fonction, les fonctions ont besoin de leurs accolades c'est un peu obligatoire par contre si vous n'avez qu'une seule instruction dans le if() avec un autre bloc de if qu'on verra par exemple par la suite les accolades ici sont facultatives et donc elles ne sont pas obligatoires.

Si vous voulez bien à présenter le code vous pouvez laisser les accolades tout le temps, ça marchera dans tous les cas après c'est juste une question de présentation ou simplement de pouvoir gagner quelques lignes de code tout simplement.

On va donc vérifier ça et on va dire tout simplement que le nombre vaut bien 0.

```c
#include <stdio.h>

int main(void)
{
    int nombre = 0;

    if(nombre == 0)
    {
        printf("Nombre vaut bien 0.\n");
    }

    return 0;
}
```

Très simple c'est tout simplement pour introduire la notion de if() donc on va regarder ça et on va tester notre programme et on va l'exécuter.

```powershell
gcc main.c -o prog
prog.exe
Nombre vaut bien 0.
```

Voilà il me met que le nombre vaut bien 0 donc le test a fonctionné effectivement par rapport à ce que j'ai déclaré et la valeur que j'ai initialisé `int nombre = 0;`.

On a bien 0.

Maintenant si je modifie la valeur ici `int nombre = 14;`.

On enregistre le fichier et on exécute.


```powershell
gcc main.c -o prog
prog.exe
```

Alors ici il n'affiche plus rien tout simplement parce que le nombre n'est plus égal à 0 donc ce qui est dans l'accolade il ne l'a pas exécuté.

Avant de voir cette vidéo vous avez vu que chaque instruction était exécutée à la suite dans tous les cas mais là il y a certains cas ou les instructions ne seront pas exécutées suivant certaines conditions.

Effectivement nombre n'est plus égal à 0 donc ça ne fonctionne pas.

## Opérateurs de comparaisons

Alors ça `==` c'est un premier opérateur de comparaison tel qu'on a vu les opérateurs pour les calculs la dernière fois mais là on va parler des opérateurs de comparaison.

Il n'y a pas que celui-là, il y en a d'autres, je vais vous les lister ici.

```c
	/*
		==	: égal à
		!=	: différent de
		<	: plus petit que
		>	: plus grand que
		<=	: plus petit ou égal à
		>=	: plus grand ou égal à
	*/
```


Voilà ça ce sont les opérateurs de comparaison, tiens par exemple si je veux tester que nombre est plus petit à 20, je fais simplement ceci.


```c
#include <stdio.h>

int main(void)
{
    int nombre = 14;

    if(nombre < 20)
    {
        printf("Nombre est inferieur a 20.\n");
    }

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Nombre est inferieur a 20.
```


On relance et effectivement nombre est inférieur à 20 puisqu'il est égal à 14.

C'est tout de suite je mets une valeur plus grande à 20, encore une fois on n'aura rien qui s'affichera à l'écran.


```c
#include <stdio.h>

int main(void)
{
    int nombre = 34;

    if(nombre < 20)
    {
        printf("Nombre est inferieur a 20.\n");
    }

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
```


Voilà on n'a rien qui s'affiche à l'écran.

Je pense que c'est clair, vous avez bien compris les opérateurs mais je ne vais pas tous vous les détailler parce que c'est le même fonctionnement que les opérateurs mathématiques.

On teste une condition ici `nombre < 20`, si cette condition est vraie et qu'elle renvoie quelque part 1 parce que n'oubliez pas qu'en informatique ce qui est vrai c'est la valeur 1, ce qui est faux (false) c'est la valeur 0.

Voilà c'est toujours comme ça en informatique pour représenter le code binaire, 1 le courant passe et 0 le courant ne passe pas.

Voilà c'est pareil 1 c'est vrai et 0 c'est faux.

Là `nombre < 20`, on peut dire que cette condition va renvoyer 1 et quand vous faites un `if(1)` c'est considéré comme vrai.

Si vous faites un `if(0)` c'est considéré comme faux.

Donc automatiquement il va faire ce qu'il y a dans les accolades si `nombre < 20` est validé.

Ainsi vous pouvez utiliser n'importe lequel de ces opérateurs, ça fonctionnera avec cette fameuse condition if().

## else

Alors je voudrais rajouter une petite chose maintenant mais je ne fais rien si jamais la condition n'est pas validée.

Pour ça on peut utiliser un autre mot-clé qu'on ajoute à la suite c'est à dire le mot else qui veut dire sinon d'accord.


```c
#include <stdio.h>

int main(void)
{
    int nombre = 34;

    if(nombre < 20)
    {
        printf("Nombre est inferieur a 20.\n");
    }
	else
	{
		printf("Nombre est plus grand que 20.\n");
	}

    return 0;
}
```

C'est le nombre est plus petit que 20 alors tu vas faire tout ce qu'il y a dans le if() sinon tu vas faire autre chose.


Donc là j'affiche simplement que le nombre est plus grand que 20.

On peut compiler et on exécute.

```powershell
gcc main.c -o prog
prog.exe
Nombre est plus grand que 20.
```

On exécute et là, il me met bien que le nombre est plus grand que 20.

Si je change la valeur pour avoir un nombre plus petit que 20, il va bien me prendre en compte que le nombre est inférieur à 20.

```c
#include <stdio.h>

int main(void)
{
    int nombre = 16;

    if(nombre < 20)
    {
        printf("Nombre est inferieur a 20.\n");
    }
	else
	{
		printf("Nombre est plus grand que 20.\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Nombre est inferieur a 20.
```

Voyez que c'est bien évidemment pris en compte selon les cas donc là par rapport à ce genre de code on ne peut évidemment pas exécuter tout ce qu'il y a dans les deux accolades, c'est soit exécuter le if() soit on va exécuter le else.

Ce sera forcément l'un ou l'autre puisqu'on a un if ou else donc on ne peut pas rentrer dans les 2, c'est soit l'un soit l'autre automatiquement.

Alors nous avons un autre cas, on peut avoir entre 2 et faire un else if(), et sinon on fait un autre test, et ainsi de suite.

On peut faire autant de tests que l'on veut et on finit toujours par un else.

C'est bien de mettre un else ça permet de faire quelque chose dans tous les cas c'est à dire que si on ne rentre pas dans la condition, on fera quelque chose au cas où.

## Test booléen et opérateur de négation

On va prendre par exemple le test avec un booléen `int jeu_demarre = 1;`, rappelez-vous que le 1 correspond à True ou vrai tandis que 0 ce serait faux.

Ainsi je peux tester tout simplement en faisant comme ceci `if(jeu_demarre == 1)` mais comme il s'agit ici de vérifier si c'est vrai ou faux on peut carrément mettre le nom de la variable `if(jeu_demarre)`.


```c
#include <stdio.h>

int main(void)
{
    int jeu_demarre = 1;

    if(jeu_demarre)
    {
        printf("Bienvenue sur le jeu.\n");
    }
	else
	{
		printf("Le jeu n'a pas ete lance...\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bienvenue sur le jeu.
```

Voilà ça c'est une possibilité et lorsqu'on exécute ceci il nous met Bienvenue sur le jeu parce qu'effectivement le jeu a été démarré.

Si je mets à 0, on test.

```c
#include <stdio.h>

int main(void)
{
    int jeu_demarre = 0;

    if(jeu_demarre)
    {
        printf("Bienvenue sur le jeu.\n");
    }
	else
	{
		printf("Le jeu n'a pas ete lance...\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Le jeu n'a pas ete lance...
```

En test et il nous met que le jeu n'a pas été lancé.

Ça c'était une petite précision c'est à dire que dans un if() vous pouvez simplement mettre le nom de la variable s'il s'agit de tester que c'est vrai ou faux tout simplement et si vous voulez tester l'inverse vous mettez un !


```c
#include <stdio.h>

int main(void)
{
    int jeu_demarre = 0;

    if(!jeu_demarre)
    {
        printf("Bienvenue sur le jeu.\n");
    }
	else
	{
		printf("Le jeu n'a pas ete lance...\n");
	}

    return 0;
}
```

`if(!jeu_demarre)` ici c'est tout simplement pour dire n'est pas égal à 1, il est donc à 0 et donc là on va retrouver l'effet inverse.

```powershell
gcc main.c -o prog
prog.exe
Bienvenue sur le jeu.
```

Il dit évidemment que le jeu a démarré parce qu'il vérifie en fait si c'était égal à 0 `if(!jeu_demarre)`.

Donc en gros si le jeu_demarre est égal à faux, est égal à 0 ? Oui il est égal à 0 donc je fais ça.

Voilà ça c'était une petite précision par rapport au if().

## else if


Alors on va faire autre chose par rapport à l'âge cette fois-ci, et on va pouvoir faire un else if() qui veut dire sinon si.

Voilà si c'est vrai il va faire if(age < 1) et si c'est faux il va faire la condition suivante donc le nouveau else if(age == 10) admettons par exemple sinon si age est égal à 10 par exemple. Et si l'âge n'est ni plus petit que 1, ni égal à 10, on peut mettre autre chose mais nous on va l'afficher admettons.

```c
#include <stdio.h>

int main(void)
{
    int age = 15;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age == 10)
	{
		printf("Tu as 10 ans !\n");
	}
	else
	{
		printf("Age : %d\n", age);
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Age : 15
```


Voilà on teste et là il nous met que âge est égal à 15 si on ne s'est pas trompé dans le drapeau (%d).

Maintenant si on met une valeur de 0, là théoriquement il va nous mettre qu'on n'est pas né.

```c
#include <stdio.h>

int main(void)
{
    int age = 0;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age == 10)
	{
		printf("Tu as 10 ans !\n");
	}
	else
	{
		printf("Age : %d\n", age);
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu n'es pas ne.
```


Voilà et si je mets que c'est égal à 10 il va nous afficher que tu as 10 ans.


```c
#include <stdio.h>

int main(void)
{
    int age = 10;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age == 10)
	{
		printf("Tu as 10 ans !\n");
	}
	else
	{
		printf("Age : %d\n", age);
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu as 10 ans !
```


Voilà on peut comme ça faire une succession de conditions, on aura comme ça un seul if() par contre les else if() qui sont collés au if() on peut en mettre autant que l'on veut mais par contre un seul else() tout à la fin.

Par contre si vous faites ceci, 2 if() à la suite, il faut qu'il soit séparé.

```c
#include <stdio.h>

int main(void)
{
    int age = 10;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }

	if(age == 10)
	{
		printf("Tu as 10 ans !\n");
	}
	else
	{
		printf("Age : %d\n", age);
	}

    return 0;
}
```

Ainsi le premier if(age < 1) va essayer de se faire tout seul mais si on ne rentre pas dedans, on passe au test suivant if(age == 10) et si l'âge n'est pas égal à 10 on fait le else c'est à dire que le else tout à la fin ne sera que lié au if() au-dessus, auquel il est rattaché. Voilà le else n'est pas rattaché au if(age < 1) donc ça c'est important aussi.

Si on veut que tout soit imbriqué ensemble, on colle toutes les conditions (pas d'espace) et comme on ne peut avoir qu'un seul if() c'est à dire le premier, pour les autres on va mettre des else if().

Ainsi on fait tous les tests que l'on veut, et on termine à la fin par un else pour avoir un dernier cas de secours en fait donc qu'est-ce qu'on fait c'est aucune condition n'a été validé.

## Opérateurs de tests multiple

Maintenant j'aimerais bien pouvoir faire un test un peu plus développé avec une fourchette, par exemple de dire cela j'ai compris entre 1 et 100.

On va pouvoir faire des tests multiples, et pour ça on va utiliser d'autres opérateurs, il y a par exemple le double est commercial (&&) qui veut simplement dire ET. On va avoir la double barre verticale (||) qui est le OU. Et si vous faites ce qu'on a vu tout à l'heure c'est à dire le ! pour le NOT signifie n'est pas mais ça on l'a déjà vu tout à l'heure.


```c
	/*
		==	: égal à
		!=	: différent de
		<	: plus petit que
		>	: plus grand que
		<=	: plus petit ou égal à
		>=	: plus grand ou égal à

		&&	: ET
		||	: OU
		!	: NOT
	*/
```

Voilà on va voir ça très rapidement avec cet exemple aussi, par exemple `else if(age >= 1 && age <= 100)` c'est à dire que je pars du principe que dans mon programme on peut pas les plus de 100 ans.


```c
#include <stdio.h>

int main(void)
{
    int age = 10;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age >= 1 && age <= 100)
	{
		printf("Tu as un age compris entre 1 et 100 ans\n");
	}
	else
	{
		printf("Wahh, tu as plus de 100 ans !!!\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu as un age compris entre 1 et 100 ans
```

Voilà effectivement on a un âge compris entre un et 100 puisque l'âge est égal à 10.

Si maintenant jamais par exemple que l'âge est égal à -5, on peut imaginer des choses un peu bizarres.

```c
#include <stdio.h>

int main(void)
{
    int age = -5;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age >= 1 && age <= 100)
	{
		printf("Tu as un age compris entre 1 et 100 ans\n");
	}
	else
	{
		printf("Wahh, tu as plus de 100 ans !!!\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu n'es pas ne.
```

Si maintenant je lui mets un âge elfique (375) par exemple.


```c
#include <stdio.h>

int main(void)
{
    int age = 375;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if(age >= 1 && age <= 100)
	{
		printf("Tu as un age compris entre 1 et 100 ans\n");
	}
	else
	{
		printf("Wahh, tu as plus de 100 ans !!!\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Wahh, tu as plus de 100 ans !!!
```

Voilà si on met un âge elfique par exemple, il nous met qu'on a plus de 100 temps donc ça fonctionne évidemment ici avec des tests multiples.

Voilà vous mettez tout simplement une condition, et vous mettez un opérateur de conditions multiples (&& ou ||) pour faire des conditions à la suite, ainsi vous pouvez en faire autant que vous voulez une 2e, une 3e, une 4e autant que vous voulez.


Alors je rappelle, car c'est une erreur qu'on fait souvent en programmation quand on débute il faut savoir que quand on fait un &&, toutes les conditions qui sont rattachées avec des && doivent être validés admettons que `age <= 1` et validée mais que `age <= 10` ne l'est pas, ça ne marchera pas.

C'est ça que parfois des gens ont du mal à comprendre, le fait qu'on dise ET, il faut vraiment que les 2 soient validés.

C'est par exemple on vous dit il faut que votre sac soit rouge et qu'il soit grand mais s'il est rouge mais pas grand, ou grand et pas rouge, ça ne marchera pas !

Tandis que si vous avez le OU (||) c'est qu'une seule des conditions c'est à dire que si je faisais ça `age >= 1 || age <= 100` il faudrait juste que l'âge soit plus grand ou égal à 1 ou alors qu'il soit plus petit ou égal à 100 c'est à dire que c'est l'une ou l'autre condition qui doit être satisfaite et si c'est le cas on rentre dans la condition et on exécute les instructions.

Voilà tout ça c'est à savoir et le !, On l'a vu tout à l'heure donc je ne reviens pas dessus.

On peut mettre également comme pour les opérateurs, ce que je vous avais expliqué dans la vidéo précédente, on peut mettre des parenthèses par exemple :

```
else if((age >= 1 && age <= 100) || age == 375)
{}
```

Voilà alors là qu'est-ce qu'il dit ? Il dit qu'il doit d'abord vérifier que là j'ai compris entre 1 et 100 donc il va faire ça en priorité parce que vous voyez qu'il y a des parenthèses c'est toujours prioritaire, ou alors il va vérifier que l'âge est égal à 375.

```c
#include <stdio.h>

int main(void)
{
    int age = 375;

    if(age < 1)
    {
        printf("Tu n'es pas ne.\n");
    }
	else if((age >= 1 && age <= 100) || age == 375)
	{
		printf("Tu as un age compris entre 1 et 100 ans\n");
	}
	else
	{
		printf("Wahh, tu as plus de 100 ans !!!\n");
	}

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu as un age compris entre 1 et 100 ans
```


Voilà comme on avait mis un âge de 375, il rentre du coup dans le else if().

Voilà ça c'est aussi important à savoir.

On peut avoir comme ça des priorités de vérification `(age >= 1 && age <= 100)` en mettant comme ça des parenthèses dans le if() c'est tout à fait possible.

Des fois vous en aurez besoin et peut être des fois vous n'en aurez pas besoin donc c'est vous qui voyez en fonction de ce que vous voudrez faire au niveau de la priorité des tests à effectuer.

Là je vous ai dit tout ce qu'il fallait savoir sur le if(), je vous expliqué le else if(), je vous expliqué le else donc normalement nous avons tout vu.

Alors je pourrais également vous parler du switch() et on parlera à la fin du ternaire mais je vous expliquerai ça rapidement pour pouvoir terminer la vidéo.

Voilà il n'y avait pas grand-chose à voir quand même.

## switch

Alors nous allons voir ce qui est en switch.

Alors le switch contrairement à d'autres langages de programmation c'est un test qui va s'effectuer que sur une variable qui était un nombre, on ne peut pas faire ça par exemple sur une variable qui serait une chaîne de caractères même si les chaînes de caractères nous n'en avons pas encore parlé à ce stade de la formation mais on va en parler par la suite.

On va justement prendre notre fameux âge de tout à l'heure, et on va faire un switch() sur age c'est à dire qu'on va d'abord commencer par ouvrir des accolades et dès le début on pense au default.

```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		default:
	}
}
```

Voilà le default c'est le truc qui va être tout en bas, c'est à dire qu'est ce qui va être fait si on ne rentre dans aucune des conditions qui va être au-dessus ? Donc si vous ne voulez rien faire vous mettez tout simplement le mot clé break comme ceci.

```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		default:
			break;
	}
}
```

Voilà pour dire tout simplement que si on ne rentre pas dans les conditions que l'on va marquer par la suite, on quitte avec le mot-clé break donc c'est mieux de le mettre comme ça vous êtes sûr de ne pas l'oublier, vous le mettez dès le début donc ça c'est le minimum.

Ensuite on va mettre les cas possibles donc je vais mettre dans le cas donc avec le mot-clé case et comment on fait un switch sur age, on teste si âge serait égal à 0.


```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		case 0:

		default:
			break;
	}
}
```

Voilà on peut pas mettre des opérateurs, on met simplement un nombre précis, on met : et ensuite à la suite avec une tabulation ça c'est vous qui mettez en page votre code comme vous voulez mais moi je préfère le mettre comme ça parce que c'est ma manière de faire et rappelez-vous que le langage c est assez flexible à ce niveau-là par exemple moi je vais mettre un printf() un peu bizarre.

```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		case 0:
			printf("Tu as 0 an.\n");
			break;

		default:
			break;
	}
}
```

Ensuite on n'oublie pas de mettre un break, le break va simplement dire de sortir du switch c'est important sinon il va s'amuser à tout tester et ça va être n'importe quoi donc en général on met en break à la fin sauf si bien sûr vous quittez le programme il ne servira à rien mais là comme on ne quitte pas le programme c'est mieux de le mettre.

Ensuite je peux tester d'autres cas, c'est pour ça qu'on utilise le mot clé case par exemple dans le cas où l'âge serait égal à 15 et là qu'est-ce que je teste ? par exemple moi je vais mettre un printf().

```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		case 0:
			printf("Tu as 0 an.\n");
			break;

		case 15:
			printf("Age vaut 15.\n");
			break;

		default:
			break;
	}
}
```

Voyez ce sont des tests assez particuliers bien évidemment et maintenant on va tester.

```powershell
gcc main.c -o prog
prog.exe
```

Donc là évidemment ça ne rentre dans aucun cas puisque pour default je ne fait rien mais je pourrais y mettre quelque chose par exemple la printf().


```c
#include <stdio.h>

int main(void)
{
	int age = 375;

	switch(age)
	{
		case 0:
			printf("Tu as 0 an.\n");
			break;

		case 15:
			printf("Age vaut 15.\n");
			break;

		default:
			printf("Tu n'as ni 0 an, ni 15 ans.\n");
			break;
	}
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu n'as ni 0 an, ni 15 ans.
```

Voyage du coup il affiche ce message.

Si on met maintenant un âge qui correspond à un des case, il va rentrer dans le cas particulier et sortir avec son break.

```c
#include <stdio.h>

int main(void)
{
	int age = 15;

	switch(age)
	{
		case 0:
			printf("Tu as 0 an.\n");
			break;

		case 15:
			printf("Age vaut 15.\n");
			break;

		default:
			printf("Tu n'as ni 0 an, ni 15 ans.\n");
			break;
	}
}
```
```powershell
gcc main.c -o prog
prog.exe
Age vaut 15.
```

Voilà donc avec le break il va tout simplement quitter le switch().

C'est une autre mise en forme, je vous conseille en général d'utiliser le switch quand vous avez notamment par exemple plus de 3 if() qui se suivent ainsi on va dire à partir de 4 c'est mieux d'utiliser un switch() parce que vous allez gagner du temps.

Ce n'est pas du tout obligatoire on peut très bien programmer sans faire de switch(), c'est vraiment pas une obligation mais j'en parle parce que ça peut être utile pour gagner du temps mais vous pouvez très bien ne jamais utiliser de switch() dans votre programme ça fonctionnera très bien.

Voilà pour les switch().

Maintenant on va voir les ternaires.

## ternaire

Un ternaire c'est simplement une condition qui va être faite sur une seule ligne mais elle va prendre qu'un seul cas c'est à dire que vous avez la condition à poser, et vous avez l'exécution à faire si le test est validé où l'exécution à faire si le test n'est pas validé.

Alors comment est-ce que ça va se composer ? Alors on commence par ouvrir des parenthèses directement et on va demander si l'âge est égal à 15.


```c
#include <stdio.h>

int main(void)
{
	int age = 15;

	(age == 15)

	return 0;
}
```

D'accord et comme je veux me poser une question je vais faire un test donc je vais mettre un ? En dehors des parenthèses, c'est vraiment important de respecter cette syntaxe c'est à dire que dans des parenthèses on met la condition ensuite on met le ? Et juste après le ? on met ce qu'il y a à faire si la condition est vraie par exemple nous on va faire un printf().

```c
#include <stdio.h>

int main(void)
{
	int age = 15;

	(age == 15) ? printf("Tu as 15 ans.\n")

	return 0;
}
```

Et sinon donc on va mettre : pour bien différencier et là on fait printf() pour lui dire qu'il n'a pas 15 ans.


```c
#include <stdio.h>

int main(void)
{
	int age = 15;

	(age == 15) ? printf("Tu as 15 ans.\n") : printf("Tu n'as pas 15 ans.\n");

	return 0;
}
```


Voilà pour la syntaxe.

Donc on lui dit de tester `(age == 15) ?` ça c'est la condition, ensuite si l'âge est égal à 15 on fait ce qu'il y a après le ? Sinon tu fais ce qu'il y a après les : donc voyez que là il y a une séparation comme ça avec : qui sépare si c'est vrai ou si ce n'est pas vrai.

On test.

```powershell
gcc main.c -o prog
prog.exe
Tu as 15 ans.
```

Voilà on teste le programme et il nous met qu'on a 15 ans.

Si on met que l'âge est égal à 37.

```c
#include <stdio.h>

int main(void)
{
    int age = 37;

    (age == 15) ? printf("Tu as 15 ans.\n") : printf("Tu n'as pas 15 ans.\n");

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Tu n'as pas 15 ans.
```

Voilà tu n'as pas 15 ans tout simplement, c'est une manière de faire un test sur une seule ligne quand on veut faire qu'une seule chose par exemple on utilise souvent le ternaire pour mettre une valeur dans une variable.

Voilà par exemple on pourrait tester pour voir s'il a 15 ans comme ceci.

```c
#include <stdio.h>

int main(void)
{
    int age = 37;
	int il_a_quinze_ans = -1;

    il_a_quinze_ans = (age == 15) ? 1 : 0;

	printf("Il a quinze ans = %d\n", il_a_quinze_ans);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Il a quinze ans = 0
```

Alors pour une assignation, on met `1 : 0` donc si c'est vrai c'est égal à 1 si c'est faux c'est égal à 0, et comme ici on va stocker quelque chose donc on va avoir un retour, on le stock dans une variable de cette manière `il_a_quinze_ans = (age == 15) ? 1 : 0;`.


Voilà on dit tout simplement qu'il a 15 ans est égal au résultat de cette condition `(age == 15)` voyez donc on stocke le ternaire dans une variable.

Alors si c'est vrai en stock 1 et si c'est faux on stock 0. 

Voilà et si je mets 15 il va marquer que c'est égal à 1 donc vrai.

```c
#include <stdio.h>

int main(void)
{
    int age = 15;
	int il_a_quinze_ans = -1;

    il_a_quinze_ans = (age == 15) ? 1 : 0;

	printf("Il a quinze ans = %d\n", il_a_quinze_ans);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Il a quinze ans = 1
```

Voilà ça c'est tout simplement ce qu'il y avait à voir pour le ternaire.

Le ternaire c'est pareil c'est juste une méthode raccourcie pour faire une condition simple comme ça.

On peut des fois stocker en résultat simple dans une variable et en mettant le ternaire on affecte le résultat de d'un ternaire dans une variable qu'on peut ensuite exploiter dans notre programme.

C'est tout ce que je voulais vous montrer au niveau des structures conditionnelles, c'est à dire le fameux il() else, else if() éventuellement, le switch() qui est important également à savoir pour gagner du temps, et le ternaire qui est un petit plus à connaître.

En effet des fois vous pourriez tomber sur ce genre de syntaxe et ne pas savoir que c'est un ternaire et ne pas savoir en quoi ça consiste parce qu'il y a beaucoup de petits caractères et ce n'est pas forcément logique au premier coup d'œil.

On va s'arrêter là pour cette vidéo, c'était les conditions.

Pour la prochaine vidéo nous parlerons des boucles donc c'est une nouvelle notion également du langage et on se retrouvera là-dessus avec d'autres exemples pour mettre en place tout ça.

On travaillera sur des conditions et tout ça parce que vous allez les employer un petit peu partout dans vos programmes.

À très bientôt pour la séance numéro 7

