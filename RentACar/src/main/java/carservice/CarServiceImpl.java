package carservice;

import domain.Car;
import domain.RentalTime;
import repository.CarRepo;
import util.FuelType;
import util.VehicleCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SearchService Class offers search services for cars in car list.
 */
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    public CarServiceImpl() {
        this.carList = new CarRepo().carList;
    }

    public List<Car> findCarsByBrand(String brand) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : carList)

            if (car.getBrand().equalsIgnoreCase(brand)) {
                foundCars.add(car);
                System.out.println(car.getBrand() + " " + "exists in the repository.");
            }
        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }
        return foundCars;

    }

    public List<Car> findCarsByBrandAndModel(String brand, String model) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : carList) {
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

    public List<Car> findCarsByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carList) {
            if ((car.getFuelType() == fuelType //TODO better if it was case-insensitive
                    && (car.isGps() && (car.getSeats() == seats)))) {
                foundCars.add(car);
            }
        }

        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }

        return foundCars;
    }

    public List<Car> findAvailableCars(Date beginDate, Date endDate) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carList) {
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


    public void addCar(int carid, String brand, String model, float size, String color, int seats, int doors, boolean ac, boolean gps, boolean gearbox, FuelType fuelType, VehicleCategory vehicleCategory, List<RentalTime> rentalTimeList, int priceperday) {
        carList.add(new Car(carid, brand, model, size, color, seats, doors, ac, gps, gearbox, fuelType, vehicleCategory, rentalTimeList, priceperday));
    }

    public void del(String brand, String model) {
        Car foundCar = null;
        for (Car car : carList) {
            if ((car.getBrand()).equalsIgnoreCase(brand) && (car.getModel().equalsIgnoreCase(model))) {
                foundCar = car;
                break;
            }
        }
        if (foundCar != null) {
            carList.remove(foundCar);
        } else {
            System.out.println("Car not found in database ! ");
        }
    }

    public List<Car> priceForCars(String brand, String model) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : carList) {
            if ((car.getBrand().equalsIgnoreCase(brand)) && (car.getModel().equalsIgnoreCase(model))) {
                foundCars.add(car);
                System.out.println("Car price per day for this model is " + car.getPriceperday());

            }
            if (foundCars.size() == 0) {
                System.out.println("Car not found in database");
            }
        }
        return foundCars;
    }

    public void update() {
    }

    public void getAll() {
        System.out.println("This is the car list : \n" + carList.toString());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
