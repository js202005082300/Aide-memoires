# [28. Gestion événements (2/2)](https://www.youtube.com/watch?v=oY-xietZTig)

Bonjour à tous nous sommes partis sur la 28e séance en langage c.

C'est la deuxième partie concernant la gestion des événements en sdl.

Je fais comme je l'avais dit précédemment càd ne pas vous montrer tout ce qu'il reste encore à voir au niveau des événements puisqu'il y a énormément énormément de choses et une grosse partie également qui vous servira peut-être jamais.

Moi je me contente en tout cas de vous montrer l'essentiel et ce qui est vraiment intéressant, qui vous servira et bien évidemment comme je le dis souvent si après vous avez besoin de cas très spécifique au niveau de la gestion des événements n'hésitez pas encore une fois à consulter la documentation officielle.

En l'occurrence le wiki de la sdl où vous aurez tout le détail des différentes structures, des différentes fonctions selon ce que vous voulez faire.

Dans la vidéo précédente on s'étaient concentrés parce que c'était les débuts de la gestion des événements et je vous avais montré comment ça se passait au niveau de la récupération en fait de tous les événements au niveau notre interface pour pouvoir les traiter donc on avait plus ou moins garder ces types de structure.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 1280
#define WINDOW_HEIGHT 720

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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

Rappelez vous on s'était servi d'un booléen `SDL_bool program_launched = SDL_TRUE;` d'accord on avait fait une boucle infinie `while(program_launched)` qui ne s'arrête jamais à ce niveau là et on avait géré les événements `while(SDL_PollEvent(&event))`.

On a un premier évenement qui est le cas unique en tout cas qu'on a mis le départ qui est le cas où lorsqu'on quitte le programme c'est-à-dire qu'on quitte la fenêtre principale du programme via la petite croix justement de l'interface soit terminé donc ça passe notre booléen à false `program_launched = SDL_FALSE;` et ça terminait l'exécution du programme d'accord donc ça c'est le code je rappelle minimal si vous voulez gérer vos évènements.

```c
    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/
```

Vous le mettez une seule fois dans votre programme, pas besoin d'en avoir deux trois quatre cinq ou je ne sais pas combien.

Il faut juste l'avoir voir une seule fois au niveau de votre programme et vous gérez tous vos événements à l'intérieur c'est comme ça que ça fonctionne et pas autrement.

Alors donc on s'était concentré uniquement sur tout ce qui concernait la partie sur le clavier d'accord on avait vu les différents événements par rapport aux touches enfoncées ou  aux touches relâchées du clavier avec différents types d'événements spécifiques et on avait vu comment afficher par exemple certaines informations par rapport à ça.

Dans cette deuxième partie, on va se concentrer un peu plus sur cette fois la souris parce que c'est évidemment un autre périphérique qui est très utilisé au niveau des interfaces graphiques.

On parlera un petit peu de gestion de fenêtres, d'événements liés aux fenêtres mais bon on ira très vite là dessus et en bonus ça c'est un petit ajout de ma part parce que c'est la dernière vidéo évidemment sur les événements et ce sera probablement la dernière vidéo également sur la sdl dans le cours puisqu'il y aura bien sûr des vidéos en annexe en complément dans la playlist auriel.

Mais en ce qui concerne le cours vous êtes sur la dernière vidéo de la sdl pour cette formation donc là on en fin de vidéo je vous parlerais très simplement de la gestion du *framerate* donc tout simplement le nombre d'image par seconde qui est affichées.

En effet, vous verrez plus tard quand vous allez gérer par exemple tout un ensemble d'affichage d'image, il faudra pouvoir limiter ça pour ne pas se retrouver avec un taux de rafraîchissement qui est complètement hallucinant donc on pourra par exemple limité à 30 fps, à 60fps, etc.

Ceux qui font du jeu vidéo ou qui font pas mal de montage vidéo, ce genre de chose c'est des notions que vous connaissez déjà, voilà vous savez ce qu'est un framerate, ce qui est une gestion de fps donc vous apprendrez à faire ça très simplement parce que c'est très facile à faire en sdl.

On y va au niveau des événements, on va commencer donc avec la gestion de la souris.

Pour la souris, il existe donc beaucoup de choses, on peut  gérer le déplacement de la souris d'accord donc ça on va le voir dans la vidéo.

On peut gérer les clics de la souris d'accord clic droit, clic gauche, etc et on peut gérer bien évidemment  l'utilisation de la molette d'accord pour ceux en tout cas qui ont une molette parce qu'il n'y en pas forcément sur toutes les souris mais par exemple le fait de déplacer la mallette vers le haut, vers le bas.

## Partie 1

Ainsi donc nous on va simplement voir déjà le déplacement de la souris et ensuite on verra ce qui concerne les clicks d'accord pour ce qui concerne la molette comme c'est quand même un cas un peu plus particulier, libre à vous d'aller voir après au niveau de la documentation si vous avez compris en tout cas les déplacements et les clics de la souris, vous n'aurez aucun mal à mettre en pratique ou utiliser en tout cas la gestion ou de la molette donc il n'y aura pas de souci à ce niveau-là.

### SDL_MOUSEMOTION

On va directement au niveau de notre type d'événement donc c'est toujours la même chose ici on va ajouter un autre cas d'accord pour gérer ça comme on avait fait par exemple le cas pour gérer le clavier, on va avoir un cas pour gérer les déplacements de la souris.

Pour gérer les déplacements de la souris, on a SDL_MOUSEMOTION tout en majuscules je rappelle que les majuscules/minuscules dans les noms que je mets ici ne sont pas au hasard, ils sont évidemment à respecter, `case SDL_MOUSEMOTION:`

```c
    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEMOTION:
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/
```

A partir de là on va gérer un événement donc on est sûr d'avoir capturé en fait un événement de type SDL_MOUSEMOTION donc un événement qui concerne le déplacement de la souris et à partir de là on peut gérer pas mal de choses grâce à une structure particulière pour laquelle je vous renvoie éventuellement sur le wiki si vous voulez voir le détail.

Pour ne pas perdre de temps moi je ne vais pas revenir sur le wiki pour montrer tout ça et ça ne servira à rien donc vous pourrez aller voir par vous même.

#### event motion x-y-xrel-yrel

Alors c'est une structure qui va permettre tout simplement de récupérer beaucoup d'informations donc elle va être stockée dans event point motion `event.motion` et à partir de ce motion-là, on va pouvoir gérer plusieurs informations.

