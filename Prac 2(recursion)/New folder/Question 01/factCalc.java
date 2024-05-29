// FILE: factCalc.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements recusion to calculate the factorial of an input number.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling)
// COMMENTS: The recursion concept uses simple meachanism of repeating 
//  a method until the method reaches it's base case.
// REQUIRES: None.
// Last Mod: 17th August 2022

import java.util.*;
import java.util.Scanner;

public class factCalc{
	public static void main(String[] args)
	 {
		 try{

		       Scanner input = new Scanner(System.in);
		       int inp =0;

		       System.out.println("Enter number : ");
	           inp = input.nextInt();
			   input.close();

		            if ( inp >= 0 )
		                 {
		                    	long fact = calcNFactorialRecursive(inp);
			                    System.out.println("Factorial value : " + fact);

		                 }
		            else
		                 {
		                    	System.out.println("Invalid input! Please enter a positive integer");

	                	 }
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input detected! Please enter an valid integer as your input \n System defined error : " +  e);
   
			}
			catch(StackOverflowError e)
			{
			   System.out.println("Error! System is detecting infinite output values \n Please try again" +  e);
 
			}			
			catch(Exception e)
			{
				System.out.println("Error! Please try again " +  e);

			}


			


	}

//Wrapper to not display the method of calculation
	public static long calcNFactorialRecursive(int pInp) {
		
		long val =0;
	
			val= calcNFactorialMethod(pInp);

		return val;
	}

		//Calculations for the solution

	private static long calcNFactorialMethod(int num) 
	{
		long result=0;

		try{

	                 	if ( num == 0 )
	                     	{
			                   result = 1;

		                    }
		                else
		                    {
			                   result = (num * calcNFactorialMethod(num-1));

		                    }
	        }
		     catch(StackOverflowError e)
			 {
				System.out.println("Error! System is detecting infinite output values \n Please try again" +  e);
  
			 }
			 catch(Exception e)
			 {
				 System.out.println("Error! Please try again " +  e);
 
			 }

		return result;
	}

	


}
