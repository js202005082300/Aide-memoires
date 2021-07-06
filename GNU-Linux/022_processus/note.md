# [22. Processus](https://www.youtube.com/watch?v=noGCntpmYpk)

Bonjour à tous et bienvenue pour la séance 22. 

Nous allons sur ce cours GNU Linux, abordé pas mal de notions importantes qu'on va voir dans les quelques séances qui vont suivre que j'ai réparti en plusieurs séances. On va passer un niveau au dessus par rapport à tout le détail que je vais vous donner concernant le fonctionnement Linux et ce que l'on peut faire dessus en ligne de commande. 

La vidéo fait référence au processus, vous avez simplement des applications que vous pouvez utiliser sur votre ordinateur et en réalité se cache derrière des processus d'accord nous avons derrière un processeur qui va se charger de faire des traitements, calculs sur ses différents programmes qui sont réparties sous forme de processus. 

Généralement nous avons un processus par application mais il est possible aussi d'avoir plusieurs processus par application et c'est notamment le cas pour les navigateurs web mais même si vous êtes sur Windows, peu importe l'OS, vous n'avez qu à les voir sur votre gestionnaire de tâches ou regarder dans la liste des processus ce que nous allons faire d'ailleurs tout de suite sur Linux et vous retrouverez des fois plusieurs processus pour Google Chrome, pour d'autres navigateurs web, il y a plusieurs logiciels qui en ont besoin en fonction. 

En gros, il y a un processus par onglet d'ouvert. 

Plus il y a de onglets d'ouvert dans votre navigateur et puis évidemment il faudra de processus par rapport à ça. 

Ces différents processus sont tout simplement un programme c'est à dire un programme qui va permettre d'avoir différentes informations, on va avoir énormément de choses les concernant et on va voir un petit peu en quoi ça consiste ? quelles sont les commandes que nous avons dans notre terminal pour accéder à ces différentes informations ? et voir un peu tout ce qu'on peut faire avec ça. 

Il y a vraiment beaucoup d'informations à connaître. 

La première commande à voir est la commande `ps`. 

Si je fais la commande comme ça je ne vais pas avoir beaucoup d'informations.

## [ps](https://man.cx/ps)
Process Status.

```bash
ps #affiche les processus en cours d'exécution.
	...
	PID TTY          TIME CMD
   	3733 pts/0    00:00:00 bash
   	7315 pts/0    00:00:00 ps
```
On a un PID, c'est tout simplement un processus id d'accord c'est l'identifiant d'un processus particulier. 

TTY, c'est l'information qui ne nous intéressera pas, on ne va pas en parler ici. 

Le TIME c'est le moment où a été exécuté la fameuse commande. 

Et le CMD, c'est par où nous sommes passés, on est passé ici par bash, et on est passé ici par ps.

Alors nous allons afficher un listing un peu plus complet, il existe déjà plein plein d'options pour cette commande ps mais je ne vais pas faire comme les autres commandes qu'on avait dans la vidéo précédente où on a abordé beaucoup d'options parce que ça veut vraiment d'intérêt et ici grosso modo vous allez avoir 2 cas avec 2 syntaxes différentes c'est-à-dire qu'il y a une syntaxe standard et il y a une syntaxe dite BSD d'accord qui est un autre style de l'environnement UNIX. Voilà vous avez le choix de l'un ou l'autre.

### ps -elf

Vous avez la syntaxe `ps -elf`, vous allez souvent utiliser ces 3 options là et on obtiendra ce genre de chose.

```bash
ps -elf #affiche une syntaxe standard.
	...
	F S UID          PID    PPID  C PRI  NI ADDR SZ WCHAN  STIME TTY          TIME CMD
	4 S root           1       0  0  80   0 - 25549 -      10:33 ?        00:00:02 /sbin/init splash
```

### ps -auwx

Et si on veut plutôt une présentation un peu plus BSD light, on aura plutôt `ps -auwx` voilà et en fonction on va retrouver du coup plein d'informations et on voit qu'il y a un listing qui est beaucoup plus grand.

```bash
ps -auwx #affiche une syntaxe bsd light.
	...
	USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
	root           1  0.1  0.0 167936 12012 ?        Ss   14:23   0:06 /sbin/init splash
		#USER = utilisateur qui a lancé ce nouveau processus.
		#PID
		#%CPU = cpu utilisé.
		#%MEM = mémoire vive utilisée.
		#STAT = status du processus.
		#TIME
		#COMMAND = par où a été lancé la commande.
```

On a l'utilisateur qui a lancé ce nouveau processus. Vous voyez qu'il y a root par défaut, il y a plein de processus qui ont été lancés par le système donc ce n'est pas nous qui l'avons fait automatiquement mais ça a été géré automatiquement et on voit également les processus qui ont été faits par nous en tout cas géré par notre session utilisateur donc c'est évidemment notre nom d'utilisateur. 

On retrouve le PID toujours important, on a le pourcentage de CPU utiliser c'est-à-dire la mémoire CPU, le pourcentage de la mémoire vive %MEM. TTY est une information qui nous intéresse pas. 

On a le statut STAT du processus en question mais ça on va en parler un petit peu. 

On retrouve le fameux temps TIME et tout ce qui la commande COMMAND donc d'où a été lancé le processus en question donc le nom du processus en question ce qu'on obtenait en faisant un simple `PS`, nous avions le nom du processus ici.

