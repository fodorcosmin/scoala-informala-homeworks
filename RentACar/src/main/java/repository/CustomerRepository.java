package repository;

import domain.customer.Customer;

import java.util.List;

/**
 * Created by Cosmin on 5/26/2017.
 */
public interface CustomerRepository {

    List<Customer> getAll();

    /**
     * Get Customers by LastName.
     *
     * @return List<Customer>
     */


    void addAll(List<Customer> customers);


    /**
     * Adds a customer in the system
     *
     * @param customer
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

