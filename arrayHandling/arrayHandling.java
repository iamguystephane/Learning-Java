package arrayHandling;
import java.util.ArrayList;
import java.util.Scanner;

class studentManagement {
    Scanner scanner = new Scanner(System.in);
    private String managerName;
    private boolean removeFlag = false;
    private ArrayList<String> studentArray = new ArrayList<>();
    public studentManagement(String name) {
        this.managerName = name;
    }
    String getManagerName() {
        return this.managerName;
    }
    ArrayList<String> getStudentArray() {
        return this.studentArray;
    }
    void addStudent() {
        String studentName;
        System.out.println("Enter the student's name: ");
        studentName = scanner.nextLine();
        this.studentArray.add(studentName);
    }
    void removeStudent() {
        String studentName;
        System.out.println("Enter the student's name to be removed: ");
        studentName = scanner.nextLine();
        if (this.studentArray.stream().anyMatch(student -> student.toLowerCase().equals(studentName.toLowerCase()))) {
            this.studentArray.removeIf(student -> student.toLowerCase().equals(studentName.toLowerCase()));
            removeFlag = true;
        } else {
            removeFlag = false;
        }
    }
    void displayStudents() {
        if (this.studentArray.size() > 0) {
            System.out.println("\nDisplaying all students");
            System.out.println(this.studentArray);
        } else{
            System.out.println("Could not print the array because it is empty!");
        }
    }
    boolean getRemoveFlag() {
        return this.removeFlag;
    }
}


public class arrayHandling { 
    public static String validateInput(String userChoice, Scanner scanner) {
        userChoice = scanner.nextLine().toLowerCase();
        while (!userChoice.equals("yes") && !userChoice.equals("no")) {
            System.out.println("Invalid choice, please try again: ");
            userChoice = scanner.nextLine().toLowerCase();
        }
        return userChoice;
    }
    public static void main(String [] args) {
      Scanner scanner = new Scanner(System.in);
      String userChoice = "";
      studentManagement m1 =  new studentManagement("Guy Stephane");
      System.out.println("Before adding any student");
      m1.displayStudents(); 

      System.out.println("Do you want to add a student to the list? (type yes or no): ");
      String newUserChoice = validateInput(userChoice, scanner);
      while (newUserChoice.equals("yes")) {
        m1.addStudent();
        System.out.println("Student added successfully!");
        System.out.println("Do you want to add another student to the list? (type yes or no): ");
        newUserChoice = validateInput(userChoice, scanner);
      }
      
      System.out.println("Do you want to print the array list? (yes or no): ");
      newUserChoice = validateInput(userChoice, scanner);
      if (newUserChoice.equals("yes")) {
        m1.displayStudents();
      }

      System.out.println("Do you want to remove a student from the list? (yes or no): ");
      newUserChoice = validateInput(userChoice, scanner);
      while (newUserChoice.equals("yes")) {
          ArrayList<String> studentArray = m1.getStudentArray();
          if (studentArray.size() > 0) {
            m1.removeStudent();
            boolean flag = m1.getRemoveFlag();
            if (flag) {
                System.out.println("Student was found and removed successfully!");
                System.out.println("Do you want to remove another student from the list? (yes or no): ");
                newUserChoice = validateInput(userChoice, scanner);
            } else {
                System.out.println("Could not find student with that name on the list");
                System.out.println("Do you want to try removing the student again? (yes or no): ");
                newUserChoice = validateInput(userChoice, scanner);
            }
        } else {
            System.out.println("Cannot remove any student from the list because it is empty!");
            break;
        }
      }
      System.out.println("Do you want to print the new and updated array list? (yes or no): ");
      newUserChoice = validateInput(userChoice, scanner);
      if (newUserChoice.equals("yes")) {
        m1.displayStudents();
      }
      scanner.close();
    }
}
