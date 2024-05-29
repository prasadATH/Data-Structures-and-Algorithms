public void displayAsMatrix()
    {
        int numVerticies = getVertexCount();
            // Number of verticies in graph
        DSAGraphVertex[] arr;
            // Array of all verticies in graph
        int[][] matrix;
            // 2D array of matrix, uses 0's for no adjacency and 1's for
            // adjacency
        int idx = 0;
            // index used to fill arr

        arr = new DSAGraphVertex[ numVerticies ];
        matrix = new int[ numVerticies ][ numVerticies ];

        // Populating vertex array
        for( Object o : verticies )
        {
            arr[idx] = (DSAGraphVertex)o;
            idx++;
        }

        // Populating matrix
        for( int i = 0; i < numVerticies; i++ )
        {
            for( int j = 0; j < numVerticies; j++ )
            {
                if( isAdjacent( arr[i], arr[j] ) )
                {
                    matrix[i][j] = 1;
                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Printing
        System.out.print( " " );
        for( Object o : verticies )
        {
            System.out.print( " | " + ((DSAGraphVertex)o).getLabel() );
        }

        for( int i = 0; i < numVerticies; i++ )
        {
            System.out.print( "\n" + arr[i].getLabel() );
            for( int j = 0; j < numVerticies; j++ )
            {
                System.out.print( " | " + matrix[i][j] );
            }
        }
        System.out.println();
    }
