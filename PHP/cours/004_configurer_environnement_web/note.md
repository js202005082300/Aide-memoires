# [4. Configurer environnement web](https://www.youtube.com/watch?v=rSd7NZfhjZg)

Bonjour tout le monde, dans cette vidéo numéro 4, on continue un petit peu avec les prérequis.

Tout ce qui concerne notamment l'installation et la mise en place de notre environnement dans cette vidéo pour lequel nous allons pas voir énormément de choses. 

Nous allons simplement passer en revue les différents paramétrages et configuration que nous avons fait, également affiner certains paramètres et certaines options par rapport à notre environnement pour avoir quelque chose qui soit complètement configuré et surtout fonctionnel pour la suite des vidéos parce que dans la séance prochaine, nous allons découvrir tout simplement la découverte du PHP ce langage de programmation qui va vous permettre de créer vos futur site web. 

On va commencer avec la partie Windows, pour ceux qui sont sur Windows. Pour ceux qui sont sur Linux vous savez que je le fais après. 

Vous pouvez de toute façon regarder cette section là je pense que ça vous servira si un jour vous avez l'occasion d'avoir Windows ou alors pour d'autres si vous utilisez simplement les 2 systèmes d'exploitation. 

On va directement aller dans notre répertoire de configurations.

Entre temps, entre les 2 vidéos là, j'ai re changé un petit peu le chemin pour Apache et PHP. Vous savez que dans la vidéo précédente, ils étaient séparés dans le répertoire disque local c côte à côte et là je fais en fait un répertoire MyWAMP tout simplement et je les ai mis à l'intérieur.
```txt
	MyWAMP:.
	+---apache
	|   |   php.ini
	|   +---bin
	|   |   |   httpd.exe
	|   |   |   php7ts.dll
	|   +---conf
	|   |   |   httpd - Copie.conf
	|   |   |   httpd.conf
	|   +---htdocs
	|   |   \---cours
	|   |       +---001_introduction
	|   |       +---002_installer_serveur      
	|   |       +---003_installer_interpr‚teur
	|   |       +---004_configurer_environnement_web
	|	|		|       index.php		
	\---php
			php-7.4.7-Win32-vc15-x64.zip
			php.exe
			php.ini-production
			php7apache2_4.dll
			php7ts.dll
			...
```		
Donc j'ai bien évidemment dans la configuration changer les chemins pour que ça fonctionne donc j'ai juste fait du changement de chemin sinon tout le reste n'a pas bougé par rapport à la dernière fois. 

On va … et là je fais un petit rappel rapide au niveau de la vidéo .. on va revoir les configurations bon voilà pour Apache il s'agit sur Windows de httpd.conf et pour PHP il s'agira … mais ça on le verra après … du fichier php.ini.

On va aller ici, on va l'ouvrir et on va revérifier qu'on a bien fait le paramétrage comme il faut et rajouter éventuellement quelques petites choses, quelques petites options.

+ .\MyWAMP\apache\conf\httpd.conf

Le serveur serverRoot, évidemment j'ai changé le chemin comme je l'avais dit donc ça on vérifie effectivement que le chemin est correct mais de toute façon vous verrez tout de suite en testant le fonctionnement du site web. 
```conf
	Define SRVROOT "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	ServerRoot "${SRVROOT}"
```
On écoute bien sûr le port 80 puisqu'on est en http. 
```conf
	Listen 80
```
Si éventuellement plus tard, on voulait être en https, on passerait en 443 mais là pour le coup on va rester sur quelque chose de simple. 

Au niveau des menus, on n'avait pas touché sauf exception pour le module mod_rewrite qui permettra de faire de la ré écriture dont on va se servir pas mal par la suite et je vous avait dit que vous pouviez le dé commenter voilà.
```conf
	LoadModule rewrite_module modules/mod_rewrite.so
```
Après inutile de décommenter autre chose, si vous ne les utilisez pas, ça ne sert à rien de les charger pour rien inutilement ça ne ferait qu alourdir, de réduire les performances au niveau de votre serveur. 

Ca on n'y avait pas touché parce que ce n'était pas intéressant pour le ServerAdmin parce que ça nous intéresse pas parce que je rappelle qu'on va travailler en local donc pas de souci. 
```conf
	ServerAdmin admin@example.com
```
Du coup le ServerName, là c'était intéressant de bien avoir des décommenter et de mettre localhost pour être sûr.
```conf
	ServerName localhost
```
Et à partir de là nous allons avoir quelques options à vérifier qu'on n'a pas forcément regarder de près dans les vidéos précédentes. 

Ici vous voyez que vous avez un fonctionnement de balise d'accord.
```conf
	DocumentRoot "${SRVROOT}/htdocs"
	<Directory "${SRVROOT}/htdocs">
```
On retrouve ici la balise Directory avec le chemin vers mon répertoire `htdocs` qui va accueillir mes site web. Il se termine ici `>` parce que c'est une balise fermante à cet endroit là. 

Et vous avez ensuite quelques options ici on voit qu'on en a 3. 
```conf
	<Directory "${SRVROOT}/htdocs">
		Options Indexes FollowSymLinks
		...
		AllowOverride None	
		...
		Require all granted
	</Directory>
```
3 lignes qui ont été spécifiées à l'intérieur.

Alors ils ont mis beaucoup de commentaires, c'est l'avantage du fichier de configuration. Comme vous le voyez il y a beaucoup de commentaires donc il est vraiment plutôt bien expliqué mais je vais vous montrer dans le détail tout ça évidemment, à quoi ça sert et qu'est-ce qui peut être intéressant à être désactivé ou activé ou configuré en fonction. 

La première partie ici ce sont les options, les options vont pas mal servir on niveau du fonctionnement de notre serveur.

## Options Indexes FollowSymLinks 

