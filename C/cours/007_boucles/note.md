# [7. Boucles](https://www.youtube.com/watch?v=in-XJLbQ1iY)

Bonjour et bienvenue pour votre séance numéro 7.

Nous allons parler des boucles qui est une nouvelle notion du langage.

La dernière fois vous avez vu les conditions, je suis allé assez vite dessus pour essayer de ne pas faire trop trop long, mais là on va parler des boucles ce qui sera encore plus court parce qu'il y a encore moins de choses à voir que les conditions mais ça va être très utile.

Je vous demande d'être très attentif, encore plus que d'habitude parce que c'est une partie vraiment très importante.

Les boucles vont servir à plein de choses donc elles ont une utilité de base mais après elles servent également à d'autres choses par la suite pour toutes les autres notions que vous allez apprendre dans ce langage.

C'est vraiment une étape à bien comprendre, comme pour les variables c'est une étape très très importante.

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

Alors on va regarder ça ensemble.

À quoi consiste une boucle ? Je vais vous montrer par exemple à quoi ça sert, pourquoi est-ce qu'on a intégré ce type de notion dans les langages informatiques puisqu'on le retrouve un peu partout.

Un exemple très simple, vous avez certainement déjà fais des copies de ligne, de punition ou simplement de devoir répéter un certain nombre de fois donc je vais faire simplement un petit printf() avec un exemple vous allez voir pas très imaginatif.

```c
#include <stdio.h>

int main(void)
{
    printf("Alerte, les zombies nous envahissent !\n");
    
    return 0;
}
```

On compile et on exécute notre programme.

```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
```

Voyez là on affiche une autre petite phrase comme ceci.

Maintenant si on veut se taper de délire de l'afficher plusieurs fois, je vais m'amuser à le répéter mais pas forcément au même endroit on peut imaginer un programme qui est beaucoup plus gros que ça et du coup je pourrais m'amuser à l'afficher de cette manière.

```c
#include <stdio.h>

int main(void)
{
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    printf("Alerte, les zombies nous envahissent !\n");
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
```

Voilà on peut l'afficher de cette manière mais le problème c'est qu'on répète autant de fois que nécessaire la ligne de code donc c'est répétitif, et là répétition on peut l'éviter en faisant une boucle.

Une bourse va simplement permettre de répéter un ensemble d'instructions, pas forcément qu'une seule instruction comme ici mais ça peut être plusieurs instructions un certain nombre de fois.

Voilà ça c'est l'utilisation de base, c'est l'utilisation un petit peu on va dire de débutants, c'est pour répéter quelque chose plusieurs fois.

Maintenant je vais le répéter plusieurs fois mais pour ça je vais utiliser d'abord une variable d'où l'intérêt de bien comprendre les variables parce que sans les variables nous ne pourrions pas faire grand-chose en informatique comme je vous l'avais dit sur la séance sur la variable donc on va faire ce qu'on appelle généralement un compteur.

## compteur

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    printf("Alerte, les zombies nous envahissent !\n");
    
    return 0;
}
```

En général un compteur on l'appelle i, c'est une convention en informatique et après si on en fait une 2e on peut l'appeler *ii* ou *j* ou *k* et cetera.

Voilà on ne lui donne pas forcément un nom explicite parce que tout le monde sait que le i est un compteur mais après on peut très bien l'appeler comme ça *cpt* ou *compteur*;

Voilà comme c'est très souvent utilisé on sait que i est un compteur donc ce n'est pas une variable directe, en particulier pour une information importante mais c'est juste un compteur.

## while

Et on va faire un petit while() comme pour les conditions, on met des parenthèses.

Vous dites tant que, le while signifie tant que c'est à dire que si on veut le traduire en français cela veut dire *que tant qu'une condition n'est pas vraie, tu vas répéter ce qui suit* donc là ça va être de dire que tu vas devoir répéter le printf() par exemple tant que i est plus petit que 20.

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    while(i < 20)
        printf("Alerte, les zombies nous envahissent !\n");
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
...
```

Voilà on dit que i est égal à 0, et tant que i est plus petit que 20 tu affiches ma fameuse phrase.

