# [10. Boucles](https://www.youtube.com/watch?v=jfkq2iXGWcY)

Bonjour, bienvenue sur cette séance 10 en PHP.

On continue avec les structures de contrôle.

La dernière fois on avait vu sur une vidéo assez longue, les conditions, et là nous allons pouvoir aborder les boucles. 

Alors le ebook c'est un concept qui est très très simple à comprendre, très simple à mettre en place, et qui va vous servir tout au long tout au long dans tous les langages de programmation que vous allez pouvoir éventuellement pouvoir étudier et utilisé donc je vais vous expliquer cela au mieux avec quelques petits exemples simples et ça devrait suffire en tout cas pour cette séance. 

Alors la première boucle c'est le principal, c'est la boucle while et vous allez voir que son fonctionnement est très logique c'est-à-dire que vous allez simplement utiliser le mot clé while et ouvrir les parenthèses et à l'intérieur nous allons effectuer une condition tout simplement on va réaliser un test.
```php
while()
```
À l'intérieur nous allons effectuer une condition tout simplement nous allons réaliser un test mais nous on peut faire sur un nombre et on va faire `$number=0`. Il atteste que nous allons réaliser c'est ce que `$number` est plus petit que 10 d'accord.
```php
	$number =0;
	
	while($number=0)
```
Si c'est le cas nous allons rentrer dans la boucle donc nous allons réaliser ce qu'on appelle une itération. À chaque fois que nous avons du code dans une boucle, nous appelons ça une itération.
```php
	$number =0;
	
	while($number=0)
	{
		
	}
```
En revanche la différence ici c'est qu'au lieu d'un simple IF où on va exécuter le contenu de la structure qu'une seule fois donc le cas où on validerait une condition. Et bien ici on va pouvoir le répéter plusieurs fois d'où le terme de boucle.  

Ça va boucler, ça va répéter les instructions, ça va tellement parcourir plusieurs fois les itérations d'une simple boucle donc dans ce cas-là si je fais par exemple un echo de `$number`.
```php
	$number =0;
	
	while($number=0)
	{
		echo $number;
	}
```
Avec juste une petite balise html (ajouter ?>). Encore une fois, vous n'êtes pas obliger de connaître le HTML pour suivre cette formation ce n'est vraiment pas obligatoire.
```php
	$number =0;
	
	while($number < 10)
	{
		echo '<p>'.$number.'</p>';
	}
```
Voilà si je m'amusais à faire ça, qu'est-ce que ça veut dire ? Ça veut dire qu'on a `$number` qui est déclaré et initialisé à 0 d'accord. On fait une boucle sur le fait que la validation de `$number` est-elle inférieure à 10 ? et c'est le cas, dans ce cas là on va faire le echo de `$number` dans un paragraphe en HTML.

Une fois qu'on a terminé la, qu'on arrive ici `}`, on revient au début de la boucle donc on revient sur le test et on revérifie la condition. Est-ce que `$number` est toujours inférieur à 10 ? ici c'est le cas parce qu'il n'a toujours pas changé il est toujours égal à 0 donc on va faire ce qu'on appelle la 2e itération donc ce qu'il y a à l'intérieur de la boucle donc on va refaire un echo de `$number`. On termine `}` et on revient au départ, et on re vérifie la condition. est-ce que c'est toujours 0 inférieur à 10 ? la réponse est oui, 3e itération, ainsi de suite. 

Là vous comprenez que dans cet exemple, on aurait une boucle infinie qui ne s'arrêterait jamais et d'ailleurs si vous essayer de l'exécuter en PHP, vous obtiendrez un message du genre Max Limit Exheded donc en bref que l'exécution du script a dépassé le temps limite qui était autorisé par PHP, ça ne fonctionnerait pas et ça finirait par planter.

Donc il nous faut dans le cadre d'une boucle toujours ce qu'on appelle un point d'arrêt c'est à dire un moment où on va pouvoir sortir de cette boucle. 

