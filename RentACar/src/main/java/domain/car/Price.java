package domain.car;

import util.VCurrency;

public class Price {
  private int value;
  private VCurrency VCurrency;

  public Price(int value, VCurrency VCurrency) {
    this.value = value;
    this.VCurrency = VCurrency;
  }

  public Price() {

  }

  /**
   * Returns the value of the Price object
   *
   * @return float value
   */
  public int getValue() {
    return value;
  }

  /**
   * Set the value of the Price object
   *
   * @param value float
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * Returns the VCurrency of the Price object
   *
   * @return string
   */
  public String getVCurrency() {
    return VCurrency.toString();
  }

  /**
   * Set the VCurrency of the Price object
   *
   * @param VCurrency
   */
  public void setVCurrency(VCurrency VCurrency) {
    this.VCurrency = VCurrency;
  }

  @Override
  public String toString() {
    return "Price{" +
      "value=" + value +
      ", VCurrency=" + VCurrency +
      '}';
  }
}
