# [10. Structures et classes](https://www.youtube.com/watch?v=tCM63nMetaU)

```cs
using System;

namespace App
{
    class Base
    {
        static void Main(string[] args)
        {

        }
    }
}
```

La méthode est forcément dans une classe (on peut néanmoins se passer de l'espace de nom *namespace*) donc attention Main() n'a pas une portée globale comme dans d'autres langages.

:warning: les fonctionnement d'une classe en CSharp n'est pas forcément le même qu'en Java donc il faut se renseigner.

On peut imaginer plusieurs types de classe : class Animal, class File, class FileStream, class SerializationFile, et cetera. Les structures de classes peuvent être aussi abstraites.

## Partie 1 - les structures

### Créer une structure

Créer une structure pour représenter un disque dur (élément concret).

```cs
using System;

namespace App
{
    struct Disk
    {
        string Brand;
        int Capacity;//en Go
    }
    
    class Base
    {
        static void Main(string[] args)
        {

        }
    }
}
```

Déclarer et initialisation d'une valeur par défaut.

```cs
using System;

namespace App
{
    struct Disk
    {
        string Brand;
        int Capacity;//en Go
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            int n = default;
            Disk d;
        }
    }
}
```

Pour le int, float, ect *default* applique *0*, pour un char c'est *\0*. Pour un type référence c'est *null*.

`d` est notre objet.

Attention aux accès en C#, les éléments sont privé par défaut alors que dans certains langages, une structure va être publique.

```cs
/*
    public, protected, private, internal
*/
```

L'accès *internal* qu'on abordera avec l'assembleur.

Ces accès peuvent être cumulé `private internal`.

Mettons l'accessibilité en public pour la structure et tout ses champs.

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d;
        }
    }
}
```

Manipulons les champs et affichons-les.

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d;

            d.Brand = "Seagate";
            d.Capacity = 2000;

            Console.WriteLine(d.Brand);
        }
    }
}
```
```powershell
dotnet run     
Seagate
```

:warning: ces données initialisées ne vont pas être modifiées. On utilise généralement une structure pour ça !

Ajoutons des éléments à la structure. Si elle devient trop complexe, il faut passer par une classe. AU choix nous choisirons la structure ou la classe.

On ajoute un constructeur à notre structure, ainsi à la fin de l'appel à notre constructeur, on doit avoir initialisé la totalité des champs.

Cette fois-ci, on initialise avec la syntaxe du constructeur, avec le mot clé new (ce n'est pas un simple appel de méthode mais un appel à un constructeur).

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d = new Disk("Toshiba", 1000);

            Console.WriteLine(d.Brand);
        }
    }
}
```
```powershell
dotnet run     
Toshiba
```

Un constructeur doit assigner une valeur pour chacuns des champs sinon ça ne compilera pas. Sans constructeur ce seront des valeurs par défaut qui seront assignées.

Suivant les langages la structure est public ou non mais nous on va le mettre en public par défaut : `public struct Disk`.

Puis d'autres objets...

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d = new Disk("Toshiba", 1000);
            Disk d2 = new Disk("Western Digital", 5000);

            Console.WriteLine(d.Brand);
            Console.WriteLine(d2.Capacity);
        }
    }
}
```
```powershell
dotnet run     
Toshiba
5000
```

Ces données ne sont pas faites pour être modifiée, un Toshiba restera un Toshiba !

### Réécriture de la méthode ToString

Révision des méthodes, de la surcharge des méthodes et également les corps d'expression (les méthodes inline).

On va réécrire une méthode avec le terme *override* et `=>` pour le corps d'expression.

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d = new Disk("Toshiba", 1000);
            Disk d2 = new Disk("Western Digital", 5000);

            Console.WriteLine(d);
            Console.WriteLine(d2);
        }
    }
}
```
```powershell
dotnet run
Disque de marque Toshiba, d'une capacite de 1000Go.
Disque de marque Western Digital, d'une capacite de 5000Go.
```

Si on ne réécrit pas cette méthode ToString(), elle nous met la méthode de départ.

```cs
using System;

