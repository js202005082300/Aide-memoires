# [21. Fonctions de sécurité](https://www.youtube.com/watch?v=VTkhWoQ4QPA)
08-01-2021

Bonjour tout le monde nous nous retrouvons pour cette 21e séance en sql.

On va terminer avec une parenthèse importante à voir au niveau de cette formation qui concerne la sécurité.

Alors vous allez pour la plupart utiliser sql avec un langage de programmation donc la majorité des section lié à la sécurisation de vos données ou la vérification de vos données se fera principalement avec votre langage de programmation donc dans ces cas là vous serez quand même un peu moins concernés pour certaines choses que je vais énumérer ici ou que vous pourrez retrouver en tout cas dans le lien que je mets en description de la vidéo mais pour tout le monde que quel qu'il soit que vous passiez par un langage de programmation ou directement avec sql, ça peut être pas mal de vous apporter quelques indications concernant la sécurité de vos bases de données déjà pour ceux où est la première formation que vous suivez et pour les autres de voir un petit peu comment assurer la sécurité pour toutes les parties en fait de votre application d'un projet.

On va passer tout de suite sur un éditeur, on va revenir là-dessus.

Il n'y a pas de  fichier sql encore une fois pour cette séance, ça va être très simple. J'ai pas grand grand chose à vous montrer finalement.

Il a pas mal d'informations et de choses à vous dire mais en termes de fonctions on n'en verra pas beaucoup alors il n'y a pas mal de fonctions qui existe pour les systèmes de gestion de bases de données et également pas mal de fonctions différentes selon le sgbd que vous utilisez.

Certaines choses seront abordés peut-être un peu plus en détail via les tutoriels donc n'hésitez pas comme toujours à consulter la playlist des tutoriels qu'il y aura pour sql ou qu'il y a, tout dépend de quand est-ce que vous irez voir justement sur la chaîne.

Petites choses déjà petite précision à donner concernant les points de sécurité.

On va distinguer grosso modo donc je ne vais pas un faire un cours sur la sécurité, on va simplement surtout parlé de fonctions de sécurité via sql mais on va distinguer deux points importants quand même.

Je pense c'est bien de savoir de quoi on parle, le chiffrement d'accord et le hachage.
```sql
	-- Fonctions : sécurité
	
	> Chiffrement
	> Hashage
```
Je ne rentrerai pas encore une fois dans d'autres termes, d'autres explications mais concrètement pour faire simple, pour que ce soit compris comme ça de tout le monde par rapport aux informations et aux choses que nous allons aborder ensemble par la suite, le chiffrement c'est une information que vous allez avoir par exemple un texte en clair d'accord d'une information, je vais le mettre entre parenthèses comme ça voilà pour représenter voilà une bulle en fait.
```sql
	-- Fonctions : sécurité
	
	> Chiffrement : (texte en clair)
	> Hashage
```
Donc on a une information, on va utiliser une clé donc en l'occurrence ici une clé de chiffrement qui va nous permettre d'obtenir des données chiffrées ok.
```sql
	-- Fonctions : sécurité
	
	> Chiffrement : (texte en clair) -> clé -> (donnée chiffré)
	> Hashage
```
Attention on parle bien de chiffrement et pas de cryptage ou de crypter les données c'est un thème qui ne veut rien dire.

En anglais on dit crypte ou encrypt mais en français on parle bien de chiffrement ou deux chiffrement et de chiffrer les données.

A partir de là voyez qu'on a fait donc le chiffrement dans un sens d'accord, on est parti d'une information, de données en clair, un texte mais ce n'est forcément un texte, ça peut être un fichier, un volume, ça peut être tout un tas de choses.

Donc une donnée en clair, on passe par une clé de chiffrement donc la clé que l'utilisateur en question choisirait pour obtenir une donnée chiffrée.

Le moyen de revenir sur la donnée en clair càd qu'on a quelque chose en fait qui peut être fait à l'inverse c'est de passer par cette fameuse clé donc c'est une information que l'on doit avoir et à partir de l'information qui est chiffrée en utilisant la clé ici qui a été utilisée pour le chiffrement, on peut déchiffrer l'information et retrouver l'information en clair.

Et par exemple sur ma chaîne des choses que j'ai abordé avec vous notamment sur la playlist d'aide, vous pouvez trouver ce genre de vidéos concernant le chiffrement des supports de stockage avec notamment l'application veracrypt où vous pouvez chiffrer une clé usb, un disque dur, un simple fichier sur votre système bref tout un tas de choses.

Ca c'est le chiffrement.

Au niveau web donc par exemple au niveau des bases de données ce n'est pas forcément ce qu'on utilise le plus disons que dans votre usage je pense pour une bonne majorité d'entre vous notamment si vous travailler avec des sites web, si vous travaillez par exemple sur des jeux vidéo et que vous voulez manipuler des données dans une base de données, vous allez surtout travailler avec du hachage.

