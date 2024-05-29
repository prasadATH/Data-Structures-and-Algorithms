// FILE: DSAStack.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875


import java.util.*;


public class DSAStack
{
     Object[] stackArray;
     int count =0;
     int defCapacity = 100;

     public DSAStack()
     {
          stackArray = new Object[defCapacity];
          count =0;
     }

     public DSAStack(int maxElements)

     {
          stackArray = new Object[maxElements];
          count =0;
     }

     public int getCount()
     {
          return count;
     }

     public boolean isEmpty()
     {
          if(getCount() ==0)
          {
               return true;
          }

          else 
          {
               return false;
          }
     }

     public boolean isFull()
     {
          if(getCount() == stackArray.length)
          {
               return true;
          }
          else
          {
              return false;
          }
     }

     public void push(int value)
     {
          if(isFull() ==true)
          {
               System.out.println("Error! Stack contains maximum amount of values it can contain ");
               
          }
          else
          {
               stackArray[getCount()] = value;
               count =count +1;
          }
     }

     public Object pop()
     {   Object topVal =top();

          count = (count-1);
          stackArray[count] =  null;

        

        return topVal;


     }

     public void popAll(int val)
     {
          

          for(int ii=0; ii< val; ii++)
          {
               count = (count-1);
               stackArray[count] =  null;
          }


    

     }

     public Object top()
     {    Object topVal = 0;
          
          if (isEmpty() ==true)
          {
               System.out.println("Error! Stack is Empty");
          }
          else
           {

               topVal = stackArray[count -1] ;
              // System.out.println("top value is : " + topVal);
           }
           return topVal;
          
     }

     

     public void printVal()
     {
          for(int i = 0 ; i<(stackArray.length) ; i++)
          {
               System.out.print(stackArray[i]);     
          }
     }
}
