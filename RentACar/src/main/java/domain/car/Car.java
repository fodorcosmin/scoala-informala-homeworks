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
  private int id;
  private String brand;
  private String model;
  private Engine engineType;
  private String color;
  private int seats;
  private int doors;
  private boolean ac = false;
  private boolean gps = false;
  private GearBox gearBox;
  private FuelType fuelType;
  private VehicleCategory vehicleCategory;
  private Price rentPrice;
  private List<RentalTime> rentalTimeList;

  public Car(int id) {

  }

  public Car(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public Car(int id, String brand, String model, Engine engineType, String color, int seats, int doors, boolean ac, boolean gps, GearBox gearBox, FuelType fuelType, VehicleCategory vehicleCategory) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.engineType = engineType;
    this.color = color;
    this.seats = seats;
    this.doors = doors;
    this.ac = ac;
    this.gps = gps;
    this.gearBox = gearBox;
    this.fuelType = fuelType;
    this.vehicleCategory = vehicleCategory;
    this.rentPrice = rentPrice;
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

  public Engine getEngineType() {
    return engineType;
  }

  public void setEngineType(Engine engineType) {
    this.engineType = engineType;
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

  public Price getRentPrice() {
    return rentPrice;
  }

  public void setRentPrice(Price rentPrice) {
    this.rentPrice = rentPrice;
  }

  @Override
  public String toString() {
    return "Car{" +
      "id=" + id +
      ", brand='" + brand + '\'' +
      ", model='" + model + '\'' +
      ", engineType=" + engineType +
      ", color='" + color + '\'' +
      ", seats=" + seats +
      ", doors=" + doors +
      ", ac=" + ac +
      ", gps=" + gps +
      ", gearBox=" + gearBox +
      ", fuelType=" + fuelType +
      ", vehicleCategory=" + vehicleCategory;

  }

  public List<RentalTime> getRentalTimeList() {
    return rentalTimeList;
  }

  public void setRentalTimeList(List<RentalTime> rentalTimeList) {
    this.rentalTimeList = rentalTimeList;
  }
}

