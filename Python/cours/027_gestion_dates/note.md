# [27. Gestion dates](https://www.youtube.com/watch?v=SXgyLoGA_mY)

Bonjour à tous, bienvenue pour la séance 27 sur la formation python. 

On va continuer un petit peu sur ce qu'on avait vu la dernière fois en gérant un petit peu les différents temps parce que ce sont des choses qui vous serviront plus tard quand on fera du réseau, quand on attaquera des notions un petit peu plus avancé, et je voulais poursuivre un petit peu sur une autre séance pour vous parler de quelque chose d'un peu plus précis, et notamment pour ce qui concerne le travail avec les dates. 

Ce que je vais vous montrer n'est pas très avancé tout simplement parce qu'il n'y a pas beaucoup d'application à faire en pratique avec les dates tant qu'on n'a pas de cas concret.

Donc là je vais essayer de vous montrer quelques petits exemples mais par la suite vous verrez que c'est très utile quand vous travaillerez en web, quand vous travaillerez sur de l'applicatif, sur des jeux vidéo ce genre de chose, que vraiment vous aurez l'occasion de mettre tout ça en pratique sur des cas réels et sur des cas concrets, ça aura plus de sens.

Donc je vais vous montrer quand même comment ça fonctionne parce que c'est à connaître, c'est un petit peu des prérequis nécessaires actuellement pour les choses que je vais vous présenter pour la suite de la formation. 

Alors on va utiliser cette fois-ci un autre module, la dernière fois on avait vu le module time qui servait justement à manipuler des temps, et là on va faire quelque chose qui va permettre de travailler un petit peu plus sous forme de programmation objet. 

Vous avez vu que time on utilisait de petites fonctions donc on restait sur des choses assez simplistes tandis qu'avec un autre module qui est cette fois-ci datetime parce que vous comprenez bien que les dates ça peut comprendre des temps bien évidemment, ce n'est pas indissociable.
```py
    #coding:utf-8
    import datetime
```
On va pouvoir manipuler ça sous forme d'objets, c'est plus une question de petite fonction, on va pouvoir vraiment manipuler des dates qui seront des objets, un objet de date, et on pourra à la suite de ça faire pas mal de choses. 

Alors quels avantages ça peut avoir ? L'avantage c'est que vous savez qu'un ordinateur, il sait sans problème faire la somme des nombres, il sait faire la concaténation de chaînes grâce à l'utilisation de fonctions de python qui sont beaucoup plus au niveau par contre il ne serait pas par défaut, prenez l'exemple dans un jeu vidéo. 

comment vous feriez dans un jeu vidéo la somme de 2 joueurs, ce serait d'ailleurs un peu bizarre et ça n'aurait pas forcément de sens mais pourtant ça pourrait en avoir. Ou alors comment est-ce qu'on pourrait comparer 2 joueurs, sur quoi on les compare sur quels critères mais pour les dates l'avantage avec ce type de menu, c'est que tout ce système de ce qu'on appelle la surcharge des opérateurs mais ce sont des choses qu'on aura également l'occasion de pouvoir d'évoquer … est déjà fait parce qu'il y a des modules et notamment des classes spécifiques pour pouvoir manipuler les dates. 

Donc l'avantage c'est que vous n'aurez pas besoin de le développer, vous pourrez sans problème faire des additions de date, faire des soustractions de date donc du coup pour pouvoir faire la différence, vous pourrez calculer des durées et notamment comparé deux dates … savoir laquelle est la plus récente et savoir qu'elle est la plus ancienne parce que ça vous savez que au niveau informatique ça n'existe pas donc il fallait bien évidemment mettre cela en place au niveau programmation.

Voilà pour l'explication grosso modo et on va voir quelques classes quelques méthodes, et propriétés qui vous serviront mais je ne vais pas tout vous montrer encore une fois parce que ça ne servirait strictement à rien, il y a même des choses que personnellement je n'ai jamais utilisé et que je n'aurais jamais peut-être l'occasion d'utiliser donc je vais voir ce qui me semble plus intéressant par rapport à ça. 

