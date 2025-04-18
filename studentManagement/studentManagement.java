package studentManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

class Student {
    private String grade;
    private String name;
    private String ID;

    public Student(String grade, String name, String ID) {
        this.grade = grade;
        this.name = name;
        this.ID = ID;
    }

    String getName() {
        return this.name;
    }

    String getGrade() {
        return this.grade;
    }

    String getID() {
        return this.ID;
    }

    void setGrade(String newGrade) {
        this.grade = newGrade;
    }

    void setName(String newName) {
        this.name = newName;
    }

    void setID(String newID) {
        this.ID = newID;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", ID: " + this.ID + ", Grade: " + this.grade;
    }
}

class studentManager {
    private ArrayList<Student> arr;
    private final String FILE_NAME = "studentManagement/student.txt";

    public studentManager() {
        this.arr = loadFromFile();
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Name,ID,Grade");
            writer.newLine();
            for (Student s : arr) {
                writer.write(s.getName() + "," + s.getID() + "," + s.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private ArrayList<Student> loadFromFile() {
        ArrayList<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    list.add(new Student(parts[2], parts[0], parts[1])); // grade, name, ID
                }
            }
        } catch (IOException e) {
            return new ArrayList<>();
        }
        return list;
    }

    public void addStudent(Student student) {
        this.arr.add(student);
        saveToFile();
        System.out.println("Student added and saved!");
    }

    public void deleteStudent(String name) {
        boolean removed = arr.removeIf(s -> s.getName().equalsIgnoreCase(name));
        if (removed) {
            saveToFile();
            System.out.println("Student with name " + name + " was removed");
        } else {
            System.out.println("Failed to remove student");
        }
    }

    public boolean updateStudent(String name, String newGrade, String newId, String newName) {
        boolean isUpdated = false;
        for (Student s : arr) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.setID(newId);
                s.setGrade(newGrade);
                s.setName(newName);
                isUpdated = true;
                saveToFile();
            }
        }
        return isUpdated;
    }
}

public class studentManagement {
    public static int askChoice(Scanner scanner) {
        int choice;
        try {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            choice = 10;
            scanner.nextLine();
            System.out.println("Invalid input. Please enter an integer");
        }
        return choice;
    }

    public static void main(String[] args) {
        studentManager m1 = new studentManager();
        Scanner scanner = new Scanner(System.in);
        int choice = askChoice(scanner);

        while (choice == 1 || choice == 2 || choice == 3 || choice == 0) {
            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    m1.addStudent(new Student(grade, name, id));
                    break;
                case 2:
                    System.out.print("Enter student's name to be deleted: ");
                    String studName = scanner.nextLine();
                    m1.deleteStudent(studName);
                    break;
                case 3:
                    System.out.print("Enter student's name to be modified: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student's new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter student's new ID: ");
                    String studid = scanner.nextLine();
                    System.out.print("Enter student's new grade: ");
                    String studgrade = scanner.nextLine();
                    boolean isUpdated = m1.updateStudent(studentName, studgrade, studid, newName);
                    if (isUpdated) {
                        System.out.println("Student with name " + studentName + " was updated successfully!");
                    } else {
                        System.out.println("Student " + studentName + " was not found!");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    choice = 10;
                    break;
                default:
                    System.out.println("Invalid input. Exiting...");
                    choice = 10;
                    break;
            }
            if (choice != 10) {
                choice = askChoice(scanner);
            }
        }
        scanner.close();
    }
}
