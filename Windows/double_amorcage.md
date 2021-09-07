# Double amorçage Windows | Linux

## Création d'une clé bootable | Windows
[Invite de commande](https://www.commentcamarche.net/faq/21013-creer-une-cle-usb-bootable-sous-windows-10-8-7)
[Ventoy - multiboot](https://www.youtube.com/watch?v=xVJHE27EJxA)

- [ ] Préparation et formatage d'une clé usb

Cette commande ouvre l'outil "diskpart"

	diskpart

Identifier le N° attribué a une clé usb dans la liste qui s'affiche

	list disk

Sélectionner le disque N° correspondant a une clé usb

	select disk 1

Supprimer la partition présente

	clean

Création d'une nouvelle partition

	create partition primary

Ceci rendra votre partition active pour lui permettre d'être "amorçable"

	active

Formatage rapide en "fat32"

	format fs=fat32 quick

Attribuer une lettre a votre lecteur USB

	assign

Quitter diskpart et fermer l'invite de commande

	exit
	exit

Ventoy2Disk.exe

* Option > Configuration > Préservez de l'espace au bas du disque > 64 GB
* Language = French
* Périphérique > D: [128GB] SanDisk Extreme
* Installation

/!\ La prochaine fois, utiliser le bouton Mise à jour de Ventoy2Disk.

# Repartitionner un disque déjà équipé d'un système d'exploitation | Windows
[lien doc.ubuntu](https://doc.ubuntu-fr.org/repartitionner )
[Gérer disque dur et partitions de disque](https://www.windows8facile.fr/gestion-partition-disque/ )

* Cmd (Admin)

	Ctrl + Shift + enter

* Défragmentation Windows
	
	Defrag C: -U -W

* Créer et formater des partitions de disque dur

	diskmgmt.msc

* Faire un clic droit sur C: et sélectionner Réduire le volume
* Indiquer une valeur dans la Quantité d’espace à réduire (en Mo)	(Par exemple pour 32 Gb : 32768 Mb)
* nb. Test disque

	chkdsk

## Installation d'Ubuntu | Linux
[Installation Ubuntu](https://www.tecmint.com/install-ubuntu-alongside-with-windows-dual-boot/)

* Redémarrage > BIOS (F12) > Ventoy > ubuntu-20.04.1-desktop-amd64.iso

## Régler le décallage d'heure | Windows

[régler le décalage d’heure](https://blog.malandra.be/mauvaise-heure-dual-boot-windowslinux/ )
- [ ] Régler le décallage d'heure sur Windows : éxécuter adjust_time_zone.reg
- [ ] Annuler le réglage : éxécuter clean_time_zone.reg

## Supprimer Partition | Windows

* Cmd Admin (Ctrl + Shift + enter)
* diskmgmt.msc (Créer et formater des partitions de disque dur)
* Faire un clic droit sur le D: et Supprimer le volume
* Faire un clic droit sur le C: et Etendre le volume (Tout par défaut)

## Rétablir Windows au démarrage | Windows

[Dual-boot : Supprimer Grub pour rétablir Windows au démarrage
](https://www.malekal.com/dual-boot-supprimer-grub-demarrage-retablir-windows/)
[Comment supprimer GRUB au démarrage de l'ordinateur
](https://www.youtube.com/watch?v=kZefIM7MDxo)

- [ ] Bios configuration| Redémarrer > Bios (F12) > OTHER OPTIONS > BIOS Setup > General > Boot List Option > Delete Boot Option (ubuntu sélectionné)

- [ ] Vérifier le mode du BIOS en UEFI

* Cmd (Admin)
* Vérifier la partition du PATH si elle pointe sur la partition UEFI ou la partition C pour le MBR

	Bcdedit /v
	
Nb. ou Information système > Résumé système > Environnement logiciel > Mode BIOS : Vérifier le Mode BIOS (UEFI ou hérité)

- [ ] Nettoyer les partitions

	Diskpart

Sélectionner disque 0

	Sel disk 0

Lister les partitions et sélectionner partition type Système

	List partition
	Sel partition x

Assigner lettre S et quitter diskpart

	Assign letter S
	Exit

Supprimer répertoire et sous dossier de Ubuntu

	S :                                        
	Cd EFI
	Dir
	Rmdir /s ubuntu

## Montage et démarrage par défaut de Windows | Linux

### Monter la partition Windows
[mount et fstab](https://doc.ubuntu-fr.org/mount_fstab)

Récupérer UUID

	sudo blkid

Editer le fichier fstab pour monter notre partition

	sudo nano /etc/fstab
	
	UUID=A894D78494D75382 /home/sam/Bureau/windows ntfs defaults 0 0

	mkdir /home/sam/Bureau/windows

Monter juste après la partion Windows

	sudo mount -a

> Pour monter un dossier partagé avec VBox
```sh
#C:\Users\sam\OneDrive\MyGame (MyGame)
sudo mount -t vboxsf MyGame ~/Bureau/MyGame/
```

### Démarrer Windows par défaut

Editer le fichier de configuration GRUB
	
	sudo nano /etc/default/grub

(GRUB_DEFAULT=0 -> GRUB_DEFAULT=2 signifie maintenant que l'on démarre sur Windows)

Appliquer les changements

	sudo update-grub