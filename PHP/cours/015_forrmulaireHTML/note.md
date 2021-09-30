# [15. Traiter formulaire HTML](https://www.youtube.com/watch?v=RWL0mUiPiI4)

Bonjour à tous et bienvenue sur cette séance 15 en PHP. 

Nous allons voir comme l'indique le titre, traiter des données issues d'un formulaire en HTML.

Alors cette vidéo je vous le dis tout de suite n'est absolument pas obligatoire, j'aurais même pu l'intégrer dans les tutoriels de PHP mais comme dans la majorité des cas vous allez vous servir de PHP avec des pages HTML, j'ai volontairement inclus ce type de séance directement dans le cours. 

Alors si vous n'avez pas prévu de faire du HTML avec PHP, ce qui peut arriver pour quelqu'un qui ferait simplement du développement en back end sans s'occuper de la partie front end c'est-à-dire l'interface d'un site, ce genre de vidéo ne sera pas forcément utile mais comme ici on parle de développement en PHP, je l'ai inclus dans ce cours. 

Alors on va prendre quelques petits exemples très simples parce que voilà j'ai fait quelque chose d'assez rapide c'est-à-dire que je viens de prendre ici un petit formulaire mais on va en parler un petit peu après.

+ index.php
```php
<!-- GET -->
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Formulaire HTML</title>
</head>
<body>
	<h1>Saisie d informations</h1>

	<form method="get" action="result.php">
		<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
		<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
		<input type="radio" name="choice" id="idchoice" value="non">Non</p>
		<p><input type="submit" name="valid_form" value="valider"></p>
	</form>
</body>
</html>
```
Voilà j'ai fait un formulaire HTML et si vous ne savez pas ce qu'est un formulaire en HTML, je vous invite à aller voir la formation HTML sur la chaîne pour la vidéo, la séance qui concerne les formulaires justement. 

Alors j'ai tout simplement repris ça que j'ai mis dans un fichier index.php donc un simple formulaire dans une page web, et on aura une page de résultats.
```php
	result.php
	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>
```
Une page PHP de résultats qui va permettre de traiter ces informations là. 

J'ai simplement mis un lien HTML (href) pour revenir au formulaire directement.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+
```
Ce qu'il faut savoir c'est ça et on va en parler un peu plus en détail par la suite. 

Et là on a dans le navigateur l'affichage de notre formulaire avec lequel nous allons travailler. 

Alors comment ça se passe ? au niveau de PHP, nous avons ce que nous appelons des variables prédéfinies notamment des variables super globales c'est à dire qu'elles vont être accessibles un petit peu n'importe où au niveau de votre application faites en PHP donc pas besoin de les déclarer en global ou autre, elles sont vraiment disponibles partout. 

Parmi ces variables on va en retrouver 2 principales qui sont les variables GET et les variables POST alors je vais les noter ici en tant que commentaire.

Nous allons voir dans cette vidéo.
```php
	/*
		Variables superglobales : 	$_GET
									$_POST
	*/
```
Variable pour tout ce qui est prévu pour la transmission de données d'un formulaire notamment leur exploitation le traitement de ces données là à partir de langages comme PHP donc ça va servir à ce niveau-là. 

Alors là distinction entre ces 2 variables super global c'est-à-dire qu'elles vont récupérer des données spécifiques, la différence tient sur la manière dont on traite et dont on transmet les données depuis notre formulaire. 

La première `$_GET` va permettre de transférer des données depuis l'url c'est à dire que quand je suis sur ma page ici, vous voyez que je vais pouvoir transmettre un certain nombre de choses c'est-à-dire que je suis même pas obligé de passer par un formulaire en fait, il suffirait d'accéder simplement à la page result.php en tapant un certain nombre d'informations. 

Ou alors comment va se composé une url ? elle va se composer de cette manière, on aura par exemple URL en GET et on aura une adresse par exemple d'accord.

http://localhost/PHP/cours/015_forrmulaireHTML/result.php

On arrive sur la page que j'ai fait avec le petit lien HTML ici qui va ramener vers le formulaire.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>
```
Donc par défaut, on a ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire
```
Je vais pouvoir ajouter un certain nombre d'informations à mon url sous forme de variable, sous forme de données qui seront passées en GET et vous allez comprendre pourquoi. 

Pour préciser ces informations, déjà au moment où on a le lien au niveau de notre url, on met un `?` pour démarrer l'ensemble des variables.
```txt
http://localhost/PHP/cours/015_forrmulaireHTML/result.php?
```
Et on va pouvoir en définir plusieurs par exemple var1 égal un nombre.
```txt
http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154
```
Si je veux en mettre d'autres, je peux les séparer avec le fameux symbole et commercial, et là par exemple je peux faire var2 égal Bonjour et pas besoin de mettre des doubles quottes.
```txt
http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour
```
Et puis un autre.
```txt
http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour&var3=ok
```
Voilà ce genre de chose. 

Je récupère cette url copier coller dans le navigateur il faut savoir que ça c'est une url valide sans problème. 
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour&var3=ok
	« Retour au formulaire
```
C'est une url valide dans lequel et vous l'avez peut-être remarqué si vous naviguez sur certains sites que des fois vous avez des adresses à rallonge avec plein d'informations, avec des symboles dont on reconnaît des noms c'est à dire des noms de variables suivies d'un `=` avec des valeurs et quand il y en a plusieurs séparés par des petits `&`. 

Ces choses-là vont être transmises via http, le protocole http mais par méthode GET c'est-à-dire visible depuis ici l'url et récupérable dans cette variable super globale `$_GET`. 

Alors ça tombe bien on va les afficher, on va afficher le contenu de cette variable super global. Alors on l'entoure de `<pre></pre>` pour que ce soit plus lisible pour nous et je vais juste faire un `print_r($_GET);` pour voir ce qu'elle contient donc à partir de l'url.

+ result.php
```txt
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	
	print_r($_GET);
	
	?>
	</pre>
```
Voir si je fais une url de base juste comme ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Array
	(
	)
```
On voit que je n'ai rien, aucune donnée en `$_GET`, ce qui est logique parce que je n'ai absolument rien transmis au niveau de mon url. 

Par contre à partir du moment où je vais passer ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour&var3=ok
	« Retour au formulaire

	Array
	(
		[var1] => 154
		[var2] => bonjour
		[var3] => ok
	)
```
Voilà ce que nous obtenons, on voit qu'on retrouve bien notre variable var1, var2, var3 avec chacune des valeurs correspondantes.

D'ailleurs rien n'empêche de faire ceci c'est-à-dire afficher le contenu mais pour l'afficher je ferai simplement ceci `echo $_GET['']` alors ce sont des tableaux et vous savez comment fonctionnent les tableaux en PHP. Je n'ai pas besoin de l'apprendre parce qu'on l'a déjà vu ici je peux par exemple récupérer var2.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	
	print_r($_GET);
	
>	echo $_GET['var2'];
	
	?>
	</pre>
```
D'accord afficher le contenu de `$_GET` à la clé `var2`.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour&var3=ok
	« Retour au formulaire

	Array
	(
		[var1] => 154
		[var2] => bonjour
		[var3] => ok
	)
	bonjour
```
Et là évidemment si j'affiche, on voit que ça fonctionne et on récupère bien l'information.

