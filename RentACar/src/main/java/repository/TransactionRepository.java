package repository;

import domain.calendar.Transaction;

import java.util.List;

public interface TransactionRepository {

  List<Transaction> getAll();

  List<Transaction> getTransactionById(int id);

  void add(Transaction transaction);

  void delete(Transaction transaction);

  void update(Transaction transaction);
}

