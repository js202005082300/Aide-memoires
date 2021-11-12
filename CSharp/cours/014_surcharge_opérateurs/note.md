# [14. Surcharge d'opérateurs](https://www.youtube.com/watch?v=kkKEDdZHqqU)

Ceci est la 14e séance en CSharp afin de parler de surcharge d'opérateurs.

La surcharge d'opérateur va nous permettre à partir d'une classe que nous allons écrire de pouvoir utiliser les opérateurs qu'on a vu en début de formation.

Prenons un cas typique avec 2 variables quelconques sur lequel on va utiliser un opérateur d'addition pour afficher la somme de ces 2 nombres.

```cs
using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 14;
            int b = 23;

            Console.WriteLine(a + b);
        }
    }
}
```
```powershell
> dotnet run
37
```

Voilà on obtient le résultat de cette addition sans aucun problème.

Ainsi nous pouvons utiliser chacun des opérateurs que nous avons vu, ça commence par l'opérateur d'affectation (=), les opérateurs arithmétiques, les opérateurs de comparaison, les opérateurs binaires, les opérateurs unaires par exemple en faisant la négation de quelque chose avec un booléen et un c'est tous ces opérateurs vont fonctionner sans problème.

Maintenant que vous savez comment créer des classes, on pourrait faire la même chose sur un type de données que nous avons créé, par exemple on va faire une classe pour représenter une armure en mode public dans lequel on va utiliser un constructeur avec des valeurs par défaut `int defense = 250` ou encore `int durability = 100` et ensuite on créera 2 propriétés pour affecter `this.Defense` et `this.Durability`.

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();

            Console.WriteLine($"{ar.Defense} DEF / {ar.Durability} de durabilité");
        }
    }
}
```
```powershell
> dotnet run
250 DEF / 100 de durabilité
```

On compile, rien de nouveau, on appelle notre constructeur qui prend les valeurs par défaut.

Et si on indique autre chose on aura les valeurs affectées sans problème.

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor(100, 50);

            Console.WriteLine($"{ar.Defense} DEF / {ar.Durability} de durabilité");
        }
    }
}
```
```powershell
> dotnet run
100 DEF / 50 de durabilité
```

Maintenant, on va créer des opérations arithmétiques avec ces armures.

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();
            Console.WriteLine($"{ar.Defense} DEF / {ar.Durability} de durabilité");

            Armor ar2 = new Armor(85, 130);
            Console.WriteLine($"{ar2.Defense} DEF / {ar2.Durability} de durabilité");
        }
    }
}
```
```powershell
> dotnet run
250 DEF / 100 de durabilité
85 DEF / 130 de durabilité
```

Idem sauf qu'on affiche les propriétés d'un autre objet.

Ici on a nos deux armures dont on affiche les propriétés, et j'aimerais créer une tierce armure beaucoup plus résistante `big` qui soit la somme des deux armures.

Attention, on ne peux pas appliquer les opérateurs (+) aux opérandes de type Armor car on a un opérateur binaire qui attend deux opérandes sans pouvoir faire l'addition comme on le ferais avec des entiers, des réels, des booléens.

## Que signifie additionner une armure avec une autre

On doit définir cette règle et surcharger un opérateur qui est concerné par l'opération que l'on veut.

La surcharge et la redéfinition est ce que nous avons commencé a abordé avec l'héritage et qui nous suivra pendant 3/4 séances.

On surcharge cette opérateur + que l'on commence par déclarer `public static`, static parce qu'on ne veut pas que ce soit lié à l'objet lui-même donc c'est un élément static. Cette méthode va nous renvoyer un nouvel objet donc on met `Armor` puis on précise l'opérateur `operateur +` et entre parenthèse, les paramètres qu'il nous faut `(Armor A, Armor B)`.

```cs
public static Armor operator +(Armor a, Armor B)
{}
```

On garde ce format-là, plustôt qu'un corps d'expression, pour que ce soit plus lisible.

On indique la règle pour surcharger cette opérateur +, et on renvoie une nouvelle instance Armor().

```cs
public static Armor operator +(Armor a, Armor B)
{
    return new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
}
```

ou

```cs
public static Armor operator +(Armor a, Armor B) => new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
```

On recompile.

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }

        public static Armor operator +(Armor a, Armor b)
        {
            return new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();
            Console.WriteLine($"{ar.Defense} DEF / {ar.Durability} de durabilité");

            Armor ar2 = new Armor(85, 130);
            Console.WriteLine($"{ar2.Defense} DEF / {ar2.Durability} de durabilité");
            
            Armor big = ar + ar2;
            Console.WriteLine($"{big.Defense} DEF / {big.Durability} de durabilité");
        }
    }
}
```
```powershell
> dotnet run
250 DEF / 100 de durabilité
85 DEF / 130 de durabilité 
335 DEF / 230 de durabilité
```

Cette opération est maintenant reconnaissable par le compilateur en rendant cette opération binaire parcequ'on attend deux opérandes en paramètres.

Noté qu'on a le + implicite lorsqu'on affecte une variable : `int a = +145;` implicitement, à l'opposé de la forme négative `int a = -145;`.

Si on voulait maintenant redéfinir + en tant qu'opérateur unaire, on ferais comme ceci et dire qu'on aurais qu'une seule opérande à passer.

```cs
public static Armor operator +(Armor a)
{}
```

Mais ici on a pas besoin de surcharger le simple opérateur unaire + donc on ne le fait pas.

Après il suffit de se renseigner pour savoir qu'elles sont les opérateurs surchargeable ou non.

