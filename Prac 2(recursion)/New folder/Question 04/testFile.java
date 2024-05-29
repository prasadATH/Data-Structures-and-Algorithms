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
    //calls the methods to display the results of the test runs.
public static void main(String[] args)
 {
     
    System.out.println();
  
    System.out.println(towerTest());
    System.out.println();



  }

//Tests solutions in tower of hanoi in towerSol.java file
public static String towerTest()
           {
                   towerSol test1 = new towerSol();
                   String testResult= "";

      
                        if(test1.towers(1, 1, 3).equals("Move Disk 1 from pole number 1 to pole number 3"))

                             {
                                testResult = ("Test of recursive algorithm for solving Tower of hanoi is Successful!");
        
                             }
           
                         else
                              {
                
                                 testResult = ("Test of recursive algorithm for solving Tower of hanoi is failed!\n Please check your alogorithm for errors");
        
                              }
                              return testResult;
            }








}


