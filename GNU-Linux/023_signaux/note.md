# [23. Signaux](https://www.youtube.com/watch?v=hJ0f1Pd-v2Y)

Bonjour et bienvenue sur ce cours GNU Linux on se retrouve avec la séance 23 qui va faire vraiment et très vite suite à la vidéo sur les processus qu'on a vu précédemment puisque nous allons aborder les signaux comme je vous l'avais dit et vous allez voir que c'est quelque chose qui est véritablement lié à ces différents processus qui compose en fait toutes les applications, les programmes que vous pouvez utilisez sur votre système et qui sont gérés par l'ordonnanceur donc toutes les choses qu'on a vu justement dans la séance précédente.

Alors un signal concerne tout simplement un message qu'un processus va pouvoir envoyer à un autre d'accord donc c'est un moyen en fait de communication d'un processus à un autre pour pouvoir demander en fait un certain type d'action ou éventuellement changer l'état ou le statut d'un processus.

Petit rappel dans ce qu'on avait vu précédemment, je vous avais parlé par exemple quand on faisait la fameuse commande `ps -aux` pour lister les processus, on avait leurs différents statuts ici.

```bash
sam@sam:~$ ps -aux

    USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
    root           1  2.1  0.2 167932 11852 ?        Ss   08:19   0:07 /sbin/init splash
    root           2  0.0  0.0      0     0 ?        S    08:19   0:00 [kthreadd]
    root           3  0.0  0.0      0     0 ?        I<   08:19   0:00 [rcu_gp]
    ...
```

Je vous avais rapidement expliqué voilà en fonction des lettres à quoi ça correspondais un processus stoppé, un processus en attentes, etc. On avait abordé pas mal de points par rapport à ça.

La première chose à savoir déjà au niveau de ces signaux c'est une commande qui va nous permettre d'envoyer un certain type de signal particulier et la première commande à connaître au niveau de votre terminal c'est la commande `kill` d'accord.

Alors cette commande ne va pas servir qu'à tuer des processus comme l'indiquerait le nom mais elle va poster tout un tas d'options qui nous permettra de faire différentes actions alors déjà vous n'avez pas forcément besoin de retenir les noms exacts, des types d'accords donc des noms des différents signaux que vous avez mais il y en a même certain que vous n'utiliserez probablement jamais mais pour pouvoir lister ces différents types de signaux vous pouvez passer l'argument donc l'option `kill -l` avec un l minuscule et on retrouve ici un numéro.

```bash
sam@sam:~$ kill -l
 1) SIGHUP	 2) SIGINT	 3) SIGQUIT	 4) SIGILL	 5) SIGTRAP
 6) SIGABRT	 7) SIGBUS	 8) SIGFPE	 9) SIGKILL	10) SIGUSR1
11) SIGSEGV	12) SIGUSR2	13) SIGPIPE	14) SIGALRM	15) SIGTERM
16) SIGSTKFLT	17) SIGCHLD	18) SIGCONT	19) SIGSTOP	20) SIGTSTP
21) SIGTTIN	22) SIGTTOU	23) SIGURG	24) SIGXCPU	25) SIGXFSZ
26) SIGVTALRM	27) SIGPROF	28) SIGWINCH	29) SIGIO	30) SIGPWR
31) SIGSYS	34) SIGRTMIN	35) SIGRTMIN+1	36) SIGRTMIN+2	37) SIGRTMIN+3
38) SIGRTMIN+4	39) SIGRTMIN+5	40) SIGRTMIN+6	41) SIGRTMIN+7	42) SIGRTMIN+8
43) SIGRTMIN+9	44) SIGRTMIN+10	45) SIGRTMIN+11	46) SIGRTMIN+12	47) SIGRTMIN+13
48) SIGRTMIN+14	49) SIGRTMIN+15	50) SIGRTMAX-14	51) SIGRTMAX-13	52) SIGRTMAX-12
53) SIGRTMAX-11	54) SIGRTMAX-10	55) SIGRTMAX-9	56) SIGRTMAX-8	57) SIGRTMAX-7
58) SIGRTMAX-6	59) SIGRTMAX-5	60) SIGRTMAX-4	61) SIGRTMAX-3	62) SIGRTMAX-2
63) SIGRTMAX-1	64) SIGRTMAX
```

Donc ça c'est le numéro du signal en question et le nom qui correspond donc vous voyez qu'ils commencent tous par les trois lettre **SIG** c'est à dire que vous verrez qu'on peut rapidement écrire par exemple le nom d'un des signaux en mettant simplement les lettres qui viennent après le terme **SIG**INT ou son numéro 2) donc maintenant comment on va envoyer déjà un signal ? eh bien on va utiliser toujours cette commande `kill` et on a ici après plusieurs options alors à la fin on mettra le pid du processus et au niveau des options et bien on va pouvoir comme ça spécifier le type de signal à envoyer d'un processus à l'autre.

Je rappelle ici par exemple au niveau de notre terminal nous sommes dans un processus  également, c'est pour ça qu'on est toujours en train de communiquer d'un processus à un autre puisque je vous avais expliqué qu'à partir du moment où on lance un programme, on va avoir un processus qui va l'encadrer ou éventuellement comme par exemple je vous avais parlé des navigateurs web qui eux peuvent en avoir plusieurs ou chaque onglet par exemple de votre navigateur chrome sera en fait encadré par un processus et si vous lancez chrome sur votre système et que vous faites un `ps | grep "chrome"` ou "google" vous allez trouver du coup plusieurs processus listé avec chacun un pid pour chacun des onglets que vous avez d'ouvert, vous verrez qu'il y a plusieurs choses comme ça distinctive au niveau ensuite du système par rapport à comment il est géré.