Il va falloir créer un point d'arrêt pour qu'en arrivant une nouvelle fois sur le début de la boucle, cette condition `$number`<10, à un moment donné, ne sois plus vrai, qu'elles devienne fausse donc le meilleur moyen de le faire quand on a une boucle comme ça avec un simple test sur un nombre donc une inégalité, et bien c'est incrémenter la variable en question, de l'augmenter par exemple de 1 à chaque fois.
```php
<?php

$number =0;

while($number < 10)
{
	echo '<p>'.$number.'</p>';
	$number++;
}
```
Et là je peux tester le code, on va actualiser.
```txt
	http://localhost/PHP/cours/010_boucles/
	0

	1

	2

	3

	4

	5

	6

	7

	8

	9
```
Et voilà ce que ça nous donne d'accord donc en toute logique qu'est-ce qui s'est passé ? Eh bien `$number`, au départ, est égal à 0. Il est bien inférieur à 10 donc on affiche `$number` et on incrémente de 1 donc `$number` devient égal à 1. Est-ce que 1 est inférieur à 10 ? oui toujours donc on refait une 2e itération. On incrémente `$number` qui est égal à 2. Est-ce que 2 est inférieur à 10 ? oui, et cetera d'accord mais il y a un moment donné où `$number` sera égal à 10 donc à partir du moment où `$number` va être égale à 10, cette inégalité ne sera plus vrai donc on ne va plus faire une nouvelle itération et on va continuer la suite du programme ici.

	$number =0;

	while($number < 10)
	{
		echo '<p>'.$number.'</p>';
		$number++;
	}
	<--

Voilà on continuera l'exécution.

On a bien établi un point d'arrêt.

Le point d'arrêt dans ce programme là en tout cas ce bout de code, le point d'arrêt c'est lorsque `$number` sera égal ou supérieur à 10 mais déjà quand il va être égal ça va s'arrêter de toute façon donc il n'y aura même pas besoin d'attendre qu'il soit supérieur. La boucle s'arrêtera quand il serra égale à 10.

Donc voilà une possibilité très très simple par rapport à ça au niveau des boucles, vous établissez une condition à vérifier qui va réaliser le traitement un certain nombre de fois et vous prévoyez un point d'arrêt c'est à dire un cas où un moment donné la vérification de la boucle ne sera plus vrai sinon vous allez avoir une boucle infinie, ce qui risquerait de poser de problème. 

Alors la boucle infinie, on en entend souvent parler dans certains programmes précis et notamment dans le jeu vidéo, on s'en sert beaucoup quand on veut par exemple … je vais vous montrer très rapidement et on va faire par exemple un booléen. C'est un exemple que je prends assez souvent d'ailleurs ignorer ce genre de choses-là pour dire que tant que le jeu est lancé `while($jeu_lance)`, tu vas attendre les actions de l'utilisateur c'est-à-dire que est-ce que dans le menu il va lancer une partie ? est-ce qu'il va charger une partie existante ? est-ce qu'il va vouloir quitter ou autre ? donc où va se faire le point d'arrêt ? il va se faire dans la possibilité de joueur de pouvoir accéder à un endroit du menu qui va, quand il va par exemple demander à quitter le jeu, passer notre booléen à false.
```php
	$jeu_lance = true;
	
	while($jeu_lance)
	{
		$jeu_lance = false;
	}
```
Et du coup ici on aura notre fameux point d'arrêt qui ressortira de cette boucle infinie mais ça ce n'est pas gênant parce qu'on ne va pas forcément dire d'afficher plusieurs textes comme ça à la suite, plusieurs fois. Ce qu'on va faire par exemple dans la boucle infinie, c'est lui demander par exemple d'afficher le menu du jeu et le menu du jeu comme c'est de l'image : afficher une image à l'infini, en fait ça va tout simplement garder l'image affichée à l'écran. 

Parce que si on demandais d'afficher une image une seule fois, elle s'afficherait instantanément et elle disparaîtrait donc vous n'aurez même pas le temps de le faire. 

D'ailleurs voilà, les logiciels que vous utilisez, regardez vos logiciels, votre éditeur, votre navigateur web et tout ça tournent en fait sur des boucle infinie d'accord. 

Ils tournent sur des boucle infinie jusqu à ce que vous rencontriez un point d'arrêt. 

Le point d'arrêt par exemple ici de mon éditeur, et bien ce serait de le fermer avec la petite croix ou bien d'aller dans le fichier et de faire quitter ou de faire Alt+F4 bref n'importe quel autre commande que ce soit un raccourci clavier ou une commande du logique en question pour quitter l'interface. Et dans ce cas-là ce serait un point d'arrêt qui fermerait la boucle donc fermerait le programme d'accord donc ça c'est à savoir. 

Alors ça c'est le premier cas, le plus simple à savoir, en tout cas pour la boucle while. 

