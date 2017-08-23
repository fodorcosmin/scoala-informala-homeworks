package domain.car;

/**
 * Created by Cosmin on 6/13/2017.
 */

/**
 * Enum GearBox holds the type of gearbox available.
 */
public enum GearBox {

  AUTOMATIC, MANUAL;

  public static GearBox search(String test) {
    for (GearBox gear : GearBox.values()) {
      if (gear.name().equalsIgnoreCase(test)) {
        return gear;

      }

    }
    return null;

  }
}
