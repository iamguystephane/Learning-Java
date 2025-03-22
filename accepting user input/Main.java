import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // clear the scanner to remove the escape sequence.
        System.out.println("What is your favorite food? ");
        String food = scanner.nextLine();
        System.out.println("Your name is " + name + " and you are " + age + " years old" + " and you like " + food);
        scanner.close();
    }
}