Alors vous avez vu que le test et toujours fait au début de la boucle avant même de commencer ne serait-ce qu'une première itération c'est-à-dire que si dès le départ … je vais vous montrer avec l'exemple de tout à l'heure. Si dés le départ, c'est égal ou supérieur à 10 parce qu'ici vous voyez que est-ce que 10 est égal ou supérieur à 10 ? Non parce que si j'ai ça dés le départ, jamais on exécutera d'itération donc jamais on ne rentrera dans la boucle dans ce genre de cas-là donc c'est tout à fait possible.
```php
	$number =10;

	while($number < 10)
	{
		echo '<p>'.$number.'</p>';
		$number++;
	}
```
Si vous voulez au moins exécuter au minimum une seule fois votre itération, avant de faire le test, vous pouvez inverser c'est-à-dire que au lieu d'écrire sur cette forme là que je vais commenter du coup pour que vous voyez la différence on va utiliser `/ * * /` pour y mettre le code. Vous allez devoir l'écrire à l'envers donc on va utiliser un 'do' pour dire tu fais 'faire' un certain nombre de choses donc faire quoi, faire ce qu'on avait mis là. Voilà je peux copier coller ça fonctionnera.
```php
	$number =10;
	
	do
	{
		echo '<p>'.$number.'</p>';
		$number++;
	}
	
	/*
	while($number < 10)
	{
		echo '<p>'.$number.'</p>';
		$number++;
	}
	*/
```
Tant que donc il faut prendre le while() ce qui signifie que d'abord tu fais les instructions et ensuite tu fait le test. Et un `do while`, attention petite particularité termine avec un ;
```php
<?php

$number =10;

do
{
	echo '<p>'.$number.'</p>';
	$number++;
}
while($number < 10);

/*
while($number < 10)
{
	echo '<p>'.$number.'</p>';
	$number++;
}
*/
```
J'insiste bien là dessus parce qu'il y a pas mal de gens qui l'oublie en général donc pour un `do while`, il y a toujours un ; à la fin du `while` alors que sinon il n'y en a pas pour le `while` simple. 

Alors ça veut dire que tu vas d'abord faire les instructions et ensuite tu vas faire le test `while` et si ce test est valide tu vas refaire les instructions et du coup une nouvelle itération, et à nouveau on va tourner autant de fois qu'il faut dans la boucle. Autant d'itérations jusqu à rencontrer un point d'arrêt qui va invalider cette condition `$number`<10 et du coup nous faire sortir de la boucle. 

Donc là la différence par rapport à la boucle simple c'est qu'on va au moins afficher une seule fois la valeur voyez même si c'était inférieur à 10 et comme le test ne se fait que après, il va au moins une fois affiché et là effectivement com 10 n'est pas inférieur à 10, il va s'arrêter et ne pas exécuter d'autres itérations de cette boucle voilà.
```txt
	http://localhost/PHP/cours/010_boucles/
	10
```
Donc ça c'est un cas c'est une alternative à la boucle while, le do while qui permet d'exécuter au moins une seule fois l'itération de la boucle avant d'effectuer le test. 

Dans certains cas vous verrez quand vous serez sur des programmes beaucoup plus complexe, ça pourrait être utile de le faire pour exécuter au moins une fois avant de faire le test, dans certains cas ça peut se montrer très utile. 

La boucle c'est souvent le petit problème, enfin ce qui dérange pas mal les débutants en informatique, en programmation de manière générale parce que si vous avez déjà programmé dans un autre langage, vous connaissez le principe de la boucle donc logiquement tout ce que je vous explique là vous le savez déjà. 

On imagine souvent de boucler pour afficher répéter un affichage de texte par exemple on peut faire par exemple ceci. Attention à ne pas oublier le point d'arrêt c'est à dire de incrémenter sinon vous allez voir que ça tourne en boucle dans l'actualisation de la page.
```php
<?php

$number =0;

while($number < 10)
{
	echo "ok<br>";
	$number++;
}
```
```txt
	http://localhost/PHP/cours/010_boucles/
	ok
	ok
	ok
	ok
	ok
	ok
	ok
	ok
	ok
	ok
```
Voilà souvent les gens pensent que l'utilité de la boucle c'est juste ça en fait que c'est juste d'afficher la même chose parce que c'est ça qu'on pourrait se dire parce que comme on exécute plusieurs itérations en même temps, à priori le code nos instructions dans la boucle feraient les mêmes choses tout le temps mais pas forcément. Il ne faut pas le voir comme un simple affichage répétitif comme ici ou on va dire par exemple tu vas copier 500 fois la même phrase d'accord on pourrait faire une punition comme ça "je ne dois pas machin ….", ce n'est pas comme ça que ça fonctionne en tout cas ce n'est pas l'intérêt que ça a.

