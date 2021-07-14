# [16. Programmation modulaire](https://www.youtube.com/watch?v=_dHqDXKvAlw)
28-11-20

Bonjour à toi sur cette formation PHP. 

On continue avec cette vidéo numéro 16 pour parler de programmation modulaire. 

Alors ce n'est pas forcément aussi complet que quelque chose comme langage c ou un autre langage que j'ai pu aborder sur la chaîne mais j'ai utilisé ce terme pour pouvoir désigner la vidéo parce que ce sera évidemment plus simple à comprendre. 

De manière générale on parle de programmation modulaire dans le sens où lorsqu'on a travaillé sur un projet, un code, plutôt que de s'occuper de n'avoir que ce fichier … imaginons un fichier PHP où je vais avoir l'ensemble du projet qui est écrit, on va répartir le projet sous plusieurs petits modules donc plusieurs parties. 

L'avantage c'est qu'on aura plusieurs fichiers différents pour chaque partie d'un projet, ça pourra évidemment être développé par plusieurs personnes différentes, plusieurs groupes différents donc ça permet de répartir des tâches et de garder les choses indépendantes. 

Après on n'a plus qu'a la lire entre elles en faisant des inclusions et ça fonctionne. 

C'est pour ça que j'ai employé ce terme là de programmation modulaire pour définir cette vidéo parce que même si on ne va pas développer des modules mais je vais vous montrer comment inclure des fichiers PHP dans d'autres fichiers pour les utiliser. 

Utiliser le contenu de fichier externe au sein de votre fichier principal, sur lequel vous allez faire l'exécution de votre programme. 

On va regarder ça sur cette vidéo et ce ne sera pas très très long. 

Il n'y a pas grand chose à voir et vous allez apprendre 4 fonctions et on aura déjà pas mal de choses. 

Alors la première chose à savoir déjà ce que au niveau de ces petites fonctions, je vais vous les donner rapidement au niveau des noms. 
```php
	/*
		
	*/
	
	echo 'Je suis le fichier index.php';
```
Pour ceux qui ont bien suivi la séance 13 sur la gestion des erreurs, on avait parlé des différents types que l'on peut rencontrer pour la gestion d'erreur. 

On avait parlé des avertissements, on avait parlé des alertes, on avait justement parlé des erreurs. 

On avait dit qu'il y avait plusieurs niveaux en fonction, on avait vu comment pouvoir créer notre propre gestionnaire d'erreurs en fonction. 

Ce qu'il faut savoir, ce que nous allons retrouver 4 fonctions. 

C'est les 4 que vous allez avoir à apprendre dans cette vidéo qui vous serviront dans beaucoup de choses, composer les utiliser des bibliothèques même téléchargés sur internet en PHP pour les utiliser dans vos projets, vous aurez dans 90 pour 100 des cas besoin de faire la liaison de ce que vous avez récupéré dans votre fichier en utilisant ces fameuses fonctions. 

On en a une première, enfin un ensemble mais ce ne sont pas vraiment des fonctions mais je vais revenir après d'ailleurs. 

Alors nous avons include, include_once et nous avons require et require_once.
```php
	/*	
		include
		include_once
		
		require
		require_once
	*/
	
	echo 'Je suis le fichier index.php';
```
Alors pourquoi ce ne sont pas des fonctions ? C'est la même chose avec echo ce qu'on avait vu précédemment echo, print et cetera, ce sont en réalité des instructions.  
```php
	/*
		echo, print
		
		include
		include_once
		
		require
		require_once
	*/
	
	echo 'Je suis le fichier index.php';
```
Ce sont des instructions du langage PHP et non pas des fonctions parce qu'on va pouvoir les écrire de différentes manières. 

On va souhaite pouvoir mettre des parenthèses, include() comme pour le echo.

Rappelez vous, le echo on pouvait l'écrire comme ça avec des parenthèses.
```php
	echo("bonjour");
```
Mais on peut aussi écrire simplement echo avec un espace et on met notre texte comme ça.
```php
	echo "bonjour";
```
Voilà 2 manières de faire une instruction echo appelle PHP.

Alors pour include(), include_once(), require(), require_once() c'est exactement la même chose. Vous pouvez écrire entre parenthèses ou vous pouvez simplement écrire avec un espace.

Il n'y a pas une méthode qui est mieux que l'autre, simplement et en termes de conseils de codage et j'avais d'ailleurs fait une vidéo sur la chaîne par rapport à ça.

