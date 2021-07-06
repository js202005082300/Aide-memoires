# [5. Conditions](https://www.youtube.com/watch?v=T_AsJ0nIeh0)

Bonjour à tous, vous êtes sur votre séance 5 sur le langage python, nous allons maintenant parler des structures conditionnelles donc notamment les conditions. 

Comment on va pouvoir effectuer des tests sur certaines de nos variables par exemple ou cours de notre programme et effectuer des traitements en fonction des résultats qui ont été obtenus lors de ces tests.

On va regarder directement sur un code pour voir comment mettre ça en place. C'est une séance qui va être très très simple, comme la séance suivante d'ailleurs où on va voir des choses tout à fait basique du langage que vous pouvez retrouver également dans d'autres langages de programmation.

Jusqu'à présent, vous avez vu les variables, on a passé pas mal de temps dessus pour voir comment ça fonctionnait et également les opérateurs pour pouvoir effectuer des calculs, à faire directement pour stocker le résultat directement dans une variable.

Le truc, c'est qu'on ne va pas toujours se baser sur ça, on va pas forcément, à chaque fois, avoir une variable et c'est tout.

Après voilà, avoir une valeur en dur comme ça qui sera entrée où le résultat d'un calcul, on aura parfois besoin d'avoir du contenu dynamique ou tout simplement d'effectuer des tests pour vérifier certaines petites choses. Ca peut être tout simplement, je sais pas moi, on va faire un système d'authentification très très simple, c'est juste pour l'exemple encore une fois où vous auriez... on va faire quoi ? on va faire "pseudo" enfin "identifiant" plutôt, voilà.
```py
#coding:utf-8

identifiant = "Jason"
```
On va mettre identifiant comme ça, on va mettre mon prénom, on va mettre mot_de_passe comme ça. "password123" alors ce n'est pas du tout un mot de passe sécurisé.
```py
identifiant = "Jason"
mot_de_passe = "password123"
```
Ce n'est évidemment pas un mot de passe sécurisé, c'est pour l'exemple. Grosso modo, on imagine ce genre de chose, c'est pour l'exemple.

Et on va faire une petite connexion, tout simplement donc pour vérifier ça. On imagine que je suis sur une interface de connexion, d'accord, ma connexion à un compte ou n'importe quoi et on va demander. C'est ce qu'on va faire là et on va demander l'identifiant, en fait, de la personne donc on va faire user_id, puis on va faire un petit input() et on va demander "Entrez votre identifiant : " et pourquoi pas ensuite votre mots de passe "Entrez votre mot de passe : " et voilà.
```py
identifiant = "Jason"
mot_de_passe = "password123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")
```
On va récupérer ces deux choses-là et après à la fin, on aura tout simplement "Vous êtes connectés ..." suivi de l'identifiant.
```py
identifiant = "Jason"
mot_de_passe = "password123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")
print("Vous êtes connectés, bienvenue,", user_id)
```
Voilà tout simplement donc une phrase de connexion à la fin.

Donc en temps normal, si j'exécute ce programme là, je regarde un petit peu.

Il va me demander de taper n'importe quoi, il va me demander le mot de passe, allez "1234". 
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : Naoki
Entrez votre mot de passe : 1234
Vous êtes connectés, bienvenue, Naoki
```
Voilà, il me dit que vous être connecté évidemment puisque je n'ai fait aucun test, je n'ai rien bloqué.

Voyez au cours du programme, je fais simplement demander une information, je stocke dans des variables et j'affiche ensuite avec quelque chose dans un print() donc il s'est rien passé de particulier.

Moi ce que j'aimerais, c'est avoir, par exemple, l'accès une certaine information, c'est-à-dire de l'afficher que si le mot de passe est correct. C'est-à-dire que l'identifiant, à la rigueur, je m'en fiche pour le moment, on verra pourquoi.

...mais si simplement le mot de passe est correct.

Pour ça, on va tout simplement faire une condition, on va utiliser le mot clé IF tout simplement et on va déterminer une condition donc c'est un test, qu'est-ce qu'on va tester ? Moi je veux que le mot de passe soit qu'on a entré soit égal au mot de passe défini par le programme.

Donc ça c'est ce qui définie par le programme.

    identifiant = "Jason"
    mot_de_passe = "password123"

Donc ça c'est ce qui est défini par le programme, on l'a mit en dur, ici c'est pas très propre mais c'est encore une fois pour simplifier les choses.

Et là, on a ce qui est demandé à l'utilisateur, on va donc vérifier que ce qui est demandé à l'utilisateur est égal au mot de passe du programme.
```py
identifiant = "Jason"
mot_de_passe = "password123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

if user_password == mot_de_passe
    print("Vous êtes connectés, bienvenue,", user_id)
