# [8. Opérateurs](https://www.youtube.com/watch?v=FeLf4G800ks)

Bonjour à tous et bienvenue pour la séance 8 en PHP. 

Nous allons parler des opérateurs même si nous n'allons pas tous les voir parce qu'il y en a beaucoup que nous allons surtout aborder avec d'autres chapitres en tout cas d'autres séances de cette formation donc je vais vous montrer quels sont les premiers opérateurs que vous allez devoir connaître avec ce langage de programmation. 

On va directement passer sur le code, on va revenir sur ce qu'on a vu avec les variables maintenant que vous avez apprise cette notion là, on va les réutiliser tout le temps parce que comme je vous l'avais expliqué les variables sont vraiment utiles pour stocker des données et les utiliser au cours de notre programme donc on va pouvoir évidemment travailler là-dessus. 

Alors les premiers opérateurs à connaître c'est pas compliqué parce qu'on tombe souvent en informatique, on vous dit qu'il faut être très bon en maths alors que ça va être effectivement le cas pour l'informatique appliquée un certain domaine très précis par exemple c'est sûr que si vous bosser dans l'aérospatiale, il est évident que vous aurez besoin d'avoir des notions de mathématiques, physiques et peut-être même plus dans ce genre de domaine mais dans notre 90% des cas évidemment ce ne sera pas utile d'avoir des connaissances mathématiques très poussée en tout cas donc voilà. 

Au niveau de ce qu'on appelle les opérateurs, ce sont les opérateurs mathématiques que vous avez appris à l'école au plutôt depuis la primaire comme l'addition la soustraction la multiplication et la division même si on va en voir quelques uns nouveau avec l'informatique que vous connaissez peut-être ou peut-être pas parce que dans certaines écoles on peut les étudier, dans certaines études aussi mais pas forcément partout et je vais vous montrer un petit peu tout ça. 

Alors les variables jusqu à présent quand je vous ai montré (on fait une petite révision très rapide), vous pouvez créer une information par exemple je vais mettre $age comme ceci et on pouvait afficher l'information en faisant de la concaténation de chaîne sur lequel on reviendra dessus parce que là concaténation ça c'est un opérateur `.` en fait, c'est l'opérateur de concaténation qui sert notamment pour les chaînes de caractères voilà donc vous pouvez l'utiliser comme ceci.
```php
	$age = 25;
	echo "Tu as ".$age." ans";
```
Alors logiquement je n'ai pas besoin de faire une concaténation quand j'utilise les doubles quotes " $age " comme je vous l'avais expliqué donc voilà si on veut être plus exact on fera plutôt comme ça.
```php
<?php>
$age = 25;
echo 'Tu as '.$age.' ans';
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	Tu as 25 ans
```
Donc voilà j'ai actualiser et voilà comment ça s'affiche. Bon en mettant 150 pourcent ce sera un peu plus lisible pour moi donc voilà comment vous pouvez fonctionner à ce niveau là. 

Alors ici on va pas forcément faire des calculs sur l'âge, ce serait un peu bizarre mais on peut éventuellement avoir des nombres donc on va reprendre des nombres :
```php
	$number1 = 14;
	$number2 = 26;
```
Vous allez pouvoir effectuer tout un tas d'opération au niveau de vos variables alors ici ce sont des expressions. On va pouvoir noter des expressions à la suite par exemple et dans ces expressions nous pouvons effectuer des opérations via l'aide d'opérateurs. 

On n'est pas obligé de passer par une variable intermédiaire mais on va le faire pour que ce soit plus lisible pour vous que l'on va appeler comme ceci. 
```php
	$number1 = 14;
	$number2 = 26;
	
	$result =
```
Et on va pouvoir effectuer tout un tas d'opérations et à la fin il affichera en fait, on fera juste ça.
```php
	$number1 = 14;
	$number2 = 26;
	
	$result =
	
	echo $result;
```
À partir de là, on a le premier opérateur à connaître et je vais vous le noter c'est-à-dire parmi les opérateurs arithmétiques c'est-à-dire l'opérateur d'addition, de soustraction avec le symbole `-`, l'étoile `*` pour le symbole de multiplication et vous avez le slash `/` pour le symbole de division. Voilà comment ça fonctionne en informatique.
```php
	/*
		Arithmétiques : +, -, *, /
	*/
```
Donc si je vais faire la somme de ce nombre, j'ai juste à faire tout bêtement ceci.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = $number1 + $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	40
```
Et là j'obtiens bien le résultat des 2, pour une soustraction c'est la même chose mais en remplaçant par le symbole - d'accord.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = $number1 - $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	-12
```
On obtient donc bien -12, et pour la multiplication et cetera.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = $number1 * $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	364
```
Et la division.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = $number1 / $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	0.53846153846154
```
Alors pour la télévision vous obtenez ce que vous voyez un nombre à virgule donc un flottant avec plusieurs décimales éventuelles, par contre si vous voulez la partie entière seulement d'une division vous allez pouvoir utiliser une fonction même si on n'a pas encore parlé des fonctions et que je vous expliqué que pour le moment tout ce que vous avez à retenir d'une fonction c'est qu'elle possède un nom, quel peut prendre certains paramètres et elle va faire quelque chose. Uniquement une seule chose donc là on a une fonction en PHP qui existe et qui permet de faire une division entière seulement de 2 nombres donc pour l'utiliser c'est très simple c'est à dire au lieu d'utiliser un opérateur vous allez appeler la fonction intdiv() sachant que le 2e paramètre est le diviseur voilà.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = intdiv($number1, $number2);
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	0
```
Et là vous allez obtenir une division entière, et ça vous met 0 parce que effectivement on obtenait 0, … quelque chose donc c'est bien une division entière qui est fait. 

Alors ça `/` c'est la division décimale mais si vous voulez une division euclidienne entière, vous utilisez la fonction intdiv() très important à ce niveau-là. 

Ensuite on a un nouvel opérateur qui est % et le % va permettre de désigner le modulo. 
```php
	/*
		Arithmétiques : +, -, *, /, %
	*/
