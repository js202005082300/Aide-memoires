# [24. Planification de tâches](https://www.youtube.com/watch?v=kdGaurPWL10)

Bonjour tout le monde on se retrouve pour la vidéo numéro 24 sur le cours consacrés à linux pour terminer à priori avec la dernière séance qui va clore un autre chapitre de cette formation pour tout ce qui relie l'administration système, le fonctionnement en fait de toutes nos applications, les processus et comment ils communiquent au travers de signaux donc tout ce qu'on a abordé précédemment.

A la suite de cette vidéo, on pourra commencer à attaquer tout ce qui concerne le réseau donc plus seulement ce qui est local mais de parler de réseau et bien évidemment internet pour terminer comme je l'avais dit avec le dernier chapitre sur la création de scripts donc la programmation de scripts en bash.

Alors pour cette vidéo nous allons voir comment planifier des tâches puisque c'est quelque chose qu'on est amené à faire très très souvent quand on fait de l'administration système, si vous êtes habitué par exemple sur windows c'est peut-être certainement quelque chose que vous faites régulièrement pour beaucoup et on peut s'en servir pour tout un tas de traitement on peut par exemple s'en servir pour faire de la sauvegarde de fichiers d'accord faire des backups de manière automatique et avec par exemple des heures régulières ou ce genre de choses.

On peut s'en servir pour faire du nettoyage de fichiers du système pour faire la mise à jour du système bref ça permet en fait d'automatiser beaucoup de choses qu'on n'a plus ensuite à faire manuellement, nous, en tant qu'utilisateur donc qui dit tâche à planifier dit forcément heures, date d'accord et tout un tas de choses comme ça à prendre en compte et on va justement aborder les commandes qui vont nous permettre de travailler là dessus.

## date

Alors une date que vous avez en tout cas ici pour votre terminal la possibilité d'utiliser la commande `date`.

```bash
sam@sam:~$ date
jeu 25 fév 2021 12:36:29 CET

jachampagne@nunux:~$ date
vendredi 24 mai 2019, 18:37:44 (UTC+0200)
```

La commande date si je l'utilise va me retourner une date avec ce type de format donc on a énormément d'informations d'accord on a le jour de la semaine, on a le numéro du jour, on a le nom en toute lettre du mois, l'année et on à l'heure, les minutes, les secondes, le fuseau horaire et on a même éventuellement le décalage par rapport aux fuseaux horaires d'accord donc on est en UTC+02 ici en horaire française puisque nous sommes en heure d'été je rappelle et qu'ici vous avez une heure française qui est affichée donc ce sera évidemment différent si vous appartenez à un autre fuseau du globe.

Alors à partir de là, on va éventuellement déjà voir comment on peut changer un petit peu ce formatage au niveaux de cette date d'accord parce qu'il y a des jokers en fait à connaître qui permettent de formater des choses bien précises et comme ils n'y en avait pas mal quand même que je voulais aborder voilà je les ai préparées en avance pour ne pas avoir à les refaire tous à la main et que ça rallonge la vidéo inutilement donc je vous ai préparé un petit fichier que vous pouvez comme ça va récupérer, recopier, etc en mettant en pause la vidéo, prendre note comme vous voulez des infos ici.

```txt
%A ou %a    : jour (lettres - complet ou abrégé)
%B ou %b    : mois (lettres - complet ou abrégé)

%d          : numéro du jour (01 à 31)
%M          : numéro du mois (01 à 12)
%Y ou %y    : numéro de l année (ex : 2019 ou 19)

-------------------------------------------------------------

%H          : heure (00 à 23)
%M          : minute (00 à 59)
%S          : seconde (00 à 59)

-------------------------------------------------------------

Raccourcis 
%F <=> %Y-%m-%d
%T <=> %H:%M:%S
```

En gros nous allons aller assez vite puisque vous allez voir c'est très très simple, la possibilité d'afficher donc le jour en lettres en utilisant par exemple `%A` qui va donc afficher le jour bien précis soit de manière complète donc ces quand on l'écrit en majuscules et la partie abrégé c'est quand on l'écrit en minuscule vous allez avoir la même chose pour le mois d'accord lorsqu'on marquer donc janvier par exemple en toutes lettres ou en abrégé avec `%b` et ensuite on va retrouver les formats habituels qu'on retrouve d'ailleurs dans beaucoup d'autres choses par exemple des langages de programmation quand on travaille sur des bases de données.

Dans les bases de données, on retrouve beaucoup ces choses là aussi avec notamment le numéro du jour donc le `%d`, on a ici le numéro du mois `%m`, on a pareil donc l'année `%y` sous quatre chiffres ou deux chiffres que vous utilisiez la majuscule ou la minuscule pour le y.

Le format d'heure donc là tout en majuscules `%H %M %S` parce que sinon on a évidemment d'autres cas.

Et je vous ai aussi partager parce que ça c'est important quelques raccourcis, vous voyez comme ça que ça permet d'aller un peu plus vite sur tous ces formats pour ne pas les passer un à un donc en gros si vous devez afficher et ça c'est souvent un format qu'on retrouve beaucoup dans d'autres cas où on a `%Y-%m-%d` plutôt que d'écrire tout ce formatage-là vous pouvez le remplacer par `%F`, et pour afficher `%H:%M:%S` vous pouvez utiliser `%T` pour time qui va permettre d'avoir ce format-là.

## plus

