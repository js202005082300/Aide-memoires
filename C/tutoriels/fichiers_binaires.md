# [Fichiers binaires](https://www.youtube.com/watch?v=_Z39xKbRd2E)

Il est recommandé de voir la séance 16 sur tout ce qui est gestion des fichiers, vous avez besoin de savoir manipuler justement des fichiers dits formaté donc du fichier texte tout simplement avant de suivre cette vidéo.

Voilà on va voir ensemble comment gérer lire et écrire dans des fichiers binaires.

On va partir sur un fichier de base.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    return 0;
}
```

Ok alors la différence c'est qu'un fichier binaire, c'est un fichier dit non formaté c'est à dire qu'il ne va pas enregistrer des informations comme des informations qu'on aurait dans les variables en fait des données statiques en mémoire mais il va enregistrer le contenu de la mémoire vive, la ram en fait.

On va faire une copie de la ram au niveau d'un fichier donc vous obtiendrez à la fin des octets, du binaire qui ne pourra pas être lu par un simple fichier texte sauf si vous avez un éditeur comme par exemple Sublime texte qui lui peut le lire.

Par contre un éditeur de texte standard comme le bloc note par exemple ne peut pas lire de fichiers binaires.

Quand on les ferra on mettra l'extension **.bin** pour apprendre à manipuler ce genre de fichier, écrire et lire par la suite.


Vous allez voir qu'au niveau fonction, au niveau syntaxe, c'est très simple à mettre en place. C'est pour ça qu'il fallait que vous soyez à l'aise en fait avec la séance numéro 16 pour tout ce qui est gestion de fichiers puisqu'on va réutiliser beaucoup de choses que vous avez vues au cours de la formation.

On commence avec une variable de fichiers, de type FILE avec un pointeur, un pointeur qu'on va appeler *fic* comme ceci.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    
    return 0;
}
```

Ensuite une donnée positionx qui vaut 145 et un int positionY égal 86.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int positionX = 145;
    int positionY = 86;
    
    return 0;
}
```

Voilà ça pourrait être la position x et y d'un personnage dans un jeu vidéo dans un jeu en 2d pour pouvoir lors du chargement de la partie revenir à l'endroit où vous vous trouviez en quittant le jeu par exemple.

Ensuite on va vouloir enregistrer ces données-là.

On va donc ouvrir un fichier que s'il n'existe pas devra être créé pour pouvoir écrire dedant.

On utilise fopen() et un fichier appelé save.bin et on va choisir le bon mode alors déjà à la différence du mode formaté donc mode fichier texte, il faudra bien penser à mettre un *b* pour binaire et *w* pour l'écriture et comme on le veux en *ajout* c'est à dire soit ajouter en fin de fichiers s'il existait déjà ou alors créer le fichier s'il n'existe pas, on va mettre *a* càd **wba**.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int positionX = 145;
    int positionY = 86;

    fic = fopen("save.bin", "wba");
    
    return 0;
}
```

Ensuite on vérifie que le fichier a bien pu être ouverts donc si *fic* est *NULL* et on va utiliser fprintf() avec la sortie d'erreur standard (stderr) puis un EXIT_FAILURE pour qu'on quitte le programme parce qu'on n'a pas réussi à ouvrir le fichier et on pense directement.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int positionX = 145;
    int positionY = 86;

    fic = fopen("save.bin", "wba");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }
    
    return 0;
}
```

Ensuite très important on pense directement le fichier et on le fait tout de suite comme ça on est sûr de ne pas l'oublier tout à l'heure et voilà.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int positionX = 145;
    int positionY = 86;

    fic = fopen("save.bin", "wba");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fclose(fic);
    
    return 0;
}
```

Alors en temps normal, si on l'avait fait en mode formaté donc sur un fichier texte, on aurait fait un fprintf() par exemple pour la position x pour la position y.

Si ça avait été une structure, on aurait dû enregistrer chaque variable de la structure de données une par une également mais là vous allez voir qu'il y aura un gros avantage avec les fichiers binaires.

Comment ça va se passer ici ?

On va avoir 2 lignes effectivement, 2 variables qui ne sont pas dans une structure mais qui sont bien distinctes donc on va avoir deux lignes d'écriture.

## fwrite

On va utiliser une fonction pour l'écriture et une autre pour la lecture et on va commencer par fwrite() tout simplement.

fwrite() prend en paramètres quelques informations très simple, la première ça va être un pointer vers la donnée à écrire donc ici écrire puisqu'on parle de fwrite() ce qu'on appellerait un buffer voilà ce qu'on appellerait un tampon qui va recueillir toutes les informations qu'on veut enregistrer pour mettre dedans.

Moi je n'ai pas de pointer et voyez que ce sont des variables simples donc je vais les **passer par adresse**, positionX par exemple je vais le passer par adresse avec le petit & commerciale.

