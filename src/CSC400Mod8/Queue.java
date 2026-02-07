package CSC400Mod8;

import java.util.LinkedList;
import java.util.List;

/*
    CSC400 Module 8
    Matthew Finney
    Option #1: Person Class
    Creates a Queue of Person objects

    https://github.com/matt-finney/CSC400
 */

// queue implementation that uses a LinkedList to store the elements
public class Queue<T>
{
    private LinkedList<T> list = new LinkedList<>();

    // constructor, takes a list of elements to initialize the queue
    public List<T> toList() 
    {
        return new LinkedList<>(list);
    }

    // add an element to the end of the queue
    public void enqueue(T info)
    {
        list.addLast(info);
    }

    // remove and return the element at the front of the queue
    public T dequeue()
    {
        if (list.isEmpty()) 
        {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    // check if the queue is empty
    public boolean isEmpty() 
    {
        return list.isEmpty();
    }

    // get the number of elements in the queue
    public int size() 
    {
        return list.size();
    }

    // return the string representation of the queue
    @Override
    public String toString() 
    {
        return list.toString();
    }
}
