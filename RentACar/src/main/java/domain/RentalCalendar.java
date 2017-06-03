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
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,1);





        // Cars that are *NOT* available *RENTED*  //
        List<RentalTime> mondisCalendar = new ArrayList<RentalTime>();
        calendar.set(Calendar.DAY_OF_WEEK, 6);
        Date beginDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, 7);
        Date endDate = calendar.getTime();
        mondisCalendar.add(new RentalTime(beginDate, endDate));

        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.WEEK_OF_MONTH, 3);
        Date beginDate2 = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.WEEK_OF_MONTH, 4);
        Date endDate2 = calendar.getTime();
        mondisCalendar.add(new RentalTime(beginDate2, endDate2));



        calendar.set(Calendar.MONTH, 10);
        Date beginDate3 = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        Date endDate3 = calendar.getTime();
        mondisCalendar.add(new RentalTime(beginDate3, endDate3));

        rentalTimeList = mondisCalendar;
    }

}