```bash
sam@sam:~$ ps -aux | grep "firefox"

    sam         2305 18.2  8.2 3192064 332820 ?      Sl   08:33   1:05 /usr/lib/firefox/firefox -new-window
    sam         2382  1.0  3.7 2447408 152236 ?      Sl   08:34   0:03 /usr/lib/firefox/firefox -contentproc -childID 1 -isForBrowser -prefsLen 1 -prefMapSize 223603 -parentBuildID 20210204182252 -appdir /usr/lib/firefox/browser 2305 true tab
    sam         2391  0.5  2.8 2409388 114124 ?      Sl   08:34   0:02 /usr/lib/firefox/firefox -contentproc -childID 2 -isForBrowser -prefsLen 85 -prefMapSize 223603 -parentBuildID 20210204182252 -appdir /usr/lib/firefox/browser 2305 true tab
    sam         2416  0.7  3.4 2479152 137948 ?      Sl   08:34   0:02 /usr/lib/firefox/firefox -contentproc -childID 3 -isForBrowser -prefsLen 1247 -prefMapSize 223603 -parentBuildID 20210204182252 -appdir /usr/lib/firefox/browser 2305 true tab
    sam         2513  0.3  2.1 2391588 87704 ?       Sl   08:34   0:00 /usr/lib/firefox/firefox -contentproc -childID 5 -isForBrowser -prefsLen 10701 -prefMapSize 223603 -parentBuildID 20210204182252 -appdir /usr/lib/firefox/browser 2305 true tab
    sam         2658  0.0  0.0  11476   724 pts/0    S+   08:39   0:00 grep --color=auto firefox
```

## xeyes

![xeyes](xeyes.JPG)

Donc nous ce qu'on va faire, on va lancer un petit programme vous allez voir c'est un petit programme visuel qui est bien pratique qu'on utilise généralement beaucoup pour montrer justement comment fonctionnent les signaux donc je rappelle qu'on a notre processus ici d'accord bash qui est notre terminal et on va lancer un programme très  simple qui est un petit problème graphique en fait qui affiche des yeux qui va suivre en fait le mouvement de la souris.

Je rappelle si je fais une commande simple ici.

```bash
sam@sam:~$ xeyes
```
Si j'exécute une commande ici vous voyez que je n'ai pas la main en fait sur mon terminal puisque le programme se lance donc voici un petit programme qui s'appelle xeyes qui n'est peut-être pas forcément disponibles sur votre distribution linux selon celles que vous  avez installé mais ça s'installe très rapidement après bon moi je me sers de ça pour l'exemple mais vous pouvez bien évidemment utiliser n'importe quel programme alors l'idéal ça peut être un programme graphique voyez qui se lance comme ça et pourquoi pas si vous faites de la programmation Python par exemple ou autre, n'hésitez pas à vous faire un petit code avec Pygame ou autre, une petite interface graphique ou un programme en 2D que vous exécutez de cette manière et qui du coup vous retire en fait la main par exemple sur votre terminal.

Ca on l'avait expliqué précédemment d'accord et que là on perdait la main par rapport au programme puisque c'est lui qui est du coup en train d'être exécuté et que le seul moyen c'est soit de l'interrompre, éventuellement de le stopper mais ça on va vite le voir ou alors tout simplement de quitter ce programme d'accord.

```bash
sam@sam:~$ xeyes
^C
sam@sam:~$ 
```

Si on veut pouvoir l'exécuter en arrière-plan on avait également vu ça la dernière fois en faisant tout simplement `xeyes &` avec le petit et commerciales ou carrément pour le détacher du terminal de faire un `nohup` d'accord c'est des choses qu'on avait abordé.

Donc si je fais par exemple ça là.

```bash
sam@sam:~$ xeyes &
[1] 2711
sam@sam:~$ 
```

On a le numéro du pid, de l'identifiant du processus qui est indiqué et en plus de ça on garde la main sur le terminal et notre programme s'exécute en parallèle, plutôt en arrière-plan donc on peut continuer de travailler pendant que notre programme est exécuté.

Alors nous on va travailler avec ce petit programme là d'accord pour exécuter tout un tas de petites choses.

Alors déjà on a encore une fois, on rappelle, on a différents types de processus, de signaux.