Les options sont définies ici.
```conf
    # Possible values for the Options directive are "None", "All",
    # or any combination of:
>   #   Indexes Includes FollowSymLinks SymLinksifOwnerMatch ExecCGI MultiViews
```
Dans notre fichier de configuration principal pour Apache, il suffira tout simplement de mettre le nom en question (Includes…) donc vous pouvez mettre tous les noms si vous voulez pour dire tout simplement d'activer ces options là. 

Donc là on voit par défaut que j'ai 2 options d'activer `Indexes` et `FollowSymLinks`.

`Indexes` c'est pas mal à connaître c'est pour ça que je vais vous en parler, ça va permettre tout simplement de lister le contenu d'un répertoire si le serveur ne trouve pas de fichier d'index. Vous avez vu par exemple pour HTML, on va faire un index.html. Pour PHP, on va faire un index.php ou éventuellement un autre nom qu'on aura choisi, on pourra voir ça par la suite pourquoi pas pour dire que tel nom de fichier tel extension, on considère que c'est ce qu'on appelle un fichier d'index donc en fait un fichier d'entrée, de démarrage pour notre site. 

Si le serveur ne trouve pas un de ces fichiers là (Indexes) par rapport à une liste qu'on aura définie mais on va le voir juste après de toute façon. 

Il va lister les répertoires alors par défaut quel va être le comportement. Alors vous allez le voir rapidement. 

Alors on va créer plein de choses, je ne vais pas mettre de index.php, je vais mettre par exemple truc.php c'est un peu bizarre mais peu importe. On va mettre un document. On va mettre un fichier texte info.txt donc je mets des noms avec plusieurs extensions même si c'est pas des vrais fichiers d'accord mais c'est vraiment pour vous montrer (doc.pdf, et cetera) voilà je fais n'importe quoi et puis dans inc, je vais mettre index.html parce que c'est effectivement intéressant de le faire pour que vous voyiez un petit peu la différence et pourquoi pas mettre un code dedans dans lequel je mets rapidement quelque chose pour que vous voyiez un exemple.
```txt
	test:.
	│   doc.pdf
	│   infos.txt
	│   truc.php
	│
	└───inc
			index.html
				<!DOCTYPE html>
				<html lang="en">
				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width initial-scale=1.0">
					<meta http-equiv="X-UA-Compatible" content="ie=edge">
					<title>Document</title>
				</head>
				<body>
					<p>hello</p>
				</body>
				</html>
```
On va lancer le serveur pour que vous voyez un petit peu évidemment ce que ça donne, et on va regarder. Alors par défaut, l'option Indexes est activé d'accord, on l'a noté.
```powershell
	.\MyWAMP\apache\bin\httpd.exe
```
Donc là sur la racine de notre site donc le fameux répertoire htdocs je rappelle à cet endroit ici. 
```txt
	Index of /PHP/cours/004_configurer_environnement_web/test

		Parent Directory
		doc.pdf
		inc/
		infos.txt
		truc.php
```
Voyez qu'on est ici à la racine du site dans lequel il n'y a aucun fichier index.html, index.php ou je ne sais quoi, du coup comme l'option est activée, elle va lister le contenu de mon répertoire donc voyez qu'on retrouve le fameux fichier .pdf, le fichier .txt, le fichier truc.php pour le coup qui n'est pas un fichier d'index et inc (include). Si je vais dans inc, étonnamment là le fichier se lance. 

Effectivement il a trouvé un fichier index donc là pas de souci, il interprète et le serveur arrivé à exécuter le HTML donc c'est interprété et c'est lu directement dans le navigateur. 
```txt
	http://localhost/PHP/cours/004_configurer_environnement_web/test/inc/
	hello
```
Par contre ici il y en a pas donc ça nous liste.
```txt
		doc.pdf
		inc/
		infos.txt
		truc.php
```
Donc ça nous liste. 

Alors dans certains cas ça peut être utile d'avoir ça (liste) par contre plus tard il est possible que vous fassiez des architectures de site web assez complexe et assez particulière et vous n'aurais pas envie que les gens puissent lister le contenu des répertoires. 

Voilà dans certains cas ça ne sera pas voulu donc évidemment en fonction de ça, il faudra penser à retirer cette option donc si vous ne voulez pas qu'on puisse lister le contenu des répertoires, vous ne la mettez tout simplement pas.

+ .\MyWAMP\apache\conf\httpd.conf
```conf		
	Options Indexes FollowSymLinks
	--> Options FollowSymLinks
```
Et qu'est-ce qui va se passer à ce moment-là ?

Je vais relancer Apache bien sûr parce que c'est important voilà.

Voilà on va retourner … comme je n'ai pas fait un service je suis obligé de relancer à chaque fois l'exécutable parce que je ne voulais pas en faire un service Windows comme ça c'est plus pratique pour moi. 
```powershell
	.\MyWAMP\apache\bin\httpd.exe
```
Et là je vais réactualiser et voilà ce qui se passe.
```txt
	http://localhost/

	Forbidden

	You don't have permission to access this resource.
```
On nous met automatiquement un forbidden comme quoi vous n'avez pas la permission d'accéder à ce serveur. 

Par contre si je précise le dossier inc.
```txt
	http://localhost/PHP/cours/004_configurer_environnement_web/test/inc/
	
	hello
		
		[Code source de la page]
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width initial-scale=1.0">
			<meta http-equiv="X-UA-Compatible" content="ie=edge">
			<title>Document</title>
		</head>
		<body>
			<p>hello</p>
		</body>
		</html>
```
Si je fais un inc, vous voyez qu'on arrive quand même à revenir sur le fameux fichier index.html du répertoire inc d'accord donc tant qu'on trouve un "index" ça va.

Par contre si on ne trouve pas d'index, on cache, masque le listing donc le contenu du répertoire donc ça peut être intéressant à savoir. C'est une option qui est à connaître en tout cas. 

Les Includes, je passe pour le moment, ça ne nous intéresse pas. 

Les FollowSymLinks, vous pouvez la laisser c'est pour tout ce qui est lien symbolique donc ça en général on la laisse parce qu'elle ne pose pas en général de problème. 

