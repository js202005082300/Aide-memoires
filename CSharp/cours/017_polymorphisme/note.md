[17. Polymorphisme](https://www.youtube.com/watch?v=pUH4wBJ1PT0)

Vidéo sur le polymorphisme.

Le polymorphisme n'est pas nécessairement rattaché à la programmation objet c'est à dire qu'il y a du polymorphisme dans d'autres paradigmes et on avait vu précédemment une vidéo dédiée à la surcharge c'est à dire que c'est une forme de polymorphisme.

On peut également retrouver de polymorphisme en programmation impérative, Nous avons une surcharge de fonctions qui est un genre de polymorphisme ad hoc et celui qu'on va aborder ici est itinéraire à la programmation objet qui va faire appel au concept d'héritage qui est très important en programmation.

à partir de là, via ce polymorphisme d'héritage ou polymorphisme d'inclusion, On va profiter des nombreux avantages offerts par ce concept.

```cs
using System;

namespace App
{
    class Human
    {
        public void Fight()
        {
            Console.WriteLine("Pour l'Alliance !");
        }
    }

    class Orc
    {
        public void Fight()
        {
            Console.WriteLine("Pour la Horde !");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Human h = new Human();
            h.Fight();

            Orc o = new Orc();
            o.Fight();
        }
    }
}
```
```powershell
> dotnet run
Pour l'Alliance !
Pour la Horde !
```

Imaginons que l'Orc et l'Humain aient besoin de s'unir contre une même menace. Actuellement ils ont chacun leur manière de se battre, ils ont un comportement différent.

Noté qu'on peut créer un tableau composé d'Humain mais on verra tout cela !

```cs
class Program
{
    static void Main(string[] args)
    {
        Human[] humansArmy = new Human[];
    }
}
```

On fait un tableau d'Humains, tableau qui contient des instance de la classe Human.

```cs
class Program
{
    static void Main(string[] args)
    {
        Human h1 = new Human();
        Human h2 = new Human();
        
        Human[] humansArmy = new Human[]
        {
            h1, h2
        };

        foreach(var human in humansArmy)
            human.Fight();
    }
}
```

On exécute.

```cs
using System;

namespace App
{
    class Human
    {
        public void Fight()
        {
            Console.WriteLine("Pour l'Alliance !");
        }
    }

    class Orc
    {
        public void Fight()
        {
            Console.WriteLine("Pour la Horde !");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Human h1 = new Human();
            Human h2 = new Human();
            
            Human[] humansArmy = new Human[]
            {
                h1, h2
            };

            foreach(var human in humansArmy)
                human.Fight();
        }
    }
}
```
```powershell
> dotnet run
Pour l'Alliance !
Pour l'Alliance !
```

On arrive toujours pas à réunir tous les clans au sein d'une même aliance !

Le problème des tableaux, c'est qu'on prend qu'un seul type.

## virtual & override

Une solution serait une classe de combattant dont on ferait dériver les autres classes ou une classe avec une méthode abstraite mais on va dire que les éléments sont virtuelles *VIRTUAL*. On utilise *OVERRIDE* pour étendre dans ces classes qui dérivent.

```cs
using System;

namespace App
{
    class Fighter
    {
        virtual public void Fight()
        {
            Console.WriteLine("Je combats, mais je ne sais pas dans quel camps je suis");
        }
    }
    
    class Human : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour l'Alliance !");
        }
    }

    class Orc : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour la Horde !");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            //...
        }
    }
}
```
```powershell
```

C'est la méthode Fight() de la méthode étendue qui sera appelée quand on fera appel à un Orc.

+ base

Noté qu'on peut faire appel également faire appel à la méthode de la classe étendue directement `base.Fight();`. On appelle la méthode qui est dans la classe parente grâce au mot-clé *base*.

```cs
class Human : Fighter
{
    public override void Fight()
    {
        base.Fight();
        Console.WriteLine("Pour l'Alliance !");
    }
}
```

Voilà on redefinir le tout pour avoir un comportement commun.

Ce n'est pas comme une interface avec l'obligation (comme un contrat) d'implémenter une méthode et ce n'est pas non plus comme une méthode abstraite.

Le fait que ce soit virtuel ne nous impose pas l'implémentation.

```cs
using System;

namespace App
{
    class Fighter
    {
        virtual public void Fight()
        {
            Console.WriteLine("Je combats, mais je ne sais pas dans quel camps je suis");
        }
    }
    
    class Human : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour l'Alliance !");
        }
    }

    class Orc : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour la Horde !");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Human h1 = new Human();
            Human h2 = new Human();
            Orc o1 = new Orc();
            Orc o2 = new Orc();

            Fighter[] fighters = new Fighter[] {h1, h2, o1, o2};

            foreach(var f in fighters)
                f.Fight();
        }
    }
}
```
```powershell
>dotnet run
Pour l'Alliance !
Pour l'Alliance !
Pour la Horde !
Pour la Horde !
```

On crée différentes instances que l'on met sous un autre types dans un tableau (on vera cela !).

On aurait pu déclarer que des fighters.

```cs
Fighter h1 = new Human();
Fighter h2 = new Human();
Fighter o1 = new Orc();
Fighter o2 = new Orc();
```

Le problème, c'est qu'à tout moment on ne sait quel type de combatant va combatre.

```cs
using System;

namespace App
{
    class Fighter
    {
        virtual public void Fight()
        {
            Console.WriteLine("Je combats, mais je ne sais pas dans quel camps je suis");
        }
    }
    
    class Human : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour l'Alliance !");
        }
    }

    class Orc : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour la Horde !");
        }
    }

    class Tauren : Fighter
    {
        public override void Fight()
        {
            Console.WriteLine("Pour la Horde, comme les Orcs !");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Fighter h1 = new Human();
            Fighter h2 = new Human();
            Fighter o1 = new Orc();
            Fighter o2 = new Orc();
            Fighter t1 = new Tauren();

            Fighter[] fighters = new Fighter[] {h1, h2, o1, o2, t1};

            foreach(var f in fighters)
                f.Fight();
        }
    }
}
```
```powershell
>dotnet run
Pour l'Alliance !
Pour l'Alliance !
Pour la Horde !
Pour la Horde !
Pour la Horde, comme les Orcs !
```

Si on voulait différencier le type, vérifier à chaque fois la classe de l'objet.

```cs
static void Main(string[] args)
{
    Fighter h1 = new Human();
    Fighter h2 = new Human();
    Fighter o1 = new Orc();
    Fighter o2 = new Orc();
    Fighter t1 = new Tauren();

    Fighter[] fighters = new Fighter[] {h1, h2, o1, o2, t1};

    //  Si c'est un Orc
    //      alors appeler sa méthode
    //  Sinon, si c'est un Humain
    //      alors appeler sa méthode...

    foreach(var f in fighters)
        f.Fight();
}
```

Voilà pour le polymorphisme, on a une classe de base avec nos méthodes virtuelles et ensuite dans les méthodes qui en héritent, on peut étendre *override* les différentes méthodes des classes qui en héritent et le gros avantage, on adopte un code générique pour tous les combatants dans Main().

## new

Maintenant si on veut masquer des classes, des méthodes mais pas les attributs. Par exemple, je veux récupérer `lifePoints` dans les autres classes mais en masquant l'information de base donc on utilise le mot clé `new` pour avoir un élément qui possède le même nom et ensuite avoir une autre valeur.

```cs
using System;

namespace App
{
    class Fighter
    {
        public int lifePoints = 1000;
    }
    
    class Human : Fighter
    {
        new public int lifePoints = 2500;
    }

    /*---------------------------------------------------------------*/

    class Program
    {
        static void Main(string[] args)
        {
            var h = new Human();
            Console.WriteLine(h.lifePoints);
        }
    }
}
```
```powershell
> dotnet run
2500
```

Prendre note de ce concept et voir avec la pratique.

Maintenant si je veux accéder à l'élément de base. Ici pas besoin d'une instance de Human, on peut accéder au 1000.

```cs
using System;

namespace App
{
    class Fighter
    {
        public static int lifePoints = 1000;
    }
    
    class Human : Fighter
    {
        new public int lifePoints = 2500;
    }

    /*---------------------------------------------------------------*/

    class Program
    {
        static void Main(string[] args)
        {
            //var h = new Human();
            Console.WriteLine(Fighter.lifePoints);
        }
    }
}
```
```powershell
> dotnet run
1000
```

On peut avoir un masquage de l'élément de base avec le mot clé `new`, attention élément contraire à `override` donc ne pas faire :

```cs
new override public int lifePoints = 2500
```

`new` et `override` sont contraires.

`override` étend un comportement de base.

`new` masque et définir quelque chose de nouveau.

## sealed

Pour terminer quand on fait cette petite extension de comportement. Human va avoir une version étendue de la méthode Fight mais Human ne pourra pas être étendue elle-même grâce au mot-clé `sealed` pour vérrouiller.

```cs
using System;

namespace App
{
    class Fighter
    {
        public virtual void Fight()
        {

        }
    }
    
    class Human : Fighter
    {
        public sealed void Fight()
        {

        }
    }

    /*---------------------------------------------------------------*/

    class Program
    {
        static void Main(string[] args)
        {
            //var h = new Human();
            Console.WriteLine(Fighter.lifePoints);
        }
    }
}
```
```powershell
> dotnet run
1000
```

On ne pourra pas étendre cette méthode de Human :

```cs
public sealed void Fight(){}
```

Elle est vérouillée, c'est la dernière extension qu'on peut faire.

`sealed` mot-clé pour ne pas étendre et dire que cette classe est vérouillée. classe au plus bas de la hiéarchie d'héritage.

Avec l'utilisation de l'héritage, on définit des methodes virtuelles et ensuite dans des classes dérivées, on peut étendre les comportements des méthodes virtuelles avec le mot-clé `override` pour avoir ensuite le code le plus générique possible et de faire notre tableau générique.

Dans la prochaine séance, on verra les tableaux.

Á bienôt.