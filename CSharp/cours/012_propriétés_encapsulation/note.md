# [12. Propriétés d'encapsulation](https://www.youtube.com/watch?v=NgSBm1mIRZE)


Dans cette 12e séance en CSharp, nous allons parler des propriétés.

Nous avions vu dans les séances précédentes qu'avec la création de classe, vous pouvez avoir des méthodes des attributs et cetera.

Les propriétés c'est tout simplement une manière qui va nous donner l'accès aux membres privés de notre classe donc on va parler d’accesseurs que ce soit pour leur lecture ou leur modification.

C'est une manière également d'établir des règles pour la lecture et la modification par exemple en interdisant la modification d'une donnée privée et ainsi on peut définir les règles d'accès pour la lecture d'un nombre privé par exemple.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
```

Alors pour le moment nous n'avons pas encore abordé les espaces de noms et donc si vous voulez faire votre classe dans un autre fichier ce sera sans problème mais on verra ce concept par la suite et pour simplifier nous allons créer notre classe dans l'espace de noms et dans le même fichier mais faites comme vous voulez.

Admettons une classe pour représenter une fenêtre graphique par exemple pour faire une application avec une bibliothèque d'interface en 2D donc une interface graphique avec par exemple des widgets et cetera.

Ici nous n'allons pas créer de constructeur.

Nous allons commencer par créer un élément privé pour contenir le titre de notre fenêtre et on va donc choisir le niveau d'accès `private`, le type `string` que l'on nomme `Title`.

On va faire finallement un constructeur par rapport à cette exemple.

```cs
public Window(string title) => this.Title = title;
```

C'est maintenant on essaie d'accéder aux différents éléments c'est à dire d'afficher le titre, on va tenter de faire ça à partir de l'objet parce que c'est comme ça qu'on accède aux différents éléments et donc on va essayer la lecture c'est à dire l'accès à l’attribut Title.

On indique qu'on affecte à `Title` la valeur du paramètre `title` avec un corps d'expression.

On a vu les corps d'expression précédemment, qui permet d'avoir une méthode sur une seule ligne (inline) que l'on retrouve aussi dans d'autres langages de programmation.

Ensuite nous allons pouvoir créer une nouvelle instance depuis notre classe Main Et comme je n'ai qu'un constructeur qui attend un titre sous forme de chaîne de caractères, je vais indiquer « Ma fenetre » pour avoir un secret notre instance.

```cs
using System;

namespace App
{
    class Window
    {
        private string Title;

        public Window(string title) => this.Title = title;
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window("Ma fenetre");
            Console.WriteLine(win.Title);
        }
    }
}
```
```powershell
> dotnet run
Base.cs(17,35): error CS0122: 'Window.Title' est inaccessible en raison de son niveau de protection [C:\.\CSharp\cours\FirstApp\FirstApp.csproj]

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

On compile et on exécute et là on nous indique simplement que `Window.Title` est simplement inaccessible en raison de son niveau de protection c'est-à-dire le niveau d'accès que nous avons défini ici pour l'attribut Title `private string Title`.

