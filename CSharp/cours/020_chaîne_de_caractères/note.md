# [20. Chaînes de caractères](https://www.youtube.com/watch?v=5nK49CWxpDc)

## Comportement 

### immuable

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = "Bonjour";

            s = "Hello";
        }
    }
}
```

Une chaîne de caractères en C# est immuable.

Instancier `string s = "Bonjour";` est différent de `s= "Hello";` même si on dirais qu'on est sur le même objet car on utilise la même variable. En réalité, on instancie un premier objet de la classe String avec une séquence de caractères et lorsqu'on fait une autre instanciation, un nouvel objet est créé.

C'est le même identifiant `s` mais suivant la manière dont on instancie, l'objet change. 

### itérable

Séquence de caractères que l'on peut parcourir (comme on pourrais le faire dans un tableau).

## Déclaration et initialisation

Utilisation d'une variable locale non-assignée.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string s;

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
error CS0165: Utilisation d'une variable locale non assignée 's' 

La build a échoué. Corrigez les erreurs de la build et réexécutez-la.
```

Si on initialise à null.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = null;

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
warning CS8600: Conversion de littéral ayant une valeur null ou d'une éventuelle valeur null en type non-nullable.
```

Attention, une chaîne null n'est pas une chaîne de longueur null, c'est une chaîne sous cette forme `string s = "";`. Elle fait référence à un objet et elle ne pointe pas sur null.

On peut créer une chaîne vide.

### La propriété Empty

Créer une chaîne de longueur null.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = String.Empty;

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run

```

Soit on passe par une valeur littéral, soit par la propriété Empty.

### Classe String et type string

`String` est une classe et comme c'est un type très souvent utilisé, les concepteur on fait l'alias `string`.

## Initialisation

Créer une instance.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = "Bonjour";

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
Bonjour
```

*Si on fait un changement, ça crée une nouvelle chaîne.*

### Passer un tableau à la classe String

Passer par le constructeur de la classe String en lui passant un tableau de caractères.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] letters = {'B', 'o', 'n', 'j', 'o', 'u', 'r'};
            // String est alias de string
            String s = new String(letters);

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
Bonjour
```

On utilisera plus souvent les double guillemets.

### Remplir une chaîne par x caractères

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = new String('M', 50);

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
```

### Chaîne verbatim

Utiliser une chaîne avec un format, une valeur verbatim en faisant précéder le formatage de la chaîne avec le @ pour se conformer avec le formatage de notre éditeur de code.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s1 = @"B    p abc
            UUUU
                g7 p";

            Console.WriteLine(s1);

            String s2 = @"B    p abc
    UUUU
g7 p";

            Console.WriteLine(s2);
        }
    }
}
```
```powershell
> dotnet run
B    p abc
            UUUU
                g7 p
B    p abc
    UUUU
g7 p
```

La chaîne verbatim va vraiment conserver tout le format.

### Interpollation 

Moyen de formater une chaîne lorsqu'on doit injecter des valeurs de variables.

Interpollation, concaténation et injection de variables au sein d'un texte.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String username = "Chuck NORRIS";
            int age = 58;

            String s = $"Il s'appelle {username}, il devrait avoir {age}";
            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
Il s'appelle Chuck NORRIS, il devrait avoir 58
```

### Composition

Composition un chaîne d'éléments que l'on veut injecter.

Il faut des arguments pour remplacer `{0}` et remplacer `{1}`.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String username = "Chuck NORRIS";
            int age = 58;

            String s = $"Il s'appelle {0}, il devrait avoir {1}", username, age;
            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
Il s'appelle Chuck NORRIS, il devrait avoir 58
```

Comme format() en Python ou %s en c.

Idem en regroupant les variables.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            var chuck_info = (username: "Chuck NORRIS", age: 58);
            Console.WriteLine("Il s'appelle {0}, il devrait avoir {1}", chuck_info.username, chuck_info.age);
        }
    }
}
```
```powershell
> dotnet run
Il s'appelle Chuck NORRIS, il devrait avoir 58
```

### Concaténation

Concaténation via l'utilisation de pointeurs.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s1 = "Hello";
            String s2 = s1 + " World !";

            Console.WriteLine(s2);
        }
    }
}
```
```powershell
> dotnet run
Hello World !
```

Attention si à la place de s2, j'avais à nouveau mis s1, on aurait eu la création d'un nouvel objet.

```cs
String s1 = "Hello";
String s2 = s1 + " World !";

s1 = s1 + " World !";
```

Ce n'est pas moins optimisé parce qu'on échappe pas à la création d'une nouvelle chaîne en retappant s1.

Il ne faut pas oublier le caractère immuable des chaînes de caractères en C#.

On change `s1`, on crée un nouvel objet.

## Propriétés et attributs

### Attribut Length

L'attribut Length est une propriété pour récupérer la longueur de la chaîne, le nombre de caractère, y compris les espaces.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour tout le monde";

            Console.WriteLine(s.Length);
        }
    }
}
```
```powershell
> dotnet run
21
```

## Méthodes type String

On a des méthodes que l'on peut utiliser soit à partir de notre objet, soit des méthodes statiques qui proviennent de la classe String.

### Méthodes ToUpper et ToLower

Méthode qui retourne une nouvelle instance, ça ne modifie pas l'objet lui-même. On crée un nouvel objet

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour tout le monde";

            Console.WriteLine(s.ToUpper());
        }
    }
}
```
```powershell
> dotnet run
BONJOUR TOUT LE MONDE
```

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour tout le monde";

            Console.WriteLine(s.ToLower());
        }
    }
}
```
```powershell
> dotnet run
bonjour tout le monde
```

### Méthode Replace

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour tout le monde";

            Console.WriteLine(s.Replace('o', 'i'));
        }
    }
}
```
```powershell
> dotnet run
Binjiur tiut le minde
```

