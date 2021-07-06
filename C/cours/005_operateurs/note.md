# [5. Opérateurs](https://www.youtube.com/watch?v=imc6C96-TW8)

Bonjour à tous on se retrouve pour la 5e séance en langage c, aujourd'hui on va voir tout ce qui concerne quelques opérateurs de base.

On ne les verra pas tous parce qu'il y a des opérateurs de décalage, il y a des opérateurs de comparaison mais ça enlèvera par la suite mais nous on va se contenter des opérateurs de calcul, ceux qui vont permettre de faire des sommes, des produits, des différences ce genre de chose et vous allez déjà voir un opérateur que vous connaissez très bien qui est l'opérateur d'affectation (=).

## Les différents opérateurs

L'opérateur d'affectation c'est celui qu'on utilisait pour affecter des valeurs à nos variables.

Rapidement parce que ça concerne les mathématiques, c'est des choses que vous avez certainement vu à l'école, à l'université ou ailleurs bref je veux aller très très vite dessus.

Ah si on retrouve 4 opérateurs standard, que ce soit dans le langage c ou dans d'autres langages également, c'est une norme une convention qui a été décidée pour tous les langages de programmation.

On va retrouver le + qui est le symbole de l'addition, on va retrouver le tiret - ou le moins sur le pavé numérique qui concerne la soustraction. On va retrouver l'étoile * pour la multiplication et le slash / donc la barre oblique qui penche vers la droite et pas celle vers la gauche pour la division.

```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)
*/
```

Voilà ce sont les 4 opérateurs de base que vous aurez l'occasion d'utiliser à de nombreuses reprises au niveau de vos programmes, je vais vous en donner un 5e que vous avez peut être vu à l'université ou autre mais je tiens quand même à le préciser pour tout le monde c'est l'opérateur qu'on utilise avec le symbole %, qui est l'opérateur de modulo.
```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)
	%	(modulo)
*/
```

À quoi sert le modulo ? C'est très simple c'est à dire que pour une division je prends notre exemple ici, si je fais 5 divisé par 2 en ne prenant en compte que des nombres entiers c'est à dire pas des nombres à virgule, on obtiendrait 2.
```txt
/	(division) 	-> 5 / 2 = 2
```
Voilà parce qu'on peut multiplier, 2 fois 2 font 4 et on aura un reste mais on s'en fiche parce comprend des nombres entiers, on ne fais pas 2,5.

Le modulo, ça tombe bien, c'est le fameux reste de la division ainsi si vous faites un 5 % 2, le résultat sera 1 donc c'est le fameux reste de la division.
```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1
*/
```

Le fameux reste de cette division Euclidienne sera 1 donc le fameux reste de la division de 5 divisé par 2.

Alors au niveau de l'utilisation du modulo, il peut servir parfois à vérifier si le nombre est pair ou impair, par exemple est ce que le reste d'une division par 2 d'un nombre est égal à 0 donc il est pair sinon il est impair.

On peut s'en servir comme ça de plusieurs manières, et dans certains calculs aussi, en cryptographie aussi on peut s'en servir donc permettre de petites choses donc il est très très utile et il peut servir dans certains cas concrets en programmation informatique.

Alors je suis passé très rapidement au niveau de ces opérateurs parce que c'est quelque chose que vous connaissez bien pour la plupart, et que vous aurez l'occasion de vous servir dans votre programme.

Nous ce qui va nous intéresser c'est de voir comment procéder à des calculs, où est-ce qu'on peut faire les calculs ? En tout cas pas comme ceci en plein milieu du programme.

```c
#include <stdio.h>

int main(void)
{
	6 + 4
	return 0;
}
```

Le mettre comme ça en plein milieu du programme ce n'est pas possible, il faut encore et toujours utiliser nos fameuses variables, c'est pour ça qu'on a vu ça dès le début de la formation puisque les variables permettent de stocker tout et n'importe quoi.

Les variables peuvent stocker non seulement un nombre que l'on va noter mais on peut également stocker le résultat d'un calcul, je peux très bien faire `int calcul = 6 + 4;` et puis avec un petit printf() on va afficher le résultat du calcul.

```c
#include <stdio.h>

int main(void)
{
	int calcul = 6 + 4;

	printf("%d\n", calcul);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
10
```

