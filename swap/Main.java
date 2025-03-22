package swap;
public class Main {
    public static void main(String[] args) {
       int a = 10;
       int b = 20;
       int temp;
       
       System.out.println("Before swapping --------------------");
       System.out.println("The value of a is: " + a + " and the value of b is: " + b);
       
       // Swapping logic using a temporary variable
       temp = a;
       a = b;
       b = temp;
       
       System.out.println("After swapping ---------------------");
       System.out.println("The value of a is: " + a + " and the value of b is: " + b);

    }
}