package FuramaResort.Models.Person;

import java.util.Date;

public class Employee extends Person {
    private int employeeID;
    private String level;
    private String position;
    private long salary;

    public Employee(String fullName, String dateOfBirth, String sex, String numberCMND, String phoneNumber, String email, int employeeID, String level, String position, long salary) {
        super(fullName, dateOfBirth, sex, numberCMND, phoneNumber, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", employeeID=" + employeeID +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String simpleString(){
        return super.simpleString() +","+employeeID+","+level+","+position+","+salary;
    }
}
