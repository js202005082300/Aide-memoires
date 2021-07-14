# [19. Introduction POO](https://www.youtube.com/watch?v=iD2JOTVbOjc)
01-12-20

Bonjour tout le monde et bienvenue sur cette 19e séance en PHP.

On a terminé un chapitre sur une grosse partie liée au procédural qui est paradigme que vous pouvez utiliser en PHP. 

D'ailleurs si vous ne savez pas ce que c'est qu'un paradigme, vous pouvez retrouver une vidéo sur la chaîne dans la playlist aide générale. 

Vous avez une vidéo Aide sur les paradigmes en programmation comme ça vous aurez un petit peu le détail pour ceux que ça intéresse. 

J'ai publié ça récemment au moment où j'enregistrais cette vidéo PHP.

Là nous allons attaquer un nouveau paradigme, un nouveau chapitre très important en PHP c'est-à-dire la programmation orientée objet. 

On va donc pouvoir programmer d'une autre manière parce qu'un paradigme c'est ça en fait, c'est tout simplement une autre façon de coder notre programme pour réaliser nos applications et en l'occurrence nos applications web. 

On va regarder du coup tout ça. 

Alors il n'y aura pas grand chose dans cette vidéo et ce soir assez court parce que c'est vraiment la petite vidéo d'introduction et donc je vais juste vous expliquer un petit peu ce qui vous attend, les notions que nous allons aborder pour savoir un petit peu comment ça fonctionne. 

Alors jusqu à présent PHP a été un langage uniquement procédural c'est-à-dire sans trop rentrer dans les détails parce que j'ai quand même fait une vidéo là-dessus.

On traite en fait les instructions une à une donc en gros on a tout un ensemble d'instructions à gérer et qui sont si vous voulez rassembler dans des fonctions d'accord ce qu'on appelait anciennement des procédures justement. 

À partir de là on peut faire différents appels à nos fonctions pour produire notre code en fonction de ce que nous voulons faire. 

La programmation objet a été instaurée à partir de PHP 5, alors c'était déjà un petit peu avec PHP 4 mais on va dire que c'est seulement depuis PHP 5 en fait qu'il y a un support complet. On va donc mettre ça, support complet de PHP 5 pour ceux qui veulent savoir comment ça se passait.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
```
C'est vraiment donc avec PHP 5 qu'on a eu un support complet noise avec toutes les notions que l'on connaît bien en technologie orientée objet avec la version 5 de ce langage d'accord. 

Ça permettait simplement d'apporter plus de performance puisque dans certains cas la programmation objet peut donner un gain de performance.

Alors ça dépend évidemment des types de projets mais en tout cas dans ce cas-là c'était fait pour ça et surtout l'ajout de nouvelles fonctionnalités, ça nous permet de faire beaucoup plus de choses comme la réutilisation de code ça c'est une chose mais aussi au niveau de la visibilité dont on parlera plus tard et tout un tas d'autres fonctionnalités intéressantes que la partie procédurale ne proposait pas forcément. 

Du coup on va aborder pas mal de notions sur ce chapitre là qui sera quand même un chapitre assez long. 

Il y aura quand même pas mal de vidéos, pas loin d'une dizaine je dirais à peu près sur ce chapitre là de secours en PHP sur différentes notions que nous allons aborder. 

Nous allons d'abord aborder … ce ne sera pas forcément dans l'ordre que je vais vous les noter ici, je note plus par rapport à ce qui me vient en tête par rapport aux choses que nous allons voir mais tout n'y sera pas il y aura probablement plus de choses que ce que je vais vous noter ici. 

On va donc parler de classes et d'objets.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets
```
Ce sont des choses que vous verrez. 

La classe ou vrai que c'est une sorte de modèle qui permet de définir une entité et ensuite on instanciant cette classe donc en créant une version concrète de cette classe, on obtient ce qu'on appelle un objet, une instance de classe c'est un objet. 

On en parlera donc. 

