package services;

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
    List<Customer> searchCustomerByFullName(String firstName, String LastName);

    /**
     * Search customer by given parameters
     *
     * @param id
     */
    void searchCustomerById(int id);

}