Pour autant il serait mal pensé de se dire qu'il faut mettre le niveau d'accès à public `public string Title;` Et ainsi l'élément devient public partout que ce soit au niveau de la classe, et même depuis l'extérieur dans d'autres espaces de noms, dans d'autres assembling (que l'on verra plus tard) bref partout. `public` est ouvert partout et on peut s'amuser à faire n'importe quoi et donc ici si je relance l'exécution pourra parfaitement afficher le titre.

```cs
using System;

namespace App
{
    class Window
    {
        public string Title;

        public Window(string title) => this.Title = title;
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window("Ma fenetre");
            Console.WriteLine(win.Title);
        }
    }
}
```
```powershell
> dotnet run
Ma fenetre
```

Le public c'est vraiment accéder à tout et si on recompile ici il n'y a plus de problème mais là où ça pose un problème c'est par rapport au principe d’encapsulation.

Il n'y a pas que ça pour l’encapsulation car ce principe regroupe tout un tas de règles et de procédés.

Alors on part du principe que cette classe Window possède des informations qui lui sont propres, et on peut avoir la raison de ne pas révéler des données depuis l'extérieur d'accord c'est à dire que les données sont propres à la classe elle-même comment peu d'efforts également masquer des données ou des méthodes qui pourrait être utilisé par d'autres méthodes où accéder par d'autres propriétés au sein de la classe.

## Usage de propriétés

Peu importe la raison, on a nécessité de garder les choses ici de manière homogène c'est à dire que la classe Window et elle ne veut pas donner accès à tout et à n'importe quoi donc on ne va pas s'amuser à modifier cet élément `private string Title;`.

C'est là que les propriétés entrent en jeu c'est à dire qu'ici entre guillemets nous avons un simple attribut mais nous on va en faire une propriété.

Déjà par convention, on va le marquer avec un underscore `_title` et tout en minuscule avec une écriture en camelCase.

```cs
private string _title;
```

Notre attribut un privé c'est à dire que dans la classe Program, je ne peux ni accéder à cette propriété Et encore moins la modifier.

Maintenant je vais créer une propriété qui va être publique `public`. Ont choisi également le même type `string` pour que ce soit cohérent et on va lui choisir un nom cette fois-ci avec une majuscule au début par exemple on peut mettre le même nom que notre attribut mais on peut également choisir autre chose mais voilà encore une fois ça peut être une manière de masquer si admettons la méthode porte un autre nom que notre attribut, par exemple `Name` au lieu de `Title`.

```cs
private string _title;
public string Title
{
    // init
    // get
    // set
}
```

Notre attribut Title est une propriété (C'est plus qu'un simple attribut) et on va essayer de définir ses niveaux d'accès en tout cas plutôt ces procédés d'accès c'est à dire les fameux fils pour le contrôle. Le premier c'est l'accesseur pour la lecture que l'on appelle communément `get` et le 2e pour la modification c’est `set` et vous verrez par moment un 3e qui est `init` lors de l'initialisation de l'objet donc au moment où on fait notre instance c'est à dire à ce moment-là `new Window("Ma fenetre");`.

On voit beaucoup plus rarement `init` et si c'est pour avoir la même chose dans `init` ce que l'on retrouve dans le `set` alors ça n'a pas d'intérêt.

```cs
private string _title;
public string Title
{
    get
    {
        return _title;
    }
    set
    {
        _title = value;
    }
}
```

Pour le `get`, la manière la plus simple pour dire qu'on veut accéder à l'élément c'est de retourner directement l’attribut `_title` donc on parle bien de l'élément privé `private string _title` donc en accédant à Title (Notre propriété avec la majuscule), on accède en fait à la référence de l'élément privé `_title` sachant que même si l'élément est privé, notre classe Window a le droit d'y accéder.

Pour le `set`, la manière la plus commune c'est simplement la modification de la valeur `_title = value ;` où on utilise le mot clé `value` tout simplement ce qui permet de dire Que si on cherche à modifier `_title` en passant par l'opérateur d'affectation automatiquement il va comprendre que c'est une opération de modification qui est faite et donc on passera par ce bloc de code `set{ }` pour modifier par notre valeur à nous `value` la valeur de l'attribut.

On teste.

```cs
using System;

namespace App
{
    class Window
    {
        //public string Title;
        private string _title;
        public string Title
        {
            get
            {
                return _title;
            }
            set
            {
                _title = value;
            }
        }

        public Window(string title) => this.Title = title;
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window("Ma fenetre");
            Console.WriteLine(win.Title);
        }
    }
}
```
```powershell
> dotnet run
Ma fenetre
```

Si je tente de faire `Console.WriteLine(win._title);`, on revient au problème de tout à l'heure ce qui est logique par rapport au niveau d'accès, de protection.

Voilà nous devons donc passer par la propriété.

Admettons encore une fois qu'un développeur qui utiliserait nos classes à nous, n'aurait pas de visibilité sur le code source.

Noté qu'on pourrais retourner autre chose comme c'est de la programmation.

```cs
get
{
    return "[" + _title + "]";
}
```

Où même utiliser le symbole de formatage `$`, notre interpolation.

```cs
get
{
    return $"[{_title}]";
}
```

Maintenant si on veut modifier, on passe par la propriété au lieu de l'attribut. Si j'essaye de faire `win._title = ""` ça ne marchera pas.

```cs
using System;

namespace App
{
    class Window
    {
        //public string Title;
        private string _title;
        public string Title
        {
            get
            {
                return _title;
            }
            set
            {
                _title = value;
            }
        }

        public Window(string title) => this.Title = title;
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window("Ma fenetre");
            Console.WriteLine(win.Title);

            win.Title = "Nouveau nom";
            Console.WriteLine(win.Title);
        }
    }
}
```
```powershell
> dotnet run
Ma fenetre
Nouveau nom
```

On teste et ça change.

Voilà notre propriété Title définis les règles d'accès et de modifications.

C'est l'exemple le plus simple mais on pourrais choisir comment filtrer ces informations et par exemple ici `get{}`, on pourrais déclencher une exception (on vera ça plus tard dans une vidéo dédiée) et ne pas autoriser l'accès à la lecture de la propriété.

On peut également faire l'inverse interdire la modification (ce qui est un peu plus cohérent et que l'on voit un peu plus souvent) pour obtenir une donnée qui est dite immuable c'est à dire qu'il ne peut pas changer de valeur une fois qu'elle a été créée. Par exemple on pourrait rendre le `set` privé, on pourrait en faire un élément privé et ce qu'il fait que ce ne serait pas autorisé de le modifier.

