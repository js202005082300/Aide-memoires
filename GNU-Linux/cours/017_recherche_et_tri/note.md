# [17. Recherche et tri](https://www.youtube.com/watch?v=Kl242W57-PU)

## whereis
Recherche.
```bash
whereis python #recherche associé à python.
whereis ls #recherche l'exécutable de la commande ls.
```

## mlocate
mlocate.db est une base de données qui indexe l'ensemble des fichiers.
```bash
sudo apt install mlocate
ls /var/lib/mlocate
locate
locate python #recherche sur le fichier mlocate.db.
sudo updatedb #mise à jour de la base de données.
```

## find
Recherche.
```bash
find -name "fic.txt"
find / *.conf #recherche les .conf dans tout le système.
find / *.conf > out.txt #stocker le résultat dans un fichier.
find -type d -name "icon" #recherche les fichiers de type répertoire.
find -type f -name "icon" #rechercher les fichiers de type fichier.
find / -type d -name "icon" #rechercher sur la partie système.
find /home -size +5M #rechercher les fichiers supérieur à 5mb dans le répertoire home.
find %HOME -size +5M #rechercher les fichiers supérieur à 5mb dans le répertoire home.
man find
find Images -type d -name "Wallpapers" #rechercher un répertoire Wallpapers.
find /home/sam -name "*.txt" #rechecher fichier txt dans le Dossier personnel.
```

## grep
Extraire et filtrer les données.
```bash
grep Bonjour fic.txt #rechercher un mot dans un fichier.
grep -n bonjour fic.txt #rechercher un mot et son numéro de ligne.
grep -r #rechercher dans plusieurs fichiers récursivement.
grep -n -i Bonjour fic.txt #rechercher sans tenir compte de la case.
grep -E ^h fic.txt #rechercher tout les mots qui commencent par un h.
        #^h = expression rationnel.
grep -E ^h -n fic.txt
grep -E ^b -n -i fic.txt
man grep
grep -E ^h -n fic.txt > res.txt
```

## sort
Trier les informations par ordre alphabétique.
```bash
sort fic.txt #trier dans l'odre croissant.
sort -r fic.txt #trier dans l'ordre décroissant.
sort -n fic.txt #trier les nombres.
sort -R fic.txt #trier de manière aléatoire (Random).
sort fic.txt > res.txt #rediriger vers un fichier avec flux de redirection.
sort fic.txt -o out.txt #rediriger vers un fichier sans flux de redirection.
sort -o out.txt fic.txt
grep -E ^h fic.txt | sort #trier les données extraite.
```

## uniq
Retirer les doublons sur un fichier trié.
```bash
uniq out.txt #retirer les doublons d'un fichier après {sort fic.txt -o out.txt}.
uniq out.txt > res.txt
uniq -c out.txt #donne le nombre d'occurence.
uniq -d out.txt #retourne les doublons.
```

## wc
Retourne des infos sur le fichier.
```bash
wc fic.txt #nombre de lignes, de mots et d octets.
	 	...
        7  7 40 fic.txt
	 	    #7 = nombre de lignes.
	 		#7 = nombres de mots.
	 		#40 = nombre d'octets.
wc -l fic.txt #nombre de lignes.
wc -w fic.txt #nombre de mots.
wc -c fic.txt #nombre d'octets.
```

## cut
Couper une chaîne.
```bash
grep -n -E ^a fic.txt | cut -d : -f 1 #retourne le contenu de la colonne 1 délimité par :
grep -n -E ^a fic.txt | cut -d : -f 2 #retourne le contenu de la colonne 2 délimité par :
cut -c 1-3 fic.txt #retourne les 3 premiers charactères de chaque mot.
```