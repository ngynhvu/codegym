package FuramaResort.Services.FileCSV;

import FuramaResort.Models.Person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileCSV {
    public static final String FILE_STUDENT_CSV ="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\employee.csv";
    public static void writeFile(Employee employee){
       try {
           FileWriter fileWriter = new FileWriter(FILE_STUDENT_CSV, true);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(employee.toString());
           bufferedWriter.newLine();
           bufferedWriter.close();
       } catch (IOException e) {
           System.out.println("File recording failed!");
       }
   }
   public static List<Employee> readCSV(){
        List<Employee> employeeList = new ArrayList<>();
       FileReader fileReader = null;
       BufferedReader bufferedReader = null;
       try{
           fileReader = new FileReader(FILE_STUDENT_CSV);
           bufferedReader = new BufferedReader(fileReader);
           String line;
           String temp[];
           Employee employee;

           while ((line = bufferedReader.readLine()) != null) {
               temp = line.split(",");
               String name = temp[0];
               String birthday = temp[1];
               String sex = temp[2];
               String cmnd = temp[3];
               String phone = temp[4];
               String email = temp[5];
               int id = Integer.parseInt(temp[6]);
               String level = temp[7];
               String position = temp[8];
               Long salary = Long.parseLong(temp[9]);
               employee = new Employee(name,birthday,sex,cmnd,phone,email,id,level,position,salary);
               employeeList.add(employee);
           }
       }catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       } finally {
           try {
               bufferedReader.close();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
       return employeeList;
   }

    public static void main(String[] args) {
//        Employee employee = new Employee("anh","20/01/2001","3","4","5","6",7,"đại học","8",80000);
//        writeFile(employee);
        List<Employee> employeeList = readCSV();
        for (Employee employee1: employeeList) {
            System.out.println(employee1);
        }
    }
}
