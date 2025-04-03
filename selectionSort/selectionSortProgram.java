package selectionSort;
import java.util.Scanner;



public class selectionSortProgram {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the number of integers
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        // Create an array to store the integers
        int[] numbers = new int[n];

        // Ask the user to enter the integers
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Perform selection sort
        selectionSort(numbers);

        // Print the sorted array
        System.out.println("Sorted integers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Method to perform selection sort
    
}
