import java.util.*;
import java.io.*;
import java.io.FileWriter;



import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class DSABinarySearchTree implements Serializable
{
public class DSATreeNode implements Serializable
{
    int key;
    Object value;
    DSATreeNode leftChild;
    DSATreeNode rightChild;

    public DSATreeNode(int inpKey, Object inpValue) 
    {
        if((inpKey)==0)
        {
            throw new IllegalArgumentException("Key cannot be null"); 

        }else{
        key = inpKey;
        value = inpValue;
        leftChild = null;
        rightChild = null;
        }
    }

    public int getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public DSATreeNode getLeft()
    {
        return leftChild;
    }

    public DSATreeNode getRight()
    {
        return rightChild;
    }

    public void setLeft(DSATreeNode newLeft)
    {
        leftChild = newLeft;
    }

    public void setRight(DSATreeNode newRight)
    {
        rightChild = newRight;
    }

}

public DSATreeNode root;


public DSABinarySearchTree()
{
    root = null;
}

 public Object find(int inKey)
 {
    return findRec(inKey, root);
 }

 

 private Object findRec(int inpKey, DSATreeNode curNode)
 {
    Object val = null;
    
    if (curNode == null)
    {
        
        throw new NoSuchElementException("Key " + inpKey + " not found"); 
        
    
    }

    else if(inpKey==(curNode.getKey()))
    {
        val = curNode.getValue(); 
    }
    else if(inpKey <(curNode.getKey()))
    {
        val = findRec(inpKey, curNode.getLeft());  
    }
    else
    {
        val = findRec(inpKey, curNode.getRight()); 
       
    }
    return val; 
 }

 public Object insert(int inKey, Object inVal)
 {
    
   return  insertRec(inKey, inVal, root);

 }

 private DSATreeNode insertRec( int key, Object data, DSATreeNode currNode )
{
 DSATreeNode updateNode = currNode;

 if( currNode == null )
 {
     // Base case: Spot found
     updateNode = new DSATreeNode( key, data );
     if( root == null )
     {
         root = updateNode;
     }
 }
 else if( key == currNode.getKey() )
 {
     // Base case: Key already in the tree
     throw new IllegalArgumentException( 
         "Key already exists in tree" );
 }
 else if( key < currNode.getKey() )
 {
     // Recurse left
     currNode.setLeft( insertRec( key, data, currNode.getLeft() ) );
 }
 else
 {
     // Recurse right
     currNode.setRight( insertRec( key, data, currNode.getRight() ) );
 }

 return updateNode;
}

 public void delete(int inkey)
 {
     deleteRec(inkey, root);
 }

 private DSATreeNode deleteRec( int key, DSATreeNode currNode )
 {
     DSATreeNode updateNode = currNode;

     if( currNode == null )
     {
         // Base case: Not in the tree
         throw new NoSuchElementException( "Key " + key + " not found" );
     }

     else if( key == currNode.getKey())
     {
         // Base case: Key found
         updateNode = deleteNode( key, currNode );
     }
     else if( key < currNode.getKey() )
     {
         // Recurse left
         currNode.setLeft( deleteRec( key, currNode.getLeft() ) );
     }
     else
     {
         // Recurse right
         currNode.setRight( deleteRec( key, currNode.getRight() ) );
     }

     return updateNode;
 }

 public DSATreeNode deleteNode(int key, DSATreeNode dNode)
 {
    DSATreeNode updtNode = null;

    if((dNode.getLeft() ==null) && (dNode.getRight() ==null))
    {
       
        updtNode = null;
    }
    else if ((dNode.getLeft() !=null) && (dNode.getRight() ==null))
    {
        updtNode = dNode.getLeft();
    }
    else if((dNode.getLeft() ==null) && (dNode.getRight() !=null))
    {
        updtNode = dNode.getRight();
    }

    else if((dNode.getLeft() !=null) && (dNode.getRight() !=null))
    {
        updtNode = promoteSucc(dNode.getRight());
        if( updtNode != dNode.getRight())
        {
          updtNode.setRight(dNode.getRight());
        }
        updtNode.setLeft(dNode.getLeft());

    }
    return updtNode;
 }
 
 public DSATreeNode promoteSucc(DSATreeNode currentN)
   {
          DSATreeNode succ = currentN;
                if( currentN.getLeft() != null )
                     {
                            succ = promoteSucc( currentN.getLeft() );
                         if(succ == currentN.getLeft())
                              {
                                   currentN.setLeft(succ.getRight());
                               }

                     }
          return succ;
    }

public int height()
{
   return heightCalc(root);
}
public int heightCalc( DSATreeNode currN )
{
    int curHt, iLeftHt, iRightHt;

    if( currN == null )
    {
        curHt = -1;
    }
    else
    {
        iLeftHt = heightCalc( currN.getLeft() );
        iRightHt = heightCalc( currN.getRight() );

            curHt = Math.max( iLeftHt, iRightHt ) + 1;
    }

    return curHt;
}

public int min()
{
    return minRec(root); 
}
public int minRec( DSATreeNode currN )
{
    int minKey;

    if( currN.getLeft() != null )
    {
        minKey = minRec( currN.getLeft() );
    }
    else
    {
        minKey = currN.getKey();
    }

    return minKey;
}

public int max()
{
    return maxRec(root); 
}

public int maxRec( DSATreeNode currN )

{
    int maxKey;

    if( currN.getRight() != null )
    {
        maxKey = maxRec( currN.getRight() );
    }
    else
    {
        maxKey = currN.getKey();
    }

    return maxKey;
}

public DSAQueue inorder()
{
    DSAQueue inorderQueue = new DSAQueue();


    inorderRec(root, inorderQueue );

    return inorderQueue;
}




public void inorderRec( DSATreeNode root, DSAQueue queue )
{
    if( root != null )
    {
        inorderRec( root.getLeft(), queue );

        queue.enqueue( root.getKey()+","+root.getValue() );
    

        inorderRec( root.getRight(), queue );
    }
}

public DSAQueue Postorder()
{
    DSAQueue postorderQueue = new DSAQueue();

    postorderRec(root, postorderQueue );

    return postorderQueue;
}
public void postorderRec( DSATreeNode root, DSAQueue queue )
{
    if( root != null )
    {
        postorderRec( root.getLeft(), queue );

        postorderRec( root.getRight(), queue );
 
      
        queue.enqueue( root.getKey()+","+root.getValue() );
       
    }
}

public DSAQueue preOrder()
{
    DSAQueue preOrderQueue = new DSAQueue();

    preorderRec(root, preOrderQueue );

    return preOrderQueue;
}



public void preorderRec( DSATreeNode root, DSAQueue queue )
{
    if( root != null )
    {
        queue.enqueue( root.getKey()+","+root.getValue() );
       

        postorderRec( root.getLeft(), queue );

        postorderRec( root.getRight(), queue );

    }
}

public double balanceH()
{
 return balance();
}

public double balance()
{
    int lHeight, RHeight, rootHt, diffHt;
    double bal;

    if( root == null )
    {
        bal = 1;
    }
    else
    {
        lHeight = heightCalc( root.getLeft() );
        RHeight = heightCalc( root.getRight() );
        rootHt = heightCalc(root);
        diffHt = Math.abs(lHeight - RHeight);
        bal = 1 - ( (double)diffHt ) / ( (double)rootHt );
    }

    return bal;
}

public void displayTree()
{
/*    DSAQueue inorderQueue = new DSAQueue();

    inorderRec( root, inorderQueue ); */

    for( Object o : inorder() )
    {
        System.out.print( o + " " );
    }
    System.out.println();
}



public void displaypreTree()
{

    inorderRec( root, preOrder() );

    for( Object I : preOrder() )
    {
        System.out.print( I + " " );
    }
    System.out.println();
}

public void displaypostTree()
{

    inorderRec( root, Postorder());

    for( Object o : Postorder())
    {
        System.out.print( o + " " );
    }
    System.out.println();
}

public void print()
{
    printTree(root);
}

public void printTree(DSATreeNode root){
    if (root==null) return;
    printTree(root.getLeft());
    System.out.print("\n\n"+root.getKey() + "\n" +  "value :" + root.getValue());
    printTree(root.getRight());
}

    







}


