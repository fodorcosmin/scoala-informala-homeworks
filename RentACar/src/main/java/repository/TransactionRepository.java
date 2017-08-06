package repository;


import domain.calendar.Transaction;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepository extends BaseDbRepository implements Repository<Transaction> {
  private static Logger LOG = Logger.getLogger(TransactionRepository.class);

  public TransactionRepository() {
    super();
  }


  @Override
  public void insert(Transaction transaction) {


    String insert = "Adding transaction into repository (id , begin_date , end_date)" + "values (?,?,?)";

    try {
      // set all the preparedstatement parameters
      PreparedStatement st = connection.prepareStatement(insert);
      st.setString(1, String.valueOf(transaction.getId()));
      st.setObject(2, transaction.getBeginDate());
      st.setObject(3, transaction.getEndDate());

      // execute the preparedstatement
      st.execute();
      closeStatement(st);
      connection.close();
    } catch (SQLException e) {
      LOG.info("Blabla");

    }
  }


  @Override
  public void select() throws SQLException {
    String select = "Search a transaction in the DB(id)"
      + " values (?,)";
    PreparedStatement st = connection.prepareStatement(select);
    ResultSet rs = st.executeQuery(select);
    try {


      while (rs.next()) {
        Integer transactionId = Integer.valueOf(rs.getString("id"));


        System.out.println("transaction id" + transactionId);

      }


    } catch (SQLException e) {
      LOG.info("SQL error" + e);
    } finally {
      closeStatement(st);
      connection.close();
    }
  }

  @Override
  public void update() {

  }

  @Override
  public void getAll() {
    try {
      connection.setAutoCommit(false);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      ResultSet rs = null;
      Statement st = connection.createStatement();
      DatabaseMetaData md = connection.getMetaData();
      rs = md.getTables("transactions", null, "%", null);

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
