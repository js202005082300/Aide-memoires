# [4. Lire données au clavier](https://www.youtube.com/watch?v=I9xlZGDMfrw)

Bonjour à tous nous sommes sur la séance 4 sur votre formation au langage c.

La vidéo précédente sur les variables était assez longue, elle faisait pratiquement 3/4 d'heure donc ici je vais vous laisser souffler un petit peu on va faire une vidéo assez courte.

Pour les variables il y avait vraiment beaucoup de choses à dire, beaucoup de choses à apprendre parce qu'il y a pas mal de mots-clés, de mots réservés et cetera, de types également à connaître globalement mais bon si vous faites le résumé vous verrez qu'il n'y a pas grand chose à retenir à part le type char, signed char, int, float et les autres types.

On a vu également quelques mots-clés pour faire des variables constantes, ce qui est quand même assez pratique, et puis évidemment comment déclarer et affecter des valeurs à nos variables.

On s'était arrêté là-dessus la dernière fois avec également quelques conversions, on avait vu également comment caster notamment certaines variables pour changer leur type.

Maintenant on va voir comment lire des données au clavier donc c'est le sujet de cette vidéo grâce à nos variables parce qu'évidemment pour lire quelque chose il faut bien le stocker en mémoire pour pouvoir travailler dessus.

Jusqu à présent, on va reprendre un exemple très simple, on pouvait afficher l'âge d'un utilisateur de cette façon là.

```c
#include <stdio.h>

int main(void)
{
	int ageUtilisateur = 25;
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Vous avez 25 ans.
```

Voilà je ne reviens pas dessus c'est quelque chose que vous aviez revue précédemment qui était relativement simple avec le petit joker %d, %d parce qu'il s'agit d'un entier ayant mettez ensuite la variable pour remplacer le joker par son contenu donc là on a bien 25 ans.

C'est bien mais c'est marqué en dur dans notre code `int ageUtilisateur = 25;` ce n'est pas dynamique mais nous on aimerait pouvoir agir avec l'utilisateur, ce qui sera un peu le but est ce qui sera intéressant également du coup on va apprendre à faire saisir des données au clavier.

Au début ageUtilisateur, on va lui affecter une valeur de 0 par défaut parce que c'est plus propre. Je vous avais conseillé de toujours affecter une valeur par défaut à toutes vos variables comme ça vous êtes sûr qu'il n'y aura pas n'importe quoi de stocker dedans et on va demander l'information à l'utilisateur donc on va commencer par poser une question avec un printf() ce qui est un peu logique parce que on ne va pas demander l'information ça avoir demandé quel genre d'information.

```c
#include <stdio.h>

int main(void)
{
	int ageUtilisateur = 0;
	printf("Quel age avez-vous ?");
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```

Voilà `printf("Quel age avez-vous ?");` certains prennent l'habitude de passer à la ligne *"Quel age avez-vous ?\n"* mais vous pouvez aussi laisser un espace *"Quel age avez-vous ? "* c'est ce qu'on appelle la syntaxe la ponctuation à la française juste après vous allez utiliser la saisie d'informations au clavier donc pour cela vous allez utiliser une fonction qui s'appelle scanf() qui est un peu l'inverse de printf() et qui va permettre de récupérer l'information que l'on veut.

```txt
#include <stdio.h>

int main(void)
{
	int ageUtilisateur = 0;
	printf("Quel age avez-vous ?");
	scanf("");
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```

Alors petite précision au sujet de la fonction scanf() et vous le verrez dans certains environnements de développement, ou peut-être même dans certains autres supports, scanf() n'est pas une fonction sécurisée de base mais attention ça ne veut pas dire qu'il ne faut pas l'utiliser, ça c'est pareil il y a beaucoup de développeurs et de gens qui forment des personnes qui vous disent que scanf() c'est une très mauvaise fonction et qu'il ne faut jamais s'en servir et qu'il faut en utiliser d'autres que l'on verra par la suite d'ailleurs, c'est faux.

Je vous l'ai dit au début de la formation, le langage c bas niveau qui demande une certaine rigueur c'est à dire que ce n'est pas le genre de langage qu'on recommanderai à un enfant de 5 ans qui ferait probablement n'importe quoi ça demande ainsi un minimum de sérieux et un minimum de rigueur donc il ne faut pas En bref faire n'importe quoi avec.

