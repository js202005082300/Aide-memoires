# [19. Fonctions dates et heures](https://www.youtube.com/watch?v=hLY7cBnFoPQ)
05-01-2021

Bonjour à tous, bienvenue pour cette 19e séance en sql.

Pour cette vidéo nous allons regarder ensemble quelques fonctions qui sont assez courantes au niveau utilisation et manipulations de date et d'heure.

On a pas mal de choses à voir là dessus la petite particularité encore une fois chaque fonction est propre à un système de gestion de base de données.

Certains sgbd utilisent des fonctions similaires et d'autres complètement pas, vous allez avoir certaines fonctions disponibles sur mysql qui ne sont pas sur oracle et inversement.

Bien évidemment comme je le fais à chaque fois pour ce genre de séance dans la description de la vidéo vous aurez un lien vers une page de mon github qui va vous proposer un tableau qui sera mis à jour au fur et à mesure, je le fais pas forcément à chaque fois mais ça va être mis à jour petit à petit pour avoir quelque chose de très complet et vous aurez comme ça chacune des fonctions qui me semblent intéressants avec également des fonctions que je n'aurais pas forcément abordé en vidéo sur les manipulations de date et d'heure sur différents systèmes de gestion : sqlite, postgressql, microsoft sql server, oracle, etc.

On va passer ensemble maintenant sur quelques exemples que je peux vous montrer donc comme d'habitude cette vidéo moi j'ai sous la main un sgbd mysql, c'est celui qu'on a utilisé en majorité pour cette formation sql mais vous pourrez bien sûr vous servir de certaines fonctions pour les adapter selon le sgbd que vous utilisez.

Dans tous les cas les fonctions que je vous montrer se feront sur mysql.

On va passer directement par le client donc je suis directement connecté sur mon client mysql, je ne vous ai pas fournis ici de fichiers sql de données il n'y a pas forcément besoin par rapport à ce que je vous montrer on pourra directement faire ça en ligne de commandes.

Vous pouvez bien évidemment testé après ces différentes fonctions sur des données, sur des tables, sur les enregistrements il n'y a aucun souci.

C'est d'ailleurs prévus pour çà à longue l'intérêt de ces fonctions c'est de s'en servir après dans des requêtes avec tout ce que vous avez pu apprendre en sql jusqu'à présent.

On va commencer par une première chose déjà qui est important je pense de souligner c'est tout ce qui concerne le format c'est à dire qu'on se représente des données très facilement rappelez vous on peut représenter des entiers par des nombres, on peut représenter par exemple une chaîne de caractères sous ce format "bonjour" ou en utilisant simple cote comme ceci 'bonjour' d'accord donc ça c'est les chaînes de caractères.

Et on peut se poser la question de comment représenter une date, on va beaucoup travailler avec des chaînes de caractères, on va par exemple pouvoir avoir une date que l'on convertira en tout cas dont on pourra obtenir un formatage pour obtenir une chaîne et éventuellement inversement d'accord on aura des fonctions par exemple qui permettront de faire l'inverse.

La première fois à savoir en tout cas au niveau des dates c'est le format que l'on va pouvoir appliquer par exemple comment on va pouvoir ce qu'on travaille quand même en informatique désigner un symbole qui définira le numéro du mois, le jour de la semaine, le numéro de l'année ce genre d'information ou par exemple le nombre d'heures, les minutes, les secondes, etc.

On a plusieurs formats, autre problème aussi c'est que ces formats ne sont pas forcément conventionnel ou en tout cas standardisés c'est pas par exemple un symbole qui désignera la même information sur tous les systèmes de gestion de bases de données.

Là aussi vous trouverez toutes les informations par rapport à ce que je vous donnerai dans la description si vous voulez aller le consulter pour avoir un maximum d'informations à ce sujet mais en gros pour mysql puisque c'est ce que je vous montrer on va désigner les choses avec un pour cent d'accord les informations avec un %.

En mettant un % suivi du symbole %d en minuscule attention c'est très important, on va désigner par exemple le numéro du jour par exemple si je met le premier la 1er mars donc 01 on utilisera ce symbole %d pour l'extraire, en tout cas l'avoir d'accord pour formater cette information là.
```txt
	%d -> 01
```
On va voir également une autre information très importante qui est le mois donc le mois ça peut par exemple être le mois de mai, on mettrait 05 d'accord.
```txt
	%d -> 01
	%m -> 05
```
Et pour l'année on va mettre un Y majuscule alors je ne vais pas vous montrer tous les symboles parce qu'il en existe plusieurs et d'autant que ces symboles vont différer sur un autre sgbd, vous n'aurez pas forcément les mêmes informations.
```txt
	%d -> 01
	%m -> 05
	%Y -> 2020
```
Là on va avoir en fait les 4 sigles digitaux qui représente une année parce qu'on pourrait très bien représenté une année sous 2 seulement mais à ce moment là on va utiliser autres choses.
```txt
	%d -> 01
	%m -> 05
	%Y -> 20
```
si je dis pas de bétise pour le MySQL c'est le y minuscule pour ça.

