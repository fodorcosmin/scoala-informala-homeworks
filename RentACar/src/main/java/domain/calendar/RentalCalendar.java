package domain.calendar;

import domain.car.Car;

import java.util.*;

/**
 * Created by Fodor Cosmin on 5/31/2017.
 * //TODO Implement a hashmap that contains an ID of the car and a LIST<RentalTime> and lookup for every car by the id in the map //
 */
public class RentalCalendar {
    private List<RentalTime> rentalTimes;

    public List<RentalTime> getRentalTimes() {
        return rentalTimes;
    }

    public void setRentalTimes(List<RentalTime> rentalTimes) {
        this.rentalTimes = rentalTimes;
    }

    public RentalCalendar()  {


        // Cars that are *NOT* available *Maintenance or RENTED*  //

        List<RentalTime> firstCalendar = new ArrayList<RentalTime>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.NOVEMBER, 25);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        Date beginDate = calendar.getTime();
        calendar.set(Calendar.NOVEMBER, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        Date endDate = calendar.getTime();
        firstCalendar.add(new RentalTime(beginDate, endDate));

        //TODO perhaps concatenate lists ??!? //
    }

    public void checkCarsPeriod() {


    }

}

