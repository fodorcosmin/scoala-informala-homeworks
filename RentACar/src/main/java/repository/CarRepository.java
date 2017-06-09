package repository;


import domain.car.Car;

import java.util.List;

/**
 * Created by Fodor Cosmin on 5/25/2017.
 */

/**
 * Repository interface for the class car
 */
public interface CarRepository {
    /**
     * Get all cars in the system
     *
     * @return List<Cars>
     */
    List<Car> getAll();

    /**
     * Adds all cars in the system
     *
     * @param carList
     */
    void addAll(List<Car> carList);

    void add(Car car);

    /**
     * delete a car from the system
     *
     * @param car
     */
    void delete(Car car);

    /**
     * Updates the current status of cars in the system.
     *
     * @param car
     */
    void updateCars(Car car);
    /**
     * Updates car information in the system
     * @param car
     */


}
