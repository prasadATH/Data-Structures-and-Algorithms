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


       

        public void displayAsList()
        {
            for( Object o : verticies )
            {
                System.out.print( ((DSAGraphVertex)o).getLabel() + " :");
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


     

    

    public Iterator iterator()
    {
        return verticies.iterator();
    }

    
}

    

