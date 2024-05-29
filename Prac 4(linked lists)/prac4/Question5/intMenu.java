import java.util.*;
import java.io.*;

public class intMenu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int userInp =0;
        int value =0;
        String fName ="";
        DSALinkedList listData = new DSALinkedList();

        
 while(userInp !=8)
    {
        System.out.println("\n<1> InsertFirst on the list ");
        System.out.println("<2> InsertLast on the list ");
		System.out.println("<3> RemoveFirst on the list");
        System.out.println("<4> RemoveLast on the list");
		System.out.println("<5> Display the list");
		System.out.println("<6> Write to a serialised file");
		System.out.println("<7> Read from a serialised file");
		System.out.println("<8> Exit");

        System.out.print("\nEnter the required function : ");
        userInp = sc.nextInt();




        switch(userInp)
		{
			    case 1:
				    System.out.println("Enter an input for the list : ");
		        	value = sc.nextInt();
                    listData.insertFirst(value);

                    System.out.println("List after the input : ");
                    printList(listData);
                    
				break;

		        case 2:
                    System.out.println("Enter an input for the list : ");
                    value = sc.nextInt();
                    listData.insertLast(value);

                    System.out.println("List after the input : ");
                    printList(listData);
              
				break;

                case 3:
                listData.removeFirst();

                System.out.println("List after the removal : ");
                printList(listData);


				break;

		        case 4:
                listData.RemoveLast();

                System.out.println("List after the removal : ");
                printList(listData);

				break;

                case 5:
                    printList(listData);
				break;
 
			    case 6:
                System.out.println("Enter a file name to include :");
                fName = sc.next();
                listData.save(listData, fName);
                break;

                case 7:
                System.out.println("Enter the file name to be scanned :");
                fName = sc.next();
                listData.load(fName);
                break;

                case 8:
                System.out.println("\nThank you! for using this program.");
                break;

                default :
                System.out.println("\nInvalid Selection!! please enter a choice between 0 and 6");


		}
    }



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
}
