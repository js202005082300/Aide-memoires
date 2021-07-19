# [21. Affichage et positionnement](https://www.youtube.com/watch?v=uT9hw2wpL9c)
04-02-21

Bonjour bienvenue sur cette 21e séance sur cette formation web en HTML CSS d'accord on a vu beaucoup beaucoup de choses concernant les modèles de boîtes et les différentes parties dans sa boîte notamment les marges les bordures les contours et cetera. 

Et là on va continuer parce qu'il y a encore pas mal de choses à voir sur cette notion là pour parler de la gestion de l'affichage des éléments et de leur positionnement parce que c'est très important de parler de positionnement pourquoi au sein d'une page web pour parler des interactions entre les différents éléments sur la même page. 

Alors on fait un code CSS.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }
```
Voilà c'est juste pour avoir un affichage de fond en gris avec une petite largeur au niveau de la page et voici ensuite pour le code acheter ml avec un titre un paragraphe.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    </p>
</body>
</html>
```
D'accord normalement on obtient ce genre de chose et vous devez être à l'aise avec tout ça.
```txt
    Bonjour !
    Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.
```
Voilà ce ne sont que des propriétés et des balises que nous avons déjà vu et donc normalement ça devrait être clair pour tout le monde. 

On va commencer déjà par tout ce qui concerne l'affichage. 

Pour l'affichage nous avons une petite propriété en CSS qui s'appelle 'display' et qui va pouvoir permettre de spécifier un affichage précis. 

Alors on peut avoir par défaut si on veut tout simplement ne pas afficher ce paragraphe on va utiliser la valeur "none" à cette propriété 'display'.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        display:none;
    }
```
J'actualise !
```txt
    Bonjour !
```
Cela aura pour effet de faire disparaître complètement l'information mais on peut le regarder au niveau du code source vous voyez qu'on verra toujours l'info donc on parle vraiment ici de pouvoir gérer l'affichage, c'est pour ça que je vous avais expliqué l'idée de ne pas mélanger le fond, l'HTML, la structure, le contenu par rapport à la forme qui est le plus réservé au design à la mise en page et ce genre de choses et on se rend bien compte ici que le CSS ne vient pas modifier le code source HTML donc bien faire attention à tout ça.

On voit simplement qu'on n'a pas d'affichage. 

Si on met un autre titre, `<h2>`.
```css
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    <h2>Test de titre</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        display:none;
    }
```
J'actualise !
```txt
    Bonjour !
    Test de titre
```
Ça n'a pas laissé un espace, on a véritablement masquer l'information et en plus de ça on ne laisse pas l'espace qu'il y avait pour cette info, si j'enlève cette propriété et que j'actualise vous allez voir que le titre va se trouver beaucoup plus bas via un décalage.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {

    }
```
J'actualise.
```txt
    Bonjour !
    Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.

    Test de titre

    Le titre se retrouve beaucoup plus bas, il y a un décalage et ça montre bien que le titre ne se retrouve pas sur le paragraphe mais si il avait été caché le titre ferait comme si le paragraphe n'avait jamais existé donc c'est pas comme s'il laissait une place vide au niveau de ce contenu là. 
```
Ça c'est un display pour retirer l'affichage d'une l'information. 

Au niveau html nous avons 2 types d'éléments dont je vous ai parlé sans trop rentrer dans les détails, nous avons un affichage de type block et vous allez avoir des balises que vous n'avez pas besoin d'avoir apprendre par coeur ou en tout cas vous pourrez les retrouver dans les spécifications du W3C donc tout ce qui concerne le html et voir un petit peu la liste des balises pour voir celles qui sont de type bloc et celles qui sont de type inline. 

Pour une balise de type block c'est très simple, on peut le voir par exemple lorsqu'on mettre plusieurs paragraphes l'un à côté de l'autre on va remarquer que au niveau du code vous verrez qu'ils se mettent bien tous là non dessous de l'autre. Et d'ailleurs si je m'amuse à faire une petite bordure comme vous l'avez vu précédemment pour bien mettre en évidence les choses on va obtenir des petites boîtes avec une petite marge par défaut qui s'applique automatiquement.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p><p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p><p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    <h2>Test de titre</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }
```
J'actualise !
```txt
    Bonjour !

    <+----
    |    Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.>

    +----
    |    Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.

    +----
    |    Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.

    Test de titre
```
On obtient des petites boîtes et vous voyez qu'elles appliquent des marges par défaut parce que la balise `<p>` appeler des marges est des paddings ou des margins par défaut.

On a ce modèle de bloc donc de boîtes qui vont se mettre l'un au dessus de l'autre dans l'ordre dans lequel vous les avez écrit dans votre fichier html après nous pour une question de lisibilité on va prendre l'habitude de faire ça pour que ce soit beaucoup plus lisible pour celui qui lit le code.

De toute manière même si vous mettiez cet affichage à la suite, on aura toujours cet affichage en bloc donc ça c'est un display bloc c'est-à-dire que l'élément `<p>` par défaut il a `display:bloc;`
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
>       display:block;
    }
```
Voilà ce sont type d'affichage par défaut. 

On va également avoir des éléments qui sont de type inline. 

Parmi les éléments de type inline dont on va avoir notamment les images qu'on peut mettre ici par exemple, on va mettre pic.jpg.

On teste bien qu'on ne verra pas grand grand chose mais si on remet l'image à coté, voyez si je met l'image à coté.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img src="pic.jpg" alt=""><img src="pic.jpg" alt="">

    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

    <h2>Test de titre</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
>       display:block;
    }
```
J'actualise !
```txt
    Bonjour !

    +---++---+
    |   ||   |
    +---++---+

    <p>...</p> 

    <p>...</p> 

    <p>...</p> 

    Test de titre
```
Si vous mettez l'image à côté les éléments vont se suivre c'est-à-dire qu'on a ce qu'on appelle des éléments in line. 

Ça c'est vraiment la différence c'est-à-dire que si ça avait été un élément bloc Eh bien les 2 images se seraient mises en dessous de l'autre. 

Vous l'aurez compris grâce à cette propriété 'display' modifier le type d'affichage d'un élément. 

Si d'un seul coup je veux que mon paragraphe devienne un élément inline je peux très bien faire ça.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
>       display:inline;
    }
```
Et là je vais obtenir ça.
```txt
    Bonjour !

    +---++---+
    |   ||   |
    +---++---+<p>...</p><p>...</p><p>...</p> 

    Test de titre
```
Voyez qu'on voit bien grâce aux  boîtes où s'arrêtent les paragraphes ainsi on a créé un paragraphe de type inline et à l'inverse pour les éléments qui sont in line, on peut très bien en faire des éléments bloc. 

Voilà donc on va faire `display:block;`
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
>       display:block;
    }
```
J'actualise !
```txt
    Bonjour !

    +---++---+
    |   ||   |
    +---++---+

    <p>...</p> 

    <p>...</p> 

    <p>...</p> 

    Test de titre
```
Voilà c'est un petit peu comme si c'était entouré d'un paragraphe `<p>` ça va devenir un élément bloc qui va du coup se suivre donc ça c'est à savoir parce que dans certains cas vous aurez peut-être besoin de changer le type d'affichage via une propriété au niveau du CSS pour certains éléments hum donc c'est des petites choses à savoir.

On a également d'autres valeurs possibles et je vais en parler très rapidement c'est-à-dire qu'on a la valeur "inline-block" alors ça je vais peut-être le faire sur des paragraphes sinon vous n'allez pas voir la différence c'est-à-dire que ces si il faut du visuel pour qu'on puisse comprendre et ce n'est pas forcément logique quand on est en train d'apprendre donc on va faire un `<span>` et ainsi créer plusieurs classes et on va faire .ib{}, .il{}
```css
    .ib{display:inline-block}
    .il{display:list-item}