```c
fwrite(&positionX, ...);
```

Ensuite en deuxième paramètre, il nous faut la taille de cet élément et vous voyez que c'est un entier donc je vais faire sizeof() de *int* donc on utilise cette fonction très pratique d'accord pour calculer la taille en octets d'un entier.

```c
fwrite(&positionX, sizeof(int), ...);
```

Ensuite c'est le nombre d'éléments à écrire et nous il n'y en a qu'un seul puisqu'il y a qu'une position *positionX* donc je met 1 et on termine par le fichier, la variable dans lequelle on écrit, *fic*.

```c
fwrite(&positionX, sizeof(int), 1, fic);
```

Voilà donc on va enregistrer la valeur positionX dans un fichier binaire.

Et on fait exactement la même chose pour la positionY.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int positionX = 145;
    int positionY = 86;

    fic = fopen("save.bin", "wba");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fwrite(&positionX, sizeof(int), 1, fic);
    fwrite(&positionY, sizeof(int), 1, fic);

    fclose(fic);
    
    return 0;
}
```

On fait juste ça et c'est bon.

On va donc compiler tout de suite.

Voilà et là vous allez voir qu'au lancement se créer un fichier binaire, save.bin

Si je l'ouvre l'éditeur ne sait pas lire le binaire donc il faudrait un éditeur binaire pour pouvoir lire les 0 et les 1.

Alors on va les lire pour voir s'il les récupère bien au niveau du code et là on verra tout de suite s'il y a eu une erreur au niveau du code.
```
C:.
    main.c
    prog.exe
    save.bin

Donc là on a le fichier binaire qui est là.

Alors ce n'est pas un fichier texte mais si vous regardez au niveau de la taille, il vous met 8 octets parce qu'ici un entier selon les architecture fait 4 octets à priori.

Comme j'ai deux variables de 4 octets, on a bien un fichier de 8 octets.

```powershell
dir save.bin
    1 fichier(s)                8 octets
```

Rappelez vous il ne s'agit pas simplement d'une copie de données il s'agit vraiment de copie de la mémoire vive donc des octets.

Là comme on enregistre deux fois 4 octets en le precisant avec sizeof(int) et on a bien à la fin un fichier de 8 octets.

C'est purement des octets à l'intérieur, c'est du binaire voilà là dessus il n'y a pas de soucis donc ça fait exactement la taille qu'il fallait.

Si j'avais retiré une variable par exemple `int positionY = 86;` et une écriture `fwrite(&positionY, sizeof(int), 1, fic);` on aurait évidemment 4 octets et après si chez vous les entiers font 8 octets a eux tout seul, votre fichier fera 16 octets ect.

## fread

On va lire notre fichier et on va récupérer les informations.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int posX = 145;
    int posY = 86;

    fic = fopen("save.bin", "rb");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fread(...);

    fclose(fic);
    
    return 0;
}
```

fread() fonctionnement exactement pareil que pour l'écriture càd un pointeur *posX* qui est le buffer qui va donc accueillir la donnée et donc on fait le petit et commercial pour le récupérer sous forme d'adresse puisque je n'ai pas de pointer directement; ensuite sizeof() de *int* et il y en a qu'un seul, et ça vient de fichier donc *fic*.

```
fread(&posX, sizeof(int), 1, fic);
```

Voilà maintenant je vais bien évidemment afficher pour voir si j'ai la bonne position "Position du joueur" admettons ect.

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE *fic;
    int posX = 145;
    int posY = 86;

    fic = fopen("save.bin", "rb");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fread(&posX, sizeof(int), 1, fic);
    fread(&posY, sizeof(int), 1, fic);

    printf("Position du joueur (x/y) = %d/%d\n", posX, posY);

    fclose(fic);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
./prog.exe        
Position du joueur (x/y) = 145/86
```

Voyez qu'on obtient bien 145 slash 86 donc on a bien enregistré en binaire les informations comme il fallait.

Voilà c'est simplement un petit fwrite() pour écrire et un petit fread() pour lire qui prennent quatre paramètres à chaque fois soit le pointer vers le buffer donc la donnée en fait, ensuite sa taille, le nombre de cette donnée càd que si avait un tableau admettons de 10 cases on aurait fait sizeof() du type du tableau par exemple sizeof(int) et on aurait mit 10 et si c'était un tableau on aurait pas mis le & commerciale.

```
int tab[10]={0};
ect.
fread(tab, sizeof(int), 10, fic);
```

Pas besoin de faire de boucles, de parcours pour faire toutes les cases une par une alors qu'on aurait du le faire avec un mode formaté.

S'il avait été question d'un fichier texte on aurait dû effectivement faire une boucle pour lire chaque case du tableau et enregistrer une par une chaque donnée.

