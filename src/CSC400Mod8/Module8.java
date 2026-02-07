package CSC400Mod8;

import java.util.Comparator;
import java.util.Scanner;

/*
    CSC400 Module 8
    Matthew Finney
    Option #1: Person Class
    Creates a queue of Person objects based on user input,
    then lets the user choose to sort the queue by last name or age using a quicksort implementation.

    https://github.com/matt-finney/CSC400
 */

public class Module8 
{
    public static void main(String[] args) 
    {
        // create a queue to hold person objects
        Queue<Person> queue = new Queue<>();
        // read 5 people from user input and enqueue them
        try (Scanner scanner = new Scanner(System.in)) 
        {
            System.out.println("Please enter 5 people one by one (Ex: John Doe 30): ");
            for (int i = 0; i < 5; i++)
            {
                // prompt user for input and read the line
                System.out.print("Person " + (i + 1) + ": ");
                String input = scanner.nextLine();
                // split input into parts and validate based on expected format
                String[] parts = input.split(" ");
                // check if input has exactly 3 parts (first name, last name, age)
                if (parts.length != 3)
                {
                    System.out.println("Invalid input format. Please enter in the format: FirstName LastName Age");
                    i--; // decrement i to retry this iteration
                    continue;
                }

                // validate input for first and last name (only letters, hyphens, and spaces allowed)
                String first_name = parts[0];
                String last_name = parts[1];
                if (!isValidName(first_name) || !isValidName(last_name)) 
                {
                    System.out.println("Invalid name. Names should only contain letters, hyphens, or spaces.");
                    i--; // decrement i to retry this iteration
                    continue;
                }

                // validate age input and convert to integer
                int age;
                try 
                {
                    age = Integer.parseInt(parts[2]);
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Invalid age. Please enter a valid integer for age.");
                    i--; // decrement i to retry this iteration
                    continue;
                }
                // add the person to the queue after successful validation checks
                queue.enqueue(new Person(first_name, last_name, age));
            }

            // display the content of the queue
            System.out.println("\n---------------------------------------");
            System.out.println("Queue content:");
            for (Person p : queue.toList())
            {
                System.out.println(p);
            }
            
            // allow user to choose sorting method and display sorted queue
            while (true)
            {
                System.out.println("---------------------------------------");
                int user_choice;
                System.out.println("How would you like to sort the queue?");
                System.out.println("1. Sort by last name (descending)");
                System.out.println("2. Sort by age (descending)");
                System.out.println("3. Exit");

                // validate user input for sorting choice
                while (!scanner.hasNextInt())
                {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    scanner.nextLine();
                }
                user_choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                while (user_choice != 1 && user_choice != 2 && user_choice != 3) 
                {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    while (!scanner.hasNextInt())
                    {
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        scanner.nextLine();
                    }
                    user_choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                }

                // perform sorting based on user choice and display sorted queue
                switch(user_choice)
                {
                    // sort by last name (descending), then by first name and age for tie-breaking
                    case 1:
                        System.out.println("\nQueue sorted by last name (descending):");
                        Queue<Person> sortedby_lastNames = quickSort(
                            copyQueue(queue),
                            Comparator.comparing(Person::getLast_name, String.CASE_INSENSITIVE_ORDER)
                            .thenComparing(Person::getFirst_name, String.CASE_INSENSITIVE_ORDER)
                            .thenComparingInt(Person::getAge)
                            .reversed()
                        );
                        // display the sorted queue
                        for (Person p : sortedby_lastNames.toList()) 
                        {
                            System.out.println(p);
                        }
                        break;
                    // sort by age (descending), then by last name and first name for tie-breaking
                    case 2:
                        System.out.println("\n=======================================");
                        System.out.println("Queue sorted by age (descending):");
                        Queue<Person> sortedby_ages = quickSort(
                            copyQueue(queue),
                            Comparator.comparingInt(Person::getAge)
                            .thenComparing(Person::getLast_name, String.CASE_INSENSITIVE_ORDER)
                            .thenComparing(Person::getFirst_name, String.CASE_INSENSITIVE_ORDER)
                            .reversed()
                        );
                        // display the sorted queue
                        for (Person p : sortedby_ages.toList())
                        {
                            System.out.println(p);
                        }
                        System.out.println("=======================================");
                        break;
                    // exit the program
                    case 3:
                        System.out.println("Exiting...");
                        return;
                }
            }
        }
    }

    // quicksort implementation that sorts a queue of Person objects with a comparator
    private static Queue<Person> quickSort(Queue<Person> input, Comparator<Person> cmp)
    {
        // base case: if the queue has 0 or 1 elements, it's already sorted
        if (input.size() <= 1) return input;

        // choose the first element as the pivot
        Person pivot = input.dequeue();

        // make three queues to hold elements less than, equal to, and greater than the pivot
        Queue<Person> less = new Queue<>();
        Queue<Person> equal = new Queue<>();
        Queue<Person> greater = new Queue<>();

        // add the pivot to the equal queue
        equal.enqueue(pivot);
        
        // loop until the input queue is empty
        while (!input.isEmpty())
        {
            // dequeue the next element and compare it to the pivot using the comparator
            Person current = input.dequeue();
            int compare = cmp.compare(current, pivot);
            // add the current element to the right queue based on result of comparison
            if (compare < 0) 
            {
                less.enqueue(current);
            } 
            else if (compare == 0) 
            {
                equal.enqueue(current);
            } 
            else 
            {
                greater.enqueue(current);
            }
        }

        // create a new queue to hold the sorted result
        // append all three queues together to get the final sorted queue
        Queue<Person> sorted = new Queue<>();
        appendAll(sorted, quickSort(less, cmp));
        appendAll(sorted, equal);
        appendAll(sorted, quickSort(greater, cmp));
        return sorted;
    }
    
    // helper method to append all the elements from the source queue to the target queue
    private static void appendAll(Queue<Person> target, Queue<Person> source)
    {
        while (!source.isEmpty())
        {
            target.enqueue(source.dequeue());
        }
    }

    // helper method to create a copy of the queue to avoid modifying the original during sorting
    // allows the program to run multiple sorts (age/last name) without changing the original order
    private static Queue<Person> copyQueue(Queue<Person> original)
    {
        Queue<Person> copy = new Queue<>();
        for (Person p : original.toList())
        {
            copy.enqueue(p);
        }
        return copy;
    }

    // helper method to validate names (only letters, hyphens, and spaces allowed)
    private static boolean isValidName(String name)
    {
        return name != null && name.matches("[A-Za-z][A-Za-z\\- ]*");
    }
    
}
