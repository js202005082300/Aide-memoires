# [14. Structures et types](https://www.youtube.com/watch?v=1Kmq-9knIUY)

Bonjour à tous et bienvenue pour cette vidéo numéro 14 sur votre formation en langage c, encore une vidéo assez simple quand même par rapport aux autres.

On termine avec les notions du langage et aujourd'hui je vais vous parler un petit peu des structures et de type tout simplement, comment on va pouvoir par exemple créer nos propres types de données donc nos propres types de variables notamment.

Je vais vous montrer ça un petit peu dans cette séance.

Alors une structure, on va en parler très rapidement, ça va tout simplement consister à rassembler en fait un ensemble de données, par exemple au lieu d'avoir des variables qui sont un peu chacune de leur côté, on va les rassembler ensemble dans une structure et ça va nous permettre de manipuler plus ou moins des sortes d'entités en fait un ensemble comme ça de données de manière plus pratique que vous allez voir avec notamment au niveau des accès, de la lecture et de la modification.

On prend un exemple très simple je vais rester sur l'exemple du jeu vidéo encore une fois parce que c'est très parlant pour faire un maximum de monde, je pourrais très bien imaginer par exemple sur un jeu d'accord donc je vais avoir par exemple ce genre de données donc username qui serait le nom d'utilisateur simplement le pseudonyme avec un pseudo quelconque, moi je prends mon nom tout simplement je ne vais pas m'êmbêter voilà tout simplement `signed char username = "Jason";`.

```c
#include <stdio.h>

int main(void)
{
    signed char username = "Jason";
    int hp = 100;
    int mp = 100;

    return 0;
}
```

On pourrait avoir un nombre de points de vie d'accord je peux mettre `int hp = 100;` pour mettre des noms en anglais *Health Point* donc on peut imaginer 100 points de vie.

Ensuite, je peux faire `int mp = 100;` pour les points de magie, les points de mana, vous appelez ça comme vous voulez.

Ainsi je pourrais avoir d'autres informations, on peut en imaginer comme ça plusieurs. Je vais m'arrêter-là pour ne pas en rajouter trop, pas que ça agrandisse pour rien la structure et du coup si je veut modifier ces informations au cours d'un jeu vidéo d'accord au cours d'un développement ça va être assez compliqué puisque vous voyez que toutes les données sont un petit peu réparties.

Il faudra en plus que je mette ici des noms plus explicites parce qu'on ne sait pas à quoi ça correspond exactement là *mp* et *hp* non plus donc pas vraiment pratique en fait à manipuler du coup moi je préfère rassembler en fait ces données pour les manipuler en fait ensemble d'accords qu'elles ne soient pas comme ça chacune dans leur coin mais d'avoir ça de manière ordonné donc on va créer ce qu'on appelle tout simplement une structure.

Alors une structure c'est ça.

```txt
signed char username = "Jason";
int hp = 100;
int mp = 100;
```

D'accord ça va permettre de rassembler comme ça, de regrouper un ensemble de données.

Je vais faire un coupé, je vais couper tout simplement tout ce que j'ai mis là et on va créer une structure pour le faire.

## struct est un type de structure

### Créer une structure

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

La structure on la définit bien évidemment au dessus de la fonction main(), il faut qu'elle soit connue avant la fonction principale ou en général quand on fait, quand on programme sur plusieurs fichiers comme vous l'avez apris avec la programmation modulaire notamment on défini en fait les structures dans les fichiers d'en-tête c'est-à-dire les fichiers qui portent l'extension *h* d'accord quand vous mettez vos prototypes en fait de fonction donc c'est là qu'on définit en général les structures et ce qu'on verra par la suite notamment les énumérations et les unions.

Du coup, on va simplement utiliser le mot clé `struct` comme ça.

```c
#include <stdio.h>

struct
{

};

int main(void)
{

    return 0;
}
```

D'accord on peut lui donner un nom donc fait `struct Player` et comme je lui donne un nom moi ça va être *Player* d'accord simplement puisque c'est ce que je veux faire et à l'intérieur vous mettez des accolades ici et on termine par un point virgule, ça c'est super important pour finir la définition de la structure, et on y met les informations de tout à l'heure voyez.

Alors là évidemment, il n'y a pas cette information-là `signed char username = "Jason";` donc je vais mettre plutôt une taille par exemple 256 `signed char username[256];` voilà donc on finis avec des points virgules pour les points de vie et les points de mana voilà.

```c
#include <stdio.h>

struct Player
{
    signed char username[256];
    int hp;
    int mp;
};

int main(void)
{

    return 0;
}
```

Voilà comme ça on détermine une structure, on dis tout simplement que l'on crée une sorte de type de variables qui s'appelle Player mais attention ce n'est pas encore un type là c'est vraiment qu'une structure, on va parler de type juste après.

On crée une structure Player d'accord qui contient donc un joueur qui aura un nom d'utilisateur, qui aura un nombre de points de vie et un certain nombre de points de mana ou de points de magie, fin ce que vous voulez d'accord.

Du coup on va pouvoir comme ça définir rapidement un joueur tout simplement.

### Déclarer et initialiser une structure

Pour créer un joueur, en ayant cette structure parce que c'est très simple c'est juste ça à faire, on aura tout simplement à le déclarer de cette manière donc on va créer un joueur
alors déjà on va voir comment initialiser un joueur ok alors je vais mettre `struct Player` parce que c'est comme ça que ça s'appelle c'est une structure Player et je vais donner un nom d'accord comme un nom de variable et je vais l'appeler `p1` et comme pour les tableaux qu'on a vu, vous mettez des accolades ici pour initialiser les valeurs, si vous voulez des valeurs de base `struct Player p1 = {};`.

Ainsi username, je vais mettre ce que j'avais tout à l'heure pour dire par défaut il s'appelle avec mon prénom auquel je met un certain nombre de points de vie et certain points de mana `struct Player p1 = {"Jason", 100, 100};` et là j'ai initialiser.

