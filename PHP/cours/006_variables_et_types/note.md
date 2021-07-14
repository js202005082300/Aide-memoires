# [6. Variables et types](https://www.youtube.com/watch?v=PRXy1yA6O7w)

Bonjour à tous et bienvenue sur cette séance 6 en PHP. 

On attaque vraiment la programmation pour concevoir votre site web et développer un programmation web avec ce langage. 

On va commencer dans cette vidéo abordé la notion de variable qui est une des plus importantes en programmation et dans tous les langages d'ailleurs qui sont dans ce domaine là. 

Et on va vous séparer des types, j'ai mis le terme type dans le titre de la vidéo pour parler tout simplement des types de données que nous allons pouvoir manipuler avec ce langage. 

Je vais revenir dessus au fur et à mesure et même dans les autres vidéos parce qu'on aura l'occasion d'en parler assez souvent au cours de la vidéo mais je tiens évidemment à présenter ça dés le départ.

Alors le type de données que vous allez pouvoir manipuler … alors je ne sais pas mais je pars toujours du principe comme toujours que vous n'avez jamais vu de formation en informatique, en programmation ou autre avant celle-ci donc je considère que c'était votre première formation sur l'informatique donc vous avez tout à apprendre et du coup on va parler un petit peu des types que vous allez pouvoir retrouver ici en termes de programmation d'accord.

Alors on a grosso modo en PHP, on a une dizaine de type basique d'accord des types primitifs appelez ça comme vous voulez donc des types natifs peu importe qui sont géré via le langage.

On va avoir 4 ensemble dit scalaire, alors des ensembles scalaires ce sont tout simplement des types de données que nous allons pas pouvoir couper par exemple scinder en 2 ce genre de chose. Chose qu'on pourra faire en revanche avec des tableaux, une des notions qu'on fera au cours de cette formation de toute manière et qu'on aura l'occasion d'aborder bien dans le détail dans une séance dédiée. 

Donc les types scalaires il y en a quelques-uns, je vous ai dit il y a 4 ensemble de type scalaire c'est-à-dire de type qu'on ne peut pas diviser, qu'on ne peut pas scinder, qu'on ne peut pas couper d'accord qui vont pouvoir être utilisés. 

Alors je vais vous le noter, on va les mettre dans des commentaires pour ceux éventuellement qui aiment bien prendre des notes. Je le fais régulièrement sur la formation pour que ce soit plus pratique pour que vous puissiez comme ça prend des notes au fur et à mesure en mettant en pause la vidéo et en ayant ça de côté. C'est histoire de vous indiquer les choses à vraiment retenir parce que ça va vous suivre tout le long mais si vous ne assimiler pas ces choses dès le départ, ça risque de énormément vous handicaper pour la suite donc il faut faire attention de bien bien comprendre ces notions là.

Alors les fameux 4 types de base et qu'on peut retrouver dans d'autres langages d'ailleurs, ce n'est pas forcément qu'en PHP, vous verrez si vous avez déjà fait d'autres formations et que vous avez prévu d'en faire d'autres après PHP, vous reviendrez très très souvent sur ces types là.

Le premier c'est le type booléen d'accord et on va le marquer en terme français parce que je fais une formation en français. Le terme voulait hein et en général on va l'écrire comme ceci (boolean, bool) et même plus exactement on va juste garder le terme anglais (boolean) par rapport à la programmation c'est-à-dire qu'en programmation on parle de boolean comme ceci et on a son diminutif comme ça (bool) donc ça c'est si vous le voulez une valeur binaire, c'est une donnée qui pourra prendre une valeur binaire soit elle pourra prendre la valeur de vrai qui correspond en termes de programmation à ceci (true) ou alors elle prendra la valeur de faux qui correspond à ceci (false) voilà ce genre de choses-là.
```php
	/*
		Booléen (boolean, bool) : vrai (true) | faux (false)
	*/
```
Au niveau programmation d'accord parce que je note au niveau programmation par rapport aux valeurs que ça peut prendre, true ou false ce sont des données qui sont insensibles à la case c'est-à-dire que si vous écrivez true comme ça en minuscule quand vous allez programmer plus tard pour définir, déclarer un booléen et que vous l'écrivez tout en majuscules ça ne changera rien d'accord.

Au niveau de PHP, vous pouvez l'écrire de 2 manières différentes (TRUE ou true) mais on va revenir dessus de toute façon tout à l'heure avec les variables, on va créer des variables booléennes et je vais vous expliquer plus en détail à quoi ça correspond donc voilà grosso modo pour le booléen, c'est en fait du binaire c'est soit vrai ou faux, soit c'est égal à un pour vrai soit c'est égal à faux c'est-à-dire 0.

C'est forcément que l'un ou l'autre, true ou false. 

À quoi ça peut servir par exemple l'imaginer il donnait où on voudrait dire, est-ce qu'un article sur un site est publié ? oui ou non, ce genre de chose, est-ce qu'il est mis en brouillon ? oui ou non, est-ce que telle partie d'un contenu est accessible seulement à l'administrateur ou à tout le monde ? on peut également faire un système de booléen comme ça, public ou privé ce genre de chose donc ça sert beaucoup les données booléennes donc ça c'est le premier type scalaire.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) : vrai (true) | faux (false)
	*/
```
Donc on a ça le booléen, ensuite on va en avoir un qui est l'entier alors l'entier c'est un nombre, c'est tout simplement un nombre, ça peut être 14 ça peut être moins 10 ça peut être 126 donc un nombre comme ceci. On va le noter integer ou son diminutif qui est int, et lui c'est encore une fois un nombre donc je vais mettre plein d'exemple 14, -126, 12300 et cetera. 

C'est basé sur le système de codage de vos machines, on va dire que la valeur maximale que l'on va pouvoir stocker comme type de données comme entier, integer, dépend de votre machine mais grosso modo comme c'est du codage sur 32 bits, ça correspond à peu près à un maximum d'une valeur de 2000. 

Par exemple si vous essayez de noter le nombre 6 milliards en tant que entier ça ne marchera pas parce que vous aurez dépasser en réalité le plafond maximum pour les nombres entiers donc il n'a pas utilisé pour certaines données qui sont vraiment très très grande mais c'est pareil de toute façon on aura l'occasion de revenir là-dessus. Voilà pour ça.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) : vrai (true) | faux (false)
			Entier (integer, int)	: 14, -126, 12300
	*/
```
On a ensuite tout simplement son équivalent qui est en nombre décimal donc nombre à virgule ou nombres flottants, et moi je vais noter "Flottant" tout simplement donc il y a le terme float et il y a le terme un peu historique double comme le langage PHP et je l'avais dit est un langage qu'il y a pas mal évolué avec le temps. 

Il n'était comme il est à présent à ses débuts. À la base il n'était pas prévu pour devenir un langage public utilisé par plein de gens, c'était juste un projet personnel qui a été ensuite développé de plus en plus et comme c'est un langage qui est assez ancien, qui a pas mal évolué et qu'il y a toute une histoire, Eh bien il n'y a pas mal de choses historiques qui sont restés pour ne pas perdre compatibilité au fur et à mesure des mises à jour donc ils ont gardé le terme historique double même si on utilisera plus souvent le terme de float d'accord donc on a par exemple le fameux nombre pi (3.14) ça peut être des valeurs négatives aussi (-12.62).

