# [13. Héritage](https://www.youtube.com/watch?v=8-GMvozd1dE)

On y va, un constructeur et un attribut avec la valeur par défaut `"Widget"`.

```cs
using System;

namespace App
{
    class Widget
    {
        public string Title { get; set; } = "Widget";

        public Widget(string title) => this.Title = title;
    }

    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
```

La notion d'héritage c'est un petit peu comme dans la vraie vie. Ainsi l'héritage est assez simple à définir et à expliquer quand on parle d'héritage entre les parents et les grands-parents.

En programmation, l'héritage va consister en la relation entre 2 classes. Il peut bien sûr y en avoir plusieurs mais nous on va parler ici de classe parce que c'est une relation d'une classe à une autre qui peut être relié par héritage.

On crée une instance sachant que si j'accède à la propriété, cela fonctionnera, grâce à cette propriété `Title` qui est définie et public. C'est ce que nous avons vu précédement.

```cs
using System;

namespace App
{
    class Widget
    {
        public string Title { get; set; } = "Widget";

        public Widget(string title) => this.Title = title;
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
        }
    }
}
```

On a une classe `Widget` qui représente quelque chose c'est-à-dire une interface graphique, une fenêtre, avec tout ce qu'on mettra par la suite si on veut la développer. Et maintenant nous allons créer une classe d'héritage.

Ainsi un Widget c'est un élément qu'on peut avoir dans une interface graphique, par exemple une fenêtre dont il peut faire partie, ça peut être un bouton, un menu déroulant, une barre de défilement, bref on court en tableau dont on peut avoir plein d'éléments comme ça.

Là nous venons de définir une classe qui va représenter un widget mais sachant qu'ici on n'a pas encore parlé d'éléments abstraits, d'éléments global ou encore de polymorphisme donc c'est des choses dont on verra par la suite mais ici on considère qu'on a widgets qui est quelque chose d'assez générique mais maintenant j'aimerais pouvoir dériver cette classe et créer un widget un peu plus spécialisé donc créer une classe qui est dérivée de widgets et qui va spécifier un peu plus les choses c'est à dire je veux un widget qui sera un peu plus complet que celui qu'on a déjà parce que pour l'instant on a juste un titre et c'est terminé.

Admettons maintenant je veux créer un élément qui sera une classe pour représenter un bouton `Button`.

```cs
using System;

namespace App
{
    class Widget
    {
        public string Title { get; set; } = "Widget";

        public Widget(string title) => this.Title = title;
    }

    class Button
    {
        public string Title { get; set; } = "Bouton";
        public int Color { get; set; } = 0;

        public Button(string title, int color)
        {
            this.Title = title;
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
        }
    }
}
```

Voilà pour notre classe `Button` mais sachez qu'on ne va pas s'amuser à faire des Attributs privés, ou des éléments accessibles qu'en lecture seule, mais on va prendre le cas le plus simple possible. Ainsi notre bouton il a 2 éléments publics soit un titre et un code couleur dont une valeur fictive `0` Qui est notre code couleur et qui représente la couleur du widget.

Admettons par exemple qu'on pourra choisir également la couleur en plus du titre `public Button(string title, int color) {}`.

Voilà ce que nous aurions dans un cas classique, à ce stade de la formation et on aurait pu le faire si on nous l'avait demandé en tant que exercice ou en définit une classe Button qui a un attribut de couleur en plus que notre classe Widget et maintenant nous allons vouloir créer une relation avec ça.

Voilà la différence par rapport au widget c'est que le bouton a une couleur.

Forcément comme le bouton est un widget on va retrouver des éléments similaires, par exemple le titre est quelque chose que nous avons copié collé et qu'on retrouve dans les 2 cas `public string Title { get ; set ;  }`.

Important le bouton est une sorte de widget, c’est un widget donc lorsqu'on en parle on comprend qu'il y a une relation naturelle qui se fait ainsi quand on est capable de faire une relation naturelle entre 2 classes, c'est qu'il y a moyen de créer une relation d'héritage entre les 2.

Comme Button est une sorte de Widget c'est à dire que c'est une classe qui étend, qui dérive d’un widget, qui est plus spécialisé c'est à dire qu'elle a plus de choses et finalement elle hérite de tout ce qui a déjà un widget c'est à dire qu'elle a un titre.

Maintenant pour créer cette relation d'héritage nous allons utiliser le caractère ` :` et on va écrire de quoi dérive, de quoi héritent cette classe `Button` et on va dire qu'elle est vide `Widget`

```cs
class Button : Widget
{
    // ...
}
```