```c
#include <stdio.h>

struct Player
{
    signed char username[256];
    int hp;
    int mp;
};

int main(void)
{
    struct Player p1 = {"Jason", 100, 100};

    return 0;
}
```

Alors on peut laisser des valeurs vide, vous pouvez très bien faire ça `struct Player p1 = {"", 0, 0};` d'accord vous avez droit de faire ça, c'est vous qui voyez. C'est vraiment au choix et voilà comment initialise comme pour un tableau, on met des accolades et voyez par une virgule on sépare chacun des éléments donc ça ce sont les champs de la structure.

```txt
signed char username[256];
int hp;
int mp;
```

Ceci, on appelle ça des champs de la structure et il y en a trois ok donc 3 champs différents ainsi ça peut être des variables, ça peut être des pointeurs. On peut avoir des pointeurs dans les structures bien évidemment, on peut avoir des tableaux parce que vous savez que ceci `signed char username[256];` en fait est un tableau de char c'est-à-dire une chaîne de caractères comme vous l'avez vu dans la séance d'avant et on peut avoir également des autres structures. On peut avoir des structures dans des structures, c'est tout à fait possible puisque après tout une structure vous allez voir par la suite qu'on va en faire un type de variable, un type de donnée donc on a ce genre de choses et du coup je peux tout simplement faire un petit printf().

### Afficher les valeurs de variables de structures 

Un petit printf() pour afficher le nom du joueur donc je vais l'afficher avec un `%s` comme on a vu pour afficher des chaînes de caractères et comment est-ce qu'on l'affiche ? hé bien on met `p1.username` c'est-à-dire le nom de la structure `p1`, un point `.` et le nom du champ `username` tout simplement.

Voilà on peut afficher autre chose, on va mettre les *PV* et les *PM* et du coup on fait `p1.hp` et `p1.mp`.

```c
#include <stdio.h>

struct Player
{
    signed char username[256];
    int hp;
    int mp;
};

int main(void)
{
    struct Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Jason
PV : 100 | PM : 100
```

Voilà j'exécute et voyez qu'il affiche le nom du joueur, les points de vie, les points de mana donc on peut manipuler et c'est beaucoup plus pratique parce qu'on sait que du coup qu'ici `username`, `hp` et `mp` ça appartient à `p1` et `p1` on voit que c'est un joueur.

### Définir un type de variable avec typedef

On peut raccourcir cette écriture, on peut également en faire un type c'est-à-dire que moi j'aimerais transformer le Player comme un nouveau type de variable comme vous savez quand vous avez les types *int*, *float*, *char*, comme vous avez type *double* aussi et cetera c'est-à-dire tout ces types-là de variables que vous connaissez depuis les toutes premières séances, on va pour cela le définir comme un type via un mot clé qui s'appelle tout simplement `typedef`.

Alors on va l'utiliser comme ceci alors il y a deux manières de le faire, on peut faire ça `typedef struct Player Player;` ce qui veut dire définit comme un type la structure Player par Player, qu'est ce que ça veut dire ? ça veut tout simplement dire qu'on va remplacer *struct Player* par *Player* tout simplement.

```c
#include <stdio.h>

struct Player
{
    signed char username[256];
    int hp;
    int mp;
};

//Remplacer "struct Player" par "Player"
typedef struct Player Player;

int main(void)
{
    struct Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Donc en faisant ça `typedef struct Player Player;` c'est-à-dire que toute cette partie-là *struct Player* d'accord tous ces textes où il y a ces deux mots là ça va être remplacé par le mot *Player* tout court, ça va raccourcir l'écriture d'où ce qui fait que là modifier `struct Player p1 = {"Jason", 100, 100};` par `Player p1 = {"Jason", 100, 100};` alors je peux laisser *struct* un ça marcherait bien évidemment mais je peux l'enlever et voilà ça raccourci l'écriture c'est pratique parce qu'après tout *struct*, on s'en fiche un peu.

```c
#include <stdio.h>

struct Player
{
    signed char username[256];
    int hp;
    int mp;
};

//Remplacer "struct Player" par "Player"
typedef struct Player Player;

int main(void)
{
    Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Nous ce qu'on veut dire c'est que c'est que *p1* est un joueur *Player* donc c'est tout à fait compréhensible sinon bah si vous voulez ne par écrire une ligne comme ça supplémentaires `typedef struct Player Player;`, vous pouvez directement mettre le `typedef` à la structure.

```c
#include <stdio.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

int main(void)
{
    Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Voilà et ça veut simplement dire que tu défini que la structure Player qui a tout ça s'appelle maintenant donc à pour type `Player` d'accord.

Pour vous montrer la dfférence c'est-à-dire que je peux faire ça `Joueur` comme nom de type pour ne pas mélanger les choses et que vous comprenez.

```c
#include <stdio.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Joueur;

int main(void)
{
    Joueur p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Jason
PV : 100 | PM : 100
```

Pour que vous compreniez, je dis en fait que le *typedef* va remplacer toute la définition de la structure par un *Joueur*.

```txt
typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
}

//remplacé par Joueur
```

C'est pour qu'en faisant ça `} Joueur;`, il va bien prendre en compte toute la structure donc vous pouvez mettre le même nom parce que des fois on met le même nom mais moi je vais rester avec des noms anglais puisque j'étais parti avec des mots anglais depuis le début mais ça fonctionne évidemment et aucun problème à ce niveau là.

Voilà pour la structure donc ça raccourci l'écriture donc sachez-le c'est un terme à connaître `typedef` qui permet de définir un type, c'est deux mot avec type pour type, et def pour define donc on dit tu définis comme type ce qui suit.

Voilà ça peut être pratique, on l'avait d'ailleurs un petit peu vu avec le define rappelez vous la dernière fois le define quand on dit qu'on pouvais par exemple  raccourcir un nom de fonction, on pouvait changer un certain nombre de termes voilà ça fonctionnait.

Voilà on pouvvais faire ça mais là comment on veut vraiment créer un type et pas seulement changer en fait par une constante, par exemple une valeur lorsqu'on ne veut pas faire une constante mais là on veut simplement dire défini `Player`, cette structure comme un type donc maintenant ça devient un **type de variable**.

```c
Player p1 = {"Jason", 100, 100};
```

`Player` devient un type de variable comme un int, un float ainsi Player est devenu un type de variables dans mon programme tout simplement donc voilà comment on fait.

### Modifier une variable de structure

Pour modifier les valeurs ok c'est très très simple, je pense que je peux aller assez vite là dessus aussi, vous accéder aux éléments tels que vous y accéder pour les afficher.

:warning: Si je fais `p1.username = "Naoki";` ça ne fonctionnera pas alors là vous savez qu'au niveau des chaînes de caractères, on peut directement mettre en dur à la création de la chaîne, à sa déclaration et son initialisation sinon on obligé de passer par une fonction.

Vous souvenez, on l'a vu juste avant donc on va faire `#include <string.h>` et on va faire strcpy() et je vais dire que dans p1.username qui contient jusqu'à 256 caractère aussi, je vais lui dire tu vas mettre "Naoki" et là ça va marcher `strcpy(p1.username, "Naoki");`.

