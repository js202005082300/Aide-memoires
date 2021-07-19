# [3. Fonctionnement balises](https://www.youtube.com/watch?v=1sPjNkKGMsY)
15-01-21

A la séance 2, nous avons vu comment créer notre première page web.

On a découvert les première balises obligatoires dans un modèle très simple pour définir la structure de notre page web.

Dans cette séance, on revient sur les balises en apportant quelques précisions sur leur fonctionnement.

C'est un petit cours de transition avant de découvrir le langage afin de se mettre d'accord sur le fonctionnement des balises.

Pour se faire, on va pas utiliser de vrais noms de balises ou de structure HTML. On va juste utiliser des exemples comme ça pour pouvoir comprendre.

Pour les balises, on a vu deux types de balises qui existaient :

On a les balises classiques. Une balise ouvrante et fermante et quelque chose dedans. C'est quelque chose de tout à fait classique. C'est la règle, toute balise ouverte doit être fermée, sauf pour les balises orphelines.
```html
<balise>du texte</balise>
```
On a la balise orpheline. Elle est fermée complètement.
```html
<baliseOrpheline>
```
C'est ce qu'il faut savoir : On a une ouverture et une fermeture de balise ou bien une balise orpheline qui se ferme toute seule. On choisit tel ou tel balise selon les cas (nous verrons). Des balises orphelines, il n'y en a pas beaucoup, quelques exceptions.

Par exemple, nous avons vu la balise orpheline <meta charset="utf-8"> qui possède un attribut. 

Les balises ont un nom et peuvent recevoir des attributs à l'intérieur d'une balise séparé par des espaces. Ces attributs sont identifié avec un nommage, un égal puis entre double guillemets, on a la valeur de l'attribut. L'attribut est charset qui permet de 
définir l'encodage et on choisit l'UTF-8 pour définir notre document.

En HTML, l'ordre des balises a tout à fait son importance. Par exemple, nous avons une balise A qui contient du texte et une autre balise B. Il faut comprendre que c'est la dernière balise qui a été ouverte, qui doit être fermée en premier. Et ensuite, je referme la première balise. C'est super important, il faut bien respecter cette ordre.
```html
<baliseA>Bonjour tout <baliseB>le monde</baliseB></baliseA>
```
Ceci signfie que tout l'ensemble de mon texte et de ma phrase est inclu dans la balise A. Et à l'intérieur de ce texte là, la partie "le monde" est contenue dans la balise B. 

On peut ainsi sans problème mettre des balises dans d'autres.

On peut faire de l'imbrication de balises mais dans ce genre de cas, il faut comprendre qu'elles doivent être fermées dans l'ordre inverse où elles ont été ouverte.

On peut parler d'héritage (surtout pour le langage CSS). On pourra définir des propriétés pour la balise A avec des choses qui se passerait sur le contenu mais automatiquement comme balise B est contenue dans balise A, il en hérite. C'est à dire que toutes les
propriétés qui ont été définies pour balise A, et bien balise B en héritera aussi.

Ce qui signifie que tout ce qui se passera sur le texte "Bonjour tout", se passera également sur le texte "le monde". 

Dans ce cas là, il faut redéfinir les propriétés pour balise B pour que ce soit différent des propriétés de balise A.

Ce qu'il faut retenir :

Les balises sauf si elles sont orphelines doivent être ouvertes et doivent être fermée. Ensuite il faut bien respecter l'ordre d'ouverture et de fermeture. Si on a ouvert une balise A et ensuite une balise B, il faut refermer dans l'ordre B puis A.

Si on inverse l'ordre, il y aura un gros soucis.

Il faut ensuite bien comprendre qu'on peut imbriquer les balises. Il y aura des notions d'heritage pour ces balises imbriquées. On verra surtout cela au niveau CSS, avec HTML ce ne sera pas si important que cela même si il y en aura quand même un petit peu.

Plus tard on verra qu'on peut avoir un espace de contenu et qu'à l'intérieur, on pourra mettre un titre et ensuite des paragraphes et dans le paragraphe, on pourra formater une certaines partie du texte dans le paragraphe. On comprend ici qu'il y a un espèce de système d'imbrication. On a des balises qui sont dans d'autres, etc. 

Il y a une histoire de balises parente, la balise A est la balise parente. Et la balise fille, c'est la balise B parce qu'elle est contenu à l'intérieur.

C'est vraiment à retenir, c'est des choses à savoir. Et donc a bien comprendre pour la suite, parce que toutes les balises qu'on va voir, vont suivre ce schéma.

Cette séance courte permet d'entrevoir le fonctionnement des balises. Sur base de cela, on peut revenir à la séance précédente pour revoir la structure d'une page web pour comprendre Comment on a produit les choses ?, revoir comment sont définies les balises ? des balises normales, des balises orphelines. Cette petite notion de base est super importante pour la suite puisque tout va reposer là-dessus.

Dans la prochaine séance, nous veront les premières balises et commencer à créer du contenus, à avoir quelque chose sur nos page web. Et on démarera sur quelque chose qui se passe sur du texte. C'est la base avant de commencer à travailler sur des images, des formulaires, des tableaux. On se concentrera d'abord sur le texte.