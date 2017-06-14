package services.transaction;

import repository.transaction.TransactionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 6/13/2017.
 */
public interface TransactionInterceptorService {

    /**
     * Find same make cars in system.
     */

    List<TransactionRepositoryImpl> findTransactionbyId(int id);

    /**
     * find all
     */
    List<TransactionRepositoryImpl> findAll(ArrayList<TransactionRepositoryImpl> transactions);
}