Voilà on obtient viens à 10, le calcul est fait.

On peut même dans ce cas-là parce que c'est un cas très très simple se passer de variable carrément et on peut mettre ainsi les calculs directement en dur dans le printf() c'est tout à fait possible parce que je rappelle que le drapeau, le %d, attend un nombre entier donc là c'est effectivement ce que ça va donner donc 6 plus 4.

```c
#include <stdio.h>

int main(void)
{
	printf("%d\n", 6 + 4);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
10
```

Même chose on obtient le même résultat sans utiliser de variable d'une manière différente.

Voilà vos calculs ils peuvent être à l'affichage, ils peuvent être stockés dans une variable, ils peuvent même être en appel de fonction comme on le verra plus tard dans les prochaines vidéos.

Il y a pas mal de petites choses dans les prochaines vidéos comme ça on a la possibilité de procéder à des calculs au sein de notre programme.

Nous ce qui va être intéressant c'est surtout d'effectuer des calculs de variables parce que là vous avez vu que je faisait la somme de 6 plus 4 qui sont des nombres à en dur mais je peux très bien faire la somme de 2 variables, ça fonctionne évidemment, on peut très bien faire ceci.

```c
#include <stdio.h>

int main(void)
{
	int nb1 = 6;
	int nb2 = 3;
	printf("%d\n", nb1 + nb2);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
9
```

Voilà c'est évidemment bien la même chose, ça fonctionne aussi et c'est là que ça va devenir intéressant, je vais vous donner un petit exemple très sympathique qui est très simple à comprendre mais qui va bien vous permettre d'assimiler un petit peu c'est parti là.

Vous savez dans ma vidéo je reprends souvent l'exemple du jeu vidéo, tous les algorithmes parce que dans le jeu vidéo on retrouve absolument tout les types d'algorithmes, tous les types de problèmes récurrents qu'on peut rencontrer en informatique donc c'est toujours de bons exemples à donner quand on veut enseigner comme ça un langage informatique.

Du coup je vais prendre un exemple encore une fois très simplifié, très basique du niveau d'un joueur admettons par exemple que dans votre jeu vous ayez stocké le niveau de votre personnage dans une simple variable qui serait éventuellement sauvegardé dans un fichier comme on le verra plus tard pour sauvegarder le personnage, ce genre de chose.

Alors on va partir du principe que le niveau du joueur commence à 1, `int niveau_joueur = 1;` et on va l'afficher avec un petit printf.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = 1;
	printf("%d\n", niveau_joueur);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
1
```

Voilà donc là on va afficher le niveau du joueur, le niveau est de 1.

## Affectation statique

Ce qui est intéressant ici c'est de bien évidemment pouvoir changer l'affectation de variable et notamment pouvoir changer des valeurs via des calculs.

Admettons que votre petit personnage vient de faire des quêtes, il a progressé dans le jeu et vous avez progressé avec, et vous venez de gagner un niveau.

En temps normal quand on est débutant, quand on ne sait pas trop comment fonctionnent les calculs, les opérateurs etc, on aurait tendance à dire cetair maintenant le niveau de joueur est égal à 2 parce que je suis censé avoir gagné à niveau et donc on imagine qu'il s'est passé pas mal de choses entre ces 2 étapes.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = 1;
	printf("Niveau : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur = 2;
	printf("Niveau : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Niveau : 1
Niveau : 2
```

En imagine que le personnage a fait des quêtes et du coup il a gagné à niveau donc là au niveau du code ça compile, on voit bien qu'il est passé du niveau un au niveau 2 et à priori pas de problème.

Par contre là on a fait ce qu'on appelle un stockage en dur `int niveau_joueur = 1;` c'est à dire un stockage en statique.

Admettons maintenant que je pars de -1, et puis on vous suit on va choisir un niveau même si dans un jeu vidéo on ne choisit jamais le niveau de départ bien sûr mais c'est encore une fois pour l'exemple ceci.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur = 2;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 1
Niveau de depart : 1
Niveau actuel : 2
```

Je recompile, j'exécute, il me demande un niveau départ et je tape 1 et après avoir fait des quêtes le niveau actuel devient 2. Pareil encore une fois on ne va pas trouver de souci, il ne va pas y avoir de problème.

Voilà ensuite si je m'amuse à faire ceci, que je tape 12, et bien là il va me dire que le niveau passe à 2 donc ici je vais perdre 10 niveaux en fait.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur = 2;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 12
Niveau de depart : 12
Niveau actuel : 2
```

