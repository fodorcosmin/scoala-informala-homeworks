package services;

import domain.car.Car;
import domain.car.FuelType;
import repository.CarRepository;
import util.MyLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;


/**
 * SearchService Class offers search services for cars in car list.
 */


public class CarService implements SearchService<Car> {
  private CarRepository carRepository;


  public CarService() {
    this.carRepository = new CarRepository();
  }


  public CarRepository getCarRepository() {
    return carRepository;
  }

  public List<Car> findCarsByBrand(String brand) {
    List<Car> foundCars = new ArrayList<>();


    for (Car car : carRepository.getAll()) {
      if (car.getBrand().equalsIgnoreCase(brand)) {
        foundCars.add(car);
      }
    }
    return foundCars;

  }

  public List<Car> findCarsByBrandandModel(String brand, String model) {
    List<Car> foundCars = new ArrayList<>();
    for (Car car : carRepository.getAll()
      ) {
      if (car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model)) {
        foundCars.add(car);
      }
    }
    return foundCars;
  }

  @Override
  public List<Car> findById(int id) throws IOException {
    List<Car> foundCars = new ArrayList<>();
    for (Car car : carRepository.getAll()) {
      if (car.getId() == id) {
        foundCars.add(car);
      } else {
        MyLogger.log(Level.INFO, "ID NOT FOUND");
      }
    }
    return foundCars;
  }


  public List<Car> findByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
    List<Car> foundCars = new ArrayList<>();
    for (Car car : carRepository.getAll()) {
      if ((car.getFuelType().equals(fuelType) && car.isGps()))
        if (car.getSeats() == seats) {
          foundCars.add(car);
        } else {
          MyLogger.log(Level.INFO, "Input mismatch / try again using the corect parameters of the car");
        }

    }
    return foundCars;
  }

  public List<Car> findAvailablePeriod(Date beginDate, Date endDate) {
    if (beginDate.toString().isEmpty() || endDate.toString().isEmpty()) {
      MyLogger.log(Level.FINE, "No dates entered / Input mismatch or empty fields");
      return null;
    }
    return carRepository.getAvailablePeriod(beginDate, endDate);
  }


}