Donc comment on utilise ces différents formats ? c'est très simple, on peut tout simplement utiliser `date` et vous entre double guillemets avec un `+` au départ de votre chaîne et là vous allez choisir donc le formatage bien précis donc par exemple si je veux dire voilà `Nous sommes %A` et voilà ce qu'il va nous retourner d'accord.

```bash
sam@sam:~$ date "+Nous sommes %A"
Nous sommes jeudi
```

Donc c'est comme une chaîne de caractères donc si vous faites de la programmation que vous avez l'habitude de manipuler ce genre de données. On marque ce qu'on veut, on n'est pas obligés de marquer quelque chose et en utilisant ces petits symboles là `%A`, c'est le joker, donc ils vont être interprété dés qu'il a un %.. quelque chose, en fonction de ce que je noté ici.

```txt
%A ou %a    : jour (lettres - complet ou abrégé)
%B ou %b    : mois (lettres - complet ou abrégé)

%d          : numéro du jour (01 à 31)
%M          : numéro du mois (01 à 12)
%Y ou %y    : numéro de l année (ex : 2019 ou 19)

-------------------------------------------------------------

%H          : heure (00 à 23)
%M          : minute (00 à 59)
%S          : seconde (00 à 59)

-------------------------------------------------------------

Raccourcis 
%F <=> %Y-%m-%d
%T <=> %H:%M:%S
```

Donc on peut véritablement récupérer des informations bien précises et en gros si on veut l'information telle qu'on la retrouve souvent dans d'autres domaines c'est à dire la date complète sous ce format-là `%Y-%m-%d` et l'heure complète sous ce format-là `%H-%M-%S` et bien vous alternez enfin vous cumuler simplement les deux donc généralement ça s'écrit comme ça.

```bash
sam@sam:~$ date "+%F %T"
2021-02-25 13:10:10
```

Vous voyez on a tout le format de la date du coup comme ceci donc à l'envers d'accord année-mois-jour, un espace, heures-minutes-secondes et ça évite de noter tout ça `%Y-%m-%d`, un espace et tout ça `%H-%M-%S` d'accord on gagne pas mal de temps.

## fuseau horaire

Je suis allé assez vite là dessus parce que c'est simple et honnêtement il n'y a pas grand chose à dire de plus, il existe plein d'autres joker et notamment par exemple le  joker pour tout ce qui est fuseau horaire donc on peut mettre `date "+%Z"`.

```bash
sam@sam:~$ date "+%Z"
CET
```

Voilà et vous avez du coup le time zone donc `CEST` donc on peut récupérer ce genre d'information et plein d'autres aussi, vous pouvez aller voir dans le manuel concernant cette commande `date` que vous allez retrouver plein d'autres jokers utilisables. Il y en a même d'autres au niveaux des raccourcis d'accord ceux là `%F %T` sont les principaux, il y en a plein d'autres également notamment `%D`.

```bash
sam@sam:~$ date "+%D"
02/25/21
```

Pour-cent grand D qui vous donne ce format-là d'accord ça vous donne le mois comme on retrouve beaucoup en us : mois/jour/l'année sur 2 chiffres d'accord il inverse en fait le mois et le jour.

En France, jour/mois/année sur quatre chiffres plus souvent donc voilà vous avez comme ça différents formatages.

C'était quelque chose que je tenais à aborder au début de vidéo puisqu'on parle de planifier des tâches, des traitements donc la planification se fait forcément par rapport à des dates et des heures.

## Modifier la date du système

Voilà pour cette partie là, on va pouvoir du coup maintenant passer au plus important par rapport à ça alors oui je ne l'ai pas dit mais si éventuellement vous voulez par exemple éditer cette date donc il faudrait en avoir vraiment l'utilité de dire je veux modifier la date de mon ordinateur à moins qu'elle ne soit pas bonne mais généralement la date est synchronisé via internet pour avoir la date la plus exacte mais si vraiment vous vouliez la modifier manuellement, vous allez devoir passer en super utilisateur sinon ça ne passera pas `sudo date` et ensuite on va pouvoir respecter un format très particulier pour pouvoir modifier la date que nous voulons donc on va avoir `042116002018` donc ce sera tout attachés donc ça va être tout simplement `mmddHHMMYYYY`.

```txt
%A ou %a    : jour (lettres - complet ou abrégé)
%B ou %b    : mois (lettres - complet ou abrégé)

%d          : numéro du jour (01 à 31)
%M          : numéro du mois (01 à 12)
%Y ou %y    : numéro de l année (ex : 2019 ou 19)

-------------------------------------------------------------

%H          : heure (00 à 23)
%M          : minute (00 à 59)
%S          : seconde (00 à 59)

-------------------------------------------------------------

Raccourcis 
%F <=> %Y-%m-%d
%T <=> %H:%M:%S

Modifier la date du système ->  mmddHHMMYYYY
                                042116002018
```

```bash
sudo date 042116002018
```

D'accord c'est un peu particulier l'ordre dans lequel on met les informations mais en tout cas voilà le format à respecter par rapport à ça vous mettez ce type de format là en mettant une date bien précise et ça va modifier la date de votre système mais encore une fois il faut en avoir l'utilité c'est pour ça donc que je vais très vite dessus, généralement on synchronise avec internet pour pouvoir quelque chose de plus exacte et si ça ne fonctionne pas il faudra revoir par rapport à la gestion de votre système il y a forcément quelque chose qui ne n'est pas bien configuré par rapport à cette synchronisation.

## at

