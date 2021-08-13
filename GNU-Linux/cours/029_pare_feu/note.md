# [29. Pare-feu](https://www.youtube.com/watch?v=nZrPOsqXF8U)

Bonjour à tous, on se retrouve pour cette 29ème séance sur GNU Linux pour parler des pare-feu, ce sera la dernière vidéo avant d'attaquer le prochain et le dernier chapitre de ce cours où on fera la de la programmation de scripts en bash mais nous expliquerons bien sûr tout ça quand on y sera.

Là on va s'attarder sur les pare feux et on va expliquer un petit peu voir en quoi ça consiste, qu'est ce qu'un pare-feu et qu'est ce que ça peut avoir d'utile parce qu'on a pas mal de gens qui sont je pense parmi vous déjà renseigné qu'ils connaissent par exemple le pare feu sur windows sur le système de microsoft et peut-être des personnes qui sont un peu moins famillier avec ce genre de choses sur une distribution de linux et qui pensent peut-être même qu'avec les technologies actuelles l'utilisation d'un pare feu n'est plus utile en 2020 donc au moment où je fait cette vidéo donc il y a pas mal de choses à rétablir vous expliquer à quoi ça sert comme ça on va pouvoir partir d'un bon pied.

Déjà un pare-feu très simplement il faut imaginer que c'est un intermédiaire entre tout ce qui se passe au niveau des communications, vous allez avoir par exemple votre machine qui est un réseau à elle seule, qui peut éventuellement être connectée dans un réseau local d'accord avec plusieurs ordinateurs et vous allez avoir pas mal de machines extérieur, ça peut être tout ce qui est accès à internet accès, à d'autres serveurs, etc etc.

Plusieurs communications vont se passer via des protocoles, vous connaissez peut-être SSH, FTP, HTTP pour surfer sur le web, https, etc etc.

Ces communications si on les laisse tout simplement transiter tel quel, on n'a finalement aucune vérification, on n'a rien qui est fait pour filtrer tout ça, pour vérifier par exemple que telle machine veut se connecter sur la nôtre, est ce qu'elle peut le faire ou non.

Un pare-feu il va analyser toutes ses communications, toutes ses transmissions et va éventuellement les filtrer.

L'avantage c'est que vous allez pouvoir spécifier par exemple de dire bah moi je veux que rien ne puisse se connecter à ma machine ou je veux par exemple bloquer tel protocole qui voudrait communiquer directement avec mon réseau ou l'inverse, on peut également bloquer en sortiez dire bas depuis mon ordinateur je ne veux pas qu'on puisse communiquer des informations depuis tel protocole précis vers l'extérieur ok, voilà comment fonctionne un purfum qui permet véritablement d'analyser et de filtrer éventuellement bien sûr toutes les tansmissions qui sont faites de l'intérieur vers l'extérieur et bien sûr de l'extérieur vers l'intérieur.

On va différencier 2 choses déjà très importantes ce sont les types de pare feu, nous on va parler des pare-feu logiciel.

Un pare-feu logiciel, l'avantage c'est que c'est disponible partout voyez on en a parlé Windows, GNU Linux même d'autres systèmes d'exploitation.

C'est logiciel puisque c'est simplement un programme qui généralement fait partie intégrante du noyau du système qui peut être installé à part, on peut installer des pare-feu complètement à part. On va le configurer comme n'importe quel programme pour appliquer des règles on va dire voilà les règles de filtrage que l'on va appliquer au niveau des différents moyens de transmission et des différents protocoles qui vont être analysés voir filtrés ça a ses avantages et ça a bien sûr ses défauts parce que comme tout programme ça peut être contournée, ça peut être désactivé, ça peut être bloquée, etc etc.

Pour des gens en tout cas qui ont des besoins beaucoup plus important je pense à des grosses entreprises et cetera on va plutôt avoir tendance à utiliser des pare-feu matériel.

Un pare-feu matériel c'est comme une box d'accord qui va être complètement à part de votre système d'exploitation et qui va se charger de faire tout ce filtrage. L'avantage c'est comme elle n'est pas reliée directement au système et n'est pas directement votre machine, quand par exemple un pirate veut tenter par exemple d'exploiter ou de la désactiver ou de la contourner c'est déjà beaucoup plus compliqué puisque c'est des systèmes de sécurité beaucoup plus performant à ce niveau là mais c'est aussi très onéreux.

Un pare-feu matériel c'est quelque chose qui coûte assez cher et on ne va pas faire ça par exemple quand on est chez soi ou même pour son réseau local familliale bien évidemment sauf si vous avez des moyens mais après c'est vous qui voyez à ce niveau là.

Nous on va parler des pare-feu logiciel puisque nous sommes sur GNU Linux on va parler d'un framework qui est directement intégré dans le noyau linux qui est Netfilter.

Netfilter c'est un ensemble d'outils comme l'indique le terme de Framework vraiment justement qui va intégrer tout un tas de choses notamment ce pare-feu et l'outil qui permet en tout cas de configurer ce pare-feu de manière historique sur de linux c'est `iptables`.

Problème très important et ça vous l'avez déjà remarqué comme pour le réseau un GNU Linux comme il y a tout un tas de systèmes de distribution et donc toute une fragmentation finalement entre les systèmes, on ne retrouve pas forcément les mêmes outils et les mêmes moyens de configuration.

`iptables` même s'il est historique, vous n'allez pas forcément surtout de nos jours le retrouver dans tous les systèmes d'unix on peut avoir des outils beaucoup plus moderne, des surcouches d'iptables, des réécritures d'iptables, voir des outils complètement différent.

Il y a firewalld sur CentOS, on peut retrouver également nftables qui est un autre outil, une réécriture d'iptables pour faire quelque chose d'un peu plus simple à utiliser et on a également d'autres surcouche, on va en voir d'ailleurs une ici par exemple pour ubuntu qui est `ufw`.

`ufw` c'est simplement un outil pour simplifier la gestion de notre pare-feu et c'est ce que je vais vous montrer dans cette séance ici.

Alors j'aurais pu vous parler `iptables` vous montrer les commandes de toute façon comme c'est très historique, si vraiment vous voulez apprendre à utiliser `iptables` vous pouvez déjà regarder dans le manuel au niveau de l'outil trouver tout un tas de choses très intéressantes et de toute manière vous ne manquerez pas d'informations comme d'habitude j'avais pas trop le choix il fallait bien que je vous montre un des outils parmi tant d'autres. Je ne pouvais pas tous les aborder c'est juste impossible donc j'ai fait le choix du `ufw` qui est tout simplement assez simple à prendre en charge et que vous pouvez de toute façon installer si vous voulez sur n'importe quelle distribution si vous ne voulez pas utiliser par exemple l'outil déjà présents dessus donc il n'y aura pas de problème à ce niveau là.


