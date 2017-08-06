package domain.customer;


/**
 * Created by Cosmin on 5/21/2017.
 */
public class Customer {


  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private boolean passport = false;
  private String telephone;
  private Address address;
  private PaymentMethod paymentMethod;

  private Customer(final Builder builder) {
    id = builder.id;
    firstname = builder.firstname;
    lastname = builder.lastname;
    email = builder.email;
    passport = builder.passport;
    telephone = builder.telephone;
    address = builder.address;
    paymentMethod = builder.paymentMethod;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public boolean isPassport() {
    return passport;
  }

  public String getTelephone() {
    return telephone;
  }

  public Address getAddress() {
    return address;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public static final class Builder {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private boolean passport;
    private String telephone;
    private Address address;
    private PaymentMethod paymentMethod;

    public Builder() {
    }

    public Builder withId(final int val) {
      id = val;
      return this;
    }

    public Builder withFirstname(final String val) {
      firstname = val;
      return this;
    }

    public Builder withLastname(final String val) {
      lastname = val;
      return this;
    }

    public Builder withEmail(final String val) {
      email = val;
      return this;
    }

    public Builder withPassport(final boolean val) {
      passport = val;
      return this;
    }

    public Builder withTelephone(final String val) {
      telephone = val;
      return this;
    }

    public Builder withAddress(final Address val) {
      address = val;
      return this;
    }

    public Builder withPaymentMethod(final PaymentMethod val) {
      paymentMethod = val;
      return this;
    }

    public Customer build() {
      return new Customer(this);
    }
  }
}