Je teste je dois arrêter le programme avec ctrl+c tout de suite parce que vous avez vu qu'il affichait à l'infini, en boucle voilà ça aurait pu tourner indéfiniment.

C'est simplement ce qu'on appelle une boucle infinie parce qu'on ne lui a pas donné une condition d'arrêt.

Ainsi le i est égal à 0 dans mon programme si on reprend depuis le début, et je lui dis que tant qu'il est plus petit que 20 tu l'affiche mais jamais je change le i donc forcément il va me l'afficher indéfiniment et j'aurais pu finir par faire ralentir le PC, voir le faire planter sur des petits PC donc ça peut effectivement le faire planter on évite de faire tourner une boucle infinie comme ça semble logique.

À part pour les jeux vidéo quand on veut lancer par exemple un gestionnaire d'évènements, quelque chose qui va écouter une liste d'évènements par exemple frappe au clavier, une touche de manette mais on en parlera plus tard quand on fera un petit peu de jeux vidéo ou autre ou sur d'autres formations sur la chaîne où vous aurez l'occasion de voir ça avec moi.

Ici on va éviter ce genre de chose et on va mettre une condition d'arrêt.

## Condition arrêt

Alors maintenant comme je veux avoir plus d'une instruction, je vais mettre des accolades à ma boucle while() tel qu'on en avait parlé pour le if() et nous allons faire un `i++;` directement.

Rappelez-vous l'incrémentation comme ça rapide `i++;` qui rajoute comme ça plusieurs à la variable et là automatiquement je n'aurais plus quelque chose d'infini.

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    while(i < 20)
    {
        printf("Alerte, les zombies nous envahissent !\n");
        i++;
    }
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
```

Voilà et là automatiquement avec notre condition d'arrêt on n'aura plus quelque chose qui est infini.

On est parti de 0 et une fois que i est égal à 20, on s'est arrêté.

La `i < 20` on test si i est inférieur à 20 et si c'est oui, on affiche notre printf() et on incrément de 1.

Ainsi i devient 1 et ainsi de suite jusqu à ce que i est égal à 20 et là est ce que `20 < 20` ? Non donc tu ne le fais pas donc quand i est arrivé à 20, il n'a pas affiché notre ligne donc c'est important de vraiment bien prendre ça en compte.

D'ailleurs vous voyez qu'on a 20 lignes à l'exécution parce qu'on est bien parti de 0 d'accord mais c'est par contre j'étais parti de 1, vous aurez vu qu'il en a affiché que 19 puisqu'il ne va pas afficher la 20e parce que la condition n'est plus vrai car 20 n'est pas plus petit que 20, n'est pas plus petit strictement que 20.

```c
#include <stdio.h>