Peu importe on va désigner ça comme ça, moi je vais montrer en tout cas ces trois là qui sont les plus usitées et on va ensuite avoir de quoi représenter le temps donc en gros on va voir %H majuscule pour l'heure donc l'heure définie sur une période de 24 heures d'accord donc ça va du coup de 0 à 23 même plus exactement parce qu'on part toujours de 0.
```txt
	%d -> 01
	%m -> 05
	%Y -> 20
	
	%H
```
On va avoir le %i, c'est un i minuscule donc ça c'est pour les minutes.
```txt
	%d -> 01
	%m -> 05
	%Y -> 20
	
	%H
	%i
```
Or pourquoi c'est un i pour représenter les minutes passent que le m est déjà réservé pour les mois. Le M majuscules minuscules c'est pour les mois donc comme on avait la même lettre, ils ont choisi le i et pour les secondes on va avoir le %S parce qu'on manipule les secondes complète donc de 0 à 59 secondes.
```txt
	%d -> 01
	%m -> 05
	%Y -> 20
	
	%H
	%i
	%S
```
Voilà ça c'est des formats qu'on va pouvoir retrouver ils vont servir un petit peu plus tard sur d'autres systèmes, vous allez retrouver d'autres formats par exemple pour les années il y a d'autres systèmes qui vont utiliser 4 y comme ça ou même en minuscule d'accord.
```txt
	%d -> 01 (DD)
	%m -> 05
	%Y -> 2020 (yyyy)
	
	%H
	%i
	%S
```
Ca va être différent pour les jours on va avoir comme ça DD mais là c'est pas forcément un symbole utilisé avec un % c'est une valeur textuel càd sous forme de chaînes de caractères pour certains sgbd quand vous allez écrire ça "yyyy" d'accord comme une chaîne de caractères, il va le représenter par une année. On va pouvoir formater des dates pour obtenir par exemple l'année d'une date.

Donc ça peut sembler un petit peu compliqué tout ça à retenir et puis à connaître et bien sûr ce sera à vous de voir en fonction du sgbd que vous utilisez quels sont les formats à connaître d'accord d'identification pour le formatage des dates et des heures et de pouvoir éventuellement s'en servir pour quelques fonctions que vous avez pour votre sgbd.

Donc je voulais faire une petite parenthèse là dessus mais on reviendra très rapidement après par rapport à ces différents formats là.

Première information qui peut être intéressante à voir pour nos différentes dates et heures c'est en fait la date actuelle par exemple vous voulez effectuer un enregistrement dans une base de données ...  je ne sais pas vous avez écrit un article ou quelqu'un a déposé un message sur un forum, sur un chat ou n'importe quoi, vous voulez dater l'enregistrement, dater la publication, le moment où l'enregistrement a été fait dans la base de données.

On a une fonction très simple en mysql en l'occurrence et postgressql la propose aussi donc c'est pas une fonction standard sql mais elle disponible sur ces 2 sgbd qui est la fonction NOW() comme ceci.

Très simplement c'est pour ça que je n'ai pas besoin de travailler sur des données alors je vais dans le teminal client ici et je fais select now() comme ceci et là ça me retourne la date sous ce format.
```sql
SELECT NOW();
```
```sql
	mysql> SELECT NOW();
	+---------------------+
	| NOW()               |
	+---------------------+
	| 2021-01-06 00:10:50 |
	+---------------------+
	1 row in set (0.00 sec)
```
Là c'est important parce qu'il faut comprendre que par défaut en sql on travaille sous ce format là.

On à l'année sur quatre chiffres d'accord, on a un tiret et on a le mois sur deux chiffres, un tiret et le jour sur deux chiffres.

Ensuite nous avons un espace, l'heure d'accord donc sur deux chiffres parce que c'est un format 24 heures, deux points, les minutes, deux points et les seconds ok.

Donc là on voit qu'on a la date tout de suite.

