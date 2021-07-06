# [[ARCHIVE] Hacking #3 - compilation langage C](https://www.youtube.com/watch?v=-iJqEYuNhD8&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=10)

  /*
      Formation   : Hacking - 
      YouTube     :
      Auteur      : Jason Champagne
      Compilateur : GCC
      Date        : 24-06-20
      Dernière modification    : --
  */

La dernière fois, on a fait quelques rappels en programmation.
Maintenant nous allons détaillé les étapes de la compilation.
C'est des choses que l'on pourrait appliquer pour le langage C++ mais comme on va être amenné à beaucoup travailler avec le langage C au cours de cette formation, on va être amenné à travailler avec ce langage.

On va directement passé à des exemples, il y aura un peu de code mais pas grand chose.

```c
#include <stdio.h>
int main(void)
{
	
	return 0;
}
```

## Pdf

Sur ces vidéos et les vidéos suivante, on peut récupérer dans la description un pdf. Il aura un certains nombres d'informations. Toute la vidéo serra proposé sous forme de note. Et puis le pdf de la séance suivante, c'est le pdf de cette séance avec des choses en plus. SI on prend le dernier pdf le plus à jour, il aura en fait tout ce qu'il y avait dans les vidéos précédentes. Comme ça on peut avoir au fur et à mesure quelque chose d'un peu plus complet. Il faut voir le numéro d'édition sur le pdf. Ici le numéro d'édition est le numéro 1. Et le pdf d"édition 2 pour la vidéo suivante.

L'intérêt est d'avoir un condensé de tout ce que l'on va voir au fur et mesure des vidéos et un résumé pour avoir des notes pour ça.

Le pdf c'est "Notes Hacking" et ici c'est tout ce que l'on va pouvoir récupérer sur cette page. Le sommaire sera complété avec les vidéos qui viendrons après.

## Etapes compilation

Au niveau des étapes de compilation, si on a bien suivi la formation en langage C, on a vu comment compiler notre programme pour l'éxecuter :

```c
#include <stdio.h>
int main(void)
{
	printf("Hello World! :)\n");
	return 0;
}
```

On faisait ensuite tout simplement gcc. On mettait ensuite une * si on avait plusieurs fichiers sources ou par exemple main.c si on en avait qu'un seul.
Par habitude on l'appelle main.c
Un -o pour spécifier un nom de programme, généralement on met prog :

	gcc main.c -o prog

On compile, ça crée un éxécutable prog.
Il a l'extension .exe si on est sur Windows.
Il n'aura pas d'extension si on est sur GNU Linux ou MacOS, c'est ./ avant le nom du programme.
A partir de là, on vient d'exécuter notre programme.

Maintenant passons à quelques petites nouveauté.
La compilation en langage C et C++, ce n'est pas seulement étape, ce n'est pas seulement on a un code source et on obtient directement un exécutable qui s'exécute et qui est compris par l'ordinateur.
Il y a en réalité, pour être plus complet, 4 étapes différentes.

On ne voit pas cette partie dans d'autres formations, il s'agit donc de quelque chose de nouveau.

La première étape consiste à tout ce qui est traitement pas le pré-processeur.
C'est ce qu'on appelle le pre-processing si on emploi le terme anglais parce que en informatique il y abeaucoup de terme en anglais.
On va utiliser pour cela un autre type de commande à la compilation avec l'outil GCC, toujours. Pour rappel, GCC c'est le compilateur.
Il en existe d'autres pour compiler du langage C ou du C++.
On a prit l'habitude d'utiliser GCC car il est très pratique et très répendu aussi.

Mais voilà il existe d'autres compilateurs, certains sont aussi très intéressant.

Ici taper comme on le faisait, taper GCC, le nom du fichier, etc dans l'invite.
On va maintenant taper une commande différente.
Déjà si on veut voir les commandes disponibles pour GCC :

	gcc --help
	
On constate ainsi qu'il y a pas mal de chose disponible.
C'est un petit raccourcis pour connaître les commandes que l'on peut retrouver.
On va en voir quelques unes et surtout comment elles fonctionnent.

### 1ere etape - pré-processeur

Donc la première étape c'est le pré-processeur et en quoi elle consiste ? Quel est le but de cette étape ? Mettons quelques commentaires dans notre code pour l'exemple : 

```c
#include <stdio.h>

/**
*	Foction principale
*/
int main(void)
{
	//Affiche un message de bienvenue
	printf("Hello World! :)\n");
	return 0;
}
```

