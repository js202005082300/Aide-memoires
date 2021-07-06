# [2. Compiler programme](https://www.youtube.com/watch?v=6E-zrVV2tSg)
> Transcription le 18-01-2020

Deuxième séance en langage C.

Nous allons commencer à coder.

Nous allons compiler notre premier programme en langage C.

On apportera bien évidemment des explications par rapport au code.

Comment s'ajance la syntaxe du langage.

Avant de commencer la vidéo, il est recommandé de suivre la séance pour l'installer MinGW, uniquement si on est sur Windows.

Pour ceux qui sont sur Linux ou MacOS, ce n'est pas utile.

Si on est sur Windows, il est recommandé de suivre le tutoriel pour installer l'outil en question.

C'est un outil qui va permettre d'installer tout ce qu'il faut pour pouvoir compiler notre programme et former le code binaire, l'exécutable et éventuellment déboguer.

Voilà, on pourra passer par MinGW et installer tout ce qu'il faut pour commencer cette formation comme il se doit.

Pour ceux qui voudraient utiliser un logiciel tout en un.

Un logiciel tout en main s'appelle un environnement de développement.

C'est un logiciel qui va regrouper un éditeur de code. Ce n'est pas un éditeur de texte, c'est vraiment un éditeur de code qui peut colorer notre syntaxe, etc; avoir de petits racourcis.

On intégre généralement aussi le compilateur et le débogueur, on intègre ces 3 choses là.

On peut avoir tout ça sous forme de logiciel, un logiciel tout en main, donc un environnement de développement.

Dans la description de la vidéo, pdf's pour proposer comment installer les logiciels proposés.

Il y a donc deux choix, soit on préfère passer par un environnement de développement, tout en un, et on a tout avec, soit on peut faire comme dans tout l'ensemble des vidéos que l'on va voir, on va faire de la compilation en ligne de commande.

La compilation est d'ailleurs recommandée, tout simplement pour ne pas être dépendant d'un logiciel. Surtout éviter de s'en fermer dans l'utilisation d'un logiciel puisque le jour où l'on utilise Codeblocks, logiciel qui propose un environnement de développement pour programmer en C, et le jour où l'on est sur un système et qu'on a plus ce logiciel là, on ne serra plus créer de programme en langage C. Ca peut être très préjudisciable et provoquer beaucoup de soucis. Il a vraiment beaucoup de gens ou de faire ce qu'il font d'habitude parce qu'il n'ont pas l'outil qu'ils ont habituellement.

Essayer d'être un maximum indépendant, polyvalent si l'on compile en ligne de commandes sur Windows, que l'on soit sur Linux, sur MacOS, peu importe ça fonctionnera. On pourra travailler de la même façon et ça c'est important. On fait comme on veut.
	
Petit point important sur Windows. 

Dans le panneau de configuration > passer dans les options des dossiers > au niveau de  l'affichage > et vérifier surtout au niveau de notre ligne "Masquer les extensions des fichiers dont le type est connu" est bien désactivé, donc décoché parceque ça nous permettre d'afficher l'extension de tous les fichiers de notre système. Pour des images, des vidéos, on verra les extensions c'est-à-dire le format de ces différents fichiers. 
	
Lorsqu'on va vouloir créer un fichier source, on pourra le faire comme lorsqu'on crée un nouveau fichier texte et le renommer avec son extension du langage et forcément ça restera un fichier texte. Si néanmoins le compilateur prend le fichier texte en entrée, il ne va vraiment l'accepter.
	
On crée un nouveau répertoire et ainsi on crée un nouveau fichier à partir d'un document texte.

Si on faisait un fichier comme ça : "main.c.txt" ca ne va pas. L'extension d'un fichier en langage C est .c

Si l'extension était masqué, le .txt de "main.c.txt" serait caché du coup j'aurais l'impression que mon fichier serait bien nommé mais en fait non.
	
Il faut donc affiché l'extension des fichiers comme ça. On ne gardera finallement main.c
	
On a donc un fichier source qui va pouvoir être compilé par la suite par notre outil de compilation. 
	
On peut ensuite l'ouvrir et éditer, taper du code.

On passera automatiquement par l'invite de commande de Windows.

On par le terminal sur Linux, pareil sur Mac.

On ouvre le terminal dans le démarrer en tappant CMD sur Windows. 

Les autres, c'est dans les menu que nous avons le terminal suivant notre système.

Ensuite il faut se rediriger dans le répertoire du fichier.

