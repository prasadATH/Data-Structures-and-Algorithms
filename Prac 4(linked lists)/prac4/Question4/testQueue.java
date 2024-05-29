import java.util.*;

public class testQueue
{
    public static void main( String[] args )
    {
        // Capacity Test
        DSAQueue queue = new DSAQueue();
        String fileName = "QueueDataTest";

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

            if(queue.count() ==10)
            {
                System.out.print( "push function test successful!\n" );

            }

    


        // Pop/Top Test
        System.out.println( "\nTesting dequeue and peek functions" );
        System.out.println( "==========================" );
        
        String outStr = new String();
        if(queue.peek().equals(10))
        {
            outStr += "Top function test successful ";
        }
        else
        {
            outStr += "Top function test failed";
        }
       // outStr += " (Expected " + 500 + ", actual " + stack.top() + ") ";

        if((queue.dequeue()).equals(10) && queue.count() ==9 )
        {
            outStr += "\nPop function test successful ";
        }
        else
        {
            outStr += "\nPop function test failed";
        }
       // outStr += " (Expected " + 400 + ", actual " + stack.top() + ") ";
        System.out.println( outStr + "\n" );


        // Empty Test
        System.out.println( "Testing isEmpty function" );
        System.out.println( "============================" );
        

            System.out.println( "Popping all " + queue.count()+ " values "  );
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

       System.out.println( "Testing saving to a file function" );
       System.out.print( "=================================" );
       queue.saveFile(queue.QueueList, fileName);
       System.out.println();


       System.out.println( "Testing loading from a file function" );
       System.out.print( "=================================" );
       queue.loadFile(fileName);
       
    }
}