Si je refais la même commande maintenant évidemment le temps change.
```sql
	mysql> SELECT NOW();
	+---------------------+
	| NOW()               |
	+---------------------+
	| 2021-01-06 00:20:40 |
	+---------------------+
	1 row in set (0.00 sec)
```
Encore le temps s'est écoulé depuis donc ça c'est pour récupérer la date et l'heure actuelle d'accord c'est le timestamp actuel pour avoir le bon moment où on exécute la commande, la bonne date c'est ce genre d'informations qu'on utiliserait pour faire un enregistrement par exemple dans une base de données en voulant mettre la date.

Plutôt que de s'embêter avec un langage de programmation pour utiliser des fonctions ou formater celles ci mais on utilise directement une fonction sql pour le faire et on enregistre l'information en base de données.

Voilà donc c'est bien c'est à bien à savoir et c'est bien de connaître cette information là.

Très rapidement mais je ne le ferai pas forcément pour tous les autres puisque vous le retrouverez en descriptions de vidéos, vous avez par exemple pour oracle SYSDATE().

SYSDATE() c'est ce qu'on va utiliser à la place de NOW() pour récupérer l'information donc le timestamp actuel.

On a également postgressql par exemple qui va travailler sous cette forme là.
```sql
	DATE('now')
```
Il y a une fonction qui s'appelle DATE() et on utilise un identificateur sous forme de chaînes de caractères c'est un petit peu ce que je vous ai dit tout à l'heure avec les formats et quand vous mettez le mot NOW(), il va chercher en fait simplement la date actuelle et il vous retournera le timestamp par rapport à ce qu'il y a actuellement.

Ensuite alors c'est aussi disponible pour Oracle si je ne dit pas de bêtises mais pour sql server on va avoir GETDATE() d'accord sous ce format.
```sql
	GETDATE()
```
Voilà donc que ça c'est Oracle qui propose aussi parce qu'il voulait justement avoir de la compatibilité avec un système microsoft sql server donc on retrouve comme ça certaines similitudes mais vous voyez que chaque sgbd un petit peu sa fonction et sa manière de faire donc ce n'est pas toujours pratique.

Et là pour la première fonction que je vous montre chaque sgbd a sa fonction différente.

N'hésitez pas bien sûr à vous renseigner là-dessus, à regarder ce que je vous fournis en ressources, en information pouvoir l'adapter au sgbd que vous utilisez si vous ne vous servez pas en tout cas de mysql.

Ca c'est la première chose que je voulais vous montrer alors encore une fois comme on ferait un enregistrement comme vous l'avez déjà vu par exemple si vous faites un INSERT INTO une table alors je vais très très vite d'accord on va mettre VALUES() et dans les informations que vous passer si vous avez en premier, je ne sais pas moi, une information textuelle peu importe d'accord pour un enregistrement d'article, un auteur par exemple et ensuite la date de publication de cet article et bien on passerait tout simplement la fonction now() en mysql pour avoir directement tout ça.
```sql
	INSERT INTO ''
	VALUES
	('bonjour', 'Tom', NOW());
```
Pas besoin nous mêmes de marquer en fait la date et dire c'était en 2020 et cetera et cetera donc on utilise des fonctions pour faire ce genre de choses là, c'est bien plus pratique.
```sql
	INSERT INTO ''
	VALUES
	('bonjour', 'Tom', '2020-02-13');
```
Voilà pour cette première fonction que je vous montre comment récupérer à date et heure actuelle c'est une première information qu'on peut avoir.

Autre information qui peut être intéressante de faire que tous les sgbd ne proposent pas forcément ou alors il faut passer par d'autres fonctions à peu un peu exotique on va dire c'est de l'extraction d'informations.

Comment par exemple partir d'une date où je peux obtenir simplement le jour ou simplement le mois, l'année et l'heure ou bref tout un tas d'informations.

Pour mysql ou sql server, on peut utiliser des fonctions qui porte le nom par rapport à ce que vous voulez extraire donc si je fais par exemple select day() et en paramètre vous mettez une date alors moi je met une valeur écrite en dur, une valeur littérale, vous vous pouvez bien sûr passer par la colonne d'un champ si vous aussi vous voulez prélever l'information depuis un enregistrement aux bases de données.

