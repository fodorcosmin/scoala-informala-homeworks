package repository.transaction;

import domain.transaction.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * Created by Fodor Cosmin on 6/13/2017.
 */
public interface TransactionRepository {

    /**
     * Get all
     */
    void getAll() throws IOException, ClassNotFoundException;

    /**
     * Get by
     */
    List<Transaction> getTransactionbyId(int id);

    /**
     * Add
     */
    void add(Transaction transaction) throws IOException;

    /**
     * Add all
     */
    void addAll(List<Transaction> transactions);

    /**
     * Delete
     */
    void delete(Transaction transaction);

    /**
     * Update
     */
    void update(Transaction transaction);

    /**
     *
     * @param transactions
     * @return  Saves one transaction at a time. Transaction MUST implement Serializable.
     * @throws IOException
     */
    void saveTransactionToFile(Transaction transactions) throws IOException;


    /**
     *
     * @param transactions
     * @return  Reads all transactions from a file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    List<Transaction> readAllTransactions() throws IOException, ClassNotFoundException;
}
