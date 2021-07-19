/*
SQL #20 - fonctions math‚matiques
06-01-21

Bonjour à tous, on se retrouve pour cette 20ème séance en sql où nous allons voir ensemble quelques fonctions mathématiques ou fonctions numériques qui vont permettre d'effectuer quelques opérations au niveau de vos bases de données.

Petites parenthèses si vous travaillez avec SQLite, vous verrez qu'il y a très très peu de fonctions qui sont disponibles pour ce sgbd donc c'est souvent là des fonctions à faire soi même ou de passer carrément par un langage de programmation pour pouvoir effectuer certains traitements spécifiques.

Comme d'habitude je vous montre un petit peu ce qu'il en est, je vous ai mis dans la description de la vidéo parce que c'est ce que j'ai fait pour chaque séance sur les fonctions une page ici.
	https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-mathematiques.md

Donc un lien vers cette page qui vous redirigera vers les différentes fonctions mathématiques que vous propose ici avec chaque sgbd ça c'est un petit rappel sur chaque page avec toutes les différentes fonctions présenté de la même manière avec ce pour les chaînes de caractères, ce qu'on a vu avec les fonctions d'agrégation et autres sont disponibles comme ça.

Vous avez comme ça le nom de la fonction, la description, éventuellement un usage, ça je ne l'avais pas mis d'ailleurs dans les anciennes séances si vous avez déjà regardé les autres pages des anciennes séance vous n'aviez pas les usages donc c'est quelque chose que je rajoute et que je rajouterais au fur et à mesure pour les autres fichiers que vous ayez tout sous la main.

Par exemple si vous regardez vite fait au niveau mysql on a beaucoup de fonctions disponibles, au niveau d'oracle, on en a un petit peu moins mais on en a quand même pas mal. postgressql est bien fourni en aussi en fonctions, sql server également donc chez microsoft et on voit que chez SQLite on a très peu finalement de fonction comme ça disponibles alors on en a éventuellement d'autres parce que j'ai pas tout il n'y a pas toutes les fonctions qui sont listées sur ce document et donc j'ai mis les plus usuels, celles qui me semblait plus intéressante donc en tout cas les plus importantes. Vous pourrez toujours en trouver encore d'autres mais on va voir un peu tout ça ensemble justement comment qu'est ce qui peut être intéressant à voir.

Alors la fonction qui est disponible partout c'est tout ce qui est calcul de valeur absolue alors je vais me connecter par contre ici et je vais vous montrer directement comme ça à usage.

	serveur
	-------
	> mysqld --console
	
	client
	------
	> mysql -u root -p

Je ne l'ai pas forcément dit mais c'est bien de le rappeler si jamais vous ne savez pas pour oracle, si vous travaillez sur oracle par exemple vous avez certaines fonctions que vous ne pouvez pas utiliser quand vous faites un select avec l'usage d'une fonction. Vous ne pouvez pas juste faire un select et l'appel à une fonction sans spécifier par exemple un nom de tables d'accord il n'est pas possible de faire juste select et la fonction qu'on va avoir par exemple la fonction absolue de -1 d'accord c'est à dire la valeur absolue du nombre -1.

	SELECT ABS(-1)

On ne peut pas faire seulement ça en Oracle, on sera toujours obligés de spécifier une table sur laquelle ça provient.

Pour cela d'ailleurs sur Oracle il existe donc une table qui est  pécialement fait pour ce genre de traitement d'accord si on veut faire une petite requête de cette sorte, il suffit simplement de mettre dual comme ceci.
*/
SELECT ABS(-1) FROM dual;
/*
dual, il suffit simplement d'utiliser cette petite table. C'est une table qui est vide en fait, qui a enregistrement une colonne qui est fait spécialement pour ça comme on a une requête de type select nécessite obligatoirement ce genre de partie au niveau de la requête (from dual), petit rappel en tout cas en petit chose que je voulais dire pour ceux qui travaillerait actuellement sur oracle database. 

Pour les autres vous pourrez tout simplement mettre un select comme ça il n'y aura pas de problème donc on va faire ça genre on va voir très rapidement ce que ça fait.
*/
SELECT ABS(-1);
/*
	mysql> SELECT ABS(-1);
	+---------+
	| ABS(-1) |
	+---------+
	|       1 |
	+---------+
	1 row in set (0.00 sec)

Donc là, il faut en avoir l'utilité d'accord par rapport à des mathématiques alors la valeur absolue d'un nombre c'est pour obtenir sa valeur positive.

Un nombre arithmétique donc si on met un nombre négatif on obtient l'inverse c'est à dire le signe inverse au lieu d'avoir quelque chose de négatif on a une valeur positive.

Si vous faites bien sûr valeur absolue de -5, vous obtenez le nombre 5 donc ça c'est des mathématiques, on est vraiment pour le coup dans des mathématiques donc ça logiquement elles est disponible un peu partout même SQLite dispose de cette fonction-là.

Voilà c'est la même un peu partout.

L'avantage aussi c'est pour tout ce qui est valeur, tout ce qui est fonction mathématique, numérique, on a quand même des noms qui sont assez similaires d'un sgbd à l'autre.

Il n'y a pas trop de différence exceptionnellement là contrairement à d'autres catégories de fonction on a des fois des noms qui diffère assez souvent donc là c'est plutôt pas mal.

On va retrouver également toutes les fonctions trigonométriques donc quelles fonctions pour calculer des cosinus, des sinus, des tangentes ou les arcs, arc tangente, arc cosinus etc etc donc ça peut être très utile et vous savez certainement si vous faites un petit peu de trigonométrie alors ces fonctions là grosso modo c'est cos() et vous mettez une valeur en fait à l'intérieur et vous faites un select, un select cosinus.

	SELECT COS()

et vous pouvez éventuellement passer d'ailleurs pas des valeurs de pi parce qu'on travaille beaucoup en trigonométrie avec pi et pour cela vous avez d'ailleurs une fonction.

	PI()

En l'occurrence tout ce que je montre ici est pour mysql encore une fois vous vous adapter si vous voulez utiliser un autre sgbd et vous avez tout ici disponible sous les yeux.
	https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-mathematiques.md

Et vous allez retrouver de toute façon certaines choses par exemple pour mysql, on a donc la fonction PI() d'accord qui permet de récupérer sa valeur et vous verrez qu'on la retrouve pour d'autres outils donc on ne l'a pas forcément pour oracle ça veut éventuellement dire qu'il faut faire vos propres fonctions.

Pour postgressql, on retrouve également cette fonction PI() disponible avec le même nom donc c'est quand même très très très simple de s'y retrouver.

Alors ce qu'on peut faire par exemple simplement, on peut très bien enchaîner les fonctions ça c'est comme dans la programmation.
*/
SELECT COS(PI());
/*
On peut bien sûr dans un appel de fonction en paramètre passé autre chose par exemple de faire ça et là ça fait cosinus de pi ce qui donne -1.

	mysql> SELECT COS(PI());
	+-----------+
	| COS(PI()) |
	+-----------+
	|        -1 |
	+-----------+
	1 row in set (0.01 sec)

Si vous faites de la trigonométrie, vous avez besoin de travailler avec justement des fonctions pour de la trigonométrie vous pouvez utiliser ces dernière là.

Alors on a COS(), SIN(), TAN() et vous avez après les versions en arc ACOS(), ASIN(), ATAN() en rajoutant simplement un A.
*/
COS(), SIN(), TAN(), ACOS(), ASIN(), ATAN()
SELECT COS(PI());
/*
Pareil toutes ces fonctions trigonométriques ne sont pas forcément disponibles en fonction du sgbd que vous utilisez.

Si vous êtes sur mysql, il n'y aura pas de problème, si vous êtes ailleurs pensez à bien vérifier dans les tableaux que je vous met toujours à disposition, voir si c'est disponible et bien sûr à défaut regardez également dans les documentations officiel du système de gestion que vous vous servez pour avoir un maximum d'informations de ce côté.

Alors je vais très vite là dessus parce que tout ce qui est trigonométrie et cetera, je vais revenir sur des points un peu plus utile pour le coup.

Alors je n'ai pas montré ça comme ça mais c'est bien éventuellement que vous ayez quand même un petit aperçu pour cette fonction là, voyez PI pour montrer en fait le nombre de décimales d'accord.
*/
SELECT PI();
/*
mysql> SELECT PI();
+----------+
| PI()     |
+----------+
| 3.141593 |
+----------+
1 row in set (0.00 sec)

On affiche 6 décimales, on peut éventuellement en rajouter d'autres.

Si je ne mets pas bétise, je pense qu'on passe par un opérateur. On doit pouvoir faire par exemple 2 4 6 8 zéros (+ 0.00000000) je crois qu'en faisant comme ça, on doit pouvoir lui spécifier.
*/
SELECT PI() + 0.00000000;
/*
	mysql> SELECT PI() + 0.00000000;
	+-------------------+
	| PI() + 0.00000000 |
	+-------------------+
	|        3.14159265 |
	+-------------------+
	1 row in set (0.00 sec)

Voyez vous pouvez spécifier en mettant zéro point et un certain nombre de décimales, certain nombre de zéro comme décimales pour spécifier le nombre de décimales pour mysql donc ça ce sont de petites opérations assez simple qu'on peut faire quand on veut par exemple changer la précision qu'on obtient pour la valeur de pi qui est comme vous le savez infini, on n'a pas de valeur de fin en fait de pi.

Quelque chose a connaître aussi qui peut servir encore une fois dans les mathématiques, en trigonométrie et dans d'autres opérations de ce genre.

Autre point qui peut être utile également quand on travaille en trigonométrie, c'est par exemple la conversion des degré en radiant d'accord vous pouvez par exemple avoir un angle en degré et on peut également travailler avec des radiants c'est une autre valeur, unité numérique et ça peut être utile de pouvoir faire des conversions de l'une à l'autre.

Pour ça on a tout simplement la fonction RADIANS() pareil pas forcément disponibles partout ce sera à vous de voir par exemple un angle de 60 degrés d'accord alors combien ça me donne en fait en radiant ?
*/
SELECT RADIANS(60);
/*
	mysql> SELECT RADIANS(60);
	+--------------------+
	| RADIANS(60)        |
	+--------------------+
	| 1.0471975511965976 |
	+--------------------+
	1 row in set (0.00 sec)

Voyez là ça vous donne une valeur ici et vous allez avoir une inverse alors si je met par exemple comme ceci, vous allez obtenir l'inverse.
*/
SELECT DEGREES(1.0471975511965976);
/*
mysql> SELECT DEGREES(1.0471975511965976);
+-----------------------------+
| DEGREES(1.0471975511965976) |
+-----------------------------+
|           59.99999999999999 |
+-----------------------------+
1 row in set (0.00 sec)

D'ailleurs est-ce que je les ai mis sur Github parce que je vais regarder quand même si j'avais bien spécifié ça ? oui qui et elles ne sont pas forcément partout voyé par exemple pour Oracle on n'a pas. On va l'avoir pour postgressql par contre, on a bien les deux oui c'est bon. On a quelques fonctions bien pratiques pour pouvoir effectuer comme ça des conversions donc ça c'est des choses qui sont ma foi très utile.

On a aussi un autre point donc là on quitte un petit peu le côté trigonométrie mais ça ça va être très très utile notamment pour pouvoir faire par exemple des calculs d'arrondis si vous faites par exemple si vous avez un nombre je ne sais pas moi vous avez un arrondi sur pi d'ailleurs on pourrait éventuellement s'en servir mais on verra.

Vous pouvez par exemple faire ceci donc CEIL() qui est un alias de CEILING() en mysql et vous allez faire 14.26334 admettons.
*/
SELECT CEIL(14.26334);
/*
	mysql> SELECT CEIL(14.26334);
	+----------------+
	| CEIL(14.26334) |
	+----------------+
	|             15 |
	+----------------+
	1 row in set (0.00 sec)

Là il vous fait vous voyez un arrondi au dessus d'accord l'entier au dessus c'est 15.

Si vous voulez l'inverse pour avoir un arrondi en fait à la base donc à l'unité, l'entier inférieur, vous allez utiliser FLOOR().
*/
SELECT FLOOR(14.26334);
/*
	mysql> SELECT FLOOR(14.26334);
	+-----------------+
	| FLOOR(14.26334) |
	+-----------------+
	|              14 |
	+-----------------+
	1 row in set (0.00 sec)

Voilà vous utilisez çà et là vous aurez l'entier inférieur donc on va obtenir 14 d'accord si c'est 14 point virgule quelque chose c'est FLOOR() donc on aura 14.

On peut également obtenir un arrondi avec ROUND() alors ROUND() fonctionne de deux manières selon le sgbd aussi soit vous passez directement le nombre en paramètres et ça va vous tronqué en fait en réalité ça vous vous faire un arrondi en prenant simplement la valeur entière.
*/
SELECT ROUND(14.26334);
/*
	mysql> SELECT ROUND(14.26334);
	+-----------------+
	| ROUND(14.26334) |
	+-----------------+
	|              14 |
	+-----------------+
	1 row in set (0.00 sec)

Et vous pouvez également choisir le nombre de décimales à laquele vous voulez arrondir par exemple si je veux arrondir à 3 décimales, je peux faire comme ceci, un deuxième argument à ma fonction.
*/
SELECT ROUND(14.26334, 3);
/*
	mysql> SELECT ROUND(14.26334, 3);
	+--------------------+
	| ROUND(14.26334, 3) |
	+--------------------+
	|             14.263 |
	+--------------------+
	1 row in set (0.00 sec)

Et on aura bien ces 3 décimales là, ça c'est des révisions de mathématique, je ne vous apprends rien, j'apprend rien de nouveau par rapport à ça.

Si on veut en fait arrondir à 3 décimales, si la décimale suivante est en dessous eh bien on garde le nombre le plus proche.
*/
SELECT ROUND(14.26364, 3);
/*
	mysql> SELECT ROUND(14.26364, 3);
	+--------------------+
	| ROUND(14.26364, 3) |
	+--------------------+
	|             14.264 |
	+--------------------+
	1 row in set (0.00 sec)
 
Automatiquement, on a un arrondi qui est autre puisque le nombre en 4e quatrième décimale dépasse 5, c'est 5 ou supérieur.

Voilà un petit arrondi assez utile à utiliser, à servir en tout cas et on peut aussi utiliser TRUNCATE() qui va faire une troncation en l'occurrence le même fonctionnement ici donc on ne fait pas d'arrondi ici, elle va simplement tronquer d'accord.
*/
SELECT TRUNCATE(14.26364, 3);
/*
	mysql> SELECT TRUNCATE(14.26364, 3);
	+-----------------------+
	| TRUNCATE(14.26364, 3) |
	+-----------------------+
	|                14.263 |
	+-----------------------+
	1 row in set (0.00 sec)

Ici évidemment il faut directement le deuxième paramètre, vous choisissez le nombre de décimales que vous voulez d'accord pour faire le pour faire la troncature et on a pas d'arrondi qui est effectué donc on coupe simplement dans les décimales qu'on ne veut pas.
*/
SELECT TRUNCATE(14.26364, 2);
/*
	mysql> SELECT TRUNCATE(14.26364, 2);
	+-----------------------+
	| TRUNCATE(14.26364, 2) |
	+-----------------------+
	|                 14.26 |
	+-----------------------+
	1 row in set (0.00 sec)

Donc pas d'arrondi en dessous ou au dessus, on tronque simplement.

Quelques petites fonctions comme ça qui sont mine de rien très utile.

Voyez donc il y a quand même pas mal à faire au niveau des valeurs absolues, de tout ce qui est trigonométrie, de tout ce qui est arrondi, on a quand même pas mal de fonctions dans ce genre qui peuvent être utile.

Autre point qu'est ce que je peux vous montrer aussi et je vais aller assez vite de toute façon là on est vraiment sur les dernières séances du cours c'est tout simplement vous montrer quelques usages de fonction dont vous avez pas grand chose à apprendre à part savoir que telle fonction existe et que voir comment elle fonctionne, honnêtement c'est pas ça qui sera le plus compliqué à apprendre de tout ce que vous avez pu voir en sql.

Vous avez déjà vu toutes les notions les plus compliqués à apprendre, là on finit vraiment cette formation avec des choses très simples à voir.

On va garder le select, on peut faire le calcul de puissance alors attention selon les versions vous avez pas POW() ou POWER() pour MySQL, vous avez les deux puisque pareil il y a un alias.
*/
SELECT POW(2, 3);
/*
Voilà simplement un calcul de puissance d'accord 2 à la puissance 3 par exemple donc ça va faire 2x2x2 je rappelle donc 8 donc on a bien ce genre de résultat. 
	mysql> SELECT POW(2, 3);
	+-----------+
	| POW(2, 3) |
	+-----------+
	|         8 |
	+-----------+
	1 row in set (0.00 sec)

Pareil je ne sais pas s'ils y en avait d'autres qui avaient des paramètres différents et normalement non, c'est généralement power un peu partout voilà c'est power et il n'y a que MySQL qui propose pow également comme alias.

Enfin c'est power qui est alias de pow enfin peu importe ça ne change pas grand chose.

Vous avez comme ça différentes valeurs.

Qu'est ce que je peux vous montrer également ? 

Alors ça c'est propre à mysql donc je vous montre rapidement parce que vous serez encore en majorité à utiliser MySQL, pour faire de la conversion de base donc là pareil, on ne va pas réviser des bases mais en gros vous avez la base 10 donc les nombres, les chiffres de 0 à 9.

Vous avez la base binaire donc c'est le 0 1.

Vous avez la base octal qui va de 0 à 7 et vous avez la base héxadécimales qui va de 0 à f.

On a différentes valeurs pour ces différentes bases, il peut exister des bases de tout, on peut avoir une base 25, une basse 30 voilà toutes les bases existent en soi parce que c'est en fait un système numérique parce qu'on passe en fait à la dizaine de cette base là.

Au niveau de ces bases, il va peut être intéressant de faire des conversions par exemple on peut se dire de convertir en l'occurrence donc la fonction ici CONV() d'accord on va pouvoir convertir un nombre d'une base à une autre donc on va faire tout simplement.
*/
SELECT CONV(145, 10, 2);
/*
Convertir le nombre 145 par exemple de la base 10 donc ça c'est la base décimale qu'on utilise très très très souvent en mathématiques, un peu partout, vers par exemple une base binaire qui est composé seulement de 0 et de 1.

	mysql> SELECT CONV(145, 10, 2);
	+------------------+
	| CONV(145, 10, 2) |
	+------------------+
	| 10010001         |
	+------------------+
	1 row in set (0.01 sec)

Ca c'est bien pratique pour ça que je vous en parle parce que c'est quand même assez rare qu'on trouve des langages de programmation ou des systèmes de gestion de bases de données avec des fonctions permettant d'effectuer des converse des conversions de base, c'est pas toujours le cas donc c'est plutôt bien de savoir que ça existe et qu'on a ce genre de choses, qu'on obtient une valeur et si vous faisiez l'inverse 10010001 de la base 2 à la base 10, vous tomberez sur la valeur 145 en décimale.
*/
SELECT CONV(10010001, 2, 10);
/*

	mysql> SELECT CONV(10010001, 2, 10);
	+-----------------------+
	| CONV(10010001, 2, 10) |
	+-----------------------+
	| 145                   |
	+-----------------------+
	1 row in set (0.00 sec)

Petite fonction qui est très pratique qui n'est pas disponible pour les autres sgbd très important donc si vous travaillez sur autre chose, vous ne pourrez pas vous servir de ce genre de fonction donc attention par rapport à ça.

On passe à d'autres choses mathématiques donc les deux calculs mathématiques, les deux choses à connaître que vous apprenez généralement d'ailleurs au lycée pour la plupart qui sont l'exponentielle et le logarithme donc pareil très rapidement, exponentielle c'est la fonction EXP() où vous passer la valeur que vous voulez, l'exponentielle par exemple de 2.
*/
SELECT EXP(2);
/*
	mysql> SELECT EXP(2);
	+------------------+
	| EXP(2)           |
	+------------------+
	| 7.38905609893065 |
	+------------------+
	1 row in set (0.00 sec)

D'accord on a la valeur ici et vous avez l'inverse alors là je vais montrer notamment le logarithme népérien donc c'est LN() ici en l'occurrence donc la pareil attention au niveau des nommages des fonctions parce que vous verrez que selon les sgbd vous n'avez pas les mêmes.

Ici je vous les montre rapidement sur le tableau parce que je ne vais pas vous les montrer 1 par 1 au niveau du client mysql mais vous avez en gros pour mysql exceptionnellement ici vous avez donc le logarithme népérien qui s'écrit LOG().

Attention pour d'autres sgbd quand vous utiliser LOG() (Oracle Database) en fait c'est un logarithme en base d'accord vous choisissez en fait la base, logarithme en base 10, logarithme en base 2 et cetera. Et le LN() est exclusivement réservé au logarithme naturel, au logarithme népérien donc il faut faire attention à ça.

	Oracle Database
	---------------
	Logarithme népérien	LN(n)
	Logarithme en base	LOG(base, n)

Egalement parce qu'on a ici LOG() qui est le logarithme népérien et LN() qui est un alias d'accord donc le comportement ne serra pas forcément le même et pour mysql il dispose de 2 fonctions qui permet de travailler directement en base 2 ou en base 10.

	MySQL
	-----
	Alias de log()			LN(n)
	Logarithme népérien		LOG(n)
							LOG(n, base)
	Logarithme en base 2	LOG2(n)
	Logarithme en base 10	LOG10(n)

C'est LOG() qu'on va utiliser en fait si on veut travailler dans une autre base que le 2 et 10, on peut utiliser LOG(n, base) et voyez qu'on peut passer la base en deuxième argument donc attention j'insiste bien là dessus et ne pas vous faire avoir en fait selon le sgbd que vous utilisez parce que vous n'aurez pas forcément les mêmes noms de fonction ici donc il faut faire gaffe à ça.

Ok donc ça c'est bon donc LOG() encore une fois c'est ce que je vous avez dit, vous passer le nombre que vous voulez et la base que vous voulez par exemple en base 10 et là vous avez du coup le logarithme de 2 en base 10.
*/
SELECT LOG(2, 10);
/*
	mysql> SELECT LOG(2, 10);
	+--------------------+
	| LOG(2, 10)         |
	+--------------------+
	| 3.3219280948873626 |
	+--------------------+
	1 row in set (0.00 sec)

Je pense que c'est assez clair par rapport à ça.

On a également les calculs de racines c'est quelque chose qu'on retrouve beaucoup en maths avec SQRT() généralement c'est très souvent ce nom-là que ce soit pour les fonctions dans un sgbd ou des fonctions dans un langage de programmation, vous pouvez par exemple choisir racine carrée de 4 et nous avons ceci.
*/
SELECT SQRT(4);
/*
	mysql> SELECT SQRT(4);
	+---------+
	| SQRT(4) |
	+---------+
	|       2 |
	+---------+
	1 row in set (0.00 sec)

Dans d'autres sgbd, postgressql propose la racine cubique CBRT(), voilà vous mettez simplement CBRT().
*/
SELECT CBRT(4);
/*
Forcément vous n'avez jamais peut-être étudier la racine cubique donc on peut travailler avec ce type de calcul mais là de toute façon ça ne marchera pas.

	mysql> SELECT CBRT(4);
	ERROR 1046 (3D000): No database selected

D'autant là il me dit No database selected et toute manière ça ne fonctionne pas sur mysql c'est pour postgressql.

Voilà donc attention encore une fois tout n'est pas forcément dispo partout.

Au niveau calcul, on n'est pas trop sur un langage de programmation ici mais vous avez le calcul de modulo pour ceux qui ne seraient pas ce que c'est si vous n'avez pas étudié des formations en langage de programmation, on à l'addition, on à la soustraction, la multiplication, la division qu'on présente en programmation respectivement par ces caractères là d'accord.

	-- Fonction : mathématiques et numériques
	
	+ - * / %

On en a un cinquième qui est le modulo représenté par un %.

Le modulo là vous allez donc avoir la division / qui va vous donner le reste d'une division au client d'accord.

Ca c'est intéressant par exemple si vous faites 5 % 2 et le reste en fait de cette division c'est 1 parce qu'on fait 2 fois 2 égal 4 et il reste 1 pour arriver à 5 d'accord c'est le reste en fait qu'on a entier de la division euclidiène.

	-- Fonction : mathématiques et numériques
	
	+ - * / %
	
	5 % 2 = 1

Pour beaucoup de sgbd quand vous voulez calculer le modulo vous avez possibilité d'utiliser cet opérateur pour effectuer ce calcul.

En mysql et dans d'autres sgbd, vous avez aussi une fonction qui est simplement la fonction MOD() et vous choisissez ce que voulait faire donc 5 et 2 en deuxième argument. Je vais vous montrer parce que c'est quand même fait pour ça.
*/
SElECT MOD(5, 2);
/*
	mysql> SElECT MOD(5, 2);
	+-----------+
	| MOD(5, 2) |
	+-----------+
	|         1 |
	+-----------+
	1 row in set (0.01 sec)

Et on obtient bien le reste la division qui est de 1 d'accord.

On peut aussi simplement faire quand comme je vous ai dit 5 % 2 avec peut-être un select sinon il ne le prendra pas en compte.
*/
SELECT 5 % 2;
/*
	mysql> select 5 % 2;
	+-------+
	| 5 % 2 |
	+-------+
	|     1 |
	+-------+
	1 row in set (0.00 sec)

Voilà et on obtient la même chose d'accord, on passe par un opérateur et il propose lui aussi un alias.

Des fois vous avez en mysql des noms de fonction qui ne sont pas en fait des insructions càd que vous n'avez pas d'appel de fonction mais c'est juste un mot qui est généralement le même nom que la fonction et qui fait la même opération.

Vous mettez 5 MOD 2, voyez qu'il n'y a pas de parenthèses ou quoi que ce soit, voyez on ne fait pas un appel à une fonction et là logiquement ça devrait donner la même chose voilà.
*/
SELECT 5 MOD 2;
/*
	mysql> SELECT 5 MOD 2;
	+---------+
	| 5 MOD 2 |
	+---------+
	|       1 |
	+---------+
	1 row in set (0.00 sec)

On a trois syntaxes différentes en mysql pour calculer un modulo, dans d'autres sgbd, vous n'avez pas ces trois là, vous avez généralement celui là "%", l'opérateur fonctionne normalement sur tous je crois et vous avez une fonction comme ça MOD() qui prend la première valeur à passer et la deuxième et qui fera donc la division de ces deux là et vous donnera le reste de la division euclidienne.

Quelque chose à connaître aussi et à savoir voilà à connaître par rapport à toutes ces informations ici.

Alors je passe très vite, on a aussi des fonctions par exemple pour récupérer le signe d'un nombre si c'est + ou - donc si vous mettez 0 ça vous renverra 0, si c'est un nombre négatif ça vous renverra -1 et si c'est un nombre positif ça vous renverra la valeur de 1. 

Des choses pareil très très simple.

Et je voulais terminer avec tout ce qui aléatoire mais est-ce que je ne voulais pas vous montrer autre chose avant ? Normalement non a vu la trigonométrie, les arrondis, les calculs racine carré cubique, les logarithme, exponentielle, on a fait le tour de tout donc je vais pour terminer vous montrer surtout en fin de vidéo.

Donc concernant mysql encore une fois il faudra voir parce que ce n'est pas disponible pour tous, vous avez notamment ce genre de fonction RAND() comme je l'ai indiqué ici ça va vous donner la valeur aléatoire à virgule flottante d'un nombre d'accords.

C'est une simple fonction à utiliser telle quelle.

On va montrer tout simplement en faisant comme ceci.
*/
SELECT RAND();
/*
Et vous allez obtenir un nombre entre 0 et 1 donc même entre 0.0 et 1.0 pour être plus exact.

	mysql> SELECT RAND();
	+--------------------+
	| RAND()             |
	+--------------------+
	| 0.8866642135071235 |
	+--------------------+
	1 row in set (0.00 sec)

voilà et si je refais ça, voyez que ça change.

	mysql> SELECT RAND();
	+-----------------------+
	| RAND()                |
	+-----------------------+
	| 0.0026330631250823505 |
	+-----------------------+
	1 row in set (0.00 sec)

On peut éventuellement spécifier une graine pour la génération de ce nombre aléatoire et pareil voilà.
*/
SELECT RAND(15);
/*
	mysql> SELECT RAND(15);
	+--------------------+
	| RAND(15)           |
	+--------------------+
	| 0.9079670691005579 |
	+--------------------+
	1 row in set (0.00 sec)

Et là comme on a la même graine, voyez qu'on garde le même nombre.

Il faut faire un cours sur tout ce qui est nombre pseudo aléatoire etc et je l'ai expliqué dans pas mal d'autres formations de toute manière donc vous l'apprendrez à un moment ou un autre si vous l'étudiez sur d'autres formations.

Dans tous les cas on peut obtenir comme ça des nombres aléatoires.

Petite distinction ici comme je peux vous le montrer ici au niveau exécution que je vais vous montrer depuis le document là.

Vous avez par exemple ici un arrondi, un nombre entier voilà qui
va être donné avec la fonction RANDOM() pour SQLite d'accord c'est un nom qui sera positif au négatif donc attention le comportement produits par la fonction ne sera pas le même.

Attention un petit peu avec les valeurs aléatoire alors c'est pareil petite information même si ce sont des fonctions pour générer un nombre aléatoire vous pouvez également vous en servir dans le cadre d'une requête, par exemple vous voulez effectué une requête pour sélectionner des enregistrements et après vous pouvez établir un ordre enfin faut avoir un intérêt pour le faire mais vous pourriez par exemple vouloir un ordre aléatoire d'affichage ou de récupération de vos résultats de requêtes. Vous pouvez utiliser cette fonction pour le faire.

Hé bien vous faites un ORDER BY avec votre fonction RAND() comme ça alors l'ordre sera complètement aléatoire.

Ca peut éventuellement, si on peut trouver une utilité à ce genre d'usage, imaginez par exemple une galerie d'image que vous avez par exemple sur votre site web donc là en passant par un langage de programmation orienté web vous faites une requête depuis ce langage sql et dans votre requête, dans votre clause partie ORDER BY vous utilisez votre fonction RAND() et comme ça si si vous avez des liens enregistré en base de données pour afficher des images d'une galerie seront récupérés aléatoirement ça permettra d'afficher une galerie de manière en fait aléatoire au niveau de l'ordre d'affichage des images sur votre page web.

Voilà ça peut être un usage comme un autre donc ça c'est à vous de voir évidemment à l'usage et par rapport à ce que vous ferez sur vos projets.

Cette petite parenthèse étant faite je crois qu'on a fait le tour de ce que je voulais vous montrer donc encore une fois rien de compliqué vous voyez c'est simplement des fonctions il faut les connaître un minimum en tout cas les plus importants.

Après de toute façon avec les documentations et avec ce que je vous mets à chaque fois dans les descriptions de vidéo vous avez besoin de vous rappeler de certaines d'entre elles, vous aurez toutes les informations à disposition.

Encore une fois je rappelle parce que c'est important n'hésitez pas à prendre des notes.

Ca il faut bien y penser prendre des notes sur un cahier, sur un classeur, dans un fichier sur votre ordinateur. Vraiment pas hésiter à avoir tout comme ça de côté et moi souvent j'en profite pour faire un petit rappel si vous voulez savoir un petit peu comment vous organiser parce que j'ai des fois des gens qui me demande. Moi je vous conseille c'est de faire un support papier voilà je vous recommanderais plutôt le format papier parce qu'on retient et on assimile plus facilement les choses quand on écrit de sa propre main en fait que depuis un cahier étonnamment donc préféré ça et gardez vous en faites un grand cahier, un classeur où on peut facilement du coup mettre des pochettes n'importe quoi pour pouvoir mettre votre cours en fait, vos notes de cours càd que tout est bien mis au propre avec toutes les explications maximum que vous voulez mettre bien détaillés et après n'hésitez pas à avoir des brouillons ou d'autres cahiers pour gribouiller, pour faire des schémas.

Par exemple vous n'avez pas compris quelque chose, si vous êtes sur sql et vous n'avez pas compris les jointures et bien vous n'avez pas noté toutes vos recherches on va dire là dessus sur votre cahier ou votre classeur de cours d'accord vos notes de cours mais vous allez le faire sur un brouillon, sur un truc à côté pour pouvoir faire tout un tas de schémas, pour essayer de bien assimiler tout ça.

Une fois que vous avez compris pour bien que ça rentre justement dans votre tête et pour que ça reste eh bien vous pourrez le noter dans votre classeur.

Voilà en fait partez du principe que vous alliez finalement enseigner à quelqu'un d'autre aussi et vous verrez comme ça que vous retiendrez bien plus bien plus facilement les choses parce que vous serez obligés de les expliquer en fait, d'expliquer ce que vous avez appris et vous saurez très très vite si vous avez compris, si vous avez acquis finalement ces choses là parce que si vous n'êtes pas capables de l'enseigner, de l'expliquer c'est que finalement vous n'avez pas bien compris comment ça fonctionnait.

Donc n'hésitez pas à essayer ces petites astuces là qui permettront de bien assimiler, de bien apprendre et surtout pouvoir garder ces connaissances et cetera et pas tout oublier à chaque fois ou se mélanger un peu les pinceaux en fonction de ce que vous apprenez.

Voilà je vous dis à bientôt en tout cas pour la prochaine vidéo ce sera la dernière séance avant la conclusion d'accords on verra tout ce qui est lié à la sécurité au niveau de nos bases de données et on en aura terminé avec cette formation.

Je ferais une petite vidéo de conclusion comme je fais à chaque fin de formation sur la chaîne et vous aurez fait grandement le tours de pas mal de choses en sql.

Je vous dis à bientôt pour la prochaine séance sur les fonctions de chiffrement.

A bientôt tout le monde.
*/
