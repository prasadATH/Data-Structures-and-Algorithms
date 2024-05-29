import java.util.*;
import java.io.*;

import java.io.FileWriter;

public class intMenu
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int userInp =0;
        int keyValue =0;
        String data="";
   
        String path="";

        DSAHeap heapArry = new DSAHeap(10);
        
 while(userInp !=8)
    {
        System.out.println("\n<1> Insert data to the heap Array ");
		System.out.println("<2> Remove root node from heap Array");
        System.out.println("<3> Display the heap Array");
        System.out.println("<4> Sort the heap array");
        System.out.println("<5> Test trickleUp method");
        System.out.println("<6> Test trickleDown method");
        System.out.println("<7> Read from a CSV file");
      

		System.out.println("<8> Exit");

        System.out.print("\nEnter the required function : ");
        userInp = sc.nextInt();




        switch(userInp)
		{
			    case 1:
				         System.out.println("\nEnter an input key for the heap Array : ");
		        	     keyValue = sc.nextInt();

                         System.out.println("\nEnter an value for the entered key : ");
		        	     data = sc.next();

                   
                          heapArry.add(keyValue, data);
                    
                         System.out.println("\nheap Array after input : ");
                         heapArry.display(); 

                 
                    
				break;

		        case 2:
                
                        heapArry.remove();
                    
                        System.out.println("\nheap Array after removing the root node : ");
                        heapArry.display(); 
          
              
				break;

                case 3:
                           System.out.println("\nheap Array : ");
                           heapArry.display();


				break;
		        case 4:
                              Object[] sorted = new Object[heapArry.getCount()];
                              sorted = heapArry.heapSort(heapArry.convertTo2D());
                
                
                
                             for(int i=0;i<sorted.length;i++)
                               {
                                     System.out.println(sorted[i]);
                   
                               }

           

				break;

                case 5:
                               System.out.println("\nEnter an input key very large compared to the existing values : ");
                               keyValue = sc.nextInt();

                                 System.out.println("\nEnter an value for the entered key : ");
                                data = sc.next();  
                         System.out.println("\nInserting '"+keyValue+"' to test trickleUp method(a very large value compare to the elements present)");
                        path = heapArry.add(keyValue, data);
                         System.out.println("\nIf the trickle up method is successfull, the array should contain '"+keyValue+"' in the 0th index ");
                         System.out.println("Heap Array : "); 
                         System.out.println("\npath = \n"+path); 

                         heapArry.display();

                

				break;

			    case 6:
                        
                         System.out.println("\nRemoving the root node to test trickleDown method(Since the lowest leaf node is assigned to the place of root node)");
                           path =heapArry.remove();
                            System.out.println("\nThe trickle down path when removing the root node is shown below ");
                         
                            System.out.println("\npath = \n"+path); 
                            System.out.println("Heap Array : "); 
                           
                           

                           heapArry.display();
         

                break;

                case 7:
                          readCSV(heapArry);
                        

                break;

                case 8:
                          //writeCSV(heapArry);
                        

                break;

                case 9:
                        System.out.println("\nThank you! for using this program.");
 
                break;

                default :
                System.out.println("\nInvalid Selection!! please enter a choice between 0 and 6");


		}
    }
  }

  public static void readCSV(DSAHeap heapArry)
    {
        String fileName;
        FileInputStream strm = null;
        InputStreamReader rdr;
        BufferedReader bfr;
        Scanner sc = new Scanner( System.in );
        String line;
        String[] lineArr = new String[ 2 ];
        int key=0;
        String value;

        System.out.println("Enter a file name to import :");
        fileName = sc.next();

        try
        {
            strm = new FileInputStream( fileName );
            rdr = new InputStreamReader( strm );
            bfr = new BufferedReader( rdr );

            line = bfr.readLine();
            while( line != null )
            {
                lineArr = line.split(",");
                key = Integer.parseInt( lineArr[0] );
                value =( lineArr[1] );

                heapArry.add(key, value);

                line = bfr.readLine();
            }
            bfr.close();

            System.out.println( "File read successfully" );
        }
        catch( IOException e )
        {
            System.out.println( "Error occurred\n" );
            e.printStackTrace();
            if( strm != null )
            {
                try
                {
                    strm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
    }

/* 
    public static void writeCSV(DSAHeap heapArry)
    {
        String fileName;
        FileOutputStream strm = null;
        PrintWriter pw;
        int order;
        Scanner sc = new Scanner( System.in );
        int i = 1;

        System.out.println( "Enter a file name to be included : " );
        fileName = sc.next();

        try
        {
            strm = new FileOutputStream( fileName );
            pw = new PrintWriter( strm );

           
            for(int j=0;j<heapArry.count;j++)
            {
                pw.println(heapArry.heap[i].getPriority()+ "," + heapArry.heap[i].getValue());
            } 

            pw.close();
            System.out.println( "File written successfully" );
        }
        catch( IOException e )
        {
            System.out.println( "Error occurred\n" );
            e.printStackTrace();
            if( strm != null )
            {
                try
                {
                    strm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
        
    }*/


}

/*

    }

    public static void printList(DSALinkedList pListData)
    {
       int count =0;
       for(Object collect :pListData)
       {
           count++;
           System.out.println("Element "+ (count) +" is :"+ collect);
       }
    }
    */

