import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter; 


public class test2
{
    public static void main(String [] args) throws IOException
    
    {
        
        dataInput();
    }



   public static void dataInput() throws IOException 
     {

  
              try {
     
    
                       String str;
                       int i=0;
                       int lineCount = fileSize();
                    

                       BufferedReader bffered = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\RandomNames.csv"));


                       System.out.println(lineCount );
                        String[] splitArry = new String[2];
                        int[] sortArray = new int[lineCount];
                        String[] sortArray2 = new String[lineCount];
     
    
                               while((str = bffered.readLine()) !=null)

                                       {
           
                                           String person = "";
                                           int index = 0;
       
               
                                                splitArry = str.split(",");           
        
                                               
                                                index = Integer.parseInt(splitArry[0]);
                                                sortArray[i] =index ;

                                                person = splitArry[1];
                                                sortArray2[i]=person ;
                                                i++;

                                                
                                                
                                                //System.out.println("ID : " + splitArry[0] + "\n" +  + splitArry[1]);
                                                
     

        
        
                                             sortFile sort1 = new sortFile(index,person);
                                           //  System.out.println("ID : " + sort1.getId() + "  Name : " + sort1.getName());


                                        }


                                             
                                             int temp=0;
                                             String temp2 ="";
                                            for (int pass = 0 ; pass<=((sortArray.length -1)-1); pass++ )
                                            {
                                                    for (int ii=0 ; ii <= ((sortArray.length -1 - pass)-1) ;ii++ )
                                                    {
                                                     if (sortArray[ii]>sortArray[ii+1] )
                                                                {
                                                                 temp = sortArray[ii] ;
                                                                 sortArray[ii] =  sortArray[ii+1];
                                                                 sortArray[ii+1] =  temp;  

                                                                 temp2 =sortArray2[ii] ;
                                                                 sortArray2[ii] =  sortArray2[ii+1];
                                                                 sortArray2[ii+1] =  temp2;  



                                                               
                                     
                                                                }
                                                                
                                                    }
                                                    
                                             }
                                            
                                             for(int n=0; n<lineCount; n++)
                                             {
                                                     System.out.println("ID : " + sortArray[n] +"  Name : " + sortArray2[n]);

                                             }

                                                     
               
   


   
          
                    }

                      // Catch block to handle the exceptions
                     catch (FileNotFoundException e)
                    {
                         System.out.println("An error occurred." + e);
                        
                    }

     }
 
     public static  int fileSize() throws IOException 
     {
          int lineCnt =0;

          try {
               BufferedReader bffR = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\RandomNames.csv"));
     
                       
             


               while((bffR.readLine()) !=null)

               {

                        lineCnt++;
               }
               System.out.println(lineCnt);

            
               bffR.close();
              

               
          }

          // Catch block to handle the exceptions
         catch (FileNotFoundException e)
        {
             System.out.println("An error occurred." + e);
            
        }
        return lineCnt;

      }

      public static void printSorted() {
          try {
            FileWriter myWriter = new FileWriter("Sorted.csv");
            myWriter.write(fileInp);
            myWriter.close();
            System.out.println("Converted answers will be available in the text file named 'Sorted.csv' in the same folder");
          }
           catch (IOException e)
           {
            System.out.println("An error occurred.");
            e.printStackTrace();
           }
        }
}