# [5. Pointeurs (QCM)](https://www.youtube.com/watch?v=BZXkTNPWHRQ)

+ Q1. Quelles sont la/les bonne(s) syntaxe(s) pour déclarer un pointeur sur un nombre entier (int) ?
    [ ] int ptr_number;
    [x] int *number;
    [x] int* number;
    [ ] int &number;

+ Q2. Quelle valeur possède par défaut un pointeur non initialisé ?
    [x] n'importe quoi
    [ ] NULL
    [ ] 0

> Pour ne pas avoir n'importe quoi, on va initialiser nos pointeurs => int ptr_number = NULL;

+ Q3. Que stocke un pointeur ?
    [ ] une valeur
    [x] une adresse
    [ ] un autre pointeur

> Une adresse d'une autre variable.

+ Q4. Sachant "int nb = 4" et "int *pNb = &nb", donner les deux méthodes pour accéder à la valeur de "4"
- printf("%d ou %d\n", nb, *pNb);

> `*pNb` mettre une étoile devant le nom du pointeur pour déférencer le pointeur pour accéder à la valeur de la variable sur lequel il pointe.

+ Q5. Quell passage d'argument évite la copie des données ?
    [x] passage par adresse -> void someFunction(int *data)
    [ ] passage par valeur  -> void someFunction(int data)

> On met l'adresse du pointeur (&ptr) en argument => someFunction(&ptr);
> le passage par valeur => someFunction(variable);

+ Q6. Quel drapeau (flag) est utilisé pour afficher des adresses dans un printf() ?
    [ ] %u
    [ ] %a
    [x] %p