package CSC400Mod6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    CSC400 Module 6
    Matthew Finney
    Demonstrates the CustomLinkedList by reading integers from a file and displaying them.

    https://github.com/matt-finney/CSC400
 */

public class Module6 {
    public static void main(String[] args) {
        CustomLinkedList linked_list = new CustomLinkedList();

        // reads integer data from a file
        String file_name = "data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name)))
        {
            String line;
            int line_number = 1;
            // Read each line and insert into linked list
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (!line.isEmpty())
                {
                    try
                    {
                        int data = Integer.parseInt(line);
                        linked_list.insert(data);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Error parsing integer on line " + line_number + ": " + line);
                    }
                }
                line_number++;
            }
        } catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // display elements
        for (int data : linked_list)
        {
            System.out.println(data);
        }

    }
}
