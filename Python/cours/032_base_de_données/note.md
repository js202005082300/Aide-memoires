# [32. Bases de données](https://www.youtube.com/watch?v=K0zF1GiPrxY)

[main.py](main.py)  

Bonjour à tous et bienvenue sur la formation en langage python. 

On continue avec une nouvelle séance toujours sur la partie web et réseaux c'est-à-dire la séance numéro 32, où je vais vous parler comme l'indique le titre de base de données.

Pour cela, je vais vous proposer une solution parmi beaucoup d'autres parce qu'il existe évidemment plusieurs manières de travailler avec des bases de données. 

Il va falloir évidemment que je vous explique ce que c'est parce que je pars du principe encore une fois que vous n'avez jamais vu d'autres langages avant d'autres technologies, que c'est la première fois que vous Découvrez ça donc je vais vous faire le tour de ce type de fonctionnement qui est à connaître en informatique. 

Alors il faut savoir qu à la base, tout ce qui était informations et vous avez vu dans la vidéo précédente, on stockait la plupart du temps quand on voulait sauvegarder pour une autre exécution du programme notamment, dans un fichier texte. 

Vous avez d'ailleurs vu la séance sur le fichier, nous pouvions stocker des informations à l'intérieur. 

On peut même stocker des informations sous forme binaire, sauvegarder carrément des objets, et ça peut avoir son utilité. 

En revanche là où ça va montrer ses limites, c'est dans le cas où nous voudront exécuter des recherches, faire des requêtes pour sélectionner certaines informations parmi ce que nous avons sauvegardé mais là le fichier texte n'est absolument pas du tout prévu pour ça. 

Et même si on s'arrangeait pour faire des sélections est sauvegardée dans des fichiers texte, ce ne serait absolument pas optimisé. 

On aurait vraiment une perte de performance parce que le fichier texte n'est pas fait pour ça. Il est fait pour être lu, il est fait pour pouvoir écrire dedans est terminé. 

Le fichier texte n'est pas fait pour faire de la recherche, de la sélection, du requêtage, du groupement de données selon certains critères spécifiques bref tout ce genre de petites choses. 

Pour cela nous avons instauré ce qu'on appelle les bases de données en informatique qui permettent de stocker les informations de manière relationnelle, on va pouvoir créer des relations entre les informations stockées. 

On pourra par exemple avoir des informations stockées sous forme de tables donc on appelle ça des tables dans les bases de données donc des tables SQL. 

SQL, c'est le langage qui est utilisé en base de données je vais revenir dessus. 

Ainsi les tables peuvent stocker certaines informations. 

Vous pouvez par exemple avoir un site web avec une table qui stockent les utilisateurs, une table qui va stocker les news de votre site, une table qui va stocker par exemple les rangs pour les utilisateurs (administrateur, modérateur et cetera) et vous pouvez comme ça créer des relations. 

Vous pouvez dire par exemple qu'un utilisateur a un rôle par exemple modérateur. 

Et vous pouvez comme ça créer des relations entre différentes tables et stocker toutes ces informations et pouvoir faire des recherches dessus via ce qu'on appelle des requêtes SQL.

Alors il existe plusieurs moteurs de gestion de base de données qu'on appelle les SGBD notamment, tous ces systèmes là ont leurs avantages et leurs inconvénients. 

Moi mon but c'est évidemment de vous proposer une solution parce qu'il en existe plusieurs, et de vous expliquer un petit peu l'ensemble des autres parce qu'on lit et on entend beaucoup choses concernant les SGBD. 

Par exemple certains vous diront que MySQL c'est le mieux, d'autres qui vous diront que PostgreSQL c'est mieux que MySQL et d'autres qui vous diront que SQLite est le mieux et cetera. 

Et on va avoir beaucoup de support qui vont toujours vous mettre en avant là plus que l'autre, alors que au final il n'y en a pas un qui est mieux que l'autre, il n'y en a pas un qui est moins bien que l'autre. 

Encore une fois et ça fonctionne pour tous, vous avez chaque système, chaque technologie, chaque langage qui est bon dans un domaine, qui fonctionne bien pour répondre à certains besoins, qui fonctionne bien selon un cas spécifique, une situation spécifique mais qui ne fonctionnera pas du tout pas de manière optimale dans un autre cas dans une autre situation. 

Donc moi ce que je vais vous proposer ici au maximum c'est de travailler comme on le fait souvent avec des choses que propose python en natif. 

Mon intérêt c'est toujours de vous apprendre un langage ou une technologie avec ce qu'elle propose de manière native, avant même que vous ayez après votre autonomie et l'indépendance pour pouvoir découvrir des choses externes parce que vous savez que python propose plein de modules, plein de bibliothèques externes. 

Donc la première chose à faire c'est apprendre déjà ce que vous propose python en standard, en natif, tout seul, et après de voir plus loin.

Pour ça du coup je vais vous proposer dans cette vidéo de travailler avec SQLite. 

Quel est l'intérêt de SQLite par rapport aux autres ? 

SQLite vise à remplacer l'utilisation de fichiers texte, et j'insiste bien là-dessus, il ne sert vraiment qu'à ça.

L'intérêt c'est de ne plus avoir de fichier texte mais de travailler avec des bases de données à la place qui sont beaucoup plus légères et qui vont permettre de faire tout un tas de recherches et notamment de requêtes SQL. 

Alors au moment où j'enregistre cette vidéo, je n'ai pas encore fait la formation SQL mais sachez qu'il y en aura une pour ceux qui se posent la question parce que pas mal de gens le demandent. 

Il y aura une formation à part juste sur le langage SQL donc ça prendrait vraiment tout le détail sur le langage à faire des requêtes, à connaître un peu les différentes fonctions et cetera. 

On va faire un peu de SQL dans d'autres formations mais de manière standard, très simple donc vous n'êtes pas obligé d'apprendre la partie SQL, on va dire. Je vais vous donner la formation par contre si vous voulez vraiment apprendre le langage SQL pour l'utiliser en PHP, en python, le réutiliser en Java ou je ne sais quoi. 

Dans n'importe quel langage où vous pouvez utiliser des requêtes SQL, alors n'hésitez pas que l'information sera bien évidemment publiée parce qu'elle ne l'est pas au moment où j'enregistre cette vidéo, à consulter le cours SQL sur la chaîne, et comme ça vous aurez tout le détail à ce niveau là. 

Alors grosso modo … si on veut faire simple parce que je ne vais pas rentrer dans les détails parce que comme vous le voyez je n'ai même pas encore commencé à programmer donc je ne vais pas trop traîner non plus dans les explications … Alors on a 3 cas de figure, et ça vous pouvez les retenir parce que ce sont les 3 cas de figure qui fonctionne plutôt bien dans la réalité, ça fonctionne à 99 pour 100 comme ça. 

SQLite est fait pour remplacer l'utilisation de fichiers texte et pas autre chose, il a été conçu par exemple pour fonctionner depuis les téléphones. Vous savez votre smartphone et tout ça, vous utilisez des applications, et ses applications plutôt que de devoir se connecter à distance à des bases de données et avoir des choses un peu lourdes parce que ça peut être aussi compliqué. 

En effet les téléphones n'avaient pas non plus beaucoup d'espace de stockage à l'époque, ils n'avaient pas beaucoup de mémoire vive même si ça a tendance à changer donc on avait besoin de proposer un système beaucoup plus léger parce que les systèmes comme MySQL voir Oracle, enfin bref des systèmes de bases de données très très lourd, c'était absolument impensable d'avoir ça sur un appareil mobile. 

Donc on a inventé SQLite pour proposer un fichier donc vous aurez un fichier qui va représenter votre base de données. Nous allons travailler avec ça. 

Du coup SQLite ne doit fonctionner que pour ça c'est-à-dire que SQLite n'est pas utiliser … ça je vais le dire, pour n'importe quelle formation, n'importe quel cas, vous ne devez pas utiliser SQLite si vous voulez gérer énormément de quantité de données. 

Alors ici je vais vous donner une fourchette qui est péjorative parce qu'elle peut être revue à la hausse ou à la baisse mais moi je pars du principe qui à partir du moment où votre base de données ou vos bases de données arriva une quantité de données qui atteint le Giga Octet, vous pouvez considérer que SQLite n'est pas une bonne solution. 

