package repository.transaction;


import domain.transaction.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by  Fodor Cosmin on 6/13/2017.
 */

public class TransactionRepositoryImpl implements TransactionRepository {


    private List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getAll() {
        return transactionList;
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

    public void save(String transactionList) throws IOException {
        FileOutputStream fout = new FileOutputStream("transactions.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(transactionList);
        fout.close();
    }


    public void read(String transactions) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("transactions.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        transactionList = (List<Transaction>) ois.readObject();
        ois.close();
    }
}
