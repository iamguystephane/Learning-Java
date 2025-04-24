package fileHandling;
import java.io.*;

public class readWrite {
    public static void main(String [] args) {

        //writing to a file.
        try {
            FileWriter writer = new FileWriter("fileHandling/data.txt");
            writer.write("Hello world");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reading from a file.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fileHandling/data.txt"));
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
