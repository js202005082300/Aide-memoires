# [11. Classes et attributs](https://www.youtube.com/watch?v=91dPooHyNIo)

+ [Créer une classe](#Créer-une-classe)
+ [Créer un constructeur](#Créer-un-constructeur)
+ [Créer une instance](#Créer-une-instance)
+ [Créer une 2e instance](#Créer-une-2e-instance)
+ [Créer des attributs](#Créer-des-attributs)
+ [Accéder à un attribut](#Accéder-à-un-attribut)
+ [Définir des attributs](#Définir-des-attributs)
    + [Définir des attributs en paramètre du constructeur](#Définir-des-attributs-en-paramètre-du-constructeur)
    + [Définir des attributs par défaut en paramètre du constructeur](#Définir-des-attributs-par-défaut-en-paramètre-du-constructeur)
+ [Créer un attribut de classe](#Créer-un-attribut-de-classe)
+ [Resume](#Resume)

Bonjour et bienvenue pour la séance numéro 11 sur python.

La dernière fois, vous vous rappeler, je vous avait fait une petite pause, en fait, sur la formation avec une vidéo un peu théorique pour vous présenter toutes les notions qu'on aura l'occasion de voir avec le programmation orienté objet.

Je vous avais dit qu'on allait comme ça, pouvoir voir les choses au fur et à mesure pour que ce soit mieux aborder, que ce soit beaucoup plus simple pour vous puisque on attaque une partie déjà un petit peu plus avancé que tout ce que vous avez vu jusqu à présent et que c'est mieux, de voilà, de procéder par étapes plutôt que d'aller trop vite.

Donc on va commencer par quelques petites choses, je vais reprendre un petit peu les notes que j'avais fait la dernière fois sur la présente vidéo pour que vous puissiez, un petit peu, voir certains termes que l'on va pouvoir tout simplement présenté dans cette vidéo-là, dans cette séance.

```py
"""
    ------------------------------------------------------------
    La programmation orienté-objet (POO) avec le langage Python
    ------------------------------------------------------------

    Classe 	    : plan de conception, genre (ex : Humain)
    Objet 	    : instance de classe (ex : Julien)
    Attribut 	: variable de classe (ex : prénom, age, sexe, taille, …)
"""
```

Donc on va parler évidemment des classes puisqu'on va commencer notre première vidéo sur l'objet. On va parler d'objets bien sûr ça ça va de soi et on va parler d'attributs également par la suite.

Vous vous rappeler, je fait un petit rappel très rapidement. Je vous avez dit que classe, en fait, c'était un plan de conception. 

Un petit peu pour dire par exemple : "bah tiens comment on pourrait fabriquer un humain ?". Volà, un humain peut être une classe et à partir de là on peut créer des objets donc on peut instancier une classe. Par exemple, créer un personnage qui s'appellerait Julien.

Un Julien en fait qui serait donc notre objet de classe humain ou un autre et cetera, voilà, on pourrait créer, instancier plusieurs objets.

Et là, ces objets, nous pourrions la compléter en leur rajoutant des attributs. Je vous avez dit qu'un attribut, c'était une variable de classe. En fait, c'est quelque chose qui permet tout simplement de le définir, en fait, voilà. Donc qu'est-ce qu'on pourrait donner un humain ? qu'est-ce qu'un humain peut avoir ? il peut avoir un prénom, il peut avoir un âge, une taille, un genre et cetera.

On peut rajouter plusieurs choses comme ça et ça permet de définir des attributs.

Donc on va se contenter de vous voir un petit peu tout ça dans cette vidéo là. Il y aura d'autres choses par la suite qu'on verra pour la prochaine vidéo et ainsi de suite pour pas que ça fasse trop trop lourd, en fait, d'un coup mais qu'on puisse voir au fur et à mesure comme je le disais au début.

## Créer une classe

On va directement commencer ici.

```py
#coding:utf-8

```

Et on va créer notre classe donc on va reprendre l'exemple de la classe humain alors pourquoi, parce que là c'est quelque chose qui est utile partout qui est suffisamment complet, comme exemple, je pense et qui sera assez clair pour tout le monde. Normalement, on saura de quoi on parle, ce sera je pense suffisament clair pour vous.

La meilleure méthode, en tout cas le moyen pour créer une classe, on va tout simplement utiliser un mot clé du langage qui est le mot class, en anglais bien sûr toujours pareil, pour pouvoir montrer que nous allons définir... je vous rappele que quand on faisait une fonction on utilisait le mot clé def, d'accord, pour define qui permet de dire je vais définir une fonction que je pourrais utiliser par la suite.

Là on va utiliser le mot-clé class. Tiens voilà, on va créer une classe. 

```py
#coding:utf-8

class
```

On va te donner un nom et par convention, on lui met une majuscule, d'accord, c'est simplement pour pouvoir les repérer facilement. On met une majuscule au début du nom de la classe et si jamais vous avez plusieurs mots pour définir cette classe. Par exemple, si votre classe, elle s'appellait UnHumain, et bon, on aurait plus tendance a marquer comme ceci.

```py
#coding:utf-8

class UnHumain
```

C'est-à-dire qu'on met une majuscule, en fait, à chaque début, vous voyez, de nouveaux mots, tout attaché bien sûr, pas d'espace, on évite le underscore parce que ce n'est pas forcément joli joli ou pratique pour les classes.

```py
#coding:utf-8

class Un_Humain
```

Les underscore, on peut en avoir, ça empêche pas, il y en a qui le font, vous faites absolument comme vous voulez mais je vous dis dans l'idéal, comme ça, c'est suffisamment lisible. On peut se contenter de ça, c'est très bien comme ça.

Donc là, on va faire au plus simple, on va faire une classe Humain, voilà, tout simplement.

```py
#coding:utf-8

class Humain
```

Et comme le langage python n'utilise pas d'acolades comme d'autres langages, on n'oublie pas les : comme pour la définition d'une fonction.

```py
#coding:utf-8

class Humain:
```

Et là, à la ligne avec la petite tabulation, on va pouvoir définir notre classe, voilà tout simplement, c'est juste ça, d'accord, absolument juste ça.

Là, on va définir, alors on y viendra plus tard. On va définir une méthode un peu particulière, on parlera des méthodes dans la vidéo suivante ou peut-être une prochaine d'après, pas pour tout de suite, on va éviter de trop avancer sur cette vidéo, là, mais il y a une méthode très spécial que nous allons voir qui s'appelle le constructeur. 

Je vous avait dit qu'une classe, c'était tout simplement un schéma, un peu de conception ... comment tu fabriquerai un humain ? et Ben voilà, la classe te permet d'en créer. Ou un animal ou ça peut être un gestionnaire pour un jeu vidéo, ça peut être la fenêtre, par exemple, de votre interface graphique. Tout ce genre de choses ce sont des classes, que vous pouvez retrouver dans un logiciel, un programme, un jeu vidéo ou je ne sais quoi encore.

Donc on a une petite méthode particulière qui va s'appeler init donc c'est ... vous verez, on aura l'occasion d'aborder cette méthode un peu particulière puisqu'il y en a plein d'autres mais on va se contenter de celle là qui va faire office de constructeur.

Elle va permettre de construire des objets donc d'instancier des classes en créant des objets.

On va faire comme pour la création d'une fonction, les méthodes, on va les définir pareil, on va utiliser le mot clé def.

Alors, par contre, une petite indication en fait, on va mettre comme ça, 3 petits double guillemets, vous pouvez en mettre d'autres et vous pouvez comme ça, mettre une petite définition en fait pour votre votre classe.

```py
#coding:utf-8

class Humain:
"""
        
"""
```

On aura l'occasion aussi d'en parler dans une vidéo annexe mais vous pouvez, comme ça, faire une petite description de votre classe, d'accord.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
```

"Classe des êtres humains" alors c'est un peu pas forcément utile  comme DocString mais peu importe.

Pourquoi une docstring ? en fait, c'est une chaîne de documentation qui va permettre de documenter votre code mais je ferai une vidéo annexe, je pense, un tutoriel, en tout cas, qui sera disponible pour voir les docstring pour comprendre un peu comment ça fonctionne. 

C'est peut-être même déjà en ligne à l'heure où je fais cette vidéo parce que rappelez-vous que je fais des vidéos pour que ce soit à jour, en tout cas, dans plusieurs mois, plusieurs années donc peut-être que d'ici là, la vidéo est déjà en ligne sur la chaîne et vous pouvez retrouver comme ça des docstring, à quoi ça sert ? comment documenter son code ? donc on va juste se contenter de ça.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
```

### Créer un constructeur

On va faire quelque chose de très simple et on va créer le constructeur, on utilise le mot clé def, comme on le ferait pour une fonction, comme vous l'avez vu donc je recommande bien évidemment de bien être à l'aise avec toutes les anciennes vidéos. Ca va de soi sinon vous allez galérer un petit peu pour tout ce qui est objet.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def
```

Et on va lui mettre un double underscore, rappelez-vous c'est le souligné, donc le tirer en fait 8. J'insiste bien, il y en a bien 2, d'accord, c'est pour ça qu'il est long. C'est pas un seul symbole, en fait, c'est vraiment deux, d'accord. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __
```

Il y a 2 caractères ... parce qu'on me l'avais déjà demandé, ça une fois, dans un commentaire et enfin, je mets le mot-clé init et je remets un double underscore, voilà. 

```py
#coding:utf-8

class Humain:
    ""
    Classe des êtres humains
    ""
    def __init__()
```

J'ouvre des parenthèses comme pour une fonction et je vais mettre un petit paramètre "self" ... je vais en parler après ... et on met les deux-points, voilà, comme pour la création d'une fonction.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
```

Et là, je vais mettre le mot "pass" pour dire : "voilà, bah en fait, tu ne fait rien, tout simplement, on va rester là et on va quitter la classe, d'accord".

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        pass
```

Rappelez-vous, ici, là on n'est plus dans la classe parce qu'on n'est plus sur tout ce qui est en tabulation.

Tout ce qui est en tabulation fait partie de la classe dès qu'on revient en retrait, on n'est plus dedans donc là, ici, faites par exemple, "Lancement du programme...", voilà, et on pourra créer une classe.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       pass

print("Lancement du programme...")
```
Alors si je teste, bien sûr, comme ça parce qu'on va commencer par tester directement, voilà.
```powershell
>python main.py
Lancement du programme...
```

Donc là, on voit bien que le programme s'est lancé, il ne s'est rien passé, bien évidemment, je n'ai fait que définir.

C'est comme pour une fonction, j'ai défini une classe comme j'aurai définit une fonction mais je n'ai jamais appelé cette classe ou je n'ai jamais créé d'instance.

Donc voilà, c'est bien, on a défini la chose mais ce n'est pas tout.

Maintenant qu'on a un petit peu notre petite boîte, d'accord, on a notre petite boîte avec notre constructeur de cette boîte donc d'Humain, en l'occurrence. On aimerait pouvoir instancier, on va donc créer un objet qui sera de classe Humain et cet objet, on va le stocker dans une variable parce que c'est à dire que en créant l'objet, je vais vous l'expliquer un petit peu après, on va en fait créer une instance.

## Créer une instance

Cette instance va être stockée dans une variable et cette variable pourra être utilisé pour faire pas mal de choses après avec.

Donc nous, on va appeler justement Julien alors faut pas forcément utiliser ça parce que, si en plus plus tard ... c'est un attribut le prénom ... puis qu'on veut changer de prénom, appeler une variable Julien, c'est un petit peu bizarre, en fait.

Donc je ne vais même pas l'appeler comme ça. Je vais l'appeler, par exemple, h1 pour humain numéro un, par exemple, parce que je n'ai pas beaucoup d'idée, on va dire pour le nom.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        pass

print("Lancement du programme...")

h1 =
```

Et on va, tout simplement, mettre le nom de la classe et les parenthèses, d'accord, tout simplement.
```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       pass

print("Lancement du programme...")

h1 = Humain()
```
Là, je lui dis dans h1, tu fais appelle, en fait, à Humain, d'accord, c'est une classe. Il va la reconnaître puisqu'elle est définie avant.

Et là, je vais appeler.
```powershell
>python main.py
Lancement du programme...
```

Alors vous ne voyez rien puisque je ne fait que "pass" au niveau du constructeur donc si on va être plus clair donc nous, on va enlever le "pass", du coup, parce qu'on va faire quelque chose.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):

print("Lancement du programme...")

h1 = Humain()
```
On va lui dire, tout simplement, "Création d'un Humain", voilà ... c'est parce qu'on se retrouve dans un système de production de création de robots sauf que là ce sont des êtres humains, c'est un peu étrange, voilà.
```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       print("Création d'un Humain...")

print("Lancement du programme...")

h1 = Humain()
```
Je réexécute le code et vous voyez qu'il passe bien effectivement dans le constructeur. Il crée donc pour Humain.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
```

Donc pour résumer qu'est-ce qui se passe ? quand vous faites ceci "Humain()", on fait appel à la classe, d'accord. Il va chercher la fameuse méthode init donc le constructeur. Il va le chercher, il va voir comment il est défini donc là "def __init__(self):", on a mis que self mais je vais vous expliquer ce que c'est.

"self", en fait, c'est tout simplement ce qui cible l'objet lui-même, qu'on est en train de créer.

```py
def __init__(self):
    print("Création d'un Humain...")
```

"print("Création d'un Humain...")", là on fait certaines choses donc là, on fait qu'afficher un petit texte et ensuite ça va rendre ... donc c'est comme ça, même si vous voyez qu'il n'y a pas de return ... le constructeur va rendre self.

Donc c'est-à-dire, il va rendre l'objet que l'on vient de créer et tout ça "Humain()", donc tout ce qui est retourné, l'objet, on va le stocker grâce à l'affectation ici (=) dans h1 qui est notre variable avec laquelle on va pouvoir faire plein de choses par la suite.

Pour le moment, on ne va pas faire grand-chose mais par la suite, se sera très utile.

Voilà, vous savez, en tout cas, comment créer une classe donc la définir et comment instancier une classe en créant un objet, voilà, ici l'objet h1. C'est aussi simple.

Il n'y a pas plus compliqué. En tout cas, on ne peut pas faire plus simple et c'est pas plus compliqué que ça. C'est vraiment vraiment très très simple à mettre en œuvre.

## Créer une 2e instance

Et là, on va va pouvoir travaillez avec ça "Humain()", je peux en créer un 2e, d'accord. Je peux, très bien, créer h2 qui sera un autre humain et vous allez voir que je vais avoir 2 fois la ligne "Création d'un Humain..." puisque j'en crée absolu 2, d'accord.
```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       print("Création d'un Humain...")

print("Lancement du programme...")

h1 = Humain()
h2 = Humain()
```
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Création d'un Humain...
```

"lancement du programme", il en créé 1, il en crée un 2e.

Alors, on ne sait pas qui est qui puisqu'on ne l'a pas détaillé mais il est là, voilà on sait qu'en tout cas il est là donc il n'y a pas de souci.

D'ailleurs, on peut s'amuser à faire ceci : print("Création d'un Humain...", self).
```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       print("Création d'un Humain...", self)

print("Lancement du programme...")

h1 = Humain()
h2 = Humain()
```
Vous voyez, je mets un virgule avec un self et là vous voyez, il vous met des adresses bizarres.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain... <__main__.Humain object at 0x000001E0A6BC7880>
Création d'un Humain... <__main__.Humain object at 0x000001E0A6BC7E50>
```

Alors on voit que ce sont pas tout à fait les mêmes adresses 001E0A6BC7880 et là c'est 001E0A6BC7E50 donc c'est une adresse, en fait, qui permet de vérifier où se trouve l'adresse de l'objet qu'on a créé.

Donc il vous mets __main__, ça c'est parce que c'est le programme principal. On l'avait vu, la dernière fois, ça que "main" c'était le code principal.

Vous voyez que ça apparaît avec des double underscores __main__ et vous mes points humain, qui est un objet, d'accord, qui a donc stocké, en fait, à l'adresse un tel, en mémoire et cetera.

    h1 = Humain()
    h2 = Humain()

Donc on arrive bien comme ça qu'on arrive bien à distinguer les 2, on voit que ce sont pas les mêmes donc il y a bien 2 objets qui ont été créés. C'est pas juste cacher ou de la triche, il y a vraiment 2 objets que nous avons créés, voilà pour ça.

Alors je vais enlever le "self" parce qu'ici ce n'est pas utile, ça sert à rien de l'afficher puisqu'il est retourné, voilà.

Ca c'est la partie définition de classe, création de classes et instanciation pour créer des objets donc vous savez faire ça.

Nous, on va compléter maintenant avec des attributs.

## Créer des attributs

Les attributs, alors de base, un attribut, il va appartenir à une classe, seulement elle, et nom d'Humain, on va lui définir des attributs. Comment on va les définir ? Et bien, on peut les définir dans le constructeur, tout simplement.

Donc on peut dire, par exemple, qu'on va avoir un prénom. Moi, je veux dire par défaut, je vais utiliser self parce que, rappelez vous que self, c'est un peu l'identifiant qui vise, en fait, l'objet que vous êtes en train de créer donc c'est lui-même, c'est moi-même alors sur moi, sur cette objet, qu'est ce que je fais ?

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        print("Création d'un Humain...", self)
        self

print("Lancement du programme...")

h1 = Humain()
h2 = Humain()
```

"self", et bien, je mets un point, je vais définir un attribut. Un attribut, c'est tout simplement une variable qui appartient à une classe, voilà, il n'y a pas à chercher plus loin. C'est juste une variable mais sauf qu'elle appartient à une classe, elle n'est pas comme ça, à se balader n'importe où, voilà. On va mettre "prenom", on va rester avec des noms français exceptionnellement. D'habitude, je fais du code en anglais mais là on va rester sur quelque chose en français pour changer un petit. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        print("Création d'un Humain...", self)
        self.prenom =

print("Lancement du programme...")

h1 = Humain()
h2 = Humain()
```

"=", égal puisqu'on fait une affectation. On va lui donner un nom, d'accord. Je vais mettre par exemple "Jojo", d'accord. self.prenom = "Jojo", Jojo c'est son prénom et on peut lui définir un âge, pourquoi pas. On peut dire que tout nous humains, par défaut, on 1 an, d'accord. On crée des petits humains, tout simplement.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        print("Création d'un Humain...", self)
        self.prenom = "Jojo"
        self.age = 1

print("Lancement du programme...")

h1 = Humain()
h2 = Humain()
```

Et là, vous allez rien voir, bien évidemment, parce qu'on ne verra rien par rapport à ça mais on aura ces attributs.

Alors, on peu s'amuser à l'afficher pourquoi pas... non, on n'affichera plus tard. On va déjà voir ça.

Alors évidemment à l'exécution, vous ne voyez rien de différent par contre, je peux sans problème les afficher. Je vais mettre un print() et je mette par exemple "Prénom de h1", d'accord. On va utiliser une méthode, comme on avait déjà utilisé avant ... rappelez vous format(), parce qu'elle permet comme ça de bien formater le texte correctement. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        print("Création d'un Humain...", self)
        self.prenom = "Jojo"
        self.age = 1

print("Lancement du programme...")

h1 = Humain()
print("Prénom de h1 -> {}", format())
    
h2 = Humain()
```

## Accéder à un attribut

Et comment on va récupérer cette variable ? comment je peux accéder au prénom de l'objet ? Et bien l'objet, il faut son identifiant dans le code principal. Quand vous êtes dans la classe en elle-même, son identifiant, c'est "self".

Ben oui parce que c'est lui-même donc c'est facile, "self", voilà. "myself", c'est moi même, "itself", c'est lui-même et cetera, en anglais.

Donc là, ici, on n'a pas de "self" dans le code principal. Je vous rappelle que le code principal, c'est à partir du print() que j'ai mis là.

```py
print("Lancement du programme...")

h1 = Humain()
print("Prénom de h1 -> {}", format())
    
h2 = Humain()
```

Par contre, son identifiant, on le voit. C'est les variables qu'on a utilisé, c'est h1 donc on va dire que c'est h1 et sur h1, on veut accéder à quoi ? son prénom.

Donc on met un point et on met prenom, voilà, "h1.prenom" c'est pour accéder à l'attribut prenom de l'objet h1 qui est de classe Humain, tout simplement.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self):
       print("Création d'un Humain...")
       self.prenom = "Jojo"
       self.age = 1

print("Lancement du programme...")

h1 = Humain()
print("Prénom de h1 -> {}", format(h1.prenom))

h2 = Humain()
```
Et du coup, là vous voyez que le prénom de h1 c'est bien Jojo. Il arrive à l'afficher, il n'y a pas de souci à ce niveau-là.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Prénom de h1 -> {} Jojo
Création d'un Humain...
```

Je pourrais faire pareil avec l'âge, je pourrais faire ça avec n'importe quoi. 

Le souci c'est que j'ai définis, comme pour une fonction, j'ai définis des choses en fait par défaut. C'est le prénom, je ne peux pas choisir ce que je veux. C'est un mot que je pourrais demander éventuellement à l'utilisateur pour choisir un prénom mais nous on parle de développement. J'aimerais pouvoir choisir, par exemple, lorsque je développe, créer un Humain directement avec le nom que je veux, avec un âge différent, pas forcément tous les mêmes.

Je ne veux pas créer des clones, à moins de vouloir refaire un Star Wars éventuellement mais je veux pouvoir créer des humains différents.

Du coup, je vais éviter de faire juste un accès comme ça, ici.

```py
self.prenom = "Jojo"
self.age = 1
```

Je vais placer ces attributs donc dans des paramètres alors vous n'allez rien apprendre de nouveau là parce que ça fonctionne comme les fonctions.

N'oubliez pas que le constructeur, c'est une méthode et ça fonctionne comme une fonction.

Tout ce que vous avez vu dans la vidéo des fonctions et tout à fait applicable ici, vous vous rappelez les paramètres... on peut en mettre 1, on peut en mettre 2, plusieurs, des obligatoire, on peut en mettre des facultatif en mettant des valeurs par défaut et on pouvait également avoir une infinité de paramètres.

Pour l'objet, c'est la même chose. Rappelez-vous que python est tout objet donc il n'y a aucune différence.

## Définir des attributs

Alors, je ne vais pas vous montrer les exemples sur tout ce qu'on a vu avec les fonctions si il y a besoin de faire quelques rappels mais on va voir tout simplement comment définir des attributs.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self):
        print("Création d'un Humain...")

print("Lancement du programme...")

h1 = Humain()

h2 = Humain()
```

### Définir des attributs en paramètre du constructeur

Alors "self", il doit toujours rester en premier, voilà. On décrit toujours en premier l'objet lui-même. On l'indique toujours en paramètre, c'est mieux de le faire, et après avec une virgule, on peut définir les attributs qu'on veut : prenom et age, tout simplement, ce qu'on avait pris tout à l'heure.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, prenom, age):
        print("Création d'un Humain...")

print("Lancement du programme...")

h1 = Humain()

h2 = Humain()
```

Et là comme on va pouvoir, en fait tout simplement, les associer à notre objet ... bah vous le savez je pense que vous l'avez compris, rappelez vous dans la classe, l'objet c'est quoi ? son identifiant c'est le fameux "self" point, et on va dire, prenom et on va le faire stocker, par exemple, prénom.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, prenom, age):
        print("Création d'un Humain...")
        self.prenom = prenom

print("Lancement du programme...")

h1 = Humain()

h2 = Humain()
```

Alors, je vais changer les noms parce que ça va être un peu bizarre ... euh qu'est ce que je peux dire ... allez on va mettre comme ça. Je vais mettre un C pour classe, d'accord, c_prenom et c_age.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age):
        print("Création d'un Humain...")
        self.prenom = c_prenom

print("Lancement du programme...")

h1 = Humain()

h2 = Humain()
```

C'est bizarre comme terme mais c'est histoire qu'en fait, vous comprenez que ce sont vraiment des variables différentes, pas les mêmes sinon vous allez penser que ce sont les mêmes, d'accord.

Vous voyez c'est c_prenoms que je stocke du coup dans une variable d'attribut, un attribut en fait, sur lequel je crée des choses donc Sur lequel, je crée des choses.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom, c_age):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain()

h2 = Humain()
```
Donc ça prenom, age, ça appartient à la classe. 

c_prenom, c_age ce ne sont maintenant que des paramètres en fait d'une fonction. 

```py
def __init__(self, c_prenom, c_age):
```

Le constructeur est une sorte de fonction tout simplement, une méthode, d'accord. 

Et là je vais pouvoir créer des humains différents.

Alors là, si je reteste mon programme, il ne va pas être content parce qu'il lui manque, rappelez-vous, deux paramètres requis.
```powershell
>python main.py
Lancement du programme...
Traceback (most recent call last):
  File "main.py", line 581, in <module>
    h1 = Humain()
TypeError: __init__() missing 2 required positional arguments: 'c_prenom' and 'c_age'
```

Comme là "__init__(self, c_prenom, c_age)", j'ai pas mis de valeurs par défaut ... vous souvenez par rapport à la vidéo sur les fonctions, je suis obligé de renseigner les 2 paramètres, donc je vais le faire, ici.

Ici, je vais garder Jojo, puis je vais dire par exemple que Jojo, il a 34 ans, d'accord. on va mettre un entier, voilà. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)

h2 = Humain()
```

Et puis là (h2), on va avoir, je sais pas moi, Albert. Alors, je suis très très très imaginatif sur les prénoms. Et on va mettre 17.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom, c_age):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)

h2 = Humain("Albert", 17)
```
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Création d'un Humain...
```

Voilà python, il crée bien les humains alors oui je ne l'ai évidemment pas afficher c'est embêtant. On va afficher, ici, on va mettre print() puis on va reprendre la même chose pour l'âge. Je fait un peu de copier-coller. Et là, on fait la même chose pour h2 pour montrer qu'il y a une différence sinon ça va évidemment n'avoir aucun intérêt.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom, c_age):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h2 = Humain("Albert", 17)
print("Prénom de h2 : {}".format(h2.prenom))
print("Age de h2 : {}".format(h2.age))
```
Ok, on fait la même chose pour montrer qu'il y a une différence  donc j'ai rien fait, j'ai juste fait du copier-coller pour afficher tout simplement chaque attribut pour chaque objet, h1.prenom, h1.age, h2.prenom, h2.age. Et là, on a bien des informations différentes, d'accord.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Prénom de h1 : Jojo
Age de h1 : 34
Création d'un Humain...
Prénom de h2 : Albert
Age de h2 : 17
```

"Jojo, 34", "Albert, 17", tout simplement, on a défini comme pour une fonction, d'accord. On a choisi des paramètres sur lesquels on peut entrer.

## Définir des attributs par défaut en paramètre du constructeur

Si par défaut, je veux pouvoir avoir un prénom , je peux mettre ceci " c_prenom="Toto" ", comme pour ce qu'on a vu sur les fonctions, c'est exactement pareil.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom="Toto", c_age):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h2 = Humain("Albert", 17)
print("Prénom de h2 : {}".format(h2.prenom))
print("Age de h2 : {}".format(h2.age))
```

C'est exactement pareil aux fonctions, ce qui fait que si je mets par exemple, je sais pas moi, ouais si je fais ça "h1 = Humain(c_age=34) et oui par exemple, on va laisser comme ça, pourquoi pas."

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom="Toto", c_age):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain(c_age=34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h2 = Humain("Albert", 17)
print("Prénom de h2 : {}".format(h2.prenom))
print("Age de h2 : {}".format(h2.age))
```
```powershell
>python main.py
  File "main.py", line 717
    def __init__(self, c_prenom="Toto", c_age):
                 ^
SyntaxError: non-default argument follows default argument
```

Alors par contre là, il y a un souci avec self. C'est pas ça que je voulais faire. Attentez, on va garder "Jojo", voilà.

    ...
    print("Lancement du programme...")

    h1 = Humain("Jojo")
    ...

c_prenom plutôt que ceci c_prenom="Toto"

    ...
    def __init__(self, c_prenom, c_age):
    ...

Et on va mettre par exemple que l'âge par défaut sera égal à 1.

    ...
    def __init__(self, c_prenom, c_age=1):
    ...

Donc ici, h1 = Humain("Jojo") ... Vous voyez, je renseigne que le prénom, je renseigne pas l'âge et normalement, vous voyez, il met automatiquement l'âge par défaut comme pour les fonctions donc que l'âge est égal à 1.

```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom, c_age=1):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo")
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h2 = Humain("Albert", 17)
print("Prénom de h2 : {}".format(h2.prenom))
print("Age de h2 : {}".format(h2.age))
```
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Prénom de h1 : Jojo
Age de h1 : 1
Création d'un Humain...
Prénom de h2 : Albert
Age de h2 : 17
```

self, il faudra que je renseigne le self à l'appel pour faire respecter l'ordre puisque ici __init__(self, c_prenom, c_age=1) implicitement, le premier argument en fait c'est pas prénom, c'est l'objet lui-même.

Il y a une petite distinction en fait, une petite différence par rapport à aux fonctions simples mais pour le reste c'est le même fonctionnement, tout pareil.

Voilà, on peut avoir des attributs avec des valeurs par défaut.

On peut avoir des attributs, une infinité d'attributs même si je vois pas trop l'utilité mais pourquoi, admettons, et c'est des choses qu'on peut faire sans problème en objet, ça fonctionnera et vous pouvez définir des personnages comme ça.

Alors, plus tard on verra que quand on veut par exemple afficher le prénom ou autres, on peut faire comme ça "h2.prenom".

Il y a peut-être si vous avez fait notamment d'autres langages de programmation objet comme le C++, vous allez vous dire : Il affiche directement, en fait, les attributs d'un objet comme ça dans le code alors qu'en C++, on nous dit, il faut pas faire ça. Il faut utiliser ce qu'on appelle des accesseurs les get( quelque chose ), get( prénom ) ou get( âge ) ou des setter quand on veut modifier.

Il faut savoir que python ne fonctionne pas sur les mêmes règles, d'accord.

Python ne demande pas ... On peut en faire, il y a des accesseurs, on peut très bien en faire ça en python si on veut, si on aime bien la philosophie un peu du C++, là dessus, ou d'autres langages comme le CSharp ou autre. On peut s'amuser à faire ça mais en python de base, il n'y a pas cette norme, en fait, de faire des accesseurs.

Si on veut accéder à un attribuer, on met le nom de l'objet, un point, le nom de l'attribut. Si on veut le modifier, on mettra le nom de l'objet, point, le nom de l'attribut, égale autre chose.

Pourquoi je vous dis ça ? Je vais reprendre l'exemple ici de notre fameux Jojo (h1). Vous voyez que l'âge et son prénom sont affichés, d'accord.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo")
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))
```

Je vais remettre 34 pour son âge, ce que j'avais mit. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))
```

Et d'un coup, je vais changer les attributs. Je vais dire que h1.prenom ça change, d'accord, il va s'appeler Thomas.

```py
    #coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h1.prenom = "Thomas"
```
okay et du coup je vais pouvoir afficher son nouveau prénom, d'accord.
```py
#coding:utf-8

class Humain:
   """
   Classe des êtres humains
   """
   def __init__(self, c_prenom, c_age=1):
       print("Création d'un Humain...")
       self.prenom = c_prenom
       self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Prénom de h1 : {}".format(h1.prenom))
print("Age de h1 : {}".format(h1.age))

h1.prenom = "Thomas"
print("Prénom de h1 : {}".format(h1.prenom))
```
Et vous voyez que le changement s'opère, d'accord.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Prénom de h1 : Jojo
Age de h1 : 34
Prénom de h1 : Thomas
```
C'est-à-dire que depuis le code principal, en fait j'ai pu modifier un attribut d'une classe, voilà.

En C++, au niveau de la norme, c'est interdit. On estime qu'en fait la seule chose qui peut modifier un attribut, c'est la classe elle-même, c'est l'objet lui-même donc on passerait par une fonction qui sera en fait une fonction, par exemple, "modifierPrénom" en fait et qui vérifiera en fait, voilà, qu'on mets de bonnes choses, que le nom est bien dans les bonnes conditions, qu'il n'y a pas de chiffres par exemple, qu'il n'y a pas forcément de caractères non autorisés, ce genre de chose qui permettrait de faire des vérifications.

En python, on peut le faire mais ce n'est pas obligatoire, ça ne fait pas partie des normes, d'accord.

Faire ça en python c'est tout tout à fait normal, tout à fait on va dire dans les normes. 

`h1.prenom = "Thomas"`, si vous faites ça en C++, par contre, vous allez vous faire taper dessus par ceux qui développe déjà en C++.

C'est pas la même philosophie simplement, voilà. Il faut respecter et accepter les philosophies de chacun des langages, pas tout mélanger non plus mais voilà.

Là où on est en python, vous pouvez faire ça, ça ne pose aucun problème. Le python, voilà, les gens développent comme ça, ça a toujours été comme ça, ça changera peut-être un jour. Après il y en a qui veulent quand même utiliser les accesseurs. Chacun est libre, chacun fait comme il veut, si vous voulez passer plus tard par une méthode comme on le verra dans la vidéo suivante pour modifier les attributs par exemple d'un objet, libre à vous. Ce sera pas moins bien, ce sera pas mieux, ce sera simplement différent tout simplement.

Voilà pour ces attributs, notamment les modifications.

On peut ainsi sans problème modifier ces attributs, modifier ce genre de chose. 

Alors, on ne va pas faire grand-chose dans cette vidéo parce que je ne veux pas aborder les méthodes tout de suite, pour pouvoir faire des choses à notre objet sinon on va directement dériver et rajouter du contenu et je veux qu'on reste sur des choses assez basiques pour commencer qu'on commence vraiment doucement.

## Créer un attribut de classe

Par contre, on va terminer pour cette vidéo à parler des attributs de classe, c'est très simple aussi. Alors je vais reprendre cet exemple là donc j'enlève tout... 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
```

Et l'attribut de classe, c'est tout simplement un attribut qui n'appartient pas à un objet en particulier mais qui appartient ... il est le même en fait pour tous les objets de la classe que vous allez créer. Et comment on le différencie, et bien au lieu de le créer par exemple dans le constructeur ou dans une méthode qu'on aurait, on le crée dans la définition de la classe elle-même, rappelez-vous, un attribut c'est une variable donc je peux tout simplement la mettre ici, par exemple. 

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
        
##    <--
        
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
```

Alors, le genre de chose qui peut être utile, qu'on fait souvent c'est par exemple une variable qui dirait le nombre d'objets que l'on a créé. Pour un logiciel, ça peut être le nombre de licences qui ont été activé, ce genre de chose, d'accord, ça peut être pas mal. 

Alors, on parle d'Humain, on parle d'unité. On peut imaginer par exemple de faire une armée. On peut très bien avoir une fameuse ... tout simplement mettre une humains_crees, comme ceci, donc vous voyez qu'il est en dehors du constructeur. On fait humains_crees égal à 0.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
        
    humains_crees = 0
    
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
```

Et après du coup, une fois que là, on a fait l'humain, on peut dire du coup que humains_crees, d'accord, à augmenter de 1, OK.

```py
humains_crees += 1
```

Et à plus exactement ceci : Humain.humains_crees += 1

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    
    humains_crees = 0
        
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age
        Humain.humains_crees += 1

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
```

`Humain.humains_crees += 1`, alors pourquoi je fais ça parce que c'est pas en fait lié à quelque chose c'est-à-dire que si je fais self, je vais créer un attribut de classe "humains_crees" qui ne serait pas le même.

Là, je lui dit, en fait, que dans la classe Humain, il y a un attribut de classe, pas un attribut tout court mais un attribut de classe, qui s'appelle comme ceci "humains_crees", je fais une modication dessus.

Vous voyez la différence quand ça appartient à l'objet en lui-même, c'est self, c'est lui-même. Quand c'est un attribut de classe, on met le nom de la classe, un point, la variable.

Donc c'est quelque chose qui va être en dehors donc ici.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
        
    humains_crees = 0       ## <-- Attribut de classe
        
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom ## <-- Attribut (de l'objet)
        self.age = c_age
        Humain.humains_crees += 1

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
```

`h1 = Humain("Jojo", 34)`, et là à chaque fois que je vais créer en fait un personnage, je peux l'afficher. Je peux faire voilà "Humains existants ... " par exemple, donc je mette ça avec format() et là je mette format(Humain.), en fait, parce que ce n'est pas lié à un objet, rappelez-vous, c'est lié à la classe donc je vais mettre format(Humain.humains_crees), d'accord, comme pour ici. 

```py
#coding:utf-8
    
class Humain:
    """
    Classe des êtres humains
    """
    
    humains_crees = 0
    
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age
        Humain.humains_crees += 1 # <---
    
print("Lancement du programme...")
    
h1 = Humain("Jojo", 34)
print("Humains existants : {}".format(Humain.humains_crees)) # <---
```

Donc je vais afficher ça et puis là, je vais en créer un 2e, Humain(), on va reprendre Albert, voilà, et on va afficher notre nouvel Humain.

```py
#coding:utf-8

class Humain:
    """
    Classe des êtres humains
    """
    
    humains_crees = 0
    
    def __init__(self, c_prenom, c_age=1):
        print("Création d'un Humain...")
        self.prenom = c_prenom
        self.age = c_age
        Humain.humains_crees += 1

print("Lancement du programme...")

h1 = Humain("Jojo", 34)
print("Humains existants : {}".format(Humain.humains_crees))

h2 = Humain("Albert", 17)
print("Humains existants : {}".format(Humain.humains_crees))
```
Et là, on va voir un peu la différence, voilà.
```powershell
>python main.py
Lancement du programme...
Création d'un Humain...
Humains existants : 1
Création d'un Humain...
Humains existants : 2
```

Création d'un humain, d'accord, il vous met que Humains existants, il y en a 1 et ensuite Humains existants, il y a 2.

Vous voyez, la variable va être la même pour tout le monde.

Il ne va pas remettre à 0, en fait, le compteur, si on l'avait créé comme une variable pour l'objet, elle serait à 0 pour chaque objet et du coup en faisant +1, elle passera à 1 pour tous les objets. Et là, on aurait 1 et 1 pour chacun (Humains existants : 1) puisqu'ils auraient une variable à eux-seuls. Ils auraient chacun leur propre variable.

Alors comme un attribut normal et comme ils ont leur prénom par exemple. Ils ont chacun leur prénom, chacun leur âge et bien là, ils auraient chacun leur humains_crees alors qu'ici, en le mettant en dehors, on en a fait un attribut de classe qui appartient non plus à l'objet mais à la classe en général et du coup tous les objets ont accès à cette même variable.

C'est un peu une variable globale en fait pour tous les objets que vous créer, toutes les instances que vous créez pour cette classe, tout simplement. Si je peux le résumer en tout cas, c'est comme ça que je le ferai, voilà.

Puis écoutez bah je pense qu'on a fait un peu le tour pour cette vidéo là, je voulais rester sur tout ce qui est classe / attribut, je ne voulais pas trop compliquer, pas trop en dire parce qu'il y a beaucoup beaucoup de choses en objet donc on va y aller tranquillement pour que ce ne soit pas trop long, on va dire, pas trop long éprouvant pour vous si vous démarrez, surtout que la formation python est l'une des plus accessible quand vous êtes débutant en informatique donc j'essaie de faire quelque chose le plus simple possible en tout cas pour que ça vous encourage pour la suite à apprendre d'autres langages plus compliqué ou d'autres technologies tout simplement, voilà.

Donc on va en rester là pour cette petite séance numéro 11.

Dans la prochaine on parlera des propriétés, un petit peu, on va voir les méthodes parce que là c'est bien on a créé des objets, on a créé des humains mais on aimerais leur faire faire des choses, les faire parler, pourquoi pas leur faire faire, voilà, des actions tout simplement.

Donc ce sont nos méthodes, rappelez-vous, les méthodes sont tout simplement des fonctions qui appartiennent à une classe, d'accord. C'est rien rien de plus, rien de moins, c'est simplement une fonction mais propre à un objet. Quand on parle d'objets, on dit des méthodes. Quand on parle de procédural, par exemple, on parle de fonctions et sur des anciens langages, on parlait carrément de procédure. Voilà les noms ont changés mais en fait c'est un petit peu la même chose, voilà.

Puis on verra donc dans cette 12e séance, on regardera un petit peu tout ça. On parlera des des méthodes. On parlera des propriétés et de pas mal d'autres petites choses liées justement à ce qu'on peut faire avec nos différents objets que nous avons créé.

A très bientôt

## Resume
```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Pythom #11 - classes et attribut
# https://youtu.be/91dPooHyNIo
# 

"""
classe, est un plan de conception. Comment pourrait-on fabriquer un humain? La classe permet de creer un Humain ou un Animal, un gestionnaire de jeu video, la fenetre pour notre interfce graphique, etc.

Un humain pourrait etre une classe. De la on peut creer des objets, on peut instancier une classe. Un personnage appele Julien serait notre objet de classe. On peut ainsi indtancier plusieurs objets.

ces objets peuvent etre completes en leur ajoutant des attributs. Un attribut est une variable de classe. L'attribut permet de definir la classe. Qu'est-ce qu'un humain peut avoir ? un prenom, un age, une taille, un genre,etc. Ce qui permet de definir les attributs.
"""
#1# CLASS
# Le mot cle class. Pour definir une fonction, on utilise le mot cle def pour define.
# Par convention, on met une majicule au debut du nom de la classe et de chaque nouveau mot, en CamelCase. On evite les underscores parce que ce n'est pas beau.
# On termine avec les deux comme pour la definition d'une fonction comme en Python, on n'utilise pas les accolades.
# A la ligne, on ajoute une tabulation pour definir notre class.
# A l'interieur, on definis une methode particuliere qui s'appelle le constructeur. La methode init fait office de constructeur, elle va permettre de construire des objets, d'instancier des classes en creant des objets. On fait comme pour la creation de methode (fonction), on utilise le mot cle def suivi de __init__ (deux underscores) et disposant de 1 parametre suivi de deux points comme pour la creation d'une fonction.
# Mettre le mot Pass et quitter la class, c'est a dire retirer la tabulation.

class Humain:
	"""
	Classe des etres humain.
	------------------------
	Description de notre classe : On utilise une docString (chaine de documentation) pour documenter notre code u sein ici de la classe Humin. Comment documenter son code.
	"""
	def __init__(self):
		pass
print("Lancement du programme...")
# Jusqu'ici, on a definis une classe comme on pourrait avoir definis une fonction. A ce niveau, on a ni appeler cette classe, ni creer une instance. On a juste une petite boite avec notre constructeur d'Humain.
# On va pouvoir instancier, creer un objet de classe Humain. Cet objet va etre stocke dans une variable. On va creer une instance qui va etre stockee dans une variable. On utilisera cette variable pour travailler ...
H1 = Humain() # On lui dit, dans H1, tu fait appel a Humain puisqu'elle est definie avant.

#2# Creation d'un Humain.
"""
Quand on fait H1=Humain(), on fait appel a la classe. l'interpreteur va chercher la methode init et il va regarder comment il est definis "self" qui signifie que la methode cible l'objet lui meme qu'on est en train de creer.
Ensuite on affiche un petit texte "Creation d'un Humain..." et ensuite le constructeur va rendre self meme si il n'y a pas de return. self etant l'objet rendu par le constructeur. L'objet retourne va etre stocke dans l'affectation H1, variable qu'on va pouvoir manipuler...
Voila comment creer une classe, comment instancier une classe en creant un objet.
"""
class Humain:
	def __init__(self):
		print("Creation d'un Humain...")
print("Lancement du programme...")
H1 = Humain()

#3# Creation de 2 Humains.
"""
Nous obtenons deux fois le message "Creation d'un humain...".
En ajoutant ("Creation d'un Humain...", self), on affiche une adresse qui permet de verifier ou se trouve l'adresse de l'objet qu'on a creer. On affiche egalement le nom du programme principale (__main__). __main__ est le code principale nomme avec des doubles underscores. On affiche egalement ".humain" qui nous dit que c'est un objet.
__main__.Humain est un objet stocke a l'adresse un tel. On arrive donc bien a distinger les deux objet crees.

"""

# definition/creation de classe.
class Humain:
	def __init__(self):
		print("Creation d'un Humain...", self)
# instanciation de classe pour creer des objets.
print("Lancement du programme...")
H1 = Humain()
H2 = Humain()

#4# Creer attribut.
"""
De base, un attribut va apartenir a une classe.
Maintenant on va definir les attribut dans le constructeur pour notre humain.
On va avoir un prenom et par defaut, on utilise self (identifiant qui vise l'objet que l'on est en train de creer - sur moi-meme, sur cet objet). 
On met un point pour definir un attribut, une variable qui appartient a une classe. Elle n'est juste pas en train de se balader n'importe ou.
On met ensuite prenom suivi de = (affection) afin de lui donner un nom (Jojo). Soit self.prenom.
qu'on on peut definir aux humains, un age, etc.
"""
class Humain:
	def __init__(self):
		print("Creation d'un Humain...")
		self.prenom = "Jojo"
		self.age=1
print("Lancement du programme...")
H1 = Humain()
H2 = Humain()

#5# Afficher attribut.
"""
Afficher avec les methodes print() et format().
format() permet de bien formater le texte.
Comment acceder/recuperer le prenom de l'objet
? L'identifiant de l'objet est dans le code principal. Dans la classe, son identifiant c'est self. Dans le code principale, son idebtifiant c'est H1, notre variable.
Sur H1 on va acceder a son prenom donc on met un point. H1.prenom permet d'acceder a l'attribut prenom de l'objet H1 qui est de classe Humain.
Le soucis est que l'on a definis des attributs par defaut. On ne peut pas choisir le prenom, on pourrait demander a l'utilisateur (input()). On veux pouvoir creer des Humains en developpement directement avec le nom et l'age que l'on veux mais qu'ils soient differents. On ne veux pas creer des clones.

"""
class Humain:
	def __init__(self):
		print("Creation d'un Humain...")
		self.prenom = "Jojo"
		self.age=1
print("Lancement du programme...") # debut du code principale.
H1 = Humain()
print("Prenom de H1 est {}.".format(H1.prenom))
H2 = Humain()

#6# Definir des attributs.
"""
On ne va plus acceder a nos variables de cette maniere. Nous allons placer nos attributs dans des parametres. Rien d'exceptionnel, cela fonctionne comme pour les foncrions. On peut mettre differents parametres (1 seul ou plusieurs, facultatif ou facultatif par defaut, obligatoir ou encore une infinite de parametres). Pour la PO, c'est la meme chose. Python est tout objet, donc il n'y a pas de differences.
"""

class Humain:
	"""
	Ainsi comment definir des attributs? self doit rester en premier. On definis toujours l'objet en premier comme parametre et ensuite avec une virgule on peut definir les attributs que l'on veux.
	"""
	def __init__(self,c_prenom,c_age):
		print("Creation d'un Humain...")
		"""
		Comment les associer a notre objet ? il faut se rappeler que dans la classe l'identifiant est self et on va le faire stocker par exemple prenom. C'est donc c_prenom que l'on stocke dans une variable d'attribut.
		self.prenom et self.age appartiennent a la classe. prenom et age sont des parametres de fonction. Le constructeur est une sorte de fonction, une methode.
		De cette maniere, on va pouvoir creer des humains differement.
		"""
		self.prenom = c_prenom
		self.age = c_age
print("Lancement du programme...")
"""
Les methodes appelees dans le programme s'attendent a avoir deux parametres car on n'a pas mis de valeur par defaut (video sur les fonctions). 
On doit renseigner les deux parametres.
On peut ensuite afficher chaque attribut pour chaque objet.
On a choisit des parametres sur lequel on peut entrer comme pour les fonctions.
"""
H1 = Humain("Jojo",34)
print("Prenom de H1 est {}.".format(H1.prenom))
print("Age de H1 est {}.".format(H1.age))
H2 = Humain("Albert",17)
print("Prenom de H2 est {}.".format(H2.prenom))
print("Age de H2 est {}.".format(H2.age))

#7# Parametre par defaut.
class Humain:
	"""
	Maintenant on peut renseigner un age par defaut.
	"""
	def __init__(self,c_prenom,c_age=25):
		print("Creation d'un Humain...")
		self.prenom = c_prenom
		self.age = c_age
print("Lancement du programme...")
""" 
Si on ne renseigne pas l'age, l'interpreteur prend l'age par defaut.
Neanmoins il faudrait renseigner le self a l'appel car implicitement le premier argument n'est pas prenom, c'est l'objet lui meme. il y a une petite distinction par rapport aux fonctions simples mais ca reste le meme fonctionnement. Tout pareil.
"""
H1 = Humain("Jojo")
print("Prenom de H1 est {}.".format(H1.prenom))
print("Age de H1 est {}.".format(H1.age))
H2 = Humain("Albert",17)
print("Prenom de H2 est {}.".format(H2.prenom))
print("Age de H2 est {}.".format(H2.age))

"""
On peut donc avoir des attributs avec des valeurs par defaut.
On peut ainsi definir des personnages comme ca.
La particularite de Python est que l'on peut afficher directement comme ca les attributs dans le code alors qu'en C++, il faut utiliser des accesseurs (getter et setter) en faisant get age ou get prenom puis set age, etc.quand on veux modifier.
Python ne fonctionne pas sur les memes regles. On peut neanmoins utiliser des accesseurs en Python si on aime bien la philosophie du C++ ou du Csharp ou autre.
De base, il n'y a pas cette norme en Python de faire des accesseurs.
Si on veux acceder a un attribut en Python, on met le nom de l'objet point puis le nom de l'attribut.
Si on veux le modifier, on met le nom de l'objet point puis le nom de l'attribut suivi d'un = et autre chose.
"""

#7# Modifier attribut.
class Humain:
	def __init__(self,c_prenom,c_age=25):
		print("Creation d'un Humain...")
		self.prenom = c_prenom
		self.age = c_age
print("Lancement du programme...")
H1 = Humain("Jojo")
print("Prenom de H1 est {}.".format(H1.prenom))
print("Age de H1 est {}.".format(H1.age))
"""
H1.prenom est modifier en Thomas. On affiche ensuite son nouveau prenom.
Depuis le code principal, on peut modifier l'attribut d'une classe. En C++, c'est intedit au niveau de la morme. On estime que la classe est la seule a pouvoir se modifier. La clasde elle-meme peut proceder a ses propres modifications. Il faudrait passer passer par une fonction qui serait "modifier le prenom" et qui verifierais que le nom est bien dans les bonnes conditions, des verifications. (pas de caracteres speciaux, etc). En Python, on peut le faire mais ce n'est pas obligatoire. ca ne fait pas partie des normes.
La philosophie n'est pas la meme en C++.
En Python, les gens travaille comme ca parfois certains veulent passer par des accesseurs.Chacun est libre de faire comme il veut.
Ce n'est pas moins bien de faire d'une facon ou d'une autre.
"""
H1.prenom = "Thomas"
print("Nouveau prenom de H1 est {}.".format(H1.prenom))

#8# Attribut de classe.
"""
Un attribut de classe est un attribut qui n'appartient pas a un objet en particulier. 
Cet attribut est le meme pour tous les objets de la classe que l'on cree.
Comment es qu'on le differencie? Au lieu de le creer dans le constructeur ou dans une autre methode, on le cree dans la definition de classe elle-meme. En effet, l'attribut est variable.
Par exemple, une variable qui dirait le nombre d'objet que l'on a cree. Pour un logiciel, ca peut etre le nombre de licences activees, etc.
"""
class Humain:
	# Classe des etres Humains.
	"""
	Quand on parle d'humain, on parle d'unite. On peut imaginer faire une armee.
	On cree humains crees en dehors du constructeur. 
	"""
	humains_crees = 0
	def __init__(self,c_prenom,c_age=25):
		print("Creation d'un Humain...")
		self.prenom = c_prenom
		self.age = c_age
		"""
		On dira que quand un humain est cree, humains_crees est augmenter de 1.
		Si je fait self (a la place de Humain), je vais creer un attribut de classe ne serait pas le meme.
		"""
		Humain.humains_crees += 1
		"""
		Dans la classe Humain, il y a un attribut de classe qui s'appele humains_crees sur lequel je fait des modications.
		Attention il s'agit d'un attribut de classe.
		il y a une difference. Quand ca appartient a l'objet lui-meme, c'est self. Quand c'est un attribut de classe, on met le nom de la classe point la variable.
		A chaque fois que je vais creer un personnage, 
		"""
print("Lancement du programme...")
H1 = Humain("Jojo")
print("Humains existants : {}".format(Humain.humains_crees))
H2 = Humain("Albert")
"""
On peut ensuite afficher notre attribut de classe. On le precede par Humain parce qu'il est liee a la classe et pas a un objet.
"""
print("Humains existants : {}".format(Humain.humains_crees))
"""
La variable va etre la meme pour tout le monde.

Si on l'avait creer en variable pour l'objet, elle serait a 0 pour chaque objet et elle passerait a +1 pour tous les objets. 
Ils auraient chacuns leur propre variable comme un atrribut normal. Ils auraient leurs variables a eux-seuls. Ils airaient chacun 
leur humains_crees comme leur prenom et leur age.

En le mettant dehors, on en a fait un attribut de classe qui m'appartient plus a l'objet mais a la classe en general et du coup 
tout les objets ont acces a cette meme variable. C'est un peu comme une variable globale pour tous les objets, pour toutes les 
instances que l'on cree pour cette classe.
"""
"""
Dans la video qui suit, on voit les methodes, soit des fonctions qui appartiennent a des classes. On aimeraient pouvoir faire 
parler, manger, etc nos objets.

ce sont simplement une fonction propre a un objet. On dit des methodes. En procedurale, on parle de fonction. Sur des anciens 
langages, on parlait carrement de procedure. ca a changer mais c'est un peu la meme chose...
"""
```