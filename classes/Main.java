
package classes;
class Person {
    private String name;
    private int age;
    public Person() {
        this.name = "John Doe";
        this.age = 20;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
}

class Student extends Person {
    private String studentId;
    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }
    
    public String studentId() {
        return this.studentId;
    }
}
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Guy Stephane", 21, "CITECSWE12");

        System.out.println("Your name is: " + student1.getName());
        System.out.println("Your age is: " + student1.getAge());
        System.out.println("Your student id is: " + student1.studentId());

    }
}