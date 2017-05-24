package ro.sci.shop;

/**
 * Created by FCS on 5/10/2017.
 */
public class Pret {
    private double valoare;
    private String moneda;

    // Constructor //
    public Pret() {
        this.valoare = valoare;
        this.moneda = moneda;
    }

    // Getters and Setters //
    public double getValoare() {
        return valoare;
    }

    // -------------------------------------------------
    //   Returns the Value of the item
    // -------------------------------------------------
    public String getMoneda() {
        return moneda;
    }

    // -------------------------------------------------
    //   Returns the currency of the item
    // -------------------------------------------------
    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}