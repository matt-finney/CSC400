package CSC400Mod4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    CSC400 Module 4
    Matthew Finney
    Creates a postfix calculator that evaluates expressions using a stack.
    Uses the examples provided in the Module 4 assignment example.

    https://github.com/matt-finney/CSC400
*/

public class Module4
{
    public static void main(String[] args)
    {
        PostfixCalculator calculator = new PostfixCalculator();

        // Example 1: Valid Expression
        String expression1 = "42*3+";
        try
        {
            System.out.println("Result 1: " + calculator.evaluatePostfix(expression1));
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }

        // Example 2: Valid Expression
        String expression2 = "53+7*";
        try
        {
            System.out.println("Result 2: " + calculator.evaluatePostfix(expression2));
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }

        // Example 3: Invalid Expression (missing operand)
        String expression3 = "42*+";
        try
        {
            System.out.println("Result 3: " + calculator.evaluatePostfix(expression3));
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println();
        System.out.println("Reading expressions from file...");

        // Read expressions from a text file and evaluate each
        String filename = "expressions.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            int lineNumber = 1;
            // Read each line and evaluate the expression
            while ((line = reader.readLine()) != null) 
            {
                line = line.trim();
                if (!line.isEmpty()) 
                {
                    try 
                    {
                        int result = calculator.evaluatePostfix(line);
                        System.out.println("File Expression " + lineNumber + ": " + line + " = " + result);
                    } catch (IllegalArgumentException e) 
                    {
                        System.out.println("File Expression " + lineNumber + ": " + line + " = Error: " + e.getMessage());
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
    }
}

