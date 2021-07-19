# [4. Formatage texte (1/2)](https://www.youtube.com/watch?v=w2knKi0ZQps)
15-01-21

Cette séance est la première partie de ce qui concerne le formatage de texte sur les pages web.

Nous allons voir des balises standard standard très simple à utiliser et qui seront utiliser régulièrement. Dans la seconde partie, on va voir des balises un peu moins utilisées.

On va aller assez vite sur nos balises parce qu'elles fonctionnent selon le contexte.

On va s'intéresser au fond de nos pages web, cest à dire le contenu pour voir comment cela fonctionne.

Il faut savoir que les moteurs de recherches (Google, Bing, etc) qui vont scrooler les pages de nos sites web vont se baser sur ces balises pour identifier le contenu qui est le plus pertinent ou la manière de l'organiser. Cela a vraiment toutes son importance d'utiliser les balises dans ce sens.

## Le paragraphe : Afficher le texte dans le navigateur. 

Si on ajoute le même paragraphe, tout va s'afficher à la suite parce qu'on lui a juste demandé d'afficher du texte. Il ne prend pas en compte, les tabulation et les passages à la ligne que l'on peut faire. Il va lire tel quel sans les prendre en compte.

La balise de paragraphe qui s'appelle <p> sera la plus utilisée même si dans certains cas, elle peut être omise c'est à dire qu'on est pas obligé de fermer la balise à la fin du paragraphe. C'est egalement le cas quand on on utilisera une balise pour spécifier une adresse postale.
    
On preferera la mettre pour avoir une page sémentiquement valide. Il est recommandé de toujours faire la fermeture des balises de paragraphes parce que c'est beaucoup plus propre et beaucoup plus logique aussi pour bien séparé les deux paragraphes.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>

<!-- 
    Ceci est un commentaire.
    La suite du commentaire.
-->
```

## Le retour à la ligne : `<br>`

On peut directement agir sur le texte pour faire un saut de ligne en utilisant la balise `<br>`. C'est une balise orpheligne, qui n'as pas de balise de fermeture.

Pour une raison de lisibilité dans nos page, on fait un retour à la ligne après un retour à la ligne. Peu importe le nombre de passage à la ligne que l'on fait dans le texte, ça ne changera pas si on actualise la page, ça n'as aucune incidence sur l'affichage réel. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam <br> conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.
</body>
</html>
```

## Le séparateur horizontale : `<hr>`

La balise `<hr>` (à ne pas confondre avec la notation XHTML (XML) : `<hr />`) est une balise orpheline qui ne contient pas de slashs tout comme la balise `<meta charset="utf-8">`.

Comme ça c'est beaucoup clair et on comprend bien que c'est une balise HTML.

`<hr>` va permettre d'afficher un séparateur horizontale sur lequel on pourra changer la mise en forme avec CSS. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>

    <hr>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```

## Mettre en évidence un texte important : `<strong>`

Quand on écrit un rapport, un article, etc, il faudra mettre en évidence certains type de texte. Pour cela nous avons plusieurs termes : `<strong>`. 

Elle permet de considérer une partie comme plus importante avec sa balise ouvrante et l'autre fermente. Pour qu'on puisse l'afficher humainnement parlant, les navigateurs l'affichent en gras.

Attention, si on veux afficher du texte en gras, il ne faut pas utiliser cette balise `<strong>`. Avec CSS, on pourra spécifier des classes pour agir sur la mise en page, la forme de notre texte. C'est à ce moment où l'on pourra choisir de le mettre en gras. 

`<strong>` permet d'annoncer aux différents moteurs de recherches qui vont analyser nos pages que l'extrait en question est important. Il est à mettre en évidence puisqu'on a utiliser les balises strong. C'est comme ça qu'il faut réflechir, pas en termes d'affichage même si les navigateurs peuvent changer l'affichage de certaines choses quand on utilise des balises particulières mais ils le font pour que ce soit humainnement visible mais ce n'est pas fait pour afficher en gras.

C'est vraiment pour mettre en évidence un texte important, une portion importante d'un texte.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <strong>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </strong>in civitatibus perviis.</p>
</body>
</html>
```

## Mettre en évidence un texte : `<em>`

