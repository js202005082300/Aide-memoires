# [3. Installer l'interpréteur](https://www.youtube.com/watch?v=0vS3fOkAbPs)

Dans cette séance #3 de PHP, nous allons passer à l'installation de PHP qui est le but de cette formation.

Dans la séance précédente, nous nous sommes occupé de l'installation du serveur HTTP Apache.
	
Nous récupérons directement le nécessaire par rapport à l'outil que nous avons besoin.
	
La première chose à faire est d'aller chercher l'archive de PHP. On va sur https://windows.php.net/

Nous verons la manipulation pour GNU-Linux.

On se rend sur la section Download sur https://windows.php.net/download/
	
On retrouve ainsi tout un tas de liens par rapport à ça. 

Ensuite logiquement, on a téléchargé les redistribuables avec Apache, nous avions vu que ça allait être utile avec l'installation de PHP.

Nous allons ainsi prendre le version le plus à jour et pour cette formation il est recommandé de prendre la version 7 parce que nous utiliserons dans cette formation, certaines choses de PHP 7. Si on est en version 5, nous aurons des erreurs dans notre code, ça ne fonctionnera pas.

Donc, il faut prendre au minimum la version 7.0, voir la 7.2 au moment où l'on regarde la vidéo pour prendre la même version.

Il faut donc prendre la bonne archive. Il faut prendre la version Thread Safe, c'est super important, on ne fait pas de CGI (Common Gateway Interface) dans cette formation.

Tout ces termes un peu compliqué seront expliqués plus tard.

Nous sommes en démarrage sur la formation PHP donc on va rester sur des choses pour l'instant.

Il faut prendre simplement la version Thread Safe.

Toujours pareil, on prend en fonction de notre système, si c'est du 32 bits, on prend la x86 : *VC15 x86 Thread Safe (2020-May-12 15:28:51)*
	
Et si on a la version x64 bits sur notre système, on prend la version suivante : *VC15 x64 Thread Safe (2020-May-12 15:28:43)*

Il faut récupérer le zip : *php-7.4.6-Win32-vc15-x64.zip*. Vérifier avoir la version x64 pour la dernière version.

On décompresse et on obtient un répertoire avec tout l'ensemble des fichiers.

On renome ce répertoire /php7.4.6 (/php) que l'on installe sur le disque local C à proximité, côte-à-côte de mon répertoire /Apache24 (/apache) qu'on avait installé dans la vidéo précédente.

## Configuration

### Renommage

Une fois l'installation, il faut procéder à quelques petites configurations parce que évidemment PHP ne fonctionnera pas tout seul. Il s'agit pour le coup de l'interprêteur, ce qui va permettre de lire les fichiers PHP et de pouvoir les exécuter, les interprêter.

Par contre, comme on utilise un serveur HTTP en particulier, il est bien d'installer un module, de charger un module de PHP pour pouvoir l'utiliser directement dans Apache c'est-à-dire notre serveur.

On se rend dans le répertoire de /php7.4.6 (/php), on retrouve un ensemble de fichiers .ini. Il y en a deux :
```txt
	php.ini-development
	php.ini-production
```
Si on était en train de faire un serveur dédié, quelque chose qui est amené à produire un site qui serait en ligne, évidemment il faurait prendre la version production.

Comment différencier les versions ? Une version en production, c'est un site qui va évidemment être en ligne, visible pour le public où l'on va par exemple masquer l'affichage des erreurs. On a pas envie qu'un pirate puisse comprendre les erreurs qu'il y a éventuellement dans un script pour pouvoir les exploiter.

Nous, on est dans un cas d'apprentissage pour un travail en local. Tout ce qui est en local ne va être accessible que pour nous donc on peut laisser en développement. Donc on va laisser s'afficher les erreurs ou autre pour développer notre site web. Donc on va travailler sur *php.ini-development* et on va le renommer en laissant juste *php.ini*.

Pour rappel, il faut que notre système affiche les extensions des fichiers, sur Windows c'est important.

On doit voir leurs extensions .dll, .txt, etc. Si on ne les voit pas, c'est qu'on a pas les extensions affichées sur notre système. Il faudra le faire dans panneau de configurations dans paramètres, dans les options des dossiers, on a un onglet affichage ou autre et on peut décocher la ligne "masquer l'extensions des fichiers dont le type est connu...". Ceci est un petit rappel, il faut vraiment afficher les extentions sur notre système surtout si on programme sur Windows.

