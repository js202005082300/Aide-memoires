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

7.0