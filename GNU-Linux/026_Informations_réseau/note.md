# [26. Informations réseau](https://www.youtube.com/watch?v=W25iWpDLt6Q)  
12-05-09

Dans cette séance, on aborde tout ce qui est aspect réseau.

On aborde tout ce qui concerne le système GNU-Linux mais en revanche tous les outils généraux qui sont disponibles à la fois sur Windows, MacOS, GNU-Linux seront abordés sur la Playlist AIDE.

La Playlist AIDE regroupe des vidéos d'aspect générales qui peuvent être associées à plusieurs formations à la fois. 

Avant de manipuler les réseaux, nous allons voir quelques commandes simples avant de s'occuper de la connexion à distance, etc.

Nous allons regarder comment fonctionne l'identité, l'identité sur internet et comment cela s'agence.

Sur un Linux, il existe tout un tas de fichiers qui possèdes des vérifications.

## finger 

Pour infos, on a vu concernant les utilisateurs que lorsqu'on ajoutait un utilisateur, on pouvait rentrer tout un tas d'informations. Par exemple, quand on est administrateur sur un réseaux qui concerne plusieurs machines, voir plusieurs utilisateurs au sein d'une même machine. On peut accéder à ces différentes informations avec la commande `finger`.

Cette commande n'est généralement pas installée sur toutes les distributions. On peut toujours l'installer comme paquet si l'on veut.

On pourra néanmoins s'en passer.

D'un point de vue réseau, il existe une commande qui permet de récupérer des fichiers. Elle fait suite à un usage standard de notre système d'exploitation, c’est-à-dire créer des documents, manipuler des documents, naviguer sur internet, etc.

Tout ce qui peut fait via une interface graphique, peut être fait en ligne de commandes via une console afin de réaliser des manipulations que l'on ferait en mode graphique.

## wget

Quand on télécharge un fichier sur internet, on a un gestionnaire de téléchargement qui va lancer ce dernier et comme ça on va pouvoir récupérer notre fichier. 

Par exemple, on récupère ici un chemin vers un ISO via le site d'Ubuntu. Le lien suivant mène vers un fichier ISO (un pdf, etc comme autre exemple).

https://ubuntu.com/download/desktop/thank-you?version=20.04&architecture=amd64

![1](1.png)
 
Dans le lien de téléchargement, le ISO est masqué mais il permet bien de télécharger un fichier. C'est une image de la distribution 20.04.

Ce fichier téléchargeable peut être récupéré grâce à une ligne de commande.

Il suffit d'utiliser la commande `wget` suivi d'un lien qui conduit à un fichier et la commande se lance.

```bash
wget https://ubuntu.com/download/desktop/thank-you?version=20.04&architecture=amd64
```

Une interface très minimaliste s'affiche dans la console et permet de voir le débit de téléchargement, le temps de téléchargement, etc.

![2](2.png)
 
C'est le genre de commande à connaître pour un jour programmer quelques scripts.

Par exemple récupérer un script d'installation, pour mettre un environnement de Python, l'installation d'un programme quelconque, de mise à jour ou autre. 

C'est une commande essentielle à connaître sur un environnement Linux.

## hostname

Au niveau réseau, des informations sont importantes à connaître. En sachant qu'en tant d'utilisateur, on a un nom d'utilisateur et un identifiant. 

Dans notre terminal, l'affichage est composé d'un nom d'utilisateur, d'un @ et d'un autre nom. Lors de l'installation de notre système, ce nom n'a pas été mis par hasard, c'était en fait l'identifiant de notre machine qui n'as pas été mis là par hasard. C'est le nom d'utilisateur de notre machine. C'est ce nom d'utilisateur qui va servir d'identifiant, d'identité sur un réseau. 

C'est par cela que l'on reconnaîtra notre machine. En réalité derrière cet identifiant se cache l'adresse IP de notre machine. On a une adresse IP qui est simplement un code de différents chiffres qui permettent de dire que tel adresse IP est associé à tel machine. 

Chaque machine peut être un serveur. Par exemple quand on se connecte par exemple à un site internet, en réalité on se connecte à une adresse IP qui est celui d'une machine qui tourne 24h/24, elle n'est jamais éteinte. On peut accéder à pas de site 24/24. Il n'y a pas de moment d'arrêt où par exemple on coupe les serveurs de Google où la nuit on ne pourrait pas faire de recherches sur Google ou regarder une vidéo sur YouTube ou faire des achats en lignes. Ce sont sites accessible tout le temps sauf en cas de pannes bien sûr.