```
Le modulo vous connaissez peut être lorsque justement vous faites une division euclidienne, vous allez pouvoir avoir un reste de cette division, Eh bien le modulo c'est justement ça. Quand on fait un intdiv() comme je vous ai montré, vous voyez qu'on a simplement le résultat de la division mais on n'a pas son reste et on l'a perdu donc si on veut garder que le reste d'une division, on peut utiliser justement le symbole modulo % donc on peut faire tout simplement ça.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = 14 % 26;
echo $result;
```
```php
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	14
```
Et là on obtiendra le reste de la division euclidiennes. 

Si on veut une valeur un peu plus précise, on peut également utiliser une fonction. Il y a aussi une fonction pour le modulo à connaître qui est fmod(). Je vais noter les fonctions ici.
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques : +, -, *, /, %
	*/
```
Donc vous pouvez faire ça.
```php
<?php
$number1 = 14;
$number2 = 26;

$result = fmod(14, 26);
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	14
```
De toute façon encore une fois vous apprendrez à faire des fonctions et un les utiliser dans les détails parce qu'il y a une vidéo spécialement dédiée pour les fonctions mais pour le moment vous vous contactez juste de les utiliser et c'est tout. Et là on obtient le même résultat (14) puisqu'il n'y a pas de détail à donner en plus mais dans certains cas vous pourrez voir que l'une peut avoir un résultat différent par rapport au décimal par rapport à tout ça donc n'hésitez pas à voir à ce niveau-là pour avoir un détail précis du calcul si vous avez besoin éventuellement d'avoir quelque chose beaucoup plus précis. 

Voilà ça c'est le modulo fmod() avec des décimales alors que à l'inverse intdiv() c'est pour avoir une division entière donc on n'aura pas de valeur décimal ici alors que avec fmod() on en aura éventuellement si il faut en générer. 
```php
<?php
$number1 = 15;
$number2 = 2;

$result = fmod($number1, $number2);
echo $result;
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Donc on passe nos variables sinon ça n'a aucun intérêt d'utiliser des variables, voilà comme ça vous obtenez le résultat par rapport à ça. Alors pourquoi est-ce que vous obtenez 1 ? Tout simplement parce que si vous divisé 15 par 2, ça fait 7 et il reste 1 pour arriver à 15 donc vous Obtenez bien ici le reste de la division. Ça c'est important de savoir. 

Dans certains cas ça peut être utile par exemple quand on a des valeurs un virgule.
```php
<?php
$number1 = 15.4;
$number2 = 2.67;

$result = fmod($number1, $number2);
echo $result;
```
```php
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	2.05
```
Voilà comme ça on va dire et là vous voyez que le reste est 2.05 alors que si j'étais passé simplement par l'opérateur modulo, je peux avoir un résultat différent.
```php
<?php
$number1 = 15.4;
$number2 = 2.67;

$result = $number1 % $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Valeur automatiquement parce qu'il nous met une valeur entière parce qu'il ne prend pas de valeur décimale donc voyez en fonction de ce que vous avez besoin de faire si vous devez utiliser l'opérateur % ou si vous devez utiliser une petite fonction fmod() qui est d'avoir éventuellement quelque chose d'un peu plus précis, ou pour la division quelque chose avec juste la partie entière intdiv() donc ça c'est à savoir c'est pour ça que je voulais les présenter. 

Ces 2 fonctions sont utiles au niveau des opérateurs. 

Donc voilà grosso modo pour les opérateurs arithmétiques. 

Et on en a un petit dernier qui est un ajout donc ajouter depuis PHP 5.6 quelque chose comme ça qui date d'ailleurs et qui est assez vieux maintenant, c'est l'opérateur simplement de puissance avec deux étoiles **.
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques : +, -, *, /, %, **
	*/
```
Vous mettez simplement 2 étoiles pour dire simplement que $number1 à la puissance $number2 donc on peut faire comme ceci.
```php
<?php
$number1 = 2;
$number2 = 4;

$result = $number1 ** $number2;
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	16
```
2 puissance 4 et vous obtenez 16 parce que je rappelle que 2 puissance 4 que vous écrivez en mathématiques c'est-à-dire 2 avec un petit 4 en haut, ou alors en informatique on l'écrit comme ça 2^4 et sur la calculatrice ça revient à faire `2^4 = 2 x 2 x 2 x 2`. Et on obtient bien évidemment 16. 

Voilà ça c'est les opérateurs arithmétiques grosso modo à connaître. 

Ensuite on a les opérateurs pour la chaîne de caractères parce qu'on les as déjà vus, je les ai un petit peu présenté précédemment mais on va revenir un petit peu dessus pour tout ce qui concerne la concaténation mais avant on va d'abord revenir sur l'affectation ce qui est un petit peu plus logique c'est-à-dire les opérateurs dit d'affectation. 
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: 
	*/
```
Donc l'affectation vous l'avez déjà utilisé précédemment c'est le fameux symbole = qui attention ne veut pas dire que $number1 est égal à 2 mais on dit simplement qu'on affecte la valeur 2 à la variable qui s'appelle $number1 donc il faut bien comprendre comme ça. 

C'est un peu comme si on fait et on le fait souvent en algorithmie, on écrivait ça comme ça.
```php
	$number1 <- 2;
