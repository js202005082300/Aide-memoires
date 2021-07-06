# [18. Archivage et compression](https://www.youtube.com/watch?v=0VyUecw1CQA)

## tar
Archivage sans méthode de compression.
```bash
tar -cf archive.tar fic.txt out.txt  #créer une archive tar.
tar -tf archive.tar #lister le contenu de l'archive.
tar -xf archive.tar #extraction d'une archive.
tar -cvf archive.tar fic.txt out.txt #créer une archive et lister.
```

## zip
Compression.
```bash
zip out.zip fic.txt out.txt #créer l'archive.
unzip out.zip #décompresser.
zip out.zip main.c #ajout à l'archive.
zip -d out.zip main.c #retirer de l'archive.
zip out.zip -0 fic.txt #archive sans compression.
zip out.zip -9 fic.txt #archive avec compression max.
zip out.zip -Z deflate fic.txt #mode de compression par défaut.
zip out.zip -Z bzip2 fic.txt #mode de compression bzip2.
zip -r out.zip dossier #archiver un dossier.
zip -T out.zip #vérifier l'intégrité des fichiers.
zip -e out.zip fic.txt out.txt #protéger le fichier.
```

## rar
Compression (non recommandé).
```bash
sudo apt install rar
rar a out.rar main.c datas.txt #créer.
sudo apt install unrar
unrar x out.rar #extraire.
rar t out.rar #vérifier l'intégriter des fichiers.
rar r out.rar #réparer une archive.
rar d out.rar main.c #supprimer fichier d'une archive.
```

## gzip
Compression forte.
```bash
gzip archive.tar #compresser après {tar -cf archive.tar datas.txt main.c}
tar -zcf archive.tar.gz datas.txt main.c #2 en 1 commande.
gunzip archive2.tar.gz #décompresser.
```

## bzip2
Compression forte.
```bash
bzip2 archive.tar
tar -jcf archive.tar.bz2 ./* #bziper tout le répertoire courant.
bunzip2 archive.tar.bz2
```

## zcat
Lister le contenu.
```bash
zcat archive.tar.gz
```