# [21. Éditeur mode console](https://www.youtube.com/watch?v=5IPkSVEYnXw)
nano
```bash
nano doc.txt #créer un fichier.
ctrl+X #quitter.
ctrl+O #enregistrer.
ctrl+G #Aide.
cat /etc/nanorc #fichier de configuration.
man nano
nano -B doc.txt #créer un fichier de la précédente sauvegarde (dox.txt~).
nano -l doc.txt #afficher le numéro de ligne.
nano -lB doc.txt
nano -L doc.txt #n'ajoute pas automatiquement une nouvelle ligne à la fin surtout si le fichier sert de fichier de données.
nano -m doc.txt #activer la souris (sudo apt-get install gpm).
nano -lL main.c
nano -E main.c #convertir les tab en espace.
nano -T 4 main.c #spécifier une taille de tab.
nano -i main.c #auto-indentation.
touch /home/sam/.nanorc #créer son fichier de configuration.
	set mouse #utiliser la souris par défaut (-m).
	set autoindent #auto-indentation (-i).
sudo nano /etc/nanorc #appliquer les changements sur le fichier de config global.
	#set autoindent #paramètre à décommenter.
```

### Vim

|||
-|-
i|insertion
:w|sauver
:q|quitter
:wq|(ou :x) sauver et quitter
:q!|quitter et annuler
/texte|(ou ?texte) rechercher texte
n|occurence précédente
N|occurence suivante
:%s/ancien-mot/nouveau-mot/g|remplacer ancien-mot par nouveau-mot