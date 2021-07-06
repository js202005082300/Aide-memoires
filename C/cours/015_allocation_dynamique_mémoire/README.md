# [15. Allocation dynamique mémoire](https://www.youtube.com/watch?v=71QV6fFl_bk)

[stdlib.h](note.md#stdlib)

+ [malloc](note.md#malloc)
+ [sizeof](note.md#sizeof)
+ [free](note.md#free)
    + [1e compilation et exécution](note.md#1e-compilation-et-exécution)
+ [calloc](note.md#calloc)
+ [realloc](note.md#realloc)

```txt
/*
    sizeof(<donnee>)            : retourne la taille en octets d'une donnée

    malloc(<taille_en_octets>)  : allouer dynamiquement une zone mémoire
    free(<donnee_allouee>)      : libérer la mémoire allouée dynamiquement

    calloc(<donne>, <taille_en_octets>) : alloue et initialise tout à 0
    realloc(<donnee>, <nouvelle_taille>) : réalloue un espace mémoire
*/
```