Et MultiViews pareil on en reparlera par la suite donc voilà. Je n'insiste pas pour le moment là-dessus donc évidemment on reviendra dessus. 

En tout cas renseignez vous un petit peu sur ces options éventuellement même s'il y en a qu'on va revoir de toute façon au cours de la formation pour voir lesquels il faut activer ou non. 
```conf
    # Possible values for the Options directive are "None", "All",
    # or any combination of:
>   #   Indexes Includes FollowSymLinks SymLinksifOwnerMatch ExecCGI MultiViews
```
Le principe c'est que le fichier de configuration principale (httpd.conf) possède toutes les règles et les options que vous voulez définir, et que vous n'ayez pas ensuite aller sur charger ou les modifier directement de votre site web d'accord. 

Normalement dans l'idéal on devrait tout paramétrer dans httpd.conf et pas ailleurs, vous verrez que par la suite on utilisera ce qu'on appelle des fichiers htaccess (pour hypertext access) … on va d'ailleurs procéder à leur activation dans cette vidéo mais dans l'idéal et Apache le recommande, on ne devrait pas avoir besoin ou en tout cas ne pas utiliser de fichier htaccess parce que les fichiers htaccess vont venir écraser la configuration globale et c'est évidemment déconseillé. 

On devrait normalement tout définir là, httpd.conf et c'est tout donc paramétrer tout bien à la base toutes les options que vous voulez ou celle que vous ne voulez pas et comme ça vous aurez quelque chose qui est fonctionnel et qui est correctement configuré par rapport à ce que vous voulez au niveau de votre environnement web donc ça c'est important pour les options. 

Alors justement comment on parlait des fameux fichiers *.htaccess*, cette option là.
```conf
    AllowOverride None
```
Cette option est intéressante si on veut utiliser ces fameux fichiers *.htaccess* donc ils auront un point au début. Ces fameux fichiers si jamais on en a besoin parce que vous verrez que ça peut être utile dans certains cas, c'est bien de les connaître. 

Il va falloir autoriser justement et on vous le dit d'ailleurs, il va falloir autoriser AllowOverride c'est-à-dire donc le fait d'écraser, de surcharger en fait, des configurations via ce type de fichier.

Par défaut vous voyez qu'ils sont désactivés puisqu'on vous dit que la surcharge est None donc elle est tout simplement pas active. 

Pour que ce soit actif, et en plus les commentaires sont assez explicites, il suffit simplement de mettre `All` d'accord.
```conf
    #
    # AllowOverride controls what directives may be placed in .htaccess files.
    # It can be "All", "None", or any combination of the keywords:
    #   AllowOverride FileInfo AuthConfig Limit
    #
    AllowOverride All
```
Donc ça vous pouvez mettre à `All` si vous voulez c'est quelque chose parce qu'encore une fois c'est quelque chose qu'on verra au niveau de la formation donc je vous recommandé de passer à `All` tout de suite et comme ça ce sera fait et il n'y aura pas d'oubli. 

Et ici,
```conf
    #
    # Controls who can get stuff from this server.
    #
    Require all granted
```
On précise que l'accès à notre site est permis pour tout le monde puisque sinon on risque d'avoir des petits problèmes de lecture pour les sites web donc on laisse bien Require all granted, et vérifiez bien que cette ligne est bien comme ceci. 

Voilà pour cette partie là. 

On continue et on arrive maintenant sur un autre jeu de balises qui est :
```conf
	#
	# DirectoryIndex: sets the file that Apache will serve if a directory
	# is requested.
	#
	<IfModule dir_module>
		DirectoryIndex index.html
	</IfModule>
```
Donc cette ligne dit simplement que si ce module "dir_module" existe … ça permet comme ça de ne pas faire n'importe quoi, de ne pas essayer de modifier des choses si on n'a pas le module qui est présent où activé autrement ce sera un petit peu embêtant. 

À ce moment-là on va définir justement le fameux point d'entrée.
```conf
	<IfModule dir_module>
>		DirectoryIndex index.html
	</IfModule>
```
Dans ce système, je dis que dès que je vais croiser un fichier index.html, je vais pouvoir l'exécuter.

C'est ce qu'on a vu justement en faisant ça tout à l'heure :
```txt
	http://localhost/localhost/inc
	
	hello
```
Vous voyez je n'ai pas besoin de rentrer ceci :
```txt
	http://localhost/inc/index.html

	hello
```
Je peux le faire ça fera la même chose mais je ne suis pas obligé. 

Automatiquement juste en ayant localhost/inc/ avec le slash de fin même sans le slash localhost/inc parce que les navigateurs sont assez intelligents maintenant, il va automatiquement exécuter le bon fichier. Ils le font tout seul grâce à ça. 

Plus tard, je vous avais dit pour PHP, on va avoir des fichiers avec une extension .PHP donc c'est plutôt sympa de les ajouter maintenant comme ça dès que vous aurez un fichier .PHP et vous l'avez vu dans la vidéo précédente, ce n'était pas chargé par défaut et bien on pourra le faire charger. 

Alors on va le refaire le test comme dans la vidéo d'avant, on va virer le dossier "test" cette fois.

On va créer un fichier index.php : *.\MyWAMP\apache\htdocs\index.php*
```php
<?php
echo "Bonjour :) !";
```
```conf
	+-------------------------------+
	|	httpd.conf					|
    |	Options FollowSymLinks		|
	|	...							|
    |	AllowOverride All			|
	|	...							|
    |	Require all granted			|
	|	...							|
    |	DirectoryIndex index.html	|
	+-------------------------------+
```
On va relancer localhost.
```txt
	.\MyWAMP\apache\bin\httpd.exe
	http://localhost/

	Forbidden

	You don't have permission to access this resource.
```
Voilà on vous met que ce n'est pas accessible tout simplement parce que ce n'est pas un point d'entrée selon la configuration ici c'est-à-dire que index.php n'est pas un point d'entrée au niveau de nos options. 

