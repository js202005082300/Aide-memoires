# [5. Affichage](https://www.youtube.com/watch?v=CHcg88F21us)

Bonjour à tous et bienvenue sur la vidéo numéro 5 en PHP. 

Nous allons maintenant rentrer dans le détail de ce langage que nous allons découvrir ensemble, maintenant que vous avez installé votre serveur http donc Apache, que vous avez installé votre interpréteur PHP et que tout est configuré et normalement fonctionnel. 

Si au moment de cette vidéo-là, si votre configuration ne marche pas, qu'il y a encore des erreurs et des problèmes n'hésitez pas dans les commentaires à me le dire pour qu'on corrigé tout ça ensemble que vous ayez bien évidemment votre environnement de web bien opérationnel pour la suite des vidéos. 

Alors nous allons directement attaquer la partie PHP.

Alors je fais 3 petits rappels au niveau de cette formation mais des rappels qui pourraient être également valides pour les autres formations que je propose en informatique. 

Alors la première chose, merci de bien avoir les extensions des fichiers présentes d'accord notamment sur Windows parce que par défaut sur Windows elles sont masquées. Comment vérifier ça ? Eh bien quand vous créez un fichier, logiquement comme ceci "Nouveau document text.txt"  par exemple, vous devez avoir le .txt affiché à la fin. Si ce n'est pas le cas, il faut qu'elle soit affichée. C'est super important sinon vous allez avoir des problèmes. 

Sur Windows 7, c'est dans le panneau de configuration > options des dossiers > onglet Affichage. 

Sur Windows 10, c'est dans l'Explorateur de fichiers > onglet Affichage > Options > Modifier les options des dossiers et de recherche.

Et là vous descendez, vous avez l'option Masquez les extensions des fichiers dont le type est connu et vous le décochez. Vous faites appliquer et OK, c'est super important. Ça c'est la base. 

Le 2e point c'est d'avoir un éditeur de code, n'utilisez pas le bloc-notes ou un logiciel par défaut qui ne serait pas fait pour ça mais d'avoir un réel éditeur. Moi dans cette vidéo j'utilise et dans les vidéo actuelle pour le moment j'enregistre cette séance, Visual Studio code puis dans d'autres vidéos j'ai sublime text et vous pouvez également utiliser d'autres éditeurs. Il y a Atome, Brackets, il y a Visual Studio tout court, NetBeans, Eclipse donc il y a carrément des environnements de développement. Il y a notepad plus plus j'ai donc fait des recherches sur internet pour un éditeur de code à coloration syntaxique de toute façon ils le sauront et tests en plusieurs pour trouver celui qui vous correspond. Il n'y en a pas un qui est forcément mieux que les autres, voilà vous aurez chacun le vôtre, celui que vous préférez, celui qui correspond le plus à ce que vous recherchez. 

Certains voudront des éditeurs avec plein de fonctionnalités, d'autres qui voudront un truc assez minimaliste et qu'il soit léger à lancer voilà très rapide à lancer pour ne pas alourdir le système donc vraiment prenez celui qui vous correspond. 

Alors il y a même des éditeurs en ligne de commande comme Nano, VIM, et cetera. Ça c'est pareil, IMAX mais ça je n'en parle pas mais il existe également donc vous pouvez les utiliser. 

Donc ça c'est le 2e point. 

Et le 3e point ça doit travailler en utf 8, c'est super important pour n'importe quel type de programmation ou n'importe quel type de travail en informatique. 

Travailler en unicode c'est-à-dire en utf 8 et pour être plus précis utf 8 sans BOM donc au niveau moi de Visual Studio code, je peux facilement le vérifier. Sur sublime text il faut aller dans le menu qui est en anglais *File > save within encoding > utf-8 …* Et vous adapter tout ça à votre éditeur en particulier si ce n'est pas le même pour avoir l'utf-8 donc super important également parce que je reçois beaucoup de commentaires d'entre vous sur plein d'erreurs parce qu'en général vous avez un de ces 3 problèmes soit vous n'avez pas l'extension de fichier qui est affiché justement, soit vous n'avez pas le bon encodage donc utf-8, soit vous ne travaillez pas avec un éditeur de code ou autre et du coup ce n'est pas forcément lisible, et vous faites des fautes de frappe ou des erreurs de syntaxe qui évidemment amène à des problèmes donc ça c'était la petite parenthèse que je voulais faire en ce début de vidéo qui est super importante et qui est encore une fois applicable aux autres formations informatiques que je propose sur la chaîne. 

Ceci étant passé, nous allons commencer à vraiment nous attarder à PHP et découvrir ce langage. 