Comme je n'utilise pas d'enregistrement pour vous montrer des exemples je notes de manière littérale une date par exemple je veux le jour de cette date là '2020-02-13'.
```sql
SELECT DAY('2020-02-13');
```
D'accord le 13 février 2020 cette information là, logiquement il m'est sencé me retourner le numéro du jour, je fais ça et voyez qu'on récupère le 13.
```sql
	mysql> SELECT DAY('2020-02-13');
	+-------------------+
	| DAY('2020-02-13') |
	+-------------------+
	|                13 |
	+-------------------+
	1 row in set (0.02 sec)
```
D'accord on a la même chose pour un petit peu tout pour month, pour year, pour l'heure, minutes, secondes si bien sûr elles sont indiquées dans l'information que vous mettez ici.
```sql
SELECT DAY('2020-02-13');
SELECT MONTH('2020-02-13');
SELECT YEAR('2020-02-13');
SELECT HOUR('2020-02-13 15:12:30');
SELECT MINUTE('2020-02-13 15:12:30');
SELECT SECOND('2020-02-13 15:12:30');
```
Toujours sous ce format en gros date et heure, ce genre d'informations là on peut récupérer après les différentes informations que l'on veut alors ça va dépendre aussi du sgbd ce n'est pas forcément disponibles.

En particulier on travaille soit sur le jour, soit le mois et l'année d'accord pour les autres fonctions pour les minutes, secondes et cetera c'est à voir aussi selon le système ce n'est pas forcément compatible et disponible partout.

Voilà donc pas évident encore une fois toujours pareil d'aborder les fonctions sql parce qu'il existe tout un tas de fonctions différentes, il n'y a pas genre un organisme qui a décidé de standardiser quelque chose et tout les sgbd ne respectent pas forcément les standards ou ne se contente pas seulement des standards ils proposent eux mêmes leur propre fonction et c'est ça aussi que certains certains vont préférer utiliser mysql, d'autres oracle, d'autres postgressql en fonction des choses qu'il y a en plus en supplément sur ces différents sgbd et de ce qui peut intéresser en fait chaque utilisateur ou chaque développeur ou administrateur de base de données tout simplement.
 
Voilà pour cette petite information qui était importante à savoir pour d'autres systèmes, on en a parlé très rapidement parce que je ne peux malheureusement pas pour le coup vous les montrer à l'exécution et par exemple pour oracle et peut être pour postgressql propose la même aussi et si vous avez ces sgbd installés sur votre machine, vous avez la fonction EXTRACT() , ça c'est chez Oracle c'est sûr mais il me semble que postgressql propose la même aussi mais là pour le coup j'ai un doute.
```sql
	EXTRACT()
```
Vous utilisez EXTRACT() et vous lui passer l'information que vous voulez récupérer donc je ne sais pas moi par exemple ça va être MONTH comme ceci, from timestamp '' d'accord et vous lui passez ensuite la date directement sous forme de chaînes donc c'est un peu comme ce qu'on avait fait par exemple tout à l'heure selon l'information là.
```sql
	EXTRACT(MONTH FROM TIMESTAMP '2020-03-15')
```
Et ça va vous extraire le mois depuis ce timestamp ici '2020-03-15' d'accord qui est en valeur littérale ou qui peut être également une colonne par exemple dans une table en base de données, encore une fois c'est fait pour ça moi je montre avec des valeurs littéral comprenez que ce sont des fonctions à utiliser bien sûr aussi sur des colonnes voilà des champs, de colonnes de base de données, de différentes tables.

Voilà pour ces différentes fonctions EXTRACT() etc on va voir des noms qui diffèrent selon les cas.

Ca c'est ce que je voulais montrer ici, je veux montrer une troisième fonction après on terminera sur le format donc je ne veux pas vous montrer énormément énormément de fonctions différentes, il y a quand même des choses qui ne sont pas forcément très utilisé mais moi je vous montre ce qui me paraît le plus le plus important et vraiment l'essentiel par rapport à ça et vous pourrez voir en fonction si vous avez besoin de d'utiliser d'autres fonctions bien particulière pour des traitements très spécifiques.

Une autre chose qui peut être intéressante à faire c'est de calculer une différence de date c'est que fois ça peut servir par exemple vous avez posté un article et à un moment donné vous le mettez à jour et vous avez besoin de savoir du coup l'ancienneté de l'article ou pour un utilisateur. Un utilisateur vous avez sa date d'inscription et vous avez sa date de dernière connexion, si vous voulez savoir l'ancienneté de vos utilisateurs depuis combien de temps ils sont inscrit sur votre site, ça peut être des informations intéressantes à récupérer càd de faire une différence en fait entre deux dates.