Sur Windows, ce qui est pratique, c'est qu'o-à l'endroit où il nous affiche le chemin, on clique et on a le chemin en absolu. 

On fait un copier et on peut comme ça se diriger dessus, avec la commande CD peu importe notre système d'exploitation pour Change Directory pour changer de répetoire et on fait un coller pour obtenir :
	
	CD C:\...\C\cours\002_compiler
	
Et là, on est effictement bien dans le repertoire qu'il faut.

On commence ensuite à taper notre code :

```c
#include <stdio.h>

int main(void)
{
	printf("Bonjour tous le monde ! :) \n");
	return 0;
}
```

C'est le code minimal et correcte pour afficher un petit mot à l'écran en langage c.

On fait un petit bonjour, le fameux hello world en version française.

C'est le code minimal qu'on peut avoir en langage c pour afficher quelque chose à l'écran.

On va maintenant compiler ce programme avant de passer aux explications.

La commande est la même pour tous. C'est exactement pareil que le soit sur Wiwdows, Linux ou MacOS. Peu importe, ça ne va rien changer et on va pouvoir compiler.

On utilise l'outil GCC. 

On lui indique ensuite la source qui est fichier main.c

On utilise ensuite une option, un argument -o pour lui dire que je veux obtenir directement un exécutable alors il y a plusieurs commandes, options pour GCC.

On a -c, -e, on a pleins pleins d'options.

Si la compilation nou intéresse, et qu'on veux en savoir plus, il est recommandé de voir la formation Hacking où l'on explique de manière plus détaillé les différentes étapes de la compilation avec GCC. Ici on va se contenter d'un -o comme ça, on obtient directement notre binaire, notre exécutable tout simplement.

On met ensuite le nom de l'exécuta que l'on veux, par exmple hello.

```powershell
gcc main.c -o hello
```
	
Si on va dans notre répertoire, on voit qu'il nous a créé un exécutable nommé hello.exe parce que on est sur Windows. Ca n'aurait pas d'extension si on était sur Linux ou MacOS. On va pouvoir exécuter notre exécutable.
	
On ne va pas pouvoir l'exécuter en double cliquant dessus. Dans ce cas, il va ouvrir un terminal qu'il va refermer directement puisque je n'ai rien mit qui permette de mettre en pause ce terminal.
	
Si on l'ouvre nous même, le terminal sera déjà ouvert donc il ne va pas se fermer.
	
Si on double clic sur l'exécutable, il affiche bien entendu bonjour tout le monde mais ça se referme tout de suite, hyper rapidement.
	
Ce n'est cependant pas comme ça qu'on va commencer. On ne va pas s'amuser à mettre en pause le programme pour le voir.
	
On va l'exécuter tout simplement.

Sur GNU Linux ou MacOS, on ferait tout simplement ./hello Sur Windows, on écrit hello ou alors hello.exe.
	
Ainsi on vient de compiler notre premier programme en langage C et d'afficher un petit message. 
	
## Explication
	
Nous allons expliquer un petit peu tout ça.

Nous avons le code minimal que nous allons détaillé rapidement.

La première ligne identifié avec un # permet de faire une inclusion si on n'est pas très fort en anglais, pour include.

Il est suivi de stdio avec une extension .h

Le .h permet d'identifier un fichier d'en-tête.

Il faut savoir que le langage C a une bibliothèque standard.

C'est un ensemble de fonctions dont on parlera après toutes faites qui permettent de faire plusieurs choses qui sont intégré dans cette bibliothèque.

Et ces bibliothèques sont triées, elles sont organisées d'une certaines manière dans des fichiers d'en-têtes. 

Par exemple, tel fichier d'en-tête permet de retrouver des fonctions propre à tel ou tel chose.

Ici stdio se termine par io, qui correspond à input/output c'est-à-dire tout ce qui est liés aux entrées/sorties notamment ici la fonction printf qui va permettre d'afficher quelque chose à l'écran. printf() est une fonction qui est inclue dans la bibliothèque standard et que l'on peut utliser car on a inclut le fichier d'en-tête stdio.

Donc on le met entre chevrons, de petits chapeaux que l'on met directement entre comme ça on peut l'inclure. Elle est obligatoire.

Dans chaque programme en C, le minimum que l'on peut inclure pour faire quelque chose, c'est ça, le fichier d'en-tête stdio.

Ensuite, on arrive sur un espèce de bloc :