```c
#include <stdio.h>
#include <string.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

int main(void)
{
    Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    strcpy(p1.username, "Naoki");

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Jason
PV : 100 | PM : 100
Nom du joueur : Naoki
PV : 100 | PM : 100
```

:warning: Attention c'est à savoir quand vous avez une chaîne de caractères sur lequel vous voulez modifier sa valeur il faut utiliser ce strcpy() d'accord vous ne pouvez pas directement dire que la chaîne égale autre chose ça ne marche pas, ça marche pour des nombres mais pas pour des chaînes de caractères sinon vous allez avoir de toute façon des plantages.

Ainsi si on compile et qu'on ré exécute mon programme, vous voyez qu'on a changé le prénom pas de souci et je peux tout modifier mais là par contre pour les hp je peux le faire directement `p1.hp -= 50;`.

```c
#include <stdio.h>
#include <string.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

int main(void)
{
    Player p1 = {"Jason", 100, 100};

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    strcpy(p1.username, "Naoki");
    p1.hp -= 50;

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Jason
PV : 100 | PM : 100
Nom du joueur : Naoki
PV : 50 | PM : 100
```

Voilà je baisse les hp de 50 hop on voit que ça a baisser de 50 donc ça je ne reviens pas dessus voyez que ces des variables c'est ce que vous aviez vu avec les opérateurs, les calculs c'est des choses que vous savez depuis maintenant un petit moment donc tout ça vous savez comment ça fonctionne.

Qu'est ce que je peux vous montrer au niveau des structures, la vidéo serait un petit peu plus longue mais c'est intéressant quand même pour vous, ça va vous servir ainsi comment on fait quand on a des pointeurs parce que là vous voyez qu'on a pas de pointeurs dans ma structure et comme on les a vues, c'est bien que vous sachiez si un jour vous avez besoin d'en faire des pointeurs comment vous allez utiliser ça.

### Initialiser une structure via une fonction

Alors on va le passer par une fonction puisque en général c'est ce qu'on fait souvent comme ça on initialise une structure via une fonction donc on va mettre quelque chose par défaut regardez comme ça `Player p1 = {"", 0, 0};` d'accord où on dit par exemple que `p1` c'est ça et on va le passer par une fonction `create_player(&p1);` ainsi on lui passe `p1` par adresse donc toujours pareil, rappelez-vous, pour devoir vraiment travailler que sur un pointeur, pour pouvoir modifier l'original.

Alors ça c'est important, pareil je ne reviens pas dessus maintenant vous savez comment ça fonctionne et par la suite on affichera voilà les informations de notre joueur et on verra comment ça fonctionne.

```c
#include <stdio.h>
#include <string.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

int main(void)
{
    Player p1 = {"", 0, 0};

    create_player(&p1);

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Ensuite on va créer ici la petite fonction pour le créer `void create_player(Player *p)` avec void puisqu'on ne retourne rien évidemment puisqu'on travaille directement sur le Player, en paramètre on va avoir cette fois-ci `Player *p` directement je travaille voyez comme sur un type de données d'accord je travaille sur un Player comme ça on arrive plus facilement à lire le code ce qui simplifie beaucoup la lecture du code.

Je met des petites séparations pour s'y retrouver plus facilement hop.

```c
#include <stdio.h>
#include <string.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

/*-------------------------------------------------*/

void create_player(Player *p)
{
    
}

/*-------------------------------------------------*/

