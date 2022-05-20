# Assembleur #2 - dis bonjour !
@https://www.youtube.com/watch?v=22UPjfgyRzI  
10-01-21

Bonjour à tous, bienvenue pour cette deuxième séance en langage assembleur.

On se retrouve ensemble pour créer notre premier programme dans ce langage et pour ... en tout cas pour cette vidéo ... pour faire une exception, nous travaillerons aussi bien sur windows que sur linux.

Je vais vous montrer la démarche sur ces deux systèmes là, je ne le ferai pas évidemment sur mac os puisque je n'ai pas d'ordinateur de la marque apple d'accord même si vous verrez que par rapport à GNU-Linux c'est assez similaires et on peut rapidement quand même adapter le code d'un des systèmes à l'autre.

On travaillera également sur du 64 bits et du 32 bits, on verra les deux architectures mais on ne le fera pas évidemment à chaque fois pour chacune des vidéos bien sûr du cours.

Je vous avais dit en introduction que je ne pouvais pas toutes façons tout abordée puisqu'il existe un langage d'assembleur pour chaque architecture donc c'est évidemment très très complet, c'est très vaste et en même temps je ne voulais pas forcément faire une formation pour chose chaque architecture que je souhaite aborder sur la chaîne.

Ca aurait un peu éparpillé les différentes notions et il aurait fallu aurait expliqué un petit peu la même chose aussi d'une formation à l'autre donc là on a un cours.

On fera principalement du 64 bits puisque c'est ce que vous avez normalement sur vos ordinateurs actuels.

Si vous êtes sur des ordinateurs un peu plus anciens notamment au niveau du processeur, vous avez peut-être un processeur qui est encore en 32 bits, ça peut arriver si vous voulez travaillez sur une vieille machine et de toute façon, on travaillera aussi sur des supports qui sont en 16 bits.

Le but bien sûr de ce cours, c'est que vous puissiez très simplement avec l'autonomie que vous aurez gagné, la confiance et puis toutes les notions que vous aurez vu et bien pouvoir vous adapter à n'importe quel outil, n'importe quel matériel sur lequel vous souhaiteriez programmer en langage assemble voilà comment que ça va se passer.

On va regarder ensemble les différents outils qu'il va falloir installer, qui vont nous servir tout au long bien sûr de cette formation et ensuite on passera au code, a commencer pour une première partie sur linux et en terminant en deuxième partie de cette séance pour windows parce que c'est un peu plus délicat et vous allez très vite comprendre pourquoi. J'en parlerai plus en détails.

On y va, passons directement sur linux.

Premier outil qu'il va vous falloir installer c'est un éditeur de code.

Evidemment comme chacune des formations de la chaîne, je pars du principe que vous n'avez jamais programmé avant que vous n'êtes pas forcément très famillié avec l'outil informatique.

Après logiquement si vous souhaitez apprendre à programmer, s'il y a un prérequis à voir avant de suivre ce cours au minimum bien sûr c'est de savoir utiliser votre système d'exploitation mais ça c'est à prévoir un petit peu pour chaque domaine finalement de l'informatique.

Si vous ne savez pas vous servir de votre windows, de votre linux avant même de commencer à faire de la programmation, de la 2d, manipuler un logiciel de graphisme ou faire de la mao, ça risque d'être problématique et vous allez très souvent bloquer ou avoir des problèmes sur des choses qui ne concerne pas en fait ce qui va être abordé notamment dans ce cours mais qui concerne directement l'usage, l'utilisation de votre système que vous ne maîtrisez peut-être pas avec lequel vous n'êtes peut-être pas encore assez familier.

Donc pour ceux qui ne le sauraient pas, au minimum il va nous falloir un éditeur de code, c'est tout simplement une application qui va nous permettre d'écrire notre code.

Généralement je ne recommande rien en particulier, je ne recommande pas d'éditeurs ou d'environnement développement complet.

Je pars toujours du principe que le meilleur outil que vous puissiez utiliser c'est celui que vous savez utiliser d'accord et qui fait le travail que vous demandez voilà.

Vous voulez réaliser quelque chose et si vous arrivez à le faire avec un outil et que ça vous convient, c'est a priori le meilleur outil que vous puissiez utiliser d'accord.

Si vous êtes encore à vous poser la question quel est le meilleur éditeur, le meilleur environnement si c'est ça qui compte pour vous, vous perdez peut-être un petit peu votre temps donc apprenez à utiliser un outil choisissez n'importe lequel, testez en plusieurs même s'il faut.

Adoptez en un, celui que vous préférez, que ce soit pour des histoires de préférence au niveau du thème, de l'interface, des fonctionnalités, des outils intégrés, etc.

Peu importe dans tous les cas, voyez un petit peu de votre côté, testez et choisissez ce qui vous plaît le plus.

Evidemment pour ceux qui ne sont pas du tout au courant de comment ça fonctionne et quels outils utiliser en particulier.

J'ai fait sur youtube donc sur la playlist Aide, une vidéo sur mon github parce qu'on peut bien sûr retrouver dans l'intégralité des vidéos plus simplement dans la playlist aide et vous allez retrouver directement une vidéo sur visual studio code d'accord qui est tout simplement l'éditeur que j'utilise principalement, quasiment sur toutes mes vidéos voilà ici.

@https://github.com/jasonchampagne/FormationVideo/blob/master/Playlists/aide.md

Et vous avez donc une vidéo petit guide sur visual studio code.

C'est principalement celui de toute façon sur les vidéos de la chaîne sauf à l'époque où il n'existait pas et je me servais d'un autre éditeur de code, c'est un éditeur de code voir même un mini environnement développement puisqu'on peut à l'aide d'extensions installer tout un tas d'outils supplémentaires qui peut en faire quelque chose d'assez riche en termes de fonctionnalités et d'outil intégré.

Voilà ça c'est le premier outil d'installé une fois que vous l'aurez, vous pourrez directement en bénéficier et si vous ne savez pas comment l'installer encore une fois je vous renvoie vers ma vidéo qui vous montrera comment installer ça peu importe votre système d'exploitation puisque c'est multiplateform,  c'est open source et c'est gratuit et c'est là évidemment tout l'intérêt.

Pas besoin de payer quoi que ce soit c'est magnifique et on commence bien cette année 2021 mine de rien au moment où je fait cette vidéo avec cet outil là.

Première outil.

Deuxième outil on va avoir besoin puisqu'il s'agit de langage assembleur et je vous ai pas mal embêter avec ça pendant la vidéo d'introduction sur le fait qu'on parlait réellement de langage d'assembleur ou de langage d'assemblage, pourquoi ? puisque l'assembleur comme on le dit de manière abusive en parlant de langage assembleur, en réalité c'est le programme qui vont me permettre d'assembler d'accord ce que l'on a écrit comme code d'accord et nous allons justement installer un assembleur.

Ici petite chose à savoir, petite particularité, j'en avais déjà parlé précédemment c'est qu'il en existe plusieurs d'accord il n'y a pas qu'un seul assembleurs et un assembleur propose et possède sa propre syntaxe voire même ses propres fonctionnalités d'accord.

Il y a des assembleurs qui auront plus de fonctionnalités que d'autres en fonction de ce que vous installez.

Pour évidemment ne pas se perdre on va utiliser toujours et uniquement le même que soit sur windows ou linux, à savoir NASM.

NASM, Netwide Assembler, c'est lui, c'est celui-çi que nous allons installer sur notre système.

@https://nasm.us/

L'avantage c'est que nous travaillerons avec le même outil, vous aurez la même syntaxe, la même fonctionnalité, vous ne serez pas perdu.

Bien évidemment encore une fois le but de mon enseignement, c'est de permettre de gagner en autonomie et surtout en curiosité aussi, d'être un maximum curieux pour ne pas par la suite en tout cas vous dispensez d'où vous intéresser à d'autres outils et qui sait peut-être qu'un jour vous vous amuserez à travailler sur d'autres assembleur, à en tester d'autres. Il n'y a pas de problème.

On a également par exemple pour windows MASM, on a également GNU ASM, c'est l'assembleur du projet GNU et on en a pleins pleins d'autres d'accord, il en existe vraiment plein plein plein.

Chacun avec leur syntaxe, chacun avec leurs fonctionnalités mais il réalise la même chose c'est-à-dire de programmer d'accord en langage assembleur et sous différentes architectures bien sûr en fonction.

L'avantagent de NASM c'est que ça fonctionne sur windows, ça fonctionne sur linux, sur mac os, pour du 32 bits, pour du 64 bits voir autre mais en tout cas voilà on travaillera sur les architectures en tout cas principal donc c'est bien pratique, c'est également gratuit encore une fois donc ça fonctionnera très bien et ça fera largement le travail par rapport à ce que nous voulons faire en tout cas pour cette formation.

NASM, c'est celui que nous allons utiliser et que nous allons installer.

Evidemment et c'est ce que disait en début de vidéo, il faut savoir utiliser un minimum votre système surtout si vous êtes sur une distribution GNU-Linux donc ici normalement il est déjà installé.

Le paquet à installer généralement, je pense que cela ne va pas de toute façon changer au niveau du nom d'un os à l'autre, c'est NASM.

```bash
	sudo apt install nasm
```

Une fois qu'il est installé pour vérifier que c'est bien le cas, vous pouvez faire appel directement au programme avec son argument -V pour obtenir le numéro de version et ça vous indiquera effectivement quelque chose s'il est installé.

```bash
	sam@samVB:~$ nasm -v
	NASM version 2.14.02
```

Donc là on a la version 2.13 au moment où je fais cette vidéo.