Noté que les opérateurs unaires, on a :

```cs
/*
    +a
    -a
    true
    false
    ++a
    --a
*/
```

Et on peut bien évidemment surcharger ces opérateurs binaire :

```cs
/*
    a + b
    a - b
    a << b
    ...
*/
```

## Surcharge implicite

Maintenant on a des surcharges implicites, par exemple, `big += ar;` donc pas besoin de le surcharger, le résultat sera implicite car implicitement en surchargeant l'opérateur +, l'opérateur += est également surchargé.

```cs
big += ar; // big = big + ar;
```

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }

        public static Armor operator +(Armor a, Armor b)
        {
            return new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();
            Console.WriteLine($"{ar.Defense} DEF / {ar.Durability} de durabilité");

            Armor ar2 = new Armor(85, 130);
            Console.WriteLine($"{ar2.Defense} DEF / {ar2.Durability} de durabilité");
            
            Armor big = ar + ar2;
            Console.WriteLine($"{big.Defense} DEF / {big.Durability} de durabilité");

            big += ar; // big = big + ar;
            Console.WriteLine($"{big.Defense} DEF / {big.Durability} de durabilité");
        }
    }
}
```
```powershell
> dotnet run
250 DEF / 100 de durabilité
85 DEF / 130 de durabilité
335 DEF / 230 de durabilité
585 DEF / 330 de durabilité  
```

Pas besoin de surcharger cette opérateur +=

On ne peut pas surcharger les opérateurs de comparaison :

```cs
/*
    && //
*/
```

On ne peut pas surcharger les opérateur avec des mots clés qu'on vera plus tard :

```cs
/*
    delegate
    typeof
*/
```

Attention ce sont bien des opérateurs et non des fonctions, et ne sont pas surchargeable.

On peut également surchargé l'opérateur d'égalité == et strictement inférieur à

```cs
/*
    ==
    <
*/
```

Maintenant on va voir que pour true ça suit une règle assez spécifique.

## Surcharge par pair

Pour une armure, on va déterminer quand est-ce que l'armure est vraie.

```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }

        public static Armor operator +(Armor a, Armor b)
        {
            return new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();

            if(ar)
                Console.WriteLine("Oui !");
            else
                Console.WriteLine("Non...");
        }
    }
}
```
```powershell
> dotnet run
Base.cs(28,16): error CS0029: Impossible de convertir implicitement le type 'App.Armor' en 'bool' [C:\.\Mementos\CSharp\cours\FirstApp\FirstApp.csproj]     

La build a échoué. Corrigez les erreurs de la build et réexécutez-la. 
```

Ainsi certains langages pourrait considérer que dès lors qu'il y a un objet qui est déclaré, une donnée qui est déclarée est considéré comme vrai parce qu'on considère que son existence est vraie.


Voilà dans certains langages ça fonctionnerait en faisant ce genre de test, comme l'objet `ar` n'est pas une valeur particulière telle que nul, 0, antislash 0 et cetera (cela dépend des langages) Eh bien en faisant ce genre de code, condition, ça pourrait fonctionner.

Le compilateur CSharp vous fait comprendre encore une fois qu’il ne peut pas convertir implicitement le type Armor en booléen donc on va devoir préciser ce que ça veut dire quand tu es une armure est vrai parce qu'il y a ambiguïté, et donc que signifie également quand une armure est fausse parce que ça fonctionne par pair.

C'est là qu'il y a une petite différence parce que si vous surcharger l'opérateur true, il faudra également surcharger l'opérateur false.

De même si vous surcharger l'opérateur d'égalité ==, il faudra surcharger dans la foulée l'opérateur d'inégalités.

Pareil pour < et > et cetera.

```cs
/*
    ==  !=
    <   >
    <=  >=
*/
```

Voilà il y a des opérateurs qui fonctionnent par paire.

On surcharge true qui n'a besoin que d'un seul élément car c'est un opérateur unaire et on choisi ce qu'on considère de vrai pour un type d'armure, qui a au moins 100 de défense.

```cs
public static bool operator true(Armor a) => a.Defense >= 100;
```

Maintenant surcharger l'opérateur false sinon le message d'erreur :

```powershell
Base.cs(21,37): error CS0216: L'opérateur 'Armor.operator true(Armor)' exige qu'un opérateur correspondant 'false' soit aussi défini
```

On surcharge les deux opérateur unaire true et false.

```cs
public static bool operator true(Armor a) => a.Defense >= 100;
public static bool operator false(Armor a) => a.Defense < 100;
```
```cs
using System;

namespace App
{   
    public class Armor
    {
        public int Defense { get; set; }    
        public int Durability { get; set; }

        public Armor(int defense = 250, int durability = 100)
        {
            this.Defense = defense;
            this.Durability = durability;
        }

        public static Armor operator +(Armor a, Armor b)
        {
            return new Armor(a.Defense + b.Defense, a.Durability + b.Durability);
        }

        public static bool operator true(Armor a) => a.Defense >= 100;
        public static bool operator false(Armor a) => a.Defense < 100;
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Armor ar = new Armor();

            if(ar)
                Console.WriteLine("Oui !");
            else
                Console.WriteLine("Non...");
        }
    }
}
```
```powershell
> dotnet run
Oui !
```

On a bien une valeur par défaut supérieur à 100 mais maintenant si je change la valeur par 80 :

```cs
//...
Armor ar = new Armor(80);
//...
```
```powershell
> dotnet run
Non...
```

Voilà il faut déterminer les règles pour notre classe et enfin surcharger nos opérateurs.

Ciao tout le monde