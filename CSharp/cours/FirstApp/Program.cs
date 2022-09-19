using System.IO;
using System;

// Structures : DateTime, TimeSpan
//

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            string s = "2015-09-18";
            DateTime dt;

            if(DateTime.TryParse(s, out dt))
                Console.WriteLine(dt);
        }
    }
}