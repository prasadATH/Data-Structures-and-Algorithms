import java.util.*;


public class DSALinkedList
{

     public class DSAListNode
{
     Object value;
     DSAListNode next;



     public DSAListNode(Object inValue)

     {
          value = inValue;
          next =null;
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




}
     DSAListNode head;

     public DSALinkedList()
     {
           head = null;
     }


     public boolean isEmpty()
     {
         boolean empty = false;
 
         empty = head == null;
 
         return empty;
     }

     public void insertFirst(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);

          if (isEmpty() == true)
          {
               head  = newNode;
          

          }
          else
          {
               newNode.next = head;
               head = newNode;
          }

     }

     public void insertLast(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);
          DSAListNode currNode;
          if (isEmpty() == true)
          {
               head  = newNode;
          }
          else
          {
           currNode =head;
     
               while(currNode.getNext() !=null )
               {
                    currNode = currNode.getNext();
               }
               currNode.setNext(newNode);
          }

     }

     public Object removeFirst()
     {
          Object nodeVal = null ;

          if(isEmpty()== true)
          {
               throw new IllegalArgumentException( "Error! List is empty" );
                   

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
          DSAListNode currNode;
          DSAListNode prevNode;

          Object nodeVal = null;

          if (isEmpty() == true)
          {
               throw new IllegalArgumentException( "Error! List is empty" );


          }
          else if(head.next ==null)
          {
              nodeVal =head.getValue();
             head = null;
          }
          else
          {    prevNode = null;
               currNode =head;
               while(currNode.getNext() !=null )
               {
                    prevNode = currNode;
                    currNode = currNode.getNext();

               }
               prevNode.setNext(null);
               nodeVal = currNode.getValue();

          }
        return nodeVal; 
     }
     public Object peekFirst()
     { 
          Object nodeVal = null;
          if(isEmpty() == true)
          {
               throw new IllegalArgumentException( "Error! List is empty" );
          }
          else
          {
               nodeVal = head.getValue();
          }
          return nodeVal;
     }

     public Object peekLast()
     { 
          DSAListNode currNode;

          Object nodeVal = null;
          if(isEmpty() == true)
          {
               throw new IllegalArgumentException( "Error! List is empty" );
          }
          else
          {
           currNode = head;

           while(currNode.getNext() !=null )
           {
               currNode = currNode.getNext();
           }

               nodeVal = currNode.getValue();
          }
          return nodeVal;
     }

}