Alors le problème c'est qu'en ce moment on démarre un projet, on ne va pas savoir à l'avance combien peuvent atteindre les données donc c'est à vous de l'estimer par rapport à votre projet, votre site web, votre jeu vidéo ou je ne sais quoi.

Bref se demande si un jour on va pas atteindre le giga octet de données parce que ça peut mine de rien aller vite, une base de données qui fait un giga octet c'est pas énorme. 

Il y a plein de bases de données sur des gros projets qui dépasse largement cette taille là. 

Donc si vous pensez qu'un jour votre base de données va s'étendre au-delà du giga octet, évitez SQLite, ce n'est pas forcément intéressant. 

Après dans certains cas ça se peut il y a forcément des projets mobiles sur téléphone qui dépasse le giga octet et utilise SQLite mais en même temps ils n'ont peut-être pas trop le choix, ça fonctionne sur mobile donc ça reste forcément la solution la plus viable mais dans l'idéal éviter si vous pouvez. 

Après quand on commence à avoir des données en grosse quantité où ça peut aller loin, et notamment quand on a besoin de la multiple connexion c'est-à-dire que le problème de SQLite ce que vous n'avez pas pouvoir connecter tout un tas d'utilisateurs en même temps parce qu'ils vont chacun devoir attendre d'avoir la main sur la base de données. 

Et en plus s'il y a trop d'utilisateurs qui se servent en même temps de la base de données en faisant des requêtes, il risque d'y avoir des conflits et des problèmes. 

Même si il y a un système de verrou pour empêcher que 2 utilisateurs en même temps puissent toucher à la même information, il est possible dans certains cas que ça se désynchronise et du coup ça crée des problèmes. 

Donc si vous prévoyez comment votre base de données puissent être consultées par plusieurs utilisateurs mais je parle vraiment de quantité assez importante, pareil SQLite n'est pas forcément la bonne solution d'accord. 

Dans ce genre de cas qu'est-ce qu'on va utiliser ? Et bien on va utiliser une solution comme MySQL qui est la solution la plus répandue et pourquoi ? Parce qu'elle correspond pratiquement à tous les projets qui utilisent les bases de données dans le monde, pratiquement tous. 

Et certains me diront qu'il y a des histoires comme Oracle et cetera qui sont des solutions propriétaires donc c'était un peu l'équivalent de MySQL d'accord qui sont des solutions très lourdes mais il y a aussi PostgreSQL dont on entend parler. 

Souvent on a beaucoup de gens qui nous disent, PostgreSQL est encore mieux que MySQL et ces gens ont tort, tout simplement parce que PostgreSQL a été créé pour manipuler des bases de données beaucoup beaucoup beaucoup plus grosses que ce qu'on peut manipuler avec MySQL. 

PostgreSQL et je vous le dis c'est mon conseil vous en faites ce que vous voulez, il est intéressant utilisé à partir du moment où vous travaillez sur des bases de données de plusieurs téraoctet de données. 

Donc déjà avant d'atteindre le téraoctet de données, il faudra en voir. 

Par exemple CHU, tout un service médical, ils vont atteindre sans problème plusieurs téraoctet de données pour la gestion des dossiers de patients, allez faire basculer, créer des relations entre les différents départements et différentes régions, et cetera. 

Et donc là oui on est vraiment dans le téraoctet de données donc oui pourquoi utiliser des bases de données en PostgreSQL, pas de problème ce sera largement optimisé. Ils ont vraiment choisi le meilleur système de base de données qu'il y a pour ça. 

Après il y a encore des solutions de propriétaires comme dans Oracle ou Windows Server mais je ne parle pas de ces solutions là parce que ça ce sont des solutions de propriétaire qui ne sont pas forcément gratuites pour la plupart donc je les met de côté. 

Ce sont évidemment des solutions viables pour de gros projets également mais moi je parle de solutions gratuites en tout cas. 

Donc retenez ça, si vous travaillez sur quelque chose de léger qui ne nécessitent pas d'avoir trop de données donc voilà que ça dépasserait le giga de données et qu'il n'y a pas besoin de connexions multiples, vous pouvez utiliser SQLite et c'est ce que je vais vous montrer dans cette vidéo donc on va pouvoir y arriver enfin :). 

Si vous avez besoin de gérer un projet qui est assez conséquent, qui a soit besoin d'avoir plusieurs connexions simultanées par exemple pour un forum, l'accès à des news, ce genre de chose où ça peut nécessiter un accès par plusieurs personnes, et qui du coup peuvent atteindre des fois plusieurs gigas de données, MySQL est à mon sens la meilleure solution. 

Et si par contre vous avez besoin de manipuler des données qui peuvent atteindre le téraoctet voir plus, là PostgreSQL est la meilleure solution parce qu'il a été conçu avec des fonctionnalités supplémentaire pour gérer justement des quantités de données très astronomique, là où MySQL se montrerait très limite. 

Par contre utiliser PostgreSQL sur une base de données qui fait que quelques méga-octets, vous allez complètement complètement brider les performances de votre base de données. 

Et ça vous pourrez le vérifier dans vos projets et vous verrez la différence. Tester du MySQL et du PostgreSQL sur vos petits projets et vous verrez que MySQL dans la majorité des cas pour pas dire tous, il est beaucoup plus performant. 

Par contre PostgreSQL sur de très très gros projets, c'est lui qui se montre le plus performant. 

Donc on en revient à ce que je vous disais, il n'y a pas un meilleur SGBD, c'est juste que chacun correspond à des besoins d'accord.

S'il y en avait un parfait, il n'en existerait qu'un seul. Personne ne se serait amusé à s'amuser à créer un système si des solutions existantes étaient parfaites, ça paraît logique. 

Par contre chaque système a des besoins, utiliser du PostgreSQL sur une base de données qui fait 100 méga, c'est complètement ridicule. 

Utiliser MySQL sur une base de données qui fait 5 Téra, c'est ridicule aussi. 

Utiliser du SQLite pour gérer imaginons un service de messagerie instantanée donc où il y a plein de gens qui écrivent en même temps pour envoyer des messages, utiliser du SQLite pour faire ça ce n'est pas forcément le meilleur moyen non plus sauf si évidemment on est sur mobile et qu'on n'a pas trop le choix encore une fois. 

Voilà désolé d'avoir été un peu long, on n'a pas fait grand chose sur cette vidéo, j'ai pas mal parlé et je n'ai pas passé grand-chose à l'écran mais peu importe vous savez comment ça fonctionne. 

Vous savez aussi que voilà je peux toujours vous expliquer les choses mais mon but ce n'est pas de vous balancer du code, du code puis de la documentation ou je ne sais quoi sans vous l'expliquer.

Au moins au niveau des bases de données vous savez comment ça fonctionne, si un jour quelqu'un vous balance PostgreSQL c'est mieux que MySQL, Eh bien vous aurez des arguments pour pouvoir justement lui expliquer les choses comme il faut. En tout cas par rapport à la réalité encore une fois et parce qu'on peut lire sur certains forums ou même des fois dans certains ouvrages, ça peut se trouver partout. 

Donc nous on va travailler sur SQLite Parce qu'on va manipuler des données légères, il n'y a pas beaucoup de données et en plus python l'avantage comme c'est un langage portable et utilisable partout, et bien sur SQLite, l'avantage c'est que vous n'avez rien à installer. 

Pas besoin d'installer de moteur de base de données parce qu'il est présent par défaut donc c'est vraiment très pratique, alors pareil à l'heure actuelle, au moment où je fais cette vidéo je n'ai pas fait de tutoriel sur d'autres bases de données mais je prévois de toute façon par exemple un tutoriel pour faire du MySQL avec python. 

Donc c'est prévu aller voir sur la playlist, python tutoriels, peut-être que au moment où vous irez voir le tutorat été publié entre temps sinon vous pouvez toujours me demander en commentaire si ça n'a pas été fait et je vous répondrais bien évidemment. 

Donc on est parti cette fois-ci et encore une fois désolé d'avoir pas mal pris du temps, de vous faire cette petite intro mais ça me semblait absolument nécessaire pour la suite que vous ayez les bonnes habitudes dès le départ et pas que vous tombiez dans des pièges que certaines personnes peuvent tomber. 

Donc SQLite, nous allons commencer par installer un petit logiciel qui en plus est multi plateforme, open source donc l'avantage c'est que c'est le même peu importe le système d'exploitation, qui va vous permettre de visualiser le contenu d'une base de données parce que vous aurez plus tard un fichier. 

