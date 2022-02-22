using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace AssemblyLine
{
    public class Factory
    {
        public static void Main()
        {
            Console.WriteLine("Hello World");

            BoundedBuffer bufferAtoB = new BoundedBuffer();
            BoundedBuffer bufferBtoC = new BoundedBuffer();
            BoundedBuffer bufferCtoD = new BoundedBuffer();
            BoundedBuffer bufferDtoFinal = new BoundedBuffer();

            Worker objA = new Worker("WorkerA",true,bufferAtoB);
            Worker objB = new Worker("WorkerB", false, bufferAtoB, bufferBtoC);
            Worker objC = new Worker("WorkerC", false, bufferBtoC, bufferCtoD);
            Worker objD = new Worker("WorkerD", false, bufferCtoD, bufferDtoFinal, true);

            Thread threadA = new Thread(new ThreadStart(objA.run));
            Thread threadB = new Thread(new ThreadStart(objB.run));
            Thread threadC = new Thread(new ThreadStart(objC.run));
            Thread threadD = new Thread(new ThreadStart(objD.run));

            threadA.Start();
            threadB.Start();
            threadC.Start();
            threadD.Start();

            threadA.Join();
            threadB.Join();
            threadC.Join();
            threadD.Join();

            Console.WriteLine("--------------------");
            Console.WriteLine("Widget Processing Complete. Final results:");
            Console.WriteLine();
            bufferDtoFinal.print();
            Console.WriteLine("--------------------");
            Console.WriteLine();
            Console.WriteLine("Program Closing");
        }
    }
}