```
Donc on va faire sous cette forme là IF notre test et on va utiliser ce qu'on appelle un opérateur de comparaison donc vous avez vu les opérateurs pour les calculs dans la séance précédente le égal, le plus, le égal c'est surtout pour l'affectation.

Vous avez vu le plus, le moins, vous avez vu l'étoile, le slash et vous avez vu le modulo également et là on va voir des opérateurs de comparaison donc je vais vous le noter après dans les commentaires pour que vous puissiez vous y retrouver.

Et on termine avec deux points, simplement pour délimiter, un petit peu, le test parce qu'on n'a pas de parenthèses comme on peut retrouver dans d'autres langages comme le C ou C++.

```py
identifiant = "Jason"
mot_de_passe = "password123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

if user_password == mot_de_passe:
    print("Vous êtes connectés, bienvenue,", user_id)
```

Du coup on met des espaces et on met bien deux points à la fin.

Dans ce cas-là, si c'est bon, je vais afficher ça (print() de "Vous êtes connectés") donc comme je suis dans quelque chose, dans le vif, je vais bien penser à faire une tabulation, c'est super important.

Le langage python n'utilise pas d'accolades ou l'autre, il utilise des tabulations donc quelque part, il vous évite de mal coder, de mal écrire votre code et donc de le présenter correctement.
```py
    if user_password == mot_de_passe:
        print("Vous êtes connectés, bienvenue,", user_id)
```
Si vous le mettez ici le print, il n'est pas considéré comme étant dans le IF.
```py
    if user_password == mot_de_passe:
        print("Vous êtes connectés, bienvenue,", user_id)
```
ça veut tout simplement dire, si cette condition est validé, je vais faire tout ce qui est après les deux-points et qui a eu une tabulation.

Donc à partir du moment où je suis ici.

    print("Je ne suis plus dans le 'if'")

```py
identifiant = "Jason"
mot_de_passe = "password123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

if user_password == mot_de_passe:
   print("Vous êtes connectés, bienvenue,", user_id)

print("Je ne suis plus dans le 'if'")
```
Je n'y suis plus parce que je n'ai pas fait une tabulation donc là on va retester.
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : Jason
Entrez votre mot de passe : passe
Je ne suis plus dans le 'if'
```
Donc là, vous voyez simplement que je ne suis plus dans 'if', il ne met plus la ligne où vous êtes connecté puisque ce n'est pas le mot de passe réel.

Je vais relancer le programme et là, je vais mettre le vrai mot de passe, password123.
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : Jason
Entrez votre mot de passe : password123
Vous êtes connectés, bienvenue, Jason
Je ne suis plus dans le 'if'
```
Et là il met, vous êtes connecté, voilà.

Donc la condition, voyez selon si elle est validée ou non donc le test, vous allez entrer dans la condition ou pas, comme ça, c'est une première possibilité et on va utiliser pour cela des opérateurs de comparaison.

Les opérateurs de comparaison je vais vous les noter. On va les voir ici.
```py
"""
    Opérateurs de comparaison : == (égal à)
"""
```
Opérateurs de comparaison parce qu'il y en a plusieurs, il y a le double égal pour égal à, alors pourquoi, on met un double égal ? tout simplement parce que le égal, tout simple, comme vous le voyez, il est déjà réservé pour l'affectation. Une valeur dans une variable par exemple ou après un calcul ou le retour d'une fonction.
On aura d'ailleurs l'occasion de le voir un peu plus en détail quand on abordera justement les fonctions et tout ce qui est modularité dans les séances suivantes.

Donc on a tout simplement doublé le égal, c'est pareil dans les autres langages de programmation. C'est devenu une norme sur tous les langages de programmation, en tout cas, je n'en connais pas qui n'aurait pas ce symbole là pour effectuer des tests, en tout cas des tests d'égalités.

On peut avoir ensuite l'inverse c'est-à-dire 'différent de' donc là on va mettre un point d'exclammation comme ceci (!=) avec un égal qui suit.
```py
"""
    Opérateurs de comparaison : == (égal à)
                                != (différent de)
"""
```
On va avoir ce symbole là plus petit que (<). Je vous apprends rien ça, c'est comme les mathématiques. 
```py
"""
    Opérateurs de comparaison : == (égal à)
                                != (différent de)
                                < (plus petit que)
"""
```
Plus grand que (>), okay.
```py
"""
    Opérateurs de comparaison : == (égal à)
                                != (différent de)
                                < (plus petit que)
                                > (plus grand que)
```
Plus petit ou égal à (<=).
```py
"""
    Opérateurs de comparaison : == (égal à)
                                != (différent de)
                                < (plus petit que)
                                > (plus grand que)
                                <= (plus petit ou égal à)
