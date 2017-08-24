package dispatcher;

import domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarDispatcher {

  private static final Logger LOGGER = Logger.getLogger("Simulating threads");

  private List<Car> carList = new ArrayList<>();

  public void rentCar(Car car) {
    System.out.println(Thread.currentThread().getName() + " entered method rented car " + car);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " after sleep");

    while (true) {
      try {
        System.out.println(Thread.currentThread().getName() + " waiting");

        synchronized (this) {
          wait();
          if (carList.contains(car)) {
            carList.remove(car);
            System.out.println(Thread.currentThread().getName() + " Done. Car is rented");
          }
          break;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public void returnCar(Car car) {
    System.out.println(Thread.currentThread().getName() + " entered method return car " + car);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " after sleep");

    synchronized (this) {
      carList.add(car);
      System.out.println(Thread.currentThread().getName() + " Done. Car returned");
      notifyAll();
    }
  }

  public List<Car> getAllCars() {
    return carList;
  }
}
