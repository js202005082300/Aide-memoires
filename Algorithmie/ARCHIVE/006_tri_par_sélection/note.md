# [[ARCHIVE] Algorithmie #6 - tri par sélection](https://www.youtube.com/watch?v=bsaT8aspIX8&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=6)

+ tri par sélection
+ Complexité O(n²)
+ Stable
+ En place (travailler directement sur la structure sans travailler sur une copie)

```txt
ALGORITHME application_tri_selection
    tabint EST UN TABLEAU D'ENTIERS
    taille EST UN ENTIER
DEBUT
    PROCEDURE tri_selection(tabint, taille)
        i EST UN ENTIER
        j EST UN ENTIER
        min EST UN ENTIER
        tmp EST UN ENTIER
    DEBUT
        POUR i ALLANT DE 0 A taille - 1 [SAUT DE 1]
            min <- i
            POUR j ALLANT DE i+1 A taille [SAUT DE 1]
                SI tabint[j] < tabint[min] ALORS
                    min <- j
                FIN SI
            FIN POUR

            SI min != i ALORS
                tmp <- tabint[min]
                tabint[min] <- tabint[i]
                tabint[i] <- tmp
            FIN SI

        FIN POUR
    FIN
FIN
```


Nb : faire un swap, une inversion de valeur mais dans le cas où min serait différent de i.
```txt
tmp <- tabint[min]
tabint[min] <- tabint[i]
tabint[i] <- tmp
```