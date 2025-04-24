package contactManager;
import java.io.*;
import java.util.Scanner;
public class contactManager {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter("contactManager/contacts.txt", true);
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();
            writer.write(name + ", " + phone + "\n");
            writer.close();
            System.out.println("Contact saved!");

            System.out.println("\nAll Contacts: ");
            BufferedReader reader = new BufferedReader(new FileReader("contactManager/contacts.txt"));
            String line;
            while((line = reader.readLine()) !=null ) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0] + ", Phone: " + parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
