/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
import java.util.concurrent.ThreadLocalRandom; 
class Sorts
{

    /** Bubble sort ------------------------------------------------------ **/
    public static void bubbleSort( int[] A )
    {
        int pass = 0;
        boolean sorted = false, swapped = false;
        int temp = 0;
        do
        {
            sorted = true;
                // Assume sorted and change if not true
            for( int i = 0; i < ( A.length - 1 ) - pass ; i++ )
            {
                if( A[i] > A[ i + 1 ] )
                {
                    // Then swap
                    temp = A[i]; // Temporarily store in variable
                    A[i] = A[ i + 1 ];
                    A[ i + 1 ] = temp;
                    sorted = false;
                    // To continue sorting
                }
            }
            pass++; // Increment to next pass
        }
        while( !sorted );
    }

    /** Selection Sort --------------------------------------------------- **/
    public static void selectionSort( int[] A )
    {
        int minIdx = 0, temp = 0;
        for( int i = 0; i < A.length; i++ )
        {
            minIdx = i;
            for( int j = i + 1; j <= A.length - 1; j++ )
            {
                if( A[j] < A[minIdx] )
                {
                    minIdx = j;
                }
            }
            temp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = temp;
        }
    }

    /** Insertion Sort --------------------------------------------------- **/
    public static void insertionSort( int[] A )
    {
        int temp = 0;
        for( int i = 1; i <= A.length - 1; i++ )
        {
            int j = i;
            temp = A[j];
            while( ( j > 0 ) && ( A[j - 1] > temp ) )
            {
                A[j] = A[ j - 1 ];
                j--;
            }
            A[j] = temp;
        }
    }

    /** Merge Sort ------------------------------------------------------- **/
    // Wrapper Method for mergeSortRec()
    public static void mergeSort( int[] A )
    {
        mergeSortRec( A, 0, A.length - 1 );
    }

    // Merge Sort Private Recursive Algorithm
    private  static void mergeSortRec( int[] A, int leftIdx, int rightIdx )
    {
        int midIdx;

        if( leftIdx < rightIdx )
        {
            midIdx = ( leftIdx + rightIdx ) / 2;

            mergeSortRec( A, leftIdx, midIdx );
                // Recurse Left
            mergeSortRec( A, midIdx + 1, rightIdx );
                // Recurse Right

            merge( A, leftIdx, midIdx, rightIdx );
        }

        // Recursive base case is if the `if` is never entered
    }

    // Private Method to Merge Sub-Arrays After Recursion
    private static void merge( int[] A, int leftIdx, int midIdx, int rightIdx )
    {
        int[] tempArr = new int[ rightIdx - leftIdx + 1 ];
        int i = leftIdx;
        int j = midIdx + 1;
        int k = 0;

        while( ( i <= midIdx ) && ( j <= rightIdx ) )
        {
            if( A[i] <= A[j] )
            {
                tempArr[k] = A[i];
                i++;
            }
            else
            {
                tempArr[k] = A[j];
                j++;
            }
            k++;
        }

        for( int ii = i; i <= midIdx; i++ )
        {
            // Flush remainder from left sub-array
            tempArr[k] = A[i];
            k++;
        }

        for( int jj = j; j <= rightIdx; j++ )
        {
            // Flush remainder from right sub-array
            tempArr[k] = A[j];
            k++;
        }

        for( int kk = leftIdx; kk <= rightIdx; kk++ )
        {
            // Place sorted data from tempArr into A
            A[kk] = tempArr[ kk - leftIdx ];
        }
    }

    /** Quick Sort | Left-Most Pivot Selection Implementation ------------ **/
    // Wrapper method for quickSortRec()
    public static void quickSortLeft( int[] A )
    {
        quickSortRec( A, 0, A.length - 1 );
    }

    private static void quickSortRec( int[] A, int leftIdx, int rightIdx )
    {
        int pivIdx;
        int newPivIdx;

        // Check that the array length is > 1
        if( rightIdx > leftIdx )
        {
            pivIdx = leftIdx;
                // Left-most pivot selection
            newPivIdx = doPartitioning( A, leftIdx, rightIdx, pivIdx );
            

            quickSortRec( A, leftIdx, newPivIdx - 1 );
                // Recurse Left
            quickSortRec( A, newPivIdx + 1, rightIdx );
                // Recurse Right
        }
        
        // Recursive base case is if the `if` is never entered   
    }

    /** Quick Sort | Median of Three Pivot Selection Implementation ------ **/
    // Wrapper method for quickSortMed3Rec()
    public static void quickSortMed( int[] A )
    {
        quickSortMedRec( A, 0, A.length - 1 );
    }
 
    // Recursive algortithm for quick sort
    private static void quickSortMedRec( int[] A, int leftIdx, int rightIdx )
    {
        int pivIdx;
        int newPivIdx;

        // Check that the array length is > 1
        if( rightIdx > leftIdx )
        {
            pivIdx = med3( A, leftIdx, rightIdx, ( leftIdx + rightIdx ) / 2 );
                // Median of three pivot selection
            newPivIdx = doPartitioning( A, leftIdx, rightIdx, pivIdx );

            quickSortRec( A, leftIdx, newPivIdx - 1 );
                // Recurse Left
            quickSortRec( A, newPivIdx + 1, rightIdx );
                // Recurse Right
        }
        
        // Recursive base case is if the `if` is never entered   
    }

    // Find the median of 3 values from given index
    private static int med3( int[] A, int a, int b, int c )
    { 
        int med;

        if( A[a] > A[b] && A[a] > A[c] )
        {
            med = a;
        }
        else if( A[b] > A[a] && A[b] > A[c] )
        {
            med = b;
        }
        else
        {
            med = c;
        }

        return med;
    }
 
    /** Quick Sort | Partitioning Generic Algorithm ----------------------- */
    // Used by left-most and median-of-three quick sorts
    private static int doPartitioning( int[] A, int leftIdx, int rightIdx, 
        int pivIdx )
    {
        int currIdx;
        int pivVal;
        int temp;
        int newPivIdx;
        
        // Swap the pivotVal and the right-most element
        pivVal = A[pivIdx];
        A[pivIdx] = A[rightIdx];
        A[rightIdx] = pivVal;

        // Find all values that are smaller than the pivot and transfer them
        // to the left side of the array
        currIdx = leftIdx;

        for( int i = leftIdx; i <= rightIdx - 1; i++ )
        {
            if( A[i] < pivVal )
            {
                // Swap i'th and currIdx element
                temp = A[i];
                A[i] = A[currIdx];
                A[currIdx] = temp;

                currIdx++;
            }
        }

        newPivIdx = currIdx;
        A[rightIdx] =  A[newPivIdx];
        A[newPivIdx] = pivVal;

        return newPivIdx;
    }


    public static void quickSortRandom( int[] A )
    {
        randomPivot( A, 0, A.length - 1 );
    }
 
    // Recursive algortithm for quick sort
    private static void randomPivot( int[] A, int leftIdx, int rightIdx )
    {
        int pivIdx;
        int newPivIdx;

        // Check that the array length is > 1
        if( rightIdx > leftIdx )
        {
            pivIdx = ThreadLocalRandom.current().nextInt(0, (A.length + 1));
                // Median of three pivot selection
            newPivIdx = doPartitioning( A, leftIdx, rightIdx, pivIdx );

            quickSortRec( A, leftIdx, newPivIdx - 1 );
                // Recurse Left
            quickSortRec( A, newPivIdx + 1, rightIdx );
                // Recurse Right
        }
        
        // Recursive base case is if the `if` is never entered   
    }
  
 
}