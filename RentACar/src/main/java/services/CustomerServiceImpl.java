package services;

import domain.customer.Customer;
import repository.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;


public class CustomerServiceImpl implements CustomerService {
  private static final CustomerServiceImpl instance = new CustomerServiceImpl(new CustomerRepositoryImpl());
  private CustomerRepositoryImpl customerRepository;

  public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
    this.customerRepository = customerRepository;
  }

  public static CustomerServiceImpl getInstance() {
    return instance;
  }


  @Override
  public List<Customer> getAll() {
    return this.customerRepository.getAll();
  }

  @Override
  public void add(Customer customer) {
    this.customerRepository.add(customer);

  }

  @Override
  public void delete(Customer customer) {
    this.customerRepository.delete(customer);
  }

  @Override
  public void update(Customer customer) {
    this.customerRepository.update(customer);

  }

  public List<Customer> findCustomerByFirstName(String firstName) {
    List<Customer> foundCustomers = new ArrayList<>();


    for (Customer customer : customerRepository.getAll()) {
      if (customer.getFirstname().equalsIgnoreCase(firstName)) {
        foundCustomers.add(customer);
      }
    }
    return foundCustomers;

  }

  public List<Customer> findCustomerByFullName(String firstName, String lastName) {
    List<Customer> foundCustomers = new ArrayList<>();


    for (Customer customer : customerRepository.getAll()) {
      if (customer.getFirstname().equalsIgnoreCase(firstName) && customer.getLastname().equalsIgnoreCase(lastName)) {
        foundCustomers.add(customer);
      }
    }
    return foundCustomers;

  }


  public List<Customer> findCustomerById(int id) {

    List<Customer> foundCustomers = new ArrayList<>();
    for (Customer customer : customerRepository.getAll()) {
      if (customer.getId() == id) {
        foundCustomers.add(customer);
      } else {

      }
    }
    return foundCustomers;
  }

}


