# [1. Introduction](https://www.youtube.com/watch?v=90hGCMC3Chc)
> Transcription le 11-01-2020

>

![Ken Thompson and Dennis Ritchie](KenThompson_DennisRitchie.jpg)
 
* **Standard ouvert** dont les bugs ont eu le temps d’être corrigé. Créé dans les années 70’s sur base du travail de Ken Thompson and Dennis Ritchie, personnes qui ont fait évoluer les languages (B..) jusqu’au language C.

* **Language de programmation impérative**, càd qu’il fonctionne suivant une suite d’instructions jusqu’à sa fin, un ensemble de commandes à suivre de manière séquentielle.

* **Language compilé**, càd qu’un code source est écrit dans des fichiers et ensuite compilé par un compilateur. La syntaxe utilisée est convertie en binaire, language de la machine qui ne connait que des zéros et des un.

* **Language de haut niveau** car il a une syntaxe simplifiée par rapport à des languages d’assembleur (Mips).

* **Language de bas niveau** car on va directement travailler sur la mémoire, càd faire des allocations de mémoire dans l’ordinateur pour y stocker des informations. Il faut tenir compte de la capacité de mémoire et de la libération de celle-ci après utilisation. Par rapport à d’autres languages (Java, CShap...) qui utilise un système de libération de mémoire, un “Garbage Collector” (un ramasse miettes).

* **Language normalisé** car on veut que le language reste le même au niveau de sa syntaxe, de la méthode de programmation et de ses normes (norme C89, C11, ...).

* **Language peu portable** car la version binaire de notre programme ne fonctionnera que sur le système sur lequel on a compilé, il n’est pas multiplateforme.

* **Language avec peu de concept** mais dont la syntaxe reste compliquée et peu amenée à beaucoup d’erreurs (mémoire mal alloué, trop peu de caractères alloués pour une chaîne de charactères).

* **Language de référence** dans les systèmes embarqués, dans les systèmes d’exploitation, sur les serveurs, dans les jeux vidéo, dans des bibliothèques partagées sous forme de packages qui peut être proposé à d’autres développeurs comme des outils. Exemple : Le noyau de chez Linux (The Linux Kernel Archives) est fait en C. La SDL, est code qui permet de manipuler des images, de gérer du son, gérer des manettes, etc.

>

## Introduction

Nous allons voir les avantages qu'il peut avoir et surtout l'utilité de l'apprendre.
	
Le langage C a évolué. A la base, il ne s'appelait pas comme cela, il y a eu le langage B et plein d'autres langages avant qui ammené au langage C par deux personnes, Ken Thompson and Dennis Ritchie, avec Ken Thompson qui était l'inventaire du langage B qui a été repris pour pouvoir former le langage C que nous connaisssont.
	
Ces deux personnes ont fait évolué les différents langages pour les ammener à ce que nous connaissons aujourd'hui et qui évolue encore maintenant car ce sont des langages, même s'ils ont été fondé dans les années 70's, continue de progresser et on voit l'ajout de nouvelles fonctionnalités.
	
Concernant le langage C, c'est un langage dit de programmation impérative c'est à dire que le langage fonctionne via une suite d'instructions.
	
Dans la séance suivante, nous veront un exemple de code. On parlera d'instruction qui sont un ensemble de commandes qui sont à suivre au fur et à mesure, de manière séquentiel et le programme les réalisent et voilà. Ils réalisent chacunes des tâches et il traite comme ça tout le fichier et tout l'ensemble du programme jusqu'à sa fin. Ca c'est dit impératif, c'est ce que l'on retrouve dans beaucoup de langage de programmation. C'est une méthode de programmation qui est quand même relativement populaire.
	
## Compilation
	
Il faut savoir que le langage C est un langage compilé, c'est à dire que nous allons avoir un code source, que nous allons taper le code de notre programme dans des fichiers. Nous allons ensuite utiliser un outil que l'on appele un compilateur qu'on ne détaillera pas, ce n'est pas le sujet de ce genre de formation.
	
>	Pour en savoir plus sur toutes les méthodes de compilation, il faut regarder la formation sur le hacking dans lequel on voit plus en détails les étapes de compilation avec le langage C parce que c'est un langage que l'on peut retrouver dans cette formation.
	
C'est un langage compilé c'est à dire que la machine ne comprend que le langage binaire qui est constitué de 0 et 1 par rapport à son fonctionnement d'origine et le langage que nous allons utiliser pour programmer n'est pas que composé de 0 et de 1. Autrement ce serrait parfaitement illisible et compliqué. On a donc une certaine syntaxe qui a été créé et à partir de là, nous avons le compilateur qui va traduire notre syntaxe à nous en langage machine donc en binaire pour pouvoir être lu et éxécuté par un ordinateur qui lui ne connait que des 0 et des 1. 
	
