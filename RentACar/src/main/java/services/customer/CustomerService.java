package services.customer;

import domain.customer.Customer;

import java.util.List;

/**
 * Created by Cosmin on 6/13/2017.
 */
public interface CustomerService {

    /**
     * Searching customer for give parameters
     *
     * @param firstName
     * @param LastName
     */
    List<Customer> findCustomerByFullName(String firstName, String LastName);

    /**
     * Search customer by given parameters
     *
     * @param id
     */
    List<Customer> findCustomerById(int id);

}