Le premier cas c'est de pouvoir créer une date par défaut et que l'on va appeler d1 donc on va travailler toujours sur notre module, et on va utiliser un appel de classe qui est datetime() qui porte le même nom d'accord.
```py
    #coding:utf-8
    import datetime
    
    d1 = datetime.datetime()
```
Tout simplement datetime(), datetime() prend plusieurs paramètres.

En premier paramètre elle va prendre l'année, l'année va s'écrire sous cette forme 2018 c'est-à-dire avec 4 chiffres.
```py
    d1 = datetime.datetime(2018)
```
Le mois il va falloir le noter sous forme de un seul chiffre de 1 à 12 donc ici pour février on va mettre 2.
```py
    d1 = datetime.datetime(2018, 2)
```
Et ensuite pour le jour du mois on va mettre évidemment le jour complet, 28. 
```py
    d1 = datetime.datetime(2018, 2, 28)
```
Donc là on a un exemple, ensuite on va voir bien évidemment puisque là c'est datetime() donc on a la date et le temps mais on va avoir ensuite les heures les minutes et les secondes d'accord.
```py
    d1 = datetime.datetime(2018, 2, 28)
```
Donc on va voir ensuite les heures les minutes et les secondes si je veux avoir un truc exact, je vais mettre par exemple 9 36 42, on peut faire ça. Ensuite on va afficher tout ça histoire d'avoir une représentation pour voir à quoi ça ressemble comme objet.
```py
#coding:utf-8
import datetime

d1 = datetime.datetime(2018, 2, 28, 9, 36, 42)
print(d1)
```
```powershell
    >python main.py
    2018-02-28 09:36:42
```
Voilà la forme que ça prend, voyez que nous on a juste mis des arguments, des paramètres de fonction séparées par des virgules et automatiquement l'affichage et comme ça a été développé justement dans cette classe datetime, l'affichage est géré au niveau du print(). 

On n'a pas besoin de formater une date en particulier parce qu'il va le faire tout seul même s'il le fait un petit peu en format anglais cette écriture là, 2018-02-28, mais c'est des choses qu'on pourrait changer si on voulait. 

Donc vous voyez que automatiquement il formate la date correctement par rapport à ça donc c'est très pratique d'avoir ce genre de chose. 

Ce qui sera pratique, c'est que par la suite notamment lorsque vous manipulerait des bases de données, vous aurez besoin de récupérer des dates, et bien l'avantage c'est que si après vous voulez travailler sur des dates, faire des comparaisons, vous comprenez bien que ces dates doivent être dans le même format. 

Si vous avez des dates dans le format français, date dans le format anglais, date où il n'y a pas l'année, date où il n'y a pas leur et cetera, ça va être un peu compliqué de comparer mais là l'avantage c'est que vous allez pouvoir former des dates qui ont la même syntaxe mais qui sont également facilement comparables pour la suite. 

Alors on va en faire une 2e, on va faire également d2 = datetime.datetime() et on va mettre pareil 2018 2 27 et puis ensuite on va mettre la même heure 9 36 42, on ne va pas induire la dessus on va juste changer au niveau du jour, voilà ce genre de choses.
```py
    #coding:utf-8
    import datetime

    d1 = datetime.datetime(2018, 2, 28, 9, 36, 42)
    d2 = datetime.datetime(2018, 2, 27, 9, 36, 42)
```
alors là pareil, ces 2 objets d1 et d2, datetime, on va pouvoir faire des comparaisons dessus comme si c'était de simples nombre ou de simples petites valeurs, on pourra comparer des dates qui sont quand même une structure assez complexe parce que c'est toute une classe comme on pourrait par exemple comparer un nombre 1 et un nombre 2. 

Donc ici on va juste faire ça.
```py
#coding:utf-8
import datetime

d1 = datetime.datetime(2018, 2, 28, 9, 36, 42)
d2 = datetime.datetime(2018, 2, 27, 9, 36, 42)

if d1 < d2:
   print("d1 est plus ancien que d2")
else:
   print("d1 est plus récent que d2")
```
```powershell
    >python main.py
    2018-02-28 09:36:42
    d1 est plus récent que d2
```
Voilà puisqu'il a été décidé au niveau de la programmation dans ce module tel qu'il a été fait, qu'une date plus grand est évidemment une date ou les valeurs récupérer une à une … par rapport à l'année au mois et cetera … il était plus récent dans l'air du temps, c'est dans l'air du temps. Ça été défini comme ça c'est comme ça parce que encore une fois qu'est-ce que ça veut dire une date plus grandes qu'une autre. 

