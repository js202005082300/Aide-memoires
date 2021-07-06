/*
 * 		YouTube: https://www.youtube.com/watch?v=Lwx9rSgwoDg
 * 		Description: Langage C #23 - introduction SDL
 * 		Created: 06-03-20 | Revision: --
 * 		Compilater: GNU Compiler - GCC.
 *      Compilation:    gcc src/m023.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
 *                          -> l'édition des liens doit bien se mettre à la fin.
 *      Author:  Samuel Jacquet
 */

/*
    ##Programme graphique en 2D##

    Distinguer 
    -> les programmes fenêtrés, les programme en GUI (= Interface graphique composé de widgets <- menu contextuel, menu déroulant, boutons, champs de textes, etc.).
    -> les programmes graphiques, manipulation d'image de sons, gérer des périphériques comme la souris le clavier, une webcam, etc.

    Télécharger bibliothèques externes à télécharger, configurer et utiliser.
    SDL: Simple DirectMedia Layer
    -> gratuite.
    -> open source (=code accessible, modifiable, adaptable. On peux proposer des mises à jour, voir des correctifs, etc).
    -> utilisable pour un usage commerciale (=licence de la SDL qui permet de créer un jeux vidéo et de le vendre).
    -> bibliothèque écrite en C.
    -> populaire, équivalente en C++, Java, Python.
    -> bibliothèque multiplateforme (Windows, Linux, Android, IOS, console de jeux, etc).

    #1# Installation Windows (32 bits).
    https://www.libsdl.org/download-2.0.php
    Download -> SDL 2.0 -> Development Libraries -> SDL2-devel-2.0.10-mingw.tar.gz
    Open With -> 7 Zip -> Open Archive -> i686-w64-mingw32 -> récupérer bin, include et lib.

    bin 
        -> SDL2.dll -> bibliothèque dynamique (=chargé à l'exécution de notre programme). A l'inverse, une bibliothèque statique (=intégrer à la compilation dans l'exécutable, l'éxéctable sera plus gros). Parfois des bibliothèques à la fois statique et dynamique. La dynamique a l'avantage d'être portable.
        -> sdl2-config -> pas intéressant sur Windows.
    include -> fichiers d'en-tête.
    lib -> fichiers compilés, fichiers objets.
    src -> fichiers sources (*.c).
*/

#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv) // La SDL vérifie la signature, les arguments de la fonctions main.
{
    /* Vérifier si on a bien chargé la SDL.*/
    SDL_version nb;
    SDL_VERSION(&nb);
    printf("Bienvenue sur la SDL %d.%d.%d !\n", nb.major, nb.minor, nb.patch);

    return 0;
}

/*
    #2# Installation Linux/Ubuntu.

    Distribution Debian (Ubuntu, Mint, Elementary) qui utilise les paquets aptitudes (apt-get).
    Le terminal de Linux et MacOS utilise le système de la famille UNIX et donc les commandes sont les mêmes.
    
    sudo apt-get install libsdl2-dev
    cd Bureau/
    nano main.c

    -------------------------------------

    #include <SDL.h>
    #include <stdio.h>
    int main (int argc, char **argv)
    {
        SDL_version nb;
        SDL_VERSION(&nb);
        printf("SDL %d.%d.%d !\n", nb.major, nb.minor, nb.patch);
        return 0;
    }

    -------------------------------------

    ctrl+O
    ctrl+X
    cat main.c
    ls
    gcc main.c -o prog $(SDL2-config --cflags --libs)
    ./prog
*/