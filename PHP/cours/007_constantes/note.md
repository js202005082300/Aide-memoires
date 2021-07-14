# [7. Constantes](https://www.youtube.com/watch?v=k1j01vaRHgo)

Bonjour tout le monde bienvenue sur la séance 7 en langage PHP. 

On va continuer avec cette formation de programmation pour aborder une notion qui suit un petit peu ce qu'on a vu précédemment sur les variables. Vous avez vu que la vidéo était assez longue et elle dura une cinquantaine de minutes donc on a vu énormément de choses mais au moins tout a été vu ensemble parce que ça concernait les variables et les types de données que vous allez manipuler tout au long de cette formation donc on va pouvoir aborder cette fois-ci comme l'indique le titre les constantes. 

Les constantes, à l'inverse des variables dont on peut modifier la valeur qui sont aussi bien accessibles en lecture pour lire leur contenu, qu'en écriture pour modifier leur valeur. Une constante pourra simplement être définie et ensuite on ne pourra que lire à l'intérieur donc on pourra seulement y accéder en lecture et donc on ne pourra plus modifier sa valeur. 

On peut acheter on a grosso modo 2 manières de pouvoir définir des constantes, je vais vous le montrer il y a une manière un peu plus ancienne que l'autre mais attention c'est pas parce que je dis ancienne qu'il ne faut plus l'utiliser. Elles sont toutes les 2 très très utilisées de manière régulière et tout le temps même encore maintenant en PHP donc c'est vous qui veut verrez à l'usage évidemment selon vos préférences laquelle des 2 syntaxes vous utiliserez. 

La première concerne l'utilisation d'une fonction donc la fonction qui s'appelle define tout simplement, on va dire de définir une constante, et elle prend 2 paramètres qu'on va passer comme ceci.
```
	define("", "");
```
Le premier paramètre va être le nom de la constante et ensuite on passera sa valeur donc le nom de la constante par convention au niveau des programmeurs et donc tous les créateurs de langage se sont accordés sur l'idée qu'une constante serait écrit en majuscule comme ça chaque programmeur dès qu'il voit un moto t'écris en majuscule, il peut comprendre que c'est une constante. 

D'ailleurs le langage PHP écrit toutes ces constantes en majuscules Donc vous avez toutes les raisons de le faire aussi. 

Une constante ça peut être par exemple ceci.
```php
	define("PSEUDO_ADMIN", "Jason");
```
Vous avez un pseudo et vous allez pouvoir l'afficher. Pour l'afficher, on note simplement le nom de la constante.
```php
<?php
define("PSEUDO_ADMIN", "Jason");

echo PSEUDO_ADMIN;
```
Pas besoin de symbole dollar `$`, ça permet comme ça de différencier constante de variable même si ça fonctionne un peu comme une variable mais seulement accessible en lecture. Ensuite j'actualise et ça s'affiche.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	Jason
```
J'actualise et là vous voyez que ça s'affiche bien. 

Le jour où je vais vouloir modifier la constante, il faudra la modifier à l'endroit où on l'a créé, à l'endroit où on l'a déclaré. C'est le seul moment où vous allez pouvoir faire quelque chose il y A partir du moment où vous avez défini votre constante, elle ne peut plus jamais être modifiée. Il est impossible de changer la valeur comme ça et de tenter de refaire quelque chose dérrière.
```php
<?php
define("PSEUDO_ADMIN", "Jason");
echo PSEUDO_ADMIN;

PSEUDO_ADMIN = "Jason";
echo PSEUDO_ADMIN;
```
Il va tout simplement vous mettre une erreur comme quoi vous ne pouvez pas faire d'affectation. 
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	Parse error: syntax error, unexpected '=' in ... onstantes\index.php on line 44
```
Voilà il vous dit que l'opérateur d'affectation '=' ne peut pas être utilisé tout simplement et qu'il y a une erreur de syntaxe pour lui par rapport à ça donc effectivement on ne peut pas faire d'affectation sur une constante, c'est impossible. 

Une constante est une valeur accessible qu'en lecture seule.

Alors là bien sûr j'ai fait comme ça mais vous pouvez passer éventuellement par une variable même si là pour le coup il n'y aurait pas d'intérêt par rapport à ce code mais là j'ai mis directement en dur l'info "Toto" mais ça peut être admettons par exemple dans un autre fichier de config. 