À partir de là tout va changer, on n'a plus besoin de mettre `public string Title { get ; set ; }` parce qu'il y a une transmission des données c'est à dire que Button est une classe dérivée Eh bien elle récupère par héritage tout ce que possède l'autre classe à l'exception du constructeur bien sûr `public Widget(string title) => this.Title = title;` Et comme on verra dans d'autres cas les finaliseurs Qui est le terme employé en CSharp pour parler des destructeurs donc c'est l'inverse des constructeurs.

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color)
        {
            this.Title = title;
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
        }
    }
}
```

`Button` est l’enfant de cette classe `Widget` par cette notation particulière `Button : Widget`.

Button a des éléments supplémentaires parce que le widget en lui-même n'a pas de couleur donc je peux ajouter de nouveaux éléments donc là c'est normal que je fasse une propriété pour Button ainsi ici on aura une différence au niveau du constructeur.

```cs
public Button(string title, int color)
{
    this.Title = title;
    this.Color = color;
}
```

Par cette relation d'héritage, construire un bouton ça revient à créer un widget donc comment allons-nous pouvoir le faire ? On va utiliser un nouvel opérateur et on va enlever le titre `this.Title = title;` puisque Button n'a pas de propriété Title en elle-même car elle en hérite de la classe widget donc on a cet opérateur qui s'appelle Base() qui veut dire la base en fait et on a tendance à le mettre à droite du constructeur et on a dit qu'un petit peu ce qui va être récupéré c'est à dire title.

```cs
public Button(string title, int color) : base(title)
{
    this.Color = color;
}
```

base() fait référence au constructeur parent et comme il prend en paramètre un titre.

Voilà notre classe Button Ah bien la propriété title que possèdera en fait le bouton et ensuite lui-même il a sa propre propriété, d'ailleurs je peux aussi parfaitement faire ça ça fonctionnera aussi `=> this.Color` mais ça risque de devenir moi allez-y parce qu'il y a beaucoup plus d'éléments mais bien sur le corps d'expression est autorisé comme notation.

```cs
public Button(string title, int color) : base(title) => this.Color = color;
```

On pourrais l'écrire comme ça et on y va.

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
        }
    }
}
```
```powershell
> dotnet run
Programme en C#
OK
15
```

Voilà comment se fait l'héritage.

L'héritage fonctionne pour les classes mais ça ne fonctionnera pas pour les structures, voilà ce qui différencie les 2.

La classe enfant c'est à dire dérivé de la classe Widget, elle hérite de tout de la classe parente à l'exception des constructeurs et des finisseurs donc voilà pour la base des informations.

## sealed

Il y a la possibilité, une particularité qui permet de arrêter cet héritage c'est à dire d'arrêter la dérivation d'une classe c'est à dire que on considère que Widget était une classe finale d'ailleurs il y a des langages de programmation qui utilisent le mot clé `final` pour représenter ça et ainsi je ne vais pas vouloir autoriser la dérivation c'est à dire la création issue de cette classe donc pour cela on va indiquer que la classe est scellée `sealed` Donc c'est une classe finale qui ne pourra pas être dérivée.

```cs
using System;

namespace App
{
    // Parent
    sealed class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
        }
    }
}
```
```powershell
> dotnet run
Base.cs(13,20): error CS0509: 'Button' : dérivation du type sealed 'Widget' impossible [C:\.\CSharp\cours\FirstApp\FirstApp.csproj]

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

On ne peut pas faire ici un héritage sur cette classe.

il faut en avoir l'utilité c'est pour ce poids on peut retrouver dans des bibliothèques, des classes qui seraient celles et qu'on ne peut pas utiliser.

On verra plus tard pour les classes abstraites `abstract` et que l'on verra bien en détail plus tard dans une autre vidéo.

## virtual et override

Concernant les méthodes, on a une méthode Test().

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Programme en C#
OK
15
Widget OK est fonctionnel.
```

On a une méthode qui appartient à la classe Widget et on appelle une méthode qui lui appartient, et maintenant comme on a dit que le button éritait de tout il devrait avoir accès à Test().

Voilà ça se vérifie aussi pour les méthodes mais le problème c'est que le bouton est plus précis qu'un Widget.

Comme on part sur la même méthode, forcément le bouton qui en hérite, Le bouton va hériter du code tel quel.

Alors ici on va redéfinir la méthode et c'est une option qu'on abordera lorsqu'on fera le polymorphisme mais qu'on ne détaillera pas trop à ce stade.

