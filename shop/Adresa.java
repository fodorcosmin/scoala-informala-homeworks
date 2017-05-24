package ro.sci.shop;

/**
 * Created by FCS on 5/10/2017.
 */
public class Adresa {
    private String strada;
    private int numar;
    private String localitate;

    // Constructor //
    public Adresa(String strada, int numar, String localitate) {
        this.strada = strada;
        this.numar = numar;
        this.localitate = localitate;
    }
}