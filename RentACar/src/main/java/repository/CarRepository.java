package repository;

import domain.calendar.RentalTime;
import domain.car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public class CarRepository implements Repository<Car> {

  private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  private List<Car> cars;

  public CarRepository() {
    this.cars = new ArrayList<>();
  }

  public void addAll(List<Car> cars) {
    cars.addAll(cars);
  }

  public void add(Car car) {
    cars.add(car);
    saveToFile(car);
  }

  public List<Car> getAll() {
    return cars;
  }

  public void remove(Car car) {
    cars.remove(car);

  }

  public void update(List<Car> cars) {
  }

  public List<Car> getAvailablePeriod(Date beginDate, Date endDate) {
    List<Car> foundCars = new ArrayList<>();

    for (Car car : cars) {
      boolean isAvailable = true;
      for (RentalTime rentalTime : car.getRentalTimeList()) {
        Date carBegin = rentalTime.getBeginDate();
        Date carEnd = rentalTime.getEndDate();

                /* it seems complicated
                if ((beginDate.before(carBegin) && endDate.before(carEnd) && endDate.after(carBegin)) ||
                        (beginDate.before(carBegin) && endDate.after(carEnd)) ||
                        (beginDate.after(carBegin) && beginDate.before(carEnd) && endDate.after(carBegin) && endDate.before(carEnd)) ||
                        (beginDate.after(carBegin) && beginDate.before(carEnd) && endDate.after(carEnd))) {
                    isAvailable = false;
                    break;
                }*/
        if (beginDate.before(carEnd) && endDate.after(carBegin)) {
          isAvailable = false;
          break;
        }

        if (isAvailable) {
          foundCars.add(car);
        }
      }

      if (foundCars.size() == 0) {
        LOGGER.log(Level.FINE, "No cars are available in this period");
      }


    }
    return foundCars;
  }


  public void saveToFile(Car car) {
    try {
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("cars.txt"));
      output.flush();
      output.writeObject(car);
      output.close();
    } catch (IOException e) {
      LOGGER.log(Level.INFO, "Just a stack trace", e.getMessage());
    }
  }


  public List<Car> readAll() {
    List<Car> cars1 = new ArrayList<>();
    try {
      ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("cars.txt"));
      Car car = null;
      while ((car = (Car) objIn.readObject()) != null) {
        cars1.add(car);
      }
      objIn.close();
    } catch (Exception e) {
      LOGGER.log(Level.INFO, "Just a stack trace", e.getMessage());
    }
    return cars1;
  }

  @Override
  public String toString() {
    return "cars = " + cars;
  }
}


