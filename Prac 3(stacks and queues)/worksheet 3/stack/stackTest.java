import java.util.*;

public class DSAStackTest
{
     public static void main(String[] args)
     {
          Scanner sc = new Scanner(System.in);
          

          System.out.println("Enter Size of array : ");
          int arrySize = sc.nextInt();

          System.out.println("Enter value to be added : ");
          int val = sc.nextInt();

          

          DSAStack test1 = new DSAStack(arrySize);

          test1.push(val);

         for(int i=0;i<(arrySize-4); i++)
         {
             test1.push(val);
          }

          System.out.println("Enter 2nd value to be added : ");
          int val2 = sc.nextInt();



          test1.push(val2);
          test1.push(val2);

          test1.push(val2);


          //test1.pop();
          //test1.pop();
          //test1.pop();
          //test1.pop();

       //   test1.top();
          System.out.println("top value is : " + test1.top());

          test1.pop();


          System.out.println();

          test1.printVal();




     }
}