En mysql c'est très simple c'est tout attaché c'est  DATEDIFF() et ça va vous faire donc la soustraction d'accord la différence entre ce que vous mettez en première date et ce que vous mettez en seconde alors moi comme je vais le faire directement ici je faire sur un select bien sûr et je fait ça.
```sql
SELECT DATEDIFF('2020-02-17', '2019-11-16');
```
D'accord il va faire cette date '2020-02-17' - cette date '2019-11-16' et par défaut parce que mysql c'est le comportement qu'a cette fonction en mysql, il va vous faire en fait le calcul la différence sur le nombre de jours donc je fais ça.
```sql
	mysql> SELECT DATEDIFF('2020-02-17', '2019-11-16');
	+--------------------------------------+
	| DATEDIFF('2020-02-17', '2019-11-16') |
	+--------------------------------------+
	|                                   93 |
	+--------------------------------------+
	1 row in set (0.02 sec)
```
Et là il me dit voilà qu'entre ces deux dates, il y a une différence de 93 jours ça donne comme ça l'ancienneté donc la différence entre les deux dates donc c'est assez limité pour le coup sql de ce qu'ils proposent sur ce type de fonction mais pour d'autres sgbd vous avez éventuellement possibilité de faire une différence et d'obtenir un résultat par rapport à l'information que vous voulez précisément.

Est-ce que vous voulez obtenir comme résultat la différence en nombre de jours, en nombre de secondes, en nombre d'heures, en nombre de mois etc etc.

Vous pouvez travailler différemment selon l'information.

postgressql par exemple propose alors un peu sous ce format aussi propose lui une fonction qui s'appelle AGE() tout simplement.
```sql
	SELECT AGE('2020-02-17', '2019-11-16');
```
Vous pouvez passer deux informations il n'y a pas de problème d'accord pareil, vous ferez la soustraction entre les deux.

Pour d'autres systèmes, vous avez possibilité de travailler directement avec un timestamp alors il y a TIMESTAMPDIFF() pour oracle par exemple mais en gros peu importe encore une fois je ne peux pas vous montrer l'utilisation de ces fonctions beaucoup, je me concentre principalement sur mysql.

En gros vous allez avoir TIMESTAMPDIFF().
```sql
	SELECT TIMESTAMPDIFF()
```
Et en gros vous allez pouvoir spécifier l'information à extraire d'accord càd que ce n'est pas seulement une première date et une deuxième, vous avez aussi l'information que vous voulez extraire.

D'ailleurs par exemple ici si on veut reproduire un comportement de DATEDIFF() en sql en mysql, vous précisez que vous voulez récupérer le jour et ensuite vous mettez votre première date ici et ensuite vous mettez la seconde.
```sql
SELECT TIMESTAMPDIFF(DAY, '2020-03-15', '2020-05-16');
```
D'accord et ça va faire la différence entre ces deux dates et extraire cette information DAY pour en fait vous retourner ce résultat là donc ça c'est du oracle principalement donc on a un petit peu toutes ces informations là qui sont intéressantes à récupérer d'accord.

Pour sql server ou pour microsoft propose également DATEDIFF() parce que microsoft propose la même fonction que mysql mais eux justement propose cette troisième information càd que ce n'est pas seulement une différence entre deux dates pour récupérer la différence en jour mais vous pouvez également passer voilà il y a un troisième  argument disponible pour microsoft sql server (DAY) pour avoir tout simplement l'information que vous voulez récupérer.
```sql
	SELECT DATEDIFF(DAY, '2020-03-15', '2020-05-16');
```
La différence est exprimé en secondes, en jours, en mois, en année ou que sais-je par rapport à l'information à récupérer donc ça très important à faire des différences comme ça sur les dates.

C'est quelque chose qu'on a besoin de faire assez souvent mine de rien quand on manipule des bases de données donc je tenais à vous parler un petit peu de ces fonctions là.

Voilà et on passe du coup à un passage qui est très important c'est tout ce qui est formatage de date puisque vous allez peut-être être amené mais pas forcément tous mais c'est possible que vous utilisiez sql ou dans le cadre d'un langage de programmation d'accord pour extraire des données càd que soit vous travaillez directement sur sql pour faire des statistiques ou vous travaillez voilà tout simplement pour récupérer des données, les trier, travailler juste directement dessus.

Soit vous passez par un langage pour utiliser ces données dans une application, sur un site web ou autre.

Et on a très souvent besoin surtout qu'à la base sql travail avec des dates, on va dire en format anglais, de travailler avec d'autres types de formatage ou en tout cas associés des dates sql dans un format qui sera compatible avec un format utilisé dans un langage de programmation pour avoir en fait des informations cohérentes entre elles.

C'est là qu'on retrouve finalement et bien le formatage des informations.

