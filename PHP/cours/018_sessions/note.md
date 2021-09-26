# [18. Sessions](https://www.youtube.com/watch?v=UgJ21BAt-y0)
30-11-20

Bonjour, bienvenue sur cette formation PHP.

On continue la suite de ce qu'on avait déjà vu avec les cookies dans la séance 17 pour parler maintenant des sessions. 

Je vous avais dit justement que ça allait utiliser un petit peu ce principe de cookie et vous allez voir dans quoi donc on va regarder ça directement sur un code, et on va mettre un peu en pratique tout ce que je vais vous montrer ici. 

La vidéo sera un peu plus longue mais c'est aussi parce que les sessions font appel à de la sécurité donc il va y avoir pas mal de choses sur lequel il va falloir rentrer dans les détails pour que vous compreniez à quoi ça consiste, comment ça fonctionne et que vous utilisiez à bon escient. 

Alors bien souvent les gens pensent que la notion de cession en PHP serre par exemple juste pour faire un système de compte utilisateur. 

Du genre vous avez un site et vous voulez que les gens puissent s'inscrire sur votre site et ensuite s'y connecter. 

Il y a une bonne majorité de personnes qui pensent que les sessions ne servent qu'a ça c'est-à-dire à créer un système d'authentification. 

Alors que pas du tout à la base ce n'est pas du tout fait pour ça, c'est simplement et c'est ça qu'il faut retenir, les sessions permettent d'enregistrer des informations en cours pendant une certaine durée donc le temps de la session en l'occurrence soit jusqu à temps que l'utilisateur ait quitté le site, ferme son navigateur ou alors ait volontairement via une action mis fin à la session.

À partir de là on va pouvoir sauvegarder des informations, stocker des informations sous forme de variables de session justement qui pourront elles transiter contrairement aux données de formulaire d'une page à l'autre de votre site. 

C'est-à-dire que la personne pourra naviguer n'importe où sur votre site tant que la session sera en cours, on aura accès à ces informations.

Et du coup comme la session est propre à l'utilisateur, logiquement sauf s'il y avait piratage ou autre, la session est accessible que pour l'utilisateur qui a ces données donc on va pouvoir utiliser des données sécurisées. 

On pourra par exemple y mettre des données comme un identifiant, on pourra y stocker un panier sur un site e-commerce ou ce genre de chose. 

On peut donc vraiment se servir de ce système de session pour cela. 

Alors ce qu'il faut comprendre parce que ce n'est pas non plus faire trop compliqué parce que ce n'est pas si compliqué que ça à comprendre. Le système de session va enregistrer un cookie … maintenant vous savez ce que c'est … où il va tout simplement sauvegarder un identifiant de session.

Quand on va créer une session, quand on va l'initialiser, on va créer un cookie qui va choisir un identifiant d'accord pour identifier la session en cours de l'utilisateur mais évidemment ça sous-entend pas mal de choses. 

À partir de cet identifiant de session, on va pouvoir du coup travailler avec et c'est dans le navigateur qu'on aura nos données, éventuellement sensible dans certains cas qui sont sauvegardés en session avec lequel nous allons pouvoir travailler. 

Voilà ce qu'il faut retenir, alors l'identifiant de session en PHP, on l'appelle le PHPSESSID d'accord tout simplement.

Donc si un jour vous voyez un cookie qui porte ce nom-là PHPSESSID, c'est tout à fait normal, c'est au niveau de ph p que ça a été créé. 

Ça c'est donc l'identifiant de session en PHP, c'est le nom qu'il porte.

Et à partir de là nous allons pouvoir travailler avec pas mal de données dans une variable super globale également qui est non pas `$_COOKIE` mais `$_SESSION`, et à partir de là on va pouvoir faire tout un tas de choses. 

Ça on va donc le voir tout au long.

Alors avant de pouvoir travailler avec cette variable super globale, il va falloir initialiser, démarrer notre session, et pour cela nous avons une fonction toute faite en PHP qui est également comme setcookie() qui est à placer avant tout code HTML, avant tout espace blanc, avant tout texte. 

Et on va y mettre `session_start();` comme ceci.
```php
	<?php
		/* PHPSESSID */
		session_start();
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
	</body>
	</html>
```
Pareil vous ne devez absolument rien mettre avant, il ne faut pas mettre de code HTML, d'espace, ce genre de chose avant d'appeler cette fonction session_start().

À partir d'ici, on aura démarré notre session et on va pouvoir sauvegarder des informations si on veut. 

L'intérêt que ça va avoir, c'est qu'on va pouvoir passer par notre variable super globale `$_SESSION` qui va permettre du coup de sauvegarder tout un tas d'informations que l'on veut stocker durant toute la durée de vie de la session que nous avons donc ça c'est vraiment important à savoir. 

Quand on n'a plus besoin, quand on a fini de travailler avec la session, on fera un session_destroy(); 

Alors là cession elle va être détruite, elle va être terminée automatiquement au bout d'un tour d'expiration qui est définit d'ailleurs par rapport à votre paramètre de PHP. 

Vous avez en fait la durée de vie d'une session donc vous pouvez toujours le changer si vous voulez, si vous y avez accès en tout cas dans la configuration et à ce moment-là la session sera automatiquement quitté.

Comme l'utilisateur quitte son navigateur, c'est pareil, ça va vous permettre de fermer la session.

Si on veut gérer manuellement ça, via un bouton, via un lien pour se déconnecter, mettre fin à la session ou n'importe quoi et bien on pourra faire appel explicitement à session_destroy(); pareil avant tout code HTML.

Ça c'est à savoir je vais vous les noter ici au niveau des fonctions à connaître pour ceux qui veulent prendre des notes donc vous avez session_start(); et vous avez son inverse session_destroy(); voilà ça ce sont les fonctions à connaître. 

On va donc démarrer ça et à partir de là on peut stocker du coup une information variable de session.
```php
		session_start();
```
Pour cela, on a juste à faire ça exactement comme un tableau associatif qu'on a déjà vu `$_SESSION[]` et puis par exemple 'username' va être stocké.
```php
	<?php
		/* 
			session_start();
			session_destroy();
		*/
		session_start();
		
>		$_SESSION['username'] = 'jachampagne';
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
	</body>
	</html>
```
Voilà on va faire directement, on intègre directement le nom d'utilisateur dans du HTML.
```php
<?php
	/* 
		session_start();
		session_destroy();
	*/
	session_start();
	
	$_SESSION['username'] = 'jachampagne';
?>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= $_SESSION['username'] ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/018_sessions/
	Sessions en PHP
	Bonjour jachampagne
```
J'actualise ma page et on obtient bien l'identifiant d'accord. 