int main(void)
{
    Player p1 = {"", 0, 0};

    create_player(&p1);

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Voilà et on va créer notre joueur donc on ne veut pas m'amuser à faire des scanf() pour demander comment tu veux t'appeler ?, combien de points de vie tu veux ? ok je vais faire une modification directement.

Alors comme il s'agit d'un pointeur, on va modifier de cette façon c'est-à-dire qu'on va ouvrir des parenthèse, on va mettre le nom du pointeur comme ceci `(*p).` où on met le point et on met du coup l'information qu'on veut `(*p).username` par exemple sur laquelle on va faire quelque chose. Alors ici il nous faudra un strcpy() où on va mettre "Naoki" par exemple.

Ensuite on initialise hp et mp.

```c
void create_player(Player *p)
{
    strcpy((*p).username, "Noaki");
    (*p).hp = 100;
    (*p).mp = 100;
}
```

Voilà on va voir si j'ai pas fait de bêtise non normalement c'est bon.

```c
#include <stdio.h>
#include <string.h>

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

/*-------------------------------------------------*/

void create_player(Player *p)
{
    strcpy((*p).username, "Noaki");
    (*p).hp = 100;
    (*p).mp = 100;
}

/*-------------------------------------------------*/

int main(void)
{
    Player p1 = {"", 0, 0};

    create_player(&p1);

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Noaki
PV : 100 | PM : 100
```

Voilà voyez que ça fonctionne sans problème, on a créé un joueur donc ça c'est pareil c'est ce que vous avez vu sur la vidéo sur les pointeurs, si c'est pas encore compris si  là vous ne comprenez pas ce code create_player(), si vous ne comprenez pas le fait qu'ici ça a bien modifié p1 en étant passé par une fonction ben revoyez la séance 11 sur les pointeurs, c'est qu'il y a des choses qui ne sont pas encore assez clair pour vous mais normalement c'est simple.

Par contre vous avez remarquez que cette syntaxe là `(*p).` n'est pas très visible et bah ça tombe bien, les développeurs faisait souvent l'erreur avec les parenthèses, les étoiles et les points à écrire bref c'est assez embêtant du coup on a remplacé cette syntaxe c'est-à-dire qu'on peut quand vous avez par exemple `(*nomPointeur).un_champ` par exemple égal quelque chose sachez que c'est la même chose que de faire `nomPointeur->un_champ` donc il n'y a même plus l'étoile et il n'y a plus les parenthèses, on met une flèche.

```c
/*
    (*nomPointeur).un_champ = X;
    nompointeur->un_champ = X;
*/
```

Automatiquement quand on a une flèche c'est un pointeur.

D'accord ce qui fait que là, j'enlève les `(*p).` et je remplace par `p->`.

```c
#include <stdio.h>
#include <string.h>

/*
    (*nomPointeur).un_champ = X;
    nompointeur->un_champ = X;
*/

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

/*-------------------------------------------------*/

void create_player(Player *p)
{
    strcpy(p->username, "Noaki");
    p->hp = 100;
    p->mp = 100;
}

/*-------------------------------------------------*/

int main(void)
{
    Player p1 = {"", 0, 0};

    create_player(&p1);

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```
```powershell
gcc main.c -o prog
.\prog.exe        
Nom du joueur : Noaki
PV : 100 | PM : 100
```

Voilà et là je re compile, même chose aucune différence mais la syntaxe est du coup beaucoup plus lisible, c'est vraiment plus pratique pour tout le monde. Il n'y a pas besoin de se dire bah mince c'est un pointeur ou pas car on le sait.

S'il y a une flèche, c'est un pointeur parce qu'on utilise la flèche que pour les pointeurs.

Alors là oui c'est un pointeur partout.

> ------------------------------------------------------------------------------------
> Partie non testé
> ------------------------------------------------------------------------------------

Voilà si par exemple d'ailleurs j'avais eu `int *hp` dans mon code ci-dessous, il aurait fallu utiliser la flèche que sur *hp* mais pas sur les autres.

```txt
typedef struct Player
{
    signed char username[256];
    int *hp;
    int mp;
} Player;
```

Voilà la flèche `->` s'utilise vraiment que sur des pointeurs, on en a un puisque toute la structure ici est un pointeur `Player *p`.

```txt
void create_player(Player *p)
{
    strcpy(p->username, "Noaki");
    p->hp = 100;
    p->mp = 80;
}
```

Ici on en a un puisque toute la structure est un pointeur `Player *p` mais si on avait pas de pointeur, il aurait fallu passer par le `p.hp` donc on aurait fait comme ça mais là on a vraiment la petite flèche `p->hp`.

Vous voyez comment on peut travailler sur des pointeurs, c'est aussi simple que ça mais si après vous ne passez pas par une fonction et que vous avez directement un champ de la structure qui est un pointeur, par exemple : `int *hp;` il faudrait le faire directement dans main()...

```txt
typedef struct Player
{
    signed char username[256];
    int *hp;
    int mp;
} Player;
```

Avec `*hp`, on aurait fait :

```txt
strcpy(p.username, "Noaki");
p->hp = 100;
p.mp = 80;
```

Si on n'était pas passer par une fonction et qu'on avait eu `int *hp`, on aurais stcpy() de p.username comme tout à l'heure, on aurait fait ensuite `p->hp = 100;` et on aurait fait `p.mp = 80;` si on était pas passer par une fonction et qu'on avait eu un pointeur.

> ------------------------------------------------------------------------------------
> Fin
> ------------------------------------------------------------------------------------

C'est la même chose donc je ne vous fais pas tout le code pour ça, c'est vraiment la même chose que ce que vous avez vu ici sauf que moi j'ai fait plus propre, je suis passé carrément par une fonction, c'est mieux de faire comme ça parce que du coup avec une fonction on peut créer un joueur directement.

Après on peut s'imaginer demander à l'utilisateur quel nom il veut, quel point de vie, vous pouvez créer comme-ça plein de joueurs à la volée voire même des tableaux, vous pouvez faire un tableau ainsi vous pouvez dans un tableau avoir des structures.

Alors ça je l'ai toujours, un tableau peut avoir n'importe quel type de données mais il faut que ce soit toujours la même dedans, c'est soit un tableau de int, soit un tableau de float, soit un tableau de char et vous pouvez avoir des tableaux de Player car rappelez-vous je vous ai dit qu'une structure ça peut être un type de variable ok.

## Un tableau de Player

Vous pouvez très bien créé après un tableau de Player, on peut faire ça.

Je peux faire par exemple ce genre de choses `Player tableau_joueurs[5];` c'est-à-dire un tableau de Playeur où j'aurais 5 joueurs.

Après comment on accède ? on fait comme je vous avais montré avant sur les tableaux pour le joueur numéro 1 donc qui à l'indice 0, on fait `tableau_joueurs[0].hp = 150;` où on prend hp, les points de vie sinon il faudrait utiliser stcpy() avec username donc 150 points de vie.

Idem pour le deuxième joueur `tableau_joueurs[1].hp = 70;` et cetera.

```c
#include <stdio.h>
#include <string.h>

/*
    (*nomPointeur).un_champ = X;
    nompointeur->un_champ = X;
*/

typedef struct Player
{
    signed char username[256];
    int hp;
    int mp;
} Player;

/*-------------------------------------------------*/

void create_player(Player *p)
{
    strcpy(p->username, "Noaki");
    p->hp = 100;
    p->mp = 100;
}

/*-------------------------------------------------*/

int main(void)
{
    Player p1 = {"", 0, 0};

    Player tableau_joueurs[5];

    tableau_joueurs[0].hp = 150;
    tableau_joueurs[1].hp = 70;

    create_player(&p1);

    printf("Nom du joueur : %s\n", p1.username);
    printf("PV : %d | PM : %d\n", p1.hp, p1.mp);

    return 0;
}
```

Ainsi c'est la même chose, vraiment on ne complique rien du tout, on peut faire des tableaux de structure il n'y a aucun problème, ça rajoute un peu de code bien sûr mais on peut s'arranger comme ça, ça peut tout à fait se faire.

Voilà pour les structures, j'ai été un petit peu long dessus mais je voulais vraiment que vous sachiez tout ça, que vous sachiez ce qu'est une structure puisque c'est simple en fait c'est un regroupement de donnée tout simplement.

Et donc comment les créer ? comment on initialise une structure ? comme on l'a fait ici par défaut `Player p1 = {"", 0, 0};`.

Maintenant vous savez tout simplement comment accéder à ses éléments, comment les affichés, comment les modifier directement par une fonction, vous savez travailler avec des pointeurs dans une structure, pas de souci.

Voilà je vous ai dit tout ce que j'avais à vous dire sur les structures, vous savez grosso modo tout ce qu'il y avait à savoir ok donc on va pouvoir passer à la suite.

On va passer aux deux autres petites choses que je voudrais que vous voyez dans cette vidéo.

C'est pour ça que le titre s'appelle structure et type puisqu'il y a deux petites choses à voir.

## enum est un autre type de structure

On va voir un autre type de structure même si je n'aime pas trop le nom struct parce qu'on aura plus ce mot clé-là `struct` mais c'est quand même important de le savoir donc je vais virer tout ce code-là, on enlève vraiment tout tout tout.

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

On va créer ce qu'on appelle une énumération.

Vous allez voir ce qu'est une énumération.

Alors une énumération ça permet tout simplement d'énumérer d'accord un type de données ou une structure, on peut appeler ça un regroupement de quelque chose mais, comment dire, qui va faire appel à des constantes c'est-à-dire qu'il a des valeurs possibles.

Alors c'est pas forcément très clair dit comme ça mais vous allez comprendre très vite.

Je vais vous montrer un exemple qui vous resservira, on utilisera notamment ce style d'énumération dans les structures de données que l'on verra la suite de la formation.

Je vais faire un `enum` tout simplement et je mettre `enum Booleen` et *Booleen* c'est une variable qui peut prendre 2 valeurs vrai ou faux, true ou false, et au lieu de mettre des valeurs je lui mets tout simplement `false,` ou `true`.

```c
#include <stdio.h>

enum Booleen
{
    false,
    true
}

int main(void)
{

    return 0;
}
```

Alors dans une numération, il faut savoir que quand vous mettez des noms comme ça tout simplement, le premier champ de l'énumération est égal à 0 ok et le deuxième champ suit les nombre donc c'est égal à 1.

Et en informatique quand on dit que quelque chose est faux, c'est égal à 0 et quand on dit que quelque chose est vraie c'est égal à 1 tout simplement.

Voilà donc c'est simplement une norme, c'est comme ça en informatique donc quand on veut déclarer un type booléen on va faire une énumération et après on peut justement faire ceci `typedef enum Booleen` et nomme le type `} Booleen;` et n'oublie pas le point virgule à la fin de l'énumération c'est comme pour les structures.

```c
#include <stdio.h>

typedef enum Booleen
{
    false,
    true
} Booleen;

int main(void)
{

    return 0;
}
```

Voilà comme ça on peut créer par exemple `Booleen jeu_lance = false;`, on dit que le jeu n'est pas lancé.

Voilà donc on peut mettre des mots comme ça en valeur de variable, ce qu'on n'aurait pas pu faire avant plutôt que de devoir mettre ceci `Booleen jeu_lance = 0;` ce qui n'est pas forcément clair.

```c
#include <stdio.h>

typedef enum Booleen
{
    false,//0
    true//1
} Booleen;

int main(void)
{
    Booleen jeu_lance = false;

    return 0;
}
```

Là on voit tout de suite, là on peut très bien mettre attention quand je vous dis qu'on peut mettre n'importe quoi, on peut mettre ceci.

```c
#include <stdio.h>

typedef enum Booleen
{
    NON,//0
    OUI//1
} Booleen;

int main(void)
{
    Booleen jeu_lance = NON;

    return 0;
}
```

Vous pouvez le faire, on peut mettre comme ça des noms (NON, OUI) et d'ailleurs c'est même ce qu'on fait le plus souvent, c'est-à-dire qu'on met en majuscule comme ça les champs d'une énumération.

Donc là, on a créé une variable en fait de type booléen par rapport au type qu'on a créé ici de l'énumération `Booleen` et on lui a dit ben voilà c'est égal à *NON, le jeu n'est lancé* du coup c'est très visible, c'est simplement pour pouvoir lire donc c'est des valeurs possibles.

Si on n'avait pas mis le type ok si on avait fait ça tout simplement `enum Booleen{};` et bien, on aurait fait comme pour les structures on aurait mis `enum Booleen jeu_lance = NON;` tout simplement.

```c
#include <stdio.h>

enum Booleen
{
    NON,//0
    OUI//1
} Booleen;

int main(void)
{
    enum Booleen jeu_lance = NON;

    return 0;
}
```

Ici à partir du moment où le jeu est lancé, on aurait changé la valeur, on aurait fait ça `jeu_lance = OUI;`.

```c
#include <stdio.h>

enum Booleen
{
    NON,//0
    OUI//1
} Booleen;

int main(void)
{
    enum Booleen jeu_lance = NON;

    jeu_lance = OUI;

    return 0;
}
```

Voilà maintenant le jeu est lancé.

On peut faire des tests, on peut dire par exemple `if(jeu_lance == OUI)` du coup on peut faire des tests et c'est lisible, on arrive à lire au niveau du code en ayant du français c'est du coup beaucoup plus compréhensible au niveau du développement.

```c
#include <stdio.h>

enum Booleen
{
    NON,//0
    OUI//1
} Booleen;

int main(void)
{
    enum Booleen jeu_lance = NON;

    if(jeu_lance = OUI)
    {

    }

    return 0;
}
```

Ainsi c'est à ça que sert l'énumération tout simplement c'est pour faciliter en fait le développement, ça permet de d'énumérer une liste de valeurs possibles pour une `enum`, pour tout simplement ici une étiquette `Booleen` voilà on appelle ça l'étiquette de l'énumération c'est-à-dire le *Booleen* et on peut transformer comme pour la structure en type c'est pour ça que le typedef est vraiment à connaître.

**Le typedef permet de transformer une structure en type, il permet de transformer une énumération au type** et il va permettre transformer autre chose qu'on va voir juste après donc ça peut servir à ça.

On peut également faire ceci, des marques de voiture.

```c
#include <stdio.h>

enum MarqueVoiture
{
    PEOGEOT,
    RENAULT,
    TOYOTA,
    MAZDA
};

int main(void)
{
    enum MarqueVoiture v1 = TOYOTA;

    return 0;
}
```

Comme ça nous définissons une marque de voiture `v1` pour la voiture 1 et on met que c'est une Toyota et voilà d'accord on peut définir comme ça des choses plus simplement c'est très lisible et encore une fois je peux transformer en type avec un petit typedef je fait `Marque` et là on va même carrément changer le nom `Marque voiture1 = TOYOTA;`.

```c
#include <stdio.h>

enum MarqueVoiture
{
    PEOGEOT,
    RENAULT,
    TOYOTA,
    MAZDA
} Marque;

int main(void)
{
    Marque voiture1 = TOYOTA;

    return 0;
}
```

Voyez tout de suite à la lecture c'est compréhensible pour tout le monde, c'est très simple voilà donc une énumération ça sert à ça.

Alors là vous n'en voyez peut-être pas l'utilité plus que ça, vous vous dites qu'on peut s'en passer c'est-à-dire que oui on peut s'en passer, on peut très bien développer sans énumération mais dans certains cas ça peut être très utile et encore une fois ça facilite beaucoup le développement.

On terminera par une dernière petite chose pour cette vidéo.

Alors tout simplement pour les enum's c'est tout simplement un manière en fait d'avoir des identificateurs en fait d'accord d'avoir des petits identifications comme ça en utilisant des constantes c'est pour ça que je les mets en majuscules et du coup ces énumérations peuvent prendre plusieurs valeurs possibles ça peut être une peugeot ici ou une renault ou toyota puis pour les couleurs on aurait pu avoir du rouge, du vert. Pour toute à l'heure voyez c'était OUI NON ainsi on peut faire comme ça différentes énumérations avec différentes valeurs possibles pour chacune de ces types de données.

On va terminer avec un dernier type qui n'est pas forcément le plus utilisé au début vous n'allez certainement pas comprendre son utilité pour commencer mais vous aurez l'occasion de toute façon peut-être de l'utiliser par la suite.

Je vais en parler quand même parce qu'il faut le connaître, je pense que c'est un des trois importants.

Il y a les structures, il y a les énumérations et on va voir les unions.

Les unions, c'est important aussi.

## union

**L'union pour faire très simple, ça permet, comme pour la structure, de regrouper plusieurs types de données ok mais qui vont permettre d'accéder à la même zone de la mémoire ok** c'est-à-dire que par exemple une énumération quand on va en créer ici `Marque voiture1 = TOYOTA;` où j'ai réservé une case en mémoire ok pour déclarer et initialiser cette marque de voiture tout simplement une case même si vous voyez qu'ici j'ai quatre choses.

```txt
PEOGEOT,
RENAULT,
TOYOTA,
MAZDA
```

### Identifier les valeurs des énumération - petite parenthèse

Là j'ai quatre choses, c'est pas comme une structure où j'avais dedans 3 variables et du coup ça va créer chaque variable pour la structure dans la mémoire d'accord on aurais réservé un emplacement pour le prénom, un emplacement pour le nombre de points de vie, un emplacement pour le nombre de points de magie.

Là on va voir qu'une seule énumération donc une seule case en mémoire qui va être réservé, ça peut être un entier puisque je vous dis qu'en fait PEOGEOT va prendre la valeur 0, RENAULT la valeur 1, TOYOTA la valeur 2 et MAZDA la valeur 3 tout simplement.

```txt
enum MarqueVoiture
{
    PEOGEOT,    //0
    RENAULT,    //1
    TOYOTA,     //2
    MAZDA       //3
} Marque;
```

D'ailleurs si vous voulez mettre des valeurs comme vous voulez, vous pouvez sans problème faire ceci c'est-à-dire identifier PEOGEOT par la valeur 10 et cetera.

```txt
enum MarqueVoiture
{
    PEOGEOT = 10,
    RENAULT = 20,
    TOYOTA  = 30,
    MAZDA   = 40
} Marque;
```

Comme ça des valeurs d'identification au pif.

Il faut ainsi comprendre que si mettez TOYOTA reviens à mettre 30.

```c
#include <stdio.h>

enum MarqueVoiture
{
    PEOGEOT = 10,
    RENAULT = 20,
    TOYOTA  = 30,
    MAZDA   = 40
} Marque;

int main(void)
{
    Marque voiture1 = 30; //TOYOTA

    return 0;
}
```

C'est vrai que dire que la marque de la voiture c'est 30, ce n'est pas forcément clair mais quand on met un nom tout de suite c'est plus clair.

```c
#include <stdio.h>

enum MarqueVoiture
{
    PEOGEOT = 10,
    RENAULT = 20,
    TOYOTA  = 30,
    MAZDA   = 40
} Marque;

int main(void)
{
    Marque voiture1 = RENAULT;

    return 0;
}
```

Après avec même l'éditeur de code qui arrive à retrouver la constante et ben c'est beaucoup plus clair, beaucoup plus lisible donc on peut faire comme ça sur les énumérations.

On peut aussi leur affecter comme ça des valeurs, on le fait assez rarement en général on s'en fiche de ça `= 10,`, nous ce qui nous intéresse c'est d'avoir des mots ici.

```txt
PEOGEOT,
RENAULT,
TOYOTA,
MAZDA
```

La plupart du temps, on laisse le compilateur mettre les valeurs par défaut mais dans certains cas ça peut éventuellement se montrer utile pourquoi pas, je vous montre que ça existe, que c'est possible on peut faire comme ça.

Voilà pour les énumérations.

### Les unions

Donc les unions et je reviens dessus du coup parce que j'avais fait une parenthèse pour revenir sur les énumérations.

Les énumérations permettent de regrouper des types de données en fait, plusieurs comme pour les structures mais on va pouvoir accéder à la même zone mémoire.

Alors en général, l'union est utilisé dans une structure le plus souvent.

Alors on va créer `union` on va utiliser le mot clé pour ça que l'on va nommer Nombre `union Nombre` pour dire qu'on fait l'union d'un nombre tout simplement, et un Nombre je prend un exemple tout bête ça peut être `int entier;` voilà un int pour un entier ou ça peut être un float pour un décimal `float decimal;` ici.

```c
#include <stdio.h>

union Nombre
{
    int entier;
    float decimal;
};

int main(void)
{

    return 0;
}
```

Alors ça c'est une possibilité, j'écris une union de nombres `union Nombre`.

Par la suite je peux sans problème faire ceci `union Nombre nb1;` et du coup je peux dire `nb1.entier = 3;` voilà si c'est un entier je peux dire qu'il égale à 3 et si nb1 est un décimale je vais dire qu'il est égale à 3.14 la valeur de Pi par exemple.

```c
#include <stdio.h>

union Nombre
{
    int entier;
    float decimal;
};

int main(void)
{
    union Nombre nb1;

    nb1.entier = 3;
    nb1.decimal = 3.14;

    return 0;
}
```

Voilà c'est une possibilité d'accord donc ça permet tout simplement d'avoir le même emplacement mémoire parce qu'en fait dans la mémoire on aura réservé un espace et si ici vous avez réservé un espace et que vous ayez un entier ou un décimale, il va réserver le même emplacement.

```txt
union Nombre
{
    int entier;
    float decimal;
};
```

Si vous travaillez sur *int* il va réserver ce qu'il faut comme place pour le int, par contre si vous travaillez sur le *float* il va réserver ce qu'il faut en float.

Voilà ça permet par exemple de ne pas réserver la taille d'un float si vous mettez qu'un int ou je ne sais quoi, ça évite par exemple de réserver 10 places en mémoire alors que vous avez besoin que de 2 alors je schématise mais c'est pour expliquer l'utilité donc l'union ça sert à ça.

L'union ça sert surtout beaucoup dans les structures par exemple on peut utiliser en jeu vidéo, si vous êtes sur un jeu de tir, vous développer un jeu de tir, une sorte de fps et dans votre jeu que ce soit les alliés ou les ennemis ils ont à peu près les mêmes paramètres c'est-à-dire ils ont des points de vie, ils ont des points d'endurance, ils ont même une vitesse d'attaque, par exemple une résistance, un type d'armes, enfin voyez ce genre de chose, un nom, un pseudo, etc.

Ainsi vous n'allez pas forcément créer une structure pour les alliés et une structure pour les adversaires alors que c'est la même chose en fait, c'est le même personnage donc vous allez créer une structure qui va avoir les points de vie, les types d'armes, etc et de dedans donc dans la structure on irait mettre ce genre de code mais avec `union` et on dirait le type d'entité, par exemple le type joueur `TypeJoueur` et puis on aurait par exemple quelque chose pour dire que tiens on a en fait un ennemi ou un allié.

```txt
union TypeJoueur
{
    int entier;
    float decimal;
}
```

Voilà comme ça en en créant nos structures on pourrait se dire que tel personnage là c'est un allié et puis à un autre moment c'est par un allié mais c'est un ennemi mais peu importe qu'on ait choisi un allié ou un ennemi, on accédera à la même zone mémoire puisque ils fonctionnent pareil au niveau du code (union) donc on ne fait pas de distinction entre les deux.

C'est à l'écran que vous allez voir la différence, au niveau de vos algorythmes, dans les combats, dans les affrontements.

Au niveau du code en lui mêmes voilà que vous ce soit un allié, un ennemi, ils ont tous un prénom, ils ont tous au moins une arme sinon ils ne peuvent pas jouer. Ils ont tous un nombre de points d'endurance, ils ont peut-être un nombre de points quand par exemple ils tuent d'autres adversaires bref quand ils marquent des points.

Je sais pas voyez vous pouvez imaginer plein de choses donc c'est à ça que sert une union.

Alors ce n'est pas forcément très clair, je vous l'accorde.

On fera de toute façon, il y aura ou il y a déjà des exercices pour voir tout ça, toutes les notions de toute manière qu'il y a en informatique sur la chaîne sont des choses que nous allons mettre en pratique dans des exercices, dans des énigmes soit ils sont déjà publiés soit ils ne le sont pas encore tout dépend de quand est ce que vous voyez cette vidéo sur la chaîne.

Dans tous les cas, tout ça vous verrez des cas concrets d'accord je vous montrerai que c'est vraiment utile à certains moments pour certaines choses donc là c'est très vague l'union à la rigueur vous pouvez vous contenter des structures, des énumérations pour commencer.

L'union vous pouvez mettre ça un petit peu de côté parce que ce ne sera pas forcément très utile pour vous tout de suite et on reviendra dessus.

Le jour où je dirais qu'il y a moyen de travailler avec une union on mettra ça en place dans le code et ça aura son utilité au moment présent mais là tout de suite bon ce n'est pas trés on va dire que c'est pas très utile pour le coup par rapport aux exemples que je vous donne mais c'est à savoir d'accord c'est simplement un moyen de regrouper plusieurs données mais qui vont accéder aux mêmes zones mémoires.

Ok ce n'est pas comme une structure cas où chaque membre est différents puisqu'ici voyez l'entier est décimal c'est des variables qui sont dans la même zone mémoire selon les cas.

Alors pour une structure, on en aurait une pour le prénom, on en aura une zone mémoire pour les hp, une zone mémoire pour les mp et cetera comme on avait fait tout à l'heure le Player.

Voilà du coup globalement, je vous ai dit pas tout ce que j'avais à vous dire là dessus.

Je pourrais également vous parler de ce qu'on appelle les champs de bits mais ça c'est surtout utile sur des toutes petites architecture quand par exemple on n'a pas beaucoup de mémoire et qu'on a besoin vraiment de contrôler chacun chaque taille de données en fait au bits près donc vraiment tout petit donc on ne parle même pas d'octet mais on parle de bits près.

Souvent ontilise ce qu'on appelle des champs de bits c'est-à-dire qu'on va faire comme ça un type de structure et on va pouvoir dire bah tiens tel donnée c'est deux bits, une autre c'est 6 puis une autre c'est 1 et cetera donc on va vraiment gérer tout ça.

Alors je ne vois pas l'utilité de vous montrer parce qu'avec les pc qu'on a maintenant et même les téléphones parce qu'avant on pouvait dire qu'ils n'ont pas beaucoup de mémoire mais ça a bien changé, c'est pas utile donc si par contre dans une formation, on fait de la programmation sur systèmes embarqués avec vraiment des toutes petites zones mémoire ça pourrait effectivement être intéressant ou alors j'en ou j'en ai déjà fait encore une fois tout dépend de quand est ce que vous voyez la vidéo, je ferais un tutoriel, une vidéo en annexe pour en parler voilà pour mettre ça en fait à part mais parce que je ne juge pas ça indispensable ou vraiment nécessaire à votre apprentissage du langage c.

Voilà c'est bien de savoir que ça existe aussi les champs de bits et qu'on verra ça éventuellement sur une autre vidéo.

Moi je vous laisse avec ça d'accord on va se retrouver pour la prochaine vidéo.

Je vous ai dit globalement tout ce que je voulais vous dire sur les structures, les énumérations et pour ceux qui sont plus curieux les unions d'accord vous pouvez toujours essayer d'en utiliser et voir un peu l'intérêts que ça peut avoir au niveau de la mémoire notamment.

Dans tous les cas moi je vous laisse avec ça, vous avez vu déjà suffisamment. Il y a déjà déjà de quoi faire avec ça.

Les structures sont très utiles puisque après quand on va aborder les structures de données, on va on va faire des structures partout. Il y aura des structures partout et des énumérations partout donc on va s'en servir sur toutes les dernières vidéos concernant les structures de données sur cette formation donc c'est vraiment à connaître aussi comme pour les pointeur, comme pour les tableaux, tout ça faut vraiment connaître.

Pour la suite on parlera d'allocation dynamique rappelez-vous au niveau des chaînes je vous avait dit qu'on ne pouvait pas par exemple faire tient maintenant la valeur de telle chaîne ça devient ça mais non il fallait passer par strcpy() des trucs comme ça.

On verra qu'on peut maintenant alloués de la mémoire en fonction de ce qu'on a besoin, on peut même réallouer pour rechanger la taille de l'espace mémoire que l'on veut. On peut libérer la mémoire bref on va apprendre à faire tout ça parce que c'est super important c'est ça qui faut aussi la puissance du langage c.

Après en terminera avec tout ce qui est gestion de fichiers et vous aurez avec tout ça vous aurez vu toutes les bases du langage c.

Voilà vous pourrez dire que avec ça, vous connaissez toutes les bases du langage du c, toutes ces notions mêmes j'ai envie de dire parce qu'après les structures de données, le réseau et si on faisait de l'émulation tout ça c'est pas des notions mais c'est juste des mises en pratique du langage mais les notions c'est tout ce que vous avez vu jusqu'à présent c'est les pointeur, les tableaux, les chaînes, plus tard les fichiers et les structures, les variables, les boucles, tout ça ce sont des notions et tout ça vous les connaissez et là il reste deux vidéos après celle-là donc la 15 et la 16.

Voilà à la fin de la 16ème vidéo, la 16e séance vous aurez enfin acquis toutes les bases toutes les notions du langage c. C'est pour ça qu'on dit que langage c est un langage qui a peu de notions en fait qui est pauvre en option puisque il y a pas grand chose mine de rien.

Il n'y a pas de partie objet, il n'y a pas tout ça donc ça allège pas mal l'apprentissage mais notamment au niveau de la mise en pratique ça devient complexe donc on peut faire plein d'autres choses mais ça on le verra pour la suite.

A très bientôt tout le monde, entraînez-vous bien n'hésitez pas à partager, liker et disliker enfin vous faites ce que vous voulez suivant l'intérêt qu'a eu cette vidéo pour vous et on se retrouve pour la prochaine.

Si vous avez des commentaires, des questions, des choses qui ne sont pas clair à ce stade de la formation parce qu'on a quand même bien avancé, vous êtes à la 14ème séance, n'hésitez pas à le demander je vous répondrai volontiers et je vous aiderai comme ça avancer et progresser dans le bon sens.

Allez à bientôt tout le monde on se retrouve pour la séance numéro 15