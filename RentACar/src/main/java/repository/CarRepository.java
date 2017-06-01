package repository;



import domain.Car;
import util.FuelType;

import java.util.List;

/**
 * Created by Fodor Cosmin on 5/25/2017.
 */

/**
 * Repository interface for the class car
 */
public interface CarRepository {

    /**
     * Returns all the cars by value
     *
     * @param brand
     * @return
     */
    List<Car> getCarsByBrand(String brand);

    /**
     * return all the cars by model
     *
     * @param model
     * @return
     */
    List<Car> getCarsByModel(String model);

    /**
     * returns all the cars by fueltype
     *
     * @param fuelType
     * @return
     */
    List<Car> getCarsByFuelType(FuelType fuelType);

    /**
     * add a cars in the system
     *
     * @param car
     */

    void add(Car car);

    /**
     * delete a car from the system
     *
     * @param car
     */
    void delete(Car car);

    /**
     * updates the current status of cars in the system.
     *
     * @param car
     */
    void update(Car car);
    /**
     * Display all cars available
     * @param car
     */









}
