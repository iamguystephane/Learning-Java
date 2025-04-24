package contactManager;
import java.io.*;
import java.util.Scanner;
public class contactManager {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter("contactManager/address.txt", true);
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dob = scanner.nextLine();
            writer.write(name + ", " + phone + ", " + email + ", " + address + ", " + dob + "\n");
            writer.close();
            System.out.println("Adress information saved!");

            System.out.println("\nAll Information: ");
            BufferedReader reader = new BufferedReader(new FileReader("contactManager/address.txt"));
            String line;
            while((line = reader.readLine()) !=null ) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0] + ", Phone: " + parts[1] + ", Email: " + parts[2] + ", Address: " + parts[3] + ", DOB: " + parts[4]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