Il faut le voir comme une suite d'instructions qui peut être elle-même répétées mais cette suite d'instruction peut être n'importe quoi, ça peut être effectivement un affichage comme je l'ai fait là mais ça peut être aussi l'accès à un ensemble de données. 

Plus tard vous allez pouvoir manipuler des tableaux par exemple et la boucle permettra de parcourir toutes les valeurs du tableau. Ça peut être également utile lorsqu'on le verra plus tard avec les fichiers, le fait par exemple de parcourir chaque ligne d'un fichier donc on dira tout simplement "tant qu'il y a des lignes du fichier à lire, Eh bien tu lis chaque ligne de ce fichier d'accord donc on ne fera pas la même chose puisque chaque ligne est différentes donc même si on lui dit affiche la ligne que tu es entrain de lire, et comme cette ligne ne sera pas la même et bien évidemment on affichera des choses différentes".

Donc il faut vraiment le voir comme ça, la boucle va pas mal servir pour faire du parcours de données, beaucoup c'est à dire qu'elle va parcourir des choses, parcourir un flux, parcourir un fichier parce que c'est un flux. On peut parcourir un tableau donc une collection ou une structure de données, ce genre de chose et c'est là tout l'intérêt de la boucle, ça va vous servir dans 99% des cas pour ce genre de chose donc on reverra tout ça par la suite sur cette formation avec pas mal de nouvelles séances qui vont arriver prochainement. 

Voilà pour cette petite chose que je voulais vous montrer. 

Une fois qu'on a vu cela donc le `while` et le `do while`, nous avons une 3e boucle qui sert à priori très souvent que pour le parcours donc je vais aller très vite dessus parce qu'on aura l'occasion de revenir dessus dans les vidéos prochaine où elle sera beaucoup plus utile c'est la boucle `for`. 

La boucle for va fonctionner sur un schéma assez particulier. 

Regardez je ne suis même pas obligé de créer de variables au début. On va reprendre les conditions qu'on avait tout à l'heure dans notre exemple.
```php
	for()
	{
		echo "Je suis une phrase...";
	}
```
Elle va prendre 3 choses.
```php
	for(1;2;3)
	{
		echo "Je suis une phrase...";
	}
```
Une première une 2e et une 3e qu'on va séparer dans l'idéal par des points-virgules avec 3 cas particuliers, 3 expressions. 

Est la première expression de la boucle, elle va être exécutée au début de celle-ci c'est à dire que peu importe ce qu'il se passe, peu importe que la condition est vérifiée ou autre, soit vrai ou soit fausse peu importe, l'expression qui va être mise ici sera fait dans tous les cas donc là chose qui peut être faites, vous en avez plusieurs et vous pouvez très bien vous amuser à faire une variable `$i=-1` et on peut décider que `$i=0` en tant que premier argument de ma boucle.
```php
	$1 = -1;
	
	for($i = 0 ; 2 ; 3)
	{
		echo "Je suis une phrase...";
	}
```
Et comme en PHP vous êtes pas obligé surtout pour la boucle ici `for` de déclarer votre variable, vous pouvez ainsi la déclarer directement en premier argument donc notre première ligne avant est carrément inutile.
```php
	for($i = 0 ; 2 ; 3)
	{
		echo "Je suis une phrase...";
	}
```
C'est à dire que là qu'est-ce qu'on dit ? en début de boucle peu importe ce qu'il arrive, tu crée une variable `$i` et tu l'initialise à 0 donc le fameux `for($i=0…` ça c'est la première partie de la boucle. 

Dans la 2e partie, la 2e expression, c'est la chose qui va être évalué c'est-à-dire tout simplement exécuter au début de chaque itération d'accord. Qu'est-ce qu'il va être fait au début de chaque itération ? alors si on compare avec la boucle d'avant … je vous montre l'équivalent avec la boucle while par rapport à la boucle for qu'on a ici.
```php
	/*
		$i = 0;
		
		while($i < 10)
		{
			echo "Je suis une phrase...";
			$i++;
		}
	*/
	
	for($i = 0 ; 2 ; 3)
	{
		echo "Je suis une phrase...";
	}
```
Alors le nom i que j'ai mis ici est volontaire quand en général on fait une variable qui doit être en général incrémentée. C'est ce qu'on appelle un compteur dans une boucle, on l'appelle i. Si on doit en faire une 2e on l'appelle j, k, l et cetera. C'est ce qu'on fait en général parce que c'est une convention. 

