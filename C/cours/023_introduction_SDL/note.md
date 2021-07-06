# [23. Introduction SDL](https://www.youtube.com/watch?v=Lwx9rSgwoDg)

Bonjour à tous, je vous souhaite la bienvenue sur cette formation en langage c avec la 23e séance donc ça commence à faire pas mal et nous allons démarrer une toute nouvelle partie d'accord une nouvelle catégorie sur cet ensemble de vidéos que vous avez vu sur le langage c.

On a démarré au début avec les quelques notions du langage, je vous avais dit qu'il y en avait très très peu donc c'était rapide a tout simplement à aborder après ça prendra bien évidemment plus de temps à assimiler.

Ensuite nous avons tout simplement travailler sur quelques structures de données les plus courantes, puis les piles, les file, les arbres et les graphes notamment et nous allons attaquer dans cette troisième partie, on peut dire ça comme ça la création de programmes en 2d donc de programmes tout simplement graphique en 2d.

Il faut distinguer deux choses, vous avez des programmes dits fenêtré donc les programmes en GUI.

Une **GUI** c'est une interface graphique tout simplement qui est composé de widgets donc c'est quoi ? ça peut être tout simplement par exemple mon éditeur ici qui va être composé d'un menu, qui peut être composé de boutons, qui peut être composée de champs de texte, de menus déroulants, de ce genre de choses.

On peut afficher des tableaux, des listes bref toutes ces petites choses là c'est ce qu'on appelle un programme fenêtré.

Nous ici on va apprendre, développer des programmes graphiques donc à manipuler des images, manipuler le son, gérer des périphériques comme la souris, le clavier, une manette de jeu, une webcam, etc. et c'est quelque chose évidemment qui sert dans la création de tout ce qui est programme graphique, manipulation, traitement d'image également dans le jeu vidéo vous vous en doutez.

Si vous voulez faire des jeux vidéo en 2d, vous allez évidemment pouvoir suivre ces vidéos-là dans cette formation et tout ça va je vais vous montrer dans un ensemble de séance que l'on va avoir ici sur cette formation au langage c.

Pour cela nous n'allons pas utiliser les notions native qui composent le langage c d'accord mais on va utiliser pour cela une bibliothèque externe d'accord une  bibliothèque qui n'est donc pas directement incluse avec le langage c mais que nous allons télécharger, configurer et utiliser.

Il s'agit du coût de la fameuse bibliothèque que vous avez peut être entendu parler qui s'appelle la sdl pour **Simple DirectMedia Layer**.

http://libsdl.org/index.php

Cette bibliothèque, elle a plusieurs avantages donc si je dois en citer quelques-uns qui sont évitant :

En premier, le fait qu'elle soit gratuite parce ce serait évidemment bien pratique pour la récupérer facilement sans devoir rien payer.

Elle est open source c'est à dire que le code est accessible d'accord on peut récupérer tout le code source de cette bibliothèque, le modifier, l'adapter si on veut, proposer des mises à jour bref des correctifs tout ça.

C'est également si vous voulez utilisable parce que du fait que voilà ça une bonne licence, sous la **zlib license** qui autorise même l'utilisation de la sdl pour créer par exemple un jeu vidéo que vous voudriez vendre d'accord donc c'est tout à fait utilisable pour un usage commercial ou non sans problème.

Voilà c'est écrit en c mais ça sans surprise d'accord c'est une bibliothèque écrite en c qu'on va utiliser avec le langage c pour pouvoir créer justement des programmes 2d.

Voilà grosso modo donc je ne vais pas vous faire un historique sur les créateurs etc.

Si l'historique vous intéresse parce que c'est quelque chose qui peut être intéressant évidemment, on va dire que la partie théorique là dessus peut être intéressante. Vous pouvez aller voir sur internet où il y a beaucoup beaucoup d'informations puisque c'est une bibliothèque qui est évidemment très populaire, elle fonctionne avec les langages c et vous pouvez également retrouver un équivalent pour le c++, pour le CSharp, pour java, pour python etc. Elle est utilisée partout et surtout dans des gros projets par exemple des jeux commerciaux donc d'ailleurs le site vous propose comme vous voyez quelques exemples souvent dont il suffit d'actualiser la page et il change les exemples donc ce sont des jeux qui sont la plupart du temps disponible sur Stream tel que Dota 2 donc c'est pas des petits jeux, il y a vraiment des très gros jeux qui utilises la sdl donc ce n'est pas une bibliothèque amateur ou quelque chose comme ça qui n'est pas forcément très puissant ou qui n'a pas beaucoup de fonctionnalités.

Au contraire c'est utilisé dans le très gros projets aussi bien dans des petits jeux indépendants tel que Portal que des très très gros jeux commerciaux parce que Portal reste un jeu très connu qui utilise cette bibliothèque externe.

Voilà donc j'ai pris un peu le temps de vous expliquer ça puisque c'est intéressant de savoir, de connaître un petit peu d'où vient cette bibliothèque et  cette bibliothèque surtout qui est multi-plateforme, que vous soyez sur windows évidemment, GNU linux, MacOS vous allez pouvoir l'utiliser mais ça fonctionne également sur IOS, Android et tout cela.

Même sur plusieurs autres supports dont on aura peut-être l'occasion d'ailleurs d'aborder sur la chaîne, sur d'autres supports qu'un pc notamment la programmation sur systèmes embarqués, sur consoles de jeux, etc voilà.

