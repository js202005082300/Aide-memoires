# [17. Cookies](https://www.youtube.com/watch?v=yED9q_chp8c)
29-11-20

Bonjour tout le monde et bienvenue sur cette séance 17. 

On termine avec quelques dernières notions avant d'attaquer la programmation objet en PHP, et là nous allons parler des cookies. 

C'est une vidéo assez courte parce qu'il n'y a pas grand-chose à vous présenter mais c'est très important au niveau de l'utilisation et du développement de vos sites web donc on va un petit le tour de tout ça.
```php
	<?php
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
	</body>
	</html>
```
Alors un cookie, en PHP, ça va être un fichier texte d'accord qui va être enregistrer au niveau de votre navigateur web quel qu'il soit et sur lequel vous allez pouvoir stocker des informations. 

Alors je préviens d'avance que le cookie n'est pas fait du tout pour stocker des informations de sécurité ou des informations confidentielles c'est-à-dire des informations sensibles. 

Tout simplement pour 2 raisons.

La première c'est que l'utilisateur lui-même va pouvoir modifier s'il veut la valeur d'un cookie. 

Il est tout à fait possible via votre navigateur ou une extension de votre navigateur de modifier la valeur d'un cookie c'est-à-dire de changer sa valeur par une autre. 

Il est tout à fait possible pour un pirate de tenter de récupérer le contenu de certains cookies et de s'en servir à des fins malveillantes donc on n'utilise pas le système de cookies pour stocker des informations de sécurité.

On utilisera plutôt pour cela les sessions et ce sera la prochaine vidéo donc on en parlera aussi. 

Je vais vous montrer un petit peu comment ça fonctionne, alors ça va être très très simple parce qu'il n'y a pas grand chose à voir. 

La première chose que vous allez voir c'est comment créer un cookie, comment l'enregistrer. 

Et ensuite on verra comment afficher la valeur d'un cookie parce que c'est à ça que ça sert. 

Pour quel usage allons-nous en avoir besoin ? 

Vous verrez on en aura besoin pour les sessions dans la prochaine vidéo mais aussi pour stocker des informations utilisateur ou des informations qui ne sont pas forcément très grave, on va dire si elles étaient modifiées par l'utilisateur d'autant que vous pourrez vérifier en PHP la validité des infos. 

Alors ça peut être par exemple sur un site qui serait multilingue c'est-à-dire enregistrer la langue préférée de l'utilisateur. 

Ça peut être également si vous avez un site multi thèmes, d'enregistrer le thème choisi ou bien le fuseau horaire, toutes des informations comme ça, ou même un surnom bref on peut enregistrer vraiment pas mal d'informations.

Alors comment créer un cookie ? comment l'enregistrer au niveau du navigateur ? 

Nous allons pour cela utiliser la fonction setcookie().
```php
	<?php
		setcookie();
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
	</body>
	</html>
```
La première règle à savoir c'est qu'elle doit être placée, utilisée, appelée avant tout code HTML.

Et même plus exactement avant tout espace blanc c'est-à-dire que par exemple si vous avez ça et que vous laissez des espaces comme ça ici vous risquerez d'avoir des erreurs.

+ index.php
```php
	<?php
		setcookie();
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
	</body>
	</html>
```
Vous aurez des erreurs tout simplement parce que cette fonction a besoin de se faire avant toute requête http donc la requête ici pour générer notre code html.
```php
	<?php
		setcookie();
	?>
>	<!DOCTYPE html>
>	<html lang="fr">
>	<head>
>		<meta charset="UTF-8">
>		<title><?= $title ?></title>
>	</head>
>	<body>
>		<h1>Les cookies en PHP</h1>
>	</body>
>	</html>
```
Il faut donc absolument qu'il n'y ait rien avant l'appel de `setcookie();` c'est-à-dire la fonction qui va nous permettre de créer notre cookie en stockant l'information que nous voulons. 

Assurez vous vraiment de ne rien avoir comme espace, il faut vraiment qu'il n'y ait pas d'espace.

Aucun espace blanc, aucune ligne blanche, évidemment aucun code HTML avant.

Peu importe votre architecture donc la manière de développer votre site, vous vous assurez toujours de l'appeler avant tout autre code.

setcookie() prend plusieurs paramètres.

