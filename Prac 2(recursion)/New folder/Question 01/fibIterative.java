// FILE: fibIterative.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements iterative algorithm to calculate the fibonacci value of an input number.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling).
// REQUIRES: None.
// Last Mod: 17th August 2022

import java.util.*;
import java.util.Scanner;

public class fibIterative
{
	public static void main(String[] args) 
	{
		try{



		
		       Scanner input = new Scanner(System.in);
		       int inp =0;

		      System.out.print("Enter number : ");
	    	  inp = input.nextInt();

              input.close();

			          if ( inp >= 0 )
			             {
			                 	int fibo = fibIterativeCalc(inp);
				                System.out.println("Fibonacci number : " + fibo);

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
			
			 catch(Exception e)
			{
				System.out.println("Error! Please try again " +  e);
			
			}						 



		
	}

//Wrapper to not display the method of calculation
public static int fibIterativeCalc(int pInp)
	{
		return fibCalc(pInp);


	}

	//Calculations for the solution

	private static int fibCalc( int num )
	 {
		int fibVal = 0;
		int currVal = 1;
		int lastVal = 0;

		try{

		              	if (num == 0)
		                      	{
				                     fibVal = 0;
			                    }

			            else if (num == 1)
			                    {
			                     	fibVal = 1;

		                      	}
			            else {
			                 	for (int i = 2; i < num; i++)
			                          	{
                                              fibVal = (currVal) + lastVal;
				                        	  lastVal = currVal;
				                              currVal = fibVal;
				                        }
			                  }
			}
            
			 catch(Exception e)
			{
				System.out.println("Error! Please try again " +  e);
					
			}								 
			return fibVal;

	 }

	


}