Autre parenthèse aussi parce que j'ai remarqué que ça pouvait amener à des erreurs au niveau de la configuration qu'on avait fait d'apache et notamment pour ceux qui sont sur Windows, vous allez retourner dansle fichier httpd.conf donc le fichier de configuration d'apache parce que sur certaines anciennes versions d'apache ça ne posait pas de problème mais je viens de me rendre compte que pour le 2.4 ça pouvait être un problème.
```conf
	+---------------------------------------------------+
	|													|
	| #\MyWAMP\apache\conf\httpd.conf					|
	| 													|
	| Define SRVROOT "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	| ServerRoot "${SRVROOT}"							|
	| ...												|
	| Listen 80											|
	| ...												|
	| LoadModule rewrite_module modules/mod_rewrite.so	|
	| ...												|
	| ServerName localhost								|
	| ...												|
	| <Directory "${SRVROOT}/htdocs">					|
	| 	Options Indexes FollowSymLinks					|
	| 	...												|
	| 	AllowOverride All								|	
	| 	...												|
	| 	Require all granted								|
	| </Directory>										|
	| ...												|
	| <IfModule dir_module>								|
	| 	DirectoryIndex index.html index.php				|
	| </IfModule>										|
	| ...												|
	| # PHP 7											|
	| LoadModule php7_module "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/php/php7apache2_4.dll"
	| 													|
	| <FilesMatch "\.php$">								|
	| 	AddHandler application/x-httpd-php .php			|
	| </FilesMatch>										|
	| 													|
	| <IfModule php7_module>							|
	| 	PHPiniDir "C:/Users/js201/OneDrive/Formations/FormationVideo/MyWAMP/apache"
	| </IfModule>										|
	| 													|
	| <IfModule mine_module>							|
	| 	AddType application/x-httpd-php .php .html		|
	| </IfModule>										|
	|													|
	+---------------------------------------------------+
```
À la fin du fichier si vous avez fait comme moi, on avait ajouté au niveau du match du type .php `<FilesMatch "\.php$">`, un SetHandler pour le type de fichier PHP j'ai remarqué que le Set pouvait poser souci pour le démarrage du serveur donc remplacer Set par Add avec je rappelle toujours bien une majuscule au A c'est important et une majuscule au H de AddHandler histoire d'avoir une syntaxe qui soit propre. 

Donc juste cette modification là, vous faites ctrl+S pour enregistrer le fichier ou bien *File > Enregistrer* et cetera. Vous fermez et voilà donc ça c'était un petit détail mais c'est bien qu'on puisse partir sur de bonnes bases et qu'on n'ait pas de problème par la suite. 

C'est parti on va lancer notre serveur donc vous lancez votre serveur comme vous l'avez appris à le faire sur les vidéos précédentes : 
```powershell
\MyWAMP\apache\bin\httpd.exe
```
Voilà on laisse tourner.

Et on va se rendre dans notre fichier htdocs, le répertoire qui va proposer les sites web si tu veux et là on ne va pas créer un projet on va juste directement créer un fichier à la racine pour faire simple au début et on va l'appeler index.php. On travaille évidemment avec l'extension .php pour que ce soit valide sans problème. 

Surtout rappelez-vous que dans la configuration précédente, les .php surtout automatiquement reconnu notamment index comme étant des fichiers d'entrée donc ils vont se charger automatiquement quand on va accéder au site. 

Voilà pour cette partie. 

Alors comment fonctionne PHP ? il va falloir au sein du fichier lui indiquer que nous allons travailler justement avec du code PHP. Pour cela nous allons ouvrir des balises spécifiques qui sont les suivantes `<?php` donc il s'agit d'un Chevron ouvrant, un ? et php bref ce qu'on appelle un symbole inférieur à en mathématique. 

+ index.php
```php
	<?php
```
La balise de fermeture est un ? et un > supérieur à ou Chevron fermant voilà et à l'intérieur on va pouvoir mettre notre code PHP donc ça c'est important à savoir.

+ index.php
```php
	<?php
	
	?>
```

Alors petite particularité ça c'est le type de balise que l'on va écrire si on a prévu avec PHP notamment d'affiché du HTML donc je recommande en parallèle ou au moins avant d'avoir vu la formation HTML CSS pour pouvoir suivre ce cours parce qu'on aura de temps en temps l'occasion de faire un peu de HTML et je ne vais évidemment pas vous l'expliquer parce que je considère que quand on va avoir du HTML que vous savez déjà l'utiliser donc si vous le voulez le voir avant ou le voir en parallèle, n'hésitez pas parce que ce sera un plus non négligeable pour cette formation éventuellement.

Donc dans le cas où vous allez afficher sur votre page web du HTML, il faut effectivement mettre les 2 balises par contre si on veut juste se contenter de PHP d'accord juste afficher du PHP, il ne faut surtout pas mettre la balise de fin.

