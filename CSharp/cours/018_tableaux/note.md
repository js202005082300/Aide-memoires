# [18. Tableaux](https://www.youtube.com/watch?v=1FgKfbNBH6Y)

## Tableau simple

### Déclaration et initialisation par défaut

Regroupement de données.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[5]; // valeur par défaut : 0
        }
    }
}
```

Déclaration d'un tableau de taille fixe de 5 entiers.

### Initialiser des valeurs

On écrit les éléments et la taille 'Fixe' est déduite.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[] {1, 2, 3};
        }
    }
}
```

Idem, syntaxe raccourcie.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};
        }
    }
}
```

Rappel un tableau est à taille fixe (diff. des containneurs et collections).
Si non précisé, les éléments sont à 0 par défaut.
Taille spécifiée à la déclaration ou à l'initialisation.

### Accéder à un élément

Afficher l'élément d'indice 0.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            Console.WriteLine(arr[0]);
        }
    }
}
```
```powershell
> dotnet run
1
```

Au delà de l'indice 2, on déborde du tableau et génère une exception.

### Modifier un élément

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            Console.WriteLine(arr[2]);

            arr[2] = 10;

            Console.WriteLine(arr[2]);
        }
    }
}
```
```powershell
> dotnet run
3
10
```

Initialiser en dehors de la déclaration mais donc plus de notations.

```cs
int[] arr = new int[3];

arr[0] = 1;
arr[1] = 2;
arr[2] = 3;
```

### Parcourir un tableau

#### foreach

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            foreach(var element in arr)
                Console.WriteLine(element);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
```

On met `var` pour ne pas s'embêter sur le type.
`arr` est un élément itérable.
`element` est en lecture, une référence à `1` et cetera et donc on ne peux pas modifier cet élément.

On ne peux pas faire de modification dans ce parcours.

#### for

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            for(int i = 0 ; i < arr.Length ; i++)
                Console.WriteLine(arr[i]);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
```

Avantage d'accéder à une valeur et de modifier une valeur dans une boucle for.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            for(int i = 0 ; i < arr.Length ; i++)
            {
                if(arr[i] == 3)
                    arr[i] = 10;
            }

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
```

### Type de tableau

```cs
// Tableau de chaîne de caractères.
string[] arr;

// Tableau d'une classe Animal
Animal[] arr;
```

## Tableau multidimentionnel

```cs
// 2 dimensions
int[,] arr;

// 3 dimensions
int[,,] arr;

// 1er dimension avec 3 élemennts et la 2e dimension avec 2 éléments
int[,] arr = new int[3, 2];

// initialisation sur le 1e élément (plus de syntaxe)
arr[0,0] = 1;

// initialisation avec les accolades (solution raccourcie)
int[,] arr =
{
    {1, 2, 3},
    {4, 5, 6}
};
```

/!\ CSharp ne considère pas ce tableaux à 2 dimensions comme un tableau de tableau comme on le ferais dans d'autres languages.

### Afficher un tableau à 2 dimensions

On récupère le premier élément d'un tableau à deux dimensions.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[,] arr =
            {
                {1, 2, 3},
                {4, 5, 6}
            };

            Console.WriteLine(arr[0, 0]);
        }
    }
}
```
```powershell
> dotnet run
1
```

### Parcourir un tableau à 2 dimensions

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[,] arr =
            {
                {1, 2, 3},
                {4, 5, 6}
            };

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
4
5
6
```

Même syntaxe que pour une dimension sinon une double boucle avec for.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[,] arr =
            {
                {1, 2, 3},
                {4, 5, 6}
            };

            for(int i = 0 ; i <= arr.GetUpperBound(0) ; i++)
                for(int j = 0 ; j <= arr.GetUpperBound(1) ; j++)
                    Console.WriteLine(arr[i,j]);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
4
5
6
```

Tant que `i` n'atteint pas `GetUpperBound(0)`, on a notre première dimension. Il faut utiliser `<=`. Idem pour la deuxième dimension sauf que c'est 1 `GetUpperBound(1)`.

Pour un simple parcours, utiliser la boucle foreach.

Pour de la modification, utiliser la boucle for.

Par exemple, si on veux tout remettre à 0 sans passer par une méthode toute faite.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[,] arr =
            {
                {1, 2, 3},
                {4, 5, 6}
            };

            for(int i = 0 ; i <= arr.GetUpperBound(0) ; i++)
                for(int j = 0 ; j <= arr.GetUpperBound(1) ; j++)
                    arr[i,j] = 0;
            
            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
0
0
0
0
0
0
```

## Tableau de tableaux

Annotation avec des doubles crochets.

```cs
int[][] arr = new int[2][];
```

Soit un tableau qui contient d'autres tableaux. On a 2 tableaux dans notre tableaux dont on ne connait pas la taille.