Là on a tout un ensemble, un code source, un fichier source. On peut d'ailleurs en avoir plusieurs. C'est l'ensemble de tout ce que le développeur à tapé dans ses fichiers : le code, y compris les différentes directives dont on va parler après et des commentaires.

Il faut savoir que le commentaires pour se repérer. Ca doit être lisible. Ca peut être utilisé par les développeurs mais c'est tout, ça n'as aucun intérêt au niveau du programme ou pour nous permettre de nous relire, de commenter le code, les traitement, les algorythmes, etc.

Le premier rôle du pré-processeur, ça va de supprimer ces commentaires là comme lui n'en a pas besoin, ça sert à rien qu'il crée un exécutable en prenant des fichiers avec les fameux commentaires. Ils ne servent vraiment pas au niveau de la compilation. Il va donc supprimer tout les petits commentaires tel que les petits commentaires style C++ :

```c
	/**
	*	Foction principale
	*/
```

les commentaires avec le double slash sont des commentaires spécialement pour le C à la base. On a des commentaires sur une seule ligne tel que :

```c
	//Affiche un message de bienvenue
```

Et on va voir pas mal d'autres choses, c'est une première chose que va faire le préprocesseur, le traitement du pré-processeur.

Le seconde chose, c'est qu'on peux éventuellement utiliser des fichiers d'en-tête, notamment les fichiers .h, notamment le fichier stdio.h qui est un des fichiers d'en-tête du langage C pour notamment utiliser la fonction printf. Et d'autres également, on en a vu sur les autres formations et sur les vidéos sur le langage C.

Tout ces fichiers sont ailleurs. Dans notre répertoire, il n'y a que main.c
Notre système doit bien les trouver quelque part. Quand on a installer le compilateur, ça également installé tous les fichiers d'en-tête du langage C donc qui vont être utile pour GCC.

Ainsi le pré-processeur va se charger d'inclure en fait le nécessaire de ces fichiers d'en-tête dans les sources. C'est-à-dire que le source, ça ne va pas seulement être le contenu de main.c mais aussi complété avec l'ensemble des fichiers d'en-têtes qui sont nécessaires.

En dernier point, le pré-processeur va traiter tout ce qui directive. Il y a actuellement une vidéo concernant les directives du pré-processeur. On a vu que les directive du pré-processeurs se sont toutes les lignes qui commencent par un dièse #.

```c
	#include
```
	
C'est une directive qui inclut un fichier d'en-tête. On peut avoir d'autres directives :

```c
	#define TAILLE_TABLEAU 20
```

Une directive peut signifier qu'on veut remplacer TAILLE_TABLEAU par 20 qu'on écrit généralement en majuscule. Ca permet de définir un remplacement. C'est juste pour dire qu'à chaque fois qu'il va rencontrer TAILLE_TABLEAU dans un code source, il va le remplacer par le nombre 20. C'est juste un remplacement d'un mot par une valeur ou même par un ensemble d'instruction peu importe.

C'est simplement du remplacement ou de l'inclusion si on a ici un include.

Le pré-processeur va faire ainsi tout ça en même temps. Ce n'est toujours que la première étape pour l'ensemble de la compilation et ça fait déjà beaucoup de chose.

En résumé, ça supprime tout les commentaires. Ca va inclure les fichiers d'en-têtes dans les sources du programmes et ca va traiter toutes les directives.

Tout ceci est noté dans le pdf disponibles, dans les notes que l'on aura au fur et à mesures des vidéos.

On va maintenant utiliser une commande du compilateur GCC pour faire en sorte que le pré-processeur fasse son traitement mais c'est tout c'est-à-dire qu'il y ait juste la première étape qui se fasse et pas les autres. Donc on va pas faire la même commande que d'habitude, on va faire :

	gcc -E main.c

On fait gcc, ça ne change pas mais on va utiliser l'option, l'agument E majuscule. Attention en informatique e minuscule et E majuscule sont différent. On fait vraiment attention à ce qu'on appelle la case au niveau de l'écriture, un majuscule et pas une minuscule. C'est vraiment important, ici il s'agit bien d'un E majuscule. Ensuite on prend main.c etant le seul fichier source à partir de quoi, on utilise le pré-processeur.

On lance la commande "gcc -E main.c" et on constate que c'est très long. Et le code source est tout en bas. Et d'ailleurs si on fait attention il n'y a plus tout les commentaires. Ils ont été effectivement supprimés.

Tout un tas de chose a été rajouté dans le terminal. Il a vraiment défilé beaucoup de lignes. On ne pourra pas réutiliser ce que le pré-processeur a produit comme résultat, ce qu'il a affiché dans le terminal.

