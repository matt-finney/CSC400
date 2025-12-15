package CSC400Mod1;

import java.util.HashMap;
import java.util.Map;

/*
    CSC400 Module 1
    Matthew Finney
    Creating a generic Bag class that allows duplicates and tracks counts of each item.
    Also includes methods to add, remove, check if it contains an item, and count items.
    https://github.com/matt-finney/CSC400
*/

public class Bag<T> 
{
    // Stores each item and how many times it occurs
    private final Map<T, Integer> counts;
    private int size; // total number of elements (including duplicates)

    // Constructor method to initialize the bag
    public Bag() 
    {
        counts = new HashMap<>();
        size = 0;
    }

    // Adds an item to the bag
    public void add(T item) 
    {
        counts.put(item, counts.getOrDefault(item, 0) + 1);
        size++;
    }

    // removes one occurrence of the item from the bag
    // if the item does not exist, do nothing
    public void remove(T item) 
    {
        Integer currentCount = counts.get(item);

        if (currentCount == null) 
        {
            return; // item does not exist
        }

        if (currentCount == 1) 
        {
            counts.remove(item);
        } 
        else 
        {
            counts.put(item, currentCount - 1);
        }

        size--;
    }

    // checks if the bag contains the item
    public boolean contains(T item) 
    {
        return counts.containsKey(item);
    }

    // returns the count of the item in the bag
    public int count(T item) 
    {
        return counts.getOrDefault(item, 0);
    }

    // returns the total number of elements in the bag including duplicates
    public int size() 
    {
        return size;
    }

    // toString method to display the contents of the bag
    @Override
    public String toString() 
    {
        return "Bag" + counts + " (total items=" + size + ")";
    }
}