Là vous voyez l'avantage qu'il y a de passer par le binaire ici, c'est qu'on va aller beaucoup plus vite, on va prendre tout un ensemble et on enregistre comme ça pouf comme des octets puisque pour l'ordinateur tout est binaire voilà les nombres ect. les lettres non plus et tout est constitué de 0 et de 1 donc il va évidemment beaucoup plus vite avec des octets.

## Structure

Alors on va maintenant transformer cet exemple sous forme de structure pour finir cette vidéo parce que là on a dû faire deux écritures et deux lectures pas très pratique.

Là c'est pareil il faut revoir la séance sur les structures.

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int posX;
    int posY;
}Position;

int main(void)
{
    FILE *fic;
    Position po;

    po.posX = 100;
    po.posY = 25;

    fic = fopen("save.bin", "rb");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fread(&posX, sizeof(int), 1, fic);
    fread(&posY, sizeof(int), 1, fic);

    printf("Position du joueur (x/y) = %d/%d\n", posX, posY);

    fclose(fic);
    
    return 0;
}
```

Une structure que l'on nomme *Position* et on passe par une structure plutôt que deux variables distinctes je passe par une structure qui les possède toutes les deux.

Ensuite même chose que tout à l'heure, vous allez le voir en moins de ligne.

```
fwrite()
```

Ici j'ai pas de pointer mais j'ai une structure comme c'est dans une seule variable et bien je n'ai plus à le faire pour le x et y puisque à elle le possède donc je fais simplement ça.

```
fwrite(&po, sizeof(po), 1, fic);
```

sizeof() de la structure *po* ensuite *1* puisque j'ai qu'une seule donnée à passer càd une seule structure attention pas une seule donnée et dans *fic*.

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int posX;
    int posY;
}Position;

int main(void)
{
    FILE *fic;
    Position po;

    po.posX = 100;
    po.posY = 25;

    fic = fopen("sauvegarde.bin", "wba");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fwrite(&po, sizeof(po), 1, fic);

    fclose(fic);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
./prog.exe  
```

Voilà on crée un fichier sauvegarde.bin

On va faire la même chose que tout à l'heure à l'envers.

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int posX;
    int posY;
}Position;

int main(void)
{
    FILE *fic;
    Position po;

    po.posX = 100;
    po.posY = 25;

    fic = fopen("sauvegarde.bin", "rb");

    if(fic == NULL)
    {
        fprintf(stderr, "Erreur ouverture fichier.\n");
        exit(EXIT_FAILURE);
    }

    fread(&po, sizeof(po), 1, fic);

    printf("X = %d | Y = %d\n", po.posX, po.posY);

    fclose(fic);
    
    return 0;
}
```
```powershell
gcc main.c -o prog
./prog.exe        
X = 100 | Y = 25
```

On a tout récupérer dans la structure ici.

Voyez pour une structure c'est beaucoup plus rapide, j'ai une seule écriture pour la structure complète.

Vous pourriez avoir ici 15 variable dans cette structure.

```
typedef struct
{
    int posX;
    int posY;
}Position;
```

Normalement on pourrait aller plus loin si on manipule par exemple des structures avec beaucoup de pointers etc. mais dans le monde professionnel ou dans les cas concret on va surtout parler de **sérialisation** c'est à dire qu'on va concatener les données ensemble pour avoir un espèce de protocoles de transmission.

On le fait beaucoup en réseau pour transmettre des données plus facilement dans un buffer justement et ça permet d'enregistrer facilement les données puisque si vous ne faisiez pas comme ça notamment au niveau pointer en récupérant par exemple des données d'un fichier binaire vous essayeriez d'accéder à des zones réservées qui ne sont plus donc les mêmes et du coup vous aurez des plantages du programme et cetera.

Là c'est plus de la *sérialisation*, c'est des choses un peu plus complexe mais je ne pense pas que ce soit utile d'aborder ici si vraiment il y avait des gens qui étaient intéressés par la *sérialisation*.

Attende les formations c++ et java ect, là on en fera parce que ça s'y prête plus mais en c enseignez vous de votre côté parce que on ne peut pas tout voir.

*sérialisation* avec le langage c s'est pas spécialement intéressant par contre si vous voulez vous renseigner allez-y.

Retenez fwrite(), fread() qui permet de faire une lecture très rapide puisque c'est une copie de la mémoire vive dans un fichier ou la restitution d'un fichier donc des données que vous pouvez faire avec fread() et fwrite() puisque on manipule des buffers et on manipule ici carrément des octets et pas seulement un mode comme ça formaté avec des fichiers donc on parle de **gestion de fichiers en mode non formaté** d'accord c'est la différence.

Formaté c'est du fichier texte et non formaté c'est du binaire.

Voilà à très bientôt.