À partir du moment, où vous choisissez une des 2 syntaxes, Eh bien essayer de la conserver partout dans votre projet. 

Si à certains moments vous utilisez des parenthèses et si a d'autres moments que vous ne les utilisez pas, on aura l'impression que vous êtes plusieurs avec en plus des normes différentes a créer le projet.

Même si vous travaillez sur un projet de groupe, mettez vous d'accord sur la syntaxe à choisir pour ces types d'instructions PHP et l'utiliser partout au sein du projet ça rendra les choses beaucoup plus lisibles beaucoup plus agréable à la maintenance et surtout la réutilisation de votre code.

Voilà pour ces 4 instructions.
```php
	/*	
		include
		include_once
		
		require
		require_once
	*/
	
	echo 'Je suis le fichier index.php';
```
Voilà comment elles vont fonctionner pour grosso modo les détailler. 

include va permettre d'inclure comme son nom l'indique le contenu est affiché à l'endroit où vous faites appel à cette instruction d'accord. 

Si jamais on ne peut pas faire cette inclusion, on déclenchera enfin PHP va déclencher tout simplement une alerte. Je ne reviendrai pas sur les alertes les avertissements et tout ça, si vous avez vu la séance 13 vous savez à quoi je fais référence puisqu'on l'a vu précédemment. 

include_once c'est simplement sécurité supplémentaire enfin c'est sûr tout simplement qu'en utilisant cette instruction, ne va pas inclure un fichier tu aurais déjà éventuellement été inclus et donc ça évite de faire des inclusions supplémentaires avec le fichier a déjà été mis. 

Ça peut être utile dans certains cas, s'il y a par exemple un risque que le fichier a déjà été inclus auparavant, utiliser include_once c'est mieux. 

include et include_once vont donc déclencher en cas de problème une alerte. 

require c'est exactement le même principe que include, c'est simplement que s'il y a un problème donc à cette inclusion, on ne déclenchera pas une alerte mais une erreur fatale donc vraiment une erreur en fait. Ça va déclencher une erreur et du coup ce sera un cas un peu plus strict. 

On va dire que require est un peu plus strict et va déclencher quelque chose de plus grave entre guillemets par rapport à include dans le cas où on n'a pas réussi à inclure le fichier, il va vous alerter qu'il n'a pas pu inclure le fichier mais il ne va pas pour autant arrêter l'exécution de script.

require, s'il y a un problème va stopper le script complètement parce qu'on peut absolument pas continuer donc c'est vraiment utile on va dire pour des cas critiques quand vous avez absolument besoin d'un fichier ou de quelque chose d'utiliser require. 

Quand c'est un cas où ce n'est pas très grave, excessivement grave si le fichier n'a pas pu être inclus, on utilisera par exemple include. 

Alors regardons par un exemple, alors là on voit que sur mon fichier principal j'ai juste echo.
```php
	/*	
		include
		include_once
		
		require
		require_once
	*/
	
	echo 'Je suis le fichier index.php';
```
Et on va s'amuser à créer un fichier d'utilitaire où on va mettre admettons des petites fonctions qu'on va pouvoir utiliser partout dans le programme. 

Je fais un petit fichier PHP que je vais appeler utils.php admettons et je mets à l'intérieur plusieurs petites fonctions PHP diverses donc là évidemment je vais faire des choses basiques tu n'as pas forcément d'intérêt mais c'est juste pour comprendre le principe comme ceci.

+ utils.php
```php
	function hello()
	{
		echo "Hello world !";
	}
```
Là si j'essaye comme ça par défaut d'appeler la fonction hello().
```php
<?php

/*	
	include
	include_once
	
	require
	require_once
*/

echo 'Je suis le fichier index.php';
hello();

?>
```
```txt
	http://localhost/PHP/cours/016_programmationModulaire/
	Je suis le fichier index.php
	Fatal error: Uncaught Error: Call to undefined function hello() in C:\...\index.php:188 Stack trace: #0 {main} thrown in C:\...\index.php on line 155
```
On va sur le navigateur et on obtient une erreur parce qu'on demande de faire appel à une fonction qui est non définie ce qui est normal parce qu'il ne trouve pas cet endroit là.

Il va falloir donc inclure ce fichier utils.php on niveau de index.php pour pouvoir l'utiliser. 

Alors le mieux c'est de pouvoir le faire au plus haut dans ce genre de cas.