`<em>` fait un peu la même chose que `<strong>` mais les navigateurs l'affche en italique.  C'est tout simplement pour montrer qu'un texte à de l'importance dans un extrait. 
    
C'est pour montrer qu'un extrait à de l'importance.

 Quand un navigateur va voir `<em>` ou `<strong>`, il va voir que cette portion de texte a de l'importance. 

On a le choix entre `<em>` et `<strong>` pour mettre en évidence une portion de texte. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <em>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </em>in civitatibus perviis.</p>
</body>
</html>
```
Au lieu de mettre en évidence, on va pouvoir mettre que quelque chose doit être supprimé, remplacé, etc. Pour cela, on utilise la balise `<del>`. C'est pour indiquer que cette portion de texte, il ne faut plus la prendre en compte parce qu'elle va devoir être remplacée.

Pour dire que ca va être supprimé, remplacé donc il ne faut pas en prendre compte.

La plupart du temps, les navigateurs vont le rendre visible en le barrant.

Par exemple, on a le nombre d'habitant qui était à 800 mais ce chiffre n'est plus à jour.

Pour cela on indique au navigateur que cette information n'est plus d'actualité avec la balise `<del>` c'est à dire qu'on considère qu'elle est à remplacer. 
    
On peut également mettre en évidence la nouvelle information en utilisant une autre balise de formatage qui est la balise `<ins>` qui fait penser à "insert". Ainsi on a insérer une nouvelle information. Le fait d'utiliser, ces deux là ensemble, ça montre bien que `<ins>1 200</ins>` est la nouvelle info.

La nouvelle information va être soulignée par les navigateurs.

C'et toujours la même chose, ce n'est pas la mise en forme qui importe, c'est la sémantique, c'est à dire la cohérence au niveau de l'information, au niveau du contenu donc du texte.

On met bien évidence que ce n'est plus 600 mais 1 200. Les moteurs de recherche vont bien prendre l'information en compte puisqu'on a utilisé des balises adéquates. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Il y a <del>800</del><ins>1 200</ins>  habitants dans ce village.</p>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```

## La balise `<mark>`

Une autre balises qui est utilisé par les moteurs lorsqu'il y a une recherche. Elle va surligner de manière visible une portion de texte.

Avec CSS on pourra changer la couleur et la mise en forme bien qu'en général ce soit affiché en jaune. Ca met en évidence qu'on a voulu faire en recherche dans un texte.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <mark>agitare</mark> quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```
Grosso modo, nous avons fait le tour des certaines balises d'intérêt sur tout ce qui est formatage, mise en évidence d'un texte : `<strong>`, `<em>`, `<del>`, `<ins>` et `<mark>`. 

On en a également quelques autres dont certaines ont été retirés du standard puis finalement remises. Avant elles avaient une certaine utilitée. Elles ont été enlevées avec l'arrivé comme `<strong>` mais finallement elles ont été remise dans HTML5 mais pour une utilisation différente. 

Attention à la date des présentation sur internet parce qu'on peut retrouver beaucoup de choses qui sont fausse et qui ne sont plus forcément d'actualité.

## La balise `<b>`

Avant HTML ne faisait pas la différence entre la sémantique (le contenu) et la mise en forme. On se servais de la balise `<b>` pour mettre du texte en gras.
    
C'etait visuel, dés qu'on voulait mettre du texte en gras, on utilisait la balise `<b>`. 

Par la suite quand ils ont voulus séparé le fond de la forme, ils ont retiré cette balise du standard. La balise était devenue obsolète, il ne fallait plus l'utiliser en HTML5 et finallement il l'ont réinstaurée pour dire que l'on met un texte en gras mais pas de manière aussi importante qu'avec `<strong>`. 

Si on veux mettre en évidence un texte, une portion de texte, il faut utiliser la balise `<strong>` par contre si le texte à un juste un peu plus d'importance que l'ensemble du paragraphe, on utilise `<b>`.

Elle va mettre le texte en gras mais avec une mise en évidence plus faible que `<strong>`.

Il n'est pas recommandé d'utiliser cette balise `<b>`. Elle est très discutable comme balise HTML. C'est pour ça qu'il n'ont pas arrêté de l'enlever et de la remettre. On peut s'en passer.

Utiliser `<em>`, `<strong>` de préférence pour mettre en évidence un texte. Si on voit néanmoins la balise `<b>`, ce n'est plus une erreur. C'est tout à fait autorisé, inclus dans le standard. Son utilisation a été pourtant très discuté.  
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <b>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </b>in civitatibus perviis.</p>
</body>
</html>
```

