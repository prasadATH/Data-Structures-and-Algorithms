import java.util.*;

public class sortFile
{
 // Class records
 private int id;
 private String name;
 
 //parameter constructor
 public sortFile (int pId, String pName)
 {
  id = pId;
  name = pName;
  

 }
 //copy conctructor
 public sortFile (sortFile psortFile)
 {
   id = psortFile.getId();
   name = psortFile.getName();
 
    
 }
 

 
 //Following are the getters
 public int getId()
 {
     return id;
 }
 
 public String getName()
 {
     return name;
 }

 

 //setters

 public void setId(int pId)
 {
  id = pId;
 }

 public void setName(String pName)
 {
  name = pName;  
 }

 //toString method
 public String toString()
 {
     String sortFileString;

     sortFileString = "In No. : " + id + "\nName" + name;
     return sortFileString;
 }



 

 


}
