package repository;


import domain.car.Car;

import java.sql.*;


/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public class CarRepository extends BaseDbRepository implements Repository<Car> {


  public CarRepository() {
    super();
  }


  @Override
  public void insert(Car car) throws SQLException {
    String insert = "Adding a car in DB (id, price, brand, model, color, gearbox, fueltype, enginetype, vehiclecategory, seats, doors, ac, gps, rentaltime)"
      + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try {
      // set all the preparedstatement parameters
      PreparedStatement st = connection.prepareStatement(insert);
      st.setString(1, String.valueOf(car.getId()));
      st.setString(2, String.valueOf(car.getPrice()));
      st.setString(3, car.getBrand());
      st.setString(4, car.getModel());
      st.setString(5, car.getColor());
      st.setString(6, String.valueOf(car.getGearBox()));
      st.setString(7, String.valueOf(car.getFuelType()));
      st.setString(8, String.valueOf(car.getEngineType()));
      st.setString(9, String.valueOf(car.getVehicleCategory()));
      st.setString(10, String.valueOf(car.getSeats()));
      st.setString(11, String.valueOf(car.getDoors()));
      st.setString(12, String.valueOf(car.isAc()));
      st.setString(13, String.valueOf(car.isGps()));
      st.setString(14, String.valueOf(car.getRentalTimeList()));
// execute the preparedstatement
      st.execute();
      closeStatement(st);
      connection.close();
    } catch (Exception e) {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }


  @Override
  public void select() throws SQLException {

    String select = "Search a car in the DB(id,brand, model)"
      + " values (?,?,?)";
    PreparedStatement st = connection.prepareStatement(select);
    ResultSet rs = st.executeQuery(select);
    try {


      while (rs.next()) {
        Integer carId = Integer.valueOf(rs.getString("id"));
        String brand = rs.getString("brand");
        String model = rs.getString("model");

        System.out.println("carId" + carId);
        System.out.println("brand" + brand);
        System.out.println("model" + model);

      }


    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      closeStatement(st);
      connection.close();
    }
  }

  @Override
  public void update() {

  }


  public void getAll() {
    try {
      connection.setAutoCommit(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      ResultSet rs;
      Statement st = connection.createStatement();
      DatabaseMetaData md = connection.getMetaData();
      rs = md.getTables("cars", null, "%", null);

      while (rs.next()) {
        System.out.println(rs.getString(3));
      }


    } catch (SQLException ex) {

      ex.printStackTrace();

    }

  }


  @Override
  public void delete() {

  }

}



