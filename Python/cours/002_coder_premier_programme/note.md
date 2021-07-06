#coding:utf-8
# [2. Coder premier programme](https://www.youtube.com/watch?v=S1SDhbJwfdk)
> Dans cette deuxième séance, vous allez apprendre à créer votre premier programme Python (afficher du texte à l'écran) et à l'exécuter directement en ligne de commandes.

+ [Introduction](#Introduction)
+ [Créer un fichier](#Créer-un-fichier)
+ [Définir l'encodage de nos fichiers](#Définir-encodage-de-nos-fichiers)
+ [Afficher du texte avec la fonction print](#Afficher-du-texte-avec-la-fonction-print)
+ [Atteindre le bon répertoire](#Atteindre-le-bon-répertoire)
+ [Appeler la commande python](#Appeler-la-commande-python)
+ [Recommandation sur les quottes](#Recommandation-sur-les-quottes)
+ [Afficher du texte - suite](#Afficher-du-texte---suite)
+ [Passer à la ligne](#Passer-à-la-ligne)
+ [Faire une tabulation](#Faire-une-tabulation)
+ [Conclusion](#Conclusion)

## Introduction

Deuxième séance sur le langage Python.

Maintenant qu'on a installer tout notre matériel, c'est-à-dire notre petit éditeur de code, que notre interprêteur Python est bien installé et fonctionnel, on va pouvoir créer notre premier programme et faire nos premier pas en Python.
    
Pour Windows il faut vérifier dans notre panneau de configuration > options de l'Explorateur de fichiers (que ce soit sur Linux ou Mac, il n'y a pas besoin de faire ça, tout est déjà fonctionnel) > onglet Affichage et vérifier que la ligne "Masquer les extensions des fichiers dont le type est connu" est bien décochée.

```py
# Afficher les extensions : 
# Panneaux de configuration > Options des dossiers > Affichage > Masquer les extensions des fichiers dont le type est connu.
```
    
Il ne faut surtout pas la cocher, ça va être utile pour la suite.
C'est valable également pour les autres formations comme ça on pourra faire sans problème des changement d'extension sur nos fichiers parcequ'elles seront affichées.
    
## Créer un fichier

On va pouvoir maintenant créer notre fichier et travailler dessus.
On crée un document texte et affiche l'extension ".txt" puisqu'on affiche les affichent les extensions.
On va l'appeler script.py, "py" est l'extension affiché en Python.
On ouvre ce fichier avec un éditeur de code et on ouvre un invite de commande, le terminal, le Shell peu importe notre OS.
    
## Définir encodage de nos fichiers
  
On va pouvoir tester certaines choses, on va avoir trois point dans cette vidéo :
La première chose, c'est l'encodage, c'est ce qui va gérer les caractères affichés au niveau de notre programme, au niveau de notre logiciel, au niveau de tout. Même l'éditeur de code utilise un certains encodage qui est normalement écrit en bas de l'éditeur. Dans tous les cas, ça va gérer des caractères. 
    
En informatique, en programmation, il est recommandé d'utiliser l'unicode, l'encodage UTF-8 puis son gros avantage, est qu'il va gérer toutes les langues du monde pour pouvoir afficher du chinois, de l'arabe, du russe, tout les autres alphabets du monde, pour pouvoir afficher surtout les caractères accentués. Les langues comme l'anglais n'ont pas d'accents, ce qui fait que les encodages souvent mis par défaut ne gèrent pas les accents, ne permte pas e les afficher dans le terminal, dans notre invite de commande.

```py
#coding:utf-8
```

Du coup, on va vérifier l'encodage, on va mettre un dièse "#", le mot "coding", deux point ":" et on met "utf-8". On met cette ligne toujours en début de fichier pour être tranquille.
    
Depuis la version 3.0 de Python, l'encodage par défaut est UTF-8. Il a été mis directemenet sur celui là car on le recommande de l'utiliser. Par contre si on utiliserais une version antérieur, il ne le serrait pas.
    
Il est quand même recommandé que même sur une version au dessus de la 3.0 de mettre cette ligne pour être sûr de toujours travailler sur le bon encodage.
    
Il est recommandé également de suivre cette formation avec Python 3 et des.
Mais si vraiment, on pas le choix et qu'il faut rester sur une version 2 et des.
Mais voilà si on est débutant dans ce langage, il est recommandé de prendre la version 3. On est ainsi tranquille si on prend une version supérieur à la 3.
    
Ainsi, on met cette ligne là, on définis bien l'encodage UTF-8. Pas de problème, c'est une sécurité en plus.
    
## Afficher du texte avec la fonction print

Voilà maintenant comment afficher quelque chose à notre écran.
On va taper le mot print() qui est une fonction en Python.
On verra plus tard, ce qu'est une fonction en Python.
Après print, on ouvre et on ferme des parenthèses, idem pour des doubles quottes dans cette petite bulle. Les doubles quottes, c'est pour du texte. A partir du moment où il y a du texte, il faut des doubles quottes ou bien des simple quottes.

```py
#coding:utf-8
print('Bonjour tout le monde !')
print('L\'envers du décor !')

print("L'envers du décor !")
```

On va tester notre premier programme en Python et si on a créer notre fichier sur le bureau, il faut que dans le terminal, on soit dans le répertoire où se trouve notre fichier sinon ça ne marchera pas. Si on essaye de l'exécuter, le fichier ne serra pas trouvable, l'interprêteur nous mettra "No surch file in the directory" ou alors "fichier introuvable".
    
## Atteindre le bon répertoire

Donc il faut taper la commande CD, que le soit sur Linux, Mac, c'est la même.
Et on tape le chemin vers notre bureau :

```powershell
CD Desktop
```

Pour info, on fait un petit DIR ou LS sur Linux ou Mac. Pour lister les fichier, on peut voir que script.py est bien présent donc on va pouvoir travailler dessus.
    
## Appeler la commande python

On appelle la commande "python" qui fonctionnait à la séance précédante car elle a été ajoutée à la variable d'environnement PATH. On ainsi plus besoin de taper le chemin vers Python comme il a été installé dans les programs files ou autre chose. 
    
```powershell
python script.py
```
        
On entre cette commande dans un terminal et avec enter on exécute ce premier programme Python. Si on arrive à cet endroit, c'est que tout a bien été installé et que tout fonctionne.
   
## Recommandation sur les quottes
    
On niveau des simples quottes, il y a une particularité car ce n'est pas forcément très conseillé parce que si on met par exemple :

```py
print('L'envers du décor !') 
```

On remarque qu'il y a un soucis de couleur au niveau de l'éditeur de texte parce que mon apostrophe est une simple quotte. 
    
Donc pour lui, la fin de la chaîne est comme ceci : 'L' et du coup ..envers du décor !'.. n'est plus une chaine et ainsi il y a un symbole qui traîne.
    
D'ailleurs si on essaye de réexecuter son programme ça ne fonctionne pas et indique qu'il y a une erreur de syntaxe.
    
Pour éviter ce genre d'erreur, on peut mettre un anti-slash devant l'apostrophe a ignorer :

```py
print('L\'envers du décor !')
```

Du coup, on résout le problème et on peut afficher sans problème notre texte.
Pour éviter de faire cela à chaque fois car c'est un peu contraignant, il est recommandé d'afficher notre texte avec des doubles quottes :

```py
print("L'envers du décor !")
```   

Dés lors, avec des doubles quottes, on peut mettre de simple quottes tout le temps.
Cela fonctionnera sans qu'il soit nécessaire de mettre d'ati-slash.
C'est donc notre petite astuce au niveau du print().
    
On peut afficher du texte avec des doubles quottes ou des simples mais il est recommandé d'utiliser des doubles quottes comme ça on aura aucun soucis avec les apostrophes dans notre texte surtout qu'on en a beaucoup en langue française.
    
Cela peut se compliquer en mettant des anti-slash "\" partout.

## Afficher du texte - suite
    
Nous auront vu la méthode print() qui permet d'afficher notamment du texte à l'écran. On verra comment afficher autre chose, utiliser cette fonction de manière un peu plus complète cette fonction mais pour le moment on va se contenter d'afficher simplement du texte.
    
Si on met un deuxième print(), le Python qui est un langage interprêteur, va exécuter les lignes une à une, les instructions une à une. On voit bien qu'il les affiche à la ligne à chaque fois.

```py
print("L'envers du décor")
print("Je suis une autre phrase")
```

Mais attention si on fait un print avec un saut de ligne, on remarque que l'interprêteur ne ferra pas un saut de ligne.

```py
print("L'envers du décor")
print("Je suis une autre phrase")

print("Une énième phrase")
```

Python ne prend pas en compte les espaces, les blancs dans notre programme.
C'est pour nous, pour prendre l'habitude de bien aérer un code.
C'est pour que tout ne soit pas sérrer et qu'on puisse bien aérer notre code.
Pour l'interprêteur, c'est comme çi, on avait fait :     

```py
print("L'envers du décor")
print("Je suis une autre phrase")
print("Une énième phrase")
```

Ca ne changera strictement rien mais c'est important de le préciser.
Donc la fonction print() passe à chaque fois la ligne dés qu'il a terminé d'afficher notre texte.
    
Ce que l'on va voir ici, c'est ce qui fonctionne avec Python 3.x.
Sur l'ancienne version de Python 2.x, le print s'affichait comme ceci :

```py
print "Bonjour"
```

On ne mettait pas de parenthèse, le texte s'affichait directement de cette manière.
    
On voit cela car il est possible qu'un jour, on modifie un programme qui a été fait dans une version 2.x et trouver ce genre de ligne.
    
Ce n'est pas une erreur de programmation mais c'est juste une ancienne version de Python. Ainsi ils ont gardé les deux versions différentes. On constate qu'il y a ainsi une sacré différence.
    
Automatiquement l'interprêteur si on tente d'interprêter :

```py
print "Bonjour"
```

... il nous dira qu'il manque les parenthèses.
Il remarque qu'il manque les parenthèses car on est en Python 3.x.
Ce n'est donc plus compatible.
    
Il faut donc éviter cette syntaxe et travailler sur Python 3.x pour être le plus à jour au niveau du projet Python qu'au niveau du langage.
    
Noter qu'il y a aussi des fonctionnalités qui n'était pas disponible avec Python 2.x parce que cette mise-à-jour a été faite pour apporter un contenu supplémentaire.
    
Ca c'était pour l'affichage.

## Ecrire un commentaire
    
On va voir deux petit caractères très intéressant. On va parler des caractères, une autre chose que l'on peut faire dans un fichier Python et que l'on peut faire dans des langages de programmation.
    
On a besoin de décrire son code, on a besoin de l'expliquer.
On a besoin de montrer aux développeur, à quoi sert ça. Tout simplement parce que si on reprend un code un mois après, on aime avoir des notes.
    
On va donc mettre des commentaires dans le fichiers qui vont tout simplement être ignorer par l'interprêteur du langage Python.
    
Il va voir que ces des commentaires grâce à certains symboles.
Il va passer à coté et va continuer l'exécution du programme sur la suite.
    
Pour afficher un commentaire d'une seule ligne, on met un dièse.

```py
# commentaire d'une seule ligne.
```

C'est comme pour la ligne de l'encodage :

```py  
#coding:utf-8
```  

Bien que l'interprêteur lorsqu'il va analyser cette ligne et qu'il va voir que c'est noté "coding:utf-8", il va la prendre en compte pour voir que l'encodage est définis. En plus, il est tout en haut fichier. C'est la petite exception.
    
En revanche, pour l'interprêteur, la syntaxe :

```py
# commentaire d'une seule ligne.
```    

C'est une syntaxe involontaire, elle va être ignorer.
    
Dans certain cas, on peut retrouver cette syntaxe :

```py
# -*- coding:utf-8 -*-
```   

Des fois, on peut retrouver l'encodage spécifié de cette manière là.
Simplement qu'elle est un peu plus complexe, il faut voir dans quel ordre sont les caractères.
    
La version raccourcie est cette version : #coding:utf-8
Il est recommandé de garder cette version.
    
Pour en revenir aux commentaires, on a un commentaire d'un seule ligne avec un dièse, on écrit un commentaire d'une seule ligne.
    
Si on va à l'autre ligne, l'éditeur change de couleur car il voit que ce n'est plus un commentaire. C'est considéré comme du code que Python doit prendre en compte.
    
Si on a besoin d'afficher un gros commentaire de plusieurs lignes, on met 3 doubles quottes et on écrit notre commentaire :

```py
""" Commentaire sur 
plusieurs lignes.""" 
```

Et on termine avec 3 doubles quottes comme ça, il est ignorer par Python.
On peut ainsi avoir des commentaires sur plusieurs lignes même sur une seule.
    
```py
"""
Test d'affichage avec print()
"""
```
        
On pourra mettre un commentaire sur une simple ligne avec les tripples quottes.
Ca fonctionne évidemment sans problème.
    
Voilà pour les commentaires. On aura souvent l'occasion d'en faire dans nos programmes, c'est utile pour se repérer et expliquer à quoi servent les fonctions que l'on verra plus tard. La documentation aide beaucoup les développeurs.
C'est même indispensable.

## Passer à la ligne
    
Une deux dernières petites astuces à connaître au niveau de l'affichage.
Admettons que l'on veut pouvoir passer à la ligne :
    
        print("L'envers du décor")
        -> L'envers 
        du décor
    
Si on veut pouvoir passer à la ligne après "l'envers", on utilise le symbole "\n".

```py
print("L'envers\n du décor")
```

C'est ce que l'on retrouve notamment dans le langage C, en C++ et dans d'autres langages. 
    
"\n" signifie "new line", c'est pour passer à la ligne.

Si maintenant, on éxécute notre programme, on va passer la ligne.
Ce symbole est écrit au milieu du code dans une autre couleur et va permettre de passer à la ligne.
    
Attention, car ce symbole prend en compte les espaces "L'envers\n du décor".
Précisont qu'en programmation, un espace est un caractère.
Ce n'est pas parce qu'on ne voit rien à l'écran qu'il n'y a rien au niveau de la programmation. Cette espace est éffectivement bien prit en compte.
    
D'ailleurs si on fait : 
    
        print("L'envers \n du décor")
        ->
        L'envers 
         du décor
    
On ne le voit pas mais après "L'envers", il y a un espace qui a bien été prit en compte. Un espace qui s'affiche, bien qu'on ne le voit pas, après "l'envers".
    
Ce sont ce que l'on appelle des espaces blancs qui sont prit en compte en informatque.
    
## Faire une tabulation
    
On a vu comment passer à la ligne et pour faire une tabulation.
Une tabulation, c'est un retrait, un alinéa.
On fait la même chose sauf que d'avoir un \n, on fait \t :

```py
print("L'envers\t du décor !")
```

Dés lors ce qu'on compile, le texte se fait avec un alinéa.
Ca peut être pratique pour présenter des choses, pour mettre en page si on veut faire quelque chose dans le terminal.
    
Ainsi, il est recommandé de connaîte :
        \n pour le passage à la ligne ;
        \t pour la tabulation.
        
## Conclusion
    
On a vu ce qu'il y a avait à voir pour commencer.
On a vu comment afficher du texte en dur avec la fonction print().
On verra qu'on pourra faire d'autres petites choses par la suite.
On sait définir l'encodage de nos fichiers. C'est pour être tranquille.
C'est une sécurité supplémentaire.
On sait aussi laisser des commentaires sur nos fichiers pour tout simplement documenter notre code. Ca ne sert pas pour le moment mais ça nous servira par la suite.
    
Dans la prochaine vidéo, nous allons parler des variables qui est la notion la plus importante de toute la formation.
    
On verra que ça fait tout le langage et que ça permet de travailler sur des données et on va pouvoir comme ça stocker des informations et les utiliser à notre convenance et les exploiter.
    
```py
""" ............................... Résumé, ancien visionnage de la vidéo ..................................."""

##1## définir l'encodage de nos fichiers.

#coding:utf-8 
"""
C'est une ligne avec un dièse qui est prise en compte (n'est pas un commentaire).
-*- coding:utf-8 -*- # autre façon de spécifier l'encodage.
"""
##2## documenter un code en Python.

# commentaire d'une seule ligne.
""" 
    Commentaire sur plusieurs lignes.
"""   

##3## afficher du texte avec la fonction print.

# l'unicode, encodage UTF-8 permet de gérer les caractères accentués (non présent en anglais), 
# toutes les langues du monde.

print('Bonjour tout le monde !')
print('L\'envers du décor !')

print("L'envers du décor !")
# Language interprété. Les instructions, les lignes sont éxécutées une à une. 
# Lecture séquentiel qui ne prend pas en compte les blancs/saut de ligne.
# print "L’envers du décor !" # Syntaxe avant la version 3.0.

# Les espaces sont des caractères.
print("L'envers\n du décor !") # passage à la ligne.
print("L'envers\t du décor !") # tabulation, retrait, alinea.

##4## Bonus : afficher les extensions.
"""
Afficher les extensions : 
    Panneaux de configuration 
    > Options des dossiers 
    > Affichage 
    > Masquer les extensions des fichiers dont le type est connu.
Créer ensuite un fichier : “script.py”.
"""

```