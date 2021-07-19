# [5. Formatage texte (2/2)](https://www.youtube.com/watch?v=HSWzav5yc6Y)
15-01-2021

A la séance précédente, nous avons vu les premières balises standards pour tout ce qui est formatage de texte. Dans cette vidéos, on va voir des choses un peu plus avancé.
	
Ce n'est pas plus compliqué que les balises de la précédente séance mais elles seront certainnement moins utilisées car ce sont des balises assez spécifiques mais qu'il faut connaître pour les employer à bon escient.
	
La dernière fois, nous avons vu des balises paragraphes, la manière dont on peux changer l'importance, la mise en valeur d'un texte mais ici nous allons nous concentrer sur des cas très spécifiques au niveau du contenu.

	La balise d'abréviation <abbr></abbr>
	
La première balise est une balise qui permet de faire des abréviations. Par exemple lorsqu'on a un certain terme qui détermine tout un ensemble de chose, HTML par exemple.
	
On commence par faire un paragraphe et puisqu'il contient HTML qui est une abréviation, on peut en donner la définition. 
	
Pour préciser cette abréviation, on utilise la balise `<abbr>` et la fermer après l'abréviation.

On constate en affichant qu'il n'y a pas de changement mais ce qui est intéressant, c'est d'insérer un attribut qui s'appelle title.
	
"title" fait partie des attributs qui sont universel au niveau du HTML (Voir Tutoriel avec tous les attributs et balises universels). Ce sont des attributs qu'on peut utiliser sur n'importe quel balise qu'on a vu (ou qu'on va voir) sur cette formation.
	
"title" fait partie des attributs universels qui va pouvoir être utilisé sur n'importe quel balise et surtout ici où il a vraiment sont intérêt car on va pouvoir y mettre la définition exacte "Hypertext Markup Language". 
	
Si on actualise ensuite, HTML est souligné avec des petits points et si on passe avec la souris dessus, le navigateur affiche ce qu'on a mis dans l'attribut. Peu importe où l'on met l'attribut title, le navigateur ouvrira toujours une petite pop-up avec notre texte.
	
Lors d'une utilisation simple de title, le navigateur affiche déjà l'attribut.
	
De plus ça déjà son utilité au niveau sémentique pour les moteurs de recherches, pour tout ce qui va analyser nos pages. Ils veront vraiment avec `<abbr>` que HTML a une abréviation et qu'il a une abréviation. C'est pourquoi, il est plus intéressant d'utiliser cette balise.
	
L'intérêt est de les utiliser en cas réel sur des exemples plus aboutits et cohérents dans leur utilisation.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p title="Ce paragraphe !">Créer une page web avec le langage <abbr title="Hypertext Markup Language">HTML</abbr></p>
	<p title="blablabla"> simple test</p>
</body>
</html>
```

## Créer une page web avec le langage HTML
*simple test*

La balise `<address></address>`
	
Cette balise va permettre d'afficher des information de contexte. Par exemple si sur un site web, on veut indiquer nos informations (adresse postal, é-mail, etc). 
	
Pour cela, on utilise la balise `<address></address>`.
	
En général, on la met soit dans des balises `<body>` ou alors on la met au sein de balises `<article>` qu'on verra quand on abordera les balises structurantes et qu'on place en général dans la balise `<body>`.
	
La balise `<body>` peut être placée simplement dans la balise `<body>` et contenir des informations.
	
Ces informations (après actualisation> seront indiquées toutes en italiques qui apporte juste un effet visuel dans ce cas ci mais qui pourra être changé en CSS plus tard.
	
Du coup, on peut afficher de la manière que l'on veut avec la balise `<br>` par exemple.
	
Remarque sur HREF :

On sait afficher une adresse avec `<a href="">mailto:chuck@norris.com</a>`

Au niveau des liens, on peut spécifier une adresse mail ce qui permet à la personne de lancer une application de messagerie électronique. Il suffit pour cela de mettre le mailto suivi de deux points : et l'adresse
```html
	<a href="mailto:chuck@norris.com">Envoyer un e-mail</a>
