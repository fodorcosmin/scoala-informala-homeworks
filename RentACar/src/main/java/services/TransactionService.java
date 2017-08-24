package services;

import domain.calendar.Transaction;
import repository.Repository;

import java.util.List;

public interface TransactionService extends Repository<Transaction> {
  /**
   * @param id
   * @return
   */
  List<Transaction> findTransactionById(int id);


  /**
   * @param transaction
   */
  void add(Transaction transaction);

  /**
   * @param transaction
   */
  void delete(Transaction transaction);

  /**
   * @param transaction
   */
  void update(Transaction transaction);

  String getAll();

}