Il faut tout simplement savoir les limites de chacune des fonctions, savoir leur risque potentiel en matière de sécurité et les utiliser à bon escient parce qu'il y a dans certains cas des fonctions qui ne seront pas nécessaires et d'autres qui sont plutôt recommandé et cetera.

scanf() n'est pas une mauvaise fonction, c'est une fonction qui par défaut n'a pas de sécurité, ça veut dire que l'on peut rencontrer des failles, des problèmes de sécurité dans nos programmes à cause de cette fonction si on ne l'utilisent pas correctement d'ailleurs si vous suivez l'information hacking mais tout est pas encore une fois de quand vous regardez cette vidéo, je vous montre quelques extraits possible avec l'utilisation de cette fonction par exemple comment est-ce qu'on peut détourner un programme pour par exemple s'autoriser tous les droits ou ce genre de chose.

Encore une fois ce n'est pas parce que c'est une fonction risquée qui n'est pas sécurisé de base, au contraire apprenez à utiliser ce qui n'est pas forcément accessible pour tout le monde et comme ça ça vous évitera de faire des bêtises avec donc nous on va se contenter de quelque chose assez simple.

Nous on veut en âge donc on veut un entier, on va utiliser comme pour le printf() un autre joker et comme j'attends un entier je vais mettre un %d comme ceci `scanf("%d");` mais ne mettez pas \n pour le passage à la ligne sinon vous risquez d'avoir des problèmes.

Voilà vous mettez juste ce que vous voulez comme joker entre guillemets, et ensuite après une virgule comme pour la syntaxe de printf() vous mettez la variable dans lequel vous allez vouloir le stocker.

```txt
#include <stdio.h>

int main(void)
{
	int ageUtilisateur = 0;
	printf("Quel age avez-vous ? ");
	scanf("%d", ageUtilisateur);
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Quel age avez-vous ? 12
```
:warning: le programme plante.

Alors ça c'est la base par contre il va y avoir une petite différence au niveau de scanf(), je vous avais dit que au niveau de la mémoire tout était stocké dans des adresses d'accord et donc l'adresse c'est tout simplement l'emplacement mémoire sur votre ordinateur.

Quand je mets ça `int ageUtilisateur = 0;` avec ageUtilisateur qui va devenir une adresse sur notre ordinateur, Il va devenir une adresse quand l'ordinateur va compiler le programme c'est à dire que quand le compilateur va compiler il va remplacer ageUtilisateur par un nombre qui sera l'adresse donc il va le faire que à ce moment-là.

Par contre, avant la compilation, l'adresse c'est simplement une étiquette *ageUtilisateur* donc ce ne sera pas l'adresse elle-même, ce sera peut être un petit peu vite mais ce qu'il faut que vous compreniez c'est qu'en mettant ça `scanf("%d", ageUtilisateur);` on ne dit pas de stocker ce qui est tapé au clavier dans la variable qui est stockée à l'adresse de la variable ageUtilisateur mais je vais vouloir directement le stocker dans la variable comme ça mais je ne peux pas parce que ce n'est pas suffisant comme information d'écrire seulement ageUtilisateur.

Écrire *ageUtilisateur* est suffisant quand on déclare la variable, qu'on l'affecte parce qu'elle est créée à ce moment-là donc c'est le système qui veulent choisir une adresse par contre ici `scanf("%d", ageUtilisateur);` nous n'avons pas l'adresse de la variable mais on va avoir sa valeur.

Ainsi ceci *ageUtilisateur* vaut 0, nous on veut stocker ce qui va être tapé au clavier dans une boîte qui a été réservée pour cette variable donc on utilise un petit symbole qui s'appelle le **et commercial** où l'esperluète c'est selon les cas qui va permettre de l'identifier.

À partir du moment ou vous notez ce symbole-là **&** devant un nom de variable, vous indiquez l'adresse donc *&ageUtilisateur* est l'adresse d'une variable.

```c
#include <stdio.h>

/*
	maVariable		: contenu de la variable (exemple maVariable = 15)
	&maVariable	: adresse où est stockée la variable
*/

int main(void)
{
	int ageUtilisateur = 0;
	printf("Quel age avez-vous ?");
	scanf("%d", &ageUtilisateur);
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```