```
Et plus grand ou égal à (>=).
```py
"""
    Opérateurs de comparaison : == (égal à)
                                != (différent de)
                                < (plus petit que)
                                > (plus grand que)
                                <= (plus petit ou égal à)
                                >= (plus grand ou égal à)
```
C'est les 6 opérateurs de comparaison que nous allons avoir pour les conditions.

Voilà comme ça, on peut vérifier certaines choses.

Maintenant donc ça c'est à retenir, c'est tout ces symboles-là, retenez les, vous verez que ça ira très très vite et ça ira très facilement.

Et on ne va pas seulement se contenter de ça puisque moi j'aimerais, également, que l'identifiant soit correcte, que les 2 informations soient correctes.

Uu coup on peut faire des conditions multiples.

Alors conditions multiples, vous allez avoir d'autres petits mots.

Je vous les met d'avance.

Vous allez avoir le and, correspond à quelque chose et autre chose est validé.
```py
"""
    Opérateurs de comparaison       :   == (égal à)
                                        != (différent de)
                                        < (plus petit que)
                                        > (plus grand que)
                                        <= (plus petit ou égal à)
                                        >= (plus grand ou égal à)
    
    Conditions multiples            :   and (ET)     
```
Vous allez avoir le or pour ou.
```py
"""
    Opérateurs de comparaison       :   == (égal à)
                                        != (différent de)
                                        < (plus petit que)
                                        > (plus grand que)
                                        <= (plus petit ou égal à)
                                        >= (plus grand ou égal à)
    
    Conditions multiples            :   and (ET)
                                        or (OU)
```
Et vous allez avoir le NOT ou IN donc le IN ou NOT IN donc on va dire DANS ou PAS DANS par exemple dans un intervalle, dans quelque chose et cetera.
```py
"""
    Opérateurs de comparaison       :   == (égal à)
                                        != (différent de)
                                        < (plus petit que)
                                        > (plus grand que)
                                        <= (plus petit ou égal à)
                                        >= (plus grand ou égal à)
    
    Conditions multiples            :   and (ET)
                                        or (OU)
                                        in / not in (DANS / PAS DANS)
```
Donc je vais l'expliquer après, c'est pas forcément très clair pour le moment. On va le voir au niveau du code, ce sera beaucoup plus simple.

Donc ça c'est à retenir, c'est au niveau des opérateurs de comparaison et là au niveau des mots qui vont servir pour les conditions multiples.

Et moi, je vérifie que l'identifiant et le mot de passe sont valide donc on va utiliser le mot clé AND donc là, je vais faire ça.
```py
identifiant = "Jason"
mot_de_passe = "password123"

print("Interface de connexion")

user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

if user_id == identifiant and user_password == mot_de_passe:
   print("Vous êtes connectés, bienvenue,", user_id)

print("Je ne suis plus dans le 'if'")
```
Alors je veux que user_id, ce qui a été demandé à l'utilisateur soit égal à l'identifiant et (AND) le mot de passe demandé l'utilisateur soit égal au mot de passe du programme et là, je fait 2 conditions.

Une "user_id == identifiant" et deux "user_password == mot_de_passe" et comme elles doievent être liées ben je met un "and" c'est-à-dire qu'il faut que les 2 soient automatiquement validée. Si il n'y en a qu'une seule qui est validé, ça ne marchera pas, on ne rentrera pas dans la condition. Il faut obligatoirement qu'elles soient toutes validées quand on a le AND.

Donc là, je relance et voilà si je note n'importe quoi mais que je note le bon mot de passe.
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : zzzff
Entrez votre mot de passe : password123
Je ne suis plus dans le 'if'
```
Evidemment, je ne vais plus rentrer dans la condition, ça paraît évident, je suis obligé dans ce cas-là d'avoir Et le bon identifiant, Et le bon mot de passe, voilà  obligatoire puisqu'on a fait une double condition.
```
>python main.py
Interface de connexion
Entrez votre identifiant : Jason
Entrez votre mot de passe : password123
Vous êtes connectés, bienvenue, Jason
Je ne suis plus dans le 'if'
```
Donc si vous faites Or par contre ça changerait tout.
```py
identifiant = "Jason"
mot_de_passe = "password123"

print("Interface de connexion")

user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

if user_id == identifiant or user_password == mot_de_passe:
   print("Vous êtes connectés, bienvenue,", user_id)

print("Je ne suis plus dans le 'if'")
```
Là, ça voudrait dire donc qu'on peut avoir que l'un des 2 qui soit bon, ce qui serait un peu bizarre pour mon exemple mais c'est pour montrer que ça fonctionne donc là si je note un mauvais identifiant mais que le mot de passé est bon, ça marche, d'accord.
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : nznzefef
Entrez votre mot de passe : password123
Vous êtes connectés, bienvenue, nznzefef
Je ne suis plus dans le 'if'
```
Et si je note le bon identifiant mais le mauvais mot de passe, ça marche aussi.
```powershell
>python main.py
Interface de connexion
Entrez votre identifiant : Jason
Entrez votre mot de passe : ezezez
Vous êtes connectés, bienvenue, Jason
Je ne suis plus dans le 'if'
```
Donc vous voyez c'est super important, ça c'est une erreur que font beaucoup de débutants en programmation d'ailleurs, c'est pour ça que j'insiste dessus. Souvent, ils ne savent pas lequel utiliser quand ils font plusieurs conditions, comme ça, multiples s'il doivent dire ET ou OU parce ce qu'on ne sait pas trop en fait.

Donc OU, c'est bien là OU l'autre OU encore un autre. On peut avoir autant de choses que vous voulez pour en avoir 10, si vous voulez même, il n'y a pas de souci. A partir du moment où il y a une seule des conditions de toute votre liste qui est bonne, qui fonctionne, vous allez entrer dans la condition.

Si ce sont que des AND, que des ET, il faudra que toutes les conditions soient valides, absolument toutes. S'il y en a qu'une seul qui n'est pas validé, ça ne marchera pas.

Ensuite, on termine avec le IN que je vous ai pas dit. On va prendre un autre exemple, je vais virer tous l'exemple ici. Je vais faire "lettre_hasard" même si c'est pas au hasard lorsque moi qui vais la noter en dur mais c'est encore une fois pour l'exemple. Je vais prendre un "b", par exemple.

```py
lettre_hasard = "b"
```

Et je vais faire tout simplement ça, IF, la lettre au hasard est dans, donc IN, est dans un semble de quelque chose donc là je vais mettre, par exemple, "aeiouy" par exemple. Eh bien je vais dire que c'est une voyelle, d'accord, tout simplement.
```py
lettre_hasard = "b"
if lettre_hasard in "aeiouy":
   print("C'est une voyelle")