Ce n'est donc pas un cookie, on n'a pas enregistrer un cookie spécifique par exemple pour le nom d'utilisateur. 

Il ne s'agit pas d'un cookie, on a un cookie pour la variable de session donc là vous voyez qu'il y en a un qui a été fait.
```txt
	edge://settings/cookies/detail?site=localhost

	+-----------------------------------------------+
	|	Tous les cookies et données du site			|
	|	/ localhost a stocké des données en local	|
	|												|
	|	Supprimer tout								|
	|	PHPSESSID									|
	|												|
	|												|
	|	Nom											|
	|	PHPSESSID									|
	|												|
	|	Contenu										|
	|	v58ec1u3aqv0ba192hv5pqthdq					|
	|												|
	|	Domaine										|
	|	localhost									|
	|												|
	|	Chemin										|
	|	/											|
	|												|
	|	Envoyer pour								|
	|	Connexions au même site uniquement			|
	|												|
	|	Accessible au script						|
	|	Oui											|
	|												|
	|	Créé										|
	|	lundi 30 novembre 2020 à 14:51:36			|
	|												|
	|	Expire										|
	|	Quand la session de navigation se termine	|
	+-----------------------------------------------+	
```
Là vous voyez qu'un copie a été fait (localhost) mais c'est tout c'est juste pour l'identifiant de session mais pas pour autre chose. 

Du coup on peut vraiment enregistrer plein d'infos, on peut vraiment avoir tout un tas de choses après ça peut être je ne sais pas quoi mais on peut vraiment y mettre plein d'informations. 

Par exemple ça peut être un panier ou un montant actuel donc vraiment vous enregistrer n'importe quelle information ici avec `$_SESSION`. 
```php
	...
	session_start();
	
	$_SESSION['username'] = 'jachampagne';
	$_SESSION['age'] = ...;
	...
```
Pour modifier une valeur c'est comme une simple variable de tableau, il suffit de changer la valeur et ça se change. 
```php
<?php
	/*
		session_start();
		session_destroy();
	*/
	session_start();
	
	$_SESSION['username'] = 'Jason';
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= $_SESSION['username'] ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/018_sessions/
	Sessions en PHP
	Bonjour Jason
```
Voilà ça se change donc ça je ne reviens pas dessus, c'est des choses que vous savez déjà faire. 

Vous savez manipuler à ce stade de la formation, les variables et les tableaux donc il ne devrait pas y avoir de problème à ce niveau-là. 

Et c'est tout. 

Et pour les afficher, si c'est une donnée qui a été enregistrée automatiquement, vous n'avez pas forcément besoin de la sécuriser.
```php
>	<p>Bonjour <?= $_SESSION['username'] ?></p>
	...
```
Par contre si c'était une donnée qui venait de l'utilisateur, par exemple l'utilisateur s'est inscrit et il a choisi lui-même son nom d'utilisateur et à ce moment-là vous l'enregistrer en session. 

Comme ça vient de l'utilisateur, on n'oublie pas tout l'temps tout l'temps tout l'temps quand on n'est pas sûr de la provenance des données de toujours toujours sécuriser l'affichage.
```php
>	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	...
```
```php
<?php
	/* 
		session_start();
		session_destroy();
	*/
	session_start();
	
	$_SESSION['username'] = 'Jason';
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/018_sessions/
	Sessions en PHP
	Bonjour Jason
```
Comme ça si un jour il s'amuse à mettre du HTML ou du javascript.
```php
<?php
	/*
		session_start();
		session_destroy();
	*/
	session_start();
	
	$_SESSION['username'] = '<strong>Jason</strong>';
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/018_sessions/
	Sessions en PHP
	Bonjour <strong>Jason</strong>
```
Toujours pareil on en revient toujours à peu près au même discours, on va échapper les caractères donc on n'aura pas l'interprétation du javascript ou des balises HTML.

Ce qui est quand même bien mieux à ce niveau-là. 

Voilà ça c'est la base pour les sessions. 

Au moment où j'enregistre cette vidéo je n'ai pas fait de tuto là dessus mais je ferais sûrement un tutoriel pour créer un système d'authentification en PHP avec les sessions parce que c'est un petit peu le truc obligatoire qu'on fait un petit peu sur tous les sites web. 

Je vais donc vous faire ce qui n'a pas été fait au moment où je fais cette vidéo, je vais vous faire un tuto et peut-être que au moment où d'autres regarderont cette vidéo, le tuto aura peut-être déjà été publié entre temps vous trouverez dans la playlist PHP tutoriel une vidéo sur la création d'un système d'authentification en PHP.

Vous aurez ça.

Alors voilà pour la base. 

On peut également supprimer une variable précise de session avec la fameuse fonction unset(). 

On la connaît bien cette fonction, il suffit de lui passer la variable en paramètre mais elle va en fait enlever la définition d'une variable c'est-à-dire qu'elle va la supprimer. 
```php
	<?php
		/* 
			session_start();
			session_destroy();
		*/
		session_start();
		
		$_SESSION['username'] = '<strong>Jason</strong>';
		
		unset($SESSION['username']);
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Alors attention ne faites jamais un unset() sur la variable `$_SESSION` tout court sinon vous ne pourrez plus réutiliser les sessions, vous aurez des petits soucis à ce niveau-là. 
```php
	/!\ unset($_SESSION)
```
Faites gaffe de ne pas utiliser le ça là-dessus, vous ne pouvez pas le faire et il ne faut pas le faire. 

C'est automatiquement sur une variable en particulier.
```php
	unset($_SESSION['username'])
```
Ça c'est à connaître. 

Si vous vouliez supprimer toutes les variables de session, on va regarder d'autres sessions qui vont nous permettre de le faire. 

Voilà en tout cas la base si on veut garder un petit peu ce système de cession qui est important. 

On va passer maintenant au niveau paramétrage parce que je vous avais dit que les sessions font appel à de la sécurité c'est à dire qu'on va vérifier … ça c'est une chose que certains ne font pas forcément mais nous on va le vérifier pour être sûr que au niveau de la configuration de PHP, nous avons un minimum de sécurité au niveau des sessions. 

Logiquement surtout si vous avez comme au début du cours, installer vous-même Apache puis ensuite l'interpréteur PHP, normalement la configuration de PHP par défaut n'est pas trop mal. 

Le PHP 7 a pratiquement tout correct et il n'y a pratiquement rien à changer mais si vous êtes sur une autre configuration ou si vous passez par un hébergeur en ligne, je ne sais pas comment sera la configuration. 

Si vous avez donc accès que ce soit en local ou depuis un hébergeur quel qu'il soit au fichier php.ini, vous savez le fichier de configuration PHP.
```txt
	C:\Users\sam\OneDrive\Formations\FormationVideo\MyWAMP\apache\php.ini
