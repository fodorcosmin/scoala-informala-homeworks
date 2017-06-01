package customer;

/**
 * Created by Cosmin on 5/26/2017.
 */
public interface CustomerInt {
    /**
     * searches user by id
     */
    void searchUserById(int i);

    /**
     * Searching user by Full Name
     */
    Customer searchCustomerByFullName(String FirstName,String LastName );

    /**
     *
     * @param firstName
     * @param lastName
     */
    void addCustomer(String firstName, String lastName, String email, boolean passport, String streetAddress, String city);

}
