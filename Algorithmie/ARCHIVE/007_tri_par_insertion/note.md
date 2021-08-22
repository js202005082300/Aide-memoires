# [[ARCHIVE] Algorithmie #7 - tri par insertion](https://www.youtube.com/watch?v=5vhM2PsZmsw&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=7)

+ Tri par insertion
+ dernier des tri lent du cours, c'est le plus éfficace sur des données de petites tailles
+ Compléxité O(n²)
+ Compléxité quadratique
+ Stable (concerve l'ordre à la base)
+ En place (travailler sur la structure même et pas une copie)

```txt
ALGORITHME application_tri_insertion
    tabint EST UN TABLEAU D'ENTIERS
    taille EST UN ENTIER
DEBUT
    PROCEDURE tri_insertion(tabint, taille)
        i EST UN ENTIER
        j EST UN ENTIER
        tmp EST UN ENTIER

        POUR i ALLANT DE 0 Á taille [SAUT DE 1]
            tmp <- tabint[i]
            j <- i

            TANT QUE j > 0 ET tabint[j-1] > tmp ALORS
                tabint[j] <- tabint[j-1]
                j <- j-1
            FIN TANT QUE

            tabint[j] <- tmp
        FIN POUR
    FIN
FIN
```
```c
#include <stdio.h>

int main(void)
{
    int tabint[5] = {2, 5, 3, 1, 4};
    int taille = 5;
    int i,j, tmp;

    printf("\n");
    for(int k = 0 ; k < taille ; k++)
        printf("%d ", tabint[k]);

    for(i = 0 ; i < taille ; i++)
    {
        tmp = tabint[i];
        j = i;

        while(j > 0 && tabint[j-1] > tmp)
        {
            tabint[j] = tabint[j-1];
            j = j-1;
        }

        tabint[j] = tmp;
    }

    printf("\n");
    for(int k = 0 ; k < taille ; k++)
        printf("%d ", tabint[k]);

    return 0;
}
```
```powershell
> gcc main.c -o prog
> .\prog.exe        

2 5 3 1 4 
1 2 3 4 5
```

vlc.exe --global-key-play-pause=Esc --global-key-jump-extrashort=Insert --extrashort-jump-size=1.5 --rate=1.3 "C:\Users\sam\OneDrive\Formations\FormationVideo\VidéosYoutube\20200428_Playlists_FV\Algorithmie\cours\Algorithmie #7 - tri par insertion-5vhM2PsZmsw.mp4"