Nous ce qui nous intéresse au niveau du déplacement de la souris ça va être par exemple les coordonnées de la souris où est-ce qu'elle se trouve au niveau notre fenêtre donc on va avoir tout simplement *event* qui vient de `SDL_Event event;` et point motion c'est le type ok c'est-à-dire l'événement qu'on a récupéré point quelque chose, etc, `event.motion.x`.

```c
    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEMOTION:
                    //event.motion.x
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/
```

Donc un point quelque chose et on a point x qui fait tout simplement la coordonnée en x d'accord de notre souris.

On a la même chose pour `event.motion.y` et on peut avoir également des coordonnées relatives donc c'est *xrel* `event.motion.xrel` et on peut avoir également *yrel* `event.motion.yrel` pour la position relative.

Alors que veut dire la position relative ? hé bien si par exemple je me x, y normal ça va donner les coordonnées exactes de où se trouve le curseur, en revanche xrel, yrel vont donné la position relative c'est-à-dire si j'ai ici réduit par exemple en remontant ma souri au niveau du curseur, je réduit la coordonnée y et bien il va mettre une valeur négative.

```
    +-----------+
    |           |
    |     ^     | yrel = -4 (p.e.)
    |     |     |
    |           |
    +-----------+

```

Il va mettre une valeur négative, il dira par exemple voilà -4 en y relatif puisque j'aurai tout simplement diminué la coordonnée y de 4 admettons donc c'est pour ça qu'il faut bien distinguer les deux.

Nous bon pour la vidéo, je vais vous montrer les coordonnées standard mais ça s'utilisera pareil pour xrel et yrel.

Ainsi à partir de là, on va se contenter d'afficher en fait les coordonnées à chaque fois donc je vais faire printf() donc je vais afficher comme ceci donc dans le terminal parce que ça ne sert à rien d'alourdir les choses inutillement.

Directement ici on va afficher donc le `event.motion.x` et ensuite `event.motion.y`.

```c
    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEMOTION:
                    printf("%d / %d\n", event.motion.x, event.motion.y);
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/
```

Ainsi `printf("%d / %d\n", event.motion.x, event.motion.y);` on affiche la coordonnées x et y à chaque fois qu'ici la sdl va détecter un mouvement de la souris d'accord donc on y va.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEMOTION:
                    printf("%d / %d\n", event.motion.x, event.motion.y);
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
897 / 185
951 / 149
1005 / 114
1058 / 81
#etc.
```

Je récupére ma petite commande comme je fais habituellement voilà ok donc là vous voyez dans le terminal d'acoord à chaque fois que je fait un petit déplacement ne serait ce que d'un pixel ça met à jour ici l'affichage des coordonnées dans ma fenêtre.

Alors ma fenêtre là fait 640 par 480 donc c'est à dire que  si je me mets tout en haut à gauche logiquement il doit trouver le point 0, 0.

```
    (0,0)
    +-----------+
    |           |
    |           |
    |           |
    |           |
    +-----------+
```

Et si je me mets là bas ça va être 640 par 480.

```
    +-----------+
    |           |
    |           |
    |           |
    |           |
    +-----------+
            (640,480)
```

Alors comme un pixel c'est tout petit, je vais avoir du mal à voir mais voilà d'accord c'est vraiment le point d'extrémité et forcément voyez en me déplaçant dans ma fenêtre comme ça il modifie l'affichage des coordonnées donc ça c'est très pratique dans le jeux vidéo, dans l'imagerie quand on veut faire par exemple du traitement d'image tout ça c'est bien des fois de récupérer les coordonnées de la souris, c'est super important.

Imaginez par exemple un jeu fps, un jeu de tir c'est des informations qui sont très très très utiles dans ce type de jeu-là et dans beaucoup d'autres choses également donc ça a vraiment son intérêt.

C'est pour ça que je voulais vous montrer en vidéo, on va fermer notre fenêtre donc voilà.

Alors donc je rappelle pour xrel et yrel, vous remplacez en fait juste comme ça.

```c
printf("%d / %d\n", event.motion.xrel, event.motion.yrel);
```

On y va.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEMOTION:
                    printf("%d / %d\n", event.motion.xrel, event.motion.yrel);
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
3 / -1
2 / -1
3 / -1
2 / 0
2 / 0
2 / 0
#etc.
```

On compile, exécute et là regardez.

Voilà voyez là ce qu'il affiche en fait c'est la position relative +1 -1 et cetera en fonction de comment je me déplace.

Evidemment si je déplace vite d'un coup il va prendre toujours le point de départ et point d'arrivée donc si je me déplace d'un pixel à un pixel il mettra toujours 1 ou 0 ou -1 éventuellement si je me déplace par exemple vers la gauche.

Egalement si je fait un gros déplacement d'un coup `28 / 39` voyez comment ça fonctionne.

Alors je rappelle que le point x, y d'indice 0, 0 est ici tout en haut à gauche donc forcément si je me déplace vers la droite j'augmente le x d'accord donc c'est plus. Si je vais vers le bas j'augmente le y et inversement si je vais vers la gauche je baisse x et si je vais vers le haut je baisse y d'où ici les valeurs négatives.

Par exemple `-3` ici signifie que je fait -3 pixels vers la gauche d'accord tout simplement.

Voilà comment ça fonctionne pour les valeurs relatives donc c'est très facile encore une fois, c'est rapide à voir donc on gère tout ça avec SDL_MOUSEMOTION tout simplement donc je vais passer très vite.

## SDL_MOUSEBUTTONDOWN

Maintenant on va se concentrer sur les clics de la souris.

Alors le clic de la souris c'est SDL_MOUSEBUTTONDOWN donc *down* c'est comme pour le clavier, comme SDL_KEYDOWN, c'est quand on va cliquer d'accord.

```c
switch(event.type)
{
    case SDL_MOUSEBUTTONDOWN:
    //etc.
}
```

Par contre quand je vais relâcher le bouton de la souris, c'est pas un SDL_MOUSEBUTTONDOWN mais c'est un SDL_MOUSEBUTTONUP.

D'accord vous avez les deux cas.

Alors nous on va juste se concentrer sur le cas où on appuie avec le bouton de la souris mais pas quand on relâche le bouton de la souris parce que voilà c'est exactement le même fonctionnement.

### event button x-y

Et à partir de là on va pouvoir récupérer différentes informations alors comme pour les coordonnées on peut demander où est ce qu on a cliqué donc savoir les coordonnées du clic qui ont été faites donc *Clic en %dx/%dy* pour les valeurs xy ici et on va pouvoir récupérer ça autrement avec un `event.button` au lieu d'un `event.motion`.

