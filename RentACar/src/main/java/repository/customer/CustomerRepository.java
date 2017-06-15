package repository.customer;

import domain.customer.Customer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Cosmin on 5/26/2017.
 */
public interface CustomerRepository {

    void getAll() throws IOException, ClassNotFoundException;

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
    void add(Customer customer) throws IOException;

    /**
     * Delete a customer from the system.
     */
    void delete(Customer customer);

    /**
     * Update a customer details.
     */
    void update(Customer customer);

    /**
     * @param customers
     * @return saves the list into the txt file
     * @throws IOException
     */
    void saveCustomerToFile(Customer customer) throws IOException;

    /**
     * @param customers
     * @return reads data from a  txt file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    List<Customer> readAllCustomers() throws IOException, ClassNotFoundException;


}