Alors l'intérêt de ça parce que là tout de suite ce n'est pas forcément très pratique, c'est un petit peu limité, c'est de pouvoir récupérer ces données depuis un formulaire. 

Alors il y a déjà des petites choses à prendre en compte au niveau par exemple de la longueur des url's. 

Par défaut tel que ça géré à la base, une url peut faire jusqu'à un peu plus de 2000 caractères et je crois que c'est 2048 donc il y a de la marge, voilà de quoi mettre beaucoup d'informations mais évidemment prendre en compte dans ces 2048 caractères la taille de l'adresse. 

Ça veut dire que vous ne pouvez pas déplacer logiquement ça, après il y a certains navigateurs Qui vont aller au-delà. 

Je crois qu'il y a des navigateurs comme opéra prévois des valeurs impossible genre plusieurs dizaines de milliers de caractères possibles c'est-à-dire d'un nombre absolument astronomique qui ne servirait d'ailleurs pas à grand-chose à mon sens mais en tout cas voilà certains navigateurs peuvent le gérer. 

Tout ce qu'il y a à savoir, c'est que par défaut en tout cas, on gère jusqu'à un peu plus de 2000 caractères possibles dans une url donc vous pouvez passer plein plein d'informations de cette manière. 

Alors comment récupérer notamment par GET des données issues d'un formulaire ? parce que là moi je les ai passés manuellement de cette manière mais alors comment est-ce que je peux faire ça ? 

Mais avant, je vais virer mon echo.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	
	print_r($_GET);
	
	?>
	</pre>
```
Alors pour le faire, je veux avoir mon formulaire HTML dans index.php. Je rappelle si vous ne connaissait pas les formulaires HTML, allez voir ma vidéo là-dessus sur la chaîne. Il y a toute une formation HTML CSS et une vidéo sur les formulaires pour ça.

Et comme je l'avais indiqué sur cette vidéo, on va avoir pour les formulaires la possibilité de choisir la méthode.

+ index.php
```php
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Formulaire HTML</title>
	</head>
	<body>
		<h1>Saisie d'informations</h1>

>		<form method="post" action="result.php">
			<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
			<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
			<input type="radio" name="choice" id="idchoice" value="non">Non</p>
			<p><input type="submit" name="valid_form" value="valider"></p>
		</form>
	</body>
	</html>
```
Alors l'action, c'est l'endroit où on envoie les données. 

Et la méthode `<method>`, je m'étais arrêté là-dessus sur la vidéo HTML, on peut choisir justement entre "get" ou "post". 

Ensuite j'ai renseigné différentes informations et les variables … je fais un petit rappel rapide sur la vidéo que j'avais fait en HTML sur les formulaires … tout ce que nous mettons à l'attribut `name=""` sera le nom des variables que nous allons pouvoir récupérer en PHP pour le coup dans `$_GET` donc on aura une variable qui s'appellera "user", on aura une variable qui s'appellera "choice" et on aura même d'ailleurs une variable "valid_form" pour le bouton de validation du formulaire. 

Donc j'y vais et je vais aller sur mon formulaire ici.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+
```
Alors si je ne rentre pas d'information et presse Valider, on va avoir ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?user=&valid_form=valider
	« Retour au formulaire

	Array
	(
		[user] => 
		[valid_form] => valider
	)
```
Alors là vous voyez que `[user]` est vide.

Comme je n'ai pas choisi au niveau de la liste, le choix unique, on n'a pas évidemment renvoyé cette donnée-là. 

Et on a la validation du formulaire `[valid_form]`.

Donc ça ce n'est évidemment pas forcément propre. 

On va donc le faire avec des informations … alors là oui j'ai juste mis une liste à puce parce que je voulais rester sur Un exemple très basique.

Et là on envoie le formulaire, presser Valider.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |		Jason				|
				  +-------------------------+
	Choix : o Oui x Non
	+---------+
	| Valider |
	+---------+
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?user=Jason&choice=non&valid_form=valider
	« Retour au formulaire

	Array
	(
		[user] => Jason
		[choice] => non
		[valid_form] => valider
	)
```
Regardez ici au niveau de GET, il a bien envoyé toutes les informations, il a mis un ? Et les différentes variables.
```txt
	?user=Jason&choice=non&valid_form=valider
```
Alors toutes ces informations ont bien été récupérées, et on va pouvoir les exploiter. 

C'est là tout l'intérêt de pouvoir travailler avec des formulaires HTML dans ce sens-là, c'est que le formulaire HTML en lui-même vous ne ferez pas grand-chose avec. Il faudra forcément un langage de programmation comme PHP où python ou du javascript côté serveur pour exploiter ces informations-là, les traiter, les stocker en base de données, les enregistrer dans un fichier ou éventuellement même les afficher.

Donc toutes ces choses-là que nous allons pouvoir faire. 

Ça c'était pour `$_GET`, vous avez vu que c'était de manière visible et qu'on peut passer par une url et cetera. 

On peut faire la même chose avec POST, avec tout simplement la méthode POST. 

La seule différence de poste, c'est que ce n'est pas fait de manière visible c'est-à-dire qu'on ne va pas passer les informations dans l'url.
```php
<!-- POST -->
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Formulaire HTML</title>
</head>
<body>
	<h1>Saisie d'informations</h1>

	<form method="post" action="result.php">
		<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
		<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
		<input type="radio" name="choice" id="idchoice" value="non">Non</p>
		<p><input type="submit" name="valid_form" value="valider"></p>
	</form>
</body>
</html>
```
On print_r() de `$_POST` maintenant.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	print_r($_POST);

	?>
	</pre>
```
Alors je vais retourner au formulaire, je vais remettre d'autres informations et Valider.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |		Jason				|
				  +-------------------------+
	Choix : x Oui o Non
	+---------+
	| Valider |
	+---------+
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Array
	(
		[user] => Jason
		[choice] => oui
		[valid_form] => valider
	)
```
Voyez qu’au niveau de POST, on récupère bien les informations aussi simplement que au niveau de l'url on a rien qui est visible.

C'est masqué. 

C'est à vous de voir en fonction, dans quel cas ça peut être utile d'afficher dans l'url ou pas. 

Là où ça peut être utile par exemple on voit souvent les moteurs de recherche utilisent GET pour effectuer des recherches parce que par exemple ils vont vous mettre la requête de recherche genre `?q=` et vous pouvez chercher différents mots-clés.

