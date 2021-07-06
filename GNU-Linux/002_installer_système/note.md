# [02. Installer système](https://www.youtube.com/watch?v=0i2WTmKktbE)

Le choix de la distribution doit surtout répondre à nos besoins.

## Critères pour sélectionner la distribution :

1. Le maintien et le support de distribution (Par exemple, Ubuntu est maintenu depuis plusieurs années par la société Canonical. C'est le cas de Mint basé sur Ubuntu basé également sur Debian).
1. La technicité : distribution minimaliste vs distribution prêt à l’emploi.
1. La philosophie (open-source, libre).
1. L'interface bureau.

## Plusieurs distributions mère dont les plus populaires sont :

- Debian : Ubuntu et Mint : Distribution stable + Distributions testing de Debian avec des versions plus récentes de logiciels.
- Arch Linux : Manjaro et Antergos : Distribution Rooling et minimaliste.
- Fedora : Distribution stable.
- OpenSUSE : Distribution stable.
- Trisquel : accepte que des logiciels 100% libre, pas de logiciels Open-source ou de logiciels privateur.
- Mageia
- Kali avec logiciels préconfigurés pour la sécurité informatique.
- Lemon
- Budgie : permet la personnalisation de l'interface.
- Cinnamon, la version la plus populaire de Linux Mint.
- Enlightenment linux : minimaliste et configurable par l’utilisateur.
- Gnome linux
- KDE plasma : interface similaire à Windows.
- LXDE linux : léger (idéal pour les vieilles machines).
- Mate Linux : minimaliste et modifiable par l’utilisateur.
- Pantheon Linux (créé par les développeurs de Elementary OS), par exemple, leur environnement de bureau peut être installé sur d'autres OS que celui de Elementary OS.
- Unity linux 
- XFCE 

## Définitions

- Distribution Rooling = distribution mise à jour continuellement. C'est l’opposé d'une distribution stable. Si FireFox sort une nouvelle version, il faudra peut-être quelques jours pour qu'elle soit disponible sur une distribution Rooling. Les distributions stables de Linux continueront à fournir des versions de logiciels plus anciennes.
- Conky = logiciel de monitoring du système de fenetrage compatible sur GNU/Linux.

## Virtualisation

1. Ouvrir VirtualBox
1. Nouvelle 
	1. Nom
	1. Type 
	1. Version (32 ou 64 bits) : juste une information qui va ajuster les paramètres par défauts.
1. Nom et système d’exploitation (nom, type et version 32 ou 64 bits).
1. Taille de la mémoire Ram à allouer (attention, les valeurs par défaut sont un peu légères. Visé 4086 ou encore 8192 MB pour l’allocation).
1. Disque dur : "Créer un disque dur virtuel maintenant".
1. Activer "Créer".
1. Type de fichier du disque dur : Cocher "VDI (Image Disque VirtualBox)"
1. Stockage sur disque dur physique : Cocher "Dynamiquement alloué" (Si on choisit une taille fixe, l'espace alloué prendra directement la place en mémoire mais dynamiquement, l'espace sera progressivement alloué en fonction des besoins). 
1. Activer "Créer".
1. Configuration
	1. Système 
		1. Mémoire vive : vérifier si on a bien ce que l'on a inscrit.
		1. Processeur : mettre le maximum de cœurs que l'on a.
	1. Affichage
		1. Mémoire vidéo : mettre le maximum aussi.
		1. Accélération : cocher accélération 3D.
	1. Stockage : simule un lecteur CD. Il est important car il va permettre de sélectionner non ISO. -> contrôleur IDE -> vide -> clic sur le petit disque -> télécharger l'ISO -> "choisissez un fichier de disque optique virtuel" (Linux Budgie).
	1. Activer "OK"
	1. Activer "Démarrer" 
	
## Exemple de Linux Budgie
- Télécharger l’ISO : https://ubuntubudgie.org/2019/10/17/ubuntu-budgie-19-10-released/
- Préparation de l’installation du système d’exploitation Ubuntu Budgie.
	- Cocher "télécharger les mises à jour pendant l’installation de Ubuntu Budgie"
	- Cocher "Install third-party software for graphics and wifi hardware, mp3 and other media."
- Type d’installation.
	- Cocher "Effacer le disque et installer Ubuntu Budgie".
- Qui êtes-vous ?
	- Cocher "chiffrer mon dossier personnel." : 

## Créer un mode Plein-Ecran

> Sous Linux : Il suffit d'exécuter la commande "./VBoxGuestAdditions.run" en mode super utilisateur avec la commande "sudo su".