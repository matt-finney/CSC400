package CSC400Mod2;
/*
    CSC400 Module 2
    Matthew Finney
    Demonstrates size, merge, and distinct methods of the Bag class.
    
    https://github.com/matt-finney/CSC400
*/
public class Module2
{
    public static void main(String[] args)
    {
        // Create two instances of the `Bag` class
        Bag<String> first_bag = new Bag<>();
        Bag<String> second_bag = new Bag<>();

        // Add elements to each bag, including duplicates
        first_bag.add("apple");
        first_bag.add("apple");
        first_bag.add("banana");

        second_bag.add("banana");
        second_bag.add("orange");
        second_bag.add("orange");

        // Print the size of each bag using the `size` method
        System.out.println("First bag: " + first_bag);
        System.out.println("First bag size: " + first_bag.size());
        System.out.println();

        System.out.println("Second bag: " + second_bag);
        System.out.println("Second bag size: " + second_bag.size());
        System.out.println();

        // Merge the two bags together using the `merge` method
        first_bag.merge(second_bag);

        // Print the merged bag contents
        System.out.println("After merging second bag into first bag:");
        System.out.println(first_bag);
        System.out.println("Merged bag size: " + first_bag.size());
        System.out.println();

        // Create a new bag containing only the distinct elements using the `distinct` method
        Bag<String> distinct_bag = first_bag.distinct();

        // Print the distinct bag contents
        System.out.println("Distinct bag contents:");
        System.out.println(distinct_bag);
        System.out.println("Distinct bag size: " + distinct_bag.size());
    }
}