```bash
ps #affiche les processus en cours d'exécution.
	...
	PID TTY          TIME CMD
	3733 pts/0    00:00:00 bash
	7315 pts/0    00:00:00 ps
```

Ensuite comment est-ce que ça fonctionne en termes de processus ? qu'est-ce qu'il y a comme informations à connaître ? 

Un processus maintenant je vous ai expliqué ce que c'était avec toutes les informations que l'on pouvait retrouver, on va donc avoir un code exécutable c'est-à-dire que peu importe le nombre de processus par exemple si vous lancez 2 fois votre lecteur VLC, ou que vous avez par exemple plusieurs onglets dans votre navigateur, chacun de ces processus va utiliser le même exécutable, le même code d'exécution.

Ça ça ne changera pas d'une instance à une autre d'accord si vous lancez plusieurs fois votre lecteur VLC, il utilisera toujours la même base de code exécutable. 

Par contre ce qui va différencier un processus d'un autre c'est tout simplement sur le contexte d'exécution et là c'est différent. 

Le contexte d'exécution et c'est très important, va permettre d'avoir un suivi d'accord de pouvoir surveiller l'état des différents processus lancés donc l'état du processus en lui-même sur son exécution. 

Et par la suite on verra ça dans la séance suivante lorsqu'on abordera les signaux, c'est une notion très importante aussi qu'on retrouve ici mais vous verrez qu'avec les signaux on va pouvoir envoyer tout un tas d'instructions à différents processus pour pouvoir changer leurs états. 

En gros ce qu'il faut retenir, un processus à un code exécutable qu'il va exécuter de manière identique peu importe le nombre d'instances donc le nombre de programmes que vous lancez, ça c'est toujours identique. 

Par contre chaque processus à son propre contexte d'exécution.

Pour ceux qui font de la programmation ça reviendra à dire que j'appelle 2 fois la même fonction par exemple en langage c vous appelez la fonction printf(), en python print(), en php echo() l'instruction. 

Eh vous aurez bien à utiliser à chaque fois la même fonction, le même code exécutable mais par contre chaque fonction aura son contexte d'exécution d'accord sa propre pile de variable mais ça ça parlera surtout pour les programmeurs sinon je ne saurai pas à quoi je fais référence. 

Voilà grosso modo pour ça. 

Il y a donc beaucoup d'informations et par rapport à ce processus on a plein d'informations qu'on va pouvoir récupérer. 

Alors ce qu'il faut savoir par rapport à ça c'est qu'il y a un système de généalogie, de hiérarchie par rapport au processus. 

Quand on va démarrer notre ordinateur il va y avoir le processus init, qui possédera le identificateur numéro 1 du processus, qui est en fait le processus père, qui est vraiment à l'origine de tous les autres en gros c'est le premier processus à être lancé sur votre système Linux et ce sera évidemment le dernier à s'arrêter parce que tout découle de ce premier.

```bash
ps -auwx
	...
	USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
	root           1  0.1  0.0 167936 12012 ?        Ss   14:23   0:06 /sbin/init splash
```

Il y a donc une histoire d'héritage, ce même plus que de la hiérarchie c'est de l'héritage. 

On a un processus père qui est vraiment le premier et de cela découlent plusieurs processus fils.

Mais nous n'allons pas rentrer trop dans les détails parce que ça fait appel aux signaux et c'est des choses qu'on reviendra dessus dans la prochaine séance histoire de ne pas voir les processus et les signaux dans une seule même vidéo parce qu'il y a énormément de choses à voir. 

Alors ce processus init est disponible dans ce cas-là.

Pour ceux qui se sont intéressés à l'actualité vous avez peut-être entendu parler de sysvinit /systemd où il y a pas mal de distribution qui ont quitté sysvinit notamment comme système d'amorçage pour passer à systemd. 

En gros ça simplement le programme init et là je simplifié énormément mais en fait la manière dont on amorce le démarrage non du système, que l'on charge les périphériques d'entrée et de sortie et cetera c'est-à-dire qu'à l'époque on travaillait surtout avec sysvinit qui travaillait beaucoup avec de simples fichiers texte pour pouvoir tout configurer pour avoir une configuration au millimètre près, bien précises pour tout ce qui est l'exécution des processus, là où systemd a véritablement quelque chose de programmé donc qui possède tout un tas de fonctionnalités différentes et via tout un tas de fichiers de configuration seulement, pas des fichiers qui illustrent la totalité de la chose Eh bien on pourra changer le comportement de ça. 

Voilà je ne vais pas rentrer dans les détails parce que l'appareil on peut en faire une vidéo complète, il n'y a pas que sysvinit /systemd, il y en a énormément d'autres aussi et c'est surtout cela qui ont fait le plus parler, il y a eu beaucoup de débats comme quoi le passage à systemd et bien ou pas bien. 

En gros ce qu'il faut savoir, on ce processus init qui est démarré et ensuite il va généré des processus fils, et vous par la suite quand vous créer un nouveau processus lancé par un programme, il lancera un processus fils depuis init.

Ou alors on va avoir un processus fils qui appartiendra à un autre père qui serra à un moment donné fils de init.