Voilà normalement je suis censé avoir progressé au niveau de la partie donc là il y a un problème puisque j'ai stocké le fameux 2 en dur donc constater qu'au lieu de le gérer de manière dynamique, et c'est là que les calculs sur variables vont être intéressant.

## Affectation dynamique

Pour résoudre cet exemple-là, comment est-ce qu'on va faire ? On va utiliser la valeur de l'ancienne variable c'est à dire qu'est-ce que le nouveau niveau de joueur ? C'est tout simplement le niveau d'avant donc c'est toute l'expérience qu'il a acquis jusqu'à présent auquel on va ajouter 1 donc on va faire `niveau_joueur = niveau_joueur + 1;` 

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur = niveau_joueur + 1;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 1
Niveau de depart : 1
Niveau actuel : 2

prog.exe
Choisir le niveau de depart : 10
Niveau de depart : 10
Niveau actuel : 11

prog.exe
Choisir le niveau de depart : 46
Niveau de depart : 46
Niveau actuel : 47
```

Ça résout tous les problèmes qu'on avait au départ par rapport à ça, si je tape 1 j'arrive bien à 2, si je tape 10 j'arrive à 11 et si je tape 46 j'arrive à 47.

Voilà il n'y a plus aucun problème comme ça tout est géré de manière dynamique à ce niveau là.

Petit raccourci sympa au niveau du langage, quand vous avez ce genre de chose `<variable> = <variable> + X` 

```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X
*/
```

Alors X vous pouvez le remplacer par n'importe quel nombre d'accord ceci `<variable> = <variable> + X` c'est un peu long parce qu'on répète 2 fois le nom de la variable à chaque fois donc on peut trouver un équivalent, une correspondance à `<variable> += X`.


```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X
*/
```


Voilà ce qui est important de savoir au niveau de la priorité des opérateurs, comment mathématique vous savez que la multiplication et la division sont prioritaires donc il passe avant sur le calcul de la soustraction et de l'addition, et bien évidemment les parenthèses sont prioritaires par rapport à tout.

## Priorité des opérateurs

Admettons qu'on ait ce genre de calcul.

```txt
4 + 5 * 6
```

Dans ce cas vous allez avant tout faire 5 * 6, et puis ajouter 4 pour avoir 34 donc si vous laissez tel quel ce résultat là donnera 34.

```txt
4 + 5 * 6 = 34
```

En revanche j'utilise des parenthèses c'est que je fais ceci.

```txt
(4 + 5) * 6 = 54
```


Là je vais d'abord faire le 4 plus 5 qui fait 9, multiplier par 6 donc on obtiendra 54 donc on aura pas du tout le même résultat.

Ainsi c'est important la priorité des opérateurs, c'est comme en mathématique, les multiplications, les divisions et le modulo parce que c'est notre 5e opérateur sont prioritaire par rapport à l'addition et à la soustraction, et dans tous les cas la parenthèse est prioritaire sur tout donc ça c'est à savoir.

Alors comme je vous avais dit il y a également l'opérateur d'affectation, celui que vous utilisez depuis le début avec les variables avec le c'est un peu égal (=).

L'opérateur = et moins prioritaire que ceux-là : + - * / % d'accord c'est à dire qu'on va toujours avoir `niveau_joueur + 1` qui va se faire avant de le affecter à la variable `niveau_joueur = niveau_joueur + 1;`

Ainsi c'est tout ce résultat qu'on stocke dans notre variable, on ne fait pas qu'ajouter niveau_joueur avant d'ajouter le +1 non non non on fait avant tout l'opération donc on ajoutant 1 et après seulement on stock.

Voyez ce n'est pas le même ordre du tout, ça peut complètement changer et dans certains cas ça peut avoir une grosse différence que l'on fasse une incrémentation avant l'affectation ou inversement.

```
niveau_joueur = niveau_joueur + 1;
```

Voilà ici on fait vraiment l'incrémentation de 1 avant d'affecter à la variable, c'est important.

## Raccourcis sur les calculs entre variables

On a également et ça ça fonctionne pour tout, je vais reprendre l'exemple `A = A - X` est la même chose que de faire `A -= X`


```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X
*/
```


Ainsi si on fait `A = A * X` ça revient à la même chose de faire `A *= X` d'accord donc ça fonctionne pour tout tel que les modulo et cetera.


```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X

	A = A * X
	A *= X
