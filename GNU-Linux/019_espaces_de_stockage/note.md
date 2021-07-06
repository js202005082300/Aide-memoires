# [19. Espaces de stockage](https://www.youtube.com/watch?v=UDmLDYMwn7c)

## diff
Permet de comparer 2 fichiers.
```bash
diff file1.txt file2.txt
man diff
diff -a #comparaison en tant que fichier txt.
diff -i #ignorer la case.
```
## fdisk
```bash
sudo fdisk -l #lister les périphériques de stockages.
	...
	Périphérique Amorçage     Début       Fin  Secteurs Taille Id Type
	/dev/sda5    428005376 495116287  67110912    32G Système de fichiers Linux
	/dev/sdb1    *             2048 112918527 112916480  53,9G  7 HPFS/NTFS/exFAT

        #avec:
        #       /dev/sda5 = partition de mon système installé.  
		#       /dev/sdb1 = clé usb.  

cat /etc/fstab #points de montage.
	...
	/swapfile #monté à l'installation.
	
	UUID=d01d89de-dd26-49f8-89d9-65de6da984a1 / ext4 errors=remount-ro 0 1
	UUID=A894D78494D75382 /home/sam/Bureau/windows ntfs defaults 0 0
	
		#avec;
        #       UUID = identifiant unique dun périphérique.  
		#       / = chemin de montage de mon système.  
```
## blkid
Récupére les identifiants uniques.
```bash
sudo blkid #récupérer les identifiants uniques.
	...
	/dev/sdb3: LABEL="USB-SAM" UUID="4A72-5894" TYPE="exfat" PARTUUID="4c34e44c-03"
	
		#avec :
        #       /dev/sdb3 = chemin de montage.  
		#       UUID="4A72-5894" = identifiant unique.  

cat /etc/mtab #liste des montages qui ont bien été fait.
```
## mount
Monter un périphérique.
```bash
sudo mount /dev/sbd1 cleusb #monter la partition sur un nouveau point de montage.
sudo umount /dev/sdb1 #démonter la partition.
sudo mount /dev/sdd1 media/sam/cleusb
```
## du
Estimation de l'espace utilisé.
```bash
du Documents/ #estimation de l'espace utilisé des dossiers.
du -a Documents/ #estimation de l'espace utilisé de tout les fichiers.
```
## mkfs
Construire un système de fichier Linux.
```bash
sudo apt-get install exfat-fuse exfat-utils
sudo mkfs.exfat /dev/sdc1 #formater au format exfat.
sudo mkfs.exfat -n "USB-SAM2" /dev/sdc1 #spécifier un nom.
sudo mkfs.vfat -F 32 /dev/sdc1 -n "USB-SAM2"

	#avec :	
    #       mkfs.vfat = travailler sur un support fat.
	#		mkfs.exfat = travailler sur un support exfat (Windows).
	#		mkfs.ext3 = travailler sur ext ou ext3 (Linux).
	#		mkfs.ntfs = travailler sur ntfs.
```
> ***ext,ntfs,...*** sont des systèmes de fichiers qui définissent la manière dont sont gérées les données sur un support de stockage, comment elles sont gérées au niveau journalisation, intégrétité des données, récupération des données en cas de suppression, cohérence des données, gestion des erreurs éventuelles pour les fichiers corrompus, en cas de coupure d'électricité, ce genre de chose.