Plutôt que de faire juste "gcc -E main.c", on va décider de le mettre dans le fichier. Pour ça on utilise une commande lié au terminal mais pas forcément au langage C. C'est lié au terminal du système d'exploitation que l'on utilise. 

	gcc -E main.c > main.i

Si on met un chevron >, c'est pour dire que le résultat d'une commande de notre terminal va être renvoyé dans quelque chose, un fichier que l'on nommera main.i à qui on donne l'extension i par habitude. On peut lui donner l'extension E majuscule aussi mais ce n'est pas forcément très très propre. Il est recommandé de mettre l'extension i comme ça on est clair. On va y mettre tout le résultat de ce qu'on a vu s'afficher. Dans n'importe quel OS et la ca va fonctionner et on va avoir un fichier .i qui va être créé.

Si on ouvre main.i, on obtient exactement ce qui a défilé dans le terminal. On constate qu'un tout petit code source, un fois que le pré-processeur a fait tout le travail, a fait tout le traitement, on voit ce qu'il a produit, soit un peu plus de 450 lignes, grosso modo même si il ya des espaces entre deux.

Ici il n'y a donc plus les commentaires comme on avait dit et il a inclut les fichiers d'en-têtes au sources. Donc il y a beaucoup beaucoup de choses.

Il a fait pas mal de chose et si il avait besoin, il aura remplacer certaines directives pour faire les remplacements, soit les fameuses directives du pré-processeur. Donc là par exemple, si il y avait TAILLE_TABLEAU, ce n'est plus TAILLE_TABLEAU mais c'est devenu 20.

Si on fait plutôt ça :

```c
#define TAILLE_TABLEAU 20
/**
*	Foction principale
*/
int main(void)
{
	int tab[TAILLE_TABLEAU];
	//Affiche un message de bienvenue
	printf("Hello World! :)\n");
	return 0;
}
```

et qu'on refait "gcc -E main.c > main.i", on remarque que pour le compilateur, la macro "TAILLE_TABLEAU" n'existe pas dans main.i parce que le pré-processeur a fait le remplacement. A chaque fois qu'il rencontrait ce mot, il a fait le remplacement par 20.

Au final, on se retrouve avec 20, on ne se retrouve pas avec une constante.

C'est vraiment un remplacement qui est éffectué. Il a donc fait tout le traitement que l'on s'attendais.

Ici, on a fait que la première étape, on voit qu'on a le fichier de la première étape.

C'etait la première étape sur les 4 qui va nous servir pour la suite car puisqu'on la mit dans un fichier. On va pouvoir le réutiliser pour la prochaine étape. C'était un peu long et il y a beaucoup de chose à voir.

Donc ici, on fait le code source dans main.c et on a produit un fichier main.i qui est le résultat du préprocesseur.

Le passage du pré-processeur est la première étape.

### 2eme étape - Compilation

On arrive maintenat à la deuxième étape. Elle est super importante parce qu'on dit qu'à la base on fait une compilation mais en fait c'est un peu un abus de langage parce qu'en fait la compilation, ce n'est que l'étape 2 en réalité.

On dit compilation quand on compile un fichier source pour devenir un exécutable alors que ce n'est pas tout à fait vrai. L'étape 2, c'est éffectivement la compilation et en quoi ça consiste ? Et bien notre fichier de pré-processeur, celui qui a été produit par le pré-processeur... C'est pour ça qu'il était intéressant de la récupérer le fichier plutôt que ça s'affiche dans le terminal. Ce fichier va êtrevraiment compilé en langage d'assembleur. Le langage d'assembleur, c'est un ensemble d'instructions machine qui fait des traitements, des opérations très simple. Ca peut être des déplacement de données dans pas vraiment des variables mais des registres, c'est un peu le même système, pour stocker de l'information. Ca peut être des additions, des soustractions bien que des soustractions, c'est des additions en fait, ou encore par exemple des comparaison de valeurs. Ce sont juste des choses très très simple, des additions, des comparaisons, des petits appels, des instructions très simples.

C'est ce qu'on appelle des instructions machine et ça c'est le langage d'assembleur. On va produire le fichier du langage assembleur en partant de notre fichier qu'on a créé précédemment. Ainsi les étapes, on les fait on fur et à mesure. On fait tout étape par étape. La commande pour le faire :

	gcc -S main.i

C'est très simple, très rapide. On fait GCC puis un tiret grand S cette fois-çi et on va spécifier notre fichier du préprocesseur c'est-à-dire on lui donne main.i que l'on vient de faire précédemment. Pas besoin d'ajouter autre chose derrière. Pas besoin de dire qu'on est dans un fichier car là il va le faire. Il aura produit un fichier .s qui est le fichier du code assembleur. Et si on l'ouvre, on obtient un code assembleur qui risque d'être assez incompréhensible mais grosso modo sans comprendre le langage assembleur si on ne le connait pas, on remarque qu'il y a des instruction très simple.

