import java.util.*;

public class DSAHeap
{
    private class DSAHeapEntry
    {
        /** ================== DSAHeapEntry ================== **/

        /** Private Classfields **/
        private int priority;
            // Priority to order by
        private Object value;
            // Value stored in entry

        /** Constructor **/
        /*  --------------------------------------------------------------
        ** Constructor: Alternate
        **      Import: inPriority (int), inValue (Object)
        **      Export: Memory adress of new DSAHeapEntry
        **   Assertion: Sets state to given values
        */
        public DSAHeapEntry( int inPriority, Object inValue )
        {
            priority = inPriority;
            value = inValue;
        }

        public int getPriority()
        {
            return priority;
        }
        public Object getvalue()
        {
            return value;
        }

       

        public void setPriority( int inPriority)
        {
             priority = inPriority;
        }

        public void setvalue(Object inValue)
        {
            value = inValue;
        }

        public String toString()
        {
            return ( priority + "," + value );
        }
    }

    /** ================== DSAHeap ================== **/

    /** Private Classfields **/
    public DSAHeapEntry[] heap;
        // Array representation of heap
    public int count;
        // No. of entries in array

    public String path="";



    /** Constructor **/
    /*  --------------------------------------------------------------
    ** Constructor: Alternate
    **      Import: maxSize (int)
    **      Export: Memory adress of new DSAHeap
    **   Assertion: Initializes array to given size and count to zero
    */
    public DSAHeap( int maxSize )
    {
        heap = new DSAHeapEntry[ maxSize ];
        count = 0;
    }

  

    /** Getters / Setter **/
    /*  --------------------------------------------------------------
    **   Submodule: add()
    **      Import: priority (int), value (Object)
    **      Export: none
    **   Assertion: Adds an entry to the heap, uses trickleUp() 
    **                  recursive algorithm
    */
    public String add( int priority, Object value )
    {
        heap[count] = new DSAHeapEntry( priority, value );
         path = "";

        path =trickleUp( count );
        count++;
        return path;
    }

    /*  --------------------------------------------------------------
    **   Submodule: remove()
    **      Import: none
    **      Export: (Object)
    **   Assertion: Removes the highest priority entry from the top
    **                  of the heap, uses trickleDown() recursive
    **                  algorithm
    */
    public String remove()
    {
        path="";
        Object retValue = heap[0].value;
        count--;

        heap[0] = heap[count];
        heap[count] = null;
        path = trickleDown( 0 );

        return path;
    }

    /*  --------------------------------------------------------------
    **   Submodule: getCount()
    **      Import: none
    **      Export: count (int)
    **   Assertion: Returns the count of entries in heap
    */
    public int getCount()
    {
        return count;
    }

    /** Heap Sort **/
    /*  --------------------------------------------------------------
    **   Submodule: heapSort()
    **      Import: values (Object[])
    **      Export: none
    **   Assertion: Implementation of max heap sort, an O(N log N) sort.
    **                  Takes import as a 2D array, at each element is a
    **                  2-element Object array, [0] is an Integer
    **                  representing priority and [1] is the value Object
    */
    public DSAHeapEntry[] heapSort( Object[][] arr )
    {
        DSAHeapEntry temp;
        count = arr.length;
        heap = new DSAHeapEntry[ count ];

        if( arr[0][0] instanceof Integer )
        {
            // Import is 2D array of priority ints and values
            for( int i = 0; i < count; i++ )
            {
                heap[i] = new DSAHeapEntry( (int)arr[i][0], arr[i][1] );
            }
        }
       

        // Heapify the array
        for( int i = ( count / 2 ) - 1; i >= 0; i-- )
        {
            trickleDown( i );
        }

        // Heap sort
        for( int i = count - 1; i >= 1; i-- )
        {
            /* Swap top entry with i'th entry */
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            // trickleDown() must use i as the value for count
            count = i;

            // Trickle down the top entry
            trickleDown( 0 );
        }

        count = arr.length;

        return heap;

    }

    public Object[][] convertTo2D()
    {
        Object[][] sortarry = new Object[count][2];

        for(int i=0;i<count;i++)
                    {
                         sortarry[i][0] = (heap[i].getPriority());
                         sortarry[i][1] = (heap[i].getvalue());
   
                    }

                    return sortarry;

    }

    /** Private Trickle Up / Down **/
    /*  --------------------------------------------------------------
    **   Submodule: trickleUp()
    **      Import: idx (int)
    **      Export: none
    **   Assertion: Recursive algorithm to trickle up an entry based
    **                  on priority of itself and it's parent
    */
    private String trickleUp( int idx )
    {
        int parentIdx = getParentIdx( idx );
        DSAHeapEntry temp;

        if( ( idx > 0 ) && ( heap[idx].priority < heap[parentIdx].priority ) )
        {
            // Swap current index with parent
            temp = heap[parentIdx];
            heap[parentIdx] = heap[idx];
            heap[idx] = temp;

            path = path + heap[idx].getPriority()+ "-->" + heap[parentIdx].getPriority();
            path = path + "\n" + heap[parentIdx].getPriority()+ "-->" + heap[idx].getPriority()+"\n";
            

            // Recurse
            trickleUp( parentIdx );
        }
        return path;
    }

    /*  --------------------------------------------------------------
    **   Submodule: trickleDown()
    **      Import: idx (int)
    **      Export: none
    **   Assertion: Recursive algorithm to trickle down an entry based
    **                  on priority of itself and it's children
    */
    private String trickleDown( int idx )
    {
        int leftIdx = getLeftChildIdx( idx );
        int rightIdx = getRightChildIdx( idx );
        int minIdx;
        DSAHeapEntry temp;

        if( leftIdx < count )
        {
            // Finding largest of two children of current index
            minIdx = leftIdx;
            if( rightIdx < count )
            {
                if( heap[leftIdx].priority > heap[rightIdx].priority )
                {
                    minIdx = rightIdx;
                }

            }
            if( heap[minIdx].priority < heap[idx].priority )
            {
                // Swap current index with larger child
                temp = heap[minIdx];
                heap[minIdx] = heap[idx];
                heap[idx] = temp;

                path = path + heap[idx].getPriority()+ "-->" + heap[minIdx].getPriority();
                path = path + "\n" + heap[minIdx].getPriority()+ "-->" + heap[idx].getPriority()+"\n";

                // Recurse
                trickleDown( minIdx );
            }
        }
        return path;
    }

    /** Private Helper Functions **/
    /*  --------------------------------------------------------------
    **   Submodule: leftChildIdx()
    **      Import: idx (int)
    **      Export: (int)
    **   Assertion: Uses arithmetic to determine the index of the 
    **                  left child of the given index
    */
    private int getLeftChildIdx( int idx )
    {
        return ( idx * 2 ) + 1;
    }

    /*  --------------------------------------------------------------
    **   Submodule: rightChildIdx()
    **      Import: idx (int)
    **      Export: (int)
    **   Assertion: Uses arithmetic to determine the index of the 
    **                  right child of the given index
    */
    private int getRightChildIdx( int idx )
    {
        return ( idx * 2 ) + 2;
    }

    /*  --------------------------------------------------------------
    **   Submodule: parentIdx()
    **      Import: idx (int)
    **      Export: (int)
    **   Assertion: Uses arithmetic to determine the index of the 
    **                  parent of the given index
    */
    private int getParentIdx( int idx )
    {
        return ( idx - 1 ) / 2;
    }

    public void display()
    {
        for(int i =0;i<count;i++)
        {
        System.out.println(i+ " " + heap[i].toString() );
        }
    }
}