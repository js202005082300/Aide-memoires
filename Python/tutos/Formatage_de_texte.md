# [Formatage de texte](https://www.youtube.com/watch?v=4ApZ80RegNI)

Tutoriel pour aborder le formatage de texte, notion que l'on a déjà abordé au niveau du cours lorsqu'on a commencé la version 3.2 et puis le cours s'est terminé avec la version 3.8. Ce changement de version a permis d'ajouter de nouvelles fonctionnalités concernant le formatage de ce texte, on avait déjà vu des syntaxes au niveau du cours puis d'autres qu'on n'a pas vu dont on peut se passer et que l'on va voir avec un peu plus de détails dans ce tutoriel.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe ,
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe %
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```

## Syntaxe virgule

Alors là syntaxe avec la virgule permet en premier lieu de pouvoir séparer les éléments, c'est une syntaxe qu'on a déjà vu au cours et qui permet de concaténer différentes informations écrit de manière brute c'est à dire de manière littérale donc directement dans le code où bien avec des valeurs qui sont mémorisées dans des variables. Par exemple une variable que l'on va concaténer avec un texte brut.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe ,
#--------------------------------------------------------
name = "Jason"
print("Je m'appelle", name)

#--------------------------------------------------------
# Syntaxe %
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```
```powershell
> python main.py
Je m'appelle Jason
```

Voilà aucun problème pour la concaténation de ces différentes informations.

Autre chose aussi c'est à dire qu'ici on a concaténer une chaîne avec une autre chaîne mais on peut effectuer ce genre de choses avec tout un tas d'autres types d'informations si par exemple on met une chaîne en `d1`, puis qu'on met un nombre en `d2` puis un flottant en `d3` puis une valeur d'un booléen en `d4` puis un tuple en `d5` et une liste en `d6`.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe ,
#--------------------------------------------------------
d1 = "Hello"
d2 = 14
d3 = 316.344
d4 = True
d5 = (12, 21)
d6 = [1, 2, 3, "OK"]
print(d1, d2, d3, d4, d5, d6)

