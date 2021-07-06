# [24. Création fenêtre](https://www.youtube.com/watch?v=yX05p3FUmEA)

+ Prototypes fonctions
```c
int SDL_Init(Uint32 flags); 
int SDL_InitSubSystem(Uint32 flags); // Initialiser les ressources plus tard. Retarder l'initialisation d'un autre système pour économiser les ressources.
int SDL_AudioInit(const char* driver_name); 
int SDL_VideoInit(const char* driver_name);

SDL_Window* SDL_CreateWindow(const char* title, int x, int y, int w, int h, Uint32 flags);

void SDL_Quit(void);
void SDL_QuitSubSystem(Uint32 flags);
void SDL_AudioQuit(void); 
void SDL_VideoQuit(void);

void SDL_Log(const char* format); 
const char* SDL_GetError(void);

void SDL_Delay(Uint32 ms);
```
+ Initialisation de la SDL
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_INIT_EVERYTHING	        // Charge tous les systèmes
SDL_INIT_AUDIO	            // Charge le système audio (son)
SDL_INIT_VIDEO	            // Charge le système video (affichage) + événements
SDL_INIT_EVENTS	            // Charge le système d'événements
SDL_INIT_JOYSTICK	        // Charge le système du joystick + événements
SDL_INIT_GAMECONTROLLER	    // Charge le système du pad + joystick
SDL_INIT_HAPTIC	            // Charge le système Haptic (vibrations)
SDL_INIT_NOPARACHUTE	    // Désactive la gestion des signaux fatals
```
+ Position d'une fenêtre
```c
//NOM	                        UTILISATION
SDL_WINDOWPOS_CENTERED	    // Position centrée
SDL_WINDOWPOS_UNDEFINED	    // Position non définie
```
+ Mode d'affichage d'une fenêtre
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_WINDOW_FULLSCREEN	        // Plein écran
SDL_WINDOW_FULLSCREEN_DESKTOP	// Plein écran (selon la résolution du bureau)
SDL_WINDOW_BORDERLESS	        // Sans contours
SDL_WINDOW_MINIMIZED	        // Réduite (minimisée)
SDL_WINDOW_MAXIMIZED	        // Affichée en grand (maximisée)
SDL_WINDOW_SHOWN	            // Affichée (visible)   --> PAR DEFAUT.
SDL_WINDOW_HIDDEN	            // Masquée (invisible)
SDL_WINDOW_RESIZABLE	        // Redimensionnable
SDL_WINDOW_OPENGL	            // Utilisable dans un contexte OpenGL
SDL_WINDOW_INPUT_GRABBED	    // Garde la souris à l'intérieur de la fenêtre
SDL_WINDOW_INPUT_FOCUS	        // Indique l'activité de la fenêtre (depuis entrée)
SDL_WINDOW_MOUSE_FOCUS	        // Indique si la souris survole la fenêtre (active ou non)
SDL_WINDOW_ALLOW_HIGHDPI	    // Mode "High-DPI" (depuis SDL 2.0.1)
SDL_WINDOW_FOREIGN	            // Fenêtre non créée avec la SDL

//D'autres valeurs existent, pour X11 seulement, et à partir des versions 2.0.4 ou 2.0.5 comme :
SDL_WINDOW_MOUSE_CAPTURE
SDL_WINDOW_ALWAYS_ON_TOP
SDL_WINDOW_SKIP_TASKBAR
SDL_WINDOW_UTILITY
SDL_WINDOW_TOOLTIP
SDL_WINDOW_POPUP_MENU
```

>

Salut tout le monde et bienvenu pour cette 24e séance, on est toujours sur la formation au langage c.

La dernière fois on avait fait l'introduction de cette bibliothèque qu'est la sdl qui permet de faire des programmes en 2d donc des programmes graphiques, à l'inverse des programmes fenêtrés qui utilisent un système de widgets, il y a des boutons, des champs de texte, etc.

Dans cette vidéo, on va aller un petit peu plus loin, la dernière fois on avait juste fait l'installation d'un projet, le démarrage d'un projet pour pouvoir obtenir une compilation fonctionnel.

