package multipleExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class multipleExceptionHandling {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //get user inputs
            System.out.println("Enter any number: ");
            int num1 = scanner.nextInt();   // may cause inputMisMatchException
            scanner.nextLine();
            System.out.println("Enter the second number: ");
            int num2 = scanner.nextInt();   // may cause inputMisMatchException

            //perform division
            int result = num1 % num2;
            System.out.println("The division of " + num1 + " and " + num2 + " is " + result);   //may cause ArithmeticException if num2 is 0

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by 0");
        } catch (InputMismatchException e) {
            System.out.println("Only integers are supposed to be entered");
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program executed completely, and scanner was closed");
        }
    }
}
