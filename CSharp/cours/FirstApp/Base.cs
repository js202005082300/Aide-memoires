using System;

namespace App
{
    class Window
    {
        public string Title { get; set; } = "Nouvelle fenetre";
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            Window win = new Window();
            Console.WriteLine(win.Title);

            win.Title = "Nouveau nom";
            Console.WriteLine(win.Title);
        }
    }
}