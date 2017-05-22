package ro.sci.cars;

import ro.sci.cars.util.FuelType;

/**
 * Created by Cosmin on 5/11/2017.
 */


public interface Vehicle {
    /**
     * Start a vehicle
     */
    void start();

    /**
     * Stop a vehicle
     */
    void stop();

    /**
     * @param km the number of km to drive
     */
    void drive(double km);

    /**
     * Shift the car gear with specified number
     *
     * @param gear to shift in
     */
    void shiftgear(int gear);

    /**
     * finds the available fuel level in the car tank
     *
     * @return the remaining fuel in the car tank
     */
    double getAvailableFuel();

    /**
     * get the average consumption per 100km
     *
     * @return double value representing the avg consumption per 100km
     */
    double getAvgFuelPer100km(double fuel, double km);

    /**
     * /**
     * get the drive consumption per 100km
     *
     * @return double value representing the drive consumption per 100km
     */


    double getDriveAvgConsumptionPer100km(double fuel, double km);

    /**
     * gets the fuel type of the current vehicle
     *
     * @return FuelType of the current vehicle
     */
    FuelType getFuelType();


}