#--------------------------------------------------------
# Syntaxe %
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```
```powershell
> python main.py
Hello 14 316.344 True (12, 21) [1, 2, 3, 'OK']
```

Je fais l'affichage et pourtant vous voyez que tout s'affiche sans problème alors qu'on a des types de données qui sont complètement différents, tout s'est bien concaténé à la suite.

On a l'intégrité des informations qui sont affichées via le print() mais alors pourquoi est-ce que cela fonctionne ? Tout simplement parce qu'elle t'appelait de manière implicite d'autres fonctions au niveau de ces différentes données. Là où il y a une chaîne de caractères, il n'y a pas de problème parce que le print() permet d'afficher des chaînes de caractères donc c'est comme ça qu'il fonctionne et en c'est tout ce qui n'est pas de type str donc de type string sera automatiquement converti c'est à dire qu'il y aura un cast qui sera effectué à l'exécution notamment par l'appel de fonction comme __repr__() ou __str__() qui permet d'obtenir une représentation littérale sous forme de chaîne 2 différentes données.

Voilà dans votre classe vous pouvez simplement dire par exemple pour faire un simple print() d'un simple objet comme un joueur, n'importe quel type de classe que vous avez définie en python ainsi vous pouvez choisir comment vous redéfinissez le comportement de ces fonctions pour vous permettre lorsqu'on fait un print() d'afficher les informations d'une certaine manière donc voilà ces fonctions sur parfaitement définissables.

Ça ce sont des fonctions, des méthodes spéciales que l'on peut parfaitement redéfinir et ne pas hésiter à le faire dans notre classe.

Au niveau du print() parce que c'est ce qui nous intéresse, il y a des appels implicites qui sont faits aux fonctions __repr__() et __str__() en fonction des données que nous avons pour pouvoir traiter toutes ces informations comme des chaînes de caractères parce que au départ toutes ces données (d1, d2, d3, d4, d5 et d6) ne sont pas des chaînes de caractères sauf pour d1.

Ces types de syntaxe sont assez bien mais c'est assez sommaire et quand on va concaténer on voit que ça crée un petit espace entre chaque information donc il y a un espace qui est toujours inséré après la virgule. La virgule est assez sommaire mais elle fait le travail pour laquelle elle a été conçue ainsi on appelle pas n'importe quoi dans le print(), on fait juste un print() des variables que l'on veut afficher et tout s'affiche directement via l'appel implicite à d'autres fonctions qui sont appelées à la volée au niveau de l'exécution de notre programme.

Si on veut procéder à un formatage de données, par exemple si on veut afficher un nombre avec une précision différente par exemple n'avoir que 2 chiffres après la virgule ou ce genre de chose, il faudra utiliser des syntaxes qui sont conçues pour le formatage.

## Syntaxe %

Maintenant la syntaxe % est une vieille syntaxe qui aurait dû être rendu obsolète au niveau de python mais avec la dernière version tu dis a eu au moment ou je fais cette vidéo, cette syntaxe est revenue alors qu'elle aurait dû être dépressive mais finalement ils ont décidé de la garder et je pense que ça restera encore un petit moment donc je pense que c'était bien de vous en parler.

Petit conseil si jamais vous faites du nouveau code, je ne vous conseille pas d'utiliser cette syntaxe. Il existe d'autres syntaxes beaucoup plus récentes on verra après soit format() et "f-string" et qui seront beaucoup plus efficaces.

Cette syntaxe % les familières pour ceux qui ont déjà programmé en c ou en c++ notamment avec l'usage de Flag cela vous dira probablement quelque chose si je vous montre `%d`, `%f`, `%s`, et cetera voilà pour afficher respectivement un entier, pour formater un entier puis pur for matin un float puis pour formater une chaîne de caractères. Il y avait également `%s` pour un caractère seul et cetera et cetera.

Voilà comment ça fonctionne où par exemple on va formater une chaîne de caractères avec le flag `%s`. Pensée par notre chaîne avec les doubles quotes de notre variable par un pourcent (%) et en réalité cela est un tuple avec un seul élément qui est `name`.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe %
#--------------------------------------------------------
name = "Jason"
print("Je m'appelle %s" % name) # % (name)

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```
```powershell
> python main.py
Je m'appelle Jason
```

En réalité on peut écrire `% (name)` au lieu de `% name` c'est à dire un tuple avec un seul élément qui name. Vous avez compris certainement que si c'est un tuple, on peut donc avoir éventuellement d'autres informations.

```py
print("Je m'appelle %s" % name) # % (name, other, another)
```

Là les espaces sont gérés, on parle de formatage donc si j'enlève l'espace il est effectivement enlevé au niveau de l'affichage donc n'oubliez pas qu'on a d'abord le texte entre double guillemets et ensuite dès qu'on a passé le pourcent ce sont les informations incorporées ainsi la première information que l'on a `name` sera attribué au premier Flag `%s` et ainsi de suite.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe %
#--------------------------------------------------------
name = "Jason"
age = 29
print("Je m'appelle %s et j'ai %d ans" % (name, age))

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```
```powershell
> python main.py
Je m'appelle Jason et j'ai 29 ans
```

Voilà on peut facilement faire notre formatage multiple et ça ira sans problème.

C'est une vieille syntaxe qui utilise les mêmes notations que le langage c et qui n'est aujourd'hui plus utilisé.

Si vous travaillez sur du nouveau projet et du nouveau code, vous pouvez vous passer de cette syntaxe-là et normalement elle aurait dû être déprécié donc je n'aurais même pas pu vous en parler et comme elle ne va pas être abandonné tout de suite on en parle ici dans ce tutoriel.

Voilà pour cette syntaxe qui utilise des Flags comment on le ferai en langage c avec la fonction printf().

## Syntaxe avec format

Passons à une version plus récente apparu dans la version python 3.1 ou 3.2, il s'agit de format() qui a peut être même des origines plus anciennes. Bref ce n'est pas très important.

Alors cette syntaxe on l'a déjà vu beaucoup en vidéo, c'est sûrement celle qu'on a le plus employé dans les vidéos de cours mais on va regarder quelques possibilités qu'on n'a pas encore vu dans d'autres vidéos.

Voilà comment elle fonctionne c'est à dire qu'ici au lieu d'avoir des `%` on va utiliser des accolades `{}`.

```py
text = "Bonjour {}"
```

Cette chaîne entre double guillemets est un type de données en python et tout en python est objet donc on va pouvoir utiliser des méthode sur cet objet qui est une chaîne de caractères et cette méthode qu'on appelle s'appelle tout simplement format() et prends en argument les différentes informations et comme on a qu'un seul couple d'accolades on n'aura qu'un seul argument à renseigner.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe avec format()
#--------------------------------------------------------
text = "Bonjour {}".format("Jason")
print(text)

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
```
```powershell
> python main.py
Bonjour Jason
```

