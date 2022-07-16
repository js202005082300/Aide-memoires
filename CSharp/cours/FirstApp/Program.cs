using System.IO;
using System;

/*
    ReadAllText, ReadAllLines
    XriteAllText, WriteAllLines
    StreamReader, StreamWriter

    File :
        Exists(), Create(), Move(), Delete()
    Directory :
        Exists(), CreateDirectory(), Move(), Delete()
        GetFiles(), GetDirectories()
*/

namespace App
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Console.WriteLine(Directory.GetParent("data"));
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}