Le premier ça va être le nom du cookie, on va faire par exemple la coquerie qui définit la langue choisie de l'utilisateur. 

Par exemple on a un site en français et en anglais, ça lui permettra comme ça à chaque fois qu'il viendra rendre visite sur le site, de l'avoir dans la langue qu'il a choisi plutôt que ce soit mais toujours par défaut en anglais et qu'il soit obligé de changer tout le temps ce qui peut être un peu désagréable.
```php
		setcookie('lang', ...);
```
La valeur de cookie en 2e paramètre et nous par défaut on va par exemple mettre 'fr'. 
```php
		setcookie('lang', 'fr', ...);
```
Le 3e paramètre ça va être tout simplement le temps avant expiration donc le temps ou le cookie qui va rester valide avant d'expirer avant d'être supprimé tout simplement et donc pour cela on peut utiliser la fonction time() qui est lié à l'époque Unix et ça j'en ai déjà parlé par rapport au temps passé depuis l'époque Unix donc on prend le temps qui s'est déroulé depuis cet instant là.
```php
		setcookie('lang', 'fr', time(), ...);
```
Et ensuite selon la durée que l'on veut faire, on peut y ajouter un certain nombre de secondes. 

Par exemple si on veut faire un an, il fera 3600 secondes multiplier par 24 heures, qui nous font du coup une journée, multiplié par 365 jours de l'année.
```php
	<?php
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, ...);
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
	</body>
	</html>
```
Vous aurez tout simplement un cookie valable pendant un an. C'est une valeur assez récurrente donc on va mettre ça. 

Ensuite nous avons un paramètre … ce sont des paramètres qui ne vont pas nous intéresser pour le coup mais c'est le paramètre suivant qui va nous permettre d'avoir le chemin du cookie. On utilise assez rarement à moins de vouloir spécifier le cookie à un endroit précis d'accord au niveau de votre arborescence et donc nous ici comme ça nous intéresse pas on va mettre le paramètre null. 
```php
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, ...);
```
Le suivant c'est le nom de domaine. 

Domaine sur lequel le cookie va être appliqué, pareil à moins d'avoir un système de nom de domaine très spécifique et il faudra à ce moment-là le spécifier sinon vous pouvez évidemment indiqué nul pour dire je ne passe aucun domaine en particulier. 
```php
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, ...);
```
Ensuite nous avons et ça c'est très très très important, l'autre paramètre c'est au niveau de sécurité … enfin même les 2 derniers paramètres sont très importants. Le paramètre suivant c'est pour dire si le cookie doit être sécurisé c'est à dire doit être sécurisé avec https donc si votre site est en https, il faudra passer ce paramètre là à true. 
```php
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, true, ...);
```
Si c'est pas le cas et normalement ici on n'est pas en https, vous mettez ce paramètre à false.
```php
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, false, ...);
```
Et le dernier c'est tout simplement pour vous dire que l'accès au cookie il ne se fera que en http et non pas en javascript. Très important parce que javascript peut t'amener à des failles de sécurité donc ça dans tous les cas je vous le dis, celui qui spécifie si c'est en HTTP en ligne pour l'accès aux cookies. Mettez le tout le temps à true pour empêcher la récupération et l'accès aux cookies via du javascript.
```php
<?php
//	setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, false, false);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title><?= $title ?></title>
</head>
<body>
	<h1>Les cookies en PHP</h1>
</body>
</html>
```
L'accès au cookie via du javascript peut entraîner une faille supplémentaire sur votre site donc voilà quand on peut l'éviter c'est toujours mieux. 

Donc là vous allez souvent mettre ce paramètre là : … null, null, false, true. Vous pouvez les retenir comme ça. 

Et le plus important c'est ceux là, le nom du cookie 'lang', sa valeur 'fr' et le temps avant expiration. 

Là nous allons donc créer un fichier texte en fait qui aura comme nom 'lang' et qui aura pour valeur 'fr' d'accord donc on va faire ça.  

Alors on va aller voir au niveau des données de sites et des cookies pour s'assurer qu'on ai rien.

## Cookies et données de sites
```txt
edge://settings/content/cookies?site=0156dbfa179422e47d3bec4da64c7a19.safeframe.googlesyndication.com
```
Voyez que le niveau des données je n'ai rien. 