### Méthode Concat

Concaténation sans l'opérateur `+`.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour";
            String s2 = String.Concat(s, " tout le monde");

            Console.WriteLine(s2);
        }
    }
}
```
```powershell
> dotnet run
Bonjour tout le monde
```

### Méthodes StartsWith et EndsWith

Méthodes booléennes.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour";

            Console.WriteLine(s.StartsWith('B'));
        }
    }
}
```
```powershell
> dotnet run
True
```

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour";

            Console.WriteLine(s.EndsWith('B'));
        }
    }
}
```
```powershell
> dotnet run
False
```

### Méthode IndexOf

Comme notre chaîne est un élément séquentiel, on peut récupérer l'indice.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Bonjour";

            Console.WriteLine(s.IndexOf('o'));
        }
    }
}
```
```powershell
> dotnet run
1
```

### Méthode Trim

Virer les espaces dans une chaîne.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "    Bonjour";

            Console.WriteLine(s.Trim());
        }
    }
}
```
```powershell
> dotnet run
Bonjour
```

Pour enlever les extrémités avant ou après un ensemble de caractères. Utiliser les tableaux `{}` ne permet pas d'enlever ce qu'il y a dans la chaîne.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = ";sOM-_7";

            char[] c = {';', '_'};
            Console.WriteLine(s.Trim(c));
        }
    }
}
```
```powershell
> dotnet run
sOM-_7
```

### Méthode Split

Scinder une chaîne selon un séparateur.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "Hello World";

            String[] stringArray = s.Split(" ");

            Console.WriteLine(stringArray[0]);
            Console.WriteLine(stringArray[1]);
        }
    }
}
```
```powershell
> dotnet run
Hello
World
```

### Méthode Join

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] stringArray = {"Hello", "World"};

            String s = String.Join("", stringArray);

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
HelloWorld
```

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] stringArray = {"Hello", "World"};

            String s = String.Join("__", stringArray);

            Console.WriteLine(s);
        }
    }
}
```
```powershell
> dotnet run
Hello__World
```

Voilà pour les méthodes, on peut également faire du copie, du collage et cetera.

## Méthodes type StringBuilder

Notez que faire des manipulations de chaîne est couteux parce qu'on travaille sur des chaîne immuables, chaque manipulation crée une nouvelle chaîne.

C'est très couteux en Java, on retrouve donc le type `StringBuilder` donc un constructeur de chaîne de caractère.

En écrivant `StringBuilder sb = new StringBuilder();`, on obtient une chaîne qu'on va pouvoir concatener donc on va pouvoir ajouter des caractères dans notre chaîne. On travaille avec de la mémoire tampon, le concepteur du langage occupera une capacitée choisie, allouée.

Je peux passer un élément au niveau du constructeur :

```cs
StringBuilder sb = new StringBuilder("Hello");
```

On peut préciser une capacité de 15 :

```cs
StringBuilder sb = new StringBuilder(15);
```

Ou faire les deux :

```cs
StringBuilder sb = new StringBuilder(15, 1000);
```

Ici on a une capacité de 15, et on pourra l'agrandir jusque 1000.

Voilà pour des éléments de contrôle.

### Méthode Apend

Elle permet d'ajouter des éléments à la fin de ma chaîne.

```cs
using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");

            sb.Append(" ");
            sb.Append("World !");

            Console.WriteLine(sb);
        }
    }
}
```
```powershell
> dotnet run
Hello World !
```

### Méthode AppendLine

Ajouter un retour à la ligne.

Notez néanmoins que tous les caractères spéciaux `\t`, `\n` et cetera sont prit en compte.

```cs
using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");

            sb.AppendLine();
            sb.Append("World !");

            Console.WriteLine(sb);
        }
    }
}
```
```powershell
> dotnet run
Hello
World !
```

### Méthode Clear

Retourne une chaîne vide.

```cs
using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");
            sb.Clear();

            Console.WriteLine(sb);
        }
    }
}
```
```powershell
> dotnet run

```

Les méthodes Replace() et cetera fonctionnent aussi.

### Méthode Insert

Insert() insére l'élément au début de la chaîne, à partir de l'indice 0.

```cs
using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");

            sb.Insert(0, "World");

            Console.WriteLine(sb);
        }
    }
}
```
```powershell
> dotnet run
WorldHello
```

### Méthode Remove

Supprimer la totalité de la chaîne sauf le 1e caracthère p.e.

```cs
using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");

            sb.Remove(1, sb.Length - 1);

            Console.WriteLine(sb);
        }
    }
}
```
```powershell
> dotnet run
H
```

L'avantage de travailler avec ce type `StringBuilder` c'est de travailler avec la mémoire tampon.

Pour quelques dizaines de modification, ce n'est pas un traitement énorme mais il vaut mieux prendre les bonnes habitudes au départ et travailler avec `StringBuilder` plutôt que sur des chaînes immuables (créer une nouvelle chaîne à chaque modification).

Bonne journée, bonne soirée, bye bye