package assignment;
import java.util.InputMismatchException;
import java.util.Scanner;

public class inputErrorHandling {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter any number between 1 and 100 inclusive: ");
            int number = scanner.nextInt();
            if (number > 100 || number < 1) {
                System.out.println("The number you entered does not fall within the range");
            } else {
                System.out.println("The number you entered is: " + number);
            }
        } catch (InputMismatchException e) {
            System.out.println("You can only enter an integer");
        } finally {
            scanner.close();
            System.out.println("Program execution completed, and scanner closed!");
        }
    }
}