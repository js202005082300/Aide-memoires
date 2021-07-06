# [9. Méthodes](https://www.youtube.com/watch?v=nKmPXDdfA3s)

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

Par exemple la méthode WriteLine() associé à la classe Console permet d'afficher du texte dans le terminal.

Une méthode est un ensemble d'instructions, un bloc de code entre {} qui se situe dans le contexte de l'élément parent.

Une méthode permet de factoriser du code.

## Signature de méthode

La signature est composé de :

+ Nom de méthode  

:warning: Règle de nommage.

+ Paramètres  
Ce qui est entre parenthèse quand on définit une méthode et quand on appel cette méthode créé, les paramètres qu'elle attend lors de l'appel ce sont les arguments. Deux termes différents, les arguments sont attendus lors de l'appel et les paramètres concerne la déclaration la définition de la méthode.

+ Type

On retrouve le type de retour dans d'autres langages mais en C# ça ne fait pas partie de la signature parce qu'on le principe de surcharge de méthode donc la possibilité de réécrire la définition d'une méthode donc le type de retour ne fait pas partie de la signature.

Pour writeLine(), on n'a pas créé d'instance de la classe Console pour l'utiliser, on utilise une méthode sans passer par un objet de la classe.

On va passer une classe statique ce qui permet d'éviter de créer une instance de Program pour utiliser la méthode Main() donc l'intéret de créer une méthode statique.

Par exemple une méthode Hello().

```cs
using System;

/*
    - Nom de méthode
    - Paramètres

    Accès : public, protected, private
*/

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            
        }

        public static void Hello()
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

Hello() méthode statique qui ne prend aucun paramètre et ne retourne rien et on peut évoquer son accèssibilité.

## Accèssibilité

L'accéssibilité :
+ public : Disponible partout.  
+ protected : Accèssibilité dans l'arborescence de classe qui sont dans un système d'héritage.  
+ private : cela appartient à la classe elle-même. Si on a une méthode private dans Program, il n'y a que la classe elle-même qui pourra l'utiliser. D'autres classes ne pourrait pas y avoir accès.  

:warning: l'accèssibilité dépend des langages de programmation, certains considèrent que c'est public et d'autres privé par défaut d'où l'intéret d'être explicite dans la signature.

Voilà pour la déclaration et la définition d'une méthode qui ne fait qu'afficher un message.

## Appel de la méthode

On l'appelle directement par son nom.

```cs
using System;

/*
    - Nom de méthode
    - Paramètres

    Accès : public, protected, private
*/

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Hello();
        }

        public static void Hello()
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run      
Hello World !
```

## Modificateurs

Les modificateurs :
+ abstract
+ sealed
+ virtual
+ unsafe (non-sécurisé lorsqu'on veux faire des pointeurs en C#.)

```cs
/*
    - Nom de méthode
    - Paramètres

    Accès : public, protected, private
    Modificateurs : abstract, sealed, virtual, unsafe
*/
```

Utilisés sur des classes ou des méthodes.

On cite ces mots-clés qu'on utilisera plus tard.

## Fonction avec paramètres

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Sum(15, 4);
            Sum(246, 33);
        }

        public static void Sum(int x, int y)
        {
            Console.WriteLine(x + y);
        }
    }
}
```
```powershell
dotnet run
19
279
```

Les variables x et y n'appartiennent qu'on contexte de la méthode Sum().

## Récupérer le retour de fonction

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int result = Sum(142, 55);
            Console.WriteLine(result);
        }

        public static int Sum(int x, int y)
        {
            return x + y; // retourne un int
        }
    }
}
```
```powershell
dotnet run
197
```

Idem, au choix.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Sum(142, 55));
        }

        public static int Sum(int x, int y)
        {
            return x + y; // retourne un int
        }
    }
}
```
```powershell
dotnet run
197
```

Il est recommandé de passer par des variables pour des raisons de lisibilité (créer une variable ne coûte rien).

Admettons plusieurs return mais un seul scénario de retour possible.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Sum(142, 55));
        }

        public static int Sum(int x, int y)
        {
            if(y == 0)
                return x;
            else if(x == 0)
                return y;
            
            return x + y; // retourne un int
        }
    }
}
```
```powershell
dotnet run
197
```

## Une petite méthode de dialogue

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Say("Coucou !", "Laurie");
            Say("Salut, tu vas bien ?", "Thomas");
        }

        public static void Say(string message, string name)
        {
            Console.WriteLine(name + " : " + message);
        }
    }
}
```
```powershell
dotnet run
Laurie : Coucou !
Thomas : Salut, tu vas bien ?
```

### Paramètre par défaut

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Say("Coucou !", "Laurie");
            Say("Salut, tu vas bien ?", "Thomas");
            Say("Héhé, personne ne me connaît...");
        }

        public static void Say(string message, string name = "Anonyme")
        {
            Console.WriteLine(name + " : " + message);
        }
    }
}
```
```powershell
dotnet run
Laurie : Coucou !
Thomas : Salut, tu vas bien ?
Anonyme : Héhé, personne ne me connaît...
```

Cette possibilité de paramètre par défaut ne se retrouve pas dans tout les langages de programmation.

### Paramètres nommés

Les paramètres nommés lors de l'appel existe aussi en Python !

L'ordre n'a plus d'importance.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Say(name:"Laurie", message:"Coucou !");
            Say("Salut, tu vas bien ?", "Thomas");
        }

        public static void Say(string message, string name)
        {
            Console.WriteLine(name + " : " + message);
        }
    }
}
```
```powershell
dotnet run
Laurie : Coucou !
Thomas : Salut, tu vas bien ?
```