+ index.php
```php
	<?php
```
C'est super important ça sinon vous allez tomber sur le genre d'erreur que l'on voit assez souvent qui est la fameuse erreur "Headers already sent".

Si vous avez ce genre de problème, souvent c'est parce que au niveau de l'ordre des affichages, il y a eu un souci par rapport aux en-têtes mais je ne rentre pas dans les détails parce que c'est un petit peu compliqué à votre niveau, et comme je pars du principe que vous n'avez jamais fait d'autres langages, que PHP ici est votre premier langage de programmation, on va rester sur des choses basiques.

Donc ça c'est la règle très simple, si vous n'avez que du PHP vous n'écrivez que cette balise.
```php
	<?php
```
... et si vous prévoyez ou en tout cas, allez afficher du HTML, vous fermez la balise PHP d'accord.
```php
	<?php
	
	?>
```
Vous verez selon le cas que l'on ferra, on changera en fonction.

Donc non je vais te faire du PHP pour le moment donc je ne ferme pas la valise c'est important. 

On y va, alors cette vidéo donc cette séance numéro 5 est dédié à l'affichage en PHP.

Pour l'affichage, nous allons utiliser un nom de commande qui est très simple qui est echo alors il ne s'agit pas d'une commande en réalité, il s'agit de ce qu'on appelle une structure d'accord ce n'est pas une fonction. 
```php
	<?php
	echo
```
Alors j'insiste bien là-dessus parce qu'il y a beaucoup de gens qui pensent à tort que echo est une fonction. Pourquoi ? Parce que dans la majorité des langages de programmation, on utilise justement des fonctions pour pouvoir faire des choses. On va avoir des fonctions pour afficher, on va avoir des fonctions pour lire, des fonctions pour ouvrir un fichier, des fonctions pour fermer un fichier. Pour certains d'autres langages il y a même des fonctions pour allouer dynamiquement de la mémoire et cetera. On va avoir plusieurs fonctions qui font chacune une chose en particulier. 

Là echo, ce n'est pas une fonction tout simplement parce que c'est défini comme étant une structure dans le langage PHP et qui va du coup avoir des syntaxes assez particulière. 

Même si ce n'est pas une fonction mais c'est pour ça que j'essaie de tout vous expliquer pour que vous sachiez comment l'utiliser. Elle peut utiliser la syntaxe comme une fonction c'est-à-dire qu'on lui met son nom donc echo() en ouvrant les parenthèses et à l'intérieur on peut éventuellement avoir des paramètres et des arguments donc nous elle va prendre quoi ? Elle va prendre du texte à afficher d'accord ouais éventuellement des variables ou autre mais ça c'est pareil, vous ne l'avez pas encore vu. 

Si c'est votre premier langage de programmation vous ne savez pas encore ce que c'est qu'une variable en informatique donc on va noter notre chaîne de caractères donc du texte en utilisant des doubles quotes ou des doubles guillemets c'est-à-dire ces symboles-là `""`.
```php
	<?php
	echo("Bonjour à tout le monde")
```
Vous pouvez également le faire avec des simples quotes comme ceci.
```php
	<?php
	echo('Bonjour à tout le monde')
```
Simple guillemets qui correspond en fait à l'apostrophe par contre attention si vous avez des apostrophes à l'intérieur même de votre texte, vous voyez que ça va poser problème (coloration différente).
```php
	<?php
	echo('Bonjour à 'tout le monde')
```
Et à ce moment-là le moyen d'éviter ce genre de soucis, c'est au niveau de l'apostrophe étant à garder comme un texte de mettre un antislash `\'` ce qui va d'ailleurs changer la couleur d'où l'intérêt d'avoir un éditeur de texte avec coloration sinon vous voyez qu'il va penser que vous fermez la chaîne à cet endroit là et que du coup `"tout le monde"` ne ferai pas partie de la chaîne donc ça c'est super important si vous avez beaucoup de texte affiché, je vous recommande directement les doubles quottes comme ça vous pouvez afficher directement des apostrophes à l'intérieur et ça ne va poser aucun souci.
```php
	<?php
	echo("Bonjour à tout '''''''le monde")
```
Il va prendre les `’` comme du texte sans problème donc on fait ça, et on n'oublie pas comme n'importe quelle instruction et comme dans beaucoup d'autres langages également pour ceux qui font du c, du c++ ou autre, de mettre un `;` ça indique que l'instruction est terminée.
```php
	<?php
	echo("Bonjour à tout le monde");
```
Le truc c'est que après on peut en mettre en la suite, on pourrait par exemple mettre un autre echo juste après terminé également par un `;` 
```php
	<?php
	echo("Bonjour à tout le monde");echo("ok");
```
Voyez ce genre de choses on peut les mettre à la suite mais bien évidemment pour que ce soit plus technique on va les mettre une par ligne ce sera mieux.
```php
<?php
echo("Bonjour à tout le monde");
echo("ok");
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le mondeok
```
Non on est allé sur le navigateur et on a lancé localhost pour arriver directement à la racine et comme on a bientôt configuré vous voyez que tout est géré comme il faut. Je vais virer l'autre echo parce qu'on s'en fiche pour le moment. 

