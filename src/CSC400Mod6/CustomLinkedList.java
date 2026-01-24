package CSC400Mod6;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    CSC400 Module 6
    Matthew Finney
    Custom linked list implementation with insertion, deletion, and iteration.
    Uses starter code provided in the Module 6 assignment example.

    https://github.com/matt-finney/CSC400
 */

// Custom linked list, implements Iterable to allow for-each loops
public class CustomLinkedList implements Iterable<Integer> 
{
    private Node head;

    // iterator method
    @Override
    public Iterator<Integer> iterator() 
    {
        return new LinkedListIterator();
    }

    // Node class for linked list
    private class Node 
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // Iterator class for linked list
    private class LinkedListIterator implements Iterator<Integer>
    {
        private Node current;

        // constructor so that iterator starts at head
        LinkedListIterator()
        {
            this.current = head;
        }

        // Check if there is a next element
        // true if there is a next element, false otherwise
        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        // returns the next element and moves the iterator to the next position
        @Override
        public Integer next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    // insertion method
    public void insert(int data)
    {
        Node new_node = new Node(data);

        // if list is empty, new node becomes head
        if (head == null)
        {
            head = new_node;
        }
        else // else traverse to the end and insert
        {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new_node;
        }
    }

    // deletion method
    public boolean delete(int data)
    {
        // if list is empty then return false
        if (head == null)
        {
            return false;
        }
        // if data matches the head, remove head
        if (head.data == data)
        {
            head = head.next;
            return true;
        }
        // traverse the list to find the data to delete
        Node current = head;
        while (current.next != null && current.next.data != data)
        {
            current = current.next;
        }
        if (current.next == null)
        {
            return false;
        }
        current.next = current.next.next;
        return true;
    }
}
