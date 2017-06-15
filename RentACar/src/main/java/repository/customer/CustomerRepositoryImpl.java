package repository.customer;

import domain.customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers;

    public CustomerRepositoryImpl() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void getAll() throws IOException, ClassNotFoundException {
        System.out.println("" + readAllCustomers());
    }

    public void addAll(List<Customer> customers) {
        customers.addAll(customers);
    }


    public void add(Customer customer) throws IOException {
        customers.add(customer);
        saveCustomerToFile(customer);
    }


    public void saveCustomerToFile(Customer customer) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("transactions.txt"));
        output.writeObject(customer);
        output.close();
    }


    public List<Customer> readAllCustomers() throws IOException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        try {
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("customers.txt"));
            Customer customer = null;
            while ((customer = (Customer) objIn.readObject()) != null) {
            }
            objIn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public void update(Customer customer) {
        customers.set(customers.indexOf(customer), customer);
    }

    public void delCustomerById(int id) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (id == customer.getUserid()) {
                foundCustomer = customer;
                break;
            }


        }
        if (foundCustomer != null) {
            customers.remove(foundCustomer);
        } else {
            System.out.println("User id not found in database.");
        }
    }

    public List<Customer> getCustomerByFullName(String firstName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getFirstname().equalsIgnoreCase(firstName) && customer.getLastname().equalsIgnoreCase(lastName)) {
                foundCustomers.add(customer);

            }
        }
        return foundCustomers;
    }

    public List<Customer> getCustomerById(int id) {
        List<Customer> foundCustomers = new ArrayList<>();
        boolean idFound = false;
        for (Customer customer : customers) {
            if (id == customer.getUserid()) {
                idFound = true;
                foundCustomers.add(customer);
                System.out.println("User id exists in the database with the name of " + customer.getFirstname() + " " + customer.getLastname());
            }
        }
        if (!idFound) {
            System.out.println("User not found!");
        }
        return null;
    }


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "customers= " + customers;
    }
}






