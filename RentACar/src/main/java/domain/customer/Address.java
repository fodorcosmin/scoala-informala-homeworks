package domain.customer;

/**
 * Created by Cosmin on 5/26/2017.
 */
public class Address {

  private String streetAddress;
  private String city;


  public Address(String streetAddress, String city) {
    this.streetAddress = streetAddress;
    this.city = city;

  }

  public Address() {
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "streetAddress=" + streetAddress + "\n" +
      "city=" + city + "\n";
  }
}