Ok maintenant passons véritablement à la planification de tâches et nous avons un outil très pratique qui n'est peut-être d'ailleurs pas forcément installé, si vous avez ubuntu bungie, il faudra installer `at` c'est le nom du paquet que nous allons utiliser donc l'installer avec `apt`, `aptitude`, ce que vous voulez comme on l'a vu sur des séances récédentes.

```bash
sam@sam:~$ sudo apt install at
```

Une fois que nous avons cet outil nous allons pouvoir planifier une tâche à un moment précis donc on va par exemple lui demander de supprimer un fichier `test.txt` à un moment donné.

On va faire juste ceci.

```
sam@sam:~$ at 21:20
warning: commands will be executed using /bin/sh
at>
```

Voilà on a accès à un prompt et là je peux lui donner toutes les commandes que je veux faire exécuter donc moi je vais lui dire de faire un remove `rm` mais je vais lui donner le chemin exact parce que c'est bien important de préciser le chemin absolue pour être sûr de trouver toujours le fichier, exécuter la commande au bon endroit comme ça il n'y a absolument pas de problème par rapport à ça, `rm /home/sam/Bureau/test.txt` donc on met toutes les commandes que l'on veut faire et finallement je vais plutôt modifier le nom du fichier avec la commande `mv`.

```bash
sam@sam:~$ at 21:26
warning: commands will be executed using /bin/sh
at> mv /home/sam/Bureau/test.txt /home/sam/Bureau/test-renomé.txt
at> <EOT>
job 3 at Thu Feb 25 21:26:00 2021
sam@sam:~$ 
```

On fait la commande `mv`, on fait entrer et s'il n'y a pas d'autres commandes que l'on veux faire, on fait ctrl+D qui va tout simplement envoyer un END OF TEXT <EOT> d'accord mais attention ici ça n'envoi pas un signal, on pourrais penser que ça envoie un signal mais en réalité ça envoie le code END OF TEXT comme on retrouve END OF FILE pour la fin d'un fichier quand on programme et s'arrête tout simplement le prompt et à partir de là vous allez pouvoir vérifier éventuellement la liste de tâches que vous avez comme ça en cours.

# atq

Alors on serait tenté de faire un `jobs` dans l'attente s'il y a des processus par exemple qui sont prêts à être exécutés mais on n'a rien en arrière-plan d'accord ou qui attendent donc on va véritablement passer par une autre commande qui est `atq` pour simplement afficher la files d'attentes des tâches planifiées.

```bash
sam@sam:~$ at 21:35
warning: commands will be executed using /bin/sh
at> mv /home/sam/Bureau/test.txt /home/sam/Bureau/test-renomé.txt
at> <EOT>
job 4 at Thu Feb 25 21:35:00 2021
sam@sam:~$ jobs
sam@sam:~$ atq
4	Thu Feb 25 21:35:00 2021 a sam
```

On retrouve du coup un numéro de tâches comme vous le voyez donc la date évidemment est prévue qui a initialisé ce type de tâche et voilà donc là on va attendre pour qu'elle s'exécute et on verra un petit peu.

## atrm

Si éventuellement vous voulez annuler une tâche qui était planifiées vous pouvez utiliser at remove `atrm` le nom de la commande et vous mettez le numéro de la tâche en question donc je mets 5 puis que vous voyez que le numéro c'est 6.

```bash
sam@sam:~$ at 21:45
warning: commands will be executed using /bin/sh
at> mv /home/sam/Bureau/test.txt /home/sam/Bureau/test-renomé.txt
at> <EOT>
job 6 at Thu Feb 25 21:45:00 2021
sam@sam:~$ atq
6	Thu Feb 25 21:45:00 2021 a sam
sam@sam:~$ atrm 6
sam@sam:~$ atq
```

Donc ça c'est si vous voulez supprimer la tâche avant qu'elle se produise donc vous avez `at` pour programmer une tâche, vous avez `atq` pour avoir la liste des tâches qui sont planifiées et at remove donc `atrm` pour pourvoir supprimer une tâche bien précise donc là on va attendre un petit peu, une dizaine de secondes et on va avoir la tâche qui va s'exécuter et qui du coup va normalement modifier ce fichier si je me suis pas gouré ...

Voilà mon fichier a changé de nom et du coup si je vais cette fois ci à nouveau dans la liste on n'a plus de tâches qui sont en attente d'accord donc il n'y a pas de problème par rapport à ça.

## planifier à une date

Alors on peut planifier de plein d'autres manières c'est à dire que par défaut j'ai mis ici ce format là on fait heures et minutes `at HH:MM`. On peut évidemment préciser pour une date précise donc par exemple de dire je veux que tu choisisses cette heure-là mais pour une autre date d'accord ce ne sera pas forcément pour aujourd'hui donc on veux pouvoir programmer ça autrement d'accord on peut sans problème le faire.

Donc là `at HH:MM` on retrouve la fameuse date us en fait où on met rappelez-vous ceci `at HH:MM mm/dd/yy`

### tomorrow and today

Par exemple si je veux programmer pour 18 heures demain je vais faire ça alors je peux utiliser `tomorrow` voilà on a un mot comme ça tout fait pour dire demain et si je précise la date précise et bien je mets `05/25/2019` puisqu'au moment où je fais cette vidéo nous sommes le 24 mai 2019.

```bash
sam@sam:~$ at 18:00 05/25/2019
sam@sam:~$ at 18:00 tomorrow
```