```
c'est-à-dire qu'on met 2 dans la variable $number1 sauf qu'en informatique ils se sont accordés pour utiliser l'opérateur '=' le symbole égal donc ça c'est l'affectation simple. 

Il n'y a vraiment pas plus simple à ce niveau-là pour affecter une valeur précise. 

On a également des opérateurs d'affectation un petit peu différent, par exemple si on veut pouvoir faire une opération suivie d'une affectation, alors comment est-ce que ça peut fonctionner ? Eh bien c'est très simple, je commence d'abord par prendre un seul nombre pour le coup, on a pas besoin de prendre $result non plus, on peut garder $number tout court.

Ensuite si je fait par défaut ça, vous êtes d'accord qu'on va juste affecter, changer la valeur donc ça va afficher en toute logique 4.
```php
<?php
$number = 2;
$number = 4;

echo $number;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	4
```
Pas de problème à ce niveau-là sauf que je peux aussi décider de faire un calcul, je peux par exemple dire que tu vas faire une somme et affecter ensuite en même temps en faisant par exemple += et donc ça je vais les noter ici.
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
	*/
```
Voilà vous avez compris le principe, alors comment est-ce que ça va fonctionner, cette ligne là. 
```php
	$number = 2;
	$number = 4;//$number = $number + 4

	echo $number;
```
Ça revient à dire $number, maintenant on lui affectent la valeur de lui-même donc la valeur qu'il avait avant plus 4.

Donc vous pouvez le noter comme ça : `$number = $number + 4`

Vous avez le droit de le noter comme ça pour vous si c'est plus simple c'est-à-dire que vous faites d'abord la somme $number + 4 donc ça va faire 4+2 (6) et du coup on va affecter 6 la variable $number, ça aura changé sa valeur. 

C'est au choix soit vous faites cette notation `$number = $number + 4` parce que pour vous c'est plus clair, soit vous avez un petit peu plus l'habitude ou alors vous prendrez l'habitude par la suite en programmation et vous pourrez directement noter les 2 ensemble +=. 

L'avantage c'est qu'en faisant directement opération affectation, vous n'avez pas besoin d'écrire 2 fois la variable $number. Vous mettez seulement une fois la variable += quelque chose, -=quelque chose et cetera. 

Et là on obtient 6.
```php
<?php
$number = 2;
$number += 4;//$number = $number + 4

echo $number;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	6
```
C'est parfaitement logique parce qu'on prend la valeur d'avant (2) et on l'incrémente d'une certaine valeur et on affecte, c'est bien dans cet ordre là. 

Si on veut faire l'inverse en fait `-=`, c'est exactement pareil, on obtiendra moins 2.
```php
<?php
$number = 2;
$number -= 4;//$number = $number - 4

echo $number;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	6
```
`*=`, on va multiplier 2 par 4 et affecter cela à $number donc on obtient bien 8.
```php
<?php
$number = 2;
$number *= 4;//$number = $number * 4

echo $number;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	8
```
Et cetera et cetera … voilà grosso modo comment ça fonctionne pour ces opérateurs de affectation, ou d'opérations affectation. Je les ai appelé affectation de manière générale mais voilà ça concerne tout ça.
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
	*/
```
On allez opérateur de concaténation et on va revenir dessus parce qu'on en a déjà vu donc ça va aller assez vite. Alors l'opérateur de concaténation que vous connaissiez bien c'est le point `.` d'accord et on a aussi le `.=` dont je n'ai pas encore parlé mais qui est très simple à comprendre.
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
	*/
```
On va noter par exemple :
```php
	$strA = "Bonjour ";
	$strB = "tout le monde";
```
Je peux et je vous l'avais déjà montré la dernière fois. On l'a fait d'ailleurs avec des variables et du texte qu'on n'est pas obligé de concaténer que des chaînes, on peut concaténer également avec d'autres variables. On peut faire ça avec le symbole `.` donc il suffit juste de faire ça.
```php
	$strA = "Bonjour ";
	$strB = "tout le monde";
	
	echo $strA . $strB;
```
Mais vous pouvez également tout attaché, je vous avait dit que ça ne posais aucun problème.
```php
<?php
$strA = "Bonjour ";
$strB = "tout le monde";
	
echo $strA.$strB;
```
Ce qui est important c'est les caractères que vous laisser éventuellement dans un texte, par exemple un espace après Bonjour "Bonjour ". 

Alors vous pouvez tous collés ensemble si c'est plus lisible pour vous.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	Bonjour tout le monde
```
Voilà donc ça a bien concaténer les 2 chaînes ensemble qui n'en sont plus qu'une seule. 

Vous pouvez également faire ça dans une variable $result c'est-à-dire une variable intermédiaire dans le cas où vous auriez besoin de garder cette concaténation assez souvent, et l'utiliser souvent dans votre programme, vous n'allez pas refaire à chaque fois le calcul donc pour le faire de manière optimisée vous le faites qu'une seule fois pour toute la concaténation et ensuite vous pouvez réutiliser le résultat quand vous voulez.
```php
<?php
$strA = "Bonjour ";
$strB = "tout le monde";

$res = $strA.$strB;

echo $res;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	Bonjour tout le monde
```
Si vous n'avez besoin de le faire qu'une seule fois `echo $strA.$strB;` et si par contre vous allez avoir besoin d'afficher plusieurs fois `"Bonjour tout le monde"` tout concaténé et bien c'est bien de faire une variable intermédiaire, stocker cette concaténation $res et du coup travailler directement avec la variable qui la concaténation `echo $res;` voilà ça va optimiser votre programme. 

Alors pour faire la suite nous pouvons faire également l'opérateur de concaténation et d'affectation `.=` alors comment est-ce que ça fonctionne ? Admettons par défaut je crée une chaîne vide.
```php
	$chaine = "";
	echo $ chaine;
