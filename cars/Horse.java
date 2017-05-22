package ro.sci.cars;

import ro.sci.cars.util.FuelType;

/**
 * Created by Cosmin on 5/11/2017.
 */
public abstract class Horse implements Vehicle {
    public void start() {

    }

    public FuelType getFuelType() {
        return FuelType.OVAZ;
    }

    public void stop() {

    }

    public void drive(double km) {

    }


    public void shiftgear(int gear) {

    }

    public double getAvailableFuel() {
        return 0;
    }

    public double getAvgFuelPer100km(double fuel, double km) {
        return 0;
    }


}
