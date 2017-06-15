package carservice;

import domain.Car;
import domain.RentalTime;
import util.FuelType;
import util.VehicleCategory;

import java.util.Date;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public interface CarService {
    /**
     * Search filter by brand
     *
     * @param brand
     */
    List<Car> findCarsByBrand(String brand);

    /**
     * Search filter for both brand and model
     *
     * @param brand
     * @param model
     */
    List<Car> findCarsByBrandAndModel(String brand, String model);

    /**
     * Search filter for the paramters given below
     *
     * @param fuelType
     * @param gps
     * @param seats
     */
    List<Car> findCarsByMultipleCategories(FuelType fuelType, boolean gps, int seats);

    List<Car> findAvailableCars(Date beginDate, Date endDate);

    /**
     * Adds the cars into the system
     *
     * @param
     */
    void addCar(int carid, String brand, String model, float size, String color, int doors, int seats, boolean ac, boolean gps, boolean gearbox, FuelType fuelType,
                VehicleCategory vehicleCategory, List<RentalTime> rentalTimeList, int priceperday);

    /**
     * delete a car from the system
     */
    void del(String brand, String model);

    /**
     * updates the current status of cars in the system.
     */
    void update();


    /**
     * @param brand return the price
     * @param model return the price
     * @return
     */
    List<Car> priceForCars(String brand, String model);
}

