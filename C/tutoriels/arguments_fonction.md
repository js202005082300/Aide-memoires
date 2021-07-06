# [Arguments fonction main()](https://www.youtube.com/watch?v=sy7VBahyBLI)

Le but de cette vidéo est de voir comment passer des arguments à la fonction main().

En règle générale on note la fonction main() de cette manière en écrivant void entre parenthèse.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{

    return 0;
}
```

Sur internet, dans des livres, on peut y voir d'autres paramètres inclus pour la fonction main().
 
Paramètres au nombre de 2.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{

    return 0;
}
```

Un entier *argc* et un pointeur sur un tableau de chaîne de caractères qui s'appelle *argv[]*.

Il peut être noté avec des crochets ou bien sans les crochets avec deux étoiles.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{

    return 0;
}
```

Ca revient exactement au même mais c'est juste la notation qui diffère.

De manière courante on note *argc* et *argv* mais je peux noter plus simplement *c* et *v*.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int c, char **v)
{

    return 0;
}
```

Il faut avoir vu la vidéo sur les fonction et connaître les chaînes de caractères, et des notions sur les conditions est suffisant pour cette vidéo.

Alors quand on utilise pas ces paramètres dans un programmes, il est plus logique de mettre un paramètre *void* comme ça on a aucun paramètre pour la fonction.

```
int main(void);
```

On va voir au niveau de l'exécution ce qu'on ferait d'habitude. 

```c
#include <stdio.h>
#include <stdlib.h>

int main(int c, char **v)
{
    printf("Bonjour.\n");
    return 0;
}
```
```powershell
gcc main.c -o prog
prog.exe
Bonjour.
```

Lorsqu'on vient de compiler `gcc main.c -o prog`, on peut l'exécuter. Sur Windows, on tape le nom de l'exécutable ou alors on tape le nom de l'exécutable et son extension. 

Sur Linux, au Mac, on met un point et un slash suivi du nom de l'exécutable.

On souhaiterait pouvoir renseigner un premier argument, puis un 2e, puis un 3e, et cetera.

```
prog argument1 Bonjour
Bonjour.
```

Voyez qu'en exécutant la commande, ça ne pose pas de problème de renseigner des choses par la suite. Et donc ça, c'est tout l'intérêt de d'utiliser ces fameux paramètres de la fonction main().

Pas de problème, le fait de rajouter des choses par la suite. 

C'est tout l'intérêt d'utiliser le fameux paramètre de la fonction main(), le premier, et vous l'avez peut être compris, il y a *arg* comme argument va permettre de stocker le nombre d'arguments mais attention, parce qu'on compte également le nom de l'exécutable lui-même.

## argc pour vérifier le nombre arguments

On peut vérifier le nombre d'arguments avec un petit printf().

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    printf("Nombre d'arguments : %d\n", argc);
    return 0;
}
```
```powershell
gcc main.c -o prog
prog
Nombre d'arguments : 1
```

On recompile tout ça `gcc main.c -o prog` puis on exécute avec simplement `prog` et il vous dit que le nombre d'arguments est à 1 donc il prend bien le nom de l'exécutable.

Si je met ceci.

```powershell
prog 1234 bonjour
Nombre d'arguments : 3
```

Là Il me compte 3 arguments. 

Si je veux après les arguments réellement entrer sans compter l'exécutable, il suffit de faire un petit *argc - 1*.

Voilà rien de bien compliqué à ce niveau-là.

Voilà à quoi sert ce premier paramètre de la fonction main(), il contient le nombre d'arguments que vous lui passer à l'exécutable directement à l'exécution du programme.

Voilà ça peut du coup vous voyez être ré-utilisé, on peut faire des tests dessus.

## argv pour afficher arguments

Ensuite *argv* va contenir l'ensemble des paramètres que l'on entre.

Il faut imaginer un petit peu comme si votre terminal ici était une fonction déjà quand vous exécutiez et que vous faites appel à la fonction main() lors de l'exécution en passant des paramètres.

Voilà donc ça fonctionne exactement comme si on faisait par exemple main(1234, "bonjour") sauf qu'on ne commence pas à taper du code on tape simplement le nom des exécutables, les paramètres que l'on veut séparés par un espace et ça fonctionne.

Alors on affiche avec un %s puisque ce sont des chaînes de caractères attention et on va commencer avec *argv[0]* puisque c'est évidemment le premier.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    printf("Premier argument : %s\n", argv[0]);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog
Premier argument : prog

prog 1234
Premier argument : prog
```

On recompile et si je tape *prog* il me dit premier argument *prog*. Peu importe ce qui derrière, on retourne le 1e argument.

Si je demande *argv[1]*.
```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    printf("Premier argument : %s\n", argv[1]);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog 1234
Premier argument : 1234

prog 192.168.1.1 8006
Premier argument : 192.168.1.1
```

Le premier argument est *1234* si je prends l'argument que je voulais rentrer ici.