Vous saviez qu'on avait vu ce genre de ligne de commande qui était assez longue pour une windows et beaucoup plus rapide à utiliser sur gnu linux ou macos avec notamment le fichier sdl de config.

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{

    return EXIT_SUCCESS; // 0;
}
```

Alors je reviendrai pas là-dessus d'accord je ferais même un copier coller de la commande puisque j'ai repris exactement le même type de projet, voyez le *bin*, *include*, *lib* et *src* pour windows. Si vous êtes sur linux ou mac, vous faites comme on procédait dans la vidéo précédente et on va pouvoir entamer et démarrer sur de nouvelles choses.

Alors on ne va pas faire grand chose, honnêtement dans cette vidéo on va avoir beaucoup beaucoup de fonctions et beaucoup de notions, il va y avoir pas mal de choses à ingérer pour pas forcément énormément de résultats à la fin mais ça va être très nécessaire pour la suite par rapport à tout ce que nous allons faire dans la suite des vidéos tout simplement.

Alors du coup donc j'ai pris un code par défaut d'accord ça c'est toujours pareil, je vous rappelle qu'on met *SDL.h* tout simplement alors respectez bien les majuscules et les minuscules, ça je le dis souvent en vidéo.

Souvent c'est des erreurs comme ça par rapport à des minuscules et des majuscules qui ne sont pas respectées donc n'oubliez pas qu'en informatique la casse des caractères est très importante.

Alors là nous allons créer puisque avant on avait simplement testé le numéro de la version de la sdl pour l'afficher directement dans le terminal.

Ici nous allons créer notre première fenêtre d'accord véritable fenêtre et pour ça nous avons un certain nombre de fonctions tout simplement.

## Initialisation & Libération

### SDL_Init

La fonction première à connaître, elle est très simple c'est la fonction SDL_Init avec *SDL* en majuscule, avec un underscore et le i majuscule comme ceci.

```c
SDL_Init();
```

Alors elle va prendre un certain nombre de paramètres donc différentes choses qu'il va falloir écrire dedans notamment ce qu'on appelle un drapeau dont elle peut prendre plusieurs drapeaux avec le terme anglais flags qui va en fait contenir des valeurs différentes suivant comment vous allez vouloir initialiser votre fenêtre.

Alors comme c'est des choses qui ne sont pas forcément à retenir par coeur parce qu'il y en a beaucoup surtout si vous démarrez, vous n'allez pas forcément pouvoir les retenir après ça viendra bien évidemment, naturellement, je vous ai fait un petit memento en pdf pour avoir ces différentes informations.

+ Initialisation de la SDL.
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_INIT_EVERYTHING	        // Charge tous les systèmes
SDL_INIT_AUDIO	            // Charge le système audio (son)
SDL_INIT_VIDEO	            // Charge le système video (affichage) + événements
SDL_INIT_EVENTS	            // Charge le système d'événements
SDL_INIT_JOYSTICK	        // Charge le système du joystick + événements
SDL_INIT_GAMECONTROLLER	    // Charge le système du pad + joystick
SDL_INIT_HAPTIC	            // Charge le système Haptic (vibrations)
SDL_INIT_NOPARACHUTE	    // Désactive la gestion des signaux fatals
```

On voit ici que pour l'initialisation de la sdl, vous avez donc les fameux drapeau et leur utilisation donc on en un plus complet qui est *SDL_INIT_EVERYTHING* qui va tout simplement charger tous les systèmes.

Vous voyez qu'il y en a un qui va simplement s'occuper de charger le système audio pour gérer le son *SDL_INIT_AUDIO*, un pour gérer l'affichage *SDL_INIT_VIDEO* donc s'appelle vidéo mais attention ne pensez pas à vidéo genre regarder une vidéo, c'est vraiment tout ce qui est affichage ici donc les images, les surface tout ça.

Alors ça changera également le système d'événements *SDL_INIT_EVENTS* mais ça on en reparlera bien évidemment plus tard dans les autres vidéos. On a tout simplement le chargement seulement des événements, le chargement du système des joystick qui va charger les événements aussi *SDL_INIT_JOYSTICK*.

Charge le système du pad donc *SDL_INIT_GAMECONTROLLER* avec le joystick.

*SDL_INIT_HAPTIC* c'est tout ce qui concerne les vibrations d'une manette par exemple et on a aussi la possibilité de désactiver tout ce qui est signaux fatals *SDL_INIT_NOPARACHUTE* mais ça c'est pareil on ne va pas en parler tout de suite ce n'est pas forcément intéressant à voir maintenant c'est des choses un peu plus compliqué donc voilà pour ces drapeaux là..

