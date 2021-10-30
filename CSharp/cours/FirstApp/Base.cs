using System;

namespace App
{
    // Parent
    class Widget
    {
        protected string Title { get; set; } = "Widget";
        public Widget(string title) => this.Title = title;

        public virtual void Test()
        {
            Console.WriteLine($"Widget {this.Title} est fonctionnel.");
        }
    }

    // Enfant de Widget
    class Button : Widget
    {
        public int Color { get; set; } = 0;

        public Button(string title, int color) : base(title)
        {
            this.Color = color;
        }

        public override void Test()
        {
            Console.WriteLine($"Bouton {this.Title} {this.Color} est fonctionnel.");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Widget w = new Widget("Programme en C#");
            Console.WriteLine(w.Title);

            Button btn = new Button("OK", 15);
            Console.WriteLine(btn.Title);
            Console.WriteLine(btn.Color);
            btn.Test();
        }
    }
}