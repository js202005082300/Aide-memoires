# [11. Ligne commande (shell)](https://www.youtube.com/watch?v=DQeBbPsGoHY)

Shell = interprêteur de commandes  

|||
-|-
sh|shell pauvre en fonctionnalité, ancêtre de tout les Shell.
bash|shell plus riche en fonctionnalités. Plus répandu.
ksh|
zsh|shell plus récent mais non disponible en natif.
csh|shell basé sur le langage c.

Le lanceur d'Applications > "Utilitaires" > "Tilix".

"Tilix" > "menu latéral" > "Préférences" > "Codage" > vérifier le cochage de UTF-8 Unicode.

## Modifier le Profil

Le lanceur d'Applications > "Utilitaires" > "Tilix" > "menu latéral" > "Préférences" > "Par défaut" : "Nom de profil", "Apparence du texte", etc.

## Un peu d'histoire

Nommé le Terminal, la Ligne de commande, le Shell.

Un Shell est une application qui permet d'utiliser un certain langage qui va à son tour permettre de créer des script Shell.

Parmi tous les environnement graphique Budgie, Gnome, KDE, Cinnamon, etc, il existe plusieurs Shell.

Le SH, le Bash, le Ksh, le Csh, le Tcsh, le Zsh.

L'ancêtre de tous les Shells est le SH, disponible sur toutes les distributions de la famille Unix (Linux, MacOS, etc.). Il est très léger et disponible partout mais il manquait de fonctionnalités, ainsi d'autres Shell ont été créé.

Le Bash est né afin d'apporter plus de fonctionnalités. Ce Shell est le plus répandu. 

Le Zsh, est le plus récent (il puisse le positif dans tous les autres terminaux) mais il n'est pas très répandu.

Le Csh est basé sur le langage C au niveau de sa syntaxe.

Le plus souvent, on fait du 'Shell scripting' en bash.

Le lanceur d'Applications > "Utilitaires" > "Tilix". Le Shell est composé d'un prompt qui attend une commande dans une interface graphique (Tilix) mais on pourrait l'avoir sans interface graphique, en mode console.

Une commande, c'est le nom de la commande suivi d'une option précédée d'un ou deux tirets et terminée par des paramètres :

`gcc` : commande  
`main.c` : paramètre  
`-o` : option pour choisir le nom de l'exécutable  
`Prog` : paramètre qui est le nom de l'exécutable  