```
"list-item" c'est pour avoir un comportement comme un élément d'une liste c'est-à-dire comme une liste al puce. 

Voilà .ib{}, .il{} et si maintenant je mets un `<span>` comme ça.
```css
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <p>Nostrud ullamco nulla est occaecat ea. <span class="ib">Sit aute dolore officia nisi Lorem consequat.</span> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. <span class="il">Sit aute dolore officia nisi Lorem consequat.</span> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

    <h2>Test de titre</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    .ib{display:inline-block}
    .il{display:list-item}
```
J'actualise !
```txt
    Bonjour !

    +---++---+
    |   ||   |
    +---++---+

    <p>...</p> 

    <p>...</p> 

    <p>...
    *  bla bla bla 
    ...</p> 

    Test de titre
```
Voilà comment on va avoir l'élément c'est-à-dire que l'endroit où j'ai fait un "list-item" on a tout simplement un comportement transformé qui du coup va se comporter comme une liste à puces.

Voyez cet élément réagi comme si c'était un élément d'une liste à puces d'ailleurs il a affiché une petite puce par défaut * donc c'est plutôt intéressant.

Alors le "inline-block" ça va fonctionner comme un mélange des 2 c'est-à-dire que vous allez avoir un passage en bloc. 

Ah oui à partir de `<span class="ib">` ça va devenir un élément bloc donc on va avoir un nouveau bloc qui va se créer et la suite va agir comme un inline.

Si voilà `<div>` est un élément bloc par défaut et `<span>` est un élément inline par défaut voilà donc ça va nous faire la coupure
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <p>Nostrud ullamco nulla est occaecat ea. <div class="ib">Sit aute dolore officia nisi Lorem consequat.</div> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. <span class="il">Sit aute dolore officia nisi Lorem consequat.</span> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

    <h2>Un titre H2</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    .ib{display:inline-block}
    .il{display:list-item}
```
J'actualise !
```txt
    Bonjour !

    +---++---+
    |   ||   |
    +---++---+

 >   <p>...
 >       <div></div> </p> 

    <p>...</p> 

    <p>...
    *  bla bla bla 
    ...</p> 

    Test de titre
```
Voilà il m'a fait la coupure avec `<div>`, voyez comment ça fonctionne c'est-à-dire que ceci `<div span=""></div>` c'est comme si c'était directement un bloc c'est-à-dire qu'on aurait une première ligne avec `<p>` puis on aurait une 2e ligne avec `<div>` et puis ça `<p>` ce serait encore un nouveau bloc donc on aurait 3 blocs pour ça.
```txt
    <p>Nostrud ullamco nulla est occaecat ea. <div class="ib">Sit aute dolore officia nisi Lorem consequat.</div> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
```
Il a commandé en "inline-block", on a d'abord le premier `<p>` ensuite au moment utilise un élément "inline-block" Eh bien il agit comme un bloc donc il passa la ligne ok et donc c'est le cas et tout le reste après cet élément "inline-block" va fonctionner comme un "inline" donc il va suivre en fait le reste de l'élément et c'est effectivement le cas parce qu'on voit que tout ça se suit.
```txt
    Nostrud ullamco nulla est occaecat ea.

    Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.
```
Donc on a pour le coup 2 blocs en réalité voilà ce n'était pas facile à montrer un exemple qui le montre et c'est donc pour ça qu'on a utilisé un `<div>` ce qui était beaucoup plus pratique. 

Encore une fois pratiquer n'hésitez pas à tester ces propriétés et moi je vous montre des exemples très simples pour pas que ça vous bloque au niveau de la compréhension mais il faudra tester sur des exemples concrets sur vos vraies pages web, sur de vrais sites web pour que vous vous rendiez compte de la différence. 

On a un peu le même genre d'exemple avec "inline-table" si vous voulez par exemple appliquer pour un style de cellules de tableau donc ça c'est à vous de voir aussi tester dans un tableau et voyez comment ça fonctionne.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

>    .ib{display:inline-table}
    .il{display:list-item}
```
"inline-table" voilà testez dans un tableau et voyez comment ça fonctionne, je ne vais pas le montrer parce que si je dois montrer les choses à chaque fois ça va évidemment nous prendre beaucoup de temps mais sachez que ça existe. 

On a également d'autres types d'affichage, 'display', et notamment le display "flex" et le display "grid".
```css
    /*
        display:flex
        display:grid
    */
```
Alors ça on en parlera dans une prochaine vidéo, il y aura justement des vidéos où on parlera de de flexbox, on parlera des grids et cetera qui sont des méthodes un peu plus modernes en CSS, un peu plus moderne pour créer des boîtes de contenu, pour créer des boîtes dynamiques à dimension dynamique donc ne vous en faites pas c'est prévu pour cette formation et on en parlera beaucoup plus tard. Il y aura vraiment une vidéo pour chacun des types, au moins une vidéo sur flex et au moins une vidéo sur les grids vu tout ce qu'il y a à dire dessus. 

Voilà pour cette partie, on va du coup revenir à des exemples simples ici et on a fait le tour grosso modo au niveau des affichages. 

Grosso modo il faut retenir "block" "inline" qui sont les plus utilisés, "none" si vous voulez masquer le contenu ça peut arriver et on a "inline-block" dans certains cas ça peut servir mais c'est quand même plus rare. 

Après "list-items", "inline-table" et cetera c'est plus rare tandis que flex et grid c'est beaucoup plus récent on en parlera prochainement de toute façon. 

Un autre moyen de jouer sur l'affichage par rapport à ce qu'on avait vu pour le display, ça va être la propriété 'visibility' pour lequel je vais aller assez vite. 

La propriété 'visibility' a un élément par défaut qui est "visible".
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
        visibility:visible;
    }
```
'visibility' est par défaut sur "visible" mais on peut aussi le masquer en faisant "hidden".
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

    <h2>Un titre H2</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
        visibility:hidden;
    }
```
J'actualise.
```txt
    Bonjour !



    Un titre H2
```
Lorsque j'actualise vous voyez qu'il a gardé en fait l'espace c'est-à-dire que contrairement à 'display' quand vous cachez avec la propriété 'visibility' on va effectivement masquer l'affichage par contre on va laisser l'emplacement que cet affichage avait pris sur notre page HTML donc c'est là qu'on a quand même la différence qui est importante entre les 2 donc on va vraiment masquer mais sans enlever l'affichage. 

On voit donc la différence de comportement avec `display:none;`
```txt
    Bonjour !
    Un titre H2
```
Voilà la différence de comportement au niveau html, on n'agit pas du tout de la même manière donc ça c'est à savoir aussi j'en parle rapidement parce que c'est ta connaître, 'visibility' qui est une propriété à connaître et ensuite on a également "collapse".
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
        visibility:collapse;
    }
```
Voilà "collapse" c'est un cas assez particulier pour les tableaux, on s'en sert pour gérer tout ce qui est affichage notamment pour les cellules de tableau par exemple ça va permettre de masquer les cellules d'une ligne dans le tableau. 

Testez le sur un tableau pour voir comment ça fonctionne. 

