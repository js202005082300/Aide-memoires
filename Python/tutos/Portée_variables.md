# [Portée variables](https://www.youtube.com/watch?v=50HJA4KpPqU)

Nouveau tutoriel sur le langage python avec une petite parenthèse sur la portée des variables donc ce ne sera pas une vidéo très longue mais c'est un passage qui peut être important à aborder avec ce langage et nous allons voir ça avec des exemples en complément à ce cours.

Nous avions déjà parlé de la portée des variables dont la vidéo sur les variables en vous disant que chaque variable appartenait à la fonction où elle était déclarée d'une certaine manière et qu'on aurait l'occasion de voir d'autres choses par la suite dans les vidéos annexes concernant leur portée et l'endroit où on peut les utiliser.

```py
#coding:utf-8

```

Alors dans notre fichier ici nous avons d'abord le code principal au niveau de notre programme, on va pouvoir créer une variable sans problème `name = "Jason"` et afficher l'information comme ceci.

```py
#coding:utf-8

name = "Jason"
print(name)
```
```powershell
> python main.py
Jason
```

Voilà ça s'affiche sans problème et tout ce code est contenu dans la partie principale de notre programme, ce n'est pas dans une fonction en particulier donc on est dans le code principal de notre fichier directement dans cet espace là.

Maintenant ce qui est intéressant c'est de faire notre affichage dans une fonction, ce qui en langage c ne fonctionnerait pas puisqu'on essaie d'accéder à une variable qui n'est pas disponible dans cette fonction, sans passer la variable en paramètre donc logiquement ne devrait pas pouvoir l'afficher. Ensuite on fait l'appel de notre fonction et là on voit que la fonction fonctionne.

```py
#coding:utf-8

name = "Jason"

def show_name():
    print(name)

show_name()
```
```powershell
> python main.py
Jason
```

Voilà on a réussi à accéder à la variable, ce qui n'est pas possible dans d'autres langages que le python par exemple, alors pourquoi est-ce que ça a fonctionné contrairement à d'autres langages notamment ? C'est tout simplement une espèce de recherche qui va se faire non pas de manière récursive mais qui va se faire par rapport à l'interpréteur.

Ainsi quand je demande à l'interpréteur de faire un `print(name)` alors que ceci on peut imaginer que c'est un espace tout seul, l'environnement de ma méthode.

```py
def show_name():
    print(name)
```

Voilà donc cette fonction il faut imaginer que c'est un espace à part, cette fonction c'est comme une boîte c'est à dire qu'elle est vraiment à part et tout le reste en enlevant cette méthode c'est le code principal.

```py
>   #coding:utf-8
>
>   name = "Jason"
>
    def show_name():
        print(name)
>
>   show_name()
```

Voilà donc on a plus ou moins de boîte c'est à dire on a le code principal et on a la fonction show_name().

Ici quand on va tenter de faire le `print(name)`, il va cherché cette variable qui s'appelle `name` dans cet espace donc dans notre boîte qui composent en fait la fonction. Comme l'interpréteur ne trouve pas cette variable dans cette boîte, l'interpréteur de python fonctionne de telle manière Ah du coup aller à l'endroit où on a appelé cette fonction et ça tombe bien parce que cette fonction on l'a appelé ici dans le code principal.

```py
    #coding:utf-8

    name = "Jason"

    def show_name():
        print(name)

>   show_name()
```

Il va donc retourner en arrière si vous voulez à l'endroit où la fonction a été appelée, tout simplement l'espace appelant de la fonction et ici comme la variable `name` existe, l'interpréteur de python va pouvoir l'afficher donc du coup il fonctionne de cette manière pour y accéder.

Maintenant si je décide de modifier le code pour pouvoir modifier la variable dans l'environnement de ma fonction, théoriquement cet appel de fonction devrait retourner le prénom Luc.

```py
#coding:utf-8

name = "Jason"

def show_name():
    name = "Luc"
    print(name)

print(name)
show_name()
```
```powershell
> python main.py
Jason
Luc
```

Si je teste cette fois-ci nous voyons que la modification fonctionne, pourquoi ? tout simplement parce que j'ai créé une variable `name` au sein de ma fonction et ainsi le `print(name)` que je fais n'est plus le `name = "Jason"` que j'ai mais il est devenu `name = "Luc"` donc là en fait on n'a pas fait de modification pourtant on pourrait le penser.

On n'a pas fait de modification et donc c'était important à l'évoquer dans cette vidéo au niveau de python parce que c'est des choses qui risquent de nous induire en erreur donc c'est un bon complément à la formation.

Encore une fois on pourrait penser que j'ai modifié cette variable `name` alors que non parce que en ayant déclaré `name = "Luc"` dans la mémoire de PC même si on ne parle pas trop de mémoire concernant python parce que c'est un langage plus au niveau que le C, vous avez pu voir qu'on ne parlait pas beaucoup de mémoire parce que en réalité c'est python qui se charge de tout ça.

