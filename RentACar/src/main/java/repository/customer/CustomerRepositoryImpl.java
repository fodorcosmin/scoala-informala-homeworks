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
        System.out.println("" + readCustomers(customers));
    }

    public void addAll(List<Customer> customers) {
        customers.addAll(customers);
    }


    public void add(Customer customer) throws IOException {
        customers.add(customer);
        saveCustomers(customers);
    }


    public List<Customer> saveCustomers(List<Customer> customers) throws IOException {
        FileOutputStream fout = new FileOutputStream("customers.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(customers);
        fout.close();
        return customers;
    }


    public List<Customer> readCustomers(List<Customer> customers) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("customers.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        customers = (List<Customer>) ois.readObject();
        ois.close();
        return customers; //TODO  some problems here :)
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