Le hachage pour faire simple aussi, on a une donnée en clair, on retrouve la même information, on va utiliser le chiffrement, faire appel à des algorithmes càd un processus qui va dire comment on va effectuer le chiffrement des données ou le déchiffrement mais je en parler un petit peu plus tard et ici directement via l'algorithme on obtient une donnée hashée ou plutôt plus exactement un hash d'accord un hash en fait c'est pour dire qu'une donnée justement a suivi un processus de hashage d'accord.
```sql
	-- Fonctions : sécurité
	
	> Chiffrement 	: (donnée en clair) -> clé -> (donnée chiffré)
	> Hashage 		: (donnée en clair) -> (hash)
```
On parle de la génération d'un hash ou de la création d'une empreinte numérique.

Dans ce cas précis on ne peut pas revenir en arrière une fois qu'on a obtenu hash, il n'est pas possible de retourner avec une donnée en clair et ça c'est quelque chose par exemple que je vous ai montré notamment sur un tutoriel en php pour voir comment mettre en place un système d'authentification donc en gros un système avec des utilisateurs, identification, mot de passe, pseudonyme et cetera et cetera.

Le principe pour être sûr par exemple qu'une donnée qui est cohérente, correspond effectivement à ce que l'on veut vous avez donc une donnée qui est enregistrée par exemple un âge et un utilisateur va entrer la donnée en clair, on va reproduire le hashage, on obtiendra du coup 2 hash que l'on pourra comparer et à partir de là si les deux hash sont identiques on pourra dire que l'information est valide.

D'accord elle est validée et qu'elle est correcte sinon c'est que là par exemple si on veut dans le cas d'un système de connexion identifiant, mots de passe ne serait pas correct si le hash ne correspond pas.

On peut utiliser du coup le hashage pour la gestion de mot de passe sur un site web, sur une application c'est très utilisé.

Le chiffrement comme je vous l'ai expliqué, comme vous l'avez peut-être compris c'est pour un autre cas d'usage.

On va en particulier et surtout pour cette vidéo je vais vous parler de pas mal de fonctions pour du hashage, on parlera très rapidement de chiffrement parce que là pareil selon le sgbd que vous utilisez vous n'aurez pas forcément tout de disponibles, il faut passer par des extensions.

C'est pour ça que je voulais réserver cette séance pour la fin de cette formation sql parce que vous allez voir que pour certains sgbd il faudra installer des modules supplémentaires, passés par d'autres extensions si vous êtes sur sql server par exemple il faudrait éventuellement passer par Transact-SQL, pour oracle c'est du PL/SQL, pour postgressql il faut éventuellement passer par pgcrypto qui est un module en fait supplémentaires.

J'ai tout indiqué de toute manière dans cette page en description de vidéos comme d'habitude, maintenant vous avez l'habitude sur les sur les dernières vidéos de cette formation, vous avez un lien qui vous redirigera sur mon github avec ici une page dédiée aux quelques fonctions de sécurité qu'on va aborder ensemble et quelques petites infos.

https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-securite.md

Encore une fois toujours, vous regardez peut-être la vidéo très très récemment après sa publication peut-être que d'autres la verons dans 3 mois, dans 6 mois, dans 1 an et je compléterai au fur et à mesure bien sûr, je rajouterais si nécessaire pas mal de fonction dans les différents fichiers que j'ai pu vous proposer tout au long de cette formation, c'est pour ça que c'est sur un github en ligne pour que vous puissez consulter ça régulièrement quand vous le voulez et que moi de mon côté je puisse vous le mettre à jour pour que vous ayez un maximum d'informations.

Voilà pour tout ça, je tenais à faire le point sur qu'est-ce que le chiffrement ? qu'est ce que le hashage et cetera ? Ce sont des choses que nous allons aborder  ensemble.

Maintenant que ceci est dit, ceci est fait, je vais me connecter à mon client mysql, toujours pareil. Je vais faire les démonstrations via mysql.

Si vous passez par un autre sgbd, à vous de tester de votre côté.

On trouvera quelques trucs pour d'autres sgbd au niveau on va dire de fonctions, etc.

Ce sera à vous de le tester et éventuellement de voir dans les documentations, dans ce que je vous ai fourni en description de vidéos pour trouver d'autres fonctions et d'autres usages notamment pour du chiffrement au autre.

Concernant mysql, on va aborder dans déjà très des fonctions très simple, on va appliquer un premier hash.

Le premier hash c'est une fonction où on pourrais se dire je pourrais très bien ne pas en parler parce que c'est une fonction qui n'est absolument plus sécurisé, elle ne l'est plus d'accord elle l'a été à une époque mais avec les ordinateurs actuels ce n'est plus quelque chose à utiliser donc vous pouvez et c'est pour ça que je vous en parle parce que peut-être qu'un jour vous travaillerez je ne sais pas sur un projet, vous reprendrez un code ou n'importe quoi et vous tomberez sur cette fonction et au moins en voyant cette fonction vous saurez que là il y a un problème et qu'il faut changer ça.

Cette fonction s'appelle MD5().

MD5() encore une fois je ne vais pas vous expliquer tout un détail sur les algorithmes que ce soit pour le hash, pour le chiffrement etc. on va faire très simple.

On va obtenir donc à partir d'une information en clair par exemple 'bonjour' donc on peut imaginer que c'est une information que je veux, pour laquelle je veux générer un hash d'accord une empreinte numérique.
```sql
	MD5('Bonjour')
```
On va utiliser un algorithme en l'ocurrence ici l'algorithme pour MD5() via cette fonction là pour produire un hash.