Si vous avez une version plus récente aucun problème bien sûr vous pourrez suivre ce cours il n'y a pas de souci.

Voilà donc on a notre éditeur de code, on a notre assembleur et on va avoir besoin d'une autre partie.

Une fois qu'on va assembler notre code, on va obtenir ce qu'on appelle un fichier objet.

Un fichier objet va en fait pouvoir est lié via ce qu'on appelle un lieur d'accord il y a le système donc le principe d'édition de lien pour obtenir notre programme final qui est généralement un programme exécutable, c'est l'objectif en tout cas la finalité de ce qu'on veut faire, c'est avoir en tout cas quelque chose d'exécutable.

On ne va pas s'embêter, si vous avez déjà programmer en c, en c++, logiquement vous l'avez déjà il s'agit de ld d'accord c'est le lieur de GNU qui est directement disponible.

Moi si je fais un ld -v, il est déjà présent puisque gcc etc, tous ces outils là, les compilateurs sont déjà présents dessus.

```bash
	sudo apt install binutils
```
```bash
	sam@samVB:~$ ld -v
	GNU ld (GNU Binutils for Ubuntu) 2.34
```

Si jamais vous ne l'avez pas je vous recommande d'aller voir directement dans mes tutoriel sur le langage c.

Vous l'installez simplement parce que c'est binutils mais de toute manière sur linux vous l'avez puisque linux utilise de toute façon ces outils là donc logiquement il n'est pas possible que vous ayez une distribution de linux sans ls disponibles dessus et sinon s'il vous manque des paquets et que vous ne savez pas trop quoi installer vous faites une petite installation notamment ici de build-essential qui est donc un méta paquet qui en contient plein d'autres et vous aurez comme ça tous les outils nécessaires.

```bash
	sudo apt install build-essential
```

A terme une fois que vous avez votre éditeur de code c'est d'avoir encore une fois NASM et d'avoir le lieur ld d'accord c'est ce que nous allons utiliser ici pour du GBU-Linux d'accord que vous pourrez éventuellement d'ailleurs utiliser sur macos encore une fois moyennant bien sûr une petite adaptation du code parce que comme je l'ai dis ça va varier d'un système à l'autre.

Donc ceci étant fait, ceci étant dit et étant installé, on va pouvoir passer à la suite et écrire notre premier code d'accord on est parti on a notre éditeur, notre assembleur, notre lieur, on a tout ce qu'il faut magnifique on va pouvoir faire notre notre pâte et finalement la recette sera bonne.

A partir de là nous allons créer notre fichier pareil je pars du principe que voux n'avez jamais programmé de votre vie donc donc on va faire étape par étape.

On va prendre notre temps et en plus on va voir énormément de choses sur ce cours, sur cette formation.

Ensuite nous allons tout installer, déjà pour votre éditeur alors notamment pour visual studio et si vous utilisez un autre logiciel débrouillez-vous donc vous savez logiquement vous en servir c'est le principe.

Ici nous allons installer une extension pour avoir en fait une coloration syntaxique sinon au niveau du code, on n'aura pas forcement une identification au niveau de la couleur pour voir les différentes parties, on va tout avoir en blanc c'est pas pratique bref ou en noir si vous êtes sur fond clair c'est pas génial donc normalement je pense qu'en mettant nasm, on devrait obtenir une extension et il y en a plusieurs on peut chercher Assembly 86 peu importe mais en tout cas on va voir pas mal de choses ici.

On va installer celui là, on verra ce que ça fait.

	The Netwide Assembler (NASM)

normalement je crois que c'est celui que j'ai installer sur mon windows de toute façon, j'ai un doute mais on verra très vite comment que ça se passe.

On y va, passons aux codes et on va en avoir deux alors déjà c'est bien d'avoir des notes en fait que vous voyez visuellement pcq fois je peux dire une chose à l'orale puis les gens comprennent un mot pas du tout comme ça donc c'est bien d'avoir des notes sous la main voilà et on va créer deux fichiers.

Faut savoir qu'au niveau programmation, on travaille donc en deux modes, on a soit des fichiers en mode texte et on a des fichiers en mode binaire et sans entrer dans le détail en gros, quand vous programmez quand vous avez besoin d'un fichier source et un fichier source n'est rien d'autre qu'un fichier en mode texte d'accord on va juste changer l'extension pour qu'il soit facilement reconnus par l'outil si on veut faire de la compilation, l'assemblage tout ça parce que s'il n'est pas dans la bonne extension il ne sera pas content il va dire non je passe ce format là tu dégages et voilà on est assez sélectif sur les outils.

Vous pouvez créer n'importe quel fichier texte sans problème et vous allez changer son extension et ici moi je vais l'appeler a32 et l'extension pour l'assembleur la plus commune c'est .asm, on peut mettre extension .s, il y en a plein d'autres mais éventuellement comme vous démarrez, vous pouvez très mettre asm ça ne posera pas de problème c'est tout pareil.

	a32.asm

On va faire la même chose pour 64 et vous allez comprendre pourquoi. On va changer l'extension .txt par .asm et on va ouvrir ces deux fichiers.

	a64.asm

Je vais commencer par la version 64 bits et on finira par la 32 pcq encore une fois normalement vous être en majorité logiquement en 2021 sur du 64 bits. Il y a plus de chances que vous soyez sur ça mais il va faloir que j'en parle parce qu'encore une fois ce n'est pas parce qu'on fait ce cours que vous êtes forcément censé savoir qu'est ce qu'une architecture, quel format, quel système d'adressage, est ce que vous avez du 32, du 64 donc on va très rapidement en parler.

En gros comprendre que vous avez dans votre processeur d'accord dans votre ordinateur qui possède une certaines architectures d'accord tel qu'il a été construit.

Il est aujourd'hui en 2021 au moment où je fais cette vidéo normalement ce qui sort son taux en architecture 64 bits sur votre ordinateur d'accord ça vous permet par exemple notamment de disposer d'une mémoire vive de  mémoire ram beaucoup plus important c'est à dire au delà de 3 giga.

On peut mettre maintenant du 8 gigas, 16, 32 gigas sur un pc.

C'est grâce au format en 64 bits qu'on peut avoir donc ces mémoires étendues aussi importante.

Sur un format 32 on était beaucoup plus limité et sur des vieilles machines il ya plus de chances que vous soyez sûr du 32 bits par rapport aux processeurs mais par rapport à ce qu'on va vouloir programmer ce n'est pas tout il faut pas prendre en compte que l' architecture de votre processeur même si c'est à priori déjà le but premier. C'est surtout fonction de votre système.

Sur un processeur en tout cas qui a une architecture 32 bits, vous allez pouvoir par exemple installer une nouvelle distribution linux ou même un windows en 32 bits. Là il n'y a pas de doute, on ne va pas se tromper, de toute façon 64 ne marche pas.

Par contre là où il y a la douille c'est que sur une architecture 64 bits, on peut très bien et on devrait installer un système 64 bits pour profiter un maximum bien sûr des fonctionnalités, des avantages que peu profité, qu'ajoute en fait cette architecture mais on peut sans problème installer un système en 32 bits ça fonctionnera aussi parce que 64 c'est une extension du 32 bits donc si vous installez par exemple un ubuntu 32 bits alors que votre processeur est un processeur 64 bits ça va fonctionné, ça ne posera pas de problème mais à ce moment là vous serez bridé et il faudra programmer en langage assembleur donc en 32 bits si votre système est en 32 bits donc veiller en fait à ce que le code que vous allez produire est fait par rapport à la version de votre système d'exploitation.

Encore une fois si vous êtes en 32, il n'y a pas de doute possible quand vous êtes en 64 il va falloir le vérifier.

Le meilleur moyen puisqu'on est sur Linux ici c'est de faire un petit uname -a, je ne serais même pas obligé de vous montrer ce genre de commandes puisque si vous ne savez pas le faire et que vous ne connaissez pas de votre système vous avez un cours Linux sur ma chaîne qui montre un petit peu tout ça dans le détail puisque ce n'est  pas un cours linux mais c'est cours au langage d'assembleur.

```bash
sam@samVB:~$ uname -a
Linux samVB 5.8.0-36-generic #40~20.04.1-Ubuntu SMP Wed Jan 6 10:15:55 UTC 2021 x86_64 x86_64 x86_64 GNU/Linux
```

Et là normalement pour toutes les infos, on obtient ce genre de format x86_64 donc ça ça correspond au format 64 bits.

Si c'était que x86 ça correspond à du 32 et quand on a un underscore 64 c'est du 64, on peut trouver également i386 ça correspond à du 32 bits aussi, on peut avoir plusieurs termes différents. C'est des fois un peu galère  parce que ça dépend en fait un petit peu de l'identifiant qu'on utilisait à l'époque pour les différents modèles de processeurs notamment chez intel d'accord.

On avait plusieurs versions comme ça et on a des identifiants qui sont restés d'accord pour des raisons de compatibilité voilà donc là je suis sur un système de toute façon 64 bits donc forcément j'ai installé un  système 64 puisque je suis sur une architecture 64 donc j'ai pas bridé par rapport à ça donc pas de problème je vais pouvoir programmer principalement là dessus et vous si vous êtes en 32, vous ferez ça donc à vous  d'adapter en fonction.

Je vais vous montrer encore une fois exceptionnellement pour cette séance les codes sur les deux architectures mais on ne va pas le faire à chaque séance.

On ne va pas le faire à toutes les séances sur linux et windows et sur du 64 et du 32.

On imagine et vous allez voir déjà la longueur de cette vidéo, imaginez si je fais ça pour chacune quand on va passer à des notions un petit peu plus avancé, on va avoir des vidéos de quatre heures donc ça va être un peu compliqué pour moi.

