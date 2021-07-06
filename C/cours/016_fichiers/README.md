# [16. Fichiers](https://www.youtube.com/watch?v=j1lHUmwnmA0)

+ [fopen](note.md#fopen)
+ [fclose](note.md#fclose)
+ [feof](note.md#feof)

+ [LECTURE](note.md#LECTURE) : [fgetc](note.md#fgetc) [fgets](note.md#fgets) [fscanf](note.md#fscanf)
+ [ECRITURE](note.md#ECRITURE) : [fputc](note.md#fputc) [fputs](note.md#fputs) [fprintf](note.md#fprintf)
+ [POSITIONNEMENT](note.md#POSITIONNEMENT) : [ftell](note.md#ftell) [fseek](note.md#fseek) [rewind](note.md#rewind)
+ [DIVERS](note.md#DIVERS) : [rename](note.md#rename) [remove](note.md#remove)

```c
/*
    fopen(<fichier>, <mode_ouverture>) :    r   (lecture seule, doit exister)
                                            w   (écriture seule)
                                            a   (ajout fin fichier)
                                            r+  (lecture/écriture, doit exister)
                                            w+  (lecture/écriture, supprime contenu)
                                            a+  (ajout lecture/écriture, fin de fichier)

    fclose(<fichier>) : fermer un fichier ouvert
    feof(<fichier>) : lire un caractère

    [LECTURE]
    fgetc(<fichier>)                            : lire un charactère
    fgets(<chaine, <taille_chaine>, <fichier>)  : lit une ligne
    fscanf(<fichier>, <format>, ...)            : lit du texte formaté

    [ECRITURE]
    fputc(<caractère>, <fichier>)               : écrit un caractère
    fputs(<chaîne>, <fichier>)                  : écrit une ligne de texte
    fprintf(<fichier>, <format>, ...)           : écrit du texte formaté

    [POSITIONNEMENT]
    ftell(<fichier>) : retourne position curseur dans fichier

    fseek(<fichier>, <deplacement>, <origine>) : déplace le curseur

        -> <origine> :  SEEK_SET (début fichier)
                        SEEK_CUR (position courante)
                        SEEK_END (fin fichier)
    
    rewind(<fichier>) : réinitialise la position du curseur

    [DIVERS]
    rename(<ancien_nom>, <nouveau_nom>)
    remove(<fichier>)
*/
```