C'est toujours le processus originel qui est à la base de tout et c'est pour ça qu'il est le dernier à être coupé avant l'extinction de votre système. Ca c'est quelque chose de très important qu'il faut bien comprendre parce que si vous avez bien compris tout ça, que INIT est le premier processus donc l'identifiant numéro 1 c'est toujours lui qui possède le PID 1 et bien vous aurez compris énormément de choses.

Et ensuite je voulais qu'on aborde tout ce qui est lié à l'état des processus. On ne va pas aller trop vite non plus.

### ps -u user

Maintenant qu'on a tous les processus listés, on peut avoir que ceux d'un utilisateur particulier donc je peux très bien utiliser.

```bash
ps -u sam #lister les processus d'un utilisateur particulier.

	PID TTY          TIME CMD
	1013 ?        00:00:01 systemd
```

On retrouve encore une fois ce numéro de PID qui aura toute son importance pour pouvoir identifier les processus et travailler dessus.

Maintenant qu'on a vu ce que c'était qu'un processus, toutes les informations qu'il y a dessus et vous voyez qu'il y a vraiment beaucoup de choses, on va s'attarder sur l'état des processus et donner quelques explications parce que vous allez voir que les processus sont très très liés aux signaux et inversement mais moi j'ai réparti ces 2 notions en 2 vidéos donc ne vous inquiétez pas s'il y a des choses qui ne sont pas vu là, on le verra dans la prochaine vidéo pour compléter un petit peu tout ça. 

En gros nous avons différents états d'un processus c'est-à-dire qu'un processus il faut bien comprendre dans quel état il est pour savoir dans quel état il est en termes de fonctionnement. 

Je vous avais dit qu'il y avait un suivi, un contexte d'exécution c'est-à-dire de savoir un peu où il en est dans son exécution, dans ce qu'il est entrain de faire. 

Vous voyez qu'il y a différents états que l'on voit dans cette colonne STAT c'est-à-dire l'état actuel de votre processus. 

L'état d'un processus par STAT

Alors un processus qui est en exécution, par exemple qui a un code exécutable à exécuter donc des instructions à suivre, un traitement, il sera dans un état R.

> :warning: la commande ps retourne un état statique, rien ne bouge alors que mon système travaille tout le temps. Toutes les infos là renvoie un état statique donc toutes les infos-là sont déjà obsolète par rapport à l'état de maintenant tout de suite de l'état du système.

## [top](https://man.cx/top)

Si vous voulez une information en temps réel, il y a une autre commande qui propose plein plein d'options qui est la commande `top` qui par défaut se met à jour toutes les 3 secondes.

```bash
top #affiche les processus en temps réel (3sec).

	PID UTIL.     PR  NI    VIRT    RES    SHR S  %CPU  %MEM    TEMPS+ COM.                     
	1301 sam       20   0 3874580 329020 117620 S   3,0   2,9   0:41.37 gnome-shell              
	1033 sam       20   0  516524  56044  36108 S   2,3   0,5   0:17.78 Xorg
```

On peut choisir de modifier le temps de mise à jour que ce soit toutes les secondes toutes les 3 secondes et il y a pas mal d'informations qu'on peut éventuellement régler. 

Si vous appuyez sur la touche H vous avez tout un Manuel en français qui vous explique les différentes commandes que vous pouvez utiliser avec ce programme `top`. 

Pareil si je vous explique toutes ces commandes, ça ferait un peu de bain alors que vous avez toutes les explications il me semble suffisamment clair par rapport à ça.

On fait Q pour quitter le programme. 

Il s'agit d'un programme interactif qui se situe entre la ligne de commande et l'interface graphique donc si j'emploie ce terme là c'est parce que c'est entre les 2 c'est-à-dire qu'elle n'est pas directement en ligne de commande pure, on n'est pas non plus dans l'interface graphique avec des boutons des widgets et cetera c'est-à-dire qu'on est vraiment dans un programme interactif qui est ton console avec lequel on peut interagir donc c'est entre les 2. 

Si vous voulez quelque chose en temps réel qui se met à jour vous avez la commande top et si vous voulez quelque chose de statique parce que vous avez besoin de travailler sur des infos de manière statique vous faites un ps -auwx. 

Pour revenir aux différents statuts, le R c'est le statut d'exécution, un programme en train d'exécuter des instructions sur en statut R. 

On a également un S majuscule qui est en fait l'état de sommeil, en gros l'état de sommeil c'est un programme en exécution dans le sens où il est démarré, il existe et il est dans la liste mais il attend quelque chose. Imaginez un programme vous attendez qu'un utilisateur tape quelque chose au clavier ou une action c'est-à-dire qu'on attend un événement utilisateur, un redimensionnement de fenêtre, un clic sur une touche en particulier ou le lancement d'une commande peu importe. Pendant ce temps le programme continue d'exister, il tourne et le processus existe mais il est en sommeil c'est-à-dire qu'il attend que l'utilisateur fasse quelque chose et du coup il se met plus ou moins en attente et on a un S majuscule qui indique le processus et ton sommeil. 

Le R signifie qu'il est en exécution qu'il est en train de travailler, le S c'est l'état de sommeil. 

L'état T est un processus stoppé c'est-à-dire que lorsqu'on abordera les signaux dans la prochaine vidéo, on va pouvoir mettre en pause un processus c'est-à-dire qu'on ne va pas le quitter mais on va juste lui dire d'arrêter d'être exécuté ou de fonctionner. Tu n'es ni en exécution ni en sommeil mais tu es en pause c'est-à-dire que tu ne réagis plus pour le moment mais on verra que pour le faire continuer, reprendre la main dessus, on pourra le mettre en sommeil ou le mettre en exécution. 

