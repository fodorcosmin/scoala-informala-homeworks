package domain.car;
/**
 * Created by Fodor Cosmin
 */

import domain.calendar.RentalTime;

import java.util.List;

/**
 * Car Class initialisation
 */
public class Car {

  private int id;
  private Price price;
  private String brand;
  private String model;
  private String color;
  private GearBox gearBox;
  private FuelType fuelType;
  private EngineType engineType;
  private VehicleCategory vehicleCategory;
  private int seats;
  private int doors;
  private boolean ac;
  private boolean gps;
  private List<RentalTime> rentalTimeList;


  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(final Price price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(final String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(final String color) {
    this.color = color;
  }

  public GearBox getGearBox() {
    return gearBox;
  }

  public void setGearBox(final GearBox gearBox) {
    this.gearBox = gearBox;
  }

  public FuelType getFuelType() {
    return fuelType;
  }

  public void setFuelType(final FuelType fuelType) {
    this.fuelType = fuelType;
  }

  public EngineType getEngineType() {
    return engineType;
  }

  public void setEngineType(final EngineType engineType) {
    this.engineType = engineType;
  }

  public VehicleCategory getVehicleCategory() {
    return vehicleCategory;
  }

  public void setVehicleCategory(final VehicleCategory vehicleCategory) {
    this.vehicleCategory = vehicleCategory;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(final int seats) {
    this.seats = seats;
  }

  public int getDoors() {
    return doors;
  }

  public void setDoors(final int doors) {
    this.doors = doors;
  }

  public boolean isAc() {
    return ac;
  }

  public void setAc(final boolean ac) {
    this.ac = ac;
  }

  public boolean isGps() {
    return gps;
  }

  public void setGps(final boolean gps) {
    this.gps = gps;
  }

  public List<RentalTime> getRentalTimeList() {
    return rentalTimeList;
  }

  public void setRentalTimeList(final List<RentalTime> rentalTimeList) {
    this.rentalTimeList = rentalTimeList;
  }
}



