package domain.car;

/**
 * Created by Fodor Cosmin
 */


public class Car {

  private int id;
  private String brand;
  private String model;
  private String color;
  private int seats;
  private int doors;
  private boolean ac;
  private boolean gps;
  private boolean reserved = false;
  private GearBox gearBox;
  private FuelType fuelType;
  private EngineType engineType;
  private VehicleCategory vehicleCategory;
  private double price;


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

  public boolean isReserved() {
    return reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
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

  public EngineType getEngineType() {
    return engineType;
  }

  public void setEngineType(EngineType engineType) {
    this.engineType = engineType;
  }

  public VehicleCategory getVehicleCategory() {
    return vehicleCategory;
  }

  public void setVehicleCategory(VehicleCategory vehicleCategory) {
    this.vehicleCategory = vehicleCategory;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