Et il y a ce qu'on appelle un processus zombie. 

Je vous expliqué qu'un processus appartenait à un père dans tous les cas mais il est possible que vous ayez des fois un processus avec un père qui n'est plus là c'est-à-dire un processus qui n'a pas envoyé de code de retour à son père.

En gros quand on va générer une commande via  un processus donc ça va créer un processus, une fois qu'il aura terminé il va renvoyer un code et si ce code de retour n'a pas été communiquée au père, on va obtenir un processus orphelin qui sera un processus zombie. 

Ainsi un processus zombie même s'il ne coûte rien en termes de mémoire, il ne consomme absolument rien puisqu'il est en l'état de zombie et c'est pour ça qu'il porte ce nom pour autant il va être dérangeant au niveau de ça parce que le système au niveau de la table de processus ne peut avoir qu'un nombre de processus limité. 

Ici on voit qu'on étape plus de 2000 processus donc ce qui est pas mal grand.

```bash
ps -auwx
	USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
	root           1  0.0  0.1 102196 11776 ?        Ss   10:33   0:03 /sbin/init splash
	root           2  0.0  0.0      0     0 ?        S    10:33   0:00 [kthreadd]
```

Même si on voit qu'ici on n'est à plus de 2000 processus ce qui a l'air pas mal d'être grand et malgré tout le nombre est quand même assez limité et si on se retrouve avec un programme qui créé plein de processus zombies (du coup une invasion zombie), Eh bien on pourrait se retrouver à saturer sa table de processus. 

Et comme je vous ai expliqué au début de la vidéo que tous les programmes générer et lance des processus, ça veut dire en gros que si vous ne pouvez plus lancer le processus votre système ne peut plus marcher.

Si vous ne pouvez plus créer vos processus, votre système ne peut plus marcher.

Alors la solution c'est de faire adopter un processus zombie par un nouveau père, ça peut être le processus INIT parce que tant qu'on n'aura pas éteint, il sera toujours en route et donc on pourra lui dire que là il y a un processus zombie donc orphelin et qu'on va le faire adopter par INIT et à partir de là quand vous allez éteindre votre système et que INIT va se couper, quand un processus père s'éteint tous les processus fils y comprit les processus fils qui étaient des zombies à la base vont être quitté correctement.

C'est compliqué mais on reviendra la dessus.

On a vu plein de commandes cat echo et cetera. On a parlé des flux de redirections et maintenant que vous savez ce que c'est qu'un processus, chaque processus possède une entrée standard et rappelez-vous qu'on parle d'un contexte d'utilisation qui est propre à chacun. 

Je vous ai dit que le code exécutable était le même peu importe le nombre d'instances d'un même programme mais par contre chaque processus à son propre contexte donc imaginer son propre espace à lui, son espace privé qui n'est pas du coup l'espace d'un même processus.

Du coup chaque processus à son entrée standard, sa sortie standard et sa sortie d'erreur et donc rappelez-vous quand on faisait les fameuses commandes tout ceci >, les entrées < ou ça <<, la sortie d'erreur 2> tout ce qu'on a vu sur la vidéo sur les flux de redirection mais c'est des choses qu'il faut évidemment bien maitriser.

```bash
ps -auwx

	USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
	root           1  0.0  0.1 167848 11688 ?        Ss   déc27   0:02 /sbin/init splash
```

Et en plus de ça comme on avait vu avec `ps -auwx`, chaque processus a bien un propriétaire parce qu'il a bien été initialisé par quelqu'un (root, sam, jachampagne, etc). Il y a toujours un propriétaire et il y a une histoire de priorité, et ça c'est pareil on va encore plus loin dans le fonctionnement du système donc là on n'est plus forcément dans le fonctionnement propre de Linux mais dans tout ce qui est système d'exploitation. On va encore plus loin là-dessus. 

En gros au niveau de notre processeur, on a l'impression que tout s'exécute en même temps c'est-à-dire que si j'ouvre mon explorateur, on pourrait penser que mon explorateur Nautilus et mon terminal Tlix s'exécute au même moment d'accord rappelez-vous qu'on parle souvent de multitâche comme si tout se faisait en même temps mais en réalité on a le processeur et donc on est vraiment dans le fonctionnement du système donc on est vraiment très très bas niveau pour le coup, beaucoup plus bas niveau que l'explorateur de fichiers, il va y avoir un ordonnancement des tâches. 

L'ordonnancement des tâches, comment ça se passe ? 

Notre processeur va dire à un moment donné qu'il va donner la main à un processus quelques milli secondes, quelques secondes peu importe c'est lui qui décide l'ordonnanceur donc c'est lui qui accordent les temps qu'il donne et il va donner donc la main pendant quelques milli secondes et ensuite il va donner la main à un autre et cetera. 

Et bien évidemment pour que ce soit géré au mieux, il faut un système de priorité c'est-à-dire qu'il y a certains programmes qui sont dits en tant que partagé c'est-à-dire qu'on leur dit que on leur donne la main tant qu'on peut leur donner la main, et c'est pour ça qu'on va dire que l'explorateur il est possible qui n'est pas la main pendant quelques milli secondes mais que nous humainement visiblement parlant, on ne voit pas la différence. 