```bash
sam@sam:~$ kill -l
 1) SIGHUP	 2) SIGINT	 3) SIGQUIT	 4) SIGILL	 5) SIGTRAP
 6) SIGABRT	 7) SIGBUS	 8) SIGFPE	 9) SIGKILL	10) SIGUSR1
11) SIGSEGV	12) SIGUSR2	13) SIGPIPE	14) SIGALRM	15) SIGTERM
16) SIGSTKFLT	17) SIGCHLD	18) SIGCONT	19) SIGSTOP	20) SIGTSTP
21) SIGTTIN	22) SIGTTOU	23) SIGURG	24) SIGXCPU	25) SIGXFSZ
26) SIGVTALRM	27) SIGPROF	28) SIGWINCH	29) SIGIO	30) SIGPWR
31) SIGSYS	34) SIGRTMIN	35) SIGRTMIN+1	36) SIGRTMIN+2	37) SIGRTMIN+3
38) SIGRTMIN+4	39) SIGRTMIN+5	40) SIGRTMIN+6	41) SIGRTMIN+7	42) SIGRTMIN+8
43) SIGRTMIN+9	44) SIGRTMIN+10	45) SIGRTMIN+11	46) SIGRTMIN+12	47) SIGRTMIN+13
48) SIGRTMIN+14	49) SIGRTMIN+15	50) SIGRTMAX-14	51) SIGRTMAX-13	52) SIGRTMAX-12
53) SIGRTMAX-11	54) SIGRTMAX-10	55) SIGRTMAX-9	56) SIGRTMAX-8	57) SIGRTMAX-7
58) SIGRTMAX-6	59) SIGRTMAX-5	60) SIGRTMAX-4	61) SIGRTMAX-3	62) SIGRTMAX-2
63) SIGRTMAX-1	64) SIGRTMAX
```

Il y a plusieurs types différents. Il y en a plein que je ne vais pas vous expliquer parce qu'il y en même que je ne connais pas forcément ou en tout cas j'en ai pas l'utilité personnellement donc ils n'ont pas forcément d'utilité pour certains cas, ils sont bien précis donc on peut trouver les détails de tous ces types de signaux en  fonction mais on va surtout se contenter de certains.

Alors déjà on a notre programme qui tourne.

```bash
sam@sam:~$ xeyes & #on le lance et on le quitte directement.
[2] 2718
sam@sam:~$ xeyes &
[3] 2719
[2]   Fini                    xeyes
sam@sam:~$ 
```

On a le ici le pid `[3] 2719` donc l'identifiant du processus qui est là et on va pouvoir se servir de ce pid justement pour travailler.

On pourrait toujours encore une fois, je rappelle, faire un `ps | grep "xeyes"` simplement pour le retrouver.

```bash
sam@sam:~$ xeyes &
[2] 2718
sam@sam:~$ xeyes &
[3] 2719
[2]   Fini                    xeyes
sam@sam:~$ ps | grep "xeyes"
   2711 pts/0    00:00:01 xeyes
   2719 pts/0    00:00:00 xeyes
sam@sam:~$ 
```

Voilà on retrouverais ce numéro éventuellement si on en a besoin et voilà ici ça nous le donne directement donc on gagne du temps autant passer par là.

## SIGSTOP

On va du coup depuis notre terminal ici envoyer un signal d'accord au processus qui fait tourner justement l'application `xeyes` pour changer son état donc là il est en exécution d'accord vous voyez qu'il suit exactement les mouvements de la souris donc c'est un petit la particularité de ce type de petit programme donc c'est pour ça que c'était bien pratique pour vous montrer ça en tant qu'exemple pour la vidéo.

Et on va le mettre en pause c'est à dire qu'on va stopper en fait le processus pour qu'il attend en fait quelque chose donc qu'il attend par exemple qu'on le réveille d'accord qu'on le sorte de son sommeil.

Pour mettre en pause, on a tout simplement le signal qui est sigstop d'accord donc c'est très simple à connaître et on peut juste marquer stop.

Alors il y a plusieurs syntaxe après je n'en ferai qu'une seule parce qu'il en y a vraiment plusieurs.

Vous pouvez soit mettre la commande `kill` et vous suivez ensuite du numéro qui concerne la commande pour stop c'est 19 donc on peut vérifier.

```bash
sam@sam:~$ kill -l
	19) SIGSTOP	...
```

Donc vous pouvez faire comme ça `KILL -19` qui correspond au signal sigstop ou alors vous mettez tout le nom complet ou alors vous mettez juste ce qui vient après sig donc là c'est stop, ou alors un `-s` pour dire j'envoie un signal et là pareil je peut mettre sigstop ou 19 ou le nom un peu plus réduit.

```bash
KILL -19 #19 pour le signal sigstop.
KILL -SIGSTOP
KILL -STOP
KILL -s SiGSTOP
KILL -s 19
KILL -s SiG
```

Il y a vraiment plein de syntaxes, à vous d'adopter celle que vous voulez et après on prend très vite l'habitude de passer par les numéros parce que bon on se souvient plus facilement des numéros des fois que des noms parce qu'on a l'habitude d'utiliser très souvent pas mal de types de signaux notamment le `-9` qu'on verra pour tuer KILL, un processus dont on verra plus tard donc là on va stopper ce processus donc je vais lui envoyer 19 et ensuite on indique le numéro du pid concerné par rapport au processus qu'on veut stopper.

```bash
sam@sam:~$ xeyes &
[2] 2718
sam@sam:~$ xeyes &
[3] 2719
[2]   Fini                    xeyes
sam@sam:~$ ps | grep "xeyes"
   2711 pts/0    00:00:01 xeyes
   2719 pts/0    00:00:00 xeyes
sam@sam:~$ kill -19 2719
```

Donc je fais ceci et là vous voyez qu'il me dit qu'il est arrêté et la voyez que mon application ne réagit plus, elle continue d'exister d'accord on n'a pas tué le processus mais elle est vraiment stoppée, elle en sommeil.

## SIGCONT