int main(void)
{
    int i = 1;
    
    while(i < 20)
    {
        printf("Alerte, les zombies nous envahissent !\n");
        i++;
    }
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
```

Voilà donc à la 20e il ne va plus l'afficher parce que la condition n'est plus vrai, 20 n'est pas plus petit que 20, strictement, ou alors il aurait fallu faire ceci `i <= 20` c'est à dire que si `i = 1` Eh bien je rajoute un égal à la condition et du coup je compense le problème.

```c
#include <stdio.h>

int main(void)
{
    int i = 1;
    
    while(i <= 20)
    {
        printf("Alerte, les zombies nous envahissent !\n");
        i++;
    }
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
Alerte, les zombies nous envahissent !
```

Voilà du coup on compense le problème, on part de 0 et puis on va jusqu ou on voulait arriver donc si on veut afficher 20 fois, on part de 0 `i= 0` et on dit jusque 20 `i < 20` strictement inférieur à 20 ou différent de 20 `i != 20` ce qui revient au même.

Alors voilà ça c'est la boucle toute simple, voilà à quoi sert la boucle while().

Plus tard vous verrez que les boucles servent aussi à faire du parcours par exemple parcourir des tableaux, parcourir une liste, parcourir une structure de données comme on verra dans la séance prochaine.

Voilà à quoi sert les boucles mais c'est aussi parcourir un fichier également on va lire ligne par ligne donc si on veut lire toutes les lignes affichées il faudra lire tant que on n'est pas arrivé à la fin du fichier, ça c'est un exemple de conditions tout simplement tant que la lecture n'est pas arrivé à la fin du fichier tout à la fin.

Voilà tant qu'on n'est pas arrivé à la fin du fichier on lit chacune des lignes mais ça on le verra dans les vidéos suivantes lorsque vous allez apprendre à faire ça.

Ainsi c'est très utile et très important de bien connaître les boucles.

Donc ça c'est une forme de boucle possible, while().

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    while(i < 20)
    {
        printf("Alerte, les zombies nous envahissent !\n");
        i++;
    }
    
    return 0;
}
```

Ça c'est une forme de boucle possible c'est-à-dire qu'on a une condition à tester `i < 20` et en fonction on exécute quelque chose.

## do while

Maintenant nous avons un autre cas, qui est le fonctionnement do while() c'est à dire que tu fais quelque chose *do* par exemple un petit printf() (très original comme message !) et on termine par un *while()* à la fin, toujours pareil tant que i est plus petit que 20 `i < 20`.

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    do
    {
        printf("Aya !!\n");
        i++;
    }
    while(i < 5);
    
    return 0;
}
```

Alors n'oublie pas la condition d'arrêt `i < 20` et dans ce cas on n'oublie pas le ; à la fin et bien sûr le incrémentation.

```powershell
gcc main.c -o prog
prog.exe
Aya !!
Aya !!
Aya !!
Aya !!
Aya !!
```

Voyez lorsqu'on exécute il a bien affiché 5 lignes directement.

Effectivement on fait `do` c'est à dire *tu fais directement*, tu exécute les instructions et ensuite tu vérifies la condition de la boucle.

La différence c'est que l'un on va dans tous les cas au moins exécuter une seule fois ce qu'il y a dans les accolades d'accord c'est seulement après cette première exécution que l'on rentre dans la boucle c'est à dire que l'on teste.

Maintenant si le test n'est pas validé, on ne va pas y retourner donc on aura exécuté qu'une seule fois.

Ici le while() on faisait le test dès le début donc si dès le début le test n'était pas bon ça ne fonctionnait pas, je peux vous remontrer d'ailleurs ici.

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    while(i < 5)
    {
        printf("Aya !!\n");
        i++;
    }
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
Aya !!
Aya !!
Aya !!
Aya !!
```

Voyez si je fais ça il va nous l'afficher 5 fois mais si dès le début je suis déjà plus grand ou égal à 5 `i = 6`, regardez à l'exécution il ne va rien afficher.

```c
#include <stdio.h>

int main(void)
{
    int i = 6;
    
    while(i < 5)
    {
        printf("Aya !!\n");
        i++;
    }
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe

```

Voilà il n'affiche rien c'est à dire qu'il fait le test dès le début, si vous aviez un vigile à l'entrée il vérifierais si vous avez quelque chose sur vous et si ça ne va pas, vous ne rentrez pas ! Voilà il ne cherche même pas à vous faire rentrer une fois c'est non direct, c'est non direct tu dégages donc ça c'est au niveau du while().

Alors le do while() c'est l'inverse c'est à dire quand vous faire entrer une fois par contre après on va vous tester sinon vous dégagez donc par exemple ici on va recommencer avec la valeur 5 donc ça va bien évidemment fonctionner 5 fois sans soucis.

```c
#include <stdio.h>

int main(void)
{
    int i = 0;
    
    do
    {
        printf("Aya !!\n");
        i++;
    }
    while(i < 5);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
Aya !!
Aya !!
Aya !!
Aya !!
```

Voilà donc là je refais la même chose que tout à l'heure donc ça va bien évidemment fonctionner 5 fois merci par contre cette fois-ci je suis à 6 comme valeur de départ, qu'est-ce qui va se passer ? Avec le while() vous avez vu que rien ne s'affichait mais là il va quand même l'afficher une fois.

```c
#include <stdio.h>

int main(void)
{
    int i = 6;
    
    do
    {
        printf("Aya !!\n");
        i++;
    }
    while(i < 5);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
```

Voilà c'est ce que je vous expliqué le fait d'abord une seule fois comme le *do* est en premier, et ensuite il fait le test seulement après. Si le test est bon il va retourner dans le do jusqu à temps d'arriver au point d'arrêt donc là il a quand même affiché au moins une fois ce teste-là pour que ça fonctionne.

Alors ça c'est la seule différence qu'il y a entre do while() et while(), c'est que ça peut être utile dans certains cas.

Il y a des cas ou on a quand même envie d'effectuer le code de la boucle au moins une fois et après on voit si on doit éventuellement le rappeler une autrefois ou le réexécutez donc c'est une autre variante qui est intéressante à connaître et qu'il faut savoir utiliser parce que ça peut être utile dans certains cas concrets dans vos programmes.

Maintenant on va présenter un dernier exemple, un dernier petit exemple, qui va servir beaucoup pour les parcours. On s'en sert beaucoup pour les parcours donc là je n'aurai pas vraiment beaucoup d'exemples à vous montrer parce qu'on n'a pas encore vu les tableaux, on n'a pas encore parlé de structure de données et tout ça, on n'a pas encore vu non plus la gestion des fichiers mais ce n'est pas grave on va reprendre notre exemple du début.

## for

Alors on va d'abord déclarer notre compteur `int i;` c'est à dire que dans ce cas-ci on ne va plus l'initialiser.

pour la boucle for(), nous avons 3 étapes.

```txt
#include <stdio.h>

int main(void)
{
    int i;

    for(1 ; 2 ; 3);

    return 0;
}
```

Voilà il y a 3 choses dans un for(), on va mettre les mêmes instructions que tout à l'heure et ici on n'aura pas besoin de mettre une autre incrémentation `int i++;`.

Alors la première étape ça va être l'étape d'initialisation c'est à dire qu'on va initialiser la variable qu'on va utiliser donc nous on va mettre `i =0` donc je dis pour i partant de 0. Après le ; c'est la 2e étape, c'est la condition à vérifier donc c'est le *tant que* comme pour le while() donc nous ce sera tant que i est plus petit que 5 `i < 5`. Enfin la 3e étape c'est l'incrémentation à faire donc moi c'est le fameux `i++`.

```c
#include <stdio.h>

int main(void)
{
    int i;

    for(i = 0 ; i < 5 ; i++)
    {
        printf("Aya !!\n");
    }

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
Aya !!
Aya !!
Aya !!
Aya !!
```

Voilà on met tout ici dans le for() et quand on reteste on a exactement la même chose que tout à l'heure mais en plus condensé, en plus pratique.

Ainsi le for() est très utilisé pour ça, pour faire notamment des parcours.

Bien pratique à connaître, c'est aussi un es avantages que l'on peut avoir, on peut faire également d'autres petites choses dedans c'est à dire qu'on peut avoir des utilisations très complexes avec la boucle for() donc des possibilités que l'on peut avoir à ce niveau ici `for(i = 0 ; i < 5 ; i++)`.

Pour l'instant ça n'a aucune utilité pour vous parce que ça fait appel à des notions que vous ne connaissez pas encore mais elle est très puissant parce que la boucle for() permet vraiment de faire plein plein de choses donc on aura l'occasion d'en parler dans des tutos et dans une autre vidéo.

Pour le moment vous pouvez vous contenter de le voir de cette manière, une première étape d'initialisation, en 2e étape on a la condition d'arrêt et enfin le pas c'est-à-dire comment on va avancer dans notre boucle par exemple si on fait une incrémentation, une décrémentation bref peu importe on peut dire par exemple `i+2` comme ceci par exemple.

```c
#include <stdio.h>

int main(void)
{
    int i;

    for(i = 0 ; i < 5 ; i+2)
    {
        printf("Aya !!\n");
    }

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
Aya !!
Aya !!
Aya !!
Aya !!
...
..
.
```

Voilà ça fonctionne également même si on a une boucle infinie !

Voilà on saute pas en pas donc on peut avoir comme ça des exemples qui fonctionnent pour pouvoir modifier un petit peu ce fonctionnement, ce comportement c'est à dire d'avoir une autre manière d'écrire la boucle que l'on veut donc ça c'est bien de la connaître parce que vous pourrez que le for() sera très utile pour la suite.

Alors nous allons en rester là pour ces 3 exemples, les applications que l'on a montrées ne sont pas forcément très pertinentes parce qu'on utilise des boucles pour des choses que l'on n'a pas encore vu par exemple parcours de fichier, un parcours de tableau, un parcours d'arbre binaire, ce qui serait totalement incompréhensible pour vous à ce stade de la formation mais en tout cas vous voyez un petit peu en quoi ça consiste donc si vous n'avez pas tout compris et que vous n'avez pas trop l'utilité pour le moment c'est normal.

Pour le moment nous n'avons pas encore la possibilité de pouvoir les tester comme il faut donc ça viendra par la suite il ne faut pas vous inquiéter.

En tout cas retenez bien qu'il y a une boucle while(), une boucle do while() et une boucle for() qui permettent chacune de faire la même chose plus ou moins avec des petits comportements différents.

## break

Alors on pourrait parler également des mots clés comme **break** que vous connaissez, break peut être utilisé dans une boucle pour quitter la boucle tout simplement c'est à dire pour dire de casser la boucle comme on a déjà pu l'utiliser dans un switch() pas besoin de le représenter ici maintenant on sait comment ça fonctionne.

Break est une instruction donc on peut le mettre facilement dans une boucle comment on pourrais le mettre dans une condition ça fonctionne.

Par exemple si je fais ça.

```c
#include <stdio.h>

int main(void)
{
    int i;

    for(i = 0 ; i < 5 ; i++)
    {
        printf("Aya !!\n");
        break;
    }

    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Aya !!
```

Voilà on a qu'un seul affichage avant d'avoir l'instruction break puis au lieu de continuer la boucle parce que le i n'était pas encore arrivé à 5 donc elle n'a été exécutée qu'une seule fois c'est à dire comme `i = 1` (0 + 1) et bien on est sorti de la boucle c'est à dire qu'on est passé directement après l'accolade fermante et comme il n'était sorti de la boucle et qu'il n'avait plus rien à tester il a directement fait le return donc il a quitté le programme tout simplement.

C'est un petit mot clé à connaître pour vous dire qu'il est également fonctionnel dans une boucle et que défende en a besoin de quitter une boucle parce qu'on a eu un comportement inattendu ou je ne sais quoi, une condition particulière, donc c'est bien à savoir.

Voilà on a dit tout ce qu'il y avait à savoir, cette vidéo était relativement en courte par rapport aux autres.

La fois prochaine nous parlerons des fonctions et de tout ce qui fait la force d'un langage de programmation c'est-à-dire le fait de pouvoir créer comme ça plusieurs petites fonctions pour rassembler, factoriser des bouts de code en fait dans des endroits très précis.

On regardera comment ça fonctionne et on utilisera celle que vous avez l'habitude d'utiliser comme par exemple printf() ou encore scanf() qui sont des fonctions.

On verra comment créer notre propre fonction, et on verra comment travailler avec tout ça.

Entraînez-vous et n'hésitez pas à poser des questions, commenter si vous avez des choses à dire ou à demander s'il y a des choses qui ne sont pas très claires.

Je n'hésite pas évidemment à vous répondre un petit problème histoire que vous soyez prêt pour la suite parce qu'on va attaquer la partie la plus sérieuse.

À partir des fonctions ça commence à se compliquer donc il faut vraiment que tout ce qu'on a vu soit clair jusqu'au bout avant d'attaquer la suite, et que vous ne soyez pas découragé non plus surtout que le langage ce n'est pas forcément très évident lorsqu'on est débutant en informatique donc n'hésitez pas à progresser à votre rythme et à bien revoir les bases pour attaquer la suite, ne pas aller trop vite et brûler les étapes.

À bientôt pour la prochaine vidéo, on se retrouve pour parler des fonctions