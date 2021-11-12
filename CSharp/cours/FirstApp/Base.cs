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
            Armor ar = new Armor(80);

            if(ar)
                Console.WriteLine("Oui !");
            else
                Console.WriteLine("Non...");
        }
    }
}