Voilà j'ai été assez vite là-dessus parce que ce n'est pas compliqué à comprendre. 

Maintenant qu'on a vu tout ça on va rester sur l'affichage avec une dernière propriété mais qui n'agit pas forcément sur le masquage ou non d'un contenu mais sur son opacité donc ça c'est important parce que par défaut les éléments sont affichés à 100 pourcent, une opacité de 1 donc on peut dire 100% par contre un événement complètement invisible aurait une opacité de 0 donc de 0%. 

Vous allez pouvoir en CSS joué avec ce type de pas citer selon le cas et nous on va le faire sur une image parce que je pense que ce sera bien parlant et on va donc remettre l'exemple de l'image mais pour le coup on va le mettre dans un paragraphe et on regarde si elle s'affiche bien par défaut.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img src="pic.jpg" alt="">

    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. <span class="il">Sit aute dolore officia nisi Lorem consequat.</span> Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

    <h2>Un titre H2</h2>
</body>
</html>
```
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+
    <p>...</p>
    <p>...</p>
    <p>...</p>
    Un titre H2
```
Il n'a pas joué là-dessus pour l'image `<img>` va mettre une capacité donc c'est la propriété 'opacity' de 100% donc de 1, et 'opacity' prend une valeur entre 0 et 1. Et notamment un nombre à virgule mais attention qu'en informatique on met un point pour la virgule.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    img
    {
        opacity:1;
    }