Ces informations concernant notre machine s'appellent un hostname, un nom d'hôte, c'est le nom de notre machine qui es stocké quelque part au niveau de notre système. Pour le trouver, on a le fameux fichier `/etc/hostname` et en faisant un cat on peut afficher son contenu.

```bash
sam@sam:~$ cat /etc/hostname
sam
```

On retrouve bien le nom que l'on a mis à l'installation (sam).

On peut bien évidement éditer ce fichier et en le renommant, on change le nom d'hôte de notre machine.

La commande ne fait que le lire ce fameux fichier `/etc/hostname` et retourne son résultat.

La commande est bien pratique si un jour on a besoin de récupérer le nom d'hôte pour faire tout un tas manipulation. Bien évidemment, on ne va pas s'amuser à ouvrir un fichier pour faire nous-même la récupération. On utilise la commande hostname.

Maintenant on sait comment fonctionne cette identité, on a un nom d'hôte et derrière se cache un adresse IP.

## host

Comment ces adresse IP, notre système, un réseau ou quelconque va être une connexion faites pour ça ? Derrière Linux, il y a tel adresse IP qui existe ; derrière google.fr, il y a une adresse IP également associée. Comment se fait cette concordance, cette association entre un nom de domaine/ nom d'hôte (google.fr, appelé populairement comme une adresse de site, le nom d'un site quand on dit "T'as pas l'adresse du site ?...") et une adresse IP. 

Grâce à la commande `host`, on va pouvoir obtenir l'association qui va avec.

On écrit `host` suivi du nom de domaine que l'on veut.

```bash
sam@sam:~$ host google.be
google.be has address 172.217.17.35
google.be has IPv6 address 2a00:1450:400e:80c::2003
google.be mail is handled by 40 alt3.aspmx.l.google.com.
google.be mail is handled by 50 alt4.aspmx.l.google.com.
google.be mail is handled by 30 alt2.aspmx.l.google.com.
google.be mail is handled by 20 alt1.aspmx.l.google.com.
google.be mail is handled by 10 aspmx.l.google.com.
```
 
On peut ainsi récupérer tout un tas d'informations.

On récupère l'adresse IPV4.

On récupère l'adresse IPV6.

On abordera la différence entre les sur la chaine lorsqu'on abordera l'administration réseau, adresse IP, adressage, rootage, etc.

On récupère un nom d'hôte, l'adresse IPV4 correspondant à google.

Si on prend cette adresse IP et qu'on la tape dans le navigateur, on devrait retomber sur le site en question. Le resolveur, suivant cette adresse IP, va dire à quoi correspond cette adresse IP et on tombe sur Google.

![5](5.png)

Il a pu résoudre, associer une adresse IP à un nom de domaine bien précis. On utilise généralement des noms de domaine (google.be) parce que c'est beaucoup plus simple à retenir et moins source d'erreur. On ne pourrait pas retenir toutes les adresses IP de tous les sites web qu'on consulte.

Nous avons des **résolveur DNS** pour dire que tel nom de domaine est associé à tel adresse IP. On a généralement le résolveur de notre fournisseur d'accès à internet (free, orange, etc) qui contiennent un gros annuaire pour dire que l'adresse IP de google.be est 172.217.17.99. 

Si je change de serveur, d'adresse IP. Admettons qu'un serveur tombe en panne. Il change de serveur, du coup, il change d'adresse IP. Le résolveur, l'annuaire des adresses DNS sera mis à jour. Ça peut d'ailleurs prendre du temps lorsqu'on entend parler de cache DNS, que ça prenne du temps à s'étendre sur toutes les régions du globe, que ce soit accessible partout dans le monde.

Nous, en mettant google.fr dans notre navigateur, on est sûr que ça pointera toujours chez Google. En revanche si on met l'adresse IP 172.217.17.99, rien ne prouve que demain cette adresse pointera chez Google.

Ce résolveur DNS par défaut permet d'attribuer cette adresse à Google. 

## cat etc/hosts

En tant qu'utilisateur, on peut modifier certaines résolutions DNS, c’est-à-dire certains accès bien précis à certaines adresses. En tant que parents, nous n'avons pas envie d'avoir des enfants qui accèdent à des sites pour adultes. On pourrait décider de rediriger l'adresse de ces sites vers notre serveur local, c’est-à-dire rien du tout.

Toutes ces informations que l'on pourrait gérer manuellement sont stocker dans etc/hosts. Ce n'est pas le même type d'emplacement mais ce type de fichier existe sur Windows ou d'autres systèmes. Comme Windows est lié à Microsoft ont peut avoir plusieurs adresses de Microsoft qui y serait indiqués.