```c
switch(event.type)
{
    case SDL_MOUSEBUTTONDOWN:
        printf("Clic en %dx/%dy\n", event.button.x, event.button.y);
        break;
}
//etc.
```

Alors les noms sont simples au niveau des event, vous allez retrouver comme ça les noms des différentes parties de la structure via le nom SDL_MOUSEBUTTONDOWN donc c'est assez parlant, c'est assez intuitif en fait à l'utilisation et là évidemment c'est tout simplement x et y.

Voilà à partir de là on va recompiler pour exécuter.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEBUTTONDOWN:
                printf("Clic en %dx/%dy\n", event.button.x, event.button.y);
                break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
Clic en 308x/168y
Clic en 314x/334y
Clic en 566x/16y
Clic en 19x/12y
Clic en 633x/473y
#etc.
```

Je clic et voyez qu'il me met les coordonnées où est-ce que j'ai cliqué d'accord très pratique aussi donc je ne vous fais pas de dessin.

Je pense que pour ceux qui veulent faire un jeu vidéo, ceux qui veulent faire une application graphique, je pense que ça doit vous donner plein d'idées d'utilisation où ça peut effectivement ici se montrer utile de savoir où est-ce qu'on a cliqué donc ça c'est plutôt très intéressant et très sympa comme fonctionnalité donc très simple.

### event button clicks

Petit ajout également donc ça si vous voulez voir l'entièreté de la structure n'hésitez pas à allez voir dans la doc comme d'habitude il y a également l'information sur le nombre de clics qui ont été faits et qui peut servir d'accord.

Alors donc ça comment ça fonctionne ? hé bien on peut le faire dans une condition ça peut être pas mal, par exemple si j'ai fait `event.button.clicks` et on va mettre *>=2* et dans ce cas, on va dire *Double-clic !*.

```c
switch(event.type)
{
    case SDL_MOUSEBUTTONDOWN:
        if(event.button.clicks >= 2)
            printf("Double-clic !\n");
        break;
}
//etc.
```

Un double-click c'est vraiment deux fois même si on va considérer dans notre cas ici que si la personne s'est acharnée sur sa souris c'est comme si en fait il voulait faire un double-clic parce que ça peut arriver.

On y va.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_MOUSEBUTTONDOWN:
                if(event.button.clicks >= 2)
                    printf("Double-clic !\n");
                break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
Double-clic !
Double-clic !
Double-clic !
Double-clic !
#etc.
```

Il ne se passe rien comme vous voyez pas contre si je fais 2 clics voilà et si j'en fais trois ça se répète, il m'indique le double clic donc ça c'est une petite information sympa dans `event.button.clicks` si vous voulez savoir le nombre de clics qui ont été faits au niveau de cet événement-là de la souris d'accord parce que ça concerne les clics de la souris donc plutôt sympa également à récupérer.

Ainsi voilà trois informations intéressantes càd les coordonnées x et y, et le nombre de clics qui ont été faits après s'il y a d'autres choses qui vous intéresse aller voir éventuellement mais ça c'est vraiment les choses principales et qui représentent la majorité de ces structures-là par rapport aux choses qui sont à voir.

### event button button

Alors au niveau du clic j'ai pas forcément montré également le clic c'est à dire par exemple que vous savez que sur votre souris, vous avez logiquement donc le clic gauche, le clic droit et pour certains peut-être vous avez un clic du milieu, c'est le clic sur la molette que je suis en train de faire-là.

```c
event.button.button
```

Alors ça vous pouvez également les récupérer tout simplement ici avec `event.button.button` ici et ça peut prendre différentes valeurs donc que je vais vous montrer-là.

#### SDL_BUTTON_LEFT-MIDDLE-RIGHT

```c
/*
    SDL_BUTTON_LEFT
    SDL_BUTTON_MIDDLE
    SDL_BUTTON_RIGHT
*/
```

On a un clic gauche, clic du milieu si éventuellement vous l'avez parce que sinon évidemment ça ne marchera pas et le clic droit tout simplement donc il suffit de faire par exemple de dire que j'ai fait un *Clic gauche !* et puis la même chose avec *Clic droit !*.

```c
/*
    SDL_BUTTON_LEFT
    SDL_BUTTON_MIDDLE
    SDL_BUTTON_RIGHT
*/
switch(event.type)
{
    case SDL_MOUSEBUTTONDOWN:
        if(event.button.button == SDL_BUTTON_LEFT)
            printf("Clic gauche !\n");
        if(event.button.button == SDL_BUTTON_RIGHT)
            printf("Clic droit !\n");
        break;
}
//etc.
```

