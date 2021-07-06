# [13. Chaînes de caractères](https://www.youtube.com/watch?v=tDE4FNCcP0k)

Bonjour, bienvenue pour cette treizième vidéo sur le langage c, nous allons aborder les chaînes de caractères alors on avait terminé avec le tableau et il y avait eu beaucoup beaucoup beaucoup de choses alors ça ne va pas forcément être plus court pour cette vidéo-là puisqu'on va avoir beaucoup de choses également.

Ce sera peut-être un petit peu plus calme pour la suite voilà.

A la suite, on verra des choses un petit peu plus simple, un petit peu plus simple, un peu plus détendue là c'est vraiment des parties assez conséquente puisque encore une fois on reste dans le domaine des pointeurs tout ça, c'est encore un petit peu frais pour vous, encore un peu nouveau et on va parler des chaînes de caractères.

## Définition

Les chaînes de caractères très rapidement, c'est tout simplement des textes voilà c'est un nom très informatique après vous comprendrez pourquoi par la suite mais ce qui faut comprendre c'est ça si vous voulez manipuler des mots, du texte, des dialogues dans un jeu dans un programme, des messages, on va utiliser des chaînes de caractères ou tout simplement le nom string qu'on leur donne en anglais.

Ainsi on va manipuler tout ça et voir un peu ce qu'on peut faire avec en tout cas.

Alors le langage c est un langage qui demande beaucoup de rigueur, je vous avais dit que c'était sa langage de bas niveau si on compare à d'autres langages comme Python, comme java, etc, il nécessite beaucoup de rigueur puisque vous ne pourrez pas faire tout ce que vous voulez et tout n'importe quoi avec les chaînes de caractères sinon vous aurez évidemment des plantages donc il va falloir faire attention à ce que vous faites puisqu'on va manipuler évidemment des pointeur, des tableaux donc faudra faire attention comment vous travaillez en fait avec la mémoire et les affichages, etc.

Je vais tout bien vous expliquer et normalement, vous aurez tout compris à la fin de cette vidéo.

Alors on va faire comme d'habitude, je vous ai expliquer ce que c'était une chaîne grosso modo en tout cas, je vous ai dit ce que c'était pour le commun des mortels si je peux m'exprimer ainsi et on va voir rapidement comment fonctionne une chaîne, comment on différencie ça avec autre chose.

Alors une chaîne si vous voulez une définition informatique d'accord c'est tout simplement un tableau de caractère c'est-à-dire que vous allez avoir un tableau donc il va y avoir un espace mémoire qui va être contigu alors je ne vous ai pas gardé un schéma, etc puisqu'on l'a vu dans la vidéo précédente, je pense que c'est clair pour vous et chaque case du tableau en fait va être une lettre donc un caractère.

## Déclaration et initialisation

Vous savez ce qu'est un caractère en informatique notamment en langage c c'est tout simplement de type **char** d'accord on va même utiliser **signed char** comme je vous avais  dit dans les premières vidéos que c'était mieux quand on utilise un char tout cours de bien préciser qu'il était signé.

Signé ça veut dire qu'il peut être négatif ou positif même si là on ne va pas l'utiliser pour des chiffres mais on l'utiliserait pour des chaînes donc on peut travailler là-dessus il n'y aura pas de souci donc c'est tout simplement ça, c'est un tableau en fait de plusieurs caractères donc de types char tout simplement d'accord on va donc mettre ça.

```c
#include <stdio.h>

int main(void)
{
    signed char

    return 0;
}
```

Vous pouvez mettre *char* tout court mais moi je met quand même *signed char* c'est mieux, c'est plus propre et je vais lui donner un nom toujours pareil je vais mettre *mot* et on va rester comme ça et on va voir comment le créer donc la manière la plus simple c'est de faire ceci.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[] = "Bonjour tout le monde !";

    return 0;
}
```

Voilà on ne peut pas faire plus simple, vous mettez des crochets comme pour un tableau ainsi on ne met rien dedans et vous mettez le texte que vous voulez d'accord entre double guillemets ou simple mais là bon si j'avait des apostrophes je préfère mettre des doubles, terminé par un point virgule.

Automatiquement le compilateur va calculer le nombre de caractères qu'il faut puisqu'on l'a pas précisé qu'on l'a fait à la déclaration d'accord donc là c'est lui qui va s'occuper de tout ce qui est allocation mémoire d'accord donc là il n'y a pas besoin d'être plus strict que ça.

```txt
signed char mot[] = "Bonjour tout le monde !";
```

Là vous faites les choses proprement et on va afficher tout simplement cette valeur.

## Afficher

Pour afficher on va utiliser le symbole %s avec s pour string tout simplement c'est pas un d pour décimale ou autre c'est vraiment le s pour string et on y va, on va mettre un petit \n pour le retour à la ligne et on indique juste le nom parce que c'est comme pour un tableau il n'y a pas besoin de & comme pour une variable. Vous mettez juste le nom bien évidemment ça fonctionnera.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[] = "Bonjour tout le monde !";

    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Bonjour tout le monde !
```

On va tester, on compile, on exécute maintenant et vous voyez qu il m'affiche tout le texte complet d'accord j'aurais pu mettre un simple prénom n'importe quoi ça va fonctionner aussi donc c'est pour ça que je n'ai rien précisé dans les crochets car c'est lui qui va faire les calculs tout seul et il va bien allouer la mémoire comme il faut et va vous l'afficher pas de problème. Il ne va pas broncher, tout va bien fonctionner.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[] = "Jason";

    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Jason