Voila on y go, on est parti, on va commencer par 64 puisque encore une fois ça va être le plus courant et c'est a priori ce qui va fonctionner si vous possédez un appareil assez moderne, attention 64 bits c'est une architecture qui existe quand même depuis maintenant je crois plus de 15 ans donc c'est pas comme si c'était sorti hier non plus mais c'est vrai qu'on a encore aujourd'hui des outils qui tourne en 32, même des applications qui sont en fait en 32 comme Steam, Skype tout ça je crois qui ne sont pas passés encore en 64 bits d'ailleurs.

Toujours voilà le 32 bits a la vie dure et va continuer d'exister encore un petit moment voilà autant flash a disparu de cette fin d'année 2020 mais pas le 32 bits.

Bref passons au 64 bits et passons au niveau du code que je maintenant écrire.

Alors le code évidemment ce que je vais faire, vous n'aller rien comprendre sauf si vous avez bien sûr déjà programmez en langage assembleur et pas sûr que vous comprenez tout d'ailleurs mais c'est normal le but c'est  que j'écrive le code, que je commente très rapidement grossièrement ce que je fais d'accord et bien sûr ça va vous permettre de voir un peu à quoi ça ressemble visuellement parlant en tout cas, en termes de syntaxe.

Je vais employer quelques termes aussi durant le commentaire que je vais apporter au code que je vais écrire et sachez que bien sûr tout ce que je vais écrire là, vous arriverez à l'installer, vous arriverez à le comprendre parfaitement totalement et vous saurez ce que chacune des lignes ou chacune des instructions ci on veux être  précis fait dans ce code donc c'est parfaitement normal que vous ne comprenez rien je voulais en fait aborder ce cours un peu d'une autre manière en faisant ça vous balancez un code et après on va éplucher un petit peu tout ça, détailler ça, voir les structures et les différentes notions d'accord qu'on abordera ensemble au cours de cette formation pour le langage d'assembleur.

On y va, on commence par notre architecture 64 bits ok donc x64 et je vais indiquer au niveau de mon code que je veux justement générer un programme pour une architecture 64 donc je vais alors pour éviter toute ambiguïté d'indiquer dans monde code via cette instruction bits donc suivi de la valeur 64 pour être sûr donc pas de problème.

a64.asm
```asm
	bits 64
```

Ensuite on va travailler par un système de segment alors je vais bien sûr être assez brève dans mes explications, le but c'est pas vous détailler la structure du code que je fais c'est juste de vous présenter brièvement en commentant et bien sûr tout ce que vous allez voir là sera expliqué en détails, en long en large et en travers tout au long de cette formation dont ne vous inquiétez pas si vous ne comprenez rien au niveau du code c'est normal d'accord.

Si vous n'avez jamais programmé en langage assembleur c'est normal que vous ne compreniez pas le code c'est  logique, vous êtes là pour apprendre.

On va utiliser donc la section data qui va permettre d'avoir des données initialisées puisque je vais avoir besoin d'une constante notamment le texte affiché, je rappelle que pour cette vidéo comme l'indique le titre nous allons faire un hello world. C'est simplement un programme qui affiche un texte en mode console tout simplement c'est la base mais c'est le minimum à savoir faire quand on apprend un langage de programmation.

a64.asm
```asm
	bits 64

	section .data
```

Je vais avoir un format particulier ici, je vais mettre 'hello world !' ce qui nous fait 13 caractères ok, je vais mettre un petit retour à la ligne donc je vais lui mettre le code ascii pour faire un retour à la ligne.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10
```

Et nous sommes partis, on va pouvoir passer cette fois ci à la partie du code donc le segment texte ce sera très bien.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
```

On va rendre la portée ici de la suite donc mes instructions globale et comme le lieur ld que nous utilisons  pour linux attend ce terme d'accord cette étiquette là, il faut l'appeler _start avec un underscore au début.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
```

Je rend ça global sinon le lieur ne pourra pas la trouver et donc l'édition de liens ne pourra tout simplement pas se faire et je mette ça là.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
```

Je le met juste ici dans le texte, je pourrais le mettre tout à fait par exemple ici au début du code en dehors même de la section texte mais moi je le mets ici comme ça je ne l'oublie pas et il n'y a pas de problème.

On est parti alors gros avantage c'est là que vous allez voir la différence entre Linux et Windows, ça va être assez mine de rien assez rapide et ensuite plus tard à la fin donc en deuxième partie de cette vidéo pour windows ... pour rappel si vous ne savez pas linux est un noyau d'accord donc c'est le noyau qui nous intéresse ici et qui est est sûre cette distribution bien sûr et c'est quelque chose qui est open source. On a donc accès au code source de son noyau, de ce kernell, il n'y a pas de problème et comme c'est quelque chose qui est opensource naturellement on a très facilement sans problème accès on va dire, on a en tout cas un regard si vous voulez sur comment est conçu ce dernier et donc sur les différentes fonctionnalités bas niveau d'accord de ce dernier.

C'est à dire qu'on ne va pas forcément avoir besoin de passer par des ... alors j'allais dire des couches d'abstraction mais en fait si en réalité puisqu'on on ne s'amuse pas directement à manipuler le noyau au coeur même de lui-même en fait, on a quand même un minimum de couche d'abstraction mais en tout cas on est vraiment vraiment très très très très proches et on va pouvoir faire ce qu'on appelle des appels système.

On va utiliser des fonctions directement du noyau d'accord on n'est pas comme en c où on utilise un printf() pour afficher quelque chose qui derrière printf() lui va faire des appels système bref va se débrouiller avec le compilateur pour faire tout ce qu'il faut au niveau du système et avoir d'ailleurs comme vous savez un code un peu plus portable aussi.

Ici on est directement sur les appels système, les appels du noyau pour linux d'accord donc forcément il ya toute une documentation pour trouver ça.

Le code est disponible, on peut retrouver toute documentation que l'on voudrait concernant le noyau linux et comment le manipuler, comment travailler avec quand on est en langage assembleur.

Donc ici je vais utiliser une instruction mov qui va permettre donc de faire des déplacements de données, vous verez un petit peu tout ça par la suite alors on va travailler en 64 bits. On ne va pas se tromper ici.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov
```

Je vais travailler sur un registre, voyez je sort comme ça des termes qu'on va évidemment voir dans le détail tout au long de ce cours et je vais placer directement donc enfin en tout cas dans ce registre la valeur de 1 qui est en fait correspondant à l'appel système write.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
```

write est une fonction donc du noyau qui va nous permettre d'afficher quelque chose en mode console d'accord notamment ce petit 'hello world !' très important.

Ce write donc cette fonction prend des arguments, elle attend des arguments pour pouvoir fonctionner donc je vais les passer un premier argument.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi,
```

Ici il va lui falloir notamment le descripteur utilisée c'est à dire sur quels fonds nous allons lire.

Moi je veux lire et ça ça va vous parler si vous avez fait bien sûr, que vous allez suivre le cours GNU-linux sur mon descripteur de fichier dont notamment la sortie standard.

La sortie standard est ce qu'on appelle stdout d'accord et ici son code c'est tout simplement 1.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
```

Même chose 1 et 1, on ne peut pas se tromper ok.

Ensuite notre autre argument ça va être tout simplement notre message donc c'est ça, rsi.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
```

Et ensuite en dernier ça va être la taille de ce message.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx,
```

On avait 13 caractères si j'ai bien compté tout à l'heure et il faut bien sûr le caractère de fin pour une chaîne de caractères, ça c'est le petit rappel à ceux qui font de la programmation bien évidemment donc là je vais mettre ça et je vais indiquer +1 à la suite comme ça je décompose pour qu'on voit que 13+1 c'est la longueur de cette chaîne 'hello world !'.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1
```

Alors on verra plus tard qu'il y a des moyens de calculer ça de manière dynamique et on n'est pas obligé de mettre 13+1 en brut mais bien sûr le but c'est de faire un code assez simple d'accord j'essaie de ne pas trop faire compliqué avec des raccourcis tout ça pour le moment ou de passer par des macros ou que sais-je.

Là je reste assez simple dans les dans les instructions pour que ce soit assez logique.

Et à partir de là on va faire appel au noyau avec un syscall.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1
			syscall
```

syscall fait appel au noyau, va nettoyer les registres et va donc analysé en fait tout ce qui a été fait ici dans les registres ...

			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1

... pour exécuter éventuellement une opération bien précises, un traitement bien précis donc là par rapport au positionnement qu'on a fait il va se passer quelque chose notamment ici l'affichage de notre message et comme je vais terminer les choses proprement on va faire appel à exit qui va permettre tout simplement de quitter proprement ici l'exécution de notre programmes.

A nouveau au niveau de l'accumulateur je vais me placer cette fois à 60 pour exit càd en 64 bits c'est ça donc c'est 60 parce que vous verrez qu'entre le 32 et le 64 c'est pas les mêmes codes donc de toutes façon si je me suis trompé je verrais très très vite à  l'assemblage les erreurs que j'aurais pu faire.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1
			syscall

			mov rax, 60
```

On fait un petit rdi à qui je passe le zéro directement donc on va faire ça.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1
			syscall

			mov rax, 60
			mov rdi, 0
```

Et on refait un appel directement au kernell donc au noyau avec syscall directement voilà.

a64.asm
```asm
	bits 64

	section .data
		message db 'hello world !', 10

	section .text
		global _start
		_start:
			mov rax, 1
			mov rdi, 1
			mov rsi, message
			mov rdx, 13+1
			syscall

			mov rax, 60
			mov rdi, 0
			syscall
```

