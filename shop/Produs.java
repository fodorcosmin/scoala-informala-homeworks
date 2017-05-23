package ro.sci.shop;


/**
 * Created by FCS on 5/10/2017.
 */
public class Produs {
    // class fields
    private String nume;
    private String descriere;
    private String categorie;

    // constructor // Encapsulation
    public Produs(String numeProdus, String descriereProdus, String categorieProdus) {
        nume = numeProdus;
        descriere = descriereProdus;
        categorie = categorieProdus;
    }

    // Getters //
    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    // -------------------------------------------------
    //   Returns the name of the item
    // -------------------------------------------------
    public String getDescriere() {
        return descriere;
    }

    // -------------------------------------------------
    //   Returns the Description of the item
    // -------------------------------------------------
    public String getCategorie() {
        return categorie;
    }
    // -------------------------------------------------
    //   Returns the Category of the item
    // -------------------------------------------------
}