On peut sans problème récupérer les arguments noter ici à l'exécution et avoir toujours toujours le total même s'il faut soustraire 1 pour enlever le nom de l'exécutable par rapport du nombre d'arguments passés par l'utilisateur de votre programme.

Alors à quoi ça peut servir ce genre de choses ?

C'est utile dans beaucoup de cas, admettons vous faites un client serveur et que vous voulez le tester, vous n'allez pas forcément à faire une interface graphique avec un champ de texte pour entrer le nom du serveur, un champ de texte pour entrer le numéro de port, un bouton pour se connecter, etc.

Mine de rien pour juste tester un petit client serveur c'est quelque chose qui est assez lourd une interface graphique.

Souvent pour aller plus vite, souvent même d'ailleurs dans les interfaces administration ou sur des vraies serveurs, des serveurs web comme on n'a pas d'interface graphique il faut bien se débrouiller en ligne de commande et c'est surtout plus rapide.

Moi ce que j'aimerais pouvoir faire c'est de faire `prog 192.168.1.1 8006` où on rentre une adresse ip et un numéro de port et qui puisse me dire par exemple qu'il se connecte sur le serveur 192.etc.

Alors très simple, première vérification par rapport à ça soit le nombre d'arguments passés.

```powershell
prog 192.168.1.1 8006
Premier argument : 192.168.1.1
```

Là vous voyez que j'ai 3 arguments : le nom de l'exécutable, une adresse ip et le numéro de port donc automatiquement je vais faire mes tests.

Si je n'ai pas trois arguments c'est que l'utilisateur n'a pas exécuté le programme comme il fallait donc je vais lui repréciser et général on met ceci.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    if(argc != 3)
    {
        fprintf(stderr, "Format : programme <IP> <port>\n");
        exit(EXIT_FAILURE);
    }

    return 0;
}
```

On n'oublie de faire passer sur la sortie d'erreur standard *stderr* et on va faire un *EXIT_FAILURE*. Voilà je précise carrément avec une constante, c'est pour ça que j'ai inclus d'ailleurs **stdlib** pour pouvoir utiliser *EXIT_FAILURE* avec la fonction exit().

Voyez si on a pas le nombre d'arguments, on quitte.

On va recompiler.

```
gcc main.c -o prog
prog
Format : programme <IP> <port>
prog
Format : programme <IP> <port>
```

A partir de là si je tape ce format là, *prog 192.168.1.1 1234* voyez que ça passe donc je peux traiter l'information.

Ensuite je vais me contenter de faire un affichage en choissant l'ordre dans lequel je veux les présenter.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    if(argc != 3)
    {
        fprintf(stderr, "Format : programme <IP> <port>\n");
        exit(EXIT_FAILURE);
    }

    printf("Connexion au serveur %s en cours... (port %s)\n", argv[1], argv[2]);

    return 0;
}
```

Vous pouvez mettre comme ça si vous voulez avoir un meilleur affichage.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    if(argc != 3)
    {
        fprintf(stderr, "Format : programme <IP> <port>\n");
        exit(EXIT_FAILURE);
    }

    printf("Connexion au serveur %s en cours... (port %s)\n", 
            argv[1], argv[2]);

    return 0;
}
```
```powershell
gcc main.c -o prog
prog 145.127.12.1 8006
Connexion au serveur 145.127.12.1 en cours... (port 8006)
```

Dans ce cas-là, je fait *prog 145.127.12.1 8006* avec un port 8006 et il me dit bien connexion au serveur 145 en cours port 8006 donc ça fonctionne et vous voyez qu'on peut directement traiter avec les arguments ici, renseigner avant même d'exécuter notre programme donc c'est très utilisé dans beaucoup de choses notamment un programme qui devrait s'exécuter un certain nombre de fois et ainsi ça peut être utile dans pas mal de choses.

Si on veut un nombre un nombre plutôt que de faire un scanf() qui n'est pas la manière la plus sécurisée.

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    printf("Nombre de joueurs : ");
    scanf("%d");

    return 0;
}
```

On peut plutôt faire *game 3* où 3 serais directement le nombre de joueurs.

```powershell
gcc main.c -o game
game 3
```

Voilà ce serait géré directement dans le programme, voilà l'utilisation de ces paramètres soit le **passage d'arguments à la fonction main()** donc c'est comme ça que ça fonctionne, il n'y a rien de plus à savoir puisque c'est vraiment très simple comme vous le voyez.

Tout ce qu'il faut retenir c'est qu'on a un premier paramètre qui contient le nombre d'arguments passés y compris le nom de  l'exécutable et un deuxième paramètre qui lui est un tableau qui stocke les paramètres en eux-mêmes.

Vous pouvez ensuite directement les utiliser, les exploiter et travailler dessus, les modifier ou je ne sais quoi directement dans la fonction main() et ça fonctionnera sans problème.