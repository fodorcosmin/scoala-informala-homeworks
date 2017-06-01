package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Fodor Cosmin on 5/31/2017.
 */
public class RentalCalendar {
    public List<RentalTime> rentalTimeList;


    public RentalCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);


        List<RentalTime> firstCalendar = new ArrayList<RentalTime>();

        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date beginDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        Date endDate = calendar.getTime();
        firstCalendar.add(new RentalTime(beginDate, endDate));


        List<RentalTime> secondCalendar = new ArrayList<RentalTime>();
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date beginDate2 = calendar.getTime();
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        Date endDate2 = calendar.getTime();
        secondCalendar.add(new RentalTime(beginDate2, endDate2));


        List<RentalTime> thirdCalendar = new ArrayList<RentalTime>();
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date beginDate3 = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        Date endDate3 = calendar.getTime();
        thirdCalendar.add(new RentalTime(beginDate3, endDate3));

        List<RentalTime> newList = new ArrayList<RentalTime>();
        Stream.of(firstCalendar,secondCalendar,thirdCalendar).forEach(newList::addAll);
        rentalTimeList = newList;
    }

}