On va tout simplement appeler la fonction SDL_Init() et on va lui passer des paramètres ici alors on peut lui en passer un seul par exemple je peux juste passé audio *SDL_INIT_AUDIO*, ensuite je pourrais lui en passer plusieurs ou alors si je veux tout changer d'un coup je peux directement lui passer celui là *SDL_INIT_EVERYTHING* donc nous comme on va charger quelque chose par défaut on va prendre celui là *SDL_INIT_VIDEO* que je mets comme ceci.

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    SDL_Init(SDL_INIT_VIDEO);

    return EXIT_SUCCESS; // return 0;
}
```

Si on voulait en mettre plusieurs admettons qu'on voulait mettre *SDL_INIT_AUDIO* également, il suffirait et de les séparer avec une barre verticale **|** donc c'est la touche alt gr suffit de la touche du 1 de votre clavier pas le pavé numérique mais simplement du clavier et là vous mettez tout simplement *SDL_INIT_AUDIO*.

```c
SDL_Init(SDL_INIT_VIDEO | SDL_INIT_AUDIO);
```

Comme ceci et vous pouvez en mettre plusieurs comme ça la suite mais évidemment si vous finissez par tous les mettre autant mais *SDL_INIT_EVERYTHING* ça ira beaucoup plus vite.

Voilà donc nous on va juste se contenter de mettre *SDL_INIT_VIDEO*.

```c
SDL_Init(SDL_INIT_VIDEO);
```

ET pour faire les choses proprement puisque là on attaque de la programmation avancée, on n'est plus dans la programmation basique, on va toujours vérifier les retours des fonctions quand c'est nécessaire pour être sûr que tout fonctionne correctement.

Il ne s'agit pas d'appeler des fonctions et de croiser les doigts pour qu'elles fonctionnent et qu'elle ait chargée ce qu'il faut; Non on va toujours vérifier les retours pour être sûr ça a bien marché.

SDL_Init() si tout va bien, elle va renvoyer 0 tout simplement telle qu'elle est définie dans la [documentation officielle de la sdl](https://www.libsdl.org/release/SDL-1.2.15/docs/html/sdlinit.html) sinon elle va retourner un autre nombre.

Elle peut retourner *-1*, elle peut retourner autre chose que *0* donc nous la vérification doit être simple on va tout simplement vérifier si le retour de SDL_Init(SDL_INIT_VIDEO) est différent de 0 c'est qu'il y a eu un problème.

```c
if(SDL_Init(SDL_INIT_VIDEO) != 0)
{

}
```

### SDL_Log & SdlGetError

Moi je fais quelque chose de très générales comme ça voilà si c'est égal à zéro c'est qu'il y a eu un problème.

Ensuite gérer l'erreur d'accord on ne va pas rester comme ça, on ne va pas continuer le programme mais on va gérer l'erreur.

Et pour ça on va utiliser deux fonctions très simple, je dis qu'on va voir pas mal de petites fonctions...

La première va simplement se charger d'afficher un message sous forme de log.

Un log c'est en général un fichier qu'on peut utiliser pour afficher plusieurs messages d'erreur ou des messages d'avertissement, notification aux développeurs ou par exemple pour vérifier que quelque chose a bien fonctionné ou non, ça s'utilise pas mal sur les serveurs en web, ce genre de choses.

Ici on n'aura pas de fichier c'est simplement une fonction qui va nous afficher le message d'erreur donc plutôt que de faire ça dans un printf() ou dans un fprintf(), on va directement utiliser les fonctions de la SDL puisqu'elles sont là pour ça donc SDL_Log() est très simple, elle va simplement prendre un texte d'accord elle renvoie rien, elle prend juste un texte en paramètre donc on va faire SDL_Log() et écrire par exemple *ERREUR : Initialisation SDL > %s* et je vais lui passer *%s* et envoyer un message donc une chaîne de caractère qui va en fait être le retour d'une autre fonction.

```c
if(SDL_Init(SDL_INIT_VIDEO) != 0)
{
    SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
}
```

Quand il y a une erreur qui se produit avec la sdl, il y a une fonction qui va la récupérer d'accord un peu comme un système d'exceptions qui est la fonction SdlGetError() qui va permettre de renvoyer un message par rapport à une erreur qui a pu survenir donc là dans le cadre de la condition que j'ai ici, si ces différentes 0 c'est que j'ai eu une erreur du coup le *%s* je lui affecte le retour de SDL_GetError() donc voyez il y a des majuscules, des minuscules faut vraiment les respecter d'accord.

SDL_GetError() tout en majuscule c'est vraiment important de respecter ça et là je quitte parce que s'il y avait un problème, je ne continue pas le programme et je fais un EXIT_FAILURE comme on fait habituellement, pas de surprise.

```c
if(SDL_Init(SDL_INIT_VIDEO) != 0)
{
    SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
    exit(EXIT_FAILURE);
}
```

Voilà donc si l'initialisation ne fonctionne pas d'accord a échoué on affiche le message d'erreur ici avec le retour de SDL_GetError() et on quitte le programme tout simplement on ne va pas plus loin.

Alors ça c'est la base d'accord c'est la toute première partie, on initialise la sdl.

### SDL_Quit

Une fois qu'elle est initialisée bien évidemment il va falloir la quitter donc je vais directement le faire maintenant pour ne pas l'oublier en fait par la suite c'est une  fonction très simple qui s'appelle SDL_Quit() tout simplement donc elle ne renvoie rien et elle ne prend rien au paramètre, elle est vraiment très simple.

```c
SDL_Quit();
```

On met SDL et Q en majuscule aussi comme ceci et entre les deux un underscore, on va pouvoir faire notre programme d'accord où on met l'exécution du programme ici. 

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    //Execution du programme...

    SDL_Quit();

    return EXIT_SUCCESS; // return 0;
}
```

Ainsi initialisation avec vérification et le fait de tout quitter.

Pourquoi on fait ces deux choses-là ? là bas c'est comme pour tout ce que vous avez vu sur l'allocation dynamique.

L'initialisation de la sdl, elle va s'occuper d'allouer dynamiquement en mémoire plusieurs données évidemment puisque l'ordinateur ne sait pas ce que c'est de manipuler de la 2d, tout ça. Lui à part quelques nombre et faire quelques calculs basiques c'est tout ce qu'il sait faire donc il va faire des allocations dynamiques évidemment et du coup il faut libérer cette mémoire là sinon elle va fuiter et donc vous aurez comme ça des fuites mémoires donc il est vraiment important et primordial de penser à libérer les ressources avec cette fonction-là, SDL_Quit() en fin de programme tout simplement.

Voilà donc ça c'est vraiment la base, après il faut savoir que vous pouvez initialiser d'autres manières d'accord il y a d'autres manières d'initialiser votre programme là je viens d'initialiser la vidéo.

Admettons que plus tard je veux initialiser un autre système par exemple l'audio je peux le faire plus tard sans problème grâce à une autre fonction et je vous en ai montré d'ailleurs quelques unes ici donc on verra un petit peu pour la suite voilà.

Je vous en ai mis ici dans ce petit mémento.

> [Memento SDL](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C/memento-sdl.md)