Dans cette vidéo d'introduction, on ne va pas commencer à faire des choses très compliqué et on va télécharger la bibliothèque et la configurer parce que c'est pas forcément évident.

Pour ceux qui sont sur linux et ceux qui sur mac, ça va être rapide à faire très rapide à utiliser.

Pour ceux qui ceux sur windows et je vais commencer par ça, vous allez voir que ça va demander un petit peu de travail supplémentaire pour pouvoir l'installer proprement et surtout de voir comment compiler en ligne de commande puisque c'est évidemment vous savez tout l'intérêt aussi de cette vidéo.

Voilà on ne va pas être dépendant automatiquement d'un éditeur puisque si vous savez compiler la sdl en ligne de commande, vous serez forcément utiliser dans un environnement de développement comme Eclipse, Codeblock, ce que vous voulez. Vous saurez le faire puisque vous aurez apris elle fait en ligne de commande pour comprendre justement les mécanismes, les engrenages en fait de toute cette configuration-là.

Pour cela donc je m'adresse évidemment pour les gens sur windows pour le moment donc on passera plus tard pour les gens qui sont sur une GNU Linux et MacOS, je vous ferais la démonstration en vidéo.

Cette vidéo sera un petit peu longue mais au moins je vais montrer tout voilà il y a vraiment toutes les étapes détaillées pour que vous puissiez avoir quelque chose de fonctionnel à la fin de cette vidéo.

Vous allez du coup sur le site **http://libsdl.org/index.php** pour ceux qui sont sur windows et nous allons récupérer la version la plus récente donc au moment où je fais cette vidéo et c'est conseiller de prendre la version au moins 2.0 d'accor nous aurons l'occasion d'utiliser la version ancienne sur certains autres supports et je pense notamment à la playstation portable de sony, la nintendo DS, tout ça, etc. ça peut être utilisé dans certaines consoles ou certains supports portables mais nous ici comme nous travaillons sur pc, nous allons passer avec la sdl 2.0.

Vous allez dans la section **Development Libraries** d'accord et vous allez récupérer cette archive là, **SDL2-devel-2.0.14-mingw.tar.gz (MinGW 32/64-bit)**.

http://libsdl.org/download-2.0.php

Voyez que c'est la version 2.0.14 mingw et c'est un format .gz d'accord.

Il faut un logiciel d'archive assez spécifiques et si vous utilisez winzip, ou winrar je crois que le format .gz n'est pas pris en charge.

Utilisé plutôt un logiciel comme 7zip qui lui prend en charge tous les formats d'archive donc vous récupérez ce fichier-là.

> SDL2-devel-2.0.14-mingw.tar.gz

On procède à l'installation sur Windows et on prend un code minimal.

```c
#include <stdio.h>

int main(void)
{

    return 0;
}
```

Dans mon dossier, on part de ça par défaut.

On ouvre notre archive *SDL2-devel-2.0.14-mingw.tar.gz* et là normalement on a ce genre de dossier.

+ i686-w64-mingw32 pour le 32 bits.
+ x86_64-w64-mingw32 pour le 64 bits.

Si on est Windows, on utilise l'outil mingw que s'il est en 32 bits, on va évidemment utiliser la sdl pour du 32 bits sinon vous aurez de gros problème à la compilation donc ne vous trompez pas et prenez ce qu'il y a dans le dossier *i686-w64-mingw32* pour le 32 bits.

On va dedans et on voit qu'il y a 3 dossiers et vous allez les mettre ici dans votre dossier de projets que l'on appelle SDL.

    SDL(x86)
    |_ bin
    |_ include
    |_ lib
    |_ src
        |_main.c

    SDL(x64)
    |_ bin
    |_ include
    |_ lib
    |_ src
        |_main.c

Ok donc ça *SDL2-devel-2.0.14-mingw.tar.gz* je peux le garder ou je pourrais même le supprimer si je voulais. Je n'en ai plus besoin mais je vais le laisser ici au cas où si jamais je fait une bêtise dans les vidéos donc pour ne re-télécharger tout.

Là on a trois dossiers (bin, include, lib) d'accord qui vont composer un petit peu toute la SDL et ils ont chacun leur importance.

On a un premier dossier qui est *bin* qui va contenir 2 fichiers.

    bin
    |_ SDL2.dll
    |_ sdl2-config


*sdl2-config* n'est pas intéressant mais servira surtout pour linux et mac os mais j'en parlerai un peu plus tard et nous avons ici un fichier dll ça vous les connaissez au niveau du format qui s'appelle donc *SDL2.dll* qui est ce qu'on appelle une bibliothèque dynamique.

Alors là dit pourquoi on parle de bibliothèques dynamiques ? puisqu'il existe également des bibliothèques statiques.

Les bibliothèques dynamiques, son avantage en tout la fin le fonctionnement qu'elle a c'est qu'elle va accompagner notre programme donc l'exécutable de notre programme et elle est nécessaire pour qu'elle fonctionne.

Vous allez voir tout à l'heure que si je n'ai pas cette bibliothèque dynamique à côté de l'exécutable de mon programme, ça ne fonctionnera pas d'accord elle contient évidemment toutes les fonctions de la sdl pour pouvoir fonctionner donc on parle de bibliothèques dynamiques, elle va être chargée à l'exécution de votre programme et pas avant.

En revanche, à l'inverse, on peut avoir des bibliothèques statiques.

Les bibliothèques statique peuvent être présente au niveau du développement et quand on va compiler en fait et bien les bibliothèques statiques vont être intégrées misent à l'intérieur de l'exécutable.

