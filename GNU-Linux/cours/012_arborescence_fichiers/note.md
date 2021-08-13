## [12. Arborescence fichiers](https://www.youtube.com/watch?v=9xpItgaWVso)

## commande shell :

> commandes --option/-option param1 param2

## echo
Afficher des lignes de caractères sur votre invite de commandes.
```bash
echo "Bonjour tout le monde" #commande d'affichage avec 1 argument entre quotes.
echo Bonjour tout le monde #même résultat avec 4 arguments.
```

## arborescence fichiers

Sur Linux, tout est fichier comme un document, la commande `echo`, les périphériques, un répertoire est également un fichier qui contient un lien vers tous les autres fichiers. Un répertoire est un fichier qui contient un liens vers plusieurs autres fichiers.

Sur Linux, pas de système d’extension (`image.docx` est quand même lu comme une image, `film.txt` est lu comme un film). Le système évalue le type d’un fichier en fonction de son contenu, de son **type MIME** et pas de son extension.

|||
-|-
**/**|répertoire racine (root) qui intègre tous les fichiers du système.
**/bin**|répertoire qui intègre tous les fichiers, les exécutables des commandes qu'on va utiliser tel que la commande echo (=fichier) considéré comme un programme exécutable.
**/boot**|répertoire qui intègre le chargeur d’amorçage, les fichiers d'amorçage, le boot loader qui permet notamment d’installer plusieurs systèmes sur un même disque dur et de pouvoir booter sur l’un ou l’autre (dual boot, multi boot). Tous les fichiers qui permettent cette action sont réunis dans ce dossier.
**/dev**|répertoire qui contient tous les fichiers des périphériques (devices).
**/etc**|répertoire qui accueille les fichiers de configurations [**editing text config**] qui vont servir pour tous les programmes et services du système (exemple, un répertoire de configuration pour gdb, un répertoire de configuration pour python). 
**/home**|répertoire qui accueille tous les fichiers utilisateurs (chacun son Dossier personnel) qui contiennent tous nos fichiers personnels.
**/lib**|répertoire qui contient les modules du noyau et les fichiers bibliothèques (libraries en anglais) partagées, notamment bibliothèques propre au module du noyau GNU, entre les différents programmes qui pourront les utilisées.
**/lib64**|répertoire qui existe car on est en architecture 64 bits.
**/media**|répertoire des fichiers de point de montage pour toutes périphériques amovibles branchables sur mon ordinateur (une clé usb, un disque dur externe ou autre).
**/mnt**|répertoire afin de monter un système de fichier manuellement (exemple, une clé usb) et de façon temporaire. 
**/opt**|répertoire pour tout ce qui est optionnel, les programmes qui ne seront pas installés via les gestionnaires de paquets (logithèque, etc.) ou un gestionnaire de paquets en ligne de commandes pour l’installation de logiciels. Il est d'usage de télécharger et dézipper dans ce répertoire (XAMP, Sublime Text, etc.).
**/proc**|répertoire des fichiers qui réunis toutes les informations du système, les processus, l'état du noyau et cetera.
**/root**|répertoire du super utilisateur. En plus de notre compte utilisateur, le super utilisateur peut écrire n’importe où dans le système. Il est bloqué par défaut (mot de passe identique que ma session).
**/run**|[**run time system**] répertoire des fichiers d'informations depuis qu'on a démarré notre système. Il s'agit de plusieurs petits fichiers de surveillance. Utile pour récupérer des infos, etc.
**/sbin**|[**super bin**] répertoire des exécutables, super important pour notre système.
**/snap**|système de paquet.
**/srv**|service du système (imprimante, Web, etc).
**/tmp**|répertoire des fichiers temporaires.
**/usr**|[**unix system resources**] répertoire des programmes utilisateurs, des fichiers partageables en réseau et en lecture seul.
||_bin_ (répertoire qui regroupe tous les programmes utilisateurs)
||_lib_ (bibliothèques partagées notamment pour les supers programmes dans sbin)
||_local_ (compiler les programme manuellement)
||_share_ (fichiers partagés entre applications comme les thèmes du systèmes, les icones, les documentations partagées, et cetera)
||_var_ (données inclassables)

## pwd
Chemin absolu c'est à dire depuis la racine du système.

## cd (change directory)
Changer de répertoire.
```bash
cd ~ #répertoire home.
cd ~sam #répertoire home de l'utilisateur sam.
cd . #(ou cd) répertoire courant.
cd .. #répertoire parent.
cd / #répertoire racine.
cd /home/sam/Téléchargements #se déplacer de manière absolue.
cd ../Musique/ #retour au parent puis se déplacer dans Musique.
cd /usr/bin/ #retour à la racine puis se déplacer dans bin.
```
## clear
Effacer le terminal.

## ls
Lister le répertoire courant.
```bash
ls /usr/bin/ #lister le répertore bin.
ls /etc #lister un autre chemin absolu.
ls Musique #lister chemin relatif.
ls . #(ou ls) lister répertoire courant.
man ls #aide de commande ls.
ls -l #lister avec plus de détails avec les droits d'accès sur le fichier.
		...
		drwxr-xr-x 3 sam sam 4096 déc 25 20:30 Bureau
			drwxr-xr-x = accès sur le fichier en lecture, écriture et éxécution.
			    #sam = utilisateur.
			    #sam = groupe.
			    #4096 = taille.
			    #déc 25 20:30 = date d accès, modification.
			    #Bureau = nom du répertoire d accès au fichier.
ls -a #ne pas cacher ce qui commence par un . ou un .. (idem avec ctrl+H).
ls -la #lister en détails, y compris fichiers cachés.
```
## man
```bash
man printf #détail commande printf.
man 1 printf #idem car printf est dans la section 1.
man ls #ou: man 1 ls
man exit #ou: man 3 exit
man clear
man man #manuel du manuel.
```
## file
Retourne le type de fichier.
```bash
file linux.txt
    ...
	linux.txt: UTF-8 Unicode text
```
:warning: Le type ne change pas si on change l'extension.
```bash
mv linux.txt linux.mp3
file linux.mp3
    ...
	linux.mp3: UTF-8 Unicode text
```