Je vous les montre en fait en note, je ne veut pas forcément les écrire dans le code parce que ça va rallonger la vidéo pour rien alors que c'est très simple.

### Sous-système

Et donc pour initialiser un autre système, c'est la fonction:
```c
int SDL_InitSubSystem(Uint32 flags);
```
Comme vous le voyez, elle va faire comme pour SDL_Init(Uint32 flags) sauf qu'elle va chercher un sous-système donc je vais l'utiliser exactement pareil donc à un moment donné je vais faire dans mon code l'initialisation d'un sous-système et par exemple pour l'audio, comme ça je peux en fait *retarder l'initialisation* d'un autre système.

L'avantage c'est que ça permet d'économiser les ressources, par exemple vous n'avez pas besoin tout de suite de la gestion du son c'est pas forcément utile de le charger en tout début de programme.

Vous pouvez éventuellement le charger au moment où vous en avez besoin et pourquoi pas le libérer quand le programme ne l'utilise plus comme ça vous économisez complètement les ressources, vous êtes un peu plus flexible à ce niveau là.

On a du coup la fonction équivalente pour quitter:
```c
void SDL_QuitSubSystem(Uint32 flags);
```
Le SDL_QuitSubSystem(Uint32 flags) qui va fonctionner pareil et qui prendra en paramètre bien évidemment le flag donc le flag du système que vous avez initialisé.

### Récapitulation et initialisation

Je rappelle ce sont ça les drapeaux en question.

+ Initialisation de la SDL.
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_INIT_EVERYTHING	        // Charge tous les systèmes
SDL_INIT_AUDIO	            // Charge le système audio (son)
SDL_INIT_VIDEO	            // Charge le système video (affichage) + événements
SDL_INIT_EVENTS	            // Charge le système d'événements
SDL_INIT_JOYSTICK	        // Charge le système du joystick + événements
SDL_INIT_GAMECONTROLLER	    // Charge le système du pad + joystick
SDL_INIT_HAPTIC	            // Charge le système Haptic (vibrations)
SDL_INIT_NOPARACHUTE	    // Désactive la gestion des signaux fatals
```

> [Memento SDL](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C/memento-sdl.md)

Ce sont ceux-là les drapeaux et on peut également comme vous avez dû le voir rapidement, juste initialiser l'audio avec SDL_AudioInit() ou la vidéo avec SDL_VideoInit() et ici on peut leur passer un paramètre *NULL* éventuellement ou alors un paramètre précis *const char* driver_name* mais là on va rentrer dans des choses plus complexes donc là je vais  très vite et je vous montre même pas de code parce que c'est pas forcément utile. Si à un moment on a besoin de le faire dans le code je vous montrerai dans une vidéo mais là tout de suite je vous en parle juste mais sachez qu'on peut le faire.

Si un jour vous voyez dans un code, que vous récupérez sur internet admettons sachez qu'il est possible juste d'initialiser l'audio comme ceci ou la vidéo avec cette fonction.

```c
int SDL_AudioInit(const char* driver_name);
int SDL_VideoInit(const char* driver_name);

void SDL_AudioQuit(void);
void SDL_VideoQuit(void);
```

Par contre si ça a été initialisé avec l'une de ces deux fonctions, il faut utiliser la fonction de libération adéquate.

Si on a utilisé SDL_AudioInit() il faut utiliser SDL_AudioQuit() absolument et pour SDL_VideoInit() c'est SDL_VideoQuit() sinon il y a des choses qui ne se passeront pas bien.

Voyez grosso modo on a quatre fonctions d'initialisation qui sont courantes et on en a quatre pour libérer la mémoire.

```c
int SDL_Init(Uint32 flags);
int SDL_InitSubSystem(Uint32 flags);
int SDL_AudioInit(const char* driver_name);
int SDL_VideoInit(const char* driver_name);

void SDL_Quit(void);
void SDL_QuitSubSystem(Uint32 flags);
void SDL_AudioQuit(void);
void SDL_VideoQuit(void);
```

Nous pour la vidéo et dans pas mal d'autres séances, on se contentera de la fonction SDL_Init() standard et la fonction SDL_Quit() standard aussi d'accord c'est plus pour votre connaissance personnelle, pour votre culture générale ou si un jour vous tombez sur un code qui utilise ces autres fonctions.

Voilà pour l'initialisation, la libération j'ai fait le tour.

Je ne vais pas m'attarder un petit peu plus là dessus, vous savez comment afficher des erreurs et comment récupérer les erreurs de la sdl.

```c
if(SDL_Init(SDL_INIT_VIDEO) != 0)
{
    SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
    exit(EXIT_FAILURE);
}
```

## Afficher une fenêtre

### SDL_Window

Et donc maintenant bas nous allons afficher une première fenêtre parce que c'est un petit peu le but de cette vidéo donc là on a vu grosso modo tout ce qui était comme ça rapide à voir pour une utilisation et la libération de mémoire.

On va voir une seule fonction, une dernière fonction pour la création de cette fenêtre déjà donc ça c'est plus par habitude avec le c puisque à l'époque il fallait faire comme ça on déclarait les variables en tout début de fonction donc je vais déclarer une variable `SDL_Window * window = NULL;` (pas Windows avec s, le système d'exploitation) donc comme c'est un pointeur, je le déclare à *NULL* par défaut donc je trouve que c'est bien de procéder comme ça parce qu'on voit d'accord l'existence de se pointeur et du coup on voit la valeur qu'on lui affecte par défaut.

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    SDL_Window *window = NULL;
    
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    //Execution du programme...

    SDL_Quit();

    return EXIT_SUCCESS; // return 0;
}
```

