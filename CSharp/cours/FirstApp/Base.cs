using System;

namespace App
{
    class Fighter
    {
        public static int lifePoints = 1000;
    }
    
    class Human : Fighter
    {
        new public int lifePoints = 2500;
    }

    /*---------------------------------------------------------------*/

    class Program
    {
        static void Main(string[] args)
        {
            var h = new Human();
            Console.WriteLine(Fighter.lifePoints);
        }
    }
}