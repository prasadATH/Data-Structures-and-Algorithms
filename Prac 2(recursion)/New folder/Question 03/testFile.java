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
   
    System.out.println(baseConvoTest());
    System.out.println();





  }

//Tests calculation of decimal value to any base in baseConvo.java file
public static String baseConvoTest()
           {
                 String result ="";
                 String testResult= "";

                 baseConvo test2 = new baseConvo();
                 result = test2.converter(300, 16);
        
                      if(result.equals("12C"))
                          {
                            testResult = ("Test of recursive algorithm for converting a Decimal (Base10) to any Base (2-16) is Successful!");
        
                           }
                      else
                           {
                            testResult = ("Test of recursive algorithm for converting a Decimal (Base10) to any Base (2-16) is failed!\n Please check your alogorithm for errors");
        
                            }
                            return testResult;

           }


}


