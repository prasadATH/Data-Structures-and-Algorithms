import java.util.*;
import java.io.*;

public class graphTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String label1 =" ";

        String label2 =" ";
        String label3 =" ";
        String label4 =" ";
        String label5 =" ";
        boolean result=false;

        
        System.out.println("\ntesting load file");
        System.out.println("=====================");

        DSAGraph graph = new DSAGraph();
/*
        System.out.println("\nInsert label for first vertex :");
        label1= sc.next();

        System.out.println("\nInsert label for Second vertex :");
        label2= sc.next();

        System.out.println("\nInsert label for Third vertex :");
        label3= sc.next();

        System.out.println("\nInsert label for Third vertex :");
        label4= sc.next();

        System.out.println("\nInsert label for Third vertex :");
        label5= sc.next();


        

        graph.addVertex(label1);
        graph.addVertex(label2);
        graph.addVertex(label3);
        graph.addVertex(label4);
        graph.addVertex(label5);




        graph.addEdge(label1, label2);
        graph.addEdge(label2, label3);
        graph.addEdge(label3, label4);

        graph.addEdge(label3, label5);
        graph.addEdge(label1, label5);
        graph.addEdge(label4, label1);
        graph.addEdge(label2, label5);





        if( graph.hasVertex(label1))
        {
            System.out.println("\nvertex label "+label1 +" found!\n");
        }
*/


//System.out.println("Edge count :" + graph.getEdgeCount());



       // System.out.println("\nGraph being displayed as a list\n");

       // graph.displayAsList();
     try{
            graph.loadFile("prac6_1.al");
          }

     catch(IOException e){
                 System.out.println("Error file read unsuccesful");
          }

         // System.out.println("vertex count :" + graph.getVertexCount());

        //graph.displaylinks();
        System.out.println("\nGraph being displayed as a Matix\n");

        graph.displayAsMatrix();


        
     //  System.out.println("\n"+graph.depthFirstSearch());

     //  System.out.println("\n"+graph.breadthFirstSearch());




    }
}