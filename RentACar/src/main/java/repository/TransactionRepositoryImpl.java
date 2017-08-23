package repository;


import domain.calendar.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepositoryImpl extends AbstractRepository implements TransactionRepository {
  private static final Logger LOGGER = Logger.getLogger("BLABLA");


  @Override
  public void add(Transaction transaction) {
    String insertSQL = "INSERT into transactions(id,beginDate,endDate)" + "values(?,?,?)";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(insertSQL)) {
      st.setInt(1, transaction.getId());
      st.setDate(2, transaction.getBeginDate());
      st.setDate(2, transaction.getEndDate());
      st.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  } //TODO OK Perhaps left and right join customers and cars eventually

  @Override
  public void update(Transaction transaction) {
    String updateQuery = "UPDATE transactions" + "SET id=?,beginDate=?,endDate=? + WHERE id=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(updateQuery)) {
      st.setInt(1, transaction.getId());
      st.setDate(2, transaction.getBeginDate());
      st.setDate(3, transaction.getEndDate());
      st.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  } //TODO NOT OK

  @Override
  public void delete(Transaction transaction) {
    String deleteQuery = "DELETE FROM transactions WHERE id=?";
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(deleteQuery)) {
      st.setInt(1, transaction.getId());
      st.execute();

    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "delete transaction");
    }
  } //TODO OK

  @Override
  public List<Transaction> getAll() {

    List<Transaction> transactions = new ArrayList<>();

    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement("SELECT id,begin_date,end_date FROM transactions")) {
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setBeginDate(rs.getDate("begin_date"));
        transaction.setEndDate(rs.getDate("end_date"));
        transactions.add(transaction);
      }
    } catch (SQLException e) {
      LOGGER.log(Level.FINE, "getAll method");
    }
    return transactions;

  }

  @Override
  public List<Transaction> getTransactionById(int id) {
    String sql = "SELECT id FROM transactions";
    List<Transaction> idTransactions = new ArrayList<>();
    try (Connection connection = getDBConnection();
         PreparedStatement st = connection.prepareStatement(sql)) {
      st.setString(1, "id");
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setBeginDate(rs.getDate("begin_date"));
        transaction.setEndDate(rs.getDate("end_date"));

        idTransactions.add(transaction);
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
    return idTransactions;
  }


}


