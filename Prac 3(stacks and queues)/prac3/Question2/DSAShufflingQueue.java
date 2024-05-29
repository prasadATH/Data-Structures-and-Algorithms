// FILE: DSAShufflingQueue.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875


import java.util.*;

public class DSAShufflingQueue extends DSAQueue
{
    // Constructors

    public DSAShufflingQueue()
    {
        super();
    }

    public DSAShufflingQueue( int capacity )
    {
        super( capacity );
    }

    // Accessors

    public boolean isEmpty()
    {
        boolean empty = false;

        if( super.endIdx == 0 )
        {
            empty = true;
        }

        return empty;
    }

    public boolean isFull()
    {
        boolean full = false;

        if( getCount() == super.queue.length )
        {
            full = true;
        }
        
        return full;
    }

    public int getCount()
    {
        return super.endIdx;
    }

    public Object peek()
    {
        Object frontVal;       

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "Queue is empty" );
        }
        else
        {
            frontVal = super.queue[0];
        }

        return frontVal;
    }

    // Mutators

    public void enqueue( Object inObject )
    {
        if( isFull() )
        {
            throw new IllegalArgumentException( "Queue is full" );
        }
        else
        {
            super.queue[ super.endIdx ] = inObject;
            super.endIdx++;
        }
    }

    public Object dequeue()
    {
        Object frontVal = peek();
        super.endIdx--;

        for( int i = 0; i < super.endIdx; i++ )
        {
            super.queue[ i ] = super.queue[ i + 1 ];
        }

        return frontVal;
    }

    public void printVal()
    {
         for(int i = 0 ; i<(super.queue.length) ; i++)
         {
              System.out.println(super.queue[i] + " ");     
         }
    }
}