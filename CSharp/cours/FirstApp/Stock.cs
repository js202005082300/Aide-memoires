using System;

namespace App
{
    public class Stock
    {
        private int Capacity;
        
        public Stock()
        {
            Capacity = 100;
        }

        public Stock(int capacity)
        {
            Capacity = capacity;
        }

        public override string ToString() => $"Capacité du stock : {Capacity}Go.";
    }
}