On y va et c'est des choses très simples je pense que c'est suffisamment parlants.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                /*
                    SDL_BUTTON_LEFT
                    SDL_BUTTON_MIDDLE
                    SDL_BUTTON_RIGHT
                */
                case SDL_MOUSEBUTTONDOWN:
                    if(event.button.button == SDL_BUTTON_LEFT)
                        printf("Clic gauche !\n");
                    if(event.button.button == SDL_BUTTON_RIGHT)
                        printf("Clic droit !\n");
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
Clic gauche !
Clic droit !
```

Et en fonction du clic que je fais, regardez dans le terminal voilà je fais un clic gauche puis un clic droit, et cetera.

Voilà c'est plutôt très facile d'utilisation et encore une fois très pratique.

Voilà au niveau de la souris, je m'arrêterais à ce niveau là je pense qu'il y a beaucoup beaucoup déjà à faire avec ça et suffisamment en tout cas pour les 98% des types de projets que vous pourriez avoir avec la sdl.

#### SDL_BUTTON_WHEEL

Après encore une fois vous avez toute la gestion de la molette pour ceux qui ont une molette càd le fait le fait de pouvoir déplacer comme ça vers le haut ou vers le bas sans cliquer attention parce que le clic sur la molette ça concerne le clic comme je viens de vous montrer, c'est juste le déplacement avec la molette donc pour ça vous avez [SDL_BUTTON_WHEEL](https://wiki.libsdl.org/SDL_MouseWheelEvent) et ensuite regardez après dans le wiki comment ça fonctionne et qu'est-ce qui est disponible comme type d'évenement d'accord on peut récupérer pas mal d'informations.

Voilà à ce niveau là.

## Partie 2

On va passer sur la deuxième parti comme je le dis en début de vidéo sur ce qui concerne la gestion d'événements concernant les modifications de la fenêtre donc on ne verra pas grand chose, ça va aller assez vite mais c'est pas mal à savoir aussi.

### SDL_WINDOWEVENT

Ainsi on rentre sur un autre cas, qui est cette fois-ci le SDL_WINDOWEVENT tout simplement.

```c
switch(event.type)
{
    case SDL_WINDOWEVENT:
        break;
}
```

Alors c'est pareil si vous voulez vous intéressez au niveau de tout ce qui est gestion par le système on a SDL_SysWMEvent parce que window manager qui concerne les fenêtres type système d'accord liés au système.

SDL_SysWMEvent c'est ce concerne les événements liés au système donc nous on ne va pas en parler dans la vidéo c'est pareil si vous avez compris pour la gestion des fenêtres tout ce qui est lié au système ne sera pas un problème du tout.

#### event window event

Alors qu'est ce qui peut nous intéresser ici à partir de là et bien nous ça va être le `event.window.event`, je vous avais dit que c'était assez parlant, assez intuitif au niveau des noms donc on retrouve `event.window.event` donc un évenement de fenêtre lié à notre gestionnaire d'évènement.

Et `event.window.event` va pouvoir prendre plusieurs valeurs donc la valeur par exemple simple qui peut être tout à fait standard lorsqu'on fait tester ce genre de chose avec plusieurs chose.

```c
switch(event.type)
{
    case SDL_WINDOWEVENT:
        //event.window.event
        if(event.window.event == SDL_WINDOWEVENT_SHOWN)

        break;
}
```

##### SDL_WINDOWEVENT

> SDL_WINDOWEVENT_SHOWN  
> SDL_WINDOWEVENT_MOVED  
> SDL_WINDOWEVENT_RESIZED  
> SDL_WINDOWEVENT_MINIMIZED  
> SDL_WINDOWEVENT_RESTORED  
> SDL_WINDOWEVENT_CLOSED  
> SDL_WINDOWEVENT_ENTER  
> SDL_WINDOWEVENT_LEAVE  

SDL_WINDOWEVENT_SHOWN quand vous afficher une fenêtre. 

Voilà une valeur mais sinon il faut aller voir l'outil si on veut toutes les valeurs mais bon je vous donne celles que j'ai comme ça en tête.

Vous avez SDL_WINDOWEVENT_MOVED donc si vous déplacez la fenêtre.

Vous avez SDL_WINDOWEVENT_RESIZED quand on redimentionne la fenêtre donc moi ici ma fenêtre ne peut pas être redimensionnés donc ça ne marchera pas si je tester sur le code mais on va en tester quelques uns.

Vous avez SDL_WINDOWEVENT_MINIMIZED quand on minimise la fenêtre.

Vous avez SDL_WINDOWEVENT_RESTORED donc c'est quand on la remet tout simplement.

On a SDL_WINDOWEVENT_CLOSED si vous fermez une fenêtre parce qu'évidemment sur un programme vous pouvez avoir plein de fenêtres d'accord quand vous quittez la fenêtre principale ça quitte le programme donc c'est le fameux SDL_QUIT par contre si c'est une sous-fenêtre de notre programme que vous fermez et bien ça peut être gérée à ce niveau là.

Et on a le fameux SDL_WINDOWEVENT_ENTER quand vous revenez sur votre fenêtre et SDL_WINDOWEVENT_LEAVE quand le curseur de la souris quitte la fenêtre* donc nous on va faire par exemple-ça et voir avec un printf() quand *La souris est sortie de la fenêtre et pourquoi pas faire la même chose sur la souris qui est revenue donc vous changer en SDL_WINDOWEVENT_ENTER.

```c
switch(event.type)
{
    case SDL_WINDOWEVENT:
        //event.window.event
        if(event.window.event == SDL_WINDOWEVENT_LEAVE)
            printf("La souris est sortie de la fenetre.\n");
        if(event.window.event == SDL_WINDOWEVENT_ENTER)
            printf("La souris est sur la fenetre.\n");
        break;
}
```

C'est vraiment très simple, alors la gestion des événements sdl est vraiment très facile une fois qu'on a compris ici comment mettre en place son gestionnaire comme je vous l'ai montré c'est-à-dire un système qui fonctionne à tous les coups et qui est optimisé.

Vous voyez qu'après il suffit de gérer les cas ici, c'est vraiment enfantin au niveau de la gestion donc il n'y a rien de compliqué.

Voilà on va actualiser.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {
                case SDL_WINDOWEVENT:
                    //event.window.event
                    if(event.window.event == SDL_WINDOWEVENT_LEAVE)
                        printf("La souris est sortie de la fenetre.\n");
                    if(event.window.event == SDL_WINDOWEVENT_ENTER)
                        printf("La souris est sur la fenetre.\n");
                    break;
                
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
La souris est sur la fenetre.
La souris est sortie de la fenetre.
La souris est sur la fenetre.
La souris est sortie de la fenetre.
La souris est sur la fenetre.
La souris est sortie de la fenetre.
```

On a donc recompiler et hop dès que je quitte la fenêtre hop il me dit qu'elle est sortie de la fenêtre, ensuite dés que je revient ça me dit qu'il revient sur la fenêtre, etc.

Voilà donc très simple encore une fois la gestion est très simple.

On rappelle que le petit bandeau ne fait pas partie de
la fenêtre.

```
    +-------------------+
    |             - # x |
    +-------------------+
    |                   |
    |                   |
    |                   |
    |                   |
    |                   |
    +-------------------+
```

Donc si je vais ici sur la partie là de la fenêtre j'en suis sorti. La fenêtre c'est que ce que vous voyez en blanc ici à l'écran donc attention à ce niveau là.

Voilà pour la gestion de la fenêtre donc ça évidemment si vous voulez voir tous les noms exactement, allez voir sur le wiki mais je vous ai les donné vraiment tous :

> SDL_WINDOWEVENT_SHOWN  
> SDL_WINDOWEVENT_MOVED  
> SDL_WINDOWEVENT_RESIZED  
> SDL_WINDOWEVENT_MINIMIZED  
> SDL_WINDOWEVENT_RESTORED  
> SDL_WINDOWEVENT_CLOSED  
> SDL_WINDOWEVENT_ENTER  
> SDL_WINDOWEVENT_LEAVE 

Voilà je pense que j'ai fait le tour de tout.

S'il en manque d'autres, vous verez sur le wiki assez rapidement.

