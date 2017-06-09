import domain.car.Car;
import domain.car.FuelType;
import domain.car.GearBox;
import domain.car.VehicleCategory;
import domain.customer.Customer;
import repository.CarRepositoryImpl;
import repository.CustomerRepositoryImpl;
import services.CarServiceImpl;
import services.CustomerServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class Main {
    private static CustomerRepositoryImpl customerRepositoryImpl;
    private static CustomerServiceImpl customerServiceImpl;
    private static CarServiceImpl carService;
    private static CarRepositoryImpl carRepositoryImpl;
    private static FuelType fuelType1;
    private static VehicleCategory vehicleCategory1;

    public static void main(String[] args) {
        customerRepositoryImpl = new CustomerRepositoryImpl();
        customerServiceImpl = new CustomerServiceImpl();
        carRepositoryImpl = new CarRepositoryImpl();
        carService = new CarServiceImpl();
        Scanner input = new Scanner(System.in);
        mainMenu(input);
    }


    private static void mainMenu(Scanner input) {
        System.out.println("1.Search menu");
        System.out.println("2.Admin menu:");
        System.out.println("3.Rental menu:");
        System.out.println("4.Exit : ");
        System.out.println("Enter option : ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                searchMenu(input);
                break;
            case 2:
                adminMenu(input);
                break;

            case 3:
                rentalMenu(input);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }


    private static void adminMenu(Scanner input) {

        System.out.println("1.Display all cars :");
        System.out.println("2.Display all customers :");
        System.out.println("3.Add a car :");
        System.out.println("4.Delete a car :");
        System.out.println("5.Add a customer: ");
        System.out.println("6.Delete a customer: ");
        System.out.println("7.Exit to main menu: ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                carRepositoryImpl.getAll();
                mainMenu(input);
                break;
            case 2: //todo implement add car
                addACar(input);
                break;
            case 3:
                delACar(input);
                break;
            case 4:
                addACustomer(input);
                break;
            case 5:
                delACustomer();
                break;
            case 6:
                mainMenu(input);
        }
    }

    private static void searchMenu(Scanner input) {
        System.out.println("1.Search car by brand : ");
        System.out.println("2.Search car by brand and model : ");
        System.out.println("3.Search car by multiple choices : ");
        System.out.println("4.Search user by id :");
        System.out.println("5.Search user by fullname :");
        System.out.println("6.Exit to main menu :");
        int option = input.nextInt();


        switch (option) {
            case 1:
                searchCarsByBrand();
                break;
            case 2:
                searchCarsByBrandAndModel();
                break;
            case 3:
                searchCarsByMultipleCategories();
                break; //TODO : make the method return the fuel type by searching in enum
            case 4:
                searchCustomerById();
                break;
            case 5:
                searchCustomerByName(input);
                break;
            case 6:
                mainMenu(input);
        }


    }

    private static void rentalMenu(Scanner input) {
        System.out.println("1.Search available cars :");
        System.out.println("2.Calculate price per day:");
        System.out.println("3.Exit to main menu:");

        int option = input.nextInt();
        switch (option) {
            case 1:
                searchAvailableCars(input);
                break;
            case 2:
            mainMenu(input); //TODO
            case 3:
                mainMenu(input);


        }
    }

    private static void searchAvailableCars(Scanner input) {
        DateFormat df = new SimpleDateFormat("d/MM/yyyy");

        try {
            System.out.println("Enter the begin date in format day/month/year :");
            Date beginDate = df.parse(input.next());
            System.out.println("Enter the end date:");
            Date endDate = df.parse(input.next());
            System.out.println(carService.findAvailableCars(beginDate, endDate));
            mainMenu(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void searchCarsByBrand() {
        System.out.println("Enter the brand for the current search:");
        Scanner input = new Scanner(System.in);
        String brand = input.nextLine();
        carService.findCarsByBrand(brand);
        searchMenu(input);
    }

    private static void searchCarsByBrandAndModel() {
        CarServiceImpl carService = new CarServiceImpl();
        System.out.println("Enter the brand for the current search:");
        Scanner input = new Scanner(System.in);
        String brand = input.nextLine();
        System.out.println("Enter the model for the current search:");
        String model = input.nextLine();
        carService.findCarsByBrandAndModel(brand, model);
        searchMenu(input);
    }

    private static void searchCarsByMultipleCategories() {
        System.out.println("Filter for searching cars by fuel type,gps and seats");
        System.out.println("Enter the fuel type:");
        Scanner input = new Scanner(System.in);
        String fuel = input.nextLine();
        FuelType fuelType = FuelType.search(fuel);
        System.out.println("GPS :");
        boolean gps = input.nextBoolean();
        System.out.println("Number of seats:");
        int seats = input.nextInt();
        System.out.println("We have found the following cars :" + "\n" + carService.findCarsByMultipleCategories(fuelType, gps, seats));
        searchMenu(input);
    }

    private static void searchCustomerByName(Scanner input) {
        System.out.println("Enter customer First name : ");
        String firstName = input.next();
        System.out.println("Enter customer Last name : ");
        String lastName = input.next();
        customerServiceImpl.searchCustomerByFullName(firstName, lastName);

        if (customerServiceImpl != null) {
            System.out.println("Username exists in Database already with the name of " + firstName + " " + lastName);
            mainMenu(input);
        } else {
            System.out.println("Username not found in Database");
            mainMenu(input);
        }

    }

    private static void searchCustomerById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id : ");
        int id = input.nextInt();
        customerServiceImpl.searchCustomerById(id);
        mainMenu(input);
    }

    private static void addACustomer(Scanner input) {
        System.out.println("Do you want to add a customer in the database: Y/N");
        String decision = input.next();
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("Enter customer's id: ");
            int userId = input.nextInt();
            System.out.println("Enter customer's first name : ");
            String firstName = input.next();
            System.out.println("Enter customer's last name : ");
            String lastName = input.next();
            System.out.println("Enter customer email : ");
            String email = input.next();
            System.out.println("Enter customer passport (true/false) : ");
            boolean passport = input.nextBoolean();
            System.out.println("Enter customer streetAddress : ");
            String streetAddress = input.nextLine();
            System.out.println("Enter customer city : ");
            String city = input.nextLine();
            customerRepositoryImpl.add(new Customer(userId, firstName, lastName, email, passport, streetAddress, city));
        } else if
                (decision.equalsIgnoreCase("n"))
            System.out.println("Serving next customer!");
        mainMenu(input);
    }

    private static void delACustomer() {
        System.out.println("Enter the id for the customer you want to delete :");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        customerServiceImpl.searchCustomerById(id);
        System.out.println("Are you sure you want to delete user? :");
        String decision = input.next();
        if (decision.equalsIgnoreCase("y")) {
            customerRepositoryImpl.delCustomerById(id);
            adminMenu(input);
        } else if (decision.equalsIgnoreCase("n")) {
            System.out.println("Exit to main menu!");
            mainMenu(input);
        }
    }


    private static void addACar(Scanner input) {
        System.out.println("Do you want to add a car in the database: Y/N");
        String decision = input.next();
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("Enter the car's id:");
            int carId = input.nextInt();
            System.out.println("Enter car brand : ");
            String brand = input.next();
            System.out.println("Enter car model : ");
            String model = input.next();
            System.out.println("Enter car size : ");
            Float size = input.nextFloat();
            System.out.println("Enter car's color : ");
            String color = input.next();
            System.out.println("Enter car no of seats : ");
            int seats = input.nextInt();
            System.out.println("Enter no of doors :");
            int doors = input.nextInt();
            System.out.println("Enter if car has ac : ");
            boolean ac = input.nextBoolean();
            System.out.println("Enter if car has gps : ");
            boolean gps = input.nextBoolean();
            System.out.println("Enter the car's gearbox : ");
            String gearbox = input.next();
            GearBox gearBox1 = GearBox.search(gearbox);
            System.out.println("Enter the car's fueltype : ");
            String fuel = input.next();
            FuelType fuelType1 = FuelType.search(fuel);
            System.out.println("Enter the car's type : ");
            String type = input.next();
            VehicleCategory vehicleCategory1 = VehicleCategory.search(type);
            System.out.println("Enter the car's price per day : ");
            int price = input.nextInt();
            carRepositoryImpl.add(new Car());


        } else if
                (decision.equalsIgnoreCase("n"))
            System.out.println("Exit to main menu!");
        mainMenu(input);
    }

    private static void delACar(Scanner input) {
        System.out.println("Enter the car's brand :");
        String brand = input.next();
        System.out.println("Enter the car's model :");
        String model = input.next();
        carService.findCarsByBrandAndModel(brand, model);
        Car car = new Car(brand, model);
        System.out.println("Do you want to delete the car? Y/N");
        String dec = input.next();
        if (dec.equalsIgnoreCase("y")) {
            carRepositoryImpl.delete(car);
            System.out.println("The following car was removed from repository : " + brand + " " + model);
        } else if
                (dec.equalsIgnoreCase("n"))
            mainMenu(input);

    }


}