Voilà je vous ai cité des noms, on va basculer directement sur la session de la machine virtuelle sur notre linux et on va voir un peu tout ça alors je vais quand même vous noter les noms des autres Firewall dont je vous ai parlé, histoire que vous ayez éventuellement les noms pour faire des recherches, vous documenter et cetera.

```bash
Netfliter #notre framework.
iptables #outil historique.
firewalld
nftables
```

firewalld ça c'est plus quand on fait de l'administration de serveurs etc. On va souvent le retrouver parce qu'on va utiliser du centOS qui est réputé pas mal en tout cas orienté pour ce genre d'utilisation.

On va voir `nftables` et nous allons utiliser `ufw` d'accord très simple uncomplicated firewall.

## installation ufw

On va pouvoir se servir de cet outil là c'est simplement une surcouche en gros quand vous allez faire usage de commandes comme on va le voir avec cet outil là ça va tout simplement appliquer à votre place les règles pour `iptables` d'accord c'est vraiment une surcouche, ça ne vient pas complètement réécrit `iptables`. C'est une surcouche à ce dernier mais qui va être très très très simple à l'usage.

Par défaut alors si vous êtes sur la même distribution que j'ai utilisé pour le cours ou sur n'importe quelle distribution ubuntu normalement l'outil est installé mais pas forcément activé alors le plus simple de toute façon c'est de faire simplement un `sudo ufw status`, on a besoin des droits super utilisateur bien évidemment et de faire un status pour voir un petit peu ce qu'il en est ici.

```bash
sam@sam:~$ sudo ufw status
[sudo] Mot de passe de sam : 
État : inactif
```

Ici je vois que l'état est inactif donc il est installé si évidemment il n'est pas installé vous faites un petit `sudo apt install ufw`.

## configuration ufw

Voilà en termes de configuration parce qu'il y a pas mal de choses, je ne veux vraiment rien oublier donc je veux vraiment être sûr de pas oublier quelque chose au niveau de la vidéo il y a pas mal de choses à dire mine de rien en terme de configuration tout va se passer dans un fichier en particulier qui sera dans /etc/default/ufw d'accord.

```bash
sam@sam:~$ cat /etc/default/ufw
# /etc/default/ufw
#

# Set to yes to apply rules to support IPv6 (no means only IPv6 on loopback
# accepted). You will need to 'disable' and then 'enable' the firewall for
# the changes to take affect.
IPV6=yes

# Set the default input policy to ACCEPT, DROP, or REJECT. Please note that if
# you change this you will most likely want to adjust your rules.
DEFAULT_INPUT_POLICY="DROP"

# Set the default output policy to ACCEPT, DROP, or REJECT. Please note that if
# you change this you will most likely want to adjust your rules.
DEFAULT_OUTPUT_POLICY="ACCEPT"

# Set the default forward policy to ACCEPT, DROP or REJECT.  Please note that
# if you change this you will most likely want to adjust your rules
DEFAULT_FORWARD_POLICY="DROP"

# Set the default application policy to ACCEPT, DROP, REJECT or SKIP. Please
# note that setting this to ACCEPT may be a security risk. See 'man ufw' for
# details
DEFAULT_APPLICATION_POLICY="SKIP"

# By default, ufw only touches its own chains. Set this to 'yes' to have ufw
# manage the built-in chains too. Warning: setting this to 'yes' will break
# non-ufw managed firewall rules
MANAGE_BUILTINS=no

#
# IPT backend
#
# only enable if using iptables backend
IPT_SYSCTL=/etc/ufw/sysctl.conf

# Extra connection tracking modules to load. IPT_MODULES should typically be
# empty for new installations and modules added only as needed. See
# 'CONNECTION HELPERS' from 'man ufw-framework' for details. Complete list can
# be found in net/netfilter/Kconfig of your kernel source. Some common modules:
# nf_conntrack_irc, nf_nat_irc: DCC (Direct Client to Client) support
# nf_conntrack_netbios_ns: NetBIOS (samba) client support
# nf_conntrack_pptp, nf_nat_pptp: PPTP over stateful firewall/NAT
# nf_conntrack_ftp, nf_nat_ftp: active FTP support
# nf_conntrack_tftp, nf_nat_tftp: TFTP support (server side)
# nf_conntrack_sane: sane support
IPT_MODULES=""
```

Moi j'ai pas grand chose voilà alors on peut vérifier éventuellement ici par exemple que la configuration s'applique pour l'ipv6, c'est toujours pas mal de vérifier ici éventuellement de le modifier si ce n'est pas yes afin d'avoir `IPV6=yes` pour que vous ayez votre configuration en fait pour l'ipv4 et l'ipv6 comme ça se sera fait pour tous et ce n'est pas plus mal..

Voilà ici donc je vous ai dit pour la configuration et maintenant on va pouvoir pour mettre tout ça en place alors attention n'activer pas et ne mettez pas en place votre pare-feu tout de suite parce que si vous n'avez par exemple que des règles par défaut et que tout est bloqué, vous n'aurez même plus accès à internet ça risque d'être problématique.

Il y a encore plus problématique si vous êtes connecté sur une machine à distance via ssh par exemple parce que là le pare-feu va tout simplement vous couper la connexion.

Normalement le pare-feu ne coupe pas les connexions déjà établies à priori mais en tout cas vous ne pourrez plus vous connecter ce serait un petit peu dommage après pour essayer de configurer un pare feu alors que de tout façon vous n'avez plus accès à la machine en question donc faites attention.

On va faire une configuration de base pour notre pare-feu, je vais vous expliquer pourquoi et comment  et ensuite on l'activera donc là par exemple mon pare-feu est installé, l'outil ufw est installé sur le système par contre il n'est pas activé.

Pour les gens vraiment qui n'aime pas la ligne de commande comme c'est très souvent le cas sur GNU Linux, vous avez des outils graphiques je crois que gufw, il y a aussi une version pour Kde, il y a des versions comme ça voilà graphique pour tout un tas d'outils.

Généralement quand vous avez un outil comme ça très utilisé en ligne de commande il y a des gens qui ont fait des petits programmes avec interface graphique si vous n'aimez vraiment pas la ligne de commande.

Là évidemment et maintenant pour faire des choses un peu plus poussé donc on fait ça en ligne de commande et vous n'avez pas de toute façon besoin de tuto pour savoir cliquez sur des boutons sur un logiciel donc il n'y a pas de problème à ce niveau là, on va regarder tout ça.

## verbose

Première chose que nous allons faire et ça on l'avait déjà vu donc c'est vrai que je vous avais montré `sudo ufw status` on peut éventuellement avoir des versions un peu plus verbeuse et je peux ajouter une option, un argument verbose pour avoir un peu plus de choses bon là il est inactif donc il n'y a évidemment rien à montrer mais on verra par la suite avec verbose, on pourra rajouter d'autres informations si on veut.