Tout le monde a pris l'habitude en informatique et dans d'autres langages également, et pas seulement en PHP d'appeler des variables qui vont servir de itérateur donc de compteur pour rester simple pour le moment, on ne va pas rentrer dans des termes trop compliqués, on les appelle comme ça i, j, k … avec des noms très simples. Il n'y a pas besoin que ça porte des noms très explicites pour le coup donc il faut comprendre que c'est un conteur. 

Alors ce code là que vous voyez ici, on va le traduire pour le coup en boucle for.
```php
	/*
		$i = 0;
		
		while($i < 10)
		{
			echo "Je suis une phrase...";
			$i++;
		}
	*/
```
Alors cette partie là que vous voyez `$i = 0;` elle sera exécutée dans tous les cas. Vous voyez qu'elle est en dehors de la boucle, en dehors de son test donc elle n'a absolument rien à voir donc ça on veut que ce soit fait tout le temps donc c'est l'intérêt de la boucle for voyez qu'on le met ici.
```php
	for($i = 0..
```
En 2e expression, c'est ce qui va se faire en début de boucle c'est à dire ce qui va être évalué en début de boucle en tout cas avant chaque itération donc c'est le fameux test à vérifier.
```php
	$i < 10
```
Donc c'est le temps que $i soit plus petit que 10 donc on peut le mettre ici.
```php
	/*
		$i = 0;
		
		while($i < 10)
		{
			echo "Je suis une phrase...";
			$i++;
		}
	*/
	
	for($i = 0 ; $i < 10 ; 3)
	{
		echo "Je suis une phrase...";
	}
```
Et la 3e expression c'est ce qui va être exécuté à la fin de chaque itération, et vous voyez qu à la fin de chaque itération (voir while) on incrémente la variable pour être sûr qu'on obtienne un point d'arrêt, pour qu'on puisse sortir de cette boucle et donc cette fameuse partie là vous pouvez la mettre ici.
```php
	/*
		$i = 0;
		
		while($i < 10)
		{
			echo "Je suis une phrase...";
			$i++;
		}
	*/
	
	for($i = 0 ; $i < 10 ; $i++)
	{
		echo "Je suis une phrase...";
	}
```
Voilà expression 1 qui va être fait en début de boucle dans tous les cas, la 2e expression c'est ce qui va être évalué au début de l'itération et en 3e expression, ce qui va être fait à la fin de l'itération voilà donc c'est important. 

Dans certains cas vous pourrez retrouver genre ceci.
```php
	for($i = 0 ; ; $i++)
```	
C'est-à-dire qu'on peut laisser vide et qu'il n'y aura pas de 2e expression c'est tout à fait possible de faire ça, ça veut dire que enfaite, on commence par initialiser `$i` à 0 et on incrémente `$i` de 1 à chaque fois mais par contre on ne fait pas de test en priorité. 

Alors il y a des cas particulier ou ça peut servir, ce sont des codes un peu plus avancés mais si un jour vous rencontrez une boucle for qui a été écrite comme ça.
```php
	for($i = 0 ;; $i++)
```
Écrite comme ça avec 2 ; qui se suivent, ce n'est pas que la personne a oublié d'écrire la 2e expression, c'est juste que la omise tout simplement d'accord c'est tout à fait possible de procéder comme ça même si dans la majeure partie des cas et de manière standard vous allez voir les 3 expressions à chaque fois. 

Donc ça ce code ici.
```php
	/*
		$i = 0;
		
		while($i < 10)
		{
			echo "Je suis une phrase...";
			$i++;
		}
	*/
	
	for($i = 0 ; $i < 10 ; $i++)
	{
		echo "Je suis une phrase...";
	}
```
D'ailleurs je ne suis même pas obligé de mettre les accolades ici parce qu'il n'y a qu'une seule instruction.
```php
<?php

for($i = 0 ; $i < 10 ; $i++)
	echo "Je suis une phrase...<br>";
```
```txt
	http://localhost/PHP/cours/010_boucles/
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
```
Alors ce code là est exactement équivalent à celui là.
```php
<?php

$i = 0;

while($i < 10)
{
	echo "Je suis une phrase...<br>";
	$i++;
}
```
```txt
	http://localhost/PHP/cours/010_boucles/
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	// Je suis une phrase...
```
Mais évidemment for est beaucoup plus court et beaucoup plus petit et dans certains cas il sera beaucoup plus pratique.