Du coup je peux continuer de faire pas mal de choses ça ne changera pas, pour réveiller ce programme donc l'inverse en fait de stop qui va en fait vraiment mettre en sommeil le processus, pour réveiller un processus qui est endormi, on va utiliser le signal SIGCONT qui est le numéro juste avant.

```bash
sam@sam:~$ kill -l
	18) SIGCONT	...
```

On va faire ça 18 et là on reprend la main en fait tout simplement sur notre programme d'accord.

```bash
sam@sam:~$ kill -19 2719

[3]+  Arrêté                xeyes
sam@sam:~$ kill -18 2719
```

## SIGKILL

Très important et pour tuer ce processus donc des fois vous aurez besoin de fermer un programme qui ne marche pas, qui plante ou je ne sais quoi, hé bien là plutôt que de redémarrer votre système ou de faire un reset, vous pouvez voir le processus en question d'accord qui peut poser problème et généralement on fait un simple `-9` puis le processus en question et là on kill tout simplement.

```bash
sam@sam:~$ kill -19 2719

[3]+  Arrêté                xeyes
sam@sam:~$ kill -18 2719
sam@sam:~$ kill -9 2719 #kill le programme simplement.
sam@sam:~$ 
```
Pour ceux qui sont sur windows par exemple parce que pour windows pour beaucoup ça reviendrait en fait à passer par gestionnaire de tâches et de faire un fin de tâche tout simplement, d'arrêter une tâche comme ça à la main donc par méthode graphique même si on pourrait le faire aussi en ligne de commande et voilà ça revient à killer le processus pour ne pas à avoir à faire un reset du pc.

Alors ça c'est ce qu'on fait quand on ne sait pas utiliser malheureusement son ordinateur et quand on sait se servir de son système avant d'appuyer sur le bouton reset de la tour ou du pc portables et bien évidemment on parle en termes de processus donc on cherche à `kill` le processus qui bloque d'accord qui est buggé ou qui a planté avant de devoir tout arrêté ou tout redémarrer.

Voilà comment ça se passe de ce côté alors on peut par exemple enchaîner ces commandes c'est à dire qu'on peut très bien lancé un autre programme.

```bash
sam@sam:~$ xeyes &
[1] 4763
sam@sam:~$ 
```

Là donc voyez là il a un autre PID, c'est parfaitement normal.

## sleep

Je vais maintenant enchaîner par exemple des commandes on va d'ailleurs voir une petite commande très simple qui est `sleep` qui va tout simplement dire de faire une pause en fait un certain nombre de secondes donc si par exemple je fais ça.

```bash
sam@sam:~$ sleep 2 #pause de 2 secondes.
sam@sam:~$ 
```

Si par exemple je fais ça, là voyez qu'il y a deux secondes qui vont se passer et je vais récupérer la main sur mon programme donc ça on peut très bien s'amuser.

Là mon programme xeyes est parfaitement disponible et je peux lui dire `kill -19 4763 ;` suivi d'un point virgule d'accord pour faire des commandes successive et lui dire tu vas garder cet état endormi pendant 5 secondes `kill -19 4763 ; sleep 5` donc ce n'est pas 5 secondes exactement quand on manipule du temps comme ça en informatique, vous verrez que c'est pas vraiment 5 secondes exactement exactement 5 secondes. Il peut y avoir des fois des petits décalages mais voilà en termes informatique on parle de 5 secondes. Ensuite on va réveiller ce processus `kill -19 4763 ; sleep 5 ; kill -18 4763`.

```bash
sam@sam:~$ kill -19 4763 ; sleep 5 ; kill -18 4763 #endore le processus 5 secondes.
sam@sam:~$ 
```
Je lance la commande et là vous voyez qu'il réagit pas de problème, puis il se met en sommeil ça va durer cinq seconde où je continue de bouger la souris et au bout de cinq secondes ça va faire le `kill -18` et voilà ça va réveiller le processus d'accord.

Voilà c'était histoire de revoir ce petit point-virgule qu'on avait abordé dans la vidéo précédente pour montrer un petit peu comme ça qu'on peut hé bien exécuter une commande ensuite une fois que `kill -19 4763` est terminée donc seulement quand elle est terminée parce que c'est pas un pipe `|`, rappelez vous, on ne récupère pas le résultat forcément de la commande d'avant, c'est juste ont fait une commande et ensuite on en fait une autre et ensuite on en fait une autre ça permet d'exécuter des commandes successives en une seule ligne plutôt que de devoir faire:

```bash
sam@sam:~$ kill -19 4763
sam@sam:~$ sleep 5
sam@sam:~$ kill -18 4763 
sam@sam:~$ 
```

Voilà on clic successivement sur enter d'autant que si vous faites le `sleep` tout de suite vous n'aurez pas la main sur le terminal n'oublier pas.

En faisant tout à la suite comme ça, ça permet de continuer à travailler à côté sans forcément tout bloquer.

## ctrlZ

voilà donc ça c'est plutôt pratique et on peut comme cela vous voyez envoyer un signal différents alors le SIGSTOP ça correspondrait en fait un ctrl+Z c'est à dire qu'en gros si vous avez un programme qui est lancé `xeyes` et qu'en fait on envoi un signal avec stop en fait ça reviendrait à faire un ctrl+Z.

```bash
sam@sam:~$ xeyes
^Z
[2]+  Arrêté                xeyes
sam@sam:~$ 
```