Alors pourquoi est-ce qu'on met un point et pas une virgule parce qu'en informatique pour ceux qui ne savent pas, le point remplace la virgule donc en informatique on écrit pas des nombres à virgules on écrit les nombres avec des points. Voilà c'est la ponctuation en informatique pour représenter les virgule quand on fait des nombres décimaux. Les flottants par contre peuvent avoir par contre une fourchette de valeur qui est très très grande, beaucoup plus grandes que les entiers dont il est très compliqué de connaître la fourchette parce que ça dépend celon les langages ou l'endroit où c'est codé mais ça peut se vérifier de toute manière au niveau du langage, on pourra toujours regarder ça.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) : vrai (true) | faux (false)
			Entier (integer, int)	: 14, -126, 12300
			Flottant (float, double): 3.14, -12.62
	*/
```
Alors on a un type qui est très intéressant ici qui est la fameuse chaîne de caractères dont on aura l'occasion de revenir aussi qui s'appelle tout simplement string et là c'est une chaîne qu'on peut se la représenter de plusieurs manières tel que 'bonjour', "bonjour" et on verra d'autres choses aussi donc là je pense que ce n'est pas compliqué ça peut être également plusieurs morts "bonjour tout le monde" et pas forcément un seul, ça fonctionne aussi. 
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
	*/
```
Voilà un petit peu comment ça se passe au niveau des 4 types scalaires donc on regardera un petit peu tout ça par la suite. 

Ensuite on va avoir … ça c'était les types que l'on va vraiment beaucoup utiliser mais au niveau de PHP on va également avoir des types un petit peu particulier qui sont 4 types de composés, Parmi eux on va retrouver des choses très intéressantes aussi que l'on va pas voir pour le moment parce que ce n'est pas encore évidemment le niveau actuel, vous démarrez tout juste en PHP donc on est encore loin d'être là pour le moment. On a les tableaux comme on en a parlé tout à l'heure du fait que ça peut être scindé donc il ne s'agit pas d'un type scalaire pour le coup parce qu'un tableau pour être coupé en 2, scindé, divisé et cetera donc on en parlera plus tard. Et ça s'appelle les array tout simplement donc je ne présente pas à quoi ça correspond parce qu'il y aura de toute façon une vidéo faite dessus donc inutile de vous les présenter là on verra ça pour plus tard. 
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
	*/
```
On va voir ensuite les objets et le nom c'est object qui est objectif donc ça c'est quand on va faire de la programmation objet, ou la fameuse POO ou technologie orientée objet donc ça a plusieurs thèmes pour le définir mais c'est pareil on fera de la programmation objet en PHP puisque c'est un langage multi paradigme donc qui permet de programmer à la fois en procédural c'est à dire de manière séquentielle c'est à dire instruction par instruction, c'est ce par quoi nous allons commencer ils nous feront suite de la programmation objet mais on reviendra dans le détail là dessus quand on y sera donc ne vous en faites pas pour le moment si vous ne comprenez pas parce que là absolument pas abordé donc c'est pareil on le verra plus tard donc je ne m'étends pas sur le sujet. 
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
	*/
```
Ensuite on va voir les fonctions d'appel ou de rappel plus exactement donc les fonctions c'est pareil c'est une notion que vous n'avez pas encore vu en PHP mais de toute façon il va y avoir une vidéo sur les fonctions aussi et ça on les appelle les callable donc les collables, voilà ce sont les fonctions de rappel et on reviendra dessus aussi.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
	*/
```
Ensuite on a les itérateurs et là ce sont les iterable donc pareil c'est un autre type composé sur lequel on aura l'occasion de discuter également donc les types composés on verra ça plus tard, il y aura des vidéos dédiées donc je vous donne juste les noms histoire que vous sachiez pour votre culture générale, pour votre apprentissage mais on verra bien évidemment tout ça dans le détail. 
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
	*/
```
On va surtout commencer à travailler avec ceux-là.
```txt
	Booléen (boolean, bool) 		: vrai (true) | faux (false)
	Entier (integer, int)			: 14, -126, 12300
	Flottant (float, double)		: 3.14, -12.62
	Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
```
Après on a 2 types divers qui sont Resources (idem en anglais) ça c'est par exemple quand on veut charger des ressources mais là c'est pareil on est encore loin d'aborder ce genre de choses parce que c'est quand même assez complexe, en plus ça fait appel à pas mal de notions de sécurité parce que ça peut présenter pas mal de risques ou de comportements inattendus hum donc il est clair qu'on abordera pas ça tout de suite.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
		
		2 types divers :
			Ressource (ressource)
	*/
```
Et le fameux type NULL qui veut dire rien tout simplement, ça correspond à nulle en fait, et vous pouvez également l'écrire tout en minuscule "null" parce que c'est pareil ce n'est pas sensible à la case dans ce genre de carte comme pour true et false. Vous pouvez écrire tout en minuscule avec une lettre majuscule au départ, tout en majuscules, comme vous voulez ça ne pose pas de problème.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
		
		2 types divers :
			Ressource (ressource)
			NULL (ou "null")
	*/
```
Voilà grosso modo pour les fameux 10 types basiques donc ça c'est facile à retenir quand on sait qu'en PHP il y a grosso modo 10 types basiques c'est facile de les retrouver parce que c'est un homme qui se retient facilement même quand on connaît plein de langages donc on ne risque pas de se mélanger à ce niveau-là. 

Voilà là je vous ai présenté un peu tous les types différents donc on va pouvoir maintenant comme ça attaquer les variables et on va en parler parce que c'est THE NOTION vraiment la plus importante en informatique et en programmation de manière générale, et à partir du moment où vous avez compris la notion de variable sur un langage, vous l'aurez compris sur toutes les autres parce que c'est exactement pareil alors qu'est-ce qu'une variable en programmation ? c'est tout simplement une petite info donc on va en fait nommer une variable, on va lui donner un nom, et dans lequel nous pourrons stocker tout un tas de données et justement les données dont on pourra stocker c'est tout simplement ce que je vous ai montré là.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
		
		2 types divers :
			Ressource (ressource)
			NULL (ou "null")
	*/
```
Absolument ça donc vous aurez 10 types que vous pourrez exploiter à l'intérieur des variables donc voilà Comment ça va se composer, et après je vais vous expliquer tout simplement à quoi ça sert mais je vais déjà vite fait pour noter un exemple et vous verrez comment ça fonctionne donc une variable en termes de code, elle va se noter elle va s'identifier de manière générale par le symbole dollar `$` et à partir de là on va pouvoir la nommer. Le nommage de variables comme tout langage de programmation … je pense je ne dois pas dire de bêtise en disant simple ou alors certains ont fait des langages un peu bizarre … doivent commencer avec un système de nommage particulier

Déjà dans un nombre variable on ne commence pas par un chiffre d'ailleurs on peut voir au niveau de la coloration du code, l'éditeur n'est pas content donc on évite de commencer par un chiffre `$3`, on ne mettra pas évidemment d'espace `$ aaa` parce que ce serait bizarre parce que ce serait bizarre de mettre des espaces dans un nombre variable et on ne met pas de caractères accentués ou de caractères spéciaux donc pas de `$é` ou encore `$ç` ou je ne sais quoi ou des étoiles `$*` bref des caractères un peu bizarre donc la seule chose que vous pouvez utiliser c'est commencer au minimum par une lettre qu'elle soit majuscule ou minuscule. Après vous pouvez mélanger, vous pouvez mettre ce que vous voulez, vous pouvez mettre des chiffres est ce que vous voulez aussi, des chiffres alphanumériques ce qui donne par exemple `$aEfz797161` et des underscores `$aEfz797161_` Le fameux tiret du bas. 

Donc pas de tirer comme ça `$aEfz797161-` mais vraiment le underscore `$aEfz797161_` c'est le soulignait en fait celui qui soulignent sous le texte donc à partir de là vous pouvez nommer vos variables comme ça, je peux créer une variable qui s'appelle comme ceci.
```php
	$_mavariable =
