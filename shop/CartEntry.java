package ro.sci.shop;

/**
 * Created by FCS on 5/10/2017.
 */
public class CartEntry {
    private Produs produs;
    private int cantitate;

    // Constructor //
    public CartEntry(Produs produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }

    // Getters and Setters //
    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "CartEntry{" +
                "produs=" + produs +
                ", cantitate=" + cantitate +
                '}';
    }
}