```bash
sam@sam:~$ sudo ufw status
État : inactif
sam@sam:~$ sudo ufw status verbose
État : inactif
```

## règle par défaut

Première chose, on va tout simplement (on ne va pas l'activer tout de suite) mais on va appliquer quelques règles.

Quand on a un pare feu comme ça on part du principe qu'il est complètement à zéro d'accord qu'il n'y a rien de défini, il faut faire attention comme je vous l'ai dit pour ne pas bloquer tout simplement les communications sinon on n'aura plus accès à rien on ne pourra plus se connecter à internet, on ne pourra plus accéder au web en tout cas et on ne pourra même plus entrer en communication avec la machine dont on a configuré un pare feu qui bloque absolument tout.

La règle générale très important d'accord si vous ne savez pas forcément comment ça fonctionne évidemment la configuration d'un pare-feu devra se faire ensuite de manière très spécifique en fonction de ce que vous voulez et de l'environnement que vous avez en termes de machines, de réseaux, etc mais pour avoir on va dire un usage assez on va dire lambda d'accord assez général pour tout le monde, on va opérer une règle très importante c'est **par défaut de bloquer les choses**.

En sécurité, il ne faut pas fonctionner à l'envers c'est de se dire, on autorise tout et ensuite on se dit ça j'en veux pas, ça on interdit, ça on interdit.

Pour des questions de sécurité, on bloque absolument tout par défaut, on interdit tout par défaut et éventuellement, on autorise seulement ensuite les systèmes que l'on veut et dont on a besoin.

L'avantage ça évite d'activer, d'autoriser des choses qui ne seront pas utiles dans votre cas bien précis et ça permet encore une fois en terme de sécurité d'éviter de laisser finalement des portes ouvertes dans ce genre de cas.

Première chose à faire c'est de se dire par défaut toutes les communications entrantes, je les blocs.

En gros j'ai interdit toute communication qui viendraient en fait se connecter à ma machine, je bloque tout ça et je t'autorise toutes communications sortantes ce qui comprendra le web, etc.

Ca c'est on va dire la configuration par défaut si aucune règle est appliquée spécifiquement, c'est le comportement qu'opera en fait le pare-feu par défaut en disant si tu n'a pas configuré de règles bien précises ben moi je pars du principe que tout ce qui entre je le bloque, j'interdis et tout ce qui sort eh bien je l'autorise.

On peut faire ce genre de choses-là, on y va et vous allez voir si vous avez déjà utilisé `iptables`, vous allez trouver les commandes beaucoup beaucoup plus simple à utiliser que `iptables` surtout beaucoup plus facile à retenir aussi donc ça va pas mal vous changer la vie à ce niveau là. On va faire `sudo ufw default deny incoming`, on fait donc comme on va appliquer une règle par défaut, on utilise le terme `default` et je veux dire interdire tout ce qui vient donc c'est `deny incoming`.

```bash
sam@sam:~$ sudo ufw default deny incoming #interdire ce qui rentre et autoriser ce qui sort par défaut si aucune règle.
La stratégie par défaut pour le sens « incoming » a été remplacée par « deny »
(veillez à mettre à jour vos règles en conséquence)
```

La stratégie par défaut pour le sens « incoming » a été remplacée par « deny », en plus tout est en français donc franchement il n'y a pas d'excuses pour configurer ça n'importe comment.

Ensuite on va autoriser par défaut tout ce qui sort donc `sudo ufw default allow outgoing`.

```bash
sam@sam:~$ sudo ufw default allow outgoing
La stratégie par défaut pour le sens « outgoing » a été remplacée par « allow »
(veillez à mettre à jour vos règles en conséquence)
```

Voilà donc là on a vraiment la base des bases, on peut là parfaitement communiquer vers l'extérieur par contre rien ne peut communiquer donc entrer d'accord il ne peut y avoir aucune communication ou transmission entrante au niveau ici de notre machine.

Ca c'est donc important première chose à faire.

## allow http

Maintenant, on va quand même spécifier des choses un peu plus clair à priori sauf peut être exceptions très très raricime où par exemple vous voulez bloquer l'accès à internet sur une machine.

On peut très bien faire ça par exemple il y a des écoles qui peuvent faire ça, il y en a d'autres qui disent on veut donner un accès à un ordinateur à nos élèves mais on ne veux pas qu'ils puissent aller sur internet, vous voyez on pourrait tout à fait dans un pare feu et ce serait logique de bloquer par exemple un accès à internet mais nous on est quand même dans un usage on va dire encore une fois c'est général donc je part du principe que vous vouliez accéder à internet donc ce sont les protocoles http et https pour ce qui est les communications chiffrées donc on va activer ces deux là.

Le schéma est assez simple aussi et on retrouve un petit peu le même schéma que ce que je voulais montrer, on fait notre petit commande `sudo ufw` et ici on n'a pas de default puisqu'on n'applique pas une règle par défaut d'accord génériques mais on applique  une règle bien spécifique qui est de choisir un petit peu le protocole à autoriser.

Moi donc je vais autoriser le protocole http, https vous pouvez le marquer comme ceci `sudo ufw allow http` et normalement comme c'est des protocoles pour le coup bien reconnus vous pouvez directement vous en servir de cette manière `sudo ufw allow` sinon si vous voulez être sûr d'appliquer sur le bon protocole vous pouvez utiliser son numéro de port d'accords donc pour http c'est le port 80, `sudo ufw allow 80`.

```bash
sudo ufw allow http #autoriser le protocole http.
sudo ufw allow #autoriser les protocoles bien connus.
sudo ufw allow 80 #autoriser le protocole http (port 80).
```

## fichier services

Alors on peut retrouver les différents protocoles dans /etc/services les différents protocoles et comme ça vous avez les numéros donc c'est en fait par rapport à ça qu'on va se baser sur le pare-feu donc logiquement si on va le numéro 80 de port et vous voyez qu'il y en a pas mal voilà ici voyez que ça correspond.

```bash
sam@sam:~$ cat /etc/services
# Network services, Internet style
#
# ...
http		80/tcp		www		# WorldWideWeb HTTP
```

Pourquoi ce fichier ? c'est simplement pour être sûr en fait d'avoir la bonne correspondance.

Dans ce fichier comme vous voyez que tout est bien plutôt bien renseigner normalement en toutes lettres, il n'y a pas de problème il va parfaitement l'associer à ça contre si vous voulez vraiment précisément indiqué le port pour dire bah tiens le port 80, vous le ferez et c'est lui qui fera l'association aussi de l'autre coté donc à vous de voir vous pouvez noter les deux soit en toutes lettres, soit numéro de porc donc c'est vraiment au choix.

Voilà pour le fichier.

Je fais donc `sudo ufw allow http`.

```bash
sam@sam:~$ sudo ufw allow http
Les règles ont été mises à jour
Les règles ont été mises à jour (IPv6)
```

Et là j'autorise donc voyez que les règles sont mises à jour donc ça c'est pour l'ipv4 par défaut et l'ipv6 puisqu'on à vérifier qu'en configuration, la configuration se faisait également pour l'ipv6.

## allow https

On autorise en sortie bien sûr tout ce qui est accès http donc accès tout simplement ici à internet, au web, on va faire la même chose pour https.

```bash
sam@sam:~$ sudo ufw allow https #autoriser le protocole https.
Les règles ont été mises à jour
Les règles ont été mises à jour (IPv6)
```

Voilà beaucoup de page https donc il faut autoriser parfaitement ça.

Voilà donc là je rappelle ce qu'on a dit c'est-à-dire on autorise la communication vers http, vers https sinon on autorise de toute façon toutes les communications en sortie donc là pour le coup c'est quand même assez permissif et en entrée on a toujours toutes les connexions alors je dois faire attention aussi avec tout ce qui est connexions entrantes.

Là par contre dans ce type de syntaxe `sudo ufw allow https`, quand vous mettez cette syntaxe par défaut c'est par rapport à tout ce qui est entrant c'est-à-dire qu'on va accepter, on va recevoir finalement l'accès par exemple à une page.

Imaginez vous demandez une page internet, c'est le serveur qui va répondre et qui va vous l'envoyez donc c'est une communication entrante, il faut bien comprendre ça donc quand vous écrivez `sudo ufw allow http` en fait comme ceci http c'est comme mettre tout simplement `in` d'accord `sudo ufw allow in http` c'est par défaut parce que très généralement on va surtout intervenir sur tout ce qui est communication entrantes donc par défaut si on ne précise rien l'outil sait parfaitement que vous voulez parler de communication entrante.

Si vous voulez faire pour de la communication exclusivement sortante, on mettra spécifiquement `out` d'accord `sudo ufw allow out http`.

D'un coté on est dans du `in` d'accord c'est tout ce qui arrive en fait par rapport à http, https parce qu'on veut pouvoir désservir en fait, que ça nous desservent des pages via les protocoles http, https.

Attention vous allez certes au niveau de votre navigateur accéder à une page, on pourrait imaginer une sortie effectivement c'est ça on va interroger en fait un serveur avec navigateur mais ça pour le moment on ne passe pas par grand chose, on envoie une requête et c'est après la requête qui nous est retransmise d'accord donc il y a de la communication qui est fait à cette manière là.

Je rappelle donc qu'en sortie de toute façon on a tout autorisés d'accord on a autorisé absolument tout en sortie donc il n'y a pas de problème et là on précise quand même manuellement, spécifiquement qu'on autorise en entrée d'accord http, https.

## allow ssh

Si vous voulez pouvoir accéder à cette machine à distance d'accord vous vous y connecter notamment via [SSH](https://www.youtube.com/watch?v=XUE6v4ZgvJ8), je rappelle que j'ai fait mais un petit tuto d'aide sur la chaîne si vous voulez.

[Se connecter à distance (SSH)](https://www.youtube.com/watch?v=XUE6v4ZgvJ8)

Il y a la playlist aide et vous avez Se connecter à distance avec SSH, on peut l'autoriser aussi pour qu'on va faire pareil `sudo ufw allow ssh` c'est le port 22 donc http c'est le port 80 et https c'est le port 443 et ssh c'est le port 22.

```bash
sam@sam:~$ sudo ufw allow http
Les règles ont été mises à jour
Les règles ont été mises à jour (IPv6)
sam@sam:~$ sudo ufw allow https
Les règles ont été mises à jour
Les règles ont été mises à jour (IPv6)
sam@sam:~$ sudo ufw allow ssh #autoriser la connection à distance SSH.
Les règles ont été mises à jour
Les règles ont été mises à jour (IPv6)
```

On fait `sudo ufw allow ssh` et là, on pourra se connecter parfaitement ici.

## activer pare-feu

Ok alors normalement de toute façon si je fais `sudo ufw status` comment je ne l'ai toujours pas activé, voilà toujours inactif, on le verra après...

```bash
sam@sam:~$ sudo ufw status
État : inactif
```

Première chose encore une fois on a autorisé toute la communication sortante donc les règles de tout ce qui est sortant. On a bloqué donc interdit tout ce qui est entrant et ensuite on a autorisé en entrant tout ce qui est http, https et ssh.

Trois protocoles de communication sont autorisés en entrée, en input si on préfère.

Voilà ça c'est la règle finalement de base, à partir de là vous pouvez activer votre pare-feu, il n'y aura pas de problème, vous aurez toujours accès éventuellement à distance et vous aurez accès à internet bien sûr avec la configuration de votre pare-feu.

On y va, `sudo ufw enable` et on active.

```bash
sam@sam:~$ sudo ufw enable
Le pare-feu est actif et lancé au démarrage du système
```

Le pare-feu est actif, lancé et là on peut faire comme j'ai fait tout à l'heure `sudo ufw status`.

```bash
sam@sam:~$ sudo ufw enable
Le pare-feu est actif et lancé au démarrage du système
sam@sam:~$ sudo ufw status
État : actif

Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW       Anywhere                  
443/tcp                    ALLOW       Anywhere                  
22/tcp                     ALLOW       Anywhere                  
80/tcp (v6)                ALLOW       Anywhere (v6)             
443/tcp (v6)               ALLOW       Anywhere (v6)             
22/tcp (v6)                ALLOW       Anywhere (v6)
```

Alors `sudo ufw status` et voilà on a les informations, on a comme ça tout ce qui est indiqué. On lis "De Anywhere" il n'y a pas de problème d'accord comme ça tout communique et on voit un petit peu tout ce qui est indiqué. (v6) signifie que c'est de l'ipv6 et le reste c'est de l'ipv4.

```bash
Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW       Anywhere                  
443/tcp                    ALLOW       Anywhere                  
22/tcp                     ALLOW       Anywhere 
80/tcp (v6)                ALLOW       Anywhere (v6)             
443/tcp (v6)               ALLOW       Anywhere (v6)             
22/tcp (v6)                ALLOW       Anywhere (v6)
```

Très simple donc on a trois choses d'accord ça passe par tcp parce qu'on peut éventuellement et ça c'est vrai que je ne l'ai pas indiqué mais on pourrait parfaitement aussi quand on fait un `sudo ufw allow http/tcp` faire ceci d'accord et puis indiquez ici par exemple précisément par quoi on passe (tcp).

```bash
sudo ufw allow http/tcp #autoriser http mais en précisant le protocole de transport tcp.
```

On peut le faire mais voilà je pense que c'est des choses un peu plus avancé qu'en configuration je ne pense pas que vous en aurez besoin ici pour un usage on va dire standard.

Moi je vous montre ce qui est ce qui me semble vraiment le plus essentiel, après bien sûr en termes de configuration de pare feu si vous êtes sur un réseau local mais vous avez voilà un **LAN** (Local Area Network, ou réseau local) ou accès à un **WAN** (Wide Area Network, ou réseau étendu) et vous avez l'internet, que vous avez une zone démilitarisé, une zone **DMZ** (demilitarized zone), etc, il y aura des configurations évidemment un peu plus complexe à faire mais cet outil vous permettra quand même de le faire de manière très simpliste au niveau de la syntaxe des commandes c'est quand même très très simple à mettre en place.

## verbose

Voilà pour l'usage de base alors je n'ai pas montré aussi qu'on pouvait faire aussi `sudo ufw status verbose`.

```bash
sam@sam:~$ sudo ufw status verbose
État : actif
Journalisation : on (low)
Par défaut : deny (incoming), allow (outgoing), disabled (routed)
Nouveaux profils : skip

Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW IN    Anywhere                  
443/tcp                    ALLOW IN    Anywhere                  
22/tcp                     ALLOW IN    Anywhere                  
80/tcp (v6)                ALLOW IN    Anywhere (v6)             
443/tcp (v6)               ALLOW IN    Anywhere (v6)             
22/tcp (v6)                ALLOW IN    Anywhere (v6) 
```

On voit voilà c'est un peu plus parlant ça nous indique par défaut tout ce qui entre est interdit et tout ce qui sort est autorisé pour tout ce qui est la redirection on en a pas parler parce que pareil ça nous intéresse pas ici on voit que c'est complètement activé.

## logging

Voilà on a une journalisation qui est fait en (low) donc ça c'est le niveau de journalisation pour que ce ne soit non plus trop trop conséquent donc ça on peut le régler en faisant ça.

```bash
sudo ufw logging on
sudo ufw logging off
sudo ufw logging low
```

Ca c'est pour les activer et pour les désactiver, vous pouvez éventuellement choisir le niveau de `low` si vous voulez par rapport à ça parce que vous pourrez très bien appliquer des règles de `low` en fonction de ce qui est fait.

Ca donc la journalisation voilà ça intéressera certains et d'autres non, c'est plus intéressant quand on fait encore une fois de l'administration de serveurs ou autre on a besoin de savoir un petit peu tout ce qui a communiqué pour avoir des enregistrements, des journaux en fait de tout ce qui s'est passé un petit peu au niveau de l'activité pour surveiller un petit peu les communications entrantes et sortantes et ça peut être pas mal et le système gère tout ça parce que vous avez le système de journalisation de l'OS donc on a tout ce qui est intégré ici.

## reset

Voilà, on a abordé et éventuellement c'est pas mal de voir maintenant si jamais vous avez fait une bêtise et que vous voulez repartir sur un système de départ en gros effacer tout ce que vous avez mit comme règle, en gros vous faites un petit `sudo ufw reset --force` avec --force si même vous voulez éviter la confirmation mais on verra par rapport à ça.

```bash
sam@sam:~$ sudo ufw reset
Réinitialisation de toutes les règles à leurs paramètres installés par
défaut. Exécuter l opération (o|n) ? n
Annulé
```

```bash
sam@sam:~$ sudo ufw status verbose
État : actif
Journalisation : on (low)
Par défaut : deny (incoming), allow (outgoing), disabled (routed)
Nouveaux profils : skip

Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW IN    Anywhere                  
443/tcp                    ALLOW IN    Anywhere                  
22/tcp                     ALLOW IN    Anywhere                  
80/tcp (v6)                ALLOW IN    Anywhere (v6)             
443/tcp (v6)               ALLOW IN    Anywhere (v6)             
22/tcp (v6)                ALLOW IN    Anywhere (v6) 
```

## numberd

On a également pour le statut `numberd` qui permet d'afficher des numéros de règles.

```bash
sam@sam:~$ sudo ufw status numbered
État : actif

     Vers                       Action      De
     ----                       ------      --
[ 1] 80/tcp                     ALLOW IN    Anywhere                  
[ 2] 443/tcp                    ALLOW IN    Anywhere                  
[ 3] 22/tcp                     ALLOW IN    Anywhere                  
[ 4] 80/tcp (v6)                ALLOW IN    Anywhere (v6)             
[ 5] 443/tcp (v6)               ALLOW IN    Anywhere (v6)             
[ 6] 22/tcp (v6)                ALLOW IN    Anywhere (v6) 
```

## delete

Ces numéros de règles serviront notamment quand on va vouloir identifier par exemple pour la suppression d'une règle, voyez qu'elles sont numérotés dans cet ordre là d'accord la première ici étant numéro [ 1] et on pourra éventuellement supprimer une règle en faisant `sudo ufw delete xx` et là vous mettez le numéro (xx) par exemple vous voulez supprimer cette règle a pour l'ipv6 je ferai ça.

```bash
sam@sam:~$ sudo ufw delete 6 #supprimer la règle 6.
```

D'accord pour là très pratique donc avec l'argument numbered quand vous faites ainsi un affichage en fait l'état de votre pare-feu vous pouvez supprimer comme ça éventuellement.

## insert

On peut aussi faire un `inserty`, on peut parfaitement dire par exemple à la ligne de 4, j'ajoute par exemple `sudo ufw insert 4 allow ...` de je ne sais pas quoi une autre règle ftp ou je ne sais quoi, `sudo ufw insert 4 allow ftp` d'accord on peut parfaitement faire ce genre de choses là.

```bash
sudo ufw insert 4 allow ftp #ajouter une règle à propos de ftp.
```

Qu'est ce que je peux vous montrer d'autres sur cet outil parce qu'il n'y a pas grand grand chose quand même à savoir pour avoir un usage assez standard il y a pas non plus 15 millions de règles à connaître mais c'est bien de savoir en tout cas comment ça fonctionne et de l'utiliser, n'hésitez pas à vous configurez quand même un pare-feu par défaut parce que vous voyez qu'il n'est pas activé par défaut sur votre distribution, ça permettra quand même d'éviter d'avoir tout connecté n'importe comment et de connecter surtout les communications entrantes et si quelqu'un cherche à se connecter à votre de votre machine et que bah si vous avez tous bloqués à part quand une fois http, https, ssh, on pourra déjà faire beaucoup moins de choses donc c'est pas mal surtout pour bloquer notamment les protocoles qui sont obsolètes ou pas assez sécurisé je pense à telnet, ftp, etc.

## from

Qu'est que je peux montrer d'autres ? on peut éventuellement voir d'autres syntaxe après là c'est pareil c'est des cas quand même très très spécifique mais admettons on peut très bien dire par exemple j'autorise donc en entrée http depuis une adresse ip en particulier et là vous mettez une adresse ip.

```bash
sudo ufw allow http from 163.146.4.1 #autoriser en entrée http depuis une adresse ip.
```

Alors je mets un exemple ici que je ne vais pas exécuter parce que je ne veux pas les appliquer à mon pare feu.

On peut faire un `allow` aussi mais si on veux faire l'inverse, c'est `deny` n'oubliez pas le terme d'ici d'accord.

```bash
sudo ufw deny
sudo ufw deny http from 163.146.4.1 #ne pas autoriser en entrée http depuis une adresse ip.
```

N'oubliez pas voilà comme ça on peut contrôler tout ça.

## ports

On peut le faire également depuis un port par exemple on a vu le cours MySQL, il y a des gens parmi vous qui utilise du MySQL d'accord donc ça peut être pas mal par exemple d'avoir ce genre de commandes là et bien on peut parfaitement se dire bah tiens on va autoriser par exemple l'usage en local d'accord en localhost directement de ça.

Je vais vous montrer un petit peu après parce que j'ai pas mal d'autres comme commandes que je peux vous montrer ici.

On a pour l'IP et on peut préciser une plage si vous voulez de ports d'accord on peut faire par exemple `sudo ufw allow 5200:5500` où on peut autoriser par exemple ici là vous mettez un port d'entrée 5200 depuis le port 5500 voilà d'accord et puis on autorise par exemple quelque chose /, `sudo ufw allow 5200:5500/...` on autorise un protocole, n'importe quoi. Franchement je ne sais pas, on peut autoriser par exemple ce genre de choses `sudo ufw allow 5200:5500/tcp` pour avoir une plage de ports.

```bash
sudo ufw allow 5200:5500/tcp #autoriser une plage de ports.
```

Et après ce qu on peut faire aussi par rapport à ce que j'avais montré tout à l'heure  notamment au niveau de l'adresse ip donc là en gros vous mettez <IP> `sudo ufw allow ... from <IP>` pour montrer qu'en fait ici vous remplacez par une adresse ip bien sûr et là `sudo ufw allow https from <IP> to any port 443` où là vous mettez un numéro de port par exemple 443 d'accord et par exemple on autorise une entrée https depuis cette adresse ip d'accord uniquement et pour le port 443 uniquement donc ça peut par exemple pour limiter, pour spécifier des ports bien précis dans votre configuration donc là je pense que ça ne vous concernera pas beaucoup, pour beaucoup d'entre vous mais c'est une commande en tout cas qu'il est possible d'utiliser.

```bash
sudo ufw allow https from <IP> to any port 443 #on autorise une entrée https depuis cette adresse ip uniquement et pour le port 443 uniquement.
```

Bien sûr dans les <IP> on peut également préciser des sous-réseaux en mettant un petit slash, vous savez le faire.

```bash
<IP>/
```

Vous mettez une ip puis vous mettez un slash et puis votre sous-réseau, on pourrait parfaitement configurer ça et s'est pris en charge également avec l'outil donc c'est pas mal pratique donc n'ésitez pas bien sûr à vous en servir.

## configurer le port MySQL en local

C'est important parce qu'on en a pas mal parlé avec le réseau au sujet des interfaces, rappelez-vous quand on faisait par exemple `ip addr`, on avait ici nos interfaces d'accord ici.

```bash
sam@sam:~$ ip addr
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host 
       valid_lft forever preferred_lft forever
2: enp0s3: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
    link/ether 08:00:27:4f:ae:24 brd ff:ff:ff:ff:ff:ff
    inet 10.0.2.15/24 brd 10.0.2.255 scope global dynamic noprefixroute enp0s3
       valid_lft 82518sec preferred_lft 82518sec
    inet6 fe80::b891:c554:c1fc:dd60/64 scope link noprefixroute 
       valid_lft forever preferred_lft forever
```

`lo` c'est l'interface pour le réseau local, localhost quand on fait pareil par exemple du web en local, vous l'utilisez généralement beaucoup et après à la connexion directement par du wifi on peut avoir la connexion ethernet, etc.

On peut parfaitement configurer ça aussi par exemple si vous faites du MySQL et je prends cet exemple parce qu'il est quand même assez parlant vous pouvez configurer cet outil là aussi c'est pas mal pratique.

On peut faire `sudo ufw allow in on lo to any port 3306` alors là c'est `in on` il y a deux mots et ici vous mettez le nom de l'interface donc vous avez vu que c'était `lo` et pour vous de toute façon ce sera pareil vous avez vu que c'était loopback généralement c'est ce terme là surtout avec les évolutions qu'il y a avec les outils de l'administration, configuration réseau et ensuite `to any port` et là vous précisé le port de MySQL par défaut à 3306 pour le port par défaut pour MySQL comme ça vous dites voilà que localhost peut parfaitement utiliser ça d'accord.

```bash
sudo ufw allow in on lo to any port 3306 #configurer le port MySQL par défaut avec l'interface du réseau local.
```

Voilà vous pourrez vraiment tout configurer bien précisément, encore une fois par défaut surtout pour ce qui est entrant prenez l'habitude de tout bloquer et de toute façon quand vous allez utiliser certaines applications si elles se mettent à ne plus fonctionner ou juste certaines, vous serez automatiquement le port qu'il faut autoriser comme ça voyez vous autorisé seulement ce que vous avez ce dont vous avez besoin et pas on autorise tout par défaut parce que c'est évidemment pas du tout pas du tout sécurisé.

Prenez toujours l'habitude en sécurité informatique, on bloque par défaut et ensuite on autorise au cas par cas ce dont on a besoin pour être sûr ou en tout cas contrôler au maximum ce qu'on autorise comme communication sur tout ce qui est communication entrante bien évidemment.

## filtrage des communications sortantes

Alors le filtrage des communications sortantes ça peut être utile, imaginez par exemple une entreprise où il y a tout un tas ordinateurs branchés ensemble, on n'a peut-être pas envie par exemple que des données fuites par un des employés donc on peut parfaitement se dire via tel protocole ou simplement parce que le protocole en question n'est pas sécurisé, on n'a pas envie que un de nos employés envoie des données via ce protocole pas sécurisé donc on peut parfaitement bloquer en sortie ce genre d'info et là on ferait quelque chose du genre, je ne sais pas moi, `sudo ufw deny out ftp` d'accord comme ça on interdit en fait en sortie l'utilisation de ftp. 

```bash
sudo ufw deny out ftp #interdire en sortie l'utilisation de ftp.
```

On peut faire ce genre de choses voilà on peut parfaitement utiliser ce genre de syntaxe ça fonctionne très bien et il y a pas mal d'autres types de syntaxes qu'on peut retrouver bien sûr par rapport à ça.

## résumé

### quid état de ufw

Alors j'essaie de résumer, on a vu pour la configuration et je regardais l'état du par feu c'est très important, on peut aussi ça je ne l'ai pas forcément montré rapidement mais c'est dans les usages où d'habord je vous ai montrée par exemple comment l'activer `sudo ufw enable` et si vous voulez désactiver bien sûr c'est l'inverse c'est disable `sudo ufw disable`. On peut également le redémarrer avec un reload `sudo ufw reload` et on a vu tout à l'heure reset `sudo ufw reset` d'accord pour remettre en fait à 0 complètement, repartir en fait d'une configuration complètement vide donc il faudra tout refaire la configuration par défaut etc etc pour avoir quelque chose bien sûr d'utile parce que s'il n'y a aucune règle d'indiquer sur votre pare feu c'est comme si vous n'aviez pas de pare-feu ça paraît logique.

```bash
sudo ufw enable #activer le pare-feu.
sudo ufw disable #désactiver le pare-feu.
sudo ufw reload #redémarrer le pare-feu.
sudo ufw reset #réinitialiser le pare-feu.
```

On a vu pour la journalisation je vous en ai parlé très rapidement parce qu'encore une fois c'est quand même un cas très spécifique donc on ne va pas non plus trop trop voir à ce niveau là et bah alors je pense qu'on a fait un petit peu le tour.

Alors autre chose d'important que je n'ai pas dit car on le voit beaucoup moins par rapport à `iptables` c'est les différents termes en fait ça c'est pas mal d'en parler c'est-à-dire que le `allow` pour ceux qui font `iptables` c'est souvent ce que l'on retrouve avec le terme `accept` d'accord ça veut dire tout simplement qu'on accepte la communication, il n'y a pas de problème à ce niveau là.

```txt
deny -> DROP
```

Quand on va retrouver un `deny`, on va parler ici de `DROP` ça veut dire qu'on va tout simplement en fait bloquer d'accord la communication mais on ne va pas forcément indiquer à la machine qui a cherché à communiquer par un message d'erreur ça veut dire que la personne qui va essayer par exemple d'entrer en communication et que si derrière le pare-feu lui envoie un `deny` entre guillemets eh bien elle n'aura pas de message d'erreur pour lui dire tu a tenté de te connecter à la machine et tu n'a pas pu parce que c'est bloqué et pensera simplement que la machine n'existe pas puisque rien ne sera envoyé.

```txt
deny -> REJECT
```

Si on veut envoyer un message d'erreur c'est à dire qu'on bloque mais qu'on envoie un message d'erreur en retour, on utilise généralement le `reject` d'accord donc là ça va bloquer d'accord c'est comme un `drop` mais on va envoyer un message d'erreur donc là la personne de l'autre côté saura que la machine existe puisque on lui aura envoyé un message d'erreur, voyez la distinction.

Généralement quand on veut bloquer par défaut toutes les choses de l'extérieur, on va certainement pas envoyer des messages d'erreur pour quelque part donner un indice que la machine que tu as essayé avec laquelle tu as essayé de communiquer en fait elle existe ... non non on `drop` tout simplement donc on `deny` et impossible finalement de savoir avec certitude que l'adresse en question de la machine avec laquelle on tente de communiquer existe ou non. Il ne se passe rien en fait voilà on verra absolument rien, au niveau comportement il n'y aura pas de message d'erreur, pas de message de retour ou ce genre de choses donc ça c'est très important quand même de savoir cette distinction parce qu'on on la voit quand même beaucoup moins, beaucoup moins avec ce genre d'outil mais ça pour ceux qui ont déjà fait de la configuration `iptables`, vous avez dû vous arracher les cheveux avec ça, je pense que c'est bien clair avec `accept`, `reject`, `drop` etc. On connaît pas mal à ce niveau-là.

### quid delete

Ensuite pour le `delete`, je vous ai montré comment faire mais on peut aussi par exemple parler de règles c'est-à-dire qu'on n'est pas obligé de faire `sudo ufw delete 4` avec le numéro par exemple de la ligne qu'on a vu avec status numbered on peut dire aussi par exemple bien tu enlève cette règle là.

```txt
sudo ufw delete 4
sudo ufw delete allow ssh #enlever une règle.
```

```bash
sam@sam:~$ sudo ufw delete allow ssh
La règle a été supprimée
La règle a été supprimée (v6)
```

Je fais ça et puis là maintenant si je fais un status, je n'ai plus la règle que j'ai mis pour ssh, y compris pour ipv6, pour les deux.

```bash
sam@sam:~$ sudo ufw delete allow ssh
La règle a été supprimée
La règle a été supprimée (v6)
sam@sam:~$ sudo ufw status
État : actif

Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW       Anywhere                  
443/tcp                    ALLOW       Anywhere                  
80/tcp (v6)                ALLOW       Anywhere (v6)             
443/tcp (v6)               ALLOW       Anywhere (v6)
```

Il ne reste plus que la règle pour http et https.

On peut soit préciser après le `delete` une règle qu'on a éventuellement appliqué, qu'on a ajouté d'accord ce serait l'équivalent de `iptables -A` avec A majuscule pour ceux qui font iptables mais ici on peut soit mettre le numéro si on passe par les numéros si vous préférez cette syntaxe là sinon bah vous savez vous avez un jour fait cette règle là, vous l'avez ajouter à votre pare-feu et on peut la retirer en réécrivant voilà pour dire tu `delete` cette règle que j'ai déjà ajouté.

Il va bien sûr la retirer sans problème.

## redirection

Voilà pour ceux éventuellement qui font un peu de routage très simplement on peut également en faire `sudo ufw route allow in on <A> out on <B>` et vous pouvez faire de la redirection mais de toute façon vous avez vu que la redirection n'était pas forcément activés donc on peut voir tout ça mais en gros on va dire `route` donc c'est pour la redirection, `in on` et ici vous mettez finalement la machine <A> d'accord le point A et vous préciser vers le point B simplement.

```bash
sudo ufw route allow in on <A> out on <B> #redirection de la machine A à B.
```

Simplement pour encore une fois autoriser la redirection par exemple lorsqu'on cherche à entrer en communication avec la machine A hé bien on autorise la retransmission/redirection vers B d'accord donc le pare-feu peut également gérer ça.

Encore une fois le pare-feu servait à analyser et filtrer toutes les communications, tout les types de transmissions donc il gère à la fois ce qui est entrant, ce qui est sortant et ce qui est en fait de la redirection alors je ne l'ai pas encore trop spécifié parce qu'encore une fois ce genre de d'outil en surcouche **ufw** est fait pour simplifier les choses mais sachez qu'on parle de table c'est-à-dire que Netfilter comme je l'ai dis en tout début de vidéo, c'est un framework qui possède pas mal d'outils différents et notamment ici un ensemble de table.

On a une table qui s'appelle filter qui contient justement toutes les règles que l'on va avoir en entrée donc c'est généralement ce qu'on appelle le INPUT, on a les règles en sortie c'est le OUTPUT et en a les règles de redirection c'est le FORWARD.

```txt
INPUT/OUTPUT/FORWARD
```

Et après dans ces différentes chaînes parce que ce sont des chaîne en fait la chaîne input, la chaîne output, la chaîne forward, on peut appliquer un ensemble de règles pour chacun.

Voilà vous voyez on a des tables, dans chacune des tables on a des chaînes et dans chacune des chaîne on applique des règles donc c'est assez conséquents donc si vous allez vous documenter un petit peu sur les outils comme Netfilter, tout ça vous allez voir que c'est pas un petit outil c'est vraiment un framework càd que c'est un ensemble d'outils
différents et il y a énormément de choses qu'on peut gérer.

On peut gérer le nat, on peut gérer tout un tas d'autres outils via d'autres tables mais moi je vous ai montré ce qui semblait le plus évident et le plus essentiel à voir bien sûr encore une fois si vous êtes une entreprise avec un usage très très précis à voir, il faudra de toute façons vous orienter vers des configurations beaucoup plus strictes très certainement. Voir même peut-être vers du pare-feu matériel si vous avez une infrastructure assez conséquente dans tous les cas.

Voilà je pense qu'on peut s'arrêter là, il y a pas mal de choses et je ne voudrait pas trop vous perdre non plus car il y a pas mal de commandes alors ça c'est le genre de vidéos idéal encore une fois vous pouvez prendre plein de notes càd que je vous ai montré pas mal de commandes pas forcément tout dans l'ordre parce qu'il n'a pas vraiment d'ordre, il y a des commandes pour ajouter, supprimer, gérer par plage de ports, gérer par adresse ip donc j'espère que vous avez pris des notes si c'est pas fait penser à le faire c'est très simple.

Voilà vous faites un petit mémento même sur votre pc, sur un cahier, sur un classeur, sur ce que vous voulez. Vous notez comme ça toutes les petites commandes à retenir et le jour où vous avez besoin de configurer votre pare-feu vous avez tout qui accessibles rapidement, c'est très très simple.

C'est vraiment très simple encore une fois si vous avez fait `iptables`, vous aurez constaté la différence d'utilisation et si vous n'en avez jamais fait n'hésitez pas à regarder un peu comment on fait ce genre de configuration de pare-feu avec l'outil `iptables` vous allez voir c'est quand même un autre délire, ça ne veut pas dire non plus que c'est infaisable mais en comparaison `ufw` en surcouche rend les choses beaucoup plus simple qu'avec `iptables` voilà il y a moins de répétition et il y a moins de syntaxe à écrire, c'est beaucoup plus simple.

Voilà alors moi j'ai enlever ssh mais je m'en fiche car je suis en machine virtuelle.

```bash
sam@sam:~$ sudo ufw status
État : actif

Vers                       Action      De
----                       ------      --
80/tcp                     ALLOW       Anywhere                  
443/tcp                    ALLOW       Anywhere                  
80/tcp (v6)                ALLOW       Anywhere (v6)             
443/tcp (v6)               ALLOW       Anywhere (v6) 
```

Je vais laisser quand même cette configuration et tant pis je vais laisser ça tel quel pour la machine virtuelle comme ça ce sera fait j'aurais un pare-feu de configurer sur ce système-là, ce qui n'était pas le cas forcément avant.

J'espère en tout cas que c'était suffisamment explicite, que je vous donné un maximum d'informations parce qu'encore une fois je ne pouvais pas parler de tout.

Au début je pensais vous faire une petite partie sur `iptables` ensuite parler `ufw` mais ça allait faire une vidéo forcément très très grande avec déjà 34 minutes d'enregistrement pour juste parler du ´ufw´ sans trop trop traîner non plus sur chaque exemple de toute façon il n'y a pas de secret il faudra que vous testiez de votre côté, sur vos configurations pour voir.

J'insiste même si je l'auraisdit trois quatre cinq fois et je sais qu'il y a des gens qui vont se planter, que je vais avoir des messages en commentaires ou en privé pour me dire mince je ne sais pas quoi faire, j'ai pu accès internet donc attention avant d'activer votre pare feu vérifiez que vous autorisez au moins connexion http, https et si la machine que vous configurez est une machine à distance et que ce n'est pas votre ordinateur, n'oubliez pas d'autoriser également `ssh` dés que vous allez vouloir vous reconnecter bas vous allez tout simplement perdre la connexion, ce sera un petit peu dommage et bien sûr si vous utilisez certains outils en local, localhost, mysql, des serveurs comme ça en local, que vous faites du développement web et bien il faudra sûrement au cas par cas autoriser certaines choses.

Après vous avez vu qu'en sortie encore une fois on avait par défaut tout autorisés mais si vous avez besoin d'autoriser certains protocole bien précis en entré, vous aurez peut-être une configuration de votre pare-feu un peu différent de la grande majorité de gens qui veulent juste un accès à internet éventuellement accès à ssh pour la connexion à distance et ça fera le travail comme il faut.

N'hésitez pas c'est pas forcément activés par défaut sur de linux, maintenant je pense que vous comprenez qu'un pare-feu est utile même encore en 2020 il n'y a aucun problème avec ça et ce sera encore utile pendant des dizaines, des centaines d'années de toute façon.

C'est pas le genre d'outil dont on peut se passer aujourd'hui même s'il y a des règles de sécurité pas mal appliquées déjà sur GNU Linux et si on peut appliquer ça en plus sur son système c'est déjà pas plus mal.

Sur windows c'est quelque chose qu'on a par défaut un pare-feu et qui limite pas mal et de toute façon pour ceux qui voit le cours sur le cours windows c'est également quelque chose que nous voyons au sujet de la configuration de pare-feu, ce n'est pas fait au moment où j'ai fait cette vidéo mais c'est quelque chose qui est prévu de toute façon sur le cours windows également parce que c'est très important.

Voilà n'hésitez pas si il y a des questions, des problèmes bien sûr j'espère qu'il n'y aura pas de soucis de gens qui n'ont plus accès internet de toute façon si c'est le cas, vous ne pourrez plus trop laisser de commentaires sur la vidéo mais si vous avez des questions, des remarques par rapport à cette configuration de votre pare feu n'hésitez pas et je vous invite à utiliser d'autres outils voilà `firewalld`, `nftables` et de voir un peu comment ça fonctionne pour comparer un peu, peut-être que vous trouverez un outil plus simple pour vous que d'autres.

Encore une fois n'y a pas de meilleurs outils, c'est en fonction de votre usage à vous, de vos préférences donc n'hésitez pas à être curieux un petit peu des différents outils et de voir un petit peu ce qui vous plaît le plus.

A bientôt monde pour la suite de ce cours de Linux, on attaque un nouveau chapitre, le dernier du cours avant de terminer qui concerne la programmation de script on y arrive et vous allez voir qu'il a pas mal de vidéos quand même encore à aborder ensemble.

Ciao