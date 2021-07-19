# [Balises obsolètes](https://www.youtube.com/watch?v=23Kcs7AW-18)
17-02-21

## \<abbr\> remplace \<acronyme\>
```html
<p>Langage <acronyme title="Hypertext Markup Language">HTML</acronyme> pour faire des pages web</p>
```
\<acronyme\> est obsolète donc utiliser \<abbr\>.
```html
<p>Langage <abbr title="Hypertext Markup Language">HTML</abbr> pour faire des pages web</p>
```

## <\object\> remplace \<applet\>
```html
<applet>
```
\<applet\> est obsolète donc utiliser \<object\>

Avant on avait des jeux qui pouvaient être développés avec des applets java. En java donc le langage de programmation java pouvait être utilisé et il fallait utiliser justement une balise applet spécialement pour ça donc évidemment comme c'était très spécifique ça a été abandonné par la suite, déprécié puis rendu justement obsolète et maintenant il faudra utiliser à la place la balise object qui elle est générique en fait, elle est générale à tous types de contenus extérieurs que ce soit une application peu importe le langage en fait on s'en fiche un petit peu mais tout ce qui va être intégration va pouvoir se faire avec la balise object qui elle est très très générique donc utiliser celle là à la place et abandonné toute utilisation de la balise applet.

## <\font>\ & <\basefont\> & \<big\> & \<center\> obsolètes
Ne plus utiliser ces attributs mais à la place un fichier css avec des sélecteurs d'attributs.
```html
<basefont color="#000000"\>
<font>
<p>Un texte normal avec <big>un texte écrit en gros\</big> dedans\</p>
```
Par exemple, big n'est plus à utiliser maintenant si vous voulez le faire vous passer automatiquement par le css et vous utilisez la fameuse propriétés font-size qui permet de modifier la taille du texte d'un élément, d'un contenu, d'un paragraphe ce genre de choses en utilisant les bons sélecteurs tout simplement donc là dans ce cas-là il faudrait utiliser ainsi un span par exemple span avec une classe ou ce genre de choses hein si vous voulez faire par exemple sur un morceau de texte on utilise la balise span avec une classe comme attribut et ont défini en css le sélecteur de classe avec une mise en forme dessus tout simplement.
```html
<p>Un texte aligné par défaut à gauche</p>
<center>Un texte centré</center>
```
On ne se sert plus de cette balise center mais text-align="center" dans style.css

## \<ul\> & \<li\> remplace \<dir\>

On avait également à l'époque on pouvait par exemple définir un ensemble de fichiers d'accord donc plus ou moins un répertoire en fait représenter une liste de documents et on utilisait la fameuse balise dir d'accord pour directory tout simplement là pareil si vous voulez lister un ensemble de choses que ce soit des documents, des éléments et bien vous utilisez bien évidemment les balises de liste, vous utilisez ul et à l'intérieur comme ça vous mettez vos différents éléments d'accord ça peut être mon fichier 1, ça peut être fichiers 2 et cetera.

```html
<ul class="repertoireTruc">
	<li>fichier 1</li>
	<li>fichier 2</li>
</ul>
```

Après si vous voulez préciser que c'est un répertoire d'un environnement ou d'un système d'exploitation vous pouvez très bien définir une classe, un identifiant dire par exemple "repertoireTruc", vous mettez ce que vous voulez et vous allez pouvoir travailler là dessus aussi également avec de la mise en page en css et donc vous pouvez largement remplacer l'utilisation de la balise dir par une balise ul tout simplement c'est vraiment simple.

## \<iframe\> ou \<object\> remplace \<frame\> et \<frameset\>

