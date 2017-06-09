package services;

import domain.car.Car;
import domain.car.FuelType;

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

    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Car> findAvailableCars(Date beginDate, Date endDate);
}