Je trouve qu'au niveau lisibilité c'est beaucoup plus clair quand on voit comme ça, on voit que dès le départ on part avec un pointeur *NULL* et ici ce pointer on va en faire quelque chose.

### SDL_CreateWindow

On va lui affecter une fenêtre donc la création d'une fenêtre donc je vais utiliser `window = SDL_CreateWindow();` voilà.

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    SDL_Window *window = NULL;
    
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    //Execution du programme...
    window = SDL_CreateWindow();

    SDL_Quit();

    return EXIT_SUCCESS; // return 0;
}
```

Cette fonction `window = SDL_CreateWindow();` évidemment vous l'avez compris, elle va permettre de créer notre fenêtre.

Elle prend plusieurs paramètres.

Le premier c'est le titre de la fenêtre, celui qui va s'afficher sur le haut de la fenêtre et gros avantage ici c'est encodé en utf-8 c'est-à-dire tout simplement qu'on va pouvoir afficher des accents donc ça c'est vraiment sympa parce qu'autant le terminal on ne peut pas mettre des accents dedans quand on affichait par exemple le contenu dans un printf() mais par contre ici on va pouvoir donc là moi je met "Première fenêtre SDL 2" et voyez je mets exprès des accents donc ça c'est le premier argument.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", );
```

Le deuxième ça va être la position en x de la fenêtre donc qu'est ce que la position x et après la position y, hé bien c'est par rapport à ce point là tout en haut à gauche de mon écran.

```
    (0,0)
    +---------------+
    |               |
    |               |
    |               |
    |               |
    +---------------+
```

Ici vous pouvez considérer imaginer un graphique d'accord avec une abscisse et une ordonnée là c'est le point 0, 0.

Voyez que là mon curseur là il est tout en haut à gauche de l'écran, c'est le point de coordonnées x qui égale à zéro et y égal à zéro.

Comme c'est un écran en full hd donc 1920x1080, le x maximum il est là.

```
    (0,0)
    +---------------+ x max (1920)
    |               |
    |               |
    |               |
    |               |
    +---------------+
    y max (1080)
```

C'est pour ça qu'on parle de résolution 1920x1080 donc full hd.

Par rapport à ça, vous pouvez détailler et préciser la position en x et y de votre fenêtre donc ce sera la position du point en haut à gauche de votre fenêtre tout simplement.

On va déterminer la position de la fenêtre sur notre écran pour son affichage.

```
    (0,0)
    +---------------+ x max (1920)
    |   +-------+   |
    |   | SDL   |   |
    |   |       |   |
    |   +-------+   |
    +---------------+
    y max (1080)
```

Sinon on peut procéder à des manières beaucoup plus flexible plutôt que d'avoir des valeurs précises ici, on peut utiliser certains autres flag pour le x et y notamment ceux là.

+ Position d'une fenêtre.
```c
//NOM	                        UTILISATION
SDL_WINDOWPOS_CENTERED	    // Position centrée
SDL_WINDOWPOS_UNDEFINED	    // Position non définie
```

Le premier ici qui va permettre de centrer automatiquement la position et celui-là bas qui tout simplement dit que la position est non définie donc elle peut éventuellement être définies par rapport à la configuration de votre os, où est-ce qu'il a positionné les anciennes fenêtres que vous aviez pu ouvrir donc en général j'utilise *SDL_WINDOWPOS_CENTERED* si je veux pouvoir une fenêtre centrée.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, ...);
```

Ensuite par habitude c'est vrai qu'on l'est mets comme ça aussi parce que ce sera plus clair parce que vous allez voir qu'il y a beaucoup de paramètres donc c'est bien de les mettre éventuellement à la ligne.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, ...
);
```

Voilà voilà pour celui là donc ça c'est pour x.

Ensuite c'est pour y donc ça va être la même chose d'accord donc y je le met ici pareil même chose.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, ...
);
```

Ensuite on va avoir la taille donc la largeur et la hauteur de la fenêtre donc le w ce qui correspond à ce que j'ai mis dans le prototype ici.

```c
SDL_Window* SDL_CreateWindow(const char* title, int x, int y, int w, int h, Uint32 flags);
```

w et h, width et height pour la largeur et la hauteur de la fenêtre donc ça bah c'est la taille tout simplement de la fenêtre en pixels.

Si je veux une fenêtre par exemple de 800 x 600 pixels, je vais noter 800 et pour la hauteur 600 tout simplement.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, ...
);
```

Et en dernier argument, je vais avoir une liste de flag donc soit donc de drapeaux, soit un seul soit plusieurs comme on avait vu pour *SDL_Init* ici qui vont permettre de gérer le mode d'affichage de la fenêtre.