Le hash qui sera produit via ce genre de fonction sera composée de 32 caractères donc un hash sur 128 bits et si vous vous posez la question pour faire simple si vous avez peur de ne pas vous en souvenir, partez du principe que un hash qui est générée sur n bites d'accord vous donnera à la fin en fait une chaîne d'information parce que là on parle effectivement de deux chaînes de caractères d'accord que vous diviser par 4 pour avoir le nombre de caractères.
```sql
	-- Fonctions : sécurité
	
	N bits = N/4 caractères
	
	MD5('Bonjour') -> 128 bits (32 caractères)
```
Donc là comme ça produit tout simplement une information sur 128 bits ça correspond si on divise 28 par 4 à 32 caractères donc ça c'est important.

Pourquoi je vous dis le nombre de caractères que ça va produire ? parce que si un jour vous voulez par exemple réserver un champ d'accord, une colonne d'une table sql pour stocker ... évidemment pas avec cette fonction MD5() parce que je vous dis qu'il ne faut plus l'utiliser du tout aujourd'hui mais je vous en parle quand même ... bien si un jour vous tombez par exemple sur quelqu'un qui s'en sert peut-être que la personne aura dans la colonne choisi comme type de données, aura choisi par exemple VARCHAR(32) et peut-être même CHAR(32) parce que ça peut être moins.
```sql
	-- Fonctions : sécurité
	
	N bits = N/4 caractères
	
	MD5('Bonjour') -> 128 bits (32 caractères) char(32)
```
Carrément ça parce que char(32) rappelez vous c'est une taille fixe puisque automatiquement on va dans tous les cas peu importe ce qu'on met ici 'Bonjour...' comme texte on va obtenir finalement une chaîne de 32 caractères donc ici voilà on stocke l'information de cette manière-là donc ça petite révision sur les types de données qu'on a vu en sql.

Voilà je vais vous montrer très rapidement parce qu'encore une fois c'est bien de savoir, de vous montrer aussi ce qu'il ne faut pas faire en informatique, c'est important sans forcément non plus détailler pendant 3 heures.

En gros je ne passe pas par des fichiers, je ne passe pas par une base de données quelconque, des tables pas besoin pour ce que je vais vous montrer dans cette séance.

On fait ça, on met par exemple notre information et voilà.
```sql
SELECT MD5('bonjour');
```
```sql
	mysql> SELECT MD5('bonjour');
	+----------------------------------+
	| MD5('bonjour')                   |
	+----------------------------------+
	| f02368945726d5fc2a14eb576f7276c0 |
	+----------------------------------+
	1 row in set (0.00 sec)
```
Et on obtient 32 caractères d'accord ici une empreinte numérique donc une empreinte md5 de bonjour donc si je refais évidemment l'exécution ce n'est pas une information qui est aléatoire et qui change d'accord.
```sql
	mysql> SELECT MD5('bonjour');
	+----------------------------------+
	| MD5('bonjour')                   |
	+----------------------------------+
	| f02368945726d5fc2a14eb576f7276c0 |
	+----------------------------------+
	1 row in set (0.00 sec)
```
Dans tous les cas même si vous le faites de votre côté en produisant l'empreinte numérique du mot bonjour en minuscule tel que je les marqué-là vous obtiendrez tous à l'identique cette empreinte là, ce hash présent.

Ca c'était une ancienne fonction que vous allez retrouver notamment sur postgressql, sur postgressql vous mettez md5(), on a plus l'habitude de marquer les noms de fonction en minuscules et vous mettez là pareil, vous mettez 'test', vous mettez 'bonjour' ce que vous voulez, même chose d'accord la fonction existe également sur postgressql et dans d'autres sgbd vous aurez des fonctions un peu plus générique.
```sql
	md5('test');
```
En gros une fonction, vous pourrez choisir comme paramètre l'algorithme en fait que vous voulez utiliser pour générer votre hash.

Voilà ça c'est l'information que je voulais vous montrer ici donc ça c'est bien de savoir que ça existe, c'est bien savoir que c'était utiliser une époque qu'il ne faut plus utiliser aujourd'hui mais ça remonte déjà à pas mal d'années donc attention si un jour vous voyez MD5() qui traîne quelques part, voyez pour  changer, pour mettre à jour si vous travaillez sur un projet que vous avez récupéré ou que sais-je et surtout n'en fait pas usage sur des nouveaux projets d'accord c'est une chose à ne plus utiliser.

Dans dans la même optique on va dire on a également un autre algorithme qui est SHA qui lui est un peu plus sécurisé que MD5() et celui-là va produire donc va générer un hash de 160 bits d'accord, produire un hash de 160 bits donc quarante caractères qui sont généré à la fin.

C'est un peu plus sécurisé que md5 mais pareil de nos jours ce n'est utilisé.

L'usage en lui-même càd comment on l'utilise c'est ça.
```sql
	SELECT SHA()
```
Vous avez également un alias en mettant le 1 d'accord.
```sql
	SELECT SHA1()
```
Le 1 n'est pas obligatoire, c'est un caractère facultatif dans la fonction.