Ce formatage du coup est disponible sur plusieurs sgbd pas encore une fois avec les mêmes fonctions d'accord on va voir pas mal de différences mais en gros on va avoir ça sous cette forme :
```sql
	-- Fonctions : dates et heures
	
	-- MySQL
```
Ca je vais prendre le temps d'expliquer un peu sur plusieurs sgbd parce que ça quand même son importance où je prendrai un peu le temps encore une fois je pourrais vous faire la démonstration pour mysql sous vos yeux et pour les autres ce sera à vous de tester de votre côté et si jamais voyé par exemple je vous dis une erreur, que j'ai laissé une coquille ou je vous ai dit quelque chose qui n'était pas forcément bon concernant une fonction tout ça pour oracle, pour ms sql, n'hésitez pas en commentaire à le relever.

Je n'ai pas forcément ces systèmes installés de mon côté donc je peux pas forcément tous tester non plus.

Voilà c'est par rapport à ce que je sais, ce que j'ai pu apprendre mais je peux me tromper évidemment donc n'hésitez pas à me dire si le je me suis trompé dans un nom de fonction pour oracle ou autres bien sûr pour qu'on puisse comme ça corriger si jamais il y a une petite coquille qui s'est glissée dans la vidéo.

Alors pour mysql, on va travailler avec la fonction DATE_FORMAT et le underscore c'est plus pour le format pour les fonctions MySQL plutôt que le format tout attaché pour sql server.
```sql
	-- Fonctions : dates et heures
	
	-- MySQL
	DATE_FORMAT()
```
On fait du coup DATE_FORMAT() et là on va pouvoir avoir deux informations. La première information c'est la date en elle-même donc pareil soit une colonne d'une table soit directement une date littérale moi je vais le faire de manière littérale encore une fois, par exemple cette information là '2020-12-06' et je choisi ensuite un format ici par rapport à cette première date ici càd quel format je veux obtenir pour cette date là. Et bien sûr il faudra le faire sur un select sinon je n'aurais pas d'affichage à vous montrer.
```sql
	-- Fonctions : dates et heures
	
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06', '')
```
Et là je vais pouvoir reproduire finalement les formats que je vous ai montré précédemment càd les fameux %d, %m et cetera.

Si je veux une date un peu à la française par exemple je pourrais noter carrément mettre ça voilà.
```sql
	-- Fonctions : dates et heures
	
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', '')
```
Voilà et de dire une date un peu plus français d'accord dans un format un peu plus français, ben moi je vais l'écrire comme ça, le jour, un slash, le mois avec un m minuscule pour mysql ensuite un Y majuscule si je veux les quatre chiffres de l'année et par exemple je mets une virgule, un espace parce que j'ai envie, je peux mettre un texte ça peut être ceci par exemple.
```sql
-- Fonctions : dates et heures
	
-- MySQL
SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
```
```sql
	mysql> SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	+----------------------------------------------------------------+
	| DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S')  |
	+----------------------------------------------------------------+
	| Le 06/12/2020, à 14:07:23                                      |
	+----------------------------------------------------------------+
	1 row in set (0.02 sec)
```
Et logiquement de toute façon s'il y a une erreur voilà il va bien nous le dire.

Normalement c'est bon voyez le 06 12 2020 à 14h07 et 23 secondes d'accord donc on a comme ça le formatage que l'on veut d'accord c'est beaucoup plus lisible et c'est pas mal pratique si par exemple après vous voulez récupérer une date depuis une base de données pour l'utiliser par exemple avec un langage de programmation pour un site, pour une application et bien vous pouvez directement faire une requête pour récupérer une date, une information datée et vous appliquez un formatage via une fonction que propose votre sgbd et c'est cette information là que vous récupérez directement avec votre langage de programmation et ça peut éviter certains traitements supplémentaires et des fois même apporter un petit coup de on va dire d'optimisation, de rendre les choses un peu plus optimale par rapport à ça.

Pas mal d'importance et pas mal d'utilité mine de rien avec ce type de fonction parce que le formatage, vous en aurez besoin très souvent.

Encore une fois tous les symboles ici, je ne vous ai pas tout montrés et il en existe pas mal d'autres par exemple pour récupérer le jour ou le jour même sous forme littérale càd sous forme écrite saterday, sunday, et cetera plutôt que d'avoir le numéro donc il a pas mal d'autres symboles ici donc n'hésitez pas aussi à retrouver tous ces symboles par rapport à ce que vous voulez formater.

La manière dont vous voulez formater vos dates.

Pour les autres sgbd alors au niveau des noms, on va commencer par qui ? On va commencer par Oracle c'est un des plus gros aussi, on va voir postgressql si je peux vous parler, on a SQLite et SQL Server.
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	
	-- Oracle
	
	-- PostgreSQL
	
	-- SQLite
	
	-- SQL Server