Voilà j'ai fait un ctrl+Z avec mon clavier `^Z` ça fait ce genre de symbole correspondant au fait qu'on appuie sur le clavier avec la touche control et z, et ça revient à envoyer un signal c'est à dire qu'avec votre clavier quand vous faites ctrl+Z et bien votre clavier envoie le signal justement `stop` au processus qui est en cours de démarrage d'accord qui est concerné donc là ça arrêtez xeyes.

Si je récupère le PID avec `ps | grep "xeyes"` et  après je peux toujours le relancer `kill -18 ...`.

```bash
sam@sam:~$ ps | grep "xeyes"
   4763 pts/0    00:00:11 xeyes
   5246 pts/0    00:00:00 xeyes
sam@sam:~$ kill -18 5246
sam@sam:~$ 
```

Voilà et on récupère la main dessus d'accord donc on peut faire ce genre de choses.

## ctrlC

On peut également interrompre d'accord non pas `kill` directement mais interrompre donc arrêter vraiment notre processus et ça ça correspond donc si je retourne ici.

```bash
sam@sam:~$ kill -l
	2) SIGINT	...
```

Voyez SIGINT qui est simplement le numéro 2, ça reviendrait à faire un ctrl+C.

## kill

Voilà ça vous est sûrement déjà arrivé d'exécuter une longue commandes rappelez-vous comme dans la vidéo présidente lorsqu'on avait fait ça.

```bash
sam@sam:~$ ls -R /
```

Par exemple et c'est trop long donc on n'a pas envie d'attendre jusqu'au bout dons qu'est ce qu'on fait sur le clavier ? On fait un ctrl+C et hop ça interrompt d'accord la commande.

Voilà quand vous faites ça, même chose n'oubliez pas voilà que les processus communiquent. Il ne faut pas imaginer qu'on appuie sur le clavier et que ça fait quelque chose d'autres, c'est votre clavier qui est un périphérique d'entrée, de lecture et votre système attend quelque chose, une action de ce clavier éventuellement.

On dit qu'il est en écoute sur votre clavier, sur votre souris, sur pas mal d'autres éléments donc si vous faites un ctrl+C votre clavier va envoyer en fait un signal SIGINT donc d'interruption qui va interrompre le processus en cours et du coup ça reviendrait exactement à faire un `kill -2 <pid>` par exemple du processus en question d'accord.

Voilà donc ça c'est les types de signaux à connaître, INT pour l'interruption, STOP pour arrêter un processus d'accord le mettre en sommeil. CONT pour continue donc reprendre, réveiller un processus qui était endormi et on a le fameux `kill` qui tue vraiment un processus, on arrête complètement tout, toute l'exécution et tout se ferment.

Alors la simple fermeture de programme [x] ou ctrl+W éventuellement, souvent de ctrl+W ferme un logiciel graphique et bien ça envoie un signal qui logiquement tue les processus alors ça ça résout une petite partie de tout ce qui concerne l'exécution de nos programmes mais je vous avais expliqué aussi qu'il y avait certains programmes par exemple le navigateur web qui peuvent avoir plusieurs processus.

Si on utilise la commande `kill` vous avez vu que la commande `kill` travaille avec un pid en particulier mais si on a par exemple chrome et que l'on souhaite quitter complètement donc en supprimant tous les processus autour, la commande `kill` ne va pas suffire il faudrait que vous supprimez chaque processus 1 par 1.

Alors on peut le faire on peut s'amuser à faire par exemple ce genre de chose en mettant par exemple un premier pid et puis un deuxième et un troisième et cetera.

```bash
sam@sam:~$ kill -9 1000 1001 1002
```

## killall

On peut comme ça les enchaîner mais voilà c'est pas forcément très pratique c'est un peu long à faire donc il existe une autre commande que `kill` qui va permettre de supprimer donc ça pour ceux qui sont sur Windows ça correspondrait au fait de terminer l'arborescence des tâches, eh bien nous avons la commande `killall` qui est correspondante.

`killall` ne va pas prendre un pid parce qu'encore une fois c'est pour supprimer tous les processus d'un même programme mais tout simplement le nom du processus en question donc on va par exemple avoir reçu pas moins de 15 processus pour google chrome mais ils auront tous le même nom d'accord le nom sera le même par  contre le pid sera différent donc en faisant par exemple un `killall chrome` si il s'appelle par exemple comme ça parce que des fois ça s'appelle google-chrome mais peu importe vous allez quitter tous les processus correspondant à cette application.

```bash
sam@sam:~$ killall google-chrome
```

Alors avec firefox, on va lancer genre plein d'onglets et on exécute la commande.

```bash
sam@sam:~$ ps -auwx | grep "firefox" > res.out
sam@sam:~$ 
```
[res.out](res.out)

Voilà on voit du coup plein de fois Firefox donc on a finallement chaque ligne par rapport à un onglet, et on a plein plein plein de pid correspondant.

```bash
sam         2305  0.5  8.1 3274340 329304 ?      Sl   08:33   4:44 /usr/lib/firefox/firefox -new-window
...
```

On voit bien que ça vient de moi puisque c'est mon nom d'utilisateur, c'est bien moi le propriétaire de ces processus et on a plein de choses qui sont reliés à firefox donc si on veut tout quitter ? 

