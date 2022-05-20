# Assembleur #1 - introduction
@https://www.youtube.com/watch?v=fvtd2Ut3MHw  
21-07-20

## Plus bas niveau que C, C++ ou meme Fortran

C'est un ensemble de langage plus bas niveau que ceux rencontres (peut etre pas Fortran, non rencontres sur la chaine). On parle de niveau pour comparer les langages. Le langage assembleur est le plus bas niveau parce que on est directement au niveau du langage machine.

## Representation "lisible" du langage machine

Le langage machine est tres generalement code en langage binaire. La suite de 0 et de 1. On pourrait l'avoir code en hexadecimale, une autre base. Principalement notre systeme communique par le princide de bit, 0 et 1.
C'est quelque chose de fastidieux pour un etre humain de travailler comme ca. Ouvrir un editeur de code et de taper des 0 et des 1 pour produire eventuellement un programme qui pourrait etre executer. Le langage assembleur permet d'obtenir une representation de ce langage machine mais de maniere plus 'lisible' avec des termes plus precis. 
Si pour tel instruction, operation, il faut taper 0100101.. on va utiliser un terme pour faire ces differentes actions, operations avec une representation beaucoup plus "lisible". 

## Un langage pour chaque processeur

Par rapport aux architecture, on retrouve un langage d'assembleur pour chaque processeur. 

On a un processeur qui est donc une certaine architecture de processeur par rapport a un jeu d'instructions. Ce langage est rattache a ce jeu d'instructions. C'est directement le langage machine mais ecrit dans un autre langage. 

La langue de notre ordinateur, c'est le binaire (0 et 1) au plus simple. Eventuellement pour faire plus, on peut avoir du hexadecimale. On peut coder du binaire en hexadecimale (on change de base).

Nous en tant qu'etre humains, on va ecrire du langage machine, du binaire mais autrement. 

Pour chaque architecture, on retrouve un langage. On parle de plusieurs langages d'assembleur. Par exemple sur une architecture Intel, une architecture bien precise, on va avoir un langage. Si on est sur de l'ARM, du eMIPS, RISC, etc. on aura un autre langage.
Chaque famille de processeur qui auront leur propre langage. 

C'est aussi (consequence direct), un des langages qui communiquent directement avec le systeme d'exploitation. Il n'y a pas d'intermediaire entre les deux.

En C, C++, on ecrit via une syntaxe qui va etre compilee et devenir un langage d'assembleur issus de cette compilation. Ensuite un assemblage se fera derriere qui permettra de transformer le code du langage d'assembleur en langage machine.

En resume, c'est une simple traduction de l'ecriture assembleur a une ecriture binaire ou hexadecimale suivant le codage utilise.

## Communication plus fine avec l'OS.

Ce n'est pas que l'on est proche de l'OS, on est directement en communication avec le systeme.
c'est une communication tres directe et pour cela, il ne dispose pas forcement de securitee ou d'intermediaire. 

On peut tout faire de maniere tres avance mais en meme temps on peut tout casser, de produire des programmes qui plantent completement ou il n'y a pas forcement de verification ou quoi que ce soit.

## Historique :

### invention aux alentours de 1950.

Invention des langages assembleurs. 

### premier progranme ecrit en 1954 (IBM 701).

Premier programme ecrit par IBM lorsqu'ils ont commercialise leur premier ordinateur, l'IBM 701.

### outils incontournables (ex : GCC en 1987).

Le langage assembleur sert aujourd'hui a enormement de choses et a servir enormement de choses. Lorsqu'on programme en C ou C++, on a utilise le compilateur GCC de 1987 (arrive un peu plus tard) qui est un compilateur ecrit en langage d'assembleur. C'est comme ci, on l'avait quasiment ecrit en langage binaire, des 0 et des 1, mais ca aurait ete encore beaucoup trop fastidieux. On a passe par un langage d'assembleur qui a rendu la syntaxe beaucoup plus facile pour un etre humain.

