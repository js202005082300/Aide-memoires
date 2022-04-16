using System.Text;

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder("Hello");

            sb.Remove(1, sb.Length - 1);

            Console.WriteLine(sb);
        }
    }
}