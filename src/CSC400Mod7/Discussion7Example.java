package CSC400Mod7;

public class Discussion7Example
{
    public static void mergeSort(int[] arr)
    {
        if (arr == null || arr.length <= 1)
        {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right)
    {
        if (left >= right)
        {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right)
    {
        // Copy the current range into temp once
        for (int i = left; i <= right; i++)
        {
            temp[i] = arr[i];
        }

        int i = left;     // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = left;     // pointer for merged output in arr

        while (i <= mid && j <= right)
        {
            if (temp[i] <= temp[j])
            {
                arr[k] = temp[i];
                i++;
            }
            else
            {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining left half elements, if any
        while (i <= mid)
        {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 8, 3, 5, 2, 9, 1, 4 };

        System.out.println("Before:");
        printArray(nums);

        mergeSort(nums);

        System.out.println("After:");
        printArray(nums);
    }

    private static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