*/
```

Pour tous les opérateurs vous pouvez utiliser les fameux raccourcis qui évite de répéter donc ici dans mon code je vais tout simplement faire `niveau_joueur += 1;`


```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur += 1;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 45
Niveau de depart : 45
Niveau actuel : 46
```

Voilà c'est exactement la même chose ça ne fait aucune différence à ce niveau-là, c'est juste une manière d'écrire plus rapidement notre code.

Ça c'était pour les fameux calculs, les raccourcis sur les calculs entre variables même si là il n'y en a qu'une seule pour le coup.

## Incrémentation et décrémentation de 1

Et je vais terminer avec une petite chose à savoir au niveau du langage c qu'on n'a pas forcément dans tous les langages, c'est concernant l'incrémentation et la décrémentation de notamment de 1.

C'est à dire quand vous allez notamment faire une incrémentation de 1, de 1 pas comme quand on le verra plus tard pour parcourir une boucle donc parcourir un tableau par exemple, parcourir une liste chaînée, ce genre de chose vous allez toujours parcourir les éléments 1 par 1, vous n'allez pas les parcourir 2 par 2 sauf dans certains cas exceptionnels.

À ce moment-là il y a des raccourcis qu'ont été inventés en langage c pour gagner du temps à ce niveau.

Alors si vous avez `niveau_joueur += 5;`, ce que je vais vous dire après ne fonctionnera pas c'est-à-dire que le incrémentation et la décrémentation que je vais vous montrer ne fonctionne que si vous voulez réduire ou augmenter de 1. C'est automatiquement pour le 1 et pas pour autre chose donc là si je fais une incrémentation de 5 je suis obligé de passer par cette syntaxe `niveau_joueur += 5;`.

Voilà `A = A - X` avec la valeur X qui peut être remplacé avec n'importe quel nombre.

Par contre ce que je vais vous montrer ne fonctionnera qu'avec un 1 c'est à dire que si vous avez quelque chose comme `A += 1` ou `A -= 1`.


```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X

	A = A * X
	A *= X

-------------------------------------------

	A += 1	-> A = A + 1
	A -= 1	-> A = A - 1
*/
```

Voilà seulement pour ces deux-là.

```txt
A += 1	-> A = A + 1
A -= 1	-> A = A - 1
```


Voilà seulement pour la soustraction et l'addition, il n'y a pas de multiplication ou de division.


Vous avez encore des raccourcis pour ces 2 possibilité là en faisant simplement `A++` ou `A--`.

 ```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X

	A = A * X
	A *= X

-------------------------------------------

	A += 1	-> A = A + 1
	A -= 1	-> A = A - 1

	A++
	A--
*/
```


Vous avez même le `++A` ou le `--A`.

```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X

	A = A * X
	A *= X

-------------------------------------------

	A += 1	-> A = A + 1
	A -= 1	-> A = A - 1

	A++	++A
	A--	--A
