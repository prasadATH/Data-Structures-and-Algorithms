// FILE: baseConvo.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875
// PURPOSE: Implements recusion to convert a decimal number to number with any base.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling),
  //Source: https://www2.cs.arizona.edu/~mercer/Presentations/17B-RecursiveNumberConversion.pdf
// COMMENTS: The recursion concept uses simple meachanism of repeating 
//  a method until the method reaches it's base case.
// REQUIRES: None.
// Last Mod: 17th August 2022

import java.util.*;
import java.util.Scanner;

public class baseConvo{
	public static void main(String[] args)
	 {
		Scanner input = new Scanner(System.in);
  
		int decNum =0;
		int baseVal =0;
		String result= "";
		System.out.print("Enter decimal number(base 10) : ");
		decNum = input.nextInt();

		System.out.print("Enter base value to be converted : ");
		baseVal = input.nextInt();

		input.close();

		
		 result = baseCalc(decNum, baseVal);

		System.out.println("\n "+ decNum + " converted to the base " + baseVal + " is : ("   + result + ")" + baseVal);
		
	}

//Wrapper to not display the method of calculation
public static String baseCalc(int valOne, int valTwo) {
		
	String val ="";
	
			val= converter(valOne, valTwo );

		return val;
	}

	//Calculations for the solution
  //Source: https://www2.cs.arizona.edu/~mercer/Presentations/17B-RecursiveNumberConversion.pdf
	public static String converter(int pDecNum, int pBaseVal)
	 {
		String ans ="";
		String hex ="";


		if (pDecNum == 0)
		{
			ans = ("");

		}
        else if((pDecNum % pBaseVal) >9 && pBaseVal==16)
			{
				if((pDecNum % pBaseVal) == 10)
				{
                    hex = "A"; 
				}
				else if((pDecNum % pBaseVal) == 11)
				{
                    hex = "B"; 
				}
				if((pDecNum % pBaseVal) == 12)
				{
                   hex = "C"; 
				}
				else if((pDecNum % pBaseVal) == 13)
				{
                    hex = "D"; 

				}
				else if((pDecNum % pBaseVal) == 14)
				{
                    hex = "E"; 

				}
				else if((pDecNum % pBaseVal) == 15)
				{
                    hex = "F"; 

				}
				ans = (converter((pDecNum/pBaseVal), pBaseVal) + hex); 
			}
				
				

			
			else
			{
				ans = (converter((pDecNum/pBaseVal), pBaseVal) + (pDecNum % pBaseVal)); 
			}

		
		 return ans;
    }
}   
		

	

	



