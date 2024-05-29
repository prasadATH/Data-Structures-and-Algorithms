import java.util.*;
import java.io.*;

import java.io.FileWriter;

public class intMenu
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String[] hash = new String[30];
        int count =0;
        int userInp =0;
        String keyValue ="";
        String data="";
       String fileN = "";
        int height =0;
        DSAHashTable hashTable = new DSAHashTable(10);
        
 while(userInp !=8)
    {
        System.out.println("\n<1> Insert data to the hash table ");
        System.out.println("<2> Find an element in the hash table to extract the data in it");
		System.out.println("<3> Check whether a key is present in the hash table");
        System.out.println("<4> Remove a key and data from the hash table");
        System.out.println("<5> Display hash table");

        System.out.println("<6> Read from a CSV file");
        System.out.println("<7> Write to a CSV file");

		System.out.println("<8> Exit");

        System.out.print("\nEnter the required function : ");
        userInp = sc.nextInt();




        switch(userInp)
		{
			    case 1:
				    System.out.println("\nEnter an input key for the Hash table : ");
		        	keyValue = sc.next();

                    System.out.println("\nEnter an value for the entered key : ");
		        	data = sc.next();

                   
                    hashTable.put(keyValue, data);
                    
                    System.out.println("\nHash Table after input : ");
                    for( String line : hashTable.export() )
                    {
                        System.out.println(line);
                    }  
                   
                    
				break;

		        case 2:
                
                    System.out.println("\nEnter the key to extract data : ");
                    keyValue = sc.next();

                    System.out.println("\nAttempting to search key now .........");
                    
                    if(hashTable.get(keyValue).equals(0))
                    {
                    System.out.println("\n key "+ keyValue +" not found!");
                    }else
                    {
                        System.out.println("\n key "+ keyValue +" found! value : " + hashTable.get(keyValue) );
                    }
          
              
				break;

                case 3:
                    System.out.println("\nEnter the key to be found : ");
                    keyValue = sc.next();

                    System.out.println("\nAttempting to search key now .........");
                    if(hashTable.hasKey(keyValue) == true)
                    {
                        System.out.println("\n key "+ keyValue +" found!" );
                    }else
                    {
                        System.out.println("\n key "+ keyValue +" not found!");
                    }


				break;
		        case 4:

                System.out.println("\nEnter a key to remove : ");
                keyValue = sc.next();
                hashTable.remove(keyValue);

                System.out.println("\nHash Table after deletion : ");
                    for( String line : hashTable.export() )
                    {
                        System.out.println(line);
                    } 

           

				break;

                case 5:

                System.out.println("\nHash Table : ");
                for( String line : hashTable.export() )
                {
                    System.out.println(line);
                }  

				break;

			    case 6:
                        readCSV(hashTable); 

                break;

                case 7:
                         writeCSV(hashTable); 

                break;

                case 8:
                System.out.println("\nThank you! for using this program.");

                break;

                default :
                System.out.println("\nInvalid Selection!! please enter a choice between 0 and 6");


		}
    }
  }

  public static void readCSV(DSAHashTable hashTable)
    {
        String fileName;
        FileInputStream strm = null;
        InputStreamReader rdr;
        BufferedReader bfr;
        Scanner sc = new Scanner( System.in );
        String line;
        String[] lineArr = new String[ 2 ];
        String key="";
        Object value;

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
                key = ( lineArr[0] );
                value =( lineArr[1] );

                hashTable.put(key, value);

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


    public static void writeCSV( DSAHashTable hashTable)
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

           
            for( String line : hashTable.export() )
            {
                pw.println(line);
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
    }


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