En réalité je ne fais pas de modification, j'ai créé simplement une autre variable. Si vous voulez cette variable `name = "Luc"` ne va pas être stockée au même endroit que cette variable `name = "Jason"` même si elle porte le même nom donc en faisant ce `print(name)` à l'intérieur de la fonction show_name(), on pourrait penser que j'ai remplacé "Jason" par "Luc" alors qu'en réalité j'ai créé une nouvelle variable.

On peut voir également d'une autre manière en essayant de modifier la variable de cette façon mais vous allez voir que ça ne va pas marcher.

```py
#coding:utf-8

name = "Jason"

def modify_name():
    name = "Luc"

print(name)
modify_name()
print(name)
```
```powershell
> python main.py
Jason
Jason
```

Voilà il n'y a pas eu de modification tout simplement parce que les variables qui sont déclarées dans une fonction n'appartiennent k cette fonction et dès que l'on sort de la fonction en question la variable est détruite et ça on en avait parlé d'ailleurs sur la séance sur les fonctions, on était revenu sur les l'histoire des variables et de leur portée donc c'est ça la portée des variables c'est de dire que chaque variable appartient à son espace quand elle a été déclarée.

Toute variable qui a été créée dans une fonction n'existera que dans cette fonction, c'est pour ça qu'on a appris dans la vidéo sur les fonctions à faire éventuellement un `return name` et puis je les récupérer après en faisant par exemple ceci `name = modify_name().

```py
#coding:utf-8

name = "Jason"

def modify_name():
    name = "Luc"
    return name

print(name)
name = modify_name()
print(name)
```
```powershell
> python main.py
Jason
Luc
```

Là effectivement on aura fait la réplication donc ce n'est que du rappel, que des choses qu'on a évoqué abordé aussi bien sur la vidéo des variables que sur la vidéo des fonctions pour travailler directement sur ces variables là et les modifier directement dans des fonctions.

C'est important de bien comprendre que l'accès ne va pas poser de soucis en étant dans une fonction par contre la modification ne fonctionne pas alors ça c'est un petit point du langage python c'est à dire que même si on essaye de faire ce qu'on avait fait au début ici.

```py
#coding:utf-8

name = "Jason"

def show_name():
    print(name)

show_name()
```
```powershell
> python main.py
Jason
```

Et là exceptionnellement l'interpréteur python est capable de revenir comme je vous l'ai expliqué au début alors endroit où on a appelé la fameuse fonction, et du coup s'il trouve la variable en question ça fonctionnera.

Attention même si ça fonctionne ce principe là, je vous conseille dans votre programmation d'éviter au maximum de faire appel à des variables qui n'existent pas normalement dans la fonction où on l'appelle même si python permet de le faire, comme la majorité des langages de programmation ne permettent pas justement ce qui amènerait une erreur de compilation ou d'interprétation donc c'est mieux de garder cette habitude de ne pas le faire parce qu'en réalité **on peut accéder à une variable qui se trouve dans un espace autre par contre on ne pourra pas là modifier** et c'est ce que je vous ai montré dans cette vidéo.

Attention à ce niveau-là donc travailler toujours comme on a pu le faire dans d'autres langages de programmation si vous en connaissez d'autres, sinon gardez ce principe d'éviter de faire ce genre de choses mais si vous voulez vraiment l'afficher faites comme ceci en passant name comme paramètres de la fonction `show_name(name)` et là vous le récupérez ici `def show_name(prenom)` par exemple on va l'appeler prenom et puis on va l'afficher de cette manière `print(prenom)` et là ce sera beaucoup plus lisible.

```py
#coding:utf-8

name = "Jason"

def show_name(prenom):
    print(prenom)

show_name(name)
```
```powershell
> python main.py
Jason
```

Question lisibilité maintenant on voit ce que l'on fait et on se rend bien compte que cette variable `prenom` elle n'est pas tombée du ciel car elle a été appelée, demandé comme paramètre de notre fonction donc là à l'appel `show_name(name)` c'est tout de suite plus clair et au Mans respecte bien cette histoire de transmission de variables d'une fonction à une autre.

Voilà c'est bien mieux comme ça.

## Les variables globales

Alors nous allons voir maintenant un autre cas où on aurait par exemple besoin de travailler sur des variables qui fonctionnerait sur plusieurs fonctions, plusieurs classes éventuellement et vous n'avez pas spécialement envie de passer. Pareil c'est une méthode à limiter mais attention ça ne veut pas dire qu'il ne faut pas là faire du tout, pareil il y a des langages de programmation où on va déconseiller l'usage de cette méthode par contre pour python vous pouvez encore en faire l'usage tant que c'est fait intelligemment ou alors c'est parce que vous n'avez pas d'autre choix, il s'agit tout simplement du cas des variables globales.