Par exemple le "mov", c'est pour faire un déplacement dans un registre mais ça on en parlera plus tard ou alors dans d'autres formations parce qu'on va faire du langage assembleur sur cette chaîne. On a aussi des "call", ce sont des appels. "push" c'est simplement pour mettre une valeur dans un registre spécifique et on a pas forcément fait de compraison ou autre. On a quelques instructions ici, soit des instructions machines.

Ici le fichier est relativement court parce qu'on ne fait afficher qu'un seul texte mais on constate que pour juste produire un texte, le code assembleur est beaucoup plus long.

A partir d'un simple printf(), on se retrouve avec pas mal de petites choses. D'ailleurs si on avait juste mit le printf(), on aurait eu un peu moins de code parceque ici, on fait de petites choses en plus.

Voilà pour le code assembleur. Pour le moment, il nous sert à rien mais au fur et à mesure que l'on va avancer sur le hacking, on va souvent travailler sur du code assembleur. On aura donc l'occasion de faire du langage assembleur. On saura à quoi correspond le fameux %esp, etc. On verra, en plus ce sont des registres très spécifiques au niveau du système.

Voilà c'était une étape assez courte.
	
### 3ème étape - traduction en langage binaire

C'est l'étape qui va permettre de traduire, transformer ce fameux assembleur en langage binaire, celui composé de 0 et 1, le seul que peut comprendre notre machine.
	
		gcc -c main.s
	
Pour ça, on va utiliser la commande gcc, tiret un c minuscule cette fois et on va lui donner le fichier .s vu précedemment. C'est tout. Ainsi on fait gcc -c main.s et on obtient un fichier main.o

Si on l'ouvre, on obtient un code en hexadécimale puisqu'il y a des E et des F, ce qui est parfaitement normale	puisqu'on est sur un éditeur de code textuelle.

Il faut savoir qu'il y a des éditeurs binaire qui sont capable d'ouvrir des fichiers binaire. Donc si on l'ouvre dans un éditeur de texte, il essaye de l'afficher sous forme 	textuelle donc c'est absollument illisible. De toute façon, on s'attarde pas sur les fichiers objets, ils ne sont pas fait pour être lu dans un éditeur de texte. Ils sont fait pour être réutilisé éventuellement, notamment quand on fait de la compilation séaparé. La compilation séparé est une notion qu'on verra ou qu'on a peut être déjà vu dans d'autres vidéos sur la chaîne. Si on ne connaît pas ce n'est pas grave. On aura l'occasion d'en parler tôt ou tard.
	
Donc ça c'est la partie objet donc on produit un fichier objet qui est facillement identifiable puisqu'il porte l'extension .o Donc le o, c'est pour "object". Donc comme ça on l'identifie facillement.
	
### 4ème étape - édition des liens

On termine du coup avec la dernière étape qui est l'édition des liens. C'est à dire que là, on a qu'un seul fichier donc ça va. Donc là, on a qu'un fichier source, donc qu'un fichier objet. Il faut savoir qu'on va avoir autant de fichiers objet que l'on a de fichiers source. Si on avait eu un fichier player.c, on aurait eu un fichier player.o

On en aurait eu plusieurs. Le problème c'est qu'à la fin, un exécutable est unique. Comment faire pour que ça fonctionne ? Il faut un éditeur de liens qui va fusionner l'ensemble des fichiers objet et pleins d'autres choses en fait. Ca va vraiment tout rassembler, ça va faire la liaison pour produire notre produire notre exécutable finale.
	
On commence par enlever l'exécutable qu'on avait fait tout au début.

On en a pas besoin.

On va du coup obtenir notre fameux fichier exécutable depuis notre fichier objet.

Donc le fichier objet est prêt. C'est déjà du binaire. On a juste à faire l'édition des liens pour qu'il devienne éffectivement un exécutable.

Sinon on ne pourrait pas l'exécuter. En fait c'est Windows qui ne peut pas directement exécuter le binaire. Il a besoin de créer un exécutable reconnu par le système d'exploitation en partant d'un fichier binaire. On va donc faire très simplement :
	
		gcc main.o 
	
Ainsi, on obtient un exécutable. Par défaut, il porte le nom a.exe 

C'est donc a.exe

Si on veut lui donner un nom :
	
		gcc main.o -o prog
	