Et ce fichier ne pourra pas être lu comme un fichier texte donc c'est bien d'avoir un petit logiciel qui permet d'aller voir à l'intérieur pour voir si vos données ont bien été enregistrées, ou éventuellement plus tard créez vos tables c'est-à-dire les tables dont je vous ai parlé, faire une table utilisateur, une table d'objets, une table de ça une table de çi donc pas mal de choses. 

Donc vous pouvez récupérer sur le site.

[sqlitebrowser.org](https://sqlitebrowser.org/dl/)  

On peut l'avoir en version portable pour Windows, on peut le télécharger pour Mac ou Linux, et de toute façon si vous êtes sur une version Ubuntu ou type Debian, vous pouvez même aller voir dans la doc par exemple d'Ubuntu ou pareil pour Linux Mint c'est la doc de Ubuntu, il devrait vous proposer en théorie de vous l'installer en ligne de commandes très rapidement depuis les dépôts parce que je pense qu'il est dans les dépôts ce type de logiciel. 

À priori vous pouvez toujours aller les voir même s'il en existe d'autres de logiciel pour ça mais moi je vous conseille celui-là parce que c'est vraiment celui qui est multiplateforme, gratuit et open source donc plus pratique à gérer pour tout. 

Voilà pour DB Browser for SQLite. 

Moi je l'ai évidemment récupéré pour Windows parce qu'on en aura besoin et on va pouvoir comme ça travailler un petit peu avec. 

Donc on est sur un fichier normal main.py comme d'habitude et j'ai récupéré la version portable parce que je ne voulais pas l'installer de SQL database browser.
```txt
    SQLiteDatabaseBrowserPortable_3.12.0_English.paf.exe
    SQLiteDatabaseBrowserPortable
    
    C:.
    └───SQLiteDatabaseBrowserPortable
        ├───App
        │   ├───AppInfo
        │   ├───DefaultData
        │   ├───SQLiteDatabaseBrowser32
        │   └───SQLiteDatabaseBrowser64
        ├───Data
        └───Other
```
On va donc pouvoir travailler avec cette partie-là.

Alors SQLite, on va pouvoir faire des requêtes SQL mais au lieu que ce soit stocké dans pas mal d'autres choses lorsqu'on a installer pas mal d'autres choses lorsqu'on installer tout un moteur, on va avoir un fichier qui représentera la base de données et on pourra du coup interrogé dessus, faire des requêtes, ajouter des choses, supprimer modifier créer des tables et cetera et cetera. 

On fera pas mal de petites choses comme ça. 

Donc nous pour la création d'une table, on ne va pas faire de requêtes SQL parce que encore une fois, je pars du principe que c'est votre première formation. 

Je n'ai pas en plus au moment où je fais cette vidéo, fait l'information SQL donc à priori vous ne connaissez pas SQL.

En tout cas je pars du principe que vous ne le connaissez pas donc je ne vais pas commencer à vous faire des requêtes SQL de création de table, ça risque d'être un peu compliqué même si ce n'est pas non plus inaccessible en soi mais on va créer la table du coup directement via le logiciel. 

Donc une fois qu'on a installé le logiciel, téléchargé et cetera, vous pouvez le lancer et vous allez obtenir un genre d'interface.
```
    SQLiteDatabaseBrowserPortable.exe
```
Nous on va pouvoir du coup se créer une base de données.
```
    DB Brower for SQLite > Nouvelle Base de Données
```
On va le mettre dans notre dossier et on va l'appeler base et il va lui mettre une extension, on peut lui mettre .db, .sqlite ou même pareil .db3 mais avec le numéro de la version mais comme on va travailler avec SQLite 3, du coup, il va nous mettre .sqlite3 ou .db3
```
    .\Python\032_base_de_données\base.db
```
Peu importe le type d'extension, on s'en fiche, vous pouvez mettre .data ce que vous voulez. D'ailleurs vous pouvez mettre .ddd, .database, vous pouvez mettre absolument l'extension que vous voulez. Ça n'a aucune importance. 

C'est juste que par habitude, on met une de cette là .db ou .sqlite, ou éventuellement avec le numéro de version derrière.

Donc je crée ça.
```
    .\Python\032_base_de_données\base.db
```
Donc il me propose éventuellement de créer une table.
```
    Editer la définition de la table
```
Et là en plus, il vous affiche la requête SQL correspondante.
```sql
    CREATE TABLE "" (

    );
```
Donc nous, on va faire une table t_users.

Généralement ça c'est une petite astuce quand par exemple gérer un site web, vous mettez le nom de votre site web ou autre. Vous ne mettez pas juste users mais vous mettez un petit préfixe pour éviter par exemple si des pirates veulent pirater votre site, puisse éventuellement deviner les noms qu'il va y avoir parce que si par exemple ils veulent tenter de pirater votre base de données, ils vont justement cherché une table "users" ou quelque chose comme ça parce que c'est le nom utilisé le plus souvent par les gens à tord. 

Donc essayez de mettre un petit préfixe que vous donnez à personne bien sûr et ça peut être n'importe quoi, des chiffres au hasard ou des lettres. Enfin ce que vous voulez ça peut être par exemple, mon préfixe est par exemple mon_users et puis plus loin news et cetera pour éviter d'avoir un nom qui est devinable par un potentiel pirate qui voudrait interroger votre base de données pour récupérer par exemple des informations d'authentification sur votre site ou n'importe quoi.

Donc nous on ne va pas chercher un truc très compliqué on va juste mettre tt_users voilà. 
```sql
    CREATE TABLE "tt_users" (

    );
```
Donc ça on l'ajoute et on va créer un champ, les champs c'est que dans la table on va pouvoir choisir quel champ, elle a. 

Par exemple moi tt_users, qu'est-ce que je veux qu'elle ait comme information? Je ne suis pas encore là pour vous faire un cours sur la SQL donc vous allez juste faire écouter ce que je vous dis sans forcément apprendre ça parce que vous n'êtes pas là pour apprendre la SQL. 

On va faire un identifiant parce que c'est bien d'avoir un identifiant surtout quand on veut faire des sélections de tri donc on va faire … alors ça c'est mon habitude parce que je trouve que c'est bien de noter comme ça, c'est toujours de noté pour l'identifiant "id_" suivi du nom utilisé pour la table donc en gros "id_user".
```
    Editer la définition de la table > Champs > id_user (INTEGER, CP, IA)
```
```sql
    CREATE TABLE "tt_users" (
        "id_user"	INTEGER,
        PRIMARY KEY("id_user" AUTOINCREMENT)
    );
```
Ensuite on le met en clé primaire et en auto incrémentation parce qu'on veut que l'identifiant soit unique pour chaque utilisateur et on auto-incrémente c'est-à-dire qu'il fasse augmenter de un automatiquement voilà. 

Et on va ajouter un autre champ et ici on prend le nom de la table au singulier "user_" et je mets le nom du champ que je veux donc par exemple si je veux le nom d'utilisateur, je vais mettre "user_name".
```
    Editer la définition de la table > Champs > user_name (TEXT,
```
```sql
    CREATE TABLE "tt_users" (
        "id_user"	INTEGER,
        "user_name"	TEXT,
        PRIMARY KEY("id_user" AUTOINCREMENT)
    );
```
Là c'est un texte donc TEXT, on le met et après on a d'autres champs pour choisir si il est obligatoire ou non mais ça on s'en fiche. 

Ensuite, on va faire par exemple un joueur de jeu vidéo, et on va mettre "user_lever" et level c'est un INTEGER et du coup on peut faire OK.
```sql
    CREATE TABLE "tt_users" (
        "id_user"	INTEGER,
        "user_name"	TEXT,
        "user_level"	INTEGER,
        PRIMARY KEY("id_user" AUTOINCREMENT)
    );
```
C'est tout.

Donc vous voyez qu'il m'a créé une table donc ça il faut pas le enlevé, c'est la table qui vous dit combien vous avez en fait d'éléments donc faut la laisser. 
```txt
    Tables (2)
        sqlite_sequence
            name
            seq
```
Et là, on a du coup la table tt_users avec nos 3 champs.
```txt
    Tables (2)
        sqlite_sequence
            name
            seq
        tt_users
            id_user             INTEGER
            user_name           TEXT
            user_level          INTEGER
```      
On l'enregistre les modifications et terminé.
```txt
    DB Browser for SQLite > Enregistrer les modifications
```
Et c'est terminé.

On va commencer déjà par créer un utilisateur donc on va ajouter ce qu'on appelle une ligne, on va ajouter un enregistrement, une entrée à la base de données qu'on pourra les lire ensuite au niveau de notre code. 

Ce sera plus pratique et après on verra pour en ajouter un 2e pour voir si ça a bien fonctionné donc on va faire en fait une lecture de la base de données et ensuite on va enregistrer donc écrire dans la base de données pour voir si les 2 fonctionnent bien. 

Donc on va aller sur tt_users, on va faire parcourir les données puis un nouvel enregistrement et là vous allez voir que par défaut id_user est à 1 et ça il ne faut pas le faire nous-mêmes. 
```txt
    DB Browser for SQLite > Parcourir les données > tt_users > Insérer un nouvel enregistrement dans la table en cours
```
Vous n'avez pas besoin de spécifier vous-même l'identifiant, jamais, c'est la base de données qui va le faire toute seule. 

Et là user_name, vous allez pouvoir lui mettre l'info donc je vais lui mettre mon prénom Jason, et puis au niveau du niveau, on va mettre par exemple niveau 15 admettons. 

Voilà on fait ça et enregistrer les modifications.
```txt
    DB Browser for SQLite > Enregistrer les modifications
```
Et normalement c'est bon.
```txt
    DB Browser for SQLite > Fichier > Fermer la Base de Données
```
On peut fermer ça et logiquement ma base de données doit être enregistrée. Ainsi je peux retourner sur le dossier python dans lequel j'ai mon fichier main.py et mon fichier main.db

Donc ça main.db, c'est ma base de données. 

Juste avec ce fichier là toute votre base de données est enregistrée mais l'avantage n'est pas seulement un simple fichier texte et si j'essaie de l'ouvrir, j'obtiens ça.
```txt
    SQLite format 3 ...
```
On obtient ça, le fichier est en binaire donc on ne va pas pouvoir le lire comme ça mais du coup on va pouvoir l'interroger là-dessus, faire des requêtes, faire de la recherche, faire de la sélection, l'enregistrement tout ça bref pas mal de petites choses intéressantes. 

Donc on y va on va travailler à ce niveau-là et commencer à importer un petit module … du coup on va commencer à faire du code mais il fallait que vous ayez les informations nécessaires mais maintenant on peut parler de code … On va importer le module sqlite3.

```py
    #coding:utf-8
    import sqlite3
```
Encore une fois un module natif en python pas besoin de l'installer il est déjà mais présent.

Vous mettez juste cette ligne là et vous l'avez.

Première chose à faire pour une base de données, il faut se connecter. 

Là où avec un fichier, il faudrait l'ouvrir avec un mode, une base de données on va se connecter dessus et en sqlite c'est très simple, il suffit de se connecter au fichier de base de données donc je crois que le fichier existe déjà et il va être tout simplement ouvert soit le fichier sur lequel vous voulez vous connectez n'existe pas et il va du coup être créé en fonction du nom que vous mettez. 

La variable je vais l'appeler connexion parce que c'est une connexion qu'on fait donc essayez de prendre des noms pour vous qui sont suffisamment explicites mais en général je mets connexion puisqu'on crée une connexion. 

On va avoir une instance de connexion de sqlite donc on va l'appeler connexion comme ça je suis sûr de pas me tromper, égal sqlite3.connect()
```py
    connection = sqlite3.connect()
```
Donc tout en minuscule et là vous mettez le nom de votre base c'est-à-dire le nom de votre dossier avec l'extension "base.db", un petit copier coller comme ça vous êtes sûr de ne rien oublier.
```py
    connection = sqlite3.connect("base.db")
```
Parce que si le nom est différent et que vous mettez par exemple "base2.db", il va créer un nouveau fichier mais il ne va pas ouvrir celle qui est déjà existante.

Voilà et comme toute base de données comme pour un fichier, si ça a été connecté donc ouvert, il faudra fermer donc on va faire automatiquement un connection.close() mais seulement à la fin une fois qu'on en aura besoin donc on va laisser ça comme ça.

```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    
    
    
    connection.close()
```
À partir de là nous allons pouvoir récupérer les données, et pour lire de donner nous avons pas mal de petites choses à faire. 

Nous allons d'abord avoir besoin de créer un curseur c'est-à-dire qu'un curseur sans rentrer dans les détails mais c'est un outil qui va vous permettre de travailler avec les requêtes c'est-à-dire qu'une fois qu'on aura le curseur, il va pouvoir effectuer une sélection. 

Une sélection c'est de la recherche dans la base de données, on va pouvoir faire un enregistrement avec un insert(), on va pouvoir faire une mise à jour avec un update() ou une suppression avec un delete(). 

Et on a évidemment d'autres types de requêtes mais ça ce sont les principales, c'est ce qu'on appelle les fameuses requêtes donc les interfaces CRUD pour ceux qui connaissent.

On vous a peut-être déjà parlé de CRUD qui veut simplement dire Create, Read, Update et Delete.

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    
    
    
    connection.close()
```
Voilà donc ça c'est le minimum général, quand on manipule des bases de données on doit faire ces 4 choses là c'est-à-dire pouvoir enregistrer l'information (Create) … attention on part du principe que la table est déjà créée et donc on fait un insert(), on enregistre une info. 

On peut la lire Read() donc le select(). 

On peut la modifier Update() et on peut la supprimer avec Delete().

Voilà donc ça c'est le CRUD. 

Une fois que ça c'est fait, quand on est connecté, et que normalement ça a fonctionné mais de toute façon on verra après comment gérer les erreurs parce que vous vous doutez bien qu'en base de données pour bien faire faire les choses, on doit gérer les erreurs mais ça on le verra à la fin. 

Pour faire ça de manière un peu plus propre on va rester sur des choses simples pour le moment. 

Ainsi on va pouvoir créer notre curseur.

Alors le curseur en général je lui donne simplement le nom curseur, pourquoi est bien comme ça au moins je suis sûr de ne pas me tromper dans le nom. 

Donc on va mettre ça, cursor=, et comme ça au moins je suis sûr de ne pas me tromper et ça correspond à connection.cursor().

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()
    
    
    connection.close()
```
Donc ça va créer un objet, une instance pardon de la classe cursor qui appartient à sqlite3. 

Donc là c'est une instance de connexion :

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")#     <-------------
    cursor = connection.cursor()
    
    
    connection.close()
```
Et là c'est une instance de curseur.

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()#               <-------------
    
    
    connection.close()
```
D'ailleurs ce qu'on peut s'amuser à faire, c'est de faire print(type(connection)). C'est vrai qu'on ne le fait pas souvent ça depuis … parce que maintenant vous êtes grand :) donc on ne fait plus trop de vérification. 