On fait F5 ou actualiser via le jeu les icônes si vous préférez passer par le logiciel directement et voilà.
```php
<?php
echo("Bonjour à tout le monde");
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Donc ça s'affiche directement sur la sortie donc notre page web grâce à cette structure echo qui est très pratique. 

Alors pourquoi est-ce que ce n'est pas une fonction ? Eh bien justement parce qu'elle peut avoir d'autres types de syntaxe et ça c'est la syntaxe dite de fonction echo() mais echo n'en est pas une d'accord elle accepte ce type de syntaxe mais vous la verrez assez peu. 

Pour être honnête en général quand on utilise echo, on utilise rarement ce type de syntaxe pour ne pas se mélanger, pour ne pas penser à tort que c'est une fonction donc vous allez plus souvent retrouver cette syntaxe là sans les parenthèses comme ceci.
```php
<?php
echo "Bonjour à tout le monde";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Donc echo, un espace et puis la chaîne si je fais F5 ça ne change absolument rien d'accord absolument rien au niveau du résultat.

Ça c'est la première chose à savoir au niveau de l'echo donc. 

Si on veut noter maintenant un autre echo donc je vais mettre ici à la ligne comme vous l'avez vu tout à l'heure ça se mettait directement à la suite.
```php
echo "Bonjour à tout le monde";
echo "ok";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le mondeok
```
Directement comme ceci la suite parce que echo va enregistrer directement tout ce que vous lui donnez pour le passer dans la sortie comme l'a je n'ai aucune instruction qui dit de passer à la ligne ou bien de faire un espace, évidemment le texte se colle mais c'est là que HTML peut éventuellement vous servir en utilisant une balise html par exemple en mettant le fameux `<br>` et pour ceux qui ont fait du HTML vous savez que ça permet d'aller à la ligne tout simplement.
```php
	<?php
	echo "Bonjour à tout le monde<br>";
	echo "OK";
	?>
```
Et là comme j'utilise du HTML d'accord pour que mon code soit correct, il faut fermer la balise PHP `?>`.

Voilà ça c'est important. 

Dans ce cas là à partir du moment où vous utilisez des balises HTML qui vont être affichées notamment avec un echo, il faut fermer la balise PHP seulement à la fin. 

S'il y a que du PHP sans balise HTML, vous ne fermez pas la balise, ça c'est la petite différence à bien savoir et là évidemment le HTML peut être géré. 
```php
<?php
echo "Bonjour à tout le monde<br>";
echo "OK";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
	OK
```
Ce n'est pas HTML mais je vous montre rapidement si par exemple je mets un texte en emphase, je ne reviens pas dessus et je pars du principe que vous savez déjà mais je vous montre rapidement.
```php
<?php
echo "<strong>Bonjour à tout le monde</strong>";
echo "OK";
```
```
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
	OK
```
Voilà vous voyez que PHP va interpréter le HTML sans problème puisqu'il affiche sur la sortie du navigateur et navigateurs sont faits pour pouvoir interpréter le HTML comme il faut, ils sont capables de le faire comme des grands donc évidemment il gère ça sans problème. 

On va faire comme ça pour que ce soit plus lisible.
```php
<?php
echo "<strong>Bonjour à tout le monde</strong>";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Voilà donc ça fonctionne évidemment sans souci de ce côté là donc nous on va enlever le HTML parce que c'est parce que je vais vous montrer-là, on va rester là-dessus.
```php
	<?php
	echo "Bonjour à tout le monde";
```
echo comme c'est une structure, elle peut s'écrire également d'une autre manière. On peut très bien l'écrire en plusieurs éléments où par exemple ici je vais séparer en 2 et vous mettez une virgule.
```php
	<?php
	echo "Bonjour", "à tout le monde";
```
Alors ici comme c'est du texte je met bien les doubles quotes à chaque fois pour chacun des membres, j'actualise et voilà comment ça se passe.
```php
<?php
echo "Bonjour", "à tout le monde";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjourà tout le monde
```
Voilà comment ça se met mais par contre vous voyez que le texte se colle, c'est exactement ce que je vous ai expliqué. La structure echo

va tout simplement gérer exactement au caractère prêt ce que vous demander d'afficher donc un espace blanc, une tabulation, un retour à la ligne, ce sont des espaces qui comptent comme des caractères donc le fait de faire un seul espace c'est considéré comme un caractère en informatique donc si vous voulez avoir un espace entre les 2 mots, vous mettez un espace tout simplement.
```php
<?php
echo "Bonjour", " à tout le monde";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Donc ce petit espace blanc va compter et vous allez voir que au niveau de la modification, on a effectivement le texte qui se met correctement donc ça c'est important au niveau de la structure de bien gérer les espaces blancs, les retours à la ligne, les tabulations tout ça. 

