package ro.sci.cars;

import ro.sci.cars.util.FuelType;

/**
 * Created by Cosmin on 5/11/2017.
 */
public class Car implements Vehicle {

    private int fuelTankSize;
    private int gears;
    private double availableFuel;
    private double factoryAvgConsumptionPer100km;
    private double driveAvgConsumptionPer100km;
    private int currentGear;
    private FuelType fuelType;


    public Car(double fuel, FuelType fuelType, int fuelTankSize, int gears, double avgConsumption) {
        this.availableFuel = fuel;
        this.fuelType = fuelType;
        this.fuelTankSize = fuelTankSize;
        this.gears = gears;
        this.factoryAvgConsumptionPer100km = avgConsumption;
    }


    public void start() {
        System.out.println("start");
    }


    public void stop() {
        System.out.println("stop");
    }

    public void drive(double km) {
        System.out.println("drive" + km);
        double fuel1 = 0;
        switch (currentGear) {
            case 1:
                fuel1 = calculateFuel(km) * 2.0;
                break;
            case 2:
                fuel1 = calculateFuel(km) * 1.8;
                break;
            case 3:
                fuel1 = calculateFuel(km) * 1.6;
                break;
            case 4:
                fuel1 = calculateFuel(km) * 1.4;
            break;
            case 5:
                fuel1 = calculateFuel(km) * 1.2;
                break;
        }

        driveAvgConsumptionPer100km = getDriveAvgConsumptionPer100km(fuel1, km);
        availableFuel = availableFuel - fuel1;

    }


    public void shiftgear(int gear) {
        System.out.println("shiftgear" + gear);
        currentGear = gear;

    }

    public double calculateFuel(double km) {
        return (factoryAvgConsumptionPer100km * km) / 100;
    }

    public double getAvailableFuel() {
        return this.availableFuel;
    }

    public double getAvgFuelPer100km(double fuel, double km) {
        return fuel * km / 100;
    }

    public double getDriveAvgConsumptionPer100km(double fuel, double km) {
        return fuel * km / 100;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }
}
