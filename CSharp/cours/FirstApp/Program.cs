using System.IO;
using System;

// Structures   : DateTime, DateTimeOffset, TimeSpan, DateOnly, TimeOnly
// Classe       : TimeZoneInfo
// Énumérations : DayOfWeek

namespace App
{
    class Program
    {
        public static void Main(string[] args)
        {
            DateTime dt = new DateTime(2022, 8, 13, 14, 53, 59);
            TimeZoneInfo tzi = TimeZoneInfo.Local;

            DateTime finalDate = TimeZoneInfo.ConvertTime(dt, tzi);
            Console.WriteLine(finalDate);
        }
    }
}