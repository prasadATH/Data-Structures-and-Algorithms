import java.util.*;
import java.io.*;
import java.io.FileWriter;

public class DSALinkedList  implements Iterable, Serializable 
{
     public class DSAListNode implements Serializable 
   {
     Object value;
     DSAListNode next;
     DSAListNode prev;



     public DSAListNode(Object inValue)

     {
          value = inValue;
          next =null;
          prev =null;
     }

     public Object getValue()
     {
          return value;
     }

     
     public void setValue(Object inValue)
     {
           value = inValue;
     }

     public DSAListNode getNext()
     {
          return next;
     }

     
     public void setNext(DSAListNode newNext)
     {
           next = newNext;
     }

     public DSAListNode getPrev()
     {
          return prev;
     }

     
     public void setPrev(DSAListNode newPrev)
     {
          prev = newPrev;
     }



}

public  Iterator iterator() 
    { 
    return new ListIterator(this); 
    } 
    private class ListIterator implements Iterator
     {
           private DSAListNode iterNext;
              public ListIterator(DSALinkedList theList) 
    { 
         iterNext = theList.head;
    }

    // Iterator interface implementation
           public boolean hasNext() 
           { 
            return (iterNext != null) ;
           }

    public Object next() 
    { 
             Object value; 
            if (iterNext == null) 
            {
                     value = null; 
            }
            else
             { 
              value = iterNext.getValue(); 
                  iterNext = iterNext.getNext();
             } 
          return value; 
    } 
    public void remove() { throw new UnsupportedOperationException("Not supported"); } 
    } 
    


     DSAListNode head;
     DSAListNode tail;

     public DSALinkedList()
     {
           head = null;
           tail =null;
     }

     public boolean isEmpty()
     {
         boolean empty = false;
 
         empty = head == null;
 
         return empty;
     }

     public Object peekFirst()
     { 
          Object nodeVal =null;
          if(isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );
          }
          else
          {
               nodeVal = head.getValue();
          }
          return nodeVal;
     }

     public Object peekLast()
     { 
          Object nodeVal = null;
          if(isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );
          }
          else
          {
               nodeVal = tail.getValue();
          }
          return nodeVal;
     }




     public void insertFirst(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);

          if (isEmpty())
          {
               head  = newNode;
               tail = newNode;
          

          }
          else
          {
               newNode.setNext(head);
               head.setPrev(newNode);
              
               head = newNode;
          }

     }

     public void insertLast(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);

          if (isEmpty())
          {
               head  = newNode;
               tail = newNode;
          }
          else
          {
               tail.setNext(newNode);
               newNode.setPrev(tail);
               tail = newNode;
          }

     }

     public Object removeFirst()
     {
          Object nodeVal;

          if(isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );
                   

          }
          else if(head.getNext() ==null)
          {
               nodeVal =head.getValue(); 
               head = null;
               tail  =null;

          }
          else
          {
          
             nodeVal = head.getValue();
             head = head.getNext();

               
          }
          return nodeVal;
   
     }

     public Object RemoveLast()
     {
          Object nodeVal = null;

          if (isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );


          }
          else if(tail.getPrev() ==null)
          {
               nodeVal =tail.getValue(); 

              tail =null;
              head = null;
          }
          else
          {
               nodeVal =tail.getValue(); 
               tail.getPrev().setNext( null );
               tail = tail.getPrev();
          }
        return nodeVal; 
     }



     public void save(DSALinkedList inpObject, String filename)
     {
             FileOutputStream fileStrm;
             ObjectOutputStream objStrm;
      try {
                fileStrm = new FileOutputStream(filename); 
                objStrm = new ObjectOutputStream(fileStrm); 
     
     
                objStrm.writeObject(inpObject); 
     
                objStrm.close();
                System.out.println( "\nSaved to file successfully" );
          }
     
             catch (Exception e)
              { 
                  throw new IllegalArgumentException("\nUnable to save object to file"); 
              } 
     } 

     public DSALinkedList load(String filename) throws IllegalArgumentException
     {
             FileInputStream fileStrm;
             ObjectInputStream objStrm;
             DSALinkedList inObj;

      try {
               fileStrm = new FileInputStream(filename);  
               objStrm = new ObjectInputStream(fileStrm); 
               inObj = (DSALinkedList)objStrm.readObject();
     
     
                objStrm.close();
                System.out.println( "\nFile reload successful" );
          }

     
             catch (Exception e)
              { 
                  throw new IllegalArgumentException("Unable to Reload object to file"); 
              } 
              return inObj;
     } 

   

     
   









}
