# [25. Création rendu](https://www.youtube.com/watch?v=Afov4ZokaOA)

Bonjour à tous, bienvenue sur la séance numéro 25 sur la formation au langage c. On continue avec la sdl, la dernière fois, on s'était occupé de voir comment créer les fenêtres et nous allons voir une autre partie.

Alors il faut savoir qu'en sdl, il y a trois principales choses à savoir faire surtout avec la nouvelle version dont à partir de la version 2.0, vous avez tout ce qui est gestion de fenêtres, vous avez ensuite ce que nous allons voir donc aujourd'hui la gestion de rendu d'accord qui vont nous permettre de dessiner dans notre fenêtre ou éventuellement la troisième chose de créer donc de charger des textures.

Voilà ce sont les trois choses.

Les textures c'est un petit peu les nouvelles versions de ce qu'on appelait les surfaces avant sur l'ancienne version de la sdl que vous pouvez encore utiliser avec la sdl 2 point quelque chose mais je vous déconseille puisque les textures maintenant sont là pour remplacer cet ancien système-là donc trois choses : les fenêtres, les systèmes de rendu et
les textures.

C'est vraiment les trois choses principales à connaître au niveau de la bibliothèque sdl.

La dernière fois, on a vu les fenêtres et là on va s'occuper de tout ce qui est rendu vous allez voir c'est très simple, il y a quelques fonctions à connaître, à utiliser par rapport à ça.

Alors je vais faire une petite parenthèse donc pour rôle pour le début, voyez que là bon j'ai repris le projet tel que je l'avais montré sur l'introduction de la sdl.