```
Ensuite on mettra en égale et on va pouvoir lui donner une valeur mais ça je vais en parler un petit peu après. 

On peut créer une autre variable comme cela, elles ne sont pas les mêmes comme les noms sont différents, ce sont 2 variables différentes donc attention.
```php
	$_mavariable =
	$mavariable
	$maVariable
```
On peut faire également comme ceci, pareil le nommage des variables est sensible à la case, ça veut dire que les minuscules et les majuscules sont définies différemment donc `$mavariable` n'est pas considéré comme la même variable que `$maVariable`.

Bien évidemment dans un vrai code on évitera de mettre des noms comme ça similaire avec juste un changement au niveau de la case sinon ça risque de poser AC problème à la lecture et au développement de votre programme moi en tout cas de votre script. 

Après on peut très bien écrire comme ça `$ma_variable`. 
```php
	$_mavariable =
	$mavariable
	$maVariable
	$ma_variable
```
Voilà, il y a plusieurs méthodes pour le faire.

On a la méthode où on commence à écrire le mot en minuscule `$maVariable` et à chaque nouveau mot on met une majuscule, par exemple `$maVariableDeCode` qui est la syntaxe dite camelCase c'est-à-dire qu'on va simplement à chaque fois pour identifier chaque mot dans le nom de la variable, mettre une majuscule au départ. Ça permet de mieux lire que si tout est écrit en minuscule comme ici `$mavariable`. 
```php
	$_mavariable =
	$mavariable
	$maVariableDeCode
	$ma_variable
```
On évite les underscores `$_maviarable`, c'est pareil c'est des cas un petit peu réservé mais vous pouvez et ça on en parlera pas mal quand on fera de la programmation objet. 

Grosso modo moi ce que je vous conseille mais vous êtes évidemment libre comme je le dis souvent dans toutes les formations que je fais, je vous conseille certaines choses pour vous donner de bonnes habitudes si vous débutez mais après si vous avez vos conventions de nommage, de codage et cetera, vous faites ce que vous voulez mais moi je vous recommandent PHP de nommer effectivement vos variables en camelCase c'est-à-dire comme ceci.
```php
	$maVariable
```
Donc une variable tout simplement qu'est-ce qu'il va se passer ? si on n'utilise pas de variable dans un programme nous allons manipuler des données. On est bien d'accord que si on est sur un site internet, que ce soit un jeu ou un site web, un blog ou n'importe quoi en fait, peu importe ce que c'est vous allez avoir besoin de manipuler des données. 

Si vous n'utilisez pas devant rien vous allez juste pouvoir faire des affichages comme on l'a vu tout à l'heure et éventuellement ouvrir des documents, des fichiers ce genre de chose, accéder à des données mais vous ne pourrez rien en faire puisque ces données ne sont pas sauvegardés pendant l'exécution de notre programme, ce qui est un peu embêtant. 

Donc si je fais comme on a fait habituellement par exemple.
```php
<?php
echo "Bonjour Jason !"
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Bonjour Jason !
```
Donc j'ai démarré mon serveur et tout ça bien sûr j'ai tout prévu. 

Donc là ça a été écrit en dur au niveau du texte, c'est bien mais "Bonjour Jason !" c'est une donnée que si on veut la changer on est obligé de directement modifier dans du texte et si un jour j'ai besoin de récupérer le nom "Jason" par exemple pour l'afficher à plein d'endroits, je vais devoir le marquer à chaque fois et le jour où on va vouloir faire un changement dans le programme, il faudra modifier tout le code ce n'est pas du tout dynamique, c'est écrit en dur, c'est statique. 

Enfin voilà ce n'est pas propre du tout et de toute façon ne pourrait pas programmer de cette manière, on a besoin d'informatique en programmation, c'est obligatoire de manipuler des variables.

Une variable tout simplement en termes de programmation, vous allez lui donner un nom et vous allez pouvoir y stocker affecter une valeur, et cette valeur ça peut être un des types que je vous ai présenté ici.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double)		: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
		
		2 types divers :
			Ressource (ressource)
			NULL (ou "null")
	*/
```
Qu'est-ce qui va se passer aussi en terme informatique ? parce que ça c'est que le terme programmation. Eh bien en informatique le langage en question, que ce soit son compilateur, que ce soit son interpréteur enfin peu importe pour PHP c'est un langage interprété donc c'est encore différent, il va demander à votre système d'exploitation donc ici en l'occurrence c'est Windows, si vous êtes sur Linux ce sera Linux, si vous êtes sur Mac ce sera Mac OS, peu importe ça ne change rien voilà. 

L'autorisation de réserver un emplacement en mémoire vive donc la fameuse mémoire RAM vous savez les barrettes de RAM que vous avez dans votre ordinateur et il va y stocker l'information à l'intérieur. La barrette de mémoire de mémoire, la barrette de RAM, elle est composée de cette manière. 
```txt
	ADRESSE | VALEUR
	0000    | $maVariable
```
vous avez grosso modo un système d'adressage Adresse | Valeur d'accord l'adresse c'est un nombre donc c'est un petit peu comme une adresse postale, ça peut être un nombre décimale, hexadécimal, peu importe pour lequel on peut par exemple imaginer l'adresse 0000 et on va stocker une variable par exemple $maVariable mais ce qu'on va y stocker surtout, c'est sa valeur. Admettons qu'on lui mette une valeur 4 qui serait pour le coup un entier, un integer, un int.
```txt
	ADRESSE | VALEUR
	0000    | $maVariable = 4
```
Voilà on va demander au système d'exploitation de chercher un emplacement suffisant qui permet de stocker un type entier en fonction de la place que ça prend en termes d'octet, en mémoire.  

Windows ici en l'occurrence sur mon PC, Windows va cherché un emplacement une place suffisante un peu comme une place de parking et il va dire il a trouvé une place à tel adresse et le langage va dire que à cette adresse 0000, je stocke cette valeur '4'.

Mais comme vous le savez la mémoire vive c'est une mort qui est volatile c'est à dire que quand vous allez éteindre votre PC et le redémarrer, cette mémoire va être vidée donc attention ce n'est pas comme un disque dur lorsque vous enregistrer un fichier, ça le sauvegarde même après redémarrage. Une mémoire vive, c'est sauvegarder que le temps de l'exécution donc dès que votre programme sera terminé, les informations seront évidemment perdues mais on verra plus tard comment sauvegarder des données dans des fichiers, dans des sessions, comment sauvegarder dans des bases de données pour que les données soient gardées de manière persistante donc c'est-à-dire de pouvoir être réutilisé et jamais perdues. 

Donc ça en terme de variable, ce sont des données qui sont volatiles. 

Et le nom variable n'est pas un hasard, dit variable parce que on va pouvoir faire varier tout simplement le contenu de nos variables, changer ce qu'elle stock, changer l'information qui est stockée à l'intérieur donc voilà comment ça fonctionne. 

Alors j'ai été très basique dans les explications parce que le but ce n'est pas de vous perdre dès le départ, on commence tout juste mais voilà comment ça fonctionne. 

En programmation, on donne un nom à une variable en l'identifiant avec un petit dollar $ donc par exemple $maVariable mais ça peut être aussi par exemple $monPrenom. On met un égal :
```php
	$monPrenom =
```
Ça c'est un opérateur, c'est ce qu'on appelle l'opérateur d'affectation pour dire qu'on affect dans cette variable $monPrenom, une valeur. 