Je fais ceci.
```sql
SELECT SHA1('bonjour');
```
```sql
	mysql> SELECT SHA1('bonjour');
	+------------------------------------------+
	| SHA1('bonjour')                          |
	+------------------------------------------+
	| 1f71e0f4ac9b47cd93bf269e4017abaab9d3bd63 |
	+------------------------------------------+
	1 row in set (0.00 sec)
```
Je vous montre aussi rapidement pour que vous sachez que ça existe et que ça fonctionne.

On produit les quarante caractères d'accord 160 bits.

Voilà donc c'est un peu plus long pareil si on refait, ce sera toujours toujours le même hash qui est obtenue, ça c'est très important de savoir parce qu'on pourrait penser que du coup l'information change à chaque fois mais non.
```sql
	mysql> SELECT SHA1('bonjour');
	+------------------------------------------+
	| SHA1('bonjour')                          |
	+------------------------------------------+
	| 1f71e0f4ac9b47cd93bf269e4017abaab9d3bd63 |
	+------------------------------------------+
	1 row in set (0.00 sec)
```
Là encore une fois c'est un hash donc cette information est toujours là d'accord parce que le but c'est de pouvoir à un moment donné si on veut pouvoir retester par exemple la chaîne bonjour et si on utilise une fonction dessus on doit pouvoir faire des comparaisons de hash donc si on avait des valeurs qui changeait et qui était aléatoire, il sera impossible de pouvoit retomber en fait sur le même hash.

Par exemple imaginez sur un système de connexion, on vous direz que l'utilisateur a mis un mauvais mot de passe alors qu'il a en fait exactement le mot de passe qui est mis d'origine, ce serait très problématique pour nos systèmes d'authentification.

Petite information comme ça à savoir donc
SHA1(), MD5(), on ne s'en sert plus.

La solution d'accord a utiliser aujourd'hui c'est la version 2 de SHA() donc c'est très simple à utiliser en sql, vous mettez un 2.
```sql
	SELECT SHA2('bonjour');
```
Voilà on ne peut pas faire plus simple que ça.

Vous avez en premier argument à renseigner à l'appel de votre fonction, c'est l'information d'accord sur lequel vous voulez évidemment générer un hash et en deuxième argument très important on va renseigner l'algorithme d'accord une information qu'on va pouvoir enseigner.
```sql
	SELECT SHA2('bonjour', ...);
```
Donc la pareil alors c'est un peu particlier il faut que je vous précise là dessus parce que pour d'autres sgbd vous allez voir qu'ils ne gèrent pas forcément les paramètres de la même manière.

Pour mysql, vous allez pouvoir produire SHA2 et c'est au choix vous avez 224 bits d'accord, vous avez 256, vous avez 384 bits et vous avez le fameux 512 bits.
```sql
	-- Fonctions : sécurité
	-- N bits = N/4 caractères
	-- MySQL : SHA2 -> 224 bits, 256 bits, 384 bits, 512 bits.
```
Ok pareil en fonction vous divisez par 4 ça permettra de savoir le nombre de caractères qui vont être une généré, en tout cas par rapport au hash qui sera généré.
```sql
	SELECT SHA2('bonjour', ...);
```
En 2e paramètre, pour l'information a indiqué ici en fait vous renseigner simplement ce nombre-là en bits d'accord.

D'accord c'est pas une chaîne a renseigner genre il faut pas faire ça genre 'sha_256' et cetera mais c'est simplement comme ça pas sous forme de chaînes comme ceci d'accord 256.
```sql
-- Fonctions : sécurité
-- N bits = N/4 caractères
	
-- MySQL : SHA2 -> 224 bits, 256 bits, 384 bits, 512 bits.
SELECT SHA2('bonjour', 256);
```
on met comme un entier pour chacune de ces valeurs là.

Là je vais vous les montrer très rapidement et vous allez voir la différence donc là d'accord donc pour 224 bits ont a 56 caractères.
```sql
SELECT SHA2('bonjour', 224);
```
```sql
mysql> SELECT SHA2('bonjour', 224);
+----------------------------------------------------------+
| SHA2('bonjour', 224)                                     |
+----------------------------------------------------------+
| f8ec9284e160c5afe456b48702e08a14095ab37bca36808e10a22f71 |
+----------------------------------------------------------+
1 row in set (0.00 sec)

Si je mets pour 256, on va avoir 64 caractères.
```
```sql
SELECT SHA2('bonjour', 256);
```
```sql
mysql> SELECT SHA2('bonjour', 256);
+------------------------------------------------------------------+
| SHA2('bonjour', 256)                                             |
+------------------------------------------------------------------+
| 2cb4b1431b84ec15d35ed83bb927e27e8967d75f4bcd9cc4b25c8d879ae23e18 |
+------------------------------------------------------------------+
1 row in set (0.00 sec)
```
384 bits, on à 96 caractères voilà ça commence à faire assez long mine de rien.
```sql
SELECT SHA2('bonjour', 384);
```
```sql
mysql> SELECT SHA2('bonjour', 384);
+--------------------------------------------------------------------------------------------------+
| SHA2('bonjour', 384)                                                                             |
+--------------------------------------------------------------------------------------------------+
| c7e2d3a1a600319151a62b9abfcecfbeab4ca388375a1498dc6d7630c67e349140103c150815cd027447db5d117e7e04 |
+--------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)
```
On a ensuite le 512 qui va produire 128 caractères et là du coup ça déborde même un peu par rapport à mon terminal.
```sql
SELECT SHA2('bonjour', 512);
```
```sql
mysql> SELECT SHA2('bonjour', 512);
+----------------------------------------------------------------------------------------------------------------------------------+
| SHA2('bonjour', 512)                                                                                                             |
+----------------------------------------------------------------------------------------------------------------------------------+
| 3041edbcdd46190c0acc504ed195f8a90129efcab173a7b9ac4646b92d04cc80005acaa3554f4b1df839eacadc2491cb623bf3aa6f9eb44f6ea8ca005821d25d |
+----------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)
```
Voilà c'est quelque chose de plus compSET donc pas mal pratique et évidemment plus sécurisé.