Initialiser les valeurs de chaque tableau.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[][] arr = new int[2][];

            arr[0] = new int[] {1, 2, 3};
            arr[1] = new int[] {4, 5, 6, 7};

            Console.WriteLine(arr[0][0]);

            // --------------------------------------

            foreach(var el in arr)
                Console.WriteLine(el);

            // --------------------------------------

            foreach(var subarray in arr)
                foreach(var element in subarray)
                    Console.WriteLine(element);

            // --------------------------------------

            for(int i = 0 ; i < arr.Length ; i++)
                for(int j = 0 ; j < arr[i].Length ; j++)
                    Console.WriteLine(arr[i][j]);
        }
    }
}
```
```powershell
> dotnet run
1
# --------------------------------------
System.Int32[]
System.Int32[]
# --------------------------------------
1
2
3
4
5
6
7
# --------------------------------------
1
2
3
4
5
6
7
```

L'avantage de CSharp, on peut avoir des tailles fixes différentes.

En c, cette syntaxe `arr[0][0]` permet d'afficher un tableau à deux dimensions mais en CSharp, c'est un tableau de tableau. 

Noté que chaque élément `el` contient un int codé sur 32 bits.

Pour un simple affichage, un foreach d'un foreach.

Pour faire de la modification, on utilise un for de for. Un parcours plus compliqué.

## 3 types de tableaux

```cs
/*
    Tableau unidimentionnel     : []
    Tableau multidimentionnel   : [,] [,,] [,,,,,,]
    Tableau de tableaux         : [][]
*/
```

En résumé,
+ `int[]` est un tableau à une dimension.
+ `int[,]` est un tableau à multiple dimensions.
+ `int[][]` est un tableau de tableaux.

Inutile de dire qu'on peut faire un tableau, de tableaux, de tableaux ...

Petite parenthèse pour dire que l'on peut faire également un tableau de tableau multidimentionnel.

## La classe Array

Elle contient méthodes et propriétés qu'on peut utilisé.

### La propriété MaxLength

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
    */
    class Program
    {
        static void Main(string[] args)
        {
            // int[] arr = new int[3];

            Console.WriteLine(Array.MaxLength);
        }
    }
}
```
```powershell
> dotnet run
2147483591
```

La taille possible d'un tableau en CSharp.

En terme d'architecture, notion numération et codage pour comprendre cette taille maximum.

### La propriété Rank

Pour connaître le nombre de dimension d'un tableau.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[,] arr1 = new int[3,2];
            Console.WriteLine(arr1.Rank);

            int[,,,] arr2 = new int[3,2,1,1];
            Console.WriteLine(arr2.Rank);
        }
    }
}
```
```powershell
> dotnet run
2
4
```

Toujours le nombre de virgule `,` + 1.

### La méthode Reverse

Permet d'inverser nos valeurs.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            foreach(var el in arr)
                Console.WriteLine(el);

            Array.Reverse(arr);

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
3
2
1
```

### La méthode Clear

Permet de remettre à zéro.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
                - Clear()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3};

            foreach(var el in arr)
                Console.WriteLine(el);

            Array.Clear(arr);

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
1
2
3
0
0
0
```

### La méthode Fill

Permet de remettre à zéro.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
                - Clear()
                - Fill()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[100];

            Array.Fill(arr, 5);

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
5
5
5
5
5
5
5
5
...
```

Pour rappel, on peut faire un tableau de n'importe quel type. Pour une chaîne, on passerait une chaîne de caractères dans la méthode Fill().

Quand on travaille avec des tableaux multidimentionnels, on a vu que tout était initialisé à **0**.

En revanche si on travaille avec un tableau de tableaux donc puisqu'on travaille avec des références, tout serra automatiquement initialisé à **NULL**.

```cs
// Tableau unidimentionnel     : []                 | Valeurs.
// Tableau multidimentionnel   : [,] [,,] [,,,,,,]  | Valeurs.
// Tableau de tableaux         : [][]               | Références.
```

### La méthode IndexOf et la méthode GetValue

`IndexOf` récupérer l'indice d'une valeur.
`GetValue` récupère la valeur.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
                - Clear()
                - Fill()
                - IndexOf()
                - GetValue()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3, 4, 5};

            Console.WriteLine(Array.IndexOf(arr, 4));

            Console.WriteLine(arr.GetValue(3));
        }
    }
}
```
```powershell
> dotnet run
3
4
```

Attention GetValue() est directement sur le tableau `arr` car ce n'est pas une méthode statique.

### La méthode Sort

Méthode statique.

Trie un tableau.

```cs
using System;

namespace App
{
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
                - Clear()
                - Fill()
                - IndexOf()
                - GetValue()
                - Sort()
    */
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {2, 3, 4, 6, 1, 0};

            foreach(var el in arr)
                Console.WriteLine(el);

            Array.Sort(arr);

            foreach(var el in arr)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
2
3
4
6
1
0
# ----------------
0
1
2
3
4
6
```

Tri sur des entier donc pas besoin de définir des tri particulier.

### La méthode Copy

Méthode statique (sur Array).

Copier un tableau de départ sur un tableau de destination.

```cs
    /*
        Tableau unidimentionnel     : []
        Tableau multidimentionnel   : [,] [,,] [,,,,,,]
        Tableau de tableaux         : [][]

        Classe > Array
            Propriétés :
                - Length
                - MaxLength
                - Rank
            Méthodes :
                - GetUpperBound()
                - Reverse()
                - Clear()
                - Fill()
                - IndexOf()
                - GetValue()
                - Sort()
                - Copy()
    */


Array.Copy(arr, arr2);
Array.Copy(arr, arr2, 3);
```

Un troisième argument pour copier que les 3 premiers éléments.

Ici on peut le faire et dire qu'on affecte que les 3 première valeurs et le reste initialisé à 0.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {2, 3, 4, 6, 1, 0};
            int[] arr2 = new int[5];

            Array.Copy(arr, arr2, 3);

            foreach(var el in arr2)
                Console.WriteLine(el);
        }
    }
}
```
```powershell
> dotnet run
2
3
4
0
0
```

Attention manipuler les tableaux peuvent conduire à des erreurs comme rechercher l'index d'une valeur qui n'existe pas, on récupérer une valeur d'un indice qui n'existe pas... et cetera. Cela peut déclencher des erreurs.

On verra comment gérer les erreurs en CSharp la prochaine fois.

Á bientôt