[SDL_WINDOWEVENT](https://wiki.libsdl.org/SDL_WindowEvent)

Voilà pour la gestion de la fenêtre.

#### event window data1-data2

Qu'est-ce qu'on peut faire d'autre également, qu'est-ce qui peut être intéressant ? comme je vous l'ai dit dans certains cas, on peut modifier évidemment quand on a redimensionné la fenêtre ou quand on a déplacé la fenêtre, ça va changer les coordonnées de la fenêtre si elle a été bougé ou ça va changer ses dimensions si elle a été redimensionnée donc ça même si je ne vais pas vous montrer en code, en compilation, vous pouvez le récupérer alors c'est dans `event.window.data1` et vous avez `event.window.data2`.

Pourquoi ils ont appelé ça data1 et data2 ? parce que ça dépend du type d'événement de fenêtre que vous avez eue si c'est encore une fois un déplacement de fenêtres et bien vous aurez la nouvelle coordonnées x et la nouvelle coordonées y du déplacement de la fenêtre, je rappelle le point tout en haut à gauche de la fenêtre encore une fois.

Par contre si c'est un re-dimensionnement de la fenêtre data1 ce sera la largeur de la fenêtre donc le x et data2 ce sera la hauteur de la fenêtre d'accord c'est pour ça qu'ils ont appelé ça avec des noms un peu plus générique parce que ça dépend en fait du type d'événement donc ils ne pouvaient pas appeler ça largeur ou hauteur, ça n'aurait pas été correspondant avec par exemple juste un déplacement de fenêtre.

## SDL_GetTicks

Voilà pour la partie gestion de fenêtre, je vous ai donné encore une fois ce qui avait en tout cas un intérêt par rapport à ça, on va terminer cette fois ci sur cette dernière vidéo sur la sdl pour le cours et dernière vidéo sur la gestion des événements avec une petit un petit bonus sur comment gérer les fps.

Alors ce que je vous montrais tout de suite ne sera pas forcément utilisable ou applicable maintenant, il faudra que vous ayez un minimum tester la sdl, que vous soyez un perfectionniste un petit peu là dedans, que vous soyez parti sur sur un véritable projet pour que ait un intérêt.

Sur des programmes actuel ça n'aura absolument aucune utilité mais c'est des choses qu'à un moment donné vous aurez besoin de savoir faire quand vous allez vouloir faire un jeu vidéo, gestion de sprites, affichage d'animation tout ça, etc. 

Vous serez obligé d'arriver à limiter vos fps pour avoir quelque chose de fluide par exemple à 30 fps, 60 ou le nombre que vous voulez, 24 fps on peut retrouver éventuellement comme vous voulez.

Par exemple les mangas ils tournent en général à 20, 25 fps au niveau des images d'un anime de manga donc voilà vous avez différents  exemples comme ça.

Donc je vais enlever la partie ici événement parce que ça n'a rien avoir ici avec les événements pour le coup donc je le mets en bonus dans la vidéo sur les événements parce que c'est notre dernière vidéo de sdl.

Moi je n'allais pas faire une vidéo pour balancer un truc en deux minutes seulement donc je vous en bonus ici mais évidemment ce n'est pas lié directement aux événements.

Comment ça va fonctionner ? alors je vous montre rapidement, le mieux je vous recommande c'est d'utiliser une fonction, de se faire une propre fonction pour gérer les fps.

Alors déjà il faut savoir ce que la sdl propose de base.

La sdl de base propose une fonction très intéressante qui s'appelle SDL_GetTicks().


Comment va fonctionner SDL_GetTicks() ? et bien c'est une fonction qui va tout simplement retourner le nombre de millisecondes et donc je rappelle qu'une milliseconde ça fait un millième de seconde depuis que la sdl a été initialisée donc depuis le SDL_Init d'accord donc c'est une information qui peut être très utile.

En général comment ça fonctionne et bien on va par exemple récupérer ça dans une variable donc on peut faire un `int ticks = SDL_GetTicks();` admettons.

```c
/*----------------------------------------------*/
int ticks = SDL_GetTicks();
/*----------------------------------------------*/
```

Voilà on dit que je récupère ça, admettons ce genre de chose d'accord, il est même recommandé de mettre en non-signé, pourquoi ? parce que ça sera toujours une valeur négative  donc si vous voulez être encore plus rigoureux et que comme le c est un langage qui demande de la rigueur, je vous recommande même de le mettre en `unsigned`.

```c
/*----------------------------------------------*/
unsigned int ticks = SDL_GetTicks();
/*----------------------------------------------*/
```

Je rappelle pour ceux qui aurait oublié ça sur les variables, vous pouvez faire des variables non signés c'est à dire qu'ils ne peuvent être que avec des valeurs positives en utilisant le mot réservé `unsigned` avant le type de la variable d'accord c'est quelque chose qu'on a déjà vu donc je reviens sur vos révisions si vous voulez concernant les variables.

Voilà on peut faire ça et ici, on va récupérer du coup le nombre de millisecondes dans un printf().

```c
/*----------------------------------------------*/
unsigned int ticks = SDL_GetTicks();
printf("%dms ecoulees.\n", ticks);
/*----------------------------------------------*/
```

Voilà on y va.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    unsigned int ticks = SDL_GetTicks();
    printf("%dms ecoulees.\n", ticks);
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
148ms ecoulees.
.\bin\prog.exe
238ms ecoulees.
.\bin\prog.exe
257ms ecoulees.
```

On recompile tout ça et voyez, il me met 83ms écoulée donc là évidemment le programme vient de se fermer complètement c'est logique.

D'ailleurs j'ai viré mon gestionnaire d'événements mais en fait c'est peut-être bien de le garder parce que j'avais dit que par défaut dans un programme minimal c'est bien d'avoir ça, vraiment ça au moins pour avoir le strict minimum pour avoir la fenêtre qui reste ouverte et cetera.

On peut faire également un petit `SDL_Delay(3000);` pour simuler une petite pause de 3 secondes.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void SDL_ExitWithError(const char *message);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;

    unsigned int ticks = 0;
    SDL_Delay(3000);
    ticks = SDL_GetTicks();
    printf("%dms ecoulees.\n", ticks);

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {               
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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
gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
3138ms ecoulees. #après 3 secondes.
```
Voilà on crée juste la variable `unsigned int ticks = 0;` ensuite on fait le SDL_Delay() et ensuite seulement il récupère.

On est donc à 3138 ms du lancement de programme et vous voyez qu'il y a encore compris dedans les 3000 millisecondes donc les trois secondes qu'on avait avec le SDL_Delay() donc la somme des deux fait bien 3138 pour le coup.

Vous avez dû remarquer pour ceux qui sont plus attentifs que c'est pas forcément toujours pareil.

```powershell
.\bin\prog.exe
3138ms ecoulees.
3196ms ecoulees.
3143ms ecoulees.
```

Si vous êtes attentif, vous voyez que c'est pas toujours pareil, ça a prit 138 millisecondes pour initialiser la sdl et là bas vous voyez que ça a pris 196 d'accord donc évidemment selon les cas bas c'est plus ou moins rapides c'est pas quelque chose qui est exact à 100% donc la sdl peut prendre plus ou moins de temps a s'initialiser en fonction de comment votre système actuel gère la mémoire.

Là comment windows gère la priorité pour le processus de mon
programme par rapport à ça donc ça peut des fois avoir des toutes petites différences de temps mais qui sont évidemment très très minimes et en informatique une milliseconde c'est déjà beaucoup donc voilà.

Voilà il faut prendre ça en compte.

Alors à partir de là donc grâce à SDL_GetTicks() comment on va pouvoir limiter les fps ? alors il y a une chose à savoir déjà c'est comment ça fonctionne si je ne veux pas trop entrer dans les détails au niveau fps.

Grosso modo si on veut avoir un minimum de fluidité c'est ce qu'on recommande au minimum sans parler des animés à la télé ce genre de chose mais si on veut parler d'un minimum de fluidité par exemple dans un jeu on recommande le 30 fps d'ailleurs pour ceux qui font du gaming vous savez que dans les jeux la plupart du temps c'est la valeur minimale que vous avez dans tous les jeux vidéo.

30 fps c'est la base.

Comment on calcule ça ? à quoi ça correspond ? eh bien ça correspond au nombre de millisecondes c'est-à-dire pour mille millisecondes en fait donc une seconde on va diviser par 30 d'accord parce qu'on va dire qu'il y aura trente images en une seconde donc comment on va faire ce calcul là ? eh bien on va le faire simplement de cette manière.

```c
/*
    1000 / 30 = 33
*/
```

Alors si je veux du 30 fps, je vais calculer ça comme ça je vais dire que si j'ai 1000 millisecondes d'accord et bien je les divise par 30.

Ainsi pourquoi je travaille en millisecondes ? parce que vous avez vu que SDL_GetTicks() renvoie des millisecondes et pas des secondes donc il faut travailler en millisecondes.

Je divise par 30 parce que je veux 30 images d'accord 30 frames par seconde, 30 fps et à partir de là bas si on fait le calcul tout bête, 1000 / 30 = 33,33333.. 

On obtient tout simplement 33,3 et si on arrondit ça au minimum d'accord donc on va donc avoir 33.

Alors ça c'est une valeur de référence à garder pour 30 fps.

Maintenant partons sur du 60 parce qu'il y a des gens qui aiment bien 60 fps qui est plus fluide et c'est pas mal aussi.

Le 60 c'est exactement le même calcul et là on va obtenir 16,666.

```c
/*
    1000 / 30 = 33
    1000 / 60 = 16
*/
```

1000 divisé par 60, on obtient 16,6666 donc entre guillemets on obtient valeur arrondi 16.

On arrondi en dessous encore une fois, on ne prend pas au dessus mais on prend en dessous donc ça c'est des références, le 30 fps vous savez que ces 33 et le 60 fps c'est 16.

Alors à quoi vont nous servir ces résultats de calcul ? ça va servir pour la suite...

Au niveau de la limite de fps que je voulais imposer à mon programme, si je veux faire un programme limité à 30 fps je vais garder 33 comme valeur de référence.

Si je veux la limiter à 60 fps, je vais garder le 16.

Comment on va calculer ça ? hé bien on va faire une petite fonction d'accords donc en fait on va simplement fonctionner de cette manière càd qu'on va créer notre petite variable comment là on l'avait fait tout à l'heure soit `unsigned int frame_limit = 0;`

```c
unsigned int frame_limit = 0;
```

Alors on met quelque chose pour éviter que ce soit initialiser avec n'importe quoi voilà.

Ensuite on peut réaffecter la valeur.

```c
unsigned int frame_limit = 0;

/*
    1000 / 30 = 33
    1000 / 60 = 16
*/

frame_limit = SDL_GetTicks() + 16;
```

Là vous comprenez que le 16, il ne sort pas de mon chapeau d'accord 16 est le résultat de mon calcul pour avoir une gestion à 60fps d'accord.

Ensuite on va normalement utilisé un délai pour limiter à 60 fps donc on va faire une fonction pour ça et après on refera ce même calcul-là.

Alors si je disais que c'était pas forcément très utile pour tout de suite en tout cas si vous n'avez pas fait un vrai projet c'est parce que ces trois lignes ne vont pas devoir être mise comme ça ensemble.

```c
unsigned int frame_limit = 0;

/*
    1000 / 30 = 33
    1000 / 60 = 16
*/

frame_limit = SDL_GetTicks() + 16; //1
//Délai pour limiter à 60fps.
frame_limit = SDL_GetTicks() + 16; //2
```

Alors la 1e ligne `frame_limit = SDL_GetTicks() + 16; //1` devrait être mise au début de votre lancement de jeu admettons, d'applications d'accord.

Ensuite au moment où vous avez besoin de limiter les fps par exemple quand vous gérer une animation, il faudra appeler la fonction en question que nous allons développer juste après là `//Délai pour limiter à 60fps.` pour cette fin de vidéo et enfin à la fin donc une fois que l'affichage a été fait, on va s'assurer de limiter à nouveau avec ça `frame_limit = SDL_GetTicks() + 16; //2` avec ça.

```c
frame_limit = SDL_GetTicks() + 16; //1
//Délai pour limiter à 60fps.
frame_limit = SDL_GetTicks() + 16; //2
```

D'accord donc ces trois lignes là ne vont pas être misent comme ça l'une à la suite des autres.

Vous allez voir ça `frame_limit = SDL_GetTicks() + 16; //1` en début de programme, ensuite vous allez avec votre fonction `//Délai pour limiter à 60fps.` dessiner à l'écran donc on va gérer l'animation et ensuite on fera ça `frame_limit = SDL_GetTicks() + 16; //2` mais moi je vous montre ici sur un exemple où bien évidemment, il n'y a rien dans mon programme.

```c
//Délai pour limiter à 60fps.
```

Ici moi j'aimerais appeler une fonction donc l'appeler par exemple limit_fps() et je vais lui passer du coup l'information que je veux d'accord donc je vais passer la fameuse frame_limit() parce qu'on l'a récupéré grâce à ce calcul-là, `frame_limit = SDL_GetTicks() + 16; //1` où on sait qu'à partir de 16, on sait qu'on va pouvoir travailler en 60 fps donc on y va ...

On va prendre le protype et on va créer notre fonction.

```c
void SDL_LimitFPS(unsigned int limit);
```

Ce que je vais vous montrer-là ça n'a rien de compliqué et c'est juste qu'il faut savoir que c'est comme ça qu'on pouvait le gérer mais c'est relativement simple.

Alors comment ça fonctionne ? alors pour commencer il va falloir des valeurs de comparaison donc je vais récupérer ici le nombre de millisecondes d'écoulé à partir de ma fonction et voyez je le fais ici c'est important.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();
}
```

Ici je fais SDL_GetTicks() par défaut sans le +16 ou n'importe quoi, on s'en fou je le fais juste comme ça.

Ensuite je vais procéder à un tas de comparaison, si je vois que ma limite par rapport à ce que j'ai déjà au niveau des frames, au niveau du temps que j'ai récupéré parce que je répète que c'est le temps depuis que la sdl a été initialisée, `if(limit < ticks)`. Si je vois que *limit* est inférieur à ce que je viens de récupérer là *ticks* dans la fonction d'accords c'est que je n'ai pas à limiter mon nombre d'image donc mon nombre de frames parce que mon temps limite que j'ai récupéré ici *ticks* en fait est déjà plus grand que *limit*.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
}
```

