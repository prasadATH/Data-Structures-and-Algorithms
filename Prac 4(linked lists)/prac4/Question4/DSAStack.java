import java.util.*;
import java.io.*;


public class DSAStack implements Iterable, Serializable 
{
    public DSALinkedList stackList;

     public DSAStack()
     {
        stackList = new DSALinkedList();
     }


     public boolean isEmpty()
     {
       return stackList.isEmpty();
     }
     
     public int count()
     {
        int count =0;
        for(Object collect :stackList )
        {
            count++;
        }
        return count;
     }



     public void push(Object value)
     {
         stackList.insertFirst(value);
    }

     public Object pop()
     {

            return stackList.removeFirst();
     }

     public Object top()
     {  
          
        return stackList.peekFirst();

          
     }

     public Iterator iterator()
     {  
          
        return stackList.iterator();

     }


     public void printStack()
     {
        int count =0;
        for(Object collect :stackList )
        {
            count++;
            System.out.println("Element "+ (count) +" is :"+ collect);
        }
     }

     public void saveFile(DSALinkedList obj, String file)
     {
      stackList.save(obj, file);
     }

     public void loadFile(String file)
     {
      stackList.load(file);
     }
  

}
