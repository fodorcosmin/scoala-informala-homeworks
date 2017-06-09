package repository;

import domain.RentalTime;
import domain.car.Car;
import domain.car.FuelType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/23/2017.
 */
public class CarRepositoryImpl implements CarRepository {

    private List<Car> cars;


    public CarRepositoryImpl() {
        this.cars = new ArrayList<>();

    }


    public List<Car> getCars() {
        return cars;
    }


    public List<Car> getCarsByBrand(String brand) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : cars)

            if (car.getBrand().equalsIgnoreCase(brand)) {
                foundCars.add(car);
                System.out.println(car.getBrand() + " " + "exists in the repository.");
            }
        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }
        return foundCars;

    }


    public List<Car> getCarsByBrandAndModel(String brand, String model) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : cars) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getBrand().equalsIgnoreCase(brand))) {
                foundCars.add(car);
                System.out.println("Car exists in the repository !!!" + car.getBrand() + " " + car.getModel());
            }

        }
        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }
        return foundCars;
    }

    public List<Car> getCarsByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : cars) {
            if ((car.getFuelType() == fuelType
                    && (car.isGps() && (car.getSeats() == seats)))) {
                foundCars.add(car);
            }
        }

        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }

        return foundCars;
    }


    public List<Car> getAvailableCars(Date beginDate, Date endDate) {
        List<Car> foundCars = new ArrayList<Car>();

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
                System.out.println("No cars are available");
            }


        }
        return foundCars;
    }


    public List<Car> getAll() {
        return cars;
    }

    public void addAll(List<Car> cars) {
        cars.addAll(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void delete(Car car) {
        cars.remove(car);

    }

    public void updateCars(Car car) {
        cars.set(cars.indexOf(car), car);

    }

}


