 /***************************************************************************
 *  FILE: TestLinkedList.java
 *  AUTHOR: Connor Beardsmore - 15504319
 *  UNIT: DSA120 Prac 8
 *  PURPOSE: Basic Test Harness For Linked List
 *  LAST MOD: 12/10/15
 *  REQUIRES: NONE
 ***************************************************************************/

import java.io.*;
import java.util.*;

public class UnitTestLinkedList
{
	public static void main(String args[])
	{
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        DSALinkedList ll = null;
        DSALinkedList testIteration = new DSALinkedList();

        String sTestString;
        Object nodeValue;

//---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor");
        System.out.println("=======================================");

        // TEST 1 : CONSTRUCTOR
        try {
            iNumTests++;
            ll = new DSALinkedList();
            System.out.print("Testing creation of DSALinkedList (isEmpty()): ");
            if (ll.isEmpty() == false)
                throw new IllegalArgumentException("Head must be null.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

//---------------------------------------------------------------------------

        System.out.println("\nTest inserting first and removing first (stack behaviour)");
        System.out.println("==========================================================");

        // TEST 2 : INSERT FIRST
        try {
            iNumTests++;
            System.out.print("Testing insertFirst(): ");
            ll.insertFirst("abc");
            ll.insertFirst("jkl");
            ll.insertFirst("xyz");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 3 : PEEK LAST
        try {
            iNumTests++;
            System.out.print("Testing peekLast(): ");
            sTestString = (String)ll.peekLast();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed   ");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 4 : REMOVE FIRST
        try {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "xyz")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "jkl")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 5 : IS EMPTY
        try {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            sTestString = (String)ll.removeFirst();
            System.out.println("FAILED");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

//---------------------------------------------------------------------------

        System.out.println("\nTest inserting last and removing first (queue behaviour)");
        System.out.println("========================================================");

        // TEST 6 : INSERT LAST()
        try {
            iNumTests++;
            System.out.print("Testing insertLast(): ");
            ll.insertLast("abc");
            ll.insertLast("jkl");
            ll.insertLast("xyz");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 7 : PEEK LAST
        try {
            iNumTests++;
            System.out.print("Testing peekFirst(): ");
            sTestString = (String)ll.peekFirst();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 8 : REMOVE FIRST
        try {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "jkl")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "xyz")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 9 : IS EMPTY 2
        try {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            sTestString = (String)ll.removeFirst();
            System.out.println("FAILED");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

        // TEST 10 : INSERT FIRST
        try {
            iNumTests++;
            System.out.print("Testing insertFirst()");
            ll.insertFirst("abc");
            ll.insertFirst("jkl");
            ll.insertFirst("xyz");
            iNumPassed++;
            System.out.println("passed");

        } catch(Exception e) { System.out.println("FAILED"); }

//---------------------------------------------------------------------------
System.out.println("\nTesting Iteration ");
System.out.println("========================================================");

        // TEST 10 : Iteration
    System.out.print("Testing iteration(): ");
    try{
        iNumTests++;

    testIteration.insertFirst(10);
    testIteration.insertFirst(20);
    testIteration.insertFirst(30);
    testIteration.insertFirst(40);

    Iterator iter = testIteration.iterator();
    int i = 0;
    int[] listArray = new int[4];


    while( iter.hasNext())
    {
        listArray[i] = (int)iter.next();
       // System.out.println( "array " +listArray[i]);
        i++;
    }

    if((listArray[0] == 40 )&&(listArray[1] == 30 )&&(listArray[2] == 20 )&&(listArray[3] == 10 ))
    {
        System.out.println("passed");
        iNumPassed++;

    }
}catch(Exception e)
 { System.out.println("FAILED" + e);
}


   

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");

        //test 11:savefile
        Scanner sc = new Scanner(System.in);

        String fileName ="";
        System.out.println( "Provide a file name to save to:" );
        fileName = sc.nextLine();
        ll.save(ll, fileName);
       



    }

    

//---------------------------------------------------------------------------




}