D'accord on peut ainsi répéter les choses très simplement, et si je met 15 ça va se répéter en fonction de la vérification que je mets là. 
```php
<?php

$i = 0;

while($i < 15)
{
	echo "Je suis une phrase...<br>";
	$i++;
}
```
```txt
	http://localhost/PHP/cours/010_boucles/
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
	Je suis une phrase...
```
Ça fonctionne comme ça donc ça c'est pareil c'est le genre de bouc qu'on va beaucoup utiliser pour faire du parcours de données mais pas forcément comme là afficher par exemple un simple texte plusieurs fois comme ça à la suite, ça n'a pas vraiment d'intérêt mais vous verrez plus tard que ça sert beaucoup pour du parcours c'est-à-dire que au lieu de travailler simplement ici, on parcourra les indices d'un tableau ou alors on parcourra la suite comme ça d'une structure ou les lignes affichées … ce seront des choses qui seront tout à fait intéressantes. 

Donc il fallait vous la montrer même si on aura l'occasion de revenir dessus donc je ne vais pas trop m'attarder. 

On verra également une autre boucle qui est le `foreach`. 

Le `foreach` c'est une boucle qui est vraiment prévu pour les tableaux donc nous comment on va faire une vidéo sur les tableaux, je la réserve pour ce moment-là donc sachez qu'il existe une boucle qui s'appelle foreach qui veut simplement dire pour chaque, par exemple pour chaque ligne d'afficher, pour chaque case, chaque élément d'un tableau, pour chaque … voilà quelque chose de quelque chose. 

On pourra du coup afficher où travailler avec les données donc c'est une boucle qui existe et on reviendra dessus là je vous ais juste donner son nom pour que vous sachiez que ça existe mais on va revenir dans le détail là-dessus sur la suite. 

Je terminerai cette vidéo pour un petit plus mais ce sont des choses à connaître au niveau des boucles elle-même, au niveau des conditions sur l'usage de certaines instructions. On avait vu dernièrement l'instruction break si vous vous souvenez avec la structure en switch pour ceux qui se souviennent qu'on faisait par exemple ceci.
```php
	$choice = 1;
	
	switch($choice)
	{
		case 1:
			eco "1";
			break;
		
		default:
			break;
	}
```	
Voilà je vous avais dit pour les cas il faut mettre un break à la fin pour sortir, interrompre le switch et pour éviter qu'il exécute tous les cas de figure du switch.

Donc ça c'était le premier, la première instruction à connaître d'accord le break qui dit d'interrompre une partie d'ailleurs ce que je ne vous ai pas dit dans la dernière vidéo, c'est que break peut éventuellement prendre un nombre entier d'accord en entier comme argument c'est à dire que quand vous écrivez break comme ça tout court ça revient en réalité à écrire break de 1.
```php
	$choice = 1;
	
	switch($choice)
	{
		case 1:
			eco "1";
			break;//break 1 OU break(1)
		
		default:
			break;
	}
```
Ou alors vous pouvez l'écrire comme ça aussi `break(1)` mais on voit très rarement ce format, on le voit plus souvent écrit comme ça `break`.

Break est comme une instruction, c'est comme pour echo, c'est comme pour print, vous pouvez noter le nom de l'instruction suivie d'un espace et l'entier `break 1` ou alors vous mettez l'instruction et entre parenthèses l'entier, son argument, `break(1)`.

Donc l'un ou l'autre mais souvent la syntaxe que l'on retrouve c'est beaucoup celle-là `break 1` donc si vous voulez mettre `break 1` donc par défaut c'est ce qu'il y a quand on note juste `break`.

Donc qu'est-ce que ça veut dire ? ça veut dire d'interrompre la structure courante quand on met 1 c'est-à-dire qu'on interrompt qu'une seule structure donc là comme on est dans un switch, on interrompt que celle là.

Admettons que vous auriez une structure dans une structure dans une structure, vous pourriez dire d'interrompre plusieurs structures imbriqués genre de mettre un `break 2` qui dirait en gros d'interrompre la structure dans lequel tu te trouves donc ici ce serait le switch et si le switch était dans un for() admettons, Eh bien on pourrait interrompre également le for(). 

Je ne sais pas si vous avez compris un petit peu le système. 

Admettons on va faire un cas un peu bizarre par exemple.

