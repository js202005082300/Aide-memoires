# [2. Première page web](https://www.youtube.com/watch?v=Fi8fj_JY91o)
11-01-21

Nous allons voir comment créer notre premier fichier pour ensuite le lire par un navigateur web. Ca ne nécessite pas d'installation de logiciels ou d'outils en particulier.

Le navigateur web qu'on a l'habitude d'utiliser Chrome, Opera, Safari, IE, Firefox, ect fonctionneront sans problème. 

C'est tout ce qu'il faut pour pouvoir lire, exécuter, interprêter nos pages web.

Pour Windows, aller dans paramètres, panneau de configurations, onglet d'affichage et décocher Masquer l'extension des fichiers dont le type est connus. Ca permet d'afficher l'extension de tous les fichiers de notre système.

## Créer un nouveau fichier

Il faut le nommer d'une certaine manière. Quand un site, une adresse va accéder à un dossier, il va chercher un fichier qui s'appelle index. C'est le premier fichier qui va être repéré. Dans le langage C, c'est la fonction main.c qui est cherchée en premier.

Prendre l'habitude d'appeler notre fichier avec ce nom plutôt que de l'appeler acceuil ou home, etc qui ne seront pas reconnu. Avec index, ce sera lu en priorité.

Ensuite, pour l'extension des fichiers html, c'est tout simplement html. On obtient ainsi un fichier index.html. 
        
C'est bien qu'il soit paramètré pour directement être ouvert avec l'éditeur de code.

## Ecrire notre première page

On utilise le langage informatique HTML pour pouvoir écrire notre première page. Ce sera très court, nous allons voir étape par étape ce que nous allons y mettre.

Le HTML fonctionne avec un système de balises, ça fonctionne avec des chevrons. On met quelques choses dans ces chevrons et entre ces balises, du contenus.

    <quelquechose>bla bla</quelquechose>

Ensuite on ferme la balise. La balise fermante s'écrit avec un / slash devant le nom.

Plutard nous verons qu'il y a des balises orphelines qui sont toute seule.

    <quelquechose>
        
Elle peuvent contenir des infos à l'intérieur mais elles n'ont pas de balises fermantes.

Pour créer notre première page web, on indique !DOCTYPE pour définir le type de fichier, ici HTML.

Excepté DOCTYPE marqué en majuscule, il est recommandé de tout marqué en minuscule sauf bien entendu le contenu de notre site, etc.

Tout ce qui est balise html, il est recommandé d'écrire en minuscules.

Avec ça on va définir pour les navigateurs que l'on a créé un fichier HTML.
        
Du coup on va pouvoir ouvrir une balise `<html>` et pour éviter d'oublier, on fait directement la balise fermante `</html>`.

Entre ces deux balises, on se trouve sur le contenus de la page HTML.

html n'est pas un nom que l'on choisit, c'est définis dans les normes, le standard. 

Il faut absolument mettre html sinon ca ne fonctionnera pas, autrement notre fichier ne sera pas valide. On parlera plus tard de la validation de nos page web.

    <head></head>

A partir de là, on démarre avec l'en-tête avec une balise qui s'appelle head dans laquel on va mettre des choses à l'intérieur. Il y a deux informations obligatoires au minimum à l'intérieur de l'en-tête.

La première information importante est l'encodage du fichier. Pour ça, il y a une balise nommé meta. meta est une balise orpheline, elle n'a pas de balise fermante.

Elle a un attribut charset qui prend une valeur d'encodage que l'on veut. Il est recommandé dans tous les cas d'utiliser tout le temps la valeur "utf-8". Pour la simple raison que utf-8 gère tous les langages, il gère les accents, les caractères spéciaux, toutes les langues possibles, etc. Aucun soucis avec utf-8. 

Pareil aussi, peut importe l'éditeur de code utilisé, toujours penser à bien sauvegarder nos fichiers avec utf-8. On peut le vérifier en allant dans save, encoding, utf-8, etc. Il faut s'arranger pour qu'il soit en utf-8. Cette remarque est valable pour les autres formations (Python, C, etc) pour éviter d'avoir des problèmes d'exécutions. Il faut toujours travailler avec l'utf-8, c'est l'unicode.

Il est inutile de s'en passer car il gère tout, toutes les langues possibles.  

