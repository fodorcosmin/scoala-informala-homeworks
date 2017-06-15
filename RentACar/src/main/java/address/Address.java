package address;

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

    @Override
    public String toString() {
        return "streetAddress=" + streetAddress + "\n" +
                "city=" + city + "\n";
    }
}
