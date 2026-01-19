package CSC400Mod5;

import java.util.Arrays;

/*
    CSC400 Module 5
    Matthew Finney
    Option #1: Integer Objects
    Implements the Radix Sort algorithm to sort an array of integers.

    https://github.com/matt-finney/CSC400
*/
public class RadixSort {
    
    public static void radixSort(int arr[])
    {
        int size = arr.length;
        // get the max value inside the array
        int max = getMax(arr, size);
        
        // do counting sort for every digit place
        for (int pos = 1; max / pos > 0; pos *= 10)
            countingSort(arr, pos);
    }

    // helper method to get the maximum value in arr[]
    public static int getMax(int arr[], int size)
    {
        int max = arr[0];
        for (int i = 1; i < size; i++)
        {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // use a counting sort algorithm to sort the array based on the digit place
    static void countingSort(int arr[], int pos)
    {
        int size = arr.length;
        int output[] = new int[size]; // output array of new sorted values
        int count[] = new int[10]; // count array to hold the count of times each digit is seen
        Arrays.fill(count, 0); // initialize count array to 0

        // store the count of occurrences of the digits in count[]
        for (int i = 0; i < size; i++) 
        {
            int index = (arr[i] / pos) % 10;
            count[index]++;
        }

        // update the count[i] so it correctly has the same position as in output[]
        for (int i = 1; i < 10; i++)
            count[i] = count[i] + count[i - 1];

        // start to populate the output array
        for (int i = size - 1; i >= 0; i--)
        {
            int index = (arr[i] / pos) % 10; 
            output[count[index] - 1] = arr[i]; // place in the correct position in output[]
            count[index]--;
        }

        // now update arr[] with the newly sorted values that are in output[]
        for (int i = 0; i < size; i++)
            arr[i] = output[i];

    }
}
