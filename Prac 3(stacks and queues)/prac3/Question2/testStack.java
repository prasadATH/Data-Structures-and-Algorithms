// FILE: testStack.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875

import java.util.*;

public class testStack
{
    public static void main( String[] args )
    {
        // Capacity Test
        DSAStack stack = new DSAStack(10);
        String fileName = "stackDataTest";

        System.out.println( "\nTesting push function" );
        System.out.println( "============================" );

            System.out.print( "pushing 10 integers ......\n" );
            for( int i = 0; i < 5; i++ )
            {
                stack.push(10 + (i*10));
            }

            for( int i = 0; i < 5; i++ )
            {
                stack.push(100 + (i*100));
            }

            if(stack.getCount() ==10)
            {
                System.out.print( "push function test successful!\n" );

            }
          //Testing isFull() method
          System.out.println( "\nTesting isFull method" );
          System.out.println( "==========================" );
            
            if(stack.isFull() ==true)
            {
              System.out.println( "isFull function test successful\n" );
      
             }
             else
             {
              System.out.println( "isFull function test failed" );
             }

    


        // Pop/Top Test
        System.out.println( "\nTesting pop and top" );
        System.out.println( "==========================" );
        
        String outStr = new String();
        if(stack.top().equals(500))
        {
            outStr += "Top function test successful ";
        }
        else
        {
            outStr += "Top function test failed";
        }
       // outStr += " (Expected " + 500 + ", actual " + stack.top() + ") ";

        if((stack.pop()).equals(500) && stack.getCount() ==9 )
        {
            outStr += "\nPop function test successful ";
        }
        else
        {
            outStr += "Pop function test failed";
        }
       // outStr += " (Expected " + 400 + ", actual " + stack.top() + ") ";
        System.out.println( outStr + "\n" );

        System.out.println( "Popping all " + stack.getCount()+ " values \n"  );
        // Empty Test
        System.out.println( "Testing isEmpty function" );
        System.out.println( "============================" );
        

            for( int i = 0; i < 9; i++ )
            {
                stack.pop();
            }

        
      
      if(stack.isEmpty() ==true)
      {
        System.out.println( "isEmpty function test successful\n" );

       }
       else
       {
        System.out.println( "isEmpty function test failed" );
       }

    }
}