Par contre ça produira, vous l'avez compris un exécutable un peu plus gros en taille d'accord ce n'est pas un inconvénient mais c'est comme ça.

Une **bibliothèque statique**, elle est directement injectées dans l'exécutable qui du coup sera un peu plus gros en taille une **bibliothèque dynamique** accompagne un exécutable et elle est chargée au niveau de son exécution.

Voilà on a d'ailleurs des bibliothèques qui fonctionne un peu dans les 2 sens càd qu'ils font à la fois statiques et dynamiques donc ça existe, ne soyez pas choqué si un jour vous en utilisez, vous en croisez.

Voilà le dossier *bin* donc c'est la dedans qu'on mettra notre exécutable.

Quand on compilera, on s'arrangera pour que notre fichier *prog.exe* comme on fait habituellement, il se retrouve dans ce dossier bin* comme ça il sera directement à côté de *SDL2.dll* sinon vous verrez que ça marchera pas.

Nous avons ensuite un dossier *include*.

    include
    |_ SDL2


Le dossier *include* par norme, par habitude c'est le dossier qui va contenir les fichiers d'en-têtes donc c'est pas des noms pareils pris au hasard d'accord c'est que tout le monde a pris l'habitude dans un projet de d'appeler les dossiers de cette manière.

Le *include* c'est les fichiers d'en-tête donc on l'appelle comme ceci.

Là où vous allez faire une première modification, c'est qu'on ne veux pas de ce sous-deoosier include/SDL2 mais moi j'en veux pas de ce dossier, vous allez voir pourquoi.

    include
    |_ *.h

Vous allez récupérer tout ce que contient le dossier SDL2, ctrl+A si vous voulez aller plus vite, ctrl+X pour couper et ctrl+V pour coller en dehors du dossier SDL2 qu'on supprime maintenant qu'il est vide.

Voilà je vais vous expliquer plus tard pourquoi j'ai fait ça, vous allez voir que ça tout son intérêt surtout si vous avez besoin de passer votre code d'un os à l'autre, c'est là que ça aura vraiment toute son importance et nous avons enfin un répertoire *lib* qui contient tout simplement les fichiers compilés donc des fichiers objets c'est à dire de la bibliothèque qui sont compilés.

    lib
    |_ lib
        |_*.a
        |_*.la

Alors on l'appelle *lib* par habitude d'accord c'est pareil c'est une convention et nous avons du coup cet ensemble de dossiers alors comme les choses organisés proprement même si je n'ai qu'un seul fichier source *main.c*, on va faire les choses aussi comme ça se ferait normlement dans un projet, on va donc créer un dossier qui par convention, nous appelons **src** pour les fichiers sources et je met le *main.c* à l'intérieur.

    SDL(x86)
    |_ bin
        |_ SDL2.dll
        |_ sdl2-config
    |_ include
        |_ *.h
    |_ lib
        |_*.a
        |_*.la
    |_ src
        |_main.c

    SDL(x64)
    |_ bin
        |_ SDL2.dll
        |_ sdl2-config
    |_ include
        |_ *.h
    |_ lib
        |_*.a
        |_*.la
    |_ src
        |_main.c


Voilà comme ça les choses sont organisées proprement donc si vous voulez par exemple faire un projet bab tout ça vous mettez dans un sous dossier par exemple *MonProjet* et comme ça vous avez tout pour travailler et faire votre développement de votre programme.

Maintenant nous allons passer à l'étape du code, tout est prêt au niveau des fichiers d'accord au niveau de la hiérarchisation des différents dossiers, répertoires, fichiers tout ça.

Voilà tout est bon pour pouvoir commencer à travailler.

Ici on va devoir opérer certains changements, le premier évidemment c'est d'inclure la SDL et voyez que dans *include* càd les fichiers d'en-tête, nous avons plusieurs fichiers notamment celui qui s'appelle *SDL.h* donc le sdl tout court c'est le fichier général qui va utiliser tout le reste donc on va l'inclure au niveau de notre code donc moi je vais le metre en toute première ligne comme ça il sera bien mis en évidence.

```c
#include <SDL.h>
#include <stdio.h>

int main(void)
{

    return 0;
}
```

Donc la voyez on met des chevrons d'accord on ne met pas des doubles quotes puisque on va l'intégrer à la compilation vous allez voir donc vous l'écrivez comme pour <stdio.h>, <stdlib> ou <string.h> etc, ce serra le même fonctionnement donc c'est un fichier d'en-tête que nous allons inclure de cette manière, voilà.

Deuxième étape la sdl utilise, a besoin en tout cas donc vérifie en fait la signature de la fonction principale et a besoin que la signature soit complète c'est-à-dire qu'on ne peut pas ici mettre *void* voire de faire l'erreur et ne pas respecter la norme donc ne rien mettre du tout mais il va falloir mettre les arguments de la fonction main.

Alors si ça ne vous dit rien d'accord si vous ne connaissez pas ce que sont les arguments ou les paramètres de la fonction main, vous pouvez aller voir dans ma playlist c tutoriels.