Là il est possible que mon explorateur n'est pas la main pendant plus de temps qu'il en faudrait mais comme c'est du temps partagé ça ne pose pas de problème. 

Par contre dans des 4 critiques, on aurait besoin de ce qu'on appelle du temps réel et à ce moment-là les priorités seront différentes et l'ordonnanceur saura qu'il doit prioriser tout ce qui est fonctionnement entre réel plus que ce qui doit être en temps partagé mais nous on va pas se poser la question de comment il fait vraiment ça. 

Tout simplement nous avons par rapport à ces fameux états au niveau de ces processus, l'ordonnanceur va gérer les différents ca. 

En gros nous avons un système d'élections et ça va être très sympa dessus et vous allez voir que ce n'est pas compliqué dans l'idée mais en gros à un moment t si on prend un moment précis, nous avons un processus qui est dit élu. 

Le processus élu va obtenir tel priorité par l'ordonnanceur qui va lui permettre de profiter de la puissance du processeur donc de pouvoir profiter de la puissance de calcul et du processeur en lui-même pour pouvoir exécuter certaines choses.

N'imaginez pas que ce temps là c'est plusieurs secondes, minutes, ici on est dans des milli secondes voir des fois moins, ce sont des temps très petits à l'échelle humaine mais pour un ordinateur quelques milli secondes c'est déjà beaucoup c'est pour ça qu'on a ce système là. 

Ce processus élu, par rapport au temps qu'on lui a accordé la main aux calculs, au processeur Eh bien ce temps-là lui est élu.

Une fois que ce temps-là lui est retiré, il passe soit en état bloqué donc un processus qui est bloqué, c'est un processus qui est dans l'attente d'avoir la main par l'ordonnanceur et quand le processus doit pouvoir rentrer dans cette fameuse file, en fait dans une file d'attente pour dire voilà je suis prêt à avoir la main pour pouvoir exécuter certaines choses Eh bien il passera justement dans cet état dit prêt. 

En gros nous avons 3 état pour faire vraiment très simple, nous avons l'état 'élu' qui à l'instant T c'est le processus qui est en cours qui a la mains c'est-à-dire que le processus lui donne la main. Nous avons l'état 'prêt' c'est-à-dire qu'il y a toute une file d'attente qui dit que tous les processus sont prêts à recevoir la main donc d'avoir le contrôle et donc ils attendent et ils attendent d'être rangés par ordre de priorité.

Tout ce qui est en temps réel sera évidemment prioritaire par rapport à ce qui est plus bas et la priorité sera gérée en fonction comme ça. 

Et le processus 'bloqué' ce sont simplement ceux qui ne sont pas encore prêts à recevoir l'accès au processeur donc toi qu'il sont bloqués, ils ne sont pas en file d'attente, ils ne font pas partie des processus prêt pour l'élection. 

On parle d'élections parce qu'on parle vraiment d'élus par rapport à ça. 

Il y a tous les processus près donc la liste des processus qui sont prêts qui peuvent recevoir la main par rapport à l'ordonnancement des tâches. 

Voilà je n'irai pas plus loin dans les détails.

En gros on a un processus élu, une liste d'attente de processus qui sont prêts à recevoir la puissance donc le calcul du processeur et des processus bloqués vont devoir sortir de cet état bloqué pour passer en file d'attente aussi donc il y a une histoire de priorité. 

Ça fait partie des différentes choses que possède chaque processus, je vous ai dit qu'on a parlé de l'entrée standard, la sortie standard, la sortie d'erreur, un propriétaire et également cette histoire de priorité. 

Par exemple dans une voiture, le freinage est bien plus prioritaire que d'afficher un témoin lumineux au sujet de la réserve d'essence ou ce genre de chose. 

Pour l'OS c'est exactement pareil, on a des processus qui passeront avant d'autres mais dans tous les cas on n'a pas tous qui est exécuté en même temps. Le processeur ne peut pas se dire qu'il va tout faire tourner en même temps, tout au même instant t où tous les processus sont élus au même moment mais il va ordonnancer donc ordonné passer la main quelques milli secondes pour l'un, quelques milli secondes pour un autre processus et cetera.

C'est cet enchaînement qui humainement parlant se fait très vite et ces histoires de quelques milli secondes mais nous on a l'impression que tout s'exécute tout le temps en parallèle, en temps réel, tout le temps au même moment alors qu'en réalité c'est la succession de la main sur un processus suivi d'un autre.

On ne présentera pas les exemples de tout ce qui est mono-core et multi-core donc tout ce qui est dual-core, quad-core, threading et multi-threading et cetera on ne va pas aller trop loin dans les détails. 

En gros voilà comment ça se passe pour l'ordonnancement des processus donc des tâches de votre système.

Alors l'ordonnanceur c'est un peu le chef d'orchestre, c'est lui qui donne la main un processus en particulier et qui peut interrompre et lui redonner la main plus tard sur ce qu'il était en train de faire en terme d'exécution si à un moment donné on peut mettre en pause. 

En tout cas l'ordonnanceur essaye que tout fonctionne ensemble. 

Voilà pour l'ordonnanceur qui était très important.

## Esperluette

On va revenir sur quelques petites choses, vous saviez que jusqu à présent on exécutait nos commandes une tâche 
à la fois donc en gros si je fais ça.