Alors ça c'est pareil vous pouvez mettre entre les termes les opérateurs des espaces pas d'espace mais moi personnellement je mets des espaces avant et après question de lisibilité mais après vous faites comme vous voulez.
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			break;
```
Si on fait comme ceci parce qu'on peut faire un break dans une boucle, ça fonctionne. 

Alors on ne va interrompre que la boucle courante merci c'est à dire qu'on va casser, interrompre la 2e boucle parce que c'est comme si on faisait 'break 1'.
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			break 1;
```
Donc ça va couper cette boucle.
```php
		for($j = 0 ; $j < 10 ; $++)
```
Donc si en revanche on veut sortir directement des 2 parce que là vous voyez qu'il y a 2 structures de contrôle imbriquées, Eh bien il suffira de faire `break 2`.
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			break 2;
```
`break 2` ça veut dire t'interrompt la courante et une 2e donc dans laquelle se trouve la structure courante voilà donc `break 3` ça sous-entend date rompre 3 structures imbriquées et cetera et cetera. 

Et je vous rappelle que vous pouvez le noter comme cela.
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			break(1);
```
Et si vous mettez 1 et que vous ne voulez interrompre que la structure courante, le 1 est optionnel donc vous pouvez écrire break tout court.
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			break;
```
Voilà on a un autre cas de figure qui est le mot mais ça c'est une autre instruction, l'instruction `continue` et je voulais terminer cette vidéo avec ça. 

Continue au lieu de dire d'interrompre la structure en fait, il va simplement dire de revenir au début de la structure courante donc d'effectuer une nouvelle itération d'accord. 

Donc si vous faites un continue, comme ça ça correspond à `continue 1` mais si vous voulez par exemple revenir à 2 structures, vous feriez un `continue 2` et c'est exactement pareil. 
```php
	for($i = 0 ; $i < 10 ; $i++)
		for($j = 0 ; $j < 10 ; $++)
			continue 2;
```
Alors comment est-ce que ça fonctionne ça ? je vais vous montrer dans 1 cas qui est suffisamment parlant et là je vais changer un petit peu l'ordre d'incrémentation, vous allez comprendre pourquoi. 
```php
<?php

$number =0;

while($number < 10)
{
	echo '<p>'.$number.'<p>';
	$number++;
}
```
```txt
	http://localhost/PHP/cours/010_boucles/
	0

	1

	2

	3

	4

	5

	6

	7

	8

	9
```
Alors ici OK pas de surprise.

Ce que l'on peut faire c'est une vérification, par exemple je fais ça. 
```php
<?php

$number =0;

while($number < 10)
{
	if($number == 5)
		continue;
		
	echo '<p>'.$number.'<p>';
	$number++;
}
```
```txt
	http://localhost/PHP/cours/010_boucles/
```
Si je fais ça voilà ce qu'il va se passer, j'actualise et vous voyez que là mon fichier, on voit qu'il charge, que le script est en train de charger si je laisse encore tourner un petit moment il va me mettre que j'ai dépassé le temps d'exécution autorisé par PHP donc je vais arrêter avant pourquoi ? Parce qu'on est dans une boucle infinie. 

Et certains vous n'aurez peut-être pas compris pourquoi mais on va relire le code et vous allez voir. 

`$number` est égal à 0. Je vérifie est-ce qu'il est inférieur à 10 ? oui c'est le cas. Ensuite je vérifie est-ce que `$number` est égal à 5 ? non. Au départ il est égal à 0 donc on va afficher `$number` puis on incrémente `$number++` donc ça va s'incrémenter plusieurs fois mais le problème c'est qu à un moment donné, on va se retrouver avec `$number` égal 5. Et à ce moment-là on va lui dire continue c'est-à-dire qu'on ne va pas continuer le reste de l'itération. 

Une fois qu'on fait ce continue, on revient au début de l'itération donc on va revenir là.
```php
	$number =0;

>	while($number < 10)
	{
		if($number == 5)
			continue;
			
		echo '<p>'.$number.'<p>';
		$number++;
	}
```
Ensuite est-ce que `$number` est inférieur à 10 ? oui parce que `$number` est égal à 5, rappelez vous. 

Rappeler vous en a fait le continue au moment où `$number` était égal à 5. 

On revient là.
```php
	$number =0;

	while($number < 10)
	{
>		if($number == 5)
			continue;
			
		echo '<p>'.$number.'<p>';
		$number++;
	}