Vous auriez par exemple la variable $config_pseudo_admin. Admettons dans un fichier de configuration vous auriez défini le pseudo.
```php
	<?php
	$config_pseudo_admin = "Jason";

	define("PSEUDO_ADMIN", "Jason");

	echo PSEUDO_ADMIN;
```
Et puis après dans votre autre fichier PHP, vous allez appeler le fichier de config et puis là vous allez lui passer l'information comme ça pour du coup définir les constantes.
```php
<?php
$config_pseudo_admin = "Jason";

define("PSEUDO_ADMIN", $config_pseudo_admin);

echo PSEUDO_ADMIN;
```
Voilà ça fonctionnera de la même manière.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	Jason
```
Voilà on peut passer une variable sans problème. 

On peut même passer même si on ne l'a pas encore vu maintenant un tableau. Vous verrez que depuis les dernières versions de PHP, on peut même passer un tableau en tant que constante, ça peut être pratique aussi. Alors ça on aura l'occasion d'en reparler parce qu'on n'a pas encore vu les tableaux et n'oubliez pas que sur cette formation on travaille avec PHP 7 d'accord au moment où je fais cette vidéo la version la plus récente c'est la version la plus récente de PHP donc je vous avais dit que si vous voulez travailler en PHP 5 ou encore plus bas ce qui serait d'ailleurs bizarre. Vous faites comme vous voulez d'ailleurs vous êtes libre par contre vous aurez pas mal de choses qui ne fonctionneront pas chez vous donc il ne faut pas vous étonner. 

Travailler surtout si vous démarrez en programmation et que vous démarrez en PHP, j'espère que vous avez suivi l'installation comme je vous l'ai suggéré et que vous êtes directement passé par PHP 7 parce que ce serait dommage de s'en priver vu les performances que ça apporte, vu les nouveautés que ça apporte aussi et du coup tout ce que je vais pouvoir vous montrer avec PHP 7 sur cette formation avec les différentes vidéos. 

Donc voilà comment on définit cette petite constante donc retenez simplement qu'une constante, on ne peut pas modifier sa valeur d'accord on peut juste lire ce qu'elle contient mais c'est tout. On ne peut rien faire d'autre. 

Alors ça peut être par exemple ce genre de choses, vous pouvez par exemple définir votre valeur pi parce que à priori la valeur arrondie de valeur pi ne doit pas changer.
```php
<?php
$config_pseudo_admin = "Jason";

define("PSEUDO_ADMIN", $config_pseudo_admin);
define("PI", 3.14);

echo PI;
```
Voilà ça fonctionnera de la même manière.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	3.14
```
Voilà puis fonctionne en tant que chaîne de caractères "3.14" et en tant que nombre 3.14 d'accord vous pouvez passer une chaîne en tant que nombre peu importe parce que ça prend n'importe quoi, une variable, un tableau et cetera comme on le verra donc ici on veut passer pi en tant que nombre donc on peut le laisser comme ça. 

Voilà comme ça ça fonctionne aussi, on ne pourra jamais changer ça donc c'est plutôt pratique. Sur de vrais projets complexes, ce qu'on va faire c'est qu'on va définir pas mal de constantes par exemple pour la racine du site, pour l'e-mail de l'administrateur, pour des informations comme ça qui ne vont pas changer ou en tout cas pas une fois quand elles ont été définies comme ça il y a juste à configurer tout notre projet dans le fichier de config où on aurait tous les define's, toutes les constantes de créés et ça va se répercuter sur tout l'ensemble du projet. 

Et le jour où on veut changer une seule info, plutôt que de modifier partout et d'avoir des variables qui traîne à droite et à gauche, on aura toutes les définitions de constantes faites dans un fichier et on pourra tout modifier à la volée. Et ça ça fonctionne partout que ce soit en programmation web, que ce soit en programmation d'applications, de jeux vidéo ou n'importe quoi. 

Quand on fait de la bonne programmation c'est comme ça qu'on procède, on crée beaucoup de constantes pour avoir des informations pratiques à utiliser. 