On pourrait également déclencher une exception dans `set` pour dire qu'on n'autorise pas la modification ou alors indiquait manuellement pour dire qu'on n’autorise pas à ça.

Comme c'est une portion de code, on pourrais vérifier la taille d'une chaîne de caractères (on vera plus tard comment calculer la taille d'une chaîne).

```cs
set
{
    if()
    _title = value;
}
```

## Réduire en corps d expression

On peut réduire ces méthodes de propriété pour économiser quelques lignes.

```cs
public string Title
{
    get => _title;
    set => _title = value;
}
```

Voilà tous les concepts fait précédemment sont applicables encore ici.

Voilà pour cette possibilité.

## Réduire la propriété en une ligne

Alors on peut faire encore beaucoup plus court sachant qu'ici on est sur un cas particulier c'est à dire qu'on ne fait rien d'autre que le comportement par défaut c'est à dire que lors d'un accès en lecture on renvoie l’attribut (sa valeur) et lors d'une modification modifie directement l’attribut donc on ne fait rien de particulier et on n'a pas de conditions, on ne fait pas de vérification ou quoi que ce soit.

Pareil si on ne veut pas s'amuser à faire toutes ces modifications, ici avec notre attribut `private string _title;` Eh bien on peut gérer ça par défaut c'est à dire avoir une complétion automatique si vous voulez au niveau du langage et donc si j'ai ce type d'opération à faire je peux donc encore aller plus vite.

Je crée ainsi simplement une propriété `public string Title;` C'est à dire qu'il n'y aura plus l’attribut privé car quand Tony pense ça n'a pas de sens et sur une seule ligne je vais écrire ceci.

```cs
public string Title { get; set; }
```

On a donc juste notre attribut `public` et comment ne fait rien d'autre, on met simplement `get` et `set` suivi d'un ;

Ainsi CSharp complèteras les propriétés set et get pour la lecture et la modification.

Voilà pour ce raccourcis.

On peut se permettre de n'avoir que de la lecture.

```cs
public string Title { get; }
```

On peut mettre en privé et cetera et contrôler les niveaux d'accès.

```cs
public string Title { get; private set; }
```

## Valeur par défaut 

Si on veux une valeur par défaut pour le titre.

```cs
class Window
{
    public string Title { get; set; } = "Nouvelle fenetre";
}
```

On teste.

```cs
using System;

namespace App
{
    class Window
    {
        public string Title { get; set; } = "Nouvelle fenetre";
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window();
            Console.WriteLine(win.Title);

            win.Title = "Nouveau nom";
            Console.WriteLine(win.Title);
        }
    }
}
```
```powershell
> dotnet run
Nouvelle fenetre
Nouveau nom
```

Voilà on peut vraiment raccourcir le code.

Attention partez du principe que tout doit être privé et qu'on donne l'accès au cas par cas. On dira ainsi que c'est la classe Window qui peut modifier seul le titre de la fenêtre.

Après si on se dit que éventuellement on peut modifier le titre, et qu'on se dit qu'on voudrait modifier le titre dans une autre classe, On dira qu'on leur donnera d'abord l'accès en lecture `get` et après Éventuellement si on veut permettre la modification du titre depuis l'extérieur, on peut le faire mais ne partez pas du principe qu'il faut permettre la modification du titre donc ne partez pas du principe qu'il faut écrire les accesseurs pour chacun des que je veux un attribut pour ma classe.

Ainsi on écrira du code en fonction des besoins qu'on peut avoir, récupérer le titre, une taille et cetera.

```cs
class Window
{
    public string Title { get; set; } = "Nouvelle fenetre";
    public string Width { get; set; };
}
```

Voilà on écrira pas les choses par défaut au cas où mais on écrira du code en fonction des besoins pour l'exécution de notre programme.

Á bientôt pour les prochaines séances