```
Alors j'essaie de l'afficher et on part du principe que la chaîne existe déjà, on ne peut pas faire une affectation à une concaténation sur une chaîne qui n'existe pas encore.

Si on essaie de faire dès le départ ça $chaine .= ""; de toute façon vous allez avoir un problème à ce niveau là.
```php
<?php
$chaine = "";
echo $chaine;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Voilà vous n'arrivez pas affiché mais le mieux c'est de partir d'une chaîne comme ceci $chaine = ""; d'accord vous faites une affectation et vous essayez de l'afficher. 
```php
	$chaine = "";
	echo $ chaine;
```
Par la suite je fais ça.
```php
	$chaine = "";
	echo $ chaine;
	
	$chaine .= "A";
```
Alors qu'est-ce que ça veut dire ? Ça veut dire que tu prends comme pour les opérateurs d'affectation d'ailleurs on pourrait dire que '.=' est également un opérateur de affectation. On pourrait d'ailleurs l'écrire avec les autres : =, +=, -=, *=, %=, .=

Du coup on va dire que c'est un petit peu les 2 parce que affectation et concaténation pourrait tenir ensemble mais peu importe donc '.=' peut être mis dans la catégorie des affectations mais on s'en fout un petit peu de la catégorie et l'important c'est que vous connaissiez les opérateurs. 

Du coup on va prendre le résultat d'avant, ici c'est une chaîne vide "" et on va ajouter A et du coup ça va bien afficher la variable $chaine.
```php
<?php
$chaine = "";
echo $chaine;

$chaine .= "A";
echo $chaine;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	A
```
Et on peut refaire pareil le site fois-ci on va ajouter B à la suite et cette fois-ci je n'ai pas d'espace s'affichent directement.
```php
<?php
$chaine = "";
echo $chaine;

$chaine .= "A";
echo $chaine;

$chaine .= "B";
echo $chaine;
```
```php
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	AAB
```
Et il va concaténer, affecter et ajouter. Et là vous allez me dire mais pourquoi ça fait `AAB` ? tout simplement parce que le A on l'avait déjà donc c'est pour ça qu'il faut bien comprendre la différence après le premier A, on a dit de reprendre ce qu'il y avait avant donc le premier affiché c'est le 2e echo dans mon code sachant que le premier echo n'affiche rien donc si vous ne voulez pas afficher l'intermédiaire vous pouvez faire ça.
```php
<?php
$chaine = "";
echo $chaine;

$chaine .= "A";
$chaine .= "B";
echo $chaine;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	AB
```
Vous faites ça simplement c'est-à-dire qu'on part d'une chaîne vide, on concatène avec A, on concatène avec B et là on affiche pour obtenir seulement AB. 

Alors c'est purement logique, il n'y a rien de compliqué dans ce que je vous montre-là bien que c'est beaucoup d'opérateurs mais c'est en réalité très très simple. Il suffit juste que vous testiez de votre côté avec des valeurs précises à vous et vous allez tout de suite comprendre le fonctionnement. 

Ça va rentrer tout seul, ça en 5 minutes vous avez tout pigé sans problème parce que c'est vraiment très très simple cette vidéo c'est-à-dire la séance sur les opérateurs, il n'y a vraiment rien de compliqué en tout cas pour ce qu'on va voir là. Après certains sont un petit peu plus compliqué notamment les opérateurs de bits mais on ne va pas en parler et je ferai éventuellement un tuto dessus mais ça ne va pas concerner le coup parce que ça ne va pas concerner énormément de gens non plus et vous n'en aurez pratiquement pas besoin dans tout vos programmes donc on n'en parlera pas forcément ici. 

Voilà pour ces opérateurs du coup au niveau concaténation. 

On va terminer je pense avec des opérateurs logiques mais on reviendra surtout dessus après lorsque on travaillera sur les structures de contrôle, les conditions et tout ça mais on peut déjà en parler un petit peu. 

Alors il y a également d'autres opérateurs, on va avoir des opérateurs de comparaison qui vont nous servir justement quand on va étudier les conditions et les boucles donc je ne vais pas revenir dessus tout de suite mais retenez ce nom, opérateur de comparaison. 

Je vous reparlerai des opérateurs de comparaison dans quelques vidéos prochaine. 

On aura également des opérateurs sur les tableaux, vous verrez que quand on étudiera les tableaux on a également des opérateurs très pratique sur le tableau, et même un petit opérateur un peu spécial quand on va faire de la programmation objet mais c'est pareil c'est plus pour vous l'annoncer mais on ne va pas le voir évidemment tout de suite parce qu'on n'en est pas du tout là. 

Alors on va terminer continuer cette vidéo avec les opérateurs logiques qu'on va revoir également quand on étudiera les structures de contrôle mais on peut déjà les utiliser quand on fait de l'utilisation de variables donc au stade où vous en êtes c'est tout à fait utilisable. Voilà je vais les noter ici pour les opérateurs logiques :
```php
	/*
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
		Logiques		: and, &&, or, ||, xor
	*/
```
Je vais en parler parce qu'il y en a plein qui nécessitent des explications tels que xor le fameux ou exclusif je vais en parler parce que ça nécessitent des explications sinon il y en a plein qui vont pas comprendre. 

Alors `and` et `&&` signifie la même chose ça veut dire ET, ça veut dire qu'on va vérifier une valeur et une autre. 

`or` et `||` signifie qu'on vérifie une valeur ou une autre. 

Et `xor` signifie qu'on vérifie une valeur ou une autre mais pas les 2, ça ne peut pas être les 2. 

