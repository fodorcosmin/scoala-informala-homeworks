package domain.calendar;

import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Created by  Fodor Cosmin on 7/17/2017.
 */
public class RentalCalendar {


  private LocalDate beginDate;
  private LocalDate endDate;


  //Constructor
  public RentalCalendar(LocalDate pickupDate, LocalDate returnDate) {
    LocalDate today = LocalDate.now();
    if (pickupDate.isBefore(today)) {
      throw new IllegalArgumentException("Date mismatch.");
    }

    if (pickupDate.isAfter(returnDate)) {
      throw new IllegalArgumentException("Date mismatch!!");
    }
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  /**
   * Calculates the time period between pickUpDate and returnDate from calendar represented in number of days.
   *
   * @return number of days as an integer.
   */
  public int intervalOfDays() {
    Days intDays = Days.daysBetween(getBeginDate(), getEndDate());
    String intValue = intDays.toString().replaceAll("[^0-9]", "");
    return Integer.parseInt(intValue);
  }


  //Getters and setters

  public LocalDate getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(final LocalDate beginDate) {
    this.beginDate = beginDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(final LocalDate endDate) {
    this.endDate = endDate;
  }

}