Par exemple si vous cherchez 2 mots, cours et PHP admettons, vous avez voté comme ça avec des `+` pour séparer les 2 mots parce qu'il n'y a pas d'espace dans un url.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?q=cours+php
```
Comme ça juste en modifiant dans l'url, on pourrait faire une autre recherche directement. 

Ça peut servir par exemple pour faire des parseurs, c'est-à-dire de pouvoir récupérer notre url et de pouvoir gérer dynamiquement des recherches.

Dans ce genre de cas, utiliser des données en GET est intéressant.

Par contre si c'est pour enregistrer un utilisateur sur un site pour l'inscrire ou ce genre de chose, on va utiliser POST parce qu'on aurait aucun intérêt à travailler directement dans l'url. 

C'est à vous de voir, c'est selon les cas où une des 2 méthodes sera plus intéressante que l'autre, de choisir entre GET ou POST en fonction évidemment du projet sur lequel vous travaillez donc ce sera à voir en fonction. 

Voilà pour ces 2 -là.

Alors là on a juste vu comment traiter les données sur l'une ou l'autre des méthodes d'accord et ça c'était le point le plus important qu'il fallait voir par rapport à ça.

Maintenant on va voir comment on va pouvoir récupérer ces données et travaillé avec parce qu'il ne suffit pas juste comme ça de faire un print_r() de `$_POST` ou `$_GET`, il faut bien pouvoir travailler avec ces données-là.

Et là on va énormément insister donc ça va être un peu long à expliquer parce qu'il faut voir cette partie-là mais on va pas mal parler sécurité. 

Parce qu’évidemment puisqu'on va parler de formulaire c'est-à-dire qu'on va avoir des données saisies par un utilisateur, et que l'utilisateur par définition sur internet vous ne devez pas lui faire confiance. 

Il peut absolument noter n'importe quoi, il pourrait aussi simplement se trompait involontairement où indiquer des mauvaises informations volontairement dans le but par exemple de casser votre site voir pire dans le cas d'une tentative de piratage. 

Donc tout ça est important à prendre en compte, et à partir de maintenant on va vraiment mettre l'accent là-dessus, et on va avoir beaucoup d'aspects de sécurité qui vont rentrer en compte puisqu'on va apporter des choses qui y font référence. 

Alors Comment ça va se passer ? Alors premier point, il y a ce qu'on appelle un web différentes failles de vulnérabilités qui peuvent mettre à mal votre site, mettre à mal votre application et dont il faut faire attention lorsque vous développez.

Une des premières failles très reconnues au niveau du web, ce sont les failles X2S.

Une faille c'est simplement l'injection de données via la transmission de données et notamment par exemple via le url.

Alors comment est-ce que ça peut se passer ? Aura montré ça très simplement utiliser un petit script en javascript donc ici un langage de programmation côté client. 

Voilà on va le faire, donc on a.

+ result.php
```php	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	print_r($_GET);

	?>
	</pre>
```
On peut aussi changer la méthode en GET mais ça on s'en fiche.
```php
<!-- GET -->
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Formulaire HTML</title>
</head>
<body>
	<h1>Saisie d'informations</h1>

	<form method="get" action="result.php">
		<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
		<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
		<input type="radio" name="choice" id="idchoice" value="non">Non</p>
		<p><input type="submit" name="valid_form" value="valider"></p>
	</form>
</body>
</html>
```
Alors je passe simplement mon url ici d'accord.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?var1=154&var2=bonjour&var3=ok

	« Retour au formulaire

	Array
	(
		[var1] => 154
		[var2] => bonjour
		[var3] => ok
	)
```
Et Pour rappel vous voyez qu'on pouvait récupérer tout un tas d'informations.

À partir du moment où juste en mettant ça c'est-à-dire un prénom de quelque chose suivi de Jason et qu'on récupère l'information ici.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?prenom=Jason
	
	« Retour au formulaire

	Array
	(
		[prenom] => Jason
	)
```
Voilà on est au nom de quelque chose et on récupère la information dans le navigateur c'est-à-dire que vous voyez qu'on a un contrôle sur les données ici parce qu'au niveau du script je me charge directement d'afficher print_r() le contenu de la variable super global `$_GET` sans contrôler quoi que ce soit.

Si un petit malin a envie d'injecter du code javascript donc si je ne vais rien faire de très avancé mais juste en incluant du HTML en utilisant la balise script et entre les balises, je mets du code HTML quel qu'il soit ça peut être par exemple juste un petit message comme une pop-up, juste ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?prenom=<script>alert("hacked");</script>
	
	+-------------------+
	|					|
	|	hacked			|
	|					|
	|				OK	|
	+-------------------+
```
On entre la page et là vous voyez que j'arrive à exécuter la page web ... la page web exécute parce qu'elle interprète le javascript comme ça, ici du code non autorisé.

C'est-à-dire qu'on a fait exécuter un code Javascript même si là ce n'est pas grave de faire afficher qu'une pop-up avec un message, c'est rien du tout.

Mais on pourrait de la même manière, récupérer des cookies ou accéder à des informations confidentielles sur votre ordinateur de cette manière.

Donc attention à ça parce qu'ici on n'a aucune protection par rapport à ça.

En effet on demande d'afficher les informations sont les vérifier. 

Au moment où je fais, même si c'est juste pour l'affichage du tableau et que j'essaie d'afficher le contenu de `[prenom]` ici.
```php
	Array
	(
>		[prenom] => 
	)
```
Eh bien il va faire ça.
```txt
	<script>alert("hacked");</script>
```
Et bien là, le navigateur au lieu simplement afficher ce texte-là, Il va l'exécuter et il va voir que c'est un script que l'on veut exécuter.

La commande alert() en Javascript, il va l'exécuter et donc afficher la fameuse pop-up.

Donc ça on va évidemment pouvoir le sécuriser à l'affichage au niveau des données qu'on récupère et ça c'est une règle essentielle en web d'accord c'est-à-dire que pour toute donnée Vous allez pouvoir afficher surtout si c'est une donnée qui provient d'un utilisateur ou qui a été récupérée par quelqu'un, on doit être sécurisé.

Alors attention de ne pas sécuriser vos données par exemple avant de les stocker dans une base de données, de les enregistrer dans un fichier parce que ça ne sert strictement à rien.

Vous allez même alourdir l'espace de stockage en ajoutant des données inutiles.

On sécurisé tout le temps avant d'exécuter ou d'afficher une information parce que c'est là qu'il y a un risque de piratage, un risque d'injection ici pour fileX2S alors c'est au moment de l'affichage et pas de l'enregistrement.

Si une personne n'est par exemple ça.
```php
	<script>alert("hacked");</script>
```
Admettons que dans cette base de données je vais enregistrer cette information comme prénom, ça ne présentera aucun risque et ça va juste enregistrer ce texte-là `<script>alert("hacked");</script>` et cetera. 

Par contre c'est au moment où je vais vouloir l'afficher que là le navigateur va l'exécuter, c'est là qu'il y a un danger. 

Donc on sécurise au moment de l'affichage ou de l'exécution de quelque chose mais non pas pour son stockage ou autre.

C'est un moment je fais ça.
```php
	print_r($_GET);
```
D'accord le fameux print_r() d'ailleurs je peux juste afficher comme ça puisqu'on a vu qu'on l'avait mis dans 'prenom'.
```php
	echo $_GET['prenom'];
```
Donc au lieu de faire ça ce qui n'est évidemment pas sécurisé et qui entraine ce genre de problème.

+ result.php
```php	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

	echo $_GET['prenom'];

	?>
	</pre>
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?prenom=<script>alert("hacked");</script>
	
	+-------------------+
	|					|
	|	hacked			|
	|					|
	|				OK	|
	+-------------------+
```
... et bien on va utiliser une fonction de PHP qui permet de sécuriser cette information.

Et en PHP, on a pas mal de petites fonctions qui permettent de le faire en l'occurrence on en a 2.

Vous allez principalement utiliser celle que je vous donne en premier.
```php
	/*
		htmlspecialchars($str)
		htmlentities($str)
	*/
```
On a la fonction `htmlspecialchars($str)` qui va prendre une chaîne donc je mets `$str`. Et on a `htmlentities($str)`, alors comment vont-elles fonctionner ?

htmlspecialchars() va remplacer tous ce qui caractères spéciaux et notamment des caractères liés à du HTML par un code ... ce qu'on appelle une entité HTML correspondante.

