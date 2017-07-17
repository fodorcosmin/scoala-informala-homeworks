import domain.car.*;
import domain.customer.Customer;
import repository.CarRepository;
import repository.CustomerRepository;
import services.CarService;
import services.CustomerService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Fodor Cosmin on 5/26/2017.
 */
public class Main {
  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static CustomerRepository customerRepository;
  private static CustomerService customerService;
  private static CarService carService;
  private static CarRepository carRepository;

  public static void main(String[] args) {
    customerRepository = new CustomerRepository();
    customerService = new CustomerService();
    carRepository = new CarRepository();
    carService = new CarService();
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
        System.out.println("BYE!");
        System.exit(0);
        break;
      case 5:

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
        carRepository.readAll();
        mainMenu(input);
        break;
      case 2: //
        customerRepository.readAll();
        mainMenu(input);
        break;
      case 3:
        addACar(input);
        mainMenu(input);
        break;
      case 4:
        delACar(input);
        mainMenu(input);
        break;
      case 5:
        addACustomer(input);
        mainMenu(input);
        break;
      case 6:
        delACustomer();
        mainMenu(input);
        break;
      case 7:
        mainMenu(input);
        break;

    }
  }

  private static void searchMenu(Scanner input) {
    System.out.println("1.Search car by brand : ");
    System.out.println("2.Search car by brand and model : ");
    System.out.println("3.Search car by multiple choices : ");
    System.out.println("4.Search user by id :"); //TODO PROBLEMS
    System.out.println("5.Search user by first name :"); //TODO PROBLEMS
    System.out.println("6.Search user by fullname :"); //TODO PROBLEMS
    System.out.println("7.Exit to main menu :");
    int option = input.nextInt();


    switch (option) {
      case 1:
        searchCarsByBrand(input);
        break;
      case 2:
        searchCarsByBrandAndModel(input);
        break;
      case 3:
        searchCarsByMultipleCategories();
        break;
      case 4:
        searchCustomerById();
        break;
      case 5:
        searchCustomerByFirstName(input);
        break;
      case 6:
        searchCustomerByFullName(input);
      case 7:
        mainMenu(input);
    }


  }

  private static void rentalMenu(Scanner input) {
    System.out.println("1.Enter period:");
    System.out.println("2.testing:");
    System.out.println("3.Exit to main menu:");

    int option = input.nextInt();
    switch (option) {
      case 1:
        searchPeriod(input);
        break;
      case 2:

      case 3:


    }
  }

  private static void searchPeriod(Scanner input) {
    DateFormat df = new SimpleDateFormat("d/MM/yyyy");

    try {
      System.out.println("Enter the begin date in format day/month/year :");
      Date beginDate = df.parse(input.next());
      System.out.println("Enter the end date:");
      Date endDate = df.parse(input.next());
      System.out.println(carService.findAvailablePeriod(beginDate, endDate));
      mainMenu(input);
    } catch (ParseException e) {
      LOGGER.log(Level.INFO, "Something went wrong", e.getMessage());
    }
  }

  private static void searchCarsByBrand(Scanner input) {
    System.out.println("Enter the brand for the current search:");
    String brand = input.nextLine();
    carService.findCarsByBrand(brand);

  }

  private static void searchCarsByBrandAndModel(Scanner input) {
    System.out.println("Enter the brand for the current search:");
    String brand = input.nextLine();
    System.out.println("Enter the model for the current search:");
    String model = input.nextLine();
    carService.findCarsByBrandandModel(brand, model);
  }

  private static void searchCarsByMultipleCategories() {
    System.out.println("Filter for searching cars by fuel type,gps and seats");
    System.out.println("Enter the fuel type:");
    Scanner input = new Scanner(System.in);
    String fuel = input.nextLine();
    FuelType fuelType = FuelType.valueOf(fuel);
    System.out.println("GPS :");
    boolean gps = input.nextBoolean();
    System.out.println("Number of seats:");
    int seats = input.nextInt();
    System.out.println("We have found the following cars :" + "\n" + carService.findByMultipleCategories(fuelType, gps, seats));
    searchMenu(input);
  }

  private static void searchCustomerByFirstName(Scanner input) {
    System.out.println("Enter customer First name : ");
    String firstName = input.next();
    customerService.findCustomerByFirstName(firstName);
  }

  private static void searchCustomerByFullName(Scanner input) {
    System.out.println("Enter customer First name : ");
    String firstName = input.next();
    System.out.println("Enter customer Last name : ");
    String lastName = input.next();
    customerService.findCustomerByFullName(firstName, lastName);

    if (customerService != null) {
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
    customerRepository.getCustomerById(id);
    mainMenu(input);
  }

  private static void addACustomer(Scanner input) {
    System.out.println("Do you want to add a customer in the database: Y/N");
    String decision = input.next();
    if (decision.equalsIgnoreCase("y")) {
      System.out.println("Enter customer's id: ");
      int id = input.nextInt();
      System.out.println("Enter customer's first name : ");
      String firstName = input.next();
      System.out.println("Enter customer's last name : ");
      String lastName = input.next();
      System.out.println("Enter customer email : ");
      String email = input.next();
      System.out.println("Enter customer passport (true/false) : ");
      boolean passport = input.nextBoolean();
      System.out.println("Enter customer telephone number:");
      String telephone = input.next();
      System.out.println("Enter customer streetAddress : ");
      String streetAddress = input.next();
      System.out.println("Enter customer city : ");
      String city = input.next();
      customerRepository.add(new Customer(id, firstName, lastName, email, passport, telephone, streetAddress, city));
      mainMenu(input);
    } else if
      (decision.equalsIgnoreCase("n"))
      System.out.println("Serving next customer!");
  }

  private static void delACustomer() {
    System.out.println("Enter the id for the customer you want to delete :");
    Scanner input = new Scanner(System.in);
    int id = input.nextInt();
    customerService.findById(id);
    System.out.println("Are you sure you want to delete user? :");
    String decision = input.next();
    if (decision.equalsIgnoreCase("y")) {
      customerRepository.delCustomerById(id);
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
      int id = input.nextInt();
      System.out.println("Enter car brand : ");
      String brand = input.next();
      System.out.println("Enter car model : ");
      String model = input.next();
      System.out.println("Enter car engine : ");
      String engine = input.next();
      Engine engineType = Engine.search(engine); //TODO
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
      String gear = input.next();
      GearBox gearBox = GearBox.search(gear);
      System.out.println("Enter the car's fueltype : ");
      String fuel = input.next();
      FuelType fuelType = FuelType.search(fuel);
      System.out.println("Enter the car's type : ");
      String type = input.next();
      VehicleCategory vehicleCategory = VehicleCategory.search(type);
      carRepository.add(new Car(id, brand, model, engineType, color, seats, doors, ac, gps, gearBox, fuelType, vehicleCategory));

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
    carService.findCarsByBrandandModel(brand, model);
    Car car = new Car(brand, model);
    System.out.println("Do you want to delete the car? Y/N");
    String dec = input.next();
    if (dec.equalsIgnoreCase("y")) {
      carRepository.remove(car);
      LOGGER.log(Level.INFO, "The following car was removed from repository : " + brand + " " + model);
    } else if
      (dec.equalsIgnoreCase("n"))
      mainMenu(input);

  }


}

