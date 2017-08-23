package repository;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class AbstractRepository {


  public static final String URL = "jdbc:postgresql://localhost:5432/rentalproject";
  public static final String USER = "postgres";
  public static final String PASS = "cosmin1";
  private static final Logger LOGGER = Logger.getLogger("boo");
  private DatabaseMetaData metaData = null;


  public AbstractRepository() {

  }

  Connection getDBConnection() {
    Connection dbConnection = null;
    loadDriver();
    try {
      dbConnection = DriverManager.getConnection(URL, USER, PASS);
      return dbConnection;
    } catch (SQLException e) {
      LOGGER.log(Level.INFO, "Failed to connect to DB");
    }
    return dbConnection;
  }

  void loadDriver() {
    try {
      Class.forName("org.postgresql.Driver").newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      LOGGER.log(Level.INFO, "Can’t load driver. Verify CLASSPATH");
    }
  }

  void printMetadata() {
    try {
      System.out.println("DB used :" + metaData.getDatabaseProductName());
      System.out.println("DB version :" + metaData.getDatabaseProductVersion());
      System.out.println("JDBC Driver :" + metaData.getDriverName());
      System.out.println("Driver Version :" + metaData.getDriverVersion());
      System.out.println("\n");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}


