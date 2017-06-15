package customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 5/26/2017.
 */
public class CustomerDB {

    public List<Customer> customerDBS;

    public CustomerDB() {
        this.customerDBS = new ArrayList();

        customerDBS.add(new Customer(1, "Doe", "John", "john.doe@gmail.com", true, "Pastorului nr 1", "Cluj-Napoca"));
        customerDBS.add(new Customer(2, "Black", "Betty", "b.betty@gmail.com", true, "Campului nr 20", "Cluj-Napoca"));
        customerDBS.add(new Customer(3, "Bishop", "Walter", "w.bishop@gmail.com", true, "Calea Motilor nr13", "Cluj-Napoca"));
        customerDBS.add(new Customer(4, "Ion", "Vasile", "v.ion@yahoo.com", true, "bla bla 10", "oradea"));
    }


    @Override
    public String toString() {
        return " ";
    }

    public Customer searchCustomerByFullName(String firstName, String lastName) {
        Customer customer = null;
        for (Customer customer1 : customerDBS) {
            if (firstName.equalsIgnoreCase(customer1.getCustomer().getFirstname()) &&
                    lastName.equalsIgnoreCase(customer1.getCustomer().getLastname())) {
                customer = customer1;
            }
        }

        return customer;
    }

    public void searchUserById(int id) {
        boolean idFound = false;
        for (Customer customer1 : customerDBS) {
            if (id == customer1.getCustomer().getUserid()) {
                idFound = true;
                System.out.println("User id exists in the databse with the name of " + customer1.getCustomer().getFirstname() + " " + customer1.getCustomer().getLastname());
            }
        }
        if (!idFound) {
            System.out.println("User not found!");
        }
    }

    public void delCustomerById(int id) {
        Customer foundCustomer = null;
        for (Customer customer1 : customerDBS) {
            if (id == customer1.getCustomer().getUserid()) {
                foundCustomer = customer1;
                break;


            }


        }
        if (foundCustomer != null) {
            customerDBS.remove(foundCustomer);
        } else {
            System.out.println("User id not found in database.");
        }
    }

    public void addCustomer(int userId, String firstName, String lastName, String email, boolean passport, String streetAddress, String city) {
        customerDBS.add(new Customer(userId, firstName, lastName, email, passport, streetAddress, city));
    }

    public void showCustomers() {
        System.out.println(String.format(customerDBS.toString()));
    }
}