Sans passer par une variable intermédiaire.

```py
#text =
print("Bonjour {}".format("Jason"))
```

Si on a d'autres informations à ajouter.

```py
#coding:utf-8

text = "Bonjour {} et j'ai {} ans".format("Jason", 29)
print(text)
```
```powershell
> python main.py
Bonjour Jason et j'ai 29 ans
```

On peut encore une fois passer par des variables plutôt que des valeurs en dur.

```py
#coding:utf-8

age = 29
text = "Bonjour {} et j'ai {} ans".format("Jason", age)
print(text)
```
```powershell
> python main.py
Bonjour Jason et j'ai 29 ans
```

Petite précision, affichons un nombre flottant avec print() qui est appeler de manière implicite pour traiter ça sous forme de chaîne de caractères.

```py
#coding:utf-8

number = 164.32641
print(number)
```
```powershell
> python main.py
164.32641
```

On le traite comme un entier, on a une concaténation qui est faite et ensuite str() serra appeler pour traiter ça sous forme de chaîne.

```py
#coding:utf-8

number = 164.32641
print(int(number))
```
```powershell
> python main.py
164
```

Cette print() qui a toujours le dernier mot, et qui traite ça sous forme de chaîne comme je vous l'avais expliqué avec les méthodes spéciales.

Maintenant pour avoir une préciion à deux chiffres avec la méthode format() bien qu'on aurais pu le faire avec la syntaxe `%` mais on conseille plutôt format(). La syntaxe c'est `:` puis un point `.` pour les décimales puis le nombre de décimales et on formate un flottant donc `{:.2f}`.

```py
#coding:utf-8

number = 164.32641
print("{:.2f}".format(number))
```
```powershell
> python main.py
164.33
```

L'arrondi est fait également.

Autre petite précision au niveau du texte.

```py
#coding:utf-8

text = "Jason"
print("{:>15}".format(text))
```
```powershell
> python main.py
          Jason
```

On lui dit simplement d'avoir 15 caractères octroyés pour cette variable. A la fin de ces 15 caractères, on a la valeur de la variable et comme la variable n'en occupe que 5, on retrouve 10 espaces blanc avant.

Par exemple, on peut utiliser ce moyen pour formater notre texte avec une belle présentation, une présentation sous forme de tableau avec des + et des |.

```txt
    +-------+-------+
    |       |       |
    +-------+-------+
    |       |       |
    +-------+-------+
    |       |       |
    +-------+-------+
```

Bref, on peut s'amuser à afficher un tableau notamment quand on fait du SQL lorsqu'on fait des requêtes pour afficher les données de manière propre, de manière formatée.

Voilà pour mettre des caractères blanc avant la valeur.

Pour mettre les caractères blancs après la valeur, on a la syntaxe `{:10}`.

```py
#coding:utf-8

text = "Jason"
print("{:10}".format(text))
```
```powershell
> python main.py
Jason     
```

On ne les verra pas sauf si on met un petit caractère de fin.

