# [3. Types de données](https://www.youtube.com/watch?v=T4D2a2gbxYc)

>  

+ [Types de données](https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/C%23/types-donnees.md)

> [CSharp #3 - types de données](https://www.youtube.com/watch?v=T4D2a2gbxYc)

_Tous les types en C# (référence, valeur, ...) héritent de la classe **Object**_

|Type|Alias .NET|Place en mémoire|Fourchette de valeurs|
|:--:|:--|:--:|:--:|
|sbyte|System.SByte|1 octet|-128 à 127|
|short|System.Int16|2 octets|-32_768 à 32_767|
|int|System.Int32|4 octets|-2_147_483_648 à 2_147_483_647|
|long|System.Int64|8 octets|-9_223_372_036_854_775_808 à 9_223_372_036_854_775_807|
|byte|System.Byte|1 octet|0 à 255|
|ushort|System.UInt16|2 octets|0 à 65_535|
|uint|System.UInt16|4 octets|0 à 4_294_967_295|
|ulong|System.UInt16|8 octets|0 à 18_446_744_073_709_551_615|

---

|Type|Alias .NET|Place en mémoire|Fourchette de valeurs|
|:--:|:--|:--:|:--:|
|char|System.Char|2 octets|U+0000 à U+FFFF|

---

|Type|Alias .NET|Place en mémoire|Fourchette de valeurs|
|:--:|:--|:--:|:--:|
|bool|System.Bool|1 octet|false (0) ou true (1)|

---

|Type|Alias .NET|Place en mémoire|Fourchette de valeurs|
|:--:|:--|:--:|:--:|
|float|System.Single|4 octets|±1,5.10<sup>−45</sup> à ±3,4.10<sup>38</sup> (~6 à 9 chiffres significatifs)|
|double|System.Double|8 octets|±5,0.10<sup>−324</sup> à ±1,7.10<sup>308</sup> (~15 à 17 chiffres significatifs)|
|decimal|System.Decimal|16 octets|±1,0.10<sup>-28</sup> à ±7,9228.10<sup>28</sup> (28 à 29 chiffres signficatifs)|

---

|Type|Alias .NET|Place en mémoire|Fourchette de valeurs|
|:--:|:--|:--:|:--:|
|string|System.String|-|caractères Unicode|

>  

Par exemple, si un jour on travaille dans la finance, monaitaire, on utilise ce type-là.

+ App.cs
```cs
using System;

class App
{
    static void Main(string[] args)
    {
        decimal myMoney = //...
    }
}
```

Idem avec l'alias Dot Net avec l'espace de nom, l'environnement System et une classe Decimal pour représenter un type de données.

+ App.cs
```cs
using System;

class App
{
    static void Main(string[] args)
    {
        System.Decimal myMoney = //...
    }
}
```

Comme `System.Decimal` est un peu long comme alias, on utilise le terme natif `Decimal`.

Parmi les types, par exemple *sbyte* occupe 1 octet c'est-à-dire 8 bits en mémoire pour stocker un nombre entre -128 et 127.

Pour les valeurs monaitaire, le type *decimal*, le plus grand et le plus précis des nombres flotant avec 29 chiffres significatifs pour être très précis.

Le type *booléen* comme le système de courant dans nos transistors avec la valeur 1 (vrai) et 0 (faux) où le courant ne passe plus.

Le type *short*, *int*, *long*, *byte* et leur version non-signé *ushort*, *uint*, *ulong*, et cetera.

2 catégories de type tel que les *types-valeurs* où on stocke une valeur dans un type de donnée mais si un jour on veux changer cette valeur (on verra avec les variables) ça va créer une copie. On va faire une copie pour acceuillir cette nouvelle valeur obtenue.

Ensuite on a les *types-références* tel que le type *string*, on a la donnée dans laquel on stocke la référence à quelque chose. Ainsi on peut avoir plusieurs données différentes qui font référence à la même information, dans ce cas si on change une des variables, on va évideemment modifier ailleurs. Il n'y a pas de copie, c'est ainsi plus économe en manipulation.

Ainsi les *types-références* font référence et ne vont donc pas éffectuer de copie à chaque fois.