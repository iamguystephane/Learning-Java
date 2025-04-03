package binarySort;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;


public class binarySearchProgram {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("How many elements of the array do you want to store?: ");
            int n = scanner.nextInt();
            int []arr = new int[n];
            scanner.nextLine();
            try {
                System.out.println("Enter " + n + " sorted integers");
                for(int i = 0; i < n; i++) {
                    System.out.print("Enter element " + (i+1) + ": ");
                    arr[i] = scanner.nextInt();
                }
                System.out.print("Enter the number you are trying to look for: ");
                scanner.nextLine();
                int k = scanner.nextInt();
                int result = binarySearch(arr, k);
                if(result == -1) {
                    System.out.println("Could not find the number you were looking for.");
                } else {
                    System.out.println("The element was found at position " + (result + 1) + " and index " + result);
                }
            } catch (InputMismatchException e) {
                System.out.println("You entered a non-integer value!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Please enter an integer!");
        } finally {
            scanner.close();
        }
    }
}