Par exemple vous avez vu qu'au niveau de ma page, j'avais ici l'ouverture d'une balise de script et ça on ne veut pas.
```php
	<script>alert("hacked");</script>
```
Nous ce qu'on va faire c'est que grâce à notre fonction PHP va remplacer le symbole `<` par son équivalent, son entité HTML, c'est-à-dire qu'il va vraiment après le considérer comme un texte c'est-à-dire qu'il va afficher réellement ce symbole et le navigateur ne va plus l'interpréter comme étant du code HTML.

Donc En bref ce que ça va faire, c'est que le symbole `<` sera remplacé par le symbole `&lt;` (lower than).
```php
	/*
		htmlspecialchars($str)	:	< par &lt;
		htmlentities($str)
	*/
```
Et ça évidemment à l'affichage, un navigateur web va l'afficher … quand il voit &lt; que ce soit Firefox, Chrome, ce que vous voulez, il va réellement afficher ce caractère-là `<` et non plus l'interpréter comme étant une balise html parce que vous savez pour ceux qui font du html que les balises sont représentées comme ça par une fermeture `<` donc un chevron ouvrant et un chevron fermant `>`. Ou un symbole inférieur et supérieur.

Il pourrait également sécuriser sur les quottes ou ce genre de chose.

Par exemple ce symbole & pourrait être remplacé par ce symbole &amp.
```php
	/*
		htmlspecialchars($str)	:	< par &lt; & par &amp;
		htmlentities($str)
	*/
```
Et puis la double et simple quotte, il pourrait la remplacer par ce symbole `&quot;`
```php
	/*
		htmlspecialchars($str)	:	< par &lt; & par &amp; ' par &quot;
		htmlentities($str)
	*/
```
Et cetera.

Donc c'est simplement de la sécurisation pour tout ce qui est balises HTML parce que c'est ça qu'on ne veut pas qu'il exécute éventuellement un code inattendu.

Donc on a juste à faire ça, htmlspecialchars() à l'affichage de la donnée sensible c'est-à-dire celle qui risque peut-être évidemment d'avoir quelque chose d'inattendu. 

+ result.php
```php	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	echo htmlspecialchars($_GET['prenom']);

	?>
	</pre>
```
Et là si on tente l'affichage.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?prenom=<script>alert("hacked");</script>
	
	« Retour au formulaire

	<script>alert("hacked");</script>
```
Vous voyez qu'on obtient effectivement le contenu et ce n'est plus exécuté. 

C'est réellement du texte ici. 

Si je regarde le code source HTML, voilà comment ça s'est passé.
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	&lt;script&gt;alert(&quot;hacked&quot;);&lt;/script&gt;</pre>
```
Voilà comment ça s'est passé, c'est marqué `&lt;` et ensuite `&gt;` (greater than) et cetera. 

Voyez qu'il a changé la quote parent avec son entité HTML correspondante &quot;

Et cetera.

Donc automatiquement, Eh bien on a cassé l'exécution possible du javascript donc on a sécurisé, on a empêché l'exécution ou en tout cas l'exploitation d'une faille XSS au niveau de notre navigateur web donc c'est évidemment très intéressant de procéder comme ça. 

Si vous avez besoin éventuellement de transformer encore plus d'entités spécifiques en HTML par exemple si vous ne travaillez pas en utf 8 et j'espère pour vous que vous travaillez en utf 8 c'est ce que je vous ai recommandé dans toutes les vidéos mais si vous avez un vieux au script ou un vieux code ou je ne sais quoi qui est en ISO ou un latin ou ce genre de chose qui ne travaille ni en utf 8 ou alors qui nécessite d'avoir des conversions supplémentaires alors à la place de htmlspecialchars() vous pouvez utiliser htmlentities().

+ result.php
```php	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	echo htmlentities($_GET['prenom']);

	?>
	</pre>
```
Logiquement si vous faites bien les choses c'est que vous travaillez en utf 8 tout le temps, le htmlspecialchars() suffira largement pour l'échappement donc en tout cas pour la protection des données.

D'accord au minimum utiliser celui-là htmlspecialchars() et si vous voulez faire tous les remplacements utiliser htmlentities() qui était un petit peu plus strict htmlspecialchars() mais dans tous les cas vous vous en servez d'un au minimum, une fonction parmi les 2 à chaque affichage d'une donnée qui a été rentrée par un utilisateur. 

Et là il n'y aura plus de failles XSS donc plus de risque ici qu'un code s'exécute à votre insu.

Alors ce que je vous dis là c'est vraiment très important, à chaque fois que vous allez vouloir afficher quelque chose admettons que vous alliez récupérer une information d'une base de données comme on le verra plus tard éventuellement. 

Eh bien au moment où vous voulez afficher cette information par exemple le titre d'une news, Eh bien vous ne savez pas ce qui a pu être mis dans le titre.

Imaginez qu'une personne ait mis justement un script javascript dans le titre. 

Si vous ne protégez pas l'affichage au moment de l'affichage du titre, vous risquez une tentative de piratage ou simplement l'exploitation d'une faille au niveau web et là ça peut du coup causer de sacrés dégâts dans certains cas au niveau de votre site. 

Pensez toujours c'est la règle à l'affichage donc l'exécution de quelque chose, d'une donnée qui peut être vérifiée d'un utilisateur et si c'est une donnée à vous à priori il n'y a pas de risque, vous n'allez pas vous pirater vous-même mais si c'est une donnée qui a pu être entrée par un utilisateur.

Imaginez un message d'un forum, un message d'un chat, un titre rentré par un rédacteur tout ça qui pourrait potentiellement contenir du texte ou quelque chose non autorisé, on va protéger cet affichage tout le temps avec l'utilisation de l'une de ces 2 fonctions là tout le temps.

Voilà ce que j'avais à dire à ce niveau-là pour tout ce qui est sécurité au niveau GET ou POST qu'importe d'ailleurs que ça fonctionne pareil que ce soit `$_GET` ou `$_POST`.

À chaque fois qu'il y a un affichage d'un formulaire donc au niveau d'une donnée saisie par l'utilisateur, je ne fais pas confiance à l'utilisateur donc je sécurise mon affichage avec cette fonction htmlspecialchars().

Comme ça si l'utilisateur rentre quelque chose qu'il ne faut pas, Eh bien ce sera affiché en tant que texte comme ici même si ce n'est pas propre plutôt que d'exécuter ce script-là.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?prenom=<script>alert("hacked");</script>
	« Retour au formulaire

	<script>alert("hacked");</script>
```
Alors ça dites-vous que ce n'est rien on peut faire des choses bien pire que cela, et pas besoin d'être un hacker professionnel.

Voilà avec des commandes déjà très très simple, on peut faire des choses assez conséquentes au niveau des sites web donc pensez à ça.

Maintenant que cette parenthèse est faite, on peut terminer et la dernière chose que je voulais vous montrer maintenant donc là on a vu comment transmettre des données d'accord. 

On a parlé des méthodes GET et POST, on a vu comment afficher les données de ces différentes variables `$_GET` et `$_POST` super global.

On a vu comment sécuriser les données saisies par un utilisateur lors de l'affichage avec ces 2 fonctions.
```php
	/*
		htmlspecialchars($str)
		htmlentities($str)
	*/