Moi je veux fonctionner comme une chaîne, une chaîne de caractères où je vais stocker mon prénom `"Jason"` donc je mets ce symbole là `""`.
```php
	$monPrenom = "Jason"...
```
Avec ce symbole-là "" mais on va en parler un petit peu et on termine avec un `;` comme je l'ai déjà expliqué dans les séances précédentes où j'avais dit que toutes les instructions PHP se terminent par un `;` sauf éventuellement la dernière du bloc mais pour être sûr de ne jamais vous tromper mettez en tout le temps une comme ça chaque construction est bien respectée et vous êtes sûr qu'il n'y aura pas de problème.
```php
	<?php
	$monPrenom = "Jason";
	
	echo "Bonjour Jason !";
```
À partir de ce moment-là, je n'ai plus qu'a faire ça, je prends ma variable, tout le nom de la variable $monPrenom et vous voyez qu'avec le echo "" j'ai mis des doubles guillemets donc à partir du moment où j'ai des doubles guillemets, j'ai juste à faire ça.
```php
<?php
$monPrenom = "Jason";
	
echo "Bonjour $monPrenom !";
```
El là si j'actualise, F5, vous voyez aucune différence.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Bonjour Jason !
```
Pourtant il est passé par une variable. 

L'avantage de ça c'est imaginer un jeu, un article, dès que vous allez vouloir changer le prénom plutôt que de modifier tous les endroits où vous avez Marquez votre prénom, vous avez juste à modifier cette ligne là et en actualisant, vous changez la valeur de la variable.
```php
<?php
$monPrenom = "Robert";
	
echo "Bonjour $monPrenom !";
```
El là si j'actualise, F5, vous voyez aucune différence.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Bonjour Robert !
```
En actualisant vous changez la valeur de la variable tout simplement, on a fait ici une modification de la valeur de la variable parce que mon prénom il peut varier, il peut changer au cours de l'exécution et vous allez voir plein de choses avec les variables. On va pouvoir faire des tests ce qu'on appelle des conditions, on va pouvoir faire des boucles, on pourra appeler des fonctions pour utiliser nos variables pour faire des calculs, pour faire des tests, pour récupérer des informations dans une base de données pour les afficher, pour les trier, pour les exploiter, tout un tas de choses. 

C'est pour ça que je vous dis qu'en informatique, en programmation, sans variable on ne pourrait rien faire. La seule chose qu'on pourrait faire, c'est affiché tout bêtement du texte. On ne pourrait même pas demander des informations à l'utilisateur parce que à partir du moment où on demande une information à l'utilisateur, il faut qu'on puisse la sauvegarder. La donnée est perdue son de la sauvegarde pas donc les variables sont vraiment importantes. 

Maintenant que ces explications sont données, on va voir comment créer des différents types de variables très rapidement et donner toutes les explications. 

Si on fait un booléen, ici je vais donner un nom très explicite mais vous pouvez donner le nom que vous voulez au niveau des variables donc on fait un booléen qui est initialisé à vrai donc à true mais vous pouvez également l'écrire à false, on peut également le mettre en majuscule FALSE parce que ce n'est pas sensible à la case donc ça ne pose absolument aucun problème de l'écrire comme ça et ça fonctionnera.
```php
	$unBooleen = true;
	$unBooleen = false;
	$unBooleen = FALSE;
```
Au niveau du nommage de variables, trouver des noms un maximum explicite, évitez les noms de variables comme ceci. Et puis après je fais une variable B et je met je ne ce quoi dedans. Voilà on ne sera pas du tout à quoi ça correspond, ça ne veut rien dire donc mettez des noms explicites par rapport à ce à quoi ça sert.
```php
	$a = FALSE;
	$b = "Jason"
```
Un homme très très long à écrire ça ne pose aucun problème.
```php
	$unNomDeVariableTresTresLongAEcrire = FALSE;
```
Voilà sachez qu'il y a beaucoup de gens qui sont sur des vieux langages de programmation au départ et à l'époque on était limité au niveau du nommage des variables. Le nom ici prenait pas mal de place en mémoire, il était très important du coup on est obligé de faire des variables avec 1, 2 ou 3 caractères et pas plus.
```php
	$aaa = FALSE;
```
C'était vraiment limité on pouvait pas faire autrement mais maintenant on est sur des langages beaucoup plus évolués et les capacités en termes de mémoire sont bien meilleurs donc écrivez des noms explicites et logiquement c'est un code bien fait, vous n'aurez pratiquement pas besoin de le commenter parce que votre code en lui-même sera déjà suffisamment explicite donc par exemple ici j'ai un nom, on mettra ça.
```php
	$b = "Jason";
	--> $prenom = "Jason";
```
Alors ça ce n'est pas un nom de variable explicite parce que c'est "prenom" de quoi, de qui ? par contre si je met ceci.
```php
	$auteurArticle = "Jason";
```
Dans le cas par exemple je fais un billet de blog, là on sait à quoi ça correspond, on sait qu'on a mis ici l'auteur de l'article sur lequel il essaye d'afficher, de modifier ou d'écrire. Tout de suite c'est déjà beaucoup plus explicite et en lisant le code on n'a pas besoin de faire ça.
```php
	//Auteur de l'article
	$prenom = "Jason";
```
Voilà ça c'est de la mauvaise programmation c'est à dire de devoir commenter quelque chose qui l'aurait pu l'être automatiquement simplement en mettant une variable explicite quitte à mettre ça simplement.
```php
	$prenomAuteurArticle = "Jason"
```
Peu importe même si vous mettez plusieurs mots comme ça à la suite, ça ne pose aucun problème et au moins on sait à quoi ça correspond tout de suite donc ça c'est vraiment la petite astuce que je vous donne ici au niveau des variables c'est à dire nommer vos variables de manière explicite, peu importe ce sera quand même beaucoup plus efficace et beaucoup plus pratique. 

Imaginer que sur certains programmes, sur certains sites, vous allez travailler plusieurs mois dessus et comme vous allez revenir après 3 ou 4, 5 mois après dessus sur ce que vous avez écrit tout au départ, si ce n'est pas nommé de manière explicite, vous n'allez plus rien comprendre vous ne serez même pas à quoi ça correspond et du coup votre propre code sera illisible, vous n'arrivez même pas à vous relire vous-même donc ça risque d'être assez problématique. 

Alors je repasse sur un nouvel exemple avec des noms qui ne sont pas du tout conseillé mais je vous montre avec un booléen qui peut s'écrire comme ceci $unBooleen. Pour écrire en entier on l'a fait tout à l'heure ce genre de chose $unEntier, auquel on peut mettre une valeur négative aussi (-14) ça ne pose pas de problème. On peut écrire en flottant $unFlottant avec par exemple la valeur pi (3.14). On peut écrire une chaîne $uneChaine et attention on ne met pas de circonflexe Î parce que c'est un caractère spécial que vous pouvez écrire comme ça `"Jason"` ou comme ça `'Jason'` par contre quand vous l'écrivez avec les simples quotes et que vous avez à l'intérieur des apostrophes par exemple comme ceci 'C'était hier' … vous allez déjà voir que là coloration indique un problème et que la chaîne c'est terminé après le 'C' donc le seul moyen de faire comme ça soit vous travaillez avec des doubles quotes soit vous voulez échapper en mettant en antislash `'C\'était hier'` tout simplement donc c'est ALT GR + une autre touche pour nous faire antislash c'est là sans problème ça fonctionne.
```php
	$unBooleen = true;
	$unEntier = -14;
	$unFlottant = 3.14;
	$uneChaine = 'C\'était hier';
```
Donc si vous avez beaucoup d'apostrophe pour éviter de faire ça `\'` à chaque fois, vous les entourés de double quotes, ça ne changera pas grand-chose et ce serra plus lisible pour vous aussi.

Essayez toujours de choisir la facilité et là lisibilité c'est le plus important, ça ne sert à rien d'essayer d'optimiser au maximum ou utiliser le moins de caractères possibles. L'intérêt c'est que ce soit beaucoup plus lisible pour vous, beaucoup plus maintenable et facile à réutiliser par la suite, c'est tout l'intérêt de la programmation. 