[Arguments fonction main()](https://github.com/js202005082300/Aide-memoires/blob/main/C/Tutoriels/arguments_fonction.md)

Je propose une vidéo qui est dédié aux arguments de la fonction main comme ça pas vous pourrez apprendre un petit peu leur utilité, leur fonctionnement donc moi je les écris rapidement encore une fois je ne reviens pas dessus puisque je pars du principe que vous les connaissez ou alors vous pouvez les connaître en allant voir la vidéo si vous voulez mettre en pause celle ci le temps d'aller voir le tuto.

```c
#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv)
{

    return 0;
}
```

Voilà donc c'est `int argc, char **argv`.

Voilà le changement et ça si vous ne le faites pas vous aurez des problème à la compilation d'accord donc vraiment il faut garder cette syntaxe-là par définition mais vous avez vus dans les vidéos précédentes, on ne le faisait pas parce qu'on n'en avait pas l'utilité donc ça ne sert à rien de mettre les arguments dans le programme si on ne s'en sert pas mais ici la sdl oblige de l'utiliser.

C'est comme ça que ça fonctionne, c'est obligatoire d'avoir la signature complète donc on va laisser comme ça et voilà maintenant on va écrire du code que je vous ne demande pas de comprendre spécialement parce que vous découvrez tout juste la sdl mais on va noter tout simplement le code.

```
SDL_version
```

Je vais utiliser une structure qui s'appelle *SDL_version* qui est fourni dans la sdl et j'en fait une variable de type *SDL_version* et j'utilise la fonction SDL_VERSION() comme ça tout en majuscules en lui passant par adresse ma variable.

```c
#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    SDL_version nb;
    SDL_VERSION(&nb);

    return 0;
}
```

Et du coup ici je vais pouvoir afficher un petit message parce qu'on ne va pas commencer à créer une fenêtre graphique avec une image ou autre, on va faire quelque chose là exceptionnellement en ligne de commande mais c'est juste pour vérifier qu'on a bien réussi à charger la sdl, que ça fonctionne, qu'on a bien fait l'installation et la configuration proprement.

Alors on va mettre un message de bienvenue, *Bienvenue sur la SDL %d.%d.%d !* et voilà un petit message comme çà et là du coup comme c'est une structure c'est un *nb.major*, *nb.minor* et *nb.patch* si je ne dis pas de bêtises.

```c
#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    SDL_version nb;
    SDL_VERSION(&nb);

    printf("Bienvenue sur la SDL %d.%d.%d !\n", nb.major, nb.minor, nb.patch);

    return 0;
}
```

Là vous pouvez recopier le code bêtement d'accord pas besoin pour le moment de forcément le comprends c'est juste pour nous permettre de vérifier qu'on a bien installer les choses donc tout simplement, on va afficher en fait le numéro de la version qui est installé donc vous avez vu tout à l'heure dans l'archive on avait la 2.0.7 donc si j'ai bien fait les choses ça devrait m'afficher 2.0.7.

Voilà là au niveau du code donc ça c'était les parties les plus simples d'accord honnêtement le fait d'organiser les dossiers, les répertoires tout ça et les fichiers, tout ça c'était vraiment le plus simple.

Maintenant on va passer à la compilation et c'est là que ça se complique puisque nous ne sommes pas dans un environnement de développement divers nous allons directement faire ça en ligne de commandes et je vais noter la commande ici comme ça vous l'aurez sous la main. Vous pourrez en prendre note parce qu'il faut vraiment la connaître et plutôt qu'encore une fois comme par habitude où vous savez très bien que moi je ne vous donne pas les informations comme ça sans les expliquer on va faire la commande étape par étape que vous voyez comment elle est construite et comment elle fonctionne.

Par défaut et comme d'habitude on a le compilateur *gcc*, pas de surprise.

Ici vous voyez que je suis dans un sous dossier c'est à dire que je me place ici.

    SDL.
    |_ bin
    |_ include
    |_ lib
    |_ src

Je me place là d'accord au niveau de mon terminal, je me placerai dans ce répertoire là donc le répertoire SDL et du coup comme je veux accéder à mon fichier main.c puisque j'en ai qu'un seul, je vais faire src slash main.c, `gcc src/main.c`.

Alors si vous aviez plusieurs fichiers, évidemment il faudrait mettre `gcc src/*.c`.

Ensuite on va directement mettre un nom à mon exécutable parce que moi j'aime bien mettre prog comme par habitude et je vous avez dit que je voulais le mettre dans *bin* d'accord je voulais qu'il se retrouve ici donc pareil on va mettre bin slash prog, `gcc src/main.c -o bin/prog`.

Voilà donc là c'est ce qu'on a toujours eu l'habitude de faire d'accord ça c'est pas de souci.

Le problème c'est que là on travaille encore une fois avec une bibliothèque externe donc il va falloir rajouter d'autres petites choses donc d'autres options, de paramètres au niveau de notre commande.

La première même si on a fait une `#include <SDL.h>` qui est important au niveau du compilateur de tout simplement l'inclure d'accord dans toutes les étapes de compilation de vraiment donné l'emplacement des fichiers parce que lui il ne connaît pas l'emplacement on va dire le chemin pour y accéder.

Le chemin voyez c'est juste le répertoire *include* et on a simplifié en plus on a enlevé le sous-répertoire *SDL2* donc on va mettre tiret grand I `-I` donc c'est important. Respecter bien les majuscules parce que si vous mettez des minuscules ça ne fera pas la même chose donc c'est vraiment un tiret grand I et le
répertoire *include* `gcc src/main.c -o bin/prog -I include`.

Ensuite on va faire la même chose pour les bibliothèques donc le dossier *lib* ici sauf que c'est l'argument tiret grand L, `-L lib` donc pour inclure les fichiers objets qui sont déjà compilés, `gcc src/main.c -o bin/prog -I include -L lib` et ensuite on va faire ce qu'on appelle l'**édition de lien**.

Alors pareil si vous ne savez pas ce que c'est l'édition de liens et que pour vous c'est du chinois vous pouvez aller voir la vidéo 3 sur la formation Hacking qui parle des étapes de la compilation et justement on le fait avec le langage c donc si vous voulez voir comment ça fonctionne, qu'est ce que le **pre-processing**, la **compilation**, l'**assembling** et l'**édition de lien** donc ce qu'on appelle le *linking* en anglais, vous pouvez aller voir cette vidéo sur la formation hacking qui vous détaille tout d'accord j'ai vraiment tout détaillé les étapes de la compilation pour expliquer comment ça fonctionne de manière plus technique que on a pu le faire par exemple ici sur la formation en langage c où on est resté honnêtement assez en surface, assez basique, assez sommaire sur les explications donc le linking, il va se passer simplement avec le tiret petit L.

Le linking, il va se passer simplement avec le tiret petit L.

Première chose comme on utilise mingw d'accord donc on rappelez-vous en 32 bits et ben on va noter le comme ceci , `gcc src/main.c -o bin/prog -I include -L lib -lmingw32` donc ça c'est avec un l minuscule d'accord c'est pas un 1 parce que l'écriture est un peu bizarre.

`-lmingw32` voilà.

Pareil petit l mais cette fois ci pour SDL2 donc tout en majuscules, `-lSDL2main` et ensuite tiret petit l pour lSDL2, `-lSDL2`.

```powershell
gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
```

Voilà donc ça en fait on inclut tout simplement l'édition de lien, regardez dans *lib* ceci.

    lib
    |_ libSDL2main.a
    |_ libSDL2.a

*libSDL2main.a* commence par *li* parce que c'est une convention donc ça on n'a pas besoin de le mettre dans le nom et on a le *libSDL2.a* voilà le point .a ou le point .dl éventuellement selon l'os mais ça on s'en fiche.

Vous mettez simplement les noms comme ceci, `-lmingw32 -lSDL2main -lSDL2` et la commande là edt complète donc on va la copier et la coller et si j'ai pas fait d'erreur comme vous le voyez ça compile et il ne reste plus qu'à exécuter donc je fais *bin\prog* ou alors *bin\prog.exe* si on veut afficher l'extension avec la commande et ça nous affiche Bienvenue sur la SDL 2.0..

```powershell
gcc src/main.c -o bin/prog -I include -L lib -lmingw32 -lSDL2main -lSDL2
bin\prog.exe
Bienvenue sur la SDL 2.0.14 !
```

Vous venez d'exécuter, de compiler surtout en ligne de commande votre premier programme sous windows avec la bibliothèque sdl donc c'est très simple, une fois qu on explique bien les choses, qu'on les détails.

Croyez moi pourtant il y a beaucoup de gens qui ont énormément d'expériences en programmation c et qui seraient incapables de compiler une bibliothèque quelle qu'elle soit d'ailleurs pas forcément la SDL mais même une autre en ligne de commande parce que voilà on a pris tellement d'habitude avec les logiciels qui font tout à notre  place et des fois il y en a même qui n'arrive pas même avec les éditeurs pour vous dire que bah du coup on oublie de comprendre tout simplement ce qu'on fait donc là maintenant vous savez comment ça fonctionne donc vous savez ce qu'est un *include*, un fichier d'en-tête, vous savez à quoi correspondent les fichiers du répertoire *lib* et comment s'est passé l'édition de liens.

Tout cela je vous l'ai apris, tout cela je vous l'ai montré en vidéo et c'est évidemment tout l'intérêt.

Le but c'est que vous compreniez tout ce que vous faisait surtout pour les vidéos qui vont venir puisqu'on va rentrer dans des choses un peu plus compliqué.

Pour windows c'est bon d'accord j'ai rien de plus à vous montrer puisque le but ici de cette vidéo c'est d'installer les choses et de voir que ça fonctionne.

## Linux

Nous allons pouvoir passer à Linux donc je suis désolé je ne peux pas tester évidemment sur mac os parce que je n'ai pas de mac sous la main mais ce sera la même chose d'accord au niveau des commandes vous verrez.

Je repasse sur le site https://www.libsdl.org/download-2.0.php et si vous êtes sur MacOS pour installer la SDL cx'est ce fichier-là *SDL2-2.0.14.dmg* dans la partie *Development Libraries*. Vous voyez si vous connaissez votre os, le point .dmg c'est un exécutable d'installation en fait pour installer l'application sdl donc pareil la 2.0.7 au moment où je fait cette vidéo.

Pour linux voyez, il faut vérifier en fait ceux qui maintiennent la distribution donc ça tombe bien, nous allons le faire directement en direct.

On va passer sur la machine virtuelle et je rappelle que c'est un os ubuntu d'accord basé sur une distribution debian que vous ayez debian, ubuntu, linux mint, elementary ou autre, quelque chose en fait qui utilise les paquets aptitudes, apt-get, tout ça ça fonctionnera dessus.

Si bien évidemment vous êtes sûr archi linux, fedora, opensuse ou autre, je pars du principe que vous connaissez un minimum le fonctionnement de votre os et que du coup vous saurez installer la sdl comme des grands en cherchant dans la doc ou en cherchant voilà dans les dépôts officiel de votre distribution.

Là je m'adresse surtout à ceux qui sont sur Ubuntu donc il serait éventuellement débutant sur cet os et qui veulent savoir comment utiliser la sdl sur linux.

Vous allez voir ça va être très rapide.

Honnêtement sur windows, vous avez vu qu'il fallait bien agencer les fichiers tout ça d'ailleurs je vous expliquerai un petit peu après quelques petits détails notamment sur le pourquoi nous avons viré le sous-dossier *include/SDL2* ici.

Pour vous montrer aussi, si j'essaye de modifier le nom de ma dll, l'exécution ne fonctionne plus.

    bin
    |_ SDL2.dll
    |_ prog.exe

```powershell
bin\prog.exe
Bienvenue sur la SDL 2.0.14 !
```

    bin
    |_ _SDL2.dll
    |_ prog.exe

```powershell
bin\prog.exe
```

Voilà il me dit qu'il n'arrive pas à l'exécuter parce qu'il manque la bibliothèque dynamique.

Voilà ça vous montre bien que c'est à l'exécution qu'elle est chargée.

Voilà donc elle est nécessaire, pourquoi ? tout simplement parce que si vous voulez faire tester votre programme à quelqu'un, par exemple lui envoyer, vous aurez juste à lui envoyer ces deux fichiers d'accord, **prog.exe** et **SDL2.dll** dans une archive et il pourra le lancer et l'avantage du fait qu'il a la bibliothèque dynamique de la SDL il n'aurait évidemment pas besoin d'installer la sdl de son côté alors si c'était du statique il aurait fallu qui compile lui-même avec les fichiers statique de la sdl.

Voilà l'intérêt des bibliothèques dynamiques, c'est qu'on l'embarque comme ça avec les exécutables et du coup n'importe va pouvoir tester votre programme sans avoir la sdl sur son pc puisqu'elle est déjà présente ici tout simplement.

Voilà ça c'est ce que je voulais vous montrer sur windows, normalement sur windows j'ai tout dit.

Je vous explique aussi pourquoi on avait ici viré le sous-dossier *include/SDL2* ça c'est important et bien évidemment l'utilisation de ce fichier-là *sdl2-config* parce que j'ai dit que pour Windows il n'était pas utile mais il allait servir pour linux et du coup pour MacOS.

Pourquoi je dis MacOS ? parce que c'est un système unix d'accord le terminal utilise de l'unix, c'est un système de la famille des Unix donc à priori les commandes devraient fonctionner pareil que ce soit sur gnu linux ou MacOS.

Je vais vous expliquer tout de suite maintenant pourquoi j'ai viré ce sous-dossier *include/SDL2* d'accord tout simplement parce que vous allez voir que sur linux pour l'installation de la SDL ça va être très rapide notamment ici sur une distribution qui est basée sur debian donc une ubuntu ici.

Je vais passer par le terminal parce que c'est plus rapide à installer la SDL et vous pouvez passer par un gestionnaire de paquets si vous voulez. Pour trouver le nom du paquet vous faites comme vous voulez mais je vous recommande de le faire dans le terminal parce que c'est le plus rapide alors pas besoin de passer par une application graphique.

Alors la commande en sudo puisqu'il faut le faire maintenant en tant que root, on va utiliser le gestionnaire paquet apt-get, la commande install et il s'appelle tout simplement **libsdl2-dev**.

```bash
sudo apt-get install libsdl2-dev
```

Je tape la commande donc là il charge les paquets et il me dit que la version installée est la *2.0.12* alors que sur Windows on a la *2.0.14* donc elle est un petit peu antérieur mais pas de souci c'est au moins la version 2.0 donc pas de problème.

Voilà donc c'est juste ça `sudo apt-get install libsdl2-dev` pour installer il n'y a pas besoin de modifier les dossiers ou des répertoires.

Là vous avez installé la sdl en une simple commande tout simplement dans un terminal, terminé donc c'est très rapide.

Alors évidemment sur Mac je rappel vous devez installer ce fichier, *SDL2-2.0.14.dmg*.

Maintenant nous allons créer notre fichier main.c

```bash
sam@sam:~/Bureau$ cd Bureau/
sam@sam:~/Bureau$ nano main.c
sam@sam:~/Bureau$ cat main.c
#include <SDL.h>
#include <stdio.h>

int main(int argc, char **argv)
{
        SDL_version nb;
        SDL_VERSION(&nb);

        printf("SDL %d.%d.%d !\n", nb.major, nb.minor, nb.patch);
        return 0;
}

```
Voilà on ne change absolument rien *SDL.h* sans sous dossier, *stdio.h* pour l'affichage printf(), etc.

Voilà ça a été rapide, on quitte *ctrl+S* et *ctrl+C*.

Donc on a bien le contenu du fichier source, pas de problème.

Alors au niveau de l'insclusion, pourquoi ai-je virer ce sous-dossier ?

Alors vous avez vu que je mettais simplement le `#include <SDL.h>` mais si j'avais laissé ce sous-dossier déjà il aurait fallu que au niveau de windows donc je reviens sur mon code windows et que je mette ce qu'on avait tout à l'heure c'est à dire `#include <SDL2/SDL.h>` mais le problème c'est que sur linux, il veut l'inclusion directement comme ceci *SDL2.h* et MacOS à priori ça devrait être pareil donc il aurait fallu qu'en passant votre code de windows à linux que vous enleviez à chaque fois ça *SDL2/* d'accord car le chemin et que vous le remettiez quand vous repasser sur Windows.

En bref il faudrait éditer le code source à chaque fois que vous changer d'os au niveau de votre code.

Là l'avantage c'est qu'en mettant *SDL.h* partout, **le code est portable** et moi je vous invite évidemment à faire ça, de ne pas avoir à modifier le code d'un
système à l'autre.

Là si je voulais j'aurais pu faire un bête copier-coller d'ailleurs, je ne l'ai pas fait parce que je voulais retaper le code pour montrer mais j'aurais pu faire un copier-coller du code.

Alors sur linux de toute façon vous voyez que c'est exactement le même à part ce que j'affiche dans le printf() mais ça on s'en fiche, ça va fonctionner de la même manière.

On va passer à la compilation et là la commande de compilation encore une fois, venez me le confirmer à ceux qui sont utilisateurs de MacOS logiquement elle devrait fonctionner pareil puisque si je ne dis pas de bêtises, le fichier dont on va se servir, le fameux *sdl2-config* (dans bin/) normalement doit être disponible également pour MacOS puisque c'est un système de la famille Unix donc il devrait fonctionner et là vous allez voir la commande elle est très pratique.

Je rappelle en faisant un petit listing que j'ai simplement mon fichier source.

```bash
sam@sam:~/Bureau$ ls
in.sh  main.c
```

Vous voyez là j'ai pas fait de dossier *src* ou autres.

Il n'y a pas le dossier *lib* puisque tout a été installé au niveau système donc pas de soucis au niveau de la sdl.

On va juste faire donc la commande habituel donc `gcc main.c -o prog` et ici on ne va pas commencer à mettre des includes, etc, des tiret grand I, tiret grand L mais on va utiliser une variable directement dans le shell `$()` et on va utiliser notre fameux fichiers *SDL2-config* avec deux arguments *--cflags* et *--libs*.

```bash
gcc main.c -o prog $(sdl2-config --cflags --libs)
```

2 arguments et donc qu'est-ce que ça fait cette commande-là et bien dans ce fichier de configuration identique que se soit sur Windows ou sur Linux, contient:

```bash
#!/bin/sh

prefix=/opt/local/x86_64-w64-mingw32
exec_prefix=${prefix}
exec_prefix_set=no
libdir=${exec_prefix}/lib

#usage="\
#Usage: $0 [--prefix[=DIR]] [--exec-prefix[=DIR]] [--version] [--cflags] [--libs]"
usage="\
Usage: $0 [--prefix[=DIR]] [--exec-prefix[=DIR]] [--version] [--cflags] [--libs] [--static-libs]"

if test $# -eq 0; then
      echo "${usage}" 1>&2
      exit 1
fi

while test $# -gt 0; do
  case "$1" in
  -*=*) optarg=`echo "$1" | sed 's/[-_a-zA-Z0-9]*=//'` ;;
  *) optarg= ;;
  esac

  case $1 in
    --prefix=*)
      prefix=$optarg
      if test $exec_prefix_set = no ; then
        exec_prefix=$optarg
      fi
      ;;
    --prefix)
      echo $prefix
      ;;
    --exec-prefix=*)
      exec_prefix=$optarg
      exec_prefix_set=yes
      ;;
    --exec-prefix)
      echo $exec_prefix
      ;;
    --version)
      echo 2.0.14
      ;;
    --cflags)
      echo -I${prefix}/include/SDL2  -Dmain=SDL_main
      ;;
    --libs)
      echo -L${exec_prefix}/lib  -lmingw32 -lSDL2main -lSDL2 -mwindows
      ;;
    --static-libs)
#    --libs|--static-libs)
      echo -L${exec_prefix}/lib -lmingw32 -lSDL2main -lSDL2 -mwindows  -Wl,--no-undefined -Wl,--dynamicbase -Wl,--nxcompat -Wl,--high-entropy-va -lm -ldinput8 -ldxguid -ldxerr8 -luser32 -lgdi32 -lwinmm -limm32 -lole32 -loleaut32 -lshell32 -lsetupapi -lversion -luuid -static-libgcc
      ;;
    *)
      echo "${usage}" 1>&2
      exit 1
      ;;
  esac
  shift
done
```

Voilà c'est tout simplement un fichier de configuration comme vous voyez qui est un peu plus long mais qui va en fait faire les inclusions automatiquement voyez ceci.

```bash
  case $1 in
#etc.
    --cflags)
      echo -I${prefix}/include/SDL2  -Dmain=SDL_main
      ;;
    --libs)
      echo -L${exec_prefix}/lib  -lmingw32 -lSDL2main -lSDL2 -mwindows
#etc.
```

Il est capable de voir en fonction comment il fait des inclusions voyez *cflags*, etc.

Voilà il inclut tout ce qu'il faut donc il va faire les inclusions à votre place en fait voyez toutes les commandes sont déjà disponibles partout il verra en fonction de Linux quel chemin il renseigne pour pouvoir conpiler donc vous n'avez pas du coup besoin de vous embêter avec ça et comme on lui passe les bons arguments d'accord vous voyez c'est un petit code en Bash et bien on va pouvoir tout simplement compiler la sdl très rapidement donc juste avec cette commande-là d'accord donc c'est un dollar et entre parenthèses vous mettez tout ça `$(sdl2-config --cflags --libs)` d'accord.

```bash
gcc main.c -o prog $(sdl2-config --cflags --libs)
```

Ici du coup on teste et s'il a bien compilé, il a bien produit un exécutable *prog*.

Pour l'exécuter point slash prog *./prog* et voilà.

```bash
sam@sam:~/Bureau$ gcc main.c -o prog $(sdl2-config --cflags --libs)
sam@sam:~/Bureau$ ./prog
SDL 2.0.12 !
```

Nous avons tout simplement installer donc c'est très rapide forcément et compilé un programme en SDL sur linux et logiquement je vous dis si c'est bon au niveau unix normalement en faisant la même commande ça devrait fonctionner si vous êtes sur MacOS et si ça ne fonctionne pas bien écouté on regardera ça dans tous les cas, voir un petit peu voilà qu'est ce qui change ? logiquement le sdl2-config est disponible sur MacOS et donc il n'y a pas de raison que ça ne fonctionne pas.

Voilà pour cette vidéo d'intro, je pense avoir fait le tour du tout ce que je voulais vous montrer en tout cas je voulais que vous soyez capable d'installer l'outil en fonction de votre OS d'acord.

On ne va pas montrer comment l'installer sur android ou autre, on ne peut pas non plus tout faire.

De toute façon vous apprenez à développer en langage c sur pc donc c'est le but et le thème de cette formation donc maintenant selon l'OS vous allez pouvoir installer ça et l'utiliser.

On voulait voir le téléchargement, l'installation et la configuration.

Je vous ai parlé un petit peu des bibliothèque dynamique statique parce que c'était quand même intéressant à savoir.

Je suis revenu un peu sur l'édition lien puisque c'est pareil ça fait toujours du bien de faire quelques petits rappels et puis voilà on a fait tour.

Vous êtes prêt normalement là pour la suite en fait de cette formation vous allez pouvoir commencer à utiliser cette bibliothèque là.

Voilà donc je vous laisse avec ça j'espère que cette introduction aura été suffisamment claire.

La vidéo j'ai bien conscience qu'elle est un petit peu longue mais en même temps c'était carrément utile puisqu'il y a beaucoup de choses et beaucoup de personnes surtout qui voulaient utiliser cette bibliothèque et surtout compiler en ligne de commande, vous a été pas mal à me le demander donc là vous voyez que ça se fait simplement.

Pour windows petit rappel respecter bien l'ordre d'accord notamment l'édition des liens `-lmingw32 -lSDL2main -lSDL2`, ces trois arguments là ils doivent se mettre à la fin tout simplement puisque si vous avez vu ma vidéo sur la formation hacking sur les étapes de compilation vous savez que l'**édition des liens c'est la dernière étape** d'accord donc si vous mettez l'édition des liens genre ici d'accord.

Pas ok:
```powershell
gcc src/main.c -o {-lmingw32 -lSDL2main -lSDL2} bin/prog -I include -L lib
```

Juste ici, il y aura un problème vous allez avoir des messages il va vous dire par exemple qu'il ne connaît pas ces fonctions (SDL_VERSION(), etc.) genre les fonctions de la SDL ne pas sont pas trouvé donc l'édition de liens appartient bien à la fin.

Autant `-I include -L lib` vous pouvez très bien le mettre ici ou ici avant le tiret o d'accord.

Ok:
```powershell
gcc {-I include -L lib} src/main.c -o bin/prog -lmingw32 -lSDL2main -lSDL2
```
Vous pouvez mettre `-I include -L lib` là ou même avant le tiret o bin slash prog.

Ok:
```powershell
gcc src/main.c {-I include -L lib} -o bin/prog -lmingw32 -lSDL2main -lSDL2
```
Ici ça ne posera pas de problème c'est vous qui voyez par contre l'édition des liens mettez-là bien à la fin et dans cet ordre-là.

    1.) -lmingw32
    2.) -lSDL2main
    3.) -lSDL2

