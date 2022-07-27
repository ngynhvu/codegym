package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.Interface.EmployeeService;
import FuramaResort.Services.WriteReadFileCSV;
import FuramaResort.Utils.*;

import java.util.*;


public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeesList = new ArrayList<>();
    private final String[] levelEmployee = {"Intermediate", "College", "University", "After university"};
    private final String[] postionEmployee = {"Receptionist", "Service", "Specialist", "Supervisor", "Manager", "Director"};
    @Override
    public List<Employee> findAll() {
        return employeesList;
    }

    @Override
    public void addEmployee(Employee employee) {
        if(employee!=null)
        {
            employeesList.add(employee);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
        Collections.sort(employeesList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        WriteReadFileCSV.writeToFileEmployee(WriteReadFileCSV.FILE_EMPLOYEE,employee);
    }

    @Override
    public void editEmployee(int idEmployee) {
        Scanner scanner = new Scanner(System.in);
        for(Employee employee: employeesList){
            if(employee.getEmployeeID() == idEmployee){
                System.out.println("Had found. Please edit!!!");
                System.out.print("Full name Employee: ");
                String name = scanner.nextLine();
                System.out.print("Date of Birth Employee: ");
                String date = BirthdayException.inputAndCheckBirthday18();
                System.out.print("Sex(1.Male, 2.Female, 3.Other): ");
                String sex  = GenderException.inputAndCheck();
                System.out.print("CMND: ");
                String cmnd = CMNDException.inputAndCheckId();
                System.out.print("Phone number Employee: ");
                String phone = CMNDException.inputAndCheckId();
                System.out.print("Email Employee: ");
                String email = scanner.nextLine();
                System.out.print("Level Employee(1.Intermediate, 2.College, 3.University, 4.After university): ");
                int choose = LevelException.inputAndCheck();
                System.out.print("Position Employee(1.Receptionist, 2.Service, 3.Specialist, 4.Supervisor, 5.Manager, 6.Director): ");
                int choosePosition = PostionException.inputAndCheck();
                System.out.print("Salary Employee: ");
                long salary = scanner.nextLong();
                employee.setFullName(name);
                employee.setDateOfBirth(date);
                employee.setSex(sex);
                employee.setNumberCMND(cmnd);
                employee.setPhoneNumber(phone);
                employee.setEmail(email);
                employee.setLevel(levelEmployee[choose-1]);
                employee.setPosition(postionEmployee[choosePosition-1]);
                employee.setSalary(salary);
                break;
            }else {
                System.out.println("Not Found");
            }
        }
    }
}
