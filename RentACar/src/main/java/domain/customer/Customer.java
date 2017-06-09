package domain.customer;


/**
 * Created by Cosmin on 5/21/2017.
 */
public class Customer {

    /**
     * @param // FIXME: 6/3/2017    ID of the user
     * @param // FIXME: 6/3/2017  First name of the user
     * @param // FIXME: 6/3/2017   Last name of the user
     * @param // FIXME: 6/3/2017      CustomerServiceImpl email
     * @param // FIXME: 6/3/2017   CustomerServiceImpl Passport
     */

    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private boolean passport = false;
    private Address address;


    public Customer(int userId, String firstName, String lastName, String email, boolean passport, String streetAddress, String city) {
        this.userId = this.userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = this.email;
        this.passport = this.passport;
        this.address = address;
    }

    public int getUserid() {
        return userId;
    }

    public void setUserid(int userid) {
        this.userId = userid;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nFirst name='" + firstname + ", Last name='" + lastname + ", Email='" + email;
    }

    //    @Override
//    public String toString() {
//        return "UserId=" + userid + "\n" +
//                "FirstName = " + firstname + "\n" +
//                "LastName = " + lastname + "\n" +
//                "Email = " + email + "\n" +
//                "Passport=" + passport + "\n";
//    }
}