Ceci en gros affiche le message via l'appel système write, ceci ...

			mov rax, 60
			mov rdi, 0
			syscall
			
... quitte le programme via l'appel système exit voilà un petit peu comment ça fonctionne donc mine de rien même si vous ne comprenez pas ce code et même si vous n'avez pas forcément compris mes explications avec les commentaires que j'ai pu donner déjà vous voyez un petit peu je pense que certains d'entre vous ont déjà un petit peu compris comment ça s'articule et
comment ça s'articulait, comment ça se structurait.

Ca vous a apporté quelques éléments et tant mieux comme ça vous voyez un petit peu à quoi ça ressemble ça vous indique un petit peu quelques petites choses.

Ca, data, text, normalement il me manque rien.

Très bien on y va et on va assembler maintenant ce dernier de façon si j'ai fait une erreur quelque part on va très très vite le voir.

Voilà on va utiliser notre assembleur NASM donc c'est très simple ici il va falloir produire en tout cas passer par un format assez particulier sur les distributions linux, bsd, tout ça on travaille avec un format elf.

Je ne rentre pas tellement dans le détail là dessus parce qu'on n'a pas encore abordé les différentes formats, le fonctionnement de la mémoire, tout ça.

On fera tout ça par la suite mais sachez que pour ce système là on utilise le format elf et comme on est en 64 bits, on va travailler avec le elf64 donc on utilise -f pour choisir le format elf64 pour évidemment assembler dans le bon format.

```bash
	nasm -f elf64
```

On veut produire un code en 64 bits, ne pas se tromper et on lui passe le fichier en question que j'avais appelé a64.asm et j'indique ensuite en argument -o le nom que je donne au fichier de sortie et je veux qu'il ait l'extension o puisque ld attend un fichier avec l'extension o donc c'est très bien de travailler avec ça donc on va lui donner le bon format directement, la bonne extension il sera content donc on met a64.o

```bash
	nasm -f elf64 a64.asm -o a64.o
```

Voilà on fait ça et a priori pas d'erreur au niveau de
l'assemblage.

```bash
	sam@sam:~/Bureau$ nasm -f elf64 a64.asm -o a64.o
```

Donc là à priori pas d'erreur au niveau de l'assemblage donc ça à l'air d'être assemblé comme il faut après ça ne veux pas dire que le code est bon, on verra.

Maintenant on a obtenu notre fichier objet, notre fichier .o ici.

```bash
	a64.o
```

Il est bien là pas de problème.

On va pouvoir lier ce dernier donc là, il n'y en qu'un seul de toute façon c'est assez simple pour obtenir notre programme final.

L'avantage, ça vous comprendrez par la suite avec ce que nous verrons, on pourrait parfaitement créer des fichiers .o avec d'autres langages.

Il y a peut-être des gens d'ailleurs un jour qui en c, en c++ se sont amusés à classer un petit peu les étapes pour la compilation, le processing, l'édition de lien au niveau de la programmation de ce qu'il faisait et ont pu obtenir des fichiers .o dans d'autres langages.

Après on pourrait parfaitement après évidemment faux que tout fonctionne ensemble mais avoir plusieurs fichiers .o produits par différents langages et ensuite lier tout ça ensemble pour obtenir un programme qui a été construit finalement et plusieurs langages différents.

C'est quelque chose qu'on fait assez couramment et je vous l'avais expliqué par exemple dans le langage d'assembleur, on ne va pas forcément tout coder un programme en langage assembleur.

On peut coder en c, c'est ce qu'ont fait principalement et
après quand on a besoin de partie critiques ou besoin de parties bien précises ou même des fois obligatoire quand on travaille sur des créations de driver ou autre en langage assembleur et bien on va tout simplement faire ça en langage assembleur mais garder le reste en c.

C'est tout à fait une application possible même si on va quand même se concentrer un maximum sur le langage assembleur puisque il ya déjà un cours en c sur la chaîne donc si vous voulez faire du c, il n'y a pas de problème non plus.

Ok donc on y va, on va faire ça donc ld, c'est très simple il attend notre fichier objets d'accord et moi je lui passe le fichier final.

```bash
	ld a64.o
```

Comme on est sur linux, je ne lui met pas d'extension dont je vais l'appeler simplement a64 voilà.

```bash
	ld a64.o -o a64
```

Normalement on a obtenu un fichier a64. Vérifiez bien sûr au niveau des permissions qu'il est bien exécutable, normalement il n'y a pas de raison mais si jamais vous voyez que ça ne s'exécute pas, il faudra changer les permissions à ce niveau là.

Et on a plus qu'à l'exécuter et voilà.

```bash
	sam@sam:~/Bureau$ ./a64
	hello world !
```

Ecouter ça n'a pas planté donc à priori c'est bon, de toute façon il n'y a pas de raison normalement, je n'ai pas vu d'erreur là-dessus donc il n'y a pas de raison que ce soit faux mais comme j'enregistre on n'est jamais à l'abri d'une erreur d'une faute de frappe, d'inattention, n'importe quoi.

Voilà notre premier programme en langage assembleur x64 d'accord 64 bits est fait.

Vous savez ça même si bien sûr à ce stade logiquement vous ne comprenez pas grand chose de ce code mais c'est
normal vous allez apprendre à comprendre et à faire tout ça vous même par la suite et on verra bien sûr beaucoup plus que ça.

Là on est sur quelque chose encore une fois d'assez simple à ce niveau là voilà.

Voilà pour le 64 bits, passons au 32 donc je prends le temps encore une fois, c'est une vidéo que vous pouvez regarder en plus leur fois etc etc. Pas de problème.

Alors ça je ne vais même pas faire un copier coller, ça va éviter de faire des bêtises.

On va simplement indiquer bits 32 ici.

a32.asm
```asm
	bits 32
```

section data donc pas de changement à ce niveau là je vais reprendre la même chose ici on va remettre 'hello world !' et le petit retour à la ligne qui va bien (, 10).

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10
```

ok section texte ici puis start, je n'oublie pas les deux
points comme j'ai fait tout à l'heure et c'est bon.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
```

Voilà pour le 32 bits c'est un petit peu différent parce qu'on va travailler sur d'autres registres parce que selon l'architecture qu'on a, eh bien on n'a pas les même registre comme vous allez l'apprendre par la suite en fonction de l'architecturé.

Donc là toujours pareil, même principe, on va faire appel à la fonction write et ensuite la fonction exit donc c'est toujours les mêmes fonctions du noyau parce que le noyau lui ne change pas, c'est toujours le noyau linux donc même si on change d'architecture le noyau c'est le même donc tout fonctionne pareil.

C'est juste que la syntaxe utilisée du langage assembleur va varier.

Je me place via mon registre d'accumulateurs sur cette fois ci non pas le code 1 mais le code 4 qui correspond donc cette fois ci au code de write en 32 bits très important.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
```

Et on refait tout pareil comme tout à l'heure, on fait ebx.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx
```

J'utilise le descripteur stdout donc c'est la sortie standard au niveau de la console.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
```

Je passe ensuite le message donc c'est ce qu'on a mis avant je rappel.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
```

Et en dernier c'est la taille donc c'était 13+1.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1
```

Et cette fois-ci puisqu'on est en 32 bits, on ne peut pas faire directement un syscall puisque ça a évolué, il faut directement non pas faire un syscall mais une interruption de code 80 en hexadécimal qui dis tout simplement de faire appel directement au noyau, nettoyer les registres et c'est reparti donc c'est l'équivalent du syscall que l'on ferais en 64 bits et en 32 bits on faits une interruption.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1
			int 0x80
```

Même chose cette fois-ci à adapter pour exit donc cette
fois ci le code exit bon là c'était 60 mais là pas de bol c'est 1.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1
			int 0x80

			mov eax, 1
```

Et on fait un petit peu ebx de 0 puisque ça ça ne change pas le paramètre passé, je le garde à zéro, je ne le veux pas.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1
			int 0x80

			mov eax, 1
			mov ebx, 0
```

Et on verra bien sûr tout ça, on verra write, etc, exit, comment je connais les paramètres vous verez que je ne les invente pas mais on verra tout ça dans le détail par la suite, ne vous inquiétez pas et ici appel au noyau derrière.

a32.asm
```asm
	bits 32

	section .data
		message db 'Hello World !', 10

	section .text
		global _start
		_start:
			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1
			int 0x80

			mov eax, 1
			mov ebx, 0
			int 0x80
```

Vous voyez je fais tout, je place tout ce qu'il faut dans les registres ...

			mov eax, 4
			mov ebx, 1
			mov ecx, message
			mov edx, 13+1

... une interruption (int 0x80), appel au noyau ça fait ce qu'il faut ici et ensuite repareil appel au noyau int 0x80) et pourrait utiliser éventuellement les registres par la suite pas de problème parce que vous verrez qu'il y a des registres qui sont réservées et d'autres qui sont préservés d'autres non bref des registres volatiles, plein de choses qu'on va apprendre, qu'on va voir  ensemble et que nous allons aborder au cours de cette formation.

Voilà alors là petite particularité parce que certes je  suis sur un système 64 bits, je vous ai dit que sur du 64 bits on peut exécuter du programme exécutable en 32 bits d'accord ça fonctionne parce que c'est une extension mais on va avoir besoin de rajouter un petit argument quand on va faire la liaison sinon il ne va pas être content parce qu'il va me dire que ... d'ailleurs là je laisserais comme ça vous verez un petit peu pourquoi et un petit peu ce qui se passe.

On va reprendre la même commande donc là voyez alors c'est tout pareil sauf que vous mettez 32 puisque c'est 32 bites, je les appelés justement comme ça pour les différencier.