Pour 18 heures le 25 mai 2009 je programme une tâche, on peut faire comme ça.

On peut également mettre `today` par exemple.

```bash
sam@sam:~$ at 18:00 today
```

## now

Et on peut également à partir de maintenant en utilisant `now+` en mettant un plus pour par exemple +5 minutes, +10 hours, +5 days, +5 months, etc.

```bash
sam@sam:~$ at now+5 months
```

Voilà pour dire à partir du moment où je planifie la tâche où elle sera planifié donc au moment où j'aurais valider les tâches a planifié et bien cinq mois plus tard par rapport au temps de maintenant on aura une tâche qui va s'exécuter.

On donc a plusieurs manières, je vais assez vite aussi parce que c'est des choses très simples pareil c'est des cas bien spécifiques pour exécuter ces types de commandes et vous pouvez du coup avoir ce format là donc ça a quand même son importance d'accord soit spécifier juste une heure, soit spécifier une heure mais une date aussi précises, soit spécifier bien évidemment une information plus complète, de faire par exemple `at now+5 months`.

Voilà on dit par exemple que cinq mois plus tard on crée par exemple un fichier et ensuite en créer un deuxième et puis tu vas renommer un fichier. ctrl+D et voilà.

```bash
sam@sam:~$ at now +5 months
warning: commands will be executed using /bin/sh
at> touch main.cpp
at> touch main.hpp
at> mv main.cpp app.cpp
at> <EOT>
job 7 at Sun Jul 25 23:43:00 2021
sam@sam:~$ 
```
Et voilà d'accord donc on voit que du coup que le 25 juillet d'accord ça tombera apparemment un dimanche 25 juillet 2021 à 23h43 puisque c'est l'heure qui a été choisie à partir de `now` et bien donc dans cinq mois voilà une tâche sera planifié.

Je peux vérifier.

```bash
sam@sam:~$ at now +5 months
warning: commands will be executed using /bin/sh
at> touch main.cpp
at> touch main.hpp
at> mv main.cpp app.cpp
at> <EOT>
job 7 at Sun Jul 25 23:43:00 2021
sam@sam:~$ atq
7	Sun Jul 25 23:43:00 2021 a sam
```

La tâche porte le numéro 7 mais je vais évidemment l'annuler.

Je fais `atrm 7` et nous n'avons plus la tâche de planifié voilà donc j'ai été un petit peu vite.

```bash
sam@sam:~$ at now +5 months
warning: commands will be executed using /bin/sh
at> touch main.cpp
at> touch main.hpp
at> mv main.cpp app.cpp
at> <EOT>
job 7 at Sun Jul 25 23:43:00 2021
sam@sam:~$ atq
7	Sun Jul 25 23:43:00 2021 a sam
sam@sam:~$ atrm 7
sam@sam:~$ atq
sam@sam:~$ 
```

Si j'ai été un petit peu trop vite sur l'explication, n'hésitez pas à tester un petit peu ces commandes.

Il y a encore une fois toujours des manuels, pour chaque commande on fait `man` suivi du nom de la commande vous retrouvez toutes les infos qu'il faut s'il manque des détails.

```bash
sam@sam:~$ man at
```

Et après si vraiment vous êtes bloqués sur quelque chose vous pouvez m'en parler dans les commentaires sous la vidéo et je viendrais évidemment vous dépanner si vous êtes bloqué sur quelque chose en particulier en particulier mais généralement c'est assez simple une fois que vous avez bien compris comment fonctionne les différents formats de date tout ce qu'on a vu-là.

```txt
%A ou %a    : jour (lettres - complet ou abrégé)
%B ou %b    : mois (lettres - complet ou abrégé)

%d          : numéro du jour (01 à 31)
%M          : numéro du mois (01 à 12)
%Y ou %y    : numéro de l année (ex : 2019 ou 19)

-------------------------------------------------------------

%H          : heure (00 à 23)
%M          : minute (00 à 59)
%S          : seconde (00 à 59)

-------------------------------------------------------------

Raccourcis 
%F <=> %Y-%m-%d
%T <=> %H:%M:%S
```
Voilà vous allez du coup pouvoir les manipuler facilement et je vous ai mis tout le détail.

Voilà pour la planification comme ça d'une tâche bien précise qui va s'exécuter et vous voyez qu'après elle est retirée de la liste des tâches planifiées et terminé, on passe du coup à autre chose par rapport à ça donc c'est à connaître.

Vous voyez qu'il y a plusieurs plusieurs possibilités et ça a quand même vraiment son utilité ici.

## shutdown

Alors on peut par exemple planifiées notamment sans parler forcément de faire des sauvegardes ou autre par exemple l'extinction de la machine, le redémarrage, tout ça. Ce sont des commandes que je n'ai pas forcément abordé donc je vais en profiter, faire une petite parenthèse pour en parler là.

Vous avez un outil qui est `shutdown` d'accord.

```bash
sam@sam:~$ man shutdown
```

### alt

Cette commande qui est un outil qui va être réutilisés par pas mal d'autres commandes c'est-à-dire que si je fais un `shutdown -H` donc h majuscule je vais mettre en veille et ça correspondrais tout simplement à `halt`.

```bash
sam@sam:~$ shutdown -H #équivalent à `halt`
```

D'accord donc si vous utilisez `halt` ça reviendrait à faire un `shutdown -H`.

### poweroff

Si vous avez un `shutdown -P` ça revient à utiliser le `poweroff` donc là c'est l'extinction de la machine.