```

## Préciser une taille

Je peux aussi lui préciser une taille et là il va falloir faire attention parce que vous aurez une petite différence.

```txt
signed char mot[] = "Jason";
```

Là par exemple pour mon prénom voyez que j'ai un, deux, trois, quatre, cinq caractères on pourrait ainsi se dire je fais un tableau de cinq char `signed char mot[5] = "Jason";` puisque ça paraît logique mais pas tout à fait, il faut savoir que pour donc au niveau des chaînes de caractères ... je ne vais pas utiliser de logiciel de schémas, je vais le noter dans les commentaires ce sera suffisamment explicite ...

```c
/*
    ['J']
    ['a']
    ['s']
    ['o']
    ['n']
*/
```

Si on imagine en mémoire d'accord comment que ça se passerait, on aurait donc la première case du tableau ce serait ça `[J]`, on aurait ensuite ça `[a]`, on aurait ça `[s]`, ça `[o]` et ça `[n]` et même pour être plus exact je peux mettre entre simple quote pour montrer que ce sont des caractères `['J'] ['a'] ['s'] ['o'] ['n']`.

Le problème c'est que ça ne suffit pas parce qu'on a pas de symbole de fin c'est-à-dire que le programme ne sera pas quand est-ce que s'arrête la chaîne et on risque d'accéder à une  zone mémoire non autorisée et on aurait un plantage donc pour les chaînes de caractères on a un petite différence par rapport à des entiers ou autre, on a un caractère qui va dire que c'est la fin de la chaîne.

Le caractère de la fin de la chaîne, c'est anti slash 0 d'accord `['\0']`.

```c
/*
    ['J']
    ['a']
    ['s']
    ['o']
    ['n']
    ['\0']
*/
```

C'est comme ça qu'il est représenté pour dire là `['\0']` on arrive à la fin d'une chaîne d'accord donc vous voyez par exemple si je veut stocker mon prénom dans une variable en fait donc un tableau tout simplement une chaîne de caractères, je vais non pas devoir avoir 5 case mais 6 donc c'est important de faire ça.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[6] = "Jason";

    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Jason
```

Il faut faire comme ça sinon on va avoir des erreurs et là même chose ça fonctionne d'accord pas de souci.

Si je mets moins que 6, je vais avoir un plantage et je vais avoir des problèmes à ce niveau-là donc c'est important de toujours compter le symbole de fin d'accord le nombre de caractères.

Si après vous ne voulez pas vous amuser à devoir compter vous faites ça `[]` au lieu de `[6]` et là votre tableau va être créé à la taille qu'il faut en fait.

```c
signed char mot[] = "Jason";
```

Ainsi là il va être créé exactement à la taille en fonction de ce que vous avez mis ici `"Jason"` d'accord c'est important.

Alors attention là je viens de déclarer et initialiser le tableau ok donc j'ai déclaré, j'ai initialiser qu'une valeur.

C'est le seul moment donc l'initialisation où vous pouvez mettre en dur un texte ça veut dire que je ne peux pas par exemple m'amuser à faire ça.

Voilà par exemple on ne peut pas dire que mot vaut *Salut tout le monde*, quelque chose de plus grand et après de l'afficher d'accord.

On peut s'amuser à tester mais ça va planter.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[6] = "Jason";

    printf("%s\n", mot);

    mot = "Salut tout le monde";
    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
main.c: In function 'main':
main.c:18:9: error: assignment to expression with array type
   18 |     mot = "Salut tout le monde";
      |
```

Voilà il ne s'embête même pas de toute manière car il ne veut pas ça.

Voyez, il refuse carrément de modifier pour le moment après je pourrai trifouiller mais de toute façon ça ne marche pas, ce n'est tout simplement pas possible puisque là quand il a  créé ça `"Jason"`, il a créé un tableau de 6 cases et voyez que maintenant il lui demande maintenant d'agrandir le tableau ça il ne sait pas le faire. 

On verra plus tard comment on peut gérer dynamiquement les espaces mémoire, on parlera d'allocation dynamique c'est une vidéo qui viendra à la suite de cette formation mais pour le moment on ne sait pas faire, on ne sait pas modifier comme ça des espaces de stockage ou en réserver d'autre donc on ne pas agrandir un tableau comme ça et s'amuser avec.

Un tableau c'est que de base, on le crée avec un certain nombre de cas mais une fois que c'est fait ça ne change plus, il gardera ce même nombre de cases donc c'est à dire ici `[6]` Vous ne pouvez pas l'agrandir et même si je fais ça `mot = "Toto";` bref en mettant moins de caractères on pourrais se dire que ça rentre mais le problème n'est pas réglé pour autant..

```c
#include <stdio.h>

