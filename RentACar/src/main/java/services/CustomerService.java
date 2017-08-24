package services;

import domain.customer.Customer;
import repository.Repository;

import java.util.List;

public interface CustomerService extends Repository<Customer> {

  List<Customer> findCustomerByFullName(String firstName, String lastName);

  /**
   * @param id
   * @return
   */
  List<Customer> findCustomerById(int id);

  /**
   * @param firstName
   * @return
   */
  List<Customer> findCustomerByFirstName(String firstName);

  /**
   * @return
   */
  List<Customer> getAll();
}