Si vous faites un include ou un require dans une fonction, tout ce qui sera inclus n'existeras que dans la fonction par rapport à tout ce que je vous expliqué sur le contexte dans la fonction c'est-à-dire que tout ce qui est variable et cetera crées dans une fonction est détruit à la fin donc n'existera pas ailleurs à moins d'avoir des variables globales par exemple. 

Nous on va faire ça, on va faire un include de 'utils.php'; 
```php
<?php

include 'utils.php';

echo 'Je suis le fichier index.php';
hello();

?>
```
```txt
	http://localhost/PHP/cours/016_programmationModulaire/
	Je suis le fichier index.phpHello world !
```
Et à partir de là je vais pouvoir faire l'appel à ma fonction, okay sans problème. 

N'oublions pas de mettre aussi en retour à la ligne pour que ça fonctionne. 
```php
<?php

include 'utils.php';

echo 'Je suis le fichier index.php<br>';
hello();

?>
```
```txt
	http://localhost/PHP/cours/016_programmationModulaire/
	Je suis le fichier index.php
	Hello world !
```
Voilà tout fonctionnera et c'est plutôt pratique.

L'avantage c'est qu'on va comme ça pour voir il y a plusieurs fichiers, par exemple moi je pourrais m'occuper de ce qu'il y a dans ce fichier là. 

Un autre développeur pourrait travailler sur les fonctions utilitaires, après il n'y a plus qu'a me passer le fichier et moi je n'ai plus qu'a l'inclure. 

Et je n'ai plus qu'à l'inclure, et hop je pourrais utiliser son code directement pour le mien donc c'est plutôt pratique. 

Ça permet comme ça de travailler sur différentes parties et c'est pour ça qu'on parle de programmation modulaire, on développent des modules séparés et on les liant les uns avec les autres, on arrive à obtenir notre application, notre projet complet. 

Voilà comment ça fonctionne. 

Alors ça c'est un cas possible c'est-à-dire que des fois vous allez trouver sur internet, je ne sais pas une bibliothèque par exemple pour pouvoir gérer vos bases de données et vous aurez tout un tas de fichiers PHP et on vous dira d'inclure là où vous voulez utiliser les bases de données le fichier PHP qui gère ça. 

Vous aurez par exemple un include 'database.php'; ou je ne sais quoi et à partir de là vous pourrez utiliser les fonctions ou même les méthodes comme on le verra quand on abordera la programmation objet sur cette formation pour les utiliser directement dans votre code. 

C'est vraiment pratique, c'est pour ça d'ailleurs que je le mets dans le cours parce que c'est indispensable pour moi.

Voilà ce n'est pas quelque chose de facultatif ou du quel on peut se passer en PHP parce que à partir du moment où on fait du PHP, ça me paraît impossible à ne jamais à avoir à inclure de fichier dans un autre. 

On utilise ça vraiment régulièrement quand on fait du PHP donc c'est pour ça que j'en ai fait une vidéo. 

Voilà pour cet exemple. 

On va faire un exemple un tout petit peu plus poussé pour terminer cette vidéo, je vous avais dit que ce n'était pas très très long. 

Admettons que je veuille … alors là c'est utile si on veut mettre du HTML ou autre mettons que je veux rajouter quelque chose avant mon echo et après.
```php
>	...
	echo 'Je suis le fichier index.php<br>';
>	...
```
On pourrait le faire par exemple avec du code HTML. 

Je vais faire un code HTML très rapide et pas propre parce que vous n'êtes pas forcément obligé de connaître HTML et je rappelle que cette formation PHP peut être faites sans connaître HTML CSS et qu'il y a des programmeurs PHP qui ne connaissent pas HTML CSS. 

Alors il y a beaucoup de gens qui pensent que quand on fait du PHP qu'on fait également du HTML CSS mais pas du tout, ce n'est pas forcément le même domaine. 

Il y a du développement back end et il y a du développement front end.

Et souvent dans les entreprises et tout ça, chaque personne est spécialisée dans un domaine ou autre et c'est assez rare qu'il s'occupe de faire les 2 à la fois.

On peut très bien apprendre donc PHP sans jamais avoir fait de HTML CSS, c'est tout à fait possible et inversement bien évidemment. 

Nous on va mélanger un petit peu avec du HTML et si vous ne comprenez rien au HTML, ce n'est pas grave. Si ça vous intéresse il y a une formation HTML CSS sur ma chaîne donc j'en profite pour en parler et ce sera toujours ça de pris. 

