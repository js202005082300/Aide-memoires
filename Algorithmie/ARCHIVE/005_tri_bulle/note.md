# [[ARCHIVE] Algorithmie #5 - tri bulle](https://www.youtube.com/watch?v=hNxmICW60lg&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=5)

+ Tri bulle, éfficace sur une petite quantité de données (5, 10, 15, 20, ...)
+ Tri en complexité O(n²) : plus il y a de données, plus l'algorithme sera lent
+ Il compare deux éléments successifs pour les trier en les inverssant : 14 et 2 puis 2 et 64 et cetera. Au moment où on peut parcourir le tableau sans changement, c'est fini.
```txt
14 2 64 97 3 0 11
2 14 64 97 3 0 11
...
0 2 3 11 14 64 97
```

+ tri.txt
```
ALGORITHME application_tri_bulle
    tabint EST UN TABLEAU D'ENTIERS
    taille_tab EST UN ENTIER //Taille du tableau
DEBUT
    PROCEDURE tri_bulle(tabint)
        tab_trie EST UN BOOLEEN <-- FAUX
        i EST UN ENTIER
        tmp EST UN ENTIER
    DEBUT
        TANT QUE tab_trie == Faux
            tab_trie <- Vrai
            POUR i ALLANT DE 0 A taille_tab - 1 [SAUT DE 1]
                SI tabint[i] > tabint[i+1] ALORS
                    //Inverser les valeurs
                    tmp <- tabint[i+1]
                    tabint[i+1] <- tabint[i]
                    tabint[i] <- tmp
                    tab_trie <- Faux
                FIN SI
            FIN POUR

            taille_tab <- taille_tab - 1
        FIN TANT QUE
    FIN
FIN
```

En Python, pour inverser deux valeurs, on peux faire ceci du coup la variable tmp ne sert à rien.
```py
a = 15
b = 8

a,b = b,a
```