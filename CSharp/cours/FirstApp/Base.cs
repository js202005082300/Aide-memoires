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