```c
int main(void)
{
	printf("Bonjour tous le monde ! :) \n");
	return 0;
}
```

Ce bloc a des accolades avec une petite tabulation qui a été faite. Un lisibilité, indentation a resoecter dans la programmation.
	
Ensuite, on a ce que l'on appelle une fonction, quo'on sait identifier avec des accolades.

On a l'espèce d'en-tête int main(void){} qui va permettre de comprendre, d'avoir toutes les informations sur cette fonction. 

Cette fonction a son nom "main", l'éditeur de code lui colore sa syntaxe.

C'est pour ça que c'est utile d'utiliser un éditeur de code à coloration syntaxique.

Entre parenthèse, elle a des paramètres, des valeurs qu'elle va pouvoir prendre en paramètre, des informations. Comme on en a pas, on met un mot clé void. On aura l'occasion de l'utiliser plus tard.

On a un mot int pour integer qui veut dire entier et qui signifie le retour.

C'est ce que la fonction va renvoyer.

On verra les fonction plus tard mais sachez qu'une fonction quand on veut être rigoureux par rapport aux normes et standards du langage C. 

Une fonction ne doit faire qu'une seule chose, elle doit toujours retourner quelque chose à la fin.

Et là il faut regarder dans les instructions :

```txt
printf("Bonjour tous le monde ! :) \n");
return 0;
```
			
On a deux instructions. Il y a un système d'instruction du fait que c'est un langage impératif, de programmation impérative. On a deux instruction et la deuxième retourne 0.

0 est bien un entier, c'est pour ça qu'on dit "int" main(void).

Si on faisait un return; sans rien, on pourrait mettre void.

```c
void main(void)
{
	printf("Bonjour tous le monde ! :) \n");
	return;
}
```
	
On pourrait même faire encore plus petit :

```c
void main(void)
{
	printf("Bonjour tous le monde ! :) \n");
}
```

Mais comme la norme du langage C veut qu'on respecte, une certaine règle, de **retourner toujours quelque chose dans la mesure du possible**, on va respecter cela.

```c
int main(void)
{
	printf("Bonjour tous le monde ! :) \n");
	return 0;
}
```
	
On va donc faire comme ça avec un return 0;
	
Ensuite le petit printf() pour afficher quelque chose à l'écran, c'est une fonction qui est incluse, qui existe dans la bibliothèque standard du langage C et que l'on peut utiliser car on a inclut cette en-tête stdio, ce fichier d'en-tête ici : stdio.h
	
Pour résumé, on a une ligne d'inclusion :

```c
#include <stdio.h> 
```

C'est ce que l'on appelle, une directive de pré-processeur.

On aura une vidéo qui serra faite exclussivement pour parler de ça.

On a ensuite des instructions qui peuvent être misent dans des fonctions (ce n'est pas obligatoire). La fonction main, c'est l'exception, elle est obligatoire.

Le compilateur quand il va compiler, il s'attend à avoir une fonction main.

Il faut vraiment qu'elle y soit.

S'il n'y en pas et qu'on compile, le compilateur ne la trouve pas :
	
```c
int debut(void)
{
	printf("Bonjour tous le monde ! :) \n");
	return 0;
}
```

Pour le compilateur, il n'y en a pas. Il chercher une fonction main. Il n'en trouve pas donc il ne veux pas compiler, il y a une erreur.
	
Simplement que le programme va démarrer par cette foncion. C'est le point de départ de notre programme.
	
Eventuellement dans la fonction main, on peut appeller d'autres fonctions.

On pourrait appeler une fonction bonjour() mais ça on le verra dans les séances prochaines.
	
Voilà globalement pour la syntaxe que l'on peut retrouver dans le langage pour son fonctionnement.
	
Pour la compilation, on a tout dit, globalement, au niveau de la création d'un fichier, au niveau de sa compilation, au niveau de la compréhension d'un code minimum, qu'est-ce qui permet de différencier chacunes des lignes.
	
On aura l'occasion de détailler et d'apprendre à utiliser tout ça.

Nous apprendrons nos premier concepts, notions au cours des prochaines vidéos.
	
On aura fait le temps et ainsi notre premier programme est compilé.

Pensez à installer tous les outils qu'il faut comme on l'as fait avec MinGW

ou alors tout simplement parceque on a déjà nos outils sur GNU Linux ou MacOS.

Ou alors passer par un environnement de développement et tester ce code.

Il est recommandé d'éviter de mettre des espaces avant, après. Il faut les éviter au maximum.