```
On va aller vérifier un certain nombre de choses et je vais vous les expliquer du coup. 

Alors comme il y a beaucoup de ligne on va faire une recherche, ça évitera de tout taper nous-mêmes. 

On va chercher `session.cookie_lifetime`.
+ php.ini
```ini
	; Lifetime in seconds of cookie or, if 0, until browser is restarted.
	; http://php.net/session.cookie-lifetime
	session.cookie_lifetime = 0
```
Alors la description est en anglais mais je vous le dis quand même parce que c'est important que vous sachiez, ce paramètre va permettre de définir si ce cookie sera stocké de manière permanente. 

Attention on parle bien du cookie de session pour l'identifiant de session donc nous dans l'idéal, on veut qu'il le soit donc vérifiez que ce paramètre est égal à 0.

Alors soit c'est 0 et ça correspond à off c'est-à-dire que vous pouvez mettre le 0 ou le mot off.
```ini
	session.cookie_lifetime = 0
	;ou
	session.cookie_lifetime = Off
```
Bien sûr si vous mettez 1 ça correspond à On. 

Vous verrez que dans certains qu ils mettent On/Off et dans d'autres cas ils mettent 1/0. 

Moi donc par défaut de base sur le fichier php.ini, ils utilisaient des chiffres donc j'ai gardé les chiffres pour ne pas tout mélanger. 

Donc celui-là assuré vous que `session.cookie_lifetime` est égal à 0 ce qui est très important.

Ensuite l'autre paramètre que nous allons devoir vérifier c'est `session.use_cookies`.
```ini
	; Whether to use cookies.
	; http://php.net/session.use-cookies
	session.use_cookies = 1
```
Alors celui-là c'est tout simplement pour lui dire de stocker les sessions en tant que cookie parce que oui on pourrait utiliser les sessions d'une autre manière mais nous on veut travailler de cette manière là parce que au moins on est sûr d'avoir quelque chose d'un peu plus efficace.

Voilà enregistrer un identifiant de session en tant que cookie, c'est ce qui se fait de mieux pour le moment en tout cas à l'heure actuelle, ce sera peut-être différent dans 10 ans on n'en sait rien mais en tout cas c'est ce qu'il y a de mieux au niveau de l'enregistrement de l'identifiant de session donc on veut forcer l'utilisation des cookies pour cela. 

Je vais donc vérifier que la variable est égal à 1 ou On.

Si c'était pas le cas n'hésitez pas à la changer à ce moment-là.

Ensuite on va vérifier qu'on n'utilise que des cookies et là normalement il y en a 2, il y avait `session.use_only_cookies` voilà elles ne sont pas très loin l'une de l'autre.
```ini
	; This option forces PHP to fetch and use a cookie for storing and maintaining
	; the session id. We encourage this operation as it's very helpful in combating
	; session hijacking when not specifying and managing your own session id. It is
	; not the be-all and end-all of session hijacking defense, but it's a good start.
	; http://php.net/session.use-only-cookies
	session.use_only_cookies = 1
```
Pareil vérifier qu'elle est bien à 1, c'est pour forcer PHP à maintenir et à utiliser les cookie pour sauvegarder notre identifiant de session et non pas autre chose donc c'est très important. 

Ça évitera comme ça par exemple que quelqu'un tente une injection d'identifiant de session.

On parle donc ici vraiment en terme de sécurité, il faut y penser.

D'ailleurs vous pouvez voir que le nom de la session vous l'avez ici pour faire une parenthèse. 
```ini
	; Name of the session (used as cookie name).
	; http://php.net/session.name
	session.name = PHPSESSID
```
C'est vraiment vous vouliez changer le nom vous pouvez le faire mais bon forcément ça n'a pas vraiment d'intérêt. 

En tout cas vous voyez qu'effectivement le nom est là que je vous ai donné tout à l'heure.

Alors qu'est-ce qu'on peut paramétrer d'autres également, alors oui il y a le mode strict qui est très important qui est `session.use_strict_mode`.
```ini
	; Whether to use strict session mode.
	; Strict session mode does not accept an uninitialized session ID, and
	; regenerates the session ID if the browser sends an uninitialized session ID.
	; Strict mode protects applications from session fixation via a session adoption
	; vulnerability. It is disabled by default for maximum compatibility, but
	; enabling it is encouraged.
	; https://wiki.php.net/rfc/strict_sessions
	session.use_strict_mode = 1
```
Alors le use.strict_mode doit être mis à 1 ou On, c'est très important aussi. Il va tout simplement empêcher un identifiant qui n'a pas été initialisé c'est-à-dire que s'il y a une session avec un identifiant non initialisé, et bien tant pis il n'y aura pas de session. 

Au pire on créera une nouvelle, on ferra quelque chose mais on veut absolument utiliser des sessions qui ont des identifiants initialisés. 

Encore une fois c'est pour prévenir des tentatives d'injection d'identifiants ou autre par un éventuel attaquant, un éventuel pirate donc on essaye de protéger à ce niveau-là.

Alors comme pour les cookies, on n'a pas envie que les cessions traîne avec du javascript donc c'est normalement `session.cookie_httponly`.
```ini
	; Whether or not to add the httpOnly flag to the cookie, which makes it
	; inaccessible to browser scripting languages such as JavaScript.
	; http://php.net/session.cookie-httponly
	session.cookie_httponly = 1
```
Donc-là c'est pareil, vous vérifier qu'il est bien à 1.

Toujours pareil ça évitera l'accès au cookie via javascript comme on l'avait vu dans la vidéo précédente donc très important à vérifier aussi au niveau des paramètres. 

Alors pour le https on va avoir la même chose ici.
```ini
	; http://php.net/session.cookie-secure
	;session.cookie_secure =
```
Si vous utilisez https, il faudra décommenter ce paramètre et le mettre à 1. 

Moi donc comme je suis juste en http, je peux le laisser comme ça il n'y a pas de problème donc ça c'est à voir en fonction de votre plateforme enfin le projet sur lequel vous bossez. 

Est-ce que vous êtes en https ou non. 

Voilà au niveau de tout ce qui est paramétrage, tout ce qui est cookie par rapport à la session donc ça normalement c'est bon. 

Ensuite qu'est-ce qu'on peut voir aussi ?

On va voir ça.  
```ini
	; trans sid support is disabled by default.
	; Use of trans sid may risk your users' security.
	; Use this option with caution.
	; - User may send URL contains active session ID
	;   to other person via. email/irc/etc.
	; - URL that contains active session ID may be stored
	;   in publicly accessible computer.
	; - User may access your site with the same session ID
	;   always using URL stored in browser's history or bookmarks.
	; http://php.net/session.use-trans-sid
	session.use_trans_sid = 0
