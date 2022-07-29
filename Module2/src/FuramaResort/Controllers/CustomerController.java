package FuramaResort.Controllers;

import FuramaResort.Models.Person.Customer;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.ClassImpl.CustomerServiceImpl;
import FuramaResort.Services.WriteReadFileCSV;
import FuramaResort.Utils.BirthdayException;
import FuramaResort.Utils.CMNDException;
import FuramaResort.Utils.ChooseException;
import FuramaResort.Utils.GenderException;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private final String[] typeOfCustomer = {"Diamond", "Platinium", "Gold", "Silver", "Member"};
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    BirthdayException birthdayException = new BirthdayException();
    public void displayCustomer(){
        List<Customer> customerList = WriteReadFileCSV.readCustomerCSV();
        for(Customer customer: customerList){
            System.out.println(customer);
        }
    }
    public void editCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer id customer: ");
        int id = scanner.nextInt();
        customerService.editCustomer(id);
    }
    public void addNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full name Customer: ");
        String name = scanner.nextLine();
        String date = birthdayException.inputAndCheckBirthday18();
        System.out.print("Sex(1.Male, 2.Female, 3.Other): ");
        String sex  = GenderException.inputAndCheck();
        System.out.print("CMND: ");
        String cmnd = CMNDException.inputAndCheckId();
        System.out.print("Phone number Customer: ");
        String phone = CMNDException.inputAndCheckId();
        System.out.print("Email Customer: ");
        String email = scanner.nextLine();
        System.out.print("Id Customer: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Type of Customer(1.Diamond, 2.Platinium, 3.Gold, 4.Silver, 5.Member): ");
        int choose = ChooseException.inputAndCheck();
        System.out.print("Address Customer: ");
        String address = scanner.nextLine();
        customerService.addCustomer(new Customer(name, date, sex, cmnd,phone,email,id, typeOfCustomer[choose-1], address));
    }
}
