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
    List<Transaction> getAll();

    /**
     * Get by
     */
    List<Transaction> getTransactionbyId(int id);

    /**
     * Add
     */
    void add(Transaction transaction);

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
     * @param filename
     * @return saves the transactions in a given filename
     * @throws IOException
     */
    void save(String filename) throws IOException;

    /**
     * @param filename
     * @return reads from the given filename
     * @throws IOException
     */
    void read(String filename) throws IOException, ClassNotFoundException;
}