```
On va tester et évidemment ça ne va pas afficher que c'est une voyelle puisque c'est une consonne.
```powershell
>python main.py
```
Donc vous voyez qu'il ne se passe absolument rien, d'accord, donc ça c'est une possibilité.

Maintenant si j'inversais bah là ça fonctionnerait ... NOT IN, si ce n'est pas, d'accord, et on affichera que c'est consonne.
```py
lettre_hasard = "b"
if lettre_hasard not in "aeiouy":
   print("C'est une voyelle")
```

On peut faire la condition inverse.
```powershell
>python main.py
C'est une voyelle
```
Voilà il vous affiche bien, c'est une consonne par contre il faut changé ce qui est affiché à la condition. Par contre faut changé ce qui est affiché à la condition.

Donc ça c'est une possibilité encore une fois, qui est DANS, PAS DANS quelque chose et cetera.

On pourra après évidemment faire un test sur d'autres choses, par exemple ici ce qu'on appelle une séquence.

Une séquence bah c'est ça "aeiouy" en fait, c'est une chaîne de caractères et si la lettre là "b", elle existe dans cette liste de lettres donc cette liste de caractères, ça va fonctionner, on verra qu'on pourra faire des IN, en fait, dans des dictionnaires, dans des tuples, on va faire ça dans pas mal de petites choses, dans des listes également.

Mais comme on a pas encore vu ça, en tout cas au niveau où vous êtes à l'heure actuel, je ne vais pas vous montrer mais on aura l'occasion de revenir dessus.

Donc si vous voulez, on complétera cette séance sur les conditions avec les nouvelles connaissances, les nouvelles choses que vous aurez appris par la suite.

Donc ça, vous pouvez retenir c'est que le IN / NOT IN permet de vérifier par exemple que dans la variable, on a l'information qui est contenu dans autre chose donc là ici une chaîne de caractère, c'est plus simple de progresser comme ça.

Alors moi j'aimerais avoir ceci et de dire donc si c'est une voyelle, il m'affiche c'est une voyelle et si c'est une consonne, il m'affiche c'est une consonne.

```py
lettre_hasard = "b"

if lettre_hasard in "aeiouy":
   print("C'est une voyelle")
   
if lettre_hasard not in "aeiouy":
   print("C'est une consonne")
```
On pourrait être tenté de faire un 2e test comme ceci, de dire ben tient si lettre_hasard du coup n'est pas là dedans "aeiouy", du coup, c'est une consonne.

Ca fonctionnerait si vous regardez bien après vous faites le test inverse. 
```powershell
>python main.py
C'est une consonne
```
Voyez il affiche que c'est une consonne.

Si je change en "i" par exemple.

```py
lettre_hasard = "i"

if lettre_hasard in "aeiouy":
   print("C'est une voyelle")
   
if lettre_hasard not in "aeiouy":
   print("C'est une consonne")
```
```powershell
>python main.py
C'est une voyelle
```
Le terminal m'affiche bien c'est une voyelle, ça fonctionne, par contre on fait de la répétition, on répète ... on fait deux conditions surtout. C'est pas grand chose sur la même chose.

Donc ça on peut re procéder à une condition un peu plus complexe c'est-à-dire que je vais faire IF donc si, ça se traduit comme ça en anglais. SI lettre_hasard est dans "aeiouy", tu affiches c'est une voyelle. Moi j'aimerais quelque chose qui permet de dire sinon, si je ne rentre pas dans cette condition, qu'est-ce que je fais.

Pour faire le sinon en programmation, on va utiliser le mot clé ELSE comme ceci et vous noté deux-points également.

```py
lettre_hasard = "i"

if lettre_hasard in "aeiouy":
   print("C'est une voyelle")
else:
   print("C'est une consonne")
