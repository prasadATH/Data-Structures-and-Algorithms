// FILE: EquationSolverTest.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875

public class EquationSolverTest
{
    public static void main( String[] args )
    {
       
        EquationSolver solver = new EquationSolver();

   


        System.out.println("\nSolving : ( 10 + 5 + 6 )");
        System.out.println("=============================");

        Double ans = solver.solve("10 + 5 + 6");
        if(ans == 21)
        {
            System.out.println("Test 1 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 1 for Equation solver failed!");
        }


        System.out.println("\nSolving : ( 2 * 2 )");
        System.out.println("=============================");
        
        ans = solver.solve("2 * 2");
        if(ans == 4)
        {
            System.out.println("Test 2 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 2 for Equation solver failed!");
        }


        System.out.println("\nSolving : ( 1 + 8 ) / 3");
        System.out.println("=============================");
        
        ans = solver.solve("( 1 + 8 ) / 3");
        if(ans == 3)
        {
            System.out.println("Test 3 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 3 for Equation solver failed!");
        }


        System.out.println("\nSolving : ( 2 * 2 * 2 * 2 / 4 )");
        System.out.println("===================================");


        ans = solver.solve("2 * 2 * 2 * 2 / 4");
        if(ans == 4)
        {
            System.out.println("Test 4 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 4 for Equation solver failed!");
        }


        System.out.println("\nSolving : ( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )");
        System.out.println("==========================================================");

        ans = solver.solve("( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )");
        if(ans == -35.432)
        {
            System.out.println("Test 5 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 5 for Equation solver failed!");
        }

        System.out.println("\nSolving : ( ( 19 - 53 ) / 54 * 8 * 19 ) / 5.8");
        System.out.println("===================================================");

        ans = solver.solve("( ( 19 - 53 ) / 54 * 8 * 19 ) / 5.8");
        if(ans == -16.50063856960409)
        {
            System.out.println("Test 6 for Equation solver is successful");
        }
        else
        {
            System.out.println("Test 6 for Equation solver failed!");
        }


    }
}
            