+ Mode d'affichage d'une fenêtre.
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_WINDOW_FULLSCREEN	        // Plein écran
SDL_WINDOW_FULLSCREEN_DESKTOP	// Plein écran (selon la résolution du bureau)
SDL_WINDOW_BORDERLESS	        // Sans contours
SDL_WINDOW_MINIMIZED	        // Réduite (minimisée)
SDL_WINDOW_MAXIMIZED	        // Affichée en grand (maximisée)
SDL_WINDOW_SHOWN	            // Affichée (visible)   --> PAR DEFAUT.
SDL_WINDOW_HIDDEN	            // Masquée (invisible)
SDL_WINDOW_RESIZABLE	        // Redimensionnable
SDL_WINDOW_OPENGL	            // Utilisable dans un contexte OpenGL
SDL_WINDOW_INPUT_GRABBED	    // Garde la souris à l'intérieur de la fenêtre
SDL_WINDOW_INPUT_FOCUS	        // Indique l'activité de la fenêtre (depuis entrée)
SDL_WINDOW_MOUSE_FOCUS	        // Indique si la souris survole la fenêtre (active ou non)
SDL_WINDOW_ALLOW_HIGHDPI	    // Mode "High-DPI" (depuis SDL 2.0.1)
SDL_WINDOW_FOREIGN	            // Fenêtre non créée avec la SDL
```

Donc je passe très vite je pense que le pdf est suffisamment explicite, vous pouvez afficher en plein écran *SDL_WINDOW_FULLSCREEN*, plein écran selon la résolution de bureau *SDL_WINDOW_FULLSCREEN_DESKTOP*, sans contour *SDL_WINDOW_BORDERLESS*, une fenêtre directement réduite c'est-à-dire qu'elle apparaît dans la barre d'outils, la barre des fenêtres mais elle n'est pas affiché par défaut.

*SDL_WINDOW_MAXIMIZED* pour maximiser c'est tout simplement qu'elle occupe tout l'écran sinon elle est flottante.

Voilà donc selon les différentes modes, vous pouvez l'afficher par défaut, masquer, redimensionnable, etc.

*SDL_WINDOW_OPENGL*, opengl on ne s'y intéresse pas c'est surtout qu'on travaille après pour de la 3D mais je vous le note quand même pour ceux qui sont currieux.

Alors il y a pas mal d'autres informations ici.

```c
//D'autres valeurs existent, pour X11 seulement, et à partir des versions 2.0.4 ou 2.0.5 comme :
SDL_WINDOW_MOUSE_CAPTURE
SDL_WINDOW_ALWAYS_ON_TOP
SDL_WINDOW_SKIP_TASKBAR
SDL_WINDOW_UTILITY
SDL_WINDOW_TOOLTIP
SDL_WINDOW_POPUP_MENU
```

Voilà d'autres là qui sont assez récents notamment depuis la version 2.0.4 de la sdl qui fonctionne avec le moteur graphique X11 tout simplement donc c'est un moteur de fenêtre qu'on retrouve beaucoup sur linux et que certains connaissent sûrement et qui permet donc de manipuler les fenêtres dans d'autres modes mais je passe très très vite là dessus d'accord.

Nous principalement on va travailler beaucoup, pourquoi pas en fullscreen ça peut arriver ou simplement par défaut comme ceci *SDL_WINDOW_SHOWN* et comme de toute manière il est prit par défaut on pourra même se contenter de mettre zéro puisque c'est un entier qui est attendu ou alors une constante comme ici d'accord qui correspond à un entier donc comme une énumération mais là on peut très bien mettre zéro par défaut.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600,
                            0);
```

On met `0` parce qu'en fait je ne veux rien spécifier de particulier, je ne veux pas qu'elle soit en plein écran ou autre.

Voilà je veux que la fenêtre soit gérée par défaut donc je mets 0 d'ailleurs je peux mettre directement à la suite, pas la peine de faire 15.000 lignes.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);
```

Voilà donc je récapitule pour SDL_CreateWindow(), on met le titre de la fenêtre, la position x, la position y, la largeur, la hauteur et le mode d'affichage donc très simple.

Il y a beaucoup de paramètres mais c'est très simple à gérer et évidemment comme vous l'avez vu c'est un pointeur à la base comme tout affectation pour un pointeur, comme pour une allocation puisque de l'allocation va se passer, ce sera libéré la fenêtre avec SDL_Quit() tout simplement qui fera appel à plein d'autres fonctions pour faire de la libération de la mémoire donc on vérifie bien sûr que notre pointeur n'est pas égale à nulle.

```c
if(window == NULL)
{
    SDL_Log("ERREUR : Creation fenetre echouee > %\n", SDL_GetError());
    exit(EXIT_FAILURE);
}
```

Voilà puisque si il est égale à nulle comme d'habitude je vous rappelle qu'on ne continue pas dont l'erreur est *Creation fenetre echouee*.

Voilà pareil je récupère le résultat de SDL_GetError() et je quitte le programme surtout parce que la fenêtre n'a pas pu être créé pour une raison x ou y voilà et normalement si j'ai pas fait de bêtises, on a tout ce qu'il faut donc on va tester et vous allez observer quelque chose.

## Compilation & exécution

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    SDL_Window *window = NULL;
    
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    //Execution du programme...
    window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);

    if(window == NULL)
    {
        SDL_Log("ERREUR : Creation fenetre echouee > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    SDL_Quit();

    return EXIT_SUCCESS; // return 0;
}
```
```powershell
gcc src/m024.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
./bin/prog.exe
```