On parlera également de visibilité.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
```
On parlera de visibilité parce que une classe peut contenir pas mal d'informations très importantes qui la définissent justement et il y aura toute une notion de visibilité donc de ce qui est accessible ou non dans la classe. 

On en parlera beaucoup parce que ça a vraiment son importance et son intérêt en PHP. 

On parlera évidemment et ça c'est autre chose encore, on aura l'occasion d'aborder ce qu'on appelle les classes abstraites ou méthode abstraite mais on en parlera un peu plus.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites
```
On a aussi tout ce qui est finales, vous verrez que c'est un mot-clé assez spécial, créer par exemple une classe finale, une méthode finale et ce sont des choses sur lesquelles nous reviendrons.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
```
Nous parlerons bien évidemment des fameux attributs et méthodes, où propriété parce que en fait on ne fait pas tellement la distinction entre attributs et propriétés.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
```
Je le dis parce que dans certains langages comme python, on définit quand même pas mal l'attribut et la propriété. L'attribut c'est un membre d'une classe mais sans rentrer dans les détails, et la propriété permet d'appliquer un filtre, une manière d'accéder ou de modifier cet attribut donc ce sont des cas particulier. 

En PHP on utilise un petit peu le même nom pour définir la même chose donc c'est pour ça que je tenais à préciser. Les méthodes on en parlera aussi au moment où on y sera sur la vidéo en question, je vous expliquerai dans le détail à quoi ça correspond. 

On va également parler d'héritage, très important.

	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
						 héritage

On parlera certainement de polymorphisme parce que ce sont également des notions en objet qu'on le retrouve dans pas mal de langage surtout les langages qui peuvent utiliser le paradigme objet et qui généralement abordent ces notions là parce qu'elles sont vraiment importantes à connaître donc c'est plus la notion que vous allez peut-être apprendre si PHP est le premier langage de programmation objet, qui utilise le paradigme objet, que vous abordez. 
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
						 héritage, polymorphisme
```
Après si vous en avez déjà vu d'autres avant comme le c plus plus ou le Java, CSharp ou autre, vous ne serez pas trop dépaysé parce que vous allez pas mal réutiliser et revoir des notions que vous connaissez déjà un peu près donc ce sera évidemment plus rapide pour vous à apprendre. 

On parlera également d'interface, ça on verra.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
						 héritage, polymorphisme
						 interfaces
```
On va parler d'exception, c'est une autre manière de gérer nos erreurs via des méthodes objets. On a vu comment gérer des erreurs en type procédurale mais on verra qu'on pourrait également utiliser ce qu'on appelle les exceptions.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
						 héritage, polymorphisme
						 interfaces, exceptions
```
Et on parlera des notions un peu plus récentes comme les traits par exemple qui est une notion qui n'est pas forcément comprise quand des gens abordent PHP.
```txt
	Introduction à la programmation objet en PHP
	--------------------------------------------
	> Support complet depuis PHP 5
	> Notions abordées : classes, objets et visibilité
						 classes abstraites, finales
						 attributs (ou propriétés) et méthodes
						 héritage, polymorphisme
						 interfaces, exceptions
						 traits