Ca c'est pour la partie compilation.

## Haut et bas niveau
	
C'est aussi un langage qu'on qualifie de haut ou bas niveau. C'est quelque chose de très subjectif et relatif, c'est-à-dire que l'on peut avoir un langage qqui est au niveau par rapport à un autre mais qui est bas niveau par rapport à autre chose. Ce n'est pas forcément très fiable comme information mais en tout cas, on peut qualifier quand même le langage C de haut niveau du fait qu'il a une syntaxe qui est simplifiée par rapport à d'autres langages comme les langages d'assembleurs par contre, il est plutôt qualifié de bas niveau dans la mesure où nous allons directement travailler sur la mémoire c'est-à-dire que l'on va gérer la mémoire. On va faire de l'allocation de la mémoire c'est-à-dire de réserver un espace dans la mémoire de l'ordinateur pour pouvoir stocker des informations.

Donc il faut prévoir la place alors que sur certains langages dit de plus haut niveau que le langage C, on aurait pas forcément besoin de ça. On stocker les données et c'est le programme après qui se charge de les allouer directement et surtout de toutes les libérer parceque si on ne libère pas les données à la fin du programme, elle reste dans la mémoire et c'est comme ça qu'on finis par satturer la mémoire. 
	
Ca c'est à retenir quand même. Le langage C est un langage compilé. Un langage dit de haut niveau si on compare par rapport aux langages proches du langage machine mais ce sont quand même des langages relativement bas niveau si on compare au langage Java, au langage CSharp, langage un peu plus récent qui dispose de système de libération de mémoire, ce qu'on appele un "carbage collector", un ramasse miette, que le langage C n'as pas. 
	
C'est relatif, cette histoire de haut et bas niveau. Il n'y a pas une des deux réponse qui est fausse, qui est plus fausse que l'autre en réalité. C'est selon là où l'on se place, selon le point de vue. Il est bas niveau par rapport au CSharp, au Java mais il est haut niveau par rapport au langage d'assembleur par exemple.
	
Ca c'est pour la petite présentation rapide du langage.
	
## Avantage du langage C
	
Du coup, la question à se poser, c'est pourquoi prendre le C ? Quel avantage il peut avoir et qu'est-ce qu'il peut apporter ?
	
Il a été créé dans les années 70's. Le gros avantage de ça, c'est qu'il y a des dizaines d'années qu'ils sont passé, le langage a vécu. Il a eu le temps de souffrir de nombreux bugs, de nombreux problèmes, de nombreuses corrections pour être amélioré, à qui ont a apporté de nouvelles fonctionnalités, du contenus. C'est quand même un très bon point.
	
On a aussi le fait que le langage est ouvert, c'est-à-dire qu'en réalité le langage C n'appartient à personne même s'il a été créé par des gens, il n'ont pas décidé d'en avoir la propriété. Ce n'est pas un langage propriétaire. On peut le réutiliser sans problème et ainsi on peut vendre un produit qui a été programmer dans le langage C, sans soucis. On aura pas de compte à rendre aux auteurs qui ont créé ce langage. Ainsi on parle de standard ouvert.
	
Pourquoi parle t on de standard ? parce que le langage au début, on commence sur un peu tout et n'importe quoi et après on essaye de hiéarchiser les choses, de les organiser mais aussi d'avoir quelque chose qui soit clair pour que le langage soit un peu le même partout, pour que le langage C reste le même au niveau de sa syntaxe, de ces méthodes, au niveau de ces règles. On a créé des normes, on a normaliser le langage.
	
On entend parler des normes C89, C99, C11 ou les normes ANSI. Ce genre de chose sont simplement une feuille de route, une feuille de règles qui reste assez imbuvable pour ceux qui n'ont pas l'habitude même pour ceux qui ont l'habitude.
	
Feuille où il y a tout un ensemble de règles à suivre concernant un langage. Des règles de codage, ça peut être sur la syntaxe, ça peut être sur des méthodes de programmation, de savoir-faire, etc.
	
Ils ont utilisé ce terme là pour C89 parcequ'elle a été initié en 1989. Et C99 en 1999. Et la plus récente, c'est la norme C11 qui a été validé en 2011. Pour un langage qui date de 1970. En 2011, il a encore été mis à jour. Ils ont continué a ajouté du contenu, des fonctionnalités. Ce n'est vraiment pas obsolette et il faut comprendre que tous les langages aussi vieux qu'ils soient, peuvent encore avoir un intérêt encore maintenant même des langage moins populaire que le langage C parcequ'il a vraiment l'avantage de s'être populariser et d'être devenu une référence en informatique. Ca c'est un gros point. 
	
