package services;

import domain.car.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CarRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class CarServiceImplTest {
  @Mock
  CarServiceImpl instance;
  @Mock
  CarRepositoryImpl carRepository;
  @InjectMocks
  CarServiceImpl carServiceImpl;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAdd() throws Exception {
    carServiceImpl.add(new Car());
  }

  @Test
  public void testDelete() throws Exception {
    carServiceImpl.delete(new Car());
  }

  @Test
  public void testUpdate() throws Exception {
    carServiceImpl.update(new Car());
  }

  @Test
  public void testFindCarsByBrand() throws Exception {
    List<Car> result = carServiceImpl.findCarsByBrand("brand");
    Assert.assertEquals(Arrays.asList(new Car()), result);
  }

  @Test
  public void testFindCarsByFuelType() throws Exception {
    List<Car> result = carServiceImpl.findCarsByFuelType("fuelType");
    Assert.assertEquals(Arrays.asList(new Car()), result);
  }
}


