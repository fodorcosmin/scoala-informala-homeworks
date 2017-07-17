package repository;


import domain.calendar.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepository implements Repository<Transaction> {

  private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  private List<Transaction> transactions;

  public TransactionRepository() {
    this.transactions = new ArrayList<>();
  }

  public List<Transaction> getAll() {
    return transactions;
  }

  public void addAll(List<Transaction> transactions) {
  }

  public void add(Transaction transaction) {
    transactions.add(transaction);

  }


  public void remove(Transaction transaction) {
    transactions.remove(transaction);
  }

  public void update(List<Transaction> transactions) {
  }


  public void saveToFile(Transaction transaction) {
    try {
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("transactions.txt"));
      output.writeObject(transaction);
      output.flush();
      output.close();
    } catch (IOException e) {
      LOGGER.log(Level.INFO, "Something went wrong", e.getMessage());
    }
  }


  public List<Transaction> readAll() {
    List<Transaction> transactions1 = new ArrayList<>();
    try {
      ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("cars.txt"));
      Transaction transaction = null;
      while ((transaction = (Transaction) objIn.readObject()) != null) {
        transactions1.add(transaction);
      }
      objIn.close();
    } catch (Exception e) {
      LOGGER.log(Level.INFO, "Something went wrong", e.getMessage());
    }
    return transactions1;
  }
}