Et comme on a interdit, tout simplement le Indexes, évidemment ça ne marche pas alors si je remets les paramètres par défaut. 
```conf
	+-----------------------------------+
	|	httpd.conf						|
>   |	Options Indexes FollowSymLinks	|
	|	...								|
    |	AllowOverride All				|
	|	...								|
    |	Require all granted				|
	|	...								|
    |	DirectoryIndex index.html		|
	+-----------------------------------+
```
Éventuellement on peut le laisser par défaut parce qu'on est en local ça ne gêne pas spécialement qu'en local, en plus lister un répertoire donc après tout cette option là je ne vais pas le enlever. 

Je vais laisser Indexes pour du local ce n'est pas gênant et on va revenir à la configuration qu'on avait avant la vidéo pour cette partie là. 

Voilà on va relancer Apache encore une fois et voilà ce qu'on avait dans la vidéo précédente.
```txt
	.\MyWAMP\apache\bin\httpd.exe
	http://localhost/

	Index of /

		index.php
```
Rappelez-vous quand on a fait ce fameux index.php, on avait ce fameux lien localhost/ qui du coup listait et on est obligé de cliquer sur index.php pour qu'effectivement le fichier PHP soit exécuté ce qui était un peu problématique je vous avais dit dans la vidéo suivante, on verra comment l'exécuter tout de suite. 
```txt
	http://localhost/index.php

	Bonjour :) !
```
Eh bien justement vous allez pouvoir le faire ici donc sur cette ligne là vous avez un DirectoryIndex et on vous met le type de fichier Index.html. Tous les fichiers index.html seront automatiquement exécuté par le navigateur qui les trouvera et qui les exécutera.

Si vous voulez que les fichiers .php soit pareil, et bien vous le mettez à la suite tout simplement.
```conf
    DirectoryIndex index.html
	-->     DirectoryIndex index.html index.php
```
C'est-à-dire qu'il va d'abord chercher de l'HTML et si il ne trouve pas, il va chercher index.PHP et vous pourrez en mettre d'autres. Je sais qu'il y a des fois d'autres types de format même si je ne les je recommande pas.

Donc si vous voulez mettre d'autres types, c'est par exemple un jour vous avez des fichiers en .ASP ou je ne sais quoi dans un autre langage pour le web, vous pourrez les ajouter ici au niveau de votre serveur Apache.
```conf
	+-----------------------------------------------+
	|	httpd.conf									|
	|	Options Indexes FollowSymLinks				|
	|	...											|
    |	AllowOverride All							|
	|	...											|
    |	Require all granted							|
	|	...											|
    |	<IfModule dir_module>						|
>	|		DirectoryIndex index.html index.php		|
	|	</IfModule>									|
	+-----------------------------------------------+
```
Nous on va se contacter seulement de PHP et HTML, on va laisser ces 2 là. 

Là évidemment je suis obligé de redémarrer mon serveur encore et toujours je rappelle.
```powershell
	.\MyWAMP\apache\bin\httpd.exe
```
Ça c'est important quand vous modifier la configuration d'apache, n'oubliez pas de redémarrer Apache sinon ce ne sera pas pris en compte. 

Et là bien sûr maintenant c'est automatiquement chargé. 
```txt
	.\MyWAMP\apache\htdocs\index.php

	http://localhost/
	
	Bonjour :) !
```
Les index.php sont reconnus comme des fichiers d'index réellement, elles sont automatiquement exécutés au niveau de notre serveur Apache. 

Vous pouvez laisser cette ligne là comme ça index.html et ajouter index.php à la suite, ce sera bien pratique. 

Voilà pour cette partie là, on continue à parcourir http.conf. Toute la partie sur les Log et cetera (module logio_module, CustomLog et cetera), on n'y a pas touché parce que tout ce qui est log et cetera, on n'y est pas encore arrivé pour le moment. On verra éventuellement lorsqu'on en parlera par la suite si on veut modifier des choses mais ça sert à rien pour le moment de s'y attarder. 

On continue de passer jusqu à la fin du fichier. Et on arrive après au niveau de PHP donc la partie PHP. 

Alors on aurait pu optimiser cette ligne là.
```conf
	+---------------------------------------------------+
	|													|
	| #httpd.conf										|
	| 													|
	| Define SRVROOT "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	| ServerRoot "${SRVROOT}"							|
	| ...												|
	| Listen 80											|
	| ...												|
	| LoadModule rewrite_module modules/mod_rewrite.so	|
	| ...												|
	| ServerName localhost								|
	| ...												|
	| <Directory "${SRVROOT}/htdocs">					|
	| 	Options Indexes FollowSymLinks					|
	| 	...												|
	| 	AllowOverride All								|	
	| 	...												|
	| 	Require all granted								|
	| </Directory>										|
	| ...												|
	| <IfModule dir_module>								|
	| 	DirectoryIndex index.html index.php				|
	| </IfModule>										|
	| ...												|
	| # PHP 7											|
	| AddHandler application/x-httpd-php .php			|
	| AddType application/x-httpd-php .php .html		|
>	| LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	| PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	|													|
	+---------------------------------------------------+
```
On aurait pu l'optimiser un peu, c'est ce que je vous avais fait mettre tout au début. On pourrait éventuellement le modifier, faire quelque chose d'un petit peu plus propre notamment en faisant ça. 

Je vous montre rapidement en mettant le chargement du module au début d'accord et après spécifier pour tout ce qui est chemin de le faire via un matching c'est-à-dire de dire qu'on va sélectionner un certain type de fichier donc une extension et appliquer un type mine c'est-à-dire que nous on avait fait comme ça directement mais c'est vrai que si on veut être assez strict d'accord si on veut faire quelque chose d'un peu plus propre, on peut utiliser le jeu de balises <FilesMatch> tout simplement.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch>
	
	AddHandler application/x-httpd-php .php
	AddType application/x-httpd-php .php .html
	
	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
