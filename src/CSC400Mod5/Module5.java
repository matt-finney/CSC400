package CSC400Mod5;

/*
    CSC400 Module 5
    Matthew Finney
    Option #1: Integer Objects
    Demonstrates the Radix Sort algorithm to sort an array of integers.

    https://github.com/matt-finney/CSC400
*/

public class Module5 {
   public static void main(String args[]) 
   {
        int[] values = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        int n = values.length;

        System.out.println("Unsorted values: ");
        for (int i = 0; i < n; ++i)
            System.out.print(values[i] + " ");

        RadixSort.radixSort(values);

        System.out.println("\nSorted values: ");
        for (int i = 0; i < n; ++i)
            System.out.print(values[i] + " ");
   }
}