Les balises frame et frameset alors frameset c'était juste pour faire un ensemble de frame ou simplement pour mettre plusieurs contenus à l'intérieur. A quoi servait cette balise frame ? ça permettait d'afficher un autre document html càd qu'à l'intérieur de votre document html ici vous pouvez en afficher une autre, par exemple si je m'étais frame avec comme source le site de google ou le site n'importe lequel en fait ça m'aurait affiché une espèce de sous-fenêtre à intérieur avec un autre site dans ma page donc ça évidemment on oublie tout ça d'accord on ne l'utilise plus maintenant il y a la balise iframe d'accord qui permet de le faire par exemple quand vous exportez je sais pas moi une vidéo youtube, une vidéo twitch ou d'autre site de vidéos ou autres que vous voulez intégrer sur vos pages web eh bien vous avez qu'à regarder soit c'est une balise object comme je vous ai parlé tout à l'heure, qui est une balise générique de contenu ou alors ça utilise une iframe tout simplement pour pouvoir intégrer en fait un lecteur dans un fichier html puis des propriétés css ou autre pour intégrer un bouton de lecture ou autre.

```html
<iframe>
```

C'est object ou iframe selon les cas.

## \<hgroup\> dépréciée

Balise expérimentale à peine disponible sur Firefox.

```html
<hgroup>
	<h1>Mon titre</h1>
	<h2>Premier sous-titre</h2>
</hgroup>
```

La balise hgroup est déconseillée.

## \<noscript\> remplace \<noframes\>

noframe c'était pour gérer un affichage de quelque chose quand par exemple le navigateur ne pouvait pas supporter justement les frames, si un navigateur ne supportait pas l'intégration de contenu et bien ici on pouvait mettre par exemple un message pour dire votre navigateur ne supporte pas le contenu ou ce genre de choses.

```html
<noframes>Votre navigateur ne supporte pas le contenu</noframes>
```

Admettons si à un moment je désactive l'utilisation de javascript ou autre choses liées à des médias ou des contenus qui sont intégrés et bien le navigateur m'afficherait ce message.

Maintenant on a simplement remplacé cette balise qui au lieu de s'appeler noframe s'appelle tout simplement noscript.

```html
<iframe>
<noscript>Votre navigateur ne supporte pas le contenu</noscript>
```

Voilà on met le iframe et si ça ne fonctionne pas plutôt qu'un espace blanc on affichera le contenu qu'il y a dans les balises noscript.

noframe c'est complément obsolète au niveau html.

## \<strike\>

```html
<p>Un texte <strike>barré</strike></p>
```
strike permettait de barrer le texte de manière visuel et non sémentique, c'est vraiement de la mise en page donc utiliser line-through=""; en css. Pour la sémentique, pour ce qui n'est plus pertinent utiliser \<s\> ou \<del\> pour remplacer.

## \<code\> remplace \<tt\>

Pour tout ce qui était minitel, ancètre des écrans de pc, on pouvais présenter l'affichage précis de ce genre de chose avec une balise dites pour les téléscripteurs qui est balise tt.

```html
<p>Un texte normal</p>
<tt>Un texte pour téléscripteur</tt>
```
Maintenant si vous avez suivi le cours vous savez qu'il y a une balise pour ça donc utiliser tout simplement la balise code qui fonctionnera pour tout les navigateurs.

```html
<code>Un texte pour téléscripteur</code>
```

## \<code\> ou \<pre\> remplace \<xmp\>

xmp permet de ne pas interprêter les tags, les balises html à l'intérieur
```html
<p>C'est un paragraphe</p>
<xmp><p>C'est un paragraphe</p></xmp>
```
mais maintenant utiliser la balise code ou pre si on veux faire un texte pré-formarté 
```html
<code\>&lt;p&gt;C'est un paragraphe&lt;/p&gt;</code>
```
Attention comme ici on a un caractère spéciale, il ne faut pas oublié de transformer ça en entité html avec &lt; pour lower than et &gt; pour greater than ou alors on utilise la balise pre qui permet de pré-formater du texte.

## \<u\>
Ne plus utiliser ce balise de style mais text-decoration="" sur un sélecteur de class
```html
<u>Un texte souligné</u>
```