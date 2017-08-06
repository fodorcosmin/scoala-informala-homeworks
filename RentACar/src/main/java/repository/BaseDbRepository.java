package repository;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class BaseDbRepository {

  public static final String URL = "jdbc:postgresql://localhost:5432/rentalproject";
  public static final String USER = "postgres";
  public static final String PASS = "cosmin1";
  public static final String DB_DRIVER = "org.postgresql.Driver";
  private static Logger LOG = Logger.getLogger(BaseDbRepository.class);
  protected Connection connection;

  public BaseDbRepository() {


    try {
      Class.forName(DB_DRIVER);
      LOG.info("Driver loaded..");
    } catch (ClassNotFoundException e1) {
      LOG.info(e1 + "Driver  not loaded..");
      try {
        connection = DriverManager.getConnection(URL, USER, PASS);
        LOG.info("Connected to database");
      } catch (SQLException e) {
        LOG.info("Failed to connect to DB");
      }

    }
  }

  protected void closeStatement(Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        LOG.info("Close statement");
      }
    }
  }
//  private static void loadDriver () {
//    try {
//      Class.forName(DB_DRIVER);
//      LOG.info("Driver loaded..");
//    } catch (ClassNotFoundException e1) {
//      LOG.info(e1 + "Driver  not loaded..");
//    }

}