On va regarder pour avoir les détails, on a pas mal de choses lié a firefox.

```bash
sam@sam:~$ ps -elf | grep "firefox"

    4 S sam         2305    1040  0  80   0 - 820112 poll_s 08:33 ?       00:04:52 /usr/lib/firefox/firefox -new-window
    4 S sam         2382    2305  0  80   0 - 613734 poll_s 08:34 ?       00:00:21 /usr/lib/firefox/firefox -contentproc -childID 1 -isForBrowser -prefsLen 1 -prefMapSize 223603 -parentBuildID 20210204182252 -appdir /usr/lib/firefox/browser 2305 true tab
```

Et ce que nous allons faire nous ici ? et si on essaye de `kill` un des processus, on va pas tous fermer on va par exemple fermer un onglet d'accord on va fermer qu'une partie du programme mais on peut s'amuser je pense que le nom va être "firefox" à faire ceci.

```bash
sam@sam:~$ killall firefox
```

Et là voyez qu'on quitte absolument tout donc là normalement je ne devrais plus retrouver du firefox dans la liste.

```bash
sam@sam:~$ ps -elf | grep "firefox"

    0 S sam         6108    5964  0  80   0 -  2869 pipe_r 22:11 pts/0    00:00:00 grep --color=auto firefox
```

Ah oui celui là oui, il y a un processus qui a été ouvert parce que j'ai fait un `grep` d'accord.

Je vous avait dit en plus il y a un pipe qui a été fait, hé bien oui ça devient processus, ça a été stocké dans un processus donc là on n'a plus du tout de traces de l'exécution de ce qu'on a pu faire avec Firefox donc le navigateur qui avait été lancé avec tous les onglets qui étaient à l'intérieur.

Voilà donc si vous avez besoin de quitter tous les processus via une application, un programme vous  utiliserez la commande `killall`.

Si c'est pour intervenir sur un seul procèssus en particulier donc via son pid, on utilisera du coup la commande `kill` avec toutes les options que je vous ai montré.

Vous voyez qu'il y a du coup pas mal de choix et pas mal de possibilités.

Voilà pour la partie qui était la plus importante à mon sens concernant les signaux d'accord pour pouvoir manipuler, envoyer des messages en fait d'un processus à l'autre et vous verrez que vous pourrez vous amuser avec pas mal de choses.

Déjà ça ça vous permet de comprendre comment fonctionne vos périphériques, tout ça et ne pas se dire voilà qu'un clavier, une souris ça n'envoie rien, ça communique aussi puisque ça travaille justement avec les processus, ça envoie des signaux ensuite ça vous permet de voir comment les utiliser, les manipuler en ligne de commande.

Comment vos programmes graphiques les manipulent d'accord de savoir quand on clique ici sur la croix de mon terminal, bah c'est pas juste le fait de dire tu éteint tout mais c'est qu'on envoie un signal qui avertit en fait d'une action effectuée et après pour ceux qui font de la programmation sachez bien évidemment qu'on fait de la programmation système sur linux.

Vous pouvez bien sûr manipuler des processus, faire même des fork, ce genre de choses, travailler avec des processus fils, processus père et tout ça mais vous pouvez bien évidemment envoyer aussi des signaux ou alors faire un petit programme comme on le verra dans le dernier chapitre de ce cours quand on va faire de la programmation dans des scripts bash, on va voir qu'on pourra sans problème envoyer des signaux aussi depuis nos cript puisque dans un script on peut utiliser des commandes unix donc il n'y a aucun problème par rapport à ça.

Voilà pour cette petite partie, on va attaquer une autre petite partie de cette vidéo avant d'en terminer parce qu'on n'a pas grand chose à voir.

Il y a beaucoup moins de choses à voir pour le coup que ce qu'on a vu sur les processus précédemment notamment pour tout ce qui est traitement de tâches mais pour gérer cette histoire de priorité, rappelez vous, on n'a pas mal parlé de processus qui s'exécute en arrière-plan, de choses qui s'exécute en premier plan et du coup vous enlève en fait la main par exemple sur votre autre processus donc là en l'occurrence le terminal puisque c'est de là qu'on lance non commandes et on va pouvoir manipuler pas mal de choses.

On avait la différence encore une fois de faire ce genre de commande d'accord où on n'a pas la main sur notre terminal donc sur le processus qui a lancé un autre processus. On est obligé de quitter pour récupérer la main.

```bash
sam@sam:~$ xeyes
```

Et sinon on avait ce genre de choses `xeyes &` qu'on avait aborder qui permet de faire ça en tâche de fond, en arrière-plan.

```bash
sam@sam:~$ xeyes
sam@sam:~$ xeyes &
[1] 6219
sam@sam:~$ 
```

Maintenant on va voir qu'est ce qu'il se passe en réalité par rapport à ça.

On peut sans problème faire et ça on l'a vu tout à l'heure ceci et là on lance ce programme.

```bash
sam@sam:~$ xeyes
^Z           
[2]+  Arrêté                xeyes
sam@sam:~$ 
```

Je vous ai expliqué qu'en faisant un ctrl+Z on va stopper le processus et l'avantage c'est qu'un processus qui est stoppé, on va pouvoir faire tout un tas de manipulation.

## fg

