package services;

import domain.car.Car;
import repository.CarRepositoryImpl;

import java.util.List;


public class CarServiceImpl implements CarService {

  private static final CarServiceImpl instance = new CarServiceImpl(new CarRepositoryImpl());
  private CarRepositoryImpl carRepository;

  public CarServiceImpl(CarRepositoryImpl carRepository) {
    this.carRepository = carRepository;
  }


  public static CarServiceImpl getInstance() {
    return instance;
  }


  @Override
  public String getAll() {
    return this.carRepository.getAll().toString();
  }

  @Override
  public void add(Car car) {
    this.carRepository.add(car);
  }

  @Override
  public void delete(Car car) {
    this.carRepository.delete(car);

  }

  @Override
  public void update(Car car) {
    this.carRepository.update(car);

  }

  public List<Car> findCarsByBrand(String brand) {
    return this.carRepository.getCarsByBrand(brand);

  }

  public List<Car> findCarsByFuelType(String fuelType) {
    return this.carRepository.getCarsByFuelType(fuelType);
  }


//  public List<Car> findByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
//    List<Car> foundCars = new ArrayList<>();
//    for (Car car : carRepository.getAll()) {
//      if ((car.getFuelType().equals(fuelType) && car.isGps() == gps))
//        if (car.getSeats() == seats) {
//          foundCars.add(car);
//        } else {
//
//        }
//
//    }
//    return foundCars;
//  }

//    public List<Car> findAvailablePeriod(Date beginDate, Date endDate) {
//      if (beginDate.toString().isEmpty() || endDate.toString().isEmpty()) {
//        MyLogger.log(Level.FINE, "No dates entered / Input mismatch or empty fields");
//        return null;
//      }
//      return carRepository.getAvailablePeriod(beginDate, endDate);
//    }


}

