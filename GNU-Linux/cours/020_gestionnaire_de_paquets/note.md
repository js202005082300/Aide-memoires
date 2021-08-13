# [20. Gestionnaire de paquets](https://www.youtube.com/watch?v=WHCb06mDPXI)

* [Gestionnaire de paquets](https://doc.ubuntu-fr.org/gestionnaire_de_paquets) = système qui intérroge des dépots pour l'installation, la màj et la suppression.
* dépots = endroit où sont stockés les paquets. Ca peut être un répertoire, un serveur, un cd qui contient des archives que l'on va pouvoir installer.
* gestionnaire de paquets et gestionnaire de dépendances sont 2 choses différentes.
* système de paquets selon les grandes familles de distributions Linux :
	* dpkg (Debian, Ubuntu, Mint, eOS, Trisquel) -> .deb
	* rpm (Fedora, openSUSE, Red Hat, Mageia) -> .rpm
	* pacman (ArchLinux, Manjaro)
	* pkgtool (Slackware)
	* pkg (Mac OSX)

> .dev = archive qui contient des fichiers, des instructions pour l'installation de notre programme.

* [Outil pour la gestion des paquets](https://doc.ubuntu-fr.org/apt)
	* apt = Gestion des paquets (pour un utilisateur final).
	* apt-get, apt-cache, apt-file = Gestion des paquets (pour un script).
	* aptitude = Gestion des paquets - interface semi-graphique.
	* dpkg = Gestion des paquets hors dépôts
		
## dpkg & apt-get

```bash
sudo dpkg -i Téléchargements/discord-0.0.13.deb
	...
	dpkg: des problèmes de dépendances empêchent la configuration de discord

sudo apt-get -f install #Permet de corriger les problèmes de dépendances càd qu'il télécharge et installe les paquets manquant pour compléter l'installation Discord.

cat /etc/apt/sources.list #liste des liens vers les dépots sur Ubuntu.
```

## dépots sur Ubuntu : 
* il y a backports (pour la compatibilités avec des anciens paquets).
* il y a main, restricted, universe et multiverse.
* Canonical gère la distribution.
* 2 dépôt officiel :
	* main = contient les paquets et programme libre.
	* restricted = paquet non libre.
* 2 dépôt maintenu par la communauté d'utilisateur :
	* universe = paquets libres.
	* multiverse = paquets non libre.
* Privilégier les dépots officiels vs. le fichier sur le site officiel non recommandé (dpkg et apt-get -f install).
* Choisir sa distribution en fonction de ses dépots (distribution rooling vs distribution stable avec des logiciel suffisament testé pour être stable)

## apt | aptitude | apt-get | apt-cache
```bash
sudo apt install gimp #installation (barre de progression en plus que apt-get).

sudo aptitude update #màj.

sudo apt-get update #mettre à jour la liste des dépots (/etc/apt/sources.list)
sudo apt-get install <paquet> #installer un paquet.
sudo apt-get install gimp vlc libreoffice #installer plusieurs paquets à la suite.

sudo apt-cache search firefox #chercher le pack de langue FR.
	...
	firefox-locale-fr - Paquet de langue Firefox pour le français

sudo apt-cache search firefox-locale-fr
sudo apt-get install firefox-locale-fr #Installer sans problème de dépendance. :D
sudo apt-get install gimp
	...
	Les paquets supplémentaires suivants seront installés : ...
	Les NOUVEAUX paquets suivants seront installés : ... #= **dépendances à installer**.

sudo apt-get -f install #corriger les problèmes de dépendance.
sudo apt-get source <paquet> #télécharger sources d'un paquet open-source ou libre.
	~$ mkdir Téléchargements/vlc
	~$ cd Téléchargements/vlc
	sudo nano /etc/apt/sources.list #décommenter plusieurs deb-src.
	sudo apt-get update #récupérer les dépots supplémentaires.
	sudo apt-get source vlc
	sudo chmod 755 -R ./
	sudo chown sam:sam -R ./
```
### remove | autoremove | purge 

```bash
sudo apt-get remove <paquet> #supprimer un paquet.
sudo apt-get autoremove <paquet> #supprimer paquet + dépendances.
sudo apt-get purge <paquet> #supprimer paquet + fichiers de configuration.
sudo apt-get autoremove --purge <paquet> #paquet + dépendances + fichiers config.

sudo apt-get install gimp
whereis gimp

 	gimp: /usr/bin/gimp /usr/lib/gimp /etc/gimp /usr/share/gimp /usr/share/man/man1/gimp.1.gz
		#avec : /usr/bin/gimp = chemin vers l'exécutable.  
		#		/usr/lib/gimp = bibliothèques.  
		#		/etc/gimp  = fichiers de config.  
		#		/usr/share/gimp = fichiers de config partagés.  
		#		/usr/share/man/man1/gimp.1.gz = manuel.  
```
			
:warning: fichier de config et fichier de préférences sont différents :

    /usr/share/gimp/2.0/ = fichiers de config partagés.  
    /home/sam/gimp-2.0/ = préférences.  

Le gestionnaire de paquet ne gère pas le nettoyage du dossier personnel.
```bash
sudo apt-get remove gimp
whereis gimp
    ...
	gimp: /etc/gimp /usr/share/gimp

sudo apt-get autoremove --purge gimp
whereis gimp
    ...
	gimp:
```
:warning: il reste des fichiers de préférences dans le dossier personnel et les logs, les surveillances qui reste au niveau du système.

```bash
rm /home/sam/gimp-2.0/

sudo apt-get autoremove --purge #tous les paquets + dépendances + fichiers config.
sudo apt-get update #mettre à jour le système.
sudo apt-get upgrade #mettre à jour les paquets et dépendances (1xsem).
sudo apt-get dist-upgrade #mettre à jour paquets et dépendances (et éventuellement nouveaux paquets) (1xmois).
```
### Documentation Ubuntu

	https://doc.ubuntu-fr.org/
	https://doc.ubuntu-fr.org/vlc

Dépot PPA Parsonnal Package Archives, dépot non officiel mais sur la doc validé par Canonical ou les communautés.

```bash
sudo add-apt-repository ppa:<dépot>
sudo add-apt-repository ppa:jonathonf/vlc
sudo apt-get update #mettre à jour la liste.
```
Emplacement des PPA : /etc/apt/sources.list.d (répertoire).
```bash
sudo apt-get install <paquet>
sudo add-apt-repository --remove ppa:<dépot>
```
Attention privilégier dépots officiels plutôt que PPA.

### dpkg

```bash
dpkg -i #installation.
dpkg -r #supprimer paquet.
dpkg -p #paquet + dépendances.
dpkg --force-all --purge #suppression totale.
```	
:warning: priviligier un gestionniaire de dépendances, versionning ou autres à :no_entry:dpkg :no_entry:.

### deborphan

Recherche les paquets orphelins.
```bash
sudo apt install deborphan
deborphan #lister les paquets inutilisés par le système.
sudo apt-get remove $(deborphan) #passer le retour de la commande pour virer les paquets orphelins.
```
:warning: aux outils que vous utilisez et l'impact sur le fonctionnement de votre système. Renseigner vous avant de supprimer n'importe quoi.

```bash
sudo apt-get autoclean #suppression paquets archivés sauf versions dans les dépôts.
sudo apt-get clean #suppression de toutes les archives.
```
Emplacement des archives : /var/cache/apt/archives