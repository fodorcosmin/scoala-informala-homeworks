package repository.transaction;


import domain.transaction.Transaction;

import java.io.*;
import java.util.*;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepositoryImpl implements TransactionRepository {

    private List<Transaction> transactions;
    private HashMap<Transaction,Date> hm = new HashMap<Transaction,Date>();


    public void getAll() throws IOException, ClassNotFoundException {
        System.out.println("" + readTransactions(transactions));
    }
    public void addAll(List<Transaction> transactions) {
    }

    public void add(Transaction transaction) {

    }


    public void delete(Transaction transaction) {

    }

    public void update(Transaction transaction) {
    }

    public List<Transaction> getTransactionbyId(int id) {
        return null;
    }

    public List<Transaction> saveTransactions(List<Transaction> transactions) throws IOException {
        FileOutputStream fout = new FileOutputStream("transactions.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(transactions);
        fout.close();
        return transactions;
    }


    public List<Transaction> readTransactions(List<Transaction> transactions) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("transactions.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        transactions = (List<Transaction>) ois.readObject();
        ois.close();
        return transactions;
    }
}