## Inconvénient du langage C
	
Si on devait citer quelques points moins bien. On pourrait parler de sa portabilité contrairement à d'autres langages comme le Python.
	
Pour ceux qui n'aurait aucunes connaissances en informatique, il y a des langages qui vont nous programmer notre application, notre jeu et si par exemple on le lance sur Windows, ça fonctionnera. Idem si on le déplace sur MacOS et qu'on l'exécute ça fonctionnera. Idem si on le déplace sur une distribution GNU Linux, il fonctionnera aussi.
	
L'avantage dans ce cas, c'est que c'est portable. On récupère le programme, on le lance et c'est terminé.
	
Mais le C ne permet pas de faire ça. Le code est effectivement le même sauf exception e bibliothèque très particulière.

Le code gràce au standard est le même que le soit sur Windows ou GNU Linux lorsqu'on veut afficher quelque chose à l'écran. On fera pareil peut importe le système, ça c'est à retenir.
	
Mais on pourrait se demander si la syntaxe est la même selon notre OS, idem pour afficher du texte, la syntaxe est la même pour stocker des informations peu importe que l'on soit sur Windows ou Linux...
	
Du coup, il manque quand même cette portabilité qui fait que quand on va compiler, quand le compilateur va faire la version binaire du programme. Cette version binaire fonctionnera que sur le système que l'on a compilé. Ce qui ne s'agit pas de méthodes dites de la "cross-compilation" qui permettent de compiler pour un autre support.
	
Si on compile notre programme sur un système Windows, il fonctionnera que sur Windows et si on compile sur MacOS, il fonctionnera que sur un système Mac, etc. On obtient un exécutable en fonction de l'OS sur lequel on compile.
	
Du coup si on veut avoir un programme portable, il faudrait au minimum le compiler sur Windows, sur MacOS, sur GNU Linux pour avoir la compatilité avec ces 3 système, ce qu'on appelerait un programme ou un jeu multi-plateforme.
	
Un autre point qui peut être assez dérangeant pour par exemple les développeurs de Pascal ou les développeur de Python, plus récent et qui est évidemment plus haut niveau, on remarque que la syntaxe du langage C et son apprentissage est à la fois facile parce qu'il y a très peu de concept, de choses à savoir au niveau de la base du langage. En même pas une vingtaine de vidéos, on aura fait le tour de tous les concepts du langage. Ca va quand même très vite, ça ne fait pas beaucoup.
	
Après on peut les mettre en application pour faire des choses bien plus complexes mais des concepts, il y en a très peu. 
	
En revanche, la syntaxe du langage en lui-même, sa compréhension peut paraître une peu compliqué. Cette complication dans la syntaxe, dans la manière de programmer peut ammener à beaucoup d'erreurs. Il est récurent de faire des bugs parcequ'on a mal alloué la mémoire, parce qu'au niveau des chaînes de caractères on ne gère pas corectement ce qui est coté mémoire. Ainsi l'erreur est vite faite avec le langage C alors que sur d'autres langages plus haut niveau ou plus simple dans leur syntaxe, il y en aurait beaucoup moins donc attention si on se lance la-dedans, il faudra être un minimum rigoureux bien évidement sur certaines choses qui ne sont pas possible. De fois le moindre petit caractère différent pourra causer un bug sur un programme. On comprend maintenant pourquoi des systèmes fait par des professionnels comme notre système d'exploitation que ce soit Windows, GNU Linux, MacOS ou les logiciels qu'on utilise tous les jours comme notre navigateur, notre anti-virus, notre logiciel de traitement de texte souffre de dizaine, voir de milliers de bugs parceque la moindre petite erreur ne pardonne pas. On prend l'exemple du langage C mais on peut retrouver cela dans d'autres langages similaires. C'est vraiment difficile de produire, voir même impossible de produire un programme parfait qui ne dispose pas de bugs et qui n'aura aucune erreur et qui soit fonctionnel partout parce qu'après, il y a aussi le matériel. Il faut que ca prenne en compte tout ce qui est fait dans le programme. Il faut que le système le supporte, etc.
	
Il y a énomément de facteurs qui peuvent faire que le programme ne fonctionne pas bien chez nous mais qui pouraient fonctionner chez un autre à cause d'un petit bug qui casse complètement son fonctionnement. 
	
