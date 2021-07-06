# [Lecture sécurisée](https://www.youtube.com/watch?v=dbUDyMtFFlc)
+ LISTE NOIRE : [gets()](#gets), [at](#at)oi(), atol(), atod()
+ LISTE GRISE : [scanf()](#scanf), [fscanf()](#fscanf)
+ LISTE BLANCHE   : [fgets()](#fgets-liste-blanche)
+ [Ne faites jamais confiance aux utilisateurs](#ne-faites-jamais-confiance-aux-utilisateurs)
+ [Lecture et positionnement dans un fichier](#lecture-et-positionnement-dans-un-fichier)
+ [Format de la fonction scanf](#format-de-la-fonction-scanf)
+ [Retour de la fonction scanf](#Retour-de-la-fonction-scanf)
+ [Contrôler le retour de la fonction scanf dans une variable](#contrôler-le-retour-de-la-fonction-scanf-dans-une-variable)
    + [scanf retourne 1 valeur affectée](#scanf-retourne-1-valeur-affectée)
    + [scanf retourne 0 valeur affectée](#scanf-retourne-0-valeur-affectée) 
    + [scanf retourne 2 valeurs affectées](#scanf-retourne-2-valeurs-affectées) 
+ [Contrôler la taille de la donnée elle-même et eviter un débordement tampon](#Contrôler-la-taille-de-la-donnée-elle-même-et-eviter-un-débordement-tampon) 
    + [Indiquer un nombre de caractères à lire %5s](#Indiquer-un-nombre-de-caractères-à-lire) 
        + [scanf retourne -1 avec un espace](#scanf-retourne--1-avec-un-espace) 
+ [scanf lit le caractères de fin de chaîne \0](#scanf-lit-le-caractères-de-fin-de-chaîne) 
+ [Capturer un ou plusieurs charactères isolés sans le caractère de fin](#Capturer-un-ou-plusieurs-charactères-isolés-sans-le-caractère-de-fin) 
+ [Les expressions rationnelles](#Les-expressions-rationnelles) 
    + [Lire que des minuscules abc](#Lire-que-des-minuscules-abc) 
    + [Lire que des minuscules abc en passant une taille](#Lire-que-des-minuscules-abc-en-passant-une-taille)
    + [Lire inverse de abc et en passant une taille](#Lire-inverse-de-abc-et-en-passant-une-taille) 
    + [Lire les minuscules](#Lire-les-minuscules) 
    + [Lire les majuscules et cumuler les expressions](#Lire-les-majuscules-et-cumuler-les-expressions)
    + [Doubles guillemets](#Doubles-guillemets) 
+ [fgets](#fgets) 
+ [strtol](#strtol)
+ [fgets et son tampon entrée](#fgets-et-son-tampon-entrée) 
+ [Vider le tampon entrée](#Vider-le-tampon-entrée) 
    + [Ne pas utiliser fflush](#Ne-pas-utiliser-fflush)
    + [Création de fonctions pour vider le tampon entrée](#Création-de-fonctions-pour-vider-le-tampon-entrée) 
    + [Création de fonction de lecture](#Création-de-fonction-de-lecture) 

>

Bonjour à tous et bienvenue pour un tutoriel en langage C très très important parce qu'on nous allons revenir sur tout ce qui concerne la lecture de données et plus particulièrement comment faire de la lecture sécurisé.

Pour ce tutoriel, il est bien que vous ayez vu les vidéos, toutes les notions du langage jusqu'aux fichiers, au moins avoir vu toutes les séances jusqu'aux fichiers pour comprendre un peu.

Après vous n'êtes pas forcément arrivé jusque là ce n'est pas bien grave mais vous comprendrez bien mieux tout ce que je dirai dans la vidéo.

Si vous avez vu les 17 premières séances du cours donc en gros tout ce qui est propre aux notions du langage jusqu'à la gestion des fichiers.

Pour cette vidéo je vais vous tout simplement vous expliquer tout un tas de choses concernant la lecture ou la saisie de données, on va revenir sur pas mal d'éléments là dessus, vous donner quelques astuces et vous indiquer en fait certaines fonctions qui sont complètement à éviter et les fonctions que vous allez apprendre à utiliser plus en détail et bien sûr on reviendra sur des fonctions qu'on a déjà abordées sur le cours et qui sont pour le coup recommandées à l'usage dans vos différents programmes donc ça c'est une partie qui vous vaut le coup éffectivement d'être vu.

Alors l'important c'est qu'à la fin de cette vidéo, vous ayez bien compris pourquoi telle ou telle fonction a tel comportement, comment on peut s'en servir de manière correcte et certaines qui sont a évités que vous puissiez comme ça adopter les bonnes pratiques en tout cas à savoir au niveau de la programmation pour ce langage.

```c
#include <stdio.h>

/*

*/

int main(void)
{

    return 0;
}
```

## gets

Ce qu'on va voir principalement vous serez d'ailleurs peut-être amené à vous documenter sur divers supports, des livres etc, sur internet et être amené à un moment donné très certainement d'ailleurs parce qu'on l'a pas vu dans la vidéo et vous pourrez peut-être tombé dessus un jour càd la fonction gets().

```c
/*
    gets()
*/
```

La fonction gets(), c'est donc une spécialité du langage en lui-même càd que le langage c est un langage bas niveaux, plus bas niveau que les langages comme python, comme java et compagnie et se contente de faire tout simplement certaines choses précises pour les fonctions.

Je vous avez déjà d'ailleurs expliqué ça sur la vidéo sur les fonctions.

Un fonction va nécessairement fournir une seule tâche d'accord et qu'on ne va pas commencer à rassembler tout un tas d'opérations différentes dans une fonction.

C'est une fonction pour une chose et si on a besoin de faire une seconde chose, on le fait dans une autre fonction.

gets() comme l'indique son nom, c'est une fonction qui va permettre de lire, de récupérer une chaîne.

En gros on va demander à l'utilisateur de saisir des caractères au clavier, ça se passera directement au clavier et on va essayer de stocker ça tout simplement dans une variable, de la mémoriser.

gets() ne fait strictement pour le coup que ce qu'on lui demande c'est à dire récupérer une chaîne sur l'entrée standard donc en l'occurrence ici le clavier.

Le problème c'est qu'elle n'a absolument aucun outil donc elle ne sécurise absolument pas la lecture qui est effectuée et ça pour le coup ça peut être très problématique parce que qu'on a aucune garantie, aucune vérification possible par rapport à ça.

Pire encore c'est une fonction qui ne fournit pas d'outil càd qui ne vous fournit pas via par exemple l'usage de certains paramètres ou autre, de moyens de pouvoir faire des lectures sécurisées.

C'est pour ça que je mettrais ce genre de fonction en liste noire.

```c
/*
    LISTE NOIRE : gets()
*/
```

En gros ce que je vais vous mettre en liste noire ce sont des fonctions que je vous cite pour le savoir, ce n'est pas parce qu'on ne doit pas les utiliser qu'il ne faut pas en parler du tout.

Au contraire pour que vous sachiez pourquoi il ne faut pas l'utiliser.

Vous savez que c'est pas mon genre de vous dire de ne pas utiliser telle chose et puis c'est tout on passe à autre chose, c'est généralement je vous explique toujours pourquoi parce que mon intérêt c'est que vous compreniez, que vous appreniez véritablement pas seulement pour faire de la répétition, du copier coller de code ça n'a aucun intérêt.

Voilà pour que vous sachiez pourquoi vous utilisez certaines choses et pourquoi surtout vous ne les utilisez pas comme ça si d'autres personnes veulent l'apprendre leur transmettre l'information également.

Ainsi donc les fonctions que je met en liste noire sont des fonctions que je déconseille complètement.

Vous pouvez oublier tout simplement l'usage de ces fonctions dans vos programmes même en l'occurrence si vous êtes juste en train de vous entraîner, d'apprendre, voilà de faire des petits codes ... évitez parce qu'après vous pourriez être tenté de vous en servir après dans des vrais projets, en production ou dans des projets beaucoup plus concret.

Ok donc on verra un ensemble de fonctions par rapport à ça.

La fonction gets() encore une fois très simplement je ne vais même pas montrer de code.

Vous demander à l'utilisateur une chaîne qui saisit la chaîne et vous pouvez éventuellement après la mémoriser ça et puis l'afficher tout simplement.

Aucune vérification est faite donc en gros si on s'attend admettons, je montre un exemple très simple.

```c
#include <stdio.h>

/*
    LISTE NOIRE : gets()
*/

int main(void)
{
    char buffer[25];

    return 0;
}
```

On fait une chaîne ici qui est capable d'accueillir 25 caractères et on va donc stocker via cette fonction gets() dans le buffer.

Dans le buffer, on va stocker en fait ce qui a retourné cette fonction-là gets() et ce qu'elle récupère.

Ainsi si l'utilisateur de manière volontaire ou involontaire d'ailleurs décide de saisir plus que 25 caractères et même d'ailleurs plus que 24 puisque faut compter rappelez-vous pour les chaînes il faut compter le caractère de fin.

On aura ce qu'on appelle un débordement de tampon pour le terme anglais le fameux **buffer overflow**.

C'est un terme qui semble complexe mais en fait si vous avez une voiture de quatre places et si vous essayez de faire entrer 20 personnes, les quatre premières vont pouvoir entrer et les suivantes, les 16 dernières à moins de pousser les autres ça va être compliqué.

Voilà donc comme on ne pousse pas les gens parce qu'on veut être respectueux on va essayer d'aller dans une voiture donc les seize autres personnes vont essayer de rentrer dans une voiture de quelqu'un qu'ils ne connaissent pas.

A priori vous savez un petit peu comment ça se passe ça peut ne pas faire plaisir aux différents conducteurs.

En mémoire c'est un petit peu pareil.

En gros si on a par exemple 24 places de disponibles, si l'utilisateur rentre 30 caractère et bien il y a des caractères de trop qui vont aller déborder de vote variable *buffer* par rapport à ce qu'on veut stocker et ça va du coup essayer d'être mémorisés dans un autre espace mémoire.

On aura un débordement tampon et éventuellement un accès à des espaces non autorisées donc dans le meilleur des cas, on a un plantage du programme et dans le pire des cas ça peut être plantage du système et dans le pire pire des cas une personne qui sait volontairement qu'il y a justement possibilité de faire un débordement de tampon sur votre programme et qui peut s'en servir par exemple pour obtenir des privilèges super utilisateur sur votre système et prendre les commandes de votre os donc ça peut du coup avoir des conséquences assez dramatique.

On ne parle pas de simplement faire planter un petit programme ... c'est pas grave et on relance.

C'est pas juste de ce point de vue là.

Cette fonction gets() pour 2 points comme elle n'est pas sécurisée au départ et qu'en plus elle ne fournit aucun outil pour l'utiliser de manière sécurisée ou de permettre de contrôler certaines choses, ne l'utilisez tout simplement pas.

Au départ le langage quand il a été conçu par rapport à cette fonction, les créateurs du langage voulaient une fonction qui récupère une chaîne très simplement d'accord où ils savaient pertinemment que en  l'utilisant il n'allait pas mettre autre chose donc c'était histoire d'avoir une fonction très rapide pour faire les choses rapidement mais en utilisation surtout de nos jours c'est à dire avec des saisies interactives.

Avec un clavier on peut saisir des lettres, on peut saisir des caractères accentués, des caractères spéciaux, des chiffres on a même des caractères f9, f8, PgDown, etc.

Bref on a de la saisie du coup interactive qui peut permettre de stocker donc de mémoriser plein d'autres informations que seulement des caractères et ça peut nous poser énormément de problèmes.

Autre point aussi très important sur des fonctions que je mets directement en liste noire qu'on va voir dès le début de cette vidéo.

## at

Ce sont des fonctions qui permettent de faire des conversions de type.

Par exemple à un moment donné vous allez vouloir lire pour x ou y raison une information qui est numérique et pour travailler correctement avec parce qu'au départ voyez que le *buffer* est une chaîne vous allez vouloir stocker cette information par la suite dans une variable qui est plus adéquate au niveau
du type.

On a donc éventuellement des fonctions et si vous vous êtes déjà renseigné sur internet, il y a de fortes chances que vous tombez sur des fonctions comme atoui(), atol(), atod() soit les fonctions pour les entiers, fonctions pour les long, donctions pour les doubles donc les valeurs ici à virgule flottante bref on a tout un tas de fonctions. 

```c
/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
*/
```

On en a d'autres, atof().

Toutes les fonctions en at..() quelque chose sont des fonctions également que vous pouvez mettre en liste noire, à ne pas utiliser.

Peu importe votre cas d'utilisation, peu importe voilà le programme que vous voulez faire, elles ne sont pas à utiliser pour la simple et bonne raison aussi que ces fonctions ne remplissent pour le coup que ce qu'on leur demande c'est à dire tu converti une chaîne vers autre chose.

En gros on ferait par exemple ceci.

```c
#include <stdio.h>

/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
*/

int main(void)
{
    char buffer[25];

    atoi(buffer);

    return 0;
}
```

Voilà cette fonction `atoi(buffer);` va nous retourner du coup le nombre d'accords converti à partir du *buffer* précédemment donc toujours pareil si au final la chose qu'on veut convertir ne peut pas être changé en nombre, en entier avec atoi().

Si par exemple vous essayez de convertir une chaîne dans buffer ça va poser problème d'accord.

```c
#include <stdio.h>

/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
*/

int main(void)
{
    char buffer[] = "sdd";

    atoi(buffer);

    return 0;
}
```

On n'a pas encore une fois de sécurité vis-à-vis de la conversion qui est faites donc de la donnée ici qu'on a et qu'on passe en argument et en plus, on n'a absolument aucun outil que fournit la fonction en elle-même pour pouvoir faire ces vérifications là.

Comme on n'a toujours pareil ni l'un ni l'autre, c'est en liste noire ce n'est pas à utiliser parce qu'évidemment à tous les coups, c'est à coup sûr des soucis des erreurs, des plantages et pire peut-être encore en en faisant usage.

On évitera donc complètement ces fonctions là.

## scanf

Maintenant et c'est la partie sur laquelle je voulais arriver et qui est pour le coup très importante.

Une autre fonction qu'on a eu l'occasion d'aborder qui est la fonction scanf()

Cette fonction scanf() on l'a utilisé assez rapidement dans le cours d'accord de manière très naïve.

Alors c'est dans un monde idéal, si je voulais faire le cours exactement comme je l'aurais voulu en partant du principe que tout le monde comprendrait au même rythme, tout pareil et qu'il n'y a pas besoin de faire quelque chose de progressif dès le début en fait on aurait vu tout un tas de choses dans cette fonction.

On aurait pu faire une vidéo de quatre heures pour expliquer toutes les spécificités de la fonction, tout ce qu'on peut faire avec et cetera et pareil pour printf() et peut être même d'autres fonctions.

Le problème c'est comme vous êtes dans un apprentissage et que je pars du principe que vous êtes justement effectivement en apprentissage, on a utilisé cette fonction de manière naïve.

Le but n'est pas de vous faire utiliser une fonction sécurisée pour utiliser une fonction sécurisé mais c'est d'étudier des notions comme les variables, comment on fait des conditions, comment on écrit des boucles, comment être on fait des structures et quand on a besoin de saisir des données comme vous êtes en apprentissage on utilise et scanf() parce qu'encore une fois c'est très pratique ça fait les choses rapidement.

Pour autant je me doute et j'espère que le but avec le peu de connaissances que vous avez pu acquérir pour le moment sur le langage de commencer à faire des vrais programmes, des vrais projets, des choses concrètes qui seraient éventuellement publiées, produites et cetera avec ce type d'exemple-là, scanf().

Voilà par l'utilisation qu'on a pu en avoir jusqu'à passer à d'autres fonctions notamment parce qu'on a vu évidemment des fonctions beaucoup plus sûr par la suite tout dépend de où vous en êtes sur la formation.

Vous avez très vite très vite vu qu'il y avait donc d'autres choses beaucoup plus sûr que scanf() et avec l'utilisation que vous en avez faites tout durant la formation d'ailleurs ce n'est pas un usage sécurisé.

Voilà parce qu'il y avait effectivement l'apprentissage qui entrait en compte pour autant cette fonction scanf() même s'il y avait beaucoup de gens qui vous diront que cette fonction n'est absolument pas utilisé et dangereuse etc etc, je la classerais dans une liste grise.

```c
/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
    LISTE GRISE : scanf()
*/
```

Alors ce que je vais mettre dans liste grise mais je ne vais pas faire un listing de toutes les fonctions parce qu'il y a énormément de fonctions de lecture, vous en mettrez des principales après à vous de vous renseigner pour d'autres mais je mettrais celles qui me viennent en tête et celles qui pour moi on un intérêt à être abordées ici.

La fonction scanf() je la mets donc en liste grise parce qu'on va rester sur des choses très inspirant, tout simplement dans le sens où c'est une fonction que vous pouvez utiliser si vous savez l'utiliser.

Alors ça peut sembler bête parce qu'on peut dire que si on ne sait pas utiliser quelque chose, c'est logique de ne pas s'en servir.

Pour autant sachez le il y a beaucoup de gens qui se servent de pas mal de fonctions pour forcément savoir comment elles tournent effectivement et comment elles se comportent alors est-ce que c'est par flemmardise parce qu'il y a le mythe qui dit que les développeurs sont des féanéants apparemment sans exception parcequ'il faut croire que tout est aussi simple dans la vie, c'est faux et du coup on a tendance à dire voilà que le développeur est paresseux et donc il se contente du plus simple et comme il se contente du plus simple il ne va pas faire l'effort d'aller beaucoup plus loin donc il va utiliser des outils de manière naïve et forcément une utilisation naïve de scanf() est une utilisation qui est parfaitement non sécurisé, absolument non sécurisé.

Exemple tout bête de ce qu'on a pu faire dans les programmes, dans les vidéos.

```c
#include <stdio.h>

/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
    LISTE GRISE : scanf()
*/

int main(void)
{
    int age = 0;

    printf("Quel age as-tu ? ");
    scanf("%d", &age); //utilisation naïve et absolument non sécurisé.

    printf("Tu as %d ans\n", age);

    return 0;
}
```

Exemple tout bête de ce qu'on a vu dans les vidéo, on va prendre par exemple un âge et demander l'âge avec un petit scanf() avec un %d, un petit & parc qu'il faut une adresse pour mémoriser dans la variable *age*, et ensuite on affichait la valeur.

Voilà c'est le genre d'exemple que j'aurais pu vous faire et que j'ai peut-être fait parce que je ne sais plus forcément quel exemple j'ai mis pour chaque langage pour montrer par exemple comment on affecte des choses à des variables et qu'ensuite on les affiches.

Par exemple un cours sur les variables, on peut tout à fait utiliser ce genre d'exemple parce que le principe ici ce n'est pas de faire de la saisie sécurisé, c'est de montrer le principe des variables, qu'on peut y stocker des informations, les mémoriser et ensuite on peut également afficher ce qu'elles contiennent d'accord l'information qu'on a mémorisé le long de l'exécution du programme parce que c'est tout l'intérêt justement des variables dans un programme.

```powershell
gcc main.c -o prog
./prog
Quel age as-tu ? 23
Tu as 23 ans
```

On peut compiler à nouveau de manière plus stricte parce qu'on travaille sur des choses sécurisé.

```powershell
gcc -Wall -Werror main.c -o prog
./prog
Quel age as-tu ? 23
Tu as 23 ans
```

C'est évidemment pour qu'il signale beaucoup plus d'erreur s'il y a des erreurs au niveau du programme ici ça parait beaucoup plus stricte encore.

Voilà autant qu'on fasse les choses comme il faut du début à la fin.

Là je note l'âge *23* pas de problème, vous voyez je fais une utilisation tout à fait attendue du programme, on demande un âge, je saisis effectivement un âge et tout fonctionne bien, parfait parfait.

Alors ça c'est évidemment une situation tout à fait naïve de la fonction puisqu'on a eu un scénario qui pour le coup bien passé mais à partir du moment où je vais noté alors un cas possible un nombre qui dépasserait la limite que peut atteindre un integer ici donc il faut revenir sur la vidéo sur les variables si vous voulez savoir quel nombre minimum ou le nombre maximum que vous pouvez mémoriser dans tel ou tel type de variables en langage c, on a vu tout ça bien en détail.

Alors ça c'est le genre d'erreur qui peut arriver si j'essaye de mettre un nombre trop trop trop trop trop grand il va y avoir forcément un petit problème et pire aussi si je mets par exemple des chaînes des caractères on va essayer du coût de ce mémoriser une chaîne de caractères ou un simple caractère s'il n'y en a qu'un seul dans un *int*.

Si on stocke ce genre de chose dans un *int* ça va évidemment poser problème et là du coup on n'aura pas ce qu'on voulait et si notre programme est basé là dessus, on va faire notre petit programme tranquille en partant du principe que scanf() la saisie sera toujours faites correctement en considérant que l'utilisateur va toujours faire sa saisi correctement sans aucun problème et du coup on s'expose à énormément de problèmes tel que des plantages du programme, du système voire l'exploitation d'une faille dans votre programme pour voilà détourner tout ça et pour obtenir des accès bref des choses qu'il ne faut pas autoriser sur un programme.

## fscanf

Alors je ne vais pas forcément en parler parce qu'on va revenir dessus mais ça fonctionne pareil pour fscanf() que je met ici en liste grise et vous allez comprendre pourquoi.

```c
/*
    LISTE NOIRE : gets(), atoi(), atol(), atod()
    LISTE GRISE : scanf(), fscanf()
*/
```

Voilà donc ça utilisation **très naïve** que j'ai dû faire dans le cours mais qu'effectivement dans un monde idéal, j'aurais aimé en fait ne pas employer càd ne pas faire une seule vidéo en fait où j'aurais fait appel à scanf de cette manière là parce que ça ne va pas du tout mais si j'avais commencé tout de suite plutôt que de faire un tutoriel comme là à vous en parler dans le cours et bien on aurait du coup parlé des pointeurs, on aurait parlé d'expression rationnelle (on va revenir dessus) et de tout un tas de domaines et ça aurait largement dépassé le cadre de l'apprentissage par exemple des variables soit qu'est ce qu'une variable ? comment ça fonctionne ? comme on s'en sert ?

Pour le coup et encore une fois voilà un peu la progression que je vous recommande si vous voyez ce tuto même si vous en êtes qu'au début de la formation.

Voilà comment fonctionnent les choses.

Je tiens à le rappeler pour que les choses soient soit bien clair, que vous ne soyez pas perdu.

Si vous êtes en apprentissage vous pouvez parce que vous êtes là pour apprendre des notions d'accord on utilise des concepts, des notions dans le langage ou dans la programmation de manière générale il n'y a pas de problème que vous utilisiez scanf() d'accord.

Quand vous allez arriver aux séances où j'aborde d'autres fonctions avec vous qui sont pour le coup plus sécurisés voilà qui contrôle par exemple les informations que l'on veut lire, vous laissez tomber l'usage des fonctions comme ça scanf(), fscanf() etc.

Vous pouvez les mettre de côté.

Alors ça ne veut pas dire pour autant que vous les abandonnez, si vous préférez comme ça évidemment c'est vous que ça regarde.

On peut très bien s'en passer, il y a sûrement des gens qui ne s'en servent pas du tout, ils arrivent à faire ce qu'ils veulent, il n'y a aucun problème à ça.

On n'est pas obligé d'utiliser toutes les fonctions proposées d'un langage et il n'y a aucun souci pour autant vous pourrez et vous pouvez si vous voulez à un moment donné quand vous estimerez avoir suffisamment d'expérience d'accord d'avoir suffisamment de pratique avec le langage, que vous sentez beaucoup plus à l'aise avec, beaucoup plus au courant de comment se comportent justement les différentes fonctions, comment on gère la mémoire, comment on gère des chaînes de caractères, comment revenir sur ces fonctions et les étudier plus en détails et en faire usage.

Ne pas hésiter à faire plein de petits programmes, plein de tests, de vérification pour effectivement bien assimiler leur comportement, leurs fonctionnement selon différents scénarios et pouvoir si nécessaire si vous en estimez voilà la nécessité ou le besoin, en faire usage mais de manière correcte.

Alors encore une fois rien ne garantira que vous saurez utiliser une fonction à 100% correctement.

On pourra toujours de toute façon à un moment donné trouver un scénario.

Encore une fois une saisie d'utilisateur c'est compliqué c'est à dire c'est essayer de prévoir tous les cas de saisies qui serait possible.

C'est à dire qu'en gros c'est de se dire bon l'utilisateur lorsqu'on demande une saisie admettons un nombre ... le bon scénario s'est qu'il saisit le nombre en question, qu'il saisit bien le nombre et qui reste dans la fourchette de valeur que peut supporter ici un type *int* en c.

Après on a un scénario qui n'est pas bon c'est qu'on dépasse le nombre en question ou alors si on demande un type non signés c'est à dire un type positif c'est de mettre par exemple une valeur négative alors qu'on attend du positif.

On peut aussi commencer à mettre des caractères spéciaux voir ne rien mettre du tout.

En gros on fait simplement entrer ou on met un *\n*.

```powershell
./prog
Quel age as-tu ? \n
Tu as 0 ans
```

Voyez du coup déjà on voit 0 ans c'est qu'il y a un problème d'accord donc déjà on peut là pour le coup faire planter le programme.

Il n'a pas le comportement attendu c'est à dire que là il devait afficher *\n* mais il affiche 0 ans parce qu'effectivement j'ai réussi à outrepasser la demande du programme donc voyez déjà ça c'est pas tolérable.

On ne peut pas laisser passer ça dans un programme d'accord il n'y a aucune vérification qui est faites.

Vraiment prenez cette habitude pour l'apprentissage surtout au tout débuts sur les premières séances vous pouvez vous en servir tout en gardant l'idée que ce n'est pas sécurisé d'accord ça c'est important.

## fgets liste blanche

Après quand vous arrivez sur des fonctions et s'en va en parler quand vous allez aborder notamment dans le cours la fonction fgets() dont on va en parler de toute façon un peu sur ce tutoriel, ne vous inquiétez pas.

```c
/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/
```

vous pouvez vous dire bon voilà je mets de côté scanf() et fscanf() càd qu'à la place j'utilise fgets().

Après quand vous avez plus d'expérience, que vous vous sentez plus à l'aise, que vous avez éventuellement la curiosité ou le besoin de savoir un peu comment fonctionnent ces fonctions d'accord vous pourrez revenir dessus comme je vous le disais, étudier cela plus en détail ou même dans ce tuto parce qu'on va évidemment aller beaucoup plus loin sur l'utilisation de scanf() dans cette vidéo.

Voilà on ne va pas dire que scanf() ce n'est pas bon du tout et du coup on passe à autre chose.

Non, je vais vous expliquer différentes subtilités de cette fonction dans cette vidéo.

C'est pour ça qu'il y a beaucoup beaucoup de choses à vous montrer.

Du coup voilà l'utilisation naïve qu'on peut avoir par rapport à ça.

Autre parenthèse et ça c'est important parce qu'on parlait comment utiliser scanf() voilà c'est à dire au  début on peut s'en servir, après on la met de côté et après on revient dessus pour véritablement apprendre et comprendre la fonction et éventuellement s'en servir concrètement dans des vrais programme.

Ainsi il n'y a pas de mal à se servir de scanf() dans un vrai programme et cetera.

Encore une fois si on utilise convenablement scanf() et qu'on sait comment elle fonctionne, voilà tout en sachant que même si on s'assure de plein de choses, on n'est jamais garantie d'avoir pensé à tous les cas possible et d'être sûr que voilà il n'y aura jamais jamais de problème mais ça des bugs dans un programme il y en a toujours.

On peut toujours trouver des bugs un peu partout et même quand on utilise les outils les plus sûrs qui soit, on arrive toujours à trouver un truc qui finalement ne se passe pas comme cela était prévu.

Il y a donc des moments où il y a des choses qui nous échappent dans tous les cas donc c'est pas toujours évident de penser à tout.

## Ne faites jamais confiance aux utilisateurs

Autre parenthèse concernant les fichiers c'est pour ça que j'ai parlé de fscanf() et après on viendra sur le reste.

Au niveau des fichiers et ça ça rejoint une règle en informatique que j'ai pu dire dans certaines autres formations et que je peux répéter ici : **ne faites jamais confiance à l'utilisateur**.

On a vu que l'utilisateur peut noter l'information telle qu'elle est attendue, c'est le bon scénario ainsi on demande une saisie à l'utilisateur et il entre ce qu'il faut on est content c'est super, ça marche !

L'utilisateur peut aussi volontairement contourner ce que vous voulez demander aux niveaux de votre programme et dans ce cas-là tenter de chercher quelque chose, on ne sait pas quoi.

Voilà il peut aussi simplement par erreur faute de frappe ou n'importe quoi faire une erreur de saisie et croyez-moi ça arrive beaucoup plus souvent qu'on peut le penser.

C'est très très vite arrivé de faire une erreur de saisie sur un formulaire, sur le web, sur un programme comme ça ou un jeu ou n'importe quoi et du coup si c'est pas contrôlé derrière ça pose énormément de problèmes.

Pour autant ça rejoint donc la parenthèse que je voulais faire concernant les fichiers.

Ne pensez pas pour autant comme vous passez par un fichier que l'information est sûre.

On pourrait se dire ça parce que si l'information est saisie depuis un clavier forcément un utilisateur peut noter n'importe quoi.

Regarder le nombre de touches que vous avez sur votre clavier, ça va très très vite de taper tout et n'importe quoi.

Sur un fichier on peut dire bon j'ai un programme il y a un fichier puis l'affiche le contenu du fichier.

On pourrait penser encore une fois naïvement que pas de problème il y a un fichier, il lit et c'est terminée donc à moins d'avoir mis vraiment n'importe quoi mais logiquement si nous mêmes on a conçu le programme on sait ce qu'il y a dans le fichier donc on va lire en sachant comment est constitué le fichier donc pas de soucis.

Voilà donc rien encore une fois ne garanti même si c'est du binaire, même si c'est un format particulier de fichier peu importe ou d'encodage ou autre.

Rien ne vous garantit que le fichier à un moment donné n'a pas été corrompu, modifié, accédé pour être changé et cetera.

Rien ne vous garantit encore une fois voilà que le fichier avec ce que vous attendez comme informations de votre fichier est effectivement ce qui va arriver quand vous allez lire votre fichier.

Attention c'est pour ça que c'est également en liste grise, ce n'est pas parce que vous passez par un fichier que c'est pour autant plus sûr qu'une lecture au clavier, très important à prendre en compte aussi.

## Lecture et positionnement dans un fichier
> Il est préférable de travailler avec du binaire.

Autre parenthèse et il y a pleins de parenthèses mais comme on parle de lecture sécurisé autant faire des rappels ou bien vous donner un maximum d'astuces sur cette vidéo.

Concernant la lecture de fichiers notamment quand on veut gérer du **positionnement dans un fichier** et ça aussi parce que j'ai eu pas mal de commentaires et de remarques là dessus parce que des gens parmi vous se sont amusés à lire des fichiers, gérer la position du curseur dans le fichier pour récupérer certains éléments précisément et vous avez testé sur des fichiers textes bien sûr parce que c'est ce qu'ont fait basiquement et vous êtes rendu compte que ça pose énormément de problèmes 

Voilà ça ne se passe pas du coup comme on l'attendait au niveau du comportement des fonctions.

Généralement quand on a un fichier texte comment ça fonctionne ? quand on fait par exemple de la lecture notamment avec fscanf(), c'est pour ça que je dis que c'est pas forcément une fonction à jeter parce qu'on gère par rapport à ça.

scanf() et fscanf() c'est des fonctions qui vont permettre d'analyser, de filtrer des informations qu'on veut.

Ainsi on lit des données formatées.

Admettons dans un fichier, je veux faire un petit dictionnaire, un truc très simple bien sûr et mon  dictionnaire c'est un fichier texte qui est sous cette forme càd que je mets un mot, je mets une barre verticale comme ceci `porte|` peu importe j'aurais pu mettre un tiret ou deux points on s'en fiche voilà et ensuite je note la définition de ce que c'est.

```
porte|c'est une ouverture.
chat|animal domestique.
voiture|véhicule de déplacement.
```

D'accord je ne vais pas vous faire la définition d'une porte.

Tout le monde sait ce que c'est une porte.

Puis un chat, une voiture, très vite vous remarquez qu'il y a un schéma qui se répète, le schéma qui se répète si on prend par exemple scanf() c'est celui-ci `%s|%s` càd qu'on a une chaîne de caractères une barre verticale et à nouveau une chaîne de caractères.

```
porte|c'est une ouverture.
chat|animal domestique.
voiture|véhicule de déplacement.

%s|%s
```

Voilà `%s|%s` c'est le formatage qui permettrait de capturer ce type de chaîne avec un fscanf() par exemple tout ce qui est en fait fonction de lecture avec ce formatage ou fonction d'écriture si on écrit de cette manière mais ça c'est autre chose.

Voilà comment ça se passerait ça c'est du rappel, on a déjà vu tout ça bien en détail sur le cours donc quand on sait comment est fournit le fichier, on peut faire de la lecture ... pas de problème pas de problème.

Maintenant si on veut commencer à lire un fichier, le curseur se met au tout début.

On peut aussi commencer la lecture d'un fichier où le curseur se met tout à la fin du fichier même carrément des fois à la ligne.

Là on a tenté de se dire avec nos fonctions en langage c pour gérer la position du curseur, on peut même le ramener au tout début, on peut le ramener à la fin, on peut le déplacer où on veut ...

Ensuite quand on fait ces petits tests dans notre programme, on se rend compte que ça ne fait pas ce qu'on voulait parce que justement différents formatages sont gérer.

Vos systèmes d'exploitation gèrent également des retours à la ligne donc on peut avoir les *\n* qu'on ne voit évidemment pas dans le fichier texte mais qui sont gérés et tout un tas d'éléments qui sont fait invisible au niveau du texte ce que voyez dans votre fichier mais qui vont permettent en fait de gérer l'encodage, le formatage de votre fichier texte parce qu'un fichier texte c'est pas juste un fichier texte il faut bien qu'il y ait une information informatique qui dise qu'après ceci *porte|c'est une ouverture.* il faut bien un retour à la ligne pour passer à un nouveau mot.

Il y a donc plein d'informations qu'on ne voit pas pourtant qui existent bien voilà l'ordinateur il ne peut pas deviner tout tout seul.

Il y a forcément des choses mémorisés, sauvegardés quelque part et ça quand on essaye du coup de faire du positionnement de curseur dans un fichier comme ça et bien forcément on a des décalages, on a tout un tas d'informations en plus qu'on ne voit pas mais que les fonctions de positionnement prennent en compte et du coup on n'a absolument pas le fonctionnement qu'on voudrait.

Du coup la petite astuce si vous voulez gérer du positionnement dans des fichiers il est préférable et plus sûr de **travailler avec des fichiers binaires** et ça tombe bien de toute façon parce que sur la playlist tutoriels de la chaîne vous avez une vidéo pour manipuler des fichiers en binaire.

> [Fichiers binaires](https://www.youtube.com/watch?v=_Z39xKbRd2E)

L'avantage du fichier binaire c'est comme on travaille avec des bits, des octets et bien il est facile de dire par exemple tu décale de 3 octets, tu décale d'autant parce qu'on sait la taille que prend chaque type de données.

```c
sizeof()
```

On a même une fameuse fonction sizeof() qui permet de récupérer la taille d'un élément et à partir de là c'est très facile de dire voilà comme si un *int* par exemple sur votre architecture fait 8 octets et bien il est facile de se dire tu décalera après l'entier que tu auras éventuellement lu.

On peut donc très facilement du coup gérer du positionnement parce qu'on manipule non pas des caractères et du coup avec des caractères éventuellement pas visible dans le fichier en lui-même mais des octets et là on est beaucoup plus sûre à ce niveau-là.

**Voilà une petite astuce pour le positionnement dans des fichiers, ainsi préféré travailler avec des fichiers binaires parce que ce sera beaucoup plus efficace à ce niveau là.**

Voilà on referme cette petite parenthèse qui était quand même très importantes concernant la lecture.

## [Format de la fonction scanf](https://en.cppreference.com/w/c/io/fscanf)

Voilà on ne fait pas tellement que de la saisie sécurisée c'est surtout de la saisie cohérente et cetera, et donc il ne faut pas vous attendre à des comportements un peu bizarres sur l'exécution de vos programmes.

Alors ceci étant dit on va passer maintenant aux quelques subtilités de la fonction scanf() parce que le but en fait c'est de vous dire que scanf(), on ne la jette pas cette fonction.

Je vais vous montrer des choses que vous pouvez faire avec scanf().

Encore une fois si après vous décidez de ne plus vous en servir, aucun problème il n'y a aucune obligation de se servir de ce genre de fonction pour autant au moins vous aurez appris à vous en servir un minimum.

Je ne vais évidemment pas tout vous montrer il y a plein de choses que je ne connais pas, il y a plein de choses qui ne sont pas forcément utiles à voir pour la vidéo, il n'y a pas besoin de voir tout ça.

Vous allez voir déjà avec ce que je vais vous montrer ça fera énormément d'éléments supplémentaires qu'on n'avait pas abordé dans le cours mais qui pourront extrêmement servir pour la suite.

Comme je vous l'ai dit autant ces fonctions en liste noir `gets(), atoi(), atol(), atod()` ne fournissent aucun outil pour vérifier les informations pour sécuriser ce qu'on fait avec autant celles-ci `scanf(), fscanf()` en ont d'accord et c'est pour ça qu'elles sont du coup en liste grise parce que de base avec l'utilisation naïve comme j'ai fait ici.

```c
#include <stdio.h>

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    int age = 0;

    printf("Quel age as-tu ? ");
    scanf("%d", &age);

    printf("Tu as %d ans\n", age);

    return 0;
}
```

Là on n'a rien qui est vérifié et c'est pas forcément une mauvaise conception de la fonction c'est que la fonction a été conçu de telle sorte que avec un usage standard, elle ne fait rien d'autre que lire des données. On ne lui a rien demander d'autres alors pourquoi elle ferait autre chose alors qu'on ne lui a pas demandé.

Si vous voulez qu'elle fasse autre chose que simplement récupérer des données, c'est à vous en tant que développeurs, ça demande plus de rigueur plus d'efforts, plus de code forcément de le demander explicitement et de vous servir des outils de la fonction.

C'est pour ça qu'il y a des gens qui vous diront ben voilà que la fonction n'est pas sécurisée donc il ne faut pas l'utiliser.

Voilà c'est soit parce qu'ils ne savent pas utiliser, soit parce qu'ils ne savent peut-être simplement pas qu'il existe des outils pour l'utiliser convenablement.

Encore une fois de manière relative parce qu'on ne peut pas s'assurer à 100% qu'on aura forcément un usage correct tout le temps quand on programme et ça ça fonctionne pour n'importe quel langage d'ailleurs même le langage le plus haut niveau qui soit, comparé aux autres rien ne vous assure que vous ferez de la bonne programmation.

Si vous programmez n'importe comment même avec le langage le plus sûr vous obtiendrez un code qui évidemment n'est pas du tout du tout optimisé, n'est pas du tout efficace.

Alors ça je ne vous apprends rien non plus.

Première chose qui est intéressante à vérifier, c'est important avant même de vérifier l'information du coup qu'on test donc qu'on lit c'est que effectivement est-ce que scanf() a déjà pu sauvegarder l'information ?

D'accord on ne va pas spécialement utilisé pour le moment d'outils de la fonction, on va juste l'utiliser plus complètement càd que là jusqu'à présent la fonction je ne faisait qu'une lecture d'accord je lis l'information et après terminé je ne fais rien de plus.

Nous donc ce qu'on va faire ici je vais vous indiquer déjà le prototype donc la signature en fait pour la fonction en gros pour faire très simplement je pense que c'est ça normalement.

```c
/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()

    int scanf(const char *format, ...);
*/
```

Vous avez ce format là.

Qu'est ce que ça veut dire ? alors *scanf* c'est non de la fonction. Ici *const char \*format,* elle gère un format d'accord c'est une chaîne qui donc sera formatée et éventuellement là *...* si on veut injecter des variables pour mémoriser des valeurs.

Voilà on s'est toujours servi de cette partie là : **scanf(const char \*format, ...);**

## [Retour de la fonction scanf](https://en.cppreference.com/w/c/io/fscanf)

Voilà on ne peut pas reprocher à la fonction de ne pas être sécurisée parce que jusqu'à présent on se contentait d'utiliser que la moitié de la fonction c'est à dire les arguments qu'elle attend donc les paramètres en fait que la fonction a définis, les arguments qu'elle attend lorsqu'on l'appelle.

Alors ça on s'en est toujours servi pas de problème mais il y a une chose dont on s'est jamais servi c'est *int* et ça du coup ça fait partie de l'usage le plus rigoureux et le plus efficace de la fonction.

Si on oublie de se servir de cette information là et bien forcément on utilise naïvement la fonction et oui évidemment de base comme ça elle n'est pas sécurisée du tout, on n'a rien contrôler.

Alors à quoi sert cet élément ? je vais vous montrer déjà vous allez voir c'est très simple.

Alors je vais faire une petite variable comme ceci *ret*, on va récupérer le retour de la fonction et voyez que rien ne change, on fait juste une récupération de la valeur au passage c'est tout.

### Contrôler le retour de la fonction scanf dans une variable

#### scanf retourne 1 valeur affectée
```c
#include <stdio.h>

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()

    int scanf(const char *format, ...);
*/

int main(void)
{
    int age = 0;
    int ret;

    printf("Quel age as-tu ? ");
    ret = scanf("%d", &age);

    printf("Tu as %d ans\n", age);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Quel age as-tu ? 23
Tu as 23 ans
RET : 1
```

Vous comprenez peut-être aussi pourquoi ça nous l'avons pas vu dans les premières séances parce que si on avait déjà commencé à parler des fonctions alors qu'on en était juste sur la vidéo des variables il aurait fallu que je commence à vous parler de retour, de fonction, de paramètres d'arguments alors que si vous en êtes que sur la séance 3 sur les variables, on n'en est même pas encore là.

On compile et on mets donc un scénario correct, je met effectivement une bonne information.

On voit que *ret* affiche 1 d'accord.

Pour comprendre ça correspond tout simplement au **nombre d'éléments qu'on a pu affecter lors de la lecture (RET : 1)**.

Là le scanf() a affecté à une variable la donnée que nous avons eu d'accord il y a eu une affectation à faire.

Comme cette affectation s'est bien passé lorsqu'on voit **le retour /*RET : 1/* qui signifie que ça s'est bien passé**.

Pourquoi ça fonctionne ? On va sur des notions encore plus avancées que le simple usage des variables, ça concerne en fait le fonctionnement, la gestion des erreurs même si bon c'est encore une fois très relatif, on n'est pas sur un langage de haut niveau comme le java par exemple ou python encore une fois. N'oubliez pas que le c est un langage beaucoup plus bas niveau par rapport à Java et à Pyhton, et ici on a pas de système d'exception càd que si vous avez étudiez d'autres langages où il y a tout un tas de systèmes pour gérer des erreurs, je ne vais pas trop entrer un détail pour pas trop vous embrouiller non plus et en c comme on est beaucoup plus bas niveau que Python, que java, etc. eh bien on va se contenter de ce que le programme fournit en notions.

C'est pour ça que le langage c a très peu de notions d'accord c'est un langage qui est pauvre en notion si on compare aux autres langages donc le seul moyen quelque part d'assurer un minimum de choses ... il n'y a pas que ce que je vais vous dire là mais ça en fait partie c'est utiliser des codes de retour.

En gros quand on fait une fonction généralement c'est très très rare d'avoir une  fonction qui ne retourne rien sauf une fonction par exemple qui va faire de l'affichage ou autre parce qu'a priori il n'y a pas de raison que ça plante.

Quand on fait de l'affichage, il n'y a pas de raison d'avoir d'erreur produite pour certains usages de fonction et pour des fonctions par exemple de récupération de données, de lecture tout ça on va très très souvent par convention utiliser des codes de retour.

Comment ça fonctionne, et bien c'est très simple par exemple vous voulez admettons faire un programme quel qu'il soit.

Vous faites voilà une fonction où je mets n'importe quoi qui retournera un entier d'accord et elle va éventuellement prendre certaines informations en paramètres.

/*
    int someFunction(params...)
    {
        //si problème A
        return -1;

        //....si problème G
        return -11;
    }
*/

C'est pas du code ici c'est juste pour dire voilà vous mettez éventuellement des paramètres dans la définition de votre fonction ok votre fonction va faire tout un tas de choses peu importe quoi et en fonction du scénario, vous dites que s'il y a eu le problème *A* on va retourner -1 ... à un moment donné dans le programme il y a eu par exemple le problème *G* pour lequel on retourne -11.

On retournera des codes d'erreurs en gros et si le programme a bien fonctionné ben soit on retourne une information bien précise soit on retourne un code précis généralement en informatique comme le fameux int dans la fonction main ici est return 0.

Par convention en informatique quand on a zéro c'est pour indiquer que tout s'est bien passé d'accord qu'il n'y a pas eu d'erreur et si vous retournez autre chose que 0, c'est que pour le coup il y a eu un problème justement quel qu'il soit et c'est là que ça rentre en jeu.

On n'est donc pas là pour faire de la gestion d'erreurs dans cette vidéo !

Ce qu'il faut comprendre c'est que du coup grâce à ça, la personne qui va utiliser votre fonction quand il va en faire usage s'il programme correctement et surtout dans un langage bas niveaux plus bas niveau comme le c il va contrôler systématiquement le retour de votre fonction donc il va en faire usage par exemple en passant ces paramètres et il va récupérer le retour.

/*
    int someFunction(params...)
    {
        //si problème A
        return -1;

        //....si problème G
        return -11;
    }

    ret = someFunction(...)
*/

Et du coup en fonction de ce qu'il aura capturé au niveau du code de retour ici, il saura si le programme a bien fonctionné ou pas donc si c'est du zéro il sera que tout a bien fonctionné et selon le problème d'accord qu'il y a pu avoir il saura qu'est ce  qu'ils doit faire, qu'est-ce qu'il doit traiter comme information càd qu'il peut y avoir des erreurs critique ou là faut quitter le programme, il n'y a pas d'autre solution et il peut y avoir des erreurs moins grave plus secondaire ou par exemple parce qu'il y a un mauvais accès ou une mauvaise information pas valide ... éventuellement redemander une information.

Voyez selon le type d'erreurs qu'on a pu obtenir grâce aux numérox ici, le code de retour on peut traiter l'erreur différemment parce que l'erreur par exemple qui a retourné -1 n'est pas la même erreur que celle qui aura retourné -11.

On peut donc traiter par exemple l'information différement donc ça c'est le moyen qu'on a, un des plus efficaces et pas le meilleur on pourrait certainement trouver mieux mais c'est le moyen qu'à un langage plus bas niveau comme le c par rapport à java et compagnie qui ont des systèmes d'exception, php par exemple on peut citer aussi celui-là pour gérer justement ces cas là d'accord ça me permet pas de contrôler le retour de nos fonctions et dire est-ce qu'elles ont bien fonctionnées et c'est là tout le principe de scanf().

#### scanf retourne 0 valeur affectée

scanf() si elle n'a pas réussi à affecter quoi que ce soit, elle va vous retournez 0 et un exemple tout bête, on l'a fait tout à l'heure d'ailleurs on va refaire *\n* et regardez.

```c
#include <stdio.h>

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    int age = 0;
    int ret;

    printf("Quel age as-tu ? ");
    ret = scanf("%d", &age);

    printf("Tu as %d ans\n", age);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Quel age as-tu ? \n
Tu as 0 ans
RET : 0
```

Déjà l'affichage de l'âge ça ne va pas du tout et vous voyez que le retour il égale à zéro.

Elle n'a pas réussi à affecter quoi que ce soit et elle vous l'indique donc déjà si on vérifie le retour de la fonction scanf() càd qu'on fait une petite condition en vérifiant ret et cetera avec la valeur qu'on veut test.

```c
ret = scanf("%d", &age);

if(ret == )
```

... on peut se dire bas que déjà si *ret* est égal à zéro on s'amuse pas à afficher l'âge parce que déjà il a rien à afficher puisqu'il n'a pas réussi à affecter ici `scanf("%d", &age)`.

Voyez que déjà ça évite tout un tas de problèmes au niveau de notre programme.

Voilà ça sécurise générallement en petite partie l'usage de la fonction.

On n'est plus sur une fonction pour le coup qui est complètement non sécurisée déjà en vérifiant ce retour là.

Donc ça c'est pour contrôler tout simplement si on a l'affectation de la donnée qu'on a voulu lire a bien été mémorisée dans la variable qui était destinée à l'information.

Si ça n'a pas fonctionné de toute façon ça ne sera pas compter donc ce ne sera pas pris en compte.

#### scanf retourne 2 valeurs affectées

Si vous mettez deux variables *x* et *y* pour lequel on va lire deux informations où on dit que l'utilisateur entre l'entier correspondant à x, il fait un espace puis un slash un espace et à nouveau son caractère et comme on veut des adresses on indique ces informations-là, *&x* et *&y*.

```c
#include <stdio.h>

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    int x = 0, y = 0;
    int ret;

    printf("Indiquez x et y : ");
    ret = scanf("%d / %d", &x, &y);

    printf("X : %d et Y : %d\n", x, y);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Indiquez x et y : 65 / 4548
X : 65 et Y : 4548
RET : 2
```

Voilà on indique x et y, on veut les afficher et afficher le retour qui est bien appliqué.

On respecte le format `"%d / %d"` et l'information bien enregistrée on voit que le retour est bien 2.

Voilà il a compté tout simplement le nombre d'éléments affectés.

Si à un moment donné je fais admettons *64 / aaa*.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Indiquez x et y : 64 / aaa
X : 64 et Y : 0
RET : 1
```

Voyez qu'il est à 1.

Il y a une information qui a été testée, on voit qu'on a eu la moitié d'information affectée.

Le x est bon mais le y non.

Si éventuellement on s'amuse à noter n'importe quoi `\n`.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Indiquez x et y : /n
X : 0 et Y : 0
RET : 0
```

Bien sûr sans surprise on se retrouve avec zéro parce que là rien n'a pu être affectés donc ça juste avec le retour de la fonction scanf() donne énormément d'informations parce qu'à partir du moment où vous avez un code mémorisé dans une variable, on peut faire tout un tas de choses dessus.

Voilà on peut faire des conditions pour tester des valeurs, pour être sûr que çà fonctionne ou pas et si vous savez dans votre scanf() combien d'éléments vous attendiez pour affecter automatiquement vous savez en temps normal dans le scénario le plus normal le nombre ici qui doit être stocké là, `"%d / %d"`.

En l'occurrence si on n'en a pas deux déjà c'est qu'il y a eu un souci, c'est que `scanf("%d / %d", &x, &y)` n'a pas fonctionné ici niveau de l'affectation et si on essaye de stocker des informations qui ne sont pas compatibles forcément le retour de scanf() ne sera pas celui qu'on voulait et si vous gérez ce code de retour vous pourrez gérer un minimum les erreurs produites avec usage de scanf().

Alors donc ça c'est en partie une chose à connaître.

## Contrôler la taille de la donnée elle-même et eviter un débordement tampon

Voilà pour ça, on n'a pas fini c'est pas suffisant évidemment si c'était aussi simple ce ne serait pas trop le problème.

Alors ça c'est pas tellement on va dire l'élément qui est mis pour critiquer en tout cas l'usage de la fonction scanf().

La première chose qu'on lui reproche en fait la même chose que gets() notamment ici en liste noire je rappelle très important de dire que c'est une fonction qui ne vérifie pas la taille de l'information qu'on veut lire.

En gros si on s'attend à lire cinq caractères alors qu'au final il y en a 10 qui a été saisie ou dans un fichier vous lisez 10 caractères alors que vous en entendez 5, on a encore une fois le fameux débordement tampon càd le **buffer overflow**.

C'est un très très gros problèmes de sécurité dans un programme qu'on ne veut absolument pas.

Là encore est ce que c'est la faute principalement de la fonction scanf() ? non c'est de la faute du programmeur qui ne sait pas ou qui n'a pas encore apris à l'utiliser convenablement pour faire en sorte justement de contrôler la taille de l'élément qui est lu.

Pour cela on va passer sur une chaîne qu'on va même appeler buffer parce qu'on parle de buffer overflow d'accord et définis une constante.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    scanf("%s", buffer);

    printf("Mot saisi : %s\n", buffer);

    return 0;
}
```

*BUFFER_SIZE* là je mets 5 et comme il faut rappeler vous pour les chaînes de caractères, le petit rappel de caractère de fin qu'il faut stocker en plus `BUFFER_SIZE + 1` donc on oublie pas.

Pourquoi j'ai écrit ça `BUFFER_SIZE + 1` comme ça parce que simplement tout bête c'est l'auto-documentation de code permet de vous rappeler que ah oui il ne faut pas que j'oublie quand c'est une chaîne de caractère il faut penser à un élément supplémentaire pour stocker le fameux en *\0* qui est la représentation du caractère de fin pour une chaîne donc très important ça aussi.

Voilà une petite astuce pour ne pas l'oublier, ainsi en mettant comme ça *+ 1* on comprend que là bon en fait on fait comprendre que on va saisir cinq caractères maximum et pas six.

Je fait printf() avec pareil utilisation naïve de scanf() comme on aurait pu faire dans le cours sur la vidéo sur les chaînes d'ailleurs c'est à ce moment là je crois qu'on a commencé à se servir de fgets().

C'est sur les vidéo des chaînes qu'on a commencé à se servir de fgets() et après on l'a réutilisé pour les fichiers aussi.

Bon ensuite on l'avait utiliser bien sûr pour les fichiers.

On fait ça `scanf("%s", buffer);` et pas besoin de et commercial puisque c'est déjà une adresse et j'ai rien oublié.

Alors ça utilisation très naïve, pas sécurisé du tout je rappelle, on fait juste un usage standard, basique de la fonction qui n'est pas du tout propre, pas du tout à faire et voilà. C'est encore une fois que pour vous comprenez pourquoi.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : Jason
Mot saisi : Jason
```

Ok j'entre pareil bon scénario, très exactement ce qu'on attendait.

Pas de problème, aucun problème.

Si encore une fois je commence à dépasser c'est-à-dire noter plus de caractères que nécessaire, je vais faire un **débordement tampon** c'est pas génial. On ne veut absolument pas de ça d'accord.

```powershell
# avec la version de gcc du cours
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : sefsiefseifniefMot saisi :

# avec ma version de gcc
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : sefsiefseifnief
Mot saisi : sefsiefseifnief
```

Et bien l'information peut être parfaitement contrôlée.

En plus de contrôler ce qu'il faut, c'est pas on fait l'un ou l'autre non il faut tout faire c'est à dire pour un bon usage de scanf() il faut en premier vérifier, contrôler **le retour de la fonction** d'accord ça c'est obligatoire et aussi limiter donc c'est à dire contrôler **la taille de la donnée elle-même**.

### Indiquer un nombre de caractères à lire

Voilà et ça on peut le préciser grâce aux éléments ici de formatage `"%s"` qu'on a pour ses fonctions, ça fonctionne parfaitement.

Ici entre le *%* et l'identificateur *s* pour dire quel type de données vous voulez récupérer d'accord donc ici en l'occurrence pour une chaîne, vous indiquez un nombre représentant le nombre de caractères en l'occurrence que vous voulez lire donc moi c'est le fameux *BUFFER_SIZE* qui est de 5 donc je vais lui dire 5, **%5s**.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    scanf("%5s", buffer);

    printf("Mot saisi : %s\n", buffer);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : Jason
Mot saisi : Jason
./prog.exe
Mot en 5 lettres : JasonChampagne
Mot saisi : Jason
```

Si je note 5 caractères, pas de souci.

Si je note beaucoup plus on voit qu'il n'y a pas eu de débordement tampon, pas de problème.

La fonction scanf() a lu cinq caractères et après elle s'est tout simplement arrêtée.

Alors petite parenthèse scanf() n'a t-elle pas lu le reste du mot "...Champagne" ? attention non, c'est pas que la fonction s'est dit tiens hop je prend "Jason" terminé. Non elle a lu les caractères et éventuellement n'oubliez pas qu'il y a aussi des caractères de fin de chaîne, de retour à la ligne, tout ça (on va en parler d'ailleurs plus en détails après) ... tout ces caractères peuvent éventuellement être capturés et mis dans ce qu'on appelle le tampon.

En bref quand vous lisez pareil une information, vous avez ce qu'on appelle le tampon d'entrée donc c'est en l'occurrence ici **stdin** d'accord l'entrée standard pour être plus exact qui va capturer tout ce que vous lui passez d'accord.

scanf() en fait elle opère directement sur *stdin*.

Voyez nulle part dans les paramètres, dans les arguments on lui dit il faut faire ça sur *stdin*. Elle n'en a pas besoin elle le fait automatiquement là dessus donc elle va lire tout ce qu'elle peut lire là dessus *stdin -> eziefz* y compris éventuellement quand vous allez faire entrer sur votre clavier pour valider la saisie eh bien elle va valider tout simplement éventuellement un caractère de fin chaîne or dans certains cas le fameux retour à la ligne qui a été produit quand vous appuyez sur la touche entrer de votre clavier *stdin -> eziefz\n*.

Ainsi elle capture les cinq premiers caractères il peut y avoir des résidus d'information vous allez voir que ça peut poser problème et on va revenir de toute façon là-dessus aussi puisqu'on va voir comment on peut s'en débarrasser par la suite.

Alors notre code, ce n'est pas suffisant parce qu'évidemment on devrait effectivement s'assurer de ça donc on va faire encore un ret après tout pour regarder l'information.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Mot en 5 lettres : ");
    ret = scanf("%5s", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : Jason
Mot saisi : Jason
RET : 1
./prog.exe
Mot en 5 lettres : jasonzefzefzuepzef
Mot saisi : jason
RET : 1
```

Voilà on a l'information qui est bien saisie.

Ainsi donc là ça montre bien pourquoi je voulais montrer le retour que en fait on n'a pas eu une erreur de saisie.

Si on avait eu une erreur de saisie la fonction ici aurait retournée 0.

Là elle a bien réussie à affecter et heureusement qu'on a contrôlé la taille parce que sinon elle aurait essayé d'affecter beaucoup plus grand grâce à ce 5 ici *%5s* où on lui précise bien cinq caractères et du coup elle ne va lire que 5 caractères.

Une fois qu'il y a au delà de 5 caractères ça ne passe pas.

Alors ce n'est pas suffisant parce que voyez ce n'est pas tellement que la fonction est mal faites ou autre c'est que c'est assez contraignant à utiliser si on veut faire les choses proprement.

Beaucoup de gens préfèrent dire bon bah j'ai la flemme je n'utilise pas, j'utilise plutôt fgets() mais pour autant fgets() on va vite voir après aussi puisqu'on va revenir dessus même si on l'a déjà vu dans le cours que ça ne pose pas problème de sécurité en soi par contre ça pose des problèmes esthétiques qui sont assez casse pieds aussi quand on programme.

Voilà on va revenir dessus de toute façon.

Alors ça commence à faire une longue vidéo mais c'est important on a beaucoup de choses à voir.

#### scanf retourne -1 avec un espace

```
int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Mot en 5 lettres : ");
    ret = scanf("%5s", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```

Ici on a également et là ça concerne évidemment d'autres éléments aussi au niveau de la programmation, nous avons fait une demande de chaînes de caractères et dans un cas où on a demandé cinq caractères, en informatique le problème c'est que un caractère ça peut tout à fait être ça " " (un espace). 

```powershell
./prog.exe
Quel age as-tu ?  

Mot saisi : 
RET : -1
```

Là je viens d'entrer un caractère c'est un espace blanc d'accord ah et je fais ça et là vous voyez plus rien je fait un ctrl+c avant que le programme plante et on voit du coup *RET : -1* donc là du coup tout à planter pourtant à la base c'est dommage que le code avait l'air de bien fonctionner, d'être tout à fait sûr, secure, etc. et au final non.

Si je fais des espaces et qu'en plus je dépasse la taille ça pose problème c'est assez embêtant, il faut savoir une chose et ça encore une fois les gens ne savent pas parce qu'ils n'ont pas forcément appris ou ils ne l'ont pas étudiés.

## scanf lit le caractères de fin de chaîne

Du coup quand on fait certaines fonctions qu'on ne connaît pas un minimum mais il se passe des choses inattendues alors comment en fait se comporte une fonction comme scanf() vis-à-vis des identificateurs, des données que l'on veut lire d'accord ? il faut savoir que la fonction scanf() va supprimer par exemple les espaces donc ça ça ne posera pas de problème.

En gros une chaîne en c c'est un mot et ensuite un anti-slash 0 qui est le caractère de fin de chaîne, c'est le moyen en informatique qui permet de dire que la chaîne s'arrête là comme ça s'il y a d'autres données, on sait où est-ce qu'elle a commencé et on sait où est-ce qu'elle s'arrête d'accord.

```c
/*
    chaîne en C : blablabla\0
*/
```

Vous voyez qu'il faut compter tous ces caractères *blablabla* plus ce caractère là *\0* d'où le fameux +1 ici `char buffer[BUFFER_SIZE + 1];`.

Quand on fait du coup un *%s* ici `scanf("%5s", buffer);` donc là il n'y a pas de problème, la chaîne est valide c'est à dire qu'on lit une chaîne ici et le scanf() va parfaitement se charger d'ajouter ce fameux anti-slash 0 à la fin pour rendre la chaîne valide parce que les chaînes de caractères en c si elle n'a pas ce caractère de fin elle n'est pas valide donc ce n'est pas une chaîne en soit.

Très important de prendre en considération ça *\0* donc ici on a scanf() avec %s.

## Capturer un ou plusieurs charactères isolés sans le caractère de fin

> **"%c"** | **" %c"** | **" %25c"**

```c
/*
    chaîne en C : blablabla\0 (scanf avec %s)
*/
```

Maintenant si à un moment donné, on fait ça.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()

    ----------------

    chaîne en C : blablabla\0 (scanf avec %s)
*/

int main(void)
{
    char letter;
    int ret;

    printf("Une lettre : ");
    ret = scanf("%c", &letter);

    printf("Lettre saisie : %c\n", letter);
    printf("RET : %d\n", ret);

    return 0;
}
```

A un moment donné et là on va changer un peu les types et donc ça **%c** c'est pour capturer un caractère je ne vous apprends rien.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Une lettre : A
Lettre saisie : A
RET : 1
```
Pareil le scénario, pas de problème ça fonctionne.

On voit bien que scanf() a bien retourné l'information, pas de souci.

Si je mets 6.

```powershell
./prog.exe
Une lettre : 6
Lettre saisie : 6
RET : 1
```

Pas de problème non plus alors là c'est un cas particulier.

Alors je ne voulais pas non plus vous en parler d'ailleurs mais le cas en fait va prendre également des éléments de la table ASCII càd que la table ASCII, vous avez par exemple pour chaque caractère le A majuscule, le a minuscule, etc. un numéro correspondant parce que le *char* permet de stocker par exemple des numéros tout petit de -127 à 128, de -128 à 127 ou de 0 à 255 donc ça c'est un cas un peu particulier du coup pas de bol parce que je vous ai montrez un chiffre mais c'est pas le sujet parce qu'on en a déjà parlé sur d'autres vidéos donc je passe très vite là dessus.

Maintenant si je fais " A" càd un espace puis A.

```powershell
./prog.exe
Une lettre :  A
Lettre saisie :
RET : 1
```

On voit que pour la lettre saisie et bien il n'y a rien par contre le scanf() dit qu'on a en fait bien saisi l'information *RET : 1*.

**Effectivement le caractère blanc c'est un caractère**.

Il n'y a aucune raison que scanf() ne l'interdise puisque pour elle que vous fassiez ça "a" ou que vous fassiez ça " " c'est un caractère.

Voilà que ce soit le caractère affiché donc une lettre ou un espace blanc, il n'y a pas de problème c'est ce qu'elle attendait elle a pu afficher l'espace, elle a pu l'injecter donc le retour a bien été incrémenté on obtient bien 1 donc on peut dire bah c'est ok.

Pourtant l'information j'ai pas l'information donc là pareil comment on peut gérer ces espaces parce que on a des problèmes en fait d'espaces par rapport à ça, ça vient de cette fonction scanf() aussi encore une fois parce qu'elle a été conçue pour ça.

Là où avec une chaîne de caractères, avec la saisie d'un entier si vous saisissez l'âge comme on a vu tout à l'heure pas de problème d'accord elle va pouvoir gérer ça parce qu'en gros là si je fais ça, `scanf(" %d", &letter);` par exemple **" %d"** il faudrait saisir un espace et ensuite un entier d'accord, ça ne poserait pas de problème c'est gérer parfaitement.

Pour la chaîne de caractères on pourrait gérer etc etc.

Par contre dans le cas du caractère de l'identificateur pour les caractères et va en voir un autre un peu après là où ça pose problème c'est que les espaces en fait ça ne le supprime pas.

scanf() ne va pas se charger de supprimer les espaces en eux qui pourrait y avoir avant ou après.

Du coup dans le cas qu'on a vu ici ça pose souci.

Alors la petite subtilité, la petite astuce très simple il suffit seulement pour lui d'accord pour l'identificateur **" %c"** c'est très important, vous mettez un petit espace avant et là vous **préciser à scanf() de penser à retirer tous les espaces qui ont pu être mis d'accord au niveau de l'identificateur**.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()

    ----------------

    chaîne en C : blablabla\0 (scanf avec %s)
*/

int main(void)
{
    char letter;
    int ret;

    printf("Une lettre : ");
    ret = scanf(" %c", &letter);

    printf("Lettre saisie : %c\n", letter);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog

./prog.exe
    Une lettre :  A
    Lettre saisie : A
    RET : 1

./prog.exe
    Une lettre :      A
    Lettre saisie : A
    RET : 1
```

Cette fois-ci l'information est bien récupérée comme il faut donc c'est tout bête mais c'est des petit élément quand on ne le sait pas forcément on peut avoir des petits soucis au niveau de l'usage de certaines fonctions et notamment au niveau de l'exécution de nos programme.

C'est donc très important puisque par défaut pour la chaîne de caractères càd le *%s* scanf() va ajouter le caractère de fin d'accord automatiquement, pas de souci.

Par contre voilà évidemment quand il s'agit d'une chaîne comme ça "c" c'est un simple caractère donc scanf() ne va pas ajouter *\0* d'accord ça se serra à vous de le faire manuellement puisque évidemment *" %c"* sera considéré comme un simple caractère isolé d'accord tout seul.

Si par la suite je ne sais pas mais on veut par exemple faire ça **" %25c"** et dire que je veux 25 caractères, c'est possible après tout de fait.

Soit 25 caractères isolés ça fait quoi ? ça fait une chaîne mais du coup ce serait stocké dans un tableau, `char letter[26];`.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

int main(void)
{
    char letter[26];
    int ret;

    printf("Une lettre : ");
    ret = scanf(" %25c", letter);

    printf("Lettre saisie : %s\n", letter);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
./prog.exe
Une lettre : AZERTYUIOPQSDFGHJKLMWXCVBN1234567890
Lettre saisie : AZERTYUIOPQSDFGHJKLMWXCVB
RET : 1
```

Alors ça fonctionnerait en faisant ça comme ça `scanf(" %25c", letter);` d'accord parce que je lui dis 25 caractères isolés tu les stockent ici `char letter[26];`.

Voilà scanf() prendra bien les 25 caractères isolés qui formeront une chaîne d'accord.

Une chaîne c'est une chaîne de plusieurs caractères différents donc on pourra gérer ça de cette manière et après afficher avec un *%s* etc.

Je ne compile pas parce que ces pour expliquer un peu le principe.

On peut vérifier ça.

Par contre en soit là le code ne fonctionnerait pas parce que la chaîne n'est pas valide en elle-même parce que dans le cas du *%c* de l'identificateur de caractère comme c'est pas à la base prévu pour une chaîne mais pour un simple caractère on n'a pas de caractère de fin de chaîne donc il faudra manuellement donc déjà prévoir un espace qu'il faut et vous-même manuellement si vous venez à faire ce genre de lecture ajouté le fameux anti-slash 0 à la fin *\0* de la variable donc en l'occurrence du buffer que vous utilisez pour stocker ça.

Alors généralement on ne s'embête pas à lire des caractères comme ça automatiquement 1 à 1.

On va donc prendre une chaîne soit taille fixe si on contrôle exactement la longueur des données qu'on lit, soit à taille variable dans ce cas là ont fait de l'allocation dynamique mais c'est évidemment pas le sujet non plus de la vidéo.

Voilà donc plein plein plein de moyens comme ça d'effectuer ce genre d'information.

## [Les expressions rationnelles](https://www.youtube.com/watch?v=f3QwwnvSQ50)

> **%s** , **%c** , **%d** , **%[]** , **%5s** , **%5[]** , **%[abc]** , **%5[abc]** , **%5[^abc]** , **%5[a-z]** , **%5[A-Z]** , **%5[A-Za-z]** , **%5[A-Za-z0-9]** , **%5s**

On va revenir également très rapidement sur un autre exemple et après on terminera avec l'usage de fgets() en l'occurrence et on parlera vite fait de conversions pour terminer.

Voilà donc là beaucoup beaucoup d'informations que je voulez vous montrer par rapport à ça.

Ce qui est à savoir aussi mais on va reprendre l'exemple d'avant.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Mot en 5 lettres : ");
    ret = scanf("%5s", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : jason
Mot saisi : jason
RET : 1
./prog.exe
Mot en 5 lettres : efziefiznef
Mot saisi : efzie
RET : 1
./prog.exe
Mot en 5 lettres : \n
Mot saisi : \n
RET : 1
```

Ok voilà.

D'ailleurs voyez *\n* a fonctionné donc ça c'est bon, on a récupéré l'information.

Passons à autre chose.

On peut aussi aller plus loin parce que je vais parler de mon identificateur standard pour les entier, pour les chaînes, pour les caractères, pour les flottants, etc. bref on a vu pas mal d'identification qu'on a abordé dans le cours.

Il faut savoir aussi que ces fonctions avec formatage permettent également de travailler avec des **expressions rationnelles**.

Les expressions rationnelles au moment où cette vidéo est enregistrée donc si vous la regardez pas longtemps après sa publication je n'ai pas encore fait de vidéo sur les expressions rationnelles sur la chaîne, ça fait partie des choses prévues mais comme il y a énormément d'éléments à voir voilà c'est une vidéo qui est à préparer et sur plein plein de choses différentes et vous verrez qu'il y a plusieurs syntaxe c'est surtout ça en fait qui pose problème donc il y a une vidéo de prévu de toute façon qui n'est pas encore enregistrée au moment où j'ai publié cette vidéo mais qui est prévu de toute façon et qui sera peut-être déjà en ligne si vous voyez cette vidéo plus tard concernant les expressions rationnelles.

[Expressions rationnelles](https://www.youtube.com/watch?v=f3QwwnvSQ50)

En gros les expressions rationnelles c'est pour valider un schéma d'information par exemple on peut se servir des expressions rationnelles en web pour valider une adresse email, pour être sûr que c'est bien une adresse e-mail valide et une adresse ip et valider un code postal ce genre de choses.

On peut se servir de ça.

Une fonction comme scanf() notamment peut utiliser des expressions rationnelles pour fonctionner avec un autre système identificateur.

Au lieu d'utiliser un *%s*, *%c*, *%d* et compagnies, on va utiliser le *%[]* qui va prendre évidemment un certain nombre d'éléments donc ça fonctionne toujours dans de cette manière là càd le % d'accord, éventuellement une valeur numérique pour indiquer la longueur de ce qu'on veut lire et ensuite un identificateur càd que là par exemple quand on faisait ça *%5s* hé bien rien ne vous empêchera de faire ça, *%5[]*.

```c
/*
    %5s, %c, %d

    %5[]
*/
```

*%5[]*, on lit 5 informations donc 5 caractère a priori en fonction de l'expression rassionnelle qu'on va avoir mis entre les crochets et je vais vous montrer en pratique ce que ça donne.

### Lire que des minuscules abc

Par exemple, je peut lire des minuscules d'accord, *Que des minuscules*.

Pour dire de lire que des minuscules donc je précise non pas un *%s* mais on va lire que des a ou b ou c, *%[abc]* et je vais dire *Que des a ou b ou c*.

On va aller étape par étape, je peux utiliser cette expression rationnelle là *abc* entre crochets.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Que des a ou b ou c : ");
    ret = scanf("%[abc]", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```

Vous mettez à l'intérieur des crochets les éléments que vous voulez capturer par la lecture ici, `scanf("%[abc]", buffer);`.

Je rappelle que de toute façon, on ne pourra pas lire grand chose càd que cinq caractères est assez court, on y va.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Que des a ou b ou c : abdcc
Mot saisi : ab
RET : 1
```

nb. On note une autre lettre que a b ou c, et ici la chaîne s'arrête à 2.

```powershell
./prog.exe
Que des a ou b ou c : abcca
Mot saisi : abcca
RET : 1
```

Voilà ça fonctionne.

Maintenant je met de caractères qu'il ne faut pas et là il fait ça.

```powershell
./prog.exe
Que des a ou b ou c : abdfczezepzep
Mot saisi : ab
RET : 1
```

Pourquoi ils s'est arrêté à *ab* tout simplement parce que scanf() va lire les caractères qu'on lui a autorisé d'accord ça agi une expression rationnelle comme un filtre d'accord pour dire que moi je m'attends à lire ça *abc* par contre au moment où je n'ai plus les informations que j'attends, explicitement c'est indiqué dans le code, j'arrêterai ma lecture.

Tant pis si on n'a pas fini ce qu'on devait lire, on s'arrêtera avant.

### Lire que des minuscules abc en passant une taille

Voilà donc là on ne lui a pas passé de taille d'accord donc on espère que l'utilisateur ne va pas dépasser ça sinon on aurait un débordement tampon encore une fois, c'est pas suffisamment sécurisé comme on l'a écrit-là, voilà admettons qu'on peut dire ça en mettant 5 ici **"%5[abc]"** explicitement.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Que des a ou b ou c : ");
    ret = scanf("%5[abc]", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Que des a ou b ou c : aaaaa
Mot saisi : aaaaa
RET : 1
./prog.exe
Que des a ou b ou c : aaaaaaaaaaa
Mot saisi : aaaaa
RET : 1
```

Si j'en note 5, ils sont bien capturés.

Si j'en note plus que 5, pas de débordement tampon, je rappelle qu'on a sécurisé voilà on a contré en fait le risque de débordement tampon avec la fonction scanf() en indiquant qu'on voulait lire seulement cinq choses et que des *abc* avec *"%5[abc]"* aussi donc c'est tout ce qui est filtré et du coup si je fais ça *faaaadzazd* dés le débuts rien ne sera lu et voyez que même RET est sympa parce qu'ils vous indique que ça n'a pas fonctionné.

```c
#include <stdio.h>

#define BUFFER_SIZE 5

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    int ret;

    printf("Que des a ou b ou c : ");
    ret = scanf("%5[abc]", buffer);

    printf("Mot saisi : %s\n", buffer);
    printf("RET : %d\n", ret);

    return 0;
}
```
```powershell
./prog.exe
Que des a ou b ou c : faaaadzazd
Mot saisi :
RET : 0
```

Voilà ça n'a pas fonctionné.

Je peux aussi faire ça, *chhdeeze*.

```powershell
./prog.exe
Que des a ou b ou c : chhdeeze
Mot saisi : c
RET : 1
```

Et là pour le coup *RET* mais on a récupéré que l'élément qui devait être lu.

Voilà donc ça va bien effectivement lire les éléments qu'on veut et dès qu'un élément qui n'était pas demandée est rencontré la lecture s'arrête tout de suite. La lecture s'arrête parce qu'elle ne rentre plus dans le schéma là *abc*.

Et donc ça s'arrête au premier cas d'arrêt spécifique par votre expression.

### Lire inverse de abc et en passant une taille

Pour faire l'inverse, vous mettez ici un accent circonflexe **%5[^abc]** tout simplement pour dire ben en fait 5 caractères qui ne sont ni des *a*, ni des *b*, ni des *c*.

### Lire les minuscules

> **"%5[a-z]"**

Si vous voulez faire tout l'alphabet donc les minuscules attention les minuscules et les majuscules ont de l'importance vous pouvez mettre *a-z*.

```c
scanf("%5[a-z]", buffer);
```

Donc là je monte rapidement parce que ce n'est pas le cours sur l'expression rationnelle donc je vais très vite là dessus.

### Lire les majuscules et cumuler les expressions

> **"%5[A-Z]"** | **"%5[A-Za-z]"** | **"%5[A-Za-z0-9]"**

Pour les majuscules, vous mettez *A-Z* et vous pouvez bien sûr les cumuler comme ceci *A-Za-z0-9* où on met même les nombres comme ça.

```c
scanf("%5[A-Z]", buffer);
scanf("%5[A-Za-z]", buffer);
scanf("%5[A-Za-z0-9]", buffer);
```

Voilà on peut mettre pas mal d'éléments comme ça donc ça *A-Za-z0-9* ça veut dire qu'on accepte tout ce qui est alpha numérique en fait rien d'autre.

Et donc on peut parfaitement filtrer du coup les informations que l'on indique ici *[]* donc trois choses à savoir soit le *retour de scanf()* à contrôler dans tous les cas pour être sûr qu'on a bien pu mémoriser les éléments qu'on voulait. On *limite la taille* des informations qu'on lit et éventuellement si ça a une nécéssité parce que ça a un coup quand même en termes de ressources mais on peut utiliser une *expression rationnelle* si on veut contrôler, exactement filtrer les informations qu'on veux.

Oui vous avez trois outils très simples à utiliser, deux qui sont obligatoires càd **le retour** et **la taille** c'est obligatoirement utiliser tout le temps et éventuellement **l'expression rationnelle** pour pouvoir sécuriser d'accord la lecture de scanf().

Alors il y a d'autres cas càd que si on est un peu malin on peut éventuellement contourner parce que voilà on a un symbole qu'on utilise pour le scanf() qui est le fameux *%* ici.

On peut dans certains cas aussi réussir à contourner ça *%* pour produire en fait le débordement tampon par rapport justement au formatage qui est fait là.

### Doubles guillemets

Alors il existe des solutions via de moyens, via des macros ou autre si vous voulez, vous arranger en fait pour qu'au moment de la compilation de votre programme de se retrouver avec des doubles guillemets pour vous assurer en fait que l'information que vous aurez capturée par exemple sera bonne.

> **""%5s""**

```c
scanf(""%5s"", buffer);
```

C'est simplement un petit contournement pour éviter les gens qui voudraient par exemple contourner cette notation pour essayer quand même de produire des débordement tampon, c'est pour ça que je dis qu'il y a quand même rien dans tous les cas qu'on peut assurer à 100% parce qu'on peut toujours trouver des contournements, des failles dans tout les cas donc c'est toujours difficile de dire bon ben voilà on peut assurer et garantir que 100% dans 100% des cas notre code sera sécurisé.

C'est très difficile ça l'est on va dire jusqu'à ce que quelqu'un arrive éventuellement à contourner ou à trouver une nouvelle faille ou autre.

Attention donc il y a toujours d'autres cas comme ça à savoir mais déjà en terme d'usage contrôler le retour de la fonction scanf() et limité le nombre de données lu ça vous évitera énormément énormément de problèmes et au moins vous n'utiliserez pas de manière non sécurisés en tout cas ça, au moins c'est quelque chose qui est sûre, c'est que vous aurez quand même fait le nécessaire par rapport aux outils que propose la fonction pour sécuriser son usage qu'on vous en ferai.

Pareil pour le scanf(), ça fonctionne un peu pareil alors on pourrait éventuellement passer par d'autres outils il y a d'autres fonctions de lecture qui existent mais je vais bien sûr passer très vite dessus et en attendant il y avait notamment sscanf() qui permet de gérer une chaîne par rapport à une autre mais je passerai très très vite là dessus.

Je vous laisserai vous renseigner si vous voulez parce que je ne peux de toute façon pas tout vous montrer non plus dans le détail.

On va terminer et la vidéo est déjà longue, on arrive dans 1 heure facile.

## fgets

On va parler de fgets parce que c'est quand même un peu ça qu'on attend de voir et surtout un problème que vous avez peut-être déjà rencontrés avec cette fonction ou que vous allez rencontrer de toute façon avec cette fonction quand vous en ferez usage, **c'est la fonction sécurisé par défaut**.

```c
/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets()
*/
```

A l'inverse de toutes celles-là, fgets() assure la sécurité de ce qui est lu puisqu'elle oblige à indiquer la taille de ce qu'on veut lire. Voyez là pour le scanf() si vous ne le faites pas avec le 5 de *"%5s"* elle ne le fera pas tout seul mais pour fgets() ça fait partie des éléments qu'elle va demander donc si vous ne le mettez pas bah ça ne compilera tout simplement pas.

Comment s'utilise fgets() au plus simple, alors fgets() retournera donc l'élément que vous avez lu sinon va retourner nul, ça c'est pour l'information.

C'est une fonction qui retournera nul si elle n'a pas réussi à lire l'information.

Pareil malgré ça si vous l'utilisez alors tout simplement en faisant ça.

```c
#include <stdio.h>
#define BUFFER_SIZE 5

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    fgets(buffer, 6, stdin);
    printf("%s\n", buffer);

    return 0;
}
```

fgets() qui prend le *buffer* et la taille qui est en l'occurence 6 (pour capturer l'*\0*) et *stdin* pour l'entrée standard.

D'accord donc ça c'est le cas le plus classique.

Ensuite j'affiche directement le mot.

Là on compile, puis ./prog il demande la saisie c'est normal je note l'information alors évidemment je note l'information et pas de problème.

```powershell
gcc -Wall -Werror main.c -o prog  
./prog.exe
jason
jason
./prog.exe
jasonefzefzeifninefz
jason
```

Si je fait ça *ja so*.

```powershell
./prog.exe
ja so
ja so
```

Il prend également les espaces.

Je ne vous l'ai pas dit parce que je ne peux pas encore une fois tout vous dire, pour le scanf() et ça vous l'avez déjà remarqué, scanf() s'arrête à l'espace rencontré d'accord sauf si dans le formatage vous indiquez que vous voulez le capturer mais si vous ne l'indiquez pas par exemple et que vous demandez un prénom simplement que vous mettez un *%s* dans le scanf().

Admettons si la personne s'appelle Jean-Pierre et qui au lieu de mettre un tiret entre les deux, il met un espace et ben ça va bien capturer le mot Jean et puis le Pierre il sera perdu. Il restera dans le tampon d'entrée et l'information n'aura pas été récupérée par le scanf().

*Pareil je ne l'ai pas dit mais effectivement scanf() s'arrêtera au premier espace blanc rencontré par rapport à ça donc attention à cet élément là.*

Là vous voyez que fgets() le capture, il n'y a pas problème et ça capture telle quelle.

Alors on se dit c'est bien, elle est déjà sécurisé au départ donc c'est vrai qu'on n'a pas trop besoin de se prendre la tête par rapport à ça.

## [strtol](https://en.cppreference.com/w/c/string/byte/strtol)

Il y a quelques petites fonctions qui font partie de la liste blanche aussi bien sûr parce que comme on ne peut pas utiliser ces fonctions là *atoi(), atol(), atod()* qui s'assurent juste de faire en fait de la simple conversion sans aucun contrôle de rien.

Je vais aller très vite mais il existe des fonctions *strtol(), strtod(), strtul()* qui permettent de vérifier l'information que vous voudriez récupérer.

```c
/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/
```

**Par exemple ceci, on détaille ci-dessous.**

```c
#include <stdio.h>
#include <stdlib.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()

    long int strtol(const char *str, char **endpr, int base)
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    long number = 0;

    fgets(buffer, 6, stdin);

    number = strtol(buffer, NULL, 10);

    printf("Nombre : %ld\n", number);

    return 0;
}
```

Alors en premier paramètre pour strtol() si je montre en gros très rapidement ça va prendre tout simplement la chaîne d'accord sur laquelle travailler `const char *str` alors ça va prendre un pointeur `char **` pareil si vous ne l'avez pas étudié parce qu'on n'en a pas tellement parler en vidéo mais bon c'est logique.

```c
/*
    long int strtol(const char *str, char **endpr, int base)
*/
```

Rappelez vous qu'un pointeur dans un pointeur, on mémorise l'adresse d'accord l'adresse d'une information donc on peut évidemment faire un pointeur de pointeur.

Un pointeur de pointeur c'est un pointeur qui stocke en fait un autre pointeur d'accord ça pointe sur un pointeur.

Voilà on peut toujours faire un pointeur, de pointeur, de pointeur, de pointeur, etc. on peut s'amuser à ça.

Ainsi on a en fait un pointeur de fin d'accord en gros et on va avoir une base `int base` pour notamment strtol().

La base, c'est la base du numérique.

La base 10 par exemple c'est la base décimale de 0 à 9.

Base octale c'est de 0 à 7, base héxadécimale, etc.

Voilà je ne vous apprend rien, c'est des choses qu'on a déjà abordés dans certaines vidéos. Je passe très vite dessus donc là ce qu'on va faire... on lui passe *buffer* à strtol() ici.

```c
number = strtol(buffer, NULL, 10);
```

ici éventuellement comme fgets() qui a une sécurité *6*, strtol() a une sécurité qui dit que pour le coup on pourrait également récupérer dans un pointeur d'accord il suffira de faire un pointeur sur char, en variable à coté que je ne vais pas faire ici et ainsi récupérer l'élement au moment où on s'est arrêter en fait de faire la conversion. Nous ici honnêtement on ne va pas le récupérer donc NULL, on va se contenter de ça et on travaille en base 10 puisqu'on veut récupérer un nombre décimale donc on met cette information comme çà.

Et comme il s'agit de conversion de chaîne, on n'oublie pas l'en-tête <string.h>.

On saisie n'importe quoi, *jason*.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
jason
Nombre : 0
```

*Nombre : 0* parce qu'évidement si on essaye de convertir un prénom en un nombre ça ne passe pas.

Voyez il y a une sécurité quand même alors on n'a pas vraiment vérifier le retour mais on devrait contrôler le retour parce que si notre conversion ne se fait pas, c'est fonction comme strtol(), strtod() ou strtul() si on veut travailler sur des valeurs non-signées donc seulement positive vont retourner zéro.

Voilà donc là il suffirait de contrôler ça.

```c
number = strtol(buffer, NULL, 10);
```

Là il suffirait de contrôler ça et de voir si ça retourne zéro d'accord et bien c'est qu'elle n'a pas fait la conversion et que ça n'a pas fonctionné.

Effectivement on peut voyez gérer l'erreur.

Voilà on pourra dire que la conversion n'a pas fonctionné ce qui n'aurait pas été possible avec ces fonctions-là, qui vont essayer de convertir et si ça ne marche pas tant pis pour nous alors on fera comme ça donc il faut utiliser des fonctions qui permettent déjà de base de sécuriser les conversions qu'on fait.

```c
#include <stdio.h>
#include <stdlib.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()

    long int strtol(const char *str, char **endpr, int base)
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];
    long number = 0;

    fgets(buffer, 6, stdin);

    number = strtol(buffer, NULL, 10);

    printf("Nombre : %ld\n", number);

    return 0;
}
```
```powershell
./prog
1564324994
Nombre : 15643
```

Et sinon si je note plus que 5 caractères, on récupère bien les cinq premiers caractères, ça a bien pu être convertis en nombre et du coup on a bien stocké dans number le nombre en l'occurrence.

*number* est maintenant une valeur numérique avec laquelle on va pouvoir faire des calculs, le travail et cetera.

Si c'était resté une chaîne, ce serait une chaîne de caractères donc un type complètement différent.

## fgets et son tampon entrée

Voilà donc ça c'était un point pour la conversion rapide et on termine enfin cette vidéo avec la partie sur fgets() problème que vous aurez certainement rencontrer à un moment ou un autre par rapport à son usage.

Alors on va reprendre un code basique.

```c
#include <stdio.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    fgets(buffer, BUFFER_SIZE + 1, stdin);
    printf("%s\n", buffer);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog
jason
jason
```

Si je fais ça, pas de problème.

Maintenant, on répète l'opération. Attention, je fais de la répétition de code il faudrait factoriser dans une fonction mais on n'a pas le temps et on va faire ça comme ça.

```c
#include <stdio.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod()
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    fgets(buffer, BUFFER_SIZE + 1, stdin);
    printf("%s\n", buffer);

    printf("-------------\n");

    printf("Mot en 5 lettres : ");
    fgets(buffer, BUFFER_SIZE + 1, stdin);
    printf("%s\n", buffer);

    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog
Mot en 5 lettres : jason
jason
-------------
Mot en 5 lettres :

```

Cette fois ci, je compile et je saisi une première information et là voyez paf le programme s'arrête.

Voià là déjà c'est embêtant parce qu'on a effectivement la première information qui a été lue et la deuxième j'ai même pas eu le temps de saisir quoi que ce soit ça revient sur le prompt d'accord et la saisie s'est arrêtée.

Alors ça c'est un problème que vous êtes nombreux forcément à avoir rencontré déjà parce que j'ai eu beaucoup de demande d'aide par rapport à ça et vous serez certainement encore tout autant nombreux à avoir ce souci là également.

Alors il y a plusieurs informations à savoir d'ailleurs pareil si j'écrit une chaîne plus longue.

```powershell
./prog
Mot en 5 lettres : jasonzefzefzef
jason
-------------
Mot en 5 lettres : zefze
```

Voyez qu'en plus le reste de la 1e partie ici se retrouve dans l'autre lecture donc ça peut être encore pire. On peut se retrouver des exemples encore pire.

Voyez fonctions sécurisées avec des tests mais ça ne veut pas dire pour autant que tout fonctionne bien comme on le voudrait.

Alors ça ne posera pas de problème de débordement tampon parce que la taille est préciser ici à la lecture `fgets(buffer, BUFFER_SIZE + 1, stdin);` comme si vous faisiez scanf() en précisant la taille.

On ne peut pas tricher là dessus à ce niveau là.

Pour autant des fois on peut avoir des choses qui ne se passent pas très très bien.

Comme je vous le disais au niveau de la mémoire tampon, quand vous avez des données à lire bon là fgets() effectivement se contente de lire un certain nombre de données `BUFFER_SIZE + 1` et après elle s'arrête pour autant ça ne veut pas dire que le reste, on s'en est débarrassé.

Il y a toujours ce fameux tampon d'entrée d'accord de lecture qui contient des données donc dès que vous allez vouloir réutiliser le tampon d'entrée pour attendre de nouvelles données et comme il y avait des données précédemment qui était à l'intérieur, eh bien elles vont être stockés et c'est pour ça qu'on a cette fameuse fin de programme qui se produit avec le reste finalement de ce que j'avais dans la première partie, *zefzefzef*.

C'est assez embêtant par rapport à ça parce que du coup si je note, si je met deux fois le prénom ça fait 2 fois 5.

```powershell
./prog.exe
Mot en 5 lettres : jasonjason
jason
-------------
Mot en 5 lettres : jason
```

Là je retrouve deux fois le nom mais c'est pas du tout ce qu'on voulait d'accord on a séparé les choses mais on ne voulait absolument pas ça donc c'est assez problématique et en plus voyez même pas d'affichage, rien du tout, il manque pas mal d'informations.

On a pas mal d'informations qui n'ont pas terminé en fait au niveau de l'exécution du programme.

Alors il peut y avoir des cas à prendre en compte déjà c'est que la fonction fgets(), c'est ça qui dérange beaucoup de gens aussi et qui est un peu embêtant. Dommages pour les développeurs fainéant parce que là le problème c'est que si vous êtes fainéant même pour fgets() dommage mais ce n'est pas suffisant, il faut faire des choses aussi.

C'est une fonction qui va ajouter un retour à la ligne et du coup le retour à la ligne même si je le fais directement moi-même.

```powershell
./prog.exe
Mot en 5 lettres :


-------------
Mot en 5 lettres : kzef
kzef

```

Hop et bien le retour à la ligne voyez il sera pris en compte en fait comme un caractère parce qu'il est ajouté dans tous les cas.

Je peux même tenter des trucs comme ça.

```powershell
./prog.exe
Mot en 5 lettres : \n
\n

-------------
Mot en 5 lettres : zefz\0
zefz\
```

On peut notez n'importe quoi comme ça *\0* et voyez on se retrouve avec des choses un peu bizarre du coup le *0* n'a pas été capturé mais on a quand même l'anti-slash.

Bref on a vraiment bon du coup des résultats assez bizarre.

Ainsi le **fgets() va déjà ajouter un anti-slash n \n** ce qui est assez problématique parce que nous on ne le veut pas.

Voilà il faut savoir que c'est une fonction, je rappelle qu'on a déjà présenté dans le cours donc je ne vous refais pas tous les détails de la fonction elle-même puisqu'on en a déjà parlé dans le dans le cours en c mais d'une fonction qui pour le coup ne va pas lire en fait un format directement sur un ensemble de données formatés mais va lire une ligne d'accord une ligne d'informations.

Donc là en gros, elle va lire tout ce que vous lui donné au moment de la saisie, elle va limiter le nombre d'éléments récupérés grâce à son deuxième argument ici `BUFFER_SIZE + 1` mais c'est tout.

## Vider le tampon entrée

Pour autant il peut y avoir d'autres informations qui reste encore une fois dans le tampon de lecture et qui seront peut-être ré-utilisé par la suite donc première chose qu'on peut faire, qu'il faut savoir aussi, je crois de toute façon que j'en avais déjà parlé dans le cours mais c'est bien d'en reparler ici parce qu'il faut le savoir c'est de **vider le tampon d'entrée**.

### Ne pas utiliser fflush

Première chose dans les fonctions alors on a la fonction fflush() qu'il ne faut pas utiliser surtout avec cet argument là, *stdin*.

```c
/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod() ; fflush(stdin)
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/
```

Voilà le fflush(stdin) en passant l'argument *stdin* n'est absolument pas à faire.

Alors ça c'est pareil parce que si un jour vous faites ça fflush(stdin) vous allez vous faire dégommer.

C'est absolument faux, faux, archifaux.

Pareil, je ne suis pas du genre à cracher sur les autres supports mais si un jour vous achetez un livre ou vous allez sur un site ou un forum, n'importe quoi et que vous trouvez sur un code ce genre d'exemples voilà le livre vous pouvez vous en débarassez mais enfin bref on s'éloigne de ça, fflush(stdin).

En gros qu'est ce que ça veut dire, fflush(stdin) ? ça veut dire que déjà c'est une fonction qui travaille sur des tampons en sortie, par exemple de l'affichage, et avec ce genre de fonction  qui a été conçu pour faire ça, on lui dit tu dois essayer de vider un trop-plein d'entrée donc j'ai même pas besoin de vous en dire plus et si vous voulez vous renseigner sur cette fonction en détail, savoir comme pour scanf() son comportement bien précis, bien détaillé vous verrez exactement comment elle fonctionne et vous comprendrez par vous même pourquoi fflush(stdin) n'est absolument pas tolérable et pas possible.

Tout simplement parce que fflush(stdin) peut très bien fonctionner comme ça peut ne pas fonctionner du tout voilà parce que comme elle n'est pas conçue pour travailler sur des tampons de lecture, hé bien forcément des fois elle peut réussir à s'en sortir et que ça fonctionne bien et des fois non et on obtient donc un comportement complètement indéfini, indéterminé.

Voilà il y a des cas où je dirais bah tiens ça a fonctionné et d'autres non.

Vous passerez le programme à quelqu'un ça fonctionnera pas, ensuite il va relancer le programme une seconde fois et ça fonctionnera bref comme c'est absolument indéterminée, indéfinie on ne fait pas ça fflush(stdin).

fflush() ne s'utilise que sur des tampons de sortie d'accord, des tampons d'écriture.

Donc ne faites pas ça.

### Création de fonctions pour vider le tampon entrée

> **flush_input_buffer()**

Du coup comment on fait pour libérer le tampon de lecture nous mêmes et pourquoi d'ailleurs on pourrait même se poser la question pour terminer pourquoi le langage ne le propose pas ? parce que tout ce qui est finalement tampon de lecture, d'écriture, etc. ce n'est pas quelque chose qui appartient en fait au langage de programmation en lui-même.

C'est votre système qui gère ça en fait, c'est windows, c'est GNU Linux, c'est MacOS et android, etc.

C'est à votre système d'exploitation que revient, c'est vraiment là de la programmation encore plus bas niveau, on est dans l'utilisation, dans le fonctionnement de votre système qui définit des tampons, de lecture, d'écriture et cetera, donc un langage ne peut pas se permettre de dire ben voilà je vais agir, je vais en fait concevoir des fonctions qui vont directement travailler sur certains tampons ou décider du comportement en fait du système.

Non c'est à votre Windows, à votre Linux, à votre MacOS de décider de comment il fait fonctionner ses appels ou ses fonctions système.

C'est pas à un langage de programmation de décider de tout ça.

Du coup on est obligé d'accord ne pensez pas que les développeurs étaient pour le coup fainéant et qu'ils n'ont pas été foutu de faire une fonction pour faire eux mêmes ça directement tel que c'est prévu dans le langage parce que c'est juste qu'on ne peut pas le faire parce qu'on produirait du coup un programme qui n'est pas portable, qui n'est pas fonctionnel partout.

Ainsi vous devez manuellement **faire vos propres fonctions pour vider ce fameux tampon d'entrée**.

Il existe plusieurs façons de faire mais la façon la moins coûteuse et qui est quand même très très simple pour tout le monde, c'est de faire une petite fonction qu'on va appeler flush_input_buffer() qui ne retourne rien et ne prend rien en paramètres.

```c
void flush_input_buffer(void)
{
    int c = 0;

    while(c != '\n' && c != EOF)
        c = getchar();
}
```

Vous initialiser une variable *c* que vous initialiser à zéro, c'est mieux que simplement déclarer. C'est un plus propre.

While(), tant que ce que vous lisez ici, un entier simplement, est différent d'un retour à la ligne *\n* d'accord très important, et que le caractère que vous vous apprêtez à lire est différent de End Of File donc c'est une macro en fait EOF pour fin de lecture, fin de fichiers ou peu importe, on demande de faire une récupération donc un getchar() qui va lire simplement un caractère de cette manière.

Voilà donc en fait ça veut simplement dire de faire appel à getchar() et qui le mémorise dans *c* autant de fois que nécessaire jusqu'à rencontrer un caractère de retour à la ligne ou EOF.

Voilà ça permet de dire que s'il reste des éléments dans le tampon d'entrée parce que getchar() quand on va l'appeler va justement accéder au tampon d'entrée et si elle trouve des informations ben voyez, on va s'en débarrasser.

On va les mémoriser à chaque fois dans *c* et voyez qu'on n'affiche pas une seule fois les informations, on ne travaille pas avec.

Voyez on les jette, on les jette, on les jette jusqu'à arriver sur le *\n* ou le fin de fichier *EOF* on s'arrête et on quitte.

Voilà ça c'est un **flush** très simple à faire, il y a encore une fois d'autres implémentations possibles et celle-là me semble suffisamment simple et compréhensible par rapport à ça pour vider efficacement le tampon d'entrée.

Bien évidemment ça se fait quand le tampon contient des données c'est-à-dire que pareil il faudra vérifier qu'effectivement le tampon d'entrée contient les informations.

Si vous essayer de vider un tampon d'entrée qui est vide, évidemment ça tournera en boucle.

Voilà ça tournera en rond parce que getchar() attendra des choses à lire et comme le tampon n'aura rien à lire, eh ben il ne se passera rien donc il faut prendre en compte ces choses-là.

Ainsi on peut éventuellement quand il y une information comme ça à lire, après les premières saisies qu'on a pu avoir s'amuser à faire comme ça à faire un vidage du buffer.

Et vous aller voir de toute façon que ça ne va pas suffire.

```c
#include <stdio.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod() ; fflush(stdin)
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/

void flush_input_buffer(void)
{
    int c = 0;

    while(c != '\n' && c != EOF)
        c = getchar();
}

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    fgets(buffer, BUFFER_SIZE + 1, stdin);
    printf("%s\n", buffer);

    flush_input_buffer();
    printf("-------------\n");

    printf("Mot en 5 lettres : ");
    fgets(buffer, BUFFER_SIZE + 1, stdin);
    printf("%s\n", buffer);

    return 0;
}
```
```powershell
./prog.exe
Mot en 5 lettres : jasonjason
jason
-------------
Mot en 5 lettres : jason
jason
./prog.exe
Mot en 5 lettres : ezfizeinzef
ezfiz
-------------
Mot en 5 lettres : zefz
zefz

```
Voyez là il a bien capturé le premier et on nous redemande l'information ok.

On arrive à peu près à se dépatouiller de cette manière ici d'accord.

Voilà ça c'est une possibilité.

## Création de fonction de lecture

Maintenant, je vous propose pour terminer la vidéo, on va se faire une petite fonction de lecture alors attention elle ne va pas combler tous les scénarios de lecture possible et il faudra bien sûr aller éventuellement l'améliorer voir pour pour permettre aussi de concevoir de votre côté des fonctions par exemple pour lire simplement des nombres voilà pour vérifier un petit peu les conversions.

Alors on ne parlera pas de conversion, je parlerais simplement de lecture en utilisant notamment fgets() et pour éviter d'avoir ces petits problèmes justement avec les tampons d'entrées

En gros voilà ce que je vous propose, clairement.

Alors la fonction *flush_input_buffer();* qu'est-ce qu'elle va faire ? au lieu de faire ici un fgets(), vous appelerez la fonction en question.

```c
fgets(buffer, BUFFER_SIZE + 1, stdin);
```

Au lieu de ça, on fait la fonction input_read() qui comme la fonction fgets() va retourner un `char *` càd dire quel va retourner ce qu'elle a lu sinon elle retournera nul d'accord càd qu'elle va retourner le *NULL* en majuscule.

Voilà on va appeler ça input_read() d'accord je pense que le nom  est suffisamment explicite et elle va prendre la chaîne en question `char *str` et elle va prendre une taille `int size`.

```c
char *input_read(char *str, int size)
```

Voyez elle prendre en fait les deux éléments là *buffer* et *BUFFER_SIZE + 1* sachant que *stdin* je ne le précise pas puisqu'on va l'indiquer dans la fonction.

On va en fait dans notre fonction ici à nous faire appel  directement à fgets() pourquoi pas.

A partir de là, on va directement déclaré une donné *data* qu'on retournera dans tout les cas.

```c
char *input_read(char *str, int size)
{
    char *data;

    return data;
}
```

Ok très important, c'est un peu comme si on allait récupérer vous allez voir le retour de fgets() qu'on va transmettre à la fonction à la fonction qu'on a fait nous-même et qu'on va en fait déployer directement dans notre fonction à nous ici.

Du coup *data*, dés le départ, on va récupérer le retour de fgets avec deux paramètres de notre fonction, *str* et *size*, et on précise en dur ici en dur *stdin*.

```c
char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    return data;
}
```

On précise en dur *stdin* parce qu'on va toujours travailler, on va considérer qu'ici que cette fonction ira toujours sur l'entrée standard d'accord elle ne sera pas faite pour lire dans un fichier ou autres.

ok à partir de là si data n'est pas nul donc on peut mettre juste *if(data){}*, tester si *data* existe.

```c
char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    if(data)
    {

    }

    return data;
}
```

Si *data* n'existe pas le cas ça va faire directement ça *return data;* c'est à dire que si fgets() retourne *NULL* donc ce que vous aller retourner nul donc ça après ce serra à vous de contrôler son retour aussi.

Si vous voyez quel a retourné *NULL*, vous pourrez mettre un message genre erreur de saisie ou n'importe quoi même quitter le programme bref gérer en fait vous même le cas d'erreur en fait de saisie, ce sera évidemment à prendre en compte.

A partir de là, très important parce qu'on a compilé avec les flags *-Wall -Werror* donc on va être plus rigoureux.

On va récupérer la taille de la chaîne - 1 parce qu'on ne veut pas rappelez-vous le caractère de fin de chaîne d'accord on veut effectivement le nombre de caractères de la chaîne.

**size_t**

Alors je vais stocker dans un `size_t`, il ne semble pas qu'on l'ait beaucoup abordé dans le cours mais c'est simplement que le la fonction strlen() qui retourne le nombre de caractères d'une chaîne retourne un `size_t`.

Si je n'utilise pas ça comme je compile avec les flags *-Wall -Werror*, il ne va pas être content si je mets juste un entier donc on va mettre `size_t` donc ne cherchez pas plus à comprendre comment mais c'est juste ça, c'est un autre type par rapport à ce que prend la fonction.

```c
char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    if(data)
    {
        size_t len = strlen(str) - 1;

        if(str[len] == '\n')
            str[len] = '\0';
        else
        {
            fscanf(stdin, "%*[^\n]");
            fgetc(stdin);
        }
    }

    return data;
}
```

Ensuite strlen() de *str* - 1 d'accord.

Du coup on a récupéré cette taille sans le charactère de fin.

Au final si `if(str[])` donc là on fait un accès directement à l'indice en question pour ma chaîne, à la taille de la chaîne, à l'endroit finale d'accord de ma chaîne est-ce que j'ai le fameux caractère de fin de chaîne *\n*.

`if(str[len] == '\n')`

Voyez je vous avais dis que le fameux fgets() ajoutait un anti-slash n automatiquement, c'est pour ça que tout à l'heure,  on avait le problème là qui était assez casse pieds et ça c'est quelque chose qui peut arriver aussi donc là on va s'occuper en fait de retirer ce retour à la ligne qui se fait automatiquement par la fonction.

Si on tombe du coup sur ce scénario-là `if(str[len] == '\n')` eh bien on remplace ce fameux *\n* par le caractère de fin de chaîne *\0*.

```
if(str[len] == '\n')
    str[len] = '\0';
```

En gros au lieu d'avoir à la fin de notre chaîne un retour à ligne, on va lui dire en fait que le retour à la ligne on l'enlève et on va nous même dire mais en fait non c'est la fin de la chaîne en fait et du coup ça s'arrêtera à cet endroit là et on aura enlevé le retour à la ligne dans notre fonction, en tout cas dans notre chaîne pour être exact.

Sinon donc si on n'a pas besoin de faire ça, on utilise fscanf() pour le coup voyez qu'elle n'est pas forcément inutile parce qu'on va revoir une autre subtilité de la fonction notamment de ce qu'on peut faire avec les identificateurs pour les fonctions de formatage donc là on appelle fsacnf() parce qu'elle est bien pratique pour faire ça.

```
if(str[len] == '\n')
    str[len] = '\0';
else
{
    fscanf(stdin, "%*[^\n]");
    fgetc(stdin);
}
```

On utilise fscanf(), on pourrait utiliser scanf() mais ça change un petit peu.

On travaille sur le flux d'entrée *stdin* pas de problème et là on va utiliser un cas un peu particulier, vous allez voir.

On va mélanger pas mal d'éléments déjà on travail avec un drapeau *%* donc un flag donc on va utiliser le pourcent, pas de problème.

On va lui dire d'ignorer et pour ignorer, on va lui dire d'utiliser le symbole étoiles * voilà tout ce que nous allons lire. Et vous me direz c'est bisare parce qu'on va récupèrer des infos pour s'en débarrasser.

```
fscanf(stdin, "%*[^\n]");
```

Voilà ça n'a rien de compliqué mais ça veut dire que je capture tout ce qui n'est pas un anti-slash n donc tout ce qui est l'inverse, rappelez vous je vous ai dit tout à l'heure que l'accent circonflexe c'est pour dire ce qui n'est pas dans l'expression rationnelle et on ignorera tout ce qui a été lu avec cette fameuse étoile, ça c'est le petit truc bonus en fin de vidéo.

Ainsi tout ça on le récupère depuis la sortie *stdin* donc depuis le tampon d'entrée s'il contient d'autres données ok et ensuite on fait notre nettoyage, fgetc() et tout ça c'est pour le vidage de buffer de *stdin*.

```
fscanf(stdin, "%*[^\n]");
fgetc(stdin);
```

Alors ça en fait cette petite fonction `fgets(str, size, stdin);`, ça revient à faire votre lecture fgets(), supprimer le caractère de fin de chaîne et faire également le vidage du tampon du tampon de lecture (on peut dire tampon d'entré ou de lecture).

Voilà comme ça tout est fait en un seul cas et vous avez une seule fonction d'accords.

```c
#include <stdio.h>
#include <string.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod() ; fflush(stdin)
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/

void flush_input_buffer(void)
{
    int c = 0;

    while(c != '\n' && c != EOF)
        c = getchar();
}

char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    if(data)
    {
        size_t len = strlen(str) - 1;

        if(str[len] == '\n')
            str[len] = '\0';
        else
        {
            fscanf(stdin, "%*[^\n]");
            fgetc(stdin);
        }
    }

    return data;
}

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    input_read(buffer, BUFFER_SIZE + 1);

    printf("%s\n", buffer);

    return 0;
}
```

Voilà on a qu'une seule fonction et on va quand même utiliser pourquoi pas.

Alors vérifier, nous on ne va utiliser le type de retour bien sûr mais vous faites-le, je le rappelle, faites ici un pointeur `char *input_read()` et si elle retourne *NULL* vous arrêtez le programme.

Pour terminer vidéo parce qu'elle était quand même pas mal longue, je ne vais pas le vérifier mais vous dans l'idéal faites-le.

On récrit main avec input_read() la chaîne *buffer* puis la taille avec + 1 dont il faut bien mettre le charactère de fin.

`input_read(buffer, BUFFER_SIZE + 1);`

Et c'est tout, on simplifie complètement l'information.

Je pense que c'est bon, on n'oublie pas `#include <string.h>` pour l'appel à strlen() très important.

On recommence et le compilateur ne se plaint pas.

```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : jason
jason
./prog.exe
Mot en 5 lettres : \n
\n
./prog.exe
Mot en 5 lettres :   eefefzef
  eef
./prog.exe
Mot en 5 lettres : ja caadfz
ja ca
```

Ok là du coup il capture évidemment les éléments en question alors ok pour les espaces pas de problème ils capturent bien cinq caractères quoi qu'il arrive ici pas de problème et alors logiquement si je répète la fonction...

Et on en terminera avec ça comme je avais dit qu'on ferra une vidéo complète.

```c
#include <stdio.h>
#include <string.h>
#define BUFFER_SIZE 5

/*
    LISTE NOIRE     : gets(), atoi(), atol(), atod() ; fflush(stdin)
    LISTE GRISE     : scanf(), fscanf()
    LISTE BLANCHE   : fgets(), strtol(), strtod(), strtul()
*/

void flush_input_buffer(void)
{
    int c = 0;

    while(c != '\n' && c != EOF)
        c = getchar();
}

char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    if(data)
    {
        size_t len = strlen(str) - 1;

        if(str[len] == '\n')
            str[len] = '\0';
        else
        {
            fscanf(stdin, "%*[^\n]");
            fgetc(stdin);
        }
    }

    return data;
}

int main(void)
{
    char buffer[BUFFER_SIZE + 1];

    printf("Mot en 5 lettres : ");
    input_read(buffer, BUFFER_SIZE + 1);
    printf("%s\n", buffer);

    printf("----------\n");
    printf("Mot en 5 lettres : ");
    input_read(buffer, BUFFER_SIZE + 1);
    printf("%s\n", buffer);
    return 0;
}
```
```powershell
gcc -Wall -Werror main.c -o prog
./prog.exe
Mot en 5 lettres : jazdon efzef
jazdo
----------
Mot en 5 lettres : zefizenizef
zefiz
```

Voyez pas de problème tout est saisie, on a bien le nombre de caractères qu'on voulait.

Le tampon de lecture est bien vide à chaque fois.

Voilà donc ça c'est petit cadeau.

Ensuite comme pour le coup, on est sur un langage qui est assez rigoureux, le c.

Si après grâce à cela vous pouvez vous éviter des lectures pas sécurisé c'est quand même pas mal donc éventuellement voilà si vos débuts vous sentez pas assez confiant pour véritablement vous servir de scanf() ou fscanf() pour faire de la simple lecture comme je vous l'ai dit.

Il faut savoir s'en servir sinon c'est mieux d'éviter de s'en servir, c'est pour ça que je l'ai mit en liste grise.

Vous pouvez vous servir de ça et si vous voulez une petite fonction pratique, vous avez ça.

```
char *input_read(char *str, int size)
{
    char *data;

    data = fgets(str, size, stdin);

    if(data)
    {
        size_t len = strlen(str) - 1;

        if(str[len] == '\n')
            str[len] = '\0';
        else
        {
            fscanf(stdin, "%*[^\n]");
            fgetc(stdin);
        }
    }

    return data;
}
```

Encore une fois elle ne va pas gérer tous les cas possibles de lecture.

N'oubliez pas qu'une lecture on peut lire tout un tas de choses des caractères, des nombres, des nombres décimaux, on peut lire voilà plein plein plein d'informations différentes.

Ce serra à vous d'adapter moi je vous donne cette petite fonction de départ, vous mettre la vidéo en pause, la recopier, la mettre dans un coin, la garder dans vos projets, faire vos petits codes perso, etc. pour la réutiliser et voir un peu pour améliorer, pour faire d'autres fonctions par exemple pour convertir une chaîne en entier avec les fameuses strtol() et strtod() pour pouvoir voilà ajouté plein d'autres fonctionnalités mais **garder quand même à l'esprit qu'une fonction ne fait qu'une chose**.

C'est-à-dire que même là, c'est pas forcément idéal parce que là par exemple le vidage du buffer je devrais le faire voilà dans une autre fonction.

```
void flush_input_buffer(void)
{
    int c = 0;

    while(c != '\n' && c != EOF)
        c = getchar();
}
```

Je devrais éventuellement le mettre dans l'autre fonction, l'appeler dans input_read() mais déjà en chipotant ma fonction input_read() fait déjà plus de choses que ce qu'elle devrait parce qu'elle li et en même temps le fait qu'il vide encore le tampon de lecture ça pourrait être fait ensore à part mais c'est histoires que vous ayez une fonction tout en un, qui a tout en un comme ça voilà c'est pratique à utiliser même si vous êtes en train d'apprendre ça vous permet de ne pas trop vous embêter avec la lecture une fois en tout cas que vous aurez étudier tout ça et que vous aurez compris comment ça fonctionne.

Ecoutez j'espère que cette vidéo vous a plu avec du coup 1h30 de vidéo.

On a un petit peu dépassé.

Encore j'aurais pu vous parler pendant des heures et des heures là dessus mais comme c'est un tuto c'est qu'une vidéo donc il ne s'agit pas de faire des tutos en plusieurs parties, ça n'a aucun intérêt.

Du coup vous avez tout ce qu'il faut par rapport à lecture sécurisée.

Encore une fois si on peut faire un petit rappel, les fonctions *gets(), atoi(), atol(), atod()* vous les banissez complètement.

Pour scnaf() et fscanf() càd des fonctions à formatage, vous pouvez vous en servir au tout départ tout en sachant que c'est pas sécurisé pour vous apprendre le langage pour les notions.

Après quand vous arrivez à l'utilisation et de l'apprentissage de fgets() et compagnie privilégiez ces fonctions-là et vous reviendrez par la suite si ça vous intéresse, c'est pas obligatoire mais si vous le voulez sur fonctions comme *scanf()), fscanf(), sscanf(), etc.* si ça vous intéresse et que vous avez cette curiosité justement de comprendre comment elles fonctionnent.

J'espère que ça vous a plu, s'il y a la moindre question parce qu'il beaucoup beaucoup de choses abordé dans cette vidéo et je pense qu'il y aura beaucoup de questions sinon n'hésitez pas entraînez vous très important, faites des programmes, testez plein de choses je ne vous ai pas tout montrer, tous les scénarios.

Essayez de faire planter en fait vos programmes en testant certaines lectures pour voir, pour vous dire bah tiens quand j'ai tapé ça en fait là ça n'a pas fonctionné et après vous dire pourquoi.

Est-ce que cette fonction capture tel élément ? est-ce que quand je saisis tel caractère, est-ce qu'elle le capture aussi ? est-ce qu'elle capture les espaces ou pas ? est-ce qu'elle met des  caractères de fin chaîne ?

Voyez je vous ai donné pas mal d'indications déjà mais on aurait pu en dire beaucoup plus.

Maintenant j'ai fait une partie du boulot c'est à vous de faire le reste et de continuer de vous documenter et surtout d'expérimenter, de tester un peu tout ça de votre côté.

Je vous dis à bientôt en tout cas, je vous laisse avec cette vidéo.

Je souhaite à tous une bonne journée, prenez soin de vous et on se retrouvera du coup pour plein d'autres vidéos sur la chaîne youtube.

Voilà voilà à bientôt tout le monde