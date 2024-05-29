// FILE: testQueue.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875


import java.util.*;

public class testQueue
{
    public static void main( String[] args )
    {
        // Capacity Test
        DSACircularQueue queue = new DSACircularQueue(10);

        System.out.println( "\nTesting enqueue function" );
        System.out.println( "============================" );

            System.out.print( "enqueuing 10 integers ......\n" );
            for( int i = 0; i < 5; i++ )
            {
                queue.enqueue(10 + (i*10));
            }

            for( int i = 0; i < 5; i++ )
            {
                queue.enqueue(100 + (i*100));
            }


            if(queue.getCount() ==10)
            {
                System.out.print( "enqueue function test successful!\n" );


            }

         //Testing isFull() method
          System.out.println( "\nTesting isFull method" );
          System.out.println( "==========================" );
            
            if(queue.isFull() ==true)
            {
              System.out.println( "isFull function test successful\n" );
      
             }
             else
             {
              System.out.println( "isFull function test failed" );
             }

    


        // Pop/Top Test
        System.out.println( "\nTesting dequeue and peek functions" );
        System.out.println( "==========================" );
        
        String outStr = new String();
        if(queue.peek().equals(10))
        {
            outStr += "peek function test successful ";
        }
        else
        {
            outStr += "peek function test failed";
        }



        if((queue.dequeue()).equals(10) && queue.getCount() ==9 )
        {
            outStr += "\ndequeue function test successful ";
        }
        else
        {
            outStr += "\ndequeue function test failed";
        }



        System.out.println( outStr + "\n" );

        System.out.println( "Dequeing all " + queue.getCount()+ " values "  );
        System.out.println( "-----------------------------------------------\n" );
        // Empty Test
        System.out.println( "Testing isEmpty function" );
        System.out.println( "============================" );
        

            for( int i = 0; i < 9; i++ )
            {
                queue.dequeue();
            }

        
      
      if(queue.isEmpty() ==true)
      {
        System.out.println( "isEmpty function test successful\n" );

       }
       else
       {
        System.out.println( "isEmpty function test failed" );
       }

       
    }
}