Ce point est à prendre en compte et éventuellement un inconvénient du langage C est qu'il rend plus facile le fait de faire faire les erreurs. On a plus tendances à faire des erreurs dans ce langage là que dans un autre.
	
## Pourquoi choisir le C
	
Revenons finallement sur un autre point du début, c'est pourquoi apprendre le C ? Qu'est-ce qu'il peut aporter ?

C'est un langage qui date, qui a pas mal d'années derrière lui et qui est donc devenu très populaire.
	
Il y a beaucoup de ressources, de contenus sur internet, donc éventuellement beaucoup d'aide si on était bloqué sur quelque chose en particulier.
	
Il est forcément inclus dans tous les appareils éléctroniques que l'on trouve en général quand un constructeur sort un appareil en général, il s'arrange pour que l'on puisse programmer, que le langage C soit compatible dessus.
	
A l'heure actuel (2016 pour la vidéo), on le retrouve dans les systèmes embarqués comme un drone, un robot, dans le domaine de la domotique, dans les frigo, les télés qui sont un peu intélligent, qui fonctionne avec des programmes.
	
La plupart du temps, c'est petit système sont programmés en langage C. Il est vraiment un standard qui est devenu une référence un peu partout. On est vraiment entouré de programme, de système qui fonctionne via ce langage.
	
C'est dommage d'avoir fait de la programmation et de n'avoir jamais fait de C. C'est dommage de passer à coté de ça car ça parait utile.
	
On l'utilise dans les systèmes embarqués mais on l'utilise en programmation système, sur des systèmes d'exploitation, sur des serveur, etc. On peut le retrouvé dans les jeux vidéo, il n'y a pas que les langages que l'on peut entendre parlé pour ça comme le C++ ou le CSharp. On a des applications en temps réel car le langage C a très peu de concepts donc il se met très rapidement en place, ce qui fait qu'il y a beaucoup d'application en temps réel qui utilise ce langage.
	
On a des bibliothèque également qui permettent de faciliter le travail des développeurs. On y retrouve des fonctionnalités toutes faites. Un développeur peut les réutiliser à son tour dans son propre programme. 
	
Ce que l'on pourra programmer pourra être fait sous forme de package et proposé aux autres qui peuvent s'en servir comme un outil. C'est un peu infini car à partir de rien, on peut avoir quelque chose qui peut être utilisé par quelqu'un d'autre qui conduira à autre chose et ainsi de suite. Une réaction en chaîne et on arrive comme ça à créer des communautés de développeurs qui peuevent se partager tout leur savoir faire.
	
Ainsi c'est une branche très intéressante et qui donne envie de se lancer en C.
	
Pour terminer cette vidéo, nous prenons quelques gros exemples de projets qui sont fait en majorité avec le langage C :
	
On peut aborder le Kernel du noyau Linux
	
	www.kernel.org
		
Le noyau de ce système d'exploitation est prncipalement fait C en grosse partie mais pas seulement.
	
Pour ceux qui connaissent, il y a une grande fiabilité dans ce noyau. Ce n'est pas quelque chose qui est devenu obselète. Plus les années passent et plus les gens s'intéressent à des systèmes alternatifs. Avant on vivait beaucoup dans le monde de Windows. Mac s'est imposé aussi très rapidement mais aujoud'hui il y a de plus en plus de gens qui s'intéressent aux solutions OpenSource, aux solutions alternatives (pas équivalent).
	
Voir également la formation GNU Linux sur la chaîne.
	
En second, puisqu'on parlait de bibliothèque, il y a la SDL qui est une bibliohèque que nous utiliseront. Nous n'avons pas créer ce code mais nous l'utiliseront. Ce code permet de manipuler des images qu'on utilise notamment pour faire des jeux vidéo en 2D ou pour gérer du son. On peut gérer des manettes, le clavier ou la souris. Bref on peut faire pas mal de petite choses.
	
Nous apprendrons à utiliser cette bibiliothèque au cours de cette formation. On pourra faire de petit jeux vidéos, des petites manipulation d'images, etc.
	
Voilà pour les deux gros projets, il y en a pleins d'autres mais nous ne ferons pas une listing exhaustif dessus.
	
Ce sont deux projets qui sont bien parlant, qui sont tout à fait d'actualité, qui sont utilisé tous les jours et bien encore maintenant et qui seront encore utilisé dans 20 temps.
	
Pour la prochaine séance nous apprendrons à compiler un premier programme. Nous veront quoi faire pour installer les bons outils, les bons programmes pour pouvoir travailler dans de bonnes conditions.