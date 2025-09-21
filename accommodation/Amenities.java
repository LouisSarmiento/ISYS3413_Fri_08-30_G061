// Contributed by Louis Sarmiento
package accommodation;

/**
 * Minimal representation of the amenities owned by an accommodation.
 * Additional fields/behaviour can be introduced as the project evolves.
 */
public class Amenities {
    private final boolean wifi;
    private final boolean parking;
    private final boolean pool;

    public Amenities(boolean wifi, boolean parking, boolean pool) {
        this.wifi = wifi;
        this.parking = parking;
        this.pool = pool;
    }

    public boolean hasWifi() {
        return wifi;
    }

    public boolean hasParking() {
        return parking;
    }

    public boolean hasPool() {
        return pool;
    }
}