Il existe deux petites commandes très pratique par rapport à ça, vous avez la commande `fg` pour foreground ... qui va tout simplement dire de passer un processus stoppé d'accord qui a reçu un signal SIGSTOP et je rappelle maintenant que vous savez ce que c'est donc voilà on peut bien avancé logiquement pour la suite ... pour lui dire tu le met au premier plan d'accord.

```bash
sam@sam:~$ xeyes
^Z           
[2]+  Arrêté                xeyes
sam@sam:~$ fg
xeyes
_
```

Donc ici voyez xeyes est repassé au premier plan donc on revient à l'état de tout à l'heure d'accord il a la main sur tout.

```
sam@sam:~$ xeyes
^Z           
[2]+  Arrêté                xeyes
sam@sam:~$ fg
xeyes
^Z
[2]+  Arrêté                xeyes
sam@sam:~$ 
```

Je refais un ctrl+Z ça restop donc ça remet en sommeil le processus et nous avons une autre commande qui est `bg` pour background.

## bg

La commande `bg` pour background donc là c'est l'inverse c'est-à-dire pour exécuter ça en arrière-plan d'accord donc là je fais ça et là automatiquement, on a le programme qui s'exécute en arrière-plan.

```bash
sam@sam:~$ xeyes
^Z           
[2]+  Arrêté                xeyes
sam@sam:~$ fg
xeyes
^Z
[2]+  Arrêté                xeyes
sam@sam:~$ bg
[2]+ xeyes &
sam@sam:~$ 
```

Donc c'est quand même vachement vachement pratique par rapport à ça donc ça peut être pas mal utile d'avoir ce genre de fonctionnement si on veut bas quand on a eu un processus lancé en premier plan, de le passer en arrière plan ou inversement d'accord on peut toujours changer éventuellement ce qu'on avait fait en cours de route. C'est pas au départ qu'il faut choisir la bonne option et après terminé, non.

On peut, rappelez vous, tout manipuler, tout changer si on veut par rapport à ça.

On a vraiment beaucoup plus de contrôle sur notre système et sur toutes les processus exécutés ou à exécuter donc c'est là que ça a quand même beaucoup d'intérêt.

```bash
sam@sam:~$ bg
[2]+ xeyes &
```

Donc la voyez, il vous montre même en fait qu'il a refait du coup un xeyes avec le petit et commercial `xeyes &` voilà c'est à dire background ´bg´ ça revient exactement à faire `xeyes &` et `fg` ça revient à exécuté simplement la commande normale `xeyes`.

Voilà c'est bien de connaître un peu ces différents outils qui vous permettrons de voir comment tout ça tourne.

## jobs

On a d'ailleurs une commande aussi qui est `jobs` qui va tout simplement vous indiquer les processus en tâche de fond qui sont en train de tourner avec notamment un numéro d'accord pour pouvoir effectuer pas mal de choses.

```bash
sam@sam:~$ jobs
[1]-  En cours d'exécution   xeyes &
[2]+  En cours d'exécution   xeyes &
sam@sam:~$ 
```
C'est à dire qu'à un moments donné, je peux dire ben  tiens tu passe en premier plan le processus numéro 1 ici qui est dans la liste des jobs d'accord avec un symbole %.

```bash
sam@sam:~$ jobs
[1]-  En cours d'exécution   xeyes &
[2]+  En cours d'exécution   xeyes &
sam@sam:~$ fg %1
xeyes
_
```

Et là le processus n°1 repasse au premier plan d'accord, je le re-stop et on peut refaire d'autres choses aussi.

Or il y a toujours ce numéro 1 et on peut dire `bg %1`.

```bash
sam@sam:~$ jobs
[1]-  En cours d'exécution   xeyes &
[2]+  En cours d'exécution   xeyes &
sam@sam:~$ fg %1
xeyes
^Z
[1]+  Arrêté                xeyes
sam@sam:~$ bg %1
[1]+ xeyes &
sam@sam:~$ 
```
Et là n°1 repasse en arrière-plan donc je peux continuer de faire autre chose à la place.

Voilà donc ça peut prendre ça comme option, vous mettez un % et vous passez le numéro d'accord du processus en question ou en tout cas de la tâche alors on parle de tâches plus que de processus en l'occurrence qui est donc disponible en tout cas dans la liste des `jobs`.

`jobs` vous indique tout ce qui est en exécution ici et à partir de ce numéro vous pouvez identifier précisément la tâche que vous voulez passer en premier plan au premier plan ou la tâche que vous voulez passer en arrière-plan.

Voila donc un un lot de trois commandes comme ça qui fonctionnent bien ensemble soit `jobs` `bg` et `fg` qui peut s'utiliser pour ça et qui bien évidemment derrière manipulent beaucoup les signaux.

C'est pour ça qu'il fallait que je vous explique tous les signaux avant, comment on manipule tout ça pour que vous puissiez bien comprendre et l' usage de ces commandes, et l'utilité qu'elles pourront éventuellement avoir pour nous.

Et je pense qu'on va pouvoir s'arrêter là puisque j'ai abordé tout ce que je voulais vous dire.

Voilà on va s'arrêter ici, on va refaire un petit `ps | grep xeyes`.

```bash
sam@sam:~$ xeyes &
[1] 6448
sam@sam:~$ ps | grep xeyes
   6448 pts/0    00:00:00 xeyes
```

## kill kill

Voyez vous pouvez faire `kill -kill 6448` avec le numéro du pid et c'est terminé.

