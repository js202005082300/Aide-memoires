# [13. Manipulation fichiers](https://www.youtube.com/watch?v=iIIE3s0FuiQ)

## touch
Créer un fichier (guillemets "" si espace dans le nom).
```bash
touch rapport.odt doc.txt
libreoffice Rapport.odt
gedit doc.txt
```
## mkdir
Créer un répertoire.

## cp
Copier un fichier.
```bash
cp rapport.odt /home/sam/Téléchargements
```

## mv
Déplacer un fichier et renomer un fichier.
```bash
mv ~/Téléchargements/rapport.odt ~/Bureau/ #~ = /home/sam
mv ~/Bureau/rapport.odt ~/Bureau/VersionFinalRapport.odt
```

## rmdir
Supprimer un répertoire vide.
```bash
mkdir empty full
touch full/texte.txt
rmdir empty #supprimer sans message d'avertissement.
rmdir full
    ...
	rmdir: impossible de supprimer 'full': Le dossier n'est pas vide
```

## ls
```bash
ls -R #afficher un dossier et son contenu.
ls -R full #afficher le contenu du dossier full.
```

## rm
Supprimer un fichier.
```bash
rm -R full #supprimer un dossier qui contient des fichier.
```
:warning: n'utiliser jamais la commande `rm` en super utilisateur root :lock: sinon vous risquer d'éliminer des fichiers du systèmes. Par défaut sur Windows, vous créer un profil administrateur donc attention.

:no_entry: `rm -R /usr` :no_entry:
```bash
rm -R /usr #rm descent dans le répertoire /usr protégé en écriture.
rm *.txt #supprimer tout les fichiers .txt.
rm *.* #supprimer tout type de fichiers.
```
## gedit
Editer.

## cat
Afficher le contenu d'un fichier.
```bash
cat test.txt
```