Parce que encore une fois qu'est-ce que ça veut dire une date plus grandes qu'une autre? ça ne veut rien dire donc il a fallu traduire ça en informatique. En fait si ça veut dire quelque chose, par exemple il est possible que là datait des années plus grandes donc pour une date qui est plus grand donc supérieure ou si elles sont égales on va comparer le mois hum ou si c'est égal on va comparer le jour, voyez on va travailler comme ça. 

On va travailler au fur et à mesure pour trouver chaque chose donc là on y va et on va tester, et il vous met que d1 est plus récent que d2.

C'est effectivement le cas, on voit que pour d1 c'est le 28/2/2018, c'est effectivement une date plus récente que le 27/2/2018. 

Si en revanche j'inversait en mettant 24 par exemple tout simplement, je refais un test.
```py
#coding:utf-8
import datetime

d1 = datetime.datetime(2018, 2, 24, 9, 36, 42)
d2 = datetime.datetime(2018, 2, 27, 9, 36, 42)

if d1 < d2:
   print("d1 est plus ancien que d2")
else:
   print("d1 est plus récent que d2")
```
```powershell
    >python main.py
    d1 est plus ancien que d2
```
À tester il nous dit que d1 est plus ancien que d2.

Ton très pratique comme il y a des classes toute faite, il n'y a pas besoin de créer vos propres fonctions, pas besoin de vous embêter à faire de la surcharge d'opérateur pour dire comment est-ce qu'il faut comparer des dates, est-ce qu'il faut comparer tel membre ou tel membre. 

Alors vous vous doutez bien python a déjà tout fait à ce niveau-là, c'est un langage plus haut niveau que des langages comme le c ou autre donc on va pouvoir comparer des dates très très facilement, encore une fois comme si vous compariez de nombre. 

Donc c'est très pratique à ce niveau-là. 

On va voir également d'autres choses, vous n'avez pas forcément besoin de manipuler tout un tas de formats comme ça. Vous pouvez aussi vous contenter de date(). 

Donc si on ne veut pas avoir ça et qu'on veut se contenter de l'année du mois et du jour, plutôt que de travailler sur la classe datetime, on a une classe qui s'appelle date tout simplement. 

Si vous voulez datetime hérite, enfin c'est une classe fille par rapport à la classe date. 

Voilà, elle hérite de la classe date mais je pense que vous aurez plus souvent l'occasion d'utiliser simplement celle là, date()mais quand vous voulez des cas précis par exemple web quand vous voulez savoir exactement l'heure et la minute, quand est-ce qu'il a été publié un article de blog, ou un message ou ce genre de chose sur entre chat ou autres, c'est pas mal d'avoir des heures et des minutes. 

Et là vous voyez qu'on va pouvoir récupérer exactement la même chose aussi. 
```py
#coding:utf-8
import datetime

d1 = datetime.date(2018, 2, 24)
d2 = datetime.date(2018, 2, 27)

if d1 < d2:
   print("d1 est plus ancien que d2")
else:
   print("d1 est plus récent que d2")
```
```powershell
    >python main.py
    d1 est plus ancien que d2
```
Et là vous voyez qu'on va pouvoir récupérer exactement la même chose, si je mets carrément 29 (on va carrément dans le futur, là vous allez voir que ça ne va pas).
```py
#coding:utf-8
import datetime

d1 = datetime.date(2018, 2, 29)
d2 = datetime.date(2018, 2, 27)

if d1 < d2:
   print("d1 est plus ancien que d2")
else:
   print("d1 est plus récent que d2")
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 165, in <module>
        d1 = datetime.date(2018, 2, 29)
    ValueError: day is out of range for month
```
Alors évidemment non c'est pas mettre 29 au mois de février donc on va mettre le premier mars et ça ira.
```py
#coding:utf-8
import datetime

d1 = datetime.date(2018, 3, 1)
d2 = datetime.date(2018, 2, 27)

if d1 < d2:
   print("d1 est plus ancien que d2")
else:
   print("d1 est plus récent que d2")
```
```powershell
    >python main.py
    d1 est plus récent que d2
```
Et là il vous met que d1 est plus récent parce qu'effectivement le premier mars est plus récent comme date en 2018 que le 27 février, parce qu'on n'a même pas cette date au moment où je fais cette vidéo. 