## La balise `<i>`

Cette balise avait été retirée mais elle a finallement été remise.

Avant elle s'occupait de mettre le texte en italique tout simplement.

Maintenant, elle a une vrai utilité. 

La balise `<i>` est prévue pour mettre en évidence un texte à part du reste du texte. C'est quelques chose qui n'est pas forcément en lien avec ce que l'on détaille dans le paragraphe. Cette balise a une utilité un peu plus importante qu'avant lorsqu'elle consistait juste à mettre en italique.
    
Par contre, il est préférable de l'utiliser si on ne peut pas utiliser la balise `<b>`, la balise `<em>`, la balise `<strong>` ou d'autres que l'on va voir.
    
C'est la solution de secours si vraiment on ne peut pas l'utiliser.

Mais son utilisation est discutable et on évitera de l'utiliser si on a pas besoin volontairement. AU niveau du standard, il ont du mal à se décider aussi.

La balise `<b>` et la balise `<i>` ne sont pas recommandé. Utiliser les autres avant de penser à ces balises. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <i>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </i>in civitatibus perviis.</p>
</body>
</html>
```

## La balise `<s>`

Pareil, elle a été utilisée avant d'avoir été retirée puis réinsérée.

La balise `<s>` servait à barrer le texte.

Il y avait avant un intérêt de mise en forme. 

A la différence de `<del>` qui signifie qu'un texte doit être supprimé ou remplacé, la balise `<s>` signifie carrément que cette portion de texte n'est pas correcte, n'est pas pertinente. 

Ca va vraiment indiquer aux moteurs de recherches que cette portion de texte ne doit pas être prise en compte parce qu'il n'est vraiment pas pertinent, que cet élément n'apporte aucun intérêt.

C'est vraiment différent de la balise `<del>` qui ne signifie pas forcément que l'information est fausse mais qu'il faut la supprimer ou la remplacer.
    
L'information n'est pas forcément mauvaise, c'est juste qu'on en veut plus. 

La balise `<s>` va vraiment indiquer que l'information est incorrecte.
    
La balise `<s>` est vraiment différente.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <s>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </s>in civitatibus perviis.</p>
</body>
</html>
```

## Les titres

Dans la rédaction d'un article, il faut bien titrer tout ce que l'on fait, titrer nos paragraphes. Pour cela, il va y avoir une hiéarchie de titres qui vont du plus important au moins important. 

Ca va donc de `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>` jusqu'à `<6>`.

De base, c'est la taille d'affichage qui change.

Pareil, quand on ferra la mise en forme avec CSS, ceci pourra être changé.

Au niveau des moteurs de recherches, ceux qui vont analyser nos pages, quand ils veront un `<h1>`, ils seront que c'est le titre principale et quand ils veront `<h6>` il veront que le titre est beaucoup moins important. 

En règle générale, il ne faut qu'un `<h1>` parce que c'est le titre principale, il ne faut qu'un titre `<h1>` par type de section mais pour l'instant `<body>` est la seul section que l'on a vu. 

Dans le `<body>`, je ne peut avoir qu'un seul `<h1>`. On ne peut mettre qu'un seul `<h1>` dans un ensemble de balise section.

On peut avoir qu'un seul `<h1>` dans des balises d'en-têtes.

Les autres titres peuvent apparaître autant que l'on veut.

On peut ajancer les éléments de la manière à avoir un titre, un paragraphe,un titre, etc.
```html
    <h1>Titre 1</h1>
    <p> bla bla </p>
    <h1>Titre 2</h1>
    <p> bla bla </p>
    <h1>Titre 2</h1>
    <p> bla bla </p>
    ...
```
Du titre de la page, on peut faire des partie, puis des sous-partie, etc jusque `<h6>`. En réalité on utilise plus rarement au delà du `<h4>`.
    