```bash
sam@sam:~$ shutdown -P #équivalent à `poweroff`
```

### reboot

Et si vous mettez `shutdown -r` avec r minuscule ça revient à la commande `reboot`.

```bash
sam@sam:~$ shutdown -r #équivalent à `reboot`
```

Alors je pense que c'est pour des histoires de compatibilité il va sûrement y avoir des commandes qui existaient à l'époque sur certains environnements unix bien précis et ensuite de nouvelles commandes ont été créés et pour ne pas casser la compatibilité avec de vieux script qui peuvent tourner encore c'est qu'il y a peut-être des gens qui ont programmé des scripts avec ces vieilles commandes il y a peut-être 10, 15 ans et avec tout les changements on n'a pas envie que ces scripts se mettent à ne plus fonctionner.

Imaginez des gens qui auraient planifiés par exemple l'exécution de scripts qu'ils ont développées donc c'est pour ça que ça peut être assez déroutant de dire que shutdown ça veut dire éteindre d'accord c'est pour couper et en faisant ceci ou cela en fait on n'éteint pas on met en veille, et en faisant autre chose carrément on redémarre donc c'est un petit peu bizarre par rapport à ça.


D'ailleurs si vous allez dans le manuel par exemple de `halt`, vous avez la commande `halt` et en fait si  vous regardez vous mettez `halt -p` ou avec l'option `halt --poweroff`, on peut utiliser la commande halt prévues pour mettre en veille pour éteindre la machine.

Voyez en fait grosso modo on va retrouver pour toutes ces commandes-là,

    `halt [OPTIONS...]` 
    `poweroff [OPTIONS...]`
    `reboot [OPTIONS...]`

et bien pour `shutdown` un petit peu les mêmes arguments.

C'est pas forcément exactement les mêmes noms ou en tout cas minuscules, majuscules selon les cas mais en fait avec n'importe quelle commande parmi ces trois là et bien en fait on peut exécuter les autres actions avec `reboot` on peut mettre en veille avec `poweroff` on peut redémarrer et cetera donc ça peut être un peu déroutant de dire pourquoi il y a tout ça mais c'est surtout pour des questions de compatibilité, il y a certaines commandes qui existait et d'autres qui  n'existaient pas.

Voilà et comme on veut pas forcément casser la compatibilité de vieux scripts et bien des choses qui n'ont pas forcément été retirées de toutes ces commandes mais voilà donc si vous voulez redémarrer vous pouvez vous servir de `reboot`, `halt` pour la mise en veille, `poweroff` pour l'extinction et ça fonctionnerait évidemment très bien.

Et si sur votre système, ces commandes ne sont pas disponibles, n'existe pas mais il y aura `shutdown` donc voila vous en aurez au moins un de sûr, toujours une de présentes sur votre système donc ça peut varier parce que vous pouvez être sûr du Ubuntu, être sur du Arch Linux, vous pouvez être sur un systèmes bsd donc c'est un système unix mais qui n'est pas du linux d'accord c'est encore autre chose, bsd, et qui n'a peut-être pas certaines commandes et qui en a d'autres donc c'est pour ça qu'il existe tous ces différents  programmes, en fait ces différentes commandes d'exécution puisqu'elles ne sont pas forcément toutes présentes partout, sur toutes les distributions et sur tous les environnements.

## cron

Voilà pour ça et passons donc à la dernière partie pour clore en fait cette cette séance là avec la possibilité de planifier non pas une tâche de manière unique d'accord de dire ben je vais exécuter un certain traitement à partir d'un moment mais de pouvoir le faire de manière régulière, et là je m'adresse surtout à ceux qui voudraient par exemple faire de la sauvegarde régulière tous les jours, toutes les heures, toutes les minutes, ...

J'en sais rien mais pour programmer quelques choses de manière régulière et nous allons utiliser un outil très pratique qu'on ne retrouve d'ailleurs pas que sur système également web, qui s'appelle `cron`.

Ce nom doit vous dire quelque chose si vous faites du web où on peut établir des tâches cron qui vont donc s'exécuter avec des intervalles régulières alors ça peut être unique mais ça n'a pas vraiment d'intérêt de faire une tâche cron unique.

On va plutôt le faire pour des choses qui vont être répétées, qui seront récurrentes et pour cela donc notre programme `cron` le système va utiliser donc des informations d'un fichier qui est crontab d'accord.

  cron #utilise le fichier crontab

crontab est un fichier que nous allons pouvoir éditer qui va ensuite être analysé par `cron` qui va du coup exécuter les commandes que nous avons voulu.

Alors là faut rester un peu concentré c'est la fin de la vidéo parce que le format vous allez voir est un petit peu particulier mais je vais quand même vous le détailler comme il faut pour que toutes les infos les informations soient données.

## select-editor

Alors d'abord si c'est la première fois que vous utiliser crontab, il est possible qu'il vous propose de choisir l'éditeur par lequel il va falloir l'ouvrir.

En fait on ne va pas ouvrir le fichier crontab via notre éditeur directement en utilisant par exemple `nano` ou `vim` ou autre, on va passer directement par les options de crontab pour qu'il puisse être édité et prendre en compte le changement et la planification de la tâche mais vous soit exécuter en premier la commande et on va vous demander de choisir l'éditeur pour éditer ce fameux fichier soit ça va choisir un éditeur par défaut parce que peut-être ça a déjà été choisi par une autre commande que vous avez utilisé sur votre OS et vous risquez peut-être de vous retrouver sur un éditeur que vous ne connaissez pas ou que vous n'aimez pas et ça va être compliqué.

