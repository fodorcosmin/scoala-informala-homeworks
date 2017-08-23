package services;

import domain.customer.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CustomerRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class CustomerServiceImplTest {
  @Mock
  CustomerServiceImpl instance;
  @Mock
  CustomerRepositoryImpl customerRepository;
  @InjectMocks
  CustomerServiceImpl customerServiceImpl;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAdd() throws Exception {
    customerServiceImpl.add(new Customer());
  }

  @Test
  public void testDelete() throws Exception {
    customerServiceImpl.delete(new Customer());
  }

  @Test
  public void testUpdate() throws Exception {
    customerServiceImpl.update(new Customer());
  }

  @Test
  public void testFindCustomerByFirstName() throws Exception {
    List<Customer> result = customerServiceImpl.findCustomerByFirstName("firstName");
    Assert.assertEquals(Arrays.asList(new Customer()), result);
  }

  @Test
  public void testFindCustomerByFullName() throws Exception {
    List<Customer> result = customerServiceImpl.findCustomerByFullName("firstName", "lastName");
    Assert.assertEquals(Arrays.asList(new Customer()), result);
  }

  @Test
  public void testFindCustomerById() throws Exception {
    List<Customer> result = customerServiceImpl.findCustomerById(0);
    Assert.assertEquals(Arrays.asList(new Customer()), result);
  }
}


