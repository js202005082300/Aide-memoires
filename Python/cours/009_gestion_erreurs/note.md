# [9. Gestion erreurs](https://www.youtube.com/watch?v=1IqnpaQy8LM)

+ [try except](#try-except)
+ [else](#else)
+ [finally](#finally)
+ [except en cas de ZeroDivisionError](#except-en-cas-de-ZeroDivisionError)
+ [except en cas de ValueError](#except-en-cas-de-ValueError)
+ [raise - lever une exception](#raise---lever-une-exception)
+ [assert - lever une AssertionError](#assert---lever-une-AssertionError)
+ [Resume](#Resume)

Bonjour bienvenue à tous sur cette séance numéro 9 en python. 

On va voir comment gérer les erreurs maintenant que vous savez comment fonctionne tout ce qui est fonction et modularité, on a passé pas mal de temps, mine de rien, à expliquer un peu toute ces notions.

On va voir comment sécuriser un peu plus nos programmes, faire quelque chose d'un peu plus sérieux pour gérer quelques erreurs possibles et pour vous adopter un comportement adéquat en cas d'erreur, en cas de plantage de notre programme plutôt que de laisser l'utilisateur dans une situation pas forcément voulu.

Regardez comment ça fonctionne, on va reprendre un exemple de code qui pourrait très bien arriver, quelque chose de tout à fait courant dans l'exécution d'un programme en python. 

Je vais prendre un ageUtilisateur et on va faire un petit imput() Hey on va demander tout simplement quel âge as-tu ?, Voilà. 

```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ?")
```

Vous êtes d'accord avec moi, on s'attend à avoir un âge non Donc on attend à ce que la personne entre un nombre, et pas commence ça rentrait son prénom ou je ne sais quoi. 

Donc nous on avait vu très rapidement parce qu'on ne commençait pas à gérer les erreurs pour le début histoire de ne pas trop compliquer les choses, on faisait directement le fameux cast, je vous rappelle. Je vous avais dit vous faites un petit cast comme ça de l'âge, comme ça vous êtes sûr que c'est bien considéré comme un nombre et non pas une chaîne puisque la fonction input(), elle prend, elle lis absolument tout au clavier comme étant une chaîne de caractères, et pas un entier. 

```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ?")
ageUtilisateur = int(ageUtilisateur)
```

Donc on fait le petit cast et après on avait juste à faire un int en disant "tu as ", ageUtilisateur, "ans".

```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")
ageUtilisateur = int(ageUtilisateur)

print("tu as", ageUtilisateur, "ans")
```
Donc là, on va tester.
```powershell
>python main.py
Quel âge as-tu ? 25
tu as 25 ans
```

Donc ça fonctionne, il n'y a pas de souci, d’accord.
Le problème c'est que dans ce genre de cas, on ne vérifie absolument rien. Tout simplement parce que je faire ça et vous allez voir que ça plante.

```powershell
>python main.py
Quel âge as-tu ? Jason
Traceback (most recent call last):
  File "main.py", line 32, in <module>
    ageUtilisateur = int(ageUtilisateur)
ValueError: invalid literal for int() with base 10: 'Jason'
```

Et vous voyez que ça plante, ça plante complètement. 

On remarque, alors ça on ne l'avait pas forcément détaillé jusqu à présent, on voyait simplement qu'il y avait une erreur. 

Là il vous met que "invalid literal for int()", il vous met c'est une valeur qui est incorrect par rapport à un entier puisqu'on note un texte. 

Et il vous met ici qui est super important, d'ailleurs il est représenté ici par un mot avec une majuscule, et ensuite le mot error commence par une majuscule, ValueError.

Vous avez des ValueError, vous avez des TypeError, vous avez des ZeroDivisionError, vous avez même des OsError et cetera et cetera. Ce sont des exceptions et notamment des types d'exceptions qui ont été levées par l'interpréteur, ça veut dire qu'il a remarqué une erreur d'un certain type et il a levé une exception pour vous dire : "attention, Il y a eu une erreur de tel type" Et je t'affiche un petit message pour te dire quoi. 

Donc ça, vous êtes d'accord, admettons que quelqu'un voudrait exécuter votre programme, s'il tombe sur ce genre d'erreur ce n'est pas propre du tout. Pour le développeur, c'est très bien, Il faut avoir le problème eccetera mais pour l'utilisateur ça ne va pas du tout parce qu'il y a une erreur que l'on pourrait penser après ce qu'une erreur de codage alors que non, Votre code il est correct. Il est tout à fait correct au niveau de la syntaxe, il n'y a pas de bug dans ce programme, c'est juste que vous ne gérez pas un cas d'erreur possible il peut très vite arriver parce qu'il y aura bien un jour un malin qui va Notez du texte alors que vous demandez un âge donc on est obligé de vérifier ça. 

Le problème il se situe au niveau du cast :

```py
ageUtilisateur = int(ageUtilisateur)
```

C'est-à-dire que là, j'ai essayé de transformer un nombre entier en prénom tout simplement, c'est juste pas possible. 

Donc dans la mesure où vous avez une instruction surtout utilisateur parce que la règle première en informatique c'est de ne jamais faire confiance à l'utilisateur, **toujours tout vérifier**, ça peut être un utilisateur ou une information que vous avez récupéré d'une base ou que vous avez récupéré d'une requête ou autre, d'un fichier ou n'importe quoi, tout ce qui aurait pu être corrompu, modifié par un utilisateur ou par tierce doit être absolument vérifier d'accord, ça c'est une règle d'or en informatique sinon c'est comme ça qu'on s'expose à des problèmes de sécurité, si ce n'est plus grave. 

## try except

Donc nous, cette ligne étant battante parce qu'on n'a rien vérifié, on a vraiment pas vérifié ce genre de chose donc la première chose à faire c'est la base on va dire, c'est vraiment il fallait gérer à la base de la base de la base un cadreur possible dans un programme, c'est d'utiliser c'est un fameux jeu d'instructions qu'on appelle le try/except, on va en parler, alors pour d'autres langages serait le try/catch mais là on parle vraiment de try/except. Vous allez voir comment ça fonctionne. 

Donc try, ça veut simplement dire *essayer* en anglais, ce n'est pas compliqué, vous mettez try deux-points. Et nous ce qu'on veut essayer c'est ce fameux cast.

```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")

try:
    ageUtilisateur = int(ageUtilisateur)

print("tu as", ageUtilisateur, "ans")
```

Nous ce que l'on veut essayer c'est ce fameux cast, on est d'accord, parce qu'il est possible que ce cast ne puisse pas fonctionner.

Si vous mettez un nom, caster un nom en entier, c'est impossible, vraiment en entier en tout cas. 

On essaie ça et on va utiliser le mot except pour exception. 

Donc on va dire, dans le cas où tu lève une exception, Qu'est-ce que tu fais ? moi je ne veux pas qu'il m'affiche cette ligne ValueError.

Donc de la base, si on a quelqu'un de fainéant, qu'on a vraiment pas envie de commencer à générer des erreurs de manière particulière, à refaire une boucle pour demander l'âge et cetera admettons, on peut mettre au moins un petit print(), ne serait-ce que ça pour dire que l'âge indiqué est incorrect. C'est vraiment la base. 

```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")

try:
   ageUtilisateur = int(ageUtilisateur)
except:
	print("L'âge indiqué est incorrect !")

print("tu as", ageUtilisateur, "ans")
```

On va mettre un ! parce qu'on n'est vraiment pas content, voilà.

On va relancé le programme.

Si je met 24, par exemple, vous voyez que le programme se passe sans incombe.

```powershell
>python main.py
Quel âge as-tu ? 24
tu as 24 ans
```

Et si je fait le petit malin en mettant une chaîne de caractères, il me dit que l'âge indiqué est incorrect.

```powershell
>python main.py
Quel âge as-tu ? Jason
L'âge indiqué est incorrect !
tu as Jason ans
```

OK, donc voilà on a quand même géré, on n'a plus cette espèce d'erreur toute moche. 

Mais il y en a qui vont me dire : "on a quand même le print qui se fait à la fin", bien évidemment, si on se contente du minimum, on va le mettre ici. 

```powershell
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")

try:
   ageUtilisateur = int(ageUtilisateur)
   print("tu as", ageUtilisateur, "ans")
except:
	print("L'âge indiqué est incorrect !")
```
On va le mettre ici puisqu'on essaie d'afficher une donnée qui a pu être corrompue par rapport à ce fameux cast. 

Par la suite, donc si on veut vraiment être le plus fainéant, ça c'est la méthode fainéante, j'ai envie de dire. 

On va faire dans cet ordre-là.
```powershell
>python main.py
Quel âge as-tu ? 24
tu as 24 ans
```
Donc là pas de souci, d'accorect.
```powershell
>python main.py
Quel âge as-tu ? Jason
L'âge indiqué est incorrect !
```
Et là, il affiche simplement que l'âge indiqué est incorrect.

Donc là au moins c'est propre, on a une erreur, le programme s'est arrêté. Bon tant pis, on aurait pu à la rigueur redemander l'âge plutôt que de quitter bêtement mais pourquoi pas, ça fonctionne.

Au moins ça évite d'afficher tu veux un truc un peu bizarre avec ligne, un tel machin … Ça a plantes et cetera. Ça ne fait vraiment pas très professionnel en tout cas. 

Donc ça c'est le minimum. 

## else

On peut maintenant gérer également d'autres fonctionnements parce que là vous avez vu que le fameux ageUtilisateur, je le faisais ici.

```py
try:
    ageUtilisateur = int(ageUtilisateur)
    print("tu as", ageUtilisateur, "ans")
```

En général, on utilise le mot else, on va le mettre ici. 
```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")

try:
   ageUtilisateur = int(ageUtilisateur)
except:
	print("L'âge indiqué est incorrect !")
else:
	print("tu as", ageUtilisateur, "ans")
```
On met le mot else ici pour dire que tu essayes un certain nombre d'instructions : 
```py
try:
    ageUtilisateur = int(ageUtilisateur)
```
En général c'est une seule chose, en général on fait un bloc try mais pour une seule instruction, des fois, ça peut être plusieurs mais en général, c'est une.

On essaye dans quelque chose où l'on sait que ça peut mal se passer par rapport à l'utilisateur ou autre chose, une lecture de fichier ou n'importe quoi. Par exemple ouvrir un fichier qu'on devrait normalement tester comme ça, on devrait normalement le tester comme ça. On devrait dire "j'essaie d'ouvrir un fichier et si on voit que ça n'a pas marché, ça aura levé une exception à priori et dans ce cas-là, on peut la gérer". 

Donc tu fais ça, t'essaye de Caster l'âge de l'utilisateur : 
```py
try:
    ageUtilisateur = int(ageUtilisateur)
```
Si tu n'y arrives pas, si tu lève une exception, alors là vous voyez que je n'ai pas parlé de type, on verra ça après. 

Si tu lève une exception, peu importe laquelle, tu affiche ça. 
```py
except:
	print("L'âge indiqué est incorrect !")
```
Tu affiches sinon C'est qu'a priori ça s'est bien passé donc tu affiche ça. 
```py
else:
	print("tu as", ageUtilisateur, "ans")
```
Donc là on va obtenir le même résultat que tout à l'heure. 
```powershell
>python main.py
Quel âge as-tu ? Jason
L'âge indiqué est incorrect !
```
Voyez, l'âge indiqué est incorrect si je mets ça (26). 
```powershell
>python main.py
Quel âge as-tu ? 26
tu as 26 ans
```
D'accord, ça fonctionnera.

Donc au niveau exécution on ne voit aucune différence par contre au niveau codage, c'est plus propre de fonctionner comme ça. 

Et on a un 4e type de mots, alors on n'est pas obligé de tous les mettre, d'accord, au minimum c'est ça, try, except Parce qu'au début le else, je l'avais mis dans try, ce n'est pas forcément très propre mais pourquoi pas. 

## finally

On peut aussi avoir un finally qui veut simplement dire que dans tous les cas, tous les cas de figure, peu importe ce qu'il s'est passé, tu m'afficheras ce qu'il y a dans le finally. Ça veut dire que finalement, tu me fais dans tous les cas ce qu'il contient. 

Donc nous on peut mettre, on va rester très simple, on va mettre "fin du programme" pour annoncer que le programme se termine, voilà.
```py
#coding:utf-8

ageUtilisateur = input("Quel âge as-tu ? ")

try:
   ageUtilisateur = int(ageUtilisateur)
except:
	print("L'âge indiqué est incorrect !")
else:
	print("tu as", ageUtilisateur, "ans")
finally:
	print("FIN DU PROGRAMME…")
```
```powershell
>python main.py
Quel âge as-tu ? 26
tu as 26 ans
FIN DU PROGRAMME…
```
```powershell
>python main.py
Quel âge as-tu ? pezfzjorzfzfe
L'âge indiqué est incorrect !
FIN DU PROGRAMME…
```
Et là peu importe ce que je note, on obtient le finally qui est toujours toujours exécuté, tout ce qui se passe dans ce bloc là, voilà. 

Voilà, ça c'était les mots à connaître. Le minimum c'est try, except et ensuite vous avez le else pour ce qui se passe en cas de réussite et le finally, c'est ce qui est exécuté dans tous les cas de figure, d'accord.

Donc on va le mettre, toujours prendre des petites notes. Donc pour gérer les exceptions, on a try/except, ce qui est obligatoire j'ai envie de dire. Et on peut avoir éventuellement le else, le finally.

```py
# Gérer les exceptions : try/except (+ else, finally)
```

Et voilà, ça ce sont des choses en plus que l'on peut effectivement compter au niveau des vérifications. 

Alors moi dans mon cas, moi je lui dit d'afficher que l'âge indiqué est incorrect si par exemple, il lève une exception. 
```py
except:
	print("L'âge indiqué est incorrect !")
```
Le problème, bon dans ce cas-là ça ne va pas lever 15000 exceptions différentes, vous avez vu tout à l'heure que ça devait une ValueError. 

Donc normalement parce qu'il y a des cas où ça pourrait lever plusieurs exceptions différentes, où je ne sais pas mais ça pourrait être embêtant.

On va reprendre le code différemment, on va faire. Alors je vais faire des choses en dur, je ne vais pas forcément aller demander à l'utilisateur, on va dire qu'on a un nombre (nombre1 = 15), alors c'est comme ça c'est tout bête. 
```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
```
Et pour le nombre2, on va le demander. Vous allez me dire qu'on aurait pu demander les 2 nombres mais c'est histoire de ne pas rajouter trop de input() et cetera. 
```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")
```
Et là, je vais faire du coup. Alors nombre1 est déjà en int parce que il est marqué ici, je l'ai affecté directement avec une valeur en dur donc est sûr que c'est une entier.

Et ici, je vais lui dire tu force avec un cast comme on l'aurait fait avant.
```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

nombre2 = int(nombre2)
```
Ensuite, tu fait, je ne sais pas moi, tu fait print() de "Résultat = {}", on va utiliser format() pour changer un petit peu, format() de nombre1 diviser par nombre2.
```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

nombre2 = int(nombre2)

print("Résultat = {}".format(nombre1 / nombre2))
```
Normalement, ce code-là devrait être tout compréhensible pour vous. S'il y a quelque chose de compliquer dans ce que j'ai noté, re-voyer les vidéos d'avant histoire de ne pas vous perdre, de ne pas en tout cas, avoir des lacunes, en fait, dés le début. Ce serrait un petit dommage pour vous.

Normalement, tout ça c'est clair, tout ça a été vu dans les vidéos précédentes. 

Donc on fait simplement, une première variable "numero1" qu'on affecte en dur "150", une 2e variable où l'on va demander de stocker une variable à l'utilisateur, ensuite on caste la première variable. Et ensuite on affiche le résultat de cette division, d'accord. 

Là on test. 

Donc là normalement, si vous avez réfléchi, vous voyez qu'il y a plusieurs possibles erreurs qui peuvent arriver dans ce genre de programme. 
```powershell
>python main.py
Choisir le nombre pour diviser :
```
"Choisir le nombre pour diviser", normalement tous les matheux auront pensé au 0, vous savez tout ce que là division n'est pas possible. 

Si j'essaie de diviser par 0 :

```powershell
>python main.py
Choisir le nombre pour diviser : 0
Traceback (most recent call last):
	File "main.py", line 312, in <module>
			print("Résultat = {}".format(nombre1 / nombre2))
ZeroDivisionError: division by zero
```

Bim, j'ai un ZeroDivisionError. 
La division par 0, c'est interdit en mathématique, ça n'existe pas donc j'ai un type d'exception mais qu'est-ce qui se passe si je mets n'importe quoi.

```powershell
>python main.py
Choisir le nombre pour diviser : ozo,ef
Traceback (most recent call last):
	File "main.py", line 310, in <module>
			nombre2 = int(nombre2)
ValueError: invalid literal for int() with base 10: 'ozo,ef'
```

Est-ce que ça va me faire une ZeroDivisionError ? Et Ben non Parce que j'essaie de diviser par un texte donc là j'ai une ValueError.

Alors si on est trop fainéant, on va procéder de cette manière, on va faire ça. 

On va faire un try, on va dire j'essaye une cast, d'accord, comme on a fait tout à l'heure et on va dire qu'en cas d'exception parce que vous voyez, on n'a pas trop envie de se prendre la tête… on va dire, je ne sais pas moi … Eh bien le nombre est incorrect, ça ne veut pas forcément dire grand-chose… alors admettons on va dire, voilà, la personne, le développeur se dit "Eh bien dans ce calcul là, comme je connais bien les maths, je sais qu'on ne peut pas diviser par 0 donc je dis que si ça lève une exception, c'est que la personne a essayé de diviser par 0". 

Donc je mets, par exemple, "Vous ne pouvez pas diviser par 0", admettons.

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
except:
	print("Vous ne pouvez pas diviser par zéro.")
print("Résultat = {}".format(nombre1 / nombre2))
```
Donc pas de souci, le mec il pense qu'il a géré son erreur, le développeur, pas de problème. 

On teste le programme et effectivement s'il tombe sur quelqu'un qui fait "O".

```powershell
>python main.py
Choisir le nombre pour diviser : 0
Traceback (most recent call last):
	File "main.py", line 367, in <module>
			print("Résultat = {}".format(nombre1 / nombre2))
ZeroDivisionError: division by zero
```

Alors, d'accord, ce n'est pas ça le problème effectivement, on va plutôt mettre le print() dans le bloc try parce que c'est ça qui lève l'exception Système, ce n'est pas le cast en fait, voilà.

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except:
	print("Vous ne pouvez pas diviser par zéro.")
```

Donc ça en fait, ces 2 choses.

"int(nombre2)", ça ça peut faire lever une ValueError du fait qu'on essaie de caster un entier, un texte.

Et le calcul ici "format(nombre1 / nombre2)" peut faire lever une ZeroDivisionError. 

Donc on va mettre les 2 puisque ces 2 lignes peuvent faire lever une exception. 

Et vous allez voir où est le problème si on n'est pas assez précis.

Donc effectivement, celui qui va faire 0. 

```powershell
>python main.py
Choisir le nombre pour diviser : 0
Vous ne pouvez pas diviser par zéro.
```

"Vous ne pouvez pas diviser par 0" donc c'est bien, il a bien indiqué le problème qu'il y avait. 

Puis je fait ça.

```powershell
>python main.py
Choisir le nombre pour diviser : ezfzef
Vous ne pouvez pas diviser par zéro.
```

Mais moi en fait je fais ça, j'ai mis du texte et on me dit "vous ne pouvez pas diviser par 0" mais le message que l'on me donne n'a rien à voir avec ce que j'ai noté avant. Je n'ai pas essayé de diviser par 0, j'ai essayé de mettre du texte.

Donc vous voyez, on n'est pas assez précis donc c'est pour ça que l'on peut préciser le type d'exception. 

## except en cas de ZeroDivisionError

Donc là je vais mettre, except en cas de ZeroDivisionError, Ça se met d'ailleurs en jaune. 

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError:
	print("Vous ne pouvez pas diviser par zéro.")
```

Ça se met d'ailleurs en jaune, vous reprenez en fait le nom qui s'affiche dans les exceptions, pas besoin de les apprendre par cœur, commencez par apprendre tous les noms des types d'exceptions par coeur. Vous allez au pire sur la documentation python, ou alors vous faites comme moi, vous provoquez l'erreur et il va vous donner le nom, d'accord. 

Ce n'est pas des choses que l'on apprend par cœur, une exception, Après on finit par les retenir naturellement bien sûr mais il y en a tellement que l'on ne peut pas forcément tout retenir par cœur même s'il y en a qui reviennent assez souvent. 

Donc le ZeroDivisionError, comme ça si je lui dis : "si il y a cette exception-là qui tombe, qui est levée, tu fais ce print()". 

Et on peut les cumuler, on peut mettre plusieurs axcept, par exemple.

## except en cas de ValueError

Si tu as une ValueError, c'est seulement dans ce cas que tu me dit : "Vous devez entrer un nombre.", d'accord.

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError:
	print("Vous ne pouvez pas diviser par zéro.")
except ValueError:
	print("Vous devez entrer un nombre.")
```

Et on peut si vous êtes très précis mettre… et bien s'il y avait une autre exception qui se levait, ça peut arriver, admettons je n'en sais rien, une personne pourrait faire un truc qui ferrait une autre exception peut-être une OsError ou je n'en sais rien, et on met à ce moment-là "Valeur incorrecte" parce qu'on ne sait pas à quoi s'attendre comme erreur, on ne sais pas qu'est-ce qui aura provoquer cette exception-là qu'on ne connaît pas.

```py
coding:utf-8

Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError:
	print("Vous ne pouvez pas diviser par zéro.")
except ValueError:
	print("Vous devez entrer un nombre.")
except:
	print("Valeur incorrecte")
```

ZeroDivisionError, celle-là on sait pourquoi elle peut arriver donc on sait ce qu'il faut indiquer à l'utilisateur "Vous ne pouvez pas diviser par zéro.". 

ValueError, celle-là on sait pourquoi donc on sait quoi indiquer aussi. 

Par contre ici "except", on ne sait pas comment on est arrivé là donc on lui dit tout simplement "Valeur incorrecte".

Et là, en faisant ceci.

```powershell
>python main.py
Choisir le nombre pour diviser : 0
Vous ne pouvez pas diviser par zéro.
```

Si je divise par 0, vous voyez qu'il met "vous ne pouvez pas diviser par 0", il est bien rentré par l'exception ici, ZeroDivisionError.

Et en revanche si je mets un texte, il m'a dit "Vous devez entrer un nombre". 

```powershell
>python main.py
Choisir le nombre pour diviser : zefzefze
Vous devez entrer un nombre.
```

Et si, je ne vois pas bon ce que je pourrais noter, je ne sais pas, peut-être des tabulations, peut-être…

```powershell
>python main.py
Choisir le nombre pour diviser :	(tab)
Vous devez entrer un nombre.
```

Non, il faut un nombre (tabulation) donc il ne prend pas. Pour lui c'est ValueError. 

Donc honnêtement, je ne sais pas, il y a peut-être moyen de provoquer une autre exception. 

Après on peut ajouter un else si ça se passe bien, genre "Bravo, tu as noté un nombre valide !".

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError:
	print("Vous ne pouvez pas diviser par zéro.")
except ValueError:
	print("Vous devez entrer un nombre.")
except:
	print("Valeur incorrecte")
else:
	print("Bravo, tu as noté un nombre valide !")
```

Et puis le finally, comme j'avais dit tout à l'heure, on peut sans problème le cumuler aussi, d'accord. Vous voyez, on peut tout cumuler. 

```py
#coding:utf-8

#Gérer les exceptions : try/except (+ else, finally)

nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")

try:
	nombre2 = int(nombre2)
	print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError:
	print("Vous ne pouvez pas diviser par zéro.")
except ValueError:
	print("Vous devez entrer un nombre.")
except:
	print("Valeur incorrecte")
else:
	print("Bravo, tu as noté un nombre valide !")
finally:
	print("Fin du programme…")
```
Voilà, 
```powershell
>python main.py
Choisir le nombre pour diviser : 0
Vous ne pouvez pas diviser par zéro.
Fin du programme…
```

Voilà, 
```powershell
>python main.py
Choisir le nombre pour diviser : zefzef
Vous devez entrer un nombre.
Fin du programme…
```
Et si je fais ça,
```powershell
>python main.py
Choisir le nombre pour diviser : 64
Résultat = 2.34375
Bravo, tu as noté un nombre valide !
Fin du programme…
```

D'accord, tous les cas sont gérés, d'accord. 

Alors l'ordre parce que je sais que ça, il y'en a qui vont me poser la question, ici l'ordre vous pouvez mettre celui que vous voulez. 

```py
"""
try:

except ZeroDivisionError:		<--

except ValueError:			<--

except:

else:

finally:
"""
```

Python est un interpréteur qui va faire ligne par ligne. 

À la rigueur, vous pouvez mettre pour optimiser un petit peu celui qui a le plus de chance d'arriver, pourquoi pas. 

Honnêtement je pense que celui qui a le plus de chances d'arriver, c'est le ValueError, quelqu'un qui ne noterais pas un nombre parce qu'en général les gens savent qu'on ne peut pas diviser par 0, en général. 

Donc vous pouvez par exemple inverser. 

```py
"""
except ValueError:			<--
except ZeroDivisionError:		<--
"""
```

Mais l'ordre n'a pas d'importance, parce que python va aller ici, Il va voir si ça rentre dedans ou pas et si ça ne rentre pas, il passe à la suivante.

si ça ne rentre pas, il passe à la suivante. Else, il ne le fera pas s'il est rentré dans un des except, il va directement sortir. Et si il y a un finally, avant de sortir, il va passer par le finally dans tous les cas. Ça c'est tout le temps. 

Il fait le try, obligatoire, ensuite il vérifie toutes les exceptions jusqu à la dernière. S'il est rentré dans aucune exception, il va dans le else. S'il est rentré dans une alors il fait ce qu'il y a dedans et à la fin, à la sortie de tout ce bloc, il fait le finally et seulement il revient au programme principal.

Vous voyez, tout se suit, tout s'enchaîne, en fait, dans l'ordre. Ca s'enchaîne sans problème naturellement, il n'y a pas de soucis, voilà. Comme ça, on gère les erreurs de manière correcte avec des noms précis de type d'erreur plutôt que d'avoir un message général, un except tout court.

Donc on évite rarement d'utiliser le except tout cours comme ça. 

```py
except:
	print("Valeur incorrecte")
```

Sauf quand on fait un petit programme comme ça dans son coin, Qu'on n'a pas envie de perdre de temps mais gérer un minimum les erreurs, c'est ce qu'on va faire mais quand on veut être précis, distribuer un programme, on essaye d'être très précis dans les messages. Là on comprend tout de suite pourquoi ça a planté, là c'est parce que la personne a bien essayé de diviser par 0.

```powershell
>python main.py
Choisir le nombre pour diviser : 0
Vous ne pouvez pas diviser par zéro.
Fin du programme…
```

Là c'est parce qu'il n'a pas rentré en nombre.

```powershell
>python main.py
Choisir le nombre pour diviser : zefzef
Vous devez entrer un nombre.
Fin du programme…
```

C'est effectivement le cas, si on regarde ce qui a été saisi.

D'accord, donc faut que le message soit clair, si vous devez indiquer une erreur, indiquez là de manière claire. Il faut qu'on comprenne pourquoi la personne s'est plantée sinon je ne vois pas l'intérêt, ça n'a aucun intérêt. 

Donc voilà, vous savez pour try, except, le else, le finally, et comment gérer les types d'exceptions. Je vais vous en mettre quelques-uns quand même si vous voulez des noms. Alors on a le ValueError. Si par exemple vous essayez d'indiquer une variable qui n'existe pas, qui n'est pas défini, vous avez un NameError. Vous avez le ZeroDivisionError. Pour des erreurs système, vous allez avoir le OSError qu'on trouve plus rarement quand même. Et vous allez avoir le AssertionError, voilà. Alors pour ne pas l'oublier TypeError pour les types de variables.

```py
"""
Gérer les exceptions    : 	try/except (+ else, finally)
Type d'exceptions       :	ValueError
       NameError
       TypeError
       ZeroDivisionError
       OSError
       AssertionError
"""
```

Ça c'est les standards, c'est ce qu'on va retrouver le plus souvent. OSError, un petit peu moins quand même mais voilà ces 3 là : ValueError, NameError, TypeError sont très récurrent. Celui-là, ZeroDivisionError, en cas de division par 0 bien évidemment. Et celui-là, AssertionError, on va en parler juste après donc vous allez voir à quoi il correspond.

Voilà voilà, ça on a tout vu normalement, pour les exceptions et cetera.

Alors oui, là on a vu comment gérer une exception qui a été levée. 

```py
	except ZeroDivisionError:
		print("Vous ne pouvez pas diviser par zéro.")
```

Alors qu'est-ce qu'on entend par "levée", Eh bien vous imaginez, moi je donne toujours cet exemple là : quelqu'un a vu un problème, il va noter sur un ballon le souci, un ballon de baudruche, et il va le laisser s'envoler, d'accord.

Donc il lève l'exception, Il laisse le ballon s'envoler et on attend que quelqu'un le capture, l'attrape, d'accord, attrape l'exception qui a été levée. 

Donc si personne ne l'attrape, Eh bien tant pis, c'est ce qui s'est passé au début de notre programme sans avoir de try/except c'est-à-dire qu'on a un gros plantage avec un message tout moche dans le terminal. 

Et si quelqu'un heureusement l'a attrapé, on peut gérer, vous voyez ici " except ZeroDivisionError", on a attrapé une exception En divisant par 0. 

Ici "except ValueError", On attrape une exception de type, voilà par rapport à la valeur, et là "except", on attrape toutes les autres types d'exceptions qui pourrait intervenir, ou survenir pendant l'exécution. 

Donc on gère absolument tout. 

Maintenant et cela sera surtout utile quand vous apprendrez à créer votre propre type d'exception Parce que oui avec l'objet vous pourrez créer vos propres classes et vos propres exceptions. 

Vous pourrez créer, je ne sais pas moi, "InventoryError" Pour gérer un inventaire ou n'importe quoi, ou "FightError", une exception par rapport à un combat. Je prends l'exemple d'un jeu vidéo, toujours, c'est quand même ce qui est le plus clair pour tout le monde. 

Donc on pourrait inventer ça et il peut y avoir dans certains cas l'intérêt II lever nous-mêmes les erreurs parce que là vous voyez qu à chaque fois c'est python Qui le fait. 

Mais le problème, voilà, python, il connaît, il manipule des nombres et cetera, ça il sait faire mais il se pourrait que dans certains cas, dans votre programme, vous ayez … vous vous savez en fait dans l'algorithme que vous avez fait j'écoute qu'il y a possibilité, qu'à un moment, donné votre algorithme puisse lever une exception mais ce n'est pas dit que Python va la trouver.

Alors si c'est une exception standard, il va la trouver, par contre si c'est une exception précise, je ne sais pas, admettrons dans un jeu vidéo, je ne sais pas … vous estimez par exemple que la personne … vous avez un personnage, d'accord, qui gère un inventaire et il ne peut pas avoir plus de 10 objets dans l'inventaire. Pour python, Il n'y a pas de titre d'exception qui disent par exemple : "vous avez essayé de porter plus de 10 objets dans votre inventaire". On est d'accord, ça n'existe pas, par contre vous, par la suite, vous pouvez très bien créer un type d'exception … Ce serait un peu bizarre pour l'exemple que je donne mais pourquoi pas, on peut tout imaginer en informatique … de faire une exception. Par exemple : "vous avez dépassé, entre guillemets, votre quota d'objet porté en inventaire" et en faisant ça vous pourriez lever une exception, par exemple, "InventoryEmptyError", qui voudrait dire que l'inventaire est plein Et du coup ça affichera un message, comme quoi, votre sac est plein, votre inventaire est plein, Vous ne pouvez pas porter d'objets supplémentaires. 

Vous voyez un petit peu le cheminement, du coup ça peut être super intéressant. 

Ce que je vais vous montrer, c'est juste pour la syntaxe, ça ne va pas être utile à l'heure d'aujourd'hui pour ce que vous avez vu mais retenez le parce que ça servira par la suite quand vous ferez vraiment vos propres petites exceptions. 

## raise - lever une exception

Donc pour lever une exception, je vous montre, c'est en un seul mot, ça va être simplement de faire un "raise".

Alors on va faire un truc tout bête, je vais mettre "age = input()". Ce que je vais vous montrer ne sert absolument rien, C'est juste pour vous montrer au niveau syntaxe, bêtement comment on les créé en fait ?  Comment on fait une levée d'exception nous même à la main ? 

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

age = input("Quel âge as-tu ? ")
age = int(age)
```

Je met : 
	age = input("Quel âge as-tu ? ")
	age = int(age)

Je ne fais même pas une vérification, C'est juste pour vous montrer. 

Et là je vais faire "if age < 25:", je ne sais pas pourquoi, c'est vraiment tout bête comme exemple, je vais lever donc on utilise le mot clé "raise" et je choisit le type, alors là quand on a créé nous même une exception, on mettrais ce qu'on avait dit, par exemple, "Inventory" mais pas "InventoryEmpty", j'avais mis empty mais ce n'est pas vide, en fait, c'est full plutôt et cetera … comme quoi, il est plein. Enfin peu importe parce que empty, c'est pour vide. Je vous dit InventoryEmpty pour vous dire que l'inventaire est plein, non c'est plutôt l'inverse. Empty c'est pour vide, bref, je met "InventoryError".

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

age = input("Quel âge as-tu ? ")
age = int(age)

if age < 25:
	raise InventoryError
```

"InventoryError", il ne vous le met pas en jaune (SublimeText), vous voyez qu'il ne le met pas en jaune parce que ça n'existe évidemment pas en Python.

Donc on pourrait créer quelque chose comme ça mais Regardez ce qui est assez bizarre, et pourtant vous allez me dire que ça n'a absolument rien à voir parce que je ne fais pas de division Mais je peux sans problème faire ça.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

age = input("Quel âge as-tu ? ")
age = int(age)

if age < 25:
	raise ZeroDivisionError
```
Alors normalement si je le mets tout seul, ça va être un peu bizarre parce que je vais mettre n'importe quoi, il va mettre rien du tout effectivement puisque je suis au-dessus de 25.
```powershell
>python main.py
Quel âge as-tu ? 26
```

Si je mets 16.
```powershell
>python main.py
Quel âge as-tu ? 16
Traceback (most recent call last):
	File "main.py", line 749, in <module>
			raise ZeroDivisionError
ZeroDivisionError
```

Là vous voyez qu'il me met "ZeroDivisionError" c'est-à-dire que je n'ai pas du tout fait une division par 0, c'est vous qui l'avez élevé, en fait, on peut même mettre un petit message si on veut, D'accord.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

age = input("Quel âge as-tu ? ")
age = int(age)

if age < 25:
	raise ZeroDivisionError("Coucou :) !")
```
Alors il vous affiche ça comme ça.
```powershell
>python main.py
Quel âge as-tu ? 14
Traceback (most recent call last):
	File "main.py", line 782, in <module>
			raise ZeroDivisionError("Coucou :) !")
ZeroDivisionError: Coucou :) !
```
Ça ne sert à rien mais voilà, mais ce qu'on a vu avant c'est le fameux petit message que python nous affiche quand c'est python qu'il fait lui-même, d'accord. 

Et du coup, on peut y aller, si on fait par exemple, qu'est-ce qu'on peut faire ? On va faire un try:, on va dire l'âge et cetera. 

Et ensuite si l'âge est plus petit 25, tu lèves une exception ZeroDivisionError.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	if age < 25:
		raise ZeroDivisionError("Coucou :) !")
```

Et comme on peut lever l'exception Mais vous savez qu'on peut la capturer aussi avec un except, donc je peux faire, bien évidemment ça n'a aucun sens ce que je fais, ce n'est pas affaire du tout, c'est juste pour vous montrer comment On lève une exception. Eh bien on peut dire, "j'ai attrapé ton Pokémon" comme un Pokémon en fait, voilà, comme ton Pokémon, j'ai attrapé ton exception inutile parce que là de toute façon fait une ZeroDivisionError, ça n'a rien avoir, mais c'est juste pour montrer que ça fonctionne.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	if age < 25:
		raise ZeroDivisionError("Coucou :) !")
except ZeroDivisionError:
   print("J'ai attrapé ton exception inutile")
```
```powershell
>python main.py
Quel âge as-tu ? 13
J'ai attrapé ton exception inutile
```
Donc voilà, On a levé un type d'exception reconnu par Python donc on peut faire comme on a fait au début c'est-à-dire le capturer avec un except, et géré le cas de figure, ça fonctionne. 

Mais ça, le "raise", ça ne vous servira à rien pour le moment, ce sera vraiment utile quand vous allez créer vos propres types d'exception.

Là, à l'heure actuelle vous n'en aurez pas besoin, Vous aurez juste besoin de faire des try pour tester certaines parties du code sensible est avec les except, finally, les else, et cetera, vous allez pouvoir gérer les cas d'erreurs possibles donc ça c'est utile.

Et on va terminer cette vidéo pour pas faire trop trop long parce qu'on aura déjà vu pas mal de choses, je trouve, ça va vous faire beaucoup de choses à revoir. 

Et on va voir également, comment gérer tout ce qui est assertion. 

## assert - lever une AssertionError

Alors, une assertion, ça va être plus ou moins un test, en fait, de code où vous savez qu'il peut y avoir un souci, tout simplement dessus, et on va utiliser le mot-clé "assert" comme ceci, d'accord. 

Une assertion, en fait, C'est une instruction que vous allez noter. Ça peut permettre notamment de faire des tests sur un calcul qui ne serait pas possible ou autre, il va lever une exception "AssertionError", ça je l'ai déjà noté ici (notes en commentaires), d'accord, et à partir de là vous pourrez la capturer comme vous voulez. 

Donc moi je peux très bien faire, je ne sais pas moi qu'est-ce que je peux faire ? On va faire ce qu'on a fait tout à l'heure, c'est un bon exemple, Je vais reprendre sur ce que j'avais tout à l'heure. 

Je reprends :

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

Et là, au lieu de faire juste IF, je fais "assert age" et je vérifie si l'âge est plus petit que 25, d'accord. Et à partir de là, ouvrez un petit peu ce qu'il se passe.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	assert age < 25
```
Normalement, quand on ça, on fait un except quand même … et en fait non, je ne vais pas le faire dans try.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

age = input("Quel âge as-tu ? ")
age = int(age)

assert age < 25
```
Normalement, je dois pouvoir le faire tout seul.
Bon quel âge as-tu ? Je note 26.
```powershell
>python main.py
Quel âge as-tu ? 26
Traceback (most recent call last):
	File "main.py", line 900, in <module>
			assert age < 25
AssertionError
```

Déjà il vous met AssertionError, effectivement parce que le assert … alors là je l'ai fait … si j'avais voulu reprendre le cas de tout à l'heure, j'aurais dû mettre le symbole de l'autre côté "assert age > 25" mais peu importe. 

"assert", Il vous dit tout simplement : "tu lèves une exception d'assertion si l'âge est plus petit que 25".

J'ai fait 26 mais comme c'est plus grand, on ne passe pas dans l'assertion, d'accord.

Donc là, âge plus petit que 25 ? non parce qu'il est plus grand, c'est 26, et du coup il fait une AssertionError, okay. 

Donc en faisant mon try, comme ceci.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	assert age < 25
```

Donc là dans mon cas j'aurais dû plutôt mettre ça "assert age > 25". L'asserttion, il l'a fait comme ça. Et ensuite on va mettre le except et bien évidemment, on va mettre le AssertionError "except AssertionError".

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	assert age > 25

except AssertionError:
	print("J'ai attrapé l'exception")
```

Donc là j'ai inversé le signe, la comparaison. 
Si je me 15, il vous dit j'ai attrapé l'exception, d'accord, voilà. 
```powershell
>python main.py
Quel âge as-tu ? 15
J'ai attrapé l'exception
```

Ça veut dire qu'il essaie de voir que l'àge j'ai plus grand que 25. 

Comme la, là j'ai plus petit que 25, on lève l'exception. Si l'âge j'avais été plus grand que 25. Pas de souci avec 26.

```powershell
>python main.py
Quel âge as-tu ? 26
```

Alors là, c'est un petit peu à l'envers … c'est pour ça que des fois je fais un peu attention à ce que je dis pour ne pas me tromper, je veux dire une bêtise où vous induire en erreur … l'assertion c'est vraiment ce qui doit, ce qu'on attend, en fait, d'accord. C'est-à-dire que là on attend, on peut jour commenté comme ça "je veux que age soit plus grand que 25", c'est tout, sinon Eh bien voilà je lève une exception. 

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)

	assert age > 25 #Je veux que âge soit plus grand que 25.

except AssertionError:
	print("J'ai attrapé l'exception")
```

C'est ça qu'il faut comprendre, le assert, ça veut simplement dire je veux que la condition qui vient après soit valide, si elle ne l'est pas tu me lève une AssertionError, d'accord, comprenez le comme ça, je pense que ce sera beaucoup plus clair comme ça. Dans ce sens là, par rapport à ce que j'avais expliqué au début, ce n'était pas forcément très compréhensible. Dans ce sens, quand vous avez le mot-clé assert, dites-vous, on attend la condition qui suit " age > 25 ". Si elle est validée comme ici, 26, tu continue comme d'habitude et si ce qui suit le mot assert, ça n'est pas validé, Eh bien dans ce cas là tu fais une AssertionError donc là il n'y a pas de ZeroDivisionError, je ne sais pas quoi, c'est AssertionError. Ça permet de le gérer comme ça. 

Alors ce n'était pas facile de vous l'expliquer, déjà parce que ça inversé un petit peu au niveau de l'assertion par rapport au try, ou dès qu'il y a une erreur, on lève l'exception, on la récupère. Là c'est vraiment dans le cas où qu'est-ce qu'on veut comme condition et surtout je ne peux pas vous donner beaucoup d'exemples parce qu'encore une fois, on n'a pas encore vu la partie objet du langage. On n'a pas fait d'objets, de classes et cetera, et du coup on n'a pas vraiment parlé des exceptions en tant que objet. 

Donc c'est pas facile de vous expliquer les choses, c'est ça le problème du langage python, c'est que c'est un langage objet complet, tout ce que vous avez vu en procédural, en réalité vous manipulez déjà des objets mais je peux pas commencer directement à vous parler d'objets sinon compliquerait les choses. 

Et voilà, ce serait juste impossible à suivre pour certains je suis obligé de procéder par les étapes pour commencer par le plus simple et par la suite, on manipule comme ceci, comme cela parce que c'était un objet qui était dessous, en fait. 

Donc ce n'est pas forcément simple à montrer mais je pense que là vous avez compris qu'effectivement au niveau du assert, c'est En bref, j'exige que age soit plus grand que 25 sinon je vais lever une AssertionError, d'accord, Il faut vraiment le comprendre comme ça. 

```py
assert age > 25
```

Dans le cas où c'est bon, ça va, si c'est pas bon, évidemment on a une exception et on peut la capturer également avec un except et cela fonctionnera. 

Puis voilà comme ça on a fait le tour, globalement, je vous ai fait un petit peu le tour de tout ce qu'il y avait à voir, en tout cas, à l'heure actuelle au niveau de la gestion d'erreur. 

Donc vous savez comment tester un code sensible avec le try, comment gérer toutes les exceptions possibles s'il le faut avec un simple except. Après vous pouvez affiner votre gestion d'erreur avec les fameux type d'exception, voir par rapport à ce qui est provoqué. 

En cas de réussite, vous pouvez mettre un petit else éventuellement et bien évidemment si vous avez un code que vous devez exécuter dans tous les cas, vous utilisez le petit mot clé finally donc un bloc finally, ça fonctionnera aussi, voilà. 

Donc à partir de maintenant, on ne le fera pas forcément dans toutes les vidéos suivantes parce que vous voyez que ça rajoute quand même pas mal de lignes de code et le but c'est quand même d'aller à l'essentiel des notions que je vous enseigne. 

Donc je ne vais pas forcément gérer les erreurs dans tous les codes que je vais vous montrer par la suite, j'essayerais de le faire de temps en temps quand il n'y a pas des choses trop trop longues mais la plupart du temps je ne le ferai pas. 

Si vous voyez que normalement dans un code, je fais ceci "age = int(age)" sans le mettre dans un bloc try except, c'est que ce n'est pas comme ça qu'il faut faire. Essayer, vous, de prendre l'habitude où quand vous avez quelque chose comme ça où vous savez que ça peut échouer, que ça peut lever une exception, de le mettre dans un bloc try except. 

Prendre vraiment cette habitude, dès que j'ai une modification qui peut entraîner une exception, je le teste dans un bloc comme ça on est sûr de gérer le erreur cas de problème, au minimum avec au moins un except tout court, d'accord. 

Au moins voilà, le minimum du code c'est ça.

```py
#coding:utf-8

#Gérer les exceptions    : 	try/except (+ else, finally)
#
#Type d'exceptions       :	ValueError
#					NameError
#					TypeError
#					ZeroDivisionError
#					OSError
#					AssertionError

try:
	age = input("Quel âge as-tu ? ")
	age = int(age)
except:
	print("Age incorrect")
```

Ça c'est vraiment le minimum, minimum, minimum vital. Comme ça on est sûr qu'on a géré l'erreur dans tous les cas plutôt que de faire simplement ça "age = int(age)" sinon on va voir des messages tout bizarre dans le terminal, ce n'est pas forcément joli et pas très pratique et pas bien pour l'utilisateur final qui lui ne veut pas avoir des lignes de code ou des erreurs bizarres avec des numéros de ligne et tout ça, évidemment ou des noms d'exception. Il en a rien à secouer, entre guillemets, des noms d'exception et cetera. Il n'est pas développeur, c'est vous le développeur donc l'utilisateur, il doit avoir un texte dans la langue qu'il parle pour comprendre l'erreur qu'il y a eu, tout simplement. 

Eh bien on va s'arrêter ici pour cette petite séance 9, on se retrouvera du coup pour la prochaine, on va pouvoir très rapidement, maintenant enfin parler d'objets. 

C'est pour ça que je voulais qu'on voit tout ça, qu'on parle de modularité, qu'on voit comment gérer les erreurs au minimum en tout cas pour pouvoir commencer la partie objet de python. 

Donc la suite, pour la prochaine séance, on va pouvoir vraiment démarrer là-dessus, vous allez voir toute la puissance de ce langage et comprendre pourquoi effectivement on dit c'est un langage qui est tout objet, que même le fameux int, le integer, donc les entiers, ce sont des objets. 

Tout, en fait, tout est objet, vos variables et cetera, ce sont également des choses qui peuvent se comporter comme des objets donc on regardera un petit peu tout ça par la suite dans la prochaine vidéo. 

En attendant, entraînez-vous bien, n'hésitez pas encore une fois à commenter, à poser des questions, s'il y a quelque chose qui n'est pas assez clair surtout que là on va passer une autre étape de l'apprentissage du langage donc là si vous avez des choses qui ne sont pas tout à fait comprise ou qui ne sont pas assez clair parce que ce n'est pas facile de coder en direct, en vidéo, et de vous expliquer en même temps. Ce n'est vraiment pas facile comme chose, je peux très bien avoir dit des choses qui ne sont pas assez clairs ou bien avoir parlé un peu trop vite ou être passé un peu trop vite sur certaines notions. 

Donc n'hésitez pas à demander, à poser des questions si il y a le moindre problème et j'y répondrais volontiers, comme ça vous serez vraiment paré pour la suite.

À très bientôt tout le monde et on se retrouve pour la prochaine vidéo 

## Resume

```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Python #9 - gestion erreurs
# https://www.youtube.com/watch?v=1IqnpaQy8LM&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=9
# Voyez comment gérer les erreurs en Python, en découvrant les exceptions, comment les gérer, traiter les différents cas d'erreurs et garder le contrôle sur vos programmes.

"""
(Abordés dans cette vidéo)

	Gérer les exceptions    : try/except (+ else en cas de réussite, finally pour du code à exécuter dans tout les cas)
   -> else et finally sont des blocs en plus que l'on peut compter dans nos vérifications.
	Type d'exceptions       :   ValueError
                               NameError (variable qui n'existe pas, qui n'est pas définie)
                               TypeError
                               ZeroDivisionError
                               OSError (erreur système, plus rare)
                               AssertionError
"""

import os
os.system("cls")

"""
Erreur possible en Python.
Par exemple, on demande l'âge. On s'attend à avoir un âge.
Pour s'assurer du bon fonctionnement, on fait un cast de l'âge.
Comme ça, on s'assure que c'est bien considéré comme un nombre et pas comme une chaîne.
En rappel, le fonction input lis tout au clavier comme une chaine et pas un entier.
Dans ce genre de cas, on vérifie rien. L'utilisateur peut encoder n'importe quoi comme âge.
Quel âge as-tu ? Samuel -> cela plante
Le programme retourne ValueError, c'est une valeur incorrecte par rapport à un entier.
On peut avoir ZeroDivisionError, TypeError, OsError, etc. Ce sont des types d'exceptions.
L'interprêteur relève ainsi des erreurs d'un certain type, il leve une exception et affiche un message.
Le code écrit n'as pas d'erreur mais l'utilisateur peut en générer.
Le problème se situe au niveau du cast. On a essayé de transformer un nombre entier, un prénom.
Dans ce cadre où on a une instruction utilisateur ("Ne jamais faire confiance à un utilisateur", regle n°1 en informatique)
Ca peut être un utilisateur ou bien encore une information récupérer d'une base (requête ou autre), ect.
Tout ce qui aurait pu être corrompue par un utilisateur ou un tiers doit être absolluement vérifié.
"""
#1# TRY / EXCEPT.
# C'est le minimum pour la gestion des erreurs.
# La base pour gérer un cas d'erreur dans un programme c'est d'utiliser le jeu d'instruction try/except (try/catch dans d'autres langages).

ageUtilisateur = input("Quel âge as-tu ? ")
try: # Essayer ce cast car il est possible qu'il ne fonctionne pas ...
   ageUtilisateur = int(ageUtilisateur) # En effet, caster un nom est impossible.
except: # ... dans le cas où tu lève une exception, qu'es que tu fait :
   print("L'âge indiqué est incorrect !") # afficher un print dans la mesure où on ne boucle pas pour attendre une nouvelle réponse de l'utilisateur (méthode fainéant).
print("Tu as", ageUtilisateur, "ans.")

""" Ajouter l'affichage de l'âge dans le bloc try pour ne plus afficher l'âge malgré l'erreur.
On aurais pu redemander l'âge plutôt que de quitter comme ça.
Au niveau codage, c'est qui suit est déjà plus propre.  """
ageUtilisateur = input("Quel âge as-tu ? ")
try:
   ageUtilisateur = int(ageUtilisateur)
   print("Tu as", ageUtilisateur, "ans.")
except:
   print("L'âge indiqué est incorrect !")

#2# ELSE.
# bloc qui contient ce qui se passe en cas de réussite.
# permet de gérer d'autres fonctionnements.
# Au niveau éxécution, cela ne fait pas de différence mais au niveau codage c'est plus propre.
ageUtilisateur = input("Quel âge as-tu ? ")
try: # Tu essaye de caster l'âge de l'utilisateur.
   """ Tu essaye un certains nombres d'instructions (généralement 1 instruction) ...
   un try, c'est une instruction dans un bloc.
   On essaye quelque chose dont onsait que cela peut mal se passer par rapport à un utilisateur.
   ça pourrait être une lecture de fichier par exemple. Ouvrir un fichier devrait être testé comme ça.
   Ouvrir un fichier devrait soulever une exception que l'on peut ensuite gérer.   """
   ageUtilisateur = int(ageUtilisateur)
except: # Si tu relève une exception quelconque ...
   print("L'âge indiqué est incorrect !") # ... tu affiche cela.
else: # ... sinon à priori ça s'est bien passer.
   print("Tu as", ageUtilisateur, "ans.")

#3# FINALLY.
# bloc exécuté dans tout les cas de figure.
# Ce qui est dans le bloc finally est toujours exécuter peut importe le cas.
ageUtilisateur = input("Quel âge as-tu ? ")
try:
   ageUtilisateur = int(ageUtilisateur)
except:
   print("L'âge indiqué est incorrect !")
else:
   print("Tu as", ageUtilisateur, "ans.")
finally: # ... dans tout les cas de figure, tu affichera ce qui suit.
   print("FIN DU PROGRAMME")

#4# Exceptions multiples.
"""
Jusqu'ici on demande au programme d'afficher que l'âge est incorrecte si il lève une exception.
Dans le cas de l'âge, ça va lever une ValueError.
Dans certains cas, ça pourrait lever plusieurs exceptions différentes.
Par exemple, on demande à l'utilisateur de choisir le diviseur.
La division par zéro va lever une exception, une ZeroDivisionError.
La division par un texte va lever une autre exception, une ValueError.
"""
nombre1 = 150 # Première variable affectée en dur.
nombre2 = input("Choisir le nombre pour diviser : ") # seconde variable où l'on demande à stocker une valeur à l'utilisateur.
nombre2 = int(nombre2) # ... caster la valeur
print("Résultat = {}".format(nombre1 / nombre2)) # ... afficher le résultat de cette division.

"""
Si on est fainéant, on essaye le cast et la division (try/except)
... mais encore faut-il un affiche qui prend en compte toutes les exceptions.
"""
nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")
try: # on essaye le cast et la division... 
   nombre2 = int(nombre2) # peut lever une ValueError (caster en entier un texte).
   print("Résultat = {}".format(nombre1 / nombre2)) # peut lever une ZeroDivisionError.
except: # ... en cas d'exception :
   print("Vous ne pouvez pas diviser par zéro.") # ... non adapté aux exceptions ValueError !

"""
On peut préciser le type d'exception comme une ZeroDivisionError.
Il ne faut pas les retenir. il suffit d'aller sur la doc Python ou de provoquer l'erreur pour obtenir le nom.
Si on sait à quoi s'attendre comme erreur, on sait quoi afficher aux utilisateurs.
Il est possible de cumuler les exceptions connues ou non, un else, un finally.
Ainsi on peux gérer tous les cas ...
"""
nombre1 = 150
nombre2 = input("Choisir le nombre pour diviser : ")
try:
   nombre2 = int(nombre2)
   print("Résultat = {}".format(nombre1 / nombre2))
except ZeroDivisionError: # préciser le type d'érreur (il se colore syntaxiquement).
   """ On gère une exception qui a été levée. Qu'es qu'on entend par levée ? Si quelqu'un a vu un problème, il va le noter
   sur un ballon de baudruche et il va le laisser s'envoler. Donc il lève l'exception, il laisse le ballon s'envoler.
   Et on attend que quelqu'un le capture l'attrape l'exception qui a été levée. Si personne l'attrape, tant pis.
   C'est ce qui arrivait au début du programme sans TRY/EXCEPT quand on a un gros plantage dans le terminal.
   Et si quelqu'un l'as attrapé heuresement, on peut gérer l'exception. Ici quelqu'un a attrapé le except ZeroDivisionError:.
   """
   print("Vous ne pouvez pas diviser par zéro.")
except ValueError: # cumuler les exceptions connues.
   """ ... ici on attrape une exception de type ValueError. """
   print("Vous devez entrer un nombre.")
except: # On ne sait pas à quoi s'attendre comme erreur (OsError ou autre).
   """ ... ici on attrape tous les autres types d'exceptions qui pourraient survenir. """
   print("Valeur incorrecte.")
else:
   print("Bravo, tu as noté un nombre valide !")
finally:
   print("Fin du programme ...")

"""
Quid sur l'ordre.
-----------------
L'ordre n'est pas important entre except ZeroDivisionError et except ValueError. 
Python est un interprêteur donc il va faire ligne par ligne.
Pour optimiser un peu, on peut mettre en premier les exceptions qui ont le plus de chance d'arriver.
ValueError a le plus de chance d'arriver car en général les gens savent qu'il ne peuvent pas diviser par zéro.
Mais en général l'ordre n'as pas d'importance. Si Python voit qu'il n'y rentre pas, il rentre à la suivante, etc.
Le try est obligatoire.
Else et certains Except ne sont pas utilisé si Python rentre dans un bloc précédent.
finally est utilisé quoi qu'il arrive avant la fin du programme.
On utilise raremment le except tout court à moinssi on fait son programme dans son coin et qu'on ne veux pas perdre de temps.
On essaye toujours d'être précis dans les messages.
"""

#5# RAISE
# permet de lever une exception nous même.
# exemple non utile, juste pour voir la syntaxe.
# Niveau syntaxe comment lever une exception nous même.
"""
Avec l'objet, on pourra créer nos propres classes et nos propres exceptions.
Dans un jeu, on peux inventer InventoryError pour gérer nos propres inventaires.
Ou encore FightError, une exception pendant un combat.
Là, il y a l'intérêt de lever nous même les erreurs parce qu'ici c'est Python qui le fait.
Python manipule juste des nom, ect. Si c'est une exception standad, Python va la trouver ...
... par contre si c'est une exception précise. Par exemple, dans un jeu, un personnage gère un
inventaire et il ne peut avoir plus de 10 objets dans son inventaire.
Dans ce cas, Python ne voit pas de type d'exception mais nous pourront créer une exception
pour dire qu'on a dépasser le quotas d'objet dans notre inventaire.
Cela permet de lever une exception tel que InventoryError quand l'inventaire est plein.
Cela a pour conséquence d'afficher un message pour dire que notre sac est plein.

"""
age = input("Quel âge as-tu ? ")
age = int(age)
if age < 25: # ... si l'âge est plus petit que 25, tu lève l'exception ZeroDivisionError.
   """ Si on avait créer une exception, on mettrait raise InventoryError pour lever notre exception.
   Ici on lève un problème de division sans raison."""
   #raise ZeroDivisionError
   """ On peut lui passer une message si nécessaire."""
   #raise ZeroDivisionError("Coucou :) !")

""" Si on peux lever l'exception, on peux la capturer avec except (aucun intêret) """
try:
   age = input("Quel âge as-tu ? ")
   age = int(age)
   if age < 25:
       raise ZeroDivisionError("Coucou :) !")
except ZeroDivisionError:
   print("J'ai attrapé ton exception inutile.")
""" On a lèvé un type d'exception reconnu par Python et on peux le capturer avec un except.
A l'heure actuel, le raise ne sert à rien. Il sera utile quand on va lever nos propres types d'exceptions.
Ici les try permettent de tester quelques partie de codes sensible avec except, else, finally de gérer les cas d'erreurs possibles.
"""

#6# Gérer une assertion (ASSERT)
# Le mot clé ASSERT.
# Ce mot clé permet de lever une exception AssertionError que l'on peut ensuite récupérer.
# Une assertion, c'est un test de code là où il peut y avoir un soucis.
# On peut faire par exemple un test sur un calcul qui ne serait pas possible.

age = input("Quel âge as-tu ? ")
age = int(age)
assert age < 25 # Tu lève une exception d'assertion si l'âge est plus petit que 25.

""" L'assertion (le levage est inversé) est ce que l'on attend. Si assert > 25, la valeur 
15 lévera une exception. """
try:
   age = input("Quel âge as-tu ? ")
   age = int(age)
   assert age > 25 # Je veux que age soit plus grand que 25 ...
except AssertionError: # ... sinon on lève une exception.
   print("J'ai attrapé l'exception.")

""" (inverse des autres exceptions) On veux la condition qui suit ... sinon on lève l'exception.
Si ce qui suit assert n'est pas respecter, on lève une exception.

J'exige que âge soit plus grand que 25 ... sinon on lève une AssertionError.
Si ce n'est pas bon, on capturera l'exception avec un except AssertionError. """

#7# Conclusion
""" La gestion des erreurs est à faire seulement si ça peut échouer ou lever des exceptions.
Si le code peut lever une exception, on le test dans un bloc TRY / EXCEPT au minimum avec un except tout court. 

Ainsi le code minimal :"""
try:
   age = input("Quel âge as-tu ? ")
   age = int(age)
except:
   print("Age incorrect.")
""" Le code est plus propre pour l'utilisateur final qui lui ne veut pas voir des lignes de codes 
avec des noms d'exceptions et des numéros de lignes. L'utilisateur doit avoir un texte dans sa langue."""
```