Si je fais d'ailleurs une tabulation, c'est pareil et ce sera évidemment gérer à partir de là.
```php
<?php
echo "Bonjour", "	à tout le monde";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Là par contre mon navigateur me fait un changement et du coup il enlève la tabulation et il le gère comme un espace donc ça après c'est encore au niveau des navigateurs que des fois ils se permettent certaines choses à ce niveau-là mais vous allez pouvoir gérer éventuellement tout ça. 

Après vous avez vu en HTML qu'il y avait des commandes comme `&nbsp;` qui permettait soit de faire des espaces soit de faire des tabulations et cetera.
```php
	<?php
	echo "Bonjour", "&nbsp;à tout le monde";
```

Mais je ne reviens pas dessus. Nous ce qui nous intéresse c'est ça.
```php
	<?php
	echo "Bonjour", "à tout le monde";
```
Alors évidemment la syntaxe la plus rencontrée sera bien sûr celle-ci c'est-à-dire un echo et une chaîne de caractères à la suite.
```php
	<?php
	echo "Bonjour à tout le monde";
```
Ça c'est ce que vous allez retrouver le plus souvent voilà c'est quelque chose à savoir donc tout est géré de cette manière. C'est super important d'avoir ça au niveau du formatage, de bien le gérer comme ça. 

Alors une petite démonstration si on fait ça. 
```php
	<?php
	echo "Bonjour à tout 
	le monde";
```
Ce genre de choses vous voyez que je coupe une ligne.
```php
<?php
echo "Bonjour à tout 
le monde";
```
```powershell
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout le monde
```
Voilà pas de changement à ce niveau là même si on ferme la balise PHP (simplement pour tester, on ne sait jamais avec PHP).
```php
	<?php
	echo "Bonjour à tout 
	le monde";
	?>
```
Vous voyez que ça ne change pas lorsque je force comme si j'avais du HTML donc je serais vraiment obligé de faire encore une fois ça.
```php
	<?php
	echo "Bonjour à tout<br>
	le monde";
	?>
```
`<br>` pour que ce soit plus lisible au niveau de mon fichier pour avoir effectivement un passage à la ligne.
```php
<?php
echo "Bonjour à tout<br>
le monde";
```
```powershell
	http://localhost/PHP/cours/005_affichage/
	Bonjour à tout
	le monde
```
Si on regarde le code source, vous voyez qu'on a effectivement les balises HTML d'afficher puisque le HTML est affiché au niveau du code source, pas le PHP mais le HTML donc ça montre bien qu'on en a.
```html
	<html><head></head><body>Bonjour à tout<br>
	le monde</body></html>
```
Voilà donc ça c'est okay pour cette partie là au niveau de la structure pour echo. 

Donc c'est quelque chose qui est évidemment à savoir et que je voulais vous rappeler. 

On a également une autre structure qui était un peu plus rapide qui vous servira pas mal comment vous les utiliserez dans du HTML qui est en fait un raccourci à echo c'est-à-dire que comme echo est une structure qui est très souvent utilisée, on peut s'en passer au niveau de l'écriture et on peut directement faire ça même si ce n'est pas propre du tout au niveau du HTML d'accord, j'ouvre et je ferme les balises PHP ce qui est super important puisque j'ai du HTML.
```php
	<h1>Ma page web</h1>
	
	<?php
	
	
	?>
```
Alors vous pouvez écrire du HTML directement comme ça dans le fichier PHP, ce sera évidemment lisible, c'est valide il n'y a pas de problème. 

Ce n'est pas valide dans le sens où je n'ai pas ouvert la valise `<!DOCTYPE>` et cetera donc il faudrait le faire normalement mais on verra ça un peu après. 

Et là pour utiliser non un echo, je peux directement au lieu de faire ceci `<?php … ?>`, je peux juste faire comme ça `<?= "Bonjour" ?>`.
```php
	<h1>Ma page web</h1>
	
	<?= "Bonjour" ?>
```
Voilà plutôt que de faire les ouvertures et fermetures de balises comme on l'a fait, vos faites plutôt comme ça et ça on utilise beaucoup quand on mélange avec du HTML et évidemment ça va fonctionner.

+ index.php
```php
	<h1>Ma page web</h1>
		
	<?= "Bonjour" ?>
```
```powershell
	http://localhost/PHP/cours/005_affichage/
	Ma page web
	Bonjour
