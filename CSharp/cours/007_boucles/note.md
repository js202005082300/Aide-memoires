# [7. Boucles](https://www.youtube.com/watch?v=1-Gnxzr5Neo)

Utiliser une variable pour éviter les répétitions.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OK";

        Console.WriteLine(word);
        Console.WriteLine(word);
        Console.WriteLine(word);
        Console.WriteLine(word);
        Console.WriteLine(word);
    }
}
```
```powershell
dotnet new console -o FirstApp
cd .\FirstApp\
dotnet build
dotnet run   
OK
OK
OK
OK
OK
```

Répétition d'instructions à éviter !

## while

Utiliser des variables explicites tel que le nom de la class *Program* qu'on changera pour rendre les choses explicites mais par convention on utilise un compteur i, j, k, l.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OK";
        int i = 0;

        while(i < 5)//Point d'arrêt : i >= 5
        {
            Console.WriteLine(word);
            i++;
        }
    }
}
```
```powershell
dotnet run   
OK
OK
OK
OK
OK
```

Notre boucle a 5 itérations.

Notre point d'arrêt est `i >= 5` qui est l'inverse de la condition à vérifier.

## do while

Au moins une itération.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OK";
        int i = 5;

        do
        {
            Console.WriteLine(word);
        }
        while(i < 5);
    }
}
```
```powershell
dotnet run   
OK
```

## break

Interrompt la boucle.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OK";
        int i = 0;

        while(i < 10)
        {
            Console.WriteLine(word);

            if(i == 6)
                break;

            i++;
        }
    }
}
```
```powershell
dotnet run     
OK
OK
OK
OK
OK
OK
OK
```

## continue

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OKI";
        int i = 0;

        while(i < 10)
        {
            i++;
            Console.WriteLine(word);

            if(i == 6)
                continue;

            Console.WriteLine("DOKI);
        }
    }
}
```
```powershell
dotnet run     
OKI
DOKI
OKI
DOKI
OKI
DOKI
OKI
DOKI
OKI
DOKI
OKI
OKI
DOKI
OKI
DOKI
OKI
DOKI
OKI
DOKI
```

Si `i == 6`, on recommence la boucle et ce qui suit n'est pas exécuté.

## for

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string word = "OKI";
        int i = 0;

        for(i = 0 ; i < 10 ; i++)
            Console.WriteLine(word);
    }
}
```
```powershell
dotnet run     
OKI
OKI
OKI
OKI
OKI
OKI
OKI
OKI
OKI
OKI
```

Si i n'est utilisé que par la boucle, on l'initialise dans le `for(int i;;)`. Si i est incrémenté ou décrémenté, `i++` ou `++i` si on veut que ce soit un peu plus performant.

## foreach

Prend une donnée et pour chaque partie qu'on veut extraire, on va pouvoir y éffectuer un certain nombre d'instructions.

Parcourir une chaîne, une structure, un fichier et cetera.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        string name = "Jason";

        foreach(char letter in name)
        {
            Console.Write(letter);
        }
    }
}
```
```powershell
dotnet run     
Jason
```

Le cas d'arrêt c'est quand on arrivera à la fin du parcours de name.

`char letter` est une variable temporaire qui n'existe que dans l'environnement de la boucle foreach() en lecture seule donc on ne peut pas la modifier.

On ne peut pas modifier un article de la liste de course par exemple.

```cs
using System;

class Program
{
    static void Main(string[] args)
    {
        //Liste mes_courses = [bananes, eau, boeuf];

        foreach(string article in mes_courses)
        {
            Console.Write(article);
        }
    }
}
```

