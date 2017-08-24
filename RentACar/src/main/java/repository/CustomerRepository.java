package repository;

import domain.customer.Customer;

import java.util.List;

public interface CustomerRepository extends Repository<Customer> {
  /**
   * Get all Customers in the system.
   *
   * @return List<Customer>
   */
  List<Customer> getAll();

  /**
   * Get Customers by LastName.
   *
   * @return List<Customer>
   */
  List<Customer> getCustomerByLastName(String lastName);

  /**
   * Get Customers by Full Name.
   *
   * @return List<Customer>
   */
  List<Customer> getCustomerByFullName(String firstName, String lastName);

  /**
   * Get Customers by Telephone number.
   *
   * @return List<Customer>
   */
  List<Customer> getCustomerByTelephone(String telephone);

  /**
   * Add a customer in the system.
   */
  void add(Customer customer);

  /**
   * Delete a customer from the system.
   */
  void delete(Customer customer);

  /**
   * Update a customer details.
   */
  void update(Customer customer);
}

