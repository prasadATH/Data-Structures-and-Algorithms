/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
      int temp =0 ;

      for (int pass = 0 ; pass<=((A.length -1)-1); pass++ )
       {
               for (int ii=0 ; ii <= ((A.length -1 - pass)-1) ;ii++ )
               {
                if (A[ii]>A[ii+1] )
                           {
                            temp = A[ii] ;
                            A[ii] =  A[ii+1];
                            A[ii+1] =  temp;  
        

                           }
                           
               }
               
        }
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
      int temp =0 ;
      int minIdx =0;

        for (int nn = 0 ; nn<=((A.length -1)-1); nn++ )
          {
             minIdx = nn;
                   for (int ii=(nn+1) ; ii <= (A.length -1) ;ii++ )
                 {
                     if (A[ii]<A[minIdx] )
                           {
                               minIdx = ii;
                           }
                 }
                            temp = A[minIdx] ;
                            A[minIdx] =  A[nn];
                            A[nn] =  temp;  
                          
          }


    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {

         int ii = 0;
         int temp =0;

         for (int nn = 1 ; nn<=(A.length -1); nn++ )
         {
                ii = nn;
                 while ( ii>0 && ((A[ii -1]>A[ii])) )
                 {
  
                              temp = A[ii] ;
                              A[ii] =  A[ii-1];
                              A[ii-1] =  temp; 
                              ii=(ii-1);      
  
                             
                  }
                 
          }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
