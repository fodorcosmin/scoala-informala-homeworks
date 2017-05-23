package ro.sci.shop;


import java.util.Date;

/**
 * Created by FCS on 5/10/2017.
 */
public class Review {
    private Date date;
    private Short rate;
    private String text;

    public Review(Date date, Short rate, String text) {
        this.date = date;
        this.rate = rate;
        this.text = text;
    }
}
