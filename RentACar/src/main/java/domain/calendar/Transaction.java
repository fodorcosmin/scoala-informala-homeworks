package domain.calendar;

import java.util.Date;

/**
 * Created by Cosmin on 6/14/2017.
 */
public class Transaction {
  private int id;

  private Date beginDate;
  private Date endDate;


  public Transaction() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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


}