Et je vais vous expliquer tout ça. 

On va faire `$a = true;` mais on ne va pas mettre de conditions, on va voir directement ce qui nous affiche.
```php
<?php
$a = true;
$b = true;

echo $a and $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Voilà donc lui il passe directement par un entier, alors vous vous souvenez que le booléen c'est true ou false donc vrai ou faux et quand c'est vrai il affiche 1 et quand c'est faux il affiche 0 d'ailleurs je vous le re dis et je vais le re noter.
```php
	/*
		RAPPEL : 	Vrai -> true (1)
					Faux -> false (0)		
		
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
		Logiques		: and, &&, or, ||, xor
	*/
```
Comme ça vous avez tout ce qu'il faut au niveau des notes et ça c'est à retenir, c'est évidemment à connaître. 

Alors là qu'est-ce que je lui dis ? j'ai d'abord créé une variable $a et je lui affectent la valeur true donc un booléen alors la variable $b que je créé je lui affecte également un booléen true et enfin je dis à echo de me donner le résultat de cette opération $a and $b parce que c'est une opération que je viens de faire, j'ai utilisé un opérateur logique. 

Qu'est-ce que va vérifier cet opérateur logique and ? il va vérifier que ces variables sont égales à vrai donc sont égales à true, et le and il insiste bien sur le fait pour que cette opération soit dite vrai/valide c'est-à-dire que pour valider cette opération, il faut à la fois que là variable `$a` soit égal à `true` ET (d'où le and en anglais) la variable `$b` soit égal à `true` donc là vous avez remarqué que c'était bien le cas pour les 2 donc en toute logique on obtient `1` c'est à dire vrai. 

À partir du moment où je viens changer un des 2 et que je mets un des 2 à `false`, ça ne va plus fonctionner parce qu'il demande à ce que les 2 soit égal à true alors que là on en a qu'un seul des 2 donc on va obtenir 0.
```php
<?php
$a = true;
$b = false;

echo $a and $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Voilà on va obtenir 0 et d'ailleurs il ne l'affiche même pas. 

Voilà c'est 0, ça ne valide absolument rien d'accord ce n'est pas bon et si on met évidemment les 2 à false sans surprise on aura le même résultat.
```php
<?php
$a = false;
$b = false;

echo $a and $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Sans surprise c'est le même résultat donc c'est vraiment important. 

Alors le symbole or, c'est l'inverse ça veut dire qu'on lui dit en fait c'est soit l'un ou c'est soit l'autre, il faut au moins que une des 2 variables donc vous voyez que ça fonctionne par paire, on vérifie une variable et une 2e d'accord on ne peut pas faire ça sur 15000. On peut en faire sur plusieurs mais vous pouvez déjà le faire au minimum avec 2 donc vérifiez les 2 là sachant que le or, c'est l'une ou l'autre. S'il y a au moins une des 2 variables qui est égal à true ce sera vrai donc il va retourner `1` ici. 
```php
<?php
$a = true;
$b = false;

echo $a or $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Donc il va retourner `1`. 

En revanche pour que ce ne soit plus égal à vrai, il faut que les 2 du coup soit faux et dans ce cas-là ça ne fonctionnera plus.
```php
<?php
$a = false;
$b = false;

echo $a or $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Dans ce cas-là ça ne fonctionne plus donc ça c'est à retenir mais on peut tester également plusieurs variables sans problème, on peut s'amuser à faire ça et s'amuser à en faire une infinité de vérification comme ça.
```php
<?php
$a = false;
$b = false;
$c = true;

echo $a or $b or $c;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
On peut en fait en faire une infinité de vérification comme ça. 

Alors je vous rappelle que echo n'est pas une fonction, c'est une instruction d'accord comme le print mais pour les conditions vous verrez que vous pourrez accumuler comme ça plusieurs variables différentes $a or $b or $c … 

Alors là on demande à ce que $a soit égal à true ou alors $b ou alors $c comme vous voyez qu'il y a 1 des 3 qui est bien égal vrai, ça va nous retourner 1. Il n'y aura pas de problème par rapport à ça.

Donc cette expression $a or $b or $c, on évitera de le faire dans un echo comme ça, comme je vous l'ai dit ce sera beaucoup plus évident quand on fera des conditions mais au niveau de faire ça directement dans un echo, ce n'est pas forcément très propre mais on n'a pas encore vu plus de choses pour le moment dans ce langage PHP donc on va se contenter avec ce que l'on a pour le moment. 

Voilà pour la vérification. 

Alors vous avez remarqué qu'il y a également cette notation ici && et ||, et c'est un peu la même chose c'est-à-dire que si je fais ça vous ne verrez pas forcément de différence.
```php
<?php
$a = false;
$b = false;
$c = true;

echo $a || $b || $c;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Vous voyez qu'on obtient un aussi mais vous allez vous dire que du coup ils ont inventé un langage avec 2 opérateurs différents à chaque fois mais qui font la même chose donc alors quelle est l'utilité. 

Ne vous en faites pas s'il y a 2 opérateurs différents, c'est bien qu'il y a une utilité. 

Alors ici je rappelle qu'on va obtenir 0 avec &&.
```php
<?php
$a = false;
$b = false;
$c = true;