Alors je vais noter n'importe quoi en mettant haut.php donc je vais mettre du codage HTML dans des fichiers PHP voilà et ça va fonctionner bien évidemment. Et un autre bas.php, ce sont des noms ridicules mais c'est juste pour savoir de quoi on parle et comme ça dans votre tête ce sera beaucoup plus simple comme ça le schématiser.

Alors dans index.php, je vais appeler pour avoir mon fichier 'haut.php' donc le code qui va être écrit dans haut.php va en fait être ajouté au début de index.php
```php
>	require 'haut.php';

	echo 'Je suis le fichier index.php<br>';
>	...
```
Et le code de bas.php sera ajouté après.
```php
>	require 'haut.php';

	echo 'Je suis le fichier index.php<br>';
	
>	require 'bas.php';
```
Vous voyez vous pouvez choisir l'endroit où vous mettez le code. 

Alors quand c'est des définitions de fonctions, on s'en fiche un peu parce que à partir du moment où elles sont définies, on est capable de les appeler comme on l'a fait avec le hello() donc il suffit de le mettre avant l'appel de la fonction et ça fonctionnera. 

Et là c'est intéressant parce que je ne veux pas que cette partie là de mon fichier contenu dans  haut.php se retrouve en bas de mon fichier, en dessous de mon echo. 

Imaginez par exemple que vous ayez un thème de site, le haut.php pourrait être l'en-tête du site et le bas.php pourrait être le footer du site pour ceux qui font du HTML et du CSS donc on va faire plus ou moins ça. 

Alors je vais écrire un fichier HTML, quelque chose qui n'est pas propre du tout mais c'est histoire de vous montrer un petit peu l'exemple mais en fait avec les éditeurs maintenant on peut directement appeler un code basique, des choses très rapide sans trop embêter et donc on va faire ça. 

+ haut.php
```php
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
```
Alors j'enlève la partie du bas que je met dans l'autre fichier.

+ bas.php
```php
	</body>
	</html>
```
Vous voyez c'est très simple, on ne peut pas faire plus simple. 

Et du coup je veux que mon echo si vous voulez, que la partie là, ce texte-là et d'ailleurs on va le mettre dans un paragraphe html, soyons fou.
```php
<?php

require 'haut.php';

echo '<p>Je suis le fichier index.php</p>';

require 'bas.php';

?>
```
Je veux que cette balise donc ce paragraphe ici se retrouve entre le `<body>` de haut.php et avant le `</body>` de fin dans bas.php. 

D'accord tout simplement pour qu'on ait une page web valide, et c'est ce que nous allons faire grâce à ça, on fait cette inclusion et j'actualise.
```txt
	http://localhost/PHP/cours/016_programmationModulaire/
	Je suis le fichier index.php
```
Et voilà ce que j'obtiens, on peut vérifier au niveau du code source que tout c'est bien fait c'est important. On fait un clic droit et on voit que tout s'est bien ajouté.

## Afficher la page source
```php
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body><p>Je suis le fichier index.php</p></body>
	</html>
```
Et vous voyez que tout s'est bien ajouter au bon endroit donc on a bien le paragraphe qui s'est mis entre les balises `<body></body>` soit de body ouvrant et body fermant. 

Alors petite parenthèse parce que je sais qu'il y a des gens il m'avait posé la question sur l'ancienne formation, est-ce qu'il y a des choses à faire ici pour bien afficher le code source proprement ?

Honnêtement il n'y a aucun intérêt d'afficher un code source proprement d'accord ou sinon peut être dans certains cas, pas avec du HTML mais quand on a du javascript par exemple, de faciliter l'aide pour un pirate qui est en tenterais de pirater votre site et qui du coup veut analyser le code source de vos pages donc si vous faciliter la lecture du code source, et bien vous rendez service quelque part aux éventuels pirates de votre site donc ce serait un petit peu dommage. 

Alors honnêtement le code source déjà ça ne sert que pour les programmeurs ou les éventuels pirates mais pour l'utilisateur et même pour vous on s'en fiche donc ça n'a aucun intérêt ici de s'arranger pour que mon paragraphe ici se mette bien proprement après le `<body>` et cetera. 

L'intérêt c'est que le code soit valide et propre. 