```

Donc là, il n'y a pas de condition d'accord. Ici pour ELSE tout court, on ne fait rien du tout. C'est si, on ne rentre pas là-dedans "if lettre_hasard in "aeiouy":" alors on fait autre chose. Le autre chose, moi, c'est print("C'est une consonne").

C'est une consonne voilà et là vous prenez tous les cas de figure, vous êtes obligés de rentrer dans une des conditions soit dans le IF soit dans le ELSE, c'est obligatoire.

Parce que le ELSE c'est ce qu'il se passe au cas où vous ne rentrez pas dans le IF donc c'est un petit peu la roue de secours, voilà.
```powershell
>python main.py
C'est une voyelle
```
C'est une voyelle évidemment, si je mets autre chose "t", n'importe quoi, il ne va pas rentrer dans le IF donc il rentre dans le ELSE en disant que c'est une consonne, voilà."""
```py
lettre_hasard = "t"

if lettre_hasard in "aeiouy":
   print("C'est une voyelle")
else:
   print("C'est une consonne")
```
```powershell
>python main.py
C'est une consonne
```
Ca c'est une possibilité.

Maintenant euh qu'est-ce que je pourrais dire ? On va prendre un autre exemple, on va prendre un âge, par exemple. On va mettre 24.
```py
age = 24
```

On va faire une triple condition avec un autre mot clé donc les mots clés, je rappelle globallement, on aura IF, on en aura un qui est ELIF et on aura vu le ELSE. Ce sont les 3.

```py
"""
    Opérateurs de comparaison       :   == (égal à)
                                        != (différent de)
                                        < (plus petit que)
                                        > (plus grand que)
                                        <= (plus petit ou égal à)
                                        >= (plus grand ou égal à)
                                        
    Mots clés des conditions        :   if / elif / else 
    
    Conditions multiples            :   and (ET)
                                        or (OU)
                                        in / not in (DANS / PAS DANS)
"""
```

ELIF ça va tout simplement vouloir dire sinon si alors dans quelle cas, c'est utile ? Ben par exemple tiens si (IF) tu as plus de 50€ alors tu peux avoir ça sinon  si tu as plus de 20€ mais pas du coup moins de 50€ pour l'exemple alors tu peux faire ça (ELIF) et sinon (ELSE), si tu n'as aucun des 2 cas-là, tu veux faire quelque chose.

Donc on va le faire avec l'âge, on va dire.
```py
age = 24

if age == 18:
   print("Tu viens d'être majeur.")
elif age == 50:
   print("Tu viens d'avoir 50 ans.")
elif age == 60:
   print("Tu viens d'avoir 60 ans.")
else:
   print("Tu as", age, "ans.")
```
On va dire Si age == 18... Sinon ... et on peut mettre autant de ELIF que l'on veut. Je vais vous en mettre un autre et ELSE ça comprend tous les autres âges, les âges de 1 à 17 et les âges de 19 à 49 et de 51 à 59 et de 61 à je ne sais pas combien. Voilà comme ça, on affichera les âges.
```powershell
>python main.py
Tu as 24 ans.
```
Là automatiquement, si j'exécute mon programme alors voilà donc là, il me dit tu as 24 ans parce qu'effectivement je ne rentre ni dans cette condition là age == 18 ni dans celle là age == 50 ni dans celle là age == 60. Vous voyez, il fait il fait IF, ELIF, ELIF, ELSE donc ça c'est tout cela, c'est toute une structure, en fait, conditionnel à elle-même.

Il y a une seule structure conditionnelle composez ici de 4 conditions.

On fait 3 tests, en réalité, il y en a un, voilà, le test de secours au cas où si jamais on rentre dans aucune d'elles.

Donc là évidemment si je me disais 18, je vais rentrer dans le IF.
```py
age = 18

if age == 18:
   print("Tu viens d'être majeur.")
elif age == 50:
   print("Tu viens d'avoir 50 ans.")
elif age == 60:
   print("Tu viens d'avoir 60 ans.")
else:
   print("Tu as", age, "ans.")
```
```powershell
>python main.py
Tu viens d'être majeur.
```

Voilà, tu es majeur si je mets 60 bah je vais rentrer dans le 2e ELIF.
```py
#age = 60
#
#if age == 18:
#    print("Tu viens d'être majeur.")
#elif age == 50:
#    print("Tu viens d'avoir 50 ans.")
#elif age == 60:
#    print("Tu viens d'avoir 60 ans.")
#else:
#    print("Tu as", age, "ans.")
```
```powershell
>python main.py
Tu viens d'avoir 60 ans.
```
Je viens d'avoir 60 ans et si je mets 50 je vais rentrer dans le premier ELIF.
```py
age = 50

if age == 18:
   print("Tu viens d'être majeur.")
elif age == 50:
   print("Tu viens d'avoir 50 ans.")
elif age == 60:
   print("Tu viens d'avoir 60 ans.")
else:
   print("Tu as", age, "ans.")
