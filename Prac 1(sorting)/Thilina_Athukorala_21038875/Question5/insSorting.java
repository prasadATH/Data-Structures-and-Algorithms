
// FILE: insSorting.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
// PURPOSE: Implements Insertion sorting algorithm to sort a .csv file
// REFERENCE: Lecture notes 2022(COMP1007)(Semester 1), Lecture notes 2022 (COMP1002)(Sorting Algorithms).
// COMMENTS: The algorithm uses simple method of checking each element and adding it to the 
//  correct place comparing values in either side.
// REQUIRES: Makes use of sortFile.java which contains a class
// used to contain data in the RandomNames7000.csv file.
// Last Mod: 11th August 2022
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter; 


public class insSorting
{
    public static void main(String [] args) throws IOException
    
    {
            //Method to input data from the RandomNames7000.csv file.
            dataInput();
    }



   public static void dataInput() throws IOException 
     {

              try {
                       String str;

                       //Count to increase number of rows in Assigning values to 'idSort' array and 'nameSort' array.
                       int i=0;

                       //Obtains the number of rows in the file to create the 'idSort' array and 'nameSort' array corresponding to the record count.
                       int lineCount = fileSize();

                     // Array to Split the data in RandomNames7000.csv file .
                       String[] splitArry = new String[2];

                       //Integer array to Store ID values.
                       int[] idSort = new int[lineCount];

                       //String array to store the names.
                       String[] nameSort = new String[lineCount];
                    
                    // REFERENCE: Lecture notes 2022(COMP1007)(Semester 1).
                     //Reading the RandomNames7000.csv file using BufferedReader. 
                        BufferedReader bffered = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\dsa final\\RandomNames7000.csv"));

                       System.out.println("Number of records detected : " + lineCount);
                       
                               while((str = bffered.readLine()) !=null)

                                       {
           
                                           String person = "";
                                           int index = 0;

                                                 //Split the array using " ' " in .csv file.
                                                splitArry = str.split(",");           
        
                                                //Convert the String data values to integers.
                                                index = Integer.parseInt(splitArry[0]);
                                                // pass the above converted values to the Integer array created to Store ID values .
                                                idSort[i] =index ;
                                                

                                                person = splitArry[1];
                                                // pass the above converted values to the String array used to store the names.
                                                nameSort[i]=person ;
                                                i++;

                                             //created an object by assiging the values from the RandomNames7000.csv file. 
                                             sortFile sort1 = new sortFile(index,person);
                                           //  System.out.println("ID : " + sort1.getId() + "  Name : " + sort1.getName());

                                        }
                                            //Method to sort the ID values obtained from the file and Align the names accordingly.
                                            sorting(idSort,nameSort);

                                             //Method to store the sorted values to another .csv file.
                                             printSorted(idSort,nameSort, lineCount);
                                            
                                           
                    }

                      // Catch block to handle the exceptions
                     catch (FileNotFoundException e)
                    {
                         System.out.println("An error occurred! Please check your file location. " + e);
                         e.printStackTrace();

                        
                    }

     }
 
     public static  int fileSize() throws IOException 
     {
          int lineCnt =0;

          try {
            // REFERENCE: Lecture notes 2022(COMP1007)(Semester 1).
            //read the RandomNames7000.csv file to obtain the row count.
            BufferedReader bffR = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\dsa final\\RandomNames7000.csv"));

                 while((bffR.readLine()) !=null)
                                  {
                                    //Get the row count.
                                    lineCnt++;
                                  }
                     bffR.close();
              

               
              }
   
          // Catch block to handle the exceptions
         catch (FileNotFoundException e)
        {
             System.out.println("An error occurred in calculation of the size of file(Number of lines)." + e);
             e.printStackTrace();
            
        }
        return lineCnt;

     }

     public static void sorting(int[] pIdSort, String[] pNameSort)
     {
      // REFERENCE: Lecture notes 2022 (COMP1002)(Sorting Algorithms)
        //Insertion sorting Algorithm.
        int temp =0 ;
        int minIdx =0;
        String temp2 ="";
        for (int nn = 0 ; nn<=((pIdSort.length -1)-1); nn++ )
          {
             minIdx = nn;
                   for (int ii=(nn+1) ; ii <= (pIdSort.length -1) ;ii++ )
                 {
                     if (pIdSort[ii]<pIdSort[minIdx] )
                           {
                               minIdx = ii;
                           }
                 }
                            //Swapping the ID values.
                            temp = pIdSort[minIdx] ;
                            pIdSort[minIdx] =  pIdSort[nn];
                            pIdSort[nn] =  temp;  

                           //Swap the coresponding names while swapping integer ID values.
                            temp2 = pNameSort[minIdx] ;
                            pNameSort[minIdx] =  pNameSort[nn];
                            pNameSort[nn] =  temp2;  
                          
          }
       } 
     //Method to print the sorted values to a .csv file.
     public static void printSorted(int[] pIdSort, String[] pNameSort, int pLineCount)
       {
          try {
            // REFERENCE: Lecture notes 2022(COMP1007)(Semester 1).
                     FileWriter myWriter = new FileWriter("Sorted.csv");

                     for(int n=0; n<pLineCount; n++)
                                {
                                     myWriter.write( pIdSort[n]+ "," + pNameSort[n] + "\n" );
                                }

                    myWriter.close();
                    System.out.println("Converted answers will be available in the text file named 'Sorted.csv' in the same folder");
              }
           catch (IOException e)
              {
                 System.out.println("An error occurred in the process of Writing to the file.");
                 e.printStackTrace();
              }
        }


     }