Voilà pour le renommage de ce répertoire.

### Couper php.ini

On prend ce php.ini qu'on va déplacer.

On coupe php.ini et on va le mettre dans le répertoire racine d'Apache : *.\MyWAMP\apache\php.ini*

Si on ne fait pas ça, on risque d'avoir de petit problème par la suite.

### Copier php7ts.dll

Il nous faut maintenant la dll sinon ça ne fonctionnera pas.

On va tout simplement dans le répertoire de PHP afin de récupérer *php7ts.dll*

Si on utilisait une version autre comme la 5, ça s'appelera *php5ts.dll*.

Il suffirait de remplacer le 7 par un 5, ou la version exacte 5.6 par exemple pour que cela foctionne.

Mais comme il a été recommandé de travailler sur la version 7, normalement on est paré.

Ici il ne faut pas le déplacer complétement, il faut juste le copier dans le dossier bin d'apache.

Ainsi il sera a deux endroit.
```txt
	.\MyWAMP\php\php7ts.dll
	.\MyWAMP\apache\bin\php7ts.dll
```
Il est donc à la fois dans *MyWAMP\apache\bin\* directement à la racine du répertoire de *\php*.

Normalement on a fait tout ce qu'il faut, on a déplacer le fichier de configurations de PHP, le *php.ini* qui va servir à beaucoup de choses. On a la petite bibliothèque, la .dll *php7ts.dll* qui est à copier et non à déplacer.

### Editer httpd.conf

Maintenant on édite le fichier *.\MyWAMP\apache\conf\httpd.conf* et à partir de là, on va avoir des choses à ajouter, ici à la fin du fichier. On écrira les commentaires en commencant par un dièse comme ça, il n'est pas prit en compte à l'interprêtation.
```conf
	# PHP 7
	AddHandler application/x-httpd-php .php
```
La première chose que l'on va faire, c'est `AddHandler` mais nous ne rentrerons pas dans les détails tout de suite. On va juste spécifier un type de fichier au niveau des extensions "application/x-httpd-php .php", il faut bien respecter les minuscule, les majuscules. En informatique, en programmation c'est toujours super important. Voilà pour le gestionnaire.
```conf
	# PHP 7
	AddHandler application/x-httpd-php .php
	AddType application/x-httpd-php .php .html
```
On s'occupe maintenant du type de fichier. On va dire qu'on va avoir un type et qu'on se base plus 
exactement sur le type mine, c'est-à-dire, pas juste sur l'extension mais pour dire le type PHP.

Qu'elle sera l'extension de fichier qui correspond ? on aura les .php, il faudra créer des fichiers
*.php* et pareil si on crèe des fichiers .html, évidemment, il pourront être exécuté avec PHP.

On aura des fois juste des fichiers HTML et on aimerais que ça fonctionne sur notre site.
```conf
	# PHP 7
	AddHandler application/x-httpd-php .php
	AddType application/x-httpd-php .php .html
	LoadModule php7_module "c:/MyWamp/php/php7apache2_4.dll"
```
Ensuite, on change de module, ça c'est super important avec `loadmodule`. On met `php7_module`, ça c'est pour la version, on va avoir un lien à préciser qui est un lien vers une dll en particulier mais pas n'importe laquelle.

On va dans le répertoire PHP et là on a php7apache2_4.dll, 2_4 parce que c'est le Apache que l'on a installé, avec la version 7, on est sûr d'avoir la bonne version d'Apache.

On écrit le lien avec le `c:` en minuscule pour une question d'homogénéité et on transforme les anti-slashs en slash pour ne pas faire d'erreur de copie, on fait un copier-coller de tout pour ne pas se tromper.

Donc le module c'est `php7apache2_4.dll`, c'est pareil à une bibliothèque DLL. Il porte le nom appache parce que c'est un module d'apache permettant d'utiliser PHP 7.
```conf
	# PHP 7
	AddHandler application/x-httpd-php .php
	AddType application/x-httpd-php .php .html
	LoadModule php7_module "c:/MyWamp/php/php7apache2_4.dll"
	PHPIniDir "c:/MyWamp/apache"
```
Une fois que le module est là.

