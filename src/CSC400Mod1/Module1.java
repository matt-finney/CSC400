package CSC400Mod1;

/*
    CSC400 Module 1
    Matthew Finney
    Creating a generic Bag class and testing it through various adding and removing.

    https://github.com/matt-finney/CSC400
*/

public class Module1 
{
    public static void main(String[] args) 
    {
        // Create an instance of the Bag
        Bag<String> bag = new Bag<>();

        // Add items, including duplicates
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("orange");
        bag.add("banana");
        bag.add("apple");

        // Print the bag contents
        System.out.println("Initial bag contents:");
        System.out.println(bag);
        System.out.println();

        // Test the contains method
        System.out.println("Contains tests:");
        System.out.println("contains(\"apple\")  = " + bag.contains("apple"));
        System.out.println("contains(\"grape\")  = " + bag.contains("grape"));
        System.out.println("contains(\"banana\") = " + bag.contains("banana"));
        System.out.println();

        // Test the count method
        System.out.println("Count tests:");
        System.out.println("count(\"apple\")  = " + bag.count("apple"));
        System.out.println("count(\"banana\") = " + bag.count("banana"));
        System.out.println("count(\"grape\")  = " + bag.count("grape"));
        System.out.println();

        // Remove an item
        bag.remove("apple");

        // Print bag contents again
        System.out.println("Bag contents after removing one \"apple\":");
        System.out.println(bag);
        System.out.println();

        // Test contains after removing an item
        System.out.println("After removal:");
        System.out.println("contains(\"apple\") = " + bag.contains("apple"));

        // Test count after removing an item
        System.out.println("count(\"apple\")    = " + bag.count("apple"));
    }
}
