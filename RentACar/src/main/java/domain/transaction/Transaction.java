package domain.transaction;

import domain.calendar.RentalCalendar;
import domain.calendar.RentalTime;
import domain.car.Car;
import domain.customer.Customer;
import repository.car.CarRepositoryImpl;
import repository.customer.CustomerRepositoryImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Cosmin on 6/14/2017.
 */
public class Transaction implements Serializable {
    private int id;
    private RentalTime rentalTime;
    private Customer customer;
    private Car car;
    private Date createDate = new Date();

    public Transaction() {


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RentalTime getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(RentalTime rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
