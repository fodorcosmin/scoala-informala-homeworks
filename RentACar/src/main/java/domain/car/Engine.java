package domain.car;

/**
 * Created by Cosmin on 7/9/2017.
 */
public enum Engine {

  DIESEL, PETROL, HYBRID, ELECTRIC;


  // Iterating through enum //
  public static Engine search(String test) {
    for (Engine engine : Engine.values()) {
      if (engine.name().equals(test)) {
        return engine;

      }

    }
    return null;
  }

}
