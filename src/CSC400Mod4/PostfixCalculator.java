
package CSC400Mod4;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    CSC400 Module 4
    Matthew Finney
    Creates a postfix calculator that evaluates expressions using a stack.

    https://github.com/matt-finney/CSC400
*/

public class PostfixCalculator
{
    // evaluates the postfix expression and returns an integer
    // throws an IllegalArgumentException for invalid input or division by zero
    public int evaluatePostfix(String postfixExpression)
    {
        // Handle empty or null input
        if (postfixExpression == null || postfixExpression.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        // Create a stack to hold operands
        Deque<Integer> stack = new ArrayDeque<>();

        // Go through each character in the expression
        for (int i = 0; i < postfixExpression.length(); i++)
        {
            char ch = postfixExpression.charAt(i);

            // Skip spaces for better handling
            if (Character.isWhitespace(ch))
            {
                continue;
            }

            // If the character is a digit, push it onto the stack
            if (Character.isDigit(ch))
            {
                stack.push(ch - '0'); // convert char digit to int
            }
            // If the character is an operator, pop two operands and apply the operator
            else if (isOperator(ch))
            {
                // Error if there are not enough operands
                if (stack.size() < 2)
                {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }

                // Pop the top two operands from the stack
                int right = stack.pop();
                int left = stack.pop();

                // Handle the division by zero error
                if ((ch == '/' || ch == '%') && right == 0)
                {
                    throw new IllegalArgumentException("Division by zero");
                }

                // Apply the operator and push the result back to the stack
                int result = applyOperator(left, right, ch);
                stack.push(result);
            }
            else
            {
                throw new IllegalArgumentException("Invalid postfix expression");
            }
        }

        // If there are too many operands left in the stack
        if (stack.size() != 1)
        {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        // Return the final result
        return stack.pop();
    }

    // Helper method to check if a character is an operator (+, -, *, /, %)
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%';
    }

    // Helper method to apply an operator to two operands
    private int applyOperator(int left, int right, char op)
    {
        if (op == '+')
        {
            return left + right;
        }
        else if (op == '-')
        {
            return left - right;
        }
        else if (op == '*')
        {
            return left * right;
        }
        else if (op == '/')
        {
            return left / right; // integer division
        }
        else
        {
            return left % right;
        }
    }
}

