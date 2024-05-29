import java.util.*;
import java.io.*;
public class DSAGraph
{
   
   
    public class DSAGraphVertex 
    {
        public String label;

        public DSALinkedList links;
 
        public boolean visited;

    public DSAGraphVertex( String inpLabel )
        {
            label = inpLabel;
            links = new DSALinkedList();
            visited = false;
        }

        public String getLabel()
        {
            return label;
        }

        public void setLabel(String inLabel)
        {
           label = inLabel;
        }

        public DSALinkedList getAdjacent()
        {
            return links;
        }

        private boolean getVisited()
        {
            return visited;
        }

        public String toString()
        {
            return label;
        }

        public boolean equals( DSAGraphVertex inpVertex )
        {
            return ( label.equals( inpVertex.getLabel() ) );
        }

        private void addEdge( DSAGraphVertex inpVertex )
        {
            links.insertLast( inpVertex );
        }

        private void setVisited()
        {
            visited = true;
        }

        private void clearVisited()
        {
            visited = false;
        }


    
     
    }

    private DSALinkedList verticies;

    public DSAGraph()
    {
        verticies = new DSALinkedList();
    }

  




    public void addVertex( String inpLabel )
    {
        if( hasVertex( inpLabel ) )
        {
            throw new IllegalArgumentException( "Vertex " + inpLabel + " already exists in graph" );
        }

        verticies.insertLast( new DSAGraphVertex( inpLabel ) );
    }


    public void addVertex( DSAGraphVertex inpVertex )
    {
        if( hasVertex( inpVertex ) )
        {
            throw new IllegalArgumentException( "Vertex " + inpVertex.getLabel() + " already exists in graph" );
        }

        verticies.insertLast( inpVertex );
    }



    public void addEdge( String firLabel, String secLabel )
    {
        addEdge( getVertex( firLabel ), getVertex( secLabel ) );
    }


    public void addEdge( DSAGraphVertex firVertex, DSAGraphVertex secVertex )
    {
        if( isAdjacent( firVertex, secVertex ) )
        {
            throw new IllegalArgumentException( "Verticies " + firVertex +" and " + secVertex + " are already connected" );
        }
        firVertex.addEdge( secVertex );
        secVertex.addEdge( firVertex );
        
    }
/*
    public void removeVertex( String inLabel )
    {
        removeVertex( getVertex( inLabel ) );
    }
 
    public void removeVertex( DSAGraphVertex inVertex )
    {
        if( !hasVertex( inVertex ) )
        {
            throw new IllegalArgumentException( "Vertex " + 
                inVertex.label + " already exists in graph" );
        }

        verticies.removeNode( inVertex );
    }
    

    public void removeEdge( String inLabel1, String inLabel2 )
    {
        removeEdge( getVertex( inLabel1 ), getVertex( inLabel2 ) );
    }

    public void removeEdge( DSAGraphVertex inVertex1, 
        DSAGraphVertex inVertex2 )
    {
        if( !isAdjacent( inVertex1, inVertex2 ) )
        {
            throw new IllegalArgumentException( "Verticies " + 
                inVertex1.label + " and " + inVertex2.label +
                " are not adjacent" );
        }

        inVertex1.links.removeNode( inVertex2 );
    }
    */


    public DSAGraphVertex getVertex( String inpLabel )
    {
        DSAGraphVertex vertex = null;

        if( !hasVertex( inpLabel ) )
        {
            throw new NoSuchElementException( "Vertex " + inpLabel + " not found" );
        }

        for( Object o : verticies )
        {
            // Search through every vertex to find matching label
            if( ( (DSAGraphVertex)o ).getLabel().equals( inpLabel ) )
            {
                vertex = (DSAGraphVertex)o;
            }
        }

        return vertex;
    }

    public boolean hasVertex( String inpLabel )
    {
        boolean result = false;

        for( Object o : verticies )
        {
            // Search through every vertex to find matching label
            if( ( (DSAGraphVertex)o ).getLabel().equals( inpLabel ) )
            {
                result = true;
            }
        }

        return result;
    }

