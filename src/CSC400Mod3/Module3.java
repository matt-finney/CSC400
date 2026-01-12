package CSC400Mod3;

public class Module3 
{
    public static int findMissingNumber(int[] array) 
    {
        int n = array.length;

        // Expected sum of numbers from 1 to n + 1
        int expected_sum = (n + 1) * (n + 2) / 2;

        // actual sum of the array
        int actual_sum = 0;
        for (int num : array) {
            actual_sum += num;
        }

        // the difference is the missing number
        return expected_sum - actual_sum;
    }

    public static void main(String[] args) 
    {
        int[] array = {3, 6, 5, 1, 4}; // missing number is 2
        System.out.println("Missing number: " + findMissingNumber(array));
    }
}

