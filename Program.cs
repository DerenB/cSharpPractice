using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace cSharpPractice
{
    /*
        Methods marked with "Community" are solutions submitted by others on CodeWars
    */

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

        static bool CommunityOneValidatePin(string pin)
        {
            return Regex.IsMatch(pin, @"^(\d{6}|\d{4})\z");
        }

        static bool CommunityTwoValidatePin(string pin) =>
            (pin.Length == 4 || pin.Length == 6) && pin.All(Char.IsDigit);

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

        static string CommunityReverseWords(string str)
        {
            return string.Join(" ", str.Split(' ').Select(i => new string(i.Reverse().ToArray())));
        }

        //Takes an Array of numbers as input, sorts the array ascending, returns the sum of the two lowest
        static int SumTwoSmallestNumbers(int[] numbers)
        {
            Array.Sort(numbers);
            return numbers[0] + numbers[1];
        }
    }
}