Donc la première chose à faire par exemple c'est de faire `select-editor` qui du coup va vous redemander ce choix.

```bash
sam@sam:~$ select-editor

Select an editor.  To change later, run 'select-editor'.
  1. /bin/nano        <---- easiest
  2. /usr/bin/vim.tiny
  3. /bin/ed

Choose 1-3 [1]: 
```

On vous redemande ce choix mais des fois vous n'aurez pas besoin de le faire encore une fois parce que vous allez utiliser crontab et ça va justement vous affichez ce menu pour vous dire lequelle parmi les éditeurs que vous avez en ligne de commande, en console lequel vous voulez utiliser d'accord donc on précise que pour le changer à nouveau plus tard, vous pouvez utiliser cette commande là donc moi il était déjà sur nano par défaut mais je vais revérifier pour être sûr voilà en faisant 1

```bash
sam@sam:~$ select-editor

Select an editor.  To change later, run 'select-editor'.
  1. /bin/nano        <---- easiest
  2. /usr/bin/vim.tiny
  3. /bin/ed

Choose 1-3 [1]: 1
sam@sam:~$ 
```

On fait 1 puisque dans le cours on a abordé `nano` donc je pars du principe que vous n'avez pas forcément après utiliser d'autres éditeurs comme `ed` ou `vim` ou ce genre de choses donc on va partir sur `nano` pour tout le monde puisque j'ai fait un cours sur `nano` donc je sais que vous l'avez tous absolument abordé si vous en êtes à ce stade de la formation comme ça il n'y aura aucun problème.

## crontab

### crontab option e

A partir de là une fois que cet éditeur a bien été configuré, on va utiliser cette fois ci notre commande `crontab -e` avec l'option `-e` pour éditer.

```bash
sam@sam:~$ crontab -e
```

Là vous voyez ça s'ouvre bien avec `nano` donc ça c'est une bonne nouvelle, on voit qu'il est affiché dans le fichier, dans le répertoire des fichiers temporaires qui s'est créé d'accord.

    /tmp/crontab.KtCtMs/crontab

Il va être disponible là, il existera du coup le temps que cette tâche soit éventuellement terminée si un jour elle l'est sinon elle ne le sera pas donc on ne se soucie pas vous voyez du fichier qui est créé, du nom, etc.

C'est pour ça qu'on passe par `crontab`, c'est lui qui gère comme ça le nommage, l'emplacement du fichier et à quel endroit serait éventuellement exécuté les commandes en passant par `cron` donc nous on ne va pas s'occuper tellement de ça.

On descend sur ce fichier crontab qui a beaucoup de commentaires et nous allons pouvoir décommenter cette ligne et voir un petit peu le format qu'il y a.

```bash
m h  dom mon dow   command
```

Ici vous avez un petit `m` minuscule sur lequel j'ai positionné mon curseur _ correspond à la minute donc le numéro de la minute pour la tâche en question.

Le petit `h` correspond à l'heure et bien je pense que ce n'est une surprise pour personne.

Vous avez le `dom` day of month qui correspond en fait au jour du mois ok.

Nous avons month `mom` tout simplement et ensuite nous avons day of week `dow` donc c'est en fait le jour en particulier, est-ce qu'on veut par exemple exécuter un lundi ? parce que vous comprenez bien que dire xécuter une tâche tous les lundis c'est pas la même chose que de dire exécuter une tâche tous les 8 du mois donc attention entre les deux.

`dom` c'est le numéro du jour dans un mois donc du 1er au 31e si on prend les mois les plus longs et `dow` c'est le numéro qui va en fait qui va identifier un  jour de la semaine et comme en informatique on a beaucoup de choses qui commencent par 0 si vous faites de la programmation, vous ètes bien au courant de ça et bien au niveau des mois de la semaine c'est pareil.

Le premier mois de la semaine ne sera pas sous un identifiant 1 mais sous l'identifiant 0 et on rajoute une couche aussi à connaître c'est que contrairement en france où la semaine commence lundi, ici la semaine commence par dimanche.

Donc si vous voulez lancer une tâche tous les dimanches, il faudra mettre à la place de `dow` il faudra mettre un zéro parce que c'est le premier jour de la semaine ici au niveau informatique et du coup le dernier jour de la semaine le samedi hé bien vous mettez un 6.

    dow
        dimanche    -> 0
        lundi       -> 1
        mardi       -> 2
        mercredi    -> 3
        jeudi       -> 4
        vendredi    -> 5
        samedi      -> 6

Voilà ça va de 0 à 6 et non pas de 1 à 7 et ensuite on à la commande `command` qui est à exécutée donc voilà en gros le format très simple qui est à faire par  rapport à ça.

Alors prenons une tâche parlant qu'on voudrait exécuter tous les jours à 16h par exemple.

Par exemple j'ai un fichier qui se créerait tous les jours ou n'importe quoi, on voudrait faire même la mise à jour de mon système par exemple, sans problème on pourrait faire ce genre de choses eh bien on peut sans problème lui dire que les minutes c'est `00` ou utiliser ce symbole `*` pour dire n'importe quel minute, toutes les minutes et puis les heures.

```bash
m h  dom mon dow   command
00
0
*
```

`dom` comme c'est n'importe quel jour du mois et bien je met une étoile aussi. Le mois c'est n'importe lequel aussi et le `dow` aussi.

