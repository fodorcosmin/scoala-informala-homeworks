package carservice;

import customer.Customer;
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

    /**
     * Public method findCarsByBrand searches cars by brand.
     *
     * @param brand holds value of car brand
     * @return list of found cars.
     */
    public List<Car> findCarsByBrand(String brand) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : carList)

            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(foundCars.add(car));
            }
        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }
        return foundCars;

    }


    /**
     * Public method findCarsByMakeAndModel searches cars by make and model.
     *
     * @param brand holds value of car make
     * @param model holds value f car model
     * @return list of found cars.
     */

    public List<Car> findCarsByBrandAndModel(String brand, String model) {
        List<Car> foundCars = new ArrayList<Car>();
        for (Car car : carList) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getBrand().equalsIgnoreCase(brand))) {
                System.out.println("Car found!!!" + foundCars.add(car));
            }

        }
        if (foundCars.size() == 0) {
            System.out.println("Car not found in database");
        }
        return foundCars;
    }

    /**
     * Public method findCarsByMultipleCategories searches cars by make, model, color, seats.
     *
     * @param brand value of car make
     * @param model value of car model
     * @param color value of car color
     * @param seats value of car seats
     * @return list of found cars
     */

    public List<Car> findCarsByMultipleCategories(FuelType fuelType, boolean gps, int seats) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carList) {
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

    public List<Car> findAvailableCars(Date beginDate, Date endDate) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carList) {
            boolean isAvailable = true;
            for (RentalTime rentalTime : car.getRentalTimeList()) {
                Date carBegin = rentalTime.getBeginDate();
                Date carEnd = rentalTime.getEndDate();

                if ((beginDate.before(carBegin) && endDate.before(carEnd) && endDate.after(carBegin)) ||
                        (beginDate.before(carBegin) && endDate.after(carEnd)) ||
                        (beginDate.after(carBegin) && beginDate.before(carEnd) && endDate.after(carBegin) && endDate.before(carEnd)) ||
                        (beginDate.after(carBegin) && beginDate.before(carEnd) && endDate.after(carEnd))) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                foundCars.add(car);
            }
        }

        if (foundCars.size() == 0) {
            System.out.println("No cars are available");
        }

        return foundCars;
    }

    public void add(String brand, String model, float size, String color, int seats, int doors, boolean ac, boolean gps, boolean gearbox, FuelType fuelType, VehicleCategory vehicleCategory, List<RentalTime> rentalTimeList, int priceperday) {
        carList.add(new Car(brand, model, size, color, seats, doors, ac, gps, gearbox, fuelType, vehicleCategory, rentalTimeList, priceperday));
    }

    public List<Car> del(String brand, String model) {
        List<Car> delCars = new ArrayList<Car>();
        for (Car car : carList) {
            if ((car.getBrand()) == brand && (car.getModel() == model)) {
                delCars.remove(car);
            }
        }
        return delCars;
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


}