Alors si je mets des slash plutôt des anti-slash sage c'est normal je suis sur un terminal powershell donc powershell a adopté la syntaxe unix pour changer un petit peu de la syntaxe **ms dos** où il y avait que des anti-slash notamment et voilà si je fais *tab* voyez ça change automatiquement en faisant un tabulation.

```powershell
./bin/prog.exe
.\bin\prog.exe
```

Et on exécute et là vous voyez que ça ouvert une fenêtre rapidement.

Je peux vous montrer et la fenêtre s'est refermée tout de suite, pourquoi tout simplement parce que la fenêtre a été créée mais derrière elle a été détruite parce que j'ai libéré la mémoire.

### SDL_Delay

Voilà il n'y a pas eu de boucle infinie ou autre donc du coup vous n'avez pas eu le temps de le voir donc pour ça en général quand on fait des tests on utilise une fonction précise de la SDL puisque elle est intégrée dedans pour mettre en pause l'exécution de la fenêtre, c'est la fonction SDL_Delay() donc elle est vraiment très simple.

```c
SDL_Delay();
```

SDL_Delay() prend en paramètre un nombre donc un entier en millisecondes donc je vous rappelle que pour faire une seconde d'attente vous devez mettre 1000 donc nous on va faire cinq secondes d'attentes donc on va mettre 5000 et là on recompile et on réexécute et vous allez voir que vous allez avoir le temps de voir la fenêtre s'afficher.

```c
#include <SDL.h>
#include <stdio.h>
#include <stdlib.h>
/*
Rappels de compilation
> Windows  : gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
> GNU/Linux, MacOS  : gcc main.c $sdl2-config --cflags --libs) -o prog
*/
int main(int argc, char**argv)
{
    SDL_Window *window = NULL;
    
    if(SDL_Init(SDL_INIT_VIDEO) != 0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    //Execution du programme...
    window = SDL_CreateWindow("Première fenêtre SDL 2", 
                            SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, 0);
    
    if(window == NULL)
    {
        SDL_Log("ERREUR : Creation fenetre echouee > %\n", SDL_GetError());
        exit(EXIT_FAILURE);
    }

    SDL_Delay(5000);

    SDL_Quit();

    return EXIT_SUCCESS; // return 0;
}
```
```powershell
gcc src/m024.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
./bin/prog.exe
```

Voilà donc on a bien le titre avec voyez les accents, pas de problème et au bout de cinq secondes la fenêtre se ferme voilà donc vous venez de réaliser votre première fenêtre en SDL2 et de manière propre surtout encore une fois.

Voyez que pour chaque fonction de la sdl que ce soit l'initialisation, la création de la fenêtre est vérifiée.

On vérifie toujours le retour pour être sûr ça fonctionne bien alors là on l'a mis dans une variable à part parce qu'on aura besoin éventuellement de la réutiliser plus tard sinon on aurait pu faire comme pour SDL_Init() également là, le mettre directement dans le if().

```c
if(window = SDL_CreateWindow(...) == NULL){}
```

Voilà ça ferait du coup quelque chose qui n'est pas lisible  honnêtement mais vous pourriez tout mettre dans le if() hélas pour des questions de lisibilité, je trouve que c'est mieux de procéder comme ça c'est-à-dire de faire la création de la fenêtre et après toute façon comme c'est qu'un pointer honnêtement en mémoire ça vous prendra pratiquement rien en taille, en espace mémoire donc c'est pas gênant.

C'est comme ici `SDL_Window *window = NULL;`, j'ai créé un pointeur null mais c'est pas un soucis au niveau de la mémoire même si par exemple au final l'initialisation ne marche pas et que vous quittez le programme.

Ne vous en faites pas, c'est pas de la mémoire utilisée pour rien, ce sont des pointeurs donc il n'y a pas de problème par défaut un pointeur c'est rien tant qu'il ne pointe sur rien, c'est rien !

Honnêtement c'est aussi simple que ça.

Voilà pour la création des fenêtres je pense que j'ai fait le tour de tout ce que je voulais vous montrer-là.

