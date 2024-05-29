import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class fileSort
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
                       
                        String[] splitArry = new String[2];
     
    
                               while((strr = bffR.readLine()) !=null)

                                       {
           
                                           String person = "";
                                           int index = 0;
     
               
                                                splitArry = strr.split(",");           
        
                                               
                                                index = Integer.parseInt(splitArry[0]);

                                                person = splitArry[1];

                                                
                                                
                                                //System.out.println("ID : " + splitArry[0] + "\n" +  + splitArry[1]);
                                                
     

        
        
                                             sortFile sort1 = new sortFile(index,person);
                                             System.out.println("ID : " + sort1.getId() + "  Name : " + sort1.getName());


                                        }
   


   
          
                    }

                      // Catch block to handle the exceptions
                     catch (FileNotFoundException e)
                    {
                         System.out.println("An error occurred." + e);
                        
                    }

     }
}