```bash
ls
	
	Bureau  Documents  Images  Modèles  Musique  Public  Téléchargements  Vidéos
```

Voilà on exécute la commande ls et une fois qu'elle est terminée je récupère la main sur mon terminal donc il y a forcément un temps d'exécution de la commande. 

La commande était très courte parce qu'il n'y avait pas grand-chose à lister par contre si je commence à lister le système ça va prendre beaucoup beaucoup plus de temps.

```bash
ls -R /
```

Et là ça prend beaucoup beaucoup plus de temps et le seul moyen d'interrompre c'est encore de faire un ctrl+C et on voit que ça interrompt.

Et bien ça fait l'introduction avec la prochaine séance, nous venons en faisant ctrl+C avec le clavier d'envoyer un signal au processus et on verra dans la prochaine séance qu'en faisant ctrl+C avec le clavier, on envoi un signal au processus pour dire d'interrompre ce processus.

La fameuse commande que j'ai fait ici, `ls -R /` elle a été enregistrée dans un processus.

```bash
ls -R /
	...

ps -auwx
	USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
	sam         2819  0.0  0.0  13156  4940 pts/1    Ss   14:32   0:00 bash
	sam         2831 59.7  0.0  13372  3444 pts/0    R+   14:33   0:04 ls --color=auto -R /
	sam         2833  0.0  0.0  14320  3576 pts/1    R+   14:33   0:00 ps -auwx
	...
```

Voilà LS, son processus d'identification c'est 2831.

Si je refais la commande `ps -auwx`, le processus a disparu quand la commande ls s'est achevée. 

Quand ce processus se termine il renvoie un code tout simplement.

On peut également exécuter une commande en tâche de fond c'est-à-dire que de plutôt d'exécuter toute cette commente là, `ls -R /` où on n'a pas la main sur ce terminal c'est à dire que je serais obligé d'ouvrir une autre console si je veux avoir la main sur autre chose donc on va lui dire tu fait cette commande et tu fait autre chose en parallèle avec un petit &.

```bash
~$ ls -R / &
	[1] 2899
	_
~$
```

Et là du coup je peux avoir la main pour exécuter du coup autre chose.

Idem si je lance Firefox.

```bash
~$ firefox
_
~$
```

Par contre là vous voyez que je n'ai pas la main sur le terminal, on a une petite barre qui clignote. 

Si je fais ctrl+C, on va envoyer un signal qui va interrompre le processus et ici du coup on voit que ça quitte.

```bash
~$ firefox
^CExiting due to channel error.
Exiting due to channel error.
Exiting due to channel error.
Exiting due to channel error.
```

Si je vais pouvoir le lancer en parallèle, j'ai juste à faire firefox et mettre le petit &.

```bash
~$ firefox &
[1] 4142
~$
```

Voilà on ne retourne pas mal d'infos dont [1] qui est le premier processus lié à Firefox et ensuite le PID 4142 qui est l'identificateur du processus en question et plus tard on pourra faire quelque chose sur ce processus de Firefox. 

Et je peux donc continuer à faire autre chose sans problème.

```bash
~$ firefox &
[1] 4142
~$ ls
Bureau  Documents  Images  Modèles  Musique  Public  Téléchargements  Vidéos
```

## [nohup](https://man.cx/nohup)

Si on fait la commande firefox &, Firefox ouvert est lié au processus père qui est en fait mon terminal et rappelez-vous que chaque processus fils a forcément un père sinon ce serait un zombie. 

Firefox n'est pas un zombie parce qu'il existe bien, on peut l'utiliser sans problème et ensuite si je ferme la console, Firefox se ferme aussi tout simplement parce qu'il a été lié à partir du moment où on a quitté le processus père donc ici le terminal bash, ça a quitté tous les processus fils, ça les a Kill, tués mais ça on en parlera un peu plus tard. 

Si je ne veux pas lier un processus par rapport au terminal donc de le délier de tout ça je vais simplement utiliser la commande `nohup` et ensuite on fait tout ce qu'on a fait sans oublier le & commercial et en faisant ça je peux tout simplement délier la gestion de l'un et de l'autre. 

```bash
~$ nohup firefox
nohup: les entrées sont ignorées et la sortie est ajoutée à 'nohup.out'
_
```

Voilà je fais ça et on va avoir un fichier qui va être créé spécialement avec nohup qui ne sera du coup plus en lien avec le terminal et alors je peux quitter mon terminal et ne plus quitter Firefox pour autant. 

Voilà une chose importante qu'il fallait connaître. 

En gros les commandes que nous avons vu dans cette vidéo, on a vu `PS`, on a vu `TOP` en temps réel et on a vu `NOHUP` par rapport à ça. 

L'utilisation d'une commande comme ça.

```bash
~$ ls
```

L'utilisation de ces commandes se fait directement donc elle est en exécution jusqu à ce qu'elle se termine et une fois que la commande se termine on peut prendre la main. 

Si on fait avec un &, ça se fait en parallèle donc on peut continuer à faire autre chose et on verra par la suite quoi mais du coup on fera un petit truc amusant dans la prochaine vidéo en utilisant un petit programme sympa par rapport à ça.

```bash
sam@samVB:~$ ls &
[1] 4809
_
```

Et si on fait nohup c'est pour tout simplement ne pas lier au processus du terminal donc ici bash et on peut ainsi délier de l'usage du terminal.