```
Et dans ce cas, on peut soit répéter l'adresse ou afficher un message "Envoyer un e-mail.
	
Quand une personne clic sur ce lien, un logiciel comme outlook, Evolution, Thunderbird, qui permettent d'envoyer des mails depuis un pc, vont démarrer un nouveau message automatiquement.

Ca permet d'éviter de passer par un site de messagerie électronique mais de passer par une application grace à ce mot spécifique mailto: dans l'attribut href pour les liens.
	
Il nécessite de mettre le mailto: suivi d'un é-mail valide pour pouvoir envoyer un é-mail.
	
C'est intéressant d'utiliser cette balise `<address>` pour les moteurs, pour tout ce qui va analyser notre site. Quand le moteur va lire le code source de la page, il va mettre cette balise en évidence. Les informations de contact seront misent en valeur sur notre page.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
    <address>
        Chuck Norris<br>
        16 Rue des cerises<br>
        XXXX MAVILLE<br>
		<a href="">mailto:chuck@norris.com</a><br>
        <a href="mailto:chuck@norris.com">Envoyer un e-mail</a><br>
		<a href="mailto:chuck@norris.com">mailto:chuck@norris.com</a><br>
    </address>
</body>
</html>
```
```txt
	Chuck Norris
	16 Rue des cerises
	XXXX MAVILLE
	mailto:chuck@norris.com
	Envoyer un e-mail
	mailto:chuck@norris.com
```

## L'orientation du texte
	
### La balise `<bdi></bdi>`
	
A partir d'ici, on passe a des choses un peu plus spécifiques qui ne vont pas forcément servir à tout le monde.
	
C'est utilisé pour ceux qui écrivent en arabe, pour ceux où la lecture et l'écriture ne se fait pas de gauche à droite mais plutôt de droite à gauche ou d'une autre manière.
	
C'est pourquoi il existe des balises spécifiques pour travailler sur ce genre de langue.
	
Par exemple, si on a une base de données écrites dans plusieurs langues différentes au niveau du contenu et pour une personne qui veut lire le contenu, elle ne sait pas dans quel sens est orienté le texte.
	
Dans ce cas, on peut utiliser une balise qui s'appelle `<bdi>` pour par exemple écrire de l'arabe qui dans notre cas est écrit à l'envers parce que on essaye d'écrire de l'arable de gauche à droite alors qu'il s'écrit de droite à gauche.
	
A l'affichage les caractères sont inversés et sont écrit dans le bon ordre par le navigateur grâce à la balise `<bdi>`. C'est bien écrit Marḥabah pour dire salut en arabe avec un terme qui écrit correctement de droite à gauche. Et bien sûr le mot salut est resté de gauche à droite.
	
Donc ici, on ne se soucie pas du sens quand on écrit et c'est le navigateur qui va terminer le sens de l'écriture. Et ainsi Marḥabah a été écrite dans le bon sens.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	    <p>Salut : <bdi> مرحبا </bdi></p>
        <p>Merci : <bdi> شكرا </bdi></p>
</body>
</html>
```
```txt
	Salut : مرحبا

	Merci : شكرا
```

### L'attribut dir (Direction)
	
On peut également spécifier, forcer le sens en utilisant un attribut spéfique pour ça.
	
Si on met rien dans cet attribut, ça se met en automatique, en auto.
```html
<bdi dir=""> مرحبا </bdi> 
```
C'est équivalent à faire `<bdi dir="auto"> مرحبا </bdi>`. Ce qui revient au même que de ne rien mettre du tout `<bdi> مرحبا </bdi>`.
	
Eh bien, on peut spécifier l'ordre en mettant par exemple Right To Left (RTL) ou alors Left To Right (LTR). C'est vraiment pour la direction.
	
On utilise cette balise quand on ne connait pas l'orientation du texte et qu'on veut laisser faire le navigateur de manière automatique.
```html
<p>Salut : <bdi dir="auto"> مرحبا </bdi></p>
```

```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	    <p>Salut : <bdi> مرحبا </bdi></p>
		<p>Salut : <bdi dir=""> مرحبا </bdi></p>
		<p>Salut : <bdi dir="auto"> مرحبا </bdi></p>
		
		<p>Salut : <bdi dir="rtl"> مرحبا </bdi></p>
</body>
</html>
```
```txt
	Salut : مرحبا

	Salut : مرحبا

	Salut : مرحبا

	Salut : مرحبا