On peut éventuellement s'amuser avec d'autres modes pour voir comment ça fonctionne pour voir un petit peu la différence.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, SDL_WINDOW_FULLSCREEN);
```

Ou bien avec *SDL_WINDOW_MINIMIZED*.

```c
window = SDL_CreateWindow("Première fenêtre SDL 2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 800, 600, SDL_WINDOW_MINIMIZED);
```

Voyez la fenêtre est minimiser par défaut et avec le reste du code comme j'ai pas trop d'évennement chargé ou autre donc je la met en pause mais plutard on ne s'ammusera pas à mettre en pause comme ça l'exécution, on va faire une boucle infinie tout simplement c'est comme ça qu'on procède et on va comme ça pouvoir attendre de faire des événements sur la fenêtre donc des clics, afficher des choses, faire des animations, tout ça.

C'est comme ça que fonctionnent les programmes en 2d donc avec des graphiques avec donc des surfaces, avec des sprites, avec des images, ce genre de chose, plus tard de la gestion du son et autres et en attendant on en restera là puisqu'on en a déjà vu pas mal.

## Memento 

Je fais un petit retour complet sur le pdf qui sera disponible du coup dans la description de la vidéo en téléchargement comme d'habitude vous savez comment ça se passe.

> [Memento SDL](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C/memento-sdl.md)

Donc je vous ai fait un rappel des prototypes de fonctions qu'on verra donc au fur et à mesure de la sdl.

Je compléterai ce pdf au fur et à mesure si nécessaire donc voilà on a fait le tour de tout : les quatre initialisation, la création de fenêtres, les quatres moyens de libérer à mémoire, SDL_Log(), SDL_GetError() et la petite fonction de pause SDL_Delay() qui est très utile aussi.

+ Prototypes fonctions.
```c
int SDL_Init(Uint32 flags); 
int SDL_InitSubSystem(Uint32 flags); // Initialiser les ressources plus tard. Retarder l'initialisation d'un autre système pour économiser les ressources.
int SDL_AudioInit(const char* driver_name); 
int SDL_VideoInit(const char* driver_name);

SDL_Window* SDL_CreateWindow(const char* title, int x, int y, int w, int h, Uint32 flags);

void SDL_Quit(void);
void SDL_QuitSubSystem(Uint32 flags);
void SDL_AudioQuit(void); 
void SDL_VideoQuit(void);

void SDL_Log(const char* format); 
const char* SDL_GetError(void);

void SDL_Delay(Uint32 ms);
```

Les drapeaux, les flags pour tout ce qui est initialisation pour la SDL.

+ Initialisation de la SDL.
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_INIT_EVERYTHING	        // Charge tous les systèmes
SDL_INIT_AUDIO	            // Charge le système audio (son)
SDL_INIT_VIDEO	            // Charge le système video (affichage) + événements
SDL_INIT_EVENTS	            // Charge le système d'événements
SDL_INIT_JOYSTICK	        // Charge le système du joystick + événements
SDL_INIT_GAMECONTROLLER	    // Charge le système du pad + joystick
SDL_INIT_HAPTIC	            // Charge le système Haptic (vibrations)
SDL_INIT_NOPARACHUTE	    // Désactive la gestion des signaux fatals
```

Les flags pour la position d'une fenêtre.

+ Position d'une fenêtre.
```c
//NOM	                        UTILISATION
SDL_WINDOWPOS_CENTERED	    // Position centrée
SDL_WINDOWPOS_UNDEFINED	    // Position non définie
```

Enfin les flags pour le mode d'affichage.

+ Mode d'affichage d'une fenêtre.
```c
//NOM DRAPEAU (FLAG)	            UTILISATION
SDL_WINDOW_FULLSCREEN	        // Plein écran
SDL_WINDOW_FULLSCREEN_DESKTOP	// Plein écran (selon la résolution du bureau)
SDL_WINDOW_BORDERLESS	        // Sans contours
SDL_WINDOW_MINIMIZED	        // Réduite (minimisée)
SDL_WINDOW_MAXIMIZED	        // Affichée en grand (maximisée)
SDL_WINDOW_SHOWN	            // Affichée (visible)   --> PAR DEFAUT.
SDL_WINDOW_HIDDEN	            // Masquée (invisible)
SDL_WINDOW_RESIZABLE	        // Redimensionnable
SDL_WINDOW_OPENGL	            // Utilisable dans un contexte OpenGL
SDL_WINDOW_INPUT_GRABBED	    // Garde la souris à l'intérieur de la fenêtre
SDL_WINDOW_INPUT_FOCUS	        // Indique l'activité de la fenêtre (depuis entrée)
SDL_WINDOW_MOUSE_FOCUS	        // Indique si la souris survole la fenêtre (active ou non)
SDL_WINDOW_ALLOW_HIGHDPI	    // Mode "High-DPI" (depuis SDL 2.0.1)
SDL_WINDOW_FOREIGN	            // Fenêtre non créée avec la SDL

//D'autres valeurs existent, pour X11 seulement, et à partir des versions 2.0.4 ou 2.0.5 comme :
SDL_WINDOW_MOUSE_CAPTURE
SDL_WINDOW_ALWAYS_ON_TOP
SDL_WINDOW_SKIP_TASKBAR
SDL_WINDOW_UTILITY
SDL_WINDOW_TOOLTIP
SDL_WINDOW_POPUP_MENU
```

Voilà donc ça pour les petits curieux si vous voulez tester certaines choses, amusez-vous c'est bien de tester pour comprendre même si le code est relativement simple c'est surtout qu'il y a beaucoup de fonctions à voir d'un coup mais elles sont nécessaires comme vous le voyez ici, il n'y a rien qui est de trop en fait parce que tout ce qu'on a vu là est nécessaire surtout pour ce que nous verrons dans les prochaines séances.

Moi je vous dis à bientôt j'espère que ça vous a plu.

Si vous avez des questions, des commentaires, des remarques, quoi que ce soit n'hésitez pas parce que là on entame vraiment un gros chapitre de cette formation en langage c qui est un peu plus complexe.

On avait déjà des choses assez complexe mais moins peut-être que les structures de données et je pense que ça vous semblera beaucoup moins compliqué que les structures de données qu'on a vu avant par contre c'est évidemment beaucoup plus complexe que les simples notions natives du langage c puisque là on utilise une bibliothèque externe donc si vous avez des questions n'hésitez pas j'y répondrais avec plaisir.

Et bientôt tout le monde, on se retrouvera pour la prochaine vidéo, pour la séance 25.

Ciao