```
Ça c'est très important, ça va tout simplement supprimer la possibilité ce qu'on avait dit tout à l'heure donc la possibilité d'injecter un identifiant de session d'accord. 

Ça veut dire tout simplement que les identifiants de session ne seront pas transparent.

On ne va pas utiliser l'identifiant transparent donc invisible ou autre, on va le spécifier volontairement. 

On va donc limiter le risque d'injecter, qu'il y ait une injection d'identifiant de session. 

Évidemment donc tous ces paramétrages là ne vous assurons jamais une sécurité à 100%. 

Vous savez que sécuriser un système à 100% en informatique c'est impossible mais en tout cas quand on peut limiter et mettre des bâtons dans les roues aux pirates c'est toujours mieux de procéder comme ça.   

Assurez vous qu'il est à 0 ou à off c'est-à-dire le `use_trans_sid`. 

Ensuite on va avoir ceci. 
```ini
	; Set to {nocache,private,public,} to determine HTTP caching aspects
	; or leave this empty to avoid sending anti-caching headers.
	; http://php.net/session.cache-limiter
	session.cache_limiter = nocache
```
Vous le mettez à nocache tout simplement pour ne pas avoir un cache de l'identifiant de session, ce qui est très important aussi parce que le but c'est de s'assurer que la session est bien valide valable et qu'elle est bien initialisé donc on veut certainement pas que cette session en soit mise en cache. 

Pour éviter donc ça on met en nocache comme ça il n'y aura pas de problème. 

Vous voyez qu'il y a plusieurs paramètres : private, public donc en fonction. 

Si vous aviez besoin d'utiliser autre chose vous pouvez également vous renseigner et d'ailleurs on vous met le lien vers la doc.

http://php.net/session.cache-limiter

Le lien vers la doc qui en fait référence pour voir un petit peu quoi choisir en fonction mais dans la majorité des cas, le nocache sera très bien. 

Tous les paramètres que je vous ai montré jusqu à présent, était déjà défini comme ça chez moi dans le php.ini qu'on avait installé au tout début de la formation. 

Logiquement si vous avez fait donc comme moi, vous devriez quand même avoir quelque chose de bien paramétré parce que PHP déjà paramétré comme ça par défaut parce qu'ils savent, ils connaissent bien leurs outils et ils savent que comme ça ça va limiter pas mal de choses. 

Par contre la seule chose que je n'avais pas trouvé et c'est pour ça que je l'avais ajouté en fin de fichier c'était au niveau du hachage pour tout ce qui est id de session. 

C'est-à-dire que par défaut on va utiliser un hash qui n'est pas forcément top, je pense que c'est du MD5 encore même si c'est mieux que rien. 

En effet c'est juste un identifiant de session, ce n'est pas comme si c'était un mot de passe donc ce n'est pas non plus très très grave mais si on peut quand même lui mettre un système de hash un petit peu plus puissant, c'est toujours mieux. 

Donc moi j'ai ajouté en fin de fichier parce qu'il n'y était pas. 

Je ne l'ai pas trouvé dans les paramètres de php.ini même si j'étais étonné mais peu importe. 

J'ai ajouté donc ça.
```ini
	; AJOUT UTILISATEUR
	session.hash_function = "sha256"
```
Et donc là vous avez pu définir une valeur, je crois même qu'on a des numéros en fonction des types de hash et je crois qu'on doit pouvoir les récupérer en PHP. 

Je pense qu'il y avait une fonction pour faire ça, on va regarder. 

Alors au minimum mettez "sha256" d'accord c'est pas mal. 

Vous avez également "sha512" qui peut être efficace. 

Vous avez également "sha384" entre les 2. 

Bref vous aurez quelque chose comme ça d'un peu plus sécurisé. 

Et si vous voulez la liste comme il me semble qu'il y avait une fonction en PHP je veux la faire ici.
```php
<?php
	/* 
		session_start();
		session_destroy();
	*/
	session_start();
	
	$_SESSION['username'] = 'Jason';
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	
	<pre>
	<?php print_r(hash_algos()) ?>
	</pre>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/018_sessions/
	Sessions en PHP
	Bonjour Jason

		Array
	(
		[0] => md2
		[1] => md4
		[2] => md5
		[3] => sha1
		[4] => sha224
		[5] => sha256
		[6] => sha384
		[7] => sha512/224
		[8] => sha512/256
		[9] => sha512
		[10] => sha3-224
		[11] => sha3-256
		[12] => sha3-384
		[13] => sha3-512
		[14] => ripemd128
		[15] => ripemd160
		[16] => ripemd256
		[17] => ripemd320
		[18] => whirlpool
		[19] => tiger128,3
		[20] => tiger160,3
		[21] => tiger192,3
		[22] => tiger128,4
		[23] => tiger160,4
		[24] => tiger192,4
		[25] => snefru
		[26] => snefru256
		[27] => gost
		[28] => gost-crypto
		[29] => adler32
		[30] => crc32
		[31] => crc32b
		[32] => crc32c
		[33] => fnv132
		[34] => fnv1a32
		[35] => fnv164
		[36] => fnv1a64
		[37] => joaat
		[38] => haval128,3
		[39] => haval160,3
		[40] => haval192,3
		[41] => haval224,3
		[42] => haval256,3
		[43] => haval128,4
		[44] => haval160,4
		[45] => haval192,4
		[46] => haval224,4
		[47] => haval256,4
		[48] => haval128,5
		[49] => haval160,5
		[50] => haval192,5
		[51] => haval224,5
		[52] => haval256,5
	)
```
Voilà j'actualise et comme ça vous voyez que vous avez un identifiant en fonction. 

C'est par exemple donc dans le fichier que vous mettez, "sha256", vous pouvez mettre l'identifiant 5 c'est à dire qu'ici vous allez pouvoir marquer le chiffre 5.
```ini
	; AJOUT UTILISATEUR
	session.hash_function = 5
```
Et logiquement ça devrait prendre en compte le type de hash que vous voulez. 

Par contre si vous voulez noter le nom exact, il faut prendre celui qui a été donné par PHP et au pire si vous avez peur de vous tromper, vous faites un copier coller et vous le mettez sous forme de chaîne.
```ini
	; AJOUT UTILISATEUR
	session.hash_function = "sha256"
