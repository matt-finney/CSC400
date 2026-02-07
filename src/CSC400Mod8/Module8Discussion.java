package CSC400Mod8;

import java.util.LinkedList;
import java.util.Queue;

public class Module8Discussion 
{
    public static void main(String[] args) 
    {
        Queue<String> queue = new LinkedList<>();

        // enqueue
        queue.add("Task 1: Login request");
        queue.add("Task 2: Load dashboard");
        queue.add("Task 3: Save settings");

        System.out.println("Queue after adding tasks: " + queue);

        // peek
        System.out.println("Next task to process: " + queue.peek());

        // dequeue
        while (!queue.isEmpty()) 
        {
            String current = queue.remove();
            System.out.println("Processing -> " + current);
        }

        System.out.println("All tasks processed. Queue is now: " + queue);
    }
}

