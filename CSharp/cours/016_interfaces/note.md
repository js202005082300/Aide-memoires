# [16. Interfaces](https://www.youtube.com/watch?v=VtNvfpkFXYA)

Les interfaces est une notion très importante avec les classes abstraites pour comprendre plus tard ce qu'est le polymorphisme.

Passons au code.

```cs
using System;

namespace App
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

Rappelons que la classe abstraite était utilisée pour représenter une identité de base, un comportement commun, un ensemble d'autres classes qui vont pouvoir en hériter, qui auront et partageront ce comportement commun ils vont ensuite elle-même implémenter leur propre comportement c'est à dire les fameuses méthodes abstraites qu'on avait dans la classe écrite est déclarée abstraite `abstract`.

Une interface va fonctionner différemment, bien qu'on soit parfois amené à ne pas arriver à les différencier dans la mesure où certains langages ne disposent pas de système d'interface c'est à dire que des personnes vont être obligées d'utiliser des classes abstraites alors que dans d'autres langages on utilisera les interfaces. Voilà ce qui a tendance à créer la confusion pour les gens qui apprennent la programmation. 

Alors quand est ce que je dois utiliser une interface et quand est ce que je dois utiliser une classe abstraite ?

Là ou la classe abstraite va représenter un comportement commun, une identité commune qu'on a pour plusieurs classes, l'interface va représenter un contrat.

Le terme de **contrat** est un mot qu'on emploie souvent Mais alors pourquoi un contrat ? Pour qui ? pourquoi ? et comment ça fonctionne ?

Voyons comment ça fonctionne.

```cs
using System;