Ici on va faire pareil c'est à dire qu'on va redéfinir la méthode avec les mêmes paramètres tout mais qui ne fera pas forcément la même chose échanger « Widget » par « Bouton ».

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }

        public void Test()
        {
            Console.WriteLine($"Bouton {this.Title} et de code couleur {this.Color} est fonctionnel.");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Base.cs(27,21): warning CS0108: 'Button.Test()' masque le membre hérité 'Widget.Test()'. Utilisez le mot clé new si le masquage est intentionnel. [C:\.\CSharp\cours\FirstApp\FirstApp.csproj]
Programme en C#
OK
15
Bouton OK et de code couleur 15 est fonctionnel.
```

Alors ici ça nous dit simplement que sa masse que le nombre hérité donc on a ici un avertissement mais on a l'application du bouton qui est faite.

Alors ce que nous allons préciser pour ce langage là c'est qu'une méthode peut être redéfinie et pour ça on va utiliser le mot clé `virtual` pour dire qu'on autorise la dérivation c'est à dire la redéfinition de cette méthode et pour éviter pas mal de problèmes.

Si on veut maintenant redéfinir une méthode on utilisera le terme `override` qui veut dire simplement une autre surcharge et on va tester avec celui-là.

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public virtual void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }

        public override void Test()
        {
            Console.WriteLine($"Bouton {this.Title} et de code couleur {this.Color} est fonctionnel.");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Programme en C#
OK
15
Bouton OK et de code couleur 15 est fonctionnel.
```

Et voilà on a plus d'avertissement par rapport à ça.

Voilà soit notre méthode est effectivement la même pour tous les objets de la classe Widget et de tous les objets de la classe enfant qui dérive donc là pas de problème on peut laisser tel quel monsieur on aimerait pouvoir réécrire, redéfinir cette méthode donc on indique clairement avec le mot-clé `virtual` pour dire que c'est une méthode virtuelle que l'on va pouvoir redéfinir avec le mot-clé `override` et donc éviter pas mal de problèmes en procédant comme ça.

Ainsi ici on part du principe que la méthode `override` ne pourra pas être appeler par la classe mère.

## base

On écrit `btn.base.Test();`.

```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public virtual void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }

        public override void Test()
        {
            base.Test();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Programme en C#
OK
15
Widget OK est fonctionnel.
```

On utilise le fameux mot clé base() et là Voilà ceci `base.Test()` appelle enfaite la classe Test() de la classe parente (base) mais ici c'est juste pour montrer que c'est fonctionnel même si ça n'a pas de sens donc ainsi ici comme on a autorisé avant la classe qui est dérivé, automatiquement on a le mot widget dans les 2 cas.


```cs
// Enfant de Widget
class Button : Widget
{
    public int Color { get; set; } = 0;

    public Button(string title, int color) : base(title)
    {
        this.Color = color;
    }

    public override void Test()
    {
        base.Test();
    }
}
```

Ici ainsi on lui indique le fameux opérateur base() c'est à dire de passer la classe parente qui est juste au-dessus et bien c'est effectivement la méthode Test() de la classe `Widget` qui sera appelée donc tout ça pour dire que quelque part même si on a ce mot-clé `virtual` pour dire qu'on autorise la dérivation Eh bien déjà on n'est pas obligé de le faire.

Sans cette méthode Test(), le compilateur cherchera la méthode dans la classe parente.

*On retire la méthode Test() de chez l'enfant*
```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        public string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public virtual void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Programme en C#
OK
15
Widget OK est fonctionnel.
```

Le compilateur va cherchez une méthode Test() dans la classe dérivée Et comme il ne la trouve pas puisqu'on est dans une relation transitif, une relation de transition entre les différentes classes Eh bien il va chercher au-dessus.

Voilà noter que `virtual` va permettre de dire qu'on veut vraiment modifier la méthode ainsi notez qu'une méthode par défaut, elle n'est pas virtuelle Et ainsi le compilateur ne va pas se dire que c'est une méthode ou une propriété virtuelle parce que c'est évidemment pas le cas par défaut et c'est à nous de l'indiquer pour éviter toute ambiguïté au moment de la compilation.

Ainsi l'héritage qu'on a vu dans cette vidéo est une petite partie, dans la suite des vidéos on parlera 2 concepts qui fonctionnent ensemble qui sont très reliés ensemble donc les interfaces, les classes abstraites, le polymorphisme qui fonctionnent bien ensemble.

Mais ici on reste purement sur de l'héritage même si on est déjà en train de déborder et de parler de surcharge et de redéfinition alors que ça concerne déjà beaucoup le polymorphisme mais ce sont des choses qu'on verra plus tard.

## protected

Le mot clé `protected` permet d'indiquer qu'un élément est accessible chez l'enfant, chez la classe dérivée.

```cs
protected string Title { get; set; } = "Widget";
```
```cs
using System;

namespace App
{
    // Parent
    class Widget
    {
        protected string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public virtual void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }

        public override void Test()
        {
            Console.WriteLine($"Bouton {this.Title} {this.Color} est fonctionnel.");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}
```
```powershell
> dotnet run
Base.cs(38,33): error CS0122: 'Widget.Title' est inaccessible en raison de son niveau de protection [C:\.\CSharp\cours\FirstApp\FirstApp.csproj]
Base.cs(41,35): error CS0122: 'Widget.Title' est inaccessible en raison de son niveau de protection [C:\.\CSharp\cours\FirstApp\FirstApp.csproj]

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

Voilà `widget.Title` est inaccessible en raison de son niveau de protection parce que j'ai défini une propriété title dans la case sujet et en fait on nous dit qu'il n'a pas le droit.

Alors ici on insiste parce que ce n'est pas forcément le k dans tous les langages de programmation avec `protected` c'est à dire qu'ils n'ont pas tous le même comportement.

En CSharp cela signifie que l’élément `Title` est lisible, accessible pour les classes dérivées donc pas pour la classe elle-même qui a défini la propriété :warning: .

C'est important parce que dans d'autres langages on peut avoir `protected` qui est privé non pas à la classe elle-même mais aux classes dérivées, qui héritent donc en CSharp c'est différent car c'est pour dire que en fait que `protected string Title` cède la propriété à la classe qui dérive donc `Button` le texte c'est des sans problème à title mais `widget` ne pourra pas y accéder même si c'est elle qui a défini dans son propre code, dans son bloc de code, dans son contexte la propriété en `protected` auquel elle n'aura pas accès !

voilà je tenais à ce qu'on aborde `protected` parce qu'on a vu `public` et `private` Mais on n'a pas encore vu `internal` qui représente tout ce qui est interne qu'on verra lorsqu'on abordera un autre concept les `assembly` et cetera mais en tout cas `protected` est fortement rattaché à l'héritage est quelque chose qu'on retrouve beaucoup lorsqu'on découvre ce concept.

Pour l'héritage on va s'arrêter là.

On verra le principe de classe abstraite un peu plus tard mais là on va s'arrêter sur de l'héritage simple.

On l'aurait pu également parler si le jour on veut créer un bouton spécial admettons c'est à dire quelque chose qui hériterait de la classe `Button`, on dirait `class SpecialButton : Button {}` ainsi SpecialButton hérite de Button donc elle est dérivée, c'est une classe dérivée et Button elle-même est une classe dérivée de Widget donc en gros on a class C qui hérite de class B et qui hérite de class A donc on aurait la même chose ici.

```cs
class Widget
{}

class Button : Widget
{}

class SpecialButton : Button
{}
```

C'est la même chose ici c'est à dire qu'on a un système transitif comme Button hérite de tout ce que à la classe parente à l'exception des constructeurs et finaliseur et cetera, récupère ces infos mais comme forcément elle en hérite Eh bien elle est riche de tout c'est à dire la propriété Title et Test() seront également hérité par SpecialButton même si elle est déjà 2 niveaux en dessous. Ce n'est pas la classe fi c'est la classe petite fille mais ça fonctionnera.

Cela fonctionnera parce que SpecialButton est relié à Button qui est relié à Widget donc comprenez que ces relations d'héritage crée vraiment des liens donc on peut avoir une classe qui hérite d'une autre qui hérite d'une autre qui hérite d'une autre ainsi la classe qui se trouve tout en bas de l'héritage hérité de la classe qui se trouve tout au-dessus et donc on parle de données transitives parce qu’elles vont transiter d'une classe à l'autre par toutes ces relations d'héritage qui sont faites, ces relations de dérivation.

Maintenant réfléchissez quand vous faites de l'héritage parce que ça ne s'applique pas tout le temps.

Pareil on ne peut pas faire de l'héritage multiple comme certains langages qui peuvent le permettre c'est à dire avoir une classe qui hérité de plusieurs par exemple :

```cs
class SpecialButton : Button, Widget, OtherClass
```
:warning: l'héritage multiple n'est pas possible en CSharp.

Ce n'est pas possible mais on a quelque chose qui permet de le faire même si l'usage premier n’est pas de le faire, ce sont les **interfaces** qui est un concept que nous verrons plus tard mais attention les interfaces n'ont pas été créées pour faire de l'héritage multiple car elles ont une toute autre fonction mais de manière secondaire elles permettent l'héritage multiple.

Ainsi on peut créer tout un arbre d'héritage avec ce système transitif avec des classes qui héritent les unes des autres.

La prochaine fois, on verra les classes abstraites.

A bientôt