```
Voilà comme ça ça utilisera ce type de hash pour l'identifiant de session donc voilà ça c'était le dernier paramètre à voir ou en tout cas les paramètres qui me semblait important à voir. 

Il y en a sûrement d'autres pour configurer les sessions mais déjà cela avec la vérification de la configuration et le paramétrage de ces différentes variables, vous aurez déjà quelque chose de pas mal sécurisé et beaucoup plus robuste que ça peut être par défaut sur certaines vieilles configurations. 

Surtout si vous n'êtes pas sûr du PHP 7 mais sur les versions antérieures, n'hésitez pas à vérifier le php.ini parce qu'il y a de fortes chances qu'il y ait des choses à modifier pour que ce soit un peu plus efficace. 

Vous avez pu voir donc il y avait beaucoup de systèmes de hash donc n'hésitez pas à voir un petit peu mais cela sont très bien.
```txt
		[4] => sha224
		[5] => sha256
		[6] => sha384

		[9] => sha512
```
Voilà ils sont déjà très bien et vous pouvez vous servir de ceux-là. 

Voilà au niveau de la configuration, on a fait le tour. 
```txt
	+-----------------------------------+
	| php.ini							|
	| -------							|
	| session.cookie_lifetime = 0		|
	| session.use_cookies = 1			|
	| session.use_only_cookies = 1		|
	| session.use_strict_mode = 1		|
	| session.cookie_httponly = 1		|
	| ;session.cookie_secure =			|
	| session.use_trans_sid = 0			|
	| session.cache_limiter = nocache	|
	| ; AJOUT UTILISATEUR				|
	| session.hash_function = "sha256"	|
	+-----------------------------------+
```
Je vous avais dit qu'il n'y avait pas mal de choses à voir sur cette vidéo mais ça a aussi toute son importance. 

Si vous utilisez mal les sessions en PHP, vous risquez tout un tas de vulnérabilités sur vos sites web et après c'est plus compliqué de guérir alors que c'est quand même plus efficace de prévenir avant. 

On a donc normalement tout vu ici. 

Alors moi je vais vous proposer parce que tant qu'a faire les choses bien, je vais maintenant vous proposer un petit système pour voir comment initialiser vos sessions habituellement au minimum avec un système minimal, et comment vous pouvez les détruire correctement donc comment pouvez-vous terminer une session correctement. 

Pour cela il n'y a pas mal de petites choses. 

Déjà en général je me fais une petite fonction quand on veut gérer des sessions c'est-à-dire une petite fonction à part, vous pouvez la faire dans un autre fichier ou n'importe quoi en fonction de comment est fait votre application. 

Alors il faut que cette fonction pour initialiser vos sessions, elles soient faites de 2 manières. 

Alors déjà on va faire une petite condition et on va utiliser la fonction session_id() que je vais noter en commentaire.
```php
	<?php
	/* 
		session_id();
		session_start();
		session_destroy();
	*/
>		if(!session_id())
	?>

	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
session_id() va nous retourner en identifiant de session si évidemment il y a quelque chose sinon ça nous retournera rien du tout, ça ne retournera je crois une chaîne vide en ce qui concerne session_id().

Dans ce cas-là on va faire cette vérification, si nous n'avons pas d'identifiant c'est-à-dire que nous aurions une chaîne vide et donc que ça n'existe pas, on va pouvoir démarrer une session ce qui éviterait de recréer une session alors qu'il y en a déjà une en route. 

Ça évitera comme ça d'appeler bêtement les fonctions pour rien, on peut faire à ce moment-là un session_start() et ça je ne vous dis pas mais c'est pareil mais ses fonctions session_id() comme pour toutes les fonctions liées aux sessions, elles retournent true en cas de réussite et false en cas d'erreur.  
```php
	<?php
	/*
		session_id();
		session_start();
		session_destroy();
	*/
		if(!session_id())
		{
>			session_start();
		}
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Alors n'hésitez pas bien sûr dans un code voilà correct complet dans un vrai projet, à tester le retour des fonctions.

Là session_start() vérifier qu'elle ne retourne pas false sinon il faudrait gérer les erreurs via un système d'exception ou autre donc n'hésitez pas à voir tout ça. 

Après les exceptions les a pas encore vu parce que c'est de l'objet mais au moins gérer les erreurs et ça on l'a vu parce qu'on a fait une vidéo dessus en PHP.

On démarre donc la session, et on va régénérer l'identifiant ici, que je vais mettre à true.
```php
	<?php
	/* 
		session_id();
		session_start();
		session_destroy();
	*/
		if(!session_id())
		{
			session_start();
>			session_regenerate_id(true);
		}
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
En mettant comme paramètre true à cette fonction session_regenerate_id(), ça va en faite supprimer l'ancien.

Alors pourquoi ? tout simplement pour pouvoir re générer un nouvel identifiant pour être sûr qu'on part sur une session nouvelle donc c'est pas mal de passer par ça et moi je vous le recommande session_regenerate_id([true]) avec true entre crochet parce que ce n'est pas obligatoire mais c'est même mieux de le mettre pour supprimer l'ancienne session comme ça vous êtes sûr de supprimer les anciens identifiants.
```php
	/* 
		session_id();
		session_start();
		session_regenerate_id(true);
		session_destroy();
	*/
```
Vous faites donc ça, vous vérifiez qu'il n'y ait pas une session existante : `if(!session_id()){}`

Si ce n'est pas le cas, on la démarre : `session_start();`

Et on régénère l'identifiant de cette session : `session_regenerate_id(true);`

Comme ça on est sûr de repartir sur un truc tout neuf et tout beau, et comme ça on peut commencer à travailler. 

À partir de là, vous allez pouvoir enregistrer vos informations en session comme on l'a vu tout à l'heure, vous allez pouvoir les afficher et cetera et cetera.
```php
	<?php
	/* 
		session_id();
		session_start();
		session_regenerate_id(true);
		session_destroy();
	*/
		if(!session_id())
		{
			session_start();
>			session_regenerate_id(true);
		}
		
		//On fait des choses avec les sessions...
		$session..
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Et puis à un moment donné quand vous voulez mettre fin à la session quelque part, sur une autre page mais moi je le fais sur une seule pour ne pas trop compliqué la vidéo et ne pas la rallonger non plus. 

On va pouvoir mettre fin à la session donc le minimum pour mettre fin à la session, c'est déjà de supprimer toutes les variables enregistrées en session en premier lieu. Vous utilisez `session_unset();` et ça ça évite de devoir faire un `unset($_SESSION['…']);` de username ou autre chose donc voyez pour le faire pour chacune des variables que vous avez enregistrer et ça risquerait d'être long.
```php
	<?php
	/* 
		session_id();
		session_start();
		session_regenerate_id(true);
		session_unset();
		session_destroy();
	*/
		if(!session_id())
		{
			session_start();
			session_regenerate_id(true);
		}
		
		//On fait des choses avec les sessions...
		$session..
		
