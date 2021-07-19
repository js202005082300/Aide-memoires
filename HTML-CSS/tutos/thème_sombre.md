# [Thème sombre](https://www.youtube.com/watch?v=UmnzAkE6DJQ)
17-02-21

On peut faire un thème sombre en switchant entre fichier css avec une feuille css pour le mode clair et une autre pour le mode sombre. L'utilisateur pourrait switcher de mode avec des outils css ou des outils javascript.

Une autre solution, un peu plus moderne, c'est d'adapter le mode en fonction du mode choisit sur le navigateur ou le système, sombre ou clair.

Prenons un thème par défaut si l'utilisateur n'a pas défini de jeux de couleur particulier au niveau de son navigateur.
```html
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>MonIncroyableSiteWeb</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<h1>Hello World !</h1>

	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed, blanditiis, distinctio, dicta iusto cum possimus ut id nulla quo facere dolores magnam ullam nihil veritatis impedit mollitia saepe. Nobis, voluptates.</p>
</body>
</html>
```
```css
body
{
	background-color:#CCC;
	margin:auto;
	width:800px;
}
```
On commence par appliquer un variable à la racine.
```css
:root
{
	--body-background-color:#CCC;
}

body
{
	background-color:var(--body-background-color);
	margin:auto;
	width:800px;
}
```
Comment proposer une couleur pour le mode sombre ?

Alors on commence  par utiliser un média qu'on a vu lorsqu'on a fait de la résolution adaptative, et on va utiliser une propriété qui est 'prefers-color-scheme' qui va nous permettre d'indiquer le comportement à adopter dans le cas où notre navigateur voir le système d'exploitation a basculer sur un mode d'apparence précis.

Comme je suis en mode clair, le mode sombre ce serra le mode dark et c'est celui que je veux pouvoir indiquer.
```css
:root
{
	--body-background-color:#CCC;
}

@media(prefers-color-scheme:dark)

body
{
	background-color:var(--body-background-color);
	margin:auto;
	width:800px;
}
```
Vous pouvez parfaitement inverser en mettant "light" plutôt que "dark" mais alors il faut configurer un mode sombre dans :root.

Ensuite on dit que si on configure un mode sombre, je veux pouvoir changer la couleur de fond. Je ne veux plus du #CCC mais une couleur plutôt sombre #111.
```css
:root
{
	--body-background-color:#CCC;
	--body-text-color:#000;
}

@media(prefers-color-scheme:dark)
{
	:root
	{
		--body-background-color:#222;
		--body-text-color:#EEE;
	}
}

body
{
	background-color:var(--body-background-color);
	color:var(--body-text-color);
	margin:auto;
	width:800px;
}
```
Voilà comme je travaille sur des variables pour le body ça va s'adapter en fonction du mode de couleur sombre ou clair du système ou du navigateur.

**Attention encore une fois le navigateur utilise déjà un thème sombre et un thème clair, c'est là-dessus que va fonctionner votre fichier css sinon il se basera simplement sur la confirguration de votre système.**

Voilà vous pouvez via ce système très très simple adapter votre design. Vous indiquez des informations qui vont varier dynamiquement généralement les couleurs d'un thème clair à sombre ici dans le sélecteur :root, et ensuite via l'instruction @media vous pouvez changer ces valeurs ça peut être des couleurs, des filtres. Vous pouvez utiliser la propriété filter si on veux faire des changements.

	:root
	{
		--body-background-color:#222;
		--body-text-color:#EEE;
		filter...
	}

Voilà ça reste du css donc on utilise la propriété que l'on veut.

Par ailleurs, on peut choisir le thème sombre par défaut.
```css
:root
{
	--body-background-color:#222;
	--body-text-color:#EEE;
}

@media(prefers-color-scheme:dark)
{
	:root
	{
		--body-background-color:#CCC;
		--body-text-color:#000;
	}
}

body
{
	background-color:var(--body-background-color);
	color:var(--body-text-color);
	margin:auto;
	width:800px;
}
```

Voilà enfin en fonction de ce qui est défini ça va appliquer le bon thème à notre système. Et encore une fois on se passe de Javascript, c'est aussi le but je l'avait indiquer dans le cours html css avec css et ses évolutions futures est fait justement pour remplacer javascript pour tout ce qui est bien sûr mise en page, mise en forme. 

Le but c'est qu'il n'y ait plus besoin d'utiliser du javascript pour faire de la modification coté client sur nos sites web, nos design, et cetera.

De plus en plus, css propose des outils pour faire cela.

Voilà assurer vous avoir un navigateur à vous parce que c'est quelque chose qui va venir de plus en plus.

Ensuite si un navigateur ne prend pas en charge cette propriété 'prefers-color-scheme' ce n'est pas grave parce qu'il appliquera votre configuration par défaut. 

	@media(prefers-color-scheme:dark)
	{}

Choissisez donc le mode que vous voulez afficher pour tout le monde que ce soit en clair ou en sombre et voilà en fonction de la configuration du thème définie sur l'os voir le navigateur, ça adaptera dynamiquement le design de votre site sans avoir besoin de créer plusieurs fichiers css et ainsi vous avez juste à modifier les filtres et les couleurs depuis le même fichier donc c'est beaucoup plus pratique.