`-lmingw32` en 1er, `-lSDL2main` en 2e et `-lSDL2` en 3e tout simplement parce qu'il y a une édition de liens qui a besoin d'un autre fichier qui lui-même a besoin d'un autre donc si vous ne les faites pas dans l'ordre évidemment il va chercher un fichier qu'il n'arrive pas à trouver donc il manquera des inclusions et de toute façon ça ne compilera pas.

Je vais m'arrêter là pour cette introduction j'ai fait le tour de tout encore une fois.

J'espère que ça vous a plu j'espère que ça vous a permis vraiment de voir comment installer tout ça proprement vous verrez qu'encore une fois c'est très facile et dans la prochaine séance nous allons créer notre premier programme donc une première fenêtre d'accord avec une vraie interface graphique en 2d et bien évidemment dans toutes les séances qui suivront vous allez apprendre à afficher des images, manipuler des sprites ce genre de choses et pourquoi pas un jour voir des bases qui vous serviront par exemple à concevoir un jeu vidéo 2d ou des programmes de manipulations graphiques, manipulation d'image bref vous aurez de toute façon beaucoup de matière et beaucoup de d'idées après et d'envie surtout de développer des programmes comme ça un peu plus élaborés que des simples programme en ligne de commandes même s'ils ont leur utilités bien évidemment mais cet autre chose.

Je vous dis à bientôt pour la prochaine séance, pour la vidéo numéro 24 et je vous dis à bientôt n'hésitez pas à laisser des commentaires, des like et cetera, partagez et je pense que ça servira beaucoup de monde.

S'il y a des choses qui ne sont pas claires vous avez des questions posées-les dans les commentaires, n'hésitez pas franchement j'y répondrai pour que tout le monde en fait à partir de la séance 24 ait la SDL qui fonctionne sur l'os qu'il utilise habituellement ... faut que ça fonctionne partout et que tout le monde soit au même point pour ne pas être largué et que vous puissiez simplement compiler parce que sinon vous aurez des petits soucis.

Voilà voilà à bientôt tout le monde pour la prochaine vidéo ciao