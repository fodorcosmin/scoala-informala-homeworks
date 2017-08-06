package domain.car;

/**
 * Created by Cosmin on 7/9/2017.
 */
public enum EngineType {

  DIESEL, PETROL, HYBRID, ELECTRIC;


  // Iterating through enum //
  public static EngineType search(String test) {
    for (EngineType engine : EngineType.values()) {
      if (engine.name().equals(test)) {
        return engine;

      }

    }
    return null;
  }

}