```
voilà pour oracle, ça va être TO_CHAR(). Pareil pour Oracle, vous avez le format donc en gros la date donc c'est comme si je prenais ça '2020-12-06 14:07:23' en fait donc je ne vais pas mettre des valeurs parce que je ne peux pas les tester donc en fait ça vous remplacé par une date. 
```sql
	TO_CHAR(<date>, <>)
```
Ici vous allez en fait avoir une forme textuelle d'accord càd une information textuelle donc qu'est-ce que j'entends par ça ? je vais mettre format et un format ça va être une information donc pour oracle je crois que c'est par exemple DD/MM/YYYY, pour les années je ne sais pas si c'est des y majuscules ou minuscules, je ne sais plus honnêtement.
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	
	-- Oracle
	TO_CHAR(<date>, <format>) -> DD/MM/YYYY
	
	-- PostgreSQL
	
	-- SQLite
	
	-- SQL Server
```
Mais en gros par exemple voilà vous allez plutôt utiliser ces symboles là %d/%m/%Y d'accord comme on le ferait en mysql.

Dans certains langages de programmation d'ailleurs par exemple php, on peux retrouve pas mal de choses similaires aussi hé bien on utilise un peu ce format là d'accord on va extraire ici le jour DD, le mois MM, l'année YYYY et cetera et cetera.

Je ne vais pas vous faire tout le détail et en gros voilà un peu comment ça fonctionne.

Pour les pour heure par exemple ça doit être HH24 voilà c'est un peu compliqué là dessus, tout un tas de choses, on doit avoir MI pour minutes et secondes je crois que c'est un SS.

C'est donc à voir, je peux peut être me tromper pour les autres sgbd mais c'est pas grave en soit parce que de toute façon vous aurez qu'à vérifier et vous serez sûr d'avoir les bons formats par rapport au sgbd que vous utilisez donc en gros je vous mets ça mais sans certifier à 100% que ceci est bon mais je pense que si, HH24:MI:SS.
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	
	-- Oracle
	TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS
	
	-- PostgreSQL
	
	-- SQLite
	
	-- SQL Server
```
Pour Oracle en tout cas d'accord cette fonction là est bien à connaître.

Pour postgressql, lui c'est la même chose en fait il utilise tout pareil mais après il utilise le même format c'est pareil TO_CHAR().
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	
	-- Oracle & PostgreSQL
>	TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS
	
	-- SQLite
	
	-- SQL Server
```
C'est preil, PostgreSQL a énormément de systèmes que je ne vous montrerai pas forcément en vidéo mais on peut aussi permettre manipuler les dates et des heures. On peut par exemple ajouter une heure à une date, on peut ajouter des périodes de temps également à une date et cetera donc on a énormément de choses bien sûr moi je ne peux pas malheureusement tout vous montrer c'est juste pas possible mais il y a plein plein de trucs intéressants qu'on peut faire au niveau manipulation dates et heures donc tout dépend après du sgbd que vous utilisez parce qu'encore une fois ce n'est pas quelque chose qui est générale à tous mais qui va être très très spécifique à un système de gestion de base de données en particulier pas forcément pour les autres.

C'est d'ailleurs très très souvent, c'est même pas disponible pour les autres non plus.

En tout cas SQLite ça change puisqu'il a une fonction qui s'appelle strftime() voilà format time que je ne mélange pas les pinceaux et lui c'est l'inverse.
```sql
	STRFTIME(<format>, <>)
```
On a la valeur donc le format à passer en premier argument et la date c'est le deuxième argument d'accord pour cette petite fonction là donc à vous aussi de voir.
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
	
	-- Oracle & PostgreSQL
	TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS
	
	-- SQLite
>	STRFTIME(<format>, <date>)
	
	-- SQL Server
```
Et pour sql server c'est directement FOMAT(), je crois qu'ils ont fait plus simple c'est pas tout. Ils ont peut-être en tout cas de la compatibilité entre oracle et sql server avec Oracle qui propose des nommages assez similaire à sql server pour créer une couche de compatibilité avec l'autre donc à voir.

Et là pareil donc FORMAT() c'est la date donc on rejoint ce format là en fait DATE_FORMAT() et un deuxième argument le format.
```sql
	-- Fonctions : dates et heures
		
	-- MySQL
	SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');

	-- Oracle & PostgreSQL
	TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS

	-- SQLite
	STRFTIME(<format>, <date>)

	-- SQL Server
	FORMAT(<date>, <format>) 
