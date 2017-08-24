package repository;


import domain.car.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO DECLARE LOGGERS

/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public class CarRepositoryImpl extends AbstractRepository implements CarRepository {

  private static final Logger LOGGER = Logger.getLogger("boo");

  @Override
  public void add(Car car) {
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement("INSERT INTO cars(" +
           "brand," +
           "model," +
           "color," +
           "gearbox," +
           "fuel_type," +
           "engine_type" +
           "vehicle_category" +
           "seats," +
           "doors," +
           "ac," +
           "gps," +
           "id" +
           "reserved" +
           "price" +
           ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
      int index = 1;
      st.setString(index++, car.getBrand());
      st.setString(index++, car.getModel());
      st.setString(index++, car.getColor());
      st.setInt(index++, car.getSeats());
      st.setInt(index++, car.getDoors());
      st.setBoolean(index++, car.isAc());
      st.setBoolean(index++, car.isGps());
      st.setBoolean(index++, car.isReserved());
      st.setString(index++, car.getGearBox().toString());
      st.setString(index++, car.getFuelType().toString());
      st.setString(index++, car.getVehicleCategory().toString());
      st.setString(index++, car.getEngineType().toString());
      st.setDouble(index++, car.getPrice());

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Car car) {
    String updateSQL = "UPDATE Cars Table" + "SET brand=?, model=?,color=?, seats=?, doors=?, ac=?, gps=?, gearbox=?, fueltype=?, " +
      "vehiclecategory=? ,enginetype=?,reserved=?, price=? " +
      "WHERE model = ?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(updateSQL)) {
      int index = 1;
      st.setString(index++, car.getBrand());
      st.setString(index++, car.getModel());
      st.setString(index++, car.getColor());
      st.setInt(index++, car.getSeats());
      st.setInt(index++, car.getDoors());
      st.setBoolean(index++, car.isAc());
      st.setBoolean(index++, car.isGps());
      st.setBoolean(index++, car.isReserved());
      st.setString(index++, car.getGearBox().toString());
      st.setString(index++, car.getFuelType().toString());
      st.setString(index++, car.getVehicleCategory().toString());
      st.setString(index++, car.getEngineType().toString());
      st.setDouble(index++, car.getPrice());
      st.executeUpdate();

    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "update method" + e);
    }
  }

  public List<Car> getAll() {
    List<Car> cars = new ArrayList<>();
    try
      (Connection connection = getDBConnection();
       PreparedStatement st = connection.prepareStatement("SELECT brand,model,color,seats,doors,ac,gps,gearbox,fuel_type,engine_type,vehicle_category,id,reserved,price FROM cars")) {
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setBrand(rs.getString("brand"));
        car.setModel(rs.getString("model"));
        car.setColor(rs.getString("color"));
        car.setSeats(rs.getInt("seats"));
        car.setDoors(rs.getInt("doors"));
        car.setAc(rs.getBoolean("ac"));
        car.setGps(rs.getBoolean("gps"));
        car.setReserved(rs.getBoolean("reserved"));
        car.setFuelType(FuelType.valueOf("fuel_type"));
        car.setGearBox(GearBox.valueOf("gearBox"));
        car.setEngineType(EngineType.valueOf("engine_type"));
        car.setVehicleCategory(VehicleCategory.valueOf("vehicle_category"));
        car.setReserved(rs.getBoolean("reserved"));
        car.setPrice(rs.getDouble("price"));
        cars.add(car);

      }


    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "getAll method");
    }
    return cars;
  }

  @Override
  public void delete(Car car) {

    try
      (Connection connection = getDBConnection();
       PreparedStatement st = connection.prepareStatement("DELETE FROM CARS where brand=?, model = ?")) {
      st.setString(1, car.getBrand());
      st.setString(2, car.getModel());

      st.execute();
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "delete method" + e);
    }
  }

  @Override
  public List getCarsByBrand(String brand) {
    List<Car> cars1 = new ArrayList<>();
    String sql = "Select model,color, FROM cars WHERE brand=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, brand);

      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        Car car = new Car();
        car.setColor(rs.getString("color"));
        car.setModel(rs.getString("model"));
        cars1.add(car);
      }
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "filter by brand method");
    }
    return cars1;
  }

  @Override
  public List getCarsByFuelType(String fuelType) {
    List<Car> cars2 = new ArrayList<>();
    String sql = "Select brand,model, FROM cars WHERE fuel_type=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, fuelType);
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        Car car = new Car();
        car.setBrand(rs.getString("brand"));
        car.setModel(rs.getString("model"));
        cars2.add(car);

      }


    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "by fueltype method");
    }
    return cars2;
  }


}