`if(limit < ticks)``si c'est vrai et que *ticks* est déjà plus grand que *limit*, il n'y a pas besoin de mettre en pause le programme pour dire attends ... attends de te re-synchroniser avant de continuer ton exécution.

Ainsi dans ce cas, je *return;* directement donc je retourne directement rien du tout parce que je rappelle que ça retourne *void* mais on met ça *return;* pour être sûr de quitter la fonction c'est-à-dire que je ne fais rien tout simplement dans ce genre de cas sinon ok.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
}
```

Si jamais, je vois que ma limite par contre elle est plus grand que *ticks* selon le nombre de fps que je veux donc c'est +16 parce que c'est 60 alors évidemment pour des questions d'optimisation si plus tard vous faites un vrai projet, un vrai programme, ne marquez pas 16 comme ça en dure.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + 16)
}
```

Plutôt que d'écrire +16, faites tout simplement une petite constante ou un fichier de configuration et comme ça en fonction du nombre de fps que vous voulez, vous aurez une constante.

Admettons si on ne veut pas faire de fichier de config, on
ferait ceci.

```c
#define FPS_LIMIT 16

//etc.

void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + FPS_LIMIT)
}
```

Du coup j'aurais juste à faire ça.

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480
#define FPS_LIMIT 16

void SDL_ExitWithError(const char *message);
void SDL_LimitFPS(unsigned int limit);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;
    unsigned int frame_limit = 0;

    /*
        1000 / 30 = 33
        1000 / 60 = 16
    */

    frame_limit = SDL_GetTicks() + FPS_LIMIT; //1
    SDL_LimitFPS(frame_limit);
    frame_limit = SDL_GetTicks() + FPS_LIMIT; //2

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {               
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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

void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + FPS_LIMIT)
        //...
}
```