>		session_unset();
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Alors que si je fais un `session_unset();` et vous pouvez ensuite faire éventuellement le `session_destroy();`
```php
	<?php
	/* 
		session_id();
		session_start();
		session_regenerate_id(true);
		session_unset();
		session_destroy();
	*/
		if(!session_id())
		{
			session_start();
			session_regenerate_id(true);
		}
		
		//On fait des choses avec les sessions...
		$session..
		
		session_unset();
>		session_destroy();
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Voilà et là on met fin à tout ça. 

Ça c'est vraiment le minimum. 

On utilise cela pour démarrer une session.
```php
		if(!session_id())
		{
			session_start();
			session_regenerate_id(true);
		}
		...
```
Et ça pour mettre fin de session.
```php
		...
		session_unset();
		session_destroy();
```
Avec ça vous êtes tranquille, c'est vraiment le minimum vital. 

Après on peut encore aller plus loin c'est-à-dire que ce qu'on pourrait faire carrément c'est initialiser la session parce qu'il faut bien évidemment qu'elle soit initialisée avant de pouvoir la terminer, c'est obligatoire. 

Il faudra mettre le session_start() sur chaque début de vos pages web au moment où vous utilisez les sessions c'est à dire qu'à chaque endroit où vous voulez vous servir de vos sessions au tout début de vos fichiers avant tout code HTML, vous devez appeler cette fonction `session_start();` ce qui est très important. 

N'hésitez donc pas à faire `session_start();` et éventuellement même celle là `session_regenerate_id();` pour être sûr d'avoir un identifiant à chaque fois. 

Ensuite ce qu'on pourrait faire c'est un session_unset(). Alors ici je vous dis ce qu'on pourrait faire en termes de nettoyage de session mais vraiment complet c'est-à-dire que on va d'abord initialiser pour dire qu'on utilise les sessions session_start() et ensuite on supprime toutes les variables de session avec session_unset() et ça on l'a déjà vu. 

Ensuite on détruit la session, `session_destroy();` d'accord. 

Ensuite on va utiliser une autre fonction qui est `session_write_close();` qui va mettre fin à tout et après supprimer la session donc c'est encore un truc supérieur, encore un cran au-dessus.
```php
	/* 
		session_id();
		session_start();
		session_regenerate_id(true);
		session_unset();
		session_destroy();
		session_write_close();
	*/
```
Ensuite on va modifier le cookie d'identifiant de session en lui stockant une nouvelle valeur donc c'est à dire une valeur vide. 

Alors on a notamment, je vous donne les fonctions peut-être qu'un jour vous vous en servirez c'est-à-dire session_name() qui permet de récupérer ou de modifier le nom de la session donc l'identifiant en l'occurrence par rapport à ce qu'on a. 
```php
	/* 
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
	*/
```
Et là on pourrait faire, un setcookie() tout simplement où on cherche le cookie qui porte ce nom là session_name() donc on utiliserait bien cette fonction là. Et on lui met du coup une valeur vide, et on lui met un temps d'expiration de 0 c'est à dire qu'il prend expiration tout de suite. 

Ça ce serait une sécurité en plus pour être sûr d'avoir vraiment supprimé l'identifiant de session, et ensuite on referait du coup une session_regenerate_id() c'est-à-dire une régénération d'un nouvel identifiant pour repartir sur un truc.

Ça on va dire que c'est la technique un peu bourrin c'est à dire pour être sûr qu'on a viré tout tout tout sur une session donc si je devais le noter, on va le noter ici et on retire le reste.
```php
	<?php
	/* 
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
	*/
		if(!session_id())
		{
			session_start();
			session_regenerate_id(true);
		}
		
		//On fait des choses avec les sessions...
		$session..
		
		session_unset();
		session_destroy();
		
>

	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Voilà le code qui sera à faire pour supprimer complètement toute une session, tout effacer de manière sûre. 

On démarre la session au tout début de notre fichier. Avant on aurait le code HTML et cetera.
```php
	<?php
	/* 
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
	*/
		
>		session_start(); //au début du fichier, avant tout code HTML

	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Ici on part du principe qu'on supprime tout donc on fera une régénération à la fin éventuellement. 

On démarre en faisant un `session_unset();` qui permet d'effacer toutes les variables et ensuite on ferra un `session_destroy();` et donc ici on supprimerait la session. Ensuite on ferrait un `session_write_close();`
```php
		session_start();
>		session_unset();
>		session_destroy();
>		session_write_close();
```
On écrit effectivement la fermeture des sessions et on la supprime, ce qui est très important. Ensuite on modifie le cookie donc setcookie() donc on va utiliser comme je n'ai pas forcément envie d'avoir le nom ici je vais mettre session_name() d'accord pour son retour. On peut faire ça évidemment sans problème.
```php
		session_start();
>		session_unset();
>		session_destroy();
>		session_write_close();
>		setcookie(session_name(), '', 0, null, null, false, true);
```
On lui met la valeur vide '' voilà aucune valeur. L'expiration c'est tout de suite donc on lui met 0 et puis voilà null, null, false, true voilà.

Et ensuite la régénération de l'identifiant que l'on met à true pour enlever l'ancien.
```php
	<?php
	/* 
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
	*/
		
		session_start();
>		session_unset();
>		session_destroy();
>		session_write_close();
>		setcookie(session_name(), '', 0, null, null, false, true);
>		session_regenerate_id(true);


	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Alors ça c'est vraiment la méthode de bourrin, vous n'aurez peut-être pas forcément besoin d'aller jusque là mais pour ceux vraiment qui sont un petit peu parano et qui ont vraiment envie de tout tout tout virer, ça c'est ce qu'il faut faire quand on veut mettre fin à une session et la supprimée.

C'est vraiment le maximum un peu de ce qu'on peut faire pour être sûr que tout est bien enlevé. 

