package util;

/**
 * Created by Cosmin on 6/14/2017.
 */
public enum PaymentMethod {

    CASH, CREDITCARD, PAYPAL;


    public static PaymentMethod searchEnum(String test) {

        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            if (paymentMethod.name().equals(test)) {
                return paymentMethod;
            }
        }
        return null;
    }

}