La seconde information, c'est le titre de la page. Pas le titre affiché dans la page. C'est le titre qui va être affiché sur l'onglet de notre navigateur.

La petite pop-up qui apparaît sur l'onglet de la page web est le titre de la page web.

Quand on clique droit pour afficher le code source, on affiche le code html du site.

On peut ainsi définir cette balise de titre qui elle a une balise fermante.

A l'intérieur, on écrit le titre que l'on veut : "Ma première page web"
        
Voilà ici nous avons la base.

Ce sont les deux informations minimums qu'il faut et l'encodage toujours en premier.

Si j'ai des accents dans le titre et qu'il est avant l'encodage, il risque de ne pas les afficher proprement sur l'onglet.

L'encodage toujours en premier parce que le navigateur va lire notre fichier ligne par ligne. Il va prendre tout du début à la fin, il ne va pas tout lire d'un coup comme dans un langage de programmation. Ici c'est un langage de balises qui va permettre de formater les données.

Ici le navigateur va prendre ligne par ligne `<html>`, puis `<head>`, etc.

Il faut toujours mettre en premier l'encodage dans la balise head. Et ensuite le titre.

On mettra encore d'autres choses, notamment pour le référencement. On vera plus tard.
        
    <body></body>

Maintenant que l'on a créer l'en tête de notre page, on peut mettre le corps de notre page. Le corps de la page s'appelle body, c'est comme ça qu'on l'appelle. Entre les balises body, on est à l'intérieur de notre page web ... Voilà notre page web est terminé !
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma première page web !</title>
</head>
<body>

</body>
</html>
```  
    
## Affichage

A partir de là, on peut l'ouvrir avec un navigateur (clic droit et ouvrir avec un navigateur). Automatiquement, j'arrive sur ma page, le titre s'affiche sur l'onglet mais pour l'instant je n'ai pas d'icone, on vera plutard. Et si je fait clic droit, j'ai bien le code source. 

On a encore rien sur la page parce que dans le corps de la page, on a encore rien mis. On vera plutard, pour l'instant on a bien l'encodage utf-8, les accents affichés sans erreurs.

On peut mettre une petite balise p (pour paragraphe) pour vérifier que tout fonctionne. On met la balise `<p>`, le texte et la balise `</p>` fermante.

On peut ainsi actualiser pour voir et si on affiche le code source, j'aurais effectivement le contenu de ma page html. On peut donc afficher le code source d'un site mais seulement ce qui concerne l'affichage et la forme. Le html-css ne peuvent pas être caché. Ils se veront sur un site web par contre en utilisant un langage de programmation, on vera qu'il ne sera pas visible parce que ça conduirait à beaucoup de problème de sécurité sur les sites internets. 

C'est consultable par les utilisateurs. Ca n'aurait pas d'intérêt de le cacher.

Par contre pour ce qui sera de la programmation, du traitement en interne ou autre. Là se sera masqué l'utilisateur ne vera que ce qui sera affiché. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma première page web !</title>
</head>
<body>
    <p>Le tout premier contenu de page web !</p>
</body>
</html>
``` 
## Conclusion :

Ici on a vu le minimum dans lequel on a tout écrit en minuscule excepté pour le mot DOCTYPE. Certains l'écrivent en minuscule mais par habitude, il faut l'écrire en majuscule. Pour le reste, il faut mettre des minuscule partout.  

Pour la prochaine séance, on commencera avec des balises pour travailler avec du contenu, du texte, etc. On s'interessera pour le formatage de texte parce que c'est la première chose que l'on met sur un site web. On ne vera pas de css au début, le but est de voir le contenu d'une page web et ensuite seulement on apprendra à mettre en forme tout ca.

Pour bien créer un site, il faut que notre contenu soit parfaitement visible, lisible sans CSS. Si un site a qui on enlève sa partie CSS n'est plus lisible ou alors qu'on ne comprend pas le contenu qu'il y a, c'est qu'il y a un gros problème.

Développer un site proprement, on fait d'habord la partie HTML et on voit déjà si tout en HTML est parfaitement correcte et une fois que c'est correcte, on peux mettre en forme.

Si déjà c'est pas correcte avec juste HTML, c'est qu'il y a des corrections à faire.