*/
```

Alors `A++` signifie tout simplement `A += 1` d'accord ça ne fonctionne pas pour 2 voilà vous n'allez pas vous amuser à mettre `A++++` parce que ça n'existe pas voilà c'est vraiment que pour le 1.

C'est un petit raccourci pour passer de 1 en 1 que ce soit pour additionner de 1, ou soustraire de 1.

## Raccourcis sur les incrémentations et les décrémentations

Alors une petite distinction, vous voyez que les symboles opérateurs d'incrémentation et après `A++` on dit qu'il est en post incrémentation après la variable mais on a des fois aussi en pré incrémentation `++A` qui est avant le nom de la variable.

Ensuite on a une post décrémentation `A--` c'est à l'envers donc on retire 1, ensuite on a une pré décrémentation `--A` donc on retire 1 avant la variable parce que c'est une pré.

Alors la différence au niveau de ces 2 syntaxes, vous ne l'avez pas forcément beaucoup beaucoup dans l'utilisation que vous aurez. Je ne vais pas vous l'expliquer parce qu'on rentre dans des sujets très très techniques puisque ça touche au niveau de la compilation, au niveau des séquences, au niveau des instructions machine donc là carrément on arrive à des choses un peu plus bas niveau pour expliquer un peu la différence entre les 2.

Tout ce que vous avez besoin de savoir c'est surtout dans le cadre d'une boucle ou autre comme on le verra plus tard, quand on fait une post incrémentation ou une pré incrémentation, vous verrez qu'il n'y aura sensiblement pas de différence.

Là où ça va être différent, c'est quand vous allez faire sur une affectation lorsqu'on fait `variable = i++;` ou `variable = ++i`


```c
/*
	+	(addition)
	-	(soustraction)
	*	(multiplication)
	/	(division)		-> 5 / 2 = 2
	%	(modulo)		-> 5 % 2 = 1

	<variable> = <variable> + X	-> <variable> += X

	A = A - X
	A -= X

	A = A * X
	A *= X

-------------------------------------------

	A += 1	-> A = A + 1
	A -= 1	-> A = A - 1

	A++	++A
	A--	--A

	variable = i++;
	variable = ++i;
*/
```

Voilà on n'est pas vraiment capable de connaître le comportement de ce genre d'instruction en langage c parce que selon les séquences, selon la liste des séquences donc des instructions qui sont exécutés par le programme, on n'est même pas sûr entre 2 séquences celle incrémentation va bien se faire au bon moment ou non.

On sait entre quelle étape et quelle étape elle se fait mais on ne sait pas exactement à quel moment donc honnêtement ce genre d'instruction `variable = i++;` peut avoir un comportement tout à fait inattendu en programmation donc c'est pour ça qu'en général on évite de faire des post ou des pré incrémentation en faisant un + 1, on se contentait simplement de faire un calcul et on le stock donc on ne commence pas à faire ces raccourcis-là parce qu'il y a des comportements qui ne sont pas toujours attendu et on ne sait pas ce qui peut se passer.

Ainsi on peut avoir des souci au niveau de l'exécution d'un programme pour pas grand-chose mais là je rentre dans des détails un peu hors sujet et surtout que ça ne risque pas vraiment de vous intéresser pour le moment.

Peut être également que vous ne serez jamais intéressé par rapport à ce fait là parce que vous pouvez très bien programmer sans savoir qu'il y a des histoires de pré incrémentation, poste incrémentation selon les instructions machines et cetera.

Bref vous pouvez complètement être étranger à ces notions là et programmer en langage c sans problème donc je ne vais pas m'étaler dessus et donner plus de détails parce que ça deviendrait très vite compliqué.

Tout ce que vous avez à retenir, c'est que vous pouvez sans problème si vous voulez ajouter un nouveau joueur utiliser cette syntaxe `niveau_joueur++;`.


```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur++;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```

Voilà du coup vous voyez que je n'ai pas stocké dans la variable niveau_joueur donc pas besoin de faire d'affectation parcequ'avec ceci `niveau_joueur++;` on va le faire automatiquement, il va dire en fait d'affecter à la variable niveau_joueur et de lui ajouter 1.

Si j'avais mis avant donc on pré incrémentation comme ceci `++niveau_joueur;` et bien là c'est différent c'est à dire qu'il va incrémenter niveau_joueur de 1 et ensuite ils veulent affecter c'est à dire qu'il va faire l'incrémentation avant l'affectation, alors que l'autre va faire l'inverse.

C'est à dire que dans le cas où on fait dans une affectation, on peut avoir des changements ou des comportements inattendus donc ça vous pouvez le faire bien évidemment, vous pouvez sans problème faire `++niveau_joueur;` ou faire `niveau_joueur++;` voilà vous n'aurez pas de souci ça va toujours augmenter de 1.

On va d'ailleurs l'exécuter pour vous montrer.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur++;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 15
Niveau de depart : 15
Niveau actuel : 16

prog.exe
Choisir le niveau de depart : 1
Niveau de depart : 1
Niveau actuel : 2

prog.exe
Choisir le niveau de depart : 0
Niveau de depart : 0
Niveau actuel : 1

prog.exe
Choisir le niveau de depart : 78
Niveau de depart : 78
Niveau actuel : 79
```

