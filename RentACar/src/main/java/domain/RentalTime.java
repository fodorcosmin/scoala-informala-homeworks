package domain;

import java.util.Date;

/**
 * Created by  Fodor Cosmin on 5/27/2017.
 */
public class RentalTime {

    private Date beginDate;
    private Date endDate;

    public RentalTime() {
    }

    public RentalTime(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "beginDate  = " + beginDate + " endDate = " + endDate;
    }
}