Voilà donc ça c'est super important et donc à chaque fois que vous utilisez scanf(), il faudra utiliser ce caractère &.

Ce sera différent quand on manipulera les chaînes de caractères mais on aura l'occasion puisqu'il y aura une vidéo spéciale, il y a une vidéo prévue juste pour les chaînes de caractères et là vous verrez que l'exception voudra qu'on aura juste à noter ceci `scanf("%d", ageUtilisateur);` donc sans utiliser le et commercial parce que là on manipulera des chaînes de caractères mais on n'en est pas encore là.

Donc pour tout ce qui est `int`, `float` et cetera, vous pouvez sans problème les afficher et les récupérer comme ça et on n'oublie pas le symbole et commercial (&).

En fait attention parce qu'il y a beaucoup de personnes qui oublient ce symbole et du coup le scanf() ne marche pas donc vraiment très important d'avoir ça donc maintenant on va afficher ce qu'on va rentrer.

Ainsi nous allons compiler puisque maintenant nous avons tout.

```c
#include <stdio.h>

/*
	maVariable		: contenu de la variable (exemple maVariable = 15)
	&maVariable	: adresse où est stockée la variable
*/

int main(void)
{
	int ageUtilisateur = 0;
	printf("Quel age avez-vous ? ");
	scanf("%d", &ageUtilisateur);
	printf("Vous avez %d ans.\n", ageUtilisateur);
	return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Quel age avez-vous ? 24
Vous avez 24 ans.
```


Vous voyez qu'il demande directement quel âge vous avez, et il vous l'ajoute directement après un espace ainsi je peux noter 24 et il valide.

Du coup c'est tout de suite plus dynamique et cetera.

```powershell
gcc main.c -o prog
prog.exe
Quel age avez-vous ? 43
Vous avez 43 ans.
```

Voilà donc là on a un résultat dynamique en fonction de ce qui est entré par l'utilisateur.

Alors petite précision par rapport à ça parce que je reviens sur l'aspect sécurité, pourquoi est ce que scanf() n'est pas une fonction sécurisée ? Parce que tout simplement qu'ici vous demandez à l'utilisateur d'entrer son âge mais regarder rien ne m'empêche de mettre par exemple ceci *Jason*.

```powershell
gcc main.c -o prog
prog.exe
Quel age avez-vous ? Jason
Vous avez 0 ans.
```

Voilà ici il me met 0 du coup ici vous allez vous dire qu'il n'a pas modifié la variable mais oui y'a un problème effectivement parce qu'il ne l'a pas stocké *Jason* dans la variable mais bon ce n'est pas trop grave parce que ça va bah du coup avec ce genre de saisie on peut modifier le fonctionnement du programme et lui faire avoir un comportement qui n'était pas prévu et du coup on a fait ce qu'on appelle un hack, ce qu'on appelle du hack tout simplement.

Ce n'est pas du piratage mais c'est du hack, on peut ainsi modifier le comportement d'un programme et du coup lui faire faire autre chose comme injecter par exemple un code qui pourrait donner des erreurs ce genre de chose. Voilà ça peut aller très très vite.

C'est pour ça qu'on dit qu'elle n'est pas sécurisée et qu'elle est déconseillée mais dans certains cas on verra encore une fois comment l'utiliser de manière propre, de manière sécurisée, on verra également d'autres fonctions.

Par la suite on verra comment faire des saisies plus sécurisées que scanf() mais n'oubliez pas que jusqu à présent et dans toutes les vidéos que je vais montrer j'utiliserai cette fonction scanf() pratiquement tout le temps par rapport à ce que l'on veut faire c'est largement suffisant il n'y a pas de problème et comme n'utilise pas encore les chaînes de caractères ça ira.

Voilà c'est quand on aura des chaînes de caractères qu'il faudra surveiller parce qu'on peut déborder au niveau de l'espace réservé pour un texte et là ça peut amener d'autres soucis mais pour le moment pas de problème à ce niveau-là, et ne vous en faites pas on verra tout.

Moi mon intérêt c'est que vous partiez vraiment de la base, vraiment de rien du tout, et que vous puissiez atteindre les compétences les plus hauts possibles, et que vous puissiez même par la suite vous former sur d'autres choses en complément pour pas que vous essayez de limite.