```
```powershell
>python main.py
Tu viens d'avoir 50 ans.
```
Voilà comme ça on peut gérer différents cas de figure en fait au niveau d'un programme et c'est vraiment très très pratique de procéder ainsi.

Donc vraiment, bien me retenir IF, le ELIF et le ELSE, c'est 3 mots clés que vous avez retenir au niveau des structures conditionnelles en python.

Dans d'autres langages, on pourrait en avoir plus mais ici on a ceux là, comme ça, on a grosso modo tout ce qu'il nous faut.

Maintenant qu'on a vu ça, je vous ais montrer les opérateurs de comparaison, les mots-clés, on a vu comment faire des conditions multiples.

On pourrait éventuellement parler un petit peu, c'est un cas particulier au niveau des valeurs booléennes.

Je vous avais montrer dans les variables , vous pouvez avoir quelque chose égale True.

```py
jeu_charge = True
```

Voilà ce genre de choses.

C'est une varianble qui dit que par défaut, le jeu est Chargé Alors True, ça veut dire vrai, je vous le rappelle, c'est égal à 1 d'accord, c'est donc égal à 1 en informatique.

```py
jeu_charge = True # True = vrai (=1)
```

Quand c'est False, c'est faux, c'est égal à 0, c'est un petit rappel.

Ca on peut faire effectivement quelques petites choses dessus c'est-à-dire que pour faire mon test, je peux très bien faire ça.
```py
jeu_charge = True # True = vrai (=1)

if jeu_charge:
```

Donc là, j'utilise même pas d'opérateur de comparaison. Je ne vais pas m'amuser à faire forcément égal égal à True ou alors égal égal à 1.

```py
jeu_charge = True # True = vrai (=1)

if jeu_charge == True:

if jeu_charge == 1:
```
ça sert à rien puisque en faisant ça...

```py
jeu_charge = True # True = vrai (=1)
if jeu_charge:
```
...donc je sous-entends, je teste si jeu_charge est égal à 1 donc qui vrai.

Donc on affiche que le jeu est en marche et puis on a qu'à faire un petit sinon "Le jeu a été quitté" par exemple.

```py
jeu_charge = True # True = vrai (=1)

if jeu_charge:
   print("Le jeu est en marche")
else:
   print("Le jeu a été quitté")
```
Voilà on teste.
```powershell
>python main.py
Le jeu est en marche
```
Là, il met que le jeu est en marche. C'est éffectivement le cas. Il met que le jeu a été quitté voilà donc c'est important de le faire comme ça.

Si je fais l'inverse, un peu bizarre de dire comme ça mais c'est pas grave. Je peux mettre le mot NOT qu'on a vu tout à l'heure.

```py
jeu_charge = False

if not jeu_charge:
   print("Le jeu est éteint")
else:
   print("Le jeu est lancé")
```

IF NOT, si n'est pas voilà donc la suite n'est pas égal à 1 donc est égal à 0.
```powershell
>python main.py
Le jeu est éteint
```
Là comme c'est False, il dit que le jeux est éteint, d'accord.

Donc c'est un mot clé, on peut l'utiliser sans problème donc on ne va pas faire NOT IN, on va simplement mettre le mot clé NOT pour dire que ce n'est pas.

Donc c'est l'inverse en fait de "quand c'est", "quand c'est", c'est juste ça et "quand ce n'est pas", on met NOT, tout simplement comme on le ferait en anglais en fait.

"est" ou "n'est pas", tout le monde comprend très bien ça donc c'est relativement simple, on arrive très bien à l'adapter ensuite en programmation avec le langage Python.

Il a ce gros avantage là a, c'est qu'au niveau de la syntaxe il est vraiment vraiment vraiment très facile à apprendre et assimiler.

On terminera pour cette vidéo sur les conditions avec un dernier petit point, c'est une petite astuce, un petit plus pour vous qui n'est pas obligatoire. Il y a des développeurs qui font très bien sans mais c'est bien de le savoir, c'est lorsque, par exemple, je veux tester, que notamment j'ai des valeurs à tester sur des fourchettes...

Qu'est-ce que ça veut dire ? bah moi je sais pas ben pour l'âge qui est quand même un très bon exemple. On va faire un input().

```py
age = input("Quel âge as-tu ? ") 
```

Ensuite on va mettre int() parce qu'on va caster, je vous rappelle, l'âge pour être sûr d'avoir un nombre pour éventuellement faire des calculs avec je sais pas trop quoi mais bref voilà.
```py
age = input("Quel âge as-tu ? ") 
age = int(age)
```
Et du coup, on peut faire une vérification.
```py
age = input("Quel âge as-tu ? ") 
age = int(age)

if age > 0 and age < 100:
    print("L'âge est validé")
```
Si âge plus grand que 0 et âge plus petit que ... allez admettons maintenant que dans notre exemple même si serait un peu bizarre qu'on estime que l'âge ne peux pas dépasser 100 ce qui serait un peu bizarre dans la vraie vie, voilà.
```py
age = input("Quel âge as-tu ? ") 
age = int(age)

if age > 0 and age < 100:
   print("L'âge est validé")
else:
   print("L'âge est incorrect")
