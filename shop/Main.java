package ro.sci.shop;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();
        Produs produs1 = new Produs("Samsung", "TV cu diagonala 80 cm", "TV");
        Produs produs2 = new Produs("Bose", "Boxe HI-FI", "Audio");
        Produs produs3 = new Produs("Nike", "Running Shoes", "Incaltaminte");
        cart.add(produs3, 4);
        System.out.println(cart.afiseaza());
        cart.add(produs1, 2);
        System.out.println(cart.afiseaza());
        cart.add(produs2, 1);
        System.out.println(cart.afiseaza());
        cart.del(produs3, 2);
        System.out.println(cart.afiseaza());
        cart.modify(produs2, 1);
        System.out.println(cart.afiseaza());
        cart.modify(produs1, 2);
        System.out.println(cart.afiseaza());
        Adresa CJ = new Adresa("calea motilor", 18, "Cluj-Napoca");


    }


}



