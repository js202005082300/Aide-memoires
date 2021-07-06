# [14. Héritage](https://www.youtube.com/watch?v=jS-S0hbUoQo)

+ [Créer une classe Mère (Vehicule)](#Créer-une-classe-Mère)
+ [Créer une classe Fille (Voiture)](#Créer-une-classe-Fille)
+ [Créer des Objets de classe Mère](#Créer-des-Objets)
+ [Développer notre classe Fille](#Développer-notre-classe-Fille)
    + [Constructeur de classe Fille](#Constructeur-de-classe-Fille)
    + [Ré-utilisation de code](#Ré-utilisation-de-code)
+ [Créer une 2e classe Fille (Avion)](#Créer-une-2e-classe-Fille)
+ [Spécialiser une classe et redéfinir ses méthodes](#Spécialiser-une-classe-et-redéfinir-ses-méthodes)
+ [Héritage multiple](#Héritage-multiple)
+ [Les fonctions isinstance et issubclass](#Les-fonctions-isinstance-et-issubclass)
+ [Resume](#Resume)

Bonjour à tous,

Vous êtes sur la séance numéro 14, on va continuer un petit peu avec les notions de l'objet.

Vous avez vu maintenant comment créer ... définir des classes donc instancier des objets, comment gérer un petit peu leurs attributs, faire des propriétés sur les attributs pour contrôler un petit peu les accès, les modifications. On a également vu comment faire des méthodes donc vous savez déjà un petit peu vraiment toutes les bases en objet qui peuvent se retrouver un petit peu dans tous les langages de programmation orienté objet et nous allons avoir une autre notion maintenant, très importante dans ces concepts en faite qui s'appelle l'héritage.

L'héritage, j'en avais parlé un petit peu la dernière fois dans la vidéo d'introduction. Si vous vous souvenez de la vidéo où j'avais donné un peu toutes les définitions des choses que nous verrions au cours de cette formation.

Et ici, je ne vais pas reprendre la définition forcément, on va simplement revoir rapidement les choses et on va voir un peu comment ça se passe au niveau code en python pour mettre en place cette histoire d'héritage.

Je vous avais expliqué si on reprend un petit peu ce que j'avais dit en introduction, que l'héritage c'était en fait une manière de créer des classes fille c'est-à-dire qu'on a une classe de départ qu'on appelle en général la classe mère et on va avoir des classes qui héritent de la classe mère donc les classes filles.

Et ces classes filles sont spécialisées c'est-à-dire qu'on va les spécialiser par rapport à la classe mère et je vais vous expliquer comment donc on va directement rentrer dans le vif du sujet en faisant du code et je vous donnerai de plus amples informations, on va dire, sur le détail de tout ça, directement sur le code.

On va commencer déjà par créer un objet, d'accord donc créer une classe. On va définir une classe comme on a pu le faire jusqu'à présent. On avait fait une classe Humain si vous souvenez un petit peu des vidéos précédentes. Là on va sûrement changer un petit peu, on va faire autre chose pour montrer ça.

## Créer une classe Mère

On va faire par exemple une classe Vehicule comme ceci, d'accord.

```py
    #coding:utf-8
    
    class Vehicule:
```

On va créer le constructeur et on va dire par exemple que le véhicule, il a un nom.

```py
    #coding:utf-8
    
    class Vehicule:
        def __init__(self, nom, ...):
```

Qu'est-ce qu'on peut dire aussi ? Qu'est-ce qu'un véhicule a ? on va dire par exemple qu'il a une quantite_essence, bon je met essence mais ce n'est pas forcément de l'essence, c'est juste pour dire voilà qu'il y a une espèce de carburant, en fait, qui fait marcher le véhicule.

On part du principe que le tout nos véhicule ici, fonctionneront avec un système d'essence, d'accord, pas fonctionner comme ça de manière mécanique ou à pédale et voilà.

On va rester là dessus, on va pas trop compliqué le code. Ce n'est pas la peine de faire quelque chose de trop long et du coup, on aurait self.nom égal nom.

```py
    #coding:utf-8
    
    class Vehicule:
    
        def __init__(self, nom, ...):
            self.nom = nom
```

Donc là, on crée un attribut nom pour l'objet de classe Vehicule, d'accord. On y stocke le paramètre qu'on a rentré et on aura la même chose par exemple pour essence. 

```py
    #coding:utf-8
    
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
```     
Alors vous allez me dire que je ne met pas le même nom parce que je peux mettre un petit peu ce que je veux, d'accord.

Et on va s'arrêter-là et éventuellement, on peut dire, je ne sais pas moi ... qu'est-ce qu'on peut dire ? montrer_objet() ... def montrer_vehicule(), c'est un petit peu bizarre mais c'est pas grave, voilà. Et on va dire par exemple return de self.nom

```py
    #coding:utf-8
    
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
        
        def montrer_vehicule(self):
            return self.nom
```

Ensuite, qu'est-ce qu'on peut faire ? alors oui, on va dire que Vehicule, on montrer juste le nom puis c'est tout, d'accord.

Histoire d'avoir ça, un peu comme ci je faisais un get de nom pour dire que quand je veux montrer mon véhicule, je retourne son nom tout simplement.

Okay donc ça c'est bon, on a ici notre classe mère, d'accord, ce sera notre classe mère donc je vais le noter, voilà.

```py
    #coding:utf-8
    
    #Classe Mère
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
        
        def montrer_vehicule(self):
            return self.nom
```

## Créer une classe Fille

Et on va avoir une classe Fille, on va créer donc une classe qui va hériter d'un véhicule. Qu'est-ce que c'est une classe ? un système d'héritage c'est pour dire en fait que si vous voulez votre ... comment dire ... votre classe fille sera une sorte de la classe mère donc nous, on va par exemple faire un ... alors je mets les classes dans le même fichier, d'accord, normalement quand on veux faire ça proprement, on fait par plusieurs fichiers mais là pour simplifier les choses, on fait tout dans un seul et même fichier pour ne pas alourdir un petit peu les explications.

On va donc créer une classe par exemple voiture, d'accord.

Et pour montrer qu'elle hérite d'une classe, il suffit juste d'ouvrir des parenthèses donc c'est vraiment très simple et vous mettez la classe Mère entre parenthèses, voilà.

```py
    #coding:utf-8
    
    #Classe Mère
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
        
        def montrer_vehicule(self):
            return self.nom
    
    class Voiture(Vehicule):
```

Donc là, ça veut dire que voiture est une classe qui hérite de véhicule. En d'autres termes, vous pouvez dire que voiture est une sorte de véhicule, voilà, c'est une manière d'illustrer en fait l'héritage en programmation objet.

Donc si vous êtes capable de dire par exemple d'une classe qu'elle est une sorte d'autres classes, normalement tout de suite, vous devrez penser à un héritage qui est possible à faire.

Si par exemple vous le faites pas, admettons que vous avez 2 classes créées comme ça, l'une indépendante de l'autre mais si vous voyez qu'une classe c'est une sorte de l'autre classe, c'est qu'à priori, vous allez pouvoir créer une relation d'héritage, voilà.

Donc on a ceci et c'est très bien : 

```py
    #coding:utf-8
    
    #Classe Mère
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
        
        def montrer_vehicule(self):
            return self.nom
    
    #classe Fille
    class Voiture(Vehicule):
```

Alors je rappelle qu'ici, on aura la classe fille, enfin une classe fille parce qu'on pourrais en avoir d'autres mais on va rester comme ça.

Vous allez me dire mais alors comment créer ce fameux objet puisque par ailleurs, ça ne sert à rien de montrer véhicule. Pourquoi j'ai fait ça mais c'est pas grave. On va juste garder ça comme ça.

```py
    #coding:utf-8
    
    #Classe Mère
    class Vehicule:
    
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
           
    #classe Fille
    #class Voiture(Vehicule):
```

## Créer des Objets

on va juste garder ça comme ça. On va faire, je ne sais pas moi, v1 = Vehicule(""), là par exemple un véhicule ça peut être un petit peu tout et n'importe quoi, d'accord. Par exemple, je peux mettre un nom d'avion, d'avion de chasse voilà et puis quantité, je peux mettre n'importe quoi, je vais mettre 2400. On ne sais pas quoi, des littres, des patates, tout ce que vous voulez. Bref quantité d'essence, voilà, c'est vraiment pour l'exemple mais il y a bien évidemment rien de réaliste là-dedans.

```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:

        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
           
    #classe Fille
    #class Voiture(Vehicule):

    v1 = Vehicule("F22 Raptor", 2400)
```
Donc on a ce genre de choses et après par exemple, on peut afficher bêtement v1.nom, d'accord. Je ne fait pas d'accèsseurs, d'accord, je l'affiche directement.

```py
#coding:utf-8

#Classe Mère
class Vehicule:

   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
      
#classe Fille
#class Voiture(Vehicule):

v1 = Vehicule("F22 Raptor", 2400)
print(v1.nom)
```
On y va, ici on va le faire.
```powershell
    >python main.py
    F22 Raptor
```

Vous voyez qu'il affiche bien le nom donc de mon véhicule donc ici, voilà c'est un véhicule du coup pour les airs, un F22 Raptor, donc un avion de chasse pour l'exemple que j'ai donné, voilà, je peux en créer un autre et cetera et cetera. Donc ça c'est ce qu'on a vu.

Moi j'aimerais par contre, vous voyez que la classe véhicule, du coup, elle n'est pas assez précise. Je peux très faire par exemple ceci, j'aurais pu très bien faire v2 égal Vehcile() et avoir, je sais pas moi, ce genre de chose, "Toyota Supra", et puis ce genre de choses "90" donc une voiture d'accord une espèce de véhicule de voiture.

```py
#coding:utf-8

#Classe Mère
class Vehicule:

   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
      
#classe Fille
#class Voiture(Vehicule):

v1 = Vehicule("F22 Raptor", 2400)
v2 = Vehicule("Toyota Supra", 90)
print(v1.nom)
print(v2.nom)
```
Là du coup, on aurait pû afficher autre chose.
```powershell
    >python main.py
    F22 Raptor
    Toyota Supra
```

Alors voilà tous ce que je montre là pour le moment, c'est des choses c'est des choses que vous savez faire. On fait de l'affichage, on crée des simples objets et on affiche un de leurs attributs. Il y a vraiment rien de compliqué à ce niveau là.

Mais du coup, c'est pas assez clair. Moi voilà, je voulais faire une classe comme je l'ai dit par exemple Voiture et là ça tombe bien, Voiture est une sorte de Vehicule donc je peux créer ce fameux Heritage donc je vais faire ça, justement, voilà, avec une classe fille.

Ensuite, on va mettre que c'est le programme principal. C'est pour vous pour que ce soit plus clair au niveau du code. Je vais même agrandir un peu la police, voilà.

```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:

        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
           
    #classe Fille
    class Voiture(Vehicule):

    #Programme principal
    v1 = Vehicule("F22 Raptor", 2400)
    v2 = Vehicule("Toyota Supra", 90)
    print(v1.nom)
    print(v2.nom)
```

Donc ici on a la classe de voiture qui est donc une spécialisation de Vehicule. Qu'est-ce que ça veut dire ? ça veut dire en fait que notre classe voiture ici, elle va avoir tous les attributs donc ici nom et essence.

```py
    class Vehicule:
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
```

Et toutes les méthodes du Vehicule, d'accord, parce que oui une voiture, elle aura en fait le nom, ici dans mon code et un taux d'essence, d'accord, une quantité d'essence.

Si j'avais fait des méthodes, je ne sais pas moi : se déplacer ou je ne sais quoi, et bien la voiture aurait automatiquement ça.

```py
    #classe Fille
    class Voiture(Vehicule):
```

Donc pas besoin ici de refaire entre guillemets un self.nom ou par exemple de recréer une méthode. Si ademettons que j'avais fait, je ne sais pas moi, ben tiens def se_deplacer(self), d'accord, ce genre de chose.

```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:

        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):

    #Programme principal
    v1 = Vehicule("F22 Raptor", 2400)
    v2 = Vehicule("Toyota Supra", 90)
    print(v1.nom)
    print(v2.nom)
```

"Le véhicule se déplace..." donc je fais juste ça, voilà, admettons on a ça, d'accord. Et bien, vous n'êtes pas obligé évidemment ici (dans la classe Fille) de recréer la méthode se déplacer.

Automatiquement, la voiture ici, elle aura cette méthode. Je peux d'ailleurs vous le montrer, on va reprendre ça et on va faire, par exemple, `v1.se_deplacer` (on ne va pas mettre de ;), voilà.

```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule se déplace...")
      
#classe Fille
class Voiture(Vehicule):

#Programme principal
v1 = Vehicule("F22 Raptor", 2400)
v1.se_deplacer()
```
Alors là évidemment, il me met rien rien. 
```powershell
    >python main.py
      File "main.py", line 293
        v1 = Vehicule("F22 Raptor", 2400)
        ^
    IndentationError: expected an indented block
```
Ah bah oui j'ai rien dans la classe, voilà.
```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule se déplace...")
      
#classe Fille
class Voiture(Vehicule):
   pass

#Programme principal
v1 = Vehicule("F22 Raptor", 2400)
v1.se_deplacer()
```
Je vais remettre proprement et voilà.
```powershell
    >python main.py
    Le véhicule se déplace...
```
Donc il vous met que le véhicule se déplace, très bien, OK et donc là on va créer une voiture, d'accord, on va reprendre cet exemple-là.
```py
    #classe Fille
    class Voiture(Vehicule):
        pass                        ## <--
```

## Développer notre classe Fille

Comment ça va se passer ? je vais mettre par exemple voiture égale, alors on pourrait être tenté de mettre véhicule mais l'intérêt ici c'est de créer des voitures donc je vais faire ceci.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):
        pass

    #Programme principal
    voiture1 = Voiture()
```

### Constructeur de classe Fille

Et là comment ça se passe au niveau de la voiture ? et bien il nous faut un constructeur, c'est obligatoire, un constructeur spécialisé donc on va faire ça. On va le créer de la même manière que l'autre, on va mettre self, et ensuite, on va mettre tous les éléments de __init__() dans Vehicule. On est obligé car c'est la classe Fille donc elle a forcément tous les attributs de la classe mère donc "nom, ...", ensuite, on va mettre l'essence plutot que quantite_essence, je peux mettre ça, d'accord, je ne suis pas obligé de mettre les mêmes mots ici, d'accord, rappelez-vous ici ce sont des paramètres, entre guillemets, de fonction donc vous mettez les noms que vous voulez, d'ailleurs là je vais mettre exprès des noms différents, voilà par exemple, je peux mettre "nom_voiture,..." et ensuite essence.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence)

    #Programme principal
    voiture1 = Voiture()
```
Et là, on peut mettre exprès des noms différents "nom_voiture" et "nom_vehicule" pour la class Vehicule, histoire de vous montrer que ce n'est pas la même chose.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence)

    #Programme principal
    voiture1 = Voiture()
```
Et ici je peux rajouter d'autres attributs.
```py
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, --> <--)
```
Qu'est-ce qu'un véhicule, il a en plus ? une voiture, qu'est-ce qu'elle va avoir de plus qu'un simple véhicule ? je pars du principe dans ma présentation qu'un véhicule, il a juste un nom et une certaine quantité d'essence, c'est tout. Il n'a pas d'autres informations qu'on juge utile par contre dans le cadre de la voiture, je veux qu'elle ait d'autres informations en plus. Je peux choisir notamment la puissance en chevaux par exemple.
```py
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
```
Voilà je peux dire qu'un véhicule standard, il n'a pas forcément certain nombre de chevaux. Il y a des véhicules qui auront pas de ... voilà. Si c'est pas des véhicules à moteur par exemple, il n'aurait pas de puissance en chevaux donc ça n'aurait aucun intérêt de mettre ça dans Vehicule.

C'est pour ça qu'on crée une classe spécialisée, pour dire qu'une voiture une sorte véhicule en mieux, en fait.

Ca a tout ce que le véhicule peut faire où a comme attribut avec des choses en plus, d'accord, donc ça c'est l'héritage. C'est vraiment la définition de l'héritage, en fait, c'est le fait de spécialiser une classe pour la compléter en fait.

On peut la compléter en attributs, en méthodes et une classe fille est une sorte de la classe Mère, c'est comme ça qu'on crée cette relation d'héritage, voilà.

Alors du coup, exemple tout bête, comment on va faire donc au niveau de l'instantiation ?
```py
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
        # <--
        # <--
```
Alors il ne faut pas faire ceci, d'accord.
```py
            self.nom = nom_voiture
            self.essence = quantite_essence
```
Il ne faut pas faire ceci parce que là, vous voyez, que le constructeur de Vehicules le fait déjà donc il faut appeler constructeur de Vehicule. Vous faites Vehicule.__init__() et vous lui passer les noms de la classe Fille et on s'en fiche puisque ce ne sont pas les mêmes.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_voiture
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
            Vehicule.__init__(self, nom_voiture, essence)

    #Programme principal
    voiture1 = Voiture()
```
Donc ça.
```py
    Vehicule.__init__(self, nom_voiture, essence)
```
Il va l'appeler automatiquement, d'accord, et ensuite finalement, on fait l'autre, on fait le dernier attribut que le Vehicule tout seul n'a pas. 

Donc on le crée ici.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_voiture
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule se déplace...")
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
            Vehicule.__init__(self, nom_voiture, essence)
            self.puissance = puissance

    #Programme principal
    voiture1 = Voiture()
```
"self.puissance = puissance", voilà l'attribut, d'accord et vous verrez que le Vehicule pourra se déplacer.

D'ailleurs, je vais mettre ceci "Le véhicule {} se déplace...", je vais mettre point format() et self.nom.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_voiture
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule {} se déplace...".format(self.nom))
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
            Vehicule.__init__(self, nom_voiture, essence)
            self.puissance = puissance

    #Programme principal
    voiture1 = Voiture()
```
On verra plus tard, on va parler un petit peu de la chaîne de caractères parce que c'est un type d'objet du langage python donc il y aura une vidéo spécialement sur ça, sur tout ce qui est chaîne de caractères, notamment lors de l'utilisation de méthodes qui leur appartient comme format() par exemple que j'ai utilisé plusieurs fois, rappelé-vous, sur les vidéos de cette formation.

Donc là, on a ça et normalement c'est bon donc, du coup, ici quand vous allez en fait appeler ici, vous voyez, le constructeur.
```py
    voiture1 = Voiture()
```
Il va commencer automatiquement par la classe Fille, d'accord,donc il va lire le constructeur et là il va faire appel au constructeur de la classe mère Vehicule.
```py
    Vehicule.__init__(self, nom_voiture, essence)
```
Et il va instancier et ensuite il va finir avec les attributs de la classe Fille, et on obtiendra bien un objet de classe voiture, d'accord.

### Ré-utilisation de code

Donc là on met les éléments comme on veut donc "Voiture", on va rester du coup sur l'exemple de tout à l'heure, on va mettre une petite voiture de course tant qu'à faire et l'essence, on va mettre 90, genre 90 litres dans la voiture même s'il y peut être plus, il peut être moins, on s'en fout, et on va mettre allez 420 chevaux, voilà, histoire de se faire une idée, d'accord.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_voiture
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule {} se déplace...".format(self.nom))
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance)
            Vehicule.__init__(self, nom_voiture, essence)
            self.puissance = puissance

    #Programme principal
    voiture1 = Voiture("Toyota Supra", 90, 420)
```
Donc ça, c'est la voiture qu'on a créé.
Ici du coup je peux faire, regardez bien, voiture1.se_deplacer().
```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom_vehicule, quantite_essence):
       self.nom = nom_vehicule
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule {} se déplace...".format(self.nom))
      
#classe Fille
class Voiture(Vehicule):
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance

#Programme principal
voiture1 = Voiture("Toyota Supra", 90, 420)
voiture1.se_deplacer()
```
Et vous voyez que dans la classe Voiture, je n'ai pas recréer , redéfinis la méthode se_deplacer(), elle n'est que dans la classe Vehicule.

Pourtant vous voyez que Voiture, ce n'est pas un Vehicule, c'est vraiment une voiture donc ça normalement, enfin si on fait ça en toute logique, ça ne devrait pas fonctionner mais l'objet permet justement de faire ça grâce à l'héritage.

```powershell
    >python main.py
    Le véhicule Toyota Supra se déplace...
```

Voilà, il vous met que le Vehicule Toyota Supra reprend bien le nom en utilisant la méthode de véhicule et il affiche, voilà, "se déplace...".

Tu peux du coup faire pareil un print de ... j'sais pas moi ... voiture1.puissance, voilà, et oui on peut du coup afficher puissance. Et on va mettre ensuite "CH" (concaténation).
```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom_vehicule, quantite_essence):
       self.nom = nom_vehicule
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule {} se déplace...".format(self.nom))
      
#classe Fille
class Voiture(Vehicule):
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance

#Programme principal
voiture1 = Voiture("Toyota Supra", 90, 420)
voiture1.se_deplacer()
print(voiture1.puissance, "CH")
```
```powershell
    >python main.py
    Le véhicule Toyota Supra se déplace...
    420 CH
```
Voilà donc ça fonctionne de cette manière, c'est très simple. Vous avez vu, c'est un concept, une fois qu'on a bien compris son utilité et comment s'en servir, c'est vraiment très simple et peu importe le langage, c'est pas qu'en Python, ça peut être en C++, dans n'importe quel autre langage de programmation, c'est vraiment très très simple.

Après le seul truc, on va dire la seule petite difficulté, c'est au niveau de la syntaxe évidemment puisqu'il faut pas se tromper, voilà, il faut bien penser ici (classe Fille) à appeler le constructeur de la classe Mère.

Ah Ben voyez ici, `Vehicule.__init__()`, moi j'avais oublié de passer le self, ça peut arriver des fois une petite erreur d'inattention.

Il ne faut pas oublier tout ça et comme ça, on a bien fonctionnement qui se fait.

Alors, si vous voulez vous demander à quoi ça sert l'héritage, est-ce que voilà c'est vraiment utile, en fait ? pourquoi à ce moment-là, on ne fait pas carrément une classe juste Voiture où on lui met dedans nom, essence, puissance et puis une méthode se_deplacer et qu'on fait notre classe Avion et puis on met pareil le nom essence... hé bien pour éviter la répétition du code tout simplement, voilà, et ça permet d'avoir une hiérarchie au niveau de vos classes, de vous dire qu'on a une classe tout en haut, tout en haut et on va avoir des classes spécialisées.

Dans un jeu vidéo, par exemple, vous pourriez avoir une classe Entité, vous savez une entité, c'est un espèce de personnage qui peut bouger, en fait, dans un jeu. Vous pourriez spécialisé ensuite, faire une classe Fille qui serait, par exemple, le joueur celui que vous pouvez jouer et une autre classe Fille qui serait Le PNJ et pourquoi pas une autre classe fille qui serait le boss d'un jeu ou un monstre, ce genre de chose.

Vous voyez, vous pouvez vraiment après comme ça, spécialiser d'une certaine manière dans la mesure où par exemple vous pourriez dire ben oui la Voiture, elle va avoir des choses en plus qu'un simple Vehicule.

## Créer une 2e classe Fille

Je peux en faire une autre d'ailleurs, regardez, je peux faire très bien ça maintenant ... class Avion(), on en parlait tout à l'heure de l'avion et il hérite de Vehicule.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_vehicule
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule {} se déplace...".format(self.nom))
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance):
            Vehicule.__init__(self, nom_voiture, essence)
            self.puissance = puissance
            
    class Avion(Vehicule):
        def

    #Programme principal
    voiture1 = Voiture("Toyota Supra", 90, 420)
    voiture1.se_deplacer()
    print(voiture1.puissance, "CH")
```

La class Avion hérite de Vehicule, même chose, on fait __init__() qui prend ... on respecte les mêmes noms que la class Voiture ... __init__(self, nom, essence ...) et qu'est-ce qu'on peut lui mettre lui ? marchandise, `__init__(self, nom, essence, marchandise)` même si jz quiq qu'il y a des avions qui ne transportent pas forcément des smarchandise mais c'est parce que je ne suis pas spécialement très inspiré donc on va prendre ça.
```py
    class Avion(Vehicule):
        def __init__(self, nom, essence, marchandise):
```
Du coup ici, on appelle __init__ avec self, nom, essence comme tout à l'heure. On appel le constructeur de la classe Mère.
```py
    class Avion(Vehicule):
        def __init__(self, nom, essence, marchandise):
            Vehicule.__init__(self, nom, essence)
```
Et ici tous les attributs éventuels qu'il y a en plus, et bien, on peut les mettre là, voilà. 
```py
    class Avion(Vehicule):
        def __init__(self, nom, essence, marchandise):
            Vehicule.__init__(self, nom, essence)
            self.marchandise = marchandise
```
Et là vous allez voir, je vais avoir la même chose. Je peux créer av1 égal Avion(""") d'accord, on va reprendre le fameux F22 Raptor. Je lui met parfait 2400 chevaux, un truc comme ça et marchandises, il n'a pas de marchandises, ben on peux dire qu'il transporte des missiles par exemple donc voilà il transporte des missiles, pourquoi pas.

Et `av1.se_deplacer()`, on va faire déplacer le F22 Raptor.
```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom_vehicule, quantite_essence):
       self.nom = nom_vehicule
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule {} se déplace...".format(self.nom))
      
#classe Fille
class Voiture(Vehicule):
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance
       
class Avion(Vehicule):
   def __init__(self, nom, essence, marchandise):
       Vehicule.__init__(self, nom, essence)
       self.marchandise = marchandise

#Programme principal
voiture1 = Voiture("Toyota Supra", 90, 420)
voiture1.se_deplacer()
print(voiture1.puissance, "CH")

av1 = Avion("F22 Raptor", 2400, "Missiles")
av1.se_deplacer()
```
Donc on test tout ça.
```py
    >python main.py
    Le véhicule Toyota Supra se déplace...
    420 CH
    Le véhicule F22 Raptor se déplace...
```
Et ça fonctionne évidemment sans problème.

Donc là, on a 2 classes filles d'accord qui héritent de la place véhicule, d'accord.

Donc la class Voiture, ça c'est mieux en fait d'accord.

Une voiture a plus de chose que le simple véhicule véhicule, le véhicule, il a juste un nom et une quantité d'essence et une méthode de déplacement.

### Spécialiser une classe et redéfinir ses méthodes

La voiture, elle a plus de choses, elle a un attribut différents. L'avion, il a un attribut en plus et on peut faire également des méthodes différentes.

Par exemple, la voiture, elle pourrais avoir une méthode rouler parce qu'on ne va pas faire rouler un avion à priori même si bon, c'est un avion avec un train d'atterrissage, ce sera un peu différent mais on se doute bien qu'une voiture ne va pas fonctionner pareil qu'un avion, d'accord.

C'est là que ça a tout intérêt justement l'héritage, c'est là que vous voyez un petit peu à quoi ça peut servir.

Il y a aussi une possibilité, la méthode se_deplacer(), elle est assez simple. Admettons justement, je voulais faire ce genre de chose se_deplacer() donc là, par exemple, on pourrait dire qu'un véhicule de base se déplace d'une certaine manière et moi, je pourrais dire, une voiture, elle va se déplacer autrement donc on peut redéfinir une méthode qui existe déjà dans la classe Mère.

Donc là, il faut justement là réécrire. Si je fais ça se_deplacer(), on va réécrire la méthode de la classe Mère, par exemple, j'affiche "Je roule...".

Si c'est pour l'avion, c'est complètement inutile comme type de méthode et là, vous allez voir qu'on ne va pas du tout avoir la même chose.
```py
#coding:utf-8

#Classe Mère
class Vehicule:
   def __init__(self, nom_vehicule, quantite_essence):
       self.nom = nom_vehicule
       self.essence = quantite_essence
       
   def se_deplacer(self):
       print("Le véhicule {} se déplace...".format(self.nom))
      
#classe Fille
class Voiture(Vehicule):
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance
       
   def se_deplacer(self):
       print("Je roule...")
       
class Avion(Vehicule):
   def __init__(self, nom, essence, marchandise):
       Vehicule.__init__(self, nom, essence)
       self.marchandise = marchandise
       
   def se_deplacer(self):
       print("Je survole les airs !")

#Programme principal
voiture1 = Voiture("Toyota Supra", 90, 420)
voiture1.se_deplacer()
print(voiture1.puissance, "CH")

av1 = Avion("F22 Raptor", 2400, "Missiles")
av1.se_deplacer()
```
```powershell
    >python main.py
    Je roule...
    420 CH
    Je survole les airs !
```
Vous voyez, la voiture elle roule alors que l'avion lui, il va survoler les airs.

Donc on a redéfini.

Comment ça fonctionne au niveau exécution du programme et bien au niveau de Python, l'interpréter, comme par exemple ici vous demander, voiture1.se_deplacer(), qu'est-ce qu'il va faire ? il va tout de suite aller dans la classe la plus proche c'est-à-dire la classe ici de voiture donc voiture.

Il va aller dans la classe fille, il va chercher si il y a une méthode se_deplacer(). Si il y a une, et bien il l'appelle. Ici c'est le cas, c'est pour ça qu'il a fait "Je roule..."
```py
    def se_deplacer(self):
        print("Je roule...")
```
Par contre, vous avez vu tout à l'heure quand la méthode n'existait pas ... qu'est-ce qu'il fait ? hé bien, il ne trouve pas la fameuse méthode se_deplacer() donc il remonte à la classe Mère et là, il la trouve et c'est bon.

Et si évidemment, il n'y en a pas non plus la classe Mère, bah vous auriez une erreur et il vous dirait que la méthode n'existe pas, ce qui est parfaitement logique donc voilà l'ordre dans lequel ça fonctionne.

On va toujours chercher les méthodes ou l'attribut, c'est la même chose pour l'attribut, dans la classe fille directement. Si on le trouve pas, on va dans la classe mère donc ce qui est la classe qui est juste au dessus et ainsi de suite parce qu'on peut avoir une classe Mère et une classe Fille qui hérite puis on peut avoir une classe petite Fille qui hérite de la Fille qui elle-même hérite de la Mère.

Je peux très bien par exemple faire dans voiture, j'aurais pu faire un type de voiture encore en mieux, plus spécialisé, en disant par exemple qu'on aurait ... je ne sais pas moi, classe de quoi en voiture ? je ne sais pas ... ça peut être par exemple VoitureSport, d'accord, on peut très bien faire ça d'accord.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_vehicule
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule {} se déplace...".format(self.nom))
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence, puissance):
            Vehicule.__init__(self, nom_voiture, essence)
            self.puissance = puissance
            
        def se_deplacer(self):
            print("Je roule...")
            
    class VoitureSport(Voiture):
            
    class Avion(Vehicule):
        def __init__(self, nom, essence, marchandise):
            Vehicule.__init__(self, nom, essence)
            self.marchandise = marchandise
            
        def se_deplacer(self):
            print("Je survole les airs !")

    #Programme principal
    voiture1 = Voiture("Toyota Supra", 90, 420)
    voiture1.se_deplacer()
    print(voiture1.puissance, "CH")

    av1 = Avion("F22 Raptor", 2400, "Missiles")
    av1.se_deplacer()
```
Comme ça, on a voiture de sport qui héritent de voiture et voiture qui héritent de véhicule. Véhicule hériterait même si on veut à la rigueur d'autre chose.

On peut faire autant d'héritage qu'on veut au niveau de la hiérarchie. Imaginer un espèce d'arbre par exemple si vous devez classifier les animaux, je prend cet exemple-là, ça fonctionnerait pareil. On aurait l'animal, si vous voulez,  voilà tout en haut. Dans les animaux, on aurait des classes fille comme, je sais pas moi, les animaux volants, les animaux les animaux qui sont sur terre, les animaux marins admettons.

Dans les animaux volants, on aurait les oiseaux et puis on en aurait d'autres... je ne sais pas moi, dans les animaux marins, on auraient des mammifères, on aurait des poissons ... enfin voyez des animaux terrestres, on pourrait avoir une classe pour les reptiles, une pour les mammifères, une pour plein de choses, en fait.

Et on peut imaginer comme ça une espèce d'arbre, de hiérarchisation des entités donc des différentes choses, voilà.

Donc ça c'était vraiment la chose à savoir, d'accord, au niveau de l'héritage, que vous pouvez comme ça créé plein d'objets qui héritent d'autres donc qui sont spécialisés. Ils ont tous ce qu'on la classe Mère ou les classes Mère si il y en a d'autres qui hérite encore. Plus des choses en plus que vous leur ajouter.

Si évidemment par exemple vous créer une classe comme ici par exemple voiture et quel a mis, admettons on va enlever tout ça.
```py
    #coding:utf-8

    #Classe Mère
    class Vehicule:
        def __init__(self, nom_vehicule, quantite_essence):
            self.nom = nom_vehicule
            self.essence = quantite_essence
            
        def se_deplacer(self):
            print("Le véhicule {} se déplace...".format(self.nom))
           
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence): #, puissance):
            Vehicule.__init__(self, nom_voiture, essence)
            #self.puissance = puissance
    #        
    #    def se_deplacer(self):
    #        print("Je roule...")
    #        
    #class VoitureSport(Voiture):
    #        
    #class Avion(Vehicule):
    #    def __init__(self, nom, essence, marchandise):
    #        Vehicule.__init__(self, nom, essence)
    #        self.marchandise = marchandise
    #        
    #    def se_deplacer(self):
    #        print("Je survole les airs !")

    #Programme principal
    voiture1 = Voiture("Toyota Supra", 90, 420)
    voiture1.se_deplacer()
    print(voiture1.puissance, "CH")

    av1 = Avion("F22 Raptor", 2400, "Missiles")
    av1.se_deplacer()
```

Admettons j'ai enlevé tout ça, genre je crée une classe voiture, d'accord, elle redéfinit aucune méthode et elle a pas de choses en plus, d'accord. 
```py
    #classe Fille
    class Voiture(Vehicule):
        def __init__(self, nom_voiture, essence):
            Vehicule.__init__(self, nom_voiture, essence)
```
Ca honnêtement, ça ne sert à rien car qu'est-ce qu'elle ferait ? bah ça ne fait que appeler le constructeur Mère donc en fait, ça c'est une classe qui est complètement inutile s'il n'y avait que ça.

C'est vraiment utile de faire des classes héritées si on ajoute des attributs en plus et des méthodes en plus ou alors éventuellement redéfinies, c'est là que ça a unc inctérêt sinon l'héritage, il n'a pas lieu d'être à ce moment-là.

Si on fait juste une simple copie, ici une voiture est parfaitement identique à Vehicule dans ce genre de cas parce que se_deplacer() ne va pas changer et on aura absolument que ces 2 attributs Le, pareil qu'un Vehicule, voilà.

Qu'est-ce que je peux vous dire également ? on va voir également, il y a quelque chose en plus, c'est pas forcément le cas de tous les langages de programmation. Il y en a qui ne propose pas cette fonctionnalité mais en python ça fonctionne. On peut faire de l'héritage multiple, je ne vais pas vous montrer des exemples sinon ça ferait une vidéo un peu plus longue, je pense que c'est pas la peine surtout que je ne  pourrais pas forcément vous donner un cas très bien expliqué.

## Héritage multiple

On peut faire un héritage multiple. Un héritage multiple, qu'est-ce qu c'est ? hé bien vous allez avoir une classe Mère, une première. 
```py
    #coding:utf-8

    #Classe Mère 1
```
Une classe Mère 1, on peut imaginer ... je ne sais moi, qu'est-ce que je pourrais donner comme nom, qui seraient, je ne sais pas ... Item alors je sais que c'est pas trop utilisé ou alors ObjetJeu.
```py
    #coding:utf-8

    #Classe Mère 1
    class ObjetJeu
```
Admettons, vous êtes dans un jeu vidéo, vous avez une classe de base qui concerne tous les objets, d'accord, par exemple, le nom de l'objet, la quantité et je ne sais quoi.

On aurait ce genre de choses alors je ne met rien dedans.
```py
    #coding:utf-8

    #Classe Mère 1
    class ObjetJeu
        pass
```
Oh vous allez avoir une autre classe Mère c'est-à-dire que c'est une classe qui est toute seule, en fait, indépendance qui va être en fait des armes, ok, et on met pass.
```py
    #coding:utf-8

    #Classe Mère 1
    class ObjetJeu
        pass
        
    #Classe Mère
    class Arme:
        pass
```
Je considère qu'ici l'arme est un objet du jeu, d'accord, d'ailleurs c'est un peu bizarre, comment je peux faire ça ? comment je peux faire ça parce que c'est un peu bizarre du coup, c'est pas forcément clair mais peu importe c'est pas grave.

Et on va avoir du coup une classe fille, d'accord, par exemple fusil qui hériterait à la fois de Arme, je met une virgule, et de ObjetJeu, voilà ce genre de choses.
```py
    #coding:utf-8

    #Classe Mère 1
    class ObjetJeu
        pass
        
    #Classe Mère
    class Arme:
        pass
        
    #Class Fille
    class Fusil(Arme, ObjetJeu):
        pass
```
On peut en mettre autant qu'on veut, on peut en mettre 3, 4, 5 autant qu'on veut.
```py
    class Fusil(Arme, ObjetJeu, ...):
```
Alors cet exemple nc'est pas forcément très probants mais dans quel cas ça peut servir ? moi sachez que c'est un exemple qui est facile à retenir, c'est le cas du doctorant d'accord.

Par exemple, imaginer qu'on aurait une classe Etudiant, On aurait une classe Enseignant, on va dire ça, voilà. ET du coup, on aurait une classe Doctorant qui hériterait demx Etudiant et Enseignant.
```py
    #coding:utf-8

    #Classe Mère 1
    class ObjetJeu
        pass
        
    #Classe Mère
    class Arme:
        pass
        
    #Class Fille
    class Fusil(Arme, ObjetJeu):
        pass
    
    #------------------------------------
    class Etudiant:
        pass
    
    class Enseignant:
        pass
        
    class Doctorant(Etudiant, Enseignant):
        pass
```
On a une classe Doctorant qui hériterait demx Etudiant et Enseignant. Pourquoi ? parce que si on dit en terme français, on peut dire qu'un doctorant, c'est une sorte d'étudiant et une sorte d'enseignant. 

Voyez comment ça fonctionne.

Comme par exemple plutôt ici, Fusil est une sorte d'Arme mais en même temps une sorte d'objet du jeu, d'accord. Voilà donc ça c'était vraiment pas forcément très très bien choisi.
```py
    #coding:utf-8
   
    #------------------------------------
    class Etudiant:
        pass
    
    class Enseignant:
        pass
        
    class Doctorant(Etudiant, Enseignant):
        pass
```
A la rigueur, celui là est mieux d'accord.

UGn doctorant c'est à la fois un étudiant et à la fois un enseignant donc il hérite de tout ce qu'est un étudiant et une enseignant avec éventuellement des choses en plus d'accord. Voilà comment ça peut fonctionner cet héritage multiple.

Je ne vais pas faire d'exemple très concret avec plein plein de constructeurs, des méthodes tout ça.

Si un jour, si vous en avez besoin, ça peut être utile.

Sachez qu'il y a des langages de programmation où l'héritage multiple n'est pas disponible donc ça veut dire qu'on peut très bien s'en passer, ça amène même des fois des complications au niveau du développement donc honnêtement si vous pouvez éviter l'héritage multiple, c'est pas plus mal.

Il y a des fois, c'est bien utile mais on peut s'en passer parce qu'il y a plein de language par exemple, le C++, où il y a plein d'autres langages où on peut pas forcément, selon les cas, faire de l'héritage multiple.

Et pourtant les langages fonctionneront très bien de cette manière, voilà. Ca c'est à savoir.

## Les fonctions isinstance et issubclass

Avant de se quitter, on va regarder quelques petites fonctions utiles, au niveau de ça, parce qu'on a vu par exemple qu'on avait fait un objet.

Comment on peut vérifier qu'un objet fait partie d'une classe fille, admettons, dans quel cas, ça peut servir ? ça dépend, vous verrez selon les problèmes que vous aurez à faire.

Moi par exemple je vais faire ma fameuse classe animal ...def __init__() ... donc là, on va refaire du code un petit peu. On va rester sur quelque chose de très simple.
```py
    #coding:utf-8
    
    class Animal:
        def __init__(self, nom):
            self.nom = nom
```
Voilà l'animal mange...
```py
    #coding:utf-8
    
    class Animal:
        def __init__(self, nom):
            self.nom = nom
        
        def manger(self):
            print(self.nom, "mange...")
```
Et là on aurait du coup une classe Reptile qui hérite du coup de Animal, avec self, nom, regime_alimentaire ... même si un animal, il ne peut pas avoir un régime alimentaire mais c'est encore une fois pour avoir quelque chose qui change un peu. Et là, on appel Animal.__init__(self, nom) et on va avoir ensuite self.regime_alimentaire = regime_alimentaire, voilà ce genre de choses.
```py
    #coding:utf-8
    
    class Animal:
        def __init__(self, nom):
            self.nom = nom
        
        def manger(self):
            print(self.nom, "mange...")
            
    class Reptile(Animal):
        def __init__(self, nom, regime_alimentaire):
            Animal.__init__(self, nom)
            self.regime_alimentaire = regime_alimentaire
```
Et lui, il va manger différemment éventuellement, "Le reptile mange", d'accord, on va dire que c'est reptile.
```py
    #coding:utf-8
    
    class Animal:
        def __init__(self, nom):
            self.nom = nom
        
        def manger(self):
            print(self.nom, "mange...")
            
    class Reptile(Animal):
        def __init__(self, nom, regime_alimentaire):
            Animal.__init__(self, nom)
            self.regime_alimentaire = regime_alimentaire
            
        def manger(self):
            print("Le reptile mange...")
```
Et hop, ce genre de chose.

Ce que l'on peut faire, on fait le code principal. On va créer un animal.
```py
    #coding:utf-8
    
    class Animal:
        def __init__(self, nom):
            self.nom = nom
        
        def manger(self):
            print(self.nom, "mange...")
            
    class Reptile(Animal):
        def __init__(self, nom, regime_alimentaire):
            Animal.__init__(self, nom)
            self.regime_alimentaire = regime_alimentaire
            
        def manger(self):
            print("Le reptile mange...")
            
        #Code principal
        lezard = Reptile("Lézard")
```
On lui donne un nom de variable comme le nom de l'animal. Je ne précise pas plus que ça. Regime_alimentaire, ce qu'il peut manger, "grenouilles" et voilà, il est content. Et du coup, on va faire lezard.manger() et on va tester ça.
```py
#coding:utf-8

class Animal:
   def __init__(self, nom):
       self.nom = nom
   
   def manger(self):
       print(self.nom, "mange...")
       
class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire
       
   def manger(self):
       print("Le reptile mange...")
       
#Code principal
lezard = Reptile("Lézard", "grenouilles")
lezard.manger()
```
```powershell
    >python main.py
    Le reptile mange...
```
Voilà le reptile mange, pas de soucis à ce niveau là.

On a donc quelques petites fonctions sympa, d'accord, qui peuvent déjà vérifier si par exemple on a un objet en fait qui est une instance, d'accord, d'une certaine classe.

A quoi ça peut servir ? quand vous avez par exemple un nom de variable, par exemple ici, j'ai mis lezard mais si j'avais mis par exemple animal, on aurait bien aimé savoir si animal est de classe juste animal ou alors est-ce qu'il est vraiment d'une classe spécialisée comme Reptile et cetera.

Donc Regardez ce qu'on peut faire, on va faire tout simplement print() et on va dire isinstance() et donc l'objet c'est lezard, isinstance(lezard,...) et est-il de classe Animal, isinstance(lezard, Animal).
```py
#coding:utf-8

class Animal:
   def __init__(self, nom):
       self.nom = nom
   
   def manger(self):
       print(self.nom, "mange...")
       
class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire
       
   def manger(self):
       print("Le reptile mange...")
       
#Code principal
lezard = Reptile("Lézard", "grenouilles")
print(isinstance(lezard, Animal))
```
```powershell
    >python main.py
    True
```
Voilà, on doit précisé un nom de classe directement sans guillemets.

Donc ici, il vous met True parce que, tout simplement, c'est une fonction qui va vous dire ... alors je vais le noter d'ailleurs pour vous ici.
```py
    #coding:utf-8
    
    """
    Fonctions utiles :
    
    isinstance(<objet>, <classe>)   :   vérifie qu'un objet est de la classe renseignée
    issubclass(<classe_fille>, <classe_mere>)   : vérifie qu'une classe est fille d'une autre
        
    
    """

    class Animal:
        def __init__(self, nom):
            self.nom = nom
        
        def manger(self):
            print(self.nom, "mange...")
            
    class Reptile(Animal):
        def __init__(self, nom, regime_alimentaire):
            Animal.__init__(self, nom)
            self.regime = regime_alimentaire
            
        def manger(self):
            print("Le reptile mange...")
            
    #Code principal
    lezard = Reptile("Lézard", "grenouilles")
    print(isinstance(lezard, Animal))
```
On a isinstance(<objet>, <classe>) et ensuite on va avoir issubclass(<classe_fille>, <classe_mere>) qui est bien pratique et permet de vérifier qu'une classe est fille d'une autre.

Alors on peut faire if isinstance(lezard, Animal), si lezard est une instance de Animal, on dira donc que lezard est un Animal, OK.
```py
#coding:utf-8

"""
Fonctions utiles :

isinstance(<objet>, <classe>)   :   vérifie qu'un objet est de la classe renseignée
issubclass(<classe_fille>, <classe_mere>)   : vérifie qu'une classe est fille d'une autre
"""

class Animal:
   def __init__(self, nom):
       self.nom = nom
   
   def manger(self):
       print(self.nom, "mange...")
       
class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire
       
   def manger(self):
       print("Le reptile mange...")
       
#Code principal
lezard = Reptile("Lézard", "grenouilles")
if isinstance(lezard, Animal):
   print("Lézard est un Animal")
```
```powershell
    >python main.py
    Lézard est un Animal
```
On peut même voir que si je fait (lézard, Reptile), ça marche.
```py
#coding:utf-8

"""
Fonctions utiles :

isinstance(<objet>, <classe>)   :   vérifie qu'un objet est de la classe renseignée
issubclass(<classe_fille>, <classe_mere>)   : vérifie qu'une classe est fille d'une autre
"""

class Animal:
   def __init__(self, nom):
       self.nom = nom
   
   def manger(self):
       print(self.nom, "mange...")
       
class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire
       
   def manger(self):
       print("Le reptile mange...")
       
#Code principal
lezard = Reptile("Lézard", "grenouilles")
if isinstance(lezard, Reptile):
   print("Lézard est un Animal")
```
On peut même voir que si je fait (lézard, Reptile), ça marche.
```py
    >python main.py
    Lézard est un Animal
```
Vous allez me dire, pourquoi ça fonctionne alors que lézard, on l'a instancié comme un Reptile.

Pourquoi il dit que c'est un Animal, pourquoi il dit que ça fonctionne quand on vérifie si c'est une instance d'Animal ? puisque on a créer un Animal quand vous regardez.
```py
    Animal.__init__(self, nom)
```
Un Animal, on peut imaginer que c'est un peu un petit bout de notre lézard c'est-à-dire qu'on a créer une espèce de petite boîte où on a mis le nom du lézard en fait, d'accord.

La petite boîte qui possède tous les attributs et les méthodes de Animal, ça crée une petite boîte ensuite on a créé une petite boîte pour le Reptile avec ici le régime alimentaire et on a en gardant tout ça ensemble dans une autre boîte, on met tout ça ensemble et ça forme notre fameux lézard, d'accord.

Donc ça c'est important quand vous avez une classe fille comme ça, en fait, il ne faut pas imaginer que vous avez qu'un seul objet en fait enfin qu'une seule boîte avec tout dedans.

Vous avez vraiment ici à la fois la boîte de reptile et la boîte d'animal, d'accord rappelez-vous que une classe fille, elle est toute la classe mère plus autre chose donc c'est d'abord la classe mère et ensuite avec des choses en plus, c'est pour ça que ça fonctionne si on vérifie par exemple que lezard est une instance d'Animal même si j'ai juste ça.
```py
    lezard = Reptile("Lézard", "grenouilles")
```
Parce que oui Reptile est une sorte d'Animal okay et du coup on peut vérifier ça.
```py
#coding:utf-8

"""
Fonctions utiles :

isinstance(<objet>, <classe>)   :   vérifie qu'un objet est de la classe renseignée
issubclass(<classe_fille>, <classe_mere>)   : vérifie qu'une classe est fille d'une autre
"""

class Animal:
    def __init__(self, nom):
        self.nom = nom
    
    def manger(self):
        print(self.nom, "mange...")
        
class Reptile(Animal):
    def __init__(self, nom, regime_alimentaire):
        Animal.__init__(self, nom)
        self.regime = regime_alimentaire
        
    def manger(self):
        print("Le reptile mange...")
        
#Code principal
lezard = Reptile("Lézard", "grenouilles")
if issubclass(Reptile, Animal):
    print("Reptile hérite d'Animal")

``` 
Donc là, c'est une autre vérification.
```py
    >python main.py
    Reptile hérite d'Animal
```
Voilà, donc ça permet de vérifier par exemple qu'une classe est bien une classe fille d'une autre donc c'est une petite vérification comme ça qui peut être utile.

2 petites fonctions comme ça intéressante pour vous.

La première pour vérifier qu'un objet est bien une instance d'une certaine classe en particulière, c'est pour contrôler un petit peu la classe d'un objet et l'autre qui permet carrément de savoir si une classe est bien fille de l'autre.

Donc si jamais ça vous est utile, hé bien vous avez ces fonctions-là. Il y en a d'autres, il y a plein plein de fonctions de toute manière par rapport à tout ce qui est objet en python mais je vous donne celles-là parce qu'elles sont assez utilisés dans certains cas, comme ça vous avez tout ce qu'il faut à ce niveau là.

Bah écoutez on va s'arrêter là maintenant, je trouve que j'ai déjà été assez long mine de rien pour un concept qui est quand même assez rapide a expliqué parce ce qu'il y a pas grand chose mais je voulais quand même bien prendre le temps de vous donner de petits exemples au moins en tout cas sur l'héritage simple parce que c'est mieux à la rigueur de passer plus de temps dessus mais que ce soit très bien compris par tous le monde à la fin plutôt de vite expédié ça parce que c'est quelque chose de simple et que la moitié n'est pas vraiment compris l'intérêt où l'utilité de l'héritage.

Donc pour résumer rapidement, l'héritage rappelez vous c'est quand vous pouvez dire par exemple qu'une classe est une sorte d'une autre classe donc par exemple Reptile est une sorte d'Animal, vous avez une relation. 

L'avantage c'est qu'on peut créer euh si vous voulez un type de classe qui hérite de toute une classe mère et sur laquelle on peut spécialiser c'est-à-dire on peut ajouter des attributs supplémentaires, des méthodes supplémentaires, voir redéfinir des méthodes déjà existantes et ça permet comme ça d'améliorer, de créer une espèce de hiérarchie de nos classes donc de nos objets donc c'est pratique quand on fait bah voilà des vrai programme un peu plus complet, ça permet de bien organiser tout ça.

Voilà voilà maintenant vous avez appris cette nouvelle notion d'héritage, elle vous servira dans d'autres langages de programmation même si la syntaxe sera différente ou qu'il n'y aura pas forcément d'héritage multiple ... sachez que ce que vous avez appris au niveau de l'héritage, vous servira dans tous les autres langages de programmation que vous pourrez éventuellement apprendre qui parleront également d'héritage.

Moi je vais vous laisser avec ça, on se dit à la prochaine.

Je pense que pour la prochaine vidéo, on va commencer à voir un petit peu des exemples d'objets puisque maintenant que vous savez bien ce que c'est, qu'on a vu pas mal de notions on va revenir sur des objets que vous manipulez plus de début notamment les chaînes de caractères, on va parler un peu des listes, on va parler des tuples, ça c'est quelque chose de nouveau pour vous. Vous ne savez pas ce que c'est et on parlera bien évidemment des fichers tout ça parce que les fichiers sont également des objets en python.

On va pouvoir un peu pas mal d'exemples là dessus et après on poursuivra un peu notre évolution sur tout ce qui est objet puis à la suite de la formation évidemment sur ce langage python.

A très bientôt tout le monde et n'hésitez pas entraîner vous bien, laisser des commentaires s'il y a des choses qui ne sont pas assez clairs et on se retrouvent pour la prochaine vidéo.

A bientôt tout le monde 

## Resume

```py
###############################################
#################### Resume ################### 
###############################################
#coding:utf-8

# Python #14 - heritage
# https://youtu.be/jS-S0hbUoQo
# Parlons d'Héritage, un des concepts en Programmation Objet qui a toute son importance pour hiérarchiser un ensemble de classes.

"""
(Vu jusqu'a maintenant)

Comment definir des classes.
Instancier des objets.
Comment gerer leur attribut.
Faire des proprietes sur les attributs pour controler les acces, les modifications.
Comment faire des methodes.
... toutes les bases de la programnation oriente objet.

Nouveau concept : l'héritage.
C'est une manière de créer des classes fille. On a une classe de départ, la classe mère.
On va voir des classes qui hérite de la classe Mère, des classes filles.

En résumé,
L'héritage, c'est quand on peux dire qu'une classe est une sorte d'une autre classe.
Reptile est une sorte d'Animal. On a donc une relation.
L'avantage c'est qu'on peux créer un type de classe qui hérite de toute une classe Mère
et sur la quelle on peut spécialier (ajouter des attributs supplémentaires, des méthodes
supplémentaires, voir redéfinir des méthodes déjà existante) et ça permet d'améliorer,
de créer une hiéarchie de nos classes, de nos objets. C'est pratique quand on fait de vrai
programme, un peu plus complet. Ca permet de bien organiser tout ça. 

Cette notion d'héritage servira dans d'autres langages de programmation différents ou il n'y
aura pas forcément d'héritage multiple mais qui parleront d'héritage.

Dans la prochaine vidéo,
Voir des exemples d'objets. Revoir des objets qu'on voit depuis le début, notamment les 
chaînes de caractères. On va voir les listes, les tupes et les fichiers. Les fichiers sont
également des objets en Python. """

import os
os.system("cls")

#1# Création d'une classe Fille.
#   ----------------------------
#

"""
On aura une Classe Mère et une Classe Fille, une classe qui va hériter d'un véhicule.
Qu'est-ce qu'une classe Fille dans un système d'héritage ? Notre Classe Fille sera une sorte de la Classe Mère.
On met les classes ici dans le même fichier mais quand on veux faire ça proprement, on met les classes dans plusieurs fichiers.
On les met toutes dans le même fichier pour ne pas alourdir les explications ...

"""
#Classe Mère
class Vehicule:
   def __init__(self, nom_vehicule, quantite_essence):
       self.nom_vehicule = nom_vehicule # On crée une classe Vehicule, son constructeur.
       self.essence = quantite_essence # On part du principe que le véhicule va fonctionner avec un système d'essence (pas de manière mécanique ou à pédale).
   def montrer_veficule(self):
       return self.nom_vehicule
   def se_deplacer(self):
       print("Le véhicule se déplace ...")
"""
... pour dire que notre classe Fille hérite d'une classe, 
il suffit d'ouvrir des parenthèses. Et on met la classe mère entre parenthèse.
Voiture est une classe qui hérite de Vehicule. Voiture est une sorte de Véhicule.
C'est une manière d'illustrer l'héritage en programmation objet.
Si on est capable de dire que notre classe qu'elle est une sorte d'autre classe, penser l'héritage.
Si on a deux classes créées comme ça, l'une indépendante de l'autre. 
Si on voit qu'une classe est une sorte d'autre classe, c'est qu'on va pouvoir créer une relation d'héritage.
"""
""" Comment créer cette classe Fille ? On peut lui mettre n'importe quoi comme nom. Ensuite sans
accesseur, on affiche. On affiche bien le nom du véhicule, une véhicule pour les airs, un avion de chasse.
On peut en créer un autre même si la classe Véhicule n'est pas assez précise. 
On crée une espèce de véhicule de voiture et on affiche autre chose.
On a déjà vu comment créer des objets et afficher un de leurs attributs. 
Du coup ce n'est passez clair et puisque Voiture est une sorte de Vehicule donc je peux créer ce fameux héritage
... """
#Classe Fille
""" ... cette classe de Voiture est une spécialisation de la classe de Vehicule. Cela signifie
que notre classe Voiture va avoir tous les attributs (nom et essence) et toutes les méthodes du
Vehicule. Si on avait fait des méthodes (se déplacer, ect), la Voiture les auraient automatiquement.
Si on avait besoin de recréer une méthode, on l'ajouterais à la classe Mère et automatiquement 
la Classe Fille en hériterait.
"""
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   pass

#Programme Principal
v1 = Vehicule("F22 Raptor", 2400)
v2 = Vehicule("Toyota Supra", 90)
print(v1.nom_vehicule)
print(v2.nom_vehicule)

#2# Héritage.
#   ---------
#

#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom # On crée une classe Vehicule, son constructeur.
       self.essence = quantite_essence # On part du principe que le véhicule va fonctionner avec un système d'essence (pas de manière mécanique ou à pédale).
   def se_deplacer(self):
       print("Le véhicule {} se déplace ...".format(self.nom))
       """ Formation à venir : Nous verons plutard que la chaîne de caractères
       est un type d'objet du Langage Python. A voir une vidéo sur tout ce qui est 
       chaîne de caractères lors d'utilisation de méthodes qui leur appartient
       comme format()."""


#Classe Fille
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   def __init__(self, nom_voiture, essence, puissance):
       """ Comment allons nous faire au niveau de l'instanciation ? Il ne faut pas définir self.nom
       et self.essence parce que le constructeur de la Classe Mère le fait déjà, donc il faut appeler 
       le constructeur de Véhicule : """
       Vehicule.__init__(self, nom_voiture, essence)
       """ On passe les paramètres de la Voiture à l'appel de la fonction __init__() sans oublier le self. 
       Comme ça, il va l'appeler directement. Ici les noms ne sont pas les mêmes. 
       Ensuite, on fait l'attribut que l'autre Vehicule n'a pas. On le crée : """
       self.puissance = puissance

#Programme Principal
v1 = Vehicule("F22 Raptor", 2400)
v1.se_deplacer();
""" Pour créer une voiture, on utilise la classe Voiture. 
Il nous faut créer un constructeur de la même manière que la classe Vehicule pour
lequel on est obligé de remettre tous les attributs de la classe Mère. 
On est cependant pas obligé de remettre les mêmes paramètres de fonctions (self, nom_voiture, essence).
Ensuite on peux rajouter d'autres attributs. Qu'est-ce qu'un Voiture a en plus ?
Qu'est-ce qu'elle va avoir de plus qu'un simple Véhicule ? On part du principe qu'un Vehicule
a juste un nom et une certaine quantité d'essence, c'est tout. Il a pas d'autres informations 
qu'on juge utile. Je veux que la Voiture ai d'autres informations en plus comme la puissance en chevaux.
Un Véhicule standard n'as pas forcement un certains nombre de chevaux,ca n'aurait aucun intéret de mettre
ça dans Vehicule, c'est pourquoi on met ça dans une classe spécialisée. Voiture est une sorte de
Véhicule en mieux. Voiture a tout ce que peux faire un Vehicule avec ses attributs avec des choses en plus."""

""" La définition de l'héritage, c'est le fait de spécialiser une classe pour la compléter en attributs
et en méthodes. Et une classe Fille est une sorte de la classe Mère. C'est comme ça qu'on crée cette
relation d'héritage."""

""" On appele ici le constructeur qui va commencer automatiquement par la classe Fille.
Donc il va lire le constructeur et il va faire appel au constructeur de la classe Mère Vehicule.
Il va instancier et ensuite il va finir avec les attributs de la classe Fille. 
Et on obtiendra bien un objet de classe Voiture. Ensuite on ajoute les paramètres "Toyota Supra", etc. """
voiture1 = Voiture("Toyota Supra", 90, 420)
""" Ensuite, on peux faire déplacer la voiture sans avoir recréé/redéfinis la méthode se_déplacer.
Cette méthode n'est que dans la classe Vehicule. Pourtant Voiture n'est pas un Vehicule. 
C'est vraiment une Voiture. Et malgré cela, l'objet permet d'appliquer cette méthode grâce à l'héritage."""
voiture1.se_deplacer()
""" Ainsi le Vehicule "Toyota Supra" reprend bien le nom en utilisant la méthode la méthode de
Vehicule et il affiche "se déplace ..." et maintenant affichons sa puissance : """
print(voiture1.puissance)
print(voiture1.puissance, "CV")

#3# Héritage (suite).
#   -----------------
#

""" Il faut bien faire attention à la syntaxe. Il faut appeler le constructeur de la classe Mère.
Et ne pas oublier de passer le self. Pourquoi ne pas faire juste une classe Voiture ? 
Dans la quel, on ajoute le nom, l'essence, la puissance et puis une méthode se_deplacer().
Et pourquoi ne pas faire une autre classe du genre Avion avec pareil le nom et l'essence ?
Tout simplement pour éviter la répétition de code. Cela permet d'avoir une hiearchie au niveau de
nos classes. C'est à dire on a une classe tout en haut et on va avoir des classes spécialisées.

Dans un jeu vidéo, on pourrait avoir une classe entité (= une espèce de personnage qui peux bouger 
dans un jeu). On pourrait spécifier ensuite (faire une classe Fille) qui serait le joueur (celui
que l'on pourrait jouer), puis une autre classe Fille qui serait le PNJ, puis une autre classe Fille
qui serait le boss d'un jeu, etc. Voilà on peux ainsi spécialiser d'une certaine manière dans la mesure 
ou la voiture pourrait avoir des choses en plus que la class Vehicule. """

#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
   def se_deplacer(self):
       print("Le véhicule {} se déplace ...".format(self.nom))

#Classes Fille
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance

class Avion(Vehicule):
   def __init__(self, nom, essence, marchandise):
       Vehicule.__init__(self, nom, essence) # On appelle le constructeur de la classe Mère...
       self.marchandise = marchandise # ... on ajoute tous les attributs en plus, supplémentaire.

#Programme Principal
av1 = Avion("F22 Raptor", 2400, "Missiles")
av1.se_deplacer()

""" Jusqu'ici, on a deux classes Filles qui hérite de la classe Vehicule. Donc Voiture est Avion (attributs et méthodes en plus)
sont mieux car ils ont plus de chose que le simple Vehicule (nom, quantite_essence et une méthode de déplacement). 
Ainsi on se doute bien qu'une Voiture ne fonctionnera pas comme un Avion d'où l'intérêt de l'héritage.
"""

#4# Redéfinir une méthode.
#   ----------------------
#
""" Au niveau de la méthode se_deplacer(), on constate qu'elle est assez simple. 
On pourrait dire qu'un Vehicule de base se déplace d'une certaine manière mais qu'une Voiture
pourrait se déplacer autrement. 
Ainsi on peux redefinir une méthode qui existe déjà dans la classe Mère.
Donc on peux la réecrire ... """
#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
   def se_deplacer(self):
       print("Le véhicule {} se déplace ...".format(self.nom))

#Classes Fille
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance
   """ Réécrire la méthode se_deplacer de la classe Mère : """
   def se_deplacer(self):
       print("Je roule !")

class Avion(Vehicule):
   def __init__(self, nom, essence, marchandise):
       Vehicule.__init__(self, nom, essence) # On appelle le constructeur de la classe Mère...
       self.marchandise = marchandise # ... on ajoute tous les attributs en plus, supplémentaire.
   """ Réécrire la méthode se_deplacer de la classe Mère : """
   def se_deplacer(self):
       print("Je survole les airs !")

#Programme Principal
voiture1 = Voiture("Toyota Supra", 90, 420)
voiture1.se_deplacer()
av1 = Avion("F22 Raptor", 2400, "Missiles")
av1.se_deplacer()

""" Comment cela fonctionne au niveau exécution du programme ? Au niveau de Python, l'interprêteur,
comme on lui demande se_deplacer(), il va tout de suite aller dans la classe la plus proche.
C'est à dire la class Voiture quand on fait "voiture1.se_deplacer()". Il va aller dans la classe Fille,
il va chercher si il y a une méthode déplacer et si il y en a une, ben il l'appelle.
Dans notre exemple, c'est cas ! 
Mais si l'interprêteur ne trouve pas la méthode se_deplacer() ben il remonte à la classe Mère.
Et si il n'y en a pas non plus dans la classe Mère, on obtient une erreur que la méthode n'existe pas.
Voici l'ordre tel que ça fonctionne, on va toujours chercher les méthodes ou l'attribut (même chose)
dans la classe Fille directement et si on le trouve pas, on va dans la classe Mère, c'est à dire
la classe qui est juste au dessus.
On peut avoir une classe Mère et une classe Fille qui hérite mais on peux aussi avoir une classe petite Fille
qui elle-même hérite de la Mère. En effet on aurait pu faire un type de Voiture en mieux, encore plus spécialisé.

"""

#5# Création d'une classe petite-Fille.
#   -----------------------------------
#

#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
   def se_deplacer(self):
       print("Le véhicule {} se déplace ...".format(self.nom))

#Classes Fille
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)
       self.puissance = puissance
   def se_deplacer(self):
       print("Je roule !")

""" Classe petite-Fille VoitureSport qui hérite de Voiture et Voiture qui hérite de Vehicule.
A la rigueur Vehicule hériterait d'autre chose. On peux faire autant d'héritage que l'on veux 
au niveau de la hiérarchie. Par exemple si on devait classifier les animaux dans un arbre, 
En haut on aurait une classe Mère Animal puis on aurait des classes Filles comme les animaux
volants, les animaux terrestres et les animaux marins. Dans les animaux volants, on aurait les
oiseaux et d'autres. Dans les animaux marins, on aurait des mammifères et des poissons. Dans les animaux
terrestres, on pourrait avoir une classe pour les reptiles, pour les mammifères, etc.
On peut imaginer ainsi une espèce d'arbre d'hiéarchisation des entités. 

Voilà ce qu'il faut savoir sur l'héritage. On peut ainsi créer pleins d'objets qui héritent
d'autres, qui sont spécialisés. Ils ont tout ce que possède la classe Mère plus des choses ajoutés."""
class VoitureSport(Voiture):
   pass

class Avion(Vehicule):
   def __init__(self, nom, essence, marchandise):
       Vehicule.__init__(self, nom, essence) # On appelle le constructeur de la classe Mère...
       self.marchandise = marchandise # ... on ajoute tous les attributs en plus, supplémentaire.
   def se_deplacer(self):
       print("Je survole les airs !")

#Programme Principal
# ...


#6# Une classe Fille inutile.
#   -------------------------
#
""" C'est vraiment utile de faire des classes héritées si on rajoute des attributs ou des 
méthodes en plus. Ou éventuellement, les redéfinir sinon l'héritage est inutile. 

Dans ce genre de cas Voiture est parfaitement identique à Vehicule."""
#Classe Mère
class Vehicule:
   def __init__(self, nom, quantite_essence):
       self.nom = nom
       self.essence = quantite_essence
   def se_deplacer(self):
       print("Le véhicule {} se déplace ...".format(self.nom))

""" 
Créons une classe Voiture qui n'aurait redéfinis aucunes méthodes et qui n'aurait rien en plus.
Cette classe ne servirait à rien. En effet se_deplacer ne va pas changer et on aura que les deux
attributs nom et essence. 
"""
#Classes Fille
class Voiture(Vehicule): # Voiture est une classe qui hérite de Vehicule.
   def __init__(self, nom_voiture, essence, puissance):
       Vehicule.__init__(self, nom_voiture, essence)

#Programme Principal
# ...

#7# Héritage multiple.
#   ------------------
#   On peux faire de l'héritage multiple ...

#Classe Mère 1
class ObjetJeu: #... C'est d'abord une classe Mère 1 dans un jeu video. C'est une classe de base qui concerne tous les objets (nom, quantité, etc). """
   pass

#Classe Mère
class Arme: # ... une autre classe Mère, toute seule et indépendante, ou l'on considère que Arme n'est pas un objet du jeu. """
   pass

#Classe Fille
class Fusil(Arme, ObjetJeu): # Une class Fille qui hériterait à la fois de Arme et de ObjetJeu, séparé par une virgule. On peut en mettre autant qu'on veux (3, 4, 5, etc) mais dans quel cas ça peut servir ? ..."""
   pass

# ------------------------------------------------

"""... par exemple, dans le cas du Doctorant ! """
class Etudiant:
   pass

class Enseignant:
   pass

class Doctorant:
   pass

""" On aurait une classe Doctorant qui hériterait de Etudiant et Enseignant. 
On peut dire qu'un doctorant c'est une sorte de d'étudiant et également une sorte 
d'enseignant.

Comme par exemple (c'était pas très clair), Fusil est une sorte d'Arme et une sorte d'ObjetJeu.

Un Doctorant est à la fois une sorte d'Etudiant et d'Enseignant. Il hérite d'un Etudiant
et d'un Enseignant avec éventuellement des choses en plus.

Python est bien utile pour l'héritage multiple car certains langages de programmation ne 
dispose pas de ce principe. Ca peut même des fois mener à des complications au niveau du 
développement, c'est pourquoi on s'en passe. Si on peut éviter l'héritage multiple, ce n'est 
pas plus mal. Par exemple, on ne peux pas faire de l'héritage multiple en C++ même si ces langages
fonctionnent très bien sans. """

#8# Fonctions utiles.
#   ------------------
#   Comment peut on vérifier qu'un objet fait partie d'une classe Fille ?

"""
Fonctions utiles :
   isinstance(<objet>, <classe>) : Vérifie qu'un objet est de la classe renseignée. Test qu'un objet est bien une instance d'une classe en particulier. Ca permet la classe d'un objet.
   issubclass(<classe_fille>, <classe_mère>) : Vérifie qu'une classe est fille d'une autre.

"""

#-1- isinstance(<objet>, <classe>)
#

class Animal:
   def __init__(self, nom):
       self.nom = nom

   def manger(self):
       print(self.nom, "mange ...")

class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire

   def manger(self):
       print("Le reptile mange ...")

# Code principal
lezard = Reptile("Lézard", "grenouilles") # -> On lui met un nom de variable comme l'Animal, on ne précise pas.
lezard.manger()
""" Il existe des fonctions sympa pour vérifier si un objet est une instance d'une certaine 
classe. A quoi cela servir ? Si par exemple, on a un nom de variable, si "lezard = Reptile()"
avait été remplacé par "animal = Reptile()", on aurait aimé savoir si animal est de classe
juste Animal ou s'il est d'une classe spécialisée comme Reptile, etc. On test si lezard est une
instance de Animal. Il ne faut pas mettre de double guillements "Animal" parce qu'il faut 
précisé un nom de classe directement. """

""" On teste si lezard est une instance de Animal, si oui, lézard est un Animal. """

print(isinstance(lezard, Animal))

if isinstance(lezard, Animal): 
   print("Lézard est un Animal.")

if isinstance(lezard, Reptile): 
   print("Lézard est un Animal.")

""" Si on fait avec Reptile, ça marche aussi. 
Pourquoi ça marche aussi alors que Lézard, on l'instancie comme un Reptile ?
Pourquoi cela fonctionne quand on vérifie si c'est une instance d'Animal ?
Parce que on a créé un Animal. Il faut imaginer qu'on créé une petite boîte 
dans lequel on a mis le nom du Lézard. Petite boîte qui possède tout les attributs
et méthodes de l'Animal. Ensuite on a créé une autre petite boîte pour le Reptile (
avec ici le regime_alimentaire). Et en mettant tout ça ensemble, on forme notre 
fameux lezard.

Quand on a notre classe Fille comme ça, il ne faut pas imaginer qu'on a qu'une boîte
avec tout dedans. On a ici à la fois, la boîte de Reptile et la boîte d'Animal. 
La classe Fille est toute la classe Mère plus autre chose. C'est pourquoi cela 
fonctionne si on vérifie que lezard est une instance de Animal. 

Reptile est donc effectivement une sorte d'Animal. """

#-2- issubclass(<classe_fille>, <classe_mère>) 
#

class Animal:
   def __init__(self, nom):
       self.nom = nom

   def manger(self):
       print(self.nom, "mange ...")

class Reptile(Animal):
   def __init__(self, nom, regime_alimentaire):
       Animal.__init__(self, nom)
       self.regime = regime_alimentaire

   def manger(self):
       print("Le reptile mange ...")

# Code principal
lezard = Reptile("Lézard", "grenouilles")
lezard.manger()
""" Vérifier qu'une classe est bien une classe Fille d'une autre."""
if issubclass(Reptile, Animal):
   print("Reptile hérite d'Animal.")
```