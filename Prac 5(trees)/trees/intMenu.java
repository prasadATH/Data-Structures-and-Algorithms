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
        Object data=0;
        String fileN = "";
        int height =0;
        DSABinarySearchTree DSATree = new DSABinarySearchTree();
        
 while(userInp !=14)
    {
        System.out.println("\n<1> Insert to the tree ");
        System.out.println("<2> Find in the tree");
		System.out.println("<3> Height of the tree");
        System.out.println("<4> Delete from the tree");
		System.out.println("<5> Traverse through the tree");
		System.out.println("<6> Balance of the tree");
		System.out.println("<7> Display the tree");
        System.out.println("<8> Display Minimum key of the tree");
        System.out.println("<9> Display Maximum  key of the tree");
        System.out.println("<10> Write to a serialised file");
        System.out.println("<11> Read from a serialised file");
        System.out.println("<12> Write to a CSV file");
        System.out.println("<13> Read from a CSV file");

		System.out.println("<14> Exit");

        System.out.print("\nEnter the required function : ");
        userInp = sc.nextInt();



        switch(userInp)
		{
			    case 1:
				    System.out.println("\nEnter an input key for the Tree : ");
		        	keyValue = sc.nextInt();

                    System.out.println("\nEnter an value for the entered key : ");
		        	data = sc.nextInt();


                   System.out.println( "\nAttempting to find() key "+ keyValue +" now\n" );
                   
                        DSATree.insert(keyValue, data);
               
                        System.out.println("Tree after the input : ");
                        DSATree.print();
                        System.out.println();
                   
                    
				break;

		        case 2:
                
                    System.out.println("\nEnter a key to find : ");
                    keyValue = sc.nextInt();
                    data = DSATree.find(keyValue);

                    System.out.println("\n key "+ keyValue +" found! \n Value of the key : " + data +"\n");
          
              
				break;

                case 3:
                height = DSATree.height();

                System.out.println("Height of tree : \n" + height);
                DSATree.print();
                System.out.println();


				break;
		        case 4:

                System.out.println("\nEnter a key to delete : ");
                keyValue = sc.nextInt();
                DSATree.delete(keyValue);

                System.out.println("\nTree after the deleting key "+keyValue+" : \n");
                DSATree.print();

				break;

                case 5:
                System.out.println("\nTree after post-order Traversal : \n");
                DSATree.displaypostTree();
                System.out.println();

                System.out.println("\nTree after pre-order Traversal : \n");
                DSATree.displaypreTree();
                System.out.println();

                System.out.println("\nTree after in-order Traversal : \n");
                DSATree.displayTree();
                System.out.println();

				break;

			    case 6:
                System.out.println("\nBalanced percentage of the tree : "+DSATree.balance()+ "%");
                System.out.println();

                break;

                case 7:
                System.out.println("\n");
               
                DSATree.print();
                System.out.println();
                break;

                case 8:
                data = DSATree.find(DSATree.min());
                System.out.println("Minimum key : "+DSATree.min() + ", value : " + data);
                System.out.println();

                break;

                case 9:
                data = DSATree.find(DSATree.max());
                System.out.println("Maximum key : "+DSATree.max() + ", value : " + data);
                System.out.println();
               

                break;

                 case 10:
                 
                 writeSerial(DSATree);
                 System.out.println();

                 break;

                case 11:
                  
                DSATree =readSerial();
                System.out.println();
                break;

                case 12:

                writeCSV(DSATree);    
                System.out.println();       
                break;

                case 13:
                readCSV(DSATree);  
                System.out.println();     
                 break;

                case 14:
                System.out.println("\nThank you! for using this program.");
                break;

                default :
                System.out.println("\nInvalid Selection!! please enter a choice between 0 and 6");


		}
    }
  }

  public static void readCSV( DSABinarySearchTree tree )
    {
        String fileName;
        FileInputStream strm = null;
        InputStreamReader rdr;
        BufferedReader bfr;
        Scanner sc = new Scanner( System.in );
        String line;
        String[] lineArr = new String[ 2 ];
        int key, value;

        System.out.print( "Enter file name to import : " );
        fileName = sc.nextLine();

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
                value = Integer.parseInt( lineArr[1] );

                tree.insert( key, value );

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


    public static void writeCSV( DSABinarySearchTree Dtree )
    {
        String fileName;
        FileOutputStream strm = null;
        PrintWriter pw;
        int order;
        Scanner sc = new Scanner( System.in );
        DSAQueue queue = new DSAQueue();
        int i = 1;

        System.out.println( "Enter file name to include : " );
        fileName = sc.nextLine();

        try
        {
            strm = new FileOutputStream( fileName );
            pw = new PrintWriter( strm );

            System.out.print( "Select traversal:\n[1] Preorder\n" +
                "[2] Inorder\n[3] Postorder\n > " );
            order = sc.nextInt();

            switch( order )
            {
                case 1:
                {
                    queue = Dtree.preOrder();
                    break;
                }
                case 2:
                {
                    queue = Dtree.inorder();
                    break;
                }
                case 3:
                {
                    queue = Dtree.Postorder();
                    break;
                }
                default:
                {
                    System.out.println( "Invalid selection, using inorder" );
                    queue = Dtree.inorder();
                }
            }

            for( Object o : queue )
            {
                pw.println( o );
                i++;
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

    public static DSABinarySearchTree readSerial()  throws IllegalArgumentException 
    {
        FileInputStream fileStrm = null;
        ObjectInputStream objStrm;
        String fileName;
        DSABinarySearchTree tree = null;
        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter a file name to import :");
        fileName = sc.nextLine();

        try
        {
            fileStrm = new FileInputStream( fileName );
            objStrm = new ObjectInputStream( fileStrm );
            tree = ( DSABinarySearchTree )objStrm.readObject();

         
               
          
           
            

            objStrm.close();
            System.out.println( "Tree read successfully" );
        }
        catch( ClassNotFoundException e )
        {
            System.out.println( 
                "Error occured, file is not the correct class" );
   
        }
        catch( IOException e )
        {
            System.out.println( "Error occured" );
            e.printStackTrace();
            if( fileStrm != null )
            {
                try
                {
                    fileStrm.close();
                }
                catch( Exception e2 )
                {
                    System.out.println( "File cannot be closed :(" );
                }
            }
        }
        return tree;
    }

    public static void writeSerial( DSABinarySearchTree tree ) throws IOException
    {
        FileOutputStream fileStrm = null;
        ObjectOutputStream objStrm;
        String fileName;
        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter file name: " );
        fileName = sc.nextLine();

      try{
            fileStrm = new FileOutputStream( fileName );
            objStrm = new ObjectOutputStream( fileStrm );
            objStrm.writeObject( tree );

            objStrm.close();
            System.out.println( "Tree saved successfully" );
    
      }
      catch(Exception e)
      {
        throw new IllegalArgumentException("Unable to save object to file");

      }
        
    }

}