```py
#coding:utf-8

text = "Jason"
print("{:10}/{}".format(text, "test"))
```
```powershell
> python main.py
Jason     /test
```

On a d'abord les 5 premiers caractères utilisés par la chaîne puis 5 caractères blancs de libres.

Dans ce cas `print("{:10}/{}".format(text, "test"))`, le format peut devenir illisible au fur et à mesures qu'on ajoute des données.

Maintenant, autre chose est intéressant, on commence avec une variable qui s'appelle `dic` pour dictionnaire parceque que `dict` est un mot réservé. On va mettre cet information-là `dic = {"name" : "Jason"}` et ensuite on dit que format() attend notre dictionnaire mais on met bien une double astérisque `print("{name}".format(**dic))` avec le nom injecté directement entre accolades qui est notre clé d'accord qui va être recherché dans ce dictionnaire la valeur qui correcpond à ce qu'on a indiqué entre les accolades.

```py
#coding:utf-8

dic = {"name" : "Jason"}
print("{name}".format(**dic))
```
```powershell
> python main.py
Jason
```

Pratique car cela permet de concaténer très rapidement et d'avoir un formatage bien précis.

L'avantage au niveau des dictionnaires c'est que vous pouvez avoir tout un tas d'autres informations qui sont enregistrés (dic) et ici avec comme argument notre dictionnaire `format(**dic)` vous pouvez injecter les données de manière rapide de cette manière `{name}` donc très pratique mais l'inconvénient c'est quand une syntaxe peu lisible lorsqu'on va avoir beaucoup de données qui vont s'ajouter.

S'il y a une fonctionnalités à utiliser, le plus pour le formatage de texte c'est cette méthode format().

C'est la méthode à privilégier au niveau de la programmation de notre programme.

## Syntaxe f-string

Par contre depuis la version 3.6 de python, une nouvelle syntaxe est apparue elle s'appelle "f-string" et c'est une syntaxe qui est faite pour être beaucoup plus rapide donc traiter directement à l'exécution de notre programme avec l'emplacement des valeurs qui sera fait à l'exécution donc ça fait pour être très rapide et très optimisé donc c'est bien plus intéressant que d'autres syntaxes ou d'autres méthodes pour faire du formatage.

En plus elle est très très simple cette méthode à utiliser.

Pareil à ne regardera pas toutes les possibilités qu'il y a avec cette méthode comme on a vu déjà beaucoup avec la fonction format(). Vous verrez qu'avez f-string, il y a pas mal de méthodes aussi.

Voilà comment s'en sert (on s'en est déjà servi dans les dernières vidéos du cours python lorsqu'on est passé à la version 3.6). Cela rejoint la syntaxe des dictionnaire.

```py
#coding:utf-8

#--------------------------------------------------------
# Syntaxe "f-string"
#--------------------------------------------------------
name = "Jason"
print(f"Je m'appelle {name}")
print(F"Je m'appelle {name}")
```
```powershell
> python main.py
Je m'appelle Jason
Je m'appelle Jason
```

Doit mettre un f/F majuscule ou minuscule avant le début de la chaîne et dans la fonction print().

Idem pour d'autres types d'objets.

```py
#coding:utf-8

li = [1, 2, 3]
print(f"{li}")
```
```powershell
> python main.py
[1, 2, 3]
```

Ça c'est la syntaxe au niveau optimisation qui est à privilégier pour faire du formatage de texte.

Suivant vos habitudes vous pouvez continuer à utiliser format(), vous servir de f-string qui sont les 2 méthodes à privilégier.

Pour la syntaxe avec les `%`, il faut éviter parce que à terme elle sera dépréciée.

Ensuite pour la syntaxe avec les `,`, on est sur quelque chose de beaucoup plus basique donc à vous de voir.

Choisir la syntaxe la plus simple et la plus fonctionnelle puis on optimisera en se posant des questions sur les différentes méthodes de formatages et bien-sûr consulter la doc si vous vouler en apprendre plus notamment sur la méthode format().

Ciao tout le monde