```bash
	sam@sam:~/Bureau$ nasm -f elf32 a32.asm -o a32.o
```

Et là pour ld, il va y avoir un petit changement ici alors c'est ld -m d'accord l'argument pour indiquer en fait qu'on veut produire d'accord pour une architecture 32 bits.

On veux un code en 32 bits c'est important parce que sinon la liaison ne fonctionnera pas.

Si je ne mets pas parce que si je ne met pas càd que je fait juste ça.

```bash
	sam@sam:~/Bureau$ ld a32.o -o a64
	ld : architecture i386 du fichier d'entrée « a32.o » est incompatible avec la sortie i386:x86-64
```

Voilà ce qu'il va nous retourner bon à priori j'ai pas fait d'erreur et il nous dit voilà c'est incompatible avec la sortie i386:x86-64 qu'en gros bah c'est pas compatible ici donc l' architecture 32 bits n'est pas compatible avec l'architectures 64.

Oui parce qu'elles sont différentes donc ce n'est pas parce que 64 et l'extension 32 cas qu'elles sont forcément identiques évidemment donc on va manuellement indiqué ici un autre lieur qu'on veut vraiment vraiment exécuter pour la partie 32 bits donc de notre système 64 bits, on veut avoir ce format là.

Et normalement c'est un elf_i386_ puisque c'est ce qui est indiqué ici donc ça ça dépend encore une fois des identifiants, des processeurs qu'il y avait à l'époque donc normalement c'est ça l'arguments.

```bash
	sam@sam:~/Bureau$ ld -m elf_i386 a32.o -o a32
```

Moi principalement je fait que du 64 bits, du 32 bits j'en fais quand même très très peu donc avec ld ça a l'air d'être bon.

Est-ce que ça produit un exécutable 32 et est-ce que maintenant ça marche ? on va donc vite le savoir.

```bash
	sam@sam:~/Bureau$  ./a32
	Hello World !
```

Et ça a l'air de fonctionner voilà voilà donc comme ça vous avez un petit peu la différence entre les deux donc encore une fois si vous êtes sur du systèmes 32 bits c'est ce code là qui va vous intéresser.

Si vous êtes sûr de 64 je vous recommande bien sûr de faire du 64 d'accord ne faites pas du 32 si vous êtes sur 64 sauf si vous avez une raison que c'est volontaire et que vous savez pourquoi vous le fait d'accord mais vous êtes sur un système 64 donc profiter de ce que ça apporte en termes de fonctionnalités c'est quand même ça qui est intéressant.

Voilà pour la partie gnu linux donc c'est bien ça fait une demi heure donc c'est assez cool on a on a fait une bonne partie à ce niveau là et nous allons pouvoir passer à windows.

D'accord alors je vais d'ailleurs volontairement fermé tout ça, je ne vais pas laisser tourner pour rien.

Pour windows c'est un peu particulier puisque à la différence du noyau linux nous sommes sur un système qui est propriétaire donc même si microsoft fait un peu dans l'open source même s'il ya des programmes des applications qu'ils font qu'ils le sont pour autant windows n'est pas open source vous ne pouvez pas récupérer, obtenir en tout cas à moins bon il y a des entreprises où bien sûr qu'ils ont mais c'est des cas très particulier et c'est pour des raisons bien particulière aussi.

Mais vous ne pouvez pas demander à consulter le code de windows, du système windows.

Donc automatiquement comme microsoft n'autorise pas là on va dire la manipulation et ce n'est pas vraiment exact, direct du système et de son noyau il propose une api d'accord c'est une bibliothèque en fait qui permet de faire via une couche d'attraction appel à des fonctions d'accord pour faire des appels système si vous voulez mais ce qu'autorise microsoft voilà.

Vous ne pouvez pas faire plus que ce qu'autorise microsoft mais voilà au minima en tout cas ce que permet cette api et nous allons donc utiliser l'api de windows d'accord la win api telle qu'on l'appelle plus communément.

C'est ce que nous allons faire.

Ici on y va, on va passer là, on va créer nos fichiers comme tout à l'heure. Ici on va voir un petit peu je vais voir parce que j'ai un doute je ne suis pas sûr que ça fonctionne mais généralement pour Windows utiliser le lieur ld c'est pas très pratique d'accord il a surtout été conçu pour linux donc c'était surtout pour ça donc ce n'est pas le top on va dire pour de windows.

Donc éventuellement vous pouvez encore installer golink.exe éventuellement mais on va quand même tester avec ld parce que peut-être que java va le faire fonctionner mais dans tous les cas bon ça ne fera pas de mal de tester un autre éditeur, un autre lieur éventuellement de toute façon si vous n'êtes que sur du windows bon bah vous en installerez qu'un seul et vous verrez.

On testera avec ld quand même mais sinon on fera on fera avec golink.


golink normalement on peut le retrouver de toute façon ici, le site est assez vieux.

@http://godevtool.com/

Voilà ce site là et normalement vous pouvez le retrouver.

vous pouvez comme ça le retrouver alors je ne l'ai pas récupéré en installateur, j'ai juste récupéré l'exécutable parce qu'il falait l'installer sur mon système et vous pouvez le récupérer-là.

	Linker
	-> Download GoLink version 1.0.3.1 (with documentation 45K)

voilà GoLink donc c'est très petit donc si vous en avez besoin vous pouvez le récupérer donc je vous conseil de le récupérer parce que pas sûr que je puisse faire fonctionner ld comme je vous dis ce n'est pas très pratique sur windows donc de toute façon je montrerai la manip aussi avec GoLink comme ça je montrerais les deux.

On va voir avec ld pour savoir si ça fonctionne et on fera de toute façon avec GoLink puisque c'est vraiment beaucoup plus pratique pour lier sur windows.

Voilà on y va, on va créer nos deux fichiers également donc même chose, sur windows petite particularité les extensions ne sont pas affichées par défaut si vous ne le savez pas faire.

Dans ma playlist windows tutoriel, vous avez une petite vidéo sur comment afficher les extensions sur windows comme ça vous verrez.

On va commencer par le a64.asm bien sûr évidemment et on fera aussi pour le 32 bits donc système de 64 bits ici comme pour linux donc pas de problème hop.

	a32.asm
	a64.asm

Là on va devoir passer par l'api et évidemment je ne vais pas montrer en détail ou parce que encore une fois c'est cette séance n'est pas faites pour vous montrer en détail chaque chose. J'écrit juste du code que je commente et on verra tout ça par la suite et encore une fois vous verrez les paramètres des différentes fonctions utilisées comme je le fais pour write et exit avec linux.

Pour Windows on a d'autres fonctions et encore une fois je n'invente pas les fonctions ou les paramètres qu'elles attendent ou les arguments qu'elles attendent tout ça bien sûr est documenté et je vous montrerait où trouver toutes ces informations là parce que de toute façon vous en avez. Je ne vais pas l'inventer et je ne peux pas le deviner.

Il faut forcément avoir la documentation et ça va beaucoup être de ça.

De toute façon quand on programme en langage assembleur, il faut tout un tas documentation ne serait ce que pour le micro processeur sur lequel vous êtes pour savoir comment ils fonctionnent donc son architecture, pour avoir connaissance des registres, pour avoir connaissance évidemment des flags, de tout ça, de tout ce qu'il propose d'accord tout ce que vous allez pouvoir utiliser et après en fonction du système sur lequel vous êtes.

Il faut voir aussi les différentes fonctions disponibles si vous êtes sur linus, l'api Windows si vous êtes sur Windows et c'est exactement la même chose pour mac os de toute manière d'accord.

Encore une fois c'est issu de documentation qui sont bien sûr public pour le coup que nous retrouvons en ligne, sur les sites officiels tout ça. Il n'y a pas de problème.

On y va alors pour windows très simplement je vais a indiqué qu'on est en 64 bits parce qu'on va commencer par celui là.

a64.asm
```asm
	
```

On y va et ici encore une fois j'utilise donc l'api de windows donc je faire appel à des fonctions de windows donc je vais en avoir besoin de 3.

Comme elles sont donc issus de l'api de windows, elles n'appartiennent pas directement au langage assembleur donc je vais aller le chercher depuis une portée extérieur donc j'utilise cette instruction externe et je fais appel aux différentes fonctions que je vais avoir besoins.

Cela va me permettre d'avoir un gestionnaire donc pour tout ce qui est en fait écriture, lecture, etc.

a64.asm
```asm
	bits 64

	extern GetStdHandle
```

Il va falloir travailler avec un gestionnaire et donc j'ai besoin de celle ci.

Je vais avoir besoin également de l'affichage en console; on a un mode Ansi qu'on peut éventuellement utilisés.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
```

On le fait assez généralement ça, on a le mode unicode aussi.

Donc je vais garder l'habitude d'utiliser la version Ansi et on va travailler avec ExitProcess pour pouvoir quitter notre programme proprement donc il nous faut ces trois là.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
```
	
Comme ça on aura tout ce qu'il faut à ce niveau là.

On est parti dans la section data et on constate que la coloration syntaxique change d'un os à l'autre avec la même extension et le même éditeur ok.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db
```

Donc db puis 'Hello World !' donc là pas de changement, même information et ,10 parce que je veux un retour à la ligne.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10
```

C'est ok, pas de problème.

Par contre là comme ces fonctions ...

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
...bien sûr ont des arguments différents, ça n'a rien avoir avec write et exit sur linux.

