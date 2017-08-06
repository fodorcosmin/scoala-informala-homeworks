package util;

/**
 * Created by Cosmin on 7/9/2017.
 */
public enum VCurrency implements SearchEnums {
  EUR,
  USD,
  GBP;

  public String getDbValue() {
    return this.name();
  }

}