Dans la description de la vidéo, si vous voulez vous pouvez télécharger une archive avec tout le projet d'accord qui est ici à chaque fois si vous voulez par exemple un projet de base à chaque fois que vous voulez faire un programme en sdl où tout est déjà inclus tout ce qu'il faut donc c'est la version 2.0.14 (2.0.7) qui a été archivée et j'ai notamment fait des modifications sur le fichier main.c d'accord donc il est déjà inclus également que vous allez le voir ici.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre
    window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);

    if(window == NULL)
        SDL_ExitWithError("Création fenetre echouee");
    
    /*--------------------------------------------------------------------*/
    SDL_Delay(6000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```

## SDL_DestroyWindow

Alors déjà petite parenthèse avant que j'explique un peu les petits changements que j'ai fait, dans la vidéo précédente, on avait vu comment créer une fenêtre par contre j'ai oublié en fait de vous mettre la fonction de destruction de fenêtre d'accord c'est un abonné justement qui me l'a dit oh là que j'avais oublié de mettre la fonction de destruction donc évidemment comme on l'avait vu un la dernière fois en faisant **SDL_CreateWindow()** et il y a l'équivalent pour détruire cette fenêtre puisque rappelez vous qu'en c c'est à nous de nous occuper de la mémoire donc il y a une fonction qui va créer donc alouer l'espace en mémoire pour la fenêtre donc il faut son équivalent qui est **SDL_DestroyWindow()** et vous passez en paramètre directement votre variable, votre pointeur ici *window* en l'occurrence pour votre fenêtre d'accord.

SDL_Quit() c'est le contraire de SDL_Init() pour initialiser la sdl donc SDL_DestroyWindow() c'est le contraire de SDL_CreateWindow().

PAr rapport à la dernière fois le code a un petit peu changé donc j'ai laissé pareil les petites commandes que vous soyez sur linux ou windows.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
```

`-mwindows` ça je rappelle cette option permet de ne pas avoir le terminal d'accord qui se lance par exemple quand vous exécutez votre programme en sdl pour que ça lance seulement l'interface sdl et pas la ligne de commande en plus.

Donc là toujours pareil `stdio.h`, `stdlib.h` et `SDL.h` pas de changement.

## SDL_ExitWithError

Par contre vous voyez que j'ai fait une petite fonction d'accords.

```c
void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```

Alors donc cette fonction c'est tout simplement pour rassembler, j'ai un peu factoriser en fait tout ce qui concerne le fait de quitter le programme par exemple quand il y a eu une erreur donc je vais reprendre chaque point.

On a le pointeur donc par défaut pour notre fenêtre parce qu'à priori vous allez au moins créer une fenêtre si vous faites un programme en sdl, `SDL_Window *window = NULL;`.

Ensuite, on fait une initialisation et si l'initialisation  échoue, voyez on va utilisez cette fonction `void SDL_ExitWithError(const char *message)`.

Donc ça c'est une fonction que j'ai fait d'accord donc on lui passe juste un message tout simplement donc là on crée la fenêtre ensuite si la fenêtre n'a pas pu être créée pareil on utilise cette fonction SDL_ExitWithError().

Ensuite le petit SDL_Delay() donc tout ce qu'on va faire au niveau de notre programme ça se passera entre les deux petites lignes de commentaires que j'ai mis là pour vous aider.

```c
    /*--------------------------------------------------------------------*/
    SDL_Delay(6000);
    /*--------------------------------------------------------------------*/
```

Donc là il y a une pause de six secondes mais là je vais très vite parce qu'on l'a déjà vu dans la vidéo précédente.

Puis la destruction de la fenêtre SDL_DestroyWindow() et le fait de quitter tout simplement proprement la sdl, SDL_Quit().

Ensuite dans cette fonction `void SDL_ExitWithError(const char *message)` il y a juste trois choses : il y a le SDL_Log() d'accord qui va afficher l'erreur par rapport au message que vous allez passer ici en argument. Un SDL_Quit() alors dans ce genre de cas d'accord si par exemple ici `if(SDL_Init(SDL_INIT_VIDEO) != 0)` ça n'a pas réussi à initialiser bon il va faire un SDL_Quit alors qu'il n'y a rien d'initialisée c'est pas grave et de toute façon c'est une fonction qui ne renvoie rien du tout.

```c
    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
```

Ainsi c'est pas gênant si vous essayez de quitter de la sdl qui n'a pas été initialisé, c'est pas gênant par contre ça va servir pour le cas ici.

```c
    if(window == NULL)
        SDL_ExitWithError("Création fenetre echouee");
```

C'est à dire que voilà si vous essayez de créer la fenêtre mais que ça ne marche pas il faudra quand même quitter la sdl proprement.

Vous ne pouvez pas quitter le programme tout simplement sans exit() donc c'est pour ça que j'ai fait cette fonction pour gagner du temps et après on fait un exit(EXIT_FAILURE) pour dire vraiment qu'on quitte donc c'est important toujours même si voilà il y a une  erreur qui est arrivée en cours de toujours fermer la sdl avant de quitter son programme donc pour éviter de devoir répéter partout, j'ai fait une petite fonction `void SDL_ExitWithError(const char *message)` tout simplement pour gérer ça.

```c
void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```

## Rappel compilation & exécution

Voilà donc c'est très simple et logiquement il n'y a rien de compliqué voilà donc ceci étant dit, la parenthèse étant faites on va pouvoir vraiment maintenant s'attaquer au rendu puisque c'est une vidéo qui va être assez longue.

Je ne vous le cache pas, il va y avoir beaucoup de choses à voir et on ne va pas tout voir non plus mais en tout cas le principal.

Alors un rendu qu'est-ce que c'est ? par défaut de toute façons, on va tester tout de suite.

Si je voulais faire mon petit lancement de programmes et on commence par un `CD` de notre dossier SDL puis un `LS` dans le PowerShell.

```powershell
    Répertoire : .\Aide-mémoires\c\SDL\x64


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
da---l          10-04-21     10:59                bin
da---l          05-04-21     21:19                include
da---l          21-12-20     18:48                lib
da---l          10-04-21     10:52                src
```

Donc on a *bin*, *include*, *lib*, *src*. et on va directement faire la commande:

```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```

Il vous suffit juste de faire un petit copier coller de la commande, ici dans PowerShell.

Ainsi là ça lance une fenêtre et ça attend six secondes avant de se fermer tout seul tout simplement, c'est ce qui se passe.

On peut réduire et mettre à 3.

```c
SDL_Delay(3000);
```

On recompile, on exécute et ok voilà trois secondes et ça quitte, pas de problème à ce niveau là donc ça c'est ce qu'on avait déjà vu.

Là on a juste créé une fenêtre, et par défaut il y a absolument rien dedans, c'est juste l'entourage qu'on a créé et donc ce qu'on va faire, c'est créer un rendu et sur ce rendu, on pourra après dessiner dessus.

## Création rendu

### SDL_CreateRenderer

Voilà sur ce rendu, on pourra dessiner ou éventuellement plus tard on verra pour carrément pour afficher des textures, afficher des images en fait voilà des choses comme ça ou autre chose mais en tout cas on va déjà voir pour s'occuper du rendu.

Pour le rendu hé bien on va tout simplement avoir besoin de créer un pointeur qui est `SDL_Renderer` et s'écrit avec un *R* majuscule attention aux minuscules/majuscules dans les noms des structures ou simplement dans les fonctions pour la SDL d'accord ne pas vous tromper et on va l'appeler *SDL_Renederer* qu'on va initialiser à *NULL* pour le moment donc là in créé la fenêtre et on l'inscrit ici.

```c
    SDL_Renderer *renderer = NULL;
    //etc.
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer();
    
    SDL_Delay(6000);
    /*--------------------------------------------------------------------*/
```

Là voyez qu'au niveau de la SDL des noms de fonctions c'est assez logique et elle prends quelques paramètres.

Le premier ça va être la fenêtre dans laquelle vous voulez mettre le rendu, chargé le rendu donc nous c'est *window* je rappelle donc vous mettez simplement le nom et c'est déjà un pointeur donc c'est bon, pas besoin de le passer autrement `renderer = SDL_CreateRenderer(window);`

Ensuite c'est un paramètre qui va permettre de gérer le driver en fait pour l'affichage donc usuellement on met *-1* d'accord je n'entrerais pas dans les détails parce qu'on n'est pas encore allez assez loin en sdl pour que ce soit assez détailer avec à ce niveau-là dont vous mettez *-1* pour ne pas avoir de problème pour le moment.

Et ensuite ça va être un ensemble de drapeaux donc un ensemble de valeurs possibles alors ça peut être par défaut zéro, vous pouvez mettre *0* sinon vous pouvez mettre plusieurs choses.

Vous allez avoir et ça je vais vous les noter encore une fois parce que c'est bien de savoir pour les rendus alors il y a plusieurs choix:

    SDL_RENDERER_SOFTWARE
    SDL_RENDERER_ACCELERATED
    SDL_RENDERER_PRESENTVSYNC
    SDL_RENDERER_TARGETTEXTURE

Alors celui-là *SDL_RENDERER_TARGETTEXTURE* j'en parle pas ça concerne voilà le ciblage d'une texture en particulier d'accord de faire le rendu d'une texture mais on n'en parlera pas. *SDL_RENDERER_PRESENTVSYNC* ça c'est pour la synchronisation verticale d'accord pour pouvoir actualiser directement avec votre écran. *SDL_RENDERER_ACCELERATED* ça c'est pour profiter de l'accélération matérielle donc par exemple si vous voulez vous servir de votre carte graphique, ce sera plus puissant et plus simplement plus performant avec le système là et *SDL_RENDERER_SOFTWARE* c'est depuis le logiciel donc là ça va surtout travailler avec éventuellement votre processeur par exemple plutôt que la carte graphique d'accord donc si vous avez l'habitude un petit peu des jeux vidéo ou autre vous connaissez un petit peu ce système, tout ce qui est logiciel, accélération matérielle, 2d, 3d, etc donc je ne reviens pas dessus.

Alors donc par défaut on va laisser software d'accord on va rester comme ça voilà, on va utiliser un rendu logiciel pour ça donc c'est pas forcément le plus performant mais pour l'exemple ici ce sera suffisant.

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Voilà pour la création du rendu.

Evidemment cette fonction comme beaucoup d'autres, elle va vérifier si les choses sont bonnes ou pas.

Si ça n'a pas fonctionné d'accord la création du rendu, elle va retourner *NULL* d'accord donc c'est simple du coup à vérifier c'est comme pour la fenêtre c'est-à-dire si *renderer==NULL* voilà donc si c'est égale à *NULL* on fait ma fonction SDL_ExitWithError().

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Fonction SDL_ExitWithError() qui va permettre comme vous le voyez d'afficher un message, de bien quitter la SDL ça c'est super important et ensuite de quitter le programme seulement et là on met *Creation rendu echouee* ici et après ça c'est que le rendu s'est bien passé donc on va pouvoir travailler avec.

### SDL_DestroyRenderer

Alors comme on a créé un rendu même chose, on va penser à détruire le rendu une fois qu'on en a plus besoin donc vous détruisez le rendu avant la destruction de la fenêtre, la fonction pour faire ça c'est pareil, c'est très simple, SDL_DestroyRenderer() ok.

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
```

Là on passe évidemment *renderer* en paramètre.

Voilà donc dans l'ordre, voyez on initialise la sdl, on créé la fenêtre, on créé le rendu, on détruit le rendu, on détruit la fenêtre et on ferme la sdl.

Voilà on fait dans l'ordre inverse de ce qui a été créé ou initialisé.

### SDL_RenderPresent

Ok pour ça donc là si je teste mon programme, je n'aurais rien puisqu'on a simplement créer le rendu mais on ne l'a pas en fait afficher d'accord on n'a pas rafraîchi en fait notre fenêtre pour afficher ce rendu donc il va falloir utiliser une fonction pour ça qui est très simple donc on va faire un SDL_RenderPresent().

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_RenderPresent(renderer);

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
```

SDL_RenderPresent() et là vous passer bien sûr le rendu que vous avez créés ok donc ça pareil vous vérifiez comment que ça fonctionne, il n'y a pas de problème on va tester notre programme ici et voilà ce qu'on obtient.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre
    window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);

    if(window == NULL)
        SDL_ExitWithError("Création fenetre echouee");
    
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_RenderPresent(renderer);

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
./bin/prog.exe
```

Voilà ce qu'on obtient pendant trois secondes donc là la seule différence c'est qu'au lieu d'avoir une fenêtre vide, on a une fenêtre avec un écran noir mais vous venez d'afficher un rendu d'accord mine de rien c'est enorme puisque là en fait on n'a pas juste une fenêtre, on a vraiment chargé un rendu à l'intérieur de la fenêtre.

C'est un petit peu comme un tableau, imaginé un tableau noir sur lequel vous allez  pouvoir du coup dessiner, charger d'autres choses, afficher tout un tas de textures d'image ou carrément directement dessiner donc sur des pixels ou autres et ça on va le voir de toute façon par la suite donc c'est vraiment important à ce niveau là.

### SDL_RenderClear

Voilà pour le chargement donc ça c'est bon à ce niveau-là, je peux vous donner une petite fonction qui à connaître qui est SDL_RenderClear() et vous passé le rendu pour éffacer.

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_RenderPresent(renderer);

    SDL_RenderClear(renderer);

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
```