Ce que affiche le navigateur comme code source quand on y accède, on s'en fiche complètement et à la rigueur si c'est tout cafouillis tant mieux parce que comme ça on rentre à la tâche un peu plus ardue pour des gens qui voudraient analyser vos pages web. 

Je ne vois donc pas en quoi ça pourrait être un problème et voilà du coup ce n'est pas quelque chose d'important à ce niveau-là ok. 

Vous avez vu comme ça 2 techniques, vous avez vu qu'il suffit simplement d'inclure le contenu d'un fichier et on peut du coup utiliser les fonctions d'un autre fichier. 

Et si on y inclut des choses qui s'affiche notamment du contenu HTML parce que ça c'est le navigateur qui va l'interpréter donc PHP ne va pas s'en charger, on peut comme ça positionner les éléments là où on veut ce qui est plutôt pratique. 

C'est-à-dire que si je m'étais amusé par exemple à mettre, à faire ça comme ça.
```php
<?php
require 'haut.php';
?>

<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Placeat perpiciatis quae labore atque earum? Explicabo itaque eaque cupiditate option dolorem ab natus, dicta odit a atque laboriosam eius repudiandae aut.</p>

<?php
require 'bas.php';
?>
```txt
	http://localhost/PHP/cours/016_programmationModulaire/
	Lorem ipsum, dolor sit amet consectetur adipisicing elit. Placeat perpiciatis quae labore atque earum? Explicabo itaque eaque cupiditate option dolorem ab natus, dicta odit a atque laboriosam eius repudiandae aut.
```
Voilà on peut très bien mélanger les choses et ça fait exactement pareil comme j'ai fait les inclusions. 

On affiche le code source et on voit bien le <body> ouvrant, tout ce que j'ai mis dans mon fichier principal et ensuite le contenu du fichier bas.php

## Afficher la page source
```php
	<!DOCTYPE html>
	<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Ma page web</title>
	</head>
	<body>
	<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Placeat perpiciatis quae labore atque earum? Explicabo itaque eaque cupiditate option dolorem ab natus, dicta odit a atque laboriosam eius repudiandae aut.</p>

	</body>
	</html>
```
Donc on a bien le contenu de mon fichier haut.php, mon fichier principal et le fichier bas.php. Et du coup on peut faire des design de chose dynamique. 

/!\ Pour ceux qui voudraient éventuellement, vous pourriez faire une fonction PHP dans haut.php qui prendrait des variables avec des paramètres, et ça vous permettrait très facilement en appelant une fonction spéciale dans index.php, de choisir le paramètre de la langue de la page "fr", l'encodage de la page "utf-8", le titre "Ma page web" éventuellement, le fichier CSS à inclure et ce genre de chose. 

Vous voyez que du coup avec PHP qui est un langage de programmation, on peut produire des page web beaucoup plus dynamique là où HTML il faut tout marquer nous-mêmes à la main et on ne peut pas faire grand-chose de plus. 

Alors que en PHP, on peut définir des fonctions pour gérer des paramètres dynamiques échanger par exemple titre de nos pages en fonction. 

C'est plutôt pratique à ce niveau là. 

Voilà tout ce qu'il y a à retenir, require, require_once, include et include_once soit 4 instructions d'accord du langage PHP qui vous permette d'inclure du code d'un fichier PHP dans un autre que ce soit du HTML ou autre. Ce sera évidemment interprété en fonction par le navigateur et c'est très simple à faire et ce sera très utile et très utilisé dans ce langage. 

N'hésitez donc pas si vous avez des questions dans les commentaires, vous pouvez toujours me les poser je pense que normalement cette vidéo n'aura pas posé de sérieux problèmes ce qui est assez simple.

Et comme d'habitude entraînez vous, essayez de faire vos petits scripts PHP pour tester et revoir un petit peu tout ce que vous avez vu jusqu'à présent puisqu'on va attaquer très bientôt de toute façon un nouveau chapitre en PHP.

On va faire de la programmation objet donc on va passer à un cran de difficulté au-dessus avec l'utilisation de classe, les notions d'héritage et tout ça.

Il y aura donc pas mal de choses à voir à ce niveau-là et n'hésitez pas de vous assurer de bien avoir tout vu à ce stade de la formation, de bien assimiler ce qui a été vu précédemment également parce que tout ce qui sera vu ici vous aidera énormément pour la suite. 

Je vous dis à bientôt du coup pour une prochaine vidéo sur cette formation PHP. 

Ciao