```
"L'âge est validé" et sinon évidemment, on mettra que l'âge ne l'ai pas, et là "L'âge est incorrect", voilà automatiquement.
Donc ça, je vais tester.
```powershell
>python main.py
Quel âge as-tu ? 12
L'âge est validé
```
Voilà quel âge as-tu ? 12. il met que l'âge est validé.

Si je met 0, il met que c'est incorrect, bien sûr.
```powershell
>python main.py
Quel âge as-tu ? 0
L'âge est incorrect
```
Si je mets même moins 4, c'est incorrect. 
```powershell
>python main.py
Quel âge as-tu ? -4
L'âge est incorrect
```
Si je met plus 200. Il vous met que c'est Incorrect.
```powershell
>python main.py
Quel âge as-tu ? 200
L'âge est incorrect
```
Si je mais 100 tout pile, il vous met que c'est incorrect.
```powershell
>python main.py
Quel âge as-tu ? 100
L'âge est incorrect
```
... parce que je n'ai pas pris en compte le 100 donc on va mettre comme ça (<=100), d'accord c'est important.
```py
age = input("Quel âge as-tu ? ") 
age = int(age)

if age > 0 and age <= 100:
   print("L'âge est validé")
else:
   print("L'âge est incorrect")
```
Voilà, là, j'ai validé, OK.
```powershell
>python main.py
Quel âge as-tu ? 100
L'âge est validé
```
Donc ça "age > 0 and age <= 100" par contre c'est un petit peu lourd parce que vous voyez on utilise 2 opérateurs comparaisons, ça peut être assez long comme condition à tester et surtout source d'erreur car souvent on peut se tromper comme ça quand on a beaucoup de symboles, beaucoup de signes. On a vite fait de se tromper de signe comme là (<=100), par exemple, pour moi c'est tout bête mais j'avais pas mis, tout de suite, le égal. Du coup, je prenais pas le 100. On le voit après quand on teste son programme, on se rend vite compte qu'on a fait une petite boulette mais c'est quand même bien d'éviter au maximum ce genre de syntaxe, qui peut être des fois assez trompeuse.

Du coup, nous on va faire une fourchette c'est-à-dire que quand vous avez par exemple à tester une variable entre un minimum et un maximum comme la, entre 0 et 100 inclus, on peut l'écrire autrement c'est-à-dire que ce genre de chose par exemple...

Donc je vais noter en commentaire Voilà donc âge plus grand que 0 et âge plus petit ou égal à 100 (age > 0 ET age <= 100), ça peut également s'écrire 0 qui es plus petit que age qui est plus petit ou égal à 100 (0 < age <= 100). 
```py
age = input("Quel âge as-tu ? ") 
age = int(age)
```
age > 0 ET age <= 100 --> 0 < age <= 100
```py
if 0 < age <= 100:
    print("L'âge est validé")
else:
    print("L'âge est incorrect")
```
Là donc, on va tout simplement faire une fourchette, comme ça, de valeur voilà.
Pour dire que âge doit être compris entre 0 et 100 inclus et là c'est exactement la même chose. Si je fais ça, il va être validé.
```powershell
>python main.py
Quel âge as-tu ? 100
L'âge est validé
```
Si je met par contre 0, il va me dire que c'est incorrect donc on obtient les mêmes résultats bien évidemment par contre l'interface et enfin la présentation est beaucoup plus propre, on n'a pas de AND déjà donc on enlève le mot de la condition multiple. On a toujours nos opérateurs de comparaison bien évidemment pour pouvoir définir la fourchette mais du coup on a la variable qui est au milieu et on a le minimum en fait et le maximum, c'est très pratique, comme ça.

Je trouve que c'est beaucoup plus clair de procéder comme ça donc voilà, ça c'était la petite astuce pour vous puissiez faire de petites fourchettes de valeur quand vous testez une variable, par exemple, comme ici dans une condition.

On va s'arrêter là pour cette vidéo sur les conditions.

Dans la prochaine on parlera des boucles donc c'est une autre petite notion très très simple qui va fonctionner de pair avec celle-ci et on pourra comme ça abordé la modularité notamment l'utilisation et la découverte des fonctions en python.

Moi je vous dis à très bientôt pour une prochaine vidéo.

Tchao

```py
###############################################
#################### Resume ################### 
###############################################

#coding:utf-8

#   Python #5 - conditions
#   https://www.youtube.com/watch?v=T_AsJ0nIeh0&list=PLrSOXFDHBtfHg8fWBd7sKPxEmahwyVBkC&index=5
#   En informatique, il est possible d'effectuer des tests de comparaison, pour effectuer des traitements spécifiques quand des conditions sont validées. Voici les structures conditionnelles en Python :) !

