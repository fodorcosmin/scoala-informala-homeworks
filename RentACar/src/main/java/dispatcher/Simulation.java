package dispatcher;

import domain.car.Car;

public class Simulation {

  private static final Simulation instance = new Simulation();
  private CarDispatcher carDispatcher = new CarDispatcher();

  public static Simulation getSimulation() {
    return instance;
  }

  public void simulateCarDispatcher() {
    Car car1 = new Car();
    car1.setModel("VW");
    car1.setBrand("Golf");

    Car car2 = new Car();
    car2.setModel("Dacia");
    car2.setBrand("Logan");

    carDispatcher.getAllCars().add(car1);
    carDispatcher.getAllCars().add(car2);

    Thread t1 = new SimulationReturnThread("Start/notify", carDispatcher, car2);

    Thread t2 = new SimulationReturnThread("Vasile", carDispatcher, car2);
    Thread t3 = new SimulationReturnThread("Costel", carDispatcher, car2);

    Thread t4 = new SimulationRentThread("Vasile", carDispatcher, car2);
    Thread t5 = new SimulationRentThread("Costel", carDispatcher, car2);

    t2.start();
    t3.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    t1.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}

class SimulationRentThread extends Thread {

  private CarDispatcher carDispatcher;
  private Car car;

  public SimulationRentThread(String name, CarDispatcher carDispatcher, Car car) {
    super(name);
    this.carDispatcher = carDispatcher;
    this.car = car;
  }

  @Override
  public void run() {
    carDispatcher.rentCar(car);
  }
}

class SimulationReturnThread extends Thread {

  private CarDispatcher carDispatcher;
  private Car car;

  public SimulationReturnThread(String name, CarDispatcher carDispatcher, Car car) {
    super(name);
    this.carDispatcher = carDispatcher;
    this.car = car;
  }

  @Override
  public void run() {
    carDispatcher.returnCar(car);
  }
}