Le petit plus `PHPIniDir` qui permet de précisser le répertoire de base de PHP. Il est recommandé de le mettre.

On met le répertoire d'appache `c:/MyWamp/apache`, en mettant un c minuscule.

Pas besoin d'autres lignes, on a tout. On a spécifier le type. On a vu pour le module `LoadModule`, cette ligne est vraiment importante. `AddType` est vraiment utile aussi. `PHPIniDir` est facultative.

Comme ça on pourra gérer tout ce qu'il nous faut.

Il existe d'autres configuration avancé que l'on pourrait faire mais pour ce que l'on va faire ce sera faire.

### Vérifier l'installation

On lance *.\MyWAMP\apache\bin\httpd.exe* en espérant ne pas avoir fait d'erreurs en espérant ne pas avoir fait d'erreurs à l'installation. 

### Créer un premier fichier PHP

On se rend sur *.\MyWAMP\apache\htdocs* pour créer notre premier fichier PHP. On crée notre fichier index.php.

Logiquement si on a bien associé l'extension au type mine PHP, ça devrait aller.

On crée un code très simple :
```php
	<?php
	echo "Hello";
```
On ne ferme pas la balise PHP, ce n'est pas obligatoire. On vera cela par la suite.

On fait ensuite localhost dans le navigateur.

rem. si on crée notre fichier, il faut redémarrer le serveur pour prendre en compte les changement.

On pourrait faire un reload.

Le "Hello" est ainsi bien interprêté.

Dans le navigateur, on n'a pas de code PHP affiché comme la dernière fois lorsqu'on avait pas d'interprêteur.

Pour que le navigateur gère le index.php, c'est pourquoi il faut lui préciser le répertoire racine par la suite.

Mais on peut le faire dans la prochaine séance, l'important est vraiment d'installer PHP.

On verra que pour par défaut que comme pour le HTML, qu'on lui précise pas de fichier.

On le voit lorsqu'on a un site en ligne, quand on ne précise pas le nom du fichier, il nous le charge automatiquement un fichier `index.<quelque chose>`. 

Normalement on ne devrait pas afficher cela :
```txt
Index of/
	* index.php
```
Il devrait nous afficher directement index.php.

Dans la prochaine séance nous configurerons un peu plus ce fichier de configurations avant de commencer à programmer.

Là il s'agissait de le télécharger, de l'installer et de le configurer pour que ça fonctionne.

## Linux

Linux c'est encore plus rapide.

C'est comme beaucoup d'outils de développement, on va beaucoup plus vite sur Linux que sur Windows.

Pour Apache, on a vu qu'il suffisait juste de télécharger un fichier mais pour l'interprêteur, il faudra un peu plus de chose quand même.

On commence l'installation en ligne de commande parce que c'est le plus rapide.

Attention il faut écrire :
```bash
sudo apt-get install php
```
Selon notre distribution, c'est PHP7 qu'on va avoir comme ça.

Il est possible que sur des distributions moins connues, moins populaires, il soit encore à PHP 5 mais logiquement sur Ubuntu, la version actuel, on doit être su PHP 7. Ca doit être à jour maintenant.

Donc il suffit d'installer juste le paquet PHP. 
```bash
sudo apt-get install php libapache2-mod-php
```
Ensuite on va installer le module.

C'est important d'ajouter comme ça `libapache2-mod-php`, sinon ça ne fonctionnera pas. On aura que PHP en ligne de commades et nous on veux que ca fonctionne directement avec notre serveur pour pouvoir créer des sites sinon on aura des petit soucis.

On accepte le chargement des fichiers (o/n).

On ne regarde pas tout mais il semblerait que dans les versions récentes, il ne propose plus les paquets pour gérer le XML, si toute fois un jour on en a besoin, on verra comment faire l'installation.

Tout ce qui manque sur la formation, on l'installera si il manque. Généralement, on ne connaît pas par coeur ce qu'installe `sudo apt-get install php`. Comme il y a beaucoup de changement, très souvent, on ne peut pas connaître par coeur ce qui est gardé ou non. Si il manque quelque chose on le verra.