```
D'accord et là il va falloir noter ça comme ça `<FilesMatch "\. …` avec un antislash pour pouvoir échapper le point c'est important et on va noter `\.php$` alors le dollar c'est la fin mais ça j'en parle pas parce que là ça concerne un certain type de formatage mais on n'en a pas encore parlé en PHP ou même meilleur donc j'évite forcément de m'attarder là-dessus. Vous écrivez simplement ça.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch "\.php$">
	
	AddHandler application/x-httpd-php .php
	AddType application/x-httpd-php .php .html
	
	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
```
Et la fameuse ligne que nous avons mis ici `AddHandler`, vous allez pouvoir l'ajouter aux balises avec une petite tabulation sauf que là nous allons directement la modifier `SetHandler` parce qu'on part du principe que ça a été matché donc plutôt de dire qu'on va faire ADD, on va carrément SETer donc c'est-à-dire qu'on va modifier ce type là pour dire que voilà cette extension là `.php` ça correspond vraiment à un fichier PHP.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch "\.php$">
		SetHandler application/x-httpd-php .php
	</FilesMatch>
	
	AddType application/x-httpd-php .php .html
	
	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
```
Et on n'oublie pas bien sûr de fermer la valise, voilà vous pouvez vous contenter de ça. Alors `AddType` on va le garder après. Mais ce que l'on peut mettre maintenant aussi c'est "PHPiniDir" qui doit être mis au niveau du module donc moi je vais dire comme je vais faire quelque chose de plus strict. 

Je pars du principe que `PHPiniDir` doit être fait que si le module a bien été chargé `LoadModule`. 

Admettons, imaginons que le module, je l'ai mal configuré ou que je me suis trompée dans un chemin, Eh bien ce serait un peu dommage de définir un répertoire sur un module qui n'est pas chargé donc pareil on va affiner la configuration.

Encore une fois si vous laissez comme c'était avant ça marchera, vous avez vu que ça marchait donc c'est qu'on a bien fait les choses mais là en fait on corrigé un petit peu ça en optimisant les commandes qu'on met aussi au niveau de la configuration d'apache histoire d'avoir quelque chose de plus propre et qui soit mieux paramétrer à ce niveau-là donc on va utiliser le fameux `<IfModule>` comme on a vu tout à l'heure sauf que là il faut vérifier ça `php7_module`.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch "\.php$">
		SetHandler application/x-httpd-php .php
	</FilesMatch>
	
	<IfModule php7_module>
	
	</IfModule>
	
	AddType application/x-httpd-php .php .html
	
	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
```
Donc si ce module est effectivement bon, a bien été chargé existe et cetera, effectivement on s'occupe d'ajouter `PHPiniDir`.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch "\.php$">
		SetHandler application/x-httpd-php .php
	</FilesMatch>
	
	<IfModule php7_module>
		PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	</IfModule>
	
	AddType application/x-httpd-php .php .html
```
Après c'est pareil j'ai un petit doute, il est possible que des fois vous voyez `PHPiniDir` écrit en majuscule mais normalement ça ne pose pas de soucis d'accord à ce niveau là. Normalement comme c'est du multiplateforme, la case devrait être importante en programmation ou en informatique mais là c'est vrai que sur beaucoup de cas, vous pourrez écrire en minuscule ou en majuscule ça fonctionnera. 

Personnellement je ne trouve pas ça très propre que les 2 fonctionnent, ça devrait être assez strict au niveau de la case, du texte, comme ça on serait sûr d'avoir toujours la même version mais là pas de soucis apparemment. 

Donc là on part du principe que si le module est bien chargé, existe bien, effectivement on précise bien ce chemin là. 

Alors vous avez remarqué au niveau de mes répertoires bien, j'ai enlevé le numéro de version "php-3.6" -> "`php`" par rapport aux vidéos précédentes mais encore une fois peu importe, c'est juste une histoire de chemin. Vous adapter en fonction du répertoire que vous avez fait, de l'environnement et ça c'est vous qui voyez, vous êtes assez grand pour le modifier. 

Et finalement, l'ajout ici du type `AddType`, on va le faire avec `<IfModule mine_module>` qui est un module pour gérer les types mine. Et pareil on va faire ça proprement, si ce module "mine_module" est ok, on ajoute ce fameux fichier `Addtype….` de cette manière tout simplement voilà.
```conf
	# PHP 7
	LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	
	<FilesMatch "\.php$">
		SetHandler application/x-httpd-php .php
	</FilesMatch>
	
	<IfModule php7_module>
		PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	</IfModule>
	
	<IfModule mine_module>
		AddType application/x-httpd-php .php .html
	</IfModule>
```
Qu'est-ce que ça veut dire ? ça veut dire que je considère que mon PHP, ce sont les fichiers qui portent l'extension .php (AddType) et même les fichiers qui portent l'extension .html (AddType) puisque dans un site fait en PHP, je vais des fois utiliser du .php ou éventuellement avoir des fichiers .html pourquoi pas d'accord ce sera interprété de la même manière donc je mets les 2 sans problème. Si vous ne mettez pas .html ce n'est pas grave du tout, vous faites comme vous voulez et vous pouvez également le laisser voilà.
```conf
	+---------------------------------------------------+
	|													|
	| #httpd.conf										|
	| 													|
	| Define SRVROOT "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	| ServerRoot "${SRVROOT}"							|
	| ...												|
	| Listen 80											|
	| ...												|
	| LoadModule rewrite_module modules/mod_rewrite.so	|
	| ...												|
	| ServerName localhost								|
	| ...												|
	| <Directory "${SRVROOT}/htdocs">					|
	| 	Options Indexes FollowSymLinks					|
	| 	...												|
	| 	AllowOverride All								|	
	| 	...												|
	| 	Require all granted								|
	| </Directory>										|
	| ...												|
	| <IfModule dir_module>								|
	| 	DirectoryIndex index.html index.php				|
	| </IfModule>										|
	| ...												|
	| # PHP 7											|
	| LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	| 													|
	| <FilesMatch "\.php$">								|
	| 	AddHandler application/x-httpd-php .php			|
	| </FilesMatch>										|
	| 													|
	| <IfModule php7_module>							|
	| 	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	| </IfModule>										|
	| 													|
	| <IfModule mine_module>							|
	| 	AddType application/x-httpd-php .php .html		|
	| </IfModule>										|
	|													|
	+---------------------------------------------------+
```
* Dans les commentaire, on utilise `AddHandler` au lieu de `SetHandler`.
* Depuis un terminal, en étant dans le répertoire où se trouve ton exécutable httpd.exe, tu peux faire la commande suivante :
```powershell
	httpd.exe -k install -n "ApacheServer"
```
Et normalement, il devrait être démarré comme un service Windows.
* Ouvrir un terminal, tu te rends sur le répertoire \bin de MySQL, et tu exécutes une à une ces deux commandes :
```powershell
mysqld --installnet start mysql
```
Et voilà, mysql sera lancé en tant que service sur ton système.