Voilà vous allez pouvoir gérer cette date de cette manière, alors oui je ne vais pas pouvoir vous montrer beaucoup d'exemples où déca plus intéressant à voir, ou plus illustré, parce qu'en général on manipule les dates avec plein d'autres choses, pour un article, pour un événement là dans un jeu, pour déclencher quelque chose, un événement un agenda ou ce genre de choses. 

Voilà dans une vidéo comme ça de formation il n'y a pas forcément beaucoup d'exemples à vous montrer pour que ce soit compréhensible. Après je ne pense pas que ce soit compliqué à assimiler comme notion. 

Comprenez simplement comme vous avez pu le voir pour les classes, il y a plein de méthodes de propriétés qui ont été faites et qui permettent du coup de récupérer des informations facilement. 

On peut aussi, par exemple si je fais ce genre de chose, print(d1.year), vous voyez que je peux récupérer directement l'année. On a des propriétés donc la propriété year, la propriété month, la propriété day, la propriété hour et cetera sur les différents types d'objets que ce soit date ou datetime en fonction, où vous pourrez récupérer qu'une seule des valeurs. 

Si par exemple vous avez besoin de manipuler juste les années, plutôt que de travailler sur la date complète, vous utilisez simplement la propriété year sur l'objet d1 donc ici notre objet qui est de classe date d'accord. On peut même vérifier, vous faites un type() de d1. 
```py
#coding:utf-8
import datetime

d1 = datetime.date(2018, 3, 1)
d2 = datetime.date(2018, 2, 27)

print(d1.year)
print(type(d1))
```
```powershell
    >python main.py
    2018
    <class 'datetime.date'>
```
C'est utile parce que je rappelle, on a manipulé cela depuis pas mal de temps, type() mais je fais un petit rappel si un jour vous avez besoin de manipuler des modules qui ont plein de classe, de sous-classes  avec même leur propre fonction, méthodes et cetera … et puis au niveau du nommage, est-ce qu'il faut mettre le nom du module ? est-ce qu'il ne faut pas mettre le nom de module ? et cetera.

Si vous ne savez plus où vous en êtes au niveau des classes et cetera, n'hésitez pas à faire un petit type() comme ça vous allez voir où vous en êtes effectivement c'est bien de classe datetime.date donc c'est un module ici, et dans ce module là on a une classe qui s'appelle date. Ça permet de se retrouver et c'est plus simple que de chercher là où en est.

 Donc ça peut être encore une fois pratique donc je veux faire ce petit rappel. 

Voilà pour les manipulations dates donc vous avez vu datetime, vous avez vu date qui est la forme raccourcie. 

On peut bien sûr travailler sur le temps, on peut très bien faire t1 = datetime.time(), ça peut être par exemple 23h et 46 secondes et enfin print() de t1.
```py
#coding:utf-8
import datetime

t1 = datetime.time(23, 00, 46)
print(t1)
```
```powershell
    >python main.py
    23:00:46
```
Et là vous voyez que manipule des heures tout simplement. 

Vous avez le choix, soit vous voulez le jour et vous utilisez la classe date, soit vous voulez juste le temps et vous utilisez la classe time, attention ici c'est la classe, il ne s'agit pas ici d'une fonction. 

Il ne s'agit pas d'une fonction comme on l'a vu précédemment avec le module time. 

La classe et le module time ce sont 2 choses différentes, il ne faut vraiment pas confondre. On ne manipule pas le timestamp Unix pour le coup, on a directement des dates sous forme d'objet. 

Ou alors vous avez le complet c'est-à-dire la somme de date et de time qui est tout simplement datetime, voyez que les noms sont bien pensé à ce niveau là donc c'est facile à retenir à ce niveau là donc vous avez déjà 3 classes comme ça qui sont intéressantes. 