```
Et on va voir maintenant comment vérifier les informations c'est-à-dire que quand on récupère dans un formulaire et vous l'avez d'ailleurs tout à l'heure. 

Alors on va repasser en POST.
```php
<!-- POST -->
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Formulaire HTML</title>
</head>
<body>
	<h1>Saisie d'informations</h1>

	<form method="post" action="result.php">
		<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
		<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
		<input type="radio" name="choice" id="idchoice" value="non">Non</p>
		<p><input type="submit" name="valid_form" value="valider"></p>
	</form>
</body>
</html>
```
Et là on va repasser en print_r(). Je vais reprendre l'exemple de toute l'erreur qui est un très bon exemple qui montre bien les choses.

+ result.php
```php	
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

	print_r($_POST);

	?>
	</pre>
```
Voilà, on va retourner sur notre formulaire.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+
```
Tout à l'heure j'ai dit que je ne remplissais pas mon formulaire et que je validais tout de suite.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Array
	(
		[user] => 
		[valid_form] => valider
	)
```
Et voilà ce qui s'était passé, on récupère un [user] qui est vide.

On récupère [valid_form] parce qu'on a cliquez sur le bouton. 

Et encore ça [valid_form] en modifiant le code source du HTML et en utilisant notre formulaire, on pourrait ne pas avoir cette valeur-là.

Et on n'a carrément pas le [choice] donc on a même perdu une variable.

Ça veut dire que si on essaie d'afficher, d'exploiter ou de travailler avec cette variable liée au choix, voyez qu'elle n'existe même pas donc ça pose un problème au niveau de la cohérence et de l'intégrité noter données c'est-à-dire qu'il y a des données qui ne sont pas là alors qu'on les attend à la base. 

Alors comment va-t-on pouvoir gérer ça ? admettons par exemple je fais ça.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |		Jason				|
				  +-------------------------+
	Choix : o Oui x Non
	+---------+
	| Valider |
	+---------+
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php?user=Jason&choice=non&valid_form=valider
	« Retour au formulaire

	Array
	(
		[user] => Jason
		[choice] => non
		[valid_form] => valider
	)
```
Là on les a, on retrouve [choice] cette fois-ci.

Alors comment vérifier la cohérence des données et surtout l'intégrité ? 

C'est à dire est-ce qu'elles existent ? est-ce qu'elles contiennent quelque chose ? parce que si elles ne contiennent rien ça peut être problématique aussi. 

Ainsi on va utiliser certaines fonctions de PHP, et là aussi ce que je vais vous montrer là, vous le réutiliserai tout le temps.

À partir du moment où vous allez travailler avec des formulaires HTML avec PHP, vous aurez besoin obligatoirement d'utiliser les fonctions que je vais vous montrer maintenant donc c'est vraiment important. 

Il y a 3 fonctions à connaître principalement bien qu'il y en a évidemment d'autres mais avec ces 3 -là vous pourrez pratiquement tout faire et je vais vous les montrer ici donc on a : la fonction isset(), la fonction empty() et la fonction is_null().
```php
	/*
		isset()
		empty()
		is_null()
	*/
```
Voilà ces 3 fonctions sont très importantes.

Grosso modo histoire de vous donner une définition rapidement, is_null() vérifie qu'une variable est nul et là variable doit exister c'est-à-dire qu'il doit avoir été défini. Cette fonction ne fonctionnera pas sur une variable qui n'existe pas et je vous expliquerai un petit peu plus tard pourquoi. 

empty() va simplement vérifier qu'une variable est vide, après il va falloir que je vous explique ce qu'on entend par vide parce que ça peut vouloir dire pas mal de choses et c'est souvent un cas récurrent d'erreur chez les gens qui apprennent PHP notamment à traiter des formulaires HTML avec PHP.

Et isset() vérifie qu'une variable existe, quel est définie ou qu'elle a été déclarée, c'est la même chose c'est 3 manières différentes pour dire la même chose. Et est non nulle donc elle ne doit pas être nulle.
```php
	/*
		isset()		: Vérifie qu'une variable existe et est non nulle
		empty()		: Vérifie qu'une variable est vide
		is_null()	: Vérifie qu'une variable est nulle (la variable doit exister)
	*/
```
Donc grosso modo ce qu'il faut comprendre, ce que isset() est l'opposé de is_null() à part que isset() par exemple on pourra l'utiliser sur une variable qui n'existe pas. 

D'ailleurs on va faire le test en faisant ça. 

On est d'accord que je n'ai pas de variable `$prenom` et j'essaie alors de faire ce test-là. En fait c'est isset() c'est-à-dire est définis... est-ce qu'elle est définie ? est-ce qu'elle est non nulle ? donc il faut ces deux choses-là.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	
>	if(isset($prenom))
		echo "OUI";
	else
		echo "NON";
	?>
	</pre>
```
Là logiquement ça ne devrait pas fonctionner puisque `$prenom` n'existe pas.

Donc si j'essaye de faire ça, on voit qu'on a Non.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	NON
```
On voit qu'on a Non parce que là variable n'existe pas donc on ne va même pas s'amuser à chercher si elle est nulle ou non, n’existe pas donc pas de problème. 

Par contre si on fait un is_null() de `$prenom`, là on va obtenir ceci. 

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

	if(is_null($prenom))
		echo "OUI";
	else
		echo "NON";
	?>
	</pre>
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire


	Notice:  Undefined variable: prenom in C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\htdocs\PHP\cours\015_forrmulaireHTML\result.php on line 6

	OUI
```
On obtient oui, pourquoi est-ce qu'on obtient oui ? tout simplement parce que is_null() va fonctionner sur quelque chose qui est déjà déclaré donc pour lui quelque chose qui n'est pas déclaré c'est nul puisque ça n'existe pas en fait.

C'est pour ça qu'il va falloir faire attention à la fonction que vous allez utiliser par rapport à l'information à vérifier.

Ça je vais prendre le temps de vous l'expliquer parce que le but c'est que vous ayez quand même bien compris là-dessus et que ce n'est pas forcément évident. Je vous avouerais que c'est pas évident à expliquer parce qu'il y a beaucoup de cas à prendre en compte mais grosso modo ce qu'il faut juste retenir c'est que isset() vérifie que quelque chose n'est pas nul et c'est l'opposé de is_null() qui vérifie qu'une information est nulle d'accord elle vaut null. 

empty() c'est juste pour le fait que l'information est vide. 

Alors je tiens à faire une parenthèse très importante d'accord sur l'utilisation de ces 2 fonctions.

Il y a des moments où des gens ont peut-être dit ou vous dirons par exemple que ça ne sert à rien d'utiliser les 2 et que empty() suffit. 

Il suffit de faire empty() de $prenom.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

	if(empty($prenom))
		echo "VIDE";
	else
		echo "NON VIDE";
	?>
	</pre>
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	VIDE
```
Et donc là $prenom n'existe évidemment pas et là on voit qu'on obtient … alors ici on va arrêter de tout le temps passer par le formulaire … là il nous met vide mais ce n'est pas forcément clair comme information. 

Il nous dit que c'est vide mais c'est pire que ça, ce n'est pas que la variable $prenom est vide c'est surtout que là variable n'existe même pas. 

D'accord donc ça c'est important à prendre en compte parce qu'en réalité pour faire un test suffisamment complet, vous allez devoir bien souvent utiliser les 2 fonctions ici à la fois. Pourquoi ? Parce qu'elles ne vont pas avoir les mêmes comportements selon les cas.