D'ailleurs en parlant de constante déjà défini parce que là ce sont des constantes que nous avons créées, évidemment PHP a déjà des constante qui existent. Et je vais vous en montrer une qui va simplement vous dire quelque chose alors on va faire PHP_INT_MAX. Voilà, on va faire ce genre de chose.
```php
<?php
echo PHP_INT_MAX;
```
```txt			
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	9223372036854775807
```
Voilà on a fait ce genre de chose et voilà ce qu'on obtient 9223372036854775807 qui est le nombre maximum de mon PC c'est-à-dire que tout le monde n'aura peut-être pas le même nombre, il y a même de fortes chances que vous n'ayez pas le même nombre. C'est le nombre maximum que peut stocker une variable de type entier sur mon ordinateur sachant que je suis en 64 bits donc c'est un adressage beaucoup plus grand et vous voyez que le nombre est plutôt grand on est sur des millions et des milliards et cetera. 

Si j'étais en 32 bits, ça s'arrêtait à 2 milliards et quelques donc ça s'arrête très plus ou moins grosso modo à 2 854775807 … Donc 2 milliards et quelques parce que c'est du 32 bits et comme on a du 64 bits le nombre est beaucoup beaucoup plus grand. C'est un nombre illisible parce que tout est attaché et du coup ce n'est pas forcément pratique à la lecture donc ça permet comme ça de récupérer certaines constantes ce qui est très pratique et permet assez d'avoir des choses qui ne vont pas changer parce que ça ce sont des informations liées à votre machine ou liées à PHP en particulier donc ces informations là ne vont jamais changer d'accord il n'y a absolument aucune raison que ça change. 

On a le même d'ailleurs pour PHP_INT_MIN qui est l'inverse pour le nombre minimum.
```php
<?php
echo PHP_INT_MIN;
```
```txt			
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	-9223372036854775808
```
Voilà le minimum c'est le nombre négatif par rapport à ça, et on doit avoir pour la valeur disponible c'est-à-dire PHP_INT_SIZE. 
```php
<?php
echo PHP_INT_SIZE;
```
```txt			
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	8
```
Voilà c'est SIZE et donc il vous met le nombre de octets, c'est-à-dire que les entiers sont stockés sur 8 octets voilà d'ailleurs 8 octets ça fait 32 parce que 4 fois 8, non et 8 fois 8 = 64, et oui comme c'est des octets on multiplie par 8 donc je suis bien en 64 bits par contre peut être que vous sur votre PC vous verrez le nombre 4. Ça voudrait dire que ce serait codé sur 4 fois 8 octets donc 4 fois 8 = 32 et du coup ça voudrait dire que vous êtes sur du 32 bits. 

Voilà tout dépend de votre machine mais vous voyez que du coup grâce à ces constantes, on peut récupérer des valeurs ok moi je sais que sur mon PC du coup sur $unEntier. On fait donc une variable dans lequel on peut lui mettre maximum le nombre qu'on a vu tout à l'heure avec PHP_INT_MAX c'est-à-dire un nombre très grand donc ça laisse de la marche par contre si je commence à mettre un nombre comme ça là je serais sûr que ça dépasse.
```php
	$unEntier = 16464611000000000000000000000;
```
Là je suis sûr qu'il dépasse largement parce que vous avez vu le nombre de tout à l'heure qui était beaucoup plus petit que celui là donc ici ça ne marcherait pas il y aurait un gros problème d'ailleurs si on tente de l'afficher.
```
<?php
$unEntier = 16464611000000000000000000000;

echo $unEntier;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	1.6464611E+28
```
Voilà on aurait du coup un nombre tout bizarre qui est sûrement d'ailleurs pas du tout correct en termes d'approximation, à moins qu'il soit correct mais comme le nombre a dépassé, PHP en fait l'interpréter, ça c'est des choses assez récentes aussi c'est-à-dire que quand le nombre dépasse la fourchette de valeur disponible plutôt que de vous mettre une erreur toute bête, ce qu'il fait en fait c'est qu'il transforme en flottant automatiquement et il lui met du coup une valeur qui est à peu près arrondie puisque ce sont des puissances de 28 donc on a un nombre qui n'est pas possible qui essaie de faire une notation scientifique avec un arrondi. 

Voilà ça c'est des choses qu'il faisait avant parce que avant il faisait une erreur mais maintenant non, automatiquement ça transforme en nombres flottants. 

Voilà pour ça donc tout intérêt du coup de vous servir comme ça de cette petite constante, elles ont vraiment leur utilité et on aura l'occasion de toute façon de travailler avec pas mal de constantes définies avec PHP quand on fera des bases de données, quand on travaillera avec des bases de données, on utilisera également des constantes spécifiques que vous verrez nous servirons énormément énormément sur pas mal de choses donc on aura l'habitude de se servir et de lire des constantes parce qu'on ne peut pas les modifier bien sûr. 

