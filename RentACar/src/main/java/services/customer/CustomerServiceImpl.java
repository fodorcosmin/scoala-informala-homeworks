package services.customer;

import domain.customer.Customer;
import repository.customer.CustomerRepositoryImpl;

import java.util.List;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepositoryImpl customerRepository;
    private List<Customer> customers = new CustomerRepositoryImpl().getCustomers();

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findCustomerById(int id) {
        if (customers.get(id).equals(id)) {
            return customerRepository.getCustomerById(id);
        }
        //TODO PROBLEMS
        return null;
    }


    public List<Customer> findCustomerByFullName(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("Error!");
            return null;
        }
        return customerRepository.getCustomerByFullName(firstName, lastName);
    }


    //TODO can implement more searches by parameters


}
