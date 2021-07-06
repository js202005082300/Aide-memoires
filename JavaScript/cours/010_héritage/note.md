# [10. Héritage](https://www.youtube.com/watch?v=2BoeW9J-Hso)

+ index.html
```html
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Cours JavaScript</title>
    <style>
        body{background-color:#111;color:#e2a93f;margin:auto;width:800px;}
        h1{color:#af8943;text-align:center;}
    </style>
</head>
<body>
    <h1>JavaScript #10 - Héritage</h1>
    <script src="main.js"></script>
</body>
</html>
```
+ main.js
```js

```

## Rappel

Rappel sur la manière de définir des entités, des objets.

En JavaScript, nous avons des objets, par exemple une fonction est un objet. Même si on a abordé la programmaion orienté objet plutard dans le cours, en réalité on de l'objet partout.

Le concept de classe et d'instance en Java, C++, CSharp, PHP diffèrent beaucoup du JavaScript d'où le fait que cette séance est très importante pour ce langage et qui fait l'incompréhension des développeurs JavaScript avec toutes les évolutions qu'il a connus ces dernières années.

## Déclaration littérale

On a parlé de pas mal d'objet mais maintenant on va commencer par définir des entités avec pas mal de méthodes.

On va aborder une 1e méthode sur la manière de définir une entité, une information par exemple, on va travailler avec des Ninjas et donc on a une première méthode très simple qui est l'**écriture litérale**.

Littérale c'est un terme que l'on a déjà employé par exemple quand on parle d'information en dur.

Admettons que je fasse ceci `let data = 14;` avec le 14 qui est une valeur littérale, une valeur brute c'est à dire qu'on l'indique directement dans le code. Ce n'est pas quelque chose de dynamique que l'on demande à l'utilisateur, ce n'est pas une affectation d'une autre variable et cetera mais c'est une valeur littérale, une valeur en brut.

Alors on va essayer d'être le plus clair possible dans le vocabulaire utilisé et on va donc essayer de faire une déclaration littérale de ce que l'on appellerait dans un autre langage de programmation une classe.

Admettons on va créer un naruto (qui est un Ninja) et on va lui indiquer tout un tas de valeurs donc les valeurs vont être écrites littéralement, elles seront inscrites en dur dans le code.

```js
let naruto = 
{
    attack: function() { return "Rasengan"; },
    name: "Naruto Uzumaki",
    weapon: "Kunai"
};
```

Voilà on a une attaque qui est un objet, un name et cetera.

Voilà ça permet un peu comme la solution ternaire qui permet ainsi de fonctionner soit dans un cas soit dans un autre en fonction du test qu'on a fait sur une condition de dire par exemple qu'ici on appliquerait une valeur ou en dur mais on verra ça peut être plus tard.

Donc tout ceci est une déclaration via une écriture littérale Dan Ninja qui est ici Naruto.

Si je veux faire un autre Ninja, il faudrait refaire un peu la même chose, il faudrait l'appeler autrement puis d'autres informations pour la cohérence..

```js
let naruto = 
{
    attack: function() { return "Rasengan"; },
    name: "Naruto Uzumaki",
    weapon: "Kunai"
};

let naruto2 = 
{
    attack: function() { return "Rasengan"; },
    name: "Naruto Uzumaki",
    weapon: "Kunai"
};
```

On peut essayer d'afficher.

```js
let naruto = 
{
    attack: function() { return "Rasengan"; },
    name: "Naruto Uzumaki",
    weapon: "Kunai"
};

document.write("<h2>");
document.write(naruto.attack());
```

Voilà ça on ne l'avait pas forcément vu précédemment mais au moins c'est bien de le savoir parce que ça existe déjà depuis pas mal de temps alors que le mot clé `let` c'est quelque chose qui n'est pas si vieux que ça donc on l'a introduit ici et on peut directement afficher l'élément que ce soit name ou attack().

Voilà pour la déclaration littérale.

## Déclarer un objet

Maintenant on va faire la déclaration d'un objet sachant que je n'avais pas été très loin dans les explications et dans les définitions mais je vous avais dit qu'une fonction c'est un objet donc on va se servir d'une fonction comme un constructeur d'objets.

Ainsi jusqu'ici on avait une écriture littérale pour créer un Naruto mais je ne pourrai pas m'en servir par exemple pour créer dynamiquement autre chose c'est à dire qu'il aurait fallu répéter ce bloc Naruto et changer les informations.

Maintenant je vais créer une fonction Ninja avec un N majuscule pour dire que c'est une fonction particulière, un peu le formalisme qu'on aurait sur d'autres langages de programmation pour une classe même si ici ce n'est pas vraiment une classe.

```js
function Ninja(name, weapon)
{

}
```

Voilà on indique les différents paramètres comme ça on a du coup quelque chose de dynamique, on utilise la variable this.

Là je vais vous montrer une petite nouveauté syntaxique, vous affectez à `this.name =` 2 cas possible mais il ne faut pas que la première valeur référencée `name` soit égal à false voilà il ne faut pas mettre ce genre de choses `this.name = false;` mais ça va nous permettre simplement de dire que si on a renseigné l'attribut name c'est à dire qu'il peut être égal à true et c'est ce qu'on affectera comme valeur à notre attribut.

```js
this.name = name;
```

Sinon on va utiliser un opérateur || (ou) et dans un autre cas on lui affectera une valeur par défaut donc par exemple si on n'indique pas l'information name, le nom sera Naruto Uzumaki.

```js
function Ninja(name, weapon)
{
    this.attack = function()
    {
        return "Rahhhh !!";
    };
    
    this.name = name || "Naruto Uzumaki";
    thus.weapon = weapon || "shurikan";
}
```

Alors c'est important mais ici on n'a pas créer d'objet, ça en est déjà un donc il a sa propre vie et on peut afficher les informations concernant cette variable `naruto` qui est notre objet.

```txt
let naruto = 
{
    attack: function() { return "Rasengan"; },
    name: "Naruto Uzumaki",
    weapon: "Kunai"
};

document.write(naruto.attack());
```

## Créer une instance

Utiliser l'opérateur `new` qui va passer par le constructeur ici.

```js
function Ninja(name, weapon)
{
    this.attack = function()
    {
        return "Rahhhh !!";
    };
    
    this.name = name || "Naruto Uzumaki";
    thus.weapon = weapon || "shurikan";
}

let hinata = new Ninja("Hinata Hyûga");
document.write(hinata.name + "<br>");
document.write(hinata.attack() + "<br>");
```

:warning: dans d'autres langages `new` fait référence à l'appel d'un constructeur de classe mais ici on n'a pas de classe mais on a un objet parce qu'ici notre fonction est un objet et nous permet de créer des objets.

Notre fonction est un objet et nous permet de créer des objets donc ça c'est important l'objet est l'instance.

Ainsi avec la classe, on a des instances de cette classe qui sont des objets mais ici l'objet est une instance donc il n'y a pas de distinction entre les 2.

Il y a vraiment une différence entre cette histoire d'objets `function Ninka()` et ce qu'on avait vu précédemment avec la syntaxe de classe.

13.25