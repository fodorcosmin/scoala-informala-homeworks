package customer;

/**
 * Created by Cosmin on 5/21/2017.
 */
public class CustomerImpl {


    private int UserId;
    private String FirstName;
    private String LastName;
    private String email;
    private boolean passport = false;

    /**
     * @param userId    ID of the user
     * @param firstName First name of the user
     * @param lastName  Last name of the user
     * @param email     CustomerImpl email
     * @param passport  CustomerImpl Passport
     */


    public CustomerImpl(int userId, String firstName, String lastName, String email, boolean passport) {
        UserId = userId;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.passport = passport;
    }


    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
        return  "UserId=" + UserId + "\n" +
                "FirstName = " + FirstName + "\n" +
                "LastName = " + LastName + "\n" +
                "Email = " + email + "\n" +
                "Passport=" + passport +"\n";
    }
}



