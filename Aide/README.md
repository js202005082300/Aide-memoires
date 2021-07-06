# [Aide](https://www.youtube.com/playlist?list=PLrSOXFDHBtfEwFMZ1YIXgUqOFODGyo7tB)

:label: [FormationVidéo](https://github.com/jasonchampagne/FormationVideo) - [Ressource Aide](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide)

## [Notes d'aide](README.md)
:label: [Playlist Aide](https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/aide.md)

+ [_gcc_](gcc.md) [:memo:](#gcc)
+ [_Bien coder_](bien_coder.md)
+ [_Choisir langage_](choisir_langage.md)
+ [_Emmet_](emmet.md)
+ [_FFmpeg_](FFmpeg.md)
+ [_Git_](Git.md)
+ [_Hébergement_](h%C3%A9berger.md)
+ [_ImageMagick_](ImageMagick.md)
+ [_Inno Setup_](Inno_Setup.md)
+ [_KeePass_](KeePass.md)
+ [_Makefile_](Makefile.md)
+ [_POO_](poo.md)
+ [_Rufus_](Rufus.md)
+ [_Ventoy_](Ventoy.md)
+ [_VScode_](VS_Code.md)

---

## [gcc](gcc.md)
### [Partie 1 - Les étapes de compilation](gcc.md#partie-1)
+ [1e étape : preprocessing](gcc.md#1e-preprocessing)
```powershell
gcc *.c -o prog
gcc -E other.c -o other.i # l'option -E décompose les étapes de prétraitement et l'option -o pour enregistrer le résultat dans un fichier de sortie.
```
+ [2e étape : compiling](gcc.md#2e-compiling)
```powershell
gcc -S main.c # compilation en langage assembleur vers un fichier point s.
```
+ [3e étape : assembling](gcc.md#3e-assembling)
```powershell
gcc -c main.c # assemblage des étapes 1 et 2 en fichier point o.
gcc -c other.c
```
+ [4e étape : linking](gcc.md#4e-linking)
```powershell
gcc main.o other.o -o prog # fusionner les fichiers objets.
as --version # gas, assembleur du projet GNU.
ld --version # éditeur de liens.
```

### [Partie 2 - Les bonnes habitudes à prendre !](gcc.md#partie-2)
```powershell
gcc main.c other.c -o # retourne un fichier a point o.
gcc main.c other.c -o prog
gcc *.c -o prog
```
+ [Wall](gcc.md#wall)
```powershell
gcc -Wall *.c -o prog # l'option -Wall active les avertissements.
```
+ [Wextra](gcc.md#wextra)
```powershell
gcc -Wall -Wextra *.c -o prog # l'option -Wextra active des avertissements supplémentaires.
```
+ [Werror](gcc.md#werror)
```powershell
gcc -Wall -Wextra -Werror *.c -o prog # l'option Werror transforme tous les avertissements en erreur.
```
+ [Normes](gcc.md#normes)
```powershell
gcc -Wall -Wextra -Werror *.c -o prog # standard par défaut (c90 !).
gcc -Wall -Wextra -Werror -ansi *.c -o prog
gcc -Wall -Wextra -Werror -std=c11 *.c -o prog
```
+ [Pedantic](gcc.md#pedantic)
```powershell
gcc -Wall -Wextra -Werror -std=c11 -pedantic *.c -o prog # l'option pedantic crée des avertissements lié à une norme et qui empêche des fonctionnalités issues d'extensions.
gcc -Wall -Wextra -Werror -std=c11 -pedantic-errors *.c -o prog
```
+ [w](gcc.md#w)
```powershell
# l'option w ignore les avertissement.
```
+ [Optimisation](gcc.md#optimisation)
```powershell
gcc -O *.c -o prog # optimise la taille du code (niv 0).
gcc -O0 *.c -o prog
gcc -O1 *.c -o prog # optimisisation (niv 1).
gcc -O3 *.c -o prog # optimisisation (niv 3).
```
+ [os](gcc.md#os)
```powershell
gcc -O2 *.c -o prog # optimisisation (niv 2).
gcc -Os *.c -o prog # optimisisation (niv 2).
```
+ [I](gcc.md#I)
```powershell
# l'option -I permet d'inclure des fichiers d'en-tête mais qui ne sont pas issus de la biblio standard.
```
+ [l](gcc.md#l)
```powershell
# l'option l permet d'inclure des bibliothèques qui portent l'extension point a (ex: -lSDL2main).
```
+ [o](gcc.md#o)
```powershell
gcc file.c -o monjoliprog # l'option o permet de rediriger vers un fichier de sortie.
gcc file.c -o monjoliprog.exe
```
+ [g](gcc.md#g)
```powershell
# option de débogage.
```
> Note:  
> Normalisation : ISO (international)  
> ANSI : représentation américaine dans la norme ISO  
> 
> -w  
> 
> c89 (ANSI) -> -std=c89 (-ansi)  
> c90  
> C99 (ISO C)  
> c11  
> c18  
> 
> c++98 (ANSI) -> -std=c++98 (-ansi)  
> c++11  
> c++17  
> 
> -std=c++17  
> 
> -I <include>  
> -l <library>  