/*
    public, protected, private, internal
*/

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        //public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Disk d = new Disk("Toshiba", 1000);
            Disk d2 = new Disk("Western Digital", 5000);

            Console.WriteLine(d);
            //Console.WriteLine(d2);
        }
    }
}
```
```powershell
dotnet run
App.Disk
```

ToString() retourne le nom de notre structure `App.Disk`, on a donc surcharger (override), réécrit cette méthode pour être plus explicite et savoir ce qu'on manipule.

Cette structure contient : 2 champs (pas de propriétés), un constructeur et une méthode de surcharge de ToString().

:warning: si on met un constructeur dans une structure (non obligatoire), nous devons assigner tous les champs.

### Structure ou classe

Si on a besoin d'un type personnalisé sans devoir modifier les informations créées, utiliser une structure.

Les classes sont conçues pour la modification et que ça change durant la durée de vie de l'objet au cours de l'exécution du programme.

## Partie 2 - Les classes

Admettons gérer des stocks (non palpable, abstrait).

```txt
Stock stock_disks = new Stock(100);
Stock stock_mouses = new Stock(25);
```

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {

    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock(100);
            Stock stock_mouses = new Stock(25);

            //Console.WriteLine(d);
        }
    }
}
```
```powershell
```

Pour notre classe, il faut un nom *Stock*, un niveau d'accès *public* car je veux pouvoir instancier des objets de classe Stock n'importe où.

### Ajouter un constructeur par défaut

L'assignation de tout les champs d'une classe n'est pas obligatoire alors que une structure c'est obligatoire.

Admettons un premier constructeur (on peut en faire plusieur si ça a un intérêt). On va définir un constructeur par défaut c'est-à-dire que si je crée une instance sans aucune informations, par exemple je mettrais `capacity = 100;`.

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        public Stock()
        {
            Capacity = 100;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock(100);
            Stock stock_mouses = new Stock(25);

            //Console.WriteLine(d);
        }
    }
}
```
```powershell
```

### Ajouter un attribut privé

Le mot *private* signifie que l'information ne serra accessible que depuis l'intérieur de notre classe... admettons qu'on aurais eu `private string Brand; private int capacity;` on aurais quand même pu accéder aux éléments qui sont privés avec la méthode ToString() dans la même structure.

Voilà pour la distinction entre *public* et *private*, cela a toute son importance quand on parle d'héritage.

```txt
private int Capacity;
```

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock(100);
            Stock stock_mouses = new Stock(25);

            //Console.WriteLine(d);
        }
    }
}
```
```powershell
```

### Ajouter un constructeur où on doit préciser nous-même un champ

```txt
public Stock(int capacity)
{
    Capacity = capacity;
}
```

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            //Console.WriteLine(d);
        }
    }
}
```
```powershell
```

En gros si on construit une instance avec ce constructeur `public Stock(){}` sans rien préciser, voyez que c'est le programme qui va décider lui même de la valeur brute à appliquer `Capacity = 100;` sinon j'ai indiqué l'information et on va prendre l'information qu'on a choisit.

### Ajouter une ToString pour afficher les informations

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks.Capacity);
        }
    }
}
```
```powershell
Dotnet run
Program.cs(41,43): error CS0122: 'Stock.Capacity' est inaccessible en raison de son niveau de protection [C:\Users\sam\OneDrive\Aide-mémoires\CSharp\cours\FirstApp\FirstApp.csproj]

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

:warning: prendre l'habitude de mettre les niveau d'accès les plus restrictifs possibles. Par défaut, je bloque tout et après si besoin je donne plus de liberté.

La solution est d'afficher cette information par une ToString(), qui est ré-écrite/surchargée, pourra y accéder sans problème parce qu'elle appartient à la même classe donc elle a le droit d'accéder à un élément privé.

Voilà on remplace `Console.WriteLine(stock_disks.Capacity);` par `Console.WriteLine(Capacity);`

```cs
using System;

namespace App
{
    public struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}