```bash
sam@samVB:~$ nohup ls -R /
nohup: les entrées sont ignorées et la sortie est ajoutée à 'nohup.out'
sam@samVB:~$
```

Voilà au niveau des commandes c'est tout ce que je voulais voir.

## Barre de Sheffer

Rappelez-vous on avait vu le PIP | qui permettait de dire que le résultat de la commande qui était à gauche quand on faisait par exemple ceci.

```bash
sam@samVB:~$ ps | grep "bash"
1934 pts/0    00:00:00 bash
```

Voilà donc comme je vous avais dit |, le pip, le tube permet de se servir de ce que retourne la commande ps en entrée de la commande grep "bash". 

Alors ça on l'a déjà vu aussi.

## variable interrogation

Chaque processus dans son fonctionnement va renvoyer un code de retour, un processus va retourner le code 0 si tout s'est bien passé pour dire que tout a bien fonctionné et si il y a une erreur il retournera un autre numéro.

Si on veut récupérer ce numéro, je vais d'abord exécuter une commande ici. 

```bash
sam@samVB:~$ ls -l
total 12092
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Bureau
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Documents
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Images
...
```

Ensuite je vais faire un echo pour afficher et ensuite un $ pour dire qu'on utilise une variable particulière et notamment $?.

```bash
sam@samVB:~$ echo $?
0
```

Le ? va tout simplement retourner le code qui a été retourné par le dernier processus qui vient de se terminer. 

Ainsi la commande s'est terminée et on a récupéré la main sur le terminal, et avec $? je vais récupérer le code retour du dernier processus terminé et il a retourné 0 ce qui signifie que la commande a bien marché. 

Si par exemple maintenant j'essaie de faire cat d'un fichier qui n'existe pas.

```bash
sam@samVB:~$ cat notfound.txt
cat: notfound.txt: Aucun fichier ou dossier de ce type
sam@samVB:~$ echo $?
1
```

Envoyer que ça nous a retourné le code un pour dire qu'il y a eu une erreur. 

Si on veut savoir à quoi correspond chaque code d'erreur, il faut aller voir dans les manuels en fonction des commandes et ça vous dira quand quel code est retourné précisément. 

Pareil je ne vais pas rentrer dans les détails parce que s'il vous faut faire l'énumération de chaque côté d'erreur, ce n'est pas très intéressant pour le coup.

## variable dollar

Si on fait par exemple ceci au lieu de demander le code de retour du dernier processus qui s'est terminé ($?), on peut également demander le PID du Shell courant avec $$.

```bash
sam@samVB:~$ echo $$
1934
```

Et si je fais `ps | grep "bash"`, on retrouve le même PID.

```bash
sam@samVB:~$ ps | grep "bash"
1934 pts/0    00:00:00 bash
```

Voilà c'est l'échelle que vous êtes en train d'utiliser bash, zh, peu importe le Shell donc vous êtes en train de vous servir ça ne changera rien. 

Nous avons en gros le numéro de processus de votre Shell donc le terminal que vous êtes en train d'utiliser et donc ça c'est quelque chose qui est important à connaître.

## variable exclamation

On a également $!

```bash
sam@samVB:~$ echo $!
4809
```

Ça vous retourne le PID du dernier processus que vous avez lancé en arrière-plan donc on peut se demander à quoi va servir tout ça mais n'oubliez pas qu'on peut faire de l'administration système et réseau c'est-à-dire que toutes les commandes qu'on utilise ici dans le terminal, comprenez qu'on pourra également s'en servir pour faire tout un tas d'instruction mais aussi dans des programmes. 

Et ça peut être intéressant dans le cas où on veut contrôler tout ce qui est lancé sur un système donc de lancer des choses bien précises et pour savoir à quoi il y a une application et si par exemple je veux récupérer le Firefox qui est déjà lancé, je vais demander où est le Firefox. 

Il faut bien qu'il y a un identificateur de ce programme et ça tombe bien parce que les identificateurs de vos applications, de vos programmes, de tout ce qui peut tourner sur votre système, ce sont des processus et chaque processus a un identificateur et grâce à ça on sait à quoi correspond chaque processus donc son PID. 

On sait à quoi correspond chaque processus parce qu'on a un numéro d'identifiant. 

Comme on aurait des identifiants dans une base de données pour chaque enregistrement, et bien dites-vous que pour le système on a des identificateurs pour chaque processus donc chaque chose qui fait tourner un programme qui exécute quelque chose que ce soit plusieurs processus d'un même programme ou un processus par programme. 

Voilà c'est exactement le même principe. 

Voilà je pense qu'on va s'arrêter là par rapport à ça. 

## Point-virgule

Alors je vous rappelle qu'on avait vu qu'on a une commande lancée en arrière plan avec ce symbole &, bien avant on avait parlé du tuple | qui permettait de prendre le résultat d'une commande en entrée pour une autre et nous avons également des cas spécifiques, je peux également rentrer des commandes successives et je suis pas sûr qu'on l'avait abordé précédemment. 

C'est par exemple à un moment donné je veux faire cette commande ls -l et à un moment donné je veux faire un echo OK, je peux faire ces 2 commandes successives en faisant ceci en utilisant un ;

