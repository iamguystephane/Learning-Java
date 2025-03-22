package errorHandling;
import java.util.Scanner;
public class userInputHandling {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your height: ");
            float number = scanner.nextFloat();
            System.out.println("Your height is: " + number + "m"); 
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid float");
        } finally {
            scanner.close();
            System.out.println("Scanner closed");
        }
    }
}