Voilà je peux mettre n'importe quoi on n'aura jamais de comportement bizarre dans ce genre de cas.

Voilà ici 2 qui sont à éviter :

```txt
variable = i++;
variable = ++i;
```

Voilà ces cas sont à éviter parce qu'on peut avoir des choses assez bizarres mais de toute manière on ne le verra pas forcément dans ce qu'on verra au niveau des vidéos.

Voilà c'était quand même nécessaire de vous en parler.

Alors tout ce qu'il y a à retenir pour vous ce sont les 4 opérateurs que vous avez connus à l'école, à l'université avec l'opérateur de modulo qui sera très utile dans certains cas. Le fameux raccourci qu'on peut faire comme ceci `<variable> = <variable> + X` d'ailleurs ce genre de syntaxe peut devenir cette syntaxe `<variable> += X` avec les 4 opérateurs même le modulo. Et en revanche lorsqu'il s'agit de faire comme ça une incrémentation, ou une décrémentation très rapide de 1 (+1 ou -1), on peut directement mettre ++ ou --.

D'accord donc si vous mettez toujours les + ou les - après le nom de la variable, voilà vous pouvez garder la même syntaxe que vous faites une pré incrémentation ou une post incrémentation, on s'en fiche complètement dans son genre de hockey ça n'aura pas de différence, ce ne sera pas plus rapide au moins rapide donc dans ce genre de cas ce n'est pas affecté au niveau du programme donc vous pouvez garder une syntaxe comme ceci `niveau_joueur++;` pour faire plus simple.

Si après admettons que niveau_joueur, on veut l'augmenter de 5 en 5, on sera obligé de faire `niveau_joueur+=5;` c'est obligatoire parce que là syntaxe en ++ ou en -- va simplement ajouter où extraire 1 donc voilà.

Donc on a besoin de cette syntaxe pour rajouter de 5 en 5, `niveau_joueur+=5;`.

```c
#include <stdio.h>

int main(void)
{
	int niveau_joueur = -1;

	printf("Choisir le niveau de depart : ");
	scanf("%d", &niveau_joueur);

	printf("Niveau de depart : %d\n", niveau_joueur);

	//Le personnage a fait des quêtes…

	niveau_joueur += 5;
	printf("Niveau actuel : %d\n", niveau_joueur);

	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Choisir le niveau de depart : 46
Niveau de depart : 46
Niveau actuel : 51

prog.exe
Choisir le niveau de depart : 125
Niveau de depart : 125
Niveau actuel : 130
```

Voilà il va toujours ajouter 5 au nombre que je lui donne voilà donc comme ça pas de problème à ce niveau-là.

Voilà c'est tout ce que j'avais à vous montrer au niveau des opérateurs, au niveau des calculs, de toute manière on aura l'occasion d'en refaire tout le temps dans les différentes vidéos et dans les différentes structures que l'on verra par la suite.

Il y aura toujours des calculs à faire avec des nombres et des opérations avec des résultats récupérés, à exploiter et cetera donc j'ai fait une vidéo parce que c'était quand même intéressant mine de rien.

Après je n'aurai pu ne pas faire de vidéo et puis l'inclure dans les autres vidéos, dans le suivi de la formation après j'ai fait ça apparaît histoire que ce soit plus clair parce qu'il y a quand même pas mal de petites choses à voir et ça pouvait faire une vidéo en elle-même qui aura duré mine de rien une bonne vingtaine de minutes le temps de vous expliquer un petit peu tout ça.

Voilà voilà on se retrouvera du coup pour une prochaine vidéo, on va commencer à voir les structures, des structures conditionnelles, les boucles puis les fonctions.

Par la suite on verra un petit peu toutes les bases donc toutes les notions, la notion de base du langage c, et vous aurez déjà de quoi faire avec tout ça pour la suite de cette formation.

À très bientôt pour tout le monde et bonne continuation sur ces vidéos