On fait comme d'habiture en mettant l'option tiret o qui signifie output et on choisi le nom que l'on veux et ça revient au même sauf qu'on a renommé l'exécutable.
	
Si on est sur GNU Linux ou Mac, on l'éxécute en faisant ./a parce que on aura juste un fichier qui s'appelle a. Si on est sur Windows, on fait a ou a.exe
	
On obtient le même résultat qu'au tout début lorsqu'on avait tapé :
	
		gcc main.c -o a
		
On a exactement la même chose, c'est simplement qu'on a détaillé les 4 étapes.
	
Tout ceci est expliqué dans le pdf.
	
## Options bonus
	
Autres options qu'il est recommandé de connaître. Certaines sont très utiles voir même indispensables. Ces options bonus par rapport à GCC peuvent être très utile.
	
On commence par celle qui concerne tout ce qui est erreurs. Quand on essaye de faire du langage C ou autre, on essaye d'être le plus rigoureux possible, de produire un code le plus propre possible. Normalement on fait gcc, les fichier sources, tiret o et prog, c'est terminé. Si on voulu être très précis, on devrait spécifier d'autres options pour 	afficher des avertissements. La différence au niveau de la compilation est la suivante; si on a une erreur de compilation, on aura pas d'exécutable obtenu. La compilation va s'arrêter en disant qu'il y a des erreurs dans le code et faut ainsi les corriger avant. En revanche, un avertissement, le code va quand même compiler, c'est juste qu'il y des choses qui ne vont pas, des choses qui ne sont pas propre dans notre code mais on aura quand même notre exécutable à la fin. Mais on nous a avertit qu'il y a ça qui n'est pas bien, il y a ça qui est mal fait. C'est ça la différence avec les avertissements, c'est que ça ne bloque pas la compilation alors qu'une erreur si.
	
Du coup nous allons partir sur les premières options.
	
## Option -W
	
La première option qui est intéressante à connaître, c'est l'option -W

On fait gcc, un tiret W majuscule suivi de all puis main.c -o prog.
	
		gcc -Wall main.c -o prog
		
Si il n'y a pas d'erreur, on produit notre exécutable sans soucis. Le Wall est simple. Le W est le diminutif pour les warning, les avertissements et all ça veut dire un petit peu tout. C'est pas tout à fait tout exactement parce que en informatique quand on utilise le mot all, ça veut dire tout sauf certaines execeptions. Grosso modo ça englobe une bonne partie des avertissements.
	
-Wall signifie simplemenent qu'on affiche l'affichage des avertissements. Pour produire un avertissement, on peut faire :

```c
int main(void)
{
	int i;
	printf("Hello World! :)\n");
	return 0;
}
```
	
On lance la commande avec gcc -Wall main.c -o prog et il nous dit qu'il y a une variable qui n'est jamais utilisé. Elle n'est nulle part dans le programme. Ce qui n'empêche pas de produire l'exécutable. L'avertissement concerne une variable créé mais qui n'est jamais utilisé. Autrement dit elle ne sert à rien donc autant l'enlevé. Ca n'empêchera pas le programme de compiler et d'avoir un exécutable mais on nous avertit quand même que ce n'est pas propre parce qu'on a une variable ici qui ne sert à rien. Elle était juste déclarer et puis c'est tout et on n'en fait rien. Voilà à quoi sert ce petit argument, cette petite option.
	
## Option -Werror
	
On peut forcer un peu plus en utilisant l'argument -Werror :
	
		gcc -Wall -Werror main.c -o prog
	
En faisant ça, on lui dit en fait de transformer tout les avertissements comme si c'était des erreurs de compilation.

Comme on le disais, si on rencontre une erreur de compilation, la compilation ne marche pas.

Et comme j'ai toujours ma variable i, le message dit que ça n'as pas fonctionné. Ainsi je n'ai pas produit d'exécutable puisque la compilation s'est arrêté.

Ca permet vraiment d'etre très stricte au niveau de la compilation. Faire attention, je veux qu'on produise un exécutable que si il n'y a vraiment aucun avertissement qui a été trouvé par le compilateur. C'est vraiment pour faire du code beaucoup plus propre si on se force à utiliser ces deux options là. 
	
C'est le minimum, on peut utiliser -Wall avec -Werror pour être sûr d'avoir un code beaucoup plus propre que si on n'affichait pas pas les avertissements.
	
## Option -Wextra
	
Ensuite ce qui est bien à savoir est que si on veut encore plus avertissements. Comme on avait dis le -Wall n'est pas tout à fait exacte parce qu'il y en a d'autres, des supplémentaires, qui ne sont pas forcément activé. Pour les activé, on va utiliser -Wextra. Certains ne connaisse pas cette commande mais d'autres on déjà entendu parler du -W.