Plus on utilise une version en bits qui est plus important plus le hash sera puissant en tout cas sera robuste.

A contrario donc à moins d'avoir des machines bien sûr qui sont très très ancienne mais bon c'est bien de l'indiquer ici... plus le hash ici est fort donc avec le nombres de bits qui est produit en tout cas avec un nombre de bits important et plus les calculs bien sûr appliqués et plus le processus sera long d'accord.

D'accord on oublie pas que ce sont des algorithmes donc même si on parle de temps informatique qui peut être en millisecondes ou éventuellement quelques secondes, ce sont des temps qui peuvent être très longs.

Voilà on va par exemple générer plus rapidement un md5, aussi pour ça qu'aujourd'hui ça se casse très facilement comme hash qu'un SHA2 en 512 bits d'accord évidemment là ce sera un peu plus long pour générer ce genre de hash mais plus robuste, plus sécurisé donc éventuellement préférable pour des informations qui seraient très critiques.

Voilà donc SHA2, vous pouvez l'utiliser pour tous ces cas, il n'y a pas de problème.

Ca c'est pour mysql d'accord principalement.

Si on veut pour postgressql bon je vous ai montré avec md5 mais encore une fois c'est juste pour information.

Vous savez maintenant et vous serez par la suite que vous ne devez plus ou pas l'utiliser.

Pour postgressql, on va faire très simple et je vous invite à prendre note. Pour postgressql petite exception et je vais vous montrer pour pas mal de sgbd également, vous avez la fonction digest() donc ça c'est la fameuses fonction qui va permettre de créer une empreinte numérique c'est ce que je vous ai expliqué tout à l'heure c'est le terme anglais.
```sql
	-- PostgreSQL
	digest('bonjour',...);
```
Ici la même chose vous passez la valeur que vous voulez et l'algorithme à utilisé qui pour le coup s'indique en fait sous forme de chaîne.

Alors la syntaxe en md5 c'est comme ça.
```sql
	-- PostgreSQL
	DIGEST('bonjour','mb5');
```
On peut soit utiliser la fonction md5 qui elle est de base dans postgressql via son module qui est pgcrypto que d'ailleurs j'ai dû indiquer là.

https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-securite.md
```txt
+------------------------------
| PostgreSQL
| Algorithmes de hash disponibles : md5, sha1, sha224, sha256, sha384, sha512
+------------------------------
| NOM	DESCRIPTION	USAGE
| DIGEST()	Génération d'un hash (via le module pgcrypto)	digest(str, algorithm)
| ...
+-------------------------------
```
Via le module pgcrypto, génération d'un hash avec DIGEST() et vous pouvez éventuellement générer aussi un md5 comme ça et encore une fois attention md5 n'est plus sécurisé.

On peut sinon indiquer sha1 pareil c'est obsolète, c'est déprécié donc c'est ne plus à utiliser aussi.
```sql
-- PostgreSQL
DIGEST('bonjour','sha1');
```
Et pour travailler sur des versions qui sont préférables, vous avez sha224, sha256, sha384 ou éventuellement sha512.

On va dire pour avoir un bon compromis surtout pour des données assez critiques quand même, le 256 n'est pas mal.
```sql
-- PostgreSQL
DIGEST('bonjour','sha256');
```
Evitez de prendre en dessous voilà si vous voulez vous prendre un juste milieu, en 256 bits c'est pas mal du tout et si vous pouvez prendre 512 c'est toujours mieux aussi mais encore une fois il y aura toujours un peu plus de lenteur par rapport aux hash.

On a ces informations là donc DIGEST() très important à connaître comme fonction pour ça.

Ok on va en montrer d'autres alors qu'est ce que je peux vous montrer ? Pour Oracle Database et je précise que MySQL c'est Oracle, je préfère préciser pour pas que vous vous tromper.