Du coup j'aurais juste à utiliser la constante mais si cette fois-çi je vois l'inverse ici.

```c
//etc.
else if(limit > ticks + FPS_LIMIT)
```

Ainsi si cette fois ci je vois l'inverse c'est à dire que là c'est plus grand que ce que je viens de récupérer ici *ticks* c'est que l'un n'est pas synchrone.

On risque d'avoir des images en fait qui vont être beaucoup plus nombreuses et du coup ça va créer une désynchronisation au niveau de mes affichages et ça sur une animation au par exemple d'avoir un personnage qui marchent normalement d'accord avec une animation qui est fluide et qui se fait de manière régulière toujours pareil et bien des fois le bonhomme va marcher tout doucement, vous aurez l'impression que votre jeu lague et à d'autres moments vous allez avoir un personnage qui va déplacer super vite et on aura l'impression qu'il a mangé du lion donc évidemment ça n'ira pas.

Dans ce genre de cas `else if(limit > ticks + FPS_LIMIT)`, si on voit qu'effectivement on est en avance d'une certaine manière par rapport au temps d'exécution, on va mettre une pause et ça tombe bien puisque les sdl propose le fameux SDL_Delay() pour le faire en fonction du nombre que l'on veut.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + FPS_LIMIT)
        SDL_Delay(FPS_LIMIT);
    //...
}
```

Ainsi une pause de quoi ? Une pause par rapport au nombre de fps que l'on veut donc ici de 16 (FPS_LIMIT) parce qu'on veut fonctionner à 60 fps je rappelle.

Si c'était en 30 fps et bien ce serait 33, on aurait juste ici à changer par 33.

```c
#define FPS_LIMIT 33 //30 fps
```

On aurait juste ici à changer par 33 et du coup vous voyez ça va modifier tout le programme, c'est plutôt optimisé donc on fait ça tout simplement.

On fait une pause simplement et on dit tu attends ce nombre de temps là donc tu vas attendre un petit peu pour que ça garde la synchronisation et que du coup notre animation soit propre.

Evidemment si on est dans ni l'un ni l'autre d'accord si ce n'est pas plus grand ni plus petits ben on va simplement faire un SDL_Delay() de la différence des deux parce que c'est à dire qu'il a quand même quelque chose qui est différent d'accord on a une égalité pour les deux temps mais on a besoin quand même d'avoir une pose éventuelle donc elle sera peut-être de 0 ou peut être d'autres choses.

Ainsi on fait tout simplement une pause de *limit* donc la valeur qu'on a récupéré je rappelle dans notre fonction *-* la valeur ici qu'on a calculé directement *ticks* qu'on a récupéré dans notre fonction de gestion donc `SDL_Delay(limit - ticks);` et en fera éventuellement une pause nécessaire en fonction.

```c
void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + FPS_LIMIT)
        SDL_Delay(FPS_LIMIT);
    else
        SDL_Delay(limit - ticks);
}
```

Là vous avez géré vos fps donc c'est très simple d'accord en termes de compréhension, il n'y a rien de compliqué c'est de la logique simplement c'est que si vous ne gérez pas cette limitation en fait de fps et vous allez voir que tous les jeux le propose, ils proposent une limitation de fps et bien quelqu'un par exemple qui a un tout petit pc ben les fps vont être réduits puis quelqu'un qui a un pc de compet ben il va se retrouver à 140 de son fps donc il pourrait se dire génial c'est super fluide alors que non ce sera pas super fluide parce sera le temps est accéléré.

Et dans un jeu si le temps et accélère, imaginez un jeu de tire c'est-à-dire que vous n'aurez même pas le temps de réagir que la personne en face vous aura déjà tiré dessus.

Vous n'aurez rien compris à ce qui s'est passé au niveau de la scène puisque tout est accélérer, le temps et accéléré et à l'inverse si c'est reculé, si c'est retardé vous aurez l'impression que votre jeu lague et qu'il fonctionne au ralenti, qu'il y a un mode slowmotion qui est mis dessus alors imaginez un jeu de voiture qui fonctionne au ralenti ça ne va pas être franchement génial donc c'est super important de limiter les fps et je vous donne en cette fin de vidéo voyez une petite astuce très simple.

## Code Bonus fps

```c
/*
    GNU/Linux et MacOS
        > gcc main.c $(sdl2-config --cflags --libs) -o prog
        > gcc *.c $(sdl2-config --cflags --libs) -o prog
    Windows
        > gcc src/m028.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
        > gcc src/m028.c -o bin/prog -I include -L lib -mingw32 -lSDL2main -lSDL2 -mwindows
*/
#include <stdio.h>
#include <stdlib.h>
#include <SDL.h>

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480
#define FPS_LIMIT 16