Voilà pour ça alors les outils on ne va pas en parler on le verra beaucoup plus tard donc on regardera ça alors pour les entiers pareil je reviens dessus un petit peu, je vais un peu vite parce qu'il y a beaucoup de choses à voir. 

Alors vous pouvez écrire plusieurs types de données sous plusieurs formes, un booléen je vous ai dit c'est true ou false, c'est un binaire mais les entiers ce sont plusieurs nombres et on peut les écrire de plusieurs manières différentes donc on peut déjà aller faire précéder d'un `+` ou d'un `-` parce que si vous ne mettez rien il considère que c'est positif mais vous pouvez éventuellement mettre `+` si vous voulez.
```php
	$unEntier = -14;
	$unEntier = +14;
	$unEntier = 14;
```
On peut le faire de plusieurs manières différentes donc on peut déjà les faire précédent d'un + ou d'un - mais le plus en général on ne le même pas parce que si vous ne mettez rien il considère que c'est positif pas de souci mais vous pouvez éventuellement le mettre si vous voulez, c'est vous qui voyez. 

Et vous voyez que c'est une notation décimale, et là je fais appel à ceux qui ont quelques petites notions en mathématique sur les système de base donc ça c'est ce qu'on appelle la base 10 c'est-à-dire la base décimale de 0 à 9, ensuite on à la base binaire, vous connaissez, c'est 0 ou 1. Les non binaires en informatique c'est bien connu. Pour écrire en binaire il suffit juste de mettre un `0b`. Et vous écrivez ensuite le nombre en binaire par exemple si je vais écrire `111111` et bien je vais le faire comme ça.
```php
	$unEntier = 0b111111;
```
Voilà mais si vous l'écrivez comme ça :
```php
	$unEntier = 111111;
```
Le nombre sera considéré comme un nombre décimal 111 111 que si vous mettez un `0b` devant, il va le prendre comme un nombre binaire. Et si vous voulez le marquer en hexadécimal c'est `0x`.
```php
	$unEntier = 0xAFD35C;
```
Et si vous voulez un nombre en octal, vous mettez un 0 devant. Par exemple si vous voulez mettre 640, vous mettez 0640 et ça ce serait considéré comme un octal parce qu'il part du principe que si vous vouliez mettre l'entier 640, ça ne sert à rien de mettre 640 devant, non on fait habituellement comme ça.
```php
	$unEntier = 0x640;
```
Donc à partir du moment où vous mettez un 0 devant, vous êtes en basse 8 c'est-à-dire en base octale et pour le hexadécimal je rappel c'est la base 16 évidemment, on va de 0 à F. 

Voilà pour ça, et là on est sur un entier décimal tout simplement.
```php
	$unEntier = 640;
```
Ça je voulais montrer rapidement parce que c'est bien à savoir, ensuite pour le nombre flottant, il y a aussi d'autres notations et c'est pareil je vais aller assez vite parce qu'un jour si vous en avez l'occasion vous reviendrez peut-être sur cette vidéo pour voir un petit peu les notations que j'avais présenté où au pire vous poserez la question ce n'est pas bien grave si vous avez oublié. 

Par exemple pour un flottant on va avoir :
```php
	$unFlottant = 15.e6;
```
15.e6 ça c'est pour les mathématiciens, et vous avez également la syntaxe avec un grand E `18E-14` dans lequel on peut mettre un nombre négatif voilà.
```php
	$unFlottant = 18E-14;
```
Voilà je ne rentre pas dans les détails ce sont des mathématiques, des notations scientifiques et je ne suis pas là pour vous faire un cours de math. Et ceux qui sont intéressés par ce type de notation, seront à quoi je fais référence, vous pouvez évidemment utiliser ces notations scientifiques au niveau de vos nombres flottants, ça ne pose aucun problème. Ça fonctionne sans problème niveau de PHP. 

Voilà ce que je voulais vous montrer à ce niveau. 

Alors pour les chaînes de caractères, j'aimerais revenir sur un autre point. Alors au niveau booléen on a tout vu. Au niveau des entiers on a vu toutes les types de notation et les différentes bases. Pour les flottants on a vu les différentes notations aussi. Et pour les chaînes je vous ai montré les doubles quotes, je vous ai montré les simples quotes. Alors il y a aussi une notation pour pouvoir écrire sur plusieurs lignes, ce qui est très simple et qui peut choquer un petit peu au départ. Vous mettrez 2 chevrons ouvrants `<<`, bref 2 fois le symbole inférieur à et ensuite vous choisissez un mot qui servira un peu comme un label, un libellé. Vous choisissez par exemple le mot LIMITE même si c'est n'importe quoi comme ceci.
```php
	$uneChaine = <<LIMITE
```
Et là vous allez à la ligne et vous écrivez votre texte et une fois que vous avez finis d'écrire votre texte, vous écrivez le fameux mot que vous avez mis au départ, suivi d'un ;.
```php
	$uneChaine = <<LIMITE
	Votre texte sur
	plusieurs lignes
	LIMITE;
```
On peut mettre ce que l'on veut, on peut mettre END ou n'importe quoi.
```php
	$uneChaine = <<END
	Votre texte sur
	plusieurs lignes
	END;
```
Honnêtement je vous le dis ça c'est une notation que je n'ai jamais utilisé en fait, je l'avais apprise parce que c'est bien de savoir en PHP tout ce qui existe, même si pourtant je n'ai jamais eu personnellement pourtant j'utilise quand même PHP au quotidien et je pense que c'est un des langages que j'utilise le plus dans mon travail. Je n'ai jamais eu besoin d'utiliser cette notation après c'est bien de peut-être vous le montrer parce que ça peut servir et des gens qui vont apprécier ce type de notation mais après est-ce que ça a vraiment une utilité, je ne sais pas, ça c'est à vous de voir donc c'est quand même bien de connaître cette notation aussi. 

Voilà je vous ai présenté les types, on a fait le tour de tout ça. Je vous ai montré ce qu'on pouvait mettre comme variable et je vous quand même bien expliquer en détail et au niveau affichage on avait juste vu la base. Par exemple on va juste avoir `$prenom` comme ceci avant de faire un echo comme ça mais on va éviter de mettre des accents puisqu ici on n'utilise pas de HTML et qu'il n'y a pas de encodage en utf 8 d'appliqué donc on va éviter …
```php
<?php
$prenom = "Jason";
	
echo "Mon prenom est $prenom !";
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est Jason !
```
Vous voyez que ça fonctionne sans problème donc ça c'est une première notation si vous voulez directement inclure les variables, vous les mettez entre double quotes mais par contre si c'est en entre simple quote et dans certains cas c'est plus pratique d'écrire comme ça, vous voyez que tout est mis comme du texte.

Si j'actualise d'ailleurs, vous allez voir le changement, tout est considé comme du texte.
```php
<?php
$prenom = "Jason";
	
echo 'Mon prenom est $prenom !';
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est $prenom !
```
Pour afficher une variable à ce moment-là, il faut lui échapper du texte donc pour ça il suffit de terminer la chaîne que vous voulez en laissant bien un espace après le 'est ' et vous mettez un point pour faire un concaténation pour dire que la suite de cette chaîne là (espace compris) dans le quel on lui met le prenom.
```php
<?php
$prenom = "Jason";
	
echo 'Mon prenom est '.$prenom;
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est Jason
```
À la suite de cette chaîne là (espace compris), il met le contenu de la variable $prenom. 