```
### La balise `<bdo></bdo>`
	
Si par contre on veux imposer un sens au texte, on ne va pas utiliser `<bdi>` mais `<bdo>`.

Si on met `<bdo>` tout court, aucun problème, le texte reste le même.
	
Si on met l'attribut dir avec la valeur Right To Left, on écrit carrément le texte à l'envers c'est à dire, qu'il est prit de la droite et écrit vers la gauche.

Ainsi l'ordre des lettres est inversé au niveau de l'écriture.
```html
	<p><bdo dir="rtl">Bonjour tout le monde.</bdo></p>
```
Dans ce cas, on impose, on force l'écriture, l'orientation du texte, la direction. 
	
Eh bien on laisse en Auto et comme c'est du français, le navigateur va le lire tel quel. Il ne va pas chercher à le lire de droite à gauche, c'est du français. Ce n'et pas comme dans d'autres langues qui se lisent et s'écrivent de droite à gauche.
```html
		<p><bdo>Bonjour tout le monde.</bdo></p>
```
Voilà les balises `<bdi>` et `<bdo>` qui sont intéressantes à savoir pour l'orientation.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
    <p><bdo>Bonjour tout le monde.</bdo></p>
	<p><bdo dir="rtl">Bonjour tout le monde.</bdo></p>
	<p><bdo dir="rtl">Inversion de tout un texte.</bdo></p>
</body>
</html>
```
```txt
	Bonjour tout le monde.

	.ednom el tuot ruojnoB

	.etxet nu tuot ed noisrevnI
```

## Les définitions

### La balise `<dfn></dfn>`
	
Au niveau des définitions, il y a pas mal de balises.
	
Il existe 3 balises différentes qui sont utilisées ensemble.
	
Admettons qu'on veut utiliser un ensemble de définitions de mots et si on a juste la définition d'un terme, on peut utiliser la balise <dfn>.
	
Une fois qu'on a utiliser la balise `<dfn>`, il faut mettre sa définition au plus près du terme à définir.

Il ne faut certainnement pas la mettre sur une autre phrase, sur un autre paragraphe.
```html
		<p><dfn>HTML</dfn> est un language informatique pour réaliser des pages web.</p>
```
On constatera que visuellement, on affiche en italique le terme à définir mais ça nous importe pas mais c'est surtout au niveau sémentique que ça aura une importance. 
	
On va pouvoir indiquer grâce à la balise <dfn> que la définition se trouve juste après ou alors éventuellement juste avant. 
```html
		<p> Pour réaliser des pages web, on utilise le langage informatique<dfn>HTML</dfn>.</p>
```	
On peut ainsi l'utiliser dans un sens ou dans un autre.
	
C'est vraiment pour quand on va définir un terme très rapidement après ce-dit terme.
	
Donc il faut vraiement le définir au plus proche. 
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
		<p><dfn>HTML</dfn> est un language informatique pour réaliser des pages web.</p>
		<p> Pour réaliser des pages web, on utilise le langage informatique<dfn>HTML</dfn>.</p>
</body>
</html>
```
```txt
	HTML est un language informatique pour réaliser des pages web.

	Pour réaliser des pages web, on utilise le langage informatiqueHTML.
```

### Les balise `<dl></dl>`, `<dt></dt>` et `<dd></dd>`
	
Dans le cas où l'on veux faire un ensemble de définitions ou un lexique.
	
Si on veux représenter un lexique proprement dans une page HTML, on peut utiliser des balises spécifiques.
	
Pour cela, on va faire une Definition List `<dl></dl>` dans le quel on met des Difinition Terms `<dt></dt>`, c'est à dire des mots à définir. 
	
Ca peut être par exemple, la définition d'un mot comme on aurait dans le dictionnaire. Ca peut être également la définition d'une abbréviation ou autre chose.
	
Par exemple, on peut définir le terme HTML avec une Definition Description `<dd></dd>`
```html
		<dt>HTML</dt>
		<dd>Langage informatique pour créer des pages web.</dd>
```
Généralement, on ne met pas qu'un seul `<dt></dt>` parce qu'on veut faire une liste. C'est pourquoi, on en met plusieurs. 
```html
	<dl>
		<dt>HTML</dt>
		<dd>Langage informatique pour créer des pages web.</dd>
		<dt>CSS</dt>
		<dd>Langage informatique pour mettre en forme des pages web.</dd>
    </dl>
