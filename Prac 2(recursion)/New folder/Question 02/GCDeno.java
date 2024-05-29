// FILE: GCDeno.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements recusion to calculate the Greatest common denominator of 2 numbers.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling),
// COMMENTS: The recursion concept uses simple meachanism of repeating 
//  a method until the method reaches it's base case.
// REQUIRES: None.
// Last Mod: 17th August 2022

import java.util.*;
import java.util.Scanner;

public class GCDeno{
	public static void main(String[] args)
	 {
		try{

		          Scanner input = new Scanner(System.in);
		          int numOne =0;
		          int numTwo =0;

		          System.out.print("Enter first number : ");
		          numOne = input.nextInt();

	        	  System.out.print("Enter Second number : ");
		          numTwo = input.nextInt();

		          input.close();

		
		          int ans = gcdMethod(numOne, numTwo);

		          System.out.println("\nGreatest common denominator of "+ numOne + " and " + numTwo+ " is : "   + ans);

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
				System.out.println("Error! Please try again  \n Error : " +  e);
	
			}				  
		
	}

//Wrapper to not display the method of calculation
	public static int gcdMethod(int valOne, int valTwo)
	{
		return calcGCDenominator(valOne, valTwo);
	}

	//Calculations for the solution

	private static int calcGCDenominator(int pNumOne, int pNumTwo)
	 {
		int gcd =0;
		try{


		                if (pNumTwo == 0)  
		                   {
		                     	gcd = pNumOne;  
						   }
		
                        else
		                   {
		                    	gcd = calcGCDenominator(pNumTwo, pNumOne%pNumTwo);   

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
		 return gcd;
    }
}   
		

	

	