    public boolean hasVertex( DSAGraphVertex inpVertex )
    {
        boolean result = false;

        for( Object o : verticies )
        {
            if( ( (DSAGraphVertex)o ).equals( inpVertex ) )
            {
                result = true;
            }
        }

        return result;
    }

        public int getVertexCount()
        {
            int vCount = 0;
    
            for( Object o : verticies )
            {
                vCount++;
            }
    
            return vCount;
        }

        public int getEdgeCount()
        {
            int eCount = 0;
    
            for( Object o : verticies )
            {
                for( Object o2 : ( (DSAGraphVertex)o ).getAdjacent() )
                {
                    // Increment for every element in the adjacency list for
                    // every induvidual vertex
                    eCount++;
                }
            }
    
            // Each edge is represented twice as the graph is undirected, so
            // we divide by 2
    
            return ( eCount / 2 );
        }


        public DSALinkedList getAdjacent( String inLabel )
        {
            DSALinkedList values = new DSALinkedList();
    
            for( Object o : getVertex( inLabel ).links )
            {
                values.insertLast( ( (DSAGraphVertex)o ).getLabel() );
            }
    
            return values;
        }

        public boolean isAdjacent( String firstLabel, String secLabel )
        {
            boolean result = false;
            DSAGraphVertex firVertex, secVertex;
    
            firVertex = getVertex( firstLabel );
            secVertex = getVertex( secLabel );
    
            for( Object o : ( firVertex.getAdjacent() ) )
            {
                if( ( (DSAGraphVertex)o ).equals( secVertex ) )
                {
                    result = true;
                }
            }
    
            return result;
        }


        public boolean isAdjacent( DSAGraphVertex firVertex, DSAGraphVertex secVertex )
        {
            boolean result = false;
    
            for( Object o : ( firVertex.getAdjacent() ) )
            {
                if( ((DSAGraphVertex)o).equals( secVertex ) )
                {
                    result = true;
                }
            }
    
            return result;
        }


        public String depthFirstSearch()
        {
            // Set all verticies to unvisited
            clearVisited();
    
            // Use recursive DSARec() algorithm
            return DFSRec( (DSAGraphVertex)verticies.peekFirst() );
        }

        private String DFSRec( DSAGraphVertex vertex )
        {
            DSAGraphVertex subVertex;
                // Current vertex adjacent to imported vertex
            String out = "";
                // Export string
    
            vertex.setVisited();
    
            // Iterate through adjacent verticies
            for( Object o : vertex.getAdjacent() )
            {
                // Find an adjacent vertex that is not visited
                subVertex = (DSAGraphVertex)o;
                if( !subVertex.getVisited() )
                {
                    out += ( "{" + vertex.toString() + ", " + 
                        subVertex.toString() + "}  " + 
                        DFSRec( subVertex ) );
                        // Recurse
                }
            }
    
            return out;
        }
        
     



        public void displayAsList()
        {
            for( Object o : verticies )
            {
                System.out.print( ((DSAGraphVertex)o).getLabel() + " ______>");
                for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
                {
                    System.out.print( "  " + ((DSAGraphVertex)o2).getLabel() );
                }
                System.out.println("\n");
            }
        }

        public void clearVisited()
        {
            for( Object o : verticies )
            {
                // Mark all verticies as not visited
                ( (DSAGraphVertex)o ).clearVisited();
            }
        }


        public String breadthFirstSearch()
        {
            DSAQueue queue = new DSAQueue();
    
            // Set all verticies to unvisited
            clearVisited();
    
            // Enqueue first vertex
            queue.enqueue( verticies.peekFirst() );
            ( (DSAGraphVertex)verticies.peekFirst() ).setVisited();
    
            return BFSRec( queue );
        }
    