Alors les fonctions isset() et empty() si on prend les 2 -là donc celle qui vérifie qu'une variable existe et quel est non nul donc elle est définie et non nul. Et celle qui vérifie qu'une variable est vide, elles vont être d'accord donc elles vont renvoyer la même chose, elles vont par exemple renvoyer vrai dans certains cas similaires. 

Dans le cas où vous avez … et ça je vous le dis n'hésitez pas à prendre des notes au fur et à mesure, je vais vous noter d'ailleurs ici donc au sujet de isset() + empty() pour ces deux-là, elles vont renvoyer true donc vrai selon plusieurs cas.

Par exemple dans le cas où vous avez une chaîne vide, une chaîne vide c'est en l'occurrence ça `=> ""` donc pas d'espace, pas de caractères blancs, rien du tout, c'est une chaîne vide. 
```php
	/*
		isset() + empty()
		
		TRUE -> chaîne vide
	*/
```
Voilà c'est comme si je faisais ça, `$str = "";`

D'accord ça c'est une chaîne vide ou ça, `$str = '';`

Voilà alors ça, elles vont renvoyer toutes les 2 true, d'accord elles vont renvoyer la même chose du coup on pourrait se dire que ça ne sert à rien d'utiliser les 2. 

Si on veut vérifier qu'une chaîne est vide, inutile d'utiliser ces 2 fonctions, vous pouvez en utiliser qu'une seule des 2. 

Ça va également renvoyer true où on aurait la donnée FALSE.
```php
	/*
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
	*/
```
Si je fais `$maVariable = FALSE;` ça ne sert à rien d'utiliser les 2 ça sert à rien de faire un isset() de ma variable et un empty() de ma variable pour vérifier que c'est égal à FALSE puisque l'une ou l'autre peu importe ça renvoie true si ça contiens false.
```php
	/*
		$maVariable = FALSE;
		
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
	*/
```
D'accord parce que pour elle, false correspond à null en informatique ici donc isset() va forcément retourner vrai mais c'est surtout que $maVariable est égal à FALSE donc c'est égal à faux donc elle n’est ni nulle et ni non définie parce que la variable existe.

Et empty() va considérer que c'est vrai parce que pour lui FALSE c'est quelque chose de vide. Ce n'est pas une donnée qui existe au niveau de empty(). 

Donc c'est pour ça qu'il faut faire attention à ça. 

Alors elles vont retourner true en cas de chaîne vide, en cas de valeur FALSE donc vous voyez on pourrait penser que empty() ça retourne vrai que quand il n'y a rien mais vous voyez que au final pas forcément parce que FALSE est une valeur booléenne, c'est 0, et pourtant empty() va vous retourner true dans ce genre de cas donc faites attention à ça. 

Alors ça peut être aussi dans le cadre d'un tableau vide, que vous l'écrivez avec des crochets [] ou bien avec le mot-clé array() avec des parenthèses. 
```php
	/*
		$maVariable = FALSE;
		
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
				[]
	*/
```
Alors un tableau vide, on peut se dire que c'est normal que empty() retourne true c'est logique. 

Le tableau est vide donc est-ce que c'est vide ? oui mais isset() va retourner true aussi d'accord parce que ça existe et que c'est non nul donc ça retournera true. 

Si vous faites un isset() de ma variable comme ça, `$maVariable = [];` si vous faites isset() de ça va retourner true. 

Si je fais un empty() de ma variable ça va retourner true aussi. 

Et on a le cas où on va avoir la chaîne de caractères à "0", ce qui est un peu logique parce qu'on a dit que FALSE ça retournait true donc forcément comme false correspond à 0, il est logique que ça retourne true par rapport à ce que je vous ai dit.
```php
	/*
		$maVariable = FALSE;
		
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
				[]
				"0"
	*/
```
L'entier 0 aussi parce qu'on ne fait pas de distinction.
```php
	/*
		$maVariable = FALSE;
		
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
				[]
				"0"
				0
	*/
```
Et même le flottant, même si vous avez le nombre flottant 0.0 ou bien 0.000 avec autant de zéros que vous voulez, ce sera évidemment pareil.
```php
	/*
		$maVariable = FALSE;
		
		isset() + empty()
		
		TRUE -> chaîne vide
				FALSE
				[]
				"0"
				0
				0.0
	*/
```
Voilà donc les cas où elles vont se mettre d'accord. 

Effectivement si c'est une de ces valeurs là que vous voulez vérifier seulement … ce qui serait assez bizarre d'ailleurs, ça sert à rien d'utiliser les 2, isset() + empty().

Le problème c'est qu'en web on va rarement utiliser ces fonctions pour simplement vérifier ça.
```php
	chaîne vide
	FALSE
	[]
	"0"
	0
	0.0
```
On va vouloir être sûr qu'on a bien récupéré l'info avec le formulaire, être sûr que la personne dans le champ de formulaire, il a bien tapé quelque chose donc on va vouloir vérifier que là variable existe et que ce n'est pas vide. 

Donc il faudra dans la majorité des cas, tout le temps utiliser les 2 fonctions et j'insiste bien. 

Si vous n'utilisez que empty(), il y a des cas de figure où empty() valider le formulaire c'est-à-dire valider l'information alors qu'en fait ce n'est pas bon. 

Si vous n'utilisez que isset() c'est la même chose alors que si vous utilisez les 2 et que les 2 sont validés, c'est que là vraiment l'information est fiable et vous allez pouvoir commencer à travailler avec. 

Alors je vous le dis par habitude, quand vous travaillez et traitez vos formulaires, faites un test avec les 2 fonctions d'accord c'est-à-dire faire simplement un test, isset() de `$_POST[]` de `$_prenom` comme on l'a vu tout à l'heure donc on va dire est-ce que `$_POST['prenom']` existe et est-ce qu'il n'est pas vide ? donc on met un !.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	if(isset($_POST['prenom']) && !empty($_POST['prenom']))
	{
		
	}
	
	?>
	</pre>
```
Si ça c'est vrai, pour simplifier l'écriture on peut stocker le prénom dans une autre variable parce que réécrire tout le temps `$_POST['prenom']` ça mène à faire des erreurs de frappe et après on peut faire tout un tas de choses avec $prenom comme éventuellement l'enregistrer dans une base de données, l'afficher ou l'enregistrer dans un fichier enfin peu importe on va pouvoir travailler avec parce que là on sait que l'information qu'on a est à priori fiable parce que la donnée a bien été récupérée et en plus elle contient quelque chose.
	
+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php

>	if(isset($_POST['prenom']) && !empty($_POST['prenom']))
	{
		$prenom = $_POST['prenom'];
		
		//plein de choses avec $prenom...
	}
	
	?>
	</pre>
```
On a bien récupéré la donnée et en plus elle contient quelque chose, ça veut dire que la personne a mis son prénom, il n'a pas mis de chaîne vide, il n'a pas mis la valeur FALSE parce que ça veut dire que si jamais par exemple 0 au niveau de mon prénom et bien si vous mettez qu'une seule des 2, et bien ça va valider et il va vous dire que pour lui c'est bon !

Donc il faut faire gaffe à ça, au niveau de isset() notamment donc attention ce que vous voulez vérifier parce que un prénom 0 n'est pas une donnée qui est fiable donc c'est pour ça que c'est important de mettre dans l'idéal les 2 fonctions par rapport à ça. 