namespace App
{
    interface //....
    
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

## interface

Utilisation du mot clé `interface` et on va le représenter par convention par `I` majuscule suivie du nom que l'on veut Et pour un terme pression utilisera également une majuscule, par exemple `ISome` mais ce n'est pas obligatoire on peut aussi très bien commencer par n'importe quel nom commençant par une majuscule `interface Some`.

Contrairement aux classes abstraites, l'interface ne concerne pas des classes qui auraient un comportement commun c'est à dire qu'on peut avoir une interface qui est utilisé par des classes complètement différentes, qui ne partage aucun comportement similaire et c’est là tout l'intérêt des interfaces.

Alors reprenons l'exemple de la dernière fois avec les objets consommables.

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

On avait vu l'exemple des consommables avec le livre magique et les sandwichs que l'on peut consommer dans un jeu vidéo, un jeu de rôle où on aurait des objets qui auraient un comportement commun donc on avait compris que l'usage de la classe abstraite était tout à fait bienvenu à ce moment-là.

Maintenant si je veux dans mon jeu vidéo avoir la possibilité d'échanger des éléments, avoir quelque chose pour pouvoir échanger des éléments tel qu'on pourrait vouloir déjà échanger les consommables ce qui paraît logique mais on devrait pouvoir également échanger d'autres choses par exemple si on parle d'un système d'armement, un système d'équipement où on donnerait la possibilité que certains de ces équipements soient échangeables.

On peut également imaginer une interface en ligne dans lequel on pourrait échanger des véhicules, des armes de combat, des montures et cetera. Et à partir de là on commence à s'égarer parce que pour les consommables on comprenait bien, que pour rendre échangeable des livres magiques, des sandwichs, ça ne pose pas de problème parce qu'on retrouve un comportement commun puisque ce sont tous les 2 des consommables donc il y a quelque chose qui est en commun.

En revanche consommer une monture ou un familier donc là on est sur quelque chose de différent, et si on commence à consommer une épée, un bouclier ou une armure en cuir, ce n'est pas pareil parce que ce n'est pas très bon pour comme repas ! :p

Alors cette histoire de pouvoir rendre échangeable, est une capacité que je veux pouvoir rendre disponible via cette interface qui va définir un contrat.

On y va, `ITradable` qui rend la possibilité de rendre quelque chose échangeable.

```cs
using System;

namespace App
{
    interface ITradable
    {

    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

Alors ici on ne va pas s’embêter avec des modificateurs d'accès `private` ou `public` parce qu'**une interface c'est public, c'est un contrat, qui indique tout ce qui est public et c'est à dire tout ce que devra remplir une classe qui va implémenter cette interface**.

Dans le cas de l'héritage on dit qu'une classe étant une autre classe, on parle de `extend` et dans une interface on dit qu'une classe va pouvoir implémenter une interface.

```cs
interface ITradable
{

}
```

À partir d'ici on va pouvoir indiquer directement des éléments qui sont publics, dans tous les cas donc je ne vais même pas m'embêter à marquer le mot clé `public` écrire des méthodes directement, des méthodes qui seront forcément abstraites. *Pareil comme tout est automatiquement abstrait, il n'y a pas d'implémentation dans une interface* et donc pas besoin d'utiliser le mot clé `abstract` donc on va pouvoir raccourcir vachement les écritures.

Alors ici on met d'abord un type de retour par exemple sans aucun problème `void sell` donc ici en terme d'échange, on dira qu'un objet qui est échangeable peut être vendu, par exemple vendu à un marchand `void SellToMerchant();`.

```cs
interface ITradable
{
    void SellToMerchant(Item it);
}
```

On pourrait mettre un format d'objet sur lequel on pourrait travailler `Item it` mais comme on n'a pas cette classe existante, je ne met pas ce paramètre et bien sûr dans un vrai exemple, on aurait quelque chose d'un peu plus complet.

Ici on va faire au plus simple sans le paramètre `Item` pour comprendre le principe. 

Ensuite on peut avoir comme ça plusieurs éléments, et dire que À partir du moment où notre objet avec l’interface ITradable, a la capacité d'être échangeable c'est-à-dire que la classe en question qui va devoir implémenter cette interface et remplir son contrat.

```cs
using System;

namespace App
{
    interface ITradable
    {
        void SellToMerchant();
        void SellToAuctionHouse();
        void SellToPlayer();
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

Pour notre exemple nous allons créer une classe Consumable qui va devoir respecter le contrat de notre interface ITradable.

```cs
using System;

namespace App
{
    interface ITradable
    {
        void SellToMerchant();
        void SellToAuctionHouse();
        void SellToPlayer();
    }

    abstract class Consumable
    {
        public abstract void Print();
    }

    class Weapon : ITradable
    {

    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

On va prendre une arme, on est d'accord que c'est un objet tel quel par exemple et je peux dire tout simplement qu'il va irriter de mon interface donc j'écris tout simplement `class Weapon : ITradable{}` Et mon objet devient échangeable un peu comme s'il héritait d'une classe sauf qu'en réalité il va implémenter (et non hérité) de cette interface ITradable.

Automatiquement si on a fait `class Weapon : ITradable`, on va devoir implémenter toute cette interface.

```cs
interface ITradable
{
    void SellToMerchant();
    void SellToAuctionHouse();
    void SellToPlayer();
}
```

On va devoir implémenter tout ça c'est à dire qu'on ne va pas pouvoir avoir la moitié des éléments abstraits et d'autres avec une implémentation de faits.

Ainsi une interface comme tout est public, tout doit être abstrait c'est à dire qu'on aurait une classe dite abstraite pure c'est à dire une classe abstraire qui n'aurait que des membres abstraits.

Ici c'est le cas c'est à dire qu'on aurait pu mettre des `abstract` partout et même des `public abstract` :

```cs
interface ITradable
{
    public abstract void SellToMerchant();
    public abstract void SellToAuctionHouse();
    public abstract void SellToPlayer();
}
```

On aurait pu l'écrire comme ça pour chaque élément mais comme c'est par défaut pour une interface, on a raccourci les écritures à ce niveau-là donc je vais devoir implémenter obligatoirement ces 3 méthodes.

Maintenant si par exemple j'autorise l'échange mais pas la vente SellToAuctionHouse(), On va pouvoir l'implémenter bien qu'on parle ici plutôt d'échanges que de commerce, un système de négoce que l'on va pouvoir implémenter.

Sachez que même si on a l'obligation d'implémenter les 3 méthodes parce que c'est nécessaire c'est à dire que c'est la garantie fournie par cette interface qui encore une fois fait office de contrat et bien qu'on peut créer un système d'exception pour une des méthodes où indiquer un message qui empêcherait quoi qu'il arrive la vente mais dans tous les cas on est obligé d'implémenter cette méthode.

```cs
using System;

namespace App
{
    interface ITradable
    {
        void SellToMerchant();
        void SellToAuctionHouse();
        void SellToPlayer();
    }

