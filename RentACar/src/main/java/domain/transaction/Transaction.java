package domain.transaction;

import domain.calendar.RentalTime;
import domain.car.Car;
import domain.customer.Customer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cosmin on 6/14/2017.
 */
public class Transaction implements Serializable {

    private int id;
    private List<RentalTime> rentalTimeList;
    private List<Customer> customerList;
    private List<Car> carList;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RentalTime> getRentalTimeList() {
        return rentalTimeList;
    }

    public void setRentalTimeList(List<RentalTime> rentalTimeList) {
        this.rentalTimeList = rentalTimeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
