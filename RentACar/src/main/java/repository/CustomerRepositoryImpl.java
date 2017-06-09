package repository;

import domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerRepositoryImpl() {
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    public void addAll(List<Customer> customerList) {
        customerList.addAll(customerList);
    }


    public void add(Customer customer) {
        customers.add(customer);
    }


    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public void update(Customer customer) {
        customers.set(customers.indexOf(customer), customer);
    }

    public void delCustomerById(int id) {
        Customer foundCustomer = null;
        for (Customer customer1 : customers) {
            if (id == customer1.getUserid()) {
                foundCustomer = customer1;
                break;


            }


        }
        if (foundCustomer != null) {
            customers.remove(foundCustomer);
        } else {
            System.out.println("User id not found in database.");
        }
    }


    @Override
    public String toString() {
        return " ";
    }
}






