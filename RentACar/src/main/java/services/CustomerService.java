//package services;
//
//import domain.customer.Customer;
//import repository.CustomerRepository;
//import util.MyLogger;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//
///**
// * Created by Fodor Cosmin on 5/26/2017.
// */
//public class CustomerService implements SearchService<Customer> {
//
//  private CustomerRepository customerRepository;
//
//  public CustomerService() {
//  }
//
//
//  public List<Customer> findCustomerByFirstName(String firstName) {
//    List<Customer> foundCustomers = new ArrayList<>();
//
//
//    for (Customer customer : customerRepository.getAll()) {
//      if (customer.getFirstname().equalsIgnoreCase(firstName)) {
//        foundCustomers.add(customer);
//      }
//    }
//    return foundCustomers;
//
//  }
//
//  public List<Customer> findCustomerByFullName(String firstName, String lastName) {
//    List<Customer> foundCustomers = new ArrayList<>();
//
//
//    for (Customer customer : customerRepository.getAll()) {
//      if (customer.getFirstname().equalsIgnoreCase(firstName) && customer.getLastname().equalsIgnoreCase(lastName)) {
//        foundCustomers.add(customer);
//      }
//    }
//    return foundCustomers;
//
//  }
//
//
//  public List<Customer> findById(int id) {
//
//    List<Customer> foundCustomers = new ArrayList<>();
//    for (Customer customer : customerRepository.getAll()) {
//      if (customer.getId() == id) {
//        foundCustomers.add(customer);
//      } else {
//        MyLogger.log(Level.INFO, "ID NOT FOUND!");
//      }
//    }
//    return foundCustomers;
//  }
//
//}
//
//
