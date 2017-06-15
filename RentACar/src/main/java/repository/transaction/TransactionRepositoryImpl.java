package repository.transaction;


import domain.transaction.Transaction;

import java.io.*;
import java.util.*;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepositoryImpl implements TransactionRepository {


    private List<Transaction> transactions;

    public TransactionRepositoryImpl() {
        this.transactions = new ArrayList<>();
    }

    public void getAll() throws IOException, ClassNotFoundException {
        System.out.println("" + readAllTransactions());
    }
    public void addAll(List<Transaction> transactions) {
    }

    public void add(Transaction transaction) throws IOException {
        transactions.add(transaction);
        saveTransactionToFile(transaction);
    }


    public void delete(Transaction transaction) {

    }

    public void update(Transaction transaction) {
    }

    public List<Transaction> getTransactionbyId(int id) {
        return null;
    }

    public void saveTransactionToFile(Transaction transaction) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("transactions.txt"));
        output.writeObject(transaction);
        output.close();

    }


        public List<Transaction> readAllTransactions() throws IOException,ClassNotFoundException {
            List<Transaction> transactions = new ArrayList<>();
            try {
                ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("transactions.txt"));
                Transaction transaction = null;
                while ((transaction = (Transaction) objIn.readObject()) != null) {
                }
                objIn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return transactions;
    }
}