Il ya des cas particuliers donc j'aurai besoin de réserver des emplacements mémoire  donc ce ne sont pas des données qui sont déjà en fait initialisé comme des constantes, ce genre de choses et je dois travailler dans un autre segment donc une autre section qui est bss et bien sûr tout ça vous sera aussi expliqué, présenté en détail dans ce cours.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
```

Je vais l'appeler written puisque c'est généralement le nom pour WriteConsoleA, il me semble.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written
```

Je vais donc format rescue puisqu'on en 64 bits et pas que je me trompe.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1
```

Et ici j'ai besoin d'une valeur de 1, il me faut 1 octet.

Ce n'est pas 1 octet d'ailleurs parce que c'est resq donc ce n'est pas un octet mais c'est q word mais on verra tout ça par la suite aussi. Je ne vais pas trop m'attarder là-dessus sinon je vais vous perdre un petit peu.

On y va et on passe cette fois-ci par le segment text et on va mettre global _start, _start pour essayer de lier avec ld parce que j'ai toujours prit l'habitude sur Windows avec GoLink mais peut être qu'il y a moyen avec ld, on testera de toute façon.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
```

On se place comme d'habitude en portée globale pour que le lieur puisse trouver, je l'appelle _start puisque le lieur s'attend à ce nom là précisément par défaut, on ne s'embête pas et on y va.

On se place sur un registre ici, rcx, alors pas se tromper par contre ça va me servir pour pouvoir utiliser directement la sortie standard avec GetStdHandle d'accord et je sais que ça correspond à -11 donc pas de problème à ce niveau là.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
```

Et ensuite on va pouvoir directement faire un appel donc encore une fois ce ne sont pas des appels système directement à proprement parler comme sur linux.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call
```

Je fais simplement ici appel à quelque chose d'externes donc ça fait partie de l'api de windows et je vais appeler GetStdHandle donc ça 'mov rcx, -11' c'est en fait l'argument qu'elle attend voilà.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
```

-11, c'est en fait pour récupérer en fait un gestionnaire pour la sortie standard en mode console et ensuite je fais appel à GetStdHandle par rapport à ce registre.

Première étape.

Maintenant on est sur de la programmation 64 bits donc en 64 bits sur windows parce que on ne fait pas toujours les choses simplement selon son architecture et son système il faut avoir un alignement de la pile qui correspondent.

Et cet aliment de la pile d'abord il va falloir donc l'appliquer sur un registre de pile prévu pour ça.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
```

32 c'est pas moi qui l'invente encore une fois, il ne faut pas le deviner c'est comme ça d'accord il ya des règles en fait, des conventions des normes à suivre au niveau des architectures qu'on retrouve dans les documentations encore vous apprendrez à chercher toutes ces informations là quand vous aurez besoin de les connaître et les utiliser.

Et ensuite il faut se réaligner par rapport à 16 donc ça va être rsp de 8.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
```

ok ensuite je vais espacer parce que cela concerne surtout pour l'alignement et comme il va faloir réaligner correctement par la suite, je le fait d'avance rsp donc pour remettre la pile, en fait le nettoyage de la pile simplement donc ça va être les deux donc 32+8.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			
			
			add rsp, 32+8
```

Donc ça c'est pour faire des décalages (rsp), pour aligner la pile comme il faut parce que sur windows en 64 bits vous verrez pourquoi par la suite il faut le faire mais je vous expliquerai en détail pourquoi.

Ok on est là, on y va, on attaque maintenant pour WriteConsoleA qui possède beaucoup plus d'arguments c'est assez compliqué quand on ne connaît pas donc ici il nous faut rcx, rax.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			
			
			
			add rsp, 32+8
```

ça c'est pour le premier.

Ensuite il va falloir le message donc rdx ça va être le message ceci.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			
			
			
			add rsp, 32+8
```

Ensuite on a deux autres arguments donc ils seront passés dans r8 et dans r9 puisque c'est l'ordre en fait des conventions d'appel pour windows ici notamment en 64 bits.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8,
			mov r9,			
			
			add rsp, 32+8
```

Voilà on va suivre les conventions, on ne va pas commencer à faire n'importe quoi.

Alors ici 13 caractères par contre je crois qu'il prend le retour à la ligne, le caractère de de terminaison, je crois qu'il ne le compte pas. Je crois qu'il faut mettre juste 13 [mov r8, 13].

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,			
			
			add rsp, 32+8
```

Pour windows ça change entre les deux donc je crois que c'est 13, pas besoin de mettre un 14e, il ajoute lui même en fait le symbole de terminaison de chaîne.

Bon on verra je vais laisser 13 mais normalement ça suffit.

r9, c'est tout simplement ce qui a été écrit donc c'est written, la partie qu'il fallait réserver donc c'est un pointeur pour ceux qui font de la programmation en c ou autre c'est un pointeur en fait voilà. C'est un pointeur, c'est un d-word donc c'est un double mot pour être exacte mais si encore une fois vous ne connaissez pas le langage assembleur vous ne savez absolument pas ce que je raconte mais c'est pas grave.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
>			mov r9,	written		
			
			add rsp, 32+8
```

Et nous avons ce qu'il faut.

C'est pas tout, il ne manque que le dernier élément donc je ne vais pas faire grand chose il faut juste que je réserve un qworld et je me sers bien sûr de ce que j'avais récupéré sur la pile, je réaligne de l'autre côté dans je fais un +32.

	mov qword [rsp+32],

Et c'est 0 voilà parce que les autres arguments en fait sont placés directement empilé sur la pile quand on a utilisé les registres rcx, r8, r9 donc au prochain pas sur la pile.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			
			add rsp, 32+8
```

On fait enfin un appel de WriteConsoleA et voilà.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
```

Et on termine donc là j'ai fait mon nettoyage de pile et enfin histoire de faire les choses dans l'ordre, on se replace mais cette fois je vais utiliser ecx parce que je veux utiliser un registre 32 pas besoin de forcément de le faire plus gros que ça de toute façon c'est pour faire 0 donc je ne suis pas obligé de le faire sur rcx.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
>			mov ecx, 0 ; rcx
```

En 64 bits voilà comprenez plus tard qu'on aura rcx parce qu'on l'avait utilisée ici plus haut, 'mov rcx, -11'. C'est un cas particulier mais là pour changer un peu on va utiliser ecx, on va faire ça mais même mieux on va faire ça comme on veux faire une initialisation à 0 on va le faire sur le registre en lui-même hop.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
>			xor ecx, ecx
```

'xor ecx, ecx', mettre en petit commentaire donc dans ecx c'est en fait un ou exclusif d'accord donc entre ecx et lui même voilà.

			xor ecx, ecx ; ecx <-

Et on termine par un appel à ça.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
		global _start
		_start:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Alors avant d'assembler, un argument pour GetStdHandle c'est bon, ça c'est pour l'alignement, les deux sont là.

			sub rsp, 32
			...
			add rsp, 32+8
			
Il a bien les 5 arguments ici.
			
			...
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			...

Ensuite WriteConsoleA et un argument pour ExitProcess après relancer les bons registres et maintenant ça m'a l'air d'être ok.

J'ai publié ici _start ... global ... .text, .bss, .data très bien.

Comme tout à l'air bon, à priori pas de problème ici.

Maintenant parce que l'on fait les malins mais il s'agit d'assembler ça alors l'assemblage ça ne va pas poser de problème c'est nasm mais moi évidemment il est déjà installé sur mon système.

Evidemment il est déjà insisté sur mon système et si vous voulez l'installer sur Windows mais vous allez sur le site de nasm que j'ai montré d'ailleurs sur linux et vous le téléchargez. C'est une application a installer.

Eventuellement si ce n'est pas fait automatiquement, il le fait automatiquement et vous ajoutez bien sûr le chemin vers les binaires à la variable d'environnement PATH de windows.

Si vous ne savait pas comment faire dans la playlist windows tutoriel, vous avez également une petite vidéo aide pour ajouter un chemin sur la variable d'environnement PATH pour savoir comment faire donc encore une fois pas d'excuses tout est sur la chaîne, vous avez tout qui est détaillé.

Alors ici le format pour windows ça va être très simple, c'est win64 comme on est en 64 bits, ne pas se tromper.

```powershell
	nasm -f win64
```

Par contre alors on va travailler avec ld, on va travailler avec un format, une extension .o également.

On va faire ça comme ça.

```powershell
	nasm -f win64 a64.asm -o a64.o
```

Ca normalement ça ne va pas me poser de problème, il va dire ok par contre là pas sûr que ça marche et je vous dis que si ça ne marche pas de toute façon je vous montrerais avec GoLink.

On fera ça avec GoLink aussi.

Alors ld puis -e _start bien que _start c'est surtout pour linux mais ici j'ai utilisé _start parce que c'est ce qu'il attend lui voilà.

```powershell
	ld -e _start
```

Et nous allons parce que ça je peux vous en parler, l'expliquer donc ça...

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

... ça fait partie de l'Api windows c'est à dire que windows au minimum pour ses fonctions système a en fait des bibliothèques d'accord qui sont disponibles.

Il y en a une qui s'appelle kernell 32, il y en a une autre qui est User 32 et éventuellement on verra plus tard qui est aussi GDI 32 dont on peut se servir même en 64 bits d'accord.

ç possède du 32 c'est pour des questions de rétrocompatibilité mais on a ces différentes bibliothèques qui sont disponibles sur votre système bien évidemment et c'est issus de ces bibliothèques là qu'on se sert de ces fonctions d'accord, c'est dans ces bibliothèques donc notamment kernell 32 qu'on a ces fonctions-là qui existent.

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

... donc on peut comme ça utiliser via cette api là dans notre langage assembleur puisque encore une fois comme je vous l'ai dis windows est propriétaire donc on ne peut pas s'amuser à directement faire appel au noyau tout ça. Non c'est windows qui gère via son api et il vous laisse faire que ce qu'il vous autorise à faire en tout cas microsoft puisque c'est leur système donc c'est surtout ça.

Ici donc comme c'est de l'édition de lien, je vais lui passer kernell 32.

```powershell
		ld -e _start a64.o -l kernell32