En revanche c'est ça qui est important, quels sont les cas où elles vont retourner FALSE ?

Alors isset() va retourner FALSE dans certains cas et empty() va tourner FALSE dans d'autres cas.
```php
	/*
		isset() : FALSE ->
		
		empty() : FALSE ->
	*/
```
Et c'est là qu'il faut effectivement utiliser les 2, que se dire que j'utilise que empty() et que c'est suffisant. Se dire que empty() ça suffit, qu'en fait c'est comme si on testait le isset() en même temps ce n'est pas vrai dans tous les cas.

Sinon dites-vous tout simplement qu'il n'aurait pas créé 2 fonctions différentes.

Si empty() suffisais, Eh bien on aurait juste fait cette fonction là et isset() aurait disparu de PHP depuis un moment donc si elle est encore là c'est qu'elle existe et qu'elle a un intérêt, elle a une utilité. 

Alors isset() va vous retourner false par exemple si vous essayez de lui passer la valeur null. Voilà parce qu'on avait dit que isset() c'était l'opposé de la fonction is_null().
```php
	/*
		isset() : FALSE -> NULL
		
		empty() : FALSE ->
	*/
```
is_null() et simple à utiliser c'est pour ça que limite je n'en parle même pas ou alors très rapidement parce que is_null() retourne true si la valeur est null et false si c'est pas nul donc au moins c'est simple à utiliser.

Mais ce n'est pas ça qui pose problème, ce qui pose souvent problème pour les développeurs web c'est l'utilisation de isset() et empty(), est-ce qu'il faut en utiliser une seule des 2 ? Est-ce qu'il faut les utiliser conjointement ? Dans quels cas utiliser que l'une ou que l'autre ou alors les 2 ? 

Mais moi je vous ai montré que dans l'idéal il faut mieux toujours utiliser les 2, et au moins comme ça vous êtes sûr de faire un maximum de vérification.

Donc isset() si la variable que vous testez est égal à nul, ça va retourner faux. Il considérera que là variable elle est … je rappelle aussi que isset() test si la variable existe et si elle est non nul donc là évidemment ça va retourner faut parce que c'est nul, c'est l'inverse de ce qu'on essaie de tester. 

Ça retournera également false dans le cas où nous avons une déclaration de variable comme ceci.
```php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->
	*/
```
J'utilise le mot-clé var, je déclare ma variable et un ; et je ne lui mets pas de valeur parce que je déclaré ma variable mais je lui affecte aucune valeur. Eh bien pour isset() ça retournera faux tout simplement d'accord. Pour lui, ça il va considérer que c'est comme ça que ça fonctionne, que la variable existe donc elle est bien 'set', elle existe.

Par contre elle n'est pas non nulle parce que comme on peut y stocker un peu n'importe quoi, PHP aura certainement mis une valeur par défaut donc il aura peut être mis nul ou autre chose donc pour lui var $maVariable; ce n'est pas validé.

En revanche empty() l'aurais fait d'accord.

empty() va valider la valeur null et va retourner true.

Et si vous testez empty() de var $maVariable va retourner true.

C'est pour ça que je vous dis attention ces 2 fonctions ne se comportent pas forcément de la même manière suivant ce que vous donnez donc elles ont toutes les 2 leur utilité et elles sont toutes les 2 à utiliser. 

Dans le cas où empty() va retourner false alors que isset() va retourner true d'accord dans le cas où je laisse un espace blanc " ".
```php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
	*/
```
D'accord je laisse un espace blanc et si ça vous testez dans votre formulaire, quand je passe mon formulaire. Si dans l'utilisateur ici je mets des espaces.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |" "						|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+
```
Si je me dis que je fais le test avec seulement empty() pour vérifier, on va se dire super empty() va retourner false mais par contre si vous l'aviez testé avec seulement isset() ça va envoyer true donc voyez qu'on n'aura pas le même résultat à la fin. 

C'est embêtant c'est à dire que si on utilise qu'une seule des 2, en fonction de celle que vous allez utiliser, vous n'aurez pas le même résultat à la fin ce qui est un peu dommage. 

Alors que si vous aviez utilisé les 2, vous seriez sûr au moins d'avoir une information à la fin parce que ça " " en tant que prénom, on ne peut pas l'accepter. 

Pour nous " " n'est rien. 

D'accord un espace ce n'est pas un prénom. 

Donc ça " ", c'est false pour empty(), l'espace, le caractère blanc comme on appelle. 

Le fameux booléen TRUE c'est pareil, pour empty() c'est faux.
```php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
	*/
```
Une variable qui est égale à TRUE, pour empty() ce n'est pas vide d'accord.

Et on a bien évidemment, alors ça ce n'est pas forcément utile c'est à dire l'octet nul, le caractère comme ça soit l'antislash 0, `\0`.

Pareil pour empty() ça va retourner false.
```php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
							\0
	*/
```
Alors que si je fais un isset() de TRUE, ça retournera TRUE. 

Si je fais un isset() de \0, ça retournera TRUE. 

Si je fais un isset() de " ", ça retournera TRUE. 

C'est ça qu'il faut comprendre, ce que tout ce que isset() considère comme FALSE, empty() va le considérer comme TRUE. 
```php
	NULL
	var $maVariable;
```
Et tout ce que empty() considère comme FALSE, isset() va le considérer comme TRUE d'accord elles vont en fait renvoyer un résultat différent.
```php
	" "
	TRUE
	\0
```
Donc attention à ceux qui vous diront qu'il est suffisant d'utiliser empty() c'est-à-dire de faire ça.
```php
>	if(!empty($_POST['prenom']))
	{
		//...
	}
```
Faire ça pour traiter les données de son formulaire et c'est tout parce que empty(), en vous disant que empty() c'est comme si vous utilisiez isset() en même temps, c'est absolument faux parce que vous voyez que dans certains cas, ce ne sera pas le cas. 

Et n'oubliez pas que l'utilisateur c'est rapide, il peut s'il veut un espace blanc c'est-à-dire que vous allez caler sur n'importe quel site au hasard où vous avez des formulaires à valider et vous n'avez qu'à tester un petit espace blanc.

Et si le développeur derrière qui a géré le traitement du formulaire, il n'a pas utilisé les 2 fonctions alors vous avez une chance sur 2 que votre formulaire passe avec des mauvaises données que vous enregistrez de mauvaises choses dans la base de données. 

Vous aurez peut être un nom d'utilisateur qui sera juste un espace, ce qui sera un petit peu embêtant après pour la connexion je pense après sur le site donc attention à ça c'est très important.

Il n'y a pas que j'utilise isset() et dire que ça suffit à lui-même, ou que j'utilise que empty() et que ça suffit à lui-même … non il faut utiliser dans certains cas, et même dans pratiquement tous les cas, les 2.

Moi quand je fais du développement web, je vérifie toujours en faisant un test avec isset() et en faisant un test du coup avec l'inverse de empty(). 

Si vous faites ces 2 là vous serez sûr à priori que l'information est bonne derrière donc ça c'est important. 

La règle est simple encore une fois vous faites juste ça et prenez votre variable et ce sera tout.

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
							\0
	*/

>	if(isset($_POST['prenom']) && !empty($_POST['prenom']))
	{
		$prenom = $_POST['prenom'];
		
		//plein de choses avec $prenom...
	}
	
	?>
	</pre>
```
Voilà c'est tout, vous faites ça pour chacune des variables du formulaire et vous êtes tranquille, vous êtes sûr de ne pas vous tromper. Vous faites un isset() et vous faites l'inverse de empty() comme ça il n'y aura pas de problème et vous faites ça après pour la valeur suivante, ce qui fait qu'en fonction de ce qu'on aura, évidemment on aura un comportement différent. 