Mais ça peut être bien de vérifier éventuellement.

+ main.py
```py
#coding:utf-8
import sqlite3
# CRUD : Create, Read, Update, Delete

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

print(type(connection))
print(type(cursor))

connection.close()
```
```powershell
    >python main.py
    <class 'sqlite3.Connection'>
    <class 'sqlite3.Cursor'>
```
Voilà vous voyez que le premier s'est sqlite3.Connection Donc c'est une instance de classe Connexion, c'est une classe qui appartient à sqlite3 qu'on a instancié ici.

Sqlite3.Cursor, et là on a créé une instance de curseur. 

Et on va pouvoir du coup travailler avec ces 2 objets là tout le long et on n'oublie pas à chaque fois de couper à chaque fois la connexion. 

Ce qu'on ferme à chaque fois ses connexions donc c'est logique que je fasse le close() sur connexion et pas par exemple sur curseur ou autre. 

Donc ça c'est pour que vous comprenez la logique parce que c'est bien que de vous expliquer les choses … c'est bien de balancer du code mais si on explique pas un minimum pourquoi la logique derrière, pourquoi … pourquoi on ferme et cetera.

Là au moins vous comprenez pourquoi on procède de cette manière. 

Une fois que ce curseur est prêt, on va pouvoir travailler avec lui … c'est avec lui, ce petit curseur "cursor" là que nous allons pouvoir faire toutes nos requêtes.  

