package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Person.Customer;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.Interface.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList;
    static {
        customerList = new LinkedList<>();
        customerList.add(new Customer("Hoang Tien Anh","18/01/2001", "Nam","23", "0705944385","anhhtgcd191331",1, "Trung cấp", "giám đốc"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void editCustomer(int idCustomer) {
        Scanner scanner = new Scanner(System.in);
        for(Customer customer: customerList){
            if(customer.getCustomerID() == idCustomer){
                System.out.print("Full name Customer: ");
                String name = scanner.nextLine();
                System.out.print("Date of Birth Customer: ");
                String date = scanner.nextLine();
                System.out.print("Sex(Male or Female): ");
                String sex  = scanner.nextLine();
                System.out.print("CMND: ");
                String cmnd = scanner.nextLine();
                System.out.print("Phone number Customer: ");
                String phone = scanner.nextLine();
                System.out.print("Email Customer: ");
                String email = scanner.nextLine();
                System.out.print("Type of Customer: ");
                String type = scanner.nextLine();
                System.out.print("Address Customer: ");
                String address = scanner.nextLine();
                customer.setFullName(name);
                customer.setDateOfBirth(date);
                customer.setSex(sex);
                customer.setNumberCMND(cmnd);
                customer.setPhoneNumber(phone);
                customer.setEmail(email);
                customer.setTypeOfCustomer(type);
                customer.setAddress(address);
                break;
            }else {
                System.out.println("Not Found");
            }
        }
    }
}
