using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace AssemblyLine
{
    public class Worker
    {
        private Boolean producer;
        private Boolean finalWorker = false;
        private int numberOfUnits = 24;
        private int unitNumber = 1;
        private string workerName;

        private BoundedBuffer bufferIn;
        private BoundedBuffer bufferOut;

        private Widget newWidget;
        private string widgetModelNumber;

        public Worker(string name, Boolean newProducer, BoundedBuffer b)
        {
            workerName = name;
            producer = newProducer;
            bufferOut = b;
        }

        public Worker(String name, Boolean newProduer, BoundedBuffer inB, BoundedBuffer outB)
        {
            workerName = name;
            producer=newProduer;
            bufferIn = inB;
            bufferOut = outB;
        }

        public Worker(String name, Boolean newProducer, BoundedBuffer inB, BoundedBuffer outB, Boolean end)
        {
            workerName=name;
            producer=newProducer;
            bufferIn=inB;
            bufferOut=outB;
            finalWorker = end;
        }

        public void run()
        {
            while(unitNumber <= numberOfUnits)
            {
                //BoundedBuffer.napping();

                if(producer)
                {
                    produceNewWidget();
                    bufferOut.enter(newWidget,workerName,widgetModelNumber);
                } else
                {
                    newWidget = bufferIn.remove(workerName);
                    Console.WriteLine($"{workerName} removed {newWidget.getModelNumber()}.");

                    newWidget.workUpon();
                    produce();

                    if(finalWorker)
                    {
                        bufferOut.finalList(newWidget, workerName, newWidget.modelNumber);
                    } else
                    {
                        bufferOut.enter(newWidget, workerName, newWidget.getModelNumber());
                    }
                }
            }
        }

        public void produceNewWidget()
        {
            newWidget = new Widget(unitNumber);
            widgetModelNumber = newWidget.getModelNumber();
            Console.WriteLine($"{workerName} Produced Widget #{unitNumber}. New Widget ID: {newWidget.getModelNumber()}.");
        }

        public void produce()
        {
            Console.WriteLine($"{workerName} Processed Widget {newWidget.getModelNumber()}.");
        }
    }
}