echo $a && $b && $c;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Alors là je rappelle qu'on obtient 0 parce qu'il faut absolument que les 3 soit égal à true, c'est la seule condition qui va valider l'ensemble de l'expression.
```php
<?php
$a = true;
$b = true;
$c = true;

echo $a && $b && $c;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Alors pourquoi il y a une différence ? simplement pour une question de priorité il s'agit n'est pas parlé mais je vais en parler pour la fin de la vidéo au sujet de la priorité des opérateurs. 

La priorité des opérateurs, vous savez qu'en mathématiques et je vais faire un petit rappel dessus pour ceux qui auraient éventuellement oublié que vous avez des opérateurs qui sont prioritaires par rapport à d'autres alors on va faire une petite révision de mathématique. Si je fais ce calcul là  4 + 3 x 9, il y en a peut être pas mal d'entre vous si l'on oublié vous allez commencer à faire 4+3=7 et ensuite vous allez faire 7x9, et vous allez dire que le résultat c'est 63 sauf que non. il faut savoir qu'en mathématiques, la multiplication et la division sont prioritaires à la soustraction et l'addition donc En bref c'est comme si on avait ça.
```txt
	4 + (3 x 9) = 63
```
Donc vous êtes censé d'abord faire la multiplication (3x9) et la somme après donc ça fait 4 + 27.
```txt
	4 + (3 x 9) = 4 + 27
```
Voilà ça c'est à retenir et après vous aurez le résultat qui sera du coup bien différent (31). 

Si vous voulez à tout prix faire la somme avant la multiplication, vous avez aussi expliqué qu'il fallait utiliser les parenthèses parce que les parenthèses sont prioritaires aux opérateurs que ce soit la multiplication la division et cetera donc là en mettant votre expression de cette manière vous allez faire avant la somme et ensuite seulement la multiplication.
```txt
	(4 + 3) x 9 =
```
Et là effectivement ce sera vrai de faire 4 + 3 = 7 d'abord et ensuite 7 x 9 = 63 donc là ce sera effectivement bon de fonctionner ainsi donc attention à ça c'est également valide en informatique. 

En informatique si vous faites $a + $b * $c ça va être différent, ce ne sera pas la même chose que de faire ($a + $b) * $c évidemment. 
```php
	$a + $b * $c
	($a + $b) * $c
```
`$a + $b * $c` -> Le programme va d'abord faire se calcule d'abord $b * $c et ensuite il va faire la somme de ce résultat avec $a.

`($a + $b) * $c` -> Et ici il va d'abord faire la somme là ($a + $b) et ensuite le résultat de cette somme, il va le multiplier avec $c. 

C'est la même chose en informatique donc vous voyez que tout ce que vous avez appris en primaire au collège en maths sur la priorité des opérateurs très simple arithmétique, vous pouvez l'appliquer en informatique et ça fonctionne pareil donc voilà. 

Pourquoi du coup, pour en revenir à ce qu'on disait, pourquoi 2 syntaxes différentes ?

and est équivalent à &&, et or est équivalent à ||, alors en quoi ça change ? ça change au niveau de la priorité des opérateurs. 

Je vais vous montrer comment ça fonctionne. je vais faire ma variable ceci.
```php
<?php
$result = false || true;
	
echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Il affiche 1 donc là à priori en faisant false || true. Je fais un truc bizarre en lui disant c'est faux ou c'est vrai mais alors comment est-ce que calcule le programme ? comment est-ce qu'il réfléchi par rapport à ça ? avec cette expression bizarre parce que humainement parlant, c'est un peu bizarre de dire que $result, tu lui affecte false ou true donc En bref il choisit lequel ? au pif ? il fait comment ? et si j'actualise plusieurs fois, c'est toujours 1. 

voilà on voit qu'il prends toujours true d'accord alors pourquoi est-ce qu'il prend toujours true ? il prend toujours true parce qu'il va lui affecté en fait le résultat d'accord c'est à dire qu'avec cet opérateur ||, cet opérateur va tout simplement afficher le résultat de la valeur. C'est une priorité c'est-à-dire qu'on lui dit false ou true donc En bref on lui dit que $result, son résultat sera vrai s'il est égal à faux ou vrai, et comme de toute façon voulu proposer de passer l'un ou l'autre et bien automatiquement comme true est passé dans la liste des 2 et bien ce sera toujours vrai.

Alors ça peut être assez complète j'avoue que c'est la partie la plus compliquée de cette vidéo mais c'est comme ça qu'il faut le comprendre. 

N'oubliez pas que le résultat qu'on obtient et 1, non pas parce que ça contient true ou false mais parce que cette expression false || true vaut vrai.

C'est un petit peu comme faire ça lorsqu'on va retourner echo de `$a || $b`.
```php
<?php
$a = false;
$b = true;
echo $a || $b;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Rappelez vous tout à l'heure, cette expression avec || (ou OR), elle retournait donc elle affichait 1 donc true si $a était égal à true ou alors, grâce à cet opérateur || (ou OR), $b est égal à true. Alors ici c'est exactement pareil sauf que au lieu de passer par des variables, je fais ça.
```php
<?php
$a = false;
$b = true;

$result = $a || $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Vous voyez qu'on obtient 1, et du coup j'ai fait comme ça pour que ce soit plus explicite pour vous plutôt que de mettre des valeurs en dur sinon il y en a qui ne vont pas comprendre. 

Alors ici on obtient le même résultat qu'avec OR, on a exactement pareil, mais alors du coup pourquoi est-ce qu'on obtient ça ? parce que là on lui dit simplement d'affecter le résultat directement à la variable donc il va affecter true d'accord il va affecter effectivement cette valeur. 

Alors ici c'est un booléen :
```php
<?php
$a = false;
$b = true;
$result = $a || $b;

echo $result;
echo gettype($result);
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1boolean
```
Voilà vous voyez que le type demain variable est un booléen effectivement ce n'est pas un entier, c'est ça qui est important à savoir. 

