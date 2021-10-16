using System;

namespace App
{
    public enum AlertLevel
    {
        Warning = 0,
        Error = 1,
        FatalError = 2
    }

    public static class CheckAlert
    {
        public static AlertLevel error = AlertLevel.Error;

        public static bool IsError(this AlertLevel a)
        {
            return a >= error;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            AlertLevel a1 = AlertLevel.Warning;
            AlertLevel a2 = AlertLevel.Error;
            AlertLevel a3 = AlertLevel.FatalError;
            
            if(CheckAlert.IsError(a1))
                Console.WriteLine("a1 : C'est un niveau d'erreur");
            if(CheckAlert.IsError(a2))
                Console.WriteLine("a2 : C'est un niveau d'erreur");
            if(CheckAlert.IsError(a3))
                Console.WriteLine("a3 : C'est un niveau d'erreur");
        }
    }
}