Nous avons plusieurs requêtes possibles soit nous allons avoir par exemple une seule requête c'est-à-dire qu'il ne va faire qu'une seule information, on va utiliser la méthode execute() et si on a besoin de gérer plusieurs informations quand on fait notamment une insertion donc un insert(), on va utiliser executemany().

Donc nous on va utiliser execute() parce qu'on va juste faire une sélection, on va les lire dans la base de données les infos que j'ai écrit tout à l'heure via le logiciel tel qu'on l'avait vu. 

Alors comment est-ce qu'on va procéder à ça ? on va procéder de cette manière en faisant la méthode de base cursor.execute() et qui va prendre la requête à faire.

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    cursor.execute()
    
    connection.close()
```
Encore une fois vous n'êtes pas ici pour apprendre SQL donc sachez que la requête pour sélectionnez un élément dans la base, ça va être 
```py
    'SELECT * FROM tt_users WHERE user_name = ?'
```
Donc on fait SELECT, l'étoile c'est pour dire que je sélectionne tout puis FROM la base qui est tt_users puis WHERE avec le champs sur lequel je veux choisir une condition par exemple c'est-à-dire dans le cas où user_name … ça c'est le champ de la base de données … égal quelque chose mais nous on va faire des requêtes sécurisé donc moi je vais vous montrer le moyen de faire des requêtes sécurisé pour éviter les injections SQL où ce genre de chose parce que oui en python il faut également sécuriser comme on le fait en PHP, on met un ?. 

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    cursor.execute('SELECT * FROM tt_users WHERE user_name = ?',...ici...)
    
    connection.close()
```
Et ici il faudra passer après la virgule élément à avoir donc n'utilisez pas de syntaxe comme ceci '= %s'.
```py
    cursor.execute('SELECT * FROM tt_users WHERE user_name = %s',)
```
On le fait plus vraiment maintenant en python 3, on le faisait beaucoup avant et après on passait notre variable avec le user.
```py
    cursor.execute('SELECT * FROM tt_users WHERE user_name = %s' user)
```
Ça ce n'est pas du tout sécurisé, là vous risquez de prendre beaucoup de risques. 

Vous mettez comme ceci, un petit joker et vous allez passer l'info après la virgule. 

Et l'info comment la passer, vous créez votre variable tout simplement my_username égale un tuple donc le tuple même s'il n'y a qu'une seule valeur, vous mettez votre valeur toute seule "Jason" une virgule , et vous ne mettez rien sur le 2e élément. 

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()
    
    my_username = ("Jason",)
    cursor.execute('SELECT * FROM tt_users WHERE user_name = ?',)
    
    connection.close()
```
Voilà ça ce n'est pas moi qui l'invente, ça fait partie de la manière dont a été fait la gestion pour les requêtes donc voilà je ne peux pas vous dire si c'est bien ou pas bien, c'est juste que ça a été décidé comme ça et il faut faire un tuple.

Même si vous n'avez qu'un seul élément, vous mettez le premier élément du tuple, une virgule et ne mettez rien après. 

Et c'est tout, et maintenant il n'y a plus qu'a passer my_username et automatiquement il va remplacer ici le ?, le premier qu'il voit, par le contenu de my_username donc par "Jason".

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()
    
    my_username = ("Jason",)
    cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)
    
    connection.close()
```
Eh bien on va lui dire quoi ? tu sélectionne toutes les infos depuis la base de données tt_users dans le cas (WHERE) où le champ user_name égal du coup "Jason" et ça tombe bien parce que c'est ce que j'ai enregistré quand j'enregistrait l'utilisateur depuis le logiciel. 

Et là logiquement on va avoir l'information ici qui va être enregistrer. 

Pour l'afficher comme il n'y a qu'une seule information parce qu'on a fait un execute(), on a la méthode fetchone(). 

Donc je vais juste faire un print() de cursor.fetchone() juste comme ça.

+ main.py
```py
#coding:utf-8
import sqlite3
# CRUD : Create, Read, Update, Delete

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

my_username = ("Jason",)
cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)

print(cursor.fetchone())

connection.close()
``` 
fetchone(), ça veut dire de récupérer, de lister sous forme d'une seule donnée donc one d'où le fait que ça s'appelle fetchone() mais quand il va y avoir plusieurs résultats possibles parce que des fois on peut avoir une requête qui retourne plusieurs résultats d'un coup, on mettra fetchall() mais ça on verra plus tard. 

Donc nous on fait juste fetchone() et on va avoir ici l'information à récupérer. 

On y va.
```powershell
    >python main.py
    (1, 'Jason', 15)
```
Donc là vous voyez qu'il récupère les informations sur cette forme là d'accord. 

On voit qu'il y a l'id (1), le user_name et il y a le user_level (15). 

Par exemple si je ne veux que l'information user_name, et bien ça fonctionne comme un tableau ou comme une liste, l'id est l'indice 0 et user_name est l'indice 1 et user_level est l'indice 2. 

Donc vous pouvez très bien faire directement comme ceci avec l'indice 1 pour avoir le nom d'utilisateur. il vous suffit de mettre entre crochets l'indice que vous voulez récupérer et là vous allez récupérer l'info.

+ main.py
```py
#coding:utf-8
import sqlite3
# CRUD : Create, Read, Update, Delete

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

my_username = ("Jason",)
cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)

print(cursor.fetchone()[1])

connection.close()
```
```powershell
    >python main.py
    Jason
```
Et voilà ici vous avez récupérer l'info, si vous voulez faire ça plus proprement, on met tout ça entre accolades pour avoir l'information proprement dans une ligne de texte.

+ main.py
```py
#coding:utf-8
import sqlite3
# CRUD : Create, Read, Update, Delete

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

my_username = ("Jason",)

cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)

print(f"Le nom d'utilisateur est : {cursor.fetchone()[1]}")

connection.close()
```
```powershell
    >python main.py
    Le nom d'utilisateur est : Jason
```
Voilà comment vous pouvez obtenir la formation proprement. 

Alors si vous préférez … c'est mieux conseiller parce que là vous voyez qu'on mélange beaucoup de choses et moi personnellement je ne suis pas friand de cette manière de faire, je préfère souvent créez des variables intermédiaires parce qu'on arrive à mieux lire son code et surtout quand on veut plus tard le maintenir ou le mettre à jour c'est beaucoup plus simple … c'est mieux je trouve d'enregistrer l'info donc par exemple vous pouvez enregistrer la requête en faisant ça, req = …

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    my_username = ("Jason",)

    req = cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)

    print(f"Le nom d'utilisateur est : {cursor.fetchone()[1]}")

    connection.close()
```

Et après du coup vous pouvez récupérer le résultat mais bon moi ici je vais mettre un nom un peu générique result mais vous pouvez mettre un nom plus explicite, et du coup vous pouvez faire `= cursor.fetchone()[1]` comme on a fait tout à l'heure. Et comme ça on fait {result} plus pratique.

+ main.py
```py
#coding:utf-8
import sqlite3
# CRUD : Create, Read, Update, Delete

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

my_username = ("Jason",)

cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', my_username)
result = cursor.fetchone()[1]

print(f"Le nom d'utilisateur est : {result}")

connection.close()
```
```powershell
    >python main.py
    Le nom d'utilisateur est : Jason
```
C'est pas obligatoire mais bon voilà ça fonctionne pareil mais au moins on passe par une variable intermédiaire et c'est donc beaucoup plus lisible ici et du coup c'est beaucoup plus simple parce que après il n'y aura qu'à modifier à cet endroit là.
```py
    result = cursor.fetchone()[1]
```
Parce que si jamais vous avez besoin d'afficher plusieurs fois cursor.fetchone()[1], vous allez du coup le répéter encore une fois comme vous savez le duplication pas mal d'endroit de votre code et le jour où cette ligne là va changer et que vous devez récupérer l'indice 2 à la place de l'indice 1, on aura pas a modifier autant de fois que vous l'avez mis.

Alors que là on aura juste cette ligne là modifier et tous les result seront modifiés encore une fois partout donc ça c'est pour révision des variables, tout ce qu'on a vu sur les variables depuis le tout début du cours donc logiquement vous êtes largement à l'aise avec tout ça. Je ne vous apprends rien du tout ici. 

Voilà pour cette partie. Voilà ça fonctionne via des indices.

Si on a plusieurs infos mais on le fera après parce qu'on va d'abord enregistrer un nouvel élément et après on refera une lecture sur plusieurs choses. 

Comment est-ce qu'on va pouvoir procéder ? Eh bien tout simplement avec plusieurs choses donc là nous avons fait simplement de la lecture, on n'a pas modifié la base de données, on a juste fait une lecture et c'était terminé. 

Une fois qu'on a fini la lecture, on ferme la base de données connection.close() et pas de soucis.

Là on va enregistrer un élément donc ce que l'on va faire c'est déjà passer toutes les informations ici, my_username = ("Jason",).

Je vais virer tout ça et je veux créer un nouvel utilisateur, new_user. Et vous pouvez le passer sur plusieurs infos donc on peut en faire une liste, on peut très bien vouloir plus tard ajouter plusieurs utilisateurs et on peut très bien faire ça. 

```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = []

    connection.close()