```bash
sam@sam:~$ cat /etc/hosts
127.0.0.1	localhost
127.0.1.1	sam

# The following lines are desirable for IPv6 capable hosts
::1     ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
```

Dans ce fichier, on doit avoir l'adresse IP 127.0.0.1 (localhost) qui est l'adresse IP de notre machine en local qui se trouve également dans notre fichier, elle s'appelle le localhost quand on l'utilise le nom d'hôte, le hostname.

En dessous, on voit l'utilisateur sam-VirtualBox, de la machine. 

Puis des adresses IPV6 correspondantes. "::1" est l'équivalent IPV6 de localhost. 
Les adresses IP de localhost sont des adresses qui ne changent pas. Tout le monde a son adresse locale à cette adresse. 

On peut ajouter de l'information à ce fichier par exemple si je ne veux pas qu'un enfant accède à un site ou autre. Les adresses du fichier fonctionnent par couple, adresse IP et nom d'hôte. A la place de mettre le vrai nom d'hôte du site, on peut par exemple mettre localhost.

L'adresse IP du site qu'on ne voudrait pas serait mise vers localhost.

```bash
sam@sam:~$ sudo gedit /etc/hosts
```

Commande pour modifier.

Quand il y a un #, ça ne fait pas partie du fichier, c'est juste un commentaire. 

Admettons que l'adresse du site pour adulte soit 126.83.40.12, je peux le faire rediriger vers localhost. Comme ça au lieu que cette adresse IP redirige vers le vrai nom de domaine du site, ça sera redirigé en local et ça bloquera l'accès. 

On peut ainsi opérer sur la résolution DNS pour bloquer certains accès.

Cela peut servir également si on veut que notre ordinateur puisse envoyer/recevoir des informations vers une adresse IP spécifique. Tout ceci fera l'objet de séance sur la gestion de pare-feu.

## whois

En résumé, il n'y a pas de fichiers de configurations qui apportent des possibilités ainsi. Nous avons vu `hostname` qui correspond au nom d'hôte de notre machine.

On a vu cette commande `host` qui fonctionne dans les deux sens. On peut le faire suivre soit d'un nom de domaine, soit d'une adresse IP.

```bash
sam@sam:~$ host 127.0.0.1
    1.0.0.127.in-addr.arpa has no PTR record
sam@sam:~$ host youtu.be
    youtu.be has address 142.250.179.142
    youtu.be has IPv6 address 2a00:1450:400e:80c::200e
    youtu.be mail is handled by 10 gmr-smtp-in.l.google.com.
    youtu.be mail is handled by 40 alt3.aspmx.l.google.com.
    youtu.be mail is handled by 50 alt4.aspmx.l.google.com.
    youtu.be mail is handled by 30 alt2.aspmx.l.google.com.
    youtu.be mail is handled by 10 aspmx.l.google.com.
    youtu.be mail is handled by 20 alt1.aspmx.l.google.com.
sam@sam:~$ host 142.250.179.142
    142.179.250.142.in-addr.arpa domain name pointer ams17s10-in-f14.1e100.net.
sam@sam:~$ host google.be
    google.be has address 172.217.17.67
    google.be has IPv6 address 2a00:1450:400e:803::2003
    google.be mail is handled by 10 aspmx.l.google.com.
    google.be mail is handled by 50 alt4.aspmx.l.google.com.
    google.be mail is handled by 20 alt1.aspmx.l.google.com.
    google.be mail is handled by 40 alt3.aspmx.l.google.com.
    google.be mail is handled by 30 alt2.aspmx.l.google.com.
```

On peut voir ainsi les correspondances entre IP et nom de domaine.

On a vu `finger` et `wget`.

On termine avec une dernière commande pour récupérer des informations d'un nom de domaine.

Si un jour on a besoin de savoir quel hébergeur héberge un site en particulier ou même qu'on aurait besoin de contacter l'administrateur d'un site mais sur son site ça ne serait pas disponible. On peut ainsi retrouver différentes informations comme une adresse email, l'hébergeur d'un site avec la commande WHOIS.

```bash
sam@sam:~$ sudo apt install whois
```
 
Elle n'est pas forcement installée partout. S'il n'est pas disponible sur notre distribution, il ne faut pas hésiter à installer ce paquet.
 
