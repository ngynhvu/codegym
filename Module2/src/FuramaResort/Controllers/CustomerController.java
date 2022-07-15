package FuramaResort.Controllers;

import FuramaResort.Models.Person.Customer;
import FuramaResort.Services.ClassImpl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {

    CustomerServiceImpl customerService = new CustomerServiceImpl();
    public void displayCustomer(){
        for(Customer customer : customerService.findAll()){
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
        System.out.print("Id Customer: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Type of Customer: ");
        String type = scanner.nextLine();
        System.out.print("Address Customer: ");
        String address = scanner.nextLine();
        customerService.addCustomer(new Customer(name, date, sex, cmnd,phone,email,id, type, address));
    }
}