```
```powershell
Dotnet run
Capacité du stock : 100Go.
```

On fait comme ça parce qu'on a pas encore vu les propriétés permettant d'afficher un seul attribut.

### Modifier un attribut

Rappel, la structure est un **type valeur**. Quand on manipule des structures, il y a des copies de ces structures durant l'appel de méthode donc on utilise la structure pour des éléments assez léger, on évite la modification, on va surtout faire de la lecture.

La classe c'est un **type référence** à l'information.

#### le mot-clé const

Par ailleurs, sachez qu'on peut appliquer tout ce qu'on a vu avant `const`.

```cs
public const string Brand;
```

#### le mot-clé readonly

Mettre une structure en lecture seule car on veut éviter de la modifier.

```txt
public readonly struct Disk
```

```cs
using System;

namespace App
{
    public readonly struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}
```
```powershell
```

On peut en mettre partout, y compris pour la méthode ToString() puisqu'elle ne modifie rien, elle fait qu'afficher quelque chose.

```txt
    public readonly struct Disk
    {
        public readonly string Brand;
        public readonly int Capacity;
        //...
        public override readonly string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";

    }
```

Pour ceux qui font du c++, cela fait beaucoup penser à `const` pour dire qu'un attribut ne va pas changer de valeur, et en CSharp on a `readonly`.

Par exemple.

```cs
using System;

namespace App
{
    public readonly struct Disk
    {
        public string Brand;
        public int Capacity;

        public Disk(string brand, int capacity)
        {
            Brand = brand;
            Capacity = capacity;
        }

        public override string ToString() => $"Disque de marque {Brand}, d'une capacite de {Capacity}Go.";
    }

    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Disk d;
            d.Brand = "Toshiba";
            d.Capacity = 1000;
            Console.WriteLine(d);
            d.Capacity = 2000;
            Console.WriteLine(d);

            Console.WriteLine(stock_disks);
        }
    }
}
```
```powershell
Program.cs(7,23): error CS8340: Les champs d'instance de structs en lecture seule doivent être en lecture seule. [C:\Users\sam\OneDrive\Aide-mémoires\CSharp\cours\FirstApp\FirstApp.csproj]
Program.cs(8,20): error CS8340: Les champs d'instance de structs en lecture seule doivent être en lecture seule. [C:\Users\sam\OneDrive\Aide-mémoires\CSharp\cours\FirstApp\FirstApp.csproj]

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

Voilà, le changement a été refusé !

*Note : on a vu qu'on pouvait avoir dans une classe ou dans une structure, avoir des méthodes, des attributs et plutard des propriétés qui permettent d'accéder et de gérer l'accès et la modification de ces attributs. Dans les méthodes, on peut avoir éventuellement des méthodes particulières qui sont les constructeurs et on a ce qu'on appelle les finalisseurs en CSharp, appelé les destructeur en c++. Attention, on retrouve des finalisseurs dans les classes mais pas dans les structures. 

Ensuite on a fait de la surcharge de méthode `override`, on vera qu'on peut faire de la surcharge d'opérateur, par exemple, l'opérateur peut faire la somme de deux nombres mais est-ce qu'il peut faire la somme de deux Disk ? par exemple tester si deux Stock() sont égaux ainsi il n'y a pas qu'une seule information à vérifier. Il y aura plusieurs attributs et c'est à ça que servira la surcharge d'opérateur.

On aura également les indexeurs pour gérer un type personnalisé et lui faire adopter le comportement d'un tableau, gérer ainsi des indices comme aurais sur un tableau statique pour créer un type personnalisé qui doit adopter ce comportement.

On aura les évennement, et cetera.*

#### le mot-clé abstract

Définir une classe abstraite (les structures ne peuvent pas être abstraites) pour dire on a tel informations, tel méthodes mais on implémente pas le code et plus tard on crée des classe plus concrètes qui vont hériter de celle-ci donc on va avoir une histoire d'héritage que les classes permettent mais que les structures ne permettent pas.

```cs
using System;

namespace App
{
    public readonly struct Disk
    {
        //...
    }

    public abstract class Stock // abstract
    {
        //...
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            //...
        }
    }
}
```

