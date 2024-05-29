// FILE: GCDeno.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements the testing procedures for the codes in Worksheet02.
// COMMENTS: All Tested codes are successfully implemented.
// REQUIRES: None.
// Last Mod: 17th August 2022


import java.util.*;
public class testFile


{
    //calls all the methods to display the results of the test runs.
public static void main(String[] args)
 {
     
    System.out.println();
    System.out.println(factrecursive());
    System.out.println();

    System.out.println(factIterative());
    System.out.println();


    System.out.println(fibRecursive());
    System.out.println();

    System.out.println(fibIterative());
    System.out.println();




  }//Tests calculation of factorial in factCalc.java file
  public static String factrecursive()
            {
                String testResult= "";

                {
                    long result =0;
                factCalc test1 = new factCalc();
                result = test1.calcNFactorialRecursive(4);
            
                if(result ==24)
                {
                    testResult = ("Test of recursive algorithm for Factorial value calculation is Successful!");
            
                }
                else
                {
                    testResult = ("Test of recursive algorithm for Factorial value calculation is failed!\n Please check your alogorithm for errors");
            
                }
              }
            return testResult;


            } 
//Tests calculation of factorial in factIterative.java file
 public static String factIterative()
            {
                String testResult= "";

                {
                    long result =0;
                    factIterative test2 = new factIterative();
                    result = test2.calcNFactorialIterative(5);
            
                if(result ==120)
                {
                    testResult = ("Test of Iterative algorithm for Factorial value calculation is Successful!");
            
                }
                else
                {
                    testResult = ("Test of Iterative algorithm for Factorial value calculation is failed!\n Please check your alogorithm for errors");
            
                }
              }
            return testResult;


            } 

//Tests calculation of fibonacci sequence values in fibonacci.java file
public static String fibRecursive()

         {
                    String testResult= "";
                    int result =0;

                    fibonacci test1 = new fibonacci();

                    result = test1.fibRecursive(7);

                         if(result ==13)
                               {
                                    testResult = ("Test of recursive algorithm for Fibonacci sequence generator is Successful!");

                                }
                         else
                                {
                                    testResult = ("Test of recursive algorithm for Fibonacci sequence generator is failed!\n Please check your alogorithm for errors");

                                 }
                       return testResult;

         }
//Tests calculation of fibonacci sequence values in fibIterative.java file
public static String fibIterative()

         {
                    String testResult= "";
                    int result =0;

                    fibIterative test4 = new fibIterative();

                    result = test4.fibIterativeCalc(15);

                         if(result ==377)
                               {
                                    testResult = ("Test of Iterative algorithm for Fibonacci sequence generator is Successful!");

                                }
                         else
                                {
                                    testResult = ("Test of Iterative algorithm for Fibonacci sequence generator is failed!\n Please check your alogorithm for errors");

                                 }
                       return testResult;

         }


}


