package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by FCS on 5/10/2017.
 */
public class ShoppingCart {
    private List<CartEntry> cartEntries;

    // Constructor //
    public ShoppingCart() {
        this.cartEntries = new ArrayList<CartEntry>();
    }

    // Definirea metodei add //
    public void add(Produs produs, int cantitate) {
        CartEntry entry = new CartEntry(produs, cantitate);
        cartEntries.add(entry);
    }

    // Definirea metodei delete
    public void del(Produs produs, int cantitate) {
        for (int i = 0; i < cartEntries.size(); i++) {
            CartEntry entry = cartEntries.get(i);

            if (entry.getCantitate() == cantitate) {
                if (entry.getProdus() == produs) {
                    cartEntries.remove(entry);
                    break;
                }
            }
        }
    }

    // Definirea Metodei Modify
    public void modify(Produs produs, int cantitate) {
        CartEntry entry = new CartEntry(produs, cantitate);
        if (entry != null) {
            if (cantitate <= 0) {
                del(produs, cantitate);
            } else {
                entry.setCantitate(cantitate);
            }
        }
    }


    public List<CartEntry> afiseaza() {
        return cartEntries;
    }

    /*public Pret calculeazaPretTotal() {
        double pret1 = 0;
        for (Pret pret:Pret

                ) {
            pret1+=pret.getValoare();
        }
        return pret;*/

    public int calculeazaCantitate() {
        int quantity = 0;
        for (CartEntry entry : cartEntries
                ) {
            quantity += entry.getCantitate();
        }
        return quantity;
    }

}