On ferra une vidéo sur l'héritage dédié à ça.

#### le mot-clé static

Il permet de faire ce qu'on a fait ici sans créer d'instance de cette classe.

Admettons qu'un jour vous ayez besoin de faire une classe d'utilitaire pour avoir accès à certaines méthodes, à rassembler dans une classe parce que ça fonctionne ensemble par exemple de se dire que j'ai besoin de manipuler une base de données, de me connecter à la base, de faire une requête et tout ça Eh bien vous allez créer une **classe statique** c'est à dire que vous n'aurez pas besoin chaque fois de créer une nouvelle instance pour la base de données mais juste de vous dire que pour cette classe je veux faire appel à telle ou telle méthode, où accéder à telle ou telle information.

Pour ça on fait une classe qui est dites *static* et qui n'a pas besoin d'être instanciée.

En gros une classe *static*, on aura jamais de *new* comme ici `new Stock();`. On va simplement appeler le nom de la classe et faire appel à la méthode `Stock.SomeMethode()`

+ Base.cs
```cs
using System;

namespace App
{
    public readonly struct Disk
    {
        //...
    }

    public static class Stock // static
    {
        //...
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            obj.SomeMethode();

            Console.WriteLine(stock_disks);
        }
    }
}
```

Et non pas `new Stock();` pour obtenir un objet et faire appel à cette méthode :

```cs
obj.SomeMethode();
```

Voilà ça c'est la petite distinction qu'on a entre statique et non statique, on a ça également pour des champs mais c'est encore un cas particulier qu'on ne verra pas spécialement ici.

#### Le mot-clé partial

C'est la définition partielle.

Alors ça j'en parle vraiment à la fin de cette séance parce que ça ne va pas concerner la majorité des gens parmi vous.

Imaginez qu'un jour vous ayez besoin de bosser à plusieurs sur un projet, avec plusieurs développeurs, il peut arriver que vous soyez des fois travailler sur la même classe ou la même structure.

Pour ça CSharp propose de définir une classe de manière partielle.

+ Base.cs
```cs
using System;

namespace App
{
    public partial class Stock // partial
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
    
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}
```
```powershell
```

Admettons que un autre développeur ait un fichier CSharp qui ne s'appelle pas forcément *Base.cs*, il va avoir de son côté une classe qui sera également *public partial* parce qu'il faut faire attention aux accès ainsi on ne peut pas mélanger les accès et ainsi il va écrire la même classe `public partial class Stock` mais il aura autre chose dedans, il aura d'autres attributs, peut être d'autres constructeurs, d'autres méthodes et cetera.

Ainsi lors de la compilation il va y avoir une fusion des parties d'où le nom partial pour la même classe donc s'il y a plusieurs morceaux de cette classe Stock, elles vont être fusionnées et à la fin on retrouvera une classe complète avec tous ces attributs, ces constructeurs, ces méthodes et cetera.

Voilà c'est vraiment un cas très spécifique de plusieurs personnes qui travaillent éventuellement sur la même structure et la même classe.

On peut définir des choses partielles.

Bien sûr on peut pas avoir une partielle public et privé, voilà il faut une conformité au niveau des accès mais sachez que ça existe.

## Modularité

Nous allons voir maintenant comment travailler sur plusieurs fichiers et pour des raisons de lisibilité on va éviter de mettre plusieurs classes dans un seul fichier, je vais dire une seule classe par fichier ou éventuellement un type de données par fichier comme ça le nom de fichier permet de me dire que ça concerne telle information, tel type de donnée.

Admettons qu'on ait une classe Stock que l'on va mettre dans un fichier pour faire un peu de place.

Voilà ce n'est pas obligatoire parce qu'il y a des langages on oblige à avoir une seule classe par fichier mais ce n'est pas le cas en CSharp car on a pu mettre une *struct* et 2 *class* dans le même fichier, ça n'a pas posé de problème mais après pour des questions pratiques c'est à vous d'adapter.