```
1 c'est 100 pourcent mais si je met 0 c'est 0 pourcent.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    img
    {
        opacity:0;
    }
```
J'actualise.
```txt
    Bonjour !



    <p>...</p>
    <p>...</p>
    <p>...</p>
    Un titre H2
```
Voilà 0% on retrouve la même chose, ce n'est pas que forcément l'élément ne pas affiché mais c'est juste qu'il y a une opacité de 0 c'est-à-dire qu'il est en fait transparent d'où le fait qu'on a encore la place qui est laissée un peu comme 'visibility' si on veut faire entre les 2 vous mettez 0 point quelque chose.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    img
    {
        opacity:0.6;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+
    <p>...</p>
    <p>...</p>
    <p>...</p>
    Un titre H2
```
Si vous mettez 0.6 ça veut dire 60% et là voilà un petit peu l'affichage qu'on c'est-à-dire qu'on a une petite opacité qui est réduite. 

Pour ceux qui utilisent des logiciels d'images, vous connaissez bien le principe d'opacité sur une image, moi je dis qu'on peut jouer un petit peu comme ça donc ça peut être sympa. 

Plus tard on fera des choses comme ça par exemple.
```css
    body
    {
        background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    p
    {
        border:1px solid #000;
    }

    img
    {
        opacity:0.6;
    }

    img:hover
    {
        opacity:0.8;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+
    <p>...</p>
    <p>...</p>
    <p>...</p>
    Un titre H2
```
`Img:hover` fait qu'au passage de la souris on a un changement d'opacité de l'image.

Voilà donc ça ce sont des petites choses à connaître qui sont plutôt intéressantes. 

Vous avez grosso modo 3 propriétés très pratique sur ce qu'on a vu ici et je vais le re noter en haut pour ceux qui aiment bien avoir la liste. 
```css
    /*
        display, visbility, opacity
    */
```
Ça ce sont vraiment les 3 propriétés principales pour gérer tout ce qui est affichage et opacité des éléments. 

Voilà pour ça. 

Maintenant nous allons pouvoir passer à tout ce qui est positionnement d'accord on a parlé de tout ce qui était affichage donc on arrive sur la 2e partie de cette vidéo à savoir le positionnement de nos éléments. 

Alors on va avoir besoin de faire autre chose et on va laisser `<img>` pour le coup, on va mettre un `<div>` dans lequel on ne va même pas mettre du texte.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img src="pic.jpg" alt="">

    <div class="first"></div>
    <div class="second"></div>
    <div class="third"></div>
</body>
</html>
```
On a 3 éléments dans des `<div>` et on va pouvoir jouer là-dessus, on va appliquer un style à chacun de ces éléments.
```css
    /*
        display, visbility, opacity
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:200px;
        width:200px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
    Un titre H2
```
Voilà comment sont nos 3 `<div>` qui se suivent à la suite des autres par rapport à ça d'ailleurs je rappelle que si je fais un `display:inline;` je veux changer le comportement du `<div>` qui est de type bloc par défaut…
```css
    /*
        display, visbility, opacity
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:200px;
        width:200px;
        display:inline;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+

    Un titre H2
```
Alors oui le problème avec "inline" ici c'est qu'on ne peut pas appliquer de taille aux éléments "inline" alors ça je ne l'avais pas dis donc du coup c'est bien que j'ai pu faire ça. 

Alors un élément "inline" on ne peut pas lui appliquer une largeur et une hauteur d'accord parce que c'est du texte, c'est une image et donc c'est régie par d'autres règles et donc à ce moment-là on va tout simplement remplir le `<div>` en question et c'est ça qui va permettre d'estimer les dimensions des éléments.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img src="pic.jpg" alt="">

    <div class="first">bla bla bla</div>
    <div class="second">bla bla bla</div>
    <div class="third">bla bla bla</div>
</body>
</html>
```
```css
    /*
        display, visbility, opacity
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:200px;
        width:200px;
        display:inline;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+[bla bla bla] [bla bla bla] [bla bla bla]

    Un titre H2
```
Voilà comme ça ça vous vous rendez bien compte des différents types sinon j'aurais oublié d'en parler et ça c'est important de le savoir. 

Alors on va revenir à l'état qu'on avait au début mais l'image on va à l'envers parce qu'elle prend de la place à l'affichage.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <!-- <img src="pic.jpg" alt=""> -->

    <div class="first">DIV 1</div>
    <div class="second">DIV 2</div>
    <div class="third">DIV 3</div>
</body>
</html>
```
```css
    /*
        display, visbility, opacity
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
J'actualise.
```txt
    Bonjour !
    +-------+
    |img    |
    |       |
    +-------+
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
    Un titre H2
```
Ok voilà ce que nous avons.

Voilà 100 pixels pour chaque image donc ça on va pouvoir du coup jouer sur le positionnement au niveau de nos éléments. 

Alors le positionnement par défaut il est statique c'est-à-dire que quand on a un positionnement statique donc si par exemple je fais un 'position' pour mon .first on va voir un élément ici de type statique.
```css
    /*
        display, visbility, opacity

        position
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
>        position:static;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
Quand on a un comportement statique on voit qu'on a ce comportement par défaut hé quand on a un positionnement statique on ne va pas pouvoir jouer sur les décalages de position.

Ça veut dire qu'en plus de la propriété 'position' qu'on va regarder parce qu'il y a pas mal de choses à connaître, on va pouvoir jouer sur des décalages en hauteur (top), à droite (right), du bas (bottom) et à gauche (left).
```css
    /*
        display, visbility, opacity
        top, right, bottom,left
    */
```
Ça c'est dans le cas où nous aurons une position autre que "statique", "statique" c'est encore une fois le positionnement par défaut car il est régi il est défini par nos autres propriétés que nous avons on CSS. 

Alors par défaut on obtient ça.
```txt
    Bonjour !
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
    +---+
    |Div|
    +---+
```
Alors comment je vais pouvoir du coup jouer sur ces éléments, comment est-ce que je vais pouvoir du coup changer ce système de positionnement avec différentes valeurs alors 'position' on peut le mettre de manière relative.
```css
    /*
        display, visbility, opacity

        position
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:relative;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
Une position 'relative' ça va être en fait par rapport à l'emplacement où se trouve l'élément c'est-à-dire que là l'élément .second a son positionnement de base ici.
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
>   o-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
    +-----------+
    |DIV 3      |
    |           |
    |           |
    |           |
    +-----------+
```
Le positionnement de base est ici, son point de coordonnées  est c'est tout en haut à gauche donc cet élément là quand vous dites un positionnement relatif c'est-à-dire qu'on va chercher à jouer sur le positionnement donc juste de faire un positionnement relatif tout seul tel que ici ça ne va rien changer. 

On utilise ce changement de positionnement pour utiliser ces propriétés là (top, right, bottom, left) donc moi à partir de là maintenant que j'ai appliqué un position:relative; tu vas faire un décalage gauche 100 pixels c'est-à-dire qu'on va retrouver une espèce de dernier.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:relative;
>       left:100px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
                +-----------+
                |DIV 2      |
                |           |
                |           |
                |           |
                +-----------+
    +-----------+
    |DIV 3      |
    |           |
    |           |
    |           |
    +-----------+
```
Et là vous voyez qu'on a une espèce de damier en couleur avec un fond blanc donc en fait le 'left' qui s'est bien fait là avec un décalage de 100 pixels parce que j'ai choisi de mettre ce `<div>` 2 en positionnement relative. 

En partant de ce point-là qui serait le point (0, 0).
```txt
    (0,0)       (100,0)
                +-----------+
                |DIV 2      |
                |           |
                |           |
                |           |
                +-----------+
```
Voilà tu fais un décalage gauche donc un décalage sur l'axe des x c'est à dire horizontal. 

Voilà c'est comme sur un graphique en physique en maths et cetera, ça fonctionne exactement pareil bien évidemment. 

Voilà donc si je fais un décalage à gauche elle va se déplacer vers la droite. 

Si je fais un décalage du haut ça va de se déplacer vers le bas.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:relative;
>       left:100px;
>       top:50px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+


                +-----------+
                |DIV 2      |
    +-----------+           |
    |DIV 3      |           |
    |           |           |
    |           |-----------+
    |           |
    +-----------+
```
Voilà plus on descend plus on augmente le y et plus on va à droite et plus on augmente le X, et inversement. 

Voilà donc on peut faire pas mal de choses comme ça, voilà on peut par exemple faire ça aussi (superposer).
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:relative;
>       left:80px;
>       top:50px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+


                +-----------+
                |DIV 2      |
    +-----------+           |
    |DIV 3      |           |
    |           |           |
    |           |-----------+
    |           |
    +-----------+
```
Et là les éléments se placent les uns au-dessus des autres en fonction des positions donc on a un ensemble fixe DIV1 et DIV3 et à côté on a un ensemble relatif DIV2 sur lequel on va pouvoir jouer le positionnement donc précisément. 

Ça c'était utilisé seulement si vous voulez utiliser ces propriétés là, top, right, bottom et left. Voilà sinon ça n'aurait aucun intérêt. 

À partir du moment où vous allez vouloir faire des décalages sur un élément quel qu'il soit Eh bien il faudra changer le type de positionnement donc le passé de "static" tel qu'il est par défaut à par exemple relatif "relative".

Maintenant vous avez un autre cas, et là du coup vous allez voir quelque chose, on va déjà remettre en positionnement par défaut.
```css
    .second
    {
        background-color:#6690eb;
>       position:relative;
    }
```
Vous avez le cadre de la position "absolute". 
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
Si j'actualise on obtient ça.
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
La position "absolute" va jouer en fait sur l'ensemble du document c'est-à-dire qu'on va avoir un positionnement à partir de la base et là même chose si je veux faire un 'left' de par exemple "200px" voilà ce qu'on va avoir.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
>       left:200px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
    +-------+-----------+
    |DIV 3  |DIV 2      |
    |       |           |
    |       |           |
    |       |           |
    +-------+-----------+
```
D'accord donc on va prendre vraiment sur un ensemble d'éléments plutôt que de prendre sur l'élément lui tout seul, OK donc il va falloir gérer toute cette partie là. 

Vous allez pouvoir évidemment jouer sur tous les types on pourra évidemment changer le comportement sans problème de ce `<div>` en .second.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
>       left:200px;
>       top:500px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    Bonjour !
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+



                    +-----------+
                    |DIV 3      |
                    |           |
                    |           |
                    |           |
                    +-----------+
```
Voilà on pourra sans problème changer le comportement de cet élément DIV 2 en fonction donc c'est à vous de voir dans certains cas vous aurez peut-être besoin d'utiliser le positionnement "absolute" et dans d'autres cas vous aurez peut-être besoin d'utiliser le positionnement "relatif". 

En général on utilise plus souvent le positionnement "relatif" pour gérer chaque élément en fonction des autres parce que sinon là vous avez vu que par défaut on perd un élément en faisant ça.
```css
    .second
    {
        background-color:#6690eb;
>       position:absolute;
    }
```
```txt
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
On perd un élément parce que comme il était du coup rattaché, on perd un élément. 

D'ailleurs si je fais "absolute" sur .third ça change le cas.
```css
    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
    }

    .third
    {
        background-color:#72aa7f;
>       position:absolute;
    }
```
```txt
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+
    +-----------+
    |DIV 3      |
    |           |
    |           |
    |           |
    +-----------+
```
Si je le fait sur ce cas là.
```css
    .first
    {
        background-color:#c98b8b;
>       position:absolute;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
Voilà alors quand je vous dis que ça prend l'ensemble du document ce n'est pas que ça prend vraiment l'ensemble du document mais c'est l'ensemble des éléments qui ont une position idem c'est-à-dire que le point absolu devient celui là (coin supérieur gauche du DIV 2). 

Le point absolu devient celui du premier `<div>` même par rapport aux autres donc automatiquement c'est pour DIV je fais un top:200px; par exemple.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
>       position:absolute;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
>       top:200px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    +-----------+
    |DIV 1      |
    |           |
    |           |
    |           |
    +-----------+

    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
Et si on fait un décallage de 100px, on arrive-là.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
>       position:absolute;
    }

    .second
    {
        background-color:#6690eb;
>       position:absolute;
>       top:100px;
    }

    .third
    {
        background-color:#72aa7f;
    }
```
```txt
    +-----------+
    |DIV 1      |
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
Voilà vous comprenez un petit peu comment ça fonctionne parce que ce n'est pas forcément évident au niveau du calcul mais pareil fait des tests et vous verrez un petit peu comment se comporte le positionnement "absolute" par rapport au positionnement "relative" donc c'est des choses à connaître aussi. 

On a également le positionnement "fixes" pareil donc ça ça peut être un autre cas par exemple vous pouvez avoir un positionnement fixe par rapport à un seul élément comme vous pouvez avoir un positionnement "absolute" ou "relative" pour les autres.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
>       position:relative;
>       left:200px;
    }

    .second
    {
        background-color:#6690eb;
>       position:fixed;
    }

    .third
    {
        background-color:#72aa7f;
>       position:relative;
>       top:500px;
    }
```
```txt
                                +-----------+
                                |DIV 1      |
                                |           |
                                |           |
                                |           |
                                +-----------+
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
```
Donc on voit le .second, on voit le .first mais le .third on ne le voit pas pour le coup parce qu'on avait "fixed" sur le .second Et on peut le décaler de 20 pixels par exemple.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
    }

    .first
    {
        background-color:#c98b8b;
        position:relative;
        left:200px;
    }

    .second
    {
        background-color:#6690eb;
        position:fixed;
>       left:20px;
    }

    .third
    {
        background-color:#72aa7f;
        position:relative;
        top:500px;
    }
```
```txt
    +-----------+
    |DIV 2      |
    |           |
    |           |
    |           |
    +-----------+
                                +-----------+
                                |DIV 1      |
                                |           |
                                |           |
                                |           |
                                +-----------+
```
Et là pareil on a un positionnement assez différent par rapport à ce positionnement "fixed" donc c'est pareil à vous de voir au niveau de vos pages comment vous allez l'utiliser parce qu'il n'est pas vraiment évident non plus au niveau de son utilité et c'est quand même beaucoup plus rare. 

Celui qu'on va retrouver le plus c'est quand même positionnement "relative" plutôt que le positionnement "fixed" ou le positionnement "absolute" qui va demander beaucoup plus d'éléments et nécessitera du coup beaucoup plus l'usage des propriétés pour que ce soit géré comme il faut. 

N'hésitez pas non plus à tester sur plusieurs types d'éléments différents et faire du positionnement sur autre chose que des `<div>` bien évidemment. 

Moi je le fais sur des `<div>` parce que c'est plus pratique avec des boîtes de couleur donc c'est visuellement parlant mais n'hésitez pas à le faire sur d'autres choses. 

Après on a d'autres cas mais c'est beaucoup de valeurs expérimentales et vous savez que sur cette formation, je ne vous présente pas les balises qui sont encore expérimentales ou qui vont venir avec des prochaines versions, les prochaines spécifications de HTML, et je fais la même chose avec CSS de sorte que vous puissiez avoir quelque chose qui fonctionne sur tous les navigateurs y compris les navigateurs mobiles sinon ça n'aurait aucun intérêt d'avoir un site qui ne fonctionne que sur Firefox sur PC et pas ailleurs ce qui serait assez problématique pour la navigation des utilisateurs. 

Voilà pour ces petites propriétés en position même si je ne vous ais pas trop détaillés parce que encore une fois il y a plein de choses à faire et je ne veux pas faire une vidéo de 2h juste là dessus mais n'hésitez pas à voir tout ça dans le détail. 

En tout cas je vous aime montrer le principal et après c'est à l'utilisation et à l'usage que vous verrez comment ça fonctionne exactement. 

Alors au niveau de ces éléments, du positionnement, et là ça peut être utile de le faire par exemple on va mettre position absolue "absolute" sur `<div>` pour commencer.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
>       position:relative;
    }

    .first
    {
        background-color:#c98b8b;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
>       top:25px;
>       left:80px;
    }
```
```txt
    +-----------+
    |DIV 3      |
    |           |
    |           |
    |           |---+
    +-----------+   |
        |           |
        |           |
        |           |
        +-----------+
```
Voilà là on voit comment les éléments vont interagir mais par contre on a perdu le .first et donc on va essayer de le récupérer.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
>       position:absolute;
    }

    .first
    {
        background-color:#c98b8b;
        left:40px;
    }

    .second
    {
        background-color:#6690eb;
    }

    .third
    {
        background-color:#72aa7f;
        top:25px;
        left:80px;
    }
```
```txt
                +-----------+
                |DIV 3      |
                |           |
                |           |
        +-------|           |---+
        |DIV 1  +-----------+   |
        |           |           |
        |           |           |
        |           |           |
        +-----------+-----------+
```
Alors si je fais ça on aura l'impression que l'élément est plus petit, 60px pour .first
```css
    .first
    {
        background-color:#c98b8b;
        left:60px;
    }
```
```txt
             +-----------+
             |DIV 3      |
             |           |
             |           |
        +----|           |---+
        |DIV +-----------+   |
        |        |           |
        |        |           |
        |        |           |
        +--------+-----------+
```
Voilà on a l'impression que l'élément est plus petit mais non on n'a pas changé de dimension et vous allez comprendre pourquoi tout simplement parce que l'élément rouge passe en dessous. 

Alors pourquoi est-ce qu'il passant dessous tout simplement parce que les éléments sont définis en premier soit le `<div1>` `<div2>` `<div3>`. 

Automatiquement on va avoir un effet d'empilement des éléments c'est-à-dire quand ils se chevauchent au niveau des affichages et donc on voit qu'ils sont dans l'ordre. 

Le premier élément affiché dans le code `<div1>` sera l'élément qui est le plus au fond, le `<div2>` comme il arrive après dans le fichier automatiquement et notamment surtout au niveau de la propriété donc au niveau du CSS, il va venir par-dessus et le `<div3>` viens du coup au-dessus de tous les autres parce qu'il a été le dernier défini. 

Voilà comment ça se passe. 

Cet effet d'imprimante c'est-à-dire cet effet de profondeur au niveau des éléments, on va pouvoir également le changer en CSS avec la propriété 'z-index' qui est une propriété très importante.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index
    */
```
'z-index' prends une valeur entière peu importe la limite bien que je crois qu'en fait la limite soit de plusieurs milliers c'est-à-dire que des empilements de plusieurs milliers d'éléments HTML faut encore le voir arriver mais en gros vous choisissez une valeur entière et évidemment la valeur qui sera la plus haute sera celle qui sera affichée en premier. 

En général on fait un 'z-index' sur tous les éléments empilés donc tous non mais par exemple celui que l'on veut en premier, moi par exemple je veux que .first soit affiché en premier. Bon je veux que .first soit affiché le plus haut donc je peux mettre par exemple la valeur "10" pour être sûr qu'elle est vraiment au dessus. Ensuite l'élément .third quand je vais en 2e je vais par exemple mettre une valeur de "8" donc 8 est en dessous de 10 et enfin pour .second je veux par exemple mettre une valeur de "5". 
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    div
    {
        height:100px;
        width:100px;
>       position:absolute;
    }

    .first
    {
        background-color:#c98b8b;
        left:40px;
>       z-index:10;
    }

    .second
    {
        background-color:#6690eb;
>       z-index:5;
    }

    .third
    {
        background-color:#72aa7f;
        top:25px;
        left:80px;
>       z-index:8;
    }
```
Alors vous pouvez avoir des valeurs qui se suivent de une unité, vous pouvez très bien avoir des index 1, 2, 3 au lieu de 5, 8, 10.


Voyez ensuite qu'on change l'ordre, on a bien le `<div 1>` avec son 'z-index' qui est au-dessus de tout le monde, `<div 3>` qui arrive après avec 8 et le dernier avec 5 qui est en dessous de tout le monde. 
```txt
                 +-----------+
                 |DIV 3      |
                 |           |
                 |           |
        +------------+       |---+
        |DIV 1       |-------+   |
        |            |           |
        |            |           |
        |            |           |
        +------------+-----------+
```
Voilà comme ça vous pouvez changer à certains moments les différents index, si je mets 15 pour le .second le bleu va se retrouver devant tout le monde, voilà.
```css
    .first
    {
        background-color:#c98b8b;
        left:40px;
>       z-index:10;
    }

    .second
    {
        background-color:#6690eb;
>       z-index:15;
    }

    .third
    {
        background-color:#72aa7f;
        top:25px;
        left:80px;
>       z-index:8;
    }
```
```txt
            +-----------+
            |DIV 3      |
            |           |
            |           |
        +----------+-----------+
        |DIV 1     |DIV 2      |
        |          |           |
        |          |           |
        |          |           |
        +----------+-----------+
```
Voilà donc on peut vraiment jouer là dessus donc c'est important de le voir pour bien piger le principe. 

Voilà ici on se rend bien compte de l'emplacement des différents éléments donc avec cette petite propriété 'z-index' qui est très simple à utiliser mais qui est évidemment à connaître parce qu'elle pourra gérer comme ça l'empilement de ces éléments selon l'affichage que vous avez choisi pour dire lequel se trouve au dessus des autres. 

Voilà pour cette partie et on va passer maintenant à la dernière partie de cette vidéo qui va permettre de gérer le positionnement et le comportement de nos boîtes de contenu, tout ce qu'on a vu sur le modèle de boîte et C'est d'ailleurs quelque chose qu'on verra d'une manière un peu plus moderne dans les prochaines vidéos avec notamment ce qu'on a parlé tout à l'heure 'flexbox' et 'grid', on verra tout ça par la suite. 

Alors on va déjà commencer par appliquer une image je vais mettre un premier paragraphe puis en 2e comme ceci.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img src="pic.jpg" alt="">

    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. Deserunt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
</body>
</html>
```
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }
```
On actualise.
```txt
    Bonjour !

    +---+
    |img|
    +---+

    <p>...</p> 

    <p>...</p> 
```
Alors ça c'est ce qu'on appelle un affichage par défaut c'est-à-dire que quand vous allez définir un site par exemple vous allez vouloir faire plusieurs sections d'ailleurs j'aurais même pu le montrer avec un forum avec plusieurs sections comme ça je vous montrerai ça en fin de vidéo et donc on verra ça par la suite. 

Ici par défaut on a notre élément bloc c'est-à-dire qu'on va avoir notre titre "Bonjour !" et je rappelle que si jamais un juste à la suite … il se met en dessous.
```html
    <!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Affichage et positionnement en css</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
>        <h1>Bonjour !</h1><h1>Bonjour !</h1>
```
Si j'actualise.
```txt
    Bonjour !

    Bonjour !

    +---+
    |img|
    +---+

    <p>...</p> 

    <p>...</p> 
```
Donc `<h1>` est bien un élément de type block, ce n'est pas un élément de type inline. 

Ensuite ici j'ai un élément de type inline `<img>` donc pas de problème, et enfin je passe à un nouvel élément bloc `<p>` donc ils se mettent en dessous l'un de l'autre, de l'image et cetera. 

Ça je pense que vous avez bien compris maintenant avec tout ce que je vous ai mis sur cette vidéo mais on va pouvoir changer ce comportement c'est-à-dire qu'on va pouvoir changer le caractère d'un élément pour lui dire qu'il sera flottant. 

Et un élément flottant vous l'avez peut-être déjà lu sur des livres ou sur des sites, c'est d'avoir par exemple ici notre petite image et d'avoir le texte qui démarre au niveau de notre image c'est-à-dire que le texte va se mettre comme ceci.
```txt     
        +-----+     Bla bla bla bla
        |img  | bla bla bla bla bla
        +-----+ bla bla bla bla bla
        bla bla bla bla bla bla bla
        bla bla bla bla bla bla bla
        bla bla bla bla bla bla bla
        bla bla bla bla.
```
Voilà un texte décalé par rapport à l'image éventuellement quand il aura dépassé les dimensions de l'image, il continuera de s'écrire en dessous. 

Alors pour ça pour cette image là on va mettre une class, "fleft".
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img class="fleft" src="pic.jpg" alt="">
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
</body>
</html>
```
Voilà on va le créer une classe "fleft" et cette classe .fleft mettra la propriété 'float' avec la valeur "left".
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    .fleft
    {
        float:left;
    }
```
Nouvelle propriété à connaître, 'float'.

Voilà on vient de lui créer une classe .fleft qui met la propriété 'float' avec la valeur "left" donc voilà c'est une nouvelle propriété à connaître et nous obtiendrons ça.
```txt
    Bonjour !
    
    +-------------------+
    |<img class="fleft">|     Bla bla bla bla bla
    |                   | bla bla bla bla bla bla
    |                   | bla bla bla bla.
    |                   |
    |                   |
    |                   |
    +-------------------+
```
Et si par exemple je mettais d'autres paragraphes vous verrez que ça se mettra automatiquement à la suite.
```txt
    +-------------------+
    |<img class="fleft">|     Bla bla bla bla bla
    |                   | bla bla bla bla bla bla
    |                   | bla bla bla bla.
    |                   |
    |                   |     Bla bla bla bla bla
    |                   | bla bla bla bla bla bla
    +-------------------+ bla bla bla bla.

        Bla bla bla bla bla bla bla bla bla bla bla
    bla bla bla bla.
```
Donc j'ai ma petite image en flottant et le texte se met par la suite comme ça. 

Voilà donc Comment ça va agir au niveau du comportement pour 'float' à "left", alors je peux faire la même chose avec "right" bien évidemment à droite mais ici pour le coup on ne verra pas forcément parce que notre texte démarre de gauche à droite donc il faudrait gérer le texte d'une autre manière mais voilà ça va faire un petit peu plus bizarre.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bonjour !</h1>

    <img class="fright" src="pic.jpg" alt="">
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
    <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
</body>
</html>
```
Voilà on va le créer une classe "fleft" et cette classe .fleft mettra la propriété 'float' avec la valeur "left".
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    .fright
    {
        float:right;
    }
```
```txt
                            +-------------------+
        Bla bla bla bla bla |<img class="fleft">|
    bla bla bla bla bla bla |                   | 
    bla bla bla bla.        |                   | 
                            |                   |
        Bla bla bla bla bla |                   |     
    bla bla bla bla bla bla |                   | 
    bla bla bla bla.        +-------------------+

        Bla bla bla bla bla bla bla bla bla bla bla
    bla bla bla bla.
```
Alors évidemment comme notre texte est écrit de gauche à droite, on a quelque chose du coup qui ne vient pas forcément se mettre pile au bord de l'image, ce qui est logique. 

Éventuellement il faudrait mettre le texte en justifié, "justify" comme on avait vu avec 'text-align'.

Voilà vous voyez comment ça fonctionne ici pour ce type 'float' au niveau des éléments. 

Alors on peut éventuellement annuler un flottant avec la valeur "none" et donc ça reviendrait à un style par défaut donc comme si vous mettiez rien du tout en fait.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    .fright
    {
>       float:none;
    }
```
Voilà ça reviendrait à un style par défaut si vous mettiez "none" ou rien du tout, c'est la même chose. 

Alors ce qui est du coup intéressant à connaître c'est-à-dire que si on voulait faire un espèce de petit design très rapidement. 

Alors on va faire un `<header>` et un `<footer>` et pourquoi pas un `<aside>`, je vais aller très vite encore une fois, parce qu'un jour vous aurez peut-être besoin de le faire en pratique donc c'est bien de le voir. On aurait pour but d'avoir l'en-tête au départ tout en haut du site qui prendrait toute la largeur par exemple, ensuite d'avoir la section `<section>` à gauche, puis d'avoir la partie `<aside>` à droite et du coup d'avoir le `<footer>` qui prend toute la largeur donc comme une espèce de design de site. Voilà on retrouve ça habituellement sur le site. 

Alors pour ça on va avoir grosso modo dans notre fichier CSS, le header{} donc pas de surprise pour lequel on répète pas mal de propriétés bien qu'il faudrait les factoriser mais je le fais surtout pour que vous puissiez bien comprendre.

Normalement il faudrait faire body,header{} et à l'intérieur des accolades factoriser toutes les propriétés tandis qu'on va les répéter à chaque fois mais ce n'est pas grave mais dans ce cas pratique ne répétait pas comme ça les propriétaires et donc optimiser vos fichiers CSS.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage et positionnement en css</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Bonjour !</h1>
    </header>
    
    <section>
        <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    
        <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>

        <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    </section>

    <aside>
        <img src="pic-small.jpg" alt="">

        <p>Nostrud ullamco nulla est occaecat ea. Sit aute dolore officia nisi Lorem consequat. Nulla eiusmod dolor fugiat enim. runt non cillum aute incididunt fugiat ad sit eu adipisicing.</p>
    </aside>


    <footer>

    </footer>
</body>
</html>
```
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    header
    {
        background-color:rgb(209, 175, 160);
        height:80px;
        margin:auto;
        width:1000px;
    }

    section
    {
        background-color:rgb(134, 175, 155);
        margin:auto;
        width:800px;
    }

    aside
    {
        background-color:rgb(212, 172, 154);
        margin:auto;
        width:200px;
    }

    footer
    {
        background-color:rgb(138, 161, 236);
        height:30px;
        margin:auto;
        width:1000px;
    }
```
Voilà `<aside>` et `<section>` clients respectivement 200 pixels et 800 pixels de large pour obtenir 1000 pixels après il ne faudrait pas qu'il y a une marge sinon avec les marges ça va s'empiéter. 

J'actualise et voilà cxe que nous avons.
```txt
    +---------------------------------------+
    | Bonjour !                             |
    +---------------------------------------+
        +---------------------------+
        |<p>Lorem...</p>            |
        |<p>Lorem...</p>            |
        |<p>Lorem...</p>            |
        +---------------------------+
                +-------+
                |<img>  |
                |<p>Lor.|
                |...    |
                |</p>   |
                +-------+
    +---------------------------------------+
    |                                       |
    +---------------------------------------+
```
J'actualise et voilà ce que nous avons par défaut. 

Évidemment tous les éléments sont de type bloc parce que `<header>`, `<section>`, `<aside>` sont comme des `<div>` donc ça fonctionne comme des types blocs donc si on essaie de faire un design avec ça on obtient donc ça qui n'est pas forcément génial. 

D'ailleurs si je veux virer toutes les marges appliquées par défaut à tous les éléments, on fait un margin:0; ensuite on vers le 'outline' à none parce que ce n'est pas joli et on met un 'padding' à 0 pour obtenir tous les éléments les uns à la suite des autres.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

>    *
>    {
>        margin:0;
>        outline:none;
>        padding:0;
>    }

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    header
    {
        background-color:rgb(209, 175, 160);
        height:80px;
        margin:auto;
        width:1000px;
    }

    section
    {
        background-color:rgb(134, 175, 155);
        margin:auto;
        width:800px;
    }

    aside
    {
        background-color:rgb(212, 172, 154);
        margin:auto;
        width:200px;
    }

    footer
    {
        background-color:rgb(138, 161, 236);
        height:30px;
        margin:auto;
        width:1000px;
    }
```
```txt
    +---------------------------------------+    
    | Bonjour !                             |    
    +---+---------------------------+-------+
        |<p>Lorem...</p>            |
        |<p>Lorem...</p>            |
        |<p>Lorem...</p>            |        
        +-------+-------+-----------+
                |<img>  |
                |<p>Lor.|
                |...    |
                |</p>   |
    +-----------+-------+-------------------+
    |                                       |
    +---------------------------------------+
```
Alors là on obtient tous les éléments les uns à la suite des autres et donc moi je veux que `<section>` se trouve à gauche et que `<aside>` se trouve à droite. 

Alors on peut utiliser 'float' même si ce n'est pas la solution la plus moderne mais on verra ça dans les prochaines vidéos c'est à dire qu'on peut mettre les éléments en flottant c'est-à-dire que le `<section>` je vais dire que tu es en flottant à gauche et que le `<aside>` tu seras en flottant à droite tout simplement.
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float
    */

>    *
>    {
>        margin:0;
>        outline:none;
>        padding:0;
>    }

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    header
    {
        background-color:rgb(209, 175, 160);
        height:80px;
        margin:auto;
        width:1000px;
    }

    section
    {
        background-color:rgb(134, 175, 155);
        margin:auto;
        width:800px;
>       float:left;
    }

    aside
    {
        background-color:rgb(212, 172, 154);
        margin:auto;
        width:200px;
>       float:right;        
    }

    footer
    {
        background-color:rgb(138, 161, 236);
        height:30px;
        margin:auto;
        width:1000px;
    }
```
Une autre solution ce serait éventuellement de ne pas mettre un flottant à droite mais lui mettre en décalage de gauche de 800 pixels, voilà on peut faire l'un ou l'autre c'est comme vous voyez. 

Et là on obtient automatiquement ces éléments là.
```txt
    +-----------------------------------+    
    | Bonjour !                         |    
    +---------------------------+-------+
    |<p>Lorem...</p>            |<img>  |
    |<p>Lorem...</p>            |<p>Lor.|
    |<p>Lorem...</p>            |...    |
    +---------------------------|</p>   |
								|		|
                                +-------+
```
Ça c'est une chose à savoir. 

Alors déjà on remarque un truc, première chose c'est que l'élément `<footer>` a disparu, on voit qu'il a disparu. 

Pourquoi est-ce qu'il a disparu ? Tout simplement parce que à partir du moment où on utilise des flottants c'est-à-dire des éléments flottants, des éléments flottants tout ce qui va suivre derrière va garder la même propriété donc il faut à un moment donné dire on arrête le mode flottant sur l'élément qui suit. 

On a donc plusieurs manières de faire, soit on veut que le mode flottant s'arrête avec avec mon élément qui est en float:left; donc dans ce cas là j'utilise la propriété 'clear' à qui on va mettre la valeur "left".
```css
    /*
        display, visbility, opacity

        position
        top, right, bottom, left
        z-index

        float, clear
    */

    *
    {
        margin:0;
        outline:none;
        padding:0;
    }

    body
    {
        background-color: background-color:#EFEFEF;
        margin:auto;
        width:1000px;
    }

    header
    {
        background-color:rgb(209, 175, 160);
        height:80px;
        margin:auto;
        width:1000px;
    }

    section
    {
        background-color:rgb(134, 175, 155);
        margin:auto;
        width:800px;
        float:left;
    }

    aside
    {
        background-color:rgb(212, 172, 154);
        margin:auto;
        width:200px;
        float:right;        
    }

    footer
    {
>       clear:left;
        background-color:rgb(138, 161, 236);
        height:30px;
        margin:auto;
        width:1000px;
    }
```
```txt
    +-----------------------------------+    
    | Bonjour !                         |    
    +---------------------------+-------+
    |<p>Lorem...</p>            |<img>  |
    |<p>Lorem...</p>            |<p>Lor.|
    |<p>Lorem...</p>            |...    |
    +---------------------------|</p>   |
	|							|		|
    +---------------------------|       |
                                +-------+
```
Voilà on lui dit d'effacer le flottement à gauche et donc le `<footer>` se met à la fin du flottement gauche par contre vous voyez que le flottement droit continue. 

Si je veux faire l'inverse je vais mettre, clear:right; et du coup l'élément flottant va se mettre à la fin du flottement droit.
```css
>       clear:right;
```
```html
    +-----------------------------------+    
    | Bonjour !                         |    
    +---------------------------+-------+
    |<p>Lorem...</p>            |<img>  |
    |<p>Lorem...</p>            |<p>Lor.|
    |<p>Lorem...</p>            |...    |
    +---------------------------|</p>   |
								|		|
                                |       |
    +---------------------------+-------+
    |                                   |
    +-----------------------------------+
```
Bon à éléments flottants s'est mis en dessous de l'élément `<aside>`. 

Si je veux que ça se fasse pour les 2 ce qui est le cas en tout cas par rapport au design que je voulais faire, on va utiliser la valeur "both" qui veut dire pour les 2 donc pour à la fois le flottement à gauche et à droite mais là ça ne va rien changer parce que `<aside>` est l'élément le plus grand au niveau hauteur.
```css
>       clear:both;
```
```txt
    +-----------------------------------+    
    | Bonjour !                         |    
    +---------------------------+-------+
    |<p>Lorem...</p>            |<img>  |
    |<p>Lorem...</p>            |<p>Lor.|
    |<p>Lorem...</p>            |...    |
    +---------------------------|</p>   |
								|		|
                                |       |
    +---------------------------+-------+
    |                                   |
    +-----------------------------------+
```
Voilà donc d'autres situations pourraient vous montrer éventuellement comment est-ce qu'on pourrait s'arranger pour que `<section>` et `<aside>` ait la même hauteur pour éviter un espace blanc avant le `<footer>` parce que là en fonction de ce qu'on met à droite un élément ne va pas forcément continuer complètement vers le bas. 

Voilà on regardera ça par la suite parce que je ne vais pas forcément vous parler de ça maintenant parce que ce n'est pas le sujet dans cette vidéo. 

Grosso modo voilà comment fonctionne le principe de flottement, gauche et droite, et n'oubliez pas évidemment pour les éléments qui suivent ensuite d'annuler ce flottement avec la propriété 'clear' sinon Sarah voulait garder ce qui serait un petit peu embêtant donc c'est tout ce que je voulais vous montrer de toute façon pour cette vidéo donc on regardera tout ça. 

Voilà le fait que le verre ne continue pas comme ça pour se mettre sur le bleu, pour se mettre à la même hauteur que le `<aside>`, on verra ça dans des cas pratique parce que ce n'est pas le sujet de cette vidéo du tout donc vous verrez ça dans déca un peu plus concret. 

En tout cas j'espère que ça vous aura permis d'apprendre beaucoup de choses, il n'y a pas trop de propriété là pour le coup si on compare avec les précédents de vidéo il y en avait énormément énormément avec les 'padding', 'margin' et cetera mais elles sont à connaître. 

Voyez qu'on peut faire beaucoup beaucoup de choses donc il faut bien connaître tout ça et ça va vous permettre tout ce système que vous avez vu de passer aux méthodes de positionnement, de dimensionnements de box donc de boîte un peu plus moderne, un peu plus récent. 

On va pouvoir aborder tout ça et après on aura bien sûr avancé pas mal au niveau du CSS et peut-être même que au niveau du cours on aura fait le tour parce que après d'autres choses je vais les garder pour les tutos donc tout ce qui est transitions, et animations donc je pense que ça restera pour des tutos. 

Voilà ce n'est pas obligatoire parce que vous n'êtes pas obligé d'apprendre à faire de l'animation en CSS pour créer un site web par exemple, ça reste du surplus pour faire plus de graphisme ou du jeu vidéo donc on regardera sûrement ça pour des tutos. 

En tout cas pour la suite des propriétés que je voulais vous faire voir on arrive quand même pas très très loin de la fin du cours HTML CSS et j'espère que ça vous apprend pas mal de choses. 

Et encore une fois le meilleur moyen de mettre en pratique tout ça c'est de vous faire un petit site web, choisissez par exemple un thème qui vous plaît genre vous avez un manga qui vous plaît, une série, vous aimez les voitures ou le jardinage et donc prenez n'importe quel thème qui vous plaît et du coup faites-vous un petit site là dessus. 

Voilà du coup un petit site statique avec HTML CSS.

Par exemple si quelqu'un veut faire quelque chose sur la botanique, il fera dans des couleurs vertes. Si quelqu'un veut faire un site de voiture, il fera peut-être des couleurs un peu plus foncé et si quelqu'un veut faire sur un manga il fera selon les couleurs du manga ou ce genre de chose.

Comme ça vous pourrez mettre en pratique tout ça dans un exercice, dans un petit projet qui vous plaît parce que vous aurez choisi un sujet un thème qui vous plaît et voilà et c'est comme ça de créer un site thématique en fonction du sujet que vous avez choisi. 

Voilà un exemple de petits projets que je peux vous inviter à faire si vous voulez sachant que là vous avez vu sans parler des méthodes modernes, vous avez vu tout ce qu'il faut en web avec tout ce qu'on a vu là pour pouvoir créer un site web sans problème tel que ça se faisait avant l'arrivée des méthodes avant l'arrivée des boîtes dynamiques, ce genre de chose. 

Alors oui tout ça n'existait pas avant c'est arrivé que très récemment, et moi sur le premier site web que j'ai pu faire, Eh bien je n'utilisais pas ces systèmes modernes là donc vous pouvez largement créer des sites web avec tout ce qu'on a vu jusqu'à présent. 

Pour ceux qui veulent un exercice une idée de choses à faire avec tout ce que vous avez vu là, et bien là maintenant vous en avez un bon, choisissez un thème s'il vous plaît faites un site thématique là-dessus. 

Et à la fin quand vous aurez fait votre site pas forcément pour vous montrer votre code CSS ou autre parce que je n'aurai pas le temps de voir pour tout le monde mais c'est après vous voulez faire des petites captures d'écran de votre site web, du design et tout ça pour voir un petit peu comment ça rend donc n'hésitez pas à le partager dans les commentaires de cette vidéo et comme ça ça profitera aussi à d'autres gens et ça motivera d'autres personnes avec très peu de vidéo parce qu'il y a 21 séance là pour le coup, qu'on peut faire déjà des trucs très très sympa. 

Si vous voulez je vous partagerai aussi peut-être des petits exemples de design, je ferais ça aussi pour ceux que ça intéresse donc n'hésitez pas à me demander sur discord tout autre pour que je vous fasse des petits sites rapides avec des petits design comme ça pour vous montrer plusieurs possibilités juste avec ce qu'on a vu là sans parler de 'flexbox' et de 'grid' juste ce qui a été vu avec ces 21 vidéo pour que vous voyez un petit peu le genre de site web que l'on peut faire. 

Simplement pour dire qu'on n'est pas limité parce que les nouveaux systèmes sont là pour simplifier les choses mais pas forcément pour rajouter de nouvelles possibilités donc on peut déjà pas mal se débrouiller avec les systèmes de flottement comment la vue et les systèmes de positionnement comme on a abordé sur cette vidéo et les précédentes. 

En tout cas moi je vous dis à bientôt pour la suite de cette formation HTML CSS et s'il y a des questions n'hésitez pas à les poser en commentaire, vous avez encore et toujours le discours si vous avez besoin d'aide par rapport aux autres abonnés ou même directement pour me contacter, par exemple pour vous partager le design de votre site que vous venez de réaliser et donc on se retrouvera du coup pour une prochaine vidéo sur ce cours en web. 

À bientôt tout le monde.

ciao