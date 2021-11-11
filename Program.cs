using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace cSharpPractice
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }

        //Removes all white spaces from string input
        static string SpacesRemover(string input)
        {
            return String.Concat(input.Where(c => !Char.IsWhiteSpace(c)));
        }

        //Tests a string PIN input
        //Pin has to be 4 or 6 digits, and only valid numbers (0-9)
        static bool ValidatePin(string pin)
        {
            if (pin.Length == 5 || (pin.Length < 4 || pin.Length > 6))
            {
                return false;
            }

            for (int i = 0; i < pin.Length; i++)
            {
                if ((int)pin[i] < 48 || (int)pin[i] > 57)
                {
                    return false;
                }
            }
            return true;
        }

        //Reverses individual words in string input without reversing order of words in string
        static string ReverseWords(string str)
        {
            string[] strSplit = str.Split(' ');
            string[] reversed = new string[strSplit.Length];

            for (int i = 0; i < strSplit.Length; i++)
            {
                char[] wordSplit = strSplit[i].ToCharArray();
                char[] wordReverse = new char[wordSplit.Length];
                for (int k = 0; k < wordSplit.Length; k++)
                {
                    int endVal = (wordSplit.Length - 1) - k;
                    wordReverse[endVal] = wordSplit[k];
                }
                string reversedWord = new string(wordReverse);

                reversed[i] = reversedWord;
            }
            string result = String.Join(" ", reversed);
            return result;
        }
    }
}



