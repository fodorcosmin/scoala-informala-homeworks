package repository;

import domain.car.Car;

import java.util.List;


public interface CarRepository extends Repository<Car> {
  /**
   * Get all cars in the system
   *
   * @return List<Car>
   */
  List<Car> getAll();

  /**
   * * Return all the cars of a certain maker
   *
   * @param brand
   * @return List<Car>
   */
  List<Car> getCarsByBrand(String brand);

  /**
   * Return all cars by fuel type
   *
   * @return List<car>
   */
  List<Car> getCarsByFuelType(String fuelType);

  /**
   * Add a car in the system.
   *
   * @param t
   */

//  void reserve(Car t);
}
