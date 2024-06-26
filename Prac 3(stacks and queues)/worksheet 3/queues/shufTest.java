import java.util.*;

public class shufTest
{
    public static void main( String[] args )
    {
        // Capacity Test
        DSAShufflingQueue queue = new DSAShufflingQueue( 5 );

        System.out.println( "Testing capacity of 5" );
        try
        {
          int val=0;
            System.out.print( "Adding integers: " );
            for( int i = 0; i <= 5; i++ )
            {
               val = (val + i);
                queue.enqueue( val);
                System.out.print( ( i + 1 ) + ", " );
            }
            System.out.println( "\nCapacity exceeded :(" );
        }
        catch( IllegalArgumentException e )
        {
            System.out.println( "\nIt's full :)" );
        }
        System.out.println( "\n" );

        // Dequeue/Peek Test
        System.out.println( "Testing dequeue and peek" );
        String outStr = new String();
        queue.peek();
        if( queue.getCount() == 5 )
        {
            outStr += "Peek works";
        }
        else
        {
            outStr += "Peek doesn't work";
        }
        outStr += " (Expected " + 5 + ", actual " + queue.getCount() + ") ";
        queue.dequeue();
        if( queue.getCount() == 4 )
        {
            outStr += "\nDequeue works";
        }
        else
        {
            outStr += "\nDequeue doesn't work";
        }
        outStr += " (Expected " + 4 + ", actual " + queue.getCount() + ") ";
        System.out.println( outStr + "\n\n" );

        // Empty Test
        System.out.println( "Testing emptiness" );
        while( !queue.isEmpty() )
        {
            System.out.println( "Dequeuing value " + queue.getCount() );
            queue.dequeue();
        }
        System.out.println( "It's empty" );

    }
}