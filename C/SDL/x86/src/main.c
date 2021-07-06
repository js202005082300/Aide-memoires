#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    SDL_version nb;
    SDL_VERSION(&nb);

    printf("Bienvenue sur la SDL %d.%d.%d !\n", nb.major, nb.minor, nb.patch);

    return 0;
}