package repository;

import domain.Car;
import domain.RentalCalendar;
import domain.RentalTime;

import java.util.ArrayList;
import java.util.List;

import static util.FuelType.DIESEL;
import static util.FuelType.GAS;
import static util.VehicleCategory.*;

/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public class CarRepo {


    public List<Car> carList;
    public List<RentalTime> rentalTimeList;

    public CarRepo() {

        this.rentalTimeList = new RentalCalendar().rentalTimeList;
        this.carList = new ArrayList<Car>();

        carList.add(new Car(001, "Mercedes", "S500", 3.0f, "black", 5, 4, true, true, true, DIESEL, LIMOUSINE, rentalTimeList, 400));
        carList.add(new Car(002, "Volkswagen", "Passat", 2.0f, "blue", 5, 4, true, true, true, DIESEL, SEDAN, rentalTimeList, 200));
        carList.add(new Car(003, "Opel", "Astra", 1.7f, "red", 5, 4, true, true, true, GAS, HATCHBACK, rentalTimeList, 150));
        carList.add(new Car(004, "Mitsubishi", "Outlander", 2.0f, "white", 5, 4, true, false, true, GAS, SEDAN, rentalTimeList, 250));


    }

    @Override
    public String toString() {
        return "";
    }
}


//TODO Implement HASHMAP