Voilà SDL_RenderClear() va éffacer tous les rendu qui ont été mis sur votre fenêtre en faisant comme ça.

Alors ça c'est pareil c'est une fonction qui renvoie 0 d'accord si elle a réussi parce que ça peut très bien échouer et si cela échoue ça envoie une valeur négative donc quand vous la tester c'est bien de vérifier d'accord qu'elle renvoie bien 0 et si elle ne renvoie pas zéro par exemple vous affichez un petit message d'erreur si vous voulez faire les choses proprement et on met *Effacement rendu echoue*.

```c
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_RenderPresent(renderer);

    if(SDL_RenderClear(renderer) != 0)
        SDL_ExitWithError("Effacement rendu echoue");

    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
```

Pour être sûr que ça a fonctionné donc là si je fais tout à la suite voilà qu'on obtiendra rien puisqu'on avait rien affiché au niveau de notre rendu.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre
    window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);

    if(window == NULL)
        SDL_ExitWithError("Création fenetre echouee");
    
    /*--------------------------------------------------------------------*/
    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    
    if(renderer == NULL)
        SDL_ExitWithError("Creation rendu echouee");

    SDL_RenderPresent(renderer);

    if(SDL_RenderClear(renderer) != 0)
        SDL_ExitWithError("Effacement rendu echoue");

    SDL_Delay(6000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
./bin/prog.exe
```

Voilà ce qu'on obtiend, vous y verrez rien puisqu'on n'avait rien affiché au niveau de notre rendu donc vous n'allez pas voir grande différence mais SDL_RenderClear() permet vraiment de nettoyer en fait l'écran si éventuellement par exemple je vais afficher autre chose.

Par contre SDL_RenderPresent() c'est vraiment pour mettre à jour, des fois vous allez genre afficher un rendu et par la suite vous allez vouloir changer SDL_RenderClear() donc vous allez faire un effacement et vous allez réutiliser SDL_RenderPresent() pour mettre à jour en fait rafraîchir le rendu donc ce qui est affiché directement dans votre fenêtre.

Voilà ça c'est les petites choses à savoir.

Alors nous on va l'enlever ici parce qu'on en n'aura pas forcément besoin, SDL_RenderClear().

Je ne vais pas trop compliqué le programme c'est déjà suffisamment de choses à voir comme ça sur cette partie-là donc ça c'est bon.

Maintenant on va commencer tout simplement à voir quelques fonctions pour pouvoir dessiner dans notre fenêtre parce que comme on n'a pas fait grand chose, évidemment ça peut être cool quand même de faire quelque chose à ce niveau là donc on va voir un peu tout ça mais avant je vais vous donner une petite solution raccourci et ça ça va servir pour ceux qui veulent avoir moins de lignes de code parce que vous voyez qu'on a beaucoup de choses.

## SDL_CreateWindowAndRenderer

Vous pouvez voir qu'on a créé la fenêtre et qu'on a créé le rendu, SDL_CreateWindow() & SDL_CreateRenderer() ainsi ces deux choses-là peuvent être assemblés ensemble.

Il y a une fonction qui permet de créer la fenêtre et le rendu par la même occasion d'accord.

C'est une fonction qui va renvoyer 0 si ça fonctionne et ça va retourner une valeur négative si ça a échoué donc le mieux quand vous voulez faire les deux, on va le faire ici.

```c
//Création fenêtre + rendu

```

On effacera après ce qu'il faut.

On va travailler directement sur les deux dans un if().

C'est SDL_CreateWindowAndRenderer() puisque c'est la fenêtre avant, et donc ici voyez qu'on ne lui passe pas la variable *window* ou autre, il faut notre fenêtre, notre pointeur pour le rendu et par contre on lui passera plein de paramètre et directement on verra si c'est différent de 0. Si c'est différent de 0, on écrira un message *Impossible de creer la fenetre et le rendu*.

```c
//Création fenêtre + rendu
if(SDL_CreateWindowAndRenderer() != 0)
    SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
```

Du coup on raccourci le nombre de ligne à écrire.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer() != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```

On fait tout ça et là bien évidemment il y a plusieurs paramètres à lui passer.

On va avoir ce qu'on a besoin à la base pour la création de la fenêtre c'est à dire la largeur, la hauteur ok donc nous on mettais 800 x 600 dans les exemples, ensuite vous passez les différents drapeaux pour la création de la fenêtre par exemple ce que vous mettez en fullscreen ou autre d'accord.

```c
//Création fenêtre + rendu
if(SDL_CreateWindowAndRenderer(800, 600, 0, ...) != 0)
    SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
```

Ensuite vous pouvez passer des paramètres éventuellement ici donc vous voyez moi je peux laisser à zéro si je veux ne rien mettre de particuliers et les 2 derniers paramètres on va lui passer simplement la fenêtre et le rendu sauf que là c'est un pointeur sur un pointeur donc pour les passer c'est par adresse donc vous mettaez une esperluette/ un & commerciale la fenêtre et le rendu en dernier paramètre.

```c
//Création fenêtre + rendu
if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
    SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
```

SDL_CreateWindowAndRenderer() va retourner un code d'erreur en fait ou un code de succès si ça marche et donc 0 si c'est bon ou autre chose si ça n'a pas fonctionné.

Et là logiquement si je compile et que je relance le programme on aura exactement la même chose.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
./bin/prog.exe
```

Voilà d'accord c'est exactement comme tout à l'heure d'accord sauf que là bas on a rassemblé en fait la création de la fenêtre et le rendu en même temps donc ça c'était le petit fonction bonus que je vous donne dans cette vidéo qui est bien savoir.

Vous pouvez très bien vous en passez, vous n'êtes pas obligé de l'utiliser mais si vous voulez voilà économiser le nombre de lignes dans votre programme, vous pouvez vous en servir c'est toujours utile également.

Voilà pour ça donc là on va rester là-dessus et je vais laisser comme ça.

## SDL_SetRenderDrawColor

Je vais laissé comme ça, on ne va pas remettre comme c'était avant et maintenant on va voir comment dessiner sur notre fenêtre, directement sur notre scène de rendu en fait comment on va pouvoir dessiner.

La première chose qui peut être sympa à faire c'est de modifier la couleur de dessin d'accord imaginez en fait comme un pinceau ou un crayon avec lequel vous allez pouvoir dessiner dans votre fenêtre donc on va pouvoir changer la couleur avec laquelle on va faire nos tracés, faire nos ou dessins.

Alors avant de faire le SDL_RenderPresent() d'ailleurs, on va changer notre petite couleur pour ça il y a une méthode qui s'appelle SetRenderDrawColor() qui va permettre de modifier justement la couleur que l'on veut.

Même chose que pour les initialisations ici c'est une fonction qui va renvoyer 0 si elle fonctionne ou qui renverra une valeur négative si ça ne fonctionne pas.

Vous avez vu qu'à partir de maintenant je vous parle beaucoup des retours de fonction puis quand on commence à faire des programmes assez lourd comme de la 2d ou autre c'est important de toujours toujours vérifier les retours des fonctions pour être sûr que ça fonctionne.

Si jamais il y a des codes d'erreurs qui sont renvoyés il faut évidemment gérer les erreurs en fonction ou voir quitter le programme si c'est nécessaire donc on y va on fait pareil.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor() != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Cette fonction prend plusieurs paramètres très simple, le premier le rendu donc on le  met directement *Renderer* et ensuite elle prend une valeur rgb donc la valeur rgb c'est tout simplement ce qui va être en fait les trois couleurs donc le taux de rouge, le taux de vert et le taux de bleu, rgb red green blue.

Si jamais vous savez pas comment les trouvez vous pouvez aller sur n'importe quel logiciel de dessin donc Paint ça fonctionne bien sur windows, vous en avez d'autres sur linux peu importe, Photoshop, Gimp, ce que vous voulez et vous cherchez la palette et sur la palette ici en section n'importe quelle couleur d'accord là vous allez pouvoir vous placez sur la couleur que vous voulez et là voyez vous avez les taux de rouge, de vert et bleu donc par exemple 112 de rouge, 168 de vert et 237 de bleus donc ça vous pouvez noter du coup donc on y va, et le dernier c'est le canal alpha donc ce qui va permettre en fait de gérer la transparence mais nous on veut évidemment changer la couleur donc on veut que ce soit affichée donc il y a une petite constante qui est SDL_ALPHA_OPAQUE.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

SDL_ALPHA_OPAQUE vaut donc 255 et 255 c'est que la couleur est complètement pleine et 0 c'est qu'elle est invisible d'accord vous pouvez comme ça gérer la transparence mais nous on veut voir le changement donc voilà comment on va changer la couleur donc pareil si je refais une compilation vous n'allez évidemment rien voir parce que je n'ai rien déssiné encore.

`SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE)` permet juste de changer la couleur de tracé qui va me servir pour le dessin en fait sur le rendu et là on va passer aux choses sérieuses maintenant.

## SDL_RenderDraw

> SDL_gfx() SDL_RenderDrawPoint() SDL_RenderDrawLine() SDL_RenderDrawRect()

On va commencer à dessiner.

Alors de base, vous pouvez dessiner des points évidemment donc un pixel près.

Vous pouvez dessiner des lignes d'accord donc ça c'est facile il suffit de prendre les coordonnées d'un point A et les coordonnées d'un point B et ça va tracer une ligne.

Et vous pouvez dessiner des rectangles, si plus tard vous voulez dessiner des cercles, des formes quelconque d'accord plusieurs autres primitive, vous avez SDL_gfx() notamment que vous pouvez voir au niveau des tutoriels d'accord de la playlist du langage c.

Il y a ou il y aura justement pour voir comment manipuler d'autres formes d'accords mais nous on va se contenter des formes basiques puisque la plupart du temps elles sont suffisantes, elle nous servent suffisamment.

On va commencer avec les trois fonctions que je vous ait parlez donc il va y avoir une fonction pour dessiner des points, une fonction pour dessiner une ligne et une fonction pour dessiner un rectangle d'accord et ces fonctions-là donc c'est tout simple elle renvoie 0 si elles ont fonctionnées et elles renvoient quelque chose de négatif si ça n'a pas fonctionné donc pareil il faudra à chaque fois refaire le test tout le temps, tout le temps, tout le temps d'accord c'est super important.

### SDL_RenderDrawPoint

On y va donc là on va commencer par dessiner un point, c'est SDL_RenderDrawPoint().

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(...) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Voyez que l'on fait beaucoup de vérifications c'est pour ça que c'est bien d'avoir une fonction parce que si vous deviez répéter à chaque fois les trois lignes de la fonction SDL_ExitWithError() même si c'est que trois lignes, ben ça fait de la répétition de code, c'est pas forcément bien et on affiche *Impossible de dessiner un point*.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(...) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Voilà et maintenant elle prend comme paramètre le rendu *renderer* et elle va prendre la coordonnées x et y du point que vous allez dessiner d'accord donc nous c'est une fenêtre en 800 par 600 donc si je faisais le point en (0, 0) ce serait celui tout en haut à  gauche de la fenêtre et voilà vous pouvez gérer à ce niveau-là.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

Et là pour le coup on va commencer à voir quelque chose enfin.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```

