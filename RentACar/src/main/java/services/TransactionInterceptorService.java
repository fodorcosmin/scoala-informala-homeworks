//package services;
//
//import domain.calendar.Transaction;
//import domain.customer.Customer;
//import repository.TransactionRepository;
//import util.MyLogger;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//
///**
// * Created by Cosmin on 6/13/2017.
// */
//
//public class TransactionInterceptorService implements SearchService<Transaction> {
//  private Customer customer;
//
//  private TransactionRepository transactionRepository;
//
//  public TransactionInterceptorService(TransactionRepository transactionRepository) {
//
//    this.transactionRepository = transactionRepository;
//
//  }
//
//
//  @Override
//  public List<Transaction> findById(int id) {
//
//    List<Transaction> foundTransactions = new ArrayList<>();
//    for (Transaction transaction : transactionRepository.getAll()) {
//      if (transaction.getId() == id) {
//        foundTransactions.add(transaction);
//      } else {
//        MyLogger.log(Level.INFO, "ID NOT FOUND");
//      }
//    }
//    return foundTransactions;
//  }
//
//
//  public List<Transaction> findAll() {
//    List<Transaction> foundTransactions = new ArrayList<>();
//    for (Transaction transaction : transactionRepository.getAll()) {
//      foundTransactions.add(transaction);
//
//    }
//    return foundTransactions;
//  }
//}