Vous voyez qu'on fait chaque étape. On dit qu'on utilise les cessions start(), on vir toutes les variables qu'on a stockées en session unset() donc toutes les variables stockées comme ça dans notre tableau associatif de `$_SESSION[]`.
```php
	$_SESSION['username']
```
Ensuite on détruit la session detroy(). Ensuite on enregistre bien la fin de la session et on la supprime session_write_close().

On modifie le cookie éventuelle qui a pu rester en lui mettant une expiration tout de suite c'est-à-dire en changeant sa valeur à 0 et en lui mettant une valeur vide, voilà comme ça là on sera sûr que l'identifiant ne sera plus stocké dans le navigateur web dans le fichier du cookie.
```php
	setcookie(session_name(), '', 0, null, null, false, true);
```
Et on régénère un nouvel identifiant donc on repart sur un nouveau truc et donc on est sûr qu'on a perdu tout ce qu'il y avait avant. 

Ça c'est donc vraiment le maximum que vous pouvez faire si vous voulez nettoyer proprement une session. Je vous le donne ainsi n'hésitez pas à mettre en pause et noter ça si vous voulez, si ça vous intéresse éventuellement mais voilà.
```php
		session_start();
		session_unset();
		session_destroy();
		session_write_close();
		setcookie(session_name(), '', 0, null, null, false, true);
		session_regenerate_id(true);
```
Voilà j'ai fait le tour des fonctions qui pouvait être intéressant ici et normalement je vous ai donné tout ce qu'il y avait savoir il n'y a pas grand-chose d'autre à savoir au niveau des sessions. 

Vous avez grosso modo tout ce qu'il y a à savoir par rapport à ça. 

N'hésitez pas d'accord vous avez compris un peu le système, une session ce n'est pas forcément pour enregistrer un compte utilisateur. 

C'est juste que sur un site marchand on peut enregistrer l'état d'un panier, on peut enregistrer des informations précises par rapport à ce que fait un utilisateur comme action que l'on veut garder. 

On peut faire un système de notifications aussi avec les sessions par conséquent une personne la et du coup quand il y a une action qui s'est produite, on peut lui mettre un petit message en javascript, en lui notifiant qu'il s'est passé telle ou telle chose. 

On peut donc faire ça du coup avec les sessions, c'est pas mal pratiqué et c'est très utilisé pour cela. 

Retenez bien que les sessions c'est simplement de stocker des informations, y compris sécurisé, y compris privé tout au long de la navigation de l'utilisateur sur les pages de votre site web d'accord. 

C'est pas juste un petit fichier qui est enregistré et ce n'est pas comme avec un formulaire où on transmet en fait les données du formulaire jusqu à une page de résultats et après c'est perdu. 

Vous avez vu qu'avec le formulaire, une fois que vous avez passé la page de résultats, les données ne sont évidemment pas sauvegardés. `$_GET` et `$_POST` après ne sont plus disponibles donc c'est juste le temps du formulaire. 

La évidemment ça restera beaucoup plus longtemps. 

Voilà là je pense qu'on a fait un peu le tour de tout ça et je ne pense pas avoir d'autre chose à vous montrer. 

Éventuellement mais ça ce n'est pas forcément mais qui en fait il pourrait vérifier que vos sessions fonctionnent. 

Alors du coup vous avez également, je peux vous le donner pour terminer, il s'agit de session_status().
```php
>		session_status()
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
```
Alors ça c'est une fonction qui va retourner 3 choses, alors elle peut soit retourner des constantes et vous avez la constante phpsessiondissabled qui veut dire que les sessions ont été désactivées donc ça veut dire qu'elles sont même pas activé au niveau de PHP mais normalement par défaut elles le sont sans problème alors je vais vous le noter comme ça ce sera plus facile.

Cette fonction retourne 0 ou PHP_SESSION_DISABLED. Elle retourne 1 dans le cas où les sessions sont bien activées au niveau de PHP mais que vous n'en avez pas créé ce qu'il n'y a pas de session qui est en cours et là c'est PHP_SESSION_NONE pour dire qu'il n'y a pas de cession mais qu'elles sont bien activées au niveau de PHP. Et si ça vous renvoie 2 donc cette fonction vous renvoie le chiffre 2 donc elle vous renvoie PHP_SESSION_ACTIVE ce qui veut dire que vous avez bien une session activé au niveau du PHP et qu'en plus vous êtes en train de vous en servir.
```php
>		session_status()	-> 0 (PHP_SESSION_DISABLED)
							-> 1 (PHP_SESSION_NONE)
							-> 2 (PHP_SESSION_ACTIVE)
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
```
Alors nous ce qu'on peut faire par exemple, on va directement faire ça.
```php
<?php
/*
	session_status()	-> 0 (PHP_SESSION_DISABLED)
						-> 1 (PHP_SESSION_NONE)
						-> 2 (PHP_SESSION_ACTIVE)
						
	session_id()
	session_name()
	session_start()
	session_regenerate_id(true)
	session_unset()
	session_destroy()
	session_write_close()
*/	
	echo session_status();
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
</body>
</html>
```
```txt
	+---------------------------------------------------------------------------+
	| /!\ session_start doit être placé tout en haut du fichier sinon WARNING.	|
	+---------------------------------------------------------------------------+

	http://localhost/PHP/cours/018_sessions/
	1
	Sessions en PHP
	Bonjour
```
Voilà on obtient un parce qu'effectivement les sessions en PHP sont bien activées, je n'aurais jamais 0 pour le coup ici. 

Et par contre je n'ai pas de session de créer. 

En revanche si je fais un session_start(); comme on l'a déjà vu. Alors ici je ne fait pas la vérification avec le session_id() mais ce n'est pas grave. Je fais ensuite session_regenerate_id(true) et je réactualise la page du navigateur.
```php
<?php
/*
	session_status()	-> 0 (PHP_SESSION_DISABLED)
						-> 1 (PHP_SESSION_NONE)
						-> 2 (PHP_SESSION_ACTIVE)
						
	session_id()
	session_name()
	session_start()
	session_regenerate_id(true)
	session_unset()
	session_destroy()
	session_write_close()
*/	
	session_start();
	session_regenerate_id(true);
	
	echo session_status();
?>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
</body>
</html>
```
```txt
	+---------------------------------------------------------------------------+
	| /!\ session_start doit être placé tout en haut du fichier sinon WARNING.	|
	+---------------------------------------------------------------------------+
	
	http://localhost/PHP/cours/018_sessions/
	2
	Sessions en PHP
	Bonjour Jason
```
Vous voyez que ça passe à 2 et on a gardé l'information. 

Pourquoi est-ce que l'information est là (Jason) ? parce que je ne l'ai pas supprimé précédemment, oui on n'a pas fait de session_destroy() donc oui la variable de session a été gardé parce que je n'ai pas fermé le navigateur.