Une variable globale est tout simplement une variable qui est aussi bien accessible en lecture qu'en écriture (c'est-à-dire la modifier partout dans votre code). C'est pareil, dans la mesure du possible utilisez toujours le principe des variables comment on l'a vu jusqu à présent dans toute la vidéo et quand il y a des moments où ça devient trop compliqué et que vous n'ayez pas trop le choix, on peut utiliser le fonctionnement des variables globales d'accord ça fait pour ça.

Si c'était complètement mauvais les variables globales ça n'existerait tout simplement pas donc si ça a été intégré dans le langage c'est que dans certains cas ça peut être beaucoup plus pratique, ça peut même être recommandé de l'utiliser. Alors comment est ce qu'on fait une variable globale ? Je vais utiliser le mot clé global et je vais mettre name, `global name`.

```py
#coding:utf-8

name = "Jason"

def edit_name(prenom):
    global name
    print(prenom)

edit_name(name)
```
```powershell
> python main.py
Jason
```

Voilà l'interpréteur vont faire chercher dans le programme une variable qui s'appelle name avec cette petite syntaxe `global name` donc il ne va plus pouvoir simplement lire cette variable `name = "Jason"` mais il pourra aussi écrire dedans parce qu'il aura connaissance vraiment de cette variable. Avant sans avoir mis cette ligne `global name`, on aurait pu juste y accéder c'est-à-dire la lire mais on n'aurait pas pu la modifier donc grâce à cette petite ligne en plus on va pouvoir faire la modification c'est à dire de faire maintenant ceci `name = "Luc"`.

```py
#coding:utf-8

name = "Jason"

def edit_name():
    global name
    name = "Luc"

print(name)
edit_name()
print(name)
```
```powershell
> python main.py
Jason
Luc
```

Voilà on n'a rien passé en paramètre de notre fonction edit_name() et la modification va se passer grâce à ce mot-clé `global` pour rendre la variable globale donc attention ce n'est pas la déclaration de `name = "Jason"` en faisant ceci `global name = "Jason"` donc c'est à l'endroit où vous voulez la retrouver qu'on doit mettre ce mot clé donc en général c'est comme ça qu'on procède c'est-à-dire qu'on met notre variable créée nous on veut et quand on en a besoin on utilise ce mot clé `global` pour indiquer un interpréteur de chercher une variable dans tous les espaces qui porte ce nom `name` et du coup la rendre globale comme ça elle sera accessible en lecture, en écriture.

Ah voilà c'est intéressant à savoir en python, ce n'est pas obligatoire donc c'est pour ça que j'ai décidé de mettre cette vidéo dans les tutoriels en annexe c'est pas directement dans le cours parce que vous pouvez très bien vous en passer, vous pouvez très bien programmer en python sans jamais utiliser de variables globales donc c'est vraiment un petit plus pour vous en complément de ce qu'on avait déjà abordé sur les variables dans le cours pour ça qu'ils veulent aller encore plus loin de tout ce qu'on a vu avec la programmation python.

Si jamais vous pouvez faire des tests de votre côté pour voir la différence entre les variables globales et locales.

## Copier une liste

Une dernière petite parenthèse à propos des listes où on avait vu qu'on ne pouvait pas faire une copie de cette manière `liste2 = liste1`.

```py
#coding:utf-8

liste1 = [1, 2, 3]

liste2 = liste1
```

On ne peut pas faire une copie de cette manière parce qu'en faisant ça on crée une 2e liste qui est une référence c'est-à-dire qui pointe vers le même endroit en mémoire que la `liste1` et du coup quand on ajoutait un élément à la `liste1`, cet élément est également ajouté à la `liste2`, ce sont en fait des clones c'est à dire que quand on fait quelque chose sur la première liste s'est automatiquement répercutée sur la 2e.

On avait notamment utilisé deepcopy() qu'on avait vu dans la vidéo sur les listes pour pouvoir effectivement la copier.

```py
#coding:utf-8
import copy

liste1 = [1, 2, 3]

liste2 = copy.deepcopy(liste1)
```

On pourrait également créer notre `liste2` avec la méthode list() qui appelle notre `liste1` pour effectuer une copie et non pas une référence..

```py
#coding:utf-8

liste1 = [1, 2, 3]

liste2 = list(liste1)
```

Sachez que pour l'instant le terme de référence on ne l'emploie pas trop en python parce que ce n'est pas forcément quelque chose de relativement clair, c'est quelque chose de très très utilisé par exemple dans le c++ mais voilà pour python on n'en parle pas forcément parce que c'est caché, masqué parce qu'encore une fois python est de beaucoup plus haut niveau donc on ne s'occupe pas de savoir comment est gérée la mémoire, comment et gérer les accès mémoire et le stockage en mémoire.

Voilà ça c'était la petite parenthèse de fin mais ça on l'avait déjà vu c'était juste histoire de faire le lien avec notamment la vidéo sur les listes parce que je vous avais dit qu'on pouvait donner plus de détails dessus.

À bientôt