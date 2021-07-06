using System;

namespace App
{
    class Base
    {
        static void Main(string[] args)
        {
            Stock stock_disks = new Stock();
            Stock stock_mouses = new Stock(25);

            Console.WriteLine(stock_disks);
        }
    }
}