-W ne doit plus être utilisé, c'était l'ancien nom de l'option mais c'est maintenant obselète.

Il est recommandé d'utiliser -Wextra à la place. Ca va simplement afficher l'affichage des avertissements supplémentaires. Ici on peut enlever -Werror, on n'est pas obligé de voir ça.
	
		gcc -Wall -Wextra main.c -o prog
	
Ici on a juste l'histoire de la variable i qui n'est pas utilisé mais si il y avait d'autres choses, on aurait trouvé peut être trouvé d'autres avertissements que le -Wall ne nous aurais pas trouvé. Avec -Wall -Wextra c'est vraiment qu'il nous affiche tous les avertissements possibles au niveau du langage. Ca peut être une variable non déclarée, ou bien au niveau du nommage, au niveau des fonctions, etc.
	
C'est ainsi un espèce de surveillant au niveau de notre programme. Et ainsi plus on active de type d'avertissement et plus on va être stricte dans le code que l'on doit écrire pour la compilation. Ca c'est vraiment le top si on veut avoir propre surtout si on active -Werror dans le cas où il rencontre des avertissements.
	
Voilà pour ces commandes là qui sont intéressante à connaître.
	
## Option -w
	
Dans certains cas, il est peut être interessant de désactiver tous les avertissements même si il n'est pas recommandé de le faire parce que l'intérêt c'est quand même de produire un code propre mais c'est de le savoir car dans certains cas c'est nécessaire
	
C'est le -w minuscule.
	
On fait :
	
		gcc -w main.c -o prog
		
C'est vraiment pour dire qu'on désactive tout l'affichage des erreurs. On est sûr qu'il n'y aura jamais d'avertissement. Et là on produira l'exécutable si il n'y a pas d'erreur de compilation. Du coup le petit i qui n'est pas utilisé ne pose pas de problème pour le compilateur
	
Ca c'est pour les petites options concernant les avertissements, les erreurs, ce genre de chose
	
Il y a ensuite d'autres options mais elle ne sont pas forcément liéent aux avertissements, aux érreurs, ce genre de choses.
	
Il y a ensuite d'autres avertissement mais pas liéent aux avertissements mais plutôt aux normes du langage.
	
## Option -ansi
	
La première de ces options est -ansi
	
		gcc -ansi main.c -o prog
		
Si je compile, cela m'affiche pleins d'erreurs parce qu'il nous met qu'il y a un petit problème de commentaires. Si on fait un commentaire sur une ligne avec un double slash, il nous met que selon la norme ISO C90, un standard, il nous dit que ce commentaire là n'est pas autorisé. Parce que à la base, il n'y avait que des commentaires avec des slashs et des étoiles. Les fameux commentaires sur plusieurs lignes même s'ils ne tiennent que sur une seule ligne. 

```c
/ **
*	Foction principale
* /
int main(void)
{
	int tab[TAILLE_TABLEAU];
	/ * Affiche un message de bienvenue * /
	printf("Hello World! :)\n");
	return 0;
}
```
	
Avec ce type de commentaires, il n'y aura plus de problèmes. Ca rend la compilation beaucoup plus stricte, ça c'est déjà beaucoup plus important. Le ANSI c'est pour se comporter, traiter la compilation selon la norme ANSI.
	
## Option -pedantic

On peut également utilisé l'option pedantic Là c'est s'occuper d'afficher les avertissements par rapport à la norme ANSI. Là c'est vraiment un plus, on peut utiliser -ansi et -pedantic comme ça, on a vraiment tout.
	
		gcc -ansi -pedantic main.c -o prog
	
On fait ainsi les deux et on obtient quelques choses d'encore plus complet. Si on remet le fameux commentaire qu'il ne faut pas, il ne va pas être content non plus.
	
pedantic c'est vraiment pour afficher des avertissements, des choses en plus toujours lié à la norme ANSI, toujours par rapport à ça. Si ça ne respecte pas les standard ISO C90 comme on peut le voir au niveau du terminal.
	
## Option -std
	
Justement comme on parlait des standards C89, C90, C99, C11 sont des normes qui ont permis d'ajouter des fonctionnalités au langage suivant les années 1989, 1999, 2011, etc.
	
Du coup, on peut forcer le standard à utiliser durant la compilation. On fait gcc -std pour standard, égale suivi de la norme à utiliser. Par exemple -std=c89, -std=c99, -std=c11 et on met ensuite l'ensemble des commandes habituelles.
	
		gcc -std=c11 main.c -o prog
		