```

Alors on peut tout collé, je rappelle pour ceux qui ont déjà fait ça en commande.

```powershell
		ld -e _start a64.o -lkernell32
```

Mais moi je prend toujours l'habitude de séparer.

kernell 32, pas besoin de spécifier le format et le fichier on va l'appeler a64.exe sur windows.

```powershell
		ld -e _start a64.o -l kernell32 -o a64.exe
```

On y va.

```powershell
	>ld -e _start a64.o -l kernell32 -o a64.exe
	a64.o: file not recognized: file format not recognized
```

Pas grave je voulais tester quand même, je voulais quand même regarder donc je vais laisser le nom _start de toute façon ou alors je vais mettre main pour changer un peu, de toute façon on ne va pas utiliser ld.

a64.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	
	section .data
		message db 'Hello World !', 10
	
	section .bss
		written resq 1
	
	section .text
>		global main
>		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

On change _start en main de toute façon on ne peux pas utiliser ld alors je vais faire ça et on va refaire ça correctement.

```powershell
	nasm -f win64 a64.asm -o a64.o
	-> nasm -f win64 a64.asm -o a64.obj
```

Donc là il faut un format .obj enfin une extension .obj parce que c'est ce que reconnaît GoLink donc on fait ça d'accord.

On assemble.

```powershell
	nasm -f win64 a64.asm -o a64.obj
```

hop on assemble et ensuite vous utiliserez GoLink c'est à dire que si vous faites comme moi ça veux dire que vous ne l'installez pas directement sur le système hé bien il suffit de passer son exécutables parce que vous voyez c'est tout petit même pas 50 ko, tout petit tout petit.

GoLink, vous le mettez au niveau en fait de votre programme comme ça vous n'avez pas besoin de le mettre dans votre système, l'installer tout ça, c'est juste un exécutable stand alone, qui est tout seul en fait ici.

Et il n'y a plus qu'à taper parce qu'on est un bon répertoire ./golink.exe, .exe si je suis sur la console powershell et là il nous faut notre fichier .obj très important.

```powershell
	golink.exe a64.obj
```

Il nous faut spécifier l'entrée donc c'est un slash, il utilise un slash pour ses arguments, /entry.

```powershell
	golink.exe a64.obj /entry
```

Et je l'ai appelé main.

```powershell
	golink.exe a64.obj /entry main
```

Je suis en mode console donc pour l'interface graphique c'est slash console voilà.

```powershell
	golink.exe a64.obj /entry main /console
```

Et ensuite on indique toutes les bibliothèques qu'on va utiliser de windows et normalement là pour le coup Golink ne va pas poser de problème puisqu'il suffit d'indiquer non pas kernel mais kernel32 et ne pas oublié d'indiquer par contre les extensions.

```powershell
	golink.exe a64.obj /entry main /console kernel32.dll
```

Et il nous faut user32.dll mais je ne suis pas sûr qu'on en ai besoin.

```powershell
	golink.exe a64.obj /entry main /console kernel32.dll user32.dll
```

Pour ne pas ajouter des choses inutiles, je crois que user32.dll n'est même pas obligatoire.

```powershell
	golink.exe a64.obj /entry main /console kernel32.dll
```

hum voilà on a notre exécutable qui est là. Voilà on a notre exécutable et on n'a pas encore fait de saisie au clavier donc ça va être suffisant.

```powershell
	>nasm -f win64 a64.asm -o a64.obj
	>golink.exe a64.obj /entry main /console kernel32.dll

		GoLink.Exe Version 1.0.3.1  Copyright Jeremy Gordon 2002-2020   info@goprog.com
		Output file: a64.exe
		Format: X64   Size: 2,048 bytes

	>a64
	Hello World !
```

Voilà effectivement le 13 était suffisant, la console ajoute automatiquement le caractère de fin pour la chaîne donc c'est ok pas de problème.

Voyez entre linux et windows, il faut faire attention. Il y en a un qui le compte et l'autre qui ne le compte pas donc il faut faire attention mais de toute façon une fois que vous testez votre programme, vous verrez s'il y a un retour à la ligne qui ne se fait pas c'est que vous avez oublié de compter un caractère pour la longueur de votre chaîne donc ici il est bien ajouté, pas de problème.

Ok donc voici le programme en 64 bits pour windows.

On utilise Golink pour le lieur et on va passer pour la version 32.

La version 32 c'est pour le coup un petit peu plus casse-pied après c'est un avis subjectif, ça me regarde que moi.

Autant sur linux c'était peut-être plus pratique on va dire et encore sur linux 32 et 64 ça va mais sur windows c'est vrai que le 32 bits c'était pas la joie au niveau des termes parce que l'Api n'était pas la même voilà ils ont essayé un petit peu de l'améliorer pour rendre ça plus pratique à utiliser mais vous allez voir qu'en 32 bits c'est un peu plus chiant.

On passe en bits 32 cette fois ci.

	a32.asm
```asm
	bits 32
```

Et là les fonctions utilisées ne sont pas exactement les mêmes en tout cas ne porte pas les mêmes nom.

Ici quand on est sur une architecture 32 bits, qu'on veut génère un code en 32 bits, il fallait les faire précéder d'un underscore donc là le nom ne change pas, _GetStdHandle.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle
```

Et ensuite il fallait indiquer via un @ le nombre d'arguments que ça prend, c'est exactement en fait la taille par rapport à la taille des arguments donc c'est par rapport au nombre d'octets mais je ne vais pas encore une fois vous faire le détail du code que je montre. C'est pas le but comme je vous l'ai rappeler sur cette vidéo donc ici c'est 4 parce qu'on a qu'un argument.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
```

Ensuite on a _WriteConsoleA@, ici on en a cinq donc c'est 5 x 4 donc 20, on est bon.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
```

Ensuite on a _ExitProcess@ et lui n'en a qu'un seul donc c'est 4.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
```

Puis section .data, c'est toujours pareil et non pas db pour data base, on verra plus tard. Le message 'Hello World !' et le retour à la ligne, 10.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
```

C'est ok, ensuite .bss, il adapter bien sûr maintenant que vous avez compris entre le 32 et le 64 bits, vous avez compris que les registres vont changer même si vous ne savez peut-être pas du tout ce qu'est un registre à ce stade mais c'est pas grave.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
```

Vous avez vu tout à l'heure sur linux, je n'utilisais pas les mêmes noms de registre dans les moves, les mov.

Je vais l'appeler toujours written mais cette fois ci c'est en resd car on est en 32 bits et c'est toujours 1 puisqu'il me faut que 1 et non pas 1 octet parce que c'est un double ... je vais y arriver ... c'est un mot double et pas un mot simple donc attention donc il n'y a pas qu'un octet ok.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
```

Ok donc c'est du 32 parce que pour le coup qword c'est 64 du coup et dword c'est 32.

section .text, on reprend le même format main et main et voilà on est bon.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
```

Ok donc là il fallait passer en 32 bits seulement par la pile, on ne passait pas par des registres en particulier. Il fallait tout empiler sur la pile évidemment vous ne savait peut-être pas ce qu'est une pile sauf peut-être en termes de structures de données si vous avez fait de la programmation dans d'autres langages, si par exempe vous avez regardé mon cours en c et on a vu les piles en programmation en langage c mais là on parle vraiment donc d'une mise en application de cette structure de piles mais au sein du système, la pile système.

Et cette pile ici, on va empiler les différents arguments dont ont besoin nos fonctions d'accord on empile dont la pile donc c'est un peu ça.

Certain diront que c'était un peu ça, on avait en gros une pile on dit tiens j'empile tous les arguments comme une pile d'assiettes et après je fais appel à la fonction et ensuite je remplis les nouveaux arguments, je fais appel à une autre fonction et cetera.

C'était ça, c'était vraiment, c'était du n'importe.

Donc pour ajouter à la pile on utilise notre instruction push donc j'ajoute la valeur -11 puisque c'est ça qui va me permettre d'écrire sur la sortie standard.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
```

Et je fais un appel parce que je n'ai pas envie de tout renoter à la main donc je reprends tout, pour appeler ici, récupérer en tout cas, obtenir un gestionnaire ici pour simplement mon affichage.

	a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
```

Voilà un gestionnaire pour la sortie standard, ensuite on push voilà donc on push 0 donc ça c'est le premier ici.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
```
Voilà donc il nous faut 0 ensuite en 32 c'est à l'envers, il nous faut written cette fois parce qu'ils avaient des arguments qui étaient inversés puisque vous verrez qu'à une histoire de prendre argument de gauche à droite donc il y a plein plein de règle qu'on va voir au niveau de ce cours, plein plein de choses.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
			push written
```

Normalement si je ne dit pas de bêtises c'est ensuite sur la pile le nombre de caractère 13 donc ici on ne prend pas le caractère donc c'est 13.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
			push written
			push 13
```

Ensuite on empile sur la pile le message voilà.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
			push written
			push 13
			push message
```

Et on termine par l'appel incroyable _WriteConsoleA@20 et on n'oublie pas l'accumulateur, eax.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
			push written
			push 13
			push message
			push eax
			call _WriteConsoleA@20
```

C'est bon c'est bon.