Ensuite je vais actualiser ma page et on va voir si quelque chose a changé. Et donc est-ce que ça a été pris en compte ?
```txt
	http://localhost/PHP/cours/017_cookies/
	Les cookies en PHP
	
	edge://settings/content/cookies?site=0156dbfa179422e47d3bec4da64c7a19.safeframe.googlesyndication.com

	+-------------------------------------------+ 
	| Tous les cookies et données du site		|
	| / localhost a stocké des données en local	|
	| 											|
	| Supprimer tout							|
	| lang										|
	| 											|
	| 											|
	| Nom										|
	| lang										|
	| 											|
	| Contenu									|
	| fr										|
	| 											|
	| Domaine									|
	| localhost									|
	| 											|
	| Chemin									|
	| /PHP/cours/017_cookies					|
	| 											|
	| Envoyer pour								|
	| Connexions au même site uniquement		|
	| 											|
	| Accessible au script						|
	| Oui										|
	| 											|
	| Créé										|
	| dimanche 29 novembre 2020 à 19:13:57		|
	| 											|
	| Expire									|
	| lundi 29 novembre 2021 à 19:13:57			|
	+-------------------------------------------+
```
Voilà on voit que localhost à bien créer un cookie. 

Alors pour vérifier qu'il a bien enregistrer l'information, maintenant que vous savez comment créer un cookie, on va voir comment le lire alors si vous voulez mettre à jour la valeur d'un cookie c'est exactement pareil donc je passe très très vite.

Si un jour vous voulez changer la valeur, il suffit de rappeler la fonction setcookie() et vous mettez une autre valeur à la place d'accord.
```php
	setcookie('lang', 'en', time() + 3600 * 24 * 365, null, null, false, false);
```
Ça c'est exactement la même chose que ce soit pour la création ou la modification. 

Pour la lecture nous avons une variable super globale tel que vous avez vu `$_GET` et `$_POST` qui servait à la transmission des données en PHP. Et on a une autre variable qui est `$_COOKIE`.

`$_COOKIE` est une variable super global permet de récupérer toutes les informations sur les cookies que nous avons donc pour le faire en PHP ça va être très facile. On va faire par exemple un paragraphe en dessous duquel nous afficherons les infos.
```php
	<?php
		/* $_COOKIE */
		
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, false, false);
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
		
		<p>Langue de l'utilisateur : </p>
	</body>
	</html>
```
Comme je vous l'avais dit en début de vidéo, vous savez qu'un cookie peut être modifié par l'utilisateur. 

Il ne faut donc absolument pas faire confiance lors de l'affichage parce qu'on pourrait injecter vraiment n'importe quoi dans la valeur du cookie et du coup ça pourrait exécuter du code. 

Imaginez que l'on mette du code javascript ou autre, ce serait interprété au niveau du navigateur donc on va toujours s'assurer de protéger l'affichage comme ce qu'on a vu pour les formulaires avec par exemple un petit htmlspecialchars().
```php
	<?php
		/* $_COOKIE */
		
		setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, false, false);
	?>
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><?= $title ?></title>
	</head>
	<body>
		<h1>Les cookies en PHP</h1>
		
		<p>Langue de l'utilisateur : <?= htmlspecialchars($_COOKIE...) ?></p>
	</body>
	</html>
```
Alors je ne fait pas de vérification aussi ce cookie existe avec un isset() ou autre parce que je sais qu'il existe puisque je viens de le faire avant donc là je ne vais pas faire ce test là.

Et là comme pour le `$_GET` ou le `$_POST`, Entre les crochets vous mettez le nom du cookie.
```php
<?php
	/* $_COOKIE */
	
	setcookie('lang', 'fr', time() + 3600 * 24 * 365, null, null, false, false);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title><?= $title ?></title>
</head>
<body>
	<h1>Les cookies en PHP</h1>
	
	<p>Langue de l'utilisateur : <?= htmlspecialchars($_COOKIE['lang']) ?></p>
</body>
</html>
```
Et vous voyez que c'est exactement le même fonctionnement que pour la transmission de données du formulaire sauf que au lieu d'avoir la super global `$_GET` et `$_POST`, on utilise `$_COOKIE` tout simplement.

N'oubliez pas les underscores et la variable tout écrit en majuscule sinon ça ne marchera pas. 

