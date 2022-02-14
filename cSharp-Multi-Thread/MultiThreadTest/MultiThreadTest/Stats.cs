using System;
using System.Collections;

namespace MultiThreadTest
{
    class Stats
    {
        // Global Variables
        public static int globalAverage;
        public static int globalMinVal;
        public static int globalMaxVal;
        public static double globalMedium;
        public static double globalSTD;

        // Global List of Inputs
        public static ArrayList globalInputValues = new ArrayList();

        static void Main(string[] args)
        {
            // Prompts the user for their input
            Console.WriteLine("Enter the values on a single line, each item separated by a space.");
            Console.WriteLine("Enter your list of numbers: ");

            // Reads in the user's input
            string input = Console.ReadLine();

            // Splits user input string into an array
            string[] inputArray = input.Split(' ');

            // Converts string items to int and adds to global List
            foreach(string item in inputArray)
            {
                globalInputValues.Add(Convert.ToInt32(item));
            }

        }
    }
}