"""
Les structures conditionnelles, c'est la façon d'éffectuer des test sur des variables puis
d'éffectuer des traitements suivant les résultats obtenus.

Les vidéos 3 et 4 ont pour sujet les variables et les opérateurs pour éffectuer des calculs
dont le résultat est stocké dans une variable. Dans ce cadre, il n'y a pas toujours une variable.
On utilise parfois la valeur en dure comme résultat d'un calcul dynamique dans la situation où
l'on veut éxécuter quelques tests. 

Par exemple, un système d'authentification.
"""
#1# Opérateurs de comparaison.
## Créer un système d'authentification. ##
identifiant = "Jason"
mot_de_passe = "123" # mot de passe en dur. Pas sécurisé.
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")
# Le mot de passe entré doit correspondre au mdp définis par le programme.
# La condition, c'est vérifier que ce qui est demandé à l'utilisateur correspond au mdp du programme.
if user_password == mot_de_passe: # Test avec un opérateur de comparaison et : pour terminer le test (comme en C++).
    print("Vous êtes connectés, bienvenue", user_id) # La tabulation est importante dans le if car Python n'utilise pas d'accolade mais des tabulations.
# Si la condition est validé, on éxécute tout ce qui suit les deux points avec une tabulation.
print("Je ne suis plus dans le 'if'") # fonction en dehors du if puisqu'on ne fait pas de tabulation.

"""
Selon que le test est validé ou pas, on entre dans la condition ou pas et pour 
cela on utilise des opérateurs de comparaison :
    ==      égal à (= est réservé pour l'affectation ou le retour de fonction)
    !=      différent de
    <       plus petit que
    >       plus grand que
    <=      plus petit ou égal à
    >=      plus grand ou égal à
Si on veut que les deux informations d'authentifications soient correctes, on peut
faire des conditions multiples :
    and         et (ça et ça sont validés)
    or          ou
    in/not in   dans/pas dans
"""
#2# Conditions multiples.
## vérifier que le mot de passe et l'identifiant sont valides. ##
identifiant = "Jason"
mot_de_passe = "123"
print("Interface de connexion")
user_id = input("Entrez votre identifiant : ")
user_password = input("Entrez votre mot de passe : ")

# AND
# Les 2 tests doivent être validés pour rentré dans la condition.
# Avoir le bon identifiant et le bon mot de passe est obligatoire.
# Toutes les conditions doivent être valide.
# Si une seule n'est pas valide, ça ne fonctionne pas.
if user_id == identifiant and user_password == mot_de_passe:
    print("Vous êtes connectés, bienvenue", user_id)

# OR
# Avoir une des deux conditions validée est obligatoire.
# Si un seul des éléments est validé, on rentre dans la condition.
if user_id == identifiant or user_password == mot_de_passe:
    print("Vous êtes connectés, bienvenue", user_id)

# IN
# Teste si une lettre est dans une séquence.
# On peut faire des IN dans des listes, des dictionnaire.
lettre_hasard = "b"
if lettre_hasard in "aeiouy": # Une séquence est une chaine de caractères.
    print("C'est une voyelle")

# NOT IN
# Teste si une lettre n'est pas dans une séquence.
# C'est la condition inverse.
if lettre_hasard not in "aeiouy":
    print("C'est une consonne")

#3# Mots clés des conditions.

# ELSE
# On fait de la répétition de conditions alors qu'on peut procéder à une condition un peu plus complète.
# On rentre obligatoirement dans le if ou dans le else.
lettre_hasard2 = "b"
if lettre_hasard2 in "aeiouy":
    print("C'est une voyelle")
else :
    print("C'est une consonne")

# IF / ELIF / ELSE
# Triple conditions avec les mots clés if / elif / else. 
# Elif signifie 'sinon si'.
# Cela permet de gérer différents cas de figures dans un programme.
age = 24
# Ci après une structure conditionnelle composé de 4 conditions.
if age == 18:
    print("Tu viens d'être majeur.")
elif age == 50:
    print("Tu viens d'avoir 50 ans.")
elif age == 60:
    print("Tu viens d'avoir 60 ans.")
else:
    print("Tu as", age, "ans.")


#4# Particularité des valeurs booléenne.

# <valeur bool>
jeu_charge = True # variable qui dit que par défaut le jeu est chargé (true = vrai (= 1)).
if jeu_charge: # Pas besoin d'opérateur de comparaison. On sous entend que jeu_charge est vrai.
    print("Le jeu est en marche.")
else:
    print("Le jeu a été quitté.")

# NOT
# Conditions inverses.
if not jeu_charge:
    print("Le jeu a été quitté.")
else:
    print("Le jeu est en marche.")

#5# Valeur a testé sur des fourchettes.
"""
Il est recommandé d'utiliser une fourchette plutôt qu'une syntaxe trop longue :
if age > 0 and age <= 100   -->   if 0 < age <= 100  
"""
age = input("Quel âge as-tu ? ")
age = int(age) # caster l'âge pour être sûr d'avoir un nombre.
#if age > 0 and age <= 100 : # Syntaxe de conditions long a tester et source d'erreur.
if 0 < age <= 100 : # Syntaxe plus propre (pas de AND) avec les opérateurs de comparaison et la variable au milieu.
    print("L'âge est validé.")
else:
    print("L'âge est incorect.")
```