Nous avons une fonction qui est STANDARD_HASH() ici pareil très simple vous mettez l'information donc là en l'occurence on peut mettre bonjour et ensuite l'algorithme qui est également sous forme de chaîne mais là par contre c'est tout en majuscule 'MD5' mais peut être qu'en minuscule ça fonctionne mais dans le doute et comme les informations sur Oracle travaillent beaucoup avec des majuscules c'est mieux de travailler avec des majuscules. 
```sql
-- Oracle DATABASE
STANDARD_HASH('bonjour', 'MD5');
```
Et là pareil pour SHA1 c'est comme ceci 'SHA1' et pour les autres c'est 'SHA256' comme ça tout en majuscules et cetera jusqu'à 'SHA512' voilà tout ce que vous ai montré.
```sql
--MySQL
SHA2('bonjour', 256);

-- PostgreSQL
DIGEST('bonjour','sha256');

-- Oracle DATABASE
STANDARD_HASH('bonjour', 'SHA256');
```
Voyez une fois que vous savez en utiliser une, on a quand même des fonctions qui finalement s'utilise un peu de la même manière, à part le nom qui change pour le reste on se retrouve avec des choses assez similaires.

Voilà ça je vous montre tout les exemples pour que vous ayez pas mal de quoi faire avec tout ça.

Pour SQL Server, voilà de Microsoft, on peut travailler avec transact sql ça marche aussi bien sûr c'est une extension et ici on va avoir HASHBYTES() d'accord.
```sql
	-- SQL Server
	HASHBYTES()
```
D'ailleurs on n'est pas obligé de travailler sur une chaîne de caractères, on peut travailler sur des données binaires, il n'y a pas de problème. Je vais parler d'un peu de binaire très vite avec avec du chiffrement aes avec mysql que je vous montrerais en fin de vidéo.

Et ici c'est l'inverse, ils ont voulu faire des petits pièges, c'est l'algorithme en premier mais là il y en a plein d'autres càd qu'il y a même des vieux algorithmes, on peut faire du MD2, MD4 qui sont des ancêtres du MD5 encore moins sécurisés évidemment.
```sql
	-- SQL Server
	HASHBYTES('MD4');
```
On retrouve 'SHA' ou son alias 'SHA1' et on retrouve les autres et eux s'écrivent comme ceci 'SHA2_' underscore puisque évidemment il faut faire un peu plus compliqué et là vous mettez bien évidemment la taille en bits par rapport à l'algorithme utilisé, le 256 s'écrira de cette manière.
```sql
	-- SQL Server
	HASHBYTES('SHA2_256');
```
Et en deuxième argument l'information ici avec laquelle nous allons produire le hash comme ça on ne se trompe pas de ce côté là.
```sql
--MySQL
SHA2('bonjour', 256);

-- PostgreSQL
DIGEST('bonjour','sha256');

-- Oracle DATABASE
STANDARD_HASH('bonjour', 'SHA256');

-- SQL Server
HASHBYTES('SHA2_256', 'bonjour');
```
Et pour sqlite petit dernier et bien None comme la version l'indique c'est un sgbd qui est lite qui est beaucoup plus léger et vous n'avez pas en natif, en standard, en fait de fonction toute fait pour gérer tout ce qui est hash, tout ce qui est chiffrement et cetera donc éventuellement c'est à vous de créer parce qu'on peut créer évidemment des fonctions via la sgbd pour faire ce genre de choses.
```sql
--MySQL
SHA2('bonjour', 256);

-- PostgreSQL
DIGEST('bonjour','sha256');

-- Oracle DATABASE
STANDARD_HASH('bonjour', 'SHA256');

-- SQL Server
HASHBYTES('SHA2_256', 'bonjour');

-- SQLite
None
```
Après encore une fois SQLite, on utilise quand même pour des cas bien précis.

Quand on veut travailler sur des données absolument a bien sécurisé, on évitera quand même en grande majorité SQLite.

Encore une fois ce n'est pas pour rien que ça s'appelle SQL Lite, on ne peut pas dire c'est nul c'est juste que ça correspond à certains besoins, certains contextes bien précis.

On va pas forcément faire du SQLite pour tous les cas, pour tous les scénarios.

Ce n'est pas pour rien qu'il y a des gros sgbd à côté qui sont quand même beaucoup plus robuste à ce niveau là.

Donc toute façon je crois que dans mon fichier, j'ai dû vous mettre que aucune fonction de sécurité n'est disponibles et c'est à vous de les définir.
```txt
+------------------------ 
| SQLite
+------------------------
| Aucune fonction de sécurité disponible (à vous de les définir)
+------------------------
```
Si un jour ça vous intéresse de voir comment créer des fonctions avec sql, vous pourrez voir ça parce que moi je ne l'aborderai pas forcément vidéo encore une fois on n'est pas à l'abri de quoi que ce soit comme pour chaque cours, il y a des playlists de tutoriels on peut après faire un tuto sur un petit peu tout et n'importe quoi donc sait-on jamais mais c'est pas prévu au programme tout de suite au moment où je fais cette vidéo donc n'attendez pas forcément que je fasse un tuto pour chaque chose.

N'hésitez pas encore une fois c'est le but aussi des vidéos que je vous fais à être un minimum autonome aussi et ne pas hésiter à vous renseigner et d'utiliser des documentations, d'aller faire la recherche sur internet s'il y a quelque chose que vous voulez faire.

Vous avez mine de rien sur ce cours déjà une bonne ... ce n'est même plus une base et vous avez vraiment voilà un gros gros package on va dire en sql et j'essaie d'être assez générale un maximum pour que vous ne soyez pas  forcément encore une fois obligé de vous servir de mysql même si c'est ce qui a été installé dans la formation. 

