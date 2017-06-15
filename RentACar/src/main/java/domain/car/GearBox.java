package domain.car;

/**
 * Created by Cosmin on 6/13/2017.
 */

/**
 * Enum GearBox holds the type of gearbox available.
 */
public enum GearBox {

    AUTOMATIC, MANUAL;

    // Iterating through enum //
    public static GearBox search(String test) {
        for (GearBox gearBox : GearBox.values()) {
            if (gearBox.name().equals(test)) {
                return gearBox;

            }

        }
        return null;
    }
}
