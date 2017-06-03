package domain;
/**
 * Created by Fodor Cosmin
 */

import util.FuelType;
import util.VehicleCategory;

import java.util.List;


/**
 * Car Class initialisation
 */
public class Car {
    private int carid;
    private String brand;
    private String model;
    private float size;
    private String color;
    private int seats;
    private int doors;
    private boolean ac = false;
    private boolean gps = false;
    private boolean gearbox = false; //TRUE automatic, FALSE manual
    private FuelType fuelType;
    private VehicleCategory vehicleCategory;
    private List<RentalTime> rentalTimeList;
    private int priceperday;

    // constructor


    public Car(int carid, String brand, String model, float size, String color, int seats, int doors, boolean ac, boolean gps, boolean gearbox, FuelType fuelType, VehicleCategory vehicleCategory, List<RentalTime> rentalTimeList, int priceperday) {
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.color = color;
        this.seats = seats;
        this.doors = doors;
        this.ac = ac;
        this.gps = gps;
        this.gearbox = gearbox;
        this.fuelType = fuelType;
        this.vehicleCategory = vehicleCategory;
        this.rentalTimeList = rentalTimeList;
        this.priceperday = priceperday;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String make) {
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

    public boolean isGearbox() {
        return gearbox;
    }

    public void setGearbox(boolean gearbox) {
        this.gearbox = gearbox;
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

    public List<RentalTime> getRentalTimeList() {
        return rentalTimeList;
    }


    public int getPriceperday() {
        return priceperday;
    }

    public void setPriceperday(int priceperday) {
        this.priceperday = priceperday;
    }

    @Override
    public String toString() {
        return "" + brand + " " + model;
    }
    public void setRentalTimeList(List<RentalTime> rentalTimeList) {
        this.rentalTimeList = rentalTimeList;
    }
}

