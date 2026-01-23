
package CSC400Mod4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

        // Tokenize the expression
        // If there are whitespaces, allow multi digits
        // If no whitespaces, assume single digits and process character by character
        List<String> tokens = tokenize(postfixExpression);

        // Process each token
        for (String token : tokens)
        {
            // Check if the token is an operator ( +, -, *, /, % )
            if (token.length() == 1 && isOperator(token.charAt(0)))
            {
                char op = token.charAt(0);

                // Error if there are not enough operands
                if (stack.size() < 2)
                {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }

                // Pop the top two operands from the stack
                int right = stack.pop();
                int left = stack.pop();

                // Handle the division by zero error
                if ((op == '/' || op == '%') && right == 0)
                {
                    throw new IllegalArgumentException("Division by zero");
                }

                // Apply the operator and push the result back to the stack
                int result = applyOperator(left, right, op);
                stack.push(result);
            }
            else
            {
                // Else, the token should be an interger operand
                try
                {
                    int value = Integer.parseInt(token);
                    stack.push(value);
                }
                catch (NumberFormatException e)
                {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
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
    

    // Creates a list of tokens from the postfix expression
    private List<String> tokenize(String expr)
    {
        List<String> tokens = new ArrayList<>();
        boolean has_whitespace = containsWhitespace(expr);

        int i = 0;
        while (i < expr.length())
        {
            char ch = expr.charAt(i);


            // If the character is whitespace, increment and continue
            if (Character.isWhitespace(ch))
            {
                i++;
                continue;
            }

            // If there is whitespace in the expression, use full token parsing
            if (has_whitespace)
            {
                // With whitespaces, read full integers and operators
                // You can used negatives when '-' starts a token
                if (Character.isDigit(ch) || (ch == '-' && i + 1 < expr.length()
                        && Character.isDigit(expr.charAt(i + 1))
                        && (i == 0 || Character.isWhitespace(expr.charAt(i - 1)))))
                {
                    int start = i;
                    i++; // consume first char (digit or '-')
                    while (i < expr.length() && Character.isDigit(expr.charAt(i)))
                    {
                        i++;
                    }
                    tokens.add(expr.substring(start, i));
                    continue;
                }

                // Check for operators and add them as tokens
                if (isOperator(ch))
                {
                    tokens.add(String.valueOf(ch));
                    i++;
                    continue;
                }

                // Any other character is invalid
                throw new IllegalArgumentException("Invalid postfix expression");
            }
            else // No whitespaces, do single digit parsing
            {
                // With no whitespaces, only single digit operands are allowed
                if (Character.isDigit(ch))
                {
                    tokens.add(String.valueOf(ch));
                    i++;
                    continue;
                }

                // Check for operators and add them as tokens
                if (isOperator(ch))
                {
                    tokens.add(String.valueOf(ch));
                    i++;
                    continue;
                }

                // Any other character is invalid
                throw new IllegalArgumentException("Invalid postfix expression");
            }
        }

        return tokens;
    }

    
    // Helper method to check if a string contains any whitespace characters
    private boolean containsWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
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