```
On verra tout ça voilà.

Il y a certainement beaucoup d'autres choses que j'ai pu oublier par rapport à ce que j'avais là tout de suite en tête mais voilà c'est grosso modo pour ceux qui voient cette vidéo qu'ils voient un petit peu près ce qu'on va aborder. 

Et de toute façon on fera le tour vraiment de tout, tout ce qui concerne tes PHP.

Une grosse partie comme vous le savez pour ceux qui ont l'habitude maintenant de voir mes formations sera traité dans le cours parce que j'estime que c'est essentiel, pour voilà manipuler correctement un langage. 

Et après tout ce qui me paraît plus secondaire et facultatif, qui n'est pas forcément obligatoire, vous le retrouverez en vidéo en annexe dans la playlist PHP tutoriel.

Voilà pour ceux qui sont débarqués sur la chaîne depuis récemment, sachez que je fonctionne comme ça. 

Je propose ce qui me semble essentiel et obligatoire à voir dans le cours, et ensuite dans la playlist tutoriel j'aborde des choses en annexe, des choses facultatives, des choses secondaires que vous êtes libre comme ça ou non de voir. 

Si vous ne voyez pas les tutoriels dans le langage de programmation comme ça en particulier ou autre, ce n'est pas trop gênant. 

Vous pourrez très bien vous débrouiller malgré ça mais évidemment les tutoriels apportent un complément, un supplément d'information et de choses en plus qui peuvent servir quand même. 

Voilà pour cette partie. 

C'était donc très court comme introduction car le but était de faire un petit peu le tour de tout ce qui vous attend, de démarrer tranquillement et de ne pas commencer dès le début a attaqué les premières notions avec tout un tas d'explications, une vidéo d'une demi heure comme vous avez l'habitude d'en voir. 

Vous avez le schéma de ce qui vous attend pour les prochaines vidéos. 

Il y aura grosso modo une dizaine de vidéos, le temps de faire le tour il nous faudra bien ça vu tout ce qu'il y a à moins qu'il y ait des choses qui passent sous forme de tutoriel en annexe mais ça je verrai à ce moment là. 

Je n'ai pas forcément réfléchi au suivi des vidéos que je vais faire sur ce chapitre même si j'ai plus ou moins avant-goût de ce qui va être abordé. 

Je vous dis du coup à bientôt pour la suite si d'ici là il y a déjà des questions par rapport à ça, que j'ai pu oublier certaines choses ou alors que vous voulez vous rassurer sur certaines choses, vous voulez vous rassurer sur des notions qui sont vues ou des choses que nous allons aborder avec son langage PHP n'hésitez pas à le dire dans les commentaires. 

Comme d'habitude, même si je ne le dis pas souvent n'hésitez pas à liker si vous avez aimé la vidéo, n'hésitez pas à la partager également surtout si vous vous servez des réseaux sociaux. C'est un moyen très rapide pour transmettre des infos, pour balancer des vidéos, faire des partages de publication. Ça va très très vite d'autant que je publie un peu partout sur les réseaux moi aussi. 

Partager cela avec un maximum de monde pour faire découvrir la chaîne à d'autres personnes, que la chaîne grimpe en visibilité, en abonnés et que ça puisse profiter encore à plus de monde que maintenant. 

À bientôt pour la prochaine vidéo sur cette formation PHP. 

Ciao tout le monde

>

## Introduction à la programmation objet en PHP		| 28-03-20

La vidéo #19 est une introduction à la programmation orientée objet en PHP pour découvrir une autre manière de coder vos applications web.

Avant la vidéo #19, la matière s'orientait procédural qui est un des paradigme que l'on peut utiliser en PHP (voir playlist 'aide générale').

Un paradigme est une autre façon de coder un programme pour réaliser notre application web.

Avant PHP était un langage uniquement procédural. C'est à dire, on traite les instructions une à une. Elles sont rassemblées dans des fonctions, appelées des procédures. On peut faire différents appels à nos fonction pour produire ce que l'on veux faire.


1. Support complet de POO depuis PHP 5.

Cela a apporté plus de performance mais surtout l'ajout de nouvelles fonctionnalitées au niveau du code et de la visibilité, pas forcément proposé par la partie procédurale.

2. Notions abordées : 
    - classe = modèle qui permet de définir une entitée. Ensuite en instanciant cette classe (en créant une version concrète de cette classe), on obtient un objet.
    - objet = une instance de classe.
    - visibilité = une classe contient pas mal d'informations qui la définissent avec une notion de visibilité, de ce qui est accessible ou non.
    - classe abstraite (ou méthode abstraite).
    - finales = mot clé pour une classe finale, une méthode finale.
    - attribut (ou propriété) = membre d'une classe (alors que la propriété, tel que définie en Python, permet d'appliquer un filtre Et qui permettent d'accéder ou de modifier cette attribut). 

En PHP, on utilise un peu les mêmes noms.
    - méthode.
    - héritage.
    - polymorphisme, propre au paradigmes objets.
    - interface.
    - exception = manière de gérer nos erreurs via des méthodes objets après avoir vu comment gérer des erreurs en type procédurale.
    - trait = notion en PHP.