```
Ca veut dire qu'on va passer par exemple un premier id à 1, et un nom "Jason" et un level (1, "Jason", 15).
```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [(1, "Jason", 15),]

    connection.close()
```
Ensuite, on en met un autre, on met 2 ... encore une fois les id, ce n'est pas à nous de les remplir mais je vous expliquerait comment faire après ... on met (2, "Marc", 8).
```py
    #coding:utf-8
    import sqlite3
    # CRUD : Create, Read, Update, Delete

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [(1, "Jason", 15), (2, "Marc", 8), ...]

    connection.close()
```
Et puis un autre ... et du coup on pourra les ajouter tous ensemble mais ça vous savez comment ça fonctionne c'est une liste donc encore une fois, je ne reviens pas dessus.

Donc nous on va en n'avoir qu'un seul donc voilà comment on va procéder alors pour l'identifiant ce n'est pas à vous de le noter parce que je vous avais dit que c'était à la base de données de le faire donc vous pouvez automatique pour interroger la base pour qu'automatiquement elle mette l'identifiant courant c'est-à-dire là où elle en est au niveau des enregistrements.

Donc moi logiquement le premier qu'il a fait il a mis l'id à 1 et logiquement le 2e, il devrait mettre l'id à 2. 

C'est plus pratique pour gérer des tris pour faire un ordre d'affichage ou de récupération de données. 

Donc pour ça, ce qu'on va faire c'est simplement utiliser la propriété lastrowid sur l'élément qu'on veut. 

Le mieux c'est de faire cursor.lastrowid pour l'id.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, ...]

    connection.close()
```
On va lui passer l'information "Julie", on va lui passer également un niveau 23 et nous avons tous les éléments enregistrés. 
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]

    connection.close()
```
Et ensuite on fait la requête cursor.execute() et donc on passe la requête.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute()

    connection.close()
```
Alors  la requête comme tout ça c'est juste de la révision, si vous voulez l'écrire sur plusieurs lignes, vous pouvez utiliser la syntaxe comme ça `""" """` parce que vous savez qu'en écrivant 3 doubles quotes, vous pouvez du coup mettre les choses comme ça sur plusieurs lignes. 
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute("""SELECT *
    FROM ... """)

    connection.close()
```
3 double quote permettant ainsi de faire les choses sur plusieurs lignes mais évidemment il n'y a rien de nouveau. 

Donc nous évidemment on va faire un 'INSERT' et ça c'est la requête pour enregistrer un nouvel élément et ça s'appelle 'INSERT INTO' d'accord et on met en général le nom de la base 'INSERT INTO tt_users' donc on insère à l'intérieur de tt_users les valeurs suivantes 'INSERT INTO tt_users VALUES()' Donc nous ça va prendre 3 valeurs donc on met 3 points d'interrogation 'INSERT INTO tt_users VALUES(?,?,?)'
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute('INSERT INTO tt_users VALUES(?,?,?)')

    connection.close()
```
Tout simplement et puis vous mettez une petite virgule et vous n'avez plus qu'à placer votre variable new_user.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute('INSERT INTO tt_users VALUES(?,?,?)', new_user)

    connection.close()
```
Et là comment enregistrer une nouvelle chose dans la base, il faut "commiter" c'est-à-dire qu'il faut valider les changements de la base comme tout à l'heure lorsque j'ai cliqué sur le bouton pour enregistrer les modifications.

Et bien là c'est pareil comme on a ajouté des choses, la base de données a changé c'est-à-dire qu'on n'a pas fait que lire à l'intérieur ce qu'il y avait déjà donc on va commiter tout simplement l'enregistrement. 

Et le commit, on va évidemment le faire sur la connexion parce que c'est la base qu'on commit, ce n'est pas le curseur donc on fait juste ceci connection.commit().
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute('INSERT INTO tt_users VALUES(?,?,?)', new_user)
    connection.commit()

    connection.close()
```
Donc c'est important pour avoir l'information et après vous pouvez faire un print() de "Nouvel utilisateur ajouté !".
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    new_user = [cursor.lastrowid, "Julie", 23]
    cursor.execute('INSERT INTO tt_users VALUES(?,?,?)', new_user)
    connection.commit()
    print("Nouvel utilisateur ajouté !")

    connection.close
```
Alors on voit beaucoup de choses dans cette vidéo, cette vidéo sera un petit peu longue mais voilà c'est très important de connaître les bases de données donc je prends bien le temps de vous l'expliquer parce que je n'ai pas envie de faire ça trop vite. 

On fais ça.

+ main.py
```py
#coding:utf-8
import sqlite3

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

new_user = [cursor.lastrowid, "Julie", 23]
cursor.execute('INSERT INTO tt_users VALUES(?,?,?)', new_user)
connection.commit()
print("Nouvel utilisateur ajouté !")

connection.close()
```
Alors oui les bases de données je prends directeur de vous l'expliquer parce que je n'ai pas envie de faire ça trop vite. 
```powershell
    >python main.py
    Nouvel utilisateur ajouté !
```
Donc là vous voyez qu'il n'y a pas eu de problème à priori, après on n'a pas encore fait la gestion d'erreur mais ne vous en faites pas, on va le faire à la fin pour vous montrer la bonne méthode pour gérer les bases de données en python en tout cas. Il ne faudra pas faire comme ça je vous montrerai à la fin comment faire pour ne pas avoir trop d'un coup. 

Alors maintenant qu'on a enregistré ce que l'on peut faire déjà, c'est vérifier au niveau du logiciel si ça a bien été ajouté.
```txt
    SQLiteDatabaseBrowserPortable.exe > BD Browser for SQLite > Ouvrir une base de données > base.db
```
Si on va dans Parcourir les données, envoie qu'il a mis tt_users = 2 lignes donc apparemment il y a 2 enregistrements donc c'est plutôt bon signe, si on va sur la table tt_users.
```txt
    id_user     user_name       user_level
    1           Jason           15
    2           Julie           23
```
On voit qu'il a bien ajouté les infos et l'identifiant a bien été mis, il a été auto incrémenté donc depuis 1, il est passé à 2.
Alors des fois ça c'est la question que se posent les gens en base de données, il y a des gens qui se disent admettons qu'un jour je supprime un enregistrement, du coup je vais avoir des trous au niveau de mes identifiants. C'est par exemple je supprime l'identifiant numéro 2, le prochain enregistré aura l'identifiant 3 mais il n'y aura plus d'enregistrement avec l'identifiant 2. Ce n'est absolument pas grave d'accord. 

Les identifiants servent juste à la base de données pour faire du tri et de la recherche parce qu'elle va beaucoup plus vite grâce à ça. Ce n'est pas fait pour nous. 

Si vous voulez utiliser des identifiants uniques en plus avec des valeurs qui se suivent de 1 jusqu à je ne sais pas combien, il faudra créer un autre champ spécial en mettant par exemple autre chose. 

Ici le id_user sert vraiment comme clé primaire et auto incrémentation pour la base de données parce que en faisant un SELECT *, la requête va aller beaucoup plus vite, la requête sera beaucoup plus performante si vous travaillez sur un SELECT * quand vous avez des identifiants sous forme de clé primaire, auto-incrémentés. 

C'est comme ça qu'on fait les choses de manière beaucoup plus performante en base de données, ce n'est pas fait pour l'utilisateur ou le développeur, c'est vraiment juste pour la base de données pour la rendre plus performante et facilité les requêtes, les recherches et cetera. 

Voilà maintenant qu'on a les infos, on a vu que physiquement elle a effectivement été bien enregistrée et on va pouvoir maintenant les récupérer. 

On va juste faire ça, on supprime new_user et la requête.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    cursor.execute('')
    connection.commit()
    print("Nouvel utilisateur ajouté !")

    connection.close
```
La requête la plus simple pour récupérer c'est SELECT * donc sélectionne tout depuis la base tt_users.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    cursor.execute('SELECT * FROM tt_users')
    connection.commit()
    print("Nouvel utilisateur ajouté !")

    connection.close