```
Est-ce que `$number` est égal à 5 ? oui ça tombe bien donc on fait continue donc en fait qu'est-ce qui se passe ? on revient au début.

Et vous voyez en fait à l'intérieur, même si on avait l'impression qu'on avait un point d'arrêt grâce à `$number++;` comment va jamais exécuter cas lignes là.
```php
	$number =0;

	while($number < 10)
	{
		if($number == 5)
			continue;
			
>		echo '<p>'.$number.'<p>';
>		$number++;
	}
```
On va jamais exécuter ces lignes là donc on va jamais incrémenter `$number`, Eh bien on est tombé son s'en rendre compte dans une boucle infinie. 

Pour éviter ça, il faut faire tout simplement ceci.
```php
<?php

$number =0;

while($number < 10)
{
	$number++;
	
	if($number == 5)
		continue;
		
	echo '<p>'.$number.'<p>';
}
```
Vous incrémentée et à ce moment-là vous vérifier ça c'est-à-dire que là automatiquement on se crée un point d'arrêt.
```txt
	http://localhost/PHP/cours/010_boucles/
	1

	2

	3

	4

	6

	7

	8

	9

	10
```
On se crée un point d'arrêt et voilà ce qu'il s'est passé au niveau du code, on a affiché 1, 2, 3, 4 et regardez le 5 on ne l'a pas affiché, pourquoi ? parce qu'on a dit tout simplement que si `$number` est égal à 5, il n'allait pas faire la suite de l'itération mais il allait revenir au début de la boucle donc c'est effectivement ce qu'il a fait mais après `$number` passe à 6 donc cette condition `($number==5)` n'est plus vrai et on fait le echo.

Voilà donc là on a une ligne qui manque, on a 1, 2, 3, 4, 6, 7, 8, 9, 10. Du coup vous voyez qu'on a été ici plus loin au niveau de l'incrémentation (jusqu'à 10). On ne s'est pas arrêté à 9 mais on s'est arrêté à 10 du coup donc ça c'est à voir au niveau de cette partie là. 

Et pourquoi nous sommes allés à 10 ? tout simplement parce que l'incrémentation, je la fais au début mais si évidemment je l'avais fait à la fin, Eh bien on se serait arrêté à 9 mais comme là, elle est faites au début évidemment.

Ca va décaler parce que dans la dernière itération quand `$number` est égal à 9 … parce que une fois qu'il est égal à 10, la boucle ne sera plus valide … Eh bien quand il est égal à 9, dès le départ on incrémente avant d'afficher parce qu'on fait la crémation avant l'affichage donc c'est normal que ça nous affiche 10. C'est tout à fait normal par rapport à ça. 

Voilà dans ce cas-là ça peut être très utile aussi par exemple de dire que dans un cas particulier au niveau de notre structure, on continue pas l'itération mais on revient à son début donc ça peut servir. 

C'est une instruction à connaître. 

Il y a continue, il y a break qui peuvent éventuellement en plus interrompre ou revenir à une itération précise en mettant par exemple un entier derrière suivi en fait de l'expression. 

C'est par contre au niveau de l'instruction vous voulez juste faire 1, encore une fois ne le mettait pas parce que par défaut en mettant just `break` ou `continue` c'est comme si vous mettiez `break 1` ou `continue 1` donc ça ne sert à rien même si vous pouvez les mettre bien que ce soit optionnel par rapport à ça. 

Voilà j'espère que c'était suffisamment clair aussi même s'il y a beaucoup de choses que nous aurons l'occasion de Ré aborder par la suite parce qu'encore une fois c'est un ensemble de notions qui aura son utilité quand on va l'associer à d'autres petites choses donc l'utiliser comme ça tout seul ce n'est pas forcément très parlant surtout si parmi vous il y en a qui sont débutants, ou pour qui le langage PHP est le premier langage de programmation que vous étudiez donc ce ne sera pas forcément pratique. 

Après si vous avez déjà l'habitude de programmer, c'est des choses que vous connaissez donc normalement vous savez déjà quelle utilité ça peut avoir par la suite et à quoi vous attendre avec l'utilisation des boucles que ce soit avec PHP ou un autre langage. 

Je vous dis à très bientôt du coup pour la séance numéro 11, on va continuer un petit peu au niveau de PHP où nous allons à priori aborder les fonctions donc on va commencer à aborder cette grande notion là. 

Vous allez savoir enfin ce qu'est une fonction, comment ça fonctionne vraiment dans le détail et même également comment créer les vôtres. 

À bientôt pour la suite de cette vidéo en PHP