```bash
m h  dom mon dow   command
00 18 * * * <command>
```

Voilà donc ça c'est vraiment pour 18 heures mais attention si vous faites `* 18 * * *` ça va s'éxécuter à n'importe quel minute 18h00, 18h01, 18h02, etc, ça ne va pas être génial donc on met ce genre d'information `00 18` ou `0 18` peu importe mais moi je met double zéro et ensuite la commande à faire d'accord donc ça peut être n'importe quoi.

Alors le mieux même pour les commandes système c'est  de passer encore une fois par le chemin absolue parce que `cron` va exécuter vos commandes mais on ne sait pas forcément d'où il va les exécuter donc si vous avez des commandes bien particulière pour être sûr qu'elles sont bien trouvés le mieux c'est de passer et bien par l'endroit absolue où se trouve la commande donc si vous n'êtes pas sûr et que par exemple vous voulez utiliser `apt-get` alors vous pouvez passer par le terminal pour aller plus vite.

```bash
sam@sam:~$ whereis apt-get
apt-get: /usr/bin/apt-get
```

Alors vous préciser ce chemin "/usr/bin/apt-get" de dire tout simplement:

```bash
m h  dom mon dow   command
00 18 * * * /usr/bin/apt-get update
```

###  exemple

On fait par exemple `update` et puis ensuite on peut faire pareil `upgrade` donc ça c'est que de la révision, toutes ces commandandes-là on les a déjà vus.

```bash
m h  dom mon dow   command
00 18 * * * /usr/bin/apt-get update && /usr/bin/apt-get upgrade
```

Donc ça tous les jours à 18h on va mettre à jour la liste des dépôts et mettre à jour les logiciels de notre système en faisant ça.

Voyez qu'en donnant bien le chemin absolue vers tous les programmes parce que n'oubliez pas que toutes les commandes que vous utilisez `ls`, `echo`, `crontab` ce sont en fait des binaires qui sont généralement dans "/usr/bin/" sinon dans bin s'ils sont partagés.

Voilà vous avez pas mal de choses comme ça disponible donc vraiment on peut retrouver `ls`, `grep`, etc.

Si on ne sait plus, on fait `whereis ls`.

```bash
sam@sam:~$ whereis ls
ls: /usr/bin/ls /usr/share/man/man1/ls.1.gz
```

Voilà on peut retrouver comme ça une commande en particulier si vous ne savez pas où aller mais ça c'est de la révision, `whereis` on l'a déjà vu bien avant dans le cours et après ben voilà on spécifie ça précisément.

crontab
```bash
00 18 * * * /usr/bin/apt-get update && /usr/bin/apt-get upgrade
```

Si je veux que ce soit exécuté par contre à 18 heures mais que par exemple les dimanches d'accord tous les dimanches eh bien je vais de spécifier ici en mettant 0 d'accord.

00 18 * * * **0** /usr/bin/apt-get update && /usr/bin/apt-get upgrade

Voilà on peut faire comme ça donc à vous de voir si vous mettez 1 vous aurez tous les lundis, début de semaine française, on peut faire ça comme ça et ça fonctionne très très bien.

00 18 * * * **1** /usr/bin/apt-get update && /usr/bin/apt-get upgrade

On a également d'autres types de formats càd là quand je mets voyez un nombre bien précis bas c'est celui-là qui est choisie, qui match en fait (0, 1, etc) mais on peut également en spécifier plusieurs par exemple si je veux que ce soit fait le lundi et le dimanche. On peut par exemple dire `1,0` d'accord ou `0,1` ça veut dire que ce sera fait et le dimanche correspondant à 0 et le lundi correspondant à 1.

00 18 * * * **1,0** /usr/bin/apt-get update && /usr/bin/apt-get upgrade

00 18 * * * **0,1** /usr/bin/apt-get update && /usr/bin/apt-get upgrade

Et on peut aussi dire de tel jour à tel jours donc en mettant une fourchette en mettant simplement un tiret `-` donc par exemple de dire du lundi jusqu'au mercredi `1-3`.

00 18 * * * **1-3** /usr/bin/apt-get update && /usr/bin/apt-get upgrade

Voilà donc on met `1-3` avec le 1 correspond au lundi et le 3 correspond à mercredi si je ne dit pas de bêtises voilà ça c'est pour dire ça va de 1 à 3 par rapport à la planification de la tâche.

Il y a donc plusieurs choses à connaître:

* l'étoile c'est pour tout.
* la virgule c'est pour spécifier plusieurs choix possibles.
* le tiret c'est pour dire ça va de tel minimum à tel maximum d'accord et sinon vous mettez la valeur précise et ça on l'a vu par rapport au format, sur les horaires et les dates et les horaires comme on l'a vu en début de vidéo et après vous mettez la commande, vous validez d'accord avec ctrl+O et crtl+X pour enregistrer mon fichier.

### valider avec nano

crontab
```bash
00 18 * * * /usr/bin/apt-get update && /usr/bin/apt-get upgrade
```
ctrl+O --> crtl+X

### crontab option l

Voilà normalement ça a prit en compte la commande et on qu'à faire `crontab -l` et elle est logiquement on doit retrouver évidemment le listing de notre fichier ça fait comme cadre en fait et voyez qu'on retrouve la tâche qui est ici.

