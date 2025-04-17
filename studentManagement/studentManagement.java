package studentManagement;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Student implements Serializable{
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
        return "Name: " + this.name + "ID: " + this.ID + "Grade: " + this.grade;
    }
}
class studentManager {
    private ArrayList<Student> arr;
    private final String FILE_NAME = "student.dat";
    public studentManager() {
        this.arr = loadFromFile();
    }
    public void saveToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(arr);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private ArrayList<Student> loadFromFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    public void addStudent(Student student) {
       this.arr.add(student);
       saveToFile();
       System.out.println("Student added and saved!");
    }
    public void deleteStudent(String name) {
        boolean removed = arr.removeIf(s -> s.getName().equalsIgnoreCase(name));
        if(removed) {
            saveToFile();
            System.out.println("Student with name " + name + " was removed");
        } else {
            System.out.println("Failed to remove student");
        }
    }
    public void updateStudent(String name, String newGrade, String newId, String newName) {
        for(Student s : arr) {
            if(s.getName().equalsIgnoreCase(name)) {
                s.setGrade(newGrade);
                s.setGrade(newGrade);
                s.setName(newName);
                saveToFile();
                System.out.println("Student with name " + name + " was updated");
            }
        }
        System.out.println("Student with name " + name + "not found");
    }
}
    



public class studentManagement {
    public static void main(String[] args) {

    }
}