Il y en a évidemment plein d'autres, on peut trouver une classe notamment pour avoir des durées, qui s'appelle timedelta qui permet de faire des durées entre plusieurs valeurs. Pour avoir plusieurs valeurs lorsqu'on a des calculs de durée. 

On a aussi pour tout ce qui s'appelle les fuseaux horaires, vous avez une classe pour manipuler tout ça  mais je ne vous le présente pas non plus parce que ce sont des choses que vous verrez de toutes façons par la suite mais c'est plutôt bien à savoir.

Je vais terminer cette vidéo du coup avec quelques petits modèles qui sont vachement utile, si par exemple vous faites un print avec datetime.now() Donc là vous voyez qu'on utilise une fonction. Attention ici il faut utiliser datetime qui est le nom du module et importer une classe qui s'appelle aussi datetime.
```py
#coding:utf-8
from datetime import datetime

print(datetime.now())
```
```powershell
    >python main.py
    2020-10-13 00:10:59.361999
```
Du coup quand je vais l'écrire comme ça ça va prendre en compte pour avoir cette version là sinon il aurait fallu stocker dans une variable datetime.datetime. Et après il aurait fallu faire cette variable point now().

Mais je vais vous montrer l'autre syntaxe, je vais vous montrer les 2 comme ça vous n'aurez pas de confusion, c'est comme si je faisait :
```py
#coding:utf-8
import datetime

dt = datetime.datetime()

print(dt.now())
```
```powershell
    >python main.py
    Traceback (most recent call last):
      File "main.py", line 270, in <module>
        dt = datetime.datetime()
    TypeError: function missing required argument 'year' (pos 1)
```
La évidemment il faut préciser le temps que l'on veut. 

Mais ce n'est pas grave va faire ça avec date, on va faire now et on va utiliser carrément date.today() et après en fait juste un print() de now. 
```py
#coding:utf-8
from datetime import date

now = date.today()
print(now)
```
```powershell
    >python main.py
    2020-10-13
```  
Et pareil on retrouve ceci. 

Alors c'est moins complet parce qu'on a fait sur date et si on le fait sur datetime, on aura les heures aussi. 

Et là en fait ça vous retourne simplement la date du jour donc si un jour vous avez besoin de récupérer la date du jour de manière dynamique, vous pouvez procéder de cette manière là c'est bien sûr beaucoup plus pratique donc on va travailler directement avec date et on va utiliser today() qui est une méthode qui va renvoyer la date du jour. 

Alors ça je vous le donne parce que c'est à connaître bien sûr, vous aurez besoin de cette syntaxe alors ce que vous voudrez récupérer la date exacte pour par exemple un événement, pour réaliser une tâche automatique, peu importe mais comme c'est intéressant de pouvoir manipuler du temps quand on programme, et bien je vous donne ces petites astuces là. 

Vous avez today(), vous avez now() au niveau des méthodes et des fonctions qui sont disponibles, en plus des propriétés que l'on a vu : year, month et cetera pour récupérer simplement un seul nombre au niveau de nos dates. 

Du coup pour ce que l'on peut faire, ce qui peut être utile, alors je vous montre un cas qui ne sera pas tout à fait correct parce que pour pouvoir comparer 2 dates exactes, il ne faudrait pas se contenté que de l'année, on pourrait même utiliser timedelta. 