int main(void)
{
    signed char mot[] = "Jason";

    printf("%s\n", mot);

    mot = "Toto";
    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
main.c: In function 'main':
main.c:9:9: error: assignment to expression with array type
    9 |     mot = "Toto";
      |  
```

Toujours pareil, ça ne résout pas le soucis, on ne peux pas faire ça tout simplement parce qu'encore une fois on va gérer la mémoire d'une certaine manière ainsi il y a la mémoire qui a été réservée enfin l'espace a été réservé en mémoire donc on ne peut pas s'amuser à tout modifier comme ça comme on veut, on pourra par contre procéder à d'autres manières mais on verra plus tard.

## Intialiser comme un tableau

Ainsi donc déjà vous savez comment créer, déclarer, initialiser une chaîne de caractères donc notamment un texte, vous pouvez soit mettre des crochets vide comme là `signed char mot[] = "Jason";` et ça va directement choisir la taille, soit vous mettez la taille entre crochets comme pour un tableau pour vous dire combien de caractère en comptant n'oubliez pas un caractère de plus `['\0']` d'accord par rapport à si c'était des entiers pour le caractère de fin de chaîne d'accord.

Ce caractère `['\0']` est important donc ne l'oubliez ça ne marchera pas et donc vous n'aurez pas votre votre tableau d'affiché.

On peut aussi procéder comme ça `signed char mot[] = {'J', 'a', 's', 'o', 'n'};` puisque je vous avais dit que c'était un tableau de char donc je peux très bien faire ça puisque c'est exactement ça qui se passe alors pas besoin d'afficher le caractère de fin `'\n'` d'accord ça c'est le programme qui va s'occuper de l'ajouter lui-même tout seul comme un grand ainsi vous faites juste ça et vous allez voir que c'est que c'est comme tout à l'heure.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[] = {'J', 'a', 's', 'o', 'n'};

    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Jason`¸_èD
```
:warning:
```txt
signed char mot[6] = {'J', 'a', 's', 'o', 'n'}
```
```powershell
gcc *.c -o prog
./prog
Jason
```

Tout pareil, aucun changement puisque `{'J', 'a', 's', 'o', 'n'}` est un tableau, rappelez-vous que ça c'est une syntaxe que vous avez découvert dans la vidéo d'avant ok donc c'est simplement un tableau de cinq cases de caractères et il y en a en fait une sixième avec le fameux anti-slash 0 qui est le caractère de fin de chaîne donc ça fonctionne aussi on peut procéder de cette manière là, il n'y a pas de problème.

Alors je peux aussi m'amuser à déclarer le mot comme ça `signed char mot[6];` donc avec une taille, et puis dire de stocker dans le mot 0 de stocker le J d'accord puis dans mot 1 tu stocke le a et cetera et cetera.

```c
#include <stdio.h>

int main(void)
{
    signed char mot[6];

    mot[0] = 'J';
    mot[1] = 'a';
    mot[2] = 's';
    mot[3] = 'o';
    mot[4] = 'n';

    printf("%s\n", mot);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Jason
```

On peut aussi d'accord tout ça c'est des tableaux, c'est pour ça que je vous dis que dans les chaînes de caractères on travail avec des tableaux aussi, on utilise les tableaux mais je ne vais pas revenir dessus vous l'avez vu dans la vidéo précédente donc vous savez comment ça fonctionne.

Après il y a des méthodes plus ou moins longue, plus ou moins pratique, plus ou moins  conseillées et cetera mais vous savez comment ça fonctionne d'accord c'est tout simplement ça.

Tout ce que vous avez à savoir, c'est qu'une chaîne de caractères c'est un tableau de caractère tout simplement puisque j'aurais pu en temps normal si j'avais déclaré simplement un caractère, j'aurais pu dire ça `signed char lettre = 'A';`. Vous avez vu la représention omment on fait ça pouf et là je pouvait l'afficher avec le `%c`, on l'avait vu sur les variables, o peut affichr la lettre d'accord.

```c
#include <stdio.h>

int main(void)
{
    signed char lettre = 'A';

    printf("%c\n", lettre);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
A
```

Alors si on change complétement `signed char lettre[] = "A";` et on affiche avec un %s.

```c
#include <stdio.h>

int main(void)
{
    signed char lettre[] = "A";

    printf("%s\n", lettre);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
A
```

Ainsi là on change complètement, là on passe à une chaîne ok c'est deux choses différentes.

Voilà donc ça c'est la petite distinction à savoir à ce niveau là c'est que à la déclaration et surtout à l'initialisation, vous pouvez mettre le texte que vous voulez mais c'est tout vous ne pouvez plus après le changer ou en tout cas mettre n'importe quoi comme vous voulez donc on verra plus tard comment on peut modifier les espaces donc ça c'est une première chose à savoir.

## Modifier une chaîne

Comment peut-on modifier par exemple des chaînes ? mettons je veux faire un programme qui demande le prénom d'utilisateur et bien vous faites ça `signed char prenom[];` tout simplement on fait *prenom* et vous choisissez une taille un peu près. Voilà vous dites par exemple moi un prénom, je ne veux pas qu'il dépasse, je ne sais pas, pour moi un prénom c'est 25 caractères maximum admettons on dirait donc de coup 26 `signed char prenom[26];` et là après vous faites la demande tout simplement `printf("Comment tu t'appelles ? ");`, un petit scanf mais ce n'est pas sécurisé du tout avec le scanf() pour le coup mais encore une fois on ne fait pas ça pour sécuriser et attention vous ne mettez pas de symboles et commercial `&` c'est-à-dire n'oubliez pas qu'on travail comme pour des pointeurs, ça c'est comme pour un tableau dont vous mettez juste le nom `scanf("%s", prenom);` d'accord.

```c
#include <stdio.h>

int main(void)
{
    signed char prenom[26];

    printf("Comment tu t'appelles ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? Jason
Ton prenom -> Jason
```

Ainsi on a comme un tableau `scanf("%s", prenom);` donc on met juste le nom comme pour les pointeurs, idem avec le printf().

Si on compile et si on exécute, ça fonctionnera bien évidemment puisque Jason, c'est que 5 lettres, 5 caractères plus le caractère de fin de chaîne ainsi ça rentre dans 26 cases d'accord ça passe.

Par contre si je m'amuse à faire ça `signed char prenom[3];` avec moins de cases.

```c
#include <stdio.h>

int main(void)
{
    signed char prenom[3];

    printf("Comment tu t'appelles ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? Jason
Ton prenom -> Jason
```

Alors ça aurais du forcément planté mais regardez ça compile et là par contre il a gardé 3 ici `[3]` mais je vais avoir des problèmes en fait au niveau de la gestion d'accord donc il faut faire vraiment attention à ça, de ne pas réserver des espaces comme ça n'importe comment.

```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? progrgz
Ton prenom -> progrgz
```

Voilà donc là il n'a pas trop broncher non plus mais :warning: il faut vraiment réserver l'espace nécessaire d'accord au niveau de la place que vous voulez.

Par la suite, on verra qu'on pourra en fait lire par exemple un nom et après réserver en mémoire exactement le nombre de caractères qu'il nous faut par rapport à ce que l'utilisateur à rentrer et là le problème c'est qu'on ne peut pas le deviner donc on peut choisir des valeurs approximatives c'est-à-dire qu'on prend des valeurs de tampon ce qu'on appelle des buffers c'est-à-dire qu'on dira qu'un buffer c'est 256 caractères, c'est par paquet de 256 et on est à peu près sûr que 256 caractère ça va prendre tous les prénoms qui existent au monde parce qu'il y a personne qui aurait un prénom aussi long que ça donc en faisant ça `signed char prenom[256];` on est sûr de ne pas avoir de souci au programme mais le problème c'est que ce n'est pas sécurisé.

```c
#include <stdio.h>

int main(void)
{
    signed char prenom[256];

    printf("Comment tu t'appelles ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? Jason
Ton prenom -> Jason
```

Le problème c'est que ce n'est pas sécurisé, là mon programme n'a pas planté ici mais il  aurait pu d'accord je pourrais avoir des comportements inattendus mais attention il y a des moyens beaucoup plus sûr que ça bien évidemment que la fonction notamment scanf() mais là je ne vais pas montrer d'autres fonctions de lecture, de saisie puisqu'il y a un tutoriel ou il y aura toujours pareil ça dépend de quand vous regardez cette vidéo, peut-être que la vidéo a déjà été fait depuis ou pas c'est-à-dire une vidéo pour faire de la lecture sécurisé d'accord de la saisie utilisateur de manière sécurisée où on parlera de fgets(), on parlera de plein d'autres fonctions pour le faire et notamment les fonctions à ne pas utiliser ou alors à utiliser vraiment sachant ce que vous faites parce que scanf() est une fonction qui de base n'est pas sécurisée du tout du tout du tout.

Voilà scanf() n'est pas du tout propre pour faire de la saisie encore une fois, on devrait faire quelque chose en fait pour contrôler le nombre de caractères que l'on prend au maximum mais peu importe on verra ça dans un tutoriel, on verra ça dans un tutoriel pour ça ou alors vous l'avez déjà publié sur la chaîne si à l'heure où vous regardez cette vidéo, j'ai déjà fait le tutoriel sur la chaîne.

Ok donc ça c'est bon, on ne va pas compliquer la chose, on voulait rester là-dessus.

Si maintenant, on décidait de modifiais par exemple comme tout à l'heure...

```c
#include <stdio.h>

int main(void)
{
    signed char prenom[256];

    printf("Comment tu t'appelles ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    printf("Comment tu t'appelles maintenant ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? Jason
Ton prenom -> Jason
Comment tu t'appelles maintenant ? Jean-Philippe
Ton prenom -> Jean-Philippe
```

Alors je n'ai pas de plantage parce que j'ai 256 encore une fois et je crois même que c'est mon compilateur qui est aux dernières normes c'est pour ça que j'ai des plantages que je n'ai pas mais peu importe, vous il y a de fortes chances que ce genre de programme ça plante parce qu'encore une fois au delà de 256, il va vous dire que vous accédez à des zones mémoires non autorisées puisque normalement on ne doit pas pouvoir faire ça.

Il est vrai qu'avec les nouvelles normes, on a les choses qui sont entre guillemets améliorées donc du coup moi ça ne plante pas, j'ai du bol !

Voilà ne pensez pas que du coup ça se passera bien parce que sinon il y aura des soucis à ce niveau là.

Ce qu'il faut savoir en revanche, c'est quand on a ce genre de caractère `signed char` et qu'on veut remodifier la valeur d'une chaîne de caractères d'ailleurs si on compile avec un `char` parce que j'aurais aimé que ça plante pour vous montrer mais du coup je suis sûrement dans les nouvelles normes.

```c
#include <stdio.h>

int main(void)
{
    char prenom[256];

    printf("Comment tu t'appelles ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    printf("Comment tu t'appelles maintenant ? ");
    scanf("%s", prenom);

    printf("Ton prenom -> %s\n", prenom);

    return 0;
}
```
```powershell
gcc *.c -o prog
./prog
Comment tu t'appelles ? Jason
Ton prenom -> Jason
Comment tu t'appelles maintenant ? Jean-Philippe
Ton prenom -> Jean-Philippe
```

Du coup ça n'a pas planté mais ce n'est pas grave je vais vous apprendre les bonnes habitudes, je ne vais pas vous apprendre les mauvaises habitudes parce que dans les dernières normes ça fonctionner donc c'est bien que vous ayez quelque chose qui fonctionne partout pour tout le monde c'est un petit peu le but quand même ok.

Voilà alors ce qu'il faut savoir c'est qu'en général quand on va modifier quelque chose comme ça donc admettons on aurais par exemple un buffer `char stockage[256];` et puis prenom serrais un tableau de 25 `char prenom[25];` ok ce genre de chose. Alors par défaut, on aurais ceci comme prenom `char prenom[25] = "Jason";` ainsi en temps normal, on ferrait un petit printf() pour afficher le prenom de base et ensuite, on va lui demander de changer son prénom en faisant un scanf() sur stockage en espérant que la personne ne dépassera pas 256 caractères sinon ça plante.

```txt
#include <stdio.h>

int main(void)
{
    char prenom[25] = "Jason";
    char stockage[256];

    printf("Ton prenom de base : %s\n", prenom);

    printf("Changer ton prenom ? ");
    scanf("%s", stockage);

    return 0;
}
```

## Fonctions

### strcpy

Et finallement, on va utiliser une fonction pour copier, vous allez voir laquelle son nouveau prénom mais pour ça on va donc ajouter un fichier d'en-tête, le fameux `#include <string.h>` avec string pour les chaînes de caractères ainsi il sert à utiliser plein de fonctions pour les chaînes c'est fait pour ça et on va en découvrir une première très utile qui est justement la fonction de copie donc on va faire un strcpy() qui prend en premier paramètre la destination donc c'est l'endroit où ça va arriver à la fin donc moi je vais envoyer du coup sur *prenom* et je vais dire que tu me copie ce qu'il y a dans *stockage* en fait, `strcpy(prenom, stockage);`.

```txt
#include <stdio.h>
#include <string.h>

int main(void)
{
    char prenom[25] = "Jason";
    char stockage[256];

    printf("Ton prenom de base : %s\n", prenom);

    printf("Changer ton prenom ? ");
    scanf("%s", stockage);

    strcpy(prenom, stockage);

    printf("Ton prenom de base : %s\n", prenom);

    return 0;
}
```

D'accord attention si vous voulez, vous voyez le problème qu'il pourrait y avoir sachant comme c'est plus gros ici `char stockage[256];` mais par contre je ne sais pas si le programme va planter.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char prenom[25] = "Jason";
    char stockage[256];

    printf("Ton prenom de base : %s\n", prenom);

    printf("Changer ton prenom ? ");
    scanf("%s", stockage);

    strcpy(prenom, stockage);

    printf("Ton prenom de base : %s\n", prenom);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Ton prenom de base : Jason
Changer ton prenom ? Toto
Ton prenom de base : Toto
./prog
Ton prenom de base : Jason
Changer ton prenom ? Jean-Paul Gauthier
Ton prenom de base : Jean-Paul
```

Voilà là par contre le mot a été coupé, j'ai quand même des choses que le compilateur sécurise puisque normalement il devrait planter à y avoir des plantages avec tout ça. Il y a des choses pas normales, il devrait y avoir des débordements de mémoire mais peu importe il y a des choses qui ont été corrigés sur les nouvelles versions des compilateurs mais peu importe dans tous les cas, ce qui est important de voir voilà ici il y aurait des pertes de données enfin bref ce n'est pas top.

Mais en tout cas, si vous voulez recopier quelque chose donc modifier la valeur d'une chaîne de caractère, il faut passer par la fonction strcpy() c'est plus propre.

C'est simplement à la création d'une chaîne `char prenom[25] = "Jason";`, vous pouvez mettre quelque chose en dur comme je l'ai fait-là par contre à partir du moment où vous voulez enregistrer autre chose d'accord **s'il y avait déjà une valeur avant, il faut utiliser le strcpy()**.

J'aurais pu aussi d'ailleurs faire ça pour simplifier.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char prenom[25] = "Toto";

    printf("Ton prenom de base : %s\n", prenom);

    strcpy(prenom, "Jason");

    printf("Ton prenom de base : %s\n", prenom);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Ton prenom de base : Toto
Ton prenom de base : Jason
```

Voilà ça fonctionne aussi, strcpy() prend une chaîne de caractères on source qu'elle va copier dans la destination mais ça peut être soit une variable du coup ou une chaîne en dur, ça fonctionne bien évidemment donc ça c'est une première fonction à connaître.

Ok je voulais vous montrer donc [fonction des chaînes] donc on a strcpy() qui copie une chaîne dans une autre.

```c
/*
    [Fonction des chaînes]
        strcpy(<destination>, <source>) : copie une chaîne dans une autre
*/
```

Faites attention, voyez que c'est inversé, la destination c'est le premier paramètre d'accord et pas l'inverse car c'est beaucoup comme ça en informatique surtout en langage assembleur où on a souvent par rapport aux instructions, on a la destination avant la source.

C'est comme ça, c'est une par habitude donc ça c'est une première fonction à connaître avec strcpy() donc je passe rapidement dessus, on aura l'occasion de l'utiliser, vous verrez que sans elle on aura des plantages tout ça, vous aurez des cas plus concret mais là malheureusement je n'ai pas réussi à faire planter mon programme mais c'est pas bien grave ça arrivera pour une fois justement que ça ne plante pas !

On verra justement des cas où vous verrez que ça ne marchera pas, vraiment des clés explicite.

## strlen

On peut voir une autre fonction aussi très pratique c'est-à-dire que c'était intéressant pour toute à l'heure par rapport à ce que je vous avais montré, c'est pour calculer la taille d'une chaîne et ça c'était super intéressant tout à l'heure quand on avait fait ça mais on utilise strlen().

```c
#include <stdio.h>
#include <string.h>

/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne
*/

int main(void)
{
    char texte[] = "Jason";

    printf("Texte : %s\n", texte);
    printf("Taille du texte : %d\n", strlen(texte));

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Texte : Jason
Taille du texte : 5
```

Voilà 5 donc voyez qu'il ne compte le caractère de fin de chaîne bien évidemment d'accord je veux savoir la longueur du texte en lui-même donc strlen() retourne la longueur d'une chaîne (sans caractère de fin de chaîne).

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans caractère de fin de chaîne)
*/
```

Voilà on ne compte pas le caractère de fin de chaîne puisqu'il ne fait pas partie du mot c'est juste pour l'informatique, on va dire qu'humainement parlant il n'existe pas c'est pour le pc, pour l'ordinateur qu'il existe, au niveau de la mémoire.

Voilà donc strlen() qui permet de compter comme ça les caractères d'une chaîne tout simplement.

Alors je vais un peu vite sur les fonctions puisque le but en fait c'est que je vous explique les fonctions les plus utilisées et puis après on aura l'occasion de les utiliser dans d'autres vidéos, dans des tutos, vous dans execices, des énigmes que je proposerai par la suite et puis vous aussi de manière personnelle donc je les passe assez rapidement mais on aura l'occasion de les voir?

Ne vous en faites pas, ce n'est pas des fonctions que je vous montre puis qu'on va oublier ensuite on n'en parlera plus ... non non on va vraiment avoir l'occasion de les utiliser peut-être pas forcément toutes mais en tout cas, on en utilisera quelques unes.

## strcmp

On peut avoir également le strcmp(), ça je vais en parler qui va permettre de comparer deux chaînes (léxicographiquement), de manière lexical en fait tout simplement.

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
*/
```

Tout simplement lexique d'accord c'est-à-dire au niveau de la table askii, au niveau du lexique comme pour un dictionnaire, au niveau des mots.

Alors comment va-t-on comparer des mots, regardez on va faire mot1[] et un mot2[].

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char mot1[] = "Jason";
    char mot2[] = "Bateau";


    return 0;
}
```

Alors je met des majuscules mais ce n'est pas forcément obligé d'accord et on peut faire un test ok c'est-à-dire qu'on va faire `int test = strcmp(mot1, mot2);` et je vais faire un petit test. Qu'est-ce qu'elle renvoie cette fonction ? Elle va renvoyer 0 d'accord si les deux chaînes sont lexicographiquement égal, identique c'est-à-dire qu'en fait le mot est égal.

Ainsi si par exemple j'ai deux fois le même mot, ça va renvoyer 0.

Si jamais au niveau du lexique le mot1 est avant le mot2, on aura un nombre négatif et si c'est inverse si le mot1 est après le mot2, on aura un nombre positif d'accord ça va simplement renvoyer ça donc je peux simplement dire bah si `if(test == 0)` on va afficher que *Les deux mots sont les mêmes.* sinon si `if(test < 0)` on va afficher que *mot1 est avant mot2*, et sinon *mot1 est après le mot2*.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char mot1[] = "Jason";
    char mot2[] = "Bateau";
    int test = strcmp(mot1, mot2);

    if(test == 0)
        printf("Les deux mots sont les memes.\n");
    else if(test < 0)
        printf("%s < %s\n", mot1, mot2);
    else
        printf("%s > %s\n", mot1, mot2);

    return 0;
}
```

On dira `%s < %s` même si ça ne veux pas dire grand chose pour des mots mais comprenez plus petit dans l'ordre dictionnaire, lexicographique d'accord ok donc on va tester.

```powershell
gcc main.c -o prog
./prog
Jason > Bateau
```

Voilà donc là, il vous met que Jason est après d'accord qu'il est plus grand parce que la lettre j est après la lettre b dans l'ordre alphabétique.

Si maintenant vous mettez le même mot, il vous dira que les deux mots sont les mêmes et cetera et cetera.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char mot1[] = "Jason";
    char mot2[] = "Jason";
    int test = strcmp(mot1, mot2);

    if(test == 0)
        printf("Les deux mots sont les memes.\n");
    else if(test < 0)
        printf("%s < %s\n", mot1, mot2);
    else
        printf("%s > %s\n", mot1, mot2);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Les deux mots sont les memes.
```

Et cetera.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char mot1[] = "Jason";
    char mot2[] = "Toit";
    int test = strcmp(mot1, mot2);

    if(test == 0)
        printf("Les deux mots sont les memes.\n");
    else if(test < 0)
        printf("%s < %s\n", mot1, mot2);
    else
        printf("%s > %s\n", mot1, mot2);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Jason < Toit
```

Voilà ok donc c'est vraiment l'ordre lexicographique d'accord tout ce qui est l'ordre comme le dictionnaire en fait comme si vous cherchez un mot dans le dictionnaire qu'est-ce qui serait avant au niveau des caractères. Par exemple, ça peut servir à ranger les mots dans l'ordre alphabétique ainsi ça peut servir à ça éventuellement.

Voilà pour cette fonction donc j'ai un petit peu tardé dessus mais bon elle est utile, je vous montre en premier les fonctions les plus utilisées, celles qu'on utilise vraiment un peu tout le temps, c'est vraiment ces trois-là.

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
*/
```

Ces trois-là, on les revoit souvent.

## strcat

On va en voir 3 ou 4 autres un peu près donc on va regarder un petit peu tout ça, celles qui me viennent en tête via notamment la petite fonction strcat() qui va concatener deux chaînes.

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
        strcat() : concatener deux chaînes (fusionner)
*/
```

Concatener, c'est les coller, rassembler, les fusionner. Comment ? déjà on ne va pas faire ça sur 3 chaînes pour le moment pour ne pas faire un strcat() dans un strcat().

```txt
char mot1[] = "Boul";
char mot2[] = " et ";
char mot3[] = "Bill";
```

Alors on va rester simple sinon ça va être compliqué.

Je ne pas vous compliquer les choses, ça ne sert à rien.

Voilà un petit print() pour faire le strcat() de mot1 et mot2 donc on met mot1 avant mot2 tout simplement et ça va tout simplement faire ceci.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char mot1[] = "Boul et ";
    char mot2[] = "Bill";

    printf("%s\n", strcat(mot1, mot2));

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Boul et Bill
```

Boul et Bill, ok donc on va voir comme ça à la suite, ainsi ça peut être utile des fois de devoir concatener des choses, ça peut être utile dans certain programme, c'est pour ça que je vous en parle.

On continue au niveau de ces fonctions donc je vais avancer un peu plus vite pour les dernières puisqu'on va les utiliser un petit peu moins quand même.

Alors j'ai regardé mais sprintf() n'est pas dans le fichier d'en-tête string.h mais dans stdio.h donc j'en parlerais après. Je terminerais par celle-là ainsi je voulais vraiment en parler parce qu'elle peut être très utile aussi. Elle permet en fait d'écrire dans une chaîne c'est-à-dire qu'on ne va pas écrire dans un fichier comme vous le verrez bientôt, on ne va pas écrire sur la sortie donc afficher comme un printf().

Voilà au lieu d'un printf() qui lui écrit sur votre écran en fait sur la sortie ici en console, on va avoir sprintf() qui va écrire dans une chaîne donc il va en fait stocker dedans.

On verra ça à la fin parce que c'est dans le fichier d'en-tête stdio.h

## strstr

Alors au niveau des fonctions, on a également strstr() aussi qui peut être utile.

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
        strcat() : concatener deux chaînes (fusionner)
        strstr() : chercher une chaîne dans une autre
*/
```

strstr() va permettre de chercher une chaîne dans une autre donc c'est une fonction qui vous renverra le pointeur vers la première occurrence dans la chaîne sinon ça va vous renvoyer NULL donc il suffit par exemple de vérifier si ça existe donc je vais montrer par exemple ici.

Par exemple ici on va chercher Bill dans le texte.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char texte[] = "Boul et Bill";
    char mot[] = "Bill";

    if(strstr(texte, mot) != NULL)
        printf("Texte trouve !\n");

    return 0;
}
```

Ainsi si on trouve le mot dans le texte, qui est différent de NULL parce que ça renvoyer autre chose que NULL alors on peut dire *Texte trouve !*. Voilà pour trouver une sous-chaîne dans une autre.

```powershell
gcc main.c -o prog
./prog
Texte trouve !
```

Voilà c'est une utilisation possible, et là il vous met *Texte trouve !* parce qu'effectivement il a trouvé cette chaîne `"Bill"` dans celle là `"Boul et Bill"` mais si par contre je met `"Billd"` qu'est-ce qu'il se passe ?

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char texte[] = "Boul et Bill";
    char mot[] = "Billd";

    if(strstr(texte, mot) != NULL)
        printf("Texte trouve !\n");

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
```

Si je met *Billd*, le programme ne retourne rien parce qu'il a cherché bild à la suite et ça n'existe pas voilà donc il prend vraiment tous les caractères.

## strchr

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
        strcat() : concatener deux chaînes (fusionner)
        strstr() : chercher une chaîne dans une autre
        strchr() : chercher 1ère occurence du caractère
*/
```

Dans les fonctions, on va parler de strchr() qui va permettre de chercher en fait la  première occurrence du caractère d'accord donc on va travailler sur un caractère c'est-à-dire que là on va voir notre fameux texte *Boul et Bill* ou *Yin-Yang* par exemple c'est tout à fait possible.

Ensuite on va avoir un autre caractère `char c = '-';` donc on va par exemple travailler sur un tiret, on va chercher notre tiret et ensuite on va avoir le retour donc notre résultat `char *resultat = strchr(texte,c)`.

```txt
#include <stdio.h>
#include <string.h>

int main(void)
{
    char texte[] = "Yin-Yang";
    char c = '-';

    char *resultat = strchr(texte, c);


    return 0;
}
```

On renvoir strchr() dans un pointeur, c'est pour une chaîne, ça retourne un `char *` tout simplement donc un pointer vers un caractère et on va faire un petit printf() tout simplement pourquoi pas d'accord `printf("%s\n", resultat);`.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char texte[] = "Yin-Yang";
    char c = '-';

    char *resultat = strchr(texte, c);

    printf("%s\n", resultat);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
-Yang
```

Voilà tout simplement pour se faire une idée.

Voilà vous voyez que ça retourne en fait tout ce qui arrive après la fameuse occurrence qu'on a ici donc le fameux tiret yang `-Yang`.

Voilà donc du coup, il a trouvé le tiret et à ce moment là, il a affiché tout ce qu'il avait.

Ainsi on peut récupéré tout ça donc la première occurrence c'est simplement le premier moment où vous avez le tiret, il vous retourne le pointeur vers cette endroit-là et du coup il récupère tout le reste car n'oubliez pas qu'une chaîne c'est un tableau de caractères donc il vous envoie du coup tout le reste et vous pouvez afficher tout simplement.

Voilà donc je passe assez vite dessus puisqu'elle ne sera pas forcément très utile, très utile pour vous cette fonction mais c'est bien la connaître elle peut être utile quand même dans certains cas ou dans certain cas très très particulier au niveau de votre programme.

## sprintf

On termine avec une dernière fonction qui est dans l'en-tête stdio.h mais c'est bien de la savoir, c'est sprintf().

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
        strcat() : concatener deux chaînes (fusionner)
        strstr() : chercher une chaîne dans une autre
        strchr() : chercher 1ère occurence du caractère

        sprintf() : écrire dans une chaîne
*/
```

Alors comment ça fonctionne ? hé bien écoutez vous faites `char texte[256];` où on met une taille par exemple comme ça par défaut de 256, et là on l'affichera en faisant `printf("%s\n", texte);` et au lieu de faire strcpy() ou que sais-je, je vais faire sprintf() et je ne vais pas dire de l'écrire sur l'écran mais je vais lui dire de l'écrire dans texte *sprintf(texte, ???)* et qu'est-ce que tu écris dans le texte ? eh bien on met quelque chose tel un mot "Jason", moi par exemple je met mon prénom *sprintf(texte, "Jason", ???)* et je mets ensuite la taille d'accord donc vous voyez il y a une petite sécurité, je lui dit la taille de "Jason" donc voyez il y a cinq caractères parce qu'il n'y a pas le caractère de fin de chaîne donc je dit 5 `sprintf(texte, "Jason", 5);` et il va écrire donc 5 caractères ce qui rentre dans les 256 pas de problème à ce niveau-là.

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char texte[256];

    sprintf(texte, "Jason", 5);

    printf("%s\n", texte);

    return 0;
}
```
```powershell
gcc main.c -o prog
./prog
Jason
```

Voilà ok ça c'est pour sprintf() alors je suis allé assez vite pour ces fonctions parce que je ne voulais pas faire une vidéo de deux heures non plus juste sur les chaînes de caractères.

Pour résumer, ce qui est à retenir bien évidement qu'est-ce qu'une chaîne de caractères ? le fait que c'est un tableau de char, d'accord donc de petits caractères ensemble c'est pour ça qu'on parle d'une chaîne.

N'oubliez pas qu'il y a un caractère de fin de chaîne *\0* qui compte pour 1 donc quand vous faites un tableau compter toujours un caractère de plus, une case de plus dans votre tableau pour accueillir ce caractère-là.

Pour les afficher d'accord c'est le *%s* et avec l'en-tête string.h vous allez pouvoir travailler avec toutes ces fonctions et faire pas mal de choses sur les chaînes.

```c
/*
    [Fonction des chaînes]
        strcpy() : copie une chaîne dans une autre
        strlen() : longueur d'une chaîne (sans le caractère '\0')
        strcmp() : comparer deux chaînes (léxicographiquement)
        strcat() : concatener deux chaînes (fusionner)
        strstr() : chercher une chaîne dans une autre
        strchr() : chercher 1ère occurence du caractère

        sprintf() : écrire dans une chaîne
*/
```

Voilà il faudra vraiment en avoir l'utilité mais en tout cas c'est les fonctions vraiment usuels, celles à connaître surtout on va dire celles-là.

+ [strcpy()](strcpy)
+ [strlen()](strlen)
+ [strcmp()](strcmp)
+ [strcat()](strcat)

Les quatre-là seront vraiment utiles, très utile.

Les autres seront un peu moins utile.

+ [strstr()](strstr)
+ [strchr()](strchr)

Celles-là c'est plutôt pour la recherche, tout ça mais on l'utilise un peu moins.

Voilà la taille des chaînes, les comparer c'est vraiment des choses basiques qu'on peut faire avec.

Maintenant que vous savez ce qu'est une chaîne de caractères, que vous savez comment les utiliser ça vous servira pour la suite des vidéos, pour la suite de cette formation et vous continuez comme ça d'avancer et vous êtes bientôt à la fin des bases du langage c, des différentes notions qu'il y a dans ce langage.

Pour la suite, on parlera un petit peu de fichiers, on va parler également de l'allocation dynamique notamment comment on va pouvoir modifier la taille en fait d'un emplacement mémoire, ce genre de chose, faire de l'allocation en elle-mêmes et vous allez voir tout ça pour la suite.

Moi je vous dis à très bientôt, entraînez-vous bien, révisez, posez des questions, laissez des commentaires, partagez, liquez, etc bref vous connaissez un petit peu le principe et on se retrouve pour la prochaine vidéo donc la séance 14.

A bientôt tout le monde