```
Si je regarde au niveau du code source.
```php
	<html><head></head><body><h1>Ma page web</h1>
		
	Bonjour</body></html>
```
On a le code HTML d'afficher alors que pour Bonjour, il nous met juste le texte. 

Ça c'est un raccourci que vous allez beaucoup utiliser quand vous mélangerez du PHP avec du HTML pour afficher du texte par exemple où afficher le contenu d'une variable comme on le verra dans la séance prochaine ou ce genre de chose donc on met ce symbole là `<?= ensuite l'information à affichée "Bonjour" et on termine par ?>`. 

Et après on peut très bien remettre du acheté ml si on veut.

+ index.php
```php
	<h1>Ma page web</h1>
		
	<?= "Bonjour" ?>

<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ullam suscipit praesentium, quos molestiae quo natus debitis consequuntur quas ex, error asperiores libero alias, quod obcaecati veritatis vitae. Nan, minus. Fuga?</p>
```
```txt
	http://localhost/PHP/cours/005_affichage/
	Ma page web

	Bonjour

	Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ullam suscipit praesentium, quos molestiae quo natus debitis consequuntur quas ex, error asperiores libero alias, quod obcaecati veritatis vitae. Nan, minus. Fuga?
```
Voilà c'est géré bien évidemment et donc vous pouvez voir que au niveau du HTML c'est particulièrement gérer comme il faut.
```php
	<html><head></head><body><h1>Ma page web</h1>
		
	Bonjour
	<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ullam suscipit praesentium, quos molestiae quo natus debitis consequuntur quas ex, error asperiores libero alias, quod obcaecati veritatis vitae. Nan, minus. Fuga?</p></body></html>
```
Et on ne voit pas de différence à l'affichage entre le PHP (Bonjour)  et HTML (Lorem …), ça s'affiche pareil. Voilà c'est au niveau du code source qu'on verra l'utilisation au nombre de balises donc ça c'est quelque chose à savoir ce type de syntaxe. 

Ok donc je fais un petit rappel éventuellement, vous allez avoir ceci.

+ index.php
```php
	<?php
	echo "Bonjour";
	echo "bon", "jour";
	?>

	<?= "bonjour" ?>
```
```powershell
	http://localhost/PHP/cours/005_affichage/
	Bonjourbonjour bonjour
```
Voilà ça c'était pour montrer par contre là vous allez voir qu'il y a un espace après `?>` du fait qu'on ai fermé la valise donc voilà mais je peux faire ça.

+ index.php
```php
	<?php
	echo "bonjour ";
	echo "bon", "jour";
	?>

	<?= "bonjour" ?>
```
```txt
	http://localhost/PHP/cours/005_affichage/
	bonjour bonjour bonjour
```
Voilà donc 3 syntaxes différentes pour faire la même chose comme ça vous verrez en fonction : `<?= "bonjour" ?>`, celle-là vous servira beaucoup avec HTML alors que celle là `echo "bonjour ";` est celle que vous rencontrerez le plus alors que `echo "bon", "jour";` peut arriver de temps en temps et là syntaxe qu'on a vu, le fameux echo comme ceci `echo ("Bonjour");`

+ index.php
```php
	<?php
	echo "bonjour ";
	echo "bon", "jour";
>	echo ("bonjour");
	?>

	<?= "bonjour" ?>
```
```txt
	http://localhost/PHP/cours/005_affichage/
	bonjour bonjourbonjour bonjour
```
Comme c'est une syntaxe `echo ("Bonjour");` qui est évidemment similaire à l'utilisation de fonction et comme echo n'est pas une fonction, vous l'avez honnêtement assez rarement donc à éviter dans la mesure du possible et en plus cette syntaxe ne gère pas les espaces selon les cas.

+ index.php
```php
	<?php
	echo "bonjour ";
	echo "bon", "jour ";
>	echo ("bonjour");
	?>

	<?= "bonjour" ?>
```
```txt
	http://localhost/PHP/cours/005_affichage/
	bonjour bonjour bonjour bonjour
```
Et vous voyez donc quand on change la syntaxe `echo ("bonjour ");` il ne va pas gérer les espaces selon les cas. C'est ça donc si vous mettez des espaces `("bonjour ")`, il ne va tout simplement pas les prendre en compte. C'est pour ça que cette syntaxe est vraiment très peu utilisée, elle n'est pas spécialement recommandable au niveau du echo. 

Voilà comme ça au moins je vous ai tout montré comme ça vous savez que ça existe et c'est donc l'intérêt de cette vidéo, ce que vous montrez que ça existe et pas que c'est une erreur ou autre. Voilà c'est bien de savoir ce qui existe ou pas au niveau du langage. 

Voilà pour l'affichage au niveau de PHP principalement avec echo. 