En revanche dans le cas où je vais faire ça.
```php
<?php
$a = false;
$b = true;
$result = $a or $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Comment ça va se passer ? Eh bien on va lui affecter d'abord false parce que vous voyez que $a =  false donc on va affecter false à la variable d'accord tu fais quoi $result et ensuite seulement on va s'occuper de faire l'opération 'or $b' d'accord donc on lui dit entre guillemets que $result ça va être égal à false sauf si par rapport au 'or $b' (la valeur qu'on lui a passé), on a autre chose donc on a pour le coup true parce que si c'est pas false c'est forcé ment true parce que c'est binaire donc c'est l'un ou l'autre ça ne peut pas être autre chose. 

Donc à ce moment-là vous voyez que effectivement le résultat est différent. D'ailleurs c'est assez bizarre parce que vous voyez qu'on n'a pas le même résultat pourtant on n'a rien changé des variables parce que là on lui affecté $a.

En revanche si je modifie et que j'inverse les 2 valeurs :
```php
<?php
$a = true;
$b = false;
$result = $a or $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Là on revient à 1 parce qu'on lui a dit tu affecte directement la valeur de la première variable qui est à droite de l'opérateur d'affectation donc c'est $a donc true et c'est tout. 

Et comme c'est prioritaire, Eh bien le `or $b` va être ignoré d'accord. On ne va pas le faire parce que c'est avant même qu'on affiche, qu'on gère, qu'on interprète cette opération là, il aura affecté à $result la valeur de $a.

Donc attention à comment vous utilisez les 2, si vous voulez absolument que l'ordre n'est pas d'importance en fait, il faut utiliser soit && ou || donc en général on les utilise pratiquement tout le temps pour vous dire la vérité quand vous allez faire des conditions, quand vous allez développer vos sites et cetera. Vous allez pratiquement toujours travailler avec ces opérateurs là parce que vous n'allez pas avoir besoin de gérer un ordre précis dans vos vérifications. D'ailleurs pour ça utiliser tout le temps … d'ailleurs il y a même des gens qui ne savent même pas quen PHP ces opérateurs `and` et `or` qui existe parce qu'ils ont tellement pris l'habitude d'utiliser `&&` et `||` depuis le départ qui ne savent pas qu'il y en a d'autres donc ce n'est pas pour rien, c'est parce que ceux-là ne prennent pas en compte l'ordre.

`and` et `or`  ont une priorité sur tout c'est-à-dire qu'ils affectent le résultat parce qu'ils mettent la priorité sur la première valeur passée $a alors que `&&` et `||` peu importe. Vous avez vu que je peux mettre n'importe quel ordre avec  `&&` et `||` et même en inversant les valeurs on obtient toujours la même valeur.
```php
<?php
$a = true;
$b = false;
$result = $a || $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Et en inversant les valeurs :
```php
<?php
$a = false;
$b = true;
$result = $a || $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
J'obtiens toujours un donc ça montre bien que l'ordre des choses l ordre des valeurs n'a strictement aucune incidence. 

Par contre si j'utilise le mot or.
```php
<?php
$a = false;
$b = true;
$result = $a or $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
```
Là on affiche rien et si j'inverse, comme c'est true en premier, ça va m'afficher 1.
```php
<?php
$a = true;
$b = false;
$result = $a or $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Donc attention vous voyez que je ne tiens pas le même résultat entre les 2 pourtant c'est le même type d'opérateur logique : and et pour représenter le ET, && est pour représenter le ET aussi. or est pour représenter le OU, || est pour représenter le OU aussi. 

Et on a un petit dernier xor donc vous voyez qu'il n'a pas d'équivalent ou autre parce qu'on utilise vraiment que dans des cas comme ça. 

Alors le xor est un ou exclusif c'est à dire que quand vous faites ça $a xor $b, vous dites que $result sera égal à vrai si $a est égal à true ou alors que $b seulement est égal à true mais ce sera également vrai si les 2 le sont (=true) parce que si les 2 sont égal à true, ça veut dire aussi qu'il y en a au moins un des 2 qui l'est. C'est logique, tant mieux quelque part si les 2 le sont vous en avez 2 fois plus. 

Voilà si tu me donnes au moins un bonbon je serai content mais si on vous en donne 2, qu'il vous donne un bonbon de chacun de ses poches, vous serez content et vous n'allez pas vous plaindre. Et bien là c'est exactement pareil, si une des 2 variables est vérifié/validé/égal à true, ça valide le résultat. 

Mais si les 2 sont aussi égale à true, ça va valider si on fait ça.
```php
<?php
$a = true;
$b = true;
$result = $a || $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
En revanche le xor, c'est ce qu'on appelle le ou exclusif c'est à dire que lui il veut absolument qu'il y en ait qu'une seule donc la différence c'est ça.
```php
<?php
$a = true;
$b = false;
$result = $a xor $b;

echo $result;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Si vous avez une qui est égal à true et une autre qui est égale à false donc si on a effectivement un seul des 2 qui est égal à true ça valide parce qu'on lui a dit qu'il lui en faut absolument qu'un seul. Par contre si par chance les 2 sont égales à vrai, le ou exclusif ne marche plus parce qu'on veut exclusivement qu'un seul des membres donc si vous avez 3 variables que vous testez comme ici.
```php
<?php
$a = true;
$b = false;
$c = false;

echo $a xor $b xor $c;
```
Pareil ça veut dire seulement qu'il faudra une seule de ces 3 variables égal à true pour que ce soit valide.
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Donc là c'est valide. 

Il y A partir du moment où j'en ai 2 qui passent à true, qu'elle qu'elle soit, ça ne valide plus.
```php
<?php
$a = true;
$b = false;
$c = false;

echo $a xor $b xor $c;
```
```txt
	\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/008_opérateurs/
	1
