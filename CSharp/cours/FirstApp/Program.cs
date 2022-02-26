using System;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {2, 3, 4, 6, 1, 0};
            int[] arr2 = new int[5];

            Array.Copy(arr, arr2, 3);

            foreach(var el in arr2)
                Console.WriteLine(el);
        }
    }
}