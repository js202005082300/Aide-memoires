/*
 * 		YouTube: https://www.youtube.com/watch?v=yX05p3FUmEA
 * 		Description: Langage C #24 - création fenêtre
 * 		Created: 07-03-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation:    gcc src/m024.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
 *      Linux:  gcc m024.c -o prog $(SDL2-config --cflags --libs)
 *      Execution:  bin/prog.exe -> syntaxe UNIX(/) du Powershell plutôt que la syntaxe MsDOS(\).
 *      Author:  Samuel Jacquet
 */

/*
    #1# Prototypes fonctions.
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

    #2# Initialisation de la SDL.
        NOM DRAPEAU (FLAG)	            UTILISATION
        SDL_INIT_EVERYTHING	        // Charge tous les systèmes
        SDL_INIT_AUDIO	            // Charge le système audio (son)
        SDL_INIT_VIDEO	            // Charge le système video (affichage) + événements
        SDL_INIT_EVENTS	            // Charge le système d'événements
        SDL_INIT_JOYSTICK	        // Charge le système du joystick + événements
        SDL_INIT_GAMECONTROLLER	    // Charge le système du pad + joystick
        SDL_INIT_HAPTIC	            // Charge le système Haptic (vibrations)
        SDL_INIT_NOPARACHUTE	    // Désactive la gestion des signaux fatals

    #3# Position d'une fenêtre.
        NOM	                        UTILISATION
        SDL_WINDOWPOS_CENTERED	    // Position centrée
        SDL_WINDOWPOS_UNDEFINED	    // Position non définie

    #4# Mode d'affichage d'une fenêtre.
        NOM DRAPEAU (FLAG)	            UTILISATION
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

    #4_bis# D'autres valeurs existent, pour X11 seulement, et à partir des versions 2.0.4 ou 2.0.5 comme :
        SDL_WINDOW_MOUSE_CAPTURE
        SDL_WINDOW_ALWAYS_ON_TOP
        SDL_WINDOW_SKIP_TASKBAR
        SDL_WINDOW_UTILITY
        SDL_WINDOW_TOOLTIP
        SDL_WINDOW_POPUP_MENU
*/

#include <SDL.h> // la case est très importante (majuscule - minuscule).
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) // La SDL vérifie la signature, les arguments de la fonctions main.
{
    /* #0# Initialisation pour la création d'une fenêtre.*/
    SDL_Window *window = NULL; // Passer par un pointeur plutôt que mettre la fonction() dans le if pour la lisibilité. Un pointeur ne prend rien en mémoire, ne pointe sur rien. Pas grave de quitter un programme avec un pointeur.
    /* #1# Initialiser un ou plusieurs paramètres (Allocation dynamique).*/
    //SDL_Init(SDL_INIT_VIDEO);
    /* #2# Vérifier le retour de fonction (0 si tout va bien).*/
    if(SDL_Init(SDL_INIT_VIDEO)!=0)
    {
        SDL_Log("ERREUR : Initialisation SDL > %s\n",SDL_GetError()); // afficher les erreur de la SDL et récupérer ses erreur (SDL_GetError).
        exit(EXIT_FAILURE);
    }
    /* #3# Création d'une fenêtre.*/
    window = SDL_CreateWindow("Titre de la fenêtre",    // Titre de la fenêtre -> codage UTF-8 prend en compte les accents,
                                SDL_WINDOWPOS_CENTERED, // Position fenêtre X -> position initial en haut à gauche (x=y=0) et si l'ecran est full hd x=1920 et y=1080, 
                                SDL_WINDOWPOS_CENTERED, // Position Y -> choix d'un paramètre de position (SDL_WINDOWPOS_CENTERED).
                                800, 600,               // largeur (width), hauteur (height).
                                0);                     // Flag du mode d'affichage, SDL_WINDOW_SHOWN constante/énumération par défaut (visible sans particularité).
    /* #4# Tester le retour de fonction.*/
    if(window == NULL)
    {
        SDL_Log("ERREUR : Creation fenetre echouee > %s\n",SDL_GetError()); 
        exit(EXIT_FAILURE);
    }
    /* #5# Mettre en pause l'exécution de la fenêtre.*/
    SDL_Delay(5000); // 5 sec d'attente. 
    /* #6# Libération de la mémoire (éviter les fuites mémoires).*/
    SDL_Quit();
    return EXIT_SUCCESS; // return 0;
}
