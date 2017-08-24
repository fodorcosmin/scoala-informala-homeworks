package domain.calendar;

import java.sql.Date;

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

  public void setBeginDate(final Date beginDate) {
    this.beginDate = beginDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(final Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Transaction{" +
      "id=" + id +
      ", beginDate=" + beginDate +
      ", endDate=" + endDate +
      '}';
  }
}
