package classwork;


class Student {
    private String name;
    private String idNumber;

    Student() {
        this.name = "Steph";
        this.idNumber = "M007";
    }
    
    Student(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }
    void greetings() {
        System.out.println("Hello " + name + " ur student id is : " + idNumber);
    }

    //getters
    String getName() {
        return this.name;
    }
    String idNumber() {
        return this.idNumber;
    }

    //setters
    void setName(String name) {
        this.name = name;
    }
    void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
     public static void main(String [] args){
        Student S1 = new Student();
        S1.greetings();
    }
}
   

