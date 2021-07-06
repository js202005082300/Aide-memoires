# [Afficher des images (SDL)](https://www.youtube.com/watch?v=ZJrXO8hKpS8)

Bonjour à tous, bienvenue pour un tutoriel en langage c concernant la bibliothèque sdl.

Si vous souvenez dans le cours, on avait vu comment afficher des images au format Bitmap des images bmp avec notamment la fonction sdl_load_bmp() et je vous avais expliqué que c'était le seul format qui étaient pris en charge de manière standard par la bibliothèque et quand on allait voir ensemble donc c'est le cas justement dans ce tutoriel en annexe un greffon donc c'est en fait un supplément à la bibliothèque que vous allez pouvoir incorporer par la suite dans la deuxième partie de cette vidéo qui vous permettra  d'afficher des images sous d'autres formes.

Voilà donc le format jpeg par exemple et notamment le format png qui permet de gérer la transparence d'accord si vous avez par exemple une image avec de la transparence en image de fond par exemple, vous pourrez gérer ça directement avec le format png au lieu de faire ça avec du bmp.

On va regarder au niveau du code repris du cours que je vais commenter assez vite.

j'ai repris un code tout à fait classique des choses qu'on a vues mais n'hésiter pas à revoir les séances correspondantes pour la création d'une fenêtre, la création d'un rendu ou d'une texture. Voilà c'est ce qui concerne les 3 à voir.

On ne pas mettre d'événements de toutes façons puisque cela n'avait pas d'intérêt alors oui c'était inutile d'alourdir le code si on en a pas besoin et pour montrer finalement comment utiliser le greffon qui va permettre de gérer d'autres formats d'images.

On va regarder tout ça.

Au niveau du projet c'est ce qu'on a toujours eue c'est à dire ce que je vous avez fait dans les vidéos les petits répertoires différent pour la sdl.

```
SDL
├───bin
├───include
├───lib
└───src
```

Un répertoire src qui contient les fichiers sources tout simplement et moi je met des images puisqu'on va devoir les afficher par la suite.