Il faut bien respecter le fait d'avoir un seul titre `<h1>` par type de section. Par exemple, `<body>` est considéré comme une section de la page donc un seul `<h1>` dans le `<body>`. Mettre deux `<h1>` dans la même section n'est pas valide du tout.
```html
    <body>
        <h1>Titre section 1</h1>
    <truc>
        <h1>Titre section 2</h1>
    </truc>
    </body>
```
`<truc>` serra à part même si c'est intégré dans le `<body>`. 
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <h1>Mon plus grand titre</h1>
    ...
    <h6>Le plus petit titre</h6>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <strong>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes </strong>in civitatibus perviis.</p>
    
    <h2>Deuxième partie</h2>

    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```

## Les citations `<q></q>`

On a vu toutes les balises principales, paragraphes, de formatages, les titres.

Nous allons voir les citations bien qu'elles ne fassent pas partie des balises avancées. On fait souvent des citations lorsqu'on écrit des articles ou autre.
	
Il y a 3 balises principales à connaître qui ont vraiment un intérêt.
	
	La balise <q></q>
	
La balise `<q></q>` est une balise qui va permettre de faire une citation assez courte depuis une source externe. On va pouvoir l'ajouter à notre texte et admettons qu'on veux faire une citation d'un document externe. On considère une citation qui est courte sous entendu une phrase ou quelque mot. 
	
A l'affichage, le moteur va l'afficher entre doubles quotes que l'on ne peut pas sélectionner. On constate que la citation a bien été mise en évidence.
	
On peut également utiliser un attribut qui serra la source de cette citation, cet attribut est "site", qui prend le lien source d'un site par exemple.
    
Par exemple, `<q cite="https://">` suivi du lien qui mène vers l'endroit ou a été trouvé cette sitation.
    
Cet attribut permet de bien mettre en évidence la source de ce que l'on a cité.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <q cite="https://lesite.fr">Mon site</q>agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```

## La balise `<cite></cite>`

La balise `<cite></cite>` va permettre de pouvoir citer de manière courte l'ensemble de l'information.
	
`<cite>` va permettre notamment à citer le titre d'une oeuvre, le titre, le titre d'un document, le titre d'un événnement, le titre d'un rapport, ce genre de chose.
	
Elle n'est par contre pas faite pour citer des personnes, un auteur, un chanteur, un artiste, ... Il ne faudra pas utiliser cette balise.
	
C'est vraiment pour citer un nom de document, de livre ou de film.
	
Si on actualise la page, on ne voit pas beaucoup de différence à part que la citation a été mise en italique. Mais bon avec de la vrai mise en forme, on pourra changer la manière dont on affiche les citations courtes, issues de documents, etc.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus <cite>agitare quaedam conducentia saluti </cite>suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.</p>
</body>
</html>
```

## La balise `<blockquote></blockquote>`
	
Si on veux pouvoir citer tout un paragraphe, on utilise la balise <blockquote></blockquote>.

C'est une balise de citation.

C'est une balise fermante.

Elle permet par exemple d'identifier tout un paragraphe comme une citation.

On peut y mettre à la fin le nom d'une personne comme par exemple monsieur Richard.

Après actualisation, cette balise met en évidence le texte en mettant une petite indentation.

Cela permet de mettre en évidence notre citation longue.
	
Comme pour la balise `<q>`, on peut utiliser l'attribut cite si ça provient d'un site ou d'une page spécifique.
	
On peut mettre un lien avec l'attribut cite (pas la balise) pour indiquer la source de cette information là bien que ça ne changera rien à l'affichage mais pour le moteur de recherche qui fait analyser nos pages, il va pouvoir accéder aux codes des pages donc il va tomber sur la valeur de l'attribut cite et il va trouver un lien externe de tout cet ensemble de citation.
	
Il faut retenir l'importance de cette sémentique, la présentation, le formatage des données.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
	<blockquote>
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis (Mr. Richard).</p>
    </blockquote>
	
	<blockquote cite="Https://lien...">
    <p>Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis (Mr. Richard).</p>
    </blockquote>
</body>
</html>
```

## La balise `<details></details>`
	
Si par exemple, il y a un texte que l'on ne veut pas spoiler, l'afficher à tout le monde par défaut.
	
On pourra utiliser la balise `<details>`. Sans forcément utiliser de paragraphes.
	
