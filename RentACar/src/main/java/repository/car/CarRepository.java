package repository.car;


import domain.car.Car;

import java.io.IOException;
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
    void getAll() throws IOException, ClassNotFoundException;

    /**
     * Adds all cars in the system
     *
     * @param carList
     */
    void addAll(List<Car> carList);

    void add(Car car) throws IOException;

    /**
     * delete a car from the system
     *
     * @param car
     */
    void delete(Car car);

    /**
     * Saves a entry into a file
     */
    void saveCarToFile(Car car) throws IOException;

    /**
     * @param filename
     * @param cars
     * @return saves a car in a given file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    List readAllCars() throws IOException, ClassNotFoundException;

    /**
     * Updates the current status of cars in the system.
     *
     * @param car
     */
    void updateCars(Car car);


}
