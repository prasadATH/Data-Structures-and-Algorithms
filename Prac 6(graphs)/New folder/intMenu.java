import java.util.*;


import java.io.*;


import java.io.FileWriter;

public class intMenu
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int userInp =0;
        String firstlabel ="";
        String seclabel ="";
        DSALinkedList data;
        String fileN = "";
        int height =0;
        DSAGraph graph = new DSAGraph();
        
 while(userInp !=11)
    {
        System.out.println("\n<1> Insert a vertex to the Graph ");
        System.out.println("<2> Insert an Edge to the Graph");
		System.out.println("<3> Search a vertex in the Graph");
        System.out.println("<4> Get count of vertices in the Graph");
		System.out.println("<5> Get count of Edges in the Graph");
		System.out.println("<6> Get a adjacent vertex in the Graph");
        System.out.println("<7> Display the Graph");
        System.out.println("<10> Read from a file");

		System.out.println("<11> Exit");

        System.out.print("\nEnter the required function : ");
        userInp = sc.nextInt();



        switch(userInp)
		{
			    case 1:
				    System.out.print("\nEnter a label for the vertex : ");
		        	firstlabel = sc.next();



                   System.out.println( "\nAttempting to search label "+ firstlabel +" now\n" );
                   while( graph.hasVertex(firstlabel))
                   {
                       System.out.println(" vertices cannot contain duplicates! please enter another label value!\n");
                       System.out.println("\nEnter a label for the vertex : ");
                       firstlabel = sc.next();
                   }

                   System.out.println( "\nNo duplicates detected....\n" );
                   
                   graph.addVertex(firstlabel);
               
                        System.out.println("Graph after the insertion(List view) : ");
                        graph.displayAsList();

                        System.out.println();

                        System.out.println("Graph after the insertion(Matrix view) : ");
                        graph.displayAsMatrix();
                        System.out.println();

                   
                    
				break;

		        case 2:
                
                        System.out.print("\nEnter first label for the Edge : ");
                        firstlabel = sc.next();

                        System.out.print("\nEnter Second label for the Edge : ");
                        seclabel = sc.next();

               
                        graph.addEdge(firstlabel, seclabel);
                        
           
                        System.out.println("\nGraph after the insertion(List view) : ");
                        graph.displayAsList();

                        System.out.println();

                         System.out.println("\nGraph after the insertion(Matrix view) : ");
                         graph.displayAsMatrix();
                         System.out.println();
              
				break;

                case 3:
                System.out.print("\nEnter vertex label to search : ");
                firstlabel = sc.next();

                if(graph.hasVertex(firstlabel))
                {
                    System.out.println("\nVertex found!");
                }else
                {
                    System.out.println("\nVertex not found! Please check your value");     
                }


				break;
                 
		        case 4:
                System.out.println("\nNumber of vertices : " + graph.getVertexCount());
                System.out.println("\nGraph: \n");
                graph.displayAsList();


				break;

                case 5:
                System.out.println("\nNumber of edges : " + graph.getEdgeCount());
                System.out.println("\nGraph: \n");
                graph.displayAsList();


				break;

			    case 6:
                System.out.print("\nEnter label of vertex to find adjacent vertice(s) : ");
                firstlabel = sc.next();

                data= graph.getAdjacent(firstlabel);
                System.out.print("\nAdjacent vertice(s) of the "+firstlabel+" vertex is/are :");
                for( Object o : data )
            {
                System.out.print( o + ", ");
            }
               // System.out.println("\nAdjacent vertex of the "+firstlabel+" label is "+graph.getAdjacent(firstlabel)+"\n");

                System.out.println("\n\nGraph: \n");
                graph.displayAsList();


                break;

                case 7:
                        System.out.println("\nGraph in List view : ");
                        graph.displayAsList();

                        System.out.println();

                         System.out.println("\nGraph in Matrix view : ");
                         graph.displayAsMatrix();
                         System.out.println();

                break;

              
                 case 10:
                 
                 System.out.print("\nEnter the name of file to be imported : ");
                 fileN = sc.next();

                 try{
                    graph.loadFile(fileN);
                  }
        
                catch(IOException e){
                         System.out.println("Error file read unsuccesful");
                  }

                 break;


                default :
                System.out.println("\nInvalid Selection!! please enter a choice between 0 and 6");


		}
    }
  }
}