Et on pourra bien évidemment définir et créer nos propres constantes aussi. 

Voilà pour la première méthode donc le fameux define().

Alors la 2e méthode c'est tout simplement l'utilisation d'un mot cle.

Vous allez faire const suivi de votre constante sans symbole dollar.
```php
	const PI =
```
Et vous mettez ensuite la valeur que vous voulez.
```php
	const PI = 3.14;
```
Et à partir de ce moment-là on peut sans problème l'afficher.
```php
<?php
const PI = 3.14;
echo PI;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	3.14
```
Par contre je ne pourrai jamais encore une fois modifier ma constante.
```php
<?php
const PI = 3.14;
PI = 3.14159265; 
echo PI;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	Parse error: syntax error, unexpected '=' in ... on line 186
```
Voilà il vous met la même erreur que tout à l'heure pour dire qu'il n'accepte pas l'opérateur de affectation '=' sur une constante donc ça ne fonctionne pas. 

Alors ça dans quel cas on va l'utiliser ? alors déjà il ne faut pas utiliser cette syntaxe const PI = 3.14; quand vous êtes dans une fonction qu'on verra plus tard, il ne faut pas le faire quand vous êtes dans une condition ni quand vous êtes dans une boucle donc tout ce qui concerne les structures de contrôle que vous ne connaissez probablement pas si c'est votre première formation en programmation mais que nous allons aborder dans les vidéos suivantes donc évidemment vous serez à quoi ça correspond. 

Généralement ça les const's se remplacer tout en haut de notre fichier, tout en haut enfaite du code avant de commencer à mettre l'algorithme donc on va le mettre le plus haut possible pour éviter que ce soit dans une fonction ou ailleurs mais comme ce sont souvent des valeurs de paramètre et de référence, ça tombe bien ça va pouvoir comme ça être utilisé un petit peu partout au sein de notre programme un peu de manière globale. 

Voilà pour sa partie sur les constantes et je pense qu'on a fait le tour, il n'y a pas grand chose à dire en plus. 

C'était une vidéo assez courte comparée à la précédente mais je voulais faire une petite vidéo on va dire tranquille pour que vous puissiez assimilé et digéré ce qui a été vu précédemment parce qu'il y avait beaucoup de choses sur les variables, et il y a beaucoup de choses à venir donc le repos ne sera que de courte durée par rapport à ça. 

Après prenez bien évidemment le temps de tout revoir, de tester des programmes, de programmer tout ça, de vérifier et de revoir la vidéo si nécessaire, de vous exercer, de vous entraîner pour bien comprendre tout ça. 

Et s'il y a des questions comme d'habitude, vous me le demandez je réponds toujours à tout le monde et je pense qu'on a fait le tour alors que j'aurai peut-être pu vous montrer un exemple avec les tableaux mais comme on n'a pas encore abordé ça, je ne vois pas l'intérêt si on le fait vous risquez d'être un peu perdu mais on en parlera plus tard des constantes avec les tableaux directement sur la vidéo avec les tableaux et je penserai du coup à revenir dessus. 

Je compte peut-être sur des gens pour me le rappeler dans un moment je ferai la vidéo sur les tableaux, et bien sûr au moment où je fais cette vidéo la vidéo sur les tableaux n'est pas encore faite. 

Et voilà je vais vous laisser du coup avec cette partie, j'espère que ça vous a plu aussi et que ça vous aurait permis d'apprendre d'autres petites choses en plus c'est en complément à l'utilisation des variables et tout ça. 

Alors évidemment je ne l'ai pas dit mais vous pouvez les concaténer dans un echo, c'est comme pour les variables, vous pouvez faire ça.
```php
<?php
const PI = 3.14;
echo 'PI = '.PI;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/007_constantes/
	PI = 3.14
```
Voilà on peut concaténer avec du texte évidemment même si je ne l'ai pas dit parce que ça me paraît logique et après ça fonctionne comme des variables, ça s'écrit pareil et on définit même si c'est seulement accessible en lecture et pas en modification. 

Je vous dis à bientôt pour la prochaine vidéo en PHP. 

À bientôt tout le monde