```
Ça ne valide plus donc voilà la différence entre le OU normal et le OU exclusif. Le OU normal ça peut être une parmi toutes les variables que vous testez ou toutes si elles sont toutes à vraies, ce n'est pas grave, ça ne gêne pas. C'est par exemple vous testez 5 variables, ça peut être 1, 2, 3, 4 ou les 5 qui sont égal à true pour valider. 

En revanche quand on a le OU exclusif (xor), il n'en faut absolument qu'une solde valide. C'est par exemple elles sont toutes égal à true ou 2, 3, 4 et cetera, ça ne valide plus la condition ou en tout cas l'expression. Attention cet opérateur est assez particulier mais c'est pareil vous aurez très peu besoin de l'utiliser. Vous êtes une grande majorité de personnes qui n'auraient jamais besoin de l'utiliser en programmation. C'est vraiment pour lesquels spécifique mais je voulais quand même vous le présenter parce qu'il faut savoir qu'il existe, et qu'il peut servir dans certain cas.

Voilà pour ces opérateurs logiques. 

Je vais vous laisser avec cette partie, alors je vous dis que la grande majorité de cette vidéo était quand même relativement simple mais sur la fin c'était quand même un petit peu plus compliqué. Ce qui est normal parce que vous continuez d'avancer sur votre formation en PHP donc les choses vont progresser petit à petit en difficulté. 

Retenez surtout les opérateurs d'arithmétiques simples qui sont à retenir.
```php
	/*
		RAPPEL : 	Vrai -> true (1)
					Faux -> false (0)		
		
		Fonctions utiles : intdiv(), fmod()
		
>		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
		Logiques		: and, &&, or, ||, xor
	*/
```
Ça ce sont des raccourcis qui ne sont pas obligatoires parce que vous pouvez très bien passer sans les utiliser mais c'est bien de le savoir parce qu'il permet d'écrire un peu plus vite du code. 
```php
	/*
		RAPPEL : 	Vrai -> true (1)
					Faux -> false (0)		
		
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
>		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
		Logiques		: and, &&, or, ||, xor
	*/
```
La concaténation, ils sont vraiment à connaître parce que cela vous allez être amené à les utiliser très très très souvent en web, dans vos applis web Donc ça c'est vraiment à connaître et je pense que c'est très difficile de s'en passer.
```php
	/*
		RAPPEL : 	Vrai -> true (1)
					Faux -> false (0)		
		
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
>		Concaténation	: ., .=
		Logiques		: and, &&, or, ||, xor
	*/
```
Et pour les symboles logiques, il faut au moins connaître ces deux-là : `&&` et `||`.
```php
	/*
		RAPPEL : 	Vrai -> true (1)
					Faux -> false (0)		
		
		Fonctions utiles : intdiv(), fmod()
		
		Arithmétiques 	: +, -, *, /, %, **
		Affectation		: =, +=, -=, *=, %=
		Concaténation	: ., .=
>		Logiques		: and, &&, or, ||, xor
	*/
```
Voilà ces 2 là c'est le minimum à connaître et si vous n'utilisez jamais ces 3 là : and, or et xor, ce n'est pas grave du tout mais au moins comme ça vous savez que ça existe et que c'est valide et qu'on peut s'en servir également en PHP, et en plus vous serez capable si jamais des gens ne savent pas de la différence, vous vous serez capable d'expliquer la différence entre les 2 à chaque fois c'est-à-dire qu'il y en a un qui gère la priorité c'est-à-dire l'ordre dans lequel l'expression est donnée (or, and) et un autre pas du tout (&&, ||) . 

Les symboles comme ça && et || ne gère pas du tout la priorité, ils s'en foutent ils prennent tout, ils affectent le résultat quel que soit l'ordre de votre expression donc c'est très pratique. 

Voilà je pense vous avoir dit tout. 

Dans les prochaines vidéos, on va continuer d'avancer un petit peu mais on reviendra de toute façon sur les opérateurs comme je vous l'avais dit quand on étudiera les structures de contrôle, on parlera des opérateurs de comparaison. 

Quand on étudiera les tableaux, on aura également des opérateurs précis concernant les tableaux et on aura un cas spécial quand on fera de la programmation objet. Il fait partie des opérateurs en PHP même si c'est un terme assez particulier donc évidemment on le réserve pour ce moment quand on commencera à faire de la programmation objet c'est-à-dire à faire des classes et cetera donc je vous garderai ça sur le code pour cette partie là de la formation. 

J'espère que ça a été clair pour vous, j'ai pris bien le temps de vous expliquer tout ça parce que encore une fois ce sont les premières vidéos, quand on débute en programmation, qui sont les plus importantes parce que c'est ça qui va vous permettre de tout comprendre par la suite donc s'il y a des vidéos à bien comprendre, à bien visionner et à bien revisionner si nécessaire et à vous entraîner à faire des codes et cetera de votre côté ce sont les premières séances. 

Après vous aurez chopé la logique, vous serez plus à l'aise et vous serez plus en confiance dans ce que vous faites donc ça ira beaucoup plus vite et beaucoup mieux. 

Au début ça va être un peu galère pour beaucoup, vous n'allez pas forcément tout comprendre, vous n'allez pas savoir comment écrire votre code, comment démarrer et cetera et c'est tout à fait normal donc prenez confiance en vous, vous n'avez aucune raison de ne pas y arriver comme les autres. 

Ça se passera très bien mais si vraiment vous bloquez sur quelque chose, n'hésitez pas à me poser des questions, à me demander et je viendrais vous aider comme d'habitude. 

Je vous dis à bientôt pour la suite de vidéo en PHP