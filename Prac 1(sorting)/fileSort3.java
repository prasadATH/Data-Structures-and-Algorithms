import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class fileSort3
{
    public static void main(String [] args) throws IOException
    
    {
        dataInput();
       
    }



   public static void dataInput() throws IOException 
     {

  
              try {
     
    
                        BufferedReader bffR = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\RandomNames.csv"));
     
                       
                        String strr ;
                        int nn =0;
                        int lineCount =0;
                        while((strr = bffR.readLine()) !=null)

                                       {
     
                                                lineCount++;
                                       }

                                       System.out.println(lineCount );
                                       bffR.close();

                        String[][] dataArrray = new String[lineCount][2];
     
                        String[] splitArry = new String[2];

                        String person = "";
                        String index = "";

                        BufferedReader bffered = new BufferedReader(new FileReader("C:\\Users\\Thilina\\Desktop\\RandomNames.csv"));

                         
     
    
                               while((strr = bffered.readLine()) !=null)

                                       {
           
                                     
       
                                                lineCount++;
                                                splitArry = strr.split(",");           
        
                                               
                                                index = splitArry[0];

                                                person = splitArry[1];


                                                 dataArrray[nn][0] = index;

                                                 dataArrray[nn][1] = person;
                                               // System.out.println(dataArrray[i][0] +"  "+ dataArrray[i][1] + "  " +   i);

                                                nn++;


                                                
                                                
                                                //System.out.println("ID : " + splitArry[0] + "\n" +  + splitArry[1]);
                                                
     

        
        
                                            // sortFile sort1 = new sortFile(index,person);
                                            // System.out.println("ID : " + sort1.getId() + "  Name : " + sort1.getName());
                                            //System.out.println("ID : " + index + "  Name : " +  person );



                                        }

                                       sortFile(dataArrray);
                    }

                   

                      // Catch block to handle the exceptions
                     catch (FileNotFoundException e)
                    {
                         System.out.println("An error occurred." + e);
                        
                    }


     }

     public static void sortFile(String psortArray[][]) throws IOException 
     {
                         
                         int index =0;
                         int index2 =0;
                         String temp2 = "";
                         int[] idArray = new int[pLineCount];

                         


                         for (int i = 0; i < psortArray.length; i++) { //this equals to the row in our matrix.
                              for (int j = 0; j < psortArray[i].length; j++)
                               { //this equals to the column in each row.
                                   if(j==0){
                                   index = Integer.parseInt(psortArray[i][0]);
                                   idArray[i] = index;
                                   }
                              }
                               //change line on console as row comes to end in the matrix.
                           }
                               /*  for (int ii=0 ; ii <= 4 ;ii++ )
                                       {
                                        index = Integer.parseInt(psortArray[ii][0]);
                                       


                                         idArray[ii] = index;


                                                          
                                        
                                       }
                                       */
                                      int temp =0 ;
                                      for (int pass = 0 ; pass<=((bubArry.length -1)-1); pass++ )
                                      {
                                              for (int ii=0 ; ii <= ((bubArry.length -1 - pass)-1) ;ii++ )
                                              {
                                               if (bubArry[ii]>bubArry[ii+1] )
                                                          {
                                                           temp = bubArry[ii] ;
                                                           bubArry[ii] =  bubArry[ii+1];
                                                           bubArry[ii+1] =  temp;  
                                       
                               
                                                          }
                                                          
                                              }
                                              
                                       }

               for(int n=0; n<4; n++)
               {
                    System.out.println(idArray[n]);
               }
               
        }

                             

                           /*   for (int i = 0; i < psortArray.length; i++) { //this equals to the row in our matrix.
                              for (int j = 0; j < psortArray[i].length; j++) { //this equals to the column in each row.
                                 System.out.print(psortArray[i][j] + " ");
                              }
                              System.out.println(); //change line on console as row comes to end in the matrix.
                           }
                           */




                         
}