Ca c'est l'affichage gestionnaire, l'affichage et si vous avez bien suivi jusqu'à présent l'argument 0, push 0. L'argument 0 qu'on passait tout le temps même pour exit tout à l'heure sur linux. On fait un petit call de ExitProcess.

a32.asm
```asm
	bits 32
	
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4
	
	section .data
		message db 'Hello World !', 10
		
	section .bss
		written resd 1
	
	section .text
		global main
		main:
			push -11
			call _GetStdHandle@4
			
			push 0
			push written
			push 13
			push message
			push eax
			call _WriteConsoleA@20
			
>			push 0
>			call _ExitProcess@4
```

Vous voyez pour résumer même si vous n'avez pas du tout compris ce code, je vous ai dit que cette fonction ne prenait qu'un argument d'accord. C'est argument dans la pile c'est la valeur zéro et je fais appel _ExitProcess@4 et en fait cette fonction _ExitProcess@4 de l'api va être appelé avec cet argument là, 0 (push 0) d'accord, ce paramètre là, paramètres qu'elle attend sera à zéro.

Voilà il faut le voir comme ça, write console, il a cinq arguments :

	1			push 0
	2			push written
	3			push 13
	4			push message
	5			push eax
	>			call _WriteConsoleA@20

... et je les empilent sur la pile donc ça bon pour le coup on pourrait se dire c'était plus simple de ce côté-là fin après c'est subjectif c'est chacun voit ça comme il veut.

C'est vrai que l'on pourrait dire que c'est assez simple à l'usage puisqu'on avait qu'à l'empiler sur la pile à chaque fois et on ne s'embêtait pas et après par la suite avec le 64 bits maintenant on a des registres particulier.

Il faut connaître les noms, il faut savoir à quoi ils servent, dans quel ordre et cetera. C'est plus compliqué mais c'est surtout que les langage assembleur fonctionne beaucoup comme ça maintenant de toute façon.

Il y a des registres réservés, des registres pour des usages bien particulier car il y a des conventions etc dans les appels donc forcément c'est mieux que de se dire on empile tout sur la pile, on s'embête pas.

Là on met tout paf à l'arrache on appelle tous donc ça a pas mal évolué au niveau des architectures et en fonction bien sûr des supports sur lesquels vous travaillez.

S'il n'y a pas d'erreur maintenant je vais pouvoir assembler le programme donc cette fois ci ce n'est pas win64 mais win32 et pour golink.exe et normalement c'est bon. Et on test, a32.

```powershell
	>nasm -f win32 a32.asm -o a32.obj

	>golink a32.obj /entry main /console kernel32.dll

	GoLink.Exe Version 1.0.3.1  Copyright Jeremy Gordon 2002-2020   info@goprog.com
	Output file: a32.exe
	Format: Win32   Size: 2,048 bytes

	>a32
	Hello World !
```

On teste et voilà le petit hello world ! qui clôt cette partie là donc c'est assez long, on a vu beaucoup de choses mais c'était le but encore une fois le but c'était un petit peu que ce soit déroutant cette vidéo càd qu'il y a eu plein d'informations d'un coup et dire ouh là là alors c'est pas du python.

Oui ça change un peu, c'est pas que ce soit plus compliqué, plus simple, n'oubliez pas que c'est toujours subjectifs s'il ya des gens qui trouvent plus simple le langage assembleur que python et inversement.

Voilà c'est juste que si pendant x temps vous manipulez telle chose et qu'on vous fait passer à autre chose, forcément c'est assez déroutant c'est pareil c'est comme d'avoir été sur windows toute sa vie et le jour où on vous met sur linux, vous êtes complètement paumé et l'inverse serait exactement pareil ça poserait le même problème, vous avez passé votre vie sur linux et demain vous êtes sur windows vous serez largué ne serait ce que pour ouvrir un simple navigateur.

C'est normal c'est des choses à savoir, on va réfléchir autrement et il y a une manière de penser les choses différemment parce qu'on ne va pas programmer de la même manière qu'on le ferait dans un langage plus haut niveau d'autant que là on est encore une fois dans un langage qui est simplement une transcription du code machine d'accord.

D'ailleurs on s'amusera peut-être à un moment donné a carrément écrire du code machine directement on passera même pas par le code en langage assembleur, enfin le texte en langage assembleur, on s'amusera noté voit les instructions directement et vous écrirez comme un robot.

Vous deviendrez des machines vous même et s'musera à faire ça.

On mettra directement les instructions en code machine et il y aura plus qu'à lancer ça et ça va faire des miracles et des merveilles.

Ok on va s'arrêter là parce que je pense qu'on a fait le tour, encore une fois le but c'était de vous montrer sur windows, sur gnu linux, 32 bits, 64 bits, l'assembleur nasm qu'on utilisera de toute façon pour ce cours.

Pour Linux, utiliser le lieur ld.

Pour windows, je vous recommande, c'est beaucoup plus pratique le lieur GoLink comme ça vous n'aurez pas forcément les mêmes de l'un à l'autre et ça fera très bien le travail de toute façon donc voilà donc si vous utilisez qu'un des seuls systèmes à vous de vous adapter.

Choisissez bien sûr ce qui correspond à l'architecture de votre système d'exploitation.

J'espère que le système d'exploitation que vous avez installer correspond à l'architecture de votre processeurs et on va pouvoir comme ça aborder tout ça dans le détails donc là au moins vous avez vu énormément de termes d'accords j'employe normalement énormément de termes pendant que j'ai commenté ce code.

On a vu plein de données on a parlé de registre, on a parlé d'instructions, on a parlé de décalage, on a parlé d'alignement, on a parlé de piles, on a parlé d'appels, on a parlé de conventions d'appel voilà j'ai sorti énommément de termes et il y a tout un tas de syntaxe différente.

Encore une fois si vous ne connaissez pas et que vous n'avez jamais programmé ou même programmé en langage assembleur ça doit être absolument déroutant et incompréhensibles comme ça en tout cas sans commentaires.

Mais sachez qu'au moins au terme encore une fois de ce cours et même bien avant de toute façon même assez tôt vous comprendrez parfaitement chacune de ces instructions et vous verrez que ça n'a rien de plus logique que ce que c'est d'accord il n'y a rien de compliqué et une fois qu'on comprend le langage, on se rend compte qu'en fait bah c'est pas plus compliqué qu'autre chose.

C'est vraiment encore une fois une question de point de vue, ça dépend des gens et de impression de chacun et programmer en langage assembleur n'est pas forcément en tout cas, là je parle de sa syntaxe, n'est pas plus compliqué que programmer en php ou en c ou en c++.

Après ça ne veut pas dire pour autant que vous ne ferez pas d'erreur ou que produire un code correct est plus facile ou plus compliqué ça bien sûr ça dépend de pas mal de paramètres et de facteurs aussi.

Voilà je pense qu'on va s'arrêter là, voilà s'il y a des commentaires bien sûr, des questions n'hésitez pas en commentant cette vidéo je pense qu'on en aura beaucoup parce que vidéo d'introduction, je vous détaille pas mal de choses qui vous attend et hop directement à la deuxième séance Max de code.

Mais ce que je voulais faire voilà je voulais qu'on balance un gros bloc, on arrive directement et je vous balance un code et j'en parle très brièvement comme si vous connaissiez déjà tout ce que j'explique comme si j'étais juste en train de vous détailler un code que je fais mais que vous connaissiez le langage et en fait pas du tout, en tout cas bon c'est le but en tout cas de cette formation.

Et on va comme ça éplucher chaque chose pour que vous voyez un petit peu la logique qu'il ya derrière le fonctionnement qu'il y a derrière tout ça et bien sûr à terme que vous puissez écrire vos propres programmes et on verra bien sûr d'autres notions que celles que j'ai pu montrer sur ces petits codes de démarrage en tout cas pour ce début de cours finalement en langage assembleur.

J'espère en tout cas que ça vous a plu puisque à l'heure bien sûr où je fais cette vidéo je sais que cette suite était très attendue comme constamment pour tout.

Voilà on va se dire que comme je ne vais pas particulièrement forcément publié toute la suite des vidéos en langage assembleur parce qu'il y a plein d'autres formations mais si vraiment la vidéo explose en termes de vue en termes de likes parce que je ne force pas forcément les gens à liker et pourtant c'est tellement important pour le référencement ou autre.

N'hésitez pas si vous donnez en tout cas un petit coup de main au niveau des likes, du référencement de la vidéo et des vues qu'elle est énormément regarder tout ça et bien écoutez on enchaînera assez vite sur les prochaines séances mais pas tout d'un coup mais j'enchaînerai comme ça sur quelques séances supplémentaires en tout cas histoire de vous gâter un petit peu pour cette ce début d'année 2021 bon en tout cas au moment où j'ai fait cette vidéo parce que peut-être que parmi vous des gens sont en train de m'écouter et on est en 2037 voilà c'est la fin du monde le covid 2037 c'est fou atroce voilà et du coup vous êtes en train de programmer en ça puisque on est plus en 2021 depuis des lustres mais c'est pas grave.

Ces vidéos sont intemporels, ce cours l'est aussi.

J'espère en tout cas que ça vous a plu que vous avez déjà pas mal appris de choses mine de rien sur cette introduction sur votre premier programme en langage assembleur.

Encore une fois choisissez le bon format, la bonne architecture, le bon système, testez de votre côté, commencez à installer tout les outils pour que tout soit en place et on va voir tout ça en détail ensemble sur la suite de la prochaine séance en tout cas de ce cours.

Je vous dis à bientôt pour une nouvelle vidéo et s'il y a des questions vous me retrouver comme d'habitude dans les commentaires puisque je suis présent constamment pour répondre à vos questions.

à bientôt