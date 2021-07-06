# [AIDE - héberger son site en ligne](https://www.youtube.com/watch?v=mXVacXSTns8&list=PLrSOXFDHBtfEwFMZ1YIXgUqOFODGyo7tB&index=14)
@https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide

## Hébergements

+ Auto-hebergement = ma machine devient un serveur d’accès. Les internautes se connectent via l'adresse IP de mon ordinateur pour accéder à mon site web. Besoin d'auto-configurer et de sécuriser.

+ Hébergeur de site web = entreprise avec plusieurs ordinateurs, des serveurs (tout en ligne de commande, pas besoin d'interface graphique).

+ Hébergement au près d'un fournisseur = contrat qui nous lient à l'entreprise qui nous fournit un serveur distant, un pc distant. On envoie notre contenu de site web à ce serveur distant au travers une adresse IP masqué par un nom de domaine (= une adresse avec une extension .game, .fr, .be). L'adresse du site web devient un nom de domaine accessible partout sur internet.

## Types d’hébergement

+ Mutualisé = colocation de serveur. Le moins coûteux. Moins puissant. Partage de ressources matériels ( de ressources entre plusieurs personnes. Plusieurs dizaine, centaine de personnes sur un même serveur. L’hébergeur initialise notre hébergement (sécurité, configuration). L'utilisateur déploient les fichiers du site web (PHP, python, html)

+ VPS = serveur virtuel privé. Choix de la puissance, de l'espace disque, de la bande passante. Entre le mutualisé et le dédié. Dans le cloud ou pas mais plus de latence, connection du serveur. Des VPS sur SSD permettent de calcul rapide par contre.

+ Dédié = la machine nous appartient. Nous avons toutes les commandes dessus. Nous sommes l'administrateur réseau. On choisit le système d'exploitation. On configure le serveur. En cas de pic d'audience, on paye le même prix. Pas de ressources supplémentaires. Si un technicien intervient, il y aura facturation.

+ Cloud = interconnexion de plusieurs machines/serveur. Travail avec la virtualisation, c'est à dire enregistré sur le disque au travers d'un fichier, pas physiquement. Beaucoup moins coûteux qu'un dédié. Permet de gérer sa facture en fonction de l'espace nécessaire et la bande passante utilisé. Payer pour avoir plus de ressources dans l'heure où diminuer.

Le moins cher, le mutualisé 50 euro l’année. Le dédié varie est le plus honneureux. La bande passante est ce qui coûte le plus cher.

Déploiement = Passer par un FTP (File transfert protocole) pour transférer vos fichiers sur la machine distante sinon on ferais de l’auto-hébergement. Donc il faut passer par un client FTP = protocole de transfert de fichiers depuis un ordinateur en locale vers un serveur distant.

+ Hébergeur payant

    OVH, EX2, IONOS, OSSTINGER.

+ Hebergeur gratuit

    alwaysdata, webhost, Umbreon Network, craym, 11vm.

Il faut regarder l’hébergement perso, l'espace disque, le trafic (bandes passantes, illimité pour les hébergement payant), les mails (Taille max par emails), les versions dans la colonne hébergement et le stockage de la base de données (SQL,. ..) et vérifier la version de MySql.

Réception d'un mail avec les accès. On retrouve des infos pour se connecter à une base de donnees SQL. Des informations pour envoyé nos fichiers vers le serveur distant, informations liées au FTP :

* Hôte avec son sous domaine est une adresse pour le ftp = monsite.domainedelhebergeur.fr , ftp.mondomaine , mais si on achète un nom de domaine (3 à 8 euros), on peut avoir : monsite.fr, monsite.com, ... Le prix des extensions n'est pas le même non plus.
* Nom d'utilisateur,
* Mot de passe.

Données qui permettent à partir d'un client ftp de mettre son site sur le serveur.

Lire les contrats.

Exemple de FILEZILA qui est multiplateforme, gratuit, ...

## Languages informatiques

Les language informatiques servent à créer  des sites web, représenter des pages (html), représenter des design de pages (css) et développer des applications dynamiques (js).

### Html, pour le fond

Html signifie HyperText Markup Language (1993). C'est le contenu d'une page. Il y a plusieurs types de contenus : textes, liens, listes, tableaux, formulaires de saisie, médias (images, sons, vidéos) et des intégrations externes (intégration de lecteur, etc).

### Css, pour la forme

Css signifie Cascading Style Sheets (1996). Il est utilisé si le contenu est déjà terminé. Le Css intervient pour la présentation d'une page (design). On peux intervenir sur les propriétés du texte : le style du texte (italique), la police de caractères, la couleur de texte et de fond, les alignements, les marges (des bordures) et les zones mais egalement les dimensions, l’opacité, etc.

Note : le responsive design, c'est avoir un écran qui s'adapte en fonction de la taille de l’écran d'une tablette, d'un smartphone, etc.

## Objectifs

* Définir un contenu sémantiquement correct (concernent les moteurs de recherches qui vont optimiser le référencement de nos pages sur le web),

* Mettre en forme le contenu,
* Garantir l’accessibilité des pages (normes et standard tel que w3c),
* Optimiser le référencement (SEO),
* Offrir une expérience utilisateur agréable,
* Enrichir le contenu (Javascript).