C'est important pour eviter tout abus de langage. Par exemple, le mot crypter (de cryptographie) ne veut rien dire qui est un cas bien specifique car quand on parle de chiffrement, on parle de chiffrer. 
Il vaut mieux ainsi etre clair sur certains termes en Assembleur.

## Quelques termes :

### assembleur

Le langage d'assembleur (dont le diminutif est le langage ASM) a un theme assez faux. En effet, l'assembleur est en fait le programme, l'outil qui va permettre de traduire un code ecrit en langage d'assembleur (attention, ce n'est pas langage assembleur). L'assembleur en lui meme va faire la traduction de ce langage directement en un langage machine, binaire le plus standard qu'il soit. L'assembleur fait directement la traduction. Le langage d'assembleur est ce que l'on va ecrire sur nos fichiers avant de passer a l'etape d'assemblage.

### assemblage/desassemblage

L'assemblage est l'action utilise par l'assembleur. L'assembleur va assembler, faire un assemblage depuis notre langage assembleur pour produire de la traduction vers le langage machine sans detour, utilisation d'une autre syntaxe. 
L'etape inverse est le desassemblage. Par exemple, nous avons n'importe quel programme quel qu'il soit et nous allons pouvoir desassembler ce dernier pour obtenir un code en langage d'assembleur a partir de ce programme. Ce code en langage d'assembleur va bien evidement etre genere et prendra toutes les operations, instructions produites par le programme de base.

### langage d'assembleur (ou langage d'assemblage)

Le langage d'assembleur peut s'appeler langage d'assemblage. C'est le programme en lui meme qui va faire la traduction, ce n'est pas le langage en lui-meme, voila pourquoi on parle d'assembleur.

## Quelques syntaxes :

On va utiliser des syntaxes bien precises pour ecrire notre code. On parle beaucoup des syntaxes Intel et AT&T. 

* Intel
* AT&T

probablement qu'on travaillera sur du Intel mais peut etre dans certains cas quand on travaillera sur d'autres architectures, on sera plus sur du AT&T. Aucune certitude a ce niveau au sujet de la formation. Ce sont neanmoins des termes que l'on va rencontrer souvent. On comprendra pourquoi au fil de la formation.

## Jeu d'instructions (operarions elementaires) :

Nous avons vu qu'il y avait des familles de processeurs qui ont chacun une architecture. Pour cette architecture, on parle d'un jeu d'instructions. Imaginons qu'on ai le manuel de ce processeur avec toutes les instructions que possedes ce processeur la qui vont permettre de realiser un ensemble d'operations elementaires dans le sens ou l'on n'aurait pas d'insrructions toutes faites pour afficher une image a l'ecran, de jouer un son. C'est reserve pour des langages beaucoup plus haut niveau.

### manipulations en memoire

Par contre, pour des langages aussi proche du systeme, de la machine donc les langages assembleur. On va avoir des operations beaucoup plus elementaires, beaucoup plus primitive dans le sens ou l'on va manipuler directement la memoire. C'est a dire manipuler, sauvegarder, memoriser des donnees en memoire. 

### calculs arithmethiques

Cela on le ferra au fur et a mesure du cours, tout ce qui est operation sur des calculs, simple addition, soustraction. Meme des calculs arithmetiques un peu plus complexes (cosinus ou autre).

### comparaisons

C'est bien de pouvoir manipuler des donnees mais on ferra aussi des comparaisons de donnees.

### sauts, appels

Il y aura des choses un peu plus avancee comme les sauts, les appels, etc. On prendra le temps de detailler tout ca et d'en parler sur le cours.

Ce sont les instructions les plus elementaires, les plus simples qui assemblees ensemble, qui se suivent pour former le programme final et qui tout simplement englobe tout ce langage d'assembleur.

## Pour qui et pour quoi ?

C'est un cours qui vient s'ajouter a la chaine et il est normal de se poser la question A qui s'adresse ce genre de cours et pourquoi apprendre un/des langages d'assembleurs ? Il faut bien que ca servent a quelques choses. 

Il est recommande d'apprendre des choses si ca peut nous servir meme si on peut apprendre pour de la culture general ou par curiosite mais c'est peut etre un peu minime. Il y a peut etre des choses plus prioritaire ou interessante a faire dans notre monde. Il faut essayer d'apprendre les choses si cela peut nous servir si possible plutot que dire, j'apprend un langage assembleur pour dire que j'ai appris un langage assembleur.

Par contre si on a l'idee ou le projet de faire quelque chose avec, la c'est different. C'est beaucoup plus motivant, interessant que d'abandonner apres la troisieme seance parce que c'est trop dur.

### optimisations sur un programme existant

On va pouvoir utiliser un programme ecrit en langage d'assembleur pour faire de l'optimisation sur des programmes existants. 

De nos jours, avec la quantite de choses a faire sur notre programme, ce serait assez fou de programmer completement en langage assembleur sauf pour certains programmes comme un micro-kernel, des choses qui se faisait deja a l'epoque, qui se font encore actuellement, qu'on maintient comme ca mais on dira qu'on a une quantite assez limitee (quand meme plusieurs dizaines de miliers de lignes de codes voir plus mais en tout cas, on arrive a en voir le bout).

Sinon, sur un programme, on a besoin de partie un peu plus rapide, plus veloce en terme de performance, on peut avoir la necessite de programmer cette partie en langage assembleur.

Par exemple, on peut avoir un programme en C et pour une partie qui necessite des performances beaucoup plus importante, on peut decider de coder cette partie la en langage assembleur integree dans notre programme en C parce que en C, ce ne serait pas suffisament rapide. On parle d'optimisation qui serait necessaire. Attention, la questuon de l'optimisation dans un programme n'est pas la question que l'on se pose des le depart.

Au depart, on veut faire quelque chose de fonctionnelle et c'est vraiment quand on est sur que tout est fonctionnel, qu'on a fait la chasse au bug, etc qu'on peut commencer a se poser des questions Est-ce que je ne peut pas optimiser mon code pour le rendre encore plus rapide, efficace ? 

Si on travaille dans l'aero-spatiale ou autre, ces questions d'optimisations vont se poser tres vite. Ce n'est pas comme si on bosait sur un site web, une simple application Desktop ou par contre si cette derniere prend 13 secondes a demarrer quand on a cliquer sur l'icone de l'application, ce n'est pas grave.

Dans certains domaines bien precis, meme une seconde, c'est deja beaucoup trop long et a ce moment la, c'est meme inpensable et on ne peut absolument pas le tolerer.

### architectures specifiques

On peut avoir besoin de langage assembleur pour des architectures specifiques.

Par exemple (cas rare) ou l'on veut travailler sur un processeur, micro-controlleur, qui n'as simplement pas de prise en charge d'un autre langage. Pas de prise en charge du C et encore moins de langage comme Java, Python qui sont encore plus haut niveau que le C et donc on aurait que ce langage la.

Comme on l'a vu, le langage assembleur est directement rattache au processeur, c'est a dire aux jeux d'instructions qu'il possede. Donc obligatoirement quant un constructeur fabrique un processeur, un micro-controleur, il fournit forcement avec un jeu d'instruction sinon on ne pourrait rien en faire.

Automatiquement, il y a forcement un langage d'assembleur qui est compatible, qui est prit en charge, "qui est integre" (bisare de dire cela). Mais voila c'est une consequence directe, comme il y a un jeu d'instructions, ce jeu d'instructions peut etre utilisee via un langage d'assembleur pour programmer des choses. C'est le stricte minimum qu'on aura toujours sur n'importe quel processeur ou simplement architecture.

Donc quand on a pas trop le choix, le langage assembleur s'avere interessant. 

Pareil meme si on travaille sur de l'embarque ou autre et qu'on a que du C, on preferera travailler avec du langage assembleur dans certains cas. 

Dans le cas d'arduino, il peut etre interessant d'aller au dela du simple utilisarion du langage Arduino qui est finalement du C, une copie du C avec quelques modification.

### hacking, analyse, retro-ingeniorie

Ca peut etre interessant pour ceux qui font pas mal de securite. On peut tres bien travailler en securite informatique sans jamais faire du langage assembleur, ca depend de beaucoup de conditions particulieres mais il y a des gens dans le hacking a titre peofessionnel ou personnel qui vont vouloir pour des cas specifiques, utiliser un langage assembleur pour faire certaines choses.

Par exemple, si on fait du hack sur une playstation portable, on peut etre amene a utiliser un langage assembleur parce qu'il peut s'agir du seul moyen pour faire certaines choses. On peut ne pas avoir le choix de passer par ce genre de langage, notamment pour tout ce qui est analyse et retro-ingenierie.

Comme on a pu le voir dans les etapes de desassemblage. En gros, on a un programme existant et revenir a un programme originale, logiquement ce qui est le plus proche du langage machine, du code machine, n'est permise que par la retro-ingenierie via un langage assembleur.

On ne ferra pas de retro-ingenierie avec du Java par exemple. On peut faire de la decompilation de programne en Java, en Python, par des langages plus haut niveau qui ne sont pas vraiment compile.

C'est la retro-ingenierie qui permettra d'obtenir un code d'assembleur. C'est utile de connaitre ce langage parce que on ne pourrait pas analyser un code ecrit en langage asdembleur si on ne connaissait pas ce langage.

### curiosite d'apprendre

Il y a surement plein d'autres choses que l'on pourrait apprendre avant par curiosite qu'un langage assembleur.

Tout depend de ce que l'on veut faire personnelement ou a titre profesionnel.

C'est a nous de voir si apprendre un langage assembleur peut etre utile.

## Mais attention !

### plus de code qu'un langage de plus haut niveau

Puisqu'on parle de langage assembleur qui sont directement rattache a la machine, evidemment on va avoir beaucoup de codes a ecrire qu'un langage de plus au niveau. 

Pour ceux qui font du C par exemple, un simple printf permet d'afficher un texte sur une console. 

En assembleur, ca n'existe pas. Il n'y a pas de fonction. Via le langage assembleur, on peut neanmois passer par un appel de fonction C mais ca ce n'est pas du vrai code en langage asdembleur car on passe finallement par un autre langage.

Si on veut faire cela en langage assembleur, il n'existe pas une fonction toute faite pour afficher du texte sur une console.

En effet, on va devoir enumerer, detailler, ecrire toutes les instructions permettant de faire cela. Par exemple, la fonction printf (en parlant du compilateur GCC qui a ete ecrit en langage assembleur) est du code en langage assembleur a la base.

Aujourd'hui tout ce que l'on peut utiliser dans d'autres langages, notamment en C, vient du langage assembleur.

Ensuite le C a servi de base pour faire des langages comme PHP ou Python. Derriere Python ou PHP, il y a du C. Apres il y a peut etre d'autres langages qui sont base sur Python et ainsi derriere il y a du Python qui est lui-meme base sur du C, qui est lui-meme base sur du langage assembleur.

Les langages assembleur sont finalement les langages originels parce qu'ils directement rattaches a l'architecture, ce qu'il y a de plus proche du langage machine. Il a ete cree des compilateurs et des interpreteurs qui ont permis de fabriquer, inventer un langage plus haut niveau et ainsi de suite et plus on va comme ca dans le plus haut niveau plus on s'eloigne de la memoire, plus on s'eloigne du materiel, plus on fait les choses rapidement, moins il y a de codes a ecrire, moins il y a de risques de faire des erreurs.
 
### quasiment pas de portabilite du code

Forcement, il n'y a quasiment pas de portabilite du code.

Si on ecrit un programme en langage assembleur Intelx86 et qu'on essaye de faire tourner cela sur une machine, sur une console qui tourne avec un processeur ARM, forcement il va y avoir des petits problemes.

C'est logique, plus on est sur des langages bas niveau, moins la portabilite se fait, ce qui necessitera dans le pire des cas, une simple recompilation. On a pas vraiment d'histoire de recompilation ici parce que on est encore une fois sur du langage machine mais ecrit avec une syntaxe plus humainnement lisible.

### debogage et detection d'erreurs plus fadtidieux

Ce dernier point est forcement plus fastidieux parce que pour par exemple faire un seul traitement comme on ferait en C, en Python. On pourrait avoir des dizaines d'instructions en langage assembleur et forcement en cas d'erreur, il va faloir eplucher tout ca et meme avec des outils pour faire du debogage, ca va nous demander pas mal de temps. C'est forcement beaucoup plus laborieux pour autant qur le langage n'est pas forcement plus complique a apprendre qu'un autre (insister sur ce point).

Ce n'est pas plus complique de faire du langage assembleur sur Playstation portable par rapport a l'apprentissage du Python ou certaines choses peuvent sembler un peu complexe au depart avant de pouvoir les mettre en pratique.

Forcement, il y a des langages qui demandent plus de rigueur que d'autres. Il y a des langages qui permettent de faire moins d'erreurs que d'autres. Il y a plus de risque de se tromper en langage assembleur, qu'en C, qu'en Python, en Java, en CSharp. 

Il ne faut pad calquer le niveau de rigueur, le niveau de risque d'erreur d'un langage avec sa complexite. Il y a des gens qui se debrouille completement en langage Assembleur et qui serait incapable de se debrouiller en Python parce qu'il n'ont juste pas la logique, ils ne comprennent pas comment ca fonctionne et ils besoin directement proche au niveau de la memoire, de manipuler des registres, d'utiliser simplement les bons jeux d'instructions tel qui le faut. Alors que leur parler de fonctions, classes, etc les perdraient totalement.

C'est donc vraiment tres subjectif. C'est pourquoi dans cette intro, nous ne parlons pas de complexite. Que ce serait plus ou moins difficile que le C, plus simple, etc. Ce sont vraiment des choses tres subjectives qui dependent de nous.

Peut etre que certains s'en sortiront mieux dans un langage assembleur plutot que dans un langage haut niveau.

Pour autant, si on veut rester objectif, 
* le code sera plus long ;
* il n'y aura pas de portabilite comme sur des langages plus haut niveau ;
* en terme d'erreur, il y a plus de risque que cela arrive. Pour tout ce qui est depannage, deboggage, correction, etc ce sera plus fastidieux. C'est parfaitement logique, c'est comme ca que les langages sont. Forcement, il y a plus de risque, ce serra plus fastidieux pour les corrections.

Voila, on a fait le tour de tout ca.

## Que va proposer le cours (et tutoriels) ?

Que va proposer le cours parce qu'il y a enormement de choses.

### plusieurs architectures (Intel, Mips, ARM)

Au depart, il etait pense faire un cours sur le langage assembleur et l'architecture Intel, ensuite eventuellement un cours pour ARM, pour IPS, etc. Mais ca va faire beaucoup trop de choses.
Tel que reexpliquer les registres sur 3 cours differents, les instructions sur 3 cours differents, les bases, etc. Ca aurait fait beaucoup de doublons, beaucoup de choses.

Il y aura forcement des repetitions

Tout de suite, on sait ce qui va etre aborde. On va parler de plusieurs architectures. On ferra du langage assembleur sur ordinateur, sur des architecture Intel. Il y aura du 16 bits, du 32 bits, du 64 bits, etc. On parlera de pas mal d'adressage notamment. On parlera d'MIPS aussi. On viendra notamment sur ce qu'il est possible de faire sur la Playstation portable et plus precisement d'MIPS R4000. On pourra par exemple s'amuser a faire du langage assembleur sur Playstation portable.

Ensuite ARM, ca peut etre assez riche car ca peut etre sur telephone, sur console de jeu aussi, sur des appareils mobiles. Bref on a de l'ARM, un peu partout aujourd'hui.

On trouve tres facillement des appareils qui possedent une architecture en ARM. Et si un jour, on a la possibilite et que ca nous interesse, on pourrait s'amuser a creer des programmes sur ces appareils.

### plusieurs systemes (GNU/Linux, Windows)

Au niveau des systemes, sur quoi allons nous programmer ? On verra comment organiser cela au niveau du cours mais il est certains qu'on aura un cours assez complet, on ne va pas se contenter du minimum.

Mais comme finalement, il n'y a qu'un cours en langage assembleur. On aura a la fois de la programmation sur GNU Linux qui lui est un systeme qui n'est pas fermé, on a acces a tout un tas de chose bas niveau, liées au systeme.

On travaillera notamment avec les appels systemes, les fameux syscall. 

Et Windows parce que Windows est un système qui est propriétaire et fermé mais qui propose une EPI qui permet d'accéder à certaines fonctionnalités qu'autorisent Microsoft forcément pour pouvoir travailler depuis un langage assembleur directement en fait créer des programmes sur Windows donc on peut faire évidemment du langage assembleur sur Windows. Il n'y a aucun problème avec ça et comme je n'avais pas envie de vous dire que je vais vous faire programmer sur Linux ou sur Windows, je n'avais pas envie de faire le choix parce que je trouve que c'était intéressant de parler des 2 parce qu'on parle très très peu de Windows en termes de langage assembleur, à tord je trouve. 

Même si Windows est un système fermé donc ce qui est un peu logique et donc il y a moins de choses que vous pouvez faire sur un système Windows que GNU-Linux en langage assembleur. 

Normal parce que c'est ce que veut Microsoft donc ce sera directement au niveau de l'API c'est-à-dire ce que autorisent Microsoft et après pour GNU-Linux comme c'est beaucoup plus ouvert, forcément là vous pourrez faire tout et n'importe quoi. 

Si vous voulez faire planter votre système il n'y a aucun problème, il n'y aura pas de soucis pour ça. 

Voilà on essaiera de voir un petit peu tout ça, je ne pourrais pas vous dire du coup comment vont s'organiser les vidéos. 

Je sais que durant les premières vidéos nous allons parler de pas mal de choses lié notamment à la mémoire. On va parler des registres, on va parler des bases de codage ce qui va faire du coup un petit peu doublon avec le cours de hacking pour ceux qui avaient vu éventuellement. 

Mais voilà le cours de hacking sera certainement réécrit parce que le cours de hacking a besoin encore une fois de beaucoup de prérequis, c'est ce que je vous avais dit et notamment ce cours en langage assembleur, cette énorme cours parce que là on est parti sur un cours assez énorme, assez astronomique mais vous servira sur le cours de hacking ou autre ce qui me permettra de mettre à jour réécrire ce cours de hacking. 

Je pourrais éventuellement refaire un tutoriel sur les parties de la compilation en c sur la playlist tutoriel du langage c, ça aurait peut être plus sa place là dedans et tout ce qui est système de codage conversion et cetera, on pourra éventuellement le voir sur ce cours là. Ça me paraît plus évident. 

Le problème comme je vous ai dit c'est que des fois je viens à changer certaines choses parce que ça ne me plaît plus tel que ça avait été décidé au départ et comme sur youtube on ne peut pas décider de mettre à jour une vidéo en disant que ça je le mets ailleurs, Eh bien on doit faire de nouvelles vidéos. 

Ce n'est pas grave mais dans tous les cas vous êtes gagnant, vous y gagnez parce que vous aurez quelque chose d'encore meilleur, qui sera à jour et cetera, encore plus moderne donc vous avez tout à y gagner personnellement. 

Moi par contre j'aurais un peu plus de travail mais ça ! aucun problème je ne m'inquiètes pas pour ça. 

Voilà ce sera assez complet, donc s'il y en a qui demande est-ce qu'on fera de l'assembleur sur Windows, sur Linux ? est-ce que ce sera en 32 bits en 64 bits ? voilà il y aura un petit peu de tout. 

Je n'ai pas voulu faire le choix de faire un cours sur de l'architecture 32 bits parce qu'on a du 64 aujourd'hui. Ça peut être aussi pas mal d'expliquer le 16 bits parce qu'il y a peut-être moins de choses à expliquer au départ donc on peut en parler et peut être que certains parmi vous feront de la programmation sur des architectures en 8 bits. 

Voilà ça existe encore, on peut pour des raisons encore une fois x où y, vouloir travailler sur ce genre de choses et dans ce genre de cas c'est bien de savoir comment ça marche. 

On va essayer de faire un cours assez général d'accord parce qu'il n'y aura qu'un seul cours en langage assembleur. Au niveau du cours j'aborderai ce qui me semble être le plus essentiel et après merci d'avoir choisi justement ce principe une playlist de cours et une playlist de tutoriels parce que l'avantage d'une playlist tutoriel je pourrais aborder plein de choses avec vous. 

On pourra aborder l'ARM sur tout un tas d'architecture différente, le MIPS, et on pourra programmer sur plein d'autres appareils que votre ordinateur. 

Il y a des gens chez vous qui ont peut-être tel truc, tel truc et si il y a moyen que je fasse une vidéo moi parce qu'il faudra que je possède l'appareil en question, ça peut être sympa. 

Attendez vous de faire de la programmation sur votre PC mais aussi sur Nintendo DS, Nintendo switch, playstation portable, les consoles de salon ou sur tout un tas d'appareils on va dire un peu plus embarqué tel que je ne sais pas moi par exemple arduino si un jour j'ai investi un peu là dedans, pourquoi pas et ce sera en plus l'occasion de voir un peu comment ça fonctionne de suite donc voilà tout simplement. 

N'hésitez pas, encore une fois je vous ai donné un maximum d'informations pour que vous ayez tous ces outils là, ne vous jetez pas obligatoirement sur ce cours en vous disant que c'est génial donc je vais le faire. 

Voilà moi je vous le conseille, c'est un conseil après vous le suivez ou pas donc lancez vous dans un langage comme celui-là et ça vaut pour n'importe quelle formation pour le C, pour python si vous savez ce que vous voulez en faire derrière. 

Voilà j'ai encore des gens qui me disent que je suis en train d'apprendre le cours python mais je ne sais pas ce que je veux faire avec, ce qui est un peu dommage. 

C'est mieux de se dire, j'ai envie de créer moi des jeux, j'ai envie de faire ci où ça et pour y arriver j'ai décidé d'étudier tel langage pour pouvoir ensuite travailler sur ces projets là ou de faire ce programme là. 

Ayez quand même un but ce qui est quand même mieux, avoir un but de ce que vous apprenez. 

Voilà ça évitera peut-être aussi de vous décourager en plein milieu et ça vous motivera beaucoup et du coup ça vous évitera encore une fois d'apprendre un langage pour juste apprendre un langage, ce qui à mon sens n'est pas forcément le plus utile même si on parle de culture générale.  Il y a peut être plus intéressant je pense.

Voilà s'il y a des questions n'hésitez pas parce que j'ai finalement détaillé pas mal de choses donc n'hésitez pas. 

Tout ça pour dire que si vous avez des questions ou des remarques ou si vous avez besoin d'informations complémentaires concernant ce cours, n'hésitez pas à les poser dans les commentaires, à partager comme d'habitude la vidéo, like et cetera. 

Voilà à bientôt. 

Je vous dis à bientôt pour la suite de ce cours et pour d'autres vidéos à venir sur la chaîne. 

Prenez soin de vous et n'hésitez pas dans les commentaires si vous avez quoi que ce soit à demander concernant toute cette introduction du langage assembleur. 

Ciao