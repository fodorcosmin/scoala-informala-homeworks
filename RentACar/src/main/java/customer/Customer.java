package customer;

import address.Address;
import domain.Car;

/**
 * Created by Cosmin on 5/26/2017.
 */
public class Customer {
    private CustomerImpl customer;
    private Address address;
    private Car car;

    public Customer(Address address, Car car) {
        this.address = address;
        this.car = car;
    }

    public Customer(int userid, String firstname, String lastname, String email, boolean passport, String streetAddress, String city) {
        this.customer = new CustomerImpl(userid, firstname, lastname, email, passport);
        this.address = new Address(streetAddress, city);

    }

    public CustomerImpl getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerImpl customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "\n Firstname\n "  + customer.getFirstname() + " \nLastname : \n" + customer.getLastname() +
                " \nemail\n " + customer.getEmail();
    }
}

