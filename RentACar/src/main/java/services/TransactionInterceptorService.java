package services;

import domain.calendar.Transaction;
import repository.TransactionRepositoryImpl;

import java.util.List;

/**
 * Created by Fodor Cosmin on 6/13/2017.
 */

public class TransactionInterceptorService implements TransactionService {


  private static final TransactionInterceptorService instance = new TransactionInterceptorService(new TransactionRepositoryImpl());
  private TransactionRepositoryImpl transactionRepository;

  public TransactionInterceptorService(TransactionRepositoryImpl transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public static TransactionInterceptorService getInstance() {
    return instance;
  }

  @Override
  public List<Transaction> findTransactionById(int id) {

    return this.transactionRepository.getTransactionById(id);
  }


  @Override
  public void add(Transaction transaction) {
    this.transactionRepository.add(transaction);
  }

  @Override
  public void delete(Transaction transaction) {
    this.transactionRepository.delete(transaction);
  }

  @Override
  public void update(Transaction transaction) {
    this.transactionRepository.update(transaction);
  }

  @Override
  public String getAll() {
    return this.transactionRepository.getAll().toString();
  }

}