```  
On ne peut pas faire plus simple, comprend tous les enregistrements de la table tt_users. 

On ne fait pas de commits parce que bien sûr on n'a rien modifié, on fait juste de la lecture.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    cursor.execute('SELECT * FROM tt_users')

    connection.close
```
Si je fais par exemple ça avec la requête dans req puis print(req).

+ main.py
```py
#coding:utf-8
import sqlite3

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

req = cursor.execute('SELECT * FROM tt_users')
print(req)

connection.close()
```
```powershell
    > python main.py
    <sqlite3.Cursor object at 0x000001D056E87F80>
```
C'est bien de faire un petit print() pour voir un petit peu ce que l'on a comme info d'accord et là vous voyez qu'on a bien l'objet cursor, pas de problème à ce niveau-là. 

Donc ce qu'on va faire comme on a plusieurs enregistrements qui vont arriver, on ne fait pas sur fetchone() mais sur fetchall(), on fait sur tout. 

+ main.py
```py
#coding:utf-8
import sqlite3

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

req = cursor.execute('SELECT * FROM tt_users')
print(req.fetchall())

connection.close()
```
```powershell
    > python main.py
    [(1, 'Jason', 15), (2, 'Julie', 23)]
```
les informations sont retournées sous forme de liste. 

Comme je vous ai montré tout à l'heure on peut mettre les informations comme ça (..,..,..) est avec un executemany(), vous pouvez faire plusieurs insert() d'un coup.

Vous n'êtes pas obligé de faire un insert() pour enregistrer qu'une seule personne, vous pouvez enregistrer 15 utilisateurs d'un coup si vous voulez. 

Vous faites une liste avec 15 utilisateurs marqué comme ça [(..,..,..), (..,..,..), …] . Sauf qu'au lieu de mettre en dur l'id, vous faites comme tout à l'heure cursor.lastrowid() comme ça, il va automatiquement les mettre en incrémenté.

Et à la fin, vous n'avez qu'à mettre un executemany().

Vous écrivez comme tout à l'heure avec values() et les ? Comme j'ai fait plutôt dans la vidéo et à la fin, au lieu de passer une petite variable après la virgule dans la requête, vous passez votre liste et ça va ajouter tout du fait que vous utilisez la requête executemany().

Donc c'est juste la différence, c'est pour ça que je ne vous la montre pas au complet parce que je pense que la vidéo est assez longue comme ça mais c'est exactement la même utilisation. 

Si vous travaillez avec execute(), vous passez une variable simple. 

Si vous travaillez avec executemany(), vous pouvez carrément passer une liste d'accord, tout simplement. 

Donc voilà l'information tel quel est.

Après le choix, c'est de la parcourir avec une petite boucle. On peut donc faire ça si on veut pour pouvoir lire l'information mais alors comment est-ce qu'on va faire ?

On va faire juste ça for row, pour chaque ligne de req.fetchall(). On peut le mettre ici mais c'est mieux de passer par une variable intermédiaire.
```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    req = cursor.execute('SELECT * FROM tt_users')
    
    for row in req.fetchall():

    connection.close
```
Et du coup, ou peut faire ça, print(row).

+ main.py
```py
#coding:utf-8
import sqlite3

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

req = cursor.execute('SELECT * FROM tt_users')

for row in req.fetchall():
   print(row)

connection.close()
```
```powershell
    > python main.py
    (1, 'Jason', 15)
    (2, 'Julie', 23)
```
Vous voyez que cette fois-ci on a bien la formation qui est comme ça.

Et du coup, là c'est facile maintenant c'est comment faire pour récupérer les éléments, on l'a fait tout à l'heure, on passe par l'indice 1 si je veux que le nom d'utilisateur. 

+ main.py
```py
#coding:utf-8
import sqlite3

connection = sqlite3.connect("base.db")
cursor = connection.cursor()

req = cursor.execute('SELECT * FROM tt_users')

for row in req.fetchall():
   print(row[1])

connection.close()
```
```powershell
    > python main.py
    Jason
    Julie
```

Et vous avez le nom d'utilisateur donc très pratique.

Vous pouvez comme ça parcourir avec tout ce que vous avez vu. 

Vous vous rendez compte un peu tout ce que vous avez vu, les notions vues précédemment dans le cours, vous resservent tout le temps. 

Tout ce que vous avez vu sur la liste, sur les parcours avec les boucles, et cetera, tout est utile.

La boucle for et d'ailleurs très pratique pour parcourir des collections, parcourir des éléments, plusieurs données comme ça d'un coup que vous pouvez faire une à la suite des autres. C'est plutôt bien pensé et prévu pour ça donc n'hésitez pas à vous en servir de cette manière et vous avez comme ça toutes les informations. 

Si jamais on veut revenir au dernier commit précédent, il y a la commande rollback(). 

On peut faire un connection.rollback()

```py
    #coding:utf-8
    import sqlite3

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    req = cursor.execute('SELECT * FROM tt_users')

    for row in req.fetchall():
        print(row[1])
    
    connection.rollback()
    connection.close()
```

connection.rollback(), permet de revenir au dernier commit.

Par exemple, il y a eu un problème avec celui d'avant.

Donc pour revenir à celui d'avant donc le précédent.

Mais on va le croire parce qu'on va mettre en place un petit système de gestion d'erreur donc gestionnaire de base de données qui soit un peu plus optimisé, un peu plus propre que ce qu'on a fait ici pour terminer en tout cas cette vidéo.

Alors, je vais d'abord essayer de voir si je n'ai rien oublié par rapport à tout ce que je voulais vous montrer d'accord. Il y a tellement tellement d'informations à savoir en base de données qu'il est possible que je puisse avoir oublié quelque chose donc je réfléchis sur tout ce qu'on a vu. 

On a vu la connexion, le curseur, je vous ai montrer comment lire des données, je vous ai montré comment écrire à l'intérieur (le commit), je vous ai montré du coup comment tout récupérer que ce soit un seul  résultat ou éventuellement plusieurs résultats et puis à priori on a tout fait. 

On a vu également comment récupérer le dernier identifiant parce qu'il faut absolument pas le mettre en dur, n'écrivez jamais un identifiant en dur en disant id=1, 2, 3 … ce n'est pas à vous de le mettre mais c'est à la base de données de le faire toute seule. 

Voilà du coup on va gérer les erreurs, comment est-ce qu'on va les gérer ? On va les gérer avec le fameux try except comme vous avez toujours appris à le faire donc ça devrait toujours être fait comme ça. 

Gérez toujours vos erreurs de cette manière 

```py
    #coding:utf-8
    import sqlite3
    
    try:
    
    except:
    
    finally:

    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()

    req = cursor.execute('SELECT * FROM tt_users')

    for row in req.fetchall():
        print(row[1])
    
    connection.rollback()
    connection.close()
```

Et on va même avoir un finally, je rappelle que le finally c'est quelque chose à faire dans tous les cas c'est à dire que les instructions qu'on ait demandé à faire et fonctionner ou non, tout ce qui se passera dans le final sera fait de toute façon. Ce sont des choses à faire peu importe ce qu'il se passe au niveau du code, qu'il y ait des erreurs ou pas, faut le faire.

Qu'est-ce que nous allons faire dans le finally ? je vais le mettre tout de suite, va fermer la base de données donc ça c'est logique.
```py
    #coding:utf-8
    import sqlite3
    
    try:
    
    except:
    
    finally:
        connection.close()
``` 
Parce que cette ligne, la base là ...
```py
    connection = sqlite3.connect("base.db")
```
... ce qu'elle va faire, c'est que soit ce fichier base.db existe et du coup c'est ouvert ou soit le fichier n'existe pas et du coup, elle va en créer un nouveau donc ça aura fonctionné.

Donc il faut à tout prix fermer la base de données quoi qu'il arrive même si les requêtes ici génèrent des erreurs ou des exceptions, quoi que ce soit, il faut à tout prix fermer la base de données donc il faut le faire à cet endroit là, finally.