Voilà alors vous n'allez pas le voir beaucoup parce qu'évidemment c'est qu'un petit point donc je vais vous montrer rapidement avec la souris mais il est ici le point.

```
    +---------------+
    |               |
    |               |
    |               |
    |    .          |
    |               |
    +---------------+

```

En tout cas c'est comme ça que ça se passe d'accord au niveau du rendu de point.

### SDL_RenderDrawLine

Maintenant si on veut faire une ligne et on va laisser le point tant qu'à faire sauf que là ce n'est pas SDL_RenderDrawPoint() mais c'est SDL_RenderDrawLine().

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

SDL_RenderDrawLine() prend x, y pour le point A et ensuite x et y pour le point B. On mettre un point d'origine 50, 50 et ensuite on va aller jusque 500, 500 et là vous allez voir ce que ça va faire une ligne sur le programme donc là vous n'allez pas pouvoir le louper et là ça va être visible à l'écran sur la vidéo voilà.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```
```
    +---------------+
    |               |
    |      \        |
    |       \       |
    |    .   \      |
    |         \     |
    +---------------+
```

Voilà on a un grand tracé en bleu donc ça a bien pris la couleur que j'ai choisi d'accord.

Voilà 2 posibilités.

## SDL_RenderDrawRect

Vous pouvez terminer avec un rectangle donc le rectangle c'est pareil sauf que c'est RenderDrawRect() et ça attention ça prend une structure un peu particulière qui est une structure de rectangles d'accord donc le rendu et un rectangle que nous allons créer avant d'accord donc avec le message *Impossible de dessiner un rectangle*, voyez il y a beaucoup beaucoup de vérifications d'erreur à faire et ce rectangle on va le créer en début de programme.

