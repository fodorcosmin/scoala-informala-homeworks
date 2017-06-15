package domain.customer;


import java.io.Serializable;

/**
 * Created by Cosmin on 5/21/2017.
 */
public class Customer implements Serializable {

    /**
     * @param // FIXME: 6/3/2017    ID of the user
     * @param // FIXME: 6/3/2017  First name of the user
     * @param // FIXME: 6/3/2017   Last name of the user
     * @param // FIXME: 6/3/2017      CustomerServiceImpl email
     * @param // FIXME: 6/3/2017   CustomerServiceImpl Passport
     */


    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private boolean passport = false;
    private String telephone;
    private Address address;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, boolean passport, String telephone, String streetAddress, String city) {
    }

    public int getUserid() {
        return id;
    }

    public void setUserid(int userid) {
        this.id = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPassport() {
        return passport;
    }

    public void setPassport(boolean passport) {
        this.passport = passport;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "" + firstname + "" + lastname + "" + email + "" + telephone;
    }
}