Ce type de paramètre a été intégré dans les dernières versions.

## Le passage par valeur

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            Console.WriteLine(number);
            number = ResetNumber();
            Console.WriteLine(number);
        }

        public static int ResetNumber()
        {
            return 0;
        }
    }
}
```
```powershell
dotnet run
10
0
```

:warning: le passage par valeur avec int **type valeur**. number dans le contexte main est différent même si ce sont les mêmes étiquettes. On crée une **copie** de même valeur en passant le paramètre à ResetNumber.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            Console.WriteLine(number);
            ResetNumber(number);
            Console.WriteLine(number);
        }

        public static void ResetNumber(int number)
        {
            number = 0;
        }
    }
}
```
```powershell
dotnet run
10
10
```

## Le passage par référence

### ref

Utiliser le mot clé *ref* pour passer nos adresses.

```cs
using System;

/*
    - Nom de méthode
    - Paramètres

    Accès           : public, protected, private
    Modificateurs   : abstract, sealed, virtual, unsafe

    ref : référence + lecture & écriture
*/

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            int number2 = 20;

            Console.WriteLine(number);
            Console.WriteLine(number2);

            ResetNumber(ref number, ref number2);

            Console.WriteLine(number);
            Console.WriteLine(number2);
        }

        public static void ResetNumber(ref int nb, ref int nb2)
        {
            nb = 0;
            nb2 = 0;
        }
    }
}
```
```powershell
dotnet run
10
20
0
0
```

On peut également retourner une référence.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            int number2 = 20;
            ref int result;

            Console.WriteLine(number);
            Console.WriteLine(number2);

            result = ResetNumber(ref number, ref number2);

            Console.WriteLine(number);
            Console.WriteLine(number2);
        }

        public static void ResetNumber(ref int nb, ref int nb2)
        {
            return ref nb + 15; //par exemple.
        }
    }
}
```

Comme les paramètres attendent un *ref*, il faut passer un *ref* à l'appel.

Et comme on retourne une *ref*, il faut également une variable de stockage en *ref*.

*ref* c'est pour faire référence à la valeur sans faire de copie, ça permet de faire de la lecture, de l'écriture c'est-à-dire pour modification de la valeur.

### in

Si vous voulez une information comme référence sans la modifier, on passe une référence avec *in*.

```cs
using System;

/*
    - Nom de méthode
    - Paramètres

    Accès           : public, protected, private
    Modificateurs   : abstract, sealed, virtual, unsafe

    ref : référence + lecture & écriture
    in  : référence + lecture seule
*/

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            int number2 = 20;

            Console.WriteLine(number);
            Console.WriteLine(number2);

            ResetNumber(number, ref number2);

            Console.WriteLine(number);
            Console.WriteLine(number2);
        }

        public static void ResetNumber(in int nb, ref int nb2)
        {
            Console.WriteLine(nb);
            nb2 = 0;
        }
    }
}
```
```powershell
dotnet run
10
20
10
10
0
```

On comprend que :
+ int nb : paramètre de type int qui sera une copie dans la méthode.  
+ ref int nb : paramètre qui peut être lu et modifié.  
+ in int nb : paramètre qui peut seulement être lu.  

### out

Ensuite on a un dernier mot-clé *out*.

```cs
/*
    - Nom de méthode
    - Paramètres

    Accès           : public, protected, private
    Modificateurs   : abstract, sealed, virtual, unsafe

    ref : référence + lecture & écriture
    in  : référence + lecture seule
    out : référence + dclaration de l'extérieur
*/
```

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 10;
            Console.WriteLine(number);
            ChangeValue(out number);
            Console.WriteLine(number);
        }

        public static void ChangeValue(out int number)
        {
            number = 5;
        }
    }
}
```
```powershell
dotnet run
10
5
```

On pourra travailler dans notre méthode par rapport à une information accessible déclarer depuis l'extérieur.

Plus tard on verra qu'on peut déclarer à l'appel `ChangeValue(out int number = 14);`

## Le corps expression

Ce qu'on appelle les fonctions flêchées en Javascript.

Si on a qu'une seule expression dans notre méthode, on peut faire tout sur une seule ligne (code inline).

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Hello();
        }

        public static void Hello() => Console.WriteLine("Hello !");
    }
}
```
```powershell
dotnet run
Hello !
```

:warning: on crée une méthode statique puisqu'il attend une instance d'objet.

Si le return est optionnel, on peut faire ceci.

```cs
using System;

namespace FV
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(14 + 5);
        }

        public static int Sum(int x, int y) => x + y;
    }
}
```
```powershell
dotnet run
19
```

On abordera les notions de méthodes locales, les méthodes anonymes, les expressions lambda et notamment les méthodes asynchrones.