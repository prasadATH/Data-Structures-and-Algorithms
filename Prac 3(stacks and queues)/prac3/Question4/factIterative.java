// FILE: factIterative.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements Iterative solution to calculate the factorial of an input number.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling).
// REQUIRES: None.
// Last Mod: 13th August 2022

import java.util.*;
import java.util.Scanner;

public class factIterative{
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
							

		                    	long fact = calcNFactorialIterative(inp);

							
			                    System.out.println("\nFactorial value : " + fact);

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
	public static long calcNFactorialIterative(int pInp) {

		
		long val =0;
	
			val= calcNFactorialMethod(pInp);

		return val;
	}

		//Calculations for the solution

	private static long calcNFactorialMethod(int num) 
	{
		long factorial = 1;
		String pushVal="";

		try{		DSAStack test1 = new DSAStack(num);

				  
                     for (int i = num; i >= 1; i--) 
					 {
                         factorial *= i;
						 pushVal = String.valueOf(i);

						//System.out.println(i);

						test1.push((num) +" * factorial(" + (num-1) + ")\n");
						
						}
						test1.printVal();
                        
                        test1.popAll(num);

						System.out.println("\nStack after popping ");
						test1.printVal();


				}

			 catch(Exception e)
			 {
				 System.out.println("Error! Please try again " +  e);
 
			 }

			 return factorial;

	 }

	


}