L'avantage des éditeurs de code encore une fois … mais prenez-en un comme Visual Studio code, Sublime text, Atome, Brackets, Notepad++, un gros environnement de développement peu importe, vous prenez ce que vous voulez comme logiciel ce que vous arrange mais ce qui est bien avec la coloration syntaxique déjà ça nous aide pas mal pour voir si le code est bien fait ou pas parce que dès qu'il y a des couleurs bizarres, on peut se dire que c'était pas normal qu'il change de couleur donc ça permet de se corriger assez rapidement. 

Et là évidemment ça fonctionne et si j'affiche le code source vous voyez que tout est bien défini à l'intérieur.
```html
	<!DOCTYPE html>
	<html>
		<head>
			<title></title>
			<style>
			</style>
		</head>
		<body>Mon prenom est Jason</body>
	</html>
```
Voilà pour les variables, après on peut mettre un texte à la suite, concaténer et vous ouvrez votre chaîne par exemple si on veut terminer avec un ! On peut faire comme ça.
```php
<?php
//$prenom = "Jason";
//	
//echo 'Mon prenom est '.$prenom.' !';
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est Jason !
```
Évidemment ça fonctionne, il n'y a pas de problème vous pouvez les concaténer comme ça à plusieurs endroits. Je précise qu'il n'y a pas de problème. Alors certains préfèrent faire ça.
```php
	'Mon prenom est ' . $prenom . ' !';
```
Je précise qu'il n'y a pas de problème. On part du principe comme on va le lire de manière séquentielle, il va d'abord voir qu'il y a des simples quotes qu'il va considérer comme une chaîne ensuite il voit qu'il y a un espace et un point ce qu'il y a concaténation. Ensuite il veut un symbole dollar donc il s'attend à trouver une variable et il remplace la variable prénom par son contenu et puis un nouveau point pour une nouvelle concaténation avec un ! dans une chaîne. Ça se termine fin d'instruction et c'est affiché à l'écran sans problème mais moi personnellement je préfère tout lier ensemble ce qui est plus pratique pour moi personnellement mais certaines personnes préfère éteindre leur variable et mettre bien des espaces partout. Vous pouvez en mettre 15000 si vous voulez ça ne posera pas de problème mais c'est à vous de voir en termes de lisibilité et de questions pratiques au niveau de votre développement. 

Donc là on a vu comment déclarer et créer une variable, comment lui affecter une valeur mais on peut aussi la modifier à n'importe quel moment. il suffit de rappeler la variable, vous remettez l'affectation et puis vous dites que le nombre change. 
```php
<?php
$prenom = "Jason";
echo 'Mon prenom est '.$prenom.' !';

$prenom = "Henri";
echo 'Mon prenom est '.$prenom.' !';
```
Evidemment en faisant un nouvel echo, l'affichage va changer.
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est Jason !Mon prenom est Henri !
```
Et là du coup on peut mettre un petit '<br>' Et pour le coup on va fermer la balise PHP (?>) parce qu'on a mis du code HTML.
```php
	<?php
	$prenom = "Jason";
	echo 'Mon prenom est '.$prenom.' !';

	echo '<br>';

	$prenom = "Henri";
	echo 'Mon prenom est '.$prenom.' !';
	?>
```
Hop et voilà.
```php
$prenom = "Jason";
echo 'Mon prenom est '.$prenom.' !';

echo '<br>';

$prenom = "Henri";
echo 'Mon prenom est '.$prenom.' !';
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Mon prenom est Jason !
	Mon prenom est Henri !
```
Ça ne pose aucun problème, tout l'intérêt encore une fois d'utiliser des variables. 

Imaginez encore une fois sur un jeu vidéo, un nombre de points de vie, un personnage avec des informations qui change, sur un site vous allez pouvoir modifier des variables ça peut être un auteur, ça peut être le contenu d'un article, ça peut être un message sur un forum bref tout un tas d'informations donc c'est absolument indispensable d'utiliser des variables quand on fait de la programmation. 

Sans les variables on pourrait absolument rien faire, c'est vraiment la notion la plus importante qui existe donc c'est vraiment bien à connaître et à bien assimiler pour ne pas avoir de problème. 

Si on veut dire qu'on n'a rien dans une variable, on me traite tout simplement nul soit en minuscule null, soit en majuscule NULL et vous voyez que encore une fois les éditeurs de code bien fait, il vous met le mot dans les bonnes couleurs pour montrer que c'est valide mais si par exemple j'essaie de faire NUL (un seul L), l'éditeur va nous montrer qu'il ne connaît pas en ne mettant pas de couleur donc là coloration syntaxique ça permet de s'y retrouver. Même ça NULl (un seul l en minuscule) fonctionnerais même si c'est très moche ça fonctionnerait quand même de mettre 1L minuscule et 1L majuscule. 

C'est évidemment pas pratique et pas propre donc éviter Alors écrivez tout en minuscule ou alors tout en majuscules mais pas un mélange des 2. En effet ne mélangez pas la manière d'écrire, pareil vous auriez beaucoup de mal à vous relire donc faites attention à ça.
```php
	$prenom = NULL:
	$prenom = null:
```
Alors concernant PHP, je vous ai parlé ici de type certains ont peut être remarqué surtout si vous avez fait d'autres langages comme le langage c, le c++ ou autre qui sont des langages avec un typage strict. Vous voyez comme pour python par exemple, le langage PHP est un langage à typage dynamique c'est-à-dire que vous n'avez pas besoin de mettre une chaîne de caractères string suivi de la variable.
```php
	string $prenom = "Jason";
```
Voilà ce n'est pas obligatoire même si depuis PHP 7 et c'est le cas puisqu'on travaille avec sur cette formation, il y a eu pas mal de changements concernant le typage d'ailleurs on le verra notamment quand on abordera la vidéo sur les fonctions. 

À partir de là, quand il lit de manière séquentielle ça `$prenom = "Jason";` Il est capable de déterminer lui-même ce qu'est "Jason" en voyant les doubles quotes, il en déduit que c'est une chaîne de caractères donc il lui appliquera automatiquement le type string. Et ça tombe bien au niveau de ces variables on va pouvoir vérifier ces informations. 

Pour afficher les informations sur une variable, c'est la fonction var_dump donc une fonction mais je ne vais pas rentrer dans les détails parce qu'on n'a pas encore vu ça. Dites-vous simplement est-ce que c'est simplement une petite boîte de code à l'intérieur qui permet de faire une chose c'est-à-dire qu'elle a une fonctionnalité. Et cette fonction var_dump, son rôle c'est d'afficher les informations d'une variable qu'on lui donne et comment on donne des informations à une fonction, on lui donne dans des parenthèses donc ici on précise la variable. 
```php
	$prenom = "Jason";
	var_dump($prenom);
```
Et je ne rentrerai pas plus dans les détails parce qu'on n'a pas encore vu les fonctions, c'est réservé pour une vidéo prochaine sur la formation. 

Donc en faisant juste ça, on aura toutes les informations de celles-ci. 
```php
<?php
$prenom = "Jason";
var_dump($prenom);
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	string(5) "Jason"
```
On a toutes les informations de celles-ci et regardez ce qu'il marque  "string(5)" donc il vous note le type et il donne même le nombre de caractères et ensuite il vous l'affiche "Jason" donc il vous donne vraiment toutes les informations. 

Si on veut éventuellement récupérer le type, on peut utiliser gettype() mais si vous faites ça...
```php
<?php
$prenom = "Jason";
gettype($prenom);
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
```
Là c'est une fonction qui va retourner quelque chose, elle va retourner en résultat mais comme ce résultat on n'en fait rien, il ne se passe rien donc il faut dire qu'on affiche le retour de cette fonction avec echo donc j'affiche son résultat.
```php
<?php
$prenom = "Jason";
echo gettype($prenom);
```
```powershell
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	string
```
Et là vous voyez le type "string" voilà. 

Et vous verez plus tard il y a pas mal de fonctions pour tester le type d'une variable donc les fonctions je vous donne rapidement les noms mais on le verra de toute façon ce n'est pas grave … il s'agit de "is_..." si l'éditeur est sympa il vous les mets toutes. 
```txt
	is_array()
	is_binary()
	is_bool()
	is_buffer()
	is_callable()
	is_dir()
	is_double()
	...
