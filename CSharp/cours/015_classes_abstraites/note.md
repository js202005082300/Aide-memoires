# [15. Classes abstraites](https://www.youtube.com/watch?v=WUtyBlkr6UA)

Pour les 2 prochaines séances nous allons voir 2 concepts très importants pour la programmation c'est à dire les classes abstraites pour cette vidéo et par la suite nous parlerons des interfaces.

Au cours des 3 prochaines vidéos nous allons apprendre à faire la différence entre les classes abstraites et les interfaces, dans quel cas et tu les as plutôt là ou plutôt l'autre et on verra également tout ce qui est attrait au polymorphisme et voir comment ça s'utilise dans un cas concret.

On va passer sur du code pour voir comment fonctionne une classe abstraite.

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

Auparavant nous avons déjà parlé de classe, de création de classe et d'héritage, et maintenant la classe abstraite est tout simplement une classe que nous allons définir et qui contiendra tout simplement au minimum, au moins une méthode abstraite.

Une méthode abstraite est une méthode dont on ne va pas écrire l'implémentation, on ne va pas écrire le code de cette méthode mais on va noter juste sa signature.

On va écrire une méthode abstraite, une méthode de base par exemple pour des consommables qu'on aurait par exemple dans un jeu vidéo que l'on déclare au départ avec le mot-clé `abstract` pour dire qu'elle est abstraite. Et le minimum pour avoir une classe abstraite, est d'avoir une méthode abstraite aussi SellToMerchant().

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public abstract void SellToMerchant();
    }

    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
```

Cette méthode se termine directement par un ; et non pas des accolades avec du code à l'intérieur donc on a ici une méthode abstraite et comme cette classe en contient au moins une, c'est une classe qui devient directement abstraite.

Ce qui est important à savoir c'est que cette classe abstraite ne va pas devoir être instancié c'est à dire que je ne vais pas m'amuser à déclarer un élément comme `Consumable` Donc par exemple si j'essaie de faire ceci `Consumable cm = new Consumable();` dans la fonction Main(), ça ne marchera pas sachant qu'en plus il n'y a même pas de constructeur (voir un destructeur) dans ma classe Consumable Donc pour autant je ne pourrai pas instancier cette classe, et ce n'est de toute façon pas son but.

Dans quelle classe je pourrais instancier cette classe abstraite

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public abstract void SellToMerchant();
    }

    class Program
    {
        static void Main(string[] args)
        {
            //Consumable cm = new Consumable();
        }
    }
}
```

Alors dans quel cas utiliser une classe abstraite ? On va l'utiliser pour représenter le comportement de base d'un ensemble d'autres classes. On avait parlé d'héritage c'est à dire qu'on peut avoir une classe parente ensuite on avait une classe fille qui héritent de la classe parente.

Par exemple une classe parente Animal et ensuite une classe enfant appelée Tiger pour dire qu'un tigre serait une sorte d'animal donc qui hérite de toutes les informations de Animal Avec éventuellement des informations supplémentaires parce qu'il est spécialisé.

Dans le cadre de classes abstraites, quand on va avoir un comportement qui va être commun a plusieurs classes parce qu'on peut dire qu'en tigre va partager plusieurs comportements communs avec un dauphin et un chien et avec n'importe quel autre animal. Ainsi on aimerait avoir notre classe de base sans pour Autant dire qu'on va créer un animal parce que ce serait justement trop abstrait c'est à dire qu'on ne veut pas créer un animal de manière vague parce que ça ne veut pas dire grand-chose donc on veut avoir quelque chose de concret mais qui représente quand même les comportements en commun donc c'est à ça que va pouvoir servir l'utilisation d'une classe abstraite. Je fait ceci.

```cs
abstract class Consumable
{
    public abstract void SellToMerchant();
}
```

Je fais ceci mais je peux également avoir dans une classe abstraite des méthodes qui sont implémentées parce que je vous dis qu'il faut au minimum une classe abstraite donc rien ne m'empêche décrire une autre méthode Print() par exemple pour afficher différents éléments.

```cs
abstract class Consumable
{
    public abstract void SellToMerchant();

    public void Print()
    {

    }
}
```

Voilà donc on a au minimum une classe qui est abstraite pour vraiment se contenter de l'essentiel pour la vidéo.

Évidemment cette classe ne va pas être statique `static` même si on ne va pas l'instancier, on ne fera pas de classe statique qui est abstraite et vous allez comprendre pourquoi par rapport à l'usage que l'on va faire de cette classe.

Maintenant ce qui est intéressant à comprendre c'est que lorsqu'on a une classe concrète derrière qui va hériter de notre classe abstraite `class MagicalBook : Consumable` avec un exemple pour un grimoire magique qui est un consommable.

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public abstract void SellToMerchant();
    }

    class MagicalBook : Consumable
    {

    }

    class Program
    {
        static void Main(string[] args)
        {
            //Consumable cm = new Consumable();
        }
    }
}
```

Et à partir de là les éléments qui sont abstraits vont devoir être implémentés puisque nous avons pas de corps à notre méthode abstraite SellToMerchant(), nous allons devoir l'implémenter dans la classe MagicalBook.

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public abstract void SellToMerchant();
    }

    class MagicalBook : Consumable
    {
        public abstract void SellToMerchant()
        {

        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            //Consumable cm = new Consumable();
        }
    }
}
```

C'est dans la classe MagicalBook, comment indiquer à cette méthode abstraite quel comportement adopter.

