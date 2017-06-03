
package util;
/**
 * Created by Cosmin on 5/26/2017.
 */


/**
 * Enum VehicleCategory holds the vehicle category constants.
 *

 */
public enum VehicleCategory {
    SPORT, SEDAN, HATCHBACK, LIMOUSINE,;

    // Iterating through enum //
    public static VehicleCategory search1(String test) {
        for (VehicleCategory vehicle : VehicleCategory.values()) {
            if (vehicle.name().equals(test)) {
                return vehicle;

            }

        }
        return null;
    }
}