```bash
sam@sam:~$ crontab -e
no crontab for sam - using an empty one
crontab: installing new crontab
sam@sam:~$ crontab -l
# Edit this file to introduce tasks to be run by cron.
# 
# Each task to run has to be defined through a single line
# indicating with different fields when the task will be run
# and what command to run for the task
# 
# To define the time you can provide concrete values for
# minute (m), hour (h), day of month (dom), month (mon),
# and day of week (dow) or use '*' in these fields (for 'any').
# 
# Notice that tasks will be started based on the cron's system
# daemon's notion of time and timezones.
# 
# Output of the crontab jobs (including errors) is sent through
# email to the user the crontab file belongs to (unless redirected).
# 
# For example, you can run a backup of all your user accounts
# at 5 a.m every week with:
# 0 5 * * 1 tar -zcf /var/backups/home.tgz /home/
# 
# For more information see the manual pages of crontab(5) and cron(8)
# 
00 18 * * * /usr/bin/apt-get update && /usr/bin/apt-get upgrade
sam@sam:~$ 
```

### crontab option r

On retrouve la tâche qui est ici et qui logiquement doit s'exécuter et si à un moment donné je veux  supprimer d'accord toutes les tâches qui ont été indiqués ici d'accord parce qu'on peut en mettre plusieurs du coup si on veut et bien j'ai juste à faire un `crontab -r` et là si je fait vérifie `crontab -r` il ne devrait plus y avoir de tâche qui ont été tout simplement prévues en tout cas créée.

```bash
sam@sam:~$ crontab -l
# Edit this file to introduce tasks to be run by cron.
# 
# Each task to run has to be defined through a single line
# indicating with different fields when the task will be run
# and what command to run for the task
# 
# To define the time you can provide concrete values for
# minute (m), hour (h), day of month (dom), month (mon),
# and day of week (dow) or use '*' in these fields (for 'any').
# 
# Notice that tasks will be started based on the cron's system
# daemon's notion of time and timezones.
# 
# Output of the crontab jobs (including errors) is sent through
# email to the user the crontab file belongs to (unless redirected).
# 
# For example, you can run a backup of all your user accounts
# at 5 a.m every week with:
# 0 5 * * 1 tar -zcf /var/backups/home.tgz /home/
# 
# For more information see the manual pages of crontab(5) and cron(8)
# 
00 18 * * * /usr/bin/apt-get update && /usr/bin/apt-get upgrade
sam@sam:~$ crontab -r
sam@sam:~$ crontab -l
no crontab for sam
```

Voilà on n'a plus du tout ce fichier crontab qui existe.

Voilà et je pense qu'on va s'arrêter là, on a apporté pas mal de choses, c'est tout ce que je voulais vous montrer par rapport à la planification de tâches donc vous avez vu comment on utilise des dates, comme on les manipulent.

Vous avez vu comment planifier une tâche mais **unique** d'accord qui va s'exécuter, qui va être faite une seule fois et si vous voulez avoir des tâches comme ça **récurrente**, régulière hé bien utilisez crontab qui se sert ... attention derrière c'est qu'un fichier ... de `cron` et vous allez comme ça pouvoir planifier des tâches bien précises avec des horaires, des dates bien précises et des commandes particulières aussi.

Je rappelle mais ça semble logique que avec ce genre de tâche on ne peut exécuter que des choses qui se font en console c'est à dire si à un moment donné vous voulez par exemple qu'à une certaine heure ça vous ouvre votre navigateur web ou que ça vous lance une musique via vlc ou ce genre de choses vous pouvez le faire avec `cron` mais il faudra aller voir pour le manuel parce que je ne vais pas m'attarder dessus, il y a trop trop de choses à voir.

Peut-être que je pourrai éventuellement l'aborder dans un tuto mais ça n'a pas été fait évidemment au moment au moment où je fais cette vidéo mais vous pouvez, sachez en tout cas qu'il y a moyen avec `xhost` notamment hé bien de passer par un serveur x donc de  pouvoir lancer une application graphique pour dire par exemple que tout les matins si je sais que j'allume mon pc à telle heure hé bien dix minutes après que mon pc est allumé, je peux par exemple planifier l'ouverture de mon lecteur mp3 qui va lire ma petite playlist pour se reveiller le matin tranquillement et on commence la journée de bonne humeur.

Voilà donc on peut faire ce genre de choses mais en tout cas là on est pour une utilisation en mode console donc attention même si par exemple vous vouliez faire une tâche pour dire j'ouvre un terminal, n'oubliez pas que même un terminal même si on ne s'en rend pas compte c'est une application graphique d'accord de cette manière.


    +---------------+
    |Bash      - # x|
    |               |
    |               |
    |               |
    +---------------+

Là on est dans une application graphique sinon on  n'aurait même pas cet écran que vous voyez derrière avec le fond d'écran, les icônes tout ça.

Même pour dire j'ouvre un terminal comme ici il passe par une interface graphique, on obligé de passer par `xhost` et là, il faudra vous renseigner un petit peu par rapport à `cron` et `crontab` pour voir comment on peut faire ça mais sachez que c'est possible.

Si ça vous intéresse vous pourrez continuer de creuser un petit peu là dessus pour planifier donc des tâches avec des environnements graphiques.

Voilà on va s'arrêter pour cette séance ça termine donc ce fameux chapitre sur tout ce qui est gestion  système, administration système et à partir de la prochaine séance on va arriver vraiment dans un nouveau chapitre qui va concerner comme je vous ai dit le réseau et tout ce qui est relié à internet.

A bientôt pour la suite des séances sur gnu linux.

Ciao tout le monde