package services;

import domain.car.Car;
import repository.Repository;

import java.util.List;

/**
 * Service Interface for car.
 */
public interface CarService extends Repository<Car> {
  /**
   * Returns the cars found in the system
   *
   * @return
   */
  String getAll();


  /**
   * Search filter based on the following params below
   *
   * @param brand Car
   * @return List<Car>
   */
  List<Car> findCarsByBrand(String brand);

  /**
   * Search filter based on the following params below
   *
   * @param fuelType
   * @return
   */
  List<Car> findCarsByFuelType(String fuelType);
}



