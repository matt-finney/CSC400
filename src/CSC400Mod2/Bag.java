package CSC400Mod2;

import java.util.HashMap;
import java.util.Map;

/*
    CSC400 Module 2
    Matthew Finney
    Extended generic Bag class with size, merge, and distinct methods.
    
    https://github.com/matt-finney/CSC400
*/
public class Bag<T>
{
    // Stores each item and how many times it occurs
    private final Map<T, Integer> item_counts;

    // Total number of elements (including duplicates)
    private int total_size;

    // Constructor method to initialize the bag
    public Bag()
    {
        item_counts = new HashMap<>();
        total_size = 0;
    }

    // Adds an item to the bag
    public void add(T item)
    {
        item_counts.put(item, item_counts.getOrDefault(item, 0) + 1);
        total_size++;
    }

    // Removes one occurrence of the item from the bag
    // If the item does not exist, do nothing
    public void remove(T item)
    {
        Integer current_count = item_counts.get(item);

        if (current_count == null)
        {
            return;
        }

        if (current_count == 1)
        {
            item_counts.remove(item);
        }
        else
        {
            item_counts.put(item, current_count - 1);
        }

        total_size--;
    }

    // Checks if the bag contains the item
    public boolean contains(T item)
    {
        return item_counts.containsKey(item);
    }

    // Returns the count of the item in the bag
    public int count(T item)
    {
        return item_counts.getOrDefault(item, 0);
    }

    // Returns the total number of elements in the bag including duplicates
    public int size()
    {
        return total_size;
    }

    // Merges another bag into this bag
    public void merge(Bag<T> other_bag)
    {
        for (Map.Entry<T, Integer> entry : other_bag.item_counts.entrySet())
        {
            T item = entry.getKey();
            int add_count = entry.getValue();

            item_counts.put(item, item_counts.getOrDefault(item, 0) + add_count);
            total_size += add_count;
        }
    }

    // Returns a new bag containing only distinct elements
    public Bag<T> distinct()
    {
        Bag<T> distinct_bag = new Bag<>();

        for (T item : item_counts.keySet())
        {
            distinct_bag.add(item);
        }

        return distinct_bag;
    }

    // toString method to display the contents of the bag
    @Override
    public String toString()
    {
        return "Bag" + item_counts + " (total items=" + total_size + ")";
    }
}