Il fallait bien en choisir un mais au moins vous serez quand même beaucoup plus à l'aise je pense avec d'autres sgbd puis c'est pareil si vous avez commencé avec mysql et que demain vous voulez vous former un petit peu à oracle, à postgressql, etc, et que vous avez la curiosité d'en tester d'autres, n'hésitez pas, c'est fait pour ça.

Bien on a vu pour les hash, il n'y a pas forcément besoin d'en voir davantage, tout ce qu'il faut ici.

Je vais quand même très rapidement voir du chiffrement, tout simplement mysql pour le coup, on va faire ça.
```sql
	--MySQL
	AES_ENCRYPT('bonjour', '');
```
On va avoir une information 'bonjour' et donc là on est sur du chiffrement, on n'est pas sur la génération d'un hash très important et on va passer par une clé alors une clé c'est si vous voulez c'est une information qui doit être gardée secrète c'est pas une chose à partager comme ça n'importe où n'importe comment.

C'est par exemple au moment où on la crée c'est le mot 'secret'.
```sql
	--MySQL
	AES_ENCRYPT('bonjour', 'secret');
```
'secret' c'est assez spécial mais pourquoi pas, je fais ça et moi je vais faire quelque chose en vidéo que je ne vous ai pas forcément montré dans le cours puisque ça donc pas encore été fait en tutoriel au moment où cette vidéo est enregistrée. Je ferais un tuto dessus bien évidemment parce que ça vaut le coup d'en parler aussi donc on va faire ça.
```sql
--MySQL
SELECT AES_ENCRYPT('bonjour', 'secret');
```
```sql
	mysql> SELECT AES_ENCRYPT('bonjour', 'secret');
	+--------------------------------------------------------------------+
	| AES_ENCRYPT('bonjour', 'secret')                                   |
	+--------------------------------------------------------------------+
	| 0x9E8B08E653F37BAB8911C743842FD36C                                 |
	+--------------------------------------------------------------------+
	1 row in set (0.00 sec)
```
Hop et là on obtient une information un peu bizarre, vous allez avoir des caractères bizarre, pas d'inquiétude c'est parfaitement normal.

La donnée qui est produite ici c'est du binaire d'accord évidemment ici le terminal n'affiche pas du binaire donc on a tout un tas d'informations un peu bizarre qui sont affichées.

On a produit d'accord, on a chiffré en fait le mot ici donc la chaîne bonjour en utilisant la clé qui s'appelle du coup secret voilà le nom est secret j'aurais pu mettre n'importe quoi voilà.

On peut faire l'inverse avec AES_DECRYPT() donc ça utilise l'algorithme aes, c'est vrai que je ne l'ai pas dit mais c'est bien de quand même en parler.
```sql
	SELECT AES_DECRYPT();
```
Et là on va avoir l'information qui est crypté donc là en l'occurrence ce serait ça 0x9E8B08E653F37BAB8911C743842FD36C mais ça ne marchera pas parce que si j'essaie de faire du copier coller comme c'est du binaire vous verrez qu'au niveau du client MySQL ça n'a pas fonctionné donc je vais faire autre chose, je vais vous montrer et si vous ne comprenez pas forcément ce n'est pas grave parce qu'on le reverra en détail dans une vidéo en annexe là dessus, et notamment pour faire des variables.

On va créer une variable, on va faire ça ok bon ça n'a rien de complexe. Je vous le dis tout de suite et je vais mettre @passw.
```sql
	-- MySQL
	SET @passw = AES_ENCRYPT('bonjour', 'secret');
	SELECT @passw;
```
Donc je mets ça en variable, après éventuellement je l'affiche et ensuite on va le stocker dans autre chose en fait, dans @text et on va faire l'inverse.
```sql
	-- MySQL
	SET @passw = AES_ENCRYPT('bonjour', 'secret');
	SELECT @passw;
	SET @text = AES_DECRYPT('bonjour', 'secret');
```
Et là en fait au lieu de mettre une information à la place de 'bonjour' parce que @passw ne peux pas être copier coller et bien je fait ça.
```sql
	-- MySQL
	SET @passw = AES_ENCRYPT('bonjour', 'secret');
	SELECT @passw;
	SET @text = AES_DECRYPT(@passw, 'secret');
```
C'est simple hop je mets la même clé, très importante il faut avoir la même clé pour pouvoir déchiffrer l'information.

C'est ce que je vous expliquais tout à l'heure concernant le chiffrement et on affichera l'information finale pour voir qu'on est bien revenue à la même information.
```sql
-- MySQL
SET @passw = AES_ENCRYPT('bonjour', 'secret');
SELECT @passw;
SET @text = cast(AES_DECRYPT(@passw, 'secret') AS char);
SELECT @text;
```
Logiquement ce qu'on a indiqué 'bonjour' c'est ce qu'on doit retrouver dans @text à la fin donc si vous n'avez pas trop compris ce que je viens de faire ici ce n'est absolument pas grave. Ce n'est pas une chose que j'ai abordé dans le cours parce que ce n'était pas nécessaire et ce n'est pas de toute façon disponibles partout.