> [SDL2-devel-2.0.14-mingw.tar.gz](https://www.libsdl.org/download-2.0.php)

```c
/*
    GNU/Linux et MacOS
        > gcc src/*.c -o bin/prog $(SDL2-config --cflags --libs)
    Windows
        > gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
*/
#include <SDL2.h>
#include <stdio.h>
#include <stdlib.h>

void clean_ressources(SDL_Window *w, SDL_Renderer *r, SDL_Texture *t)
{
    if(t != NULL)
        SDL_DestroyTexture(t);

    if(r != NULL)
        SDL_DestroyRenderer(r);

    if(w != NULL)
        SDL_DestroyWindow(w);
    
    SDL_Quit();
}

/*------------------------------------------------------*/

int main(int argc, char **argv)
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;
    SDL_Surface *picture = NULL;
    SDL_Texture *texture = NULL;
    SDL_Rect dest_rect = {0, 0, 640, 480};

    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    window = SDL_CreateWindow("Affichage avec SDL2_image", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 640, 480, 0);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    picture = SDL_LoadBMP("src/rocky4.bmp");
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    texture = SDL_CreateTextureFromSurface(renderer, picture);
    SDL_FreeSurface(picture);
    if(texture == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    if(SDL_QueryTexture(texture, NULL, NULL, &dest_rect.w, &dest_rect.h) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    if(SDL_RenderCopy(renderer, texture, NULL, &dest_rect) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    SDL_RenderPresent(renderer);
    SDL_Delay(5000);

    clean_ressources(window, renderer, texture);
    return EXIT_SUCCESS;
}
```

Petit rappel par rapport à ce qu'on a vu dans le court ok donc en gros en sdl par rapport à l'affichage de l'image que nous voulons, il y a trois principales structures à prendre en compte.

Nous avons celle qui représente la fenêtre d'accord.

La fenêtre c'est un peu le gabarit ce qui va entourer en fait votre affichage qui contient notamment les boutons pour réduire la fenêtre, fermer la fenêtre ce genre de choses que vous avez sur n'importe quelle application graphique.

Nous avons ensuite le rendu.

Le rendu c'est un peu comme une feuille blanche d'accord un tableau sur lequel nous allons pouvoir dessiner, afficher des choses et nous avons les textures.

Les textures en fait vont permettre véritablement de créer par exemple quelque chose à appliquer sur notre rendu d'accord c'est un peu par exemple une image qu'on mettrait sur un tableau, qu'on collerait sur un tableau dans une salle d'une salle de classe ou dessiner, tracer par exemple des traits, des points avec une craie ou n'importe quoi c'est tout à fait ce genre de chose.

Pour l'image nous utilisons bien évidemment une surface puisqu'une texture se crée à partir d'une surface comme on l'avait vu justement dans le cours en langage c sur le chapitre concernant la sdl.

Voilà en gros comment ça va fonctionner et si vous voyez un petit peu ici au niveau du code, on a évidemment la petite structure de `SDL_RECT` d'accord qui permet de gérer un encadrement en fait par rapport à notre surface qui servira notamment après pour le rendu d'accord pour la texture que nous allons créer.

```c
SDL_Rect dest_rect = {0, 0, 640, 480};
```

Voilà pour ça donc je reprécise très rapidement, j'ai créé donc les différentes structures ici initialisées à NULL, vous verrez par la suite pourquoi.

```c
SDL_Window *window = NULL;
SDL_Renderer *renderer = NULL;
SDL_Surface *picture = NULL;
SDL_Texture *texture = NULL;
```

Alors je prévois un rectangle en 640 480 puisque c'est tout simplement les dimensions de l'image qu'on va afficher pour commencer au format bmp donc on va faire un affichage natif avec la sdl telle donc là c'est vraiment de la sdl standard comme vous l'avez vu dans le cours.

> SDL/src/rocky4.png

Ensuite première chose, on initialise sdl d'accord on fait des vérifications tout le temps d'accord, vérifier le type de retour s'il y a eu une erreur par rapport à ça. On affiche un message en utilisant `SDL_GetError()` rien nouveau.

```c
if(SDL_Init(SDL_INIT_VIDEO) != 0)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(NULL, NULL, NULL);
    exit(EXIT_FAILURE);
}
```

Alors j'ai changé un petit peu par rapport à ce que je faisais dans le cours par une fonction clean_ressources() qui va permettre en fait de nettoyer, libérer la mémoire en fait des ressources éventuellement allouer avec succès pour qu'il n'y ait pas de fuites de mémoire à l'arrêt du programme.

Cette fonction clean_ressources() est très simple, elle se présente comme ceci.

```c
void clean_ressources(SDL_Window *w, SDL_Renderer *r, SDL_Texture *t)
{
    if(t != NULL)
        SDL_DestroyTexture(t);

    if(r != NULL)
        SDL_DestroyRenderer(r);

    if(w != NULL)
        SDL_DestroyWindow(w);
    
    SDL_Quit();
}
```

Elle prend en paramètre une fenêtre, voyez les trois structures dont je vous parlais, un rendu et une texture.

Ainsi si cette texture existe donc associations différentes de nuls eh bien elles seront **détruites dans l'ordre inverse dans lequel vous les avez créé**.

On a commencé par créer la fenêtre ensuite le rendu, ensuite la texture donc on libère les ressources à l'envers et on quitte ensuite proprement la sdl qui a été initialisée au tout départ du programme, SDL_Quit().

Voilà comment ça se passe donc on initialise sdl, voyez ça va appeler SDL_Init() et si l'initialisation a échoué directement à ce moment là, la fenêtre n'a pas encore été créée donc on donne **NULL** comme argument pour la fonction, y compris pour le rendu, la texture et on quitte en indiquant qu'il y a une erreur.

Ensuite on fait la création de la fenêtre.

```c
window = SDL_CreateWindow("Affichage avec SDL2_image", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 640, 480, 0);
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(NULL, NULL, NULL);
    exit(EXIT_FAILURE);
}
```

Tout ça a déjà été vu dans le cours.

Si la fenêtre n'a pas été crée, même chose d'accord on a rien à passer comme information parce que rien n'a pu être alloués et on ferme le programme en indiquant une erreur.

Ensuite on s'occupe du rendu même chose.

```c
renderer = SDL_CreateRenderer(window, -1,SDL_RENDERER_SOFTWARE);
if(window == NULL)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(window, NULL, NULL);
    exit(EXIT_FAILURE);
}
```

Si par contre le rendu à échouer comme on a quand même pu à ce stade créer la fenêtre, on passe cette fois ci le pointeur de la fenêtre pour le libérer de la mémoire, très important etc etc.

On prépare ensuite notre image qui est une surface je rappelle *picture* est une SDL surface qui du coup est chargé depuis cette fonction-là, 

```c
picture = SDL_LoadBMP("src/rocky4.bmp");
if(window == NULL)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(window, renderer, NULL);
    exit(EXIT_FAILURE);
}
```

Même chose s'il y a une erreur par rapport à ça on clean_ressources() d'accord donc la fenêtre et le rendu en l'occurrence et ensuite la texture qui est créé à partir de notre surface.

```c
texture = SDL_CreateTextureFromSurface(renderer, picture);
SDL_FreeSurface(picture);
if(texture == NULL)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(window, renderer, NULL);
    exit(EXIT_FAILURE);
}
```

On libère l'image puisqu'on en a plus besoin à ce moment là une fois que la texture est créée.

```c
//etc.
SDL_FreeSurface(picture);
//etc.
```

Si la création de la texture a échouée ou non d'ailleurs au final on fait un *Free* de l'image dans tous les cas que la texture ait réussi à le crééer ou non peu importe parce que si elle a réussi à être créé, on n'a plus besoin de toutes façons de l'image donc on peut la libérer et si elle n'a pas été créée on va quitter le programme donc on aura plus besoin d'avoir l'image en mémoire.

En gros donc voilà on fait toutes les vérifications, vous voyez très important de toujours vérifier chaque retour de fonctions ça c'est vraiment important en langage c comme il n'y a **pas de système d'exception** c'est à vous de vérifier les retours de fonction pour gérer un maximum les erreurs, pour ne pas se retrouver dans un scénario où aucune erreur n'est traité.

On a donc toute cette texture ici ensuite on fait tout simplement l'**application de la texture**.

```c
if(SDL_QueryTexture(texture, NULL, NULL, &dest_rect.w, &dest_rect.h) != 0)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(window, renderer, texture);
    exit(EXIT_FAILURE);
}
```

On applique la texture d'accord c'est là qu'on se sert justement de notre fameux rectangle **SDL_RECT** et ensuite on fait l'**application pour le rendu** d'accord ici.

```c
if(SDL_RenderCopy(renderer, texture, NULL, &dest_rect) != 0)
{
    SDL_Log("ERREUR > %s\n", SDL_GetError());
    clean_ressources(window, renderer, texture);
    exit(EXIT_FAILURE);
}
```

Alors c'est appliqué directement sur le rendu.

```c
if(SDL_QueryTexture(texture, NULL, NULL, &dest_rect.w, &dest_rect.h) != 0)
//etc.
if(SDL_RenderCopy(renderer, texture, NULL, &dest_rect) != 0)
```

C'est le rectangle `&dest_rect.w, &dest_rect.h` d'accord dans lequel on a chargé l'image en fait pour notre textures `texture` et ensuite on applique la texture sur le rendu.

`SDL_RenderCopy(renderer, texture, NULL, &dest_rect)` applique la texture sur le rendu càd qu'on colle notre image sur le tableau d'accord si vous voulez un peu par analogie.

Ensuite là on affiche le rendu.

```c
SDL_RenderPresent(renderer);
```

Là on rend en fait l'affichage donc on effectue le rendu.

```c
SDL_Delay(5000);
```

Comme je n'ai pas mis d'événements dans le code pour pas que ça fasse trop long, on attend simplement 5 secondes avec un petit SDL_Delay() et on nettoie bien évidemment à la fin du programme les 3 ressources principales qui n'avaient pas encore été libérées.

```c
clean_ressources(window, renderer, texture);
```

Je rappelle que l'image a été libéré déjà avant ici.

```c
//etc.
SDL_FreeSurface(picture);
//etc.
```

L'image a été libéré avant donc on avait 4 pointeurs ici et dans tous les scénarios possibles, ils sont libérés voilà qu'il y ait eu des erreurs en cours de route ou que tout ait bien fonctionné et qu'on en arrive ici.

```c
SDL_Window *window = NULL;
SDL_Renderer *renderer = NULL;
SDL_Surface *picture = NULL;
SDL_Texture *texture = NULL;
//etc.
SDL_FreeSurface(picture);
//etc.
clean_ressources(window, renderer, texture);
return EXIT_SUCCESS;
```

Enfin on fait un petit *return EXIT_SUCCESS* pour dire que tout s'est bien passé.

Voilà comment que ça se passe.

Je vais compilé tout ça donc on récupère la ligne habituel comme l'a toujours fait dans cours, pas de problème à ce niveau-là.

```c
/*
    GNU/Linux et MacOS
        > gcc src/*.c -o bin/prog $(SDL2-config --cflags --libs)
    Windows
        > gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
*/
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>

void clean_ressources(SDL_Window *w, SDL_Renderer *r, SDL_Texture *t)
{
    if(t != NULL)
        SDL_DestroyTexture(t);

    if(r != NULL)
        SDL_DestroyRenderer(r);

    if(w != NULL)
        SDL_DestroyWindow(w);
    
    SDL_Quit();
}

/*------------------------------------------------------*/

int main(int argc, char **argv)
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;
    SDL_Surface *picture = NULL;
    SDL_Texture *texture = NULL;
    SDL_Rect dest_rect = {0, 0, 640, 480};

    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    window = SDL_CreateWindow("Affichage avec SDL2_image", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 640, 480, 0);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    picture = SDL_LoadBMP("src/rocky4.bmp");
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    texture = SDL_CreateTextureFromSurface(renderer, picture);
    SDL_FreeSurface(picture);
    if(texture == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    if(SDL_QueryTexture(texture, NULL, NULL, &dest_rect.w, &dest_rect.h) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    if(SDL_RenderCopy(renderer, texture, NULL, &dest_rect) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    SDL_RenderPresent(renderer);
    SDL_Delay(5000);

    clean_ressources(window, renderer, texture);
    return EXIT_SUCCESS;
}
```
```powershell
gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
.\bin\prog.exe
```

On exécute *prog.exe* et ensuite l'image s'affiche sans problème, cinq secondes d'affichage et le programmes va quitter tout seul d'accord ça c'est tout ce que vous aviez vu dans le cours d'accord tout ça maintenant vous êtes tout à fait capables de le faire, de leur faire en tout cas puisque ce sont que des fonctions qu'on a abordés.

Je vous ai expliqué d'où venaient les paramètres et comment ça fonctionnait et on a vraiment tout le détail, un maximum. C'était d'ailleurs des vidéos assez long pour vraiment tout expliquer en détail donc je ne reviendrai pas dessus mais si par exemple vous avez des commentaires concernant les textures bien vous allez sur la vidéo concernant les textures en sdl vous laisser un petit commentaire sur la vidéo moi j'y répondrai il n'y a pas de problème, je pourrai vous aider par rapport à ça.

Pour la suite ici nous avons maintenant utiliser parce que c'est l'intérêt du tuto justement le fameux greffon qui s'appelle *SDL2* puisqu'on travaille avec SDL2 Image qui va nous permettre d'utiliser d'autres formats d'image que le .bmp notamment le .jpeg et le .png en l'occurrence qui sont intéressants pour nous.

Pour cela vous allez tout simplement aller sur le site https://www.libsdl.org/projects/

[https://www.libsdl.org/projects/](https://www.libsdl.org/projects/)  

Ici vous avez donc tout les différents projets différents qu'on peut retrouver et notamment les greffons concernant la sdl.

Vous allez dans SDL_image et vous tombez sur ce site https://www.libsdl.org/projects/SDL_image/

[https://www.libsdl.org/projects/SDL_image/](https://www.libsdl.org/projects/SDL_image/)

Vérifier d'être bien être sur SDL_image en version 2.0 d'accord parce que la version 1.2 c'est la version obsolète qu'on ne veut pas utiliser et ensuite on récupère les choses.

Comme on l'avais fait dans la vidéo d'introduction à la SDL, on avait récupérer la version développement, *Development Libraries:* d'accord c'est la bibliothèque pour le développement pour **mingw** parce que c'est comme ça qu'on a travaillé dans nos vidéos.

> [SDL2_image-devel-2.0.5-mingw.tar.gz (MinGW 32/64-bit)](https://www.libsdl.org/projects/SDL_image/release/SDL2_image-devel-2.0.5-mingw.tar.gz)

>
Development Libraries:
   Windows
      SDL2_image-devel-2.0.5-VC.zip (Visual C++ 32/64-bit)
      **SDL2_image-devel-2.0.5-mingw.tar.gz (MinGW 32/64-bit)**
   Mac OS X
      SDL2_image-2.0.5.dmg
   Linux
      Please contact your distribution maintainer for updates.
   iOS & Android
      Projects for these platforms are included with the source.
>

Si bien sûr vous travaillez avec visual ce serait différent mais dans les vidéos, on a fait avec *mingw* donc pas de changement à ce niveau-là.

Vous récupérez ça ici, [SDL2_image-devel-2.0.5-mingw.tar.gz (MinGW 32/64-bit)](https://www.libsdl.org/projects/SDL_image/release/SDL2_image-devel-2.0.5-mingw.tar.gz).

Pour macOS vous avez le même fichier et pour Linux vous avez à la ligne de commande dans les dépôts directement, vous avez le paquet *sdl2 images* d'accord c'est la même chose sauf que là c'est SDL2_image où on a retiré le *image* suivant comment s'appelle le paquet sur votre distribution etc. Il faut rechercher la partie développement.

Parfois on a des fichiers Zip et si vous avez des gestionnaire comme WinZip ou Rar que je vous déconseille personnellement autant pour leur performance médiocre en terme de compression, vous pouvez utiliser bien sûr **7zip qui est gratuit, open source, multi-plateformes** et qui prend en charge tous les formats. C'est quand même bien plus efficace.

Au moins avec 7zip ça fonctionne partout peut importe votre système d'exploitation.

Nous on a récupérez celui-là [SDL2_image-devel-2.0.5-mingw.tar.gz (MinGW 32/64-bit)](https://www.libsdl.org/projects/SDL_image/release/SDL2_image-devel-2.0.5-mingw.tar.gz) pour image-devel ou en Dev en installation en ligne de commande si vous êtes sur linux.

Pour mac vous avez le fichier qui est là tout simplement.

Vous allez obtenir votre archive par la suite.

> SDL2_image-devel-2.0.5-mingw.tar.gz

Cette archive, on va tous rangés comme il faut dans l'installation sdl basiques que nous avions faite au préalable.

Avec 7zip on voit très bien le format *tar.gz* qui ne fonctionne pas forcément avec un autre logiciel et là vous prenez la version en 64 bits si on a installer la version 64 bits en SDL.

> Pour la version 32 bits, on prend i686-w64-mingw32
> Pour la version 64 bits, on prend x86_64-w64-mingw32

J'avais prit la SDL en 64 bits donc je prends pour la même architecture. Si vous aviez pris 32 il faut prendre la SDL_image en 32 bits et à partir de là on a plus qu'à déplacer ce qu'il faut.

## SDL_image
32 bits : \SDL2_image-2.0.5\i686-w64-mingw32
+ \bin (Nb. on ne tiens pas compte de tout les fichiers .txt)
+ \include\SDL2
+ \lib

Voilà c'est aussi simple que ça on a intégré le greffon *SDL_image* à notre projet SDL c'est aussi simple que ça vous êtes sûr d'avoir installer correctement et si à la compilation il y a une erreur c'est que vous vous serez trompez dans un chemin où vous aurez mis dans un mauvais répertoire etc. 

Comment ça se passe du coup maintenant au niveau du code ?

Là maintenant le projet est prêt à utiliser *SDL_image* et on va s'en servir directement au lieu de ce format bmp.

En termes déjà d'ajout, on va ajouter un nouveau include et comme SDL_image utilise la sdl donc on va le préciser un petit peu après mais on va faire ça.

```c
#include <SDL.h>
#include <SDL_image.h>
#include <stdio.h>
#include <stdlib.h>
//etc.
```

Comme on avais pas de sous-dossier SDL2, je n'ai pas besoin de le mettre ici dans le nom.

Ensuite pour la commande de compilation, il faudra changer également, *-lSDL2_image*.

```c
/*
    GNU/Linux et MacOS
        > gcc src/*.c -o bin/prog $(SDL2-config --cflags --libs)
    Windows
        > gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2 -lSDL2_image
*/
```

*-lSDL2_image* d'accord pour intégrer tout simplement à l'édition de liens ce qu'il faut pour la compilation sinon on n'arrivera pas à trouver tout simplement votre bibliothèque.

Voilà d'accord au niveau de tout ce qui est pour la compilation et pour l'inclusion de la bibliothèque au projet, c'est tout bon.

Maintenant il faut au niveau du code faire des modifications et là vous allez voir c'est impressionnant comme c'est compliqué à faire ! :)

Vous remplacez tout simplement ceci.

```c
    SDL_LoadBMP("src/rocky4.bmp");
    //-->
    IMG_Load("src/rocky4.bmp");
    IMG_Load("src/rocky4.jpg");
    IMG_Load("src/rocky4.png");
```

*IMG_Load()* permet de spécifier n'importe quel format : bmp, tiff, jpeg, png, peu importe donc moi j'ai fait une image au format jpeg comme ceci et vous n'avez plus qu'à compiler.

```c
/*
    GNU/Linux et MacOS
        > gcc src/*.c -o bin/prog $(SDL2-config --cflags --libs)
    Windows
        > gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2 -lSDL2_image
*/
#include <SDL.h>
#include <SDL_image.h>
#include <stdio.h>
#include <stdlib.h>

void clean_ressources(SDL_Window *w, SDL_Renderer *r, SDL_Texture *t)
{
    if(t != NULL)
        SDL_DestroyTexture(t);

    if(r != NULL)
        SDL_DestroyRenderer(r);

    if(w != NULL)
        SDL_DestroyWindow(w);
    
    SDL_Quit();
}

/*------------------------------------------------------*/

int main(int argc, char **argv)
{
    SDL_Window *window = NULL;
    SDL_Renderer *renderer = NULL;
    SDL_Surface *picture = NULL;
    SDL_Texture *texture = NULL;
    SDL_Rect dest_rect = {0, 0, 640, 480};

    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    window = SDL_CreateWindow("Affichage avec SDL2_image", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 640, 480, 0);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(NULL, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_SOFTWARE);
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, NULL, NULL);
        exit(EXIT_FAILURE);
    }

    picture = IMG_Load("src/rocky4.jpg");
    if(window == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    texture = SDL_CreateTextureFromSurface(renderer, picture);
    SDL_FreeSurface(picture);
    if(texture == NULL)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, NULL);
        exit(EXIT_FAILURE);
    }

    if(SDL_QueryTexture(texture, NULL, NULL, &dest_rect.w, &dest_rect.h) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    if(SDL_RenderCopy(renderer, texture, NULL, &dest_rect) != 0)
    {
        SDL_Log("ERREUR > %s\n", SDL_GetError());
        clean_ressources(window, renderer, texture);
        exit(EXIT_FAILURE);
    }

    SDL_RenderPresent(renderer);
    SDL_Delay(5000);

    clean_ressources(window, renderer, texture);
    return EXIT_SUCCESS;
}
```
```powershell
gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2 -lSDL2_image
.\bin\prog.exe
```

C'est terminé donc c'est une ligne a changer même si bon il y avait des inclusions supplémentaires mais en terme de code pur, il faut juste remplacer un nom de fonction et du coup vous pouvez lire n'importe quel format.

*SDL2_image* avec IMG_Load() comme la fonction native SDL_LoadBMP() mais c'est intéressant surtout pour d'autres formats qu'elle ne prend pas en compte nativement.

On compile vous voyez que j'ai bien ajouter le *-lSDL2_image* et si j'ai pas fait d'**erreur dans mes chemin** à priori

Et là nous avons bien l'image au format jpeg qui s'affiche d'accord voilà tout simplement.

Pour les différencier bmp est en noir et blanc et le format jpg est en couleur donc vous avez comme ça l'affichage qui se fait bien.

Pour rappel, j'avais mis mon image dans *src* alors que la compilation ici au niveau de la commande se fait à la racine du projet.

> gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2 -lSDL2_image

C'est pour ça que dans la commande, on précise src slash *src/*, bin slash *bin/*, etc.

Je suis obligé dans le chargement de mon image de préciser la même chose d'accord parce que si on essaie de donner directement mon image, ça ne marche pas.

    IMG_Load("rocky4.jpg");
    au lieu de IMG_Load("src/rocky4.jpg");

... ça ne marchera pas parce que je les ait mis dans la *src* donc je dois passer par le sous-dossier, très important.

Voilà c'était pas sorcier.

En gros dans le cours, vous avez appris à intégrer la bibliothèque SDL dans vos projets donc normalement vous savez ce que vous faites et comment vous l'avez employés. Vous n'avez pas passer par un éditeur qui vous fait tout à votre place et à partir de là c'est pareil pour tous en fait, n'importe quelle bibliothèque que vous allez utilisé en programmation, c'est toujours la même chose d'accord il suffit juste de bien mettre dans les bons dossiers et ensuite dans la commande de compilation d'avoir les bons chemins et tout se trouve tout seul.

On met en route avec un petit include pour que ce soit évidemment utilisable, on appelle les bonnes fonctions et ça roule, y a pas besoin de plus que ça.

Voilà pour ce tuto, s'il y a vraiment des problèmes pour quoi que soit, retournez voir le cours très important et si vraiment vous avez un problème directement lié à SDL_image, vous pouvez laisser dans les commentaires de cette vidéo en question pour ne pas mélanger les commentaires dans les différentes vidéos, que tout le monde puisse mieux s'y retrouver y compris pour les autres internautes.

Ainsi, je vous dis à bientôt du coup pour un prochain contenu en SDL et notamment en programmation langage c.

Ciao ciao ciao je disparait