package CSC400Mod6;

public class Discussion6Example 
{
    public static void selectionSort(double[] sales) 
    {
        for (int i = 0; i < sales.length - 1; i++) 
        {
            int min_index = i;

            for (int j = i + 1; j < sales.length; j++) 
            {
                if (sales[j] > sales[min_index]) 
                {
                    min_index = j;
                }
            }

            double temp = sales[min_index];
            sales[min_index] = sales[i];
            sales[i] = temp;
        }
    }

    public static void main(String[] args) 
    {
        double[] daily_sales = {245.50, 189.99, 310.75, 199.25, 150.00};

        System.out.println("Daily sales before sorting:");
        for (double sale : daily_sales) 
        {
            System.out.printf("$%.2f ", sale);
        }

        System.out.println();
        selectionSort(daily_sales);

        System.out.println("\nDaily sales after sorting:");
        for (double sale : daily_sales) 
        {
            System.out.printf("$%.2f ", sale);
        }
    }
}