Alors si vous trouvez que c'est un petit peu trop complexe et cetera, vous pouvez rester avec l'écriture d'avant. L'écriture d'avant était correcte, ce n'était pas une erreur je vous le dis tout de suite, ce n'était pas faux par contre là on a quelque chose d'un petit peu plus propre au niveau de la présentation pour la configuration.

Voilà pour PHP et voilà au niveau de Windows pour toute la partie Apache. 

Je voulais dire qu'il n'y avait pas énormément de choses à voir mais on fait vraiment le tour de tout pour que vous puissiez bien comprendre ce que vous faites. 

Mon intérêt pour cette formation, c'est que vous ayez bien le contrôle des outils dont vous vous servez pour savoir ce que vous faites savoir ce que vous utilisez.

Je ne trouve pas normal par exemple de faire du web et ne pas savoir ce qu'est un serveur http, ou si par exemple quelqu'un, voilà qui fait du web depuis des années je ne serais même pas capable de vous expliquer ce qu'est Apache, je trouverais cela problématique pour ma part mais au moins ici vous savez ce que vous faites et vous savez en tout cas sans même forcément être des spécialistes, vous serez un minimum comment fonctionnent tous ces outils là et à quoi ils correspondent. 

Voilà pour Apache ici.

On va passer maintenant au php.ini : *.\MyWAMP\apache\php.ini*
```txt
	MyWAMP:.
	+---apache
>	|   |   php.ini
	|   +---bin
	|   |   |   httpd.exe
	|   |   |   php7ts.dll
	|   +---conf
	|   |   |   httpd - Copie.conf
	|   |   |   httpd.conf
	|   +---htdocs
	|   |   \---cours
	|   |       +---001_introduction
	|   |       +---002_installer_serveur      
	|   |       +---003_installer_interpr‚teur
	|   |       +---004_configurer_environnement_web
	|	|		|       index.php		
	\---php
			php-7.4.7-Win32-vc15-x64.zip
			php.exe
			php.ini-production
			php7apache2_4.dll
			php7ts.dll
			...
```
Et là pareil on ne va pas modifier beaucoup de choses, on va surtout faire un tour des options parce qu'en plus je me suis rendu compte que sur la vidéo précédente j'ai fait une petite erreur mais bon apparemment moi je l'avais mis de correctement donc il s'agit d'une petite référence parmi les options les plus populaires, les plus utilisés au niveau de la configuration PHP …

Alors ce qui est bien de vérifier, ce qui va nous intéresser ? c'est la fameuse ligne error_reporting qui permet d'afficher les erreurs de PHP avec les commentaires au dessus qui donne un petit peu les explications.
```conf
	error_reporting = E_ALL
```
Moi ce que je recommande comme vous êtes en mode développement et notamment en local, c'est de mettre tout simplement cette option là E_ALL qui va vraiment tout afficher tous les types d'erreurs comme ça vous serez sûr d'avoir un code PHP qui soit un maximum correct et ça pourrait éventuellement signaler le moindre problème au niveau de votre code et au niveau de vos scripts donc gardez bien ça au niveau du report et de l'affichage des erreurs.

Et après nous avons le display_error qui est un petit peu en dessous et qui doit bien sûr être mis sur on. Alors ça c'est important aussi aussi pour bien les afficher.
```conf
	display_errors = On
```
Et après honnêtement pour le reste on peut s'en passer, normalement ça doit être bien configuré vérifier que html_errors est bien sur on.
```conf
	html_errors = On
```
Alors normalement html_error doit être sur On. Vous pouvez éventuellement bien vérifier que les options sont correctes. Il y a aussi pour l'encodage le default_charset pareil surtout depuis PHP 7 en unicode donc vérifiez bien que c'est marqué "UTF-8" et si c'était marqué autre chose, changez le pour UTF-8 mais logiquement ça doit être bon.
```conf
	default_charset = "UTF-8"
```
```txt
	+---------------------------------------------------+
	|													|
	| #php.ini											|
	| 													|
	| error_reporting = E_ALL							|
	| ...												|
	| display_errors = On								|        
	| ...												|
	| html_errors = On									|
	| ...												|
	| default_charset = "UTF-8"							|
	|													|
	+---------------------------------------------------+
```
Là normalement vous ne devrez plus rien avoir à modifier et si vous avez pris les mêmes fichiers normalement ça doit déjà bien être configuré correctement de base, après on a toute la partie sur les bases de données (mysql…) mais ça ne nous intéresse pas pour le moment. On est loin d'être là tout de suite. On va faire pareil pour la cession ça ne nous intéresse pas pour le moment et cetera. On a les chaînes et puis on arrive sur pas mal d'extension et c'est pareil ça nous intéresse pas. 

Voilà pour php.ini donc c'était rapide pour lui, il y avait beaucoup moins de choses à voir. Logiquement votre environnement pour ceux qui sont en tout cas sur Windows est près et configuré et encore une fois vous savez ce que vous avez, vous n'avez pas simplement installé un logiciel qui avait plein d'outils à l'intérieur qui vous a tout fait à votre place sans savoir ce que vous utilisez mais là maintenant vous êtes parfaitement conscient de ce que vous avez installé, à quoi ça sert, qu'est-ce qui fonctionne à qu'est-ce qui ne fonctionne pas, qu'est-ce qui est paramétré et ça va évidemment beaucoup mieux se passer pour la suite de la formation et dans la vidéo que vous allez suivre prochainement. 

