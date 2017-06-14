package services.transaction;

import repository.transaction.TransactionRepository;
import repository.transaction.TransactionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 6/13/2017.
 */

public class TransactionInterceptorServiceImpl implements TransactionInterceptorService {


    private TransactionRepository transactionRepository;

    public List<TransactionRepositoryImpl> findTransactionbyId(int id) {
        return null;
    }

    public List<TransactionRepositoryImpl> findAll(ArrayList<TransactionRepositoryImpl> transactions) {
        return null;
    }
}
