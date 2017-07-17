package domain.customer;


import java.io.Serializable;

/**
 * Created by Cosmin on 5/21/2017.
 */
public class Customer implements Serializable {


  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private boolean passport = false;
  private String telephone;
  private Address address;
  private PaymentMethod paymentMethod;


  public Customer() {
  }

  public Customer(int id, String firstName, String lastName, String email, boolean passport, String telephone, String streetAddress, String city) {
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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


  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public String toString() {
    return "" + firstname + "" + lastname + "" + email + "" + telephone;
  }
}