```
Voilà l'éditeur est gentil, il vous en met pas mal et vous mettez le type de la donnée. Par exemple pour vérifier que c'est un entier c'est is_int() donc on fait comme ceci.
```php
	$prenom = "Jason";
	is_int($prenom);
```
On fait comme ça bien qu'on n'a pas encore vu les conditions mais on aura l'occasion d'en parler par la suite. Vous avez également is_float(), is_string(), is_array(), is_object() et cetera. C'est pareil je ne rentrerai pas dans les détails, sachez juste que ça existe et qu'on aura l'occasion d'en reparler pour les variables. 

Voilà pour les variables, voilà comment les créer, comment leur affecter des valeurs, comment les modifier simplement en faisant une affectation comme on a vu. On a vu comment les afficher, je pense qu'on a fait tout le tour là dessus et on va terminer avec 2 petites choses. 

C'est une vidéo assez longue parce qu'il y a beaucoup de choses à dire dans cette vidéo et puis de  tester du code en même temps mais bon il n'y a rien qui presse prenez le temps de tester aussi de votre côté pour voir que tout fonctionne bien et que vous avez tout compris. 

Alors les 2 petites dernières choses que je voudrais vous montrer, la première c'est le principe de référence mais on ne rentrera pas non plus dans les détails parce qu'il en parle beaucoup de ça quand on fait de l'objet mais pour le moment on travaille sur du procédural c'est-à-dire qu'on va pouvoir créer une variable qui va pointer, qui va faire référence à une autre. 

Et ça fait penser au pointeur d'ailleurs pour ceux qui font du c par exemple ou d'autre langage un peu plus par niveau que PHP. On a ce système là de dire qu'il y a une variable qui vient pointer vers une autre alors comment ça se passe ? Si je fais ceci même si ce n'est pas propre du tout ($a et $b).
```php
	<?php
	$a = "Jason";
	$b = "Henri";
	
	echo $a.'<br>'.$b;
	
	$b = "Toto";
	echo $a.'<br>'.$b;
	?>
```
Voilà et voyons ce qu'il se passe à ce niveau-là.
```php
$a = "Jason";
$b = "Henri";

echo $a.'<br>'.$b;

$b = "Toto";
echo '<br>';

echo $a.'<br>'.$b;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Jason
	Henri
	Jason
	Toto
```
Voilà comment ça se passe : au départ on a la variable A (Jason) et la variante B (Henri). Ensuite je modifie la variable B $b = "Toto"; donc je lui modifie sa valeur, je lui affectent une nouvelle valeur et ça a été effectivement changé. Par contre là variable A quand vous relisez le code on n'a rien fait dessus, on a juste déclaré et initialisé et après on n'a rien fait dessus, on a fait juste que l'affiche. 

En faisant une référence c'est à dire en faisant `$b = &$a;` donc avec le symbole esperluette ou le et commercial suivi de la variable à laquelle on fait référence. La variable B est une référence de la variable A et vous voyez que je ne change rien d'autre et voilà ce qu'il se passe.
```php
<?php
$a = "Jason";
$b = &$a;

echo $a.'<br>'.$b;

$b = "Toto";
echo '<br>';

echo $a.'<br>'.$b;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Jason
	Toto
	Jason
	Toto
```
Le fait de créer une référence, voilà ce qu'il se passe. On voit que au départ les variables sont exactement de même valeur ce qui est logique parce que c'est une référence, on dit que là variable B pointe vers la variable A avec la variable B qui possède du coup la même valeur. Et à partir du moment où je vais modifier la variable B, ça va modifier également la valeur de A comme si c'était des copies liées donc c'est-à-dire que ce ne sont pas des copies distinctes. Et donc si vous modifier A ou B, Eh bien vous allez également modifier l'autre variable que ce soit l'une ou l'autre c'est à dire qu'elles ont le même emplacement mémoire. 

Ici,
```php
	$a = "Jason";
	$b = &$a;
```
.. on n'a pas réservé 2 emplacements mémoire distincts, on a réservé un emplacement mémoire pour la variable A, et un petit emplacement pour B mais pour lui donner un lien, imaginez une chaîne qui se relie à la variable A.

Ce qui fait que quand on va modifier l'un, comme ils sont liés tous les 2, ça va modifier l'autre également donc ça c'est ce qu'on appelle une référence en PHP. C'est une petite chose que je voulais vous montrer en PHP qui pourra dans certains cas vous servir donc on reviendra dessus en détail quand on en aura vraiment besoin mais là vous n'en verrez pas forcément l'utilité mais ça a vraiment son intérêt en programmation. 

I la dernière chose avec lequel nous allons terminer, c'est ce qu'on appelle de manière générale le transtypage ou le cast c'est-à-dire qu'on va pouvoir modifier le type d'une variable en une autre. Par exemple si on écrit ceci et que j'essaie de l'afficher.
```php
<?php
$unFlottant = 16.45;

echo $unFlottant;
```
Voilà ce qu'il va se passer en affiche le nombre sans problème.
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16.45
```
Voilà on affiche le nombre sans problème et admettons que je veux récupérer que sa partie entière c'est-à-dire le 16, je peux dire que je fais un cast, je fais un transtypage vers le type entier parce que $unFlottant est de type float. 

Pour faire un transtypage, vous passez le type nouveau que vous voulez entre parenthèses (int) de la variable avec un espace ou non, (int)$unFlottant ou (int) $unFlottant.
```php
<?php
$unFlottant = 16.45;

echo (int)$unFlottant;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16
```
À ce moment-là vous allez transtyper, faire un cast de votre variable donc voilà comment ça fonctionne et ça peut être pratique dans certains cas. 

Alors attention on peut également passer par des variables intermédiaires et faire comme ça. 
```php
<?php
$unFlottant = 16.45;
$entier = (int)$unFlottant;

echo $entier;
```
```
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16
```
Voilà c'est exactement pareil en terme de code mais attention avec le transtypage parce que si vous essayez de convertir un type vers un type qui n'est pas compatible, vous aurez des résultats assez inattendus. C'est par exemple on essaie de convertir un entier en une chaîne comme ici. 
```php
<?php
$unFlottant = 16.45;
$chaine = (string)$unFlottant;

echo $chaine;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16.45
```
J'actualise et voilà ce qu'il nous met 16.45. On a l'impression que rien n'a changé mais bien oui parce que au début le nombre est considéré comme un flottant et on va pouvoir faire des calculs tout simple avec mais en revanche à partir du cast on a une chaîne de caractères donc le 16.45 que vous voyez affiché là n'est plus un nombre c'est du texte. On affiche du texte 16.45 qui n'est pas un nombre qui pourrait servir à faire des calculs. 