Si maintenant nous voulons garder un comportement commun par exemple si on avait un autre objet qui serait un consommable tel qu’un sandwich et qu'on veut considérer que l'ensemble de nos objets vont avoir un comportement en commun Eh bien c'est là tout l'intérêt dans une classe abstraite de pouvoir implémenter certaines méthodes c'est à dire que si tous peuvent vendre de la même manière Eh bien on fera l'implémentation dans la classe abstraite.

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public /*abstract*/ void SellToMerchant()
        {
            // code
        }
    }

    class MagicalBook : Consumable
    {
    }

    class Sandwich : Consumable
    {
    }

    class Program
    {
        static void Main(string[] args)
        {
            //Consumable cm = new Consumable();
        }
    }
}
```

Tout ce qui sera implémenté dans la classe abstraite, sera hérité pour les classes MagicalBook et Sandwich Mais si maintenant on a besoin d'avoir des éléments qui vont dépendre de la classe concrète que l'on a. Eh bien ça revient à dire qu'on va avoir quelque chose d’abstrait. Ainsi par exemple on va dire que on va pouvoir le vendre de la même manière pour chacun des consommables avec la méthode SellToMerchant mais qu'on va les acheter de manière différente et va donc dépendre de l'objet que l'on a et va donc dépendre de l'implémentation pour chaque classe. Ainsi on va imposer l'implémentation de BuyToMarket() pour chaque classe que l'on a.

```cs
using System;

namespace App
{
    abstract class Consumable
    {
        public void SellToMerchant()
        {
            Console.WriteLine("Je vends au marchand...");
        }

        public abstract void BuyToMarket();
    }

    class MagicalBook : Consumable
    {
        public override void BuyToMarket()
        {
            Console.WriteLine("J'achète auprès d'un Magicien");
        }
    }

    class Sandwich : Consumable
    {
        public override void BuyToMarket()
        {
            Console.WriteLine("J'achète sur le marché de fournitures");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Sandwich s = new Sandwich();
            MagicalBook m = new MagicalBook();

            s.BuyToMarket();
            m.BuyToMarket();

            s.SellToMerchant();
            m.SellToMerchant();
        }
    }
}
```
```powershell
> dotnet run
J'achète sur le marché de fournitures
J'achète auprès d'un Magicien
Je vends au marchand...
Je vends au marchand...
```

Le but bien sûr est de ne pas avoir de répétition de code donc le comportement de l'achat sur un sandwich ne sera pas la même chose pour un grimoire magique, et en revanche la vente comme c'est quelque chose qui est en commun, qui sera fait de la même manière peu importe l'objet, sera implémentée directement dans notre classe abstraite et on pourra bien sûr utiliser cette méthode pour MagicalBook et Sandwich.

C'est donc là tout l'intérêt parce qu'on peut mais les à la fois les méthodes qui sont implémentées et les méthodes qui ne le sont pas donc les méthodes abstraites il en faut au moins une pour pouvoir avoir une classe abstraite et à partir de là vous avez compris un peu le principe.

Évidemment par défaut les éléments sont privés, on a accès si l'élément est public mais si on ne met rien ce sera privé par défaut donc à vous d'adapter en fonction de ce que vous voulez faire.

:warning: Bien indiqué `override` pour dire qu'on va surcharger cette méthode donc on va réécrire cette méthode. On met `abstract` et plus loin `override` si il y a une implémentation à faire.

```powershell
> dotnet run
J'achète sur le marché de fournitures
J'achète auprès d'un Magicien
Je vends au marchand...
Je vends au marchand...
```

On constate que l'achat ne se fait pas de la même manière suivant le cas donc c'est propre à l'implémentation qu'on a écrite, qu’on a implémenté dans chaque classe de manière concrète.

Tandis qu'on observe le même comportement pour les 2 objets pour la vente.

Voilà le principe de la classe abstraite, on a une classe de base qui va servir pour plein d'autres classes et qui va contenir tous les comportements en commun (avantage) et ensuite ce qui va vraiment être propre à chacune, on en fait des méthodes abstraites `abstract` et on devra obligatoirement les implémenter `override`.

Si j'oublie de faire une implémentation, le compilateur ne sera pas content. C’est obligatoire, un élément abstrait doit obligatoirement être implémenté donc ça donne une garantie que si on fait hériter une classe de notre classe abstraite Consumable, elle devrait implémenter tout ce qui est abstrait ici.

```cs
abstract class Consumable
{
    public void SellToMarchant()
    {
        Console.WriteLine("Je vends au marchand...");
    }

    public abstract void BuyToMarket();
    public abstract bool IsTradable();
}
```

Ici toutes les classes abstraites devons obligatoirement être implémentée dans chacune des classes concrètes (2 classes dans notre cas).

Il y aura encore d'autres choses à vous montrer concernant notamment ce qui va venir par la suite avec les interfaces c'est-à-dire qu'on peut utiliser les classes avec les interfaces, ce n'est pas forcément l'un qui va remplacer l'autre et inversement mais comme on les a pas encore vu ce sera le sujet de la prochaine vidéo et on verra leur usage avec les classes abstraites par la suite.

Donc ici on va vraiment avoir une identité base pour notre classe qu'on va représenter avec une classe abstraite Qui ne va pas être instanciée c'est à dire que vous voyez que dans Main(), on instancie pas la classe abstraite c'est à dire qu'on fait de l’instanciation uniquement avec les classes concrètes par contre on gagne vachement du temps et on peut avoir un comportement commun pour toutes les classes concrètes. C'est là tout l'intérêt de ce système là et on comprendra pourquoi est-ce qu'on s'en sert lorsqu'on abordera le polymorphisme.

Voilà on a fait le tour donc à bientôt pour la prochaine séance, et on aura donc vu une base qui nous amènera beaucoup de possibilités et de fonctionnalités derrière qu'on utilisera en programmation donc ce sont des notions à bien assimiler et à bien comprendre.

À bientôt pour la prochaine soirée on parlera des interfaces