Mais pour montrer en tout cas que ça marche aussi, on peut juste faire ça donc on va faire un import datetime, je vous montre très rapidement. Alors le code ici ne sera pas exact mais c'est quand même bien de pouvoir montrer le code aussi pour voir comment ça fonctionne donc c'est plus à titre de compréhension que d'avoir quelque chose de correct. 
```py
    #coding:utf-8
    import datetime
    from datetime import date
```
Alors on va récupérer la date du jour en faisant date.today() que l'on récupère dans now.
```py
    #coding:utf-8
    import datetime
    from datetime import date

    now = date.today()
```
Et je peux récupérer par exemple une date de naissance donc là je vais carrément faire date() sur datetime, vous mettez votre date de naissance ou n'importe, enfin si vous voulez tester votre date de naissance il ne faut pas mettre une fausse date de naissance sinon ça ne marchera pas et après vous pouvez faire une comparaison.
```py
    #coding:utf-8
    import datetime
    from datetime import date

    now = date.today()
    born = datetime.date(1991, 2, 10)
```  
Et après vous pouvez faire une comparaison, alors c'est now - born.year, et on récupère, compare seulement sur l'année.
```py
#coding:utf-8
import datetime
from datetime import date

now = date.today()
born = datetime.date(1991, 2, 10)
print(f"{now.year - born.year} ans.")
```
```powershell
    >python main.py
    29 ans.
```  
Alors là il met 27 ans pour cette date là mais bien sûr ce ne serait pas forcément exact tout le temps, par exemple si c'est une date qui est déjà passée mais là ça va mais par contre si je dis que c'est pour le 10 mars, Eh bien le 10 mars de 2018 n'est pas encore passé mais pourtant on aura encore le même âge.
```py
#coding:utf-8
import datetime
from datetime import date

now = date.today()
born = datetime.date(1991, 3, 10)
print(f"{now.year - born.year} ans.")
```
```powershell
    >python main.py
    29 ans.
```
On aura quand même le même âge pourquoi ?  Parce que on fait la comparaison que sur les années, C'est pour ça qu'ils ont prévu une classe timedelta qui va permettre de faire des comparaisons comme ça beaucoup plus facilement, Ou alors vous pouvez vous amuser à faire comme ça votre propre fonction qui va effectivement comparer les années et sinon elle va comparer les mois, le jour et cetera pour vous dire de calculer l'âge d'une personne par exemple en fonction de sa date de naissance par rapport à la date de maintenant. 

Alors ça peut être pareil, un petit entraînement à faire si vous voulez ce qui pourra vous permettre de bien pratiquer ça, et bien comprendre comment ça fonctionne. 

Maintenant je vais m'arrêter là pour tous les exemples à vous donner sur les manipulations de dates, on n'a pas vu grand-chose encore une fois parce que ça sert à rien de vous en montrer plus de toute manière parce qu'il n'y aura pas de cas pratique.

Pas vraiment de cas pratique pour voir ça ou bien pour le mettre dans des cas d'applications mais c'est des choses qui vont être carrément utiles parce que après on va aborder d'autres notions, et on va parler de date et on va parler de temps. 

Voilà comme ça on aura vu les dates et le temps donc on n'aura pas besoin de passer du temps la prochaine fois dessus, vous saurez déjà en quoi ça consiste et comment ça fonctionne en tout cas dans les grandes lignes et ça vous servira pour ce qu'on va faire en 2D, pour ce qu'on va faire en réseau, quand on va faire des clients serveur ce genre de chose, les mêmes contours frein de la programmation asynchrome. 

Voilà pas mal de petites choses que l'on va faire pour la suite de la formation. 

En attendant, revoyez bien tout ça c'est super important même s'il n'y a pas grand chose à apprendre c'est bien de comprendre et donc profitez en pour vous entraîner, faire des petits programmes de test et cetera pour vous exercer, pour être sûr d'avoir bien compris toutes les notions qu'on avait jusque-là. 

La partie tkinter comment on a fait pour l'interface graphique c'est un petit plus, ça ne concerne pas forcément pour le coup les dates les temps et cetera mais vraiment tout ce qu'on a vu la liste, et cetera toutes les notions qu'on a pu voir dès le départ. Il faut que vous soyez sûr de bien les avoir assimilés et de bien les avoir comprises pour attaquer la suite parce que là on va entrer sur des choses un peu plus compliquées. 

Ce qu'on a vu jusqu'à présent, honnêtement c'était assez simple mais là on va commencer à aborder des cas un peu plus avancé ils ne sont pas forcément faciles à assimiler quand on n'a pas l'habitude donc faites attention à ça n'hésitez pas bien sûr, au revoir tout ça, à travailler sur les différentes syntaxes et les différentes notions que vous avez vu pour être sûr d'être au point pour la suite.

À bientôt tout le monde on se retrouvera pour le coup pour la séance 28, et là je vous dis on aura des petites choses sympa qu'on va commencer à voir, et moi je vous dis voilà n'hésitez pas à laisser des commentaires si vous avez besoin d'aide sur quelque chose, des questions et comme d'habitude j'y répondrais voilà. 

À bientôt pour la séance 28