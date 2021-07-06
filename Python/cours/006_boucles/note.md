# [6. Boucles](https://www.youtube.com/watch?v=excGUISppC4)

+ [while](#while)
+ [for](#for)
+ [Resume](#Resume)

Bonjour à tous, vous êtes sur votre 6e séance sur le langage python.

On a vu les conditions la dernière fois et nous allons en parler comme je vous l'avais dit, des boucles.

Nous allons voir comment répéter certains traitements, un certain nombre de fois.

On va prendre un exemple sans boucle, comment on ferait tout simplement un certain type de programme sans l'utilisation de cette notion de boucle que vous ne connaissez pas encore.

Par exemple la répétition d'une information donc de l'instruction que l'on afficherait, d'accord.
```py
coding:utf-8
print("Je suis une phrase")
```
"Je suis une phrase", on va prendre cette exemple là. Si bien évidemment, je fais fait ce programme là, je vais directement tester l'affichage et l'afficher.
```powershell
>python main.py
Je suis une phrase
```
Maintenant si je veux l'afficher plusieurs fois, je vais devoir évidemment faire du copier-coller, ça c'est obligatoire je peux pas faire autrement.
```py
coding:utf-8
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")
```
```powershell
>python main.py
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
```
...ça fait du coup de la répétition, c'est pas propre du tout évidemment parce que quand même ça, c'est une règle d'or en informatique, c'est que lorsque vous commencer à répéter du code, il faut trouver un moyen de ne plus le faire, trouver un moyen d'automatiser tout ça pour ne pas devoir répéter où faire du copier-coller ici, ces commandes-là, d'instruction.

Du coup, on va utiliser, on va découvrir en tout cas un nouveau mot-clé et une nouvelle notion de langage python qui est l'utilisation des boucles.

## while

Pour cela, on va se servir du mot-clé while qui est ce dernier.
```py
#coding:utf-8

while
print("Je suis une phrase")
```

Le mot-clé while, il va fonctionner comme pour le les conditions, il va fonctionner avec des variables et éventuellement des opérateurs de comparaison pour pouvoir vérifier notamment par exemple un point d'arrêt.

Un point d'arrêt, c'est quand votre boucle va s'arrêter. Moi je vais lui dire tout simplement donc avec une variable qui sera ici un compteur donc souvent dans le langage de programmation, on l'appel i, après on peut l'appeler, si on a une 2e j, k et cetera.

Donc on met simplement une seule lettre mais on va l'appeler compteur pour savoir de quoi on parle et je vais mettre par défaut à 0, voilà.

```py
#coding:utf-8
    
compteur = 0

while
print("Je suis une phrase")
```
Je veux dire donc while compteur est plus petit que 5 par exemple et mes deux points.
```py
#coding:utf-8
    
compteur = 0

while compteur < 5:
print("Je suis une phrase")
```
Donc tant que compteur, ici est plus petit que 5 qu'est-ce que je vais faire ? Donc on n'oublie pas la tabulation pour entrer dans la condition, je vais afficher cette phrase.
```py
#coding:utf-8

compteur = 0

while compteur < 5:
   print("Je suis une phrase")
```
Et je n'oublie pas de modifier ma variable parce que là, vous voyez, si je le lance le programme, je l'arrête avant avec ctrl+c, il me fait une boucle infinie c'est-à-dire qu'il m'affiche à l'infini mon instruction.
```powershell
>python main.py
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
...
```
Si je ne l'avais pas arrêter moi-même, j'aurais certainement fait planter l'ordinateur du coup, on fait attention à ça, les boucle infinie, donc vous laissé pas tourné comme ça longtemps.

Bon après sur des grosses configurations, ça peut tourner un petit moment avant de planter, je veux dire comme là moi, j'ai 32 gigas de mémoire alors bien évidemment, ça ne va pas planter tout de suite par contre, il faut éviter de laisser tourner ça en boucle parce qu'il arrive à un moment donné où ça risque d'être un peu compliqué.

Du coup, nous ce qu'on va faire c'est de ne pas oublier surtout d'augmenter la valeur de compteur.

On va dire que compteur, il augmente de 1.
```py
#coding:utf-8

compteur = 0

while compteur < 5:
   print("Je suis une phrase")
   compteur += 1
```
Voilà c'est pour ça que je l'ai appelé compteur.

Donc on n'oublie pas de toujours, dans une boucle, notamment ici le while, d'avoir quelque chose qui va permettre d'arriver à un point d'arrêt puisque là au bout d'un moment, on est d'accord que compteur, il va passer à 5.

Comment ça va se passer ? Compteur est égal à 0 donc je vais vous le tester d'ailleurs avant.
```powershell
>python main.py
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
```
Voilà, il a bien affiché le print 5 fois, pourquoi ? compteur à la base est égal à 0.
Là, il fait un test "compteur < 5", si le compteur est plus petit enfin tant que compteur est plus petit que 5, c'est effectivement le cas, il y a 0; tu affiches la phrase donc c'est bien ce qu'il a fait la première "Je suis une phrase" et ensuite tu lui ajoute 1 donc le compteur devient 1.

On repasse dans la boucle c'est-à-dire quand on arrive à la fin, on revient au while, il re vérifie... est-ce que compteur est plus petit que 5 ? Oui, 1 c'est plus petit que 5 donc il retourne dans la boucle, il fait ça.
```py
print("Je suis une phrase")
```
Et il lui ajoute plus 1, donc ça devient 2. Est-ce que 2 est plus petit que 5 ? oui donc je recommence, j'affiche. Ca devient 3, est-ce que 3 plus petit que 5 ? oui, j'affiche. Tu ajoute 1. Est-ce que 4 plus petit que 5 ? oui, je re affiche une 5e fois.

là ça devient 5, est-ce que 5 est plus petit que 5 ? non donc je sors de la boucle donc on ne va plus rentrer dedans, voilà comment ça se passe. 

D'ailleurs je vous montre.
```py
#coding:utf-8

compteur = 0

while compteur < 5:
   print("Je suis une phrase")
   compteur += 1
   
print("Je suis sorti de la boucle")
```
"Je suis sorti de la boucle" comme pour un IF, comme pour des conditions dès qu'on n'est plus en tabulation, d'accord, on n'est plus considéré comme étant dans la structure, voilà.
```powershell
>python main.py
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis sorti de la boucle
```
Donc là, il vous "je suis sorti de la boucle" c'est-à-dire qu'on y est plus donc il a bien fait 5 fois.

Si je veux l'afficher 10 fois, ben je vais mettre 10, tout simplement, d'accord.
```py
#coding:utf-8

compteur = 0

while compteur < 10:
   print("Je suis une phrase")
   compteur += 1
   
print("Je suis sorti de la boucle")
```
```powershell
>python main.py
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis une phrase
Je suis sorti de la boucle
```

On peut mettre 100 pour S'amuser et voyez c'est très très rapide, ça vous fait comme ça un affichage en boucle, voilà. Il y a quelque chose donc c'est vraiment très très important dans la programmation d'avoir ce système de boucle, ça va servir à pas mal de choses notamment pour parcourir des structures de données pour parcourir des informations ou pour tout simplement dans certains cas, notamment tout ce qui est graphique, afficher, faire de l'affichage.

Par exemple, votre écran d'ordinateur là est affiché grâce à une boucle, tout ce que vous voyez à l'affichage ici, c'est une boucle qui va faire tourner tout ce qui est fonctionnalités donc au niveau de l'affichage de votre écran et qui va également se mettre à jour en temps réel donc vous allez avoir vos images, vos fenêtres. Par exemple, quand moi, je vais déplacer ma fenêtre ici ... en réalité il me met à jour l'affichage, en boucle, en temps réel bien évidemment, ce qui fait que pour vous, vous voyez une fenêtre qui bouge à l'écran alors qu'en réalité c'est un ensemble de plusieurs images qui va changer de coordonnées et qui va être mis à jour comme ça dans une boucle qui elle tourne en fond, voilà.

Voilà, comment ça fonctionne grosso modo pour rester simple parce que je ne veux pas vous compliquer, non plus, le détail donc de ce que je vous raconte.

Donc voilà comment ça va fonctionner.

Dans un jeu vidéo par exemple on va avoir une boucle, je vais vous montrer avec le while, qui sera une boucle infinie tout simplement c'est-à-dire qu'on va charger le jeu pour pas mal de choses donc on peut imaginer, tiens on va dire "continuer_partie = True", voilà.

```py
#coding:utf-8

continuer_partie = True
```
Et on va faire un while ou alors plutôt jeu_lance et dire tant que le jeu est lancé et ben tu fais pas mal de choses, d'accord.
```py
#coding:utf-8

jeu_lance = True

while jeu_lance:
    #Fais des instructions en rapport avec le jeu

print("A bientôt...")
```
A partir de moment où on a quitté et ben là, on n'est plus dans le jeu donc c'est fini, voilà tout simplement.

Donc on va avoir une boucle infinie puisqu'elle ne s'arrêtera jamais donc ça on peut le retrouver beaucoup dans le jeu vidéo. Comment on va faire pour ne pas avoir quelque chose par exemple qui vas s'exécuter à l'infini ? et Ben on va attendre quelque chose. On pourrait très bien imaginer ... je vais vous montrer d'ailleurs. Je vais créer une variable ici.

On va faire ça tout simplement, j'sais pas moi, choixmenu et input() et on va mettre ce genre de choses.
```py
#coding:utf-8

jeu_lance = True

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")

print("A bientôt...")
```
Tout simplement, vous voyez c'est quoi ? C'est une sorte de terminal. Vous voyez le terminal que j'ai ici, que vous utilisez pour compiler notamment en ligne de commande. Et bien on va le faire,voilà on va la répéter, comme ça dans cette ligne là "choixMenu = ("> ")".

Alors par contre, avant tout, je vais faire un petit print(""), voilà pour passer la ligne.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")

print("A bientôt...")
```
Et je vais faire ça et là selon ce que j'ai dans le choixMenu, admettons je vais dire, par exemple, si choixMenu égal égal, admettons que j'ai une commande "quitter" d'accord, tout simplement, bah je sais pas moi, il va quitter.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")
        
    if choixMenu == "quitter":

print("A bientôt...")
```
Alors là on verra ce qu'il fera notamment avec un mot-clé qu'on va voir plus tard qui s'appelle break.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")
        
    if choixMenu == "quitter":
        break

print("A bientôt...")
```
break, ça va tout simplement permettre de sortir de notre boucle c'est-à-dire que bah c'est cassé la boucle donc on va arriver ici, d'accord.
```py
if choixMenu == "quitter":
    break
```
On en a un autre qui va être "continue", et vous verrez un petit peu ce que c'est.

Alors on va faire, on va mettre des mots anglais, par exemple, si je tape "again" et bah il va dire "continue". 
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")
        
    if choixMenu == "again":
        continue
        
    if choixMenu == "quit":
        break

print("A bientôt...")
```
continue, il va revenir à la boucle, il va pas exécuter ce qu'il y a après, il va dire bon ben ok, je continue la boucle donc il va revenir là.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance: ## <-------
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")
        
    if choixMenu == "again":
        continue
        
    if choixMenu == "quit":
        break

print("A bientôt...")
```
Il revient là comme si on était arrivé à la fin, en fait, de la boucle donc il va juste faire ça mais admettons que "again" c'est parce qu'on a fait une erreur, alors on tape "again" et bien on reviendra à l'affichage ici de ce petit prompt.

```py
choixMenu = input("> ")
```
Sinon qu'est-ce qu'on peut avoir ? alors c'est pareil là, je peux faire un ELIF bien sûr, voilà, et vous pouvez terminer en ELSE et dire print("Commande introuvable") par exemple. Voilà comment on pourrait gérer un terminal en fait, grosso modo, si on imagine terminal minimaliste comme on peut le voir ici.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
    #Fais des instructions en rapport avec le jeu
    choixMenu = input("> ")
        
    if choixMenu == "again":
        continue
    elif choixMenu == "quit":
        break
    else:
        print("Commande introuvable")

print("A bientôt...")
```
Donc on a un ensemble de commandes bien évidemment qui sont définis et qui seront utilisables mais qui font pas mal de petites choses, qui font appel à des fonctions et cetera mais on ne l'a pas encore vu donc je vous ne le montre pas dans cet exemple. On pourrait avoir, je sais pas moi, choixMenu == "hello" et par exemple, on va print("Bonjour :) !").
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
   #Fais des instructions en rapport avec le jeu
   choixMenu = input("> ")
   
   if choixMenu == "again":
       continue
   elif choixMenu == "quit":
       break
   elif choixMenu == "hello":
       print("Bonjour :) !")
   else:
       print("Commande introuvable")

print("A bientôt...")
```
Voilà, on va rester très simple. On exécute et là vous voyez qui me met un petit peu prompt, tout simplement.
```powershell
>python main.py

>
```
Donc si je tape n'importe quoi, il met que la commande est introuvable mais il revient bien au début de la boucle puisque ici le jeu est lancé. 
```powershell
>python main.py

> zefzef
Commande introuvable
>
```
D'ailleurs c'est ça que j'ai mit "break" ça mais en fait, plutôt que d'utiliser "break", j'aurais juste à faire ça. jeu_lance devient False puisqu'à partir du moment où je change ça comme c'est ce qui tient la boucle bah on va arriver sur un point d'arrêt donc on va la quitter, ok.
```py
#coding:utf-8

jeu_lance = True
print("")

while jeu_lance:
   #Fais des instructions en rapport avec le jeu
   choixMenu = input("> ")
   
   if choixMenu == "again":
       continue
   elif choixMenu == "quit":
       jeu_lance = False
   elif choixMenu == "hello":
       print("Bonjour :) !")
   else:
       print("Commande introuvable")

print("A bientôt...")
```
Je vais lancer le programme donc voilà.
```powershell
>python main.py

> again
>
```
Donc si je fais again, voyez, il me relance le prompt directement, "again" voyez et il continue.

Si je mets "hello", il m'affiche Bonjour et il me remet le prompt directement, il suit bien la boucle.
```powershell
>python main.py

> hello
Bonjour :) !
>
```
Et si je ne "quit", il quitte effectivement puisque jeu_lance est devenu False, voilà, à bientôt.
```powershell
>python main.py

> quit
A bientôt...
```
Voilà comment peut s'utiliser une boucle, très très pratique. On aura l'occasion de le faire d'ailleurs dans certains projets ou dans des programmes un peu plus, on va dire, pousser. Notamment si vous même, je sais pas, si vous avez prévu de faire un jeu vidéo ou ce genre de choses, vous verrez qu'au début quand on n'a pas d'interface graphique, quand on n'a pas de de 2D pour, un petit peu, afficher des images et cetera pour son jeu, on va quelque part simuler le fonctionnement du jeu, les affichages avec la ligne de commande et du coup, faire un espèce de petit terminal, comme ça, qui exécute des choses peut être intéressant.

Ca permet de simuler le déplacement d'un personnage, simuler par exemple l'acquisition d'un objet dans un inventaire, ce genre de choses. C'est très très pratique, mine de rien, c'est pour ça que je vous le montre comme exemple, déjà parce que c'est très très simple à mettre en place et vous pourrez certainement re utiliser dans certains de vos projets donc n'hésitez pas, à vous servir comme ça, à faire une boucle infinie qui est évidemment bloqué, pour éviter les problèmes avec un input().

Et à partir de là, vous voyez, vous pouvez faire tout un ensemble de choses suivant ce qui a été enregistré donc par l'utilisateur et ici au niveau de la demande de l'input(), voilà, c'est une possibilité.

Donc ça c'est juste ce qu'il y a dans le while, c'est pareil au niveau, de ce que j'avais tout à l'heure, au niveau du compteur.

Petite précision si vous faites notamment du C, du C++, vous savez probablement si vous avez fait des conditions, des boucles que l'on peut faire, par exemple, i++ pour dire qu'on augmente la variable i de 1 ou alors ++i qui est de la pré incrémentation, ça ça n'existe pas en python.

En python vous êtes obligé de faire i égal i plus 1 ou alors i plus égal 1.
```py
"""
    i = i + 1
    i += 1
"""
```

Voilà petite précision, il n'y a pas de raccourci, en fait, pour le faire. Vous êtes obligé de passer par ce genre de syntaxe là.

Donc voilà, on a vu les mots-clés alors je vais le noter encore une fois, ça c'est toujours pour vous donc :
```py
"""
        Boucles : while / for
"""
```
Boucles, on a la while, on va avoir for mais on va voir après.

On avait également des mots-clés.
```py
"""
        Boucles : while / for
        Mots-clés : break (casse la boucle)
"""
```
Ca on va voir break, casse la boucle, d'accord. Et on va avoir continue, revient au début de la boucle. 
```py
"""
        Boucles : while / for
        Mots-clés : break (casse la boucle) / continue (revient au début de la boucle)
"""
```
Voilà, c'est les deux mots. Je vous les note comme ça au fur et à mesure pour que vous puissiez prendre des notes si vous voulez puis voir un petit peu globalement tout ce qu'on a vu dans cette vidéo comme ça vous ne serez pas perdu, donc voilà comment ça se monte, comment ça se met en place, en tout cas, au niveau d'un while tout simplement.

## for

Et maintenant passons au niveau for alors au niveau du for, on ne va pas voir grand-chose puisqu'il y a pas mal de notions que vous n'avez pas encore vu à ce niveau de la formation donc je vais vous montrer un exemple qui ne sera pas forcément très très parlant mais encore une fois, on reviendra dessus quand vous aurez acquis beaucoup plus de choses. 

Et comme ça on va voir un petit peu ça avec un bon exemple donc for, je vais reprendre l'exemple d'une variable, je vais mettre, par exemple, je mettrai un mot, le mot ça va être "Bonjour" tout simplement, voilà. 
```py
#coding:utf-8

mot = "Bonjour"
```
Ou alors, je peux mettre une phrase, avec les espaces, un petit smiley à la fin si on veut.
```py
#coding:utf-8

phrase = "Bonjour tout le monde :) !"
```
Et on peut du coup faire ce genre de syntaxe.
```py
#coding:utf-8

phrase = "Bonjour tout le monde :) !"
    
for letter in phrase:
```

"for letter" donc ici, je vais créer une nouvelle variable parce qu'elle n'existe pas avant.

"in phrase", du coup, j'ai mélangé l'anglais et le français donc ça va peut-être mieux de faire ça.
```py
#coding:utf-8

sentence = "Bonjour tout le monde :) !"
    
for letter in sentence:
```
Et je vais faire un petit print de letter.
```py
#coding:utf-8

sentence = "Bonjour tout le monde :) !"

for letter in sentence:
    print(letter)

print("A bientôt...")
```
on va tester.
```powershell
>python main.py
B
o
n
j
o
u
r

t
o
u
t

l
e

m
o
n
d
e

:
)

!
A bientôt...
```
Et voilà ce qu'on obtient Bonjour tout le monde, ça vous l'affiche.

Ce qu'il va se passer, c'est qu'au niveau du for, ici.
```py
for letter in sentence:
```
Au niveau dur for ici, pour lui c'est une séquence c'est-à-dire c'est une chaîne de caractères c'est-à-dire qu'il va prendre chaque caractère un par un, le for, et il va le stocker dans une variable temporaire qui est ici qu'on va appeler letter.
```py
# for --> letter <-- in sentence:
```
Du coup, dans la boucle for, la variable letter existe donc on peut en faire ce que l'on veut, on peut faire des tests dessus, on peut faire des IF, on peut simplement l'afficher comme là et comme à chaque fois il va prendre qu'une petite partie de la séquence, on va pouvoir travailler dessus.

Alors c'est pour ça que je vous dis que c'est pas très très parlant pour le moment puisque là on travaille encore une fois sur une chaîne de caractères, plus tard on pourra travailler sur des listes, par exemple on pourrait avoir un inventaire. 

Imaginer dans un jeu, un inventaire d'objets, et on pourrait dire pour chacun de ces objets, j'sais pas, tu fais tel truc, par exemple tu affiche leur prix de vente ou j'sais pas quoi donc là ça serait évidemment plus intéressant parce que au lieu de dire, on en prend caractère par caractère d'une chaîne qu'on met dans une variable, on prendrait un objet par objet donc si on manipule des items, si on manipule des personnes, des monstres ou j'sais pas quoi ou ça peut être absolument n'importe quoi.

Tout de suitec, c'est plus intéressant ou des news, si on faisait un système de blog. On pourrait manipuler des news et afficher l'auteur d'une news par exemple.

Voilà donc dans ce cas-là c'est intéressant, ça pourrait être du coup :

```py
for news in list_news:
```

"for news in list_news" parce qu'on peut faire du web avec python, je vous rappelle, on aura l'occasion d'ailleurs d'en faire dans cette formation donc on peut imaginer, par exemple, je ne sais pas moi. "list_news", on aurait une fonction, on verra plus tard get_new() qui récuperait des news, on ne sait pas comment,peu importe, on s'en fiche.

```py
#coding:utf-8
list_news = get_new()

#Boucles : while / for
#Mots-clés : break (casse la boucle) / continue (revient au début de la boucle)

for news in list_news:
    print(letter)

print("A bientôt...")
```
Et cette list_news, du coup, on dirait que pour chacune des news, t'affiche, par exemple, ben tient l'auteur ou la news ou ce genre de choses dans un print(), voilà.
```py
#coding:utf-8
list_news = get_new()

#Boucles : while / for
#Mots-clés : break (casse la boucle) / continue (revient au début de la boucle)

for news in list_news:
    print(letter)  ## <----------

print("A bientôt...")
```
On pourrait procéder à ce genre de choses donc c'est que le for sera très utile puisqu'il va parcourir en fait tout un ensemble de quelque chose. 

Ca va être une liste, un dictionnaire comme on le verra plus tard, des tuples, ce genre de chose, une séquence si c'est une chaîne de caractères.

Donc voilà, normalement, je vous ai globalement parler un petit peu de tout au niveau des boucles, on retrouve évidemment le mot-clé break, continue... On pourra les utiliser sans problème ici dans le for dans le while, peu importe. C'est vraiment important.

break, celui-là ça peut être en cas de grosse grosse erreur, on veut quitter la boucle, on utilise break.

continue, c'est genre on est arrivé dans un cas particulier mais on n'a pas pour autant envie d'arrêter la boucle, on fait un petit continue pour dire bah tu reviens au début, tu reprend le traitement là où tu l'avait laissé  maintenant qu'on a fait ce qu'on avait à faire entre guillemets, voilà.

Normalement, c'est tout bon pour les boucles. Je pense vous avoir dit tout ce qui était, en tout cas, intéressant et tout ce qu'il fallait savoir pour vous, à votre niveau.

On aura bien évidemment l'occasion de reparler du for par la suite, on en parlera beaucoup puisque dans les leçons à venir, on aura l'occasion de l'utiliser à de nombreuses reprises et dans beaucoup d'exemples qui seront certainement beaucoup plus parlant et beaucoup plus concret.

En tout cas, je vous en ai donné un, ça peut vous permettre quand même de voir un peu son utilité.

Je vous dis à très bientôt, j'espère que cette vidéo, vous aura pris pas mal de petites choses, que vous allez commencer à avoir un bon niveau en langage python.

N'hésitez pas à vous entraîner, à faire beaucoup de programmes, faire des petits codes et cetera.

Poser des questions dans les commentaires si vous voulez, à partager comme d'habitude les vidéos et tout ça et tout ça.

Bref bon je vais pas me répéter dans chaque vidéo, vous savez comment ça fonctionne.

Je vous dis à très bientôt.

Surtout travaillez bien, apprenez bien tout ça.

Et on se retrouve dans une prochaine vidéo

## Resume
```py

###############################################
#################### Resume ################### 
###############################################


#coding:utf-8

# Python #6 - boucles
# https://www.youtube.com/watch?v=excGUISppC4&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=6
# Faire des conditions, c'est bien...mais l'utilisation de boucles peut également servir. Il s'agit de répéter un certain nombre de fois des instructions tant qu'une condition n'a pas été validée. On utilise également les boucles pour garder un programme ouvert, ou une instance, lire un fichier voire parcourir un tableau ou une structure de données.

"""
Abordés dans cette vidéo :

   Boucles     : while / for
   Mots-clés   : break (casse la boucle) / continue (revient au début de la boucle)
"""

"""
Les boucles permettent de répéter des traitement un certains nombre de fois.
Par exemple, les boucles permettent la répétition d'une instruction.
Autrement il faudrait faire des copier coller. Ce qui n'est pas propre car en
informartique, il faut trouver un moyen d'automatiser le code.
"""
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")
print("Je suis une phrase")

#1# WHILE
# On utilisera le mot clé WHILE et éventuellement les opérateurs de comparaison pour éviter la répétition.
# Les opérateurs de comparaison permettent de vérifier un point d'arrêt.
# Le point d'arrêt, c'est quand la boucle va s'arrêtée.
# Pour se faire, on utilise une variable, un compteur, appelé i, j, k.
# Ne pas oublier de modifier notre compteur pour arriver à un point d'arrêt (sinon boucle infinie).
# En C et C++, i est modifié en incrémentant (i++) ou en pré-incrémentant (++i).
# En Python, i est incrémenté de 2 façons (i = i + 1 ou i += 1).

compteur = 0
while compteur < 5: # (Test) Tant que compteur est plus petit que 5 (à 5 on sort de la boucle), tu affiche la phrase. Et ensuite tu ajoute 1 à compteur.
   print("Je suis une phrase")
   compteur += 1 # Ne pas oublier de modifier la variable. Autrement, on affiche une boucle infinie.
print("Je suis sorti de la boucle...") # On sort de la structure quand on est plus en tabulation (comme pour if).

"""
Les boucles permettent de parcourir des structures de données, des informations.
Ou bien encore faire de l'affichage graphique. L'écran d'ordinateur est affiché grâce à une boucle.
C'est en effet, une boucle qui fait tourner les fonctionnalités au niveau de l'affichage de notre écran et qui se met à jour en temps réel.
Le fenêtres sont déplacés sur notre écran en changeant de coordonnées dans des boucles qui tournent en tâche de fond.
Un jeu vidéo, c'est une boucle infini également.
"""
jeu_lance = False
while jeu_lance: # tant que le jeu est lancé (boucle infinie car ca ne s'arrêtera jamais).
   # fais des instructions en rapport avec le jeu.
   print("jeu en cours...")
print("A bientôt...")

terminal_lance = True
while terminal_lance:
   # Exemple de gestion d'un terminal.
   # Ensemble de commandes définies et utilisables.
   choixMenu = input("> ") # Exemple d'un terminal (petit prompt).
   if choixMenu == "again":
       continue # Reviens au début de la boucle (comme si on arrivait à la fin de la boucle).
   elif choixMenu == "quit":
       # break # Mot clé pour sortir de la boucle.
       terminal_lance = False # quitter la boucle en provoquant un point d'arrêt.
   elif choixMenu == "hello":
       print("Bonjour :) ! ")
   else:
       print("Commande introuvable")

"""
Au début de la création d'un jeu vidéo si on a pas d'interface graphique, 
on peux simuler le fonctionnement du jeu en ligne de commande (jeux des allumettes).
La création d'un petit terminal peut être intéressant pour simuler le déplacement 
d'un personnage ou encore simuler l'acquisition d'un objet dans l'inventaire.
L'avantage, c'est que c'est très simple à mettre en place.
Le principe est de lancé une boucle infinie et avec la commande input, on peut lancé
divers fonctionnalités suivant ce que l'utilisateur a tapé au clavier.
"""

#2# FOR
# Au niveau de For, sentence est une séquence qui va prendre chaque caractère 1 par 1 que l'on stocke dans une variable temporaire appelée letter.
# Dans la boucle, la variable letter existe et on peux en faire ce que l'on veut (teste if, l'afficher).
# La boucle permet de travailler sur des chaînes de caractères, des listes, un inventaire d'objet dans un jeu (pour chaque objet, afficher leur prix de vente).
# On peut prendre caractère par caractère, objet par objet suivant qu'on manipule des items, des monstres, etc.
# On peut manipuler des news dans un système de blog et afficher l'auteur d'une news.. avec une fonction get_new()
# En effet, on peut faire du web avec du Python.
# FOR permet donc de parcourir un ensemble de choses (liste, dictionnaire, une séquence si c'est une chaîne de caractères).

sentence = "Bonjour tout le monde :) !"
for letter in sentence:
   print(letter)
print("A bientôt...")

list_news = get_new() # fonction qui récupererait des news ...
for news in list_news: # ... pour chacune des news de la liste, ...
   print(letter) # ... tu affiche l'auteur ou le titre.
print("A bientôt...")

#3# BREAK / CONTINUE
# Break sert en cas de grosse erreur pour quitter la boucle.
# Continue sert en cas d'un point particulier et qu'on ne veux pas arrêter la boucle.
# Continue permet de revenir au début de la boucle.
```