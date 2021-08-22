# [Présentation](https://www.youtube.com/watch?v=R9iHBRQbiEI)

+ [Introduction](#Introduction)
+ [Commentaires](#Commentaires)
+ [Caractères spéciaux](#Caractères-spéciaux)
+ [Types de données](#Types-de-données)
+ [Nommage variable](#Nommage-variable)
+ [Affichage variable](#Affichage-variable)
+ [Déclaration et initialisation](#Déclaration-et-initialisation)
+ [Appel de fonction](#Appel-de-fonction)
+ [Opérateurs](#Opérateurs)
+ [Lecture au clavier](#Lecture-au-clavier)
+ [Structures de contrôles](#Structures-de-contrôles)
+ [Boucles](#Boucles)
+ [Fonctions et Procedures](#Fonctions-et-Procedures)
+ [Structure de données](#Structure-de-données)
+ [Classes](#Classes)

## Introduction

Pour cette vidéo de présentation nous allait voir le pseudo-code et faire le tour de toutes les syntaxes que nous allons utiliser.

L'algorithmique c'est une manière de représenter un processus, un protocole, une recette qu'on pourrait utiliser en informatique pour la construction d'un programme ou d'une application ou d'un site web ou d'un jeu vidéo bref peu importe. C'est ce qui va permettre d'écrire la logique de tout ce qu'il y a autour, le traitement et les instructions qu'on veut effectuer.

Le but n'est pas de représenter tout ça dans un langage de programmation finale mais c'est d'avoir une écriture la plus générique possible qui puisse ensuite être transcrit dans un langage de programmation cible et que le programmeur mettra en œuvre suivant ses compétences et ses connaissances, et bien sûr des besoins qu'il a ainsi que les fonctionnalités que lui offre le langage dans lequel il veut en fait transcrire l'algorithme.

La transcription est à mettre en œuvre par le programmeur mais nous on va s'intéresser à l'algorithme et à l'utilisation d'un pseudo code.

Alors le pseudo code ce n'est pas quelque chose qui est normalisé parce que l'intérêt d'un pseudo code c'est de représenter de manière générique et que ce soit lisible pour n'importe quel programmeur est compréhensible sachant qu'il y a des fonctionnalités qui ne sont pas disponibles dans tous les langages mais ça doit rester compréhensible et permettre au programmeur de le retranscrire dans le langage qu'il connaît.

Le but est d'adopter une notation générique utilisable partout et exploitable par un développeur.

```txt
+---------------------------------------+
| PSEUDO-CODE                           |
+---------------------------------------+
```

## Commentaires

```txt
// Ceci est un commentaire

//
Ceci est un commentaire
sur plusieurs lignes
//
```

## Caractères spéciaux

Les méta-caractères.

```txt
\n \t \r \a
```

Retour à la ligne, tabulation, ...

## Types de données

```txt
Entier (45, -58)    : INT   -> 14, -5
Réels (3,14)        : REAL  -> 3.14
Booléen (V, F)      : BOOL  -> vrai (v), faux (f)
Caractère (A, C)    : CHAR  -> 'c', 'A'
Chaîne (bonjour)    : STR   -> "bonjour", "Hello World"
```

## Nommage variable

Tout en minuscule, un underscore entre les mots.
Les constantes en majuscule.

```txt
ma_variable
variable
MA_CONSTANTE
mon_tableau[x]
```

## Affichage variable

```txt
"Valeur de ma variable : {ma_variable}"
```

## Déclaration et initialisation

```txt
INT nombre := 144
{nombre}
```
nb. On affichera le nombre entre accolades, `{nombre}`.

```
STR nom := "Bob"
BOOL jeu_lance := vrai
```

Une constante,
```txt
REAL TAUX_TVA := 20.0
```

## Appel de fonction

```txt
STR nom := "Alice"
afficher("Bonjour {nom}")

nom = "Toto"
afficher("Bonjour {nom}")
```

Initialiser une information `:=` et affecter une nouvelle valeur `=`.

## Opérateurs

Opérateur d'initialisation `:=`, d'affectation `=`, arithmétique `+ - * + %`, de comparaison `== != < <= > >=`, logique `NOT AND OR XOR`, le XOR est le Ou Exclusif.

```txt
:= =
+ - * + %
== != < <= > >=
NOT AND OR XOR
```

```txt
BOOL d1 := vrai
BOOL d2 := vrai

d1 XOR d2
```

```txt
INT nombre := 4 OR 5
BOOL resultat := vrai OR vrai // vrai
BOOL res := 4 == 5 // faux
```

L'incrémentation `+=` et la décrémentation `++` ne sont pas assez universel pour être inséré au langage.

```txt
variable = variable + 1
```

## Lecture au clavier

```txt
lire()
```

Récupérer la lecture au clavier.
```txt
STR phrase := lire()
```
```txt
STR phrase
phrase = lire()
```

On a donc afficher() et lire().
```txt
afficher()
lire()
```

## Structures de contrôles

```txt
INT age := 19

SI age >= 18 ALORS
    afficher("Tu es majeur")
FIN SI
```

```txt
SI exxx ALORS
    ...
SINON SI exxx ALORS
    ...
SINON
    ...
FIN SI
```

## Boucles

```txt
INT i := 0

TANT QUE i < 10 FAIRE
    afficher("{i}")
    i = i + 1
FIN TANT QUE
```

Avec incrémentation,
```txt
INT i

POUR i ALLANT DE 0 A 10 FAIRE
    afficher("{i}")
FIN POUR
```

Avec décrémentation,
```txt
POUR INT i ALLANT DE 10 A 0 FAIRE
    afficher("{i}")
FIN POUR
```

Parcourir une collection (tableaux ou listes, et cetera),
```txt
INT tableau_nombres[2] := [1, 2]

POUR CHAQUE nombre DE tableau_nombres FAIRE
    afficher("{nombre}\n")
FIN POUR CHAQUE
```

```txt
STR phrase := "Bonjour tout le monde"

POUR CHAQUE caractere DE phrase FAIRE
    afficher("{caractere}\n")
FIN POUR CHAQUE
```

## Fonctions et Procedures

```txt
STR nom1 := "Alice"
STR 2 := "Bob"

afficher("{nom1} : Bonjour")
```

Procédure, ne retourne rien !
```txt
PROCEDURE somme_entiers(INT a, INT b)
    afficher("{a + b}")
FIN PROCEDURE
```

Fonction, retourne un résultat !
```txt
FONCTION somme_entiers(INT a, INT b)
    // a et b existent et ont pour valeur respective 10 et 2
    RENVOYER a + b
FIN FONCTION

INT resultat := 0
resultat = somme_entiers(10, 2)
afficher("{resultat})

// ou

afficher("{somme_entiers(10, 2)}") // 12
```

```txt
FONCTION somme_reels(REAL a, REAL b)
    RENVOYER a + b
FIN FONCTION

afficher("{somme_reels(10.0, 2.0)}) // 12.0
```

## Structure de données

```txt
STRUCTURE CompteBancaire
    REAL solde
FIN STRUCTURE

STRUCTURE Personne // Type de donnée personnalisé
    STR nom
    INT age
    STR adresse
    CompteBancaire compte
FIN STRUCTURE
```

```txt
STRUCTURE Reel // Type de donnée personnalisé
    INT entier
    INT decimales
FIN STRUCTURE
```

```txt
STRUCTURE Personne // Type de donnée personnalisé
    STR nom
    INT age
FIN STRUCTURE

Personne p1 := {"Alice", 25}

p1.nom = "Richard"
afficher("{p1.nom} a {p1.age} ans.") // Richard a 25 ans
```

## Classes

```txt
CLASSE Personne
    METHODES :
        CONSTRUCTEUR Personne(nom)
            Personne.nom = nom
        FIN CONSTRUCTEUR

        PROCEDURE se_presenter()
            afficher("Bonjour, je suis {Personne.nom}")
        FIN PROCEDURE

    ATTRIBUTS :
        STR nom
        INT age := 0
FIN CLASSE

Personne p1 := Personne("Richard")
p1.nom
p1.se_presenter() // Bonjour, je suis Richard
```

Nb. quid différence entre fonction et procédure.
```txt
PROCEDURE <nom>()
FIN PROCEDURE

FONCTION <nom>() -> STR
FIN FONCTION
```
La fonction renvoi une donnée de type string et la procédure ne renvoi rien.