Voilà au plus simple fait comme ça. L'espace de nom `namespace App` n'est pas obligatoire. Et pour la compilation pas de problème, pas besoin d'importer il trouvera le fichier sans soucis. Après nous on utilise des espaces de noms parce que ça permet d'encore mieux organiser le code notamment si on veut faire après des sous dossiers et cetera, on va travailler sur les espaces de noms et du coup on va travailler sur le même espace de noms dans les 2 fichiers pour dire que Stock appartient au même espace comme ça on aura une même appartenance entre ces deux-là.

+ Stock.cs
```cs
using System;

namespace App
{
    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
}
```

+ Base.cs
```cs
using System;

namespace App
{
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}
```

+ Compilation et exécution
```powershell
Dotnet run     
Capacité du stock : 100Go.
```

Voilà pas besoin de faire d'import et cetera, on pourrait faire par exemple un `using App;` mais ce n'est pas nécessaire parce que notre class Base et déjà dans l'espace de noms donc pas besoin de dire using App car il est déjà lui-même dedans mais si admettons elle était dans un autre espace de nom, il faudrait le faire.

+ Stock.cs
```cs
using App;
using System;

namespace Other // espace de nom différent
{
    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
}
```

Voilà comme la class Stock appartient toujours à cet espace App, il faudrait faire un import comment on a fait pour `Console.WriteLine`, on ajoute son espace de nom `using System;` parce qu'elle n'appartient pas.

Voilà on a le même espace de nom donc nous n'avons pas besoin de faire d'import.

Donc là on passe vite sans trop de détails parce qu'on n'a pas encore abordé les espaces de noms mais c'était plus pour terminer cette vidéo avec plus de fichier pour que vous puissiez à ce stade de cours programmé dans plusieurs fichiers et pas forcément le faire que dans un seul.

Dans les séances suivantes, je continuerai quand je peux le faire de travailler sur un seul fichier parce qu'il n'y a pas besoin d'en faire beaucoup pour vous apprendre ce qu'il y a à faire par rapport aux notions.

Prenez ainsi l'habitude dès maintenant de structurer un minimum pour avoir quelque chose de lisible pour vous et bien organisé au niveau de votre code.

À ce stade de la vidéo vous savez ce qu'est une classe, vous savez ce qu'est une structure, dans quel cas on utilise plutôt l'un ou plutôt l'autre. On n'a pas encore parlé d'héritage mais c'est un jour vous avez besoin de faire de l'héritage, la question ne se posera pas ce sera une classe parce qu'on ne peut pas faire d'héritage avec une structure.

Ensuite ce qu'il faut retenir c'est que la structure c'est pour un type personnalisé mais qui n'est pas trop trop conséquent avec des informations qui ne sont pas forcément faites pour être modifiée au cours de la durée de vie de ce type personnalisé, alors que pour la classe on aura quelque chose de beaucoup plus complexe, plus conséquent, éventuellement des modifications de l'état de notre objet de classe et plus tard la possibilité de faire par exemple des classes abstraites, la possibilité de faire des classes statiques, et la possibilité de faire de l'héritage.

Voilà je le répète mais on pourra pas faire d'héritage avec les structures quand on abordera ça dans le détail.

Bien sûr les classes amèneront tout un tas d'autres concepts par la suite tels que les interfaces, le polymorphisme, bref d'autres choses qui vont être très importantes et qu'on retrouve en programmation objet qui sont très très rattachés à ce principe et ce système de classe.

Voilà c'est la fin.

Un dernier petit rappel par exemple pour le mot-clé static vous n'avez pas besoin de créé d'instance de Base ici donc on peut appeler la méthode directement ce qu'on a vu avec les classes statiques notamment.

+ Base.cs
```cs
using System;

namespace App
{
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}
```

Voilà nous avons déjà vu suffisamment pour pouvoir nous entraîner et faire plein de petits programmes comme tester les différentes syntaxes, les valeurs par défaut, différents constructeurs et différentes structures, voyez comment ça fonctionne et comment on instancie, comment on affiche les valeurs, comment on modifie les valeurs et cetera.

Voilà vous savez faire déclasser des structures on se revoit très bientôt pour une prochaine vidéo