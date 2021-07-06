# SDL Configuration 32 bits.

Télécharger les parties **Development Libraries for Windows**

Importer les dossiers suivants dans les projets:

## [SDL2](https://www.libsdl.org/download-2.0.php)

> https://www.libsdl.org/download-2.0.php
> SDL2-devel-2.0.14-mingw.tar.gz
> 32 bits : \SDL2-2.0.14\i686-w64-mingw32
+ \bin
+ \include\SDL2
+ \lib

```
    gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
    #include <SDL.h>
    SDL_LoadBMP("src/rocky4.bmp");
```

## [SDL_image](https://www.libsdl.org/projects/SDL_image/release/SDL2_image-devel-2.0.5-mingw.tar.gz)

> https://www.libsdl.org/projects/SDL_image/release/SDL2_image-devel-2.0.5-mingw.tar.gz
> SDL2_image-devel-2.0.5-mingw.tar.gz (MinGW 32/64-bit)
> 32 bits : \SDL2_image-2.0.5\i686-w64-mingw32
+ \bin *(Nb. on ne tiens pas compte de tout les fichiers .txt)*
+ \include\SDL2
+ \lib

```
    gcc src/*.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2 -lSDL2_image
    #include <SDL_image.h>
    IMG_Load("src/rocky4.jpg");
```

## Dossier projet:

+ bin
+ include
+ lib
+ src