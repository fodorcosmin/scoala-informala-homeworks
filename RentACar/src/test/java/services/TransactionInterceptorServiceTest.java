package services;

import domain.calendar.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.TransactionRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class TransactionInterceptorServiceTest {
  @Mock
  TransactionInterceptorService instance;
  @Mock
  TransactionRepositoryImpl transactionRepository;
  @InjectMocks
  TransactionInterceptorService transactionInterceptorService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFindTransactionById() throws Exception {
    List<Transaction> result = transactionInterceptorService.findTransactionById(0);
    Assert.assertEquals(Arrays.asList(new Transaction()), result);
  }

  @Test
  public void testAdd() throws Exception {
    transactionInterceptorService.add(new Transaction());
  }

  @Test
  public void testDelete() throws Exception {
    transactionInterceptorService.delete(new Transaction());
  }

  @Test
  public void testUpdate() throws Exception {
    transactionInterceptorService.update(new Transaction());
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