Pourtant vous avez vu qu'on avait supprimé le code tout à l'heure, c'est pour ça que je vous dis si vous voulez détruire une session, il ne faut pas hésiter à utiliser le session_unset() et les quelques lignes, le quelques fonctions pour supprimer les informations correctement au niveau de vos variables de session. 

Comme ça vous pouvez transmettre pas mal de choses au niveau de vos pages web et ça pourra suivre à chaque fois. 

Alors la règle à connaître c'est session_start() en tout début de fichier avant tout code HTML et à chaque page où vous voulez l'utiliser. 

Chaque endroit où vous voulez utiliser les sessions, utiliser les variables que vous avez enregistrer en session, vous devez mettre un `session_start();` minimum et éventuellement un `session_regenerate_id(true);`

Au moment où vous voulez détruire la session si vous voulez le faire manuellement, pareil au tout début d'un fichier, un fichier spécialement pour la déconnexion entre guillemets vous mettez le session_unset(); et session_destroy(); donc c'est bien de mettre les 2 et ensuite vous faites une petite re direction en PHP, vous renvoyer sur une nouvelle page. 

La redirection se fait avec header(), je ne sais pas si je l'ai montré sur la formation d'ailleurs. 

Je vais vous le donner là, on va faire une redirection donc la redirection en PHP c'est comme ceci.
```php
	header('Location': index.php');
```
Vous mettez : sans espace après 'Location' sinon ça ne marchera pas, et là suivi du chemin par exemple votre notre nouvelle page index.php ça c'est vous qui voyez.

Alors attention à ne pas mettre des liens, ça ne fonctionnera pas vers l'externe si vous mettez des liens en absolu par exemple vers un autre site ce n'est évidemment pas sécurisé et vous ne pourrez pas le faire.
```php
	/!\ header('Location': http://unautresite.com/index.php');
```
Vous ne pourrez pas faire de toute façon des redirections comme ça, alors ça c'est pareil header( ) est à bien utiliser sinon on peut avoir des petits problèmes de sécurité. 

Si vous voulez donc faire une redirection PHP vous faites ça.
```php
	<?php
	/*
		session_status()	-> 0 (PHP_SESSION_DISABLED)
							-> 1 (PHP_SESSION_NONE)
							-> 2 (PHP_SESSION_ACTIVE)
							
		session_id()
		session_name()
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
		session_write_close()
	*/	
>		header('Location': index.php');
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Cours PHP</title>
	</head>
	<body>
		<h1>Sessions en PHP</h1>
		
		<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
	</body>
	</html>
```
Et pareil la redirection, se fait avant tout code HTML sinon vous aurez un message de ce style "headers have already sent … " ce qui veut dire que les en-têtes http ont déjà été envoyé en fait. 

Pour vous dire que vous faites une redirection alors qu'on a déjà renvoyé du HTML alors qu'on aurait déjà chargé du code HTML ici.

C'est parce que vous auriez utilisé header() après du HTML donc ça c'est pareil comme session_start(), comme pour setcookie(), la redirection PHP ça s'utilise tout le temps avant tout code HTML. 

Alors je vous le donne là parce que je pense que dans la formation on ne l'avait pas jamais vu dans cette formation je n'allais pas faire une vidéo juste là dessus. 

Maintenant vous l'avez vous savez comment faire une redirection en PHP et c'est très simple. 

Pas de problème à ce niveau-là. 

Alors je pense que j'ai fait le tour et on ne va pas s'attarder plus que ça. 

Alors il n'y a pas de Secret vous voyez qu'il y a quand même beaucoup de fonctions, éventuellement à connaître et le minimum à connaître c'est évidemment session_start() et session_destroy(). 

session_start() et session_destroy() sont vraiment le minimum à connaître, le strict minimum c'est ces 2 là. 

Après c'est bien de connaître au minimum ces 4 là :
```php
		session_start()
		session_regenerate_id(true)
		session_unset()
		session_destroy()
```
Alors ça c'est vraiment les 4.

Ça pour la création de la session :
```php
		session_start()
		session_regenerate_id(true)
```	
En faisant un test sur session_id() éventuellement.

Ça pour la fin de la session :
```php
		session_unset()
		session_destroy()
```
Alors ça c'est plutôt pas mal. 

Alors les autres c'est vraiment du plus mais ce n'est pas tellement obligatoire, vous pouvez vous en passer ça ne posera pas de problème. 

Pas de secret comme je le disais, si vous voulez bien comprendre et assimiler cette notion de session, il faudra pratiquer. 

Il faudra vous faire un petit site web avec plusieurs pages éventuellement et utiliser ces sessions directement dans un cas pratique. 

Il y aura évidemment et je le rappelle parce que ce n'est pas encore le cas au moment où j'ai enregistrer cette vidéo, une playlist PHP exercice comme pour toutes les autres formations de programmation ou autre. Vous avez en général une playlist d'exercice spécial qui évolue en fait de manière croissante avec le cours et qui permet comme ça de réviser les notions que vous avez appris et les mettre en pratique dans un petit exercice simple. 

Le but ce n'est pas de faire des gros projets genre créer un vrai site web tout ça mais c'est juste de mettre en application tout ça sur des petits exemples et des petits exercices qui sont assez court, voir un peu plus long par la suite et avec des difficultés croissantes comme ça vous pouvez mettre ça en pratique. 

N'hésitez pas à consulter régulièrement les playlists sur youtube et allez dans la section playlist pour voir justement s'il n'y a pas la playlist d'exercice en PHP. 

Quand il y serra Parce qu'elle n'est pas encore créée au moment où je fais cette vidéo, vous pourrez voir un petit peu ce qu'il y a comme exercice que vous pouvez trouver avec des difficultés croissantes comme ça vous pourrez vous exercez et mettre tout ça en pratique, en application pour bien assimiler toutes les notions vues dans son cours. 

Je vous dis à très bientôt pour la suite de PHP, normalement on devrait avoir fini avec toute la partie procédurale si je ne dis pas de bêtises c'est à dire toute la programmation qu'on a fait là, et je pense que pour la prochaine vidéo on va commencer la programmation orientée objet donc on va commencer à faire des classes en PHP. 

On va commencer et passer à un nouveau paradigme, une nouvelle possibilité que vous pouvez faire également PHP qui est bien connaître parce que c'est une autre manière de programmer dans ce langage qui est tout aussi intéressante. 

Je vous dis à très bientôt pour la suite de ce courant PHP.

À bientôt tout le monde