```
On actualise et l'affichage s'agence d'une tel manière par défaut mais encore une fois, la mise en forme, ce n'est pas au HTML de le faire. On pourra le contrôler avec CSS plus tard.
	
Ensuite, si on a plusieurs termes, on peut très bien accumuler les `<dt>` et les `<dd>` en les rangeant de cette manière. Par contre, on peut mettre plusieurs termes pour une seule définition, il suffit de les mettre à la suite. 
	
Par exemple, on utilise plus xHTML sous HTML5 mais par exemple on est sous HTML4, il est probable qu'on ai déjà utilisé du xHTML ...
```html
		<dt>HTML</dt>
		<dt>xHTML</dt>
		<dd>Langage informatique pour créer des pages web.</dd>
```
Le navigateur affiche tous les termes à la suite et ensuite la définition avec un petit retrait.
	
Ainsi, il faut savoir :
```html
		<dl></dl> pour faire les listes
		<dt></dt> pour les termes
		<dd></dd> pour les définitions
```
Si vraiment on a qu'un seul terme à définir, on ne fait pas une liste, on utilise comme on a vu la balise `<dfn></dfn>` qui sera beaucoup plus pratique et beaucoup plus cohérente pour ce genre d'utilisation.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<dl>
		<dt>HTML</dt>
		<dt>xHTML</dt>
		<dd>Langage informatique pour créer des pages web.</dd>
		<dt>CSS</dt>
		<dd>Langage informatique pour mettre en forme des pages web.</dd>
    </dl>
</body>
</html>
```
```txt
	HTML
	xHTML
	Langage informatique pour créer des pages web.
	CSS
	Langage informatique pour mettre en forme des pages web.
```

## La balise `<dialog></dialog>`
	
C'est une balise assez récente.
	
Elle permet de gérer notamment des boîtes de dialogues. On peut l'utiliser pour afficher/masquer des formulaires ou des informations très spécifiques. 

Elle très intéressante à utiliser lorsqu'on s'en sert avec du JavaScript, qui est un langage de programmation qu'on peut utiliser pour le web (Formations JavaScript sur la chaîne en complément de celle-çi). 
	
Avec JavaScript, on verra comment utiliser cette balise en particulier. 

## La balise `<progress></progress>`
	
Par exemple, on travaille sur un projet et on veut présenter à nos internautes, la progression de notre projet.
	
Une balise a été faite pour ça car des gens faisait ce genre de chose juste avec du CSS ou autre. C'est pourquoi, ils ont trouvé intéressant de l'intégrer avec les standards pour lui donner plus de valeurs.
	
C'est une balise de progression.
	
On peut le mettre dans un paragraphe ou non si on ne veut pas s'embêter.
	
On utilise la balise `<progress></progress>` qui n'as pas d'intérêt sans ses attributs.
	
On peut lui mettre un attribut value="" qui est la valeur actuel que l'on veut. Admettons qu'on veut faire une barre de progression de 100% et que mon projet est arrivé à 25%, on mettra value="25".
	
Et l'attribut max="" va déterminer le maximum de cette barre de progression. Par exemple, 100%
	
Ca permet de gérer ainsi une barre de progression qui pourra être mise en forme plus tard avec le langage CSS.
	
Il faut savoir les utiliser, lorsque c'est cohérent. Il ne sert à rien de se forcer à les utiliser.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>Etat du projet : <progress value="75" max="100"></progress></p>
	Etat du projet : <progress value="75" max="100"></progress>
</body>
</html>
```
```txt
	Etat du projet : ================-----

	Etat du projet : ================-----
```
## Les balises <sub></sub> et <sup></sup>

D'autres balises qui ne sont pas forcément utiles sauf pour certains cas.
	
Notamment pour ceux qui font de la chimie, des mathématiques ou qui utilisent certains termes précis en indice ou en exposant.

On a deux balises pour ça :
	
`<sub></sub>` permet d'écrire un élément en indice. Par exemple, le 2 de CO2 est écrit en petit vers le bas.
	
On entoure ce que l'on veut en petit et vers le bas entouré des balises `<sub></sub>`. Ca permet d'avoir une écriture propre, un peu plus cohérente.
			
`<sup></sup>` peut être utilisée pour la superficie d'un appartement, une maison ou autre. On peut l'utiliser pour les mettres carrés avec la balise `<sup></sup>` autour du 2. Ce qui nous met le petit 2 en haut, en exposant cette fois çi.
			
Ainsi <sub> est pour les indices et <sup> est pour les exposants. Ils sont différents mais permettent de présenter le texte d'une autre manière pour que ce soit encore une fois cohérent et qu'il y ai une cohérence.
	
Au niveau de l'analyse de la page, c'est beaucoup plus clair, lorsqu'on lit `<sub>` ou `<sup>`.
	
On a beaucoup plus de cohérence au niveau du contenu, de notre texte.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
		<p>Formule du dioxyde de carbone : CO<sub>2</sub></p>
		<p>Superficie : 100m<sup>2</sup></p>
</body>
</html>
```
```txt
	Formule du dioxyde de carbone : CO2

	Superficie : 100m2
```

