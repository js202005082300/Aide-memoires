# Regedit

[Ajouter des entrées au menu contextuel Nouveau de Windows 10](http://www.nonoweb.net/ajouter-entrees-menu-contextuel-nouveau-windows-10/)
[Sauvegarder et restaurer la base de registre de Windows](https://www.lecoindunet.com/sauvegarder-restaurer-base-registre-windows-1254)
* Ouvrir regedit.exe
* Cliquer sur l'icône Ordinateur
* Fichier > Exporter > Enregistrer un fichier .reg
* Fichier > Importer > sélectionner un fichier .reg

[Rétablir l’élément « Nouveau document texte » du menu contextuel Windows](https://www.lecoindunet.com/retablir-lelement-nouveau-document-texte-du-menu-contextuel-windows-1807)
* Ouvrir regedit.exe
* développer le dossier HKEY_CLASSES_ROOT 
* rechercher ou créer la chaîne .txt
* Les valeurs des clés sont :
	- Default = txtfile
	- Content Type = text/plain
	- PerceivedType = text
* Ajouter la sous-chaîne ShellNew et les clés :
	- La valeur de type chaîne NullFile reste vide
	- La valeur de type chaîne extensible ItemName contient : @%SystemRoot%\system32\notepad.exe,-470