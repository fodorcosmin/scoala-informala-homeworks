package domain.customer;

/**
 * Created by Cosmin on 6/14/2017.
 */
public enum PaymentMethod {

  CASH, CREDITCARD, PAYPAL;


  public PaymentMethod search(String test) {

    for (PaymentMethod paymentMethod : PaymentMethod.values()) {
      if (paymentMethod.name().equals(test)) {
        return paymentMethod;
      }
    }
    return null;
  }

}
