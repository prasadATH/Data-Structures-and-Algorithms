import java.util.*;

public class queueTest
{
     public static void main(String[] args)
     {
          Scanner sc = new Scanner(System.in);

          System.out.println("Enter Size of array : ");
          int arrySize = sc.nextInt();

          System.out.println("Enter value to be added : ");
          int val = sc.nextInt();

          

          DSAShufflingQueue test2 = new DSAShufflingQueue(arrySize);

         // shuffleQueue test3 = new shuffleQueue(arrySize);




        //  test2.arraySize(arrySize);
           for(int i=0;i<(arrySize-4); i++)
          {
          test2.enqueue(val);
          }
          for(int i=0;i<(4); i++)
          {
               test2.enqueue(8);
          }

/* 
          System.out.println("Enter 2nd value to be added : ");
          int val2 = sc.nextInt();

          test2.enqueue(val2);

          test2.dequeue();
          test2.dequeue();

          test2.dequeue();
          */
//test2.dequeue();



          

          System.out.println();

          test2.printVal();
          System.out.println();

          System.out.println();

          
          //test2.shufTop();




     }
}

