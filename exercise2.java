import java.util.Random;
import java.util.Scanner;

class Person {
    String name;
    String address;

    Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String GetName() {
        return name;
    }

    public String GetAddress(){
        return address;
    }

    public void SetAddress(String address) {
        this.address = address;
    }

    
    public String ToString(){
        return "Person[name=" + name + ",address=" + address + "]";
    }

}

class Student extends Person{
    String program;
    int year;
    double fee;

    Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String GetProgram(){
        return program;
    }

    public void SetProgram(String program){
        this.program = program;
    }

    public int GetYear(){
        return year;
    }

    public void SetYear(int year){
        this.year = year;
    }

    public double GetFee(){
        return fee;
    }

    public void SetFee(double fee){
        this.fee = fee;
    }

    public String ToString(){
        return "Student[" + super.ToString() + ",program=" + program + ",year=" + year + ",fee=" + fee + "]";
    }

    
}

class Staff extends Person{
    String school;
    double pay;

    Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String GetSchool(){
        return school;
    }

    public void SetSchool(String school){
        this.school = school;
    }

    public double GetPay(){
        return pay;
    }

    public void SetPay(double pay){
        this.pay = pay;
    }

    public String ToString(){
        return "Staff[" + super.ToString() + ",school=" + school + ",pay=" + pay + "]";
    }
}

class SchoolBusinessTest {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student [] students = new Student[5];

        for (int i = 0 ; i < 5 ; i++) {
            System.out.print("Enter student "+ i +" name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student "+ i +"  address: ");
            String address = scanner.nextLine();

            Student student = new Student(name, address, "Computer Science", 2023, 400000);
            students[i] = student;
        }

        for (Student student : students) {
            System.out.println(student.ToString());
        }

        Staff staff = new Staff("Nguyen Duc Anh", "268 Ly Thuong Kiet", "School of Computer Science", 5000000.0);
        System.out.println(staff.ToString());
    

        scanner.close();
    }
}


public class exercise2 {
    public static void main(String[] args) {
        SchoolBusinessTest schoolBusinessTest = new SchoolBusinessTest();
        schoolBusinessTest.main(args);
    }
}
