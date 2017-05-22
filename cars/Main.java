package ro.sci.cars;

import ro.sci.cars.util.FuelType;


public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car(5, FuelType.DIESEL, 60, 5, 4.5);
        System.out.println("Simulating a car drive");
        simulateDriving(car);


        /**
         *  Vehicle Horse = new Horse();

         System.out.println("Simulating a horse ride:");

         */

    }

    private static void simulateDriving(Vehicle vehicle) {

        vehicle.start();        // 12.310 km
        vehicle.shiftgear(1);
        vehicle.drive(0.01);
        vehicle.shiftgear(2);
        vehicle.drive(0.1);
        vehicle.shiftgear(3);
        vehicle.drive(0.2);
        vehicle.shiftgear(4);
        vehicle.drive(0.5);
        vehicle.shiftgear(5);
        vehicle.drive(11.5);
        vehicle.shiftgear(1);
        vehicle.stop();
        double availableFuel = vehicle.getAvailableFuel();
        System.out.println("available fuel" + availableFuel);


        double avgFuelPer100km = vehicle.getDriveAvgConsumptionPer100km(5, 12.310);
        System.out.println("average fuel is" + avgFuelPer100km);
    }


}