```bash
sam@sam:~$ whois google.fr
%%
%% This is the AFNIC Whois server.
%%
%% complete date format : YYYY-MM-DDThh:mm:ssZ
%% short date format    : DD/MM
%% version              : FRNIC-2.5
%%
%% Rights restricted by copyright.
%% See https://www.afnic.fr/en/products-and-services/services/whois/whois-special-notice/
%%
%% Use '-h' option to obtain more information about this service.
%%
%% [91.179.211.223 REQUEST] >> -V Md5.5.6 google.fr
%%
%% RL Net [##########] - RL IP [#########.]
%%

domain:      google.fr
status:      ACTIVE
hold:        NO
holder-c:    GIH6-FRNIC
admin-c:     GIH5-FRNIC
tech-c:      CP4370-FRNIC
zone-c:      NFC1-FRNIC
nsl-id:      NSL4386-FRNIC
registrar:   MARKMONITOR Inc.
Expiry Date: 2021-12-30T17:16:48Z
created:     2000-07-26T22:00:00Z
last-update: 2020-11-28T10:35:01Z
source:      FRNIC

ns-list:     NSL4386-FRNIC
nserver:     ns1.google.com
nserver:     ns2.google.com
nserver:     ns3.google.com
nserver:     ns4.google.com
source:      FRNIC

registrar:   MARKMONITOR Inc.
type:        Isp Option 1
address:     3540 East Longwing Lane
address:     
address:     ID 83646 MERIDIAN
country:     US
phone:       +1 208 389 5740
fax-no:      +1 208 389 5771
e-mail:      registry.admin@markmonitor.com
website:     http://www.markmonitor.com
anonymous:   NO
registered:  2002-01-10T12:00:00Z
source:      FRNIC

nic-hdl:     GIH6-FRNIC
type:        ORGANIZATION
contact:     Google Ireland Holdings
address:     70 Sir John Rogersons Quay
address:     2 Dublin
country:     IE
phone:       +353 14361000
e-mail:      dns-admin@google.com
registrar:   MARKMONITOR Inc.
changed:     2015-03-20T21:13:41Z nic@nic.fr
anonymous:   NO
obsoleted:   NO
eligstatus:  ok
eligsource:  REGISTRAR
eligdate:    2011-12-30T17:15:32Z
reachmedia:  email
reachstatus: ok
reachsource: REGISTRAR
reachdate:   2015-03-20T21:13:41Z
source:      FRNIC

nic-hdl:     GIH5-FRNIC
type:        ORGANIZATION
contact:     Google Ireland Holdings
address:     70 Sir John Rogersons Quay
address:     2 Dublin
country:     IE
phone:       +353 14361000
e-mail:      dns-admin@google.com
registrar:   MARKMONITOR Inc.
changed:     2011-12-06T09:28:50Z nic@nic.fr
anonymous:   NO
obsoleted:   NO
eligstatus:  not identified
reachmedia:  email
reachstatus: ok
reachsource: REGISTRAR
reachdate:   2011-12-06T09:28:50Z
source:      FRNIC

nic-hdl:     CP4370-FRNIC
type:        PERSON
contact:     Ccops Provisioning
address:     MarkMonitor
address:     10400 Overland Rd.
address:     PMB 155
address:     83709 Boise
country:     US
phone:       +1 2083895740
fax-no:      +1 2083895771
e-mail:      ccops@markmonitor.com
registrar:   MARKMONITOR Inc.
changed:     2011-06-14T14:36:12Z nic@nic.fr
anonymous:   NO
obsoleted:   NO
eligstatus:  not identified
reachstatus: not identified
source:      FRNIC
```

On retrouve ainsi pas mal d'information comme une adresse émail, un numéro de téléphone, etc. On peut par exemple demander des informations bien précises dans le cas où on ne trouve pas les informations de contacts par exemple. On peut également se rendre compte que tel ou tel site est plutôt bien héberger et on souhaiterait connaître l'hébergeur pour héberger notre propre site là-bas.

On pourrait par exemple contacter un administrateur si on a un problème avec un site de vente en ligne.

Pour quelqu'un qui gère son site, il est possible de masquer quelques informations privées ou qui pourrait même être erronés. Peut être pas chez Google mais les registras qui s'occupe de répertorier les noms de domaine en France obligent à renseigner les vraies informations. C'est une obligation légale pour les gens qui hébergent des sites. On ne peut pas mettre un faux nom par exemple.

## conclusion

L'intérêt de cette séance était de voir comment récupérer pas mal d'informations et voir comment fonctionne une identité sur internet. Ce sont des informations sur lequel on peut travailler et modifier certaines choses manuellement au niveau de notre système. 

Pour la prochaine séance, on abordera la configuration réseau. C'est déjà un peu plus complexe, comment fonctionne ce système d'hôte, d'adresse IP, cette fameuse résolution DNS (dont on a parlé). L'intérêt est de comprendre comment tourne notre système Linux.

Les outils et commandes de terminal communes aux systèmes Linux, Windows seront donnés dans la rubrique Aides.