using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AssemblyLine
{
    public class Widget
    {
        public int modelNumber, red, green, blue, numberOfWorkers;

        public Widget(int productionCount)
        {
            modelNumber = productionCount;
            red = RandomValue();
            green = RandomValue();
            blue = RandomValue();
            numberOfWorkers = 1;
        }

        public int RandomValue()
        {
            Random rand = new Random();
            return rand.Next(256);
        }

        public void workUpon()
        {
            numberOfWorkers++;
        }

        public string getModelNumber()
        {
            return red.ToString() + "." + green.ToString() + "." + blue.ToString();
        }
    }
}
