import java.util.InputMismatchException;
import java.util.Scanner;

class rectangleOperations {
    private double length;
    private double width;

    //constructors
    //default constructor
    public rectangleOperations() {
        this.length = 4.2;
        this.width = 10.3;
    }
    //parameterized constructor
    public rectangleOperations(double l, double w) {
        this.length = l;
        this.width = w;
    }
    public double calculateArea() {
        return length * width;
    }
}

public class rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            scanner.nextLine();
            rectangleOperations rectangle = new rectangleOperations(length, width); // instantiate the class with data inputed by the user
            double area = rectangle.calculateArea();
            System.out.println("The area of the rectangle is: " + area + " square meters");
        } catch(InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}