```bash
sam@samVB:~$ ls -l ; echo OK
total 12092
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Bureau
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Documents
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Images
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Modèles
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Musique
-rw------- 1 sam sam 12348744 déc 28 15:16 nohup.out
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Public
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Téléchargements
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Vidéos
OK
```

Voyez que ça fait 2 choses à la suite, ça fait d'abord la première commande et une fois terminé ça fait la 2e donc si on veut des commandes successives on peut utiliser ce genre de ; ce qui est bien pratique.

> rmq: On remarque d'ailleurs le fichier nohup.out qui a été généré. C'est tout le résultat de la commande qui a été enregistré et c'est normal puisque je vous ai dit que quand on utilise nohup, ça délie le processus du terminal du coup ce qui fait qu'on interrompt pas le processus en quittant le terminal et pour cela il crée un fichier nohup.out.

## && et ||

Une fois qu'on a vu tout ça on a également des cas très pratique et on terminera avec ça mais nous avons également 2 symboles très particulier && et || donc en gros si nous avons un code retour correct donc généralement 0, on va s'attendre à récupérer quelque chose avec ce double symbole && et si ce n'est pas cas on fera ce genre de choses ||. 

## Double esperluette

Je vais faire par exemple ceci.

```bash
sam@samVB:~$ cat out.txt && echo "OK"
total 12092
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Bureau
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Documents
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Images
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Modèles
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Musique
-rw------- 1 sam sam 12348744 déc 28 15:16 nohup.out
-rw-rw-r-- 1 sam sam        0 déc 28 15:50 out.txt
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Public
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Téléchargements
drwxr-xr-x 2 sam sam     4096 déc 27 17:39 Vidéos
OK
```

Il me fait la commande et il me dit OK pas de problème et si maintenant je mets un nom de fichier qui n'existe pas.

```bash
sam@samVB:~$ cat out2.txt && echo "OK"
cat: out2.txt: Aucun fichier ou dossier de ce type
```
Vous voyez que ici ça n'a pas affiché le echo tout simplement parce qu'on lui a dit que via ce symbole && tu exécuteras ce qui suit seulement si le code de retour de ce processus cat out2.txt qui a pu être lancé grâce à cette commande retourne 0 donc retourne aucune erreur. 

## Double barre de Sheffer

Si on veut l'inverse on fera un double pipe comme ceci. Et là du coup on pourrait mettre n'importe quoi par exemple PROBLEME.

```bash
sam@samVB:~$ cat out2.txt || echo "PROBLEME"
cat: out2.txt: Aucun fichier ou dossier de ce type
PROBLEME
```

Tandis que bien l'erreur de retour de la commande pour dire que c'est la commande cat telle qu'elle a été programmée qui a dit que ce fichier m'existe et nous indique ensuite qu'il y a eu un problème en utilisant ce type de symbole ||. 

Alors ça peut-être que vous vous en servirez pas forcément et je vous le donne parce que je sais qu'il y a des gens qui veulent aller loin dans les possibilités au niveau du terminal et je pense que ça vous servira. 

Ce n'est pas parce que ce type de symbole existe qu'il faut obligatoirement s'en servir. 

Il y a plein de commandes certainement que vous n'utiliserai jamais ou alors tellement peu que vous les oublierez. 

Voilà ce n'est pas parce qu'une chose existe qu'il faut absolument s'en servir ou se forcer limite à l'utiliser. 

Si vous n'en avez pas l'utilité ça ne sert à rien, ce n'est pas grave si vous l'oubliez et que vous vous en servez pas. 

Voilà en tout cas on peut séparer comme on avait vu pour les flux de direction la sortie standard et la sortie d'erreur donc on peut séparer ici un résultat, un retour suivant le code de retour d'un processus. 

Si le processus n'a pas retourné d'erreur, en utilisant && on peut exécuter autre chose. 

Et si au contraire ça a retourné un code d'erreur, en utilisant le double pipes || on peut effectuer des actions par rapport au fait qu'il y a eu une erreur. 

Voilà un peu la différence entre les 2. 

Logiquement je pense que ça a été suffisamment clair. 

Je pense qu'on va s'arrêter parce qu'il y a encore plein plein d'autres choses qu'on aurait pu aborder mais la majorité des choses que l'on va voir je vais la garder pour la vidéo sur les signaux. 

Parce que jusqu à présent on n'a pas fait grand chose avec les processus à part de voir comment les décomposer, comment on peut éventuellement lancer des tâches en arrière-plan et ça c'est une chose que vous ne saviez pas faire mais que maintenant vous avez appris dans cette séance. 

Vous allez voir ensuite qu'on va manipuler ces processus en ligne de commande en les mettant en pause, en les tuant, en arrêtant des processus, en lançant, en donnant la main, on va gérer pas mal de choses comme ça via des signaux en fait qui permettront de lancer ces différents types d'actions.

Et là vous apprendront de nouveaux types de commandes via le terminal pour pouvoir faire ces petites choses-là. 

S'il y a des questions il ne faut surtout pas hésiter surtout s'il y a des choses que vous n'avez pas comprises. 

Je réduis dans les explications pour pas que ça traîne trop en longueur mais il y a des choses qui ne sont pas suffisamment claires sur lequel vous auriez besoin de revenir en commentaire et n'hésitez pas à demander ça ne me gêne pas de réexpliquer certaines choses ce n'est absolument pas grave. 

À bientôt pour la prochaine vidéo sur ce cours.