void SDL_ExitWithError(const char *message);
void SDL_LimitFPS(unsigned int limit);

int main(int argc, char *argv[])
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;

    //Lancement SDL
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
        SDL_ExitWithError("Initialisation SDL");
    
    //Création fenêtre + rendu
    if(SDL_CreateWindowAndRenderer(WINDOW_WIDTH, WINDOW_HEIGHT, 0, &window, &renderer) != 0)
        SDL_ExitWithError("Impossible de creer la fenetre et le rendu");

    /*----------------------------------------------*/
    SDL_bool program_launched = SDL_TRUE;
    unsigned int frame_limit = 0;

    /*
        1000 / 30 = 33
        1000 / 60 = 16
    */

    frame_limit = SDL_GetTicks() + FPS_LIMIT; //1
    SDL_LimitFPS(frame_limit);
    frame_limit = SDL_GetTicks() + FPS_LIMIT; //2

    while(program_launched)
    {
        SDL_Event event;

        while(SDL_PollEvent(&event))
        {
            switch(event.type)
            {               
                case SDL_QUIT:
                    program_launched = SDL_FALSE;
                    break;
                
                default:
                    break;
            }
        }
    }
    /*----------------------------------------------*/

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

void SDL_LimitFPS(unsigned int limit)
{
    unsigned int ticks = SDL_GetTicks();

    if(limit < ticks)
        return;
    else if(limit > ticks + FPS_LIMIT)
        SDL_Delay(FPS_LIMIT);
    else
        SDL_Delay(limit - ticks);
}
```

En cette fin de vidéo, une petite astuce très simple encore une fois.

Vous utilisez ça `frame_limit = SDL_GetTicks() + FPS_LIMIT; //1` au départ, au moment de contrôler la limite vous utilisez ça `SDL_LimitFPS(frame_limit);` et à la fin bien sûr derrière vous utilisez ça `frame_limit = SDL_GetTicks() + FPS_LIMIT; //2` c'est super important pour toujours s'assurer d'avoir cette synchronisation.

Encore une fois s'il y a des chose que vous n'avez pas compris par rapport à ça c'est pas bien grave, le jour où vous ferez vraiment des animations, un programme avec plein d'affichage et de gestion d'image ...faites-le déjà sans la gestion de fps et vous verrez déjà ce qui se passe.

Après vous appliquerez la gestion des fps comme je vous ai montré là et vous verrez le problème que ça corrige et du coup à quoi ça sert.

C'est le seul moyen de toute façon vraiment de vous en rendre compte c'est encore une fois de mettre en application pour voir l'utilité que ça a mais encore une fois ceux qui jouent aux jeux vidéo ont déjà tous bien compris tout de suite à quoi ça sert et l'utilité que ça a parce que sans ça on aurait encore une fois les gens fonctionnerait en fonction du matériel qu'il y a donc ceux qui ont des gros pc, ça irait trop vite et ceux qui auront des des petits pc peut-être que ça n'irais pas assez vite ou alors ce serait un fonctionnement normal.

Donc chaque personne aurait une exécution du programme différentes qui serait du coup impossible à gérer donc c'est très très important de savoir ça.

C'était le petit bonus, la petite astuce de fin ici que je vous donne ici.

Je vous remercie en tout cas d'avoir suivi cette vidéo c'était encore une fois le dernier cours sur la sdl en c et on va attaquer maintenant un autre chapitre qui devrait a  priori le dernier de la formation et après on aura terminé en tout cas vous aurez terminé avec le langage c au niveau du cours.

Et vous aurez fait tout le tour de ce que je voulais vous montrer donc on aura dépassé les 30 vidéos et donc ça fait pas mal quand même sachant que les vidéos sont plutôt bien fournies, c'est pas des vidéos de cinq, dix minutes, on est plutôt sur de la demi heure à chaque fois et peut-être même plus pour certaines notamment celle-là je pense que là on est on est bien au niveau des temps.

J'espère ça vous a plus, s'il y a des questions des commentaires comme d'habitude laissez des messages directement sous la vidéo dans les commentaires, le like, le partage évidemment parce que c'est quelque chose je pense que beaucoup de gens ont cherché et qui pourra servir à beaucoup de personnes soit des universitaires, des gens curieux qui veulent se mettre à la programmation ou créer leur petit jeu ou créer n'importe quoi, ça pourra leur être utile.

Donc n'hésitez pas à partager.

A bientôt du coup pour la suite de cette formation et n'hésitez pas à vous exercez avec la sdl, je vous ai présenté vraiment l'essentiel mais on peut faire beaucoup beaucoup plus de choses encore donc n'hésitez pas à aller voir également la Playlist des tutos parce que je compléterai où je complète même actuellement déjà avec des tutos même concernant la sdl pour venir compléter tout ce que vous avez vu ici au niveau du cours.

A bientôt tout le monde pour une nouvelle vidéo