========================================

On passe à Linux.

On ferme tout, on va virer httpd.exe (Apache) ça ne sert à rien qu'il tourne en boucle et on va passer à Linux donc pour Linux on va faire un petit peu la même chose, on va simplement vérifier si vous savez que les répertoires sont un petit peu différent. 

On va démarrer en ligne de commande et on va procéder à quelques modifications alors je vais vérifier que je n'ai rien oublié parce que je voulait que vous modifiez les paramètres comme on avait changé, je voulais qu'on active le htaccess pour Windows donc on la fait, et après les options j'en ai parlé et tout ça donc normalement je n'ai rien oublié de toute façon au pire si j'ai oublié quelque chose je m'en rendrait compte dans les vidéos prochaines donc on corrigera à ce moment là mais logiquement c'est bon.

Ce qu'on va faire maintenant donc je rappelle pour les fichiers de configuration sur Linux notamment pour la distribution que j'ai essayé donc Ubuntu, Linux Mint, Debian et cetera. Vous avez : */etc/apache2/apache2.conf*

Et ça c'est le fichier configuration d'Apache.

Alors attention rappelez vous comme c'est des fichiers système, ils sont en lecture seule donc là vous n'allez pas pouvoir le modifier. 

Si vous voulez le modifier il faudra évidemment l'ouvrir en ligne de commande dans un terminal, donc :
```bash
	sudo nano /etc/apache2/apache2.conf
```
Voilà et là on va vérifier notamment avec les flèches directionnels que tout est bon donc logiquement et c'est pour ça que Linux c'est quand même plus pratique pour ça aussi, vous voyez qu'il est mieux optimisé par rapport à la configuration. Vous voyez par exemple ici que tout est commenté parce que les configurations sont bien paramétrées par défaut. 

Vous voyez qu'il y a quand même des petites différences entre Windows et Linux, alors ça `<Directory />` concerne le répertoire racine donc on n'y touche pas. 

Alors pour `<Directory /var/www/>`, je rappelle que le `/var/www/` c'est là qu'on va avoir après dans le dossier HTML nos sites donc vous voyez qu'on retrouve les mêmes options. 

Même chose comme on a vu sur Windows : 
```conf
	 <Directory /var/www/>
		Options Indexes FollowSymLinks
		AllowOverride None
		Require all granted
	</Directory>
```
Vous enlevez les options que vous ne voulez pas et vous pouvez même en ajouter d'autres à la suite, si vous voulez par exemple ajouter le MultiViews n'hésitez pas. 

Nous comme on avait dit qu'on voulait activer le .htaccess donc on va mettre All ici 
```conf
	+---------------------------------------------------+
	|													|
	| #/etc/apache2/apache2.conf						|
	| 													|
	| <Directory /var/www/>								|
	| 	Options Indexes FollowSymLinks					|
>	| 	AllowOverride All								|	
	| 	Require all granted								|
	| </Directory>										|
	| ...												|
	|													|
	+---------------------------------------------------+
```
On va sauvegarder ctrl+O puis Entrer et on continue.

On continue et vous voyez qu'il y a une petite ligne en plus.
```conf
	AccessFileName  .htaccess
```
une ligne en plus pour le nom du fichier .htaccess qui n'est pas obligatoire mais vous voyez qu'ici ils sont un peu plus propre d'accord et ils le mettent quand même pour être sûr. 

Ensuite il y a quelques fichiers de configuration à part, vous voyez notamment qu'il n'y a pas de Directory index ici tout simplement parce que par défaut le Apache sur Linux c'est plutôt bien configuré de ce côté là. Vous pouvez éventuellement l'ajouter si vous voulez en mettant un `<IfModule …>` pour tout ce qui est justement l'ajout des Directory index donc le module c'est dir_module pour pouvoir paramétrer dessus avec un jeu de balises ouvrante fermante et après vous mettez un Directory index mais honnêtement vous pouvez le laisser parce que de toute façon ça fonctionne déjà par défaut donc à la rigueur inutile de rajouter des trucs si ça fonctionne déjà. 
```conf
	<IfModule dir_module>
		DirectoryIndex index.html index.php
	</IfModule>
```
Tout le reste est OK donc ctrl+x (nano) et voilà.
```conf
	+---------------------------------------------------+
	|													|
	| #/etc/apache2/apache2.conf						|
	| 													|
	| <Directory /var/www/>								|
	| 	Options Indexes FollowSymLinks					|
>	| 	AllowOverride All								|	
	| 	Require all granted								|
	| </Directory>										|
	| ...												|
	| AccessFileName  .htaccess							|
	| 													|
	+---------------------------------------------------+
```
Et on passe du coup à notre fichier /etc/php/7.1/apache2/php.ini.
```bash
	sudo nano /etc/php/7.1/apache2/php.ini
```
php.ini et là c'est pareil, vous revérifiez éventuellement mais logiquement on devrait rien avoir à modifier pratiquement et que tout est déjà mis comme il faut de base. On va quand même revérifier.

Alors ici, il faut laissé commenté.
```conf
	error_reporting = E_ALL
	--> ;error_reporting = E_ALL
```
C'est plus bas qu'il est, je ne sais pas pourquoi je l'avais enlevé à cet endroit là. J'ai fait une erreur d'inattention, je l'aurais modifier dans les commentaires ce qui n'aurait pas été trop grave mais bon donc il vaut mieux le modifier et le toucher au bon endroit sinon on va se retrouver 2 fois avec la même commande et ça risque d'être un peu embêtant. 

Je ne fait pas de recherche comme ça on passe tous les paramètres en revue pour être sûr. 