Ensuite je peux actualiser.
```txt
	http://localhost/PHP/cours/017_cookies/
	Les cookies en PHP
	Langue de l'utilisateur : fr
```
Et là en faisant ça on récupère bien le 'fr' d'accord. 

Si je le modifie en mettant 'en' et ensuite j'actualiserais.
```php
<?php
	/* $_COOKIE */
	
	setcookie('lang', 'en', time() + 3600 * 24 * 365, null, null, false, false);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title><?= $title ?></title>
</head>
<body>
	<h1>Les cookies en PHP</h1>
	
	<p>Langue de l'utilisateur : <?= htmlspecialchars($_COOKIE['lang']) ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/017_cookies/
	Les cookies en PHP
	Langue de l'utilisateur : en
```
J'actualise 2 fois et hop la, le cookie a donc été changé en 'en' donc c'est très pratique et ça vous permet de récupérer des valeurs rapidement. 

L'avantage c'est que par exemple sur un site multilingue et quand l'utilisateur accède au site, regarde s'il y a un cookie qui s'appelle 'lang' par exemple en faisant un petit test comme ça.

Vérifier que le cookie n'existe pas ou qu'il est vide. Je suis en train de faire la condition à l'envers.
```php
		if(!isset($_cookie['lang']) || empty($_cookie['lang']))
```
Si le cookie qui porte le nom 'lang' n'existe pas ou alors qu'il existe mais que sa valeur est vide c'est-à-dire qu'il n'y a rien dedans, à ce moment-là, on le crée.

Et par défaut, on a qu'à dire que je suis un site francophone de base et bien je met la langue 'fr' par défaut. 

Et à ce moment-là, on pourra charger la langue correspondante au cookie qui a été choisi.
```php
<?php
	/* $_COOKIE */
	if(!isset($_cookie['lang']) || empty($_cookie['lang']))
		setcookie('lang', 'en', time() + 3600 * 24 * 365, null, null, false, false);
?>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title><?= $title ?></title>
</head>
<body>
	<h1>Les cookies en PHP</h1>
	
	<p>Langue de l'utilisateur : <?= htmlspecialchars($_COOKIE['lang']) ?></p>
</body>
</html>
```
```txt
	http://localhost/PHP/cours/017_cookies/
```
En vérifiant bien parce que c'est par exemple vous voulez faire une sécurité supplémentaire, on pourrait avoir une liste de langues compatibles, dit valide genre 'fr' et 'en' comme ça il y a un petit malin qui s'amuse par exemple à mettre 'ru' pour du russe, on affichera un message d'erreur pour dire que ça ne marche pas ou alors on appliquerait une autre langue par défaut. 

Attention si vous utilisez les cookies pour paramétrer certaines choses sur le site, vérifiez toujours que la valeur du cookie fait partie des valeurs que vous avez autorisé. 

Si c'est un paramètre de langue, ou un paramètre de thème, il faut évidemment que ce soit quelque chose de valide sinon vous aurez des comportements inattendus. 

Voilà du coup comment ça se passe. 

On va s'arrêter là pour cette vidéo et c'était très court comme je vous l'avais dit. 

Vous savez maintenant comment créer un cookie, je rappelle que c'est juste un fichier au niveau du navigateur qui permet de stocker de petites informations non sensible. 

Il ne s'agit pas de stocker des informations de sécurité ou confidentiels et après vous pourrez les afficher en utilisant la variable super globale `$_COOKIE` tout en majuscules. 

Et comme ça vous pourrez accéder aux éléments et les afficher. 

Voilà voilà et dans la prochaine vidéo nous verrons les sessions. 

Ce sera un petit peu plus long. 

Ça utilise les cookies justement et là on pourra justement s'en servir pour stocker des informations de sécurité puisqu'ils sont là pour ça donc on prendra le temps d'expliquer cela dans la prochaine séance, la 18. 

En attendant si vous avez des questions, n'hésitez pas à laisser des commentaires et après normalement ce n'était pas très compliqué ce que je vous ai montré là. 

N'hésitez pas aussi à tester dans vos codes, commencez par faire usage de ce petit fichier là pour voir un petit peu l'utilité que ça peut avoir et le gain de temps que vous pouvez gagner. 

Et ce que ça peut vous apporter en plus sur votre site web. 

À très bientôt tout le monde pour la prochaine vidéo