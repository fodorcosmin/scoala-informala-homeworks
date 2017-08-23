import dispatcher.Simulation;
import domain.car.*;
import domain.customer.Address;
import domain.customer.Customer;
import services.CarServiceImpl;
import services.CustomerServiceImpl;
import services.TransactionInterceptorService;

import java.util.Scanner;

/*
  Created by Fodor Cosmin on 5/26/2017.

 */


public class Main {


  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);


    mainMenu(input);
  }

  private static void mainMenu(Scanner input) {

    System.out.println("1.Admin menu");
    System.out.println("2.Search menu:");
    System.out.println("3.Rental menu:");
    System.out.println("4.Exit : ");
    System.out.println("Enter option : ");
    int option = input.nextInt();

    switch (option) {
      case 1:
        adminMenu(input);
        break;
      case 2:
        searchMenu(input);
        break;

      case 3:
        rentalMenu(input);
        break;
      case 4:
        System.out.println("BYE!");
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
        CarServiceImpl.getInstance().getAll();
        break;
      case 2: //
        CustomerServiceImpl.getInstance().getAll();
        break;
      case 3:
        addACar(input);
        break;
      case 4:
        delACar(input);
        break;
      case 5:
        addACustomer(input);
        break;
      case 6:
        delACustomer(input);
        break;
      case 7:
        break;

    }

    mainMenu(input);
  }

  private static void searchMenu(Scanner input) {
    System.out.println("1.Search car by brand : ");
    System.out.println("2.Search car by fuel type : ");
    System.out.println("3.Search user by first name :");
    System.out.println("4.Search user by fullname :");
    System.out.println("5.Exit to main menu :");
    int option = input.nextInt();


    switch (option) {
      case 1:
        searchCarsByBrand(input);
        break;
      case 2:
        searchCarsByFuelType(input);
        break;
      case 3:
        searchCustomerByFirstName(input);
        break;
      case 4:
        searchCustomerByFullName(input);
        break;
      case 5:
        mainMenu(input);
    }


  }

  private static void rentalMenu(Scanner input) {
    System.out.println("1.Enter period:");
    System.out.println("2.View ongoing transactions:");
    System.out.println("3.View a transaction by id:");
    System.out.println("4.Simulate threads");
    System.out.println("5.Exit to main menu:");

    int option = input.nextInt();
    switch (option) {
      case 1:
        //searchPeriod(input);
        break;
      case 2:
        TransactionInterceptorService.getInstance().getAll();
        break;
      case 3:
        searchTransactionById(input);
        break;
      case 4:
        Simulation.getSimulation().simulateCarDispatcher();
      case 5:
        mainMenu(input);
    }
  }

  /*private static void searchPeriod(Scanner input) {
    DateFormat df = new SimpleDateFormat("d/MM/yyyy");

    try {
      System.out.println("Enter the begin date in format day/month/year :");
      java.util.Date beginDate = df.parse(input.next());
      System.out.println("Enter the end date:");
      Date endDate = df.parse(input.next());

      mainMenu(input);
    } catch (ParseException e) {

    }
  } */

  private static void searchCarsByBrand(Scanner input) {
    System.out.println("Enter the brand for the current search:");
    String brand = input.next();
    CarServiceImpl.getInstance().findCarsByBrand(brand);


  }

  private static void searchCarsByFuelType(Scanner input) {
    System.out.println("Enter the fuel type for the current search:");
    String fuel = input.next();
    CarServiceImpl.getInstance().findCarsByFuelType(fuel);

  }

  private static void searchCustomerByFirstName(Scanner input) {
    System.out.println("Enter customer's first name : ");
    String firstName = input.next();
    CustomerServiceImpl.getInstance().findCustomerByFirstName(firstName);
  }

  private static void searchTransactionById(Scanner input) {
    System.out.println("Enter a random ID : ");
    int id = input.nextInt();
    TransactionInterceptorService.getInstance().findTransactionById(id);
  }

  private static void searchCustomerByFullName(Scanner input) {
    System.out.println("Enter customer First name : ");
    String firstName = input.next();
    System.out.println("Enter customer Last name : ");
    String lastName = input.next();
    CustomerServiceImpl.getInstance().findCustomerByFullName(firstName, lastName);

  }

  private static void addACustomer(Scanner input) {
    System.out.println("Do you want to add a customer in the database: Y/N");
    String decision = input.next();
    if (decision.equalsIgnoreCase("y")) {
      Customer customer = new Customer();
      Address address = new Address();
      System.out.println("Enter customer's id: ");
      customer.setId(input.nextInt());
      System.out.println("Enter customer's first name : ");
      customer.setFirstname(input.next());
      System.out.println("Enter customer's last name : ");
      customer.setLastname(input.next());
      System.out.println("Enter customer email : ");
      customer.setEmail(input.next());
      System.out.println("Enter customer passport (true/false) : ");
      customer.setPassport(input.nextBoolean());
      System.out.println("Enter customer telephone number:");
      customer.setTelephone(input.next());
      System.out.println("Enter customer streetAddress : ");
      address.setStreetAddress(input.next());
      System.out.println("Enter customer city : ");
      address.setCity(input.next());
      customer.setAddress(address);
      CustomerServiceImpl.getInstance().add(customer);
      mainMenu(input);
    } else if
      (decision.equalsIgnoreCase("n"))
      System.out.println("Serving next customer!");
  }

  private static void delACustomer(Scanner input) {
    System.out.println("Enter the id for the customer you want to delete :");
    Customer customer = new Customer();
    customer.setId(input.nextInt());
    System.out.println("Are you sure you want to delete user? :");
    String decision = input.next();
    if (decision.equalsIgnoreCase("y")) {
      CustomerServiceImpl.getInstance().delete(customer);
    } else if (decision.equalsIgnoreCase("n")) {
      System.out.println("Exit to main menu!");
      mainMenu(input);
    }
  }


  private static void addACar(Scanner input) {
    System.out.println("Do you want to add a car in the database: Y/N");
    String decision = input.next();


    if (decision.equalsIgnoreCase("y")) {
      Car car = new Car();
      System.out.println("Enter the car's id:");
      car.setId(input.nextInt());
      System.out.println("Enter car brand : ");
      car.setBrand(input.next());
      System.out.println("Enter car model : ");
      car.setModel(input.next());
      System.out.println("Enter car engine : ");
      String engine = input.next();
      EngineType engineType = EngineType.search(engine);
      car.setEngineType(engineType);
      System.out.println("Enter car's color : ");
      car.setColor(input.next());
      System.out.println("Enter car no of seats : ");
      car.setSeats(input.nextInt());
      System.out.println("Enter no of doors :");
      car.setDoors(input.nextInt());
      System.out.println("Enter if car has ac : ");
      car.setAc(input.nextBoolean());
      System.out.println("Enter if car has gps : ");
      car.setGps(input.nextBoolean());
      System.out.println("Enter the car's gearbox : ");
      String gear = input.next();
      GearBox gearBox = GearBox.search(gear);
      car.setGearBox(gearBox);
      System.out.println("Enter the car's fueltype : ");
      String fuel = input.next();
      FuelType fuelType = FuelType.search(fuel);
      car.setFuelType(fuelType);
      System.out.println("Enter the car's type : ");
      String vCategory = input.next();
      VehicleCategory vehicleCategory = VehicleCategory.search(vCategory);
      car.setVehicleCategory(vehicleCategory);
      System.out.println("Enter the car's price : ");
      car.setPrice(input.nextDouble());
      CarServiceImpl.getInstance().add(car);

    } else if
      (decision.equalsIgnoreCase("n"))
      System.out.println("Exit to main menu!");
    mainMenu(input);
  }

  private static void delACar(Scanner input) {
    Car car = new Car();
    System.out.println("Enter the car's brand :");
    car.setBrand(input.next());
    System.out.println("Enter the car's model :");
    car.setModel(input.next());
    CarServiceImpl.getInstance().delete(car);
  }
}


