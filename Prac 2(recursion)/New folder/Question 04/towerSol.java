// FILE: towerSol.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
// PURPOSE: Implements recusion to provide step by step commands in solving Tower of hanoi.
// REFERENCE: Lecture notes 2022 (COMP1002)(Recursion, Wrappers, Exeption handling),
// COMMENTS: The recursion concept uses simple meachanism of repeating 
//  a method until the method reaches it's base case.
// REQUIRES: None.
// Last Mod: 17th August 2022

import java.util.*;
import java.util.Scanner;

public class towerSol{
	public static void main(String[] args)
	 {
		try{

		          Scanner input = new Scanner(System.in);
		          int diskNum =0;
		          int src =0;
				  int dest =0;
				  String ans = "";


		          System.out.print("\nEnter number of disks to be moved : ");
		          diskNum = input.nextInt();

	        	  System.out.print("\nEnter starting pole number : ");
		          src = input.nextInt();

				  System.out.print("\nEnter destination pole number : ");
		          dest = input.nextInt();


		          input.close();

		
		          ans = towers(diskNum, src, dest);


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

	public static String towers(int valOne, int valTwo, int valThree)
	{
		 return towerLogic(valOne, valTwo, valThree,1);

	}


	private static String towerLogic(int pDiskNum, int pSrc, int pDest, int recLevel)
	 {
		int temp = 0;
		String sol = "";
		try{
			String indent = "";
              for (int i = 0; i < recLevel - 1; i++) 
			  {
				indent += "\t";
              }


		                if (pDiskNum == 1)  
		                   {
							sol = transferDisk(pDiskNum, pSrc, pDest, recLevel, indent);  
						   }
		
                        else
		                   {
							   temp = (6 - pSrc - pDest); 

							   towerLogic((pDiskNum-1), pSrc, temp, (recLevel+1));

							  sol = transferDisk((pDiskNum), pSrc, pDest, recLevel, indent );  

							   towerLogic((pDiskNum-1), temp, pDest, (recLevel+1));
							   

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
			return sol;					   

    }

	private static String transferDisk(int disk, int source, int desination ,int pRecLevel, String pIndent)
	{
		String wanted= "";
		System.out.println(pIndent + "Recursion level = " + pRecLevel);

		System.out.println(pIndent +"Move Disk " + disk + " from pole number " + source + " to pole number " + desination );
		System.out.println(pIndent+ "n = " + disk + "src = " + source + "dest = " + desination );
		System.out.println("");
		System.out.println("");

		wanted = (pIndent +"Move Disk " + disk + " from pole number " + source + " to pole number " + desination );
		return wanted;

	}


}   
		

	

	



