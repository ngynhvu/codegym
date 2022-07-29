package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Person.Customer;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.Interface.CustomerService;
import FuramaResort.Services.WriteReadFileCSV;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList=new LinkedList<>();

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        if(customer!=null)
        {
            customerList.add(customer);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
        Collections.sort(customerList, new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }   
        });
        WriteReadFileCSV.writeToFileCustomer(WriteReadFileCSV.FILE_CUSTOMER,customer);
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