        /*  --------------------------------------------------------------
        **   Submodule: BFSRec()
        **      Import: queue (DSAQueue)
        **      Export: out (String)
        **   Assertion: Recursive helper function to traverse graph using
        **                  depth first search
        */ 
        private String BFSRec( DSAQueue queue )
        {
            DSAGraphVertex vertex = (DSAGraphVertex)queue.dequeue();
                // Current vertex for this recurse
            DSAGraphVertex subVertex;
                // Current vertex in adjacency list of vertex for each iteration
            String out = "";
                // Export string
    
            // Iterate through adjacent verticies
            for( Object o : vertex.getAdjacent() )
            {
                subVertex = (DSAGraphVertex)o;
    
                if( !subVertex.getVisited() )
                {
                    queue.enqueue( subVertex );
                    subVertex.setVisited();
                    out += ( "{" + vertex.toString() + ", " + 
                        subVertex.toString() + "}  " );
                }
            }
    
            if( !queue.isEmpty() )
            {
                // Recurse
                out += BFSRec( queue );
            }
    
            return out;
        }



        public void displayAsMatrix()
    {
        int vertixNum = getVertexCount();
            // Number of verticies in graph
        DSAGraphVertex[] arr;
            // Array of all verticies in graph
        int[][] graphMatrix;
            // 2D array of matrix, uses 0's for no adjacency and 1's for
            // adjacency
        int idx = 0;
            // index used to fill arr

        arr = new DSAGraphVertex[ vertixNum ];
        graphMatrix = new int[ vertixNum ][ vertixNum ];

        // Populating vertex array
        for( Object o : verticies )
        {
            arr[idx] = (DSAGraphVertex)o;
            idx++;
        }

        // Populating matrix
        for( int i = 0; i < vertixNum; i++ )
        {
            for( int j = 0; j < vertixNum; j++ )
            {
                if( isAdjacent( arr[i], arr[j] ) )
                {
                    graphMatrix[i][j] = 1;
                }
                else
                {
                    graphMatrix[i][j] = 0;
                }
            }
        }
        
        // Printing
       System.out.print( "  " );
        for( Object o : verticies )
        {
            System.out.print( " | " + ((DSAGraphVertex)o).getLabel() );
        }

        for( int i = 0; i < vertixNum; i++ )
        {
        
                System.out.print( "\n " + arr[i].getLabel() );
            
            for( int j = 0; j < vertixNum; j++ )
            {

                System.out.print( " | " + graphMatrix[i][j] );
            }
        }
        System.out.println();
    }

    public void loadFile( String fileName ) throws IOException
    {
        
        DSALinkedList fileLine = new DSALinkedList();
            // List of lines in file as strings
        String data;
        String[] splitArry = new String[2] ;
            // 2-element array of the verticies at each end of given edge

        // File IO
        try
        {
            FileInputStream strm = new FileInputStream( fileName );
            InputStreamReader inpRdr = new InputStreamReader( strm );
            BufferedReader bffr = new BufferedReader( inpRdr );

            data = bffr.readLine();
            while( data != null )
            {
                // Save lines to linked list
                fileLine.insertLast( data );

                data = bffr.readLine();
            }
        
            bffr.close();
            strm.close();

        // Populatiing graph
        for( Object o : fileLine )
        {
            splitArry = ( (String)o ).split(" ");
                // Populate the array with the verticies on either side of 
                // the edge given in the file ( [ A, B ] )

            // Adding verticies
            for( String labl : splitArry )
            {
                // Add each vertex in the array that isnt already in the
                // graph
                if( !hasVertex( labl ) )
                {
                    addVertex( labl );
                }
            }

            // Adding edges
          
            for (int i=1;i<(splitArry.length);i++)
            {
             addEdge(splitArry[0], splitArry[i]);
            }
        
       }
    }
       catch( FileNotFoundException e )
       {
           System.out.println( "File " + fileName +" not found" );
       }
       catch( IOException e )
       {
           System.out.println( "File " + fileName +" not found" );
       }


    }

    public Iterator iterator()
    {
        return verticies.iterator();
    }

    
}

    

