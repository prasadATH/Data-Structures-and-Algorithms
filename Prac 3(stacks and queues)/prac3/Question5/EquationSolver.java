// FILE: EquationSolver.java
// AUTHOR: Thilina Prasad Athukorala
// UNIT: COMP1002
//ID : 21038875

public class EquationSolver
{
    public double solve( String equation )
    {
        DSACircularQueue postfixQueue;
        double answer;

        postfixQueue = parseInfixToPostfix( equation );
        answer = evaluatePostfix( postfixQueue );

        return answer;
    }
    
    private DSACircularQueue parseInfixToPostfix( String equation )
    {
        DSACircularQueue postfixQueue;
        String[] infixArray; //Array of equation terms in infix
        String term;
        DSAStack operatorStack;
        String operators = "+-*/";

        infixArray = equation.split(" ");
        operatorStack = new DSAStack( infixArray.length );
        postfixQueue = new DSACircularQueue( infixArray.length );

        for( int i = 0; i < infixArray.length; i++ )
        {
            term = infixArray[i];

            if( term.equals( "(" ) )
            {
                operatorStack.push( term.charAt(0) );
            }
            else if( term.equals( ")" ) )
            {
                while( !operatorStack.top().equals( '(' ) )
                {
                    postfixQueue.enqueue( operatorStack.pop() );
                }
                operatorStack.pop(); //Pop the '(' and discard it
            }
            else if( operators.contains( term ) ) //If term is +,-,* or /
            {
                while( !operatorStack.isEmpty() && 
                    !operatorStack.top().equals( '(' ) && 
                    ( precedenceOf( operatorStack.top().toString().charAt(0) ) 
                    >= precedenceOf( term.charAt(0) ) ) )
                {
                    postfixQueue.enqueue( operatorStack.pop() );
                }
                operatorStack.push( term );
                    //Puts the new operator onto the stack
            }
            else
            {
                //Term is an operand
                postfixQueue.enqueue( Double.valueOf( term ) );
            }
        }

        while( !operatorStack.isEmpty() )
        {
            //Push any remaining operands
            postfixQueue.enqueue( operatorStack.pop() );
        }


        return postfixQueue;
    }

    private double evaluatePostfix( DSACircularQueue postfixQueue )
    {
        DSAStack operandStack;
        char op;
        double op1, op2;

        operandStack = new DSAStack( postfixQueue.getCount() );
        while( !postfixQueue.isEmpty() )
        {
            if( postfixQueue.peek() instanceof Double )
            {
                //Next item is an operand
                operandStack.push( postfixQueue.dequeue() );
            }
            else
            {
                //Next item is an operator
                op2 = (double)operandStack.pop();
                op1 = (double)operandStack.pop();
                op = postfixQueue.dequeue().toString().charAt(0);
                operandStack.push( executeOperation( op, op1, op2 ) );
            }
        }

        return (double)operandStack.pop();
    }

    private int precedenceOf( char theOp )
    {
        int precedence;

        if( theOp == '+' || theOp == '-' )
        {
            precedence = 1;
        }
        else if( theOp == '*' || theOp == '/' )
        {
            precedence = 2;
        }
        else
        {
            throw new IllegalArgumentException( 
                "Postfix equation contains operator " + theOp );
        }

        return precedence;
    }

    private double executeOperation( char op, double op1, double op2 )
    {
        double answer;

        switch( op )
        {
            case '+':
            {
                answer = op1 + op2;
                break;
            }
            case '-':
            {
                answer = op1 - op2;
                break;
            }
            case '*':
            {
                answer = op1 * op2;
                break;
            }
            case '/':
            {
                answer = op1 / op2;
                break;
            }
            default:
            {
                throw new IllegalArgumentException(
                    "Postfix equation contains operator " + op );
            }
        }

        return answer;
    }
}