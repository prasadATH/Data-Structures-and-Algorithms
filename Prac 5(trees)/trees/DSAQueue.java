import java.util.*;
import java.io.*;


public class DSAQueue implements Iterable, Serializable 
{
    public DSALinkedList QueueList;

     public DSAQueue()
     {
      QueueList = new DSALinkedList();
     }


     public boolean isEmpty()
     {
       return QueueList.isEmpty();
     }
     
     public int count()
     {
        int count =0;
        for(Object collect :QueueList )
        {
            count++;
        }
        return count;
     }



     public void enqueue(Object value)
     {
      QueueList.insertLast(value);
    }

     public Object dequeue()
     {

            return QueueList.removeFirst();
     }

     public Object peek()
     {  
          
        return QueueList.peekFirst();

          
     }

     public Iterator iterator()
     {  
          
        return QueueList.iterator();

     }


     public void printQueue()
     {
        int count =0;
        for(Object collect :QueueList )
        {
            count++;
            System.out.println("\nElement "+ (count) +" is :"+ collect);
        }
     }

     public void saveFile(String file)
     {
      QueueList.save(QueueList, file);
     }

     public void loadFile(String file)
     {
      QueueList.load(file);
     }
  

}
