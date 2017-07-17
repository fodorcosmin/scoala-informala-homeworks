package util;

/**
 * Created by Cosmin on 7/9/2017.
 */
public enum VCurrency {
  EUR,
  USD,
  GBP;


  public static VCurrency search(String test) {

    for (VCurrency VCurrency : VCurrency.values()) {
      if (VCurrency.name().equals(test)) {
        return VCurrency;
      }
    }
    return null;
  }
}