Alors echo en revanche c'est un cas particulier parce qu'il y a certains cas où ça ne fonctionnera pas où je ne peux pas forcément vous montrer la syntaxe parce que ce sont des choses beaucoup plus avancées mais par exemple on ne pourra pas l'utiliser dans un contexte de fonction. 

Admettons je ne sais pas je vais vous dire un exemple tout bête, on peut faire une condition donc par exemple vérifier l'âge d'une personne. Si l'âge de la personne est plus grand qu'un certains nombres, on veut afficher qu'elle est majeure donc plus grand que 18 ans ou égal, si elle est inférieure à 18 on voudrait que afficher que les mineurs. Et bien dans ce genre de cas, on ne pourra pas faire un echo, ça ne fonctionnera pas, on verra plus tard pourquoi ça ne fonctionnera pas mais là je ne vais pas vous montrer parce que ça va compliquer cette première séance. 

Pour cela on a une autre structure de PHP, autre que echo qui permet de faire exactement la même chose que echo par contre elle sera utilisée dans des contextes de fonction comme on le verra par la suite et c'est notamment la structure print, attention pas autre chose c'est vraiment print, et là elle fonctionne pareil.
```php
	<?php
	print "ok ";
```
Elle fonctionne pareil, c'est vraiment la même chose que echo.
```php
<?php
print "ok ";
```
```txt
	http://localhost/PHP/cours/005_affichage/
	ok
```
C'est exactement la même chose sauf qu'elle comme on le verra plus tard elle pourra être utilisée au sein d'un contexte de fonctions, chose que echo n'est pas compatible de cette manière là alors que print oui. 

C'est pareil, prix vous le verrez quand même beaucoup moins souvent puisqu'on doit l'utiliser dans des contextes de fonction c'est assez rare, souvent on passe plutôt par des variables plutôt que de faire un affichage direct donc honnêtement moi print je n'utilise jamais. Je vous le dis clairement sur tous les sites web que j'ai pu faire ou autre, print je ne m'en sers pas parce que j'en ai pas l'utilité. 

Je travaille souvent avec des echo voir directement avec de l'HTML puisqu'on mélange très souvent les 2, la plupart du temps l'affichage se fait directement en HTML ou avec le raccourci echo je dois tout à l'heure `<?= … ?>` voilà. Principalement ça se fait beaucoup plus que ça mais je vous en parle parce que c'est bien de savoir que ça existe également en termes d'affichage et notamment en PHP. 

Et en plus c'est valide ici comme on le verra par la suite quand on commencera à parler des conditions des boucles et cetera, c'est valide dans un contexte de fonction donc ça j'en parlerais bien évidemment plus tard de print dans les vidéos prochaines. 

Voilà ce sont des choses à savoir. 

Maintenant vous savez comment afficher du contenu en comment PHP, du texte tout simplement alors ce qu'on peut voir également parce que ça a quand même son importance c'est de voir comment faire des commentaires parce qu'en général quand je vous fais une formation sur des langages de programmation, je vous explique comment faire des commentaires. 

Site HP votre premier langage, un commentaire sachez simplement que c'est quelque chose qui va vous permettre de décrire une partie de votre code, une fonction, une classe comme on verra plus tard mais sans que ce soit interprété. 

Vous avez 2 types de commentaires. 

Vous avez un commentaire sur une seule ligne qui se met avec un double slash `//`. Par exemple on peut faire ceci.
```php
<?php
//La prochaine ligne dit "bonjour"
echo "Bonjour !";
```
Et si j'exécute.
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour !
```
On regarde le code source.
```txt
	Bonjour !
```
Et on voit que le commentaire n'est pas affiché. 

Ce n'est pas affiché parce que c'est un commentaire PHP, et comme je vous avais expliqué PHP on n'affiche pas le code source du PHP, c'est protégé, il est masqué, on ne peut pas le voir avec un navigateur. Il faudrait pirater le site pour récupérer le fichier en question ou bien trouver une faille pour récupérer le code. 

Le code PHP bien évidemment n'est pas visible, on ne peut pas le retrouver directement dans un code source. 

Par contre si ça avait été … et ça vous l'avez vu en HTML notamment … un commentaire HTML. Je vais juste mettre un commentaire en HTML qui se fait comme ceci.

+ index.php
```php
	<!-- Un commentaire HTML -->

	<?php
	//La prochaine ligne dit "bonjour"
	echo "Bonjour !";
```

Toujours pareil sans surprise pour ceux qui ont déjà fait du HTML, vous savez que le HTML est visible dans le code source et donc lui il sera affiché évidemment.
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour !
```
On regarde le code source.
```php
	<!-- Un commentaire HTML -->

	Bonjour !
```
Donc le commentaire HTML lui évidemment sera affiché donc attention à la différence entre les 2 commentaires mais pour PHP c'est ça. 

