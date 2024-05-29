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

    System.out.println(GCDenTest());
    System.out.println();





  }

//Tests calculation of Greatest common denominator in GCDeno.java file
public static String GCDenTest()
         {
            String testResult= "";

            int result =0;
            GCDeno test1 = new GCDeno();
            result = test1.gcdMethod(100, 1005);
    
               if(result ==5)
                     {
                        testResult = ("Test of recursive algorithm for calculating the Greatest Common Denominator is Successful!");
    
                      }
                else
                      {
                        testResult = ("Test of recursive algorithm for calculating the Greatest Common Denominator is failed!\n Please check your alogorithm for errors");
    
                      }
                      return testResult;

         }


}


