package domain.car;

/**
 * Created by Cosmin on 5/21/2017.
 */
public enum FuelType {
  GAS, DIESEL, GPL;

  public static FuelType search(String test) {
    for (FuelType fuel : FuelType.values()) {
      if (fuel.name().equalsIgnoreCase(test)) {
        return fuel;

      }

    }
    return null;
  }
}