Il y a plein de sgbd qui n'ont pas de système de variables, c'est parfaitement normal comme je vous ai dis que je ne l'ai pas abordé dans le cours mais je ferai une vidéo annexe dans les tutos pour les sgbd qui sont concernés par ce genre de fonctionnalités.

On chiffre, on définis la variable @passw, hop je stock tout ça.
```sql
	mysql> SET @passw = AES_ENCRYPT('bonjour', 'secret');
	Query OK, 0 rows affected (0.00 sec)
```
Là on affiche l'information qui vient d'être chiffrée, le contenu donc on retrouve naturellement l'information en binaire, une chaîne binaire, pas de souci.
```sql
	mysql> SELECT @passw;
	+------------------------------------+
	| @passw                             |
	+------------------------------------+
	| 0x9E8B08E653F37BAB8911C743842FD36C |
	+------------------------------------+
	1 row in set (0.00 sec)
```
Ici on déchiffre et on affecte à une nouvelle variable où je stocke l'information déchiffrée.
```sql
	mysql> SET @text = cast(AES_DECRYPT(@passw, 'secret') AS char);
	Query OK, 0 rows affected (0.00 sec)
```
Et j'affiche la variable et on retombe sur l'information en clair.
```sql
	mysql> SELECT @text;
	+---------+
	| @text   |
	+---------+
	| bonjour |
	+---------+
	1 row in set (0.00 sec)
```
Encore une fois comme je vous l'ai expliqué en début de séance, on a bien la possibilité de faire le chemin dans un sens et dans l'autre on peut chiffrer et on peut déchiffrer.

A l'inverse le hash comme je vous l'ai expliquer aussi, on a une information en clair, on utilise un algorithme pour générer un hash, une empreinte numérique et on obtient un hash finale qui lui ne permet pas de revenir en arrière d'accord il ne pourra pas revenir en arrière, faire le processus inverse pour retourner sur l'information en clair et c'est tout.

Voilà c'est ce que je voulais vous montrer par rapport à ça.

Autre chose que je voulais vous montrer en vidéo, de toute façon je ne peux pas vous le faire tester, faire une démonstration puisque c'est sur postgressql mais si vous avez ce sgbd, vous pourrez utiliser ces fonctions.
```sql
	-- PostgreSQL

	Déchiffrement avec clé PGP	pgp_sym_decrypt(crypt_data, key)
	Chiffrement avec clé PGP	pgp_sym_encrypt(str, key)
```
Je pense que c'est suffisamment claire, chiffrement et déchiffrement avec une clé pgp donc c'est une clé symétrie. Et voilà vous pouvez passer par ça en gros.

Pour le chiffrement c'est pareil, vous mettez l'information en clair, la clé à utiliser pour un chiffrement et pour le déchiffrement c'est l'information qui est chiffrée 'crypt_data' je rappelle et pas cryptée et la clé 'key' pour pouvoir déchiffrer l'information et retrouver la donnée en clair, en texte clair tout simplement.

Autre usage très très simple là-dessus mais je tenais quand même à vous en parler et le mettre dans ce tableau-là parce que c'était pas mal de l'aborder et éventuellement pour les plus curieux d'entre vous, ça vous donnera peut-être envie de vous renseigner un peu sur cette histoire de PGP.

Là j'ai parlé de AES puis pourquoi pas MD5, SHA etc.

Comme le thème de cette vidéo n'est pas de vous de vous faire un historique et un détail sur tous les algorithmes de chiffrement de hash et cetera sur un cours en cryptographie vous pourrez pas mal regarder d'informations à ce sujet puis vous renseigner surtout tout ça ok.

Je pense que j'ai fait le tour de ce que je voulais vous dire et vous montrer surtout cette séance.

En tout cas, ça clôture ce que je voulais vous montrer dans le cours.

On se retrouvera pour la prochaine séance et la dernière séance de ce cours qui sera donc la fameuse vidéo de conclusions pour ceux qui ont un petit peu l'habitude maintenant du contenu sur la chaîne, on fera un point de tout ce qui a été abordé et des choses que vous pouvez continuer de voir, des choses que je compte aborder dans les tutos par rapport notamment à ce qui n'a pas encore été publiée au moment où je vous parle.

On reviendra sur toutes ces informations là, je vais repasser en webcam coucou donc merci à tous d'avoir suivi cette vidéo et j'espère que vous avez pas mal d'informations.

C'était une petite vidéo simple, on a fait quand même beaucoup.

On a vu énormément énormément de choses sur toutes les dernières séances.

On en a terminé avec des choses qui sont quand même un très importante, la sécurité qui est liée aux bases de données mais voyez quelques petites fonctions, il n'y a rien de compliqué pour un usage en tout cas assez standard.

On a pas de choses énormes à connaître, quelques fonctions par ci, par là, savoir comment fonctionne un hash et comment fonctionne le chiffrement en tout cas maintenant vous êtes parés pour un usage de sql via n'importe quel sgbd et finalement on en a quand même abordé énormément dont vous avez de quoi faire et vous adapter selon le contexte, selon l'environnement avec lequel vous travaillez et vous décidez en tout cas de travailler.

Je vous dis à bientôt pour la prochaine et dernière séance de secours et on fera comme ça une belle petite conclusion pour cette formation sql.

A bientôt tout le monde.

Ciao