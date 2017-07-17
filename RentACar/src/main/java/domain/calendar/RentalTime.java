package domain.calendar;

import domain.car.Car;

import java.util.Date;

/**
 * Created by  Fodor Cosmin on 5/27/2017.
 */

//TODO compute algorythm for renting price and find an elegant way for the rental schedules

public class RentalTime {

  private Date beginDate;
  private Date endDate;


  public RentalTime() {


  }


  public Date getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public <T extends Car, V extends Number> double calculateRentPrice(T car, V rentalTime) {

    return car.getRentPrice().getValue() * rentalTime.doubleValue();
  }

}
