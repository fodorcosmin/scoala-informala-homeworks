
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

    public VehicleCategory searchEnum(String s) {
        if (s.equalsIgnoreCase("sport") || s.equalsIgnoreCase("sedan") || s.equals("hatchback") || s.equalsIgnoreCase("limousine"))
        return null;
        return null;
    }

}