```
Voyez selon le sgbd, les arguments sont inversés ce n'est évidemment pas les mêmes noms de fonction, les symboles utilisés pour le formatage que l'on veut récupérer pour nos dates ne sont pas les mêmes non plus, certains pour qui c'est pareil, pour d'autres non donc tout ça voilà ça sert à rien évidemment de vous énumérer chaque symbole pour chaque sgbd, ce serait plus confus qu'autre chose pour faire une petite séance comme ça sur des fonctions de manipulation de date et d'heure donc je voulais voir en tout cas l'essentiel par rapport à ça.

Alors oui je crois qu'ils utilisent des formats simple parce que pour SQL Server, je crois que c'est même pas des DD majuscules. Je crois que c'est des dd minuscules pour les jours, pour les mois ça doit être des MM comme ça mais c'est particulier mais peut-être que c'est eux qui ont les minuscules justement pour les année yyyy de toute façon c'est l'un ou l'autre, majuscules ou minuscules.
```sql
-- Fonctions : dates et heures
	
-- MySQL
SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');

-- Oracle & PostgreSQL
TO_CHAR(<date>, <format>) -> DD/MM/YYYY HH24:MI:SS

-- SQLite
STRFTIME(<format>, <date>)

-- SQL Server
FORMAT(<date>, <format>)  -> dd/MM/yyyy
```
bref pour pas vous dire de bêtises si vraiment vous utilisez ce sgbd renseignez vous  sur les formats si vous utilisez Oracle renseignez vous sur les formats, ça c'est sûr parce c'est celui que j'utilise au quotidien.
```sql
-- MySQL
SELECT DATE_FORMAT('2020-12-06 14:07:23', 'Le %d/%m/%Y, à %H:%i:%S');
```
Pour les autres SQLite, je m'en sert de temps en temps, SQL Server je m'en suis très très peu servi et postgressql et oracle très peu aussi donc je ne peux pas forcément être sûrs et certains des formats que je vous donne pour les autres sgbd en tout cas mais comme j'essaie de faire un cours assez général, n'exclue pas forcément les gens qui n'utilisent pas mysql, ce n'est pas le but et vous avez comme ça quelque chose d'assez général finalement et qui peut être adapté un petit peu partout.

Je pense que ce sera pas mal pour les dates on aura vu tout un tas d'informations déjà je pense pas qu'il ait besoin de voir d'autres choses.

Il n'y a pas tellement et je ne vous ai pas donné d'autres formats ici. Il y a pas mal de choses que je vous aurait pas forcément dit en vidéo que vous allez pouvoir retrouver dans la description via le lien que je vous ai donné.

Alors donc je vais complété au fur et à mesure ces différents tableaux et vous allez retrouver tout un tas de fonctions, de manipulation etc.

J'essaie de faire quelque chose mine de rien d'assez complet avec certainement des choses que vous utiliserez jamais mais au moins ce sera assez exhaustif pour le coup de disposer d'autres fonctions pour effectuer d'autres traitements sur ces dates et ces heures.

Je pense que je vais m'arrêter là pour ici ce sera très très bien comme ça j'espère en tout cas que c'était suffisamment clair parce que c'est pas évident pour ces dernières ces dernières séances de faire quelque chose d'assez concis ce serait tellement plus simple s'il y avait un seul sgbd et qu'on avait tout le monde avec les mêmes fonctions et les mêmes formats et les mêmes opérateurs, les mêmes fonctionnalités.

Là il y a tellement d'outils je ne peux pas dire bah voila je fais que du mysql et tant pis pour les autres parce que je veux faire un cours assez générales et que ça concerne un petit peu tous les sgbd et il y a quand même une grosse partie qui est similaire entre tous que vous avez vu avec toutes les séances qu'on a abordé ensemble. C'est surtout plus sur les dernières là pour le coup qui vont terminer ce cours où on a des fonctions qui sont un peu différent donc c'est pas l'idéal mais au moins on aura abordé tout ça et ça vous donnera aussi l'occasion de vous de vous renseigner un petit peu et pis de vous adapter un petit peu au sgbd que vous utilisez car vous serez peut-être amenés à utiliser autre chose que mysql en entreprise, durant vos études ou même personnellement vous préférez utiliser plutôt tel sgbd qu'un autre.

Je vous dis à bientôt pour la prochaine séance.

Pour la prochaine séance, on abordera d'autres fonctions je pense qu'on verra les fonctions mathématiques, il y a des petites choses à savoir et on terminera avec le chiffrement tout ce qui est lié à la sécurité.

On arrive vraiment voilà à quelques séances près, on arrive vraiment à la fin de cette formation donc j'espère que vous aurez appris énormément de choses et que vous allez continuer d'apprendre de choses en sql.

Si il y a la moindre question n'hésitez pas dans les commentaires et je vous dis à bientôt pour la prochaine vidéo sur ce cours sql.

A bientôt