Si par exemple on a un jour besoin de travailler sur un certin type de fichier et que ça ne marche pas, suivant l'erreur qui sera indiqué, il suffira d'installer le bon paquet, le bon module éventuellement.

A partir de là, on a déjà tout installé. Ce qui est très rapide.

On va maintenant pour éventuellement modifier des fichiers.

Où sont présenté ces fichiers là ?

Le fichier php.ini est dans : */etc/php/7.2/apache2/php.ini*
	
/etc est le répertoire des fichier de configurations pour Linux.

La version actuellement présente est la *7.2*.

Pour les prochaines vidéos, on programmera sur Windows, on ne ferra pas ça en virtualisé.

Pour la suite, on verra comment éditer ce fichier `php.ini` mais actuellement on a vu où il se trouvait.

Au niveau de Apache, si on veut le fichier de configuration, on va dans : */etc/apache2/mods-available/php7.2.conf*

On en a pas parlé dans la vidéo précédente mais il faut aller dans */etc/apache2/mods-available/* et dedans, on doit avoir un fichier PHP pour la configuration.

### Editer php7.2.conf

Il y a des choses dans ce contenu qui vont nous servir.

On aimerais afficher les erreurs de PHP.

On ajoute en fin de fichier : `php_value display_errors on`

Bien faire attention `errors` prend un `s`. Ca ça va toujours permettre d'afficher les erreurs de PHP dans notre navigateur quand il y aura une erreur de script.

Ici, on est en développement en local donc pas de soucis, on pourra le faire.

Néanmoins, il faut faire attention que le fichier est en lecture seul vu qu'on a pas les droits.

Il faut faire simplement :
```conf
sudo vim /etc/apache2/mods-available/php7.4.conf #A ce jour, la bonne version est 7.4
i			(insertion)
:w			(sauver)
:q			(quitter)
```
C'est bon pour ce fichier.

### Editer php.ini

On édite ensuite le fichier php.ini :
```bash
sudo vim /etc/php/7.4/apache2/php.ini
/etc/php/7.4/apache2/php.ini
```
On se sert pas mal du `display_errors` et du `error_reporting`.

On commence par rechercher le `display_errors` (ligne 482).
```php
display_errors = On
```
Le O de `Off` est en majuscule, c'est important.

Nous lui applique juste `On`.

Ensuite on édite `error_reporting` (ligne 465).
```ini
error_reporting = E_ALL & -E_DEPRECATED & -E_STRICT
--> error_reporting = E_ALL
```
`E_ALL` est la valeur par défaut. Il ne faut pas oublier le underscore.

On sauve et on quite 
```bash
:x
```
Et voilà c'est tout.

### Vérifier l'installation

Au niveau du service :
```bash
	sudo systemctl start apache2 
```
On démarre (ou redémarre) notre Apache.

Ici on avait désactiver le service au démarrage dans la séance précédente.


### index.html -> index.php

On va dans *var/www/html/* et on renomme index.html en index.php.

*rem. Avant de rafraichier la page, il faudra redémarrer le serveur.*

On fait pareil à Windows, on édite *var/www/html/index.php* :
```php
	<?php
	echo "Hello";
```
On redémarre le service :
```bash
	sudo systemctl restart apache2
```
On retourne au navigateur et on fait le fameux localhost.

Et là, il trouve directement mon fichier index.php

Linux est quand même plus pratique à ce niveau là. Il fait les choses plus rapidemment.

Si on vérifie le code source, on ne voit pas le code PHP, on voit juste ce qu'il y a en sortie.

Ainsi PHP est installé sur notre serveur Apache et fonctionnel.

Logiquement que l'on soit sur Windows ou sur Linux, ça fonctionne.

Pour MacOS voir d'autres documentations ou de tutos à ce sujet d'autant qu'il y a pas mal d'outils pré-installés.

Dans la prochaine vidéo, on va commencer à configurer pour ne pas ralonger cette vidéo.

Ici on s'arrête sur l'installation et ensuite, on verra des choses un peu plus avancés.

On verra des petites choses concernant le serveur HTTP et PHP.

On ferra de la configuration de l'environnement afin de comprendre les choses nécessaire que l'on peut éditer et modifier au niveau de notre environnement de développement.

Dans la séance encore d'après, on rentrera dans la programmation PHP pour créer nos sites web.