Un commentaire ce n'est pas du code en réalité, c'est juste une instruction qui sert au programmeur, à celui qui va voir le code source pour pouvoir l'aider par exemple quand vous avez une fonction un peu compliqué … plus tard quand on fera une portion de code vous allez avoir besoin d'expliquer éventuellement, vous pourrez le faire avec des commentaires et si le commentaire a besoin de tenir sur plusieurs lignes … le commentaire qu'on dit du c++ qu'on retrouve beaucoup pour les langages comme le c et le c++ qui est celui là `/ * ... * /`.

On est en fait un slash et une étoile, on met le commentaire sur plusieurs lignes si on veut, et pour le terminer on est l'inverse une étoile et un slash donc ça c'est un commentaire de plusieurs lignes.

+ index.php
```php
	<!-- Un commentaire HTML -->

	<?php
	/ * La prochaine ligne 
	dit "bonjour" * /
	echo "Bonjour !";
```

Voilà ça c'est un commentaire de plusieurs lignes. 
```txt
	http://localhost/PHP/cours/005_affichage/
	Bonjour !
```
Pareil je peux vous montrer le code source.
```txt
	Bonjour !
```
Le commentaire n'est évidemment pas affiché, c'est vraiment donc pour celui qui a accès au fichier donc en l'occurrence c'est intéressant pour le programmeur. 

Plus tard vous verrez que dans les programmes un peu plus étoffé, ça va quand même pas mal nous servir pour détailler certains usage, certaines fonctions au niveau de notre programmation donc ça servira. 

Je voulais vous montrer ces 2 syntaxes parce qu'elles sont bien évidemment à savoir, c'est bien de savoir commenter son code dans certains cas pour des fois expliquer des passages un peu compliqué mais attention ça ne dispense pas de rendre le code visible.

Ce sera toujours mieux d'avoir un code qui est clair en lui-même tout seul plutôt que d'avoir un code avec des noms bizarres comme vous le verrez par la suite avec les variables et puis essayer de tout expliquer via des commentaires. 

L'intérêt c'est que déjà le code en lui-même soit suffisamment compréhensible mais des fois malgré tout ce qu'on veut faire au niveau du code, ce n'est pas assez et des fois c'est un petit peu trop compliqué donc on est obligé de mettre des commentaires pour préciser certaines choses et que ce soit clair pour le programmeur qui éventuellement va relire votre code et même pour vous-même. 

Par exemple, un site web ou un programme mettez l'autre côté pendant quelques mois et revenez sur le code après, si vous n'avez pas fait soit est un code clair soit mis des commentaires, vous serez peut-être même incapable de relire votre propre code ou de comprendre ce que vous aviez essayé de faire. 

Ça c'était un cas que vous allez rencontrer dans certaines périodes donc essayez de bien détailler ce que vous faites il faut que ce soit suffisamment lisible en tout cas. 

Voilà je pense que pour cette vidéo on va s'arrêter là, elle était mine de rien même si on n'a pas vu énormément de choses, on a dit beaucoup de trucs. Je vous ai raconté beaucoup de choses et je vous ai présenté pas mal de choses également donc je vous ai fait des petit rappel encore une fois sur tout ce qui est à savoir en informatique c'est-à-dire l'affichage des extensions, utilisez votre éditeur de code et bien travailler en utf 8, ça j'insiste bien. Voilà faites attention à ça géré bien tout ça. 

Peu importe la formation que vous suivez sur ma chaîne en programmation, veuillez à avoir ces 3 choses-là qui soit complètement faites pour être sûr de ne pas avoir de problème. 

Et là on a vu tout simplement comment afficher du texte avec echo, on a vu également une autre structure print, et donc je rappelle echo et print sont des structures du langage, des structures de PHP et non pas des fonctions. Ça c'est super important. 

Si un jour vous voyez quelqu'un vous dire que echo est une fonction, vous pourrez lui expliquer que non et que c'est une structure de langage et lui dire pourquoi parce que je vous aime montrer justement pourquoi. 

Et voilà on aura vu ça et ensuite les commentaires qui était le petit bonus de la vidéo pour vous montrer tout simplement comment ça fonctionne. 

On se retrouvera du coup pour la prochaine séance et aller un petit peu plus loin donc là c'est vraiment la base de la base. 

On va commencer à aller un petit peu plus loin, et en fin de vidéo parce que ça peut quand même être intéressant, par la suite on verra comment travailler avec du HTML un petit peu donc n'hésitez pas en parallèle avant même d'attaquer cette formation, à voir la formation HTML ça pourra toujours vous servir pour la suite notamment quand on l'évoquera sur cette vidéo-là. 

À bientôt tout le monde pour la séance numéro 6