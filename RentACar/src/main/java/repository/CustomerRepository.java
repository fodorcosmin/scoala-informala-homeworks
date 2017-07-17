package repository;

import domain.customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class CustomerRepository implements Repository<Customer> {

  private List<Customer> customers;

  public CustomerRepository() {
    this.customers = new ArrayList<>();
  }

  @Override
  public List<Customer> getAll() {
    return customers;
  }

  public void addAll(List<Customer> customers) {
    customers.addAll(customers);
  }


  public void add(Customer customer) {
    customers.add(customer);
    saveToFile(customer);
  }

  public void remove(Customer customer) {
    customers.remove(customer);
  }

  public void update(List<Customer> customers) {
  }

  public void delCustomerById(int id) {
    Customer foundCustomer = null;
    for (Customer customer : customers) {
      if (id == customer.getId()) {
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


  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
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
      if (id == customer.getId()) {
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

  public void saveToFile(Customer customer) {
    try {
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("customers.txt"));
      output.writeObject(customer);

      output.flush();
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public List<Customer> readAll() {
    List<Customer> customers1 = new ArrayList<>();
    try {
      ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("customers.txt"));
      Customer customer = null;
      while ((customer = (Customer) objIn.readObject()) != null) {
        customers1.add(customer);
      }
      objIn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return customers1;
  }

  @Override
  public String toString() {
    return "customers= " + customers;
  }
}






