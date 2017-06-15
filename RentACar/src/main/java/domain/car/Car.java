package domain.car;
/**
 * Created by Fodor Cosmin
 */

import domain.calendar.RentalTime;

import java.io.Serializable;
import java.util.List;

/**
 * Car Class initialisation
 */
public class Car implements Serializable {
    List<RentalTime> rentalTimeList;
    private int id;
    private String brand;
    private String model;
    private float size;
    private String color;
    private int seats;
    private int doors;
    private boolean ac = false;
    private boolean gps = false;
    private GearBox gearBox;
    private FuelType fuelType;
    private VehicleCategory vehicleCategory;
    // constructor


    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(int id, List<RentalTime> rentalTimeList) {
        this.rentalTimeList = rentalTimeList;
        this.id = id;
    }

    public Car(int id, String brand, String model, float size, String color, int seats, int doors, boolean ac, boolean gps, GearBox gearBox, FuelType fuelType, VehicleCategory vehicleCategory) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.color = color;
        this.seats = seats;
        this.doors = doors;
        this.ac = ac;
        this.gps = gps;
        this.gearBox = gearBox;
        this.fuelType = fuelType;
        this.vehicleCategory = vehicleCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public List<RentalTime> getRentalTimeList() {
        return rentalTimeList;
    }

    public void setRentalTimeList(List<RentalTime> rentalTimeList) {
        this.rentalTimeList = rentalTimeList;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }


    @Override
    public String toString() {
        return "" + brand + " " + model;
    }

}

