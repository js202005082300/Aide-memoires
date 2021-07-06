# [3. Variables](https://www.youtube.com/watch?v=nbecRjzVzNg)
> C'est parti pour aborder la première notion du langage Python : les variables. Dans ce cours, vous apprendrez comment les utiliser, en créer, afficher leur valeur et même faire saisir des données au clavier.

+ [Conseils de nommage](#Conseils-de-nommage)
    +[Plus...](#Plus...)
+ [La fonction type](#La-fonction-type)
+ [La fonction format](#La-fonction-format)
+ [Saisie d'informations](#Saisie-informations)
    + [La fonction input](#La-fonction-input)
+ [Caster une donnée](#Caster-une-donnée)
+ [Resume](#Resume)

3ième séance sur notre formation en langage python et maintenant nous allons pouvoir parler d'une des notions les plus importantes de l'informatique et de la programmation générale c'est à dire le stockage des données.

On va utiliser pour cela ce qu'on appelle des variables et je vais vous présenter un petit peu globalement comment ça fonctionne comment nous allons pouvoir en utiliser et s'en servir au cours de nos programmes.
On va passer sur notre code source. On va remettre un encodage même si par défaut c’est de l’UTF-8 en Python 3.

```py
#coding:UTF-8
```

Et on va commencer à travailler directement avec nos variables.

Une variable, c'est tout simplement comme son nom l'indique une donnée qui va pouvoir varier c'est-à-dire on va la stocker dans un nom qui permettra d'identifier après le l'interpréteur python va l’associer à une adresse en mémoire donc vous vous en fichez complètement puisque c’est un langage de haut niveau donc vous n'avez pas à vous soucier de comment est géré la mémoire, comment elle est stockée au niveau de votre ordinateur.

Vous avez simplement des noms pour nommer vos espaces de données pour y stocker des choses à l'intérieur, faire des tests dessus ect.

On verra tout ça dans les prochaines vidéos et voilà on peut travailler directement avec cette variable là et ça vous permet de gérer un petit peu tout l'ensemble de votre programme.

Le langage python, il faut savoir contrairement à d'autres langages, si vous avez suivi un peu la formation au langage ou des formations un peu plus bas niveau au niveau du langage en lui-même, le langage python utilise un **typage dynamique**.

Qu'est-ce que ça veut dire ?

Déjà ça veut dire qu’au niveau de la création de variables que nous allons avoir, on n'aura pas besoin d'indiquer le type de données que l'on doit accepter.

## Conseils de nommage

Une variable, elle va tout simplement posséder un nom.

```py
"""
    Nommer une variable :   doit commencer par une lettre
                            Ne pas contenir de caractères spéciaux
                            Ne pas contenir d'espaces
                            utiliser des underscores (_)
"""
```

Le nommage d'une variable doit suivre quelques règles donc déjà : elle doit commencer par une lettre c'est-à-dire pas de chiffres ou de caractère spécial. elle doit également ne pas contenir de caractères spéciaux. Les caractères spéciaux, ce sont évidemment les points d'exclamation, les étoiles, les pourcents et également les caractères accentués. elle doit ensuite ne pas contenir d'espace sinon il y aura un nom qui sera en 2 mots donc ça ne va pas aller au niveau de l'interprétation de votre programme.

Et voilà globalement au niveau des règles cependant vous pouvez utiliser le Under score. Pour rappel c'est le tiret du bas, le souligné en fait. Vous pouvez l'utiliser pour faire vos variables.
On va commencer par en créer une et on va voir comment ça fonctionne.

On va créer une variable âge ça va rester très simple :

```py
age
```

Je peux faire une variable âge tout simplement.

Après ce n'est pas un terme qui est très explicite. Il est recommandé évidemment d'être très explicite au niveau du nommage de vos variables, pourquoi ? parce que déjà lorsque vous aurez plusieurs centaines, plusieurs milliers de lignes et plusieurs dizaines de variables, il est bien que vous puissiez avoir un nom qui soit correct.

Il faut normalement en fait que le nom puisse directement commenter votre code. Si vous êtes obligé de faire un commentaire au niveau d'une variable pour dire qu'elle concerne-t-elle partie de votre programme ou qu'elle stocke telle information, c'est que déjà le nom de votre variable n'est pas n'est pas suffisamment clair.

Donc là âge ça peut être l'âge de n'importe quoi.
Donc disons qu'on a un programme qui va faire un répertoire sur les personnes, on va mettre au minimum :

```py
agePersonne 
```

voilà ça c'est un nommage possible, c'est-à-dire que j'utilise ce qu'on appelle une syntaxe en CamelCase, c'est-à-dire qu'on va avoir le premier mot et à chaque nouveau mot on va mettre une majuscule.

Ça permet naturellement à la lecture de pouvoir bien différencier chaque mots.

On peut sans problème faire comme ça avec le fameux underscore :

```py
age_personne 
```

On peut faire comme ça :

```py
agepersonne
```

On est obligé de mettre de majuscule si vraiment vous ne voulez pas en mettre.

Vous pouvez en mettre une au début si ça vous chante :

```py
AgePersonne
Age_Personne
```

Et cetera, et cetera.

On peut aussi commencer par underscore.

```py
_AgePersonne
```

On peut commencer par une lettre ou un underscore. 

On le fait assez rarement, on le fait dans certains langages, notamment PHP pour le web c'est assez intéressant d'utiliser ce genre de syntaxe. On peut le faire, ça marchera sans problème.

Donc on a un nom de variable, il y a plusieurs modes possibles. 

En revanche, je ne peux pas faire ça :

```py
0age_personne
```

L'éditeur va colorer différemment ça ne fonctionne pas.

Et on ne peut évidemment pas s'amuser à mettre les caractères spéciaux : 

```py
âge_personne
```

voilà pas de caractères spéciaux. Certains langages ne vont pas l'accepter et d'autres vont éventuellement l'accepter mais vous aurez de toute manière des soucis avec. Donc le mieux c'est de rester sur des caractères non accentués.

Il ne faut pas que ce sont des langages qui sont américains à la base pour beaucoup qui voilà non pas d'accent dans la langue. Les accents, les caractères accentués ou les caractères spéciaux ne sont pas acceptés dans le nommage de nos variables. 

Donc il faut rester sur des noms simples. Il est recommandé de prendre :

```py
agePersonne 
```
...qui est évidemment une syntaxe très recommandée dans le milieu de l'informatique.

On peut également faire ce genre de syntaxe :

```py
age_personne 
```

voilà et après pour certains cas, on peut avoir ce genre de syntaxe :

```py
_AgePersonne
```
...ou alors vous voir carrément comme ceci :

```py
_age_personne 
```

C'est vous qui voyez.

## Plus ...

Une bonne astuce, si vous adoptez dans un projet en lui-même, c'est d'adopter toujours la même syntaxe si vous partez au départ par une syntaxe comme celle-ci :

```py
agePersonne
```

Il ne faut pas commencez pas à faire quelque chose comme ça :

```py
nom_joueur
```

Sinon on ne s'y retrouve pas, on n'a pas quelque chose qui est cohérent, homogène.

Il faudra adopter toujours le même type la syntaxe pour que ce soit plus correct par rapport au nommage de nos variables.

C'est assez flexible de nommer le nom de sa variable. Le nom va permettre de l'identifier au niveau de programme donc par exemple ça va être cette syntaxe :

```py
agePersonne
```

Et on va faire une affectation c'est-à-dire quand va mettre un égal. Un seul égal, c'est important et on verra par la suite que si on met un double égal, ça voudrait dire autre chose, on en parlera plus tard.

Ça va permettre d'affecter une information à cette variable donc par défaut je vais lui mettre un type de données. Ici qui est un entier, je lui mets 14.

```py
agePersonne = 14
```

Voilà l'âge de la personne est égal à 14.

Les types de données, pour les types standards en tout cas, je vais vous donner quelques-uns

```py
"""
    Types standard 		:	entier numérique
                            nombre flottant (float)
                            chaîne de caractères (str)
                            booléen (bool)
"""
```

Donc pour les types standards, on va avoir l'entier numérique ce qu'on appelle un int pour integer. On va avoir le nombre flottant donc un nombre à virgule donc un float. On va avoir la chaîne de caractères, un string donc str. On va avoir un booléen, c'est 0 ou 1, vrai ou faux, c'est l'un ou l'autre c'est binaire et après on a vraiment tous les autres types.

On verra comme python est complètement objet, on peut avoir un type de liste, un type de tableau, on peut avoir le type dictionnaire, type tuple. On peut vraiment avoir plein de types au niveau de python mais ça c'est pour les types standard, ce que vous allez utiliser beaucoup beaucoup beaucoup surtout les 3 premiers en l'occurrence au niveau de vos variables.

Donc là automatiquement python va procéder à un typage dynamique, typage dynamique donc il n'est pas explicite.

Si vous suivez le langage C, par exemple, parce qu'il est très parlant. Si j'avais voulu créer une variable comme ça :

```c
int agePersonne = 14
```

il aurait fallu, pour identifier, dire que agePersonne, c'est une variable de type INT donc de type entier.

Python, il n'y a pas besoin de faire ce genre de chose. Automatiquement comme on stocke 14, on lui affecte la valeur de 14, l'interpréter va savoir que c'est un entier donc il va transformer cette variable en entier automatiquement.

Par contre, attention, automatiquement où vous allez vouloir l'afficher où faire quoi que soit avec cette variable-là, il la considéra toujours comme un entier donc en entier pas de problème on peut faire des calculs avec. Je pourrais très bien faire des calculs plus tard avec l'âge de la personne d'ailleurs dans la vidéo suivante on parlera des opérateurs mais nous aurez l'occasion de voir tout ça.

Par contre, il n'est pas question de le l'utiliser comme un texte.

Même chose, si je fais :

```py
agePersonne  = "25"
```

Ici il s'agit bien d'un texte. Vous ne pourrez pas faire de calculs sur cette valeur-là.

Pour python ce n'est pas un nombre. Donc ce qui n'est pas un nombre, ne peut pas subir d'opération.

Du coup, on l'identifie évidemment comme une chaîne avec les doubles quotes, qu'on a vu un petit peu, comme pour le prix en fait quand on utilise la fonction print().

```py
agePersonne = 14
agePersonne2 = "25"
```
Et ça ce sont 2 variables différentes.

```py
agePersonne = 14
```
Là, il s'agit bien d'une variable qui possède en entier donc un int.

```py
agePersonne2 = "25"
```

Et là une variable qui contient une chaîne de caractères donc un String, une str.

Pour cela, on va vérifier quelque chose avec une première fonction à retenir, c'est la fonction type.

## La fonction type

Donc si je fais un print() de type de agePersonne et un autre de agePersonne2 :

```py
print(type(agePersonne))
print(type(agePersonne2))
```

type(), c'est une fonction qui retourne tout simplement le type d'une donnée, donc une variable, et cetera, un objet ou autre.

Dans le terminal, on va faire 

```powershell
python script.py
```

ça nous affiche que ces 2 classes puisque e, python tout est objet mais on n'a pas encore parlé de tout ce qui est programmation orienté objet donc considérer pour le moment qu'on parle de tipe et pas de classe.

Vous voyez que le premier est bien un int et le deuxième est un str :

```powershell
<class 'int'>
<class 'str'>
```

On a mit un nombre dans agePersonne donc c'est vraiment 2 choses distinctes et donc voilà comment on fait un entier, voilà comment on fait une chaîne de caractères.

Pour un nombre flottant ça peut être tout simplement comme ceci :

```py
prixHT = 120.46
```

on met un point toujours en informatique. Le point pour représenter la virgule et c'est tout.
Pour un booléen, par exemple :

```py
continuerPartie = True
```

ou bien :

```py
continuerPartie = False
```

Vous remarquerez qu'on met une majuscule. Dans certains autres langages on n'en met pas.
C'est globalement pour les quatre choses comme ça qu'on a voir.

Les autres on les verra par la suite. Vous aurez l'occasion éventuellement de les utiliser dans dans vos projets.

Il faudra les voir à ce moment-là mais pour le moment c'est tout ce qui à retenir.

Après il y a des types différents de nombre, on peut stocker un nombre décimal mais je pourrais très bien stocker un nombre hexadécimal c'est-à-dire de la forme ça serait pas un age du coup mais 0xFAD5B8

```py
agePersonne = 0xFAD5B8
```

voilà un nombre avec 6 chiffres hexadécimaux en l'occurrence.

On peut on pourrait stocker de l'octal également en mettant un 0o devant :

```py
agePersonne = 0o705
```

Et cetera, on pourrait faire aussi à une variable de type long c'est-à-dire qu'y est un peu plus grand au niveau de l'espace qu'elles peuvent accorder qu'un entier et cetera et cetera.
 
Et avec j c'est pour les nombres imaginaires mais là on rentre dans les mathématiques.

Donc on ne rentre pas dans le détail parce que ça va dépendre complètement de vos projets et il y a beaucoup d'autres donc si on commence à faire le listing c'est juste complètement inutile à l'heure d'aujourdhui, là ou vous en êtes.

Par contre si un jour vous avez besoin je sais pas de manipuler des nombres hexadécimaux, il faudra garder au niveau de la documentation de python comment ça se met en place. 

On verra qu'il suffit de rajouter un petit 0x et ça devient l'identifiant pour le l'interpréteur python qui saura peux vous manipuler de l'haxadécimale comme ça vous pourrez travailler dessus.

Donc je vais revenir sur mes exemples mais retenez en tout cas c'est quatre type de données :

+ l'entier 
+ le monde flottant 
+ la chaîne de caractères 
+ et le booléen

Ce seront les plus utiles.

Du coup on a vu comment afficher une variable mais ce qui va nous intéresser c'est d'afficher une variable.
Ca me paraît logique maintenant que vous savez créer des variables, vous savez comment ça fonctionne, à quoi elles servent.

On va pouvoir afficher leur valeur.

Pour afficher la valeur d'une variable, on utilise ce que vous avez appris jusqu'à maintenant c'est-à-dire :

```py
print()
```

print(), la fonction pour afficher quelque chose donc sur la sortie standard, en l'occurrence ici le terminal.

Et au lieu de dire que je veux afficher un texte comme ici Bonjour :

```py
print("Bonjour")
```

Je ne veux pas afficher un texte mais je veux afficher le contenu d'une variable donc on enlève les doubles quotes.

Il ne s'agit pas d'une chaîne, vous allez voir pourquoi d'ailleurs je vais laisser au début pour montrer.
Mettons je vais afficher l'âge de la personne :

```py
print("agePersonne")
```

Automatiquement si j'exécute mon programme il va m'afficher agePersonne puisque je lui dis d'afficher le texte suivant donc c'est exactement ce que python fait. Il fait exactement ce que je lui demande.

N'oubliez pas pour afficher un varibale d'avoir le double quottes :

```py
print(agePersonne)
```

Automatiquement, ce n'est plus du texte et là je vais pouvoir afficher la valeur, il n'y aura pas de souci à ce niveau-là.

Rappelez-vous print affiche toujours les données, en tout cas quand ça ne pose pas de soucis, il les considére comme une chaîne.

Au moment ou print() affiche l'âge de la personne, c'est une chaîne de caractères.

On verra pourquoi après ça peut poser problème surtout quand on va faire de la saisie de données juste après.

Donc tout simplement un petit print(), vous mettez la variable que vous voulez et vous pouvez l'afficher.

Maintenant si vous voulez la compléter avec un texte vous pouvez mettre le texte, on va faire Age de la personne :

```py
agePersonne = 14
prixHT = 120.46
agePersonne = "25"
continuer_partie = True

print("Âge de la personne", agePersonne)
```
... comme ceci et vous mettez une virgule.

python va faire un espace et voyez je n'ai pas d'espace avant la fin du texte puisque python va faire un espace entre la phrase ici et la valeur de la variable. Vraiment n'en mettez pas, on n'est pas toujours habitués alors que sur certains langages où il faudrait les mettre. En python pas besoin.

On teste vous voyez qui met âge de la personne 14.

Donc vous pouvez sans problème associé comme ça du texte avec une variable.

Et on peut ensuite continue du texte derrière si je veux mettre un point tout simplement :

```py
print("Âge de la personne", agePersonne, ".")
```
Voilà ça va fonctionner.

Par contre il met un espace donc ça c'est le petit bémol par rapport à ce système d'affichage comme ça qui permet de concaténer à la fois de la chaîne de caractères et la valeur de variable.

## La fonction format

On va voir une autre méthode juste après, un petit bonus, même si on n'a pas encore vu de l'objet et ça vous permettra comme ça d'afficher proprement des choses au niveau des variables.

Je vais vous la montrer maintenant parce qu'après on va commencer à avoir d'autre chose pour la saisie de données.

Vous pouvez faire tout simplement alors que vous savez que tout est objet en python.

vous avez vu tout à l'heure que "agePersonne = 14" était de classe str et que "25" était de classe str et cetera.

Et comme tout est objet et bien chaque objet a des propriétés donc ce qui permet de le définir.

Il a également des méthodes c'est-à-dire ce qu'il peut faire, c'est un petit peu les services qui peut vous rendre.

Une chaîne de caractères a certaines méthodes, des fonctions en fait ce sont des fonctions de classe qui vont lui permettre de faire certaines choses.

Et il y a une fonction très intéressante sur les chaîne qui s'appelle format qui va permettre de formater du texte.

Comment ça va fonctionner ?

Et bien je vais pouvoir faire ça :

```py
agePersonne = 14
prixHT = 120.46
agePersonne = "25"
continuer_partie = True

texte = "L'âge de la personne est {} et le prix HT est de {}€."
```

Aalors je vais faire une variable intermédiaire pour vous puissiez pas trop être perdu parce que ça va faire des concaténations un peu compliqué et vous risquez de ne pas comprendre.

Je met donc "L'âge de la personne est " et ensuite je met des accolades et je met rien dedans et le prix alors c'est un peu bizarre comme on fait l'affichage de données mais c'est pas grave.

Donc vous imaginez, en fait, vous faites toute votre phrase et à chaque endroit vous voulez normalement afficher la valeur d'une variable, ce qu'elle contient, vous mettez des accolades comme ça {}, une petite boîte, j'appelle ça une boîte.

Et on va pouvoir remplacer ce qu'il y a dans toutes ces petites boîtes.

Vous voyez c'est facile à lire naturellement, on comprend très très bien ce que l'on va faire.

Et ensuite on va directement utiliser format() sur tout le texte.

Je vais faire print() :

```py
agePersonne = 14
prixHT = 120.46
agePersonne = "25"
continuer_partie = True

texte = "L'âge de la personne est {} et le prix HT est de {}€."
print(texte)
```

Je vais dire tu affiche le contenu de texte et sur texte comme c'est une chaîne de caractères, vous le voyez au dessus, je vais utiliser une méthode dessus donc en fait une fonction des chaînes de caractère qui s'appelle format().

Donc ça si vous ne comprenez pas encore l'utilisation des méthodes et cetera, ce n'est pas grave, on ne l'a pas encore vu.

On en est vraiment au début de la formation, on le verra bien plus tard.

Donc vous en faites pas, c'est la petite le petit bonus que je vous donne maintenant.

Vous pouvez l'utiliser bêtement pour le moment comme ça, tel que je voul l'ai montrer sans forcément le comprendre.

Par contre ne vous en faites pas vous comprendrez par la suite et vous pourrez vraiment l'utiliser comme il faut.

```py
agePersonne = 14
prixHT = 120.46
agePersonne = "25"
continuer_partie = True

#texte = str("L'âge de la personne est {} et le prix HT est de {}€.")
texte = "L'âge de la personne est {} et le prix HT est de {} euros."
print(texte.format(agePersonne, prixHT))
```

Et la format() va prendre en paramètre, dans l'ordre des bulles que vous avez dans texte {}, les variables sur lesquels il faut mettre les valeurs donc la première c'est l'âge, agePersonne, une virgule, le prix hors taxe tout simplement.

Vous voyez, il va faire un remplacement, il va mettre la valeur dans {}.

Si vous avez deux boîtes entre guillemets, vous aurez donc deux paramètres dans la fonction, dans la méthode format.

Et là on peut directement afficher.

Rem. le symbole € ne passait pas dans l'affichage au moment de la vidéo. Jason a fait un cast avec str() mais il avoue lui-même faire des bêtises. Ce n'est pas bien grave, il l'a changé et mit le texte à la place.
Donc python gère du coup très bien l'espace si je ne veux pas d'espace, je peux faire :

```py
texte = "L'âge de la personne est {} et le prix HT est de {} euros."
```

Vous voyez ça va directement modifier.

Ca formate vraiment le texte comme vous voulez.

Ainsi, je l'ai fait en 2 lignes, c'est peut être un peu plus long. Certains préfère peut être une méthode plus raccourcie :

```py
print("L'âge de la personne est {} et le prix HT est de {} euros.".format(agePersonne, prixHT))
```

Au lieu de passer par une variable intermédiaire vous pouvez directement prendre ce qu'elle contient.

Et moi je fais comme ça, ça va beaucoup plus vite.

C'est un peu moins lisible mais ça fonctionne en tout cas.

Donc c'est toute la chaîne de caractères dans le print() et surtout ça on fait un point format avec les bons paramètres qui vont et ça fait exactement la même chose.

Donc ça c'est une méthode pour afficher les variables.

L'avantage c'est que cette méthode fonctionne à tous les coups avec tous les types de données que ce soit des chaînes de caractères { agePersonne = "25" }, des mots flottants { prixHT = 120.46 }, des true/false { continuer_partie = True }, des entiers { agePersonne = 14 }.

il nous ferra pas d'erreur au niveau de python en disant bah tiens je ne sais pas afficher ce type de données ou alors faut que tu le fasses une conversion et cetera.

C'est là tout l'avantage et vous allez voir ça va être utile pour la suite.

## Saisie informations

On va maintenant passer à la saisie d'informations.

Parce que là c'est bien on fait toujours des petites variable en dur.

Par exemple,
```py
nomJoueur = "Diablo"
print("Bienvenue,",nomJoueur)
```

On fait nomJoueur, on fait print()

On va faire un affichage simplement mais c'est toujours nous qui entrons l'information. c'est-à-dire qu'elle est en dur dans le programme.

Donc du coup, ça peut pas être le la personne qui teste le programme, ici le jeu en l'occurence, qui pourrait entrer l'information.

Donc on a besoin à un moment donné de pouvoir demander des choses à l'utilisateur, donc de pouvoir saisir des informations, de lire des données.

### La fonction input


Pour ça, vous allez utiliser une nouvelle fonction, une nouvelle fonction à apprendre en plus de print(), qui permet elle d'afficher les informations et celle que nous allons voir permet d'en saisir.

Elle s'appelle input(). 

Alors input() va retourner, même si on n'a pas encore abordé les fonctions dans la formation, mais elle va renvoyer tout ce qui a été tapé au clavier par l'utilisateur.

C'est pour ça qu'il faut la mettre dans une variable automatiquement.

Si vous faites input() tout seul :

```py
input()
```

C'est bien par contre tout ce qui aura été tapé au clavier sera perdu.

```py
nomJoueur = input()
```

Donc je vais bien tout récupérer, j'affecte en fait un nom de joueur au résultat d'une fonction, c'est tout à fait possible.

Et on en parlera encore plus quand vous aurez abordé les fonctions dans les vidéos prochain.

```py
nomJoueur = input("")
```

Ici, dans le double quottes; je met mon petit texte, tout simplement, pour poser une question, pour demander ce que je veux.

```py
nomJoueur = input("Choississez un nom de joueur : ")
```

Donc là, vous choisissez, par exemple, un nombre de joueurs. 

je vais faire comme ça avec un petit espace pour que ce soit un peu plus propre.
Et après le input() ça va passer à la ligne. 

Du coup python me propose d'entrer un nom de jouer.

Donc je peux rentrer n'importe quoi et il va du coup prendre en compte sans problème au niveau de l'affichage.

Donc ça évidemment, on n'exploite des données dynamiques c'est-à-dire que ça va vous changer en fonction de ce que l'utilisateur le programme va entré.

Voilà donc ça c'est un point qu'il fallait retenir, c'est la fonction input.

Donc n'oubliez pas, je rappel au niveau des fonctions qu'on a vu on a :

```py
"""
    print() ->  afficher à l'écran
    input() ->  lire au clavier
    type()  ->  retourne le type d'une donnée, variable, etc.
    str.format()    -> formater une chaîne.
"""
```
  
On a print() pour afficher du texte mais comprenez que ce sont des des variables, don on dira afficher à l'écran de manière plus général. On a ensuite input() pour lire le clavier. On a type() qui retourne le type d'une donnée. C'est différent mais on a pour les str, la méthode format mais c'est un peu comme une fonction. Cette dernière est différente mais c'est juste qu'on n'a pas encore vu ce que sont les méthodes mais on verra cela plus tard. Et donc là c'est formater et je vais rester là pour j'sais pas trop compliquer les choses.

vous aurez un bon exemple, un petit résumé rapide de ce que vous avez vu jusqu à présent donc comment nommer une variable ? comment en créer ? quel type de données on peut y stocker ? même si vous verrez plus tard qu'on peut bien évidemment avoir des listes, des dictionnaires et des tuples et cetera, plein plein plein.

```py
"""
Type standards :    entier numérique (int)
                    monde flottant (float)
                    chaîne de caractères (str)
                    booléen (bool)
                    autres (listes, dictionnaires, tuples, etc)
"""
```
... plein plein plein, des objets. D'ailleurs, je n'ai pas noté mais bon tout est objet, une liste, c'est un objet en fait.

Classe list et cetera ... dans certains termes vous allez être un peu perdu au début mais à la longue au fur à mesure que vous allez avancer dans une vidéo, certains points qui vous sont un peu sombre qui vont se débloquer et vous comprendrez.

C'est ça aussi le petit souci au niveau de python, pour le faire apprendre c'est que c'est un langage qui est déjà objet à la base mais on ne peut pas directement attaqué par là tiens Allez hop on fait la PDO dès le début sinon vous serez complètement perdu puisqu'il n'est pas obligatoire en réalité de commencer à créer des classes et cetera et de manipuler des objets personnels en fait, des objets que vous auriez fait vous-même.

on va utiliser les objets natifs de python mais pour faire du procédural donc c'est un petit spécial mais on est obligé de commencer par là. Si je commence à tout mélanger, ce serait tellement compliqué ce serait assez décourageant et l'informatique c'est déjà décourageant à la base donc si on commence à tout mélanger on ne s'en sort pas.

donc je suis désolé par avance si certaines choses ne sont pas forcément toujours très clair sur cette formation au début parce qu'on mélange un peu pas mal de notions mais j'essaye de suivre un certain ordre logique que vous puissiez avancer logiquement, que par rapport à tout ce que vous allez voir au fur et à mesure vous puissiez comprendre tout ce que vous avez appris et surtout être autonome dans ce que vous ferez, dans les projets que vous pourriez débuter.

Maintenant, on a vu tout ça donc print() input() type().

Au moins, les 3 fonctions comme ça à retenir, les 3 que vous avez vu, qui sont super importantes, qui vous serviront beaucoup beaucoup d'ailleurs et on va terminer par quelques autres petites fonctions qui vont permettre 

Donc n'oubliez pas, je rappel au niveau des fonctions qu'on a vu on a :

```py
"""
    print() ->  afficher à l'écran
    input() ->  lire au clavier
    type()  ->  retourne le type d'une donnée, variable, etc.
    int(), float(), str(), bool()   ->  "caster" une donnée, la convertir.
    str.format()    -> formater une chaîne.
"""
```

## Caster une donnée

Qu'est-ce que ça veut dire de caster une donnée ? c'est pour er son changer son type. Notamment au niveau de ses types standards.

Il y a des fonctions comme ça qui s'appelle int(), une fonction str(), et cetera qui va permettre de changer le type d'une information.

On va faire le calcul d'un prix par exemple à partir d'un prix hors taxes TTC, avec une TVA à 20 pourcent pour l'exemple :

```py
prixHT = input("Entrez un prix HT : ")
prixTTC = prixHT + (prixHT * 20 / 100)
print("Prix TTC =", prixTTC)
print("Prix TTC = {}".format(prixTTC))
```

on va faire prixHT, input() et demander d'entrer un prix.

Qu'est-ce qu'il va se passer ? 

On n'a pas encore vu les opérateurs d'accord.

On va faire prixHT plus (prixHT * 20 / 100). On fait un calcul tout bête.

On aura l'occasion de voir ça à la vidéo suivante.

Et enfin, on affiche prix TTC égale. On procède à l'affichage avec un petit format() de prixTTC également.

On exécute et on va avoir une erreur. Le programme ne va pas fonctionner : 

```powershell
#prixTTC = prixHT + (prixHT * 20 / 100)
TypeError: unsupported operand type(s) for /: 'str' and 'int'
```

Il me met qu'un opérande n'est pas supporté 'str' et 'int'. Mais pourquoi ?

Tout simplement parce que la fonction input() quand elle lit quelque chose, elle va en faire un texte. Pour elle, tout ce qu'elle lit, c'est du texte.

c'est comme ça c'est de type 'str', string.

Si vous entrez entrez simplement un nombre tel que 125.

Il va être stocké de cette manière :

```py
prixHT = "125"
```

Et là quand on va faire un petit calcul, on essaye de calculer entre guillemets :

```py
prixTTC = "125" + ("125" * 20 / 100)
```

C'est-à-dire un texte "125" avec des vrais nombres entiers, ce qui est juste pas possible.

C'est comme pour dire bah tiens je veux faire, par exemple, l'addition d'une lettre plus un nombre, vous allez obtenir quelque chose d'assez bizarre.

Donc là, c'est pas possible puisque vous essayez de faire des calculs sur des types de données différentes, des chaînes avec des entiers. C'est pour ça qu'il nous met ce genre d'erreur.

On va être obligé du coup de faire une conversion, de forcer le type, de faire un casque pour dire que prix hors taxe, je veux lui affecter une nouvelle valeur. 

Je veux lui affecter une conversion en entier de ce qui a été noté avant.

```py
prixHT = input("Entrez un prix HT : ")
prixHT = int(prixHT)
prixTTC = prixHT + (prixHT * 20 / 100)
print("Prix TTC =", prixTTC)
print("Prix TTC = {}".format(prixTTC))
```

Ainsi prix hors taxe égale int de prix hors taxe et là automatiquement je viens de convertir en entier.

Pourquoi ça n'a pas posé de souci ? parce que voilà j'ai simplement entrer ici un nombre donc pour lui, 125 en texte, il est capable de le convertir en entier parce que c'est comme s'il avait simplement enlevé les doubles guillemets et ça va fonctionner.

Donc là je peux noter 125 et vous voyez qui m'affiche bien le prix TTC.
il n'y a pas de problème ça fonctionne.

Donc ça c'est super important. Dans certains cas vous n'aurez pas le choix vous serez obligé de passer par là.

Et bien souvent quand, au niveau du input(), vous attendez un nombre entier ou un flottant, il faut faire un cast derrière. Alors après on verra comment gérer les erreurs avec de try catch comme on fera de la gestion d'exception puisqu'on peut pas s'amuser à faire des cast comme ça sans vérifier qu'il n'y a pas eu de problème.

Mais pour le moment avec votre niveau actuel c'est tout ce que vous pouvez faire c'est-à-dire à partir du moment où dans un input() vous demander en entier, un nombre en l'occurrences, quelque chose qui n'est pas du texte, vous réalisez ensuite un cast derrière.

```py
int(prixHT)
```

Vous le convertissez bien dans le format de données que vous voulez et à la fin vous pouvez faire ce que vous voulez dessus.

N'oubliez pas que les calculs comme :

```py
prixHT + (prixHT * 20 / 100)
```

On peut le faire qu'avec des float ou des entiers. vous ne pouvez pas faire ça avec des chaînes de caractères ou encore un booléen pourquoi pas parce que le booléen ne va pas le convertir tout seul. Le booléen ça va être True ou False. 

Si vous voulez par exemple que ça devienne 0 ou 1, 0 pour False et 1 pour True, il faudra convertir par exemple votre booléen en entier avec int() qui va convertir automatiquement.
D’ailleurs on va faire le test :

```py
valeur_booleen = True
print(valeur_booleen)
```

On va tester pour que vous voyez un petit peu de différence donc là vous voyez il m'affiche bien True effectivement par contre si je fais : 

```py
valeur_booleen = False
valeur_booleen = int(valeur_booleen)
print(valeur_booleen)
```

Il va convertir pour lui True. Qu'est-ce que ce serait comme entier ? qu'est-ce que ça voudrait comme entier ? ça voudrait donc 1. Si je mets False, il va mettre 0 comme c'est en informatique.

True, vrai, c'est le courant passe. 0 c'est faux, c'est le courant ne passe pas pour la base au niveau du binaire.

Ici c'est 0 voilà et si je mettais en str() en l'occurrence là, il va l'afficher comme texte :

```py
valeur_booleen = False
valeur_booleen = str(valeur_booleen)
print(valeur_booleen)
```

Le mot que vous voyez, False, ce n'est plus booléen en fait. C'est le mot booléen, c'est un texte. C'est pas pareil alors c'est un peu spécial c'est-à-dire qu après plus tard si je vais faire des tests dessus, vérifier, par exemple, quelque chose est faux … il va pas dire que c'est faux, il dira que le texte est égal à F a l s e avec un F majuscule en l'occurrence.

Donc attention à cette distinction de donnée, de bien retenir qu'encore une fois que "125" n'est pas la même chose que 125 et que True n'est pas la même chose que "True" non plus. C'est vraiment des données différentes, c'est super important en python puisqu'il n'y a pas de typage explicite, on ne doit pas commencer à dire bah tiens là c'est un int comme on ferait en langage C ou en C++:

```c
int valeur_booleen;
```

C'est implicite et surtout c'est dynamique, c'est python qui va déterminer le type de votre donnée par rapport à ce que vous stockez dedans donc si jamais c'est pas bon et qu'il y a une possibilité d'erreur notamment au niveau du input() qui récupère une chaîne, vous faites un petit cast avec une de ces fonctions et vous êtes sûr d'avoir le bon type de données en sortie pour pouvoir travailler dessus.

Voilà je pense avoir fait le tour. On a vu comment nommer une variable, on a vu à quoi elle servait c'est-à-dire à stocker des informations. On va pouvoir faire varier ce qu'elles contiennent.

On verra par la suite comment modifier les valeurs des variables, il suffit simplement de réinfecter une nouvelle valeur comme on l'a fait rapidement dans les exemples qu'on a vu. Il n'y a rien de compliqué mais on ira un petit peu plus loin.

On a vu les types standards grosso modo même si on sait pas trop attardé sur le type long, le type imaginaire, ce genre de choses.

Et on a fait un petit rappel sur les fonctions que vous avez vu jusqu'à présent et les nouvelles notamment que ce soit le input(), le type(), etc. Vous avez eu beaucoup mine de rien. 

En une vidéo, il y a plein de nouvelles et puis éventuellement retenir celle-ci-dessous pour les plus courageux :

```py
# str.format() -> formater une chaîne
```

Retenir cette méthode format des chaînes de caractères comme ça vous pourrez formater du texte sans problème.

Voilà voilà je pense avoir fait le tour de tout ce que je voulais vous montrer ici. Normalement globalement, on a parlé un petit peu de tout ce qu'il y avait à savoir et de tous les types possibles.

On a vu comment afficher des variables donc vous savez du coup comment travailler avec.

On verra dans la vidéo prochaine comment faire des opérations donc manipuler des opérateurs pour faire des calculs ou simplement faire des modifications, des choses comme ça et ça permettra comme ça de poursuivre un petit peu sur l'utilisation des variables puisqu'on va s'en servir tout le temps.

Sur toutes les vidéos toutes les sens que l'on va avoir, on va travailler sur des variables tout le temps tout le temps tout le temps.

Donc retenez tout ce que je vous ai dit là par rapport aux variables et par rapport aux conditions pour nommer une variable,  les types et surtout comment on peut convertir les types de données si jamais y a des problèmes d'affichage notamment avec print() par exemple où input() qui récupère que des chaînes.
On se retrouve pour une prochaine vidéo, je vous dis à très bientôt et bon courage pour la suite !"""

## Resume

```py
###############################################
#################### Resume ################### 
###############################################

#coding:utf-8

#   Python #3 - variables
#   https://www.youtube.com/watch?v=nbecRjzVzNg&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=3
#   C'est parti pour aborder la première notion du langage Python : les variables. Dans ce cours, vous apprendrez comment les utiliser, en créer, afficher leur valeur et même faire saisir des données au clavier.

#1# Les types les plus utiles.
agePersonne = 14 # int
agePersonne2 = "25" # str
prixHT = 120.46 # float
continuer_partie = False # bool
continuer_partie = True # la valeur d'un booléen commence par une majuscule.

#2# Les types les moins utiles.
nombreHexadecimal = 0xFAD588 # stockage d'un nombre hexadécimale (0x...).
nombreOctale = 0o705 # stockage d'un nombre octale (0...).
nombreDeTypeLong = 535633629843 # stockage d'un nombre de type long (avant : ...L), plus grand au niveau de l'espace qu'un entier.
nombreImaginaire = 705j # stockage d'un nombre imaginaire (...j).

#3# Afficher le type d'une variable avec la fonction TYPE
print(type(agePersonne))
print(type(agePersonne2))

#4# Afficher le contenu d'une variable avec la fonction PRINT
print("agePersonne") # afficher du texte entre double quote. 
"""
Peu importe le type de variable, print affiche une chaîne de caractères 
(peut poser des problèmes pendant la saisie de données).
"""
print(agePersonne) # afficher le contenu d'une variable.
print("Âge de la personne", agePersonne) # afficher du texte avec une variable.
print("Âge de la personne", agePersonne,".") # concaténation (pas besoin de drapeau ou d'espace).

#5# Formater du texte au travers d'une boîte {} par la méthode FORMAT
"""
En python, tout est objet (int, str, bool, ...) et chaque objet a des propriétés pour le définir et dire ce qu'il peux faire.
Une chaîne de caractère a des méthodes (fonctions de classe) pour faire certaines choses. 
-> exemple : format est une fonction qui permet de formater du texte.
"""
texte = "L'âge de la personne est {} et le prix HT est de {} euros." 
print(texte.format(agePersonne, prixHT))

print("L'âge de la personne est {} et le prix HT est de {} euros.".format(agePersonne, prixHT))
"""
Avantage de la méthode : elle prend en compte les espaces et tout les types de données.
"""
#6# Saisir des informations avec fonction INPUT
nomJoueur = "Diablo"
print("Bienvenue,", nomJoueur)

nomJoueur = input("Choississez un nom de joueur : ")
print("Bienvenue,", nomJoueur)

#7# Changer le type d'une donnée avec une fonction "CAST".
prixHT = input("Entrez un prix HT : ") # saisie d'un texte par INPUT (prixHT = "12.3").
prixHT = int(prixHT) # INPUT nécessite parfois un CAST.
"""
La conversion en nombre est nécessaire pour les entiers, les float et même les bools.
Le CAST necéssitera de faire des TRY CATCH pour s'assurer qu'il n'y a pas eu de problème.
"""
prixTTC = prixHT + (prixHT * 20 / 100)
print("Prix TTC =", prixTTC)

valeur_booleen = True
valeur_booleen = int(valeur_booleen) # True en 0.
valeur_booleen = str(valeur_booleen) # True en "0".
```