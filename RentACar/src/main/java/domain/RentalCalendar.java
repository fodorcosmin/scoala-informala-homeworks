package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Fodor Cosmin on 5/31/2017.
 * //TODO Implement a hashmap that contains an ID of the car and a LIST<RentalTime> and lookup for every car by the id in the map //
 */
public class RentalCalendar {
    public List<RentalTime> rentalTimeList;


    public RentalCalendar() {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);


        // Cars that are *NOT* available *RENTED*  //
        List<RentalTime> firstCalendar = new ArrayList<RentalTime>();
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_WEEK, 6);
        Date beginDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_WEEK, 7);
        Date endDate = calendar.getTime();
        firstCalendar.add(new RentalTime(beginDate, endDate));

        rentalTimeList = firstCalendar;
    }

}
