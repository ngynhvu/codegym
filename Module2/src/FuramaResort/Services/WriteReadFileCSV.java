package FuramaResort.Services;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Models.Person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteReadFileCSV {
    public static final String FILE_EMPLOYEE="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\employee.csv";
    public static final String FILE_CUSTOMER="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\customer.csv";
    public static final String FILE_VILLA="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\villa.csv";
    public static final String FILE_HOUSE="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\house.csv";
    public static final String FILE_ROOM="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\room.csv";
    public static final String FILE_BOOKING="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\booking.csv";
    public static final String FILE_CONTRACT="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\contract.csv";
    public static final String FILE_VOUCHER="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\voucher.csv";
    public static void writeToFileEmployee(String path, Employee employee ) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(employee.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> readEmloyeeCSV() {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_EMPLOYEE);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Employee employee;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String date = temp[1];
                String sex = temp[2];
                String cmnd = temp[3];
                String phone = temp[4];
                String email = temp[5];
                int id = Integer.parseInt(temp[6]);
                String level = temp[7];
                String position = temp[8];
                long salary = Long.parseLong(temp[9]);
                employee = new Employee(name,date,sex,cmnd,phone,email,id,level,position,salary);
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return employeeList;
    }
}
