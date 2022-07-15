package FuramaResort.Services.Interface;

import FuramaResort.Models.Person.Customer;


import java.util.List;

public interface CustomerService extends Service{
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void editCustomer( int id);
}
