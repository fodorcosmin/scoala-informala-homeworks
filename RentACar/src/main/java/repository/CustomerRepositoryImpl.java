package repository;

import domain.customer.Address;
import domain.customer.Customer;
import domain.customer.PaymentMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class CustomerRepositoryImpl extends AbstractRepository implements CustomerRepository {


  private static final Logger LOGGER = Logger.getLogger("bobobo");

  @Override
  public void add(Customer customer) {
    String insertQuery = "INSERT into customers id,first_name,last_name,email,telephone,passport,paymentmethod,street_address,city" +
      "values(?,?,?,?,?,?,?,?,?)";
    try
      (Connection connection = getDBConnection();
       PreparedStatement st = connection.prepareStatement(insertQuery)) {
      st.setInt(1, customer.getId());
      st.setString(2, customer.getFirstname());
      st.setString(3, customer.getLastname());
      st.setString(4, customer.getEmail());
      st.setString(5, customer.getTelephone());
      st.setBoolean(6, customer.isPassport());
      st.setString(7, customer.getAddress().getStreetAddress());
      st.setString(8, customer.getAddress().getCity());
      st.setString(9, customer.getPaymentMethod().toString());
      st.execute();
      connection.commit();
      connection.setAutoCommit(true);

    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "add customer method");
    }
  }


  @Override
  public List<Customer> getCustomerByLastName(String lastName) {
    List<Customer> filterByLastName = new ArrayList<>();
    String sql = "SELECT * from customers WHERE first_name=?,last_name=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {

      st.setString(2, "last_name");


      ResultSet rs = st.executeQuery();


      while (rs.next()) {
        Customer customer = new Customer();
        customer.setFirstname(rs.getString("first_name"));
        customer.setLastname(rs.getString("last_name"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setEmail(rs.getString("email"));
        customer.setAddress(new Address(rs.getString("street_address"), rs.getString("city")));
      }
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "filtered customers");
    }
    return filterByLastName;
  } //DB LOGIC

  @Override
  public List<Customer> getCustomerByFullName(String firstName, String lastName) {
    List<Customer> filterByFullName = new ArrayList<>();
    String sql = "SELECT * from customers WHERE first_name=?,last_name=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, "first_name");
      st.setString(2, "last_name");


      ResultSet rs = st.executeQuery();


      while (rs.next()) {
        Customer customer = new Customer();
        customer.setFirstname(rs.getString("first_name"));
        customer.setLastname(rs.getString("last_name"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setEmail(rs.getString("email"));
        customer.setAddress(new Address(rs.getString("street_address"), rs.getString("city")));
      }
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "filtered customers");
    }
    return filterByFullName;
  }

  @Override
  public List<Customer> getCustomerByTelephone(String telephone) {

    List<Customer> filterByTelephone = new ArrayList<>();
    String sql = "SELECT first_name,last_name from customers WHERE telephone=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, telephone);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        Customer customer = new Customer();
        customer.setFirstname(rs.getString("first_name"));
        customer.setFirstname(rs.getString("last_name"));

      }
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "filtered customers");
    }
    return filterByTelephone;
  }

  @Override
  public void update(Customer customer) {
    String updateQuery = "UPDATE customers" + "SET ,firstname=?,lastname=?,email=?,telephone=?,passport=?,,paymentmethod=?,street_address=?,city=?"
      + "WHERE telephone=?";
    try
      (Connection connection = getDBConnection();
       PreparedStatement st = connection.prepareStatement(updateQuery)) {
      st.setInt(1, customer.getId());
      st.setString(2, customer.getFirstname());
      st.setString(3, customer.getLastname());
      st.setString(4, customer.getEmail());
      st.setString(5, customer.getTelephone());
      st.setBoolean(6, customer.isPassport());
      st.setString(7, customer.getAddress().toString());
      st.setString(8, customer.getPaymentMethod().toString());

      st.execute();

    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "update customers method");

    }
  } //TODO UPDATE BY EMAIL

  @Override
  public void delete(Customer customer) {
    String deleteQuery = "DELETE from customers WHERE firstname=?,lastname=?";
    try
      (Connection connection = getDBConnection();
       PreparedStatement st = connection.prepareStatement(deleteQuery)) {
      st.setString(1, customer.getFirstname());
      st.setString(2, customer.getLastname());

    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "delete customer method");
    }
  }

  @Override
  public List<Customer> getAll() {
    String getQuery = "SELECT id,first_name,last_name,email,telephone,passport,street_address,city FROM customers";
    List<Customer> customers = new ArrayList<>();
    try
      (Connection connection = getDBConnection();
       Statement st = connection.createStatement()) {
      ResultSet rs = st.executeQuery(getQuery);

      // Set all the preparedstatement parameters

      while (rs.next()) {

        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));
        customer.setEmail(rs.getString("email"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setPassport(rs.getBoolean("passport"));
        customer.setAddress(new Address(rs.getString("streetAddress"), rs.getString("city")));
        customer.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod")));

        customers.add(customer);

      }

    } catch (Exception e) {
      LOGGER.log(Level.FINE, "getAll customers");
    }
    return customers;
  }
}
