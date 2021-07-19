# [Tutoriel HTML/CSS - attributs universels](https://www.youtube.com/watch?v=TZwvw5niU7Q)

## class

* 2 cas d'utilisation : 
	- En javascript avec la fonction getElementsByClassName().
	- En css avec les sélecteurs.
* attribut qui peut contenir plusieurs noms de class séparés par des espaces :
	class="nom1 nom2 nom3"
	p.e. une classe pour gérer l'alignement, une classe pour la couleur, etc.
* réutilisation du même nom de classe dans un ou plusieurs fichiers
* sélecteur css de classe : 
```css
.nomClasse
```

## id

* utilisation unique
* utilisation :
	- dans une ancre.
```html
<a href="#ancre">Aller à mon ancre</a>

<h1 id="ancre">Mon titre</h1>

<a href="#ancre">Revenir en haut</a>
```
	- dans un lien : index.html#ancre
* sélecteur css d'id : 
```css
#nomId
```
* fonction javascript : getElementById()

## title

* création d'une infobulle
```html
<p title="Tu as ton curseur sur le paragraphe">je suis un paragraphe.</p>
```

## style

* attribut 'style' pour les tests en développement html-css mais attention ce n'est pas propre de le faire sur un site en ligne.
```html
<p style="color:blue;">je suis un pragraphe</p>
```

## tabindex

* Accèder aux éléments par la tabulation, pratique pour les formulaires.
* Par défaut, c'est "0".
```html
<p tabindex="0">je suis un pragraphe</p>
```
* Ordonner les tabulations
```html
<p tabindex="0">1er tab.</p>
<p tabindex="101">4e tab.</p>
<p tabindex="100">3e tab.</p>
<p tabindex="1">2e tab.</p>
```

## lang
```html
<p lang="fr">Bonjour à tous !</p>
<p lang="en">Hello World!</p>
```

## accesskey

Ne pas utiliser.
```html
<p accesskey="">Ceci est un texte dans un paragraphe</p>
```

## contenteditable

Editer un contenu, pratique pour les formulaires.
```html
<p contenteditable="true">Ceci est un texte dans un paragraphe</p>
```

## dir

dir="auto"|"ltr"|"rtl"
```html
<p dir="ltr">Ceci est un texte dans un paragraphe</p>
```

## hidden

Masquer un élément qui n'est plus pertinent sur ma page html mais continue d'exister dans le code source.
```html
<p hidden="true">Ceci est un texte dans un paragraphe</p>
```

## data-???????

Créer ses attributs à utiliser et récupérer avec Javascript pour afficher des légendes ou des informations complémentaires pour une image, un paragraphe, un texte ou je ne sais quoi.
```html
<p><img data-location="Paris" data-appareil="Nikon D500" src="http://lien.com/image.jpg" alt="Climats de France"></p>
```
Autre exemple pour donner les informations de contact donc <address> puis dedans vous mettez data-facebook="" puis vous mettez le lien de votre facebook mais attention comme il y a des système qui analyse ce genre d'informations 'data', il peut y avoir des noms déjà utiliser donc il y a de forte chance que des systèmes utilisent déjà ce nom là mais pour avoir un nom libre utilisez par exemple le nom de votre site '-monsite-' puis le nom de votre donnée sur lequel vous allez pouvoir travailler dessus avec un langage comme JavaScript.
```html
<address data-monsite-facebook="">
</address>
```

## draggable

Pratique avec javascript pour glisser-deposer
```html
<img draggable="true" src="img.png">
```
Avec Javascript ça fait qu'en affichant votre image, vous pourrez cliquez dessus, resté appuyer avec votre souris et déplacer votre image dans un autre contenu dans vos pages web mais évidemment ça se fait avec du Javascript.


<!--

Ne pas s'en servir :

	contextmenu (uniquement sur Firefox) permet de faire un identifiant pour la balise <menu>
	
Attributs expérimentales :

	itemid, 
	itemscope, 
	itemprop, 
	itemtype, 
	itemref 

	slot, 
	spellcheck, 
	translate, 
	dropzone (définir une zone de glisser-déposer)
-->
