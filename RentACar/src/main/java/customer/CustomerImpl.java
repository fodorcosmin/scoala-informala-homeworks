package customer;

/**
 * Created by Cosmin on 5/21/2017.
 */
public class CustomerImpl {

    /**
     * @param // FIXME: 6/3/2017    ID of the user
     * @param // FIXME: 6/3/2017  First name of the user
     * @param // FIXME: 6/3/2017   Last name of the user
     * @param // FIXME: 6/3/2017      CustomerImpl email
     * @param // FIXME: 6/3/2017   CustomerImpl Passport
     */


    private int userid  ;
    private String firstname;
    private String lastname;
    private String email;
    private boolean passport = false;

    public CustomerImpl(int userid, String firstname, String lastname, String email, boolean passport) {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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







    @Override
    public String toString() {
        return  "UserId=" + userid + "\n" +
                "FirstName = " + firstname + "\n" +
                "LastName = " + lastname + "\n" +
                "Email = " + email + "\n" +
                "Passport=" + passport +"\n";
    }
}