Attention vous voyez que le cast fonctionne et que ça ne pose pas de problème par contre dans certains cas on va éviter les transtypage bizarre par exemple de transtyper quelque chose à NULL (ou "null") ce qui serait assez étonnant de faire ça d'ailleurs. On pouvait le faire avant mais depuis des versions assez récente de PHP, il est même déconseillé de le faire qui est justement entrainait justement des comportements inattendus au niveau de la programmation donc on évitera de faire ça si on veut par exemple supprimer le contenu d'une variable mais pour supprimer le contenu d'une variable on fera ça. 
```php
<?php
$unFlottant = 16.45;
echo $unFlottant;

$unFlottant = NULL;
echo $unFlottant;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16.45
```
Voilà la première fois ça affiche quelque chose mais la 2e fois ça n'affiche rien parce que c'est nul. Le nul ce n'est rien du tout donc ça a effectivement été changé mais on peut également utiliser la fonction unset() donc on va faire ça sur une variable pour dire qu'en fait une variable n'existe plus et là on obtiendra : 
```php
<?php
$unFlottant = 16.45;
echo $unFlottant;

unset($unFlottant);
echo $unFlottant;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16.45
	Notice: Undefined variable: unFlottant in ...
```
Donc le unset() va simplement passer la valeur null à une variable c'est tout simplement ce que ça va faire donc il n'y a pas de problème à ce niveau-là. On peut faire également un var_dump() sur notre flottant.
```php
<?php
$unFlottant = 16.45;
echo $unFlottant;

unset($unFlottant);
var_dump($unFlottant);
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	16.45
	Notice: Undefined variable: unFlottant in ...
	NULL
```
Donc voilà vous voyez que le type est bien NULL par contre il n'y a plus de valeur du tout comme on mit NULL dedans, il vous rebalance le type. Il n'y a plus de valeur du tout parce qu'il n'y a plus de valeur du tout elle a été retirée parce que set() c'est définir la variable et unset() c'est l'enlevé, enlever la définition de la variable. 

Petite fonction à noter aussi, le unset() ça pourra vous servir quand vous voudrez enlever le contenu d'une variable pour vous dire qu'on ne met plus rien dedans. La variable sera bien sûr détruite à la fin de l'exécution du programme de manière tout à fait normale. 

Après j'essaie de voir si je n'ai rien oublié mais si je suis amené à oublier quelque chose de toute façon on va être amené à réutiliser tout et n'importe quoi au niveau de la formation donc tout ce qui aura été oublié là sera de toute façon aborder par la suite donc ce n'est pas un souci notamment les fonctions et pas mal de choses qu'on pourra réutiliser mais moi je vous ai donné tout ce qu'il fallait par rapport à ça. 

Moi aussi je ne vous ai pas dit mais pour caster en int (ou integer) normalement les 2 fonctionnent. Pour le booléen, vous pouvez utiliser (boolean) ou (bool). Et pour float, vous pouvez utiliser (float), vous pouvez utiliser (double) donc la fameuse notation historique et il y a également la notation (real) qui normalement doit fonctionner encore.
```php
	/*
		4 types scalaires :
			Booléen (boolean, bool) 		: vrai (true) | faux (false)
			Entier (integer, int)			: 14, -126, 12300
			Flottant (float, double, real)	: 3.14, -12.62
			Chaîne de caractères (string)	: 'bonjour', "bonjour tout le monde"
			
		4 types composés :
			Tableau (array)
			Objets (object)
			Fonctions de rappel (callable)
			Iterateurs (iterable)
		
		2 types divers :
			Ressource (ressource)
			NULL (ou "null")
	*/
```
Normalement ça doit fonctionner encore par exemple si vous faites comme ceci.
```php
<?php
$nombreEntier = 14;
echo $nombreEntier;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	14
```
On peut très bien le faire sur lui-même, le caster sur lui-même. Pareil c'est une vielle notation mais ça fonctionne aussi. Et pour le coup ce n'est plus un nombre entier parce qu'on travail sur un réel et un réel c'est un nombre décimale donc un nombre flottant.
```php
<?php
$nombre = 14;
echo $nombre;

$nombre = (real) $nombre;
echo $nombre;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Deprecated: The (real) cast is deprecated, use (float) instead in .. on line 853
	1414
```
Voilà ça fonctionnera aussi à ce niveau-là, on a transformé le type de la variable donc ça peut être utile à ce niveau-là. On peut le noter comme ceci par exemple.
```php
<?php
$nombre = 14.54;
echo $nombre;

$nombre = (real) $nombre;
echo $nombre;
```
```txt
	C:\MyWAMP\apache\bin\httpd.exe
	http://localhost/PHP/cours/006_variables_et_types/
	Deprecated: The (real) cast is deprecated, use (float) instead in .. on line 853
	14.5414.54
```
Voilà donc il faudra voir par rapport à ça comment ça s'est passé mais en général on va surtout noter (float) pour le transtypage mais attention avec le transtypage parce que ça risque de vous amener pas mal d'erreurs donc ce n'est pas à utiliser à la légère, je vous le montre parce qu'il faut le connaître et que ça concerne les variables mais à ne pas utiliser n'importe comment. 

Dans certains cas d'ailleurs on évitera d'utiliser le transtypage et on passera par des fonctions à la place pour obtenir en entier d'un nombre, on utilisera la fonction intval() comme fonction mais on aura l'occasion de revenir dessus par la suite donc il n'y aura pas de soucis à ce niveau-là. 

Je crois qu'on a fait un peu le tour de tout ce que je voulais vous montrer, je vous ai présenté encore une fois pour résumer encore une fois cette vidéo parce qu'elle est déjà assez long comme ça donc ce n'est pas pour 5 minutes de plus. Je vous ai présenté 10 types basiques que vous allez manipuler 4 types scalaires qui sont un peu tout ce que nous allons manipuler et avec lequel nous allons travailler sur une grosse partie de la formation, avant d'aborder les 4 types composés par exemple pour les tableaux il y aura une vidéo, pour les objets il y aura plusieurs vidéos parce que pour la programmation objet il y aura plus d'une vidéo ça c'est sûr. Le fonctionne rappel on les abordera peut-être même pas dans le cours, peut-être même juste dans des tutos. Les itérateurs c'est pareil. Pour les types divers, on a déjà parlé de NULL et en ce qui concerne Ressources, pareil ce sera sûrement dans un tuto en annexe donc pas pour tout de suite dans tous les cas. 

Au moins vous savez comment ça fonctionne. Vous savez à la fin de cette vidéo ce qui est une variable, à quoi ça sert et comment on peut en créer, comment on peut les déclarer, quelle valeur on peut leur mettre, comment on peut les modifier c'est-à-dire enlever leur définition (je vous ai montré ça aussi), comment les afficher ? et voilà, vous avez déjà pas mal de choses à faire avec au niveau de ça. 

Dans les prochaines vidéos, on va continuer de toute façon un petit peu là-dessus, on va travailler sur d'autres notions.  On va voir également comment travailler sur des opérations, utiliser des opérateurs pour faire tout un tas de choses avec nos variables parce que vous vous verrez qu'au lieu de mettre tout simplement des valeurs comme ça et les afficher, on pourra également faire des calculs, faire des opérations très très spécifiques par rapport à nos variables donc c'est possible de faire toutes ces choses-là donc on verra ça dans les prochaines vidéos de cette formation.

J'espère que ça vous a plu et il y avait beaucoup beaucoup de choses à voir mais encore une fois vous avez la possibilité de mettre en pause une vidéo, ce n'est pas comme si vous étiez en cours donc vous n'êtes pas embêté en terme de temps ou autre, vous avez absolument moyen de travailler dessus, de voir les vidéos à votre rythme et de prendre des notes que vous voulez, de tester les programmes sur le côté si vous avez par exemple besoin de faire un programme à chaque vidéo pour résumer un peu tout ce qu'on avait pour vous rappeler un peu de tout et ça ne peut que vous aider. 

N'hésitez pas c'est bien sûr vous avez des questions des choses qui ne sont pas suffisamment clair parce qu'on a beau expliquer expliquer, des fois ce n'est pas assez et il en faudrait un peu plus et vous pouvez vous tourner vers les commentaires comme d'habitude et je vous répondrai par-dessus. 

Du coup je vous dis à bientôt pour la prochaine vidéo, on continuera à travailler là dessus avec de nouvelles notions. 

À bientôt tout le monde. 

Ciao