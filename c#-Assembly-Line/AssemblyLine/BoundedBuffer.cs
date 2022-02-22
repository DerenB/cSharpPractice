using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AssemblyLine
{
    public class BoundedBuffer
    {
        public static int napTime = 5;
        public static int buffer_size = 3;
        private LinkedList<Widget> widgetItems = new LinkedList<Widget> ();
        private int numberOfItemsInBuffer;

        public BoundedBuffer()
        {
            numberOfItemsInBuffer = 0;
        }

        public static void napping()
        {
            Random rand = new Random();
            int sleepTime = napTime * rand.Next(10);
            try
            {
                Thread.Sleep(sleepTime);
            } catch (Exception e) { }
        }

        public async void enter(Widget item, string worker, string widgetNumber)
        {
            /*
            while (widgetItems.Count() == 3)
            {
                try
                {
                    Console.WriteLine($"{worker} encountered a full Buffer.");
                    //await Widget();
                } catch (Exception e) { }
                
            } 
            */

            numberOfItemsInBuffer++;

            widgetItems.AddLast(item);

            if(numberOfItemsInBuffer == buffer_size)
            {
                Console.WriteLine($"{worker} entered Widget {widgetNumber}. Buffer FULL.");
            } else
            {
                Console.WriteLine($"{worker} entered Widget {widgetNumber}. Buffer size is {numberOfItemsInBuffer}.");
            }
        }

        public Widget remove(string worker)
        {
            Widget item;

            /*
            while(widgetItems.Count() == 0)
            {
                Console.WriteLine($"{worker} is waiting.");
            }
            */

            numberOfItemsInBuffer--;
            item = widgetItems.First();
            widgetItems.RemoveFirst();

            return item;
        }

        public void finalList(Widget item, string worker, int widgetNumber)
        {
            widgetItems.AddLast(item);
        }

        public void print()
        {
            int widgetNum = 1;
            foreach(Widget entry in widgetItems)
            {
                Console.WriteLine("--------------------");
                Console.WriteLine($"Widget # {widgetNum}");
                Console.WriteLine($"Widget ID: {entry.getModelNumber}");
                Console.WriteLine($"Number of Workers that Processed {entry.numberOfWorkers}");
                widgetNum++;
            }
        }
    }
}
