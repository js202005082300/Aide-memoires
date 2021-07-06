# [10. Programmation objet](https://www.youtube.com/watch?v=s2pnrMKpEp0)

+ [Classe](#Classe)
plan de conception, genre (ex : Humain)
+ [Objet](#Objet)
instance de classe (ex : Julien)

+ [Attribut](#Attribut)
variable de classe (ex : prénom, age, sexe, taille, …)
+ [Propriété](#Propriété)
manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

+ [Méthode](#Méthode)
fonction d'une classe (ex : manger, marcher, parler, dormir, mourir)
+ [Méthode de classe](#Méthode-de-classe)
fonction d'une classe (explications à venir plus tard…)
+ [Méthode statique](#Méthode-statique)
fonction d'une classe, mais indépendante de celle-çi.

+ [Héritage](#Héritage)
classe fille qui hérite d'une classe Mère (Fille est sorte de Mère)
classe Chat hérite de la classe Animal (Chat est une sorte d'Animal)

+ [Bonus - Les chaînes de caractères sont des objets de classe str](#Bonus---Les-chaînes-de-caractères-sont-des-objets-de-classe-str)

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

"""
```
Bonjour à tous, bienvenue pour cette nouvelle séance sur le langage python.

Aujourd'hui, on va faire l'introduction de la programmation orientée objet ce qu'on appelle plus couramment la POO et je vais plutôt que commencer directement à coder, ça va être une séance, en fait, où je vais simplement vous appliquer les notions, les concepts que nous avons abordés.

On va faire un petit un petit récapitulatif de tout ce qu'on a vu jusqu'à présent plutôt que de commencer directement à coder, d'attaquer cette partie-là qui va quand même être assez conséquente puisque tout le langage tiens justement sur cette partie objet.

Du coup pas de codage pour cette séance là, ça va être l'occasion de faire une petite pause tout simplement, de voir un petit peu ce qu'on a vu.

Alors vous êtes maintenant normalement en mesure de faire pas mal de petites choses déjà avec le langage python. Vous avez vu comment afficher du texte. Je vais le noter au fur et à mesure comme ça on verra un petit peu globalement.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
"""
```

Afficher du texte. Vous avez vu comment saisir des informations donc avec print(), avec input().

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
"""
```
Vous avez vu les variables.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
-
"""
```

On a vu également tout ce qui était conditions et boucles, voilà.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
- Conditions et boucles
"""
```

On a parlé des fonctions et de la modularité donc comment faire des modules, utiliser les fonctions des modules qui sont des fichiers et rappelez-vous, pour le petit rappel, quand vous avez un répertoire qui contient plusieurs modules, d'accord, donc un dossier sur votre Windows, sur votre Linux, votre MacOS, ça s'appelle un package, tout simplement.

C'est simplement un dossier qui contient plusieurs fichiers de modules donc plusieurs fichiers avec une extension point py, voilà voilà.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
- Conditions et boucles
- Fonctions et modularité
"""
```
Et ensuite, on a vu, un petit peu, comment gérer les erreurs.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
- Conditions et boucles
- Fonctions et modularité
- Gestion des erreurs
"""
```

Voilà un petit peu tout ce que nous avons vu, jusqu'à présent, donc c'est déjà pas mal parce que vous avez vu vraiment le principal pour pouvoir manipuler un peu tout et n'importe quoi en python.

Et maintenant, nous allons vraiment parler d'objets.

Alors je vous avais expliqué que le langage python contrairement à d'autres langages comme le C ou C++, même d'ailleurs, est un langage qui est tout objet, ça veut dire que même si vous faites qu'afficher du texte, même si vous saisissez, par exemple, quelque chose dans une variable de type int donc un entier. Le int donc le interger, le String pour la chaîne de caractères str et cetera, tout ça, ce sont des classes.

Vous manipulez, en fait, des objets mais comme ce sont des classes natives donc des objets natifs du langage, ils sont implicites, ils sont un petit peu masqué, vous les utilisez sans vous en rendre compte.

Donc en réalité, quand vous faites, par exemple, ceci. Je vous montre en termes de code.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
- Conditions et boucles
- Fonctions et modularité
- Gestion des erreurs


ageUtilisateur = 14
"""
```

"ageUtilisateur = 14", vous créez un objet de classe int, donc integer, tout simplement, qui est un entier.

C'est pour ça que je vous avais rappelez normalement, quand on faisait par exemple ça donc on l'affichait bien sûr. "type(ageUtilisateur)". Ça affichait quelque chose du style, je sais pas moi, du style quelque chose comme ça dans le terminal <class 'int'>.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

- Afficher du texte
- Saisir des informations
- Variables
- Conditions et boucles
- Fonctions et modularité
- Gestion des erreurs

ageUtilisateur = 14
type(ageUtilisateur) -> <class 'int'>
"""
```

Ca affichait cela <class 'int'> dans le terminal ou même sans les simples cotes, enfin peu importe, donc ça m'était "class int" et pour vous dire, voilà, que ça appartient … c'est un objet de classe integer et l'objet, c'est ça "ageUtilisateur", c'est l'âge utilisateur.

Donc tous est objet en python, c'est super important puisque contrairement à d'autres langages, vous ne pouvez pas vous dire, par exemple, je ne fait pas d'objet avec python. Ce n'est juste pas possible, le langage est basé entièrement sur ça.

Du coup je voulais profiter de cette petite vidéo d'introduction pour pouvoir vous parler un petit peu du jargon donc du vocabulaire qu'on voit en informatique puisque là, ce qu'on appelle la POO où la PO, programmation objet, ainsi on peut dire orienté ou non, enfin peu importe le mot n'est pas obligatoire.

Donc tout ce qui est technologie orientée objet, programmation objet, programmation orientée objet, vous voyez, il y a déjà plusieurs manières d'en parler.

C'est une manière en fait de coder, ce n'est pas propre au python, pas propre au C++ ou au Java. C'est simplement ce qu'on appelle un paradigme.

Un paradigme, c'est une manière de coder, d'organiser son code, de coder d'une certaine manière avec différents moyens, on a la programmation procédurale, on peut programmer de manière impérative, de manière fonctionnelle, par contrat, par flux.

Il y a plusieurs manières et il y a également la programmation objet donc ça va être simplement une autre manière d'organiser son code pour qu'il offre bien évidemment certains avantages ou des inconvénients aussi, hein ça apporte son lot d'inconvénients toujours mais c'est simplement ça.

C'est pour ça qu'on parle de paradigme, d'ailleurs pour ceux qui ont déjà fait du C++. Le C++ est réputé pour être un langage qu'on dit multi paradigme c'est-à-dire qu'il permet de programmer de plusieurs manières différentes.

Le Python, c'est de l'objet donc c'est vraiment un langage tout objet donc vous ne pouvez pas vous dire bah tiens je fait uniquement du procédurale, il y a toujours des classes, des objets qui sont derrière tout ça, voilà voilà.

On va maintenant, un petit peu, je vais vous parler en tout cas de quelques notions de base, simplement parce qu'au niveau jargon informatique, au niveau vocabulaires, on va avoir comme je vous l'ai dit la partie programmation objet qui est global à tous les langages, d'accord.

Quand on parle d'une classe, c'est la même chose que ce soit du Python, du C++, du Java, du CSharp, ce que vous voulez, ça ne change pas. Pareil pour les méthodes et cetera.

Par contre, on a certains termes où ils ne sont pas forcément les mêmes d'un langage à l'autre, alors à la base ça pourrait être tous les mêmes, le problème c'est qu'il y a des langages qui prennent leur propre définition, qui l'a déformes pour en faire leur propre définition à eux.

Et le problème c'est que, voilà, sur les forums, les canaux de discussion, les gens ne sont jamais d'accord puisque, par exemple, une classe, enfin une propriété, ça va être tel chose en python mais ça ne va pas être pareil en C++ et cetera.

Donc histoire de s'y retrouver, entre nous, puisque vous suivez un petit peu cette formation et que tout le monde soit un petit peu sur un même pied d'égalité, sur la même base, on va définir globalement le jargon général même si on ne va pas tout voir dans cette vidéo sinon on aurait  une vidéo de 3h mais d'avoir déjà quelques termes que l'on va employer puis que je vais vous expliquer.

C'est pour ça, que je vous dis plutôt que de commencer à faire du code, à créer des programmes et cetera, on va déjà définir quelques notions pour comprendre un petit peu comment ça marche. 

Alors, on a la première chose puisqu'on parle de programmation objet, on va commencer à parler des classes, qu'est-ce qu'une classe, tout simplement.

## Classe

Alors une classe, si je devais vous donner une définition très simple, c'est un petit peu, c'est comme un plan, euh je ne sais pas moi, un plan de conception peut imaginer quelque chose comme ça.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe : plan de conception, 
"""
```

Pas une structure parce que le problème c'est qu'une structure, c'est utilisé en informatique pour décrire autre chose.

On va mettre un plan de conception, voilà on peut imaginer. Un genre, quelque chose comme ça, et je vais donner un exemple, on va prendre l'exemple au fur et mesure, ça je vais dire, on ne programme pas, on reste vraiment sur quelque chose de tout à fait vulgariser pour que ce soit clair pour tout le monde… puis, vous, ça vous fait une petite pause comme ça vous avez vu beaucoup de choses, ça vous permet d'avoir quelque chose d'un petit peu plus souple, un peu plus dire calme pour cette séance-là.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe : plan de conception, genre (ex : )
"""
```

Et on va prendre un exemple de classe, on va l'appeler humain, d'accord.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe : plan de conception, genre (ex : Humain)
"""
```

Donc vous imaginez, voilà un humain, l'humain c'est une classe. On a un plan pour concevoir des humains, ça semble bizarre. Un genre, le genre humain, tout de suite, ça parle beaucoup plus donc vous allez voir, vous allez comprendre par la suite.

Donc une classe, c'est tout simplement ça. Si on va définir, je ne vous  montre pas comment que ça se présente au niveau du code, on le verra dans la séance suivante quand on commencera.

Dans la prochaine séance, on commencera à mettre tout ça en place au niveau code python.

## Objet

On a ensuite ce qu'on appelle les objets, d'accord.

Un objet, c'est une instance de classe.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe : plan de conception, genre (ex : Humain)
Objet : instance de classe
"""
```
Une instance de classe, c'est simplement qu'on va produire quelque chose qui est du genre de votre classe, qui est cette classe.

Donc une instance de classe, ça peut être par exemple, nous on va quelqu'un, voilà notre Julien par exemple voilà, d'accord.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe : plan de conception, genre (ex : Humain)
Objet : instance de classe (ex : Julien)
"""
```

Julien est un objet d'accord, donc c'est un objet qui est de classe humain, d'accord. Donc Julien est un humain, c'est comme ça qu'on peut le voir, en fait, d'accord, Julien est un humain donc il a été créé, en fait, par ça (Humain).

Ça veut dire qu'on avait un plan, on peut imaginer, voilà, comment fonctionne, comment est conçu un humain, d'accord. C'est son plan de conception, c'est la classe et à partir de là, on peut créer un Julien et Julien est un objet qui est de classe humain.

On peut créer un autre, voilà on peut créer Mathilde, on peut créer n'importe qui, qui sera de cette même classe mais ce seront chacun des objets différents. Mathilde ne sera pas Julien, d'accord. Je pense que tout le monde comprend bien à ce niveau-là.

Donc voilà ce qu'est un objet, c'est une instance de classe donc ça c'est des termes très technique. On parle d'instance, instancier une classe donc simplement c'est créer un objet, tout bêtement.

Donc ça, ce sont 2 termes qu'on retrouve. 

En général, les différences … il n'y a pas de différence entre les langages. Ça tout le monde se met d'accord, qu'est-ce qu'une classe ? qu'est-ce qu'un objet ? j'ai pas vu beaucoup de gens qui n'étaient pas d'accord avec ces notions, ces définitions.

Là-dessus, tout le monde est à peu près d'accord donc c'est déjà pas mal.

## Attribut

Là on va rentrer sur un peu plus compliqué. On va avoir les termes d'attribut, d'accord, et on va avoir les termes de propriété et vous allez voir qu'on tombe sur autre chose.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	:
Propriété 	:
"""
```
## Propriété

Ça c'est 2 termes que vous allez voir également, tout au long de la formation qu'on va avoir. On va parler beaucoup d'attribut, on va parler de propriété. Q'elle est différence et cetera ?

Un attribut, de manière générale, et là je parle surtout au niveau python. C'est une variable de classe, d'accord.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe
Propriété 	:
"""
```

Elle appartient … donc vous imaginez que là (classe), vous avez plan de conception, d'accord, de la classe. A l'intérieur, vous allez avoir une variable qui est définie. Elle est définie, elle appartient à la classe, d'accord.

Donc à l'extérieur de la classe, cette variable n'existe pas, c'est un attribut. On appelle ça, un attribut de classe. Ça peut-être pour notre humain, ça peut être, par exemple, je ne sais pas moi, le nom. Je vais mettre nom, l'âge, je ne sais pas moi, plein de choses comme ça. Le sexe si c'est un homme, une femme, voilà, on peut avoir pas mal de petites choses, la taille pourquoi pas et cetera. Bref vous avez compris ce qu'est un attribut.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : nom, age, sexe, taille, …)
Propriété 	:
"""
```

J'en viens maintenant à la propriété, c'est là que ça va commencer à se compliquer. Alors dans beaucoup de langage, la plupart du temps quand on demande aux gens, je pense notamment au C++ et cetera, quand on leur demande la différence entre attribut et propriété, ils ne sont pas vraiment capable de l'expliquer puisque elle est tellement tellement subtile qu'il n'y en a pas.

Grosso modo, un attribut, c'est une propriété parce que le nom, c'est une propriété d'un être humain, d'accord, d'un humain.

L'âge c'est une propriété d'un humain, le sexe c'est une propriété d'un humain et cetera et cetera.

Alors il y en a certains des fois, il essaie de faire une différence subtile en disant l'attribut c'est plus ce qui le catégorise et la propriété c'est plus une capacité. Par exemple, votre âge c'est pas vraiment une capacité que vous avez, voilà c'est un attribut, c'est comme ça, comme l'attribut masculin et cetera et cetera. Donc c'est une chose que vous avez comme ça naturellement.

La propriété, c'est par exemple une compétence et cetera mais là, on tombe dans quelque chose qui est trop subtiles pour commencer à faire des différences.

Donc en python, ils ont quand même une différence et on aura l'occasion d'en parler. Une propriété en python donc là, je parle vraiment que pour ce langage donc ne le prenez pas en compte par rapport à d'autres langages si vous avez fait du C++, du Java ou autre, que vous suivez d'autres formations, il s'agit en fait tout simplement, on va dire, d'un moyen. C'est une manière, en fait, tout simplement donc je vais le noter. C'est une manière de manipuler les attributs, d'accord.

Donc je vais mettre, par exemple, lecture seule puis accès non autorisé en dehors de la classe et cetera, voilà ce que serait une propriété.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : nom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)
"""
```

Une propriété, on va la définir sur certains attributs. Par exemple, on va dire, je ne sais pas moi, allez admettons bon, l'objet Julien, lui, lui-même, il a le droit de modifier, par exemple, son nom.

D'accord, si un jour, il envie de modifier son nom. C'est tout à fait, d'ailleurs, un cas possible dans la réalité. Il peut modifier son nom, il peut modifier son prénom, enfin ce genre de chose.

J'aurais pu mettre prénom, c'est vrai qu'on emploie souvent nom en informatique donc on va plutôt mettre prénom, voilà ce sera plus clair.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)
"""
```

Donc Julien, il peut modifier lui-même son prénom, par contre la logique des choses, selon comment on conçoit … c'est pour ça que je vous dis que la programmation objet, c'est une manière de coder, d'accord, ce n'est pas propre à un langage. C'est vraiment général, c'est une conception, une méthode de conception, voilà une manière de coder.

Euh, on estime, par exemple, que si on avait un objet qui est de classe voiture, on n'a peut-être pas envie que voiture puisse modifier le prénom de Julien, d'accord, ou son âge ou je ne sais quoi.

Donc on peut définir une propriété, on dira je met une propriété sur l'attribut prénom, d'accord, de la classe humain en disant par exemple que j'interdit son accès en dehors. Il y a seulement, il n'y a que les humains qui peuvent modifier le prénom des humains, d'accord. On peut faire ce genre de choses.

Donc on peut définir des accès, voilà, des accès, des restrictions et cetera. "lecture seule", bah ça veut dire, par exemple, on a quelque chose qu'on peut seulement lire donc on peut le récupérer mais on ne peut pas le changer, d'accord. 

On peut … je ne sais pas, ça peut être n'importe quoi … une information, voilà, qui ne changera jamais ou autre … on dit : "tiens si je veux absolument que personne ne puisse modifier tel attribut d'une classe", voilà.

Donc voilà en python, comment on va faire cette distinction. 

Vous voyez que là, il y a effectivement une différence, l'attribut ça va être la variable d'une classe qui appartient à celle-ci et la propriété va permettre de manipuler l'attribut d'une certaine manière, de dire "bah je t'autorise son accès en dehors ou pas, c'est en lecture seule ou ça fonctionne comme çi, ça fonctionne comme ça, voilà comment on peut différencier.

Le problème, comme en C++ ou dans d'autres langages objets ou qui utilise simplement l'objet comme par rapport à un paradigme, vous verrez qu'il n'y a pas de distinction. S'il y en a, ben une variable de classe, ils vont l'appeler la propriété et puis d'autres, ils vont l'appeler l'attribut.

C'est pour ça que je vous dis, je voulais vraiment faire ce genre de vidéo, histoire de bien mettre les choses au clair pour nous, d'accord entre nous, sur cette formation en langage python.

Là, vous verrez, vous avez vraiment une différence et vous verrez qu'au niveau codage, on en aura effectivement, il y aura une manière de définir des propriétés qui sera pas du tout la même manière que définir un attribut, voilà.

Donc attribut de classe, propriété de classe, peu importe. 

## Méthode

On arrive maintenant à 3 autres noms, donc on a une méthode, on a méthode de classe et on va avoir les méthodes statiques.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	:
Méthode de classe	:
"""
```

Alors là, c'est pareil, ce n'est pas propre au langage python, c'est propre à tout ce qui est technologie objet, OK, c'est vraiment par rapport à ça donc on va mettre méthode statique, donc la méthode de classe statique, en fait, tout simplement.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	:
Méthode de classe	:
Méthode statique		:
"""
```
La méthode, c'est une fonction d'une classe, tout simplement.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe
Méthode de classe	:
Méthode statique		:
"""
```

Vous savez ce qu'est une fonction, sur des vieux langages, on parlait même de procédure. On ne parlait même pas de fonction à l'époque, hein je pense à plein de vieux langage. Une procédure, c'était tout simplement un ensemble d'instructions qu'on pouvait, comme ça, appeler rapidement via, en fait, un identifiant donc le nom de la procédure et ça permettait de faire tout un ensemble de traitements. 

Après par la suite, on a fini par appeler ça des fonctions. Sur tout ce qui est programmation de procédures et cetera, on a appelé ça des fonctions et en objet, bon on appelle ça des méthodes, d'accord.

Donc c'est une fonction d'une classe, tout bêtement.

Vous verrez qu'en plus au niveau du codage en python, il n'y a pas vraiment de différence avec comment vous créer des fonctions. On met le mot-clé DEF et on met le nom de la méthode et elle peut prendre des paramètres et cetera donc vous verrez que ça fonctionne exactement de la même manière qu'une fonction, c'est pour ça que on parle vraiment de fonction d'une classe.

Donc exemple, je prends l'exemple par rapport à l'humain, admettons notre classe humain, elle pourra avoir une méthode manger et entre parenthèses (j'aurais dû prendre des crochets mais c'est pas grave), par exemple quelle nourriture, elle mange. Je ne sais pas moi, quantité, d'accord, tu peux prendre des paramètres ou pas, c'est au choix.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger(nouriturre, quantite))
Méthode de classe	:
Méthode statique		:
"""
```

Donc ça, ce serait une méthode de la classe humain, d'accord. 

Et Julien, du coup, en tant qu'objet instancié pourrait, par la suite, utilisé cette méthode donc je ne vous montre pas, encore une fois, comme on le fera au niveau code, d'accord, c'est vraiment comme ça. Donc manger, voilà.

Donc d'ailleurs, ici, je mets des parenthèses mais non, j'ai dit que je m'étais pas de codes donc manger, marcher, parler, dormir, … encore, on peut imaginer plein de choses. Tout ce que peut faire un humain, en fait, ce sont un peu les services, qu'est-ce qu'il est capable de faire, d'accord. Donc voyez un petit peu comme ça.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	:
Méthode statique		:
"""
```

L'attribut, c'est vraiment les caractéristiques de votre classe.

Les méthodes, c'est ce qu'il peut faire, d'accord, tout ce qu'il est capable de faire. Il est capable de manger, de marcher et cetera, voilà.

## Méthode de classe

La méthode de classe, c'est un peu spécial, c'est pour ça que je vous dit il y a des choses un petit peu compliqué. C'est une méthode en fait tout simplement qui va fonctionner vraiment vraiment pour la classe. Je vais expliquer par la suite. On le définira autrement, je ne vais pas m'attarder en fait dessus puisqu'au niveau de définition, ça ne va pas changer grand-chose.

Il va vraiment y avoir une appartenance forte au niveau de la classe donc ça reste pareil, c'est une fonction d'une classe mais je ne vais pas vous détailler ça parce que ça va vous embrouiller donc on en parlera quand on les fera au niveau code. Vous comprendrez un petit peu la différence comment fonctionne l'une, comment fonctionne l'autre.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe ()
Méthode statique		:
"""
```

Donc je vais rester là puisqu'il y a des explications à venir plus tard sinon ça va vous embrouiller, ce n'est pas la peine, je ne pourrais pas l'expliquer sans code, en fait, ça ne va pas être assez clair.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		:
"""
```

## Méthode statique

Une méthode statique, c'est une fonction donc d'une classe, toujours pareil, mais indépendante. Ça veut dire que quand vous voulez utiliser une méthode, d'accord, une méthode d'une classe. Vous allez devoir créer un objet, par exemple, tant qu'on ne créé pas Julien, on ne pourra pas dire : "bah tiens il faut manger, d'accord". Il faut automatiquement qu'on ait créé un Julien pour pouvoir manger.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		: fonction d'une classe, mais indépendante de celle-çi.
"""
```

En revanche une fonction d'une classe mais indépendante, je peux très bien créer une méthode donc une fonction de classe qui puisse être utilisée même en dehors de tout objet, ça veut dire que je pourrais très bien dire, un humain, tu utilises tel méthode. Vous voyez, ça ne passera pas par Julien, ça passera par l'humain en lui-même, d'accord, l'humain, il possède un service donc ça on l'utilise beaucoup, les méthodes statiques, vous verrez par la suite donc quand on fait des classes qu'on appelle des classes utilitaires.

Une classe utilitaire c'est un petit peu une classe que l'on va pas forcément, on ne va jamais instancier dans l'absolu c'est-à-dire qu'on ne va jamais créer des objets de cette classe. On va simplement avoir une classe qui aura plusieurs méthodes, un peu comme une bibliothèque qui aurait plusieurs fonctions, on pourrait imaginer pareil, et à chaque fois qu'on voudrait utiliser une de ces fonctions, bah on mettra le nom de la classe et on précisera ensuite quelle méthode on utilise, notamment une méthode statique.

Donc vous verrez qu'il y aura une manière de définir la méthode statique pour faire la différence avec une méthode, on va dire standard.

Et méthodes de classe, je vous ai dit, on reviendra après, je donne vraiment les explications pour plus tard parce que, pareil, c'est une différence tellement minime, tellement subtile que ce sera beaucoup plus clair avec du code, avec un exemple.

Là comme je parle, que je ne fait pas de code pendant cette vidéo, je ne préfère pas vous mélanger les pinceaux dès le début. Le but justement, c'est voilà que tout le monde soit d'accord sur les termes et cetera.

Donc à la rigueur, cette méthode de classe, vous pouvez même à la rigueur l'oublier, d'accord.

Simplement que voilà, méthode statique, elle est vraiment … donc elle appartient bien évidemment à la classe mais elle peut être utilisée sans créer d'objet, d'accord.

La méthode standard faut qu'elle parte d'un objet donc ici, bah nous, ce serait notre Julien sinon bah voilà c'est différent.

Donc voilà, les classes j'ai dit … attribut, propriété, je pense que je n'aurai pas d'autres termes. On parlera, par la suite, donc j'en parle très rapidement, l'héritage.

## Héritage

Qu'est-ce que l'héritage, d'accord ? Alors l'héritage, ça va être par exemple une classe, je ne sais pas moi, une classe fille qui hérite d'une classe Mère.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		: fonction d'une classe, mais indépendante de celle-çi.

Héritage 	: classe fille qui hérite d'une classe Mère.
"""
```

Vous voyez, je ne met pas de code. 

Donc on imagine qu'on a une classe Mère, ok, et qu'on fait un héritage ensuite pour avoir une classe qu'on appellerait fille donc par exemple humain, on peut imaginer que donc humain c'est la classe mère et une classe fille, on peut très bien faire, je ne sais pas moi, autre chose, d'accord.

On pourrait très bien faire … ce serait un peu bizarre comme fonctionnement … on va prendre plutôt animal, voilà, si on avait une classe mère qui s'appellerait animal, on peut très bien faire une classe fille, qui en hérite, qui s'appellerait panda, d'accord, pour pouvoir créer plein d'objets donc plein de panda.

On pourrait avoir une autre classe fille qui s'appellerait ours et cetera, une classe chat, classe chien et cetera, d'accord.

Donc on dit en général quand on a ça, par rapport à la classe fille, on dit que fille est une … alors ça, c'est un petit moyen que je vous donne pour le retenir facilement … est une sorte de Mère. Vous allez me dire, c'est bizarre dit comme ça. 

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		: fonction d'une classe, mais indépendante de celle-çi.

Héritage 	: classe fille qui hérite d'une classe Mère (Fille est sorte de Mère)
"""
```
Donc si je devais prendre un exemple plus parlant. Par exemple, classe chat hérites de la classe animal, on dira donc que chat est une sorte d'animal, voilà.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		: fonction d'une classe, mais indépendante de celle-çi.

Héritage 	: classe fille qui hérite d'une classe Mère (Fille est sorte de Mère)
		: classe Chat hérite de la classe Animal (Chat est une sorte d'Animal)
"""
```

Et là, tout de suite, vous voyez c'est plus clair quand on emploi des termes, voilà, un petit peu plus compréhensif donc c'est, comme ça, qu'il faut le comprendre.

Et l'héritage, on en parlera, vous verrez à quoi ça sert parce  que vous allez dire : "bah oui mais ça sert à quoi en fait du coup, autant créer directement au classe Chat, une classe Chien et puis ne pas créer de classe animal à ce moment-là. 

Vous comprendrez comment ça fonctionne mais c'est comme dans la vraie vie, c'est par rapport à l'héritage, comment ça fonctionne à ce niveau-là et on parlera de spécialisation.

Par exemple, le chat, c'est une classe spécialisée par rapport à l'animal, il sait faire plus de choses qu'un simple animal, d'accord. L'animal c'est quelque chose d'abstrait, de général.

Et en le spécialisant, on peut obtenir un chat qui saura faire tout ce que l'animal connaît plus des choses en plus, d'accord.

Animal, c'est ce qui va concerner tous les animaux mais le chat, il sait faire des choses qu'un autre animal ne sait pas forcément faire donc on spécialise en créant une classe fille qu'ici serait le chat, voilà.

Et je pense qu'on en restera là pour les termes, pour les définitions globalement.

Alors maintenant qu'on a vu, grosse modo, un peu de vocabulaire et cetera, qu'on a démystifié un petit peu toute la partie programmation objet.

Quel avantage, en fait, de l'objet, si je devais noter … pas noter mais tout simplement, vous donner des avantages … quel intérêt, en fait, quel intérêt, il y a de programmer ? Pourquoi le Python a été conçu sur un paradigme objet ? 

Alors l'intérêt premier, c'est déjà de bien organiser son code c'est-à-dire qu'on va définir des choses différentes plutôt que d'avoir, par exemple, un code où on va mélanger des fonctions de tout et n'importe quoi … quand on prend avec du recul tout son programme, on est capable de définir des catégories, par exemple, si on a, je sais pas moi, je prends l'exemple pour un jeu vidéo, vous avez une fonction attaquer, vous avez une fonction, je sais pas moi, prendre un objet dans un inventaire ou le retirer, se soigner, utiliser une potion. Je ne sais quoi.

Tout ça, on voit que ça peut rentrer, tout à fait, dans une catégorie qui est le joueur, d'accord. Ce sont des choses que peut faire un joueur donc on a une espèce de contexte qui se crée comme ça.

On pourrait très bien faire une classe joueur qui possède des méthodes comme se soigner, attaquer et cetera, mourir.

Oui mourir est une méthode, oui c'est quelque chose que peut faire le joueur. Le joueur peut mourir.

Là d'ailleurs, c'est vrai que je ne l'ai pas noté mais oui c'est vrai que c'est … faut comprendre aussi que voilà, d'accord, mourir, je crois que c'est un seul R, voilà.

```py
"""
------------------------------------------------------------
La programmation orienté-objet (POO) avec le langage Python
------------------------------------------------------------

Classe 	: plan de conception, genre (ex : Humain)
Objet 	: instance de classe (ex : Julien)

Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
Propriété 	: manière de manipuler les attributs (lecture seule, accès non autorisé en dehors de la classe, etc.)

Méthode	: fonction d'une classe (ex : manger, marcher, parler, dormir, mourir)
Méthode de classe	: fonction d'une classe (explications à venir plus tard…)
Méthode statique		: fonction d'une classe, mais indépendante de celle-çi.

Héritage 	: classe fille qui hérite d'une classe Mère (Fille est sorte de Mère)
		: classe Chat hérite de la classe Animal (Chat est une sorte d'Animal)
"""
```
Donc mourir est effectivement une possibilité, quelque chose que peut faire un humain, d'accord. Donc tout ça, c'est important de bien comprendre que ça permet, tout simplement, d'organiser son code d'une autre manière.

C'est pour ça qu'on parle vraiment qu'un paradigme comme l'objet, c'est simplement une autre manière de programmer, une autre manière de penser les choses quand on code.

On va dire : "bah tiens on voit qu'il y a des choses qui peuvent être mises ensemble donc on a fait une classe qui ont des méthodes c'est-à-dire qu'elles sont liées à ça parce que oui par exemple si je fais, je sais pas moi, je fais une classe mur … on va dire ça sert à quoi mais on peut imaginer une classe mur général … qui a une classe qui hérite qui serait la brique".

Et puis la brique … je ne vois pas … enfin une brique ne peut pas manger. Ça paraitrait complètement un peu bizarre.

Donc du coup on aurait, voyez, une autre classe avec d'autre chose qu'elle sait faire et ses propres attributs à elle, ses propres variables.

Par exemple, la densité de ciment ou je ne sais quoi. Enfin le poids, on peut imaginer d'autres choses qu'un humain n'aurait pas forcément.

Un humain, il n'est pas composé, à priori, de ciment sinon c'est un petit peu problématique.

Du coup ça permet de dégager comme ça, différentes … voyez une organisation générale au niveau du programme.

C'est aussi et ça c'est le premier argument qu'on donne en général pour tout ce qui concerne l'objet, on parle de réutilisation ou réutilisabilité parce qu'il en a qui invente des mots comme ça … le maximum, faut mettre le maximum de caractère à croire … donc ça veut dire qu'une fois qu'on a une classe définie, ce fameux plan de conception, le jour où vous voulez vous créer, par exemple, des humains … plein d'humains. Plutôt que de devoir tout refaire à la main, vous avez juste à faire une instance. 

Vous instanciez votre objet, vous pouvez créer un Julien mais une fois que vous avez créé un Julien, vous pouvez créer Marie, vous pouvez créer, voilà Hector, Robert, qui vous voulez et tout sera basé sur le même plan de conception.

Ils pourront chacun utiliser des capacités donc ce qu'ils sont capables de faire de leurs méthodes, leurs propres méthodes chacun. Et ils pourront interagir ensemble et cetera.

Qu'alors que si on avait juste fait des fonctions mais encore une fois tout serait mélangé, d'accord. Il aura fallu recréer à chaque fois tout à la main, tout répéter alors que là, on factorise un peu comme des fonctions mais c'est encore plus puissant.

On ne fait pas seulement que de factoriser dans des fonctions, c'est une classe factorise un ensemble de variable, d'attributs et de méthodes donc de fonctions pour pouvoir répéter tout ça … enfin utiliser tout ça de manière simultanée, de manière répétitive sans devoir répéter du code, faire du copier-coller, tout simplement, et devoir tout changer.

Donc c'est vraiment pour utiliser au maximum le code, à partir du moment, où on a une classe, on peut créer plein d'objets de cette classe, très rapidement donc c'est là tout l'intérêt. 

Donc ça rend le code, forcément, beaucoup plus lisible et ça, il faut penser surtout quand on développe en groupe, à plusieurs, ça rend le code plus facilement maintenable.

Si par exemple vous avez des objets "créer des classes". Si quelqu'un d'autre va travailler sur votre code, ce sera beaucoup plus facile, beaucoup plus lisible, beaucoup plus facilement réutilisable et donc maintenable que si vous aviez simplement des fonctions à droite, à gauche dans des fichiers, un peu à droite, à gauche, on ne sait pas trop comment sont organisés les choses.

Si par exemple vous avez une fonction qui s'appelle "attaquer" sur un jeu vidéo, ça nous dit pas qui attaque. C'est une fonction "attaquer", propre à quoi ? propre au joueur principal ? propre au PNJ ? propre à un monstre ? propre à … on ne sait pas. On est incapable de savoir … propre à un boss…

Voyez, il y a impossibilité de savoir où on en est. Que si cette fonction… cette méthode pardon "attaquer" se trouvait dans une Classe "Mom", donc monstre, le fameux monstre dans un jeu vidéo.

Là, tout de suite, on sait de quoi on parle, d'accord. On a vraiment ce contexte, on comprend tout de suite et ça donne du sens à la programmation, au code et ça c'est super important.

Donc voilà pour introduire rapidement cette programmation orienté objet. Les avantages qu'on peut y retrouver et grosso modo le vocabulaire à connaître (voir notes). 

Alors s'il y a des choses que vous ne comprenez pas, que vous n'avez pas retenu d'ici là, ce n'est pas grave, d'accord.

Mais là, je vous ai déjà balancé une grosse grosse partie de tout ce que nous allons voir en objet donc tout ça, on va le voir sur peut-être une dizaine de vidéos avec d'autres choses en plus.

Donc ne vous attendez pas à avoir tout retenu, tout compris en une seule vidéo, c'est évidemment, pas possible, c'est illogique et si c'est clair pour vous, bah tant mieux, comme ça, vous serez en avance, vous aurez plus de facilité pour la suite mais en tout cas tout ça nous allons le voir et le revoir. 

Et nous allons pratiquer après par la suite tout le temps.

## Bonus - Les chaînes de caractères sont des objets de classe str

On va voir comment les chaînes de caractères que vous utilisez avant sont également des objets, de classe STR, qu'elles ont également des attributs et qu'elles ont des méthodes.

D'ailleurs, je vais terminer avec ça, pour vous souvenir … là je fais du code donc c'est le petit bonus voilà même si j'avais dit que je ne faisais pas de code du tout dans cette vidéo.

	"coucou"

Quand on avait par exemple, ce genre de choses. Je vais mettre mon prénom et puis j'avais par exemple texte, d'accord, et on faisait nom.

```py
nom = "Jason"
texte = nom
```

Nom, c'est un objet de classe String. En mettant le point, je peux utiliser une méthode donc ceci --> "Méthode : fonction d'une classe (ex : manger, marcher, parler, dormir, mourir)"

```py
nom = "Jason"
texte = nom.format
```

Je peux utiliser une méthode, rappelez-vous, la méthode format() donc en fait d'ailleurs, je voulais faire ça plutôt. C'est plutôt ça que je voulais faire, bienvenue et la petite boîte, vous vous rappelez donc ça normalement vous savez.

```py
nom = "Jason"
texte = "Bienvenue {}".format
```

Vous connaissez cette syntaxe. On l'avait vu avant et je vous avait dit : "ça j'en parlerais plus tard, c'est une méthode, ce n'est pas une fonction". Je vous avait dit, on en parlera quand on ferra de l'objet. Et on faisait du coup et hop ça marchait.

```py
nom = "Jason"
texte = "Bienvenue {}".format(nom)
```

Et après, en faisant un petit print() de texte, ça aurait affiché "Bienvenue Jason" ou "Bienvenue … n'importe quoi" selon ce que vous avez mis dans le nom, d'accord.

Donc voilà, vous voyez qu'un simple texte que vous avez mis comme ça donc une chaîne de caractères est déjà un objet d'une classe ici STR donc String, qui peut utiliser des méthodes, qui a des attributs aussi mais ça on parlera plus tard. Donc tout ça, on le verra. On verra un petit peu les objets que vous avez déjà manipulé et puis après bien évidemment on regardera comment en créer nous-mêmes, comment on va pouvoir créer nos propres classes, instancier nos propres objets, travailler avec, les faire interagir, créer des petits jeux, créer des petit programme sympa,  des trucs vraiment beaucoup plus élaboré que ce qu'on a vu jusqu'à  présent, voilà.

Et je vais en rester là pour cette petite vidéo d'introduction, je ne vais pas en rajouter parce qu'après on pourrait en parler encore pendant des heures donc c'était vraiment histoire de vous introduire ce vocabulaire, de le présenter rapidement pour vous faire une petite idée globale de ce qui vous attend et de se mettre d'accord surtout, d'accord.

N'oubliez pas en python, voilà, on différencie bien attribut/ propriété.

Après en C++, c'est un peu la même chose. Voilà, il y a des gens qui vous diront, non, il y a une différence mais au final, on voit que c'est la même chose. Un attribut c'est une propriété donc c'est pour ça que je vous dis ne vous embêtez pas trop avec les noms. 

Ce n'est pas parce que vous allez vous trompez de termes pour désigner quelque chose, que ça y est vous êtes un mauvais développeur ou autre, d'accord.

L'important c'est de savoir coder que ce que vous programmez, vous le comprenez. A partir de moment où vous comprenez ce que vous développez, il n'y a pas de souci. Après les noms on s'en fout, à la limite, ce sont juste des noms. C'est bien pour se comprendre, c'est sûr, mais c'est un détail. Ce n'est pas ce qui est le plus important dans la programmation, Voilà.

Je vous dis à très bientôt.

On se retrouvera du coup pour la prochaine vidéo donc la prochaine vidéo bien évidemment, on fera de la programmation. On va vraiment commencer à coder et on va, je vous dis, mettre en avant tout la partie objet puisque langage python est objet et vous allez voir un peu comment tout ça, s'agence.

Et comment, on définit un petit peu toutes ces petites choses-là.

Aller à très bientôt