Voilà on ne va pas se contenter de faire le minimum puis de se dire voilà vous connaissez la base et puis c'est tout, on en reste là et puis le reste vous vous débrouillez, non on ira vraiment sur des choses très spécialisées, très professionnelles comme le font les entreprises et les experts en sécurité et cetera.

On ira vraiment très très loin au niveau de cette formation que je vous propose donc vous verez tout l'aspect sécurité, pas d'inquiétude.

Voilà nous n'allons pas passer à côté de ça, voilà surtout que je suis très porté sur ce qui est sécurité donc pour moi c'est très important.

Ainsi je ne travaille pas en informatique sur la sécurité, ça ne va pas sans l'autre voilà on peut pas dire qu'on fait de l'informatique sans faire de la sécurité pour moi ce n'est pas pensable.

Du coup ne vous en faites pas on aura l'occasion d'en reparler bien en détail.

Voilà c'était tout au niveau de scanf() tout simplement pour la saisie de données, de faire comme ceci donc n'oubliez pas votre joker `%d` pour identifier la donnée que vous attendez, et ensuite un petit symbole esperluette & (ou le et commercial) pour récupérer dans l'adresse. On peut du coup le faire sur pas mal de choses, on peut le faire sur un caractère et cetera.

Voilà par exemple on va le faire sur un caractère.

```c
#include <stdio.h>

/*
    maVariable      : contenu de la variable (exemple maVariable = 15)
    &maVariable : adresse où est stockée la variable
*/

int main(void)
{
    signed char lettre = 'A';

    printf("Entrez une lettre : ");
    scanf("%c", &lettre);

    printf("Lettre choisie => %c\n", lettre);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Entrez une lettre : d
Lettre choisie => d
prog.exe
Entrez une lettre : c
Lettre choisie => c
```

Voilà on rentre une seule lettre et ça fonctionne parfaitement.

Voilà c'est tout ce que j'avais à vous montrer à ce niveau-là donc je vous avais dit que c'était une vidéo très très courte histoire de faire une bonne petite pause, histoire de souffler avant d'attaquer la suite parce qu'on va avoir pas mal de petites choses.

On va avoir pas mal de petites notions à chaque fois et après on va parler des structures de données donc ça va être encore plus compliqué, on va parler de pointeur enfin vous aurez pas mal de petites surprises, pas mal de petites choses qui vous attendent dans ce langage mais en attendant vous savez comment se composant programme on language c.

Ainsi vous savez comment compiler, comment créer des fichiers, vous savez comment afficher des données à l'écran, vous savez comment saisir des informations au clavier et comment manipuler des variables.

Dans la prochaine vidéo on parlera des opérateurs donc on verra comment faire des opérations, tout simplement des calculs sur les variables donc les modifier même des fois de manière dynamique et cetera.

Voilà on doit pas seulement demander quelque chose et l'afficher, ce n'est évidemment pas tout ce qu'on attend du langage, moi je vous laisse avec ça et n'hésitez pas à vous entraîner à faire quelque petit programme d'exemple.

Pareil tout dépend de quand vous visionnez cette vidéo mais il est possible qu'il y ait déjà des exercices sous forme d'énigme, sous forme de petit jeu, de petits trucs sympas et le but c'est de faire des exercices originaux et d'éviter les exercices bateau du genre calculer l'aire d'un carré, calculer le rendu d'une monnaie ou la réservation dans un restaurant, il faut faire le calcul prix TTC et cetera qui sont déjà des trucs mathématiques d'une part, voilà ce sont toujours des exercices bateau les mêmes exercices et cetera ce qui devient casse-pieds et répétitif à la longue.

Moi j'essaie de rendre ça le plus original, et j'espère que ça vous plaira mais encore une fois tout dépend de la date à laquelle vous regardez-là cette vidéo.

Ainsi il est fort possible que vous ayez déjà les énigmes disponibles sur la chaîne et dans ce cas là vous pourrez profiter de pas mal d'exercice à sympa puis de vous entraîner sur des cas concrets et de mettre en pratique tout ce que vous apprenez et puis de s'amuser un peu parce que le but c'est quand même de se passionner un petit peu pour tout ça et de prendre beaucoup de plaisir.

Voilà on se retrouvera pour une prochaine vidéo pour parler des opérateurs que l'on va retrouver dans le langage, en attendant bonne révision et bon apprentissage du langage c, et à bientôt sur la chaîne