donc ici vous allez mettre tout votre code dans le try.
```py
    #coding:utf-8
    import sqlite3
    
    try:
        connection = sqlite3.connect("base.db")
        cursor = connection.cursor()

        req = cursor.execute('SELECT * FROM tt_users')

        for row in req.fetchall():
            print(row[1])

    except:
    
    finally:
        connection.close()
```
Alors ici on n'aurait pas grand-chose parce que c'est que de la lecture mais souvent les erreurs que l'on a c'est plus souvent dans l'écriture ou dans la mise à jour admettons mais c'est quand même bien de pouvoir gérer ça comme ça voilà.

Donc dans le try, vous mettez tout ce que vous avez à faire, la connexion et cetera, le curseur, vos petites requêtes. 

Et dans ce genre de cas vous allez rencontrer des erreurs, alors pourquoi le except: et pourquoi on ne peut pas mettre un type d'exception en particulier puisqu'il n'y en a beaucoup. D'après mes souvenirs, on peut avoir des erreurs du type integrityError par rapport à l'intégrité concernant les clés primaires. On peut avoir des erreurs sur OperationError quand on fait des requêtes sur une table qui n'existe pas. 

Admettons si j'essaie de faire ça …
```py
    req = cursor.execute('SELECT * FROM users') 
```
Eh bien là j'aurai des erreurs mais ça on le verra tout à l'heure, on va créer exprès des erreurs pour voir que notre système fonctionne bien. 

Comme il y a plusieurs types d'exceptions, le mieux à mon sens, en tout cas c'est mieux que de ne rien faire du tout, c'est mieux de pouvoir gérer toutes les exceptions plutôt que de ne rien gérer du tout. 

Vous faites un except Exception as e: et là vous gérez du coup vos petites erreurs donc moi en général quand je veux faire un truc très simple, j'affiche un petit `"[ERREUR] ", e`. Et donc ensuite j'affiche e.
```py
    #coding:utf-8
    import sqlite3
    
    try:
        connection = sqlite3.connect("base.db")
        cursor = connection.cursor()

        req = cursor.execute('SELECT * FROM tt_users')

        for row in req.fetchall():
            print(row[1])

    except Exception as e:
        print("[ERREUR]", e)
    
    finally:
        connection.close()
```
On va mettre également le connexion.rollback() parce que si jamais il y a une erreur, il faut revenir au dernier commit. Il faut annuler la tentative ou la requête qu'on a fait parce que admettons que la requête enregistre des choses à moitié, vous aurez des petits soucis dans votre base donc il faut absolument annuler ce qu'on a tenté de faire si jamais il y a eu des erreurs parce que s'il y a eu des erreurs c'est que ça n'a pas fonctionné comme on voulait donc on évite. 

+ main.py
```py
#coding:utf-8
import sqlite3

try:
   connection = sqlite3.connect("base.db")
   cursor = connection.cursor()

   req = cursor.execute('SELECT * FROM tt_users')

   for row in req.fetchall():
       print(row[1])

except Exception as e:
   print("[ERREUR]", e)
   connection.rollback()

finally:
   connection.close()
```
Voilà donc on affiche, on affiche `[ERREUR]` puis j'afficher le message tout de suite alors vous pouvez faire autre chose si vous voulez mais ça c'est vraiment la manière la plus simple. 

Et le rollback() et voilà. 

Donc là maintenant on va retenter pour le coup. 
```powershell
    > python main.py
    Jason
    Julie
```
Du coup vous voyez j'ai pas changé grand-chose, j'ai juste mis ça dans un try except pour que ce soit propre. 

Et là vous voyez que ça fonctionne. 

Et ensuite si on met un nom de base qui n'existe pas, il va me retourner.

+ main.py
```py
#coding:utf-8
import sqlite3

try:
   connection = sqlite3.connect("base.db")
   cursor = connection.cursor()

   req = cursor.execute('SELECT * FROM users')

   for row in req.fetchall():
       print(row[1])

except Exception as e:
   print("[ERREUR]", e)
   connection.rollback()

finally:
   connection.close()
```
```powershell
    > python main.py
    [ERREUR] no such table: users
```
Donc là on a mis un nom de base qui n'existe pas, et il doit me retourner OperationError quand la base de données n'est pas trouvée … Et là, il ne me l'affiche pas parce que il y a "no such table: users" voyez.

Si j'avais voulu ne pas gérer l'erreur pour retourner le type … on ne va pas le faire bien qu'ici il est capturé l'exception. 

Comme ça vous capturez tous les types d'exceptions. 

Après éventuellement il peut aussi avoir le cas où il ne trouve pas l'information avec WHERE. On va faire ça. On va créer une variable user avec un nom qui n'existe pas. Le fameux Toto qui est de retour.

+ main.py
```py
#coding:utf-8
import sqlite3

try:
    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()
    
    user = ("Toto",)
    req = cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', user)

    for row in req.fetchall():
        print(row[1])

except Exception as e:
    print("[ERREUR]", e)
    connection.rollback()

finally:
    connection.close()
```
```powershell
    > python main.py
``` 
Et si on cherche quelqu'un qui n'existe pas, alors là il n'y a pas de problème d'accord. 

Alors vous allez me demander pourquoi est-ce que ça ne génère pas d'erreur ? Ça ne génère tout simplement pas d'erreur parce qu'il n'y a pas de résultat attendu. 

Le truc c'est que vous devez vérifier évidemment au niveau de votre requête si l'information a été retournée, c'est important. 

Dans le cas où vous n'avez rien, vous avez none par exemple, il faudra également gérer ça vous-même parce qu'il ne va pas lever d'exception. 

Il n'y a pas de raison de lever d'exception si dans votre base de données, il n'a pas trouvé de résultat parce que ce n'est pas faux comme requête de dire "cherche un utilisateur qui s'appelle toto" parce qu'il pourrait y en avoir un mais s'il n'y en a pas un c'est à vous de le notifier à l'utilisateur. 

C'est pour ça que je tenais à vous montrer ça comme quoi il faut bien différencier une exception qui est vraiment une erreur commise par rapport à une requête qui n'a pas trouvé de résultats. 

Le fait de ne pas trouver de résultat ce n'est tout simplement pas une erreur, c'est juste qu'il n'y a pas de résultat, terminé. 

Voilà pour cette partie là. 

Je pense qu'on va s'arrêter merci pour cette grosse vidéo donc j'ai fait une grosse introduction au début, j'ai pas mal parlé pour vous présenter tout ce qui concerne les bases de données et je pense que c'était nécessaire. 

S'il y a des choses qui ne sont pas encore très claires évidemment, vous pouvez poser des questions et demander il n'y a pas de souci. Je vous donnerai plus de détails encore si vous trouvez qu'il n'y en a pas eu assez dans cette vidéo. 

Dans tous les cas je pense que j'ai fait un peu le tour de tout ce qu'il y avait à savoir au niveau de l'utilisation de sqlite donc vous voyez que c'est très simple à utiliser. 

Si vous êtes intéressé bien sûr par le SQL comme je le rappelle je vais faire en tout cas parce qu'elle n'est pas fait au moment où cette vidéo est enregistrée, une formation au langage SQL complète qui pourra vous servir dans n'importe quelle autre formation pour PHP, python et cetera, partout où vous ferez du web. 

Donc attendez cette formation-là comme ça vous pourrez vraiment apprendre à faire des requêtes comme ça, et comprendre ces requêtes et même faire des choses un peu plus complexes donc on verra tout ça dans le détail. 

En attendant j'espère que ça vous a plu, j'espère que c'était suffisamment complet. On continuera pour la prochaine séance donc la 33 avec encore d'autres choses. 

On va commencer maintenant à faire autre chose, et je pense qu'on a fait un peu le tour de tout ce qui était vraiment web mais maintenant on va plus partir sur du réseau. 

On verra bien dans ce que je propose pour la suite mais on n'a pas du coup fini ce chapitre-là concernant la partie web réseau donc il y a encore des petites choses à vous montrer et à vous présenter qui sont très intéressantes dans ce langage. 

Je vous dis à bientôt pour la prochaine vidéo et n'hésitez pas à bien vous entraîner et à faire du code, posez des questions si c'est nécessaire et bien sûr partager la vidéo. 

Ciao tout le monde