Pendant l'affichage, il est utile de cliquer sur le mot ou la flèche pour afficher le contenu.
	
Ca peut être utile quand on ne veut pas spoiler les gens. Ainsi ne pas l'afficher par défaut peut être pratique.
	
	La balise <summary></summary>
	
Si on veux changer le mot détails, on met à l'intérieur de la balise une autre balise `<summary></summary>`.

A l'affichage, on voit que l'on change l'information.

A la mise en forme, on pourra la changer. Changer la couleur de fond, faire un cadre, etc.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
	<details> blablabla </details>
	
	<details> 
		<summary>Cliquez pour afficher l'information</summary>
		blablabla 
	</details>

</body>
</html>
```

## La balise `<a></a>`
	
Un balise super importante quand on rédige du texte ou autre.
	
C'est la balise pour faire des liens. C'est quand même une des plus importantes.
	
Comment faire un lien internet ?
	
Un lien internet nécessite d'écrire la balise `<a></a>` et on utilise un attribut qui est HREF.
	
C'est l'attribut pour mettre une adresse. Il faut ensuite terminer avec la balise fermante `</a>`.
	
Ca fonctionne avec un lien et entre la balise ouvrante/fermante, on met le texte que l'on veut.
	
Toujours à l'affichage, dés que l'on clique dessus, ça nous redirige vers le site.
		
	l'attribut title
	
On peut également afficher l'information si l'information entre balise n'est pas en accord avec ce que l'on a dans le lien.
	
On peut utiliser l'attribut title.
	
Par exemple, on peut mettre "site personnel de Jason"
	
Par contre il faut éviter de répeter le contenu entre balise avec la valeur contenue dans title.
	
Ce sont des informations redondantes. Ca veut dire que le title ne sert à rien.
	
De plus, si on passe la souris, le lien affichera une petite info-bulle. Ce qui peut servir pour l'information.
	
	L'attribut target
	
On peut utiliser cet attribut pour ouvrir le lien dans un autre onglet.
	
On écrit la valeur _blank avec un underscore au début. Ce qui permet de ne pas quitter notre onglet. Il faut savoir que dans le target, on peut mettre d'autres informations que _blank.
	
Par défaut, la page s'ouvre bien sûr dans le même onglet.
	
	Remarque :
	
Beaucoup de discussion autour de `target="_blank"`. Beaucoup vont dire qu'il vaut mieux ouvrir un lien dans la même page et d'autres vont dire qu'il faut l'ouvrir sur un nouvel onglet. Il y a un débat qui se fait entre les deux. Quel est le mieux des deux ? Il suffit de choisir celui qui nous convient le plus.
	
Parceque le problème est que si on ouvre directement une nouvelle page sur le même onglet est que l'utilisateur perd notre page malgré les options pour revenir en arrière.
	
Et il est possible, surtout si la personne ne maitrise pas l'outil informatique, que cette personne ne puisse pas retourner sur le site d'avant. Ca peut être embêtant.
	
Après, il est possible de perdre l'onglet d'avant quand on ouvre sur un nouvel onglet parce que le nombre d'onglet ouvert dans le navigateur est dupliqué.
	
C'est pourquoi les arguments avancés sont bons et pas bons dans les deux cas. 
	
Et bien sûr, ça va dépendre beaucoup de la personne en face.
	
Dans certains cas, c'est bien dans le même site, d'ouvrir la page dans le même onglet mais si on veux mettre un lien vers un autre site, un document ou autre, ça peut être mieux de le faire sur un nouvel onglet, histoire de ne pas mélanger.
	
Libre à nous de choisir la méthode. Pas une est mieux que l'autre car de toute façon, tout dépend des cas.
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
	<a href="https://jasonchampagne.fr">bla bla.</a>
	<a href="https://jasonchampagne.fr" title="site personnel de Jason">Site...</a>
	<a href="https://jasonchampagne.fr" title="site personnel de Jason" target="_blank">Site...</a>
</body>
</html>
```
Dans la prochaine séance, nous veront les balises un peu plus avancées qu'on utilisera beaucoup moins voir pas du tout mais qu'il faut connaître un minimum.
	
A bientôt et entrainez-vous pour comprendre leurs intérêts.