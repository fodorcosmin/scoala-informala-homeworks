package domain.car;

/**
 * Created by Cosmin on 5/21/2017.
 */
public enum FuelType {
  GAS, DIESEL, GPL;


  // Iterating through enum //
  public static FuelType search(String test) {

    for (FuelType fuelType : FuelType.values()) {
      if (fuelType.name().equals(test)) {
        return fuelType;
      }
    }
    return null;
  }
}