Voilà et on arrive au niveau des erreurs et ça ça vous intéresse, vous voyez que pour error_reporting est légèrement différent sur Linux, il vous met par exemple qu'il ne faut pas afficher tout ce qui est les fonctionnalités dépréciées donc moi je vous invite à laisser juste E_ALL tout simplement comme sur Windows faut vraiment tout afficher. 
```conf
	error_reporting = E_ALL & -E_DEPRECATED & -E_STRICT
	--> error_reporting = E_ALL
```
Voilà comme pour Windows E_ALL et vraiment tout afficher, vous pouvez mettre ça comme ça pour display_error. 
```conf
	display_error = On
```
Donc vous voyez que par défaut c'est bien mis, et ça par contre display_startup_errors est sur off apparemment ici tient mais vous pouvez le mettre à On je ne sais pas pourquoi ils le mettent à Off parce que c'est bien d'avoir aussi ces erreurs là.
```conf
	display_startup_errors = Off
	--> display_startup_errors = On
```
Voilà les html_errors sont à On aussi.
```conf
	html_errors = On
```
Donc c'est bon et après c'est por les logs mais ça on s'en fiche. Et après le reste c'est pour les bases de données, les chemins et cetera, les extensions, les CGI voilà le reste ça nous intéresse pas.

Je repasse quand même très vite pour voir mais normalement on n'a rien oublié parce qu'on a fait le tour. Alors pour MySQL ce sont les bases de données on s'en fiche on verra plus tard. Les sessions et cetera donc ça va être bon CTRL+O ENTRER CTRL+X … Ça je vous redis la commande parce que je voulais raccourci clavier et vous ne les voyez pas forcément à l'écran. 

Donc,
```conf
	+---------------------------------------------------+
	| # /etc/php/7.1/apache2/php.ini					|
	| ...												|
	| ;error_reporting = E_ALL							|
	| ...												|
>	| error_reporting = E_ALL							|
	| ...												|
	| display_error = On								|
	| ...												|
>	| display_startup_errors = On						|
	| ...												|
	| html_errors = On									|
	|													|
	+---------------------------------------------------+
```
Et voilà pour Linux. 

Je rappelle on va pouvoir redémarrer pour le coup :
```bash
	sudo systemctl start apache2
```
Et là bien sûr hop, on avait déjà vu ça dans la vidéo précédente. Toute façon vous avez vu que le chemin marchait par défaut, il n'y avait pas eu besoin de vérifier quoi que ce soit mais on avait vu que tout était OK. 

Donc là évidemment ça liste mais c'est normal :
```txt
	localhost/
	
	Index of /
		monsite/
		
	( ... ouvrir le sous-dossier ... )
	
	localhost/monsite/
	
	Bonjour
```
C'est normal parce qu'on n'a pas de fichier index ici j'ai mis un répertoire pour mon site, et là directement quand je l'ouvre le fichier PHP est lu donc ça c'est le fichier index.php qui même s'il n'est pas affiché dans l'adresse, évidemment est exécuté correctement parce qu'il est considéré comme un point d'entrée donc il n'y a pas de souci à ce niveau-là.

Ça vous met Bonjour parce que tout simplement on avait mis un echo. 

Et je fais un petit rappel pour terminer cette vidéo bien sûr à ce niveau-là que les sites web et là il ne faut pas se tromper au niveau de Linux il faut aller dans */var/www/html/monsite/*

Et là vous mettez directement vos fichiers, soit si vous voulez faire plusieurs sites ou plusieurs projets, vous faites un dossier par projet et après comme ça vous mettez ce que vous voulez à l'intérieur : */var/www/html/monsite/index.php*

Et je vous remontre :
```txt
	index.php
	
	<?php
	echo "Bonjour";
```
Voilà le message Bonjour qu'on a bien eu dans le navigateur et donc c'est bon. 

Et attention au droit, rappelez-vous au niveau des droits des fichiers c'est important donc ça fait attention à tout ça pour que ce soit bien évidemment accessible. 

On va fermer Apache.
```bash
	sudo systemctl stop apache2
	exit
```
Et on est bon pour ça, le paramétrage est OK, vous avez donc votre environnement de développement web qui est prêt pour la suite en tout cas de cette formation. 

Dans la prochaine vidéo et en tout cas à partir de la prochaine séance, nous allons vraiment commencer à programmer en PHP, et à voir ce langage de programmation qui va vous permettre de faire beaucoup de choses. 

J'espère que ça vous a plu et que c'était suffisamment clair donc ce n'était pas forcément les vidéos les plus marrantes, les plus intéressants de la formation mais encore une fois c'est super important. 

Au moins vous aurez l'avantage de savoir ce que vous utilisez contrairement peut-être à d'autres personnes qui installent des outils de développement web sans savoir même ce qu'il s'est installé ce qu'ils utilisent donc au moins là vous avez le nécessaire. 

Alors pour ceux qui avaient vu mon ancienne formation PHP, l'ancienne version où justement j'avais démarré l'installation de tous les outils via XAMPP.

Il y a ou il y aura, ça dépend encore une fois du moment où vous Regardez cette vidéo, un tutoriel dans la playlist PHP tutoriel pour l'installer. Il y a même un tuto pour WAMP server, voilà pour différents logiciels qui permettent de faire ça donc après si vous avez besoin d'aller plus vite vous pouvez utiliser Xampp, vous pouvez utiliser Wamp server, ça ne pose pas de soucis. 

L'intérêt ici maintenant c'est que vous êtes le maximum indépendant par rapport aux outils dont vous vous servez et encore une fois vous savez ce que vous utilisez et vous savez à quoi ça correspond et comment ça fonctionne et ça c'est quand même super important quand on fait de l'informatique d'avoir un contrôle encore une fois sur les outils de dont on se sert parce qu'on s'en sert beaucoup et on se sert de beaucoup de choses également. 

À bientôt tout le monde pour la suite de cette formation en PHP et si vous avez des questions n'hésitez pas à laisser vos commentaires. 

Ciao tout le monde