Du coup si on utilise une fonctionnalité qui est obsolète par rapport au standard que l'on spécifie, on aura également des erreurs de compilation.
	
Si on veut être sûr que le compilateur prenne en compte des nouveautés du langage, il faut mettre c11, le standard de 2011.
	
Par défaut le compilateur compile en C90. Si maintenant j'utilise une fonctionnalité qui est arrivé avec le standard c11, il va mettre une erreur alors que non. C'est juste qu'il ne compile pas avec le bon standard.
	
C'est bien à savoir comme standard. Tout est marqué sur le pdf.
	
## Option -g
	
On arrive ensuite sur des choses plus secondaires, qui ne sont pas forcément utile. Il y en a même qu'on utilisera jamais. Sauf pour la petite commande à part qui va servir pour la vidéo suivante lorsqu'on va parler de débogage.
	
Cette commande permet justement de générer des infos pour le débogage. Tout ça on le verra dans la prochaine vidéo.
	
On regarde la commande, c'est l'option -g :
	
		gcc -g main.c -o prog
		
Ca va juste ajouter des informations de débogage à l'exécutable qu'on va pouvoir utiliser pour pouvoir déboger le programme quand on va l'analyser 	mais tout ça on va le voir dans la vidéo suivante, dans la séance 4.
	
## Option -O
	
On continue avec la commande d'optimisation. On peut éventuellement optimiser le code qui est compilé pour produire un code un peu plus petit en taille.
	
Cette commande, c'est gcc tiret grand O suivi d'un chiffre qui peut aller de 0 à 3 pour donner le niveau d'optimisation. zero, il n'y a pas d'optimisation. Un, c'est une optimisation dite faible et forte avec trois.
	
		gcc -O0 main.c -o prog
		gcc -O1 main.c -o prog
		gcc -O2 main.c -o prog
		gcc -O3 main.c -o prog
		
Le compilateur peut être configurer de sorte à être optimisé à un certain niveau, ça dépend de comment il est configuré. Dans certain cas, ça peut être utile d'optimiser et dans d'autres cas, ça ne fait pas de différence, surtout dans les versions de compilateur actuel. La plupart du temps, ils sont déjà suffisament optimisé pour que cete commande n'ai plus tellement d'intérêt par rapport à il y a quelques années. Il y a peut être même des chances pour qu'elles disparaissent dans quelques années.
	
Les compilateurs sont téllement devenus performant qu'il n'y a plus tellement d'intérêt pour utiliser une commande pour optimiser car c'est un petit peu en natif. C'est en fait inclut par défaut.
	
Voilà à savoir qu'en utilisant le -O et un chiffre de zéro à 3, on peut quand même optimiser le code pour produire un code plus beau.
	
## Option -Os
	
On a également l'équivalent avec un tirel grand O suivi d'un petit s.
	
		gcc -Os main.c -o prog
	
C'est pareil, c'est pour l'optimisation de code, la taille. Ce genre de chose. On passe néanmoins très vite dessus parce que pas tellement d'intérêt.
	
## Option -pipe
	
Une autre est :
	
		gcc -pipe main.c -o prog
	
Pour nous cette option ne fait aucune différence. C'est juste au niveau du système, il faut savoir qu'on a vu quatre étapes, le pre-processing, le compiling qui est tout ce qui est compilation en langage assembleur, l'assembling c'est la transformation de l'assembleur en binaire et le linking c'est l'édition de lien si on emploi les terme en anglais.
	
Le système GNU Linux, Mac, etc utilise des fichiers temporaires, intermédiaires pour pouvoir faire chacune de ces étapes mais si on veux, on peut utiliser les tubes systèmes. Si on a jamais fait de programmation système, il faut savoir qu'il existe en programmation système, les fameux pipe, des tubes.
	
Si par exemple on a une commande pour dire, je crée une variable, et une commande pour dire j'affiche, sans l'utilisation de tube, on va avoir une première étape pour la création de la variable et la deuxième, ça va être pour l'affichage.
	
Un tube ça permet de faire les deux à la fois. On crée la variable et tout de suite, on affiche. C'est simplement ça.
	
C'est pour éviter de plutôt que d'utiliser des intermédiaires, des fichiers qui alourdissent le traitement, on utilisent un tube pour dire que tu utilise une première commande et avec le résultat de la première commande, directement tu passe à la suivante. On se sert du résultat pour passer à la commande suivante.
	
Ca tombe bien car au vue de ce que l'on a fait au niveau de la compilation, on a utilisé le fichier traité par le pré-pocesseur pour transformer en assembleur, lui même utilisé pour transformer en binaire, utilisé pour faire l'exécutable après l'édition des liens.
	