```bash
sam@sam:~$ xeyes &
[1] 6448
sam@sam:~$ ps | grep xeyes
   6448 pts/0    00:00:00 xeyes
sam@sam:~$ kill -kill 6448
sam@sam:~$ 
```

Donc c'est très rapide et ça permet de faire beaucoup de choses. C'est très important de pouvoir comme ça comprendre comment fonctionnent les processus et les signaux.

C'était une grosse partie de ce cours qu'il fallait que j'aborde avec vous et qui n'est pas forcément très très simple au départ mais qui aide énormément à comprendre comment le système fonctionne.

Voilà comment le système gère un petit peu l'exécution de toutes vos applications, ne pas penser qu'une application c'est juste une fenêtre qu'on lance en cliquant sur un menu et qu'il n'y a que ça et terminé, il n'y a rien en dessous et qu'on peut rien gérer derrière.

Autres petite chose par exemple, je pense que j'en avais déjà parlé mais ça fait pas de mal aussi de rappeler. Si je fais par exemple un lancement d'une application directement en mode graphique d'accord donc vous êtes en mode windows c'est à dire que votre applications qui s'exécute est terminée.

On a donc absolument aucune information derrière qui est récupérable, on peut bien évidemment mais c'est pour ça que j'en fais un petit rappel, exécuter ça en ligne de commande d'accord c'est dire que là on a un processus qui va en lancer un autre. Je peux genre faire ceci pour garder la main `firefox &`.

```bash
sam@sam:~$ firefox &
[1] 6793
sam@sam:~$ 
```

Du coup sur votre firefox s'il y a la la moindre erreur, le moindre problème, un message serra envoyé ici d'accord tous les retours seront envoyés dans votre terminal donc ça permet d'avoir plus ou moins une espèce de système de log qui vous permet de voir s'il y a un souci avec un programme comment il s'exécute.

Souvent par exemple je prends l'exemple pour ceux qui des fois me contacte au sujet d'un programme graphique quel qu'il soit un navigateur, un discord ou peu importe le logiciel et vous essayez le lancer votre logiciel graphique et puis il se ferme directement et souvent ça c'est parce qu'il y a une erreur. Il y a quelque chose qui s'est produit qui n'aurait pas dû se produire et le problème c'est que quand on a un programme qu'on lance et qui se ferme tout de suite impossible de savoir pourquoi ça fait ça, impossible !

Donc si vous avez ce genre de problème que ce soit d'ailleurs sur windows ou même linux ou macos peu importe, là pour le coup c'est un conseil qui est très général peu importe le système hé bien vous exécutez ça depuis un terminal.

Vous lancez votre programme depuis un terminal et là forcément l'application graphique se referme tout de suite puisque vous avez ce problème là et automatiquement ça vous renverra en tout cas si le programme a été bien développé et généralement par rapport à ça c'est le cas pour les cas d'erreur eh bien vous aurez un message qui s'affichera pour vous dire ce qui a planté.

Ca peut être une bibliothèque manquantes ou une option qui ne va pas enfin bref n'importe quoi, il y aura forcément un message qui pourra vous avertir du problème qui a été rencontré qui fait que votre programme par exemple graphique ne se lance pas donc ça évidemment tout à fait son utilité donc on n'hésite pas à s'en servir parce que c'est utile.

Là vous voyez il n'y a pas eu de problème comme on a  quitté proprement Firefox donc il n'a pas envoyé d'erreurs de quoi que ce soit donc on n'hésite pas un petit peu à comprendre tout ça et voir un peu comment ça fonctionne et vous aurez bien évidemment beaucoup plus de contrôle sur votre système.

Plutôt que d'être vraiment très passif dans son utilisation a ne pas comprendre ce que vous faites, ce que vous utilisez et bien là au moins vous savez exactement comment ça fonctionne derrière et ça va vous éviter beaucoup beaucoup de problèmes parce que dés que vous aurez une erreur, un bug, n'importe quoi sur votre système que vous utilisez probablement tous les jours pour beaucoup et bien au moins vous saurez comment le corriger et pas forcément voilà rester comme ça dans l'ignorence de se dire je ne comprends pas ce qui se passe, pourquoi ça bug et je peux rien faire...

C'est un petit peu dommage quand on ne peut pas forcément corriger les choses.

Je vous dis du coup à bientôt pour la séance 24, on va aborder encore pas mal d'autres choses.

Je pense que pour la prochaine séance, je vais vous parler de tout ce qui est tâche mais en fait planifiée.

Là on a vu pas mal de choses concernant des jobs, concernant les processus, les signaux donc là on va voir qu'on peut planifier pas mal de commandes d'accord par exemple à l'avance pour pouvoir très vite par la suite aborder le réseau.

D'accord on terminera sur un gros chapitre sur le réseau et ensuite on ira sur le tout dernier chapitre de ce cours qui concernera donc tout simplement de la programmation.

Programmation dans des scripts shell donc voilà ça terminera le cours Linux mais voyez il y a encore pas mal de choses mine de rien à voir.

Je pense qu'on sera dans la bonne trentaine - quarantaine de vidéos à la fin au niveau de ce cours.

J'espère que ça vous a plu je vous dis à bientôt pour la suite et n'hésitez pas si à des commentaires a laisser sous la vidéo.

A bientôt tout le monde.