## La balise `<wbr>`
	
Admettons qu'on aient des URL's qui soit très très longue, une suite de lettre ou de chiffres ou autre qui n'ont pas forcément de cassure.
	
Si par exemple, on a :
```html
	<p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
```
Et que le navigateur ne veut pas tout couper séparement puisque tout est ensemble dans le texte, le navigateur va afficher une scroll barre qui s'affiche qui ne rend pas les choses très jolie.
	
Sur certains sites web, vous avez définis des tailles spécifiques ou si par exemple on a un forum et qu'on a un petit rigolo qui publie ce genre de message sur un forum, risque de casser notre desgin pour pas grand chose.

Pour pas grand chose, si on ne l'avait pas prévu dés le départ, ça va déformer le design en faisant des décallages, ce ne serra pas jolie.
	
On pourra gérer ça avec CSS quand on veut faire ça proprement. Mais déjà en HTML, surtout quand on écrit notre propre texte ou autre, on peut spécifier un endroit ou le texte va être coupé. Il suffit d'utiliser la simple balise `<wbr>`.
	
Ce n'est pas Break comme on casse une ligne. C'est un Word Break donc on casse un mot d'où un W devant.
	
Et du coup le compilateur est capable de couper le mot au bon endroit.
	
Si toutefois, on a trop de caractères, on réutilise plusieurs fois la balise `<wbr>`.
	
Autant que nécessaire et on constate qu'on arrive à couper le mot au bon endroit. C'est à nous de choisir à quel endroit, on le fait.
	
Des fois, on peut avoir des très très longue URL's et l'URL normalement ne peut pas être coupée. On ne peut pas s'amuser à couper une URL mais nous, humainement, si on voit comment est écrit l'URL et qu'on indiquer à quel endroit elle peut être coupé visuellement, ça permettra au navigateur de le faire et de lui alléger le travail et du coup éviter de déformer l'affichage et d'avoir des barres de défillement. 
	
Cette petite balise est vraiement très importante dans certains cas car lorsqu'on va développer de vrais sites, etc avec des forums, etc. On risque un jour de rencontrer ce problème où quelqu'un va nous afficher un URL ou un texte avec pleins de caractères à la suite et toute l'interface du site qui se retrouve déformé, ce qui est très embêtant.
	
C'est pourquoi ce genre de balise est très intéressante pour économiser pas mal de choses et ça facilite la casse au niveau d'un mot pour le navigateur.
	
Très intéressant à utiliser et à connaître.
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Ma page web</title>
</head>
<body>
	<p>https://www.youtube.com/watch?v=HSWzav5yc6Y&list=<wbr>PLrSOXFDHBtfE5tpw0bjMevWxMWXotiSdO&index=5</p>
	<p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<wbr>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<wbr>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<wbr>bbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
</body>
</html>
```
```txt
	https://www.youtube.com/watch?v=HSWzav5yc6Y&list=PLrSOXFDHBtfE5tpw0bjMevWxMWXotiSdO&index=5

	bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
```
Nous avons fait le tour des balises de formatages de texte.

Dans la séance 6, on verra des balises toujours sur le formatage de texte. 

Bien que les dernières séances étaient orientées formatage, la prochaine séance sera d'aspect un peu plus technique.
	
Ce sera intéressant pour ceux qui font de l'informatique, de la programmation, pour ceux qui utilisent l'ordinateur de manière spécifique. Certaines balises ont été conçues pour ces personnes notamment pour afficher la sortie d'un programme ou simplement le fait de taper le code d'un programme informatique. 
	
Cette séance 6 est donc réservé pour un public ciblé avec des balises techniques au niveau HTML pour la conception de nos pages web.