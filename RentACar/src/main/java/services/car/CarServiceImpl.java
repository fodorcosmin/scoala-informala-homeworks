package services.car;

import domain.car.Car;
import domain.car.FuelType;
import repository.car.CarRepositoryImpl;

import java.util.Date;
import java.util.List;

/**
 * SearchService Class offers search services for cars in car list.
 */
public class CarServiceImpl implements CarService {

    private CarRepositoryImpl carRepository;
    private List<Car> cars = new CarRepositoryImpl().getCars();

    public CarServiceImpl() {
        this.carRepository = new CarRepositoryImpl();
    }


    public List<Car> findCarsByBrand(String brand) {
        if (brand.isEmpty()) {
            System.out.println("error");
            return null;
        }
        return carRepository.getCarsByBrand(brand);

    }

    public List<Car> findCarsByBrandAndModel(String brand, String model) {
        if (brand.isEmpty() || model.isEmpty()) {
            System.out.println("error!");
            return null;
        }
        return carRepository.getCarsByBrandAndModel(brand, model);
    }

    public List<Car> findCarsByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
        if (fuelType != null)
            if (gps = true)
                if (cars.get(seats).equals(seats)) {
                    return carRepository.getCarsByMultipleCategories(fuelType, gps, seats);
                }
        return null;
    }

    public List<Car> findAvailablePeriod(Date beginDate, Date endDate) {
        if (beginDate.toString().isEmpty() || endDate.toString().isEmpty()) {
            System.out.println("error");
            return null;
        }
        return carRepository.getAvailablePeriod(beginDate, endDate);
    }
}