```c
    if(SDL_RenderDrawRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");
```

On peut le créer au début ou au moment où on va vouloir utiliser ici.

On fait un `SDL_Rect rectangle;` d'accord voilà et là c'est une structure qui prend plusieurs valeurs càd x, y, w et h donc voilà comment ça fonctionne.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");
    
    SDL_Rect rectangle;
    rectangle.x = 300;
    rectangle.y = 300;
    rectangle.w = 200;
    rectangle.h = 100;

    if(SDL_RenderDrawRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

C'est simplement rectangle point x, y, w et h donc ça c'est les structures donc les structures vous l'avez vu en langage c bien avant donc si c'est pas clair pour vous revoyez la vidéo sur les structures et les énumérations du cours.

Voilà donc on y va, logiquement j'ai rien oublié.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");
    
    SDL_Rect rectangle;
    rectangle.x = 300;
    rectangle.y = 300;
    rectangle.w = 200;
    rectangle.h = 100;

    if(SDL_RenderDrawRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```
```
    +---------------+
    |               |
    |      \        |
    |       \       |
    |    .   +---+  |
    |        |\  |  |
    |        +-\-+  |
    +---------------+
```

:warning: Attention comme SDL_RenderDrawRect() attend un pointeur de pointeur, *rectangle* doit être passé par adresse et donc ne pas oublié le petit & commerciale.

Voyez ça fonctionne vraiment avec la couleur qu'on a choisi.

Et si vous voulez le faire de trois couleurs différentes, hé bien le SDL_SetRenderDrawColor() vous pouvez le faire à chaque fois contre d'accord par exemple faire ça avant d'appeler le rectangle et je change la couleur en rouge (255, 15, 15).

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");
    
    SDL_Rect rectangle;
    rectangle.x = 300;
    rectangle.y = 300;
    rectangle.w = 200;
    rectangle.h = 100;

    if(SDL_SetRenderDrawColor(renderer, 255, 15, 15, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```
```
    +---------------+
    |               |
    |      \        |
    |       \       |
    |    .   +---+  |
    |        |\  |  |
    |        +-\-+  |
    +---------------+
```

Voilà vous pouvez vraiment vraiment manipuler tout, ça fonctionne bien évidemment sans problème au niveau des couleurs.

Voilà donc là vous voyez comment dessiner sur votre rendu donc c'est vraiment un tableau noir, imaginez un tableau sur lequel vous pouvez dessiner comme ça des points, des lignes, des rectangles et éventuellement avec d'autres types de données, vous pourrez même voilà faire des cercles, faire des ellipses voir d'autres formats assez sympathique au niveau des rendu donc moi c'est ce que je voulais vous montrer ici puisque c'était quand même à connaître.

Alors au niveau des rectangles, il y a une petite spécificité parce que vous voyez que par défaut le rectangle est vide, c'est juste son entourage qui est présent.

### SDL_RenderFillRect

Vous pouvez remplir ce rectangle, il n'y a pas de souci du tout c'est à dire que si vous voulez remplir ce rectangle pouvez utiliser SDL_RenderFillRect() qui va permettre de le dessiner car vous n'êtes pas obligé de faire SDL_RenderDrawRect() qui va vous permettre juste de tracer le contour.

```c
//Remplacer le Draw par un Fill

SDL_RenderDrawRect(renderer, &rectangle);
//...
SDL_RenderFillRect(renderer, &rectangle);
```

Vous remplacer tout simplement ici le Draw par un Fill d'accord vous changez juste un seul mot et là voilà.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m025.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(800, 600, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");
    
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");
    
    SDL_Rect rectangle;
    rectangle.x = 300;
    rectangle.y = 300;
    rectangle.w = 200;
    rectangle.h = 100;

    if(SDL_SetRenderDrawColor(renderer, 255, 15, 15, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderFillRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/

    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return EXIT_SUCCESS;
}

void SDL_ExitWithError(const char *message)
{
    SDL_Log("ERREUR : %s > %s\n", message, SDL_GetError());
    SDL_Quit();
    exit(EXIT_FAILURE);
}
```
```powershell
gcc src/m025.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```
```
    +---------------+
    |               |
    |      \        |
    |       \       |
    |    .   +---+  |
    |        |###|  |
    |        +---+  |
    +---------------+
```

Voilà SDL_RenderFillRect() fonctionne pareil au niveau des paramètres mais ça va remplir ici le rectangle d'accord c'est important à savoir.

Pareil là vous avez vu dans l'ordre où j'ai fait.

Regardez si je crée la ligne en dernier.

```c
    /*--------------------------------------------------------------------*/
    if(SDL_SetRenderDrawColor(renderer, 112, 168, 237, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    if(SDL_RenderDrawPoint(renderer, 100, 450) != 0)
        SDL_ExitWithError("Impossible de dessiner un point");

    // if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
    //     SDL_ExitWithError("Impossible de dessiner une ligne");
    
    SDL_Rect rectangle;
    rectangle.x = 300;
    rectangle.y = 300;
    rectangle.w = 200;
    rectangle.h = 100;

    if(SDL_RenderFillRect(renderer, &rectangle) != 0)
        SDL_ExitWithError("Impossible de dessiner un rectangle");

    if(SDL_SetRenderDrawColor(renderer, 255, 15, 15, SDL_ALPHA_OPAQUE) != 0)
        SDL_ExitWithError("Impossible de changer la couleur pour le rendu");

    //On applique la couleur seulement sur la ligne
    if(SDL_RenderDrawLine(renderer, 50, 50, 500, 500) != 0)
        SDL_ExitWithError("Impossible de dessiner une ligne");

    SDL_RenderPresent(renderer);
    SDL_Delay(3000);
    /*--------------------------------------------------------------------*/
```

On crée la ligne à la fin, elle prend la couleur rouge, l'ordre est important, elle est au dessus du rectangle.

```
    +---------------+
    |               |
    |      \        |
    |       \       |
    |    .   +---+  |
    |        |\  |  |
    |        +-\-+  |
    +---------------+
```

Voyez comme la ligne est créé après le rectangle évidemment elle passe dessus d'accord donc il y a  bien sûr superposition au niveau de ce que vous dessinez donc ça c'est à savoir d'accord l'ordre dans lequel vous définissez des choses.

L'ordre est important.

Alors ça fait déjà une grosse vidéo au niveau des rendus.

On a vu la structure des rectangles, on a vu comment dessiner des points, des lignes, des rectangles et c'est déjà pas mal pas mal.

Je pense que vous avez vu suffisamment déjà au niveau des rendus.

Encore une fois n'hésitez pas à regarder dans la playlist des tutoriels, il y a des choses qui sont ajoutés régulièrement donc il y aura évidemment des vidéos en annexes concernant la sdl avec des petites choses en plus donc n'hésitez pas à aller voir là dessus et dans la description de la vidéo en petit rappel, vous avez une archive en fait donc d'un projet vide qui en fait crée juste une fenêtre sur lequel vous pouvez travailler pour être sûr d'avoir par exemple d'avoir le même code que moi si par exemple vous avez des petits soucis à faire marcher ça.

Alors j'espère que ça vous a plus parce que ça vous a apprit encore pas mal de choses.

Je pense que ça a été suffisamment assez clair puis si jamais il y a des petits problèmes n'hésitez pas à me le dire en commentaire, s'il y a des questions n'hésitez pas à me demander s'il y a des choses que vous ne comprenez pas logiquement je pense que c'est assez simple à comprendre là c'est beaucoup connaître des fonctions, ne pas se tromper dans les paramètres, de bien passer les & commercials ou autres.

Après honettement la sdl c'est très simple comme c'est de la représentation graphique, on arrive très vite à voir les erreurs qu'on fait ou non donc c'est facile à se corriger je trouve contrairement à quelque chose par exemple qui serait plutôt en interne donc là quand ces graphiques c'est mieux, c'est plus facile de se corriger.

On se retrouvera du coup la prochaine fois pour d'autres vidéos sur la sdl, on est encore au début donc il y a plein de choses encore à voir, plein de choses très intéressantes d'ailleurs parce que là on est vraiment sur le début.

J'espère que ça vous a plu je vous dis à bientôt pour la prochaine séance en langage c avec la bibliothèque sdl.

A bientôt tout le monde