Tout est réutilisé et en utilisant les fameux tubes systèmes, ça permet parfois d'optimiser un peu la compilation.
	
On utilisera proablement jamais cette option mais pour ceux qui veulent être très rigoureux, qui veulent aller plus loin dans les détails, on peut utiliser cette option pipe.
	
On va terminer avec deux petites options mais très rapidement car on ne va pas forcément les utiliser ici. C'est notamment des choses que l'on verra avec la SDL sur le langage C notamment.
	
## Option -I
	
On aura l'occasion d'utiliser ces fameux arguments. On a le gcc tiret grand I, qui va permettre d'ajouter des répertoires concernant des fichiers d'en-têtes.
	
		gcc -I
	
Parce qu'il faut savoir qu'à la compilation, le compilateur va d'habord chercher des fichiers d'en-têtes que l'on veux inclure nous et après, il va aller prendre ceux qui sont sur notre système. Sur le système, c'est par exemple, le fameux stdio.h

Encore une fois stdio.h n'est pas dans mon projet, il est installé dans mon système.

Mais avant tout quand on utilise un argument grand I majuscule et qu'on ajoute un répertoire, il va chercher dans notre projet en premier et après il va aller inclure ce qu'il y a sur notre système.
	
## Option -L
	
		gcc -L
	
Le grand L est un peut la même chose qui va permettre d'afficher des fichiers qui la plupart du temps portent l'extension .a qui sont des fichiers qui sont prêt à être réutilisé, qui permettent du coup de faire des inclusions multiples de plusieurs fichiers d'en-têtes au cours de la compilation.
	
Là on tombe dans quelque chose qui devient très vite compliqué.

On ne rentrera pas plus dans les détails, c'est des choses que nous allons voir. C'est des choses qu'on a peut être déjà vu dans d'autres vidéos. On s'attarde pas dessus mais comme la vidéo parlait de compilation en langage C, ou éventuellement C++, il était de bon aloi de les voir.
	
On les voit parce que c'est deux options qu'on utilise très souvent notamment quand on travaille avec des bibliothèques externes, ca peut être la SDL, la SFML, ce genre de chose. C'est très très utilisé surtout lorsqu'on compile en ligne de commandes ou avec un petit Makefile par exemple.
	
## Conclusion
	
On a maintenant tout vu.

La première édition des notes PDF qui contient le résumé pour la fameuse compilation en langage C avec le numéro de la séance au quel c'est associé, ainsi que les différentes étapes résumé.

Avec un petit détail pour chacune. Un petit conseil sur tout ce que l'on a raconté avec peut être des petites choses en plus qu'on aura pas dite.

Tout est présent, y compris le bonus avec les options qu'on a parlé au cours de cette vidéo.

Un petit détail au niveau de -Wextra, ça remplace la commande l'option -W que l'on voit parfois sur des forums ou autre lorsqu'on demande de l'aide mais cette option est obselète.

On aura vraiment été très loin dans le détail alors qu'à la base, on a l'habitude de compiler de manière débutant. La on a maintenant le détail et les étapes de compilation.

C'est ainsi plus complexe que ce que l'on a pas voir avant, on peut s'attaquer maintenant au base du hacking. Voilà les bases qu'à un hacker.

Le hacker a pour base des langages de programmation et sait comment se passe la compilation dans le détail.

Pour un hacker, la compilation, c'est pas juste, on a des fichiers sources et on obtient un exécutable. Il sait ce qu'est l'édition de liens, il sait ce qu'est un langage assembleur, il sait ce que c'est un pré-processeur, etc.

Maintenant ce sont peut être des connaissances qu'on a déjà si on a tout compris de cette vidéo, après il ne faut pas hésité à revoir le pdf ou bien revoir cette vidéo plusieurs fois si nécessaire ou bien même à tester des commandes sur nos fichiers, sur plusieurs fichiers sources (conseillé).

En effet, comme dans les exemples pour raccourcir les vidéos, on a mis qu'un seul mais on peut bien sûr en mettre plusieurs pour voir un peu ce qu'il se passe. On aura plusieurs fichiers objets mais surtout pour voir comment l'édition de liens se passe. Ce n'est pas forcément compréhensible au premier abord.
	
Dans la séance 4, on utilisera la fameuse option -g qui va permettre de faire du débogage pour trouver des erreurs et analyser un exécutable et trouver des erreurs qu'on aurait fait à la compilation quand on quelque chose qui ne marche pas. Et ça bien évidemment, c'est pour la suite.