On va finir pour terminer cette vidéo quand même avec un cas pratique c'est-à-dire avec le formulaire qu'on a fait, On va venir l'afficher avec htmlspecialchars().

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
							\0
	*/

	if(isset($_POST['prenom']) && !empty($_POST['prenom']))
			echo htmlspecialchars($_POST['prenom']);

	if(isset($_POST['choice']) && !empty($_POST['choice']))
			echo htmlspecialchars($_POST['choice']);
	
	?>
	</pre>
```
Appuyer sur Valider directement, valider sans rien avoir noté.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire
```
Automatiquement je n'ai rien qui s'affiche, logique parce qu'on a fait ici un test complet c'est-à-dire que ça veut dire que comme il n'y a rien de validé, on n'affiche rien et on ne traite pas l'information. 

Dans ce cas on affichera un message d'erreur, on leur enverra sur le formulaire pour dire que la personne n'a pas fait les choses comme il faut, terminé.

Alors si je ne remplis que ça, choix = Non, et j'appuie sur valider.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui x Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	non
```
Voilà on voit que ça affiche que ce qui concerne le choix, on voit qu'on n'a pas récupéré le prénom donc on pourra aussi afficher une erreur pour dire qu'il faut rentrer un nom d'utilisateur donc vous voyez que tous les câbles peuvent être traités en faisant comme ça. 

Et si je saisi bien les 2 ou bien saisir le nom d'utilisateur.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |Jason					|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire
```
Alors là je n'ai rien parce qu'il a carrément arrêté la suite parce que c'était le premier champ de formulaire qui n'a pas marché, donc il n'aura pas en fait géré le choice. 

Et ce qu'on peut faire évidemment c'est de valider les 2.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |Jason					|
				  +-------------------------+
	Choix : x Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	oui
```
Alors là, il doit récupérer user d'où on remplace prenom dans result.php

+ result.php
```php
	<p><a href="index.php">&laquo; Retour au formulaire</a></p>

	<pre>
	<?php
	/*
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
							\0
	*/

	if(isset($_POST['user']) && !empty($_POST['user']))
			echo htmlspecialchars($_POST['user']);

	if(isset($_POST['choice']) && !empty($_POST['choice']))
			echo htmlspecialchars($_POST['choice']);

	?>
	</pre>
```
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |Jason					|
				  +-------------------------+
	Choix : x Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Jasonoui
```
/!\ Et oui forcément il n'aurait pas risqué de la trouver vu que la variable prénom n'existait pas et ainsi on recommence.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire
```
Si je note que le choix (Non) mais que je ne met pas l'utilisateur, et bien il n'affiche que le choix, logique.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |							|
				  +-------------------------+
	Choix : o Oui x Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	non
```
Et si je note que l'utilisateur n'ait pas le choix, il note que l'utilisateur.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |Jason					|
				  +-------------------------+
	Choix : o Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Jason
```
Donc il faudra bien effectivement que je remplisse convenablement et complètement le formulaire pour récupérer toutes les infos.
```txt
	http://localhost/PHP/cours/015_forrmulaireHTML/index.php
	Saisie d'informations
				  +-------------------------+
	Utilisateur : |Jason					|
				  +-------------------------+
	Choix : x Oui o Non
	+---------+
	| Valider |
	+---------+

	http://localhost/PHP/cours/015_forrmulaireHTML/result.php
	« Retour au formulaire

	Jasonoui
```
Voilà donc ça c'est important. 

Si vous voulez pas vous compliquer la tâche parce que j'étais un petit peu long dans les explications et que j'ai peut-être perdu quelques personnes parce que c'était un peu confus. 

La règle à retenir de base après vous prendrez le temps de comprendre par la suite est de l'assimiler avec l'expérience que vous allez acquérir en PHP, c'est que lorsque vous récupérez les données de formulaire. Pour chaque donnée vous testé dans une condition avec la fonction isset() et l'inverse de la fonction empty() tout simplement. 

Vous faites les 2 à chaque fois et vous serez sûr à tous les coups de récupérer l'information comme il faut. 

Et n'oubliez pas de bien protéger tout le temps sécuriser les affichages htmlspecialchars() pour éviter les mauvaises surprises au niveau de vos pages web. 

Voilà je pense avoir fait le tour de tout ce que je voulais vous dire par rapport à ça. 

Alors oui une dernière petite info, évidemment quand isset() retourne true, Hé bien is_null() retourne false et inversement parce qu'on a dit qu'elles étaient opposées cette fonction. 

Donc si vous avez isset() qui retourne true alors is_null() retourne false et inversement, si isset() retourne false alors is_null() retourne true.
```php
	/*
		isset() -> TRUE alors is_null() -> FALSE
		isset() -> FALSE alors is_null() -> TRUE
		
		isset() : FALSE -> 	NULL
							var $maVariable;
		
		empty() : FALSE ->	" "
							TRUE
							\0
	*/
```
Ça ce sont des fonctions proposer, c'est pour ça que je n'ai presque pas parlé de is_null() parce que c'est très simple. Le nom de la fonction dit ce qu'elle fait et elle fonctionne de manière opposée tout simplement. 

C'est un jour par exemple vous voulez vérifier, que le nom de la personne n'est pas nul c'est-à-dire qu'il y a quelque chose, vous faites juste un is_null() tout simplement ou l'inverse si vous voulez vérifier que ça ne l'est pas. 

Voilà comment ça fonctionne, ce sont 3 fonctions : isset(), is_null() et empty() à connaître pour tout ce qui est traitement des données de formulaire pour être sûr d'avoir quelque chose de correct. 

Une fois qu'on a récupéré l'info, qu'on est sûr à priori d'avoir une info, on peu après comme je vous ai dit l'exploiter soit faire juste de l'affichage, soit la sauvegarder dans un fichier, la stocker dans une base de données ou l'envoyer par mail bref je ne sais quoi. 

Bref on peut travailler avec ces données là et les exploiter une fois qu'on a sécurisé et qu'on s'est assuré de bien filtrer les données que nous avons. 

J'espère en tout cas que cette vidéo vous a plu, elle était quand même un petit peu longue parce qu'il y avait beaucoup de choses à aborder et que la sécurité en informatique c'est une partie inhérente. On peut pas faire l'un sans l'autre donc c'est super important de prendre le temps d'expliquer ça est-ce que vous aurez peut être pris pas mal de minutes pour comprendre et assimiler tout ça mais ce sont des nombreuses heures de nombreuses heures qui seront économiser et gagner par la suite quand vous ferez vos développements en PHP et notamment pour tout ce qui concerne le traitement de formulaires HTML. 

Je vous dis à bientôt du coup pour une prochaine vidéo sur cette formation. 

En attendant n'hésitez pas à faire du code, à tester comme ça quelques formulaires et tester la récupération de données et s'il y a des questions ou quelques petites confusions n'hésitez pas à me le dire dans les commentaires. 

À bientôt