    abstract class Consumable
    {
        public abstract void Print();
    }

    class Weapon : ITradable
    {
        void SellToMerchant()
        {
            //...
        }

        void SellToAuctionHouse()
        {
            //...
        }

        void SellToPlayer()
        {
            //...
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

On peut ensuite faire une autre classe MagicalBook qui est hérite de Consumable, et qui lui même si j'ai envie de le rendre échangeable, va implémenter l'interface ITradable.

```cs
using System;

namespace App
{
    interface ITradable
    {
        void SellToMerchant();
        void SellToAuctionHouse();
        void SellToPlayer();
    }

    abstract class Consumable
    {
        public abstract void Print();
    }

    class MagicalBook : Consumable, ITradable
    {
        public override void Print()
        {
            //...
        }

        void SellToMerchant()
        {
            //...
        }

        void SellToAuctionHouse()
        {
            //...
        }

        void SellToPlayer()
        {
            //...
        }
    }

    class Weapon : ITradable
    {
        void SellToMerchant()
        {
            //...
        }

        void SellToAuctionHouse()
        {
            //...
        }

        void SellToPlayer()
        {
            //...
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

Voilà on va pouvoir comme ça produire une sorte d'héritage multiple c'est à dire que là où on peut faire hériter une classe que d'une seule autre, on ne peut pas en fait faire hériter une classe de plusieurs autres classes. 

En revanche nous ne sommes pas limités au nombre d'interfaces c'est à dire que l'on peut très bien avoir une classe qui implémente plusieurs interfaces, ici je peux très bien en avoir qu'une seule mais je pourrais très bien en implémenter une 2e, une 3e, une 4e  interface et cetera en fonction des fonctionnalités que je veux intégrer.

Alors il faut noter que cette ligne `class MagicalBook : Consumable, ITradable` suffit à imposer l'implémentation De cette classe abstraite Consumable et de toutes les méthodes de cette interface ITradable.

Donc on doit commencer par écrire l'implémentation de la classe Consumable et je vais devoir implémenter toutes les classes dans mon interface.

Pour voir un petit peu la différence avec une classe abstraite, à l'aide d'une interface nous ne sommes plus dans un comportement commun c'est à dire qu'on a l'obligation d'implémenter tout ce que contient l'interface et c'est d'ailleurs plus lent à l'exécution si on voulait parler d'optimisation.

Évidemment les interfaces sont plus lentes que des classes abstraites puisqu ici il va falloir retrouver ce qui correspond à chaque élément que l'on a c'est à dire qu'en fonction des implémentations qui vont être faites, il faudra voir quelle méthode va être appelée par rapport à la classe qui utilise l'implémentation donc on aurait quelque chose de plus lent.

Ainsi pour les interfaces on a quelque chose d'obligatoire, on n'a pas de comportement commun.

On ne peut par exemple pas se dire que tout ce qui implémente ITradable va par exemple permettre la vente à un marchand de la même manière donc si vous voulez ce genre de possibilité il faudra utiliser une classe abstraite avec des éléments qui encore une fois ont une base commune sinon s'il n'y a pas de basse commune, ça ne sert à rien !

par exemple ce ne serait pas cohérent d'avoir une classe abstraite `abstract class Animal` Et ensuite imaginons que l'on fasse une classe qui hérite de Animal `class Tiger : Animal` Et maintenant si on fait `class Weapon : Animal` C'est à dire de dire qu'une arme hérite de Animal à moins que c'est ce que vous voulez faire dans votre jeu mais sinon ça ne marche pas c'est à dire que si on veut parler d'une arme telle qu'elle c'est à dire un équipement de combat Eh bien forcément l'héritage sera un peu bizarres et donc le comportement commun entre une épée et un tigre aura peut être le comportement commun de pouvoir tuer mais sinon en tant que tel on n'aurait pas grand chose à relier ensemble.

```cs
// abstract class Animal
// class Tiger : Animal
// class Weapon : Animal
```

Voilà on a un petit peu l'idée où dans quel cas on va travailler avec une classe abstraite et dans quel cas on va préférer une interface.

Sachez que pour l'interface vous allez devoir forcément tout écrire et tout implémenter, là où la classe abstraite, vous allez seulement écrire les éléments qui seront différents Et ce qui est commun vous allez pouvoir déjà l'implémenter dans la classe abstraite puisqu'il suffit juste d'avoir un seul élément abstrait pour être une classe abstraite (c'est ce que nous avions expliqué dans la vidéo précédente).

noir l'avantage ici c'est qu'on permet l'implémentation multiple, un petit peu comme si on faisait de l'héritage multiple puisque les interfaces ne sont pas limitées à 1 comme on l'a avec nos classes.

Ensuite comme les interfaces sont actives que l'on a en CSharp, on peut sans problème faire une interface qui va hérite d'une autre. Par exemple dire qu'on a des objets échangeables puis des objets échangeables entre différents serveurs :

```cs
interface ITradable
{
    void SellToMerchant();
    void SellToAuctionHouse();
    void SellToPlayer();
}

interface ITradableBetweenServers : ITradable
{
    void SellToNeighbour();
    
    void SellToMerchant(){}
    void SellToAuctionHouse(){}
    void SellToPlayer(){}
}
```

Voilà on peut tout à fait dire qu'on a une interface qui hérite d'une autre.

Ici dans ce cas-ci on est avec un seul héritage `interface ITradableBetweenServers : ITradable` mais on peut tout à fait le faire et à ce moment-là on devra implémenter notre interface et notre interface va avoir également ses propres définitions.

Notre interface ITradableBetweenServers a donc ses propres définitions.

Bien sûr il ne faut pas oublier que notre interface va devoir implémenter également l'autre interface, bien évidemment ça fonctionne par héritage donc notre interface va hériter de notre interface mère donc on retrouve le même principe et c'est forcément logique avec tout ce qu'on a expliqué dans les vidéos précédentes.

On peut donc faire de l'héritage avec nos interfaces pour avoir ainsi une implémentation multi interfaces au sein d'une même classe, et bien sûr comprendre qu'il y a une réelle différence entre interface et classe abstraite, ne serait-ce que dans l'usage et dans le principe.

L'interface est un contrat, simplement une liste, une garantie de fonctionnalités et de capacités tierces que vous allez amener à une classe qui n'ont pas forcément de comportement commun ; là ou la classe abstraite sera justement une base de comportement commun entre plusieurs classes concrètes.

On a vraiment 2 distinctions importantes même si dans d'autres langages lorsqu'on n'a pas le système d'interface qui existe, les gens n'ont pas trop le choix que d'utiliser des classes abstraites mais l'interface comme on en a parlé c'était aussi une classe abstraite dite pure.

Comme l'interface est une classe abstraite d'être pure, on pourrait très bien faire une interface avec des classes abstraites et comme si CSharp est un langage qui propose les 2 fonctionnalités, utiliser les fonctionnalités du langage en priorité avant d'utiliser quelque chose de générique ou de commun a plusieurs langages de programmation différents.

On pourrait également avoir d'autres types d'éléments publics dans une interface comme des indexeurs et des événements c'est à dire qu'on peut avoir tout ça dans une interface aussi et comme on ne l'a pas encore vu on ne va pas l'aborder dans ce cours pour le moment mais le principe à retenir en tout cas c'est que tout est public par défaut dans une interface donc on ne le précise pas forcément.

```cs
interface ITradable
{
    /*public abstract*/void SellToMerchant();
    void SellToAuctionHouse();
    void SellToPlayer();
}
```

On pourrait également travailler avec des propriétés mais nous allons passer là-dessus Puisque de toute façon vous avez vu comment ça fonctionnait dans d'autres vidéos et vous avez compris un petit peu le principe à ce niveau-là.

Revenons à l'essentiel pour les interfaces en termes de code.

```cs
using System;

namespace App
{
    interface ITradable
    {
        void SellToMerchant();
        void SellToAuctionHouse();
        void SellToPlayer();
    }

    class Weapon : ITradable
    {
        void SellToMerchant()
        {
            //...
        }

        void SellToAuctionHouse()
        {
            //...
        }

        void SellToPlayer()
        {
            //...
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World !");
        }
    }
}
```

L'essentiel pour l'interface c'est-à-dire qu'on doit d'abord définir notre interface avec les différentes méthodes, la signature terminée par un ; et ensuite une classe Weapon qui implémente ITradable.

En fait ici on peut donner la capacité à une classe peu importe l'application, On va pouvoir donner la capacité à une classe d'être échangeable donc si je vais par exemple avoir plus tard quelque chose d'autre que je veux rendre échangeables :

```cs
class Mount : ITradable
{}

class Weapon : ITradable
{}
```

Même si la classe Mount et Weapon non pas de relation entre elles c'est à dire qu'elle n’hérite pas d'une classe mère toutes les 2 ou de la même classe peu importe, Eh bien je peux parfaitement leur donner cette capacité ITradable.

Vous verrez que les interfaces que vous utiliserez dans les langages de programmation, sont des interfaces qui fonctionnent de la même manière.

Si admettons on veut créer par exemple une interface qui permet l'export c'est à dire la sauvegarde d'un élément, sous forme de fichier, pour de l'impression ou que sais-je Eh bien on est d'accord qu'on va pouvoir exportable et sauvegardable différents éléments qui n'ont pas forcément de lien entre eux.

Ainsi les interfaces servent à ça, on n'a pas de relation direct de comportement entre les éléments, pour autant on donne des capacités tierces à différents éléments distinctes sans problème avec cette fonctionnalité qui permet de faire une implémentation de notre interface.

Voilà nous avons tout dit et le plus important est ce qui va suivre à ces 2 vidéos sur les abstractions et les interfaces parce que le but de tout ça est d'aborder le polymorphisme et c'est ce que nous verrons juste par la suite pour comprendre à quoi ça sert.

Alors il ne faut pas oublier de dire que l'on ne peut pas instancier une interface mais on peut parfaitement déclarer un élément de type interface comme ceci `ITradable items` Mais on ne va pas pouvoir instance est un élément de cette interface `ITradable items = new //…` c'est à dire qu à partir de là ça va changer.

```cs
class Program
{
    static void Main(string[] args)
    {
        ITradable items = new //… non on ne peut pas instancier une interface.
    }
}
```

Nous verrons cela parce qu’on ne va pas pouvoir instancier un élément de cette interface sans empiéter sur la notion de polymorphisme et c'est ce que nous verrons prochainement.

On a déjà vu les classe abstraite et les interfaces dans d'autres playlist, avec lequel on a vu plein d'exemples sachez donc que c'est un principe très important parce que on a tendance à vite faire des confusions entre ces 2 principes qu'il faut insister pour voir la différence qu'il y a entre chacun.

Normalement à ce stade on sait faire la différence entre une classe abstraite et une interface, et quand on les utiliser donc il faut bien avoir compris cela pour la suite.

Ciao tout le monde