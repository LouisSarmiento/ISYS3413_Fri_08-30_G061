// Contributed by Louis Sarmiento
package accommodation;

/**
 * Minimal representation of the amenities owned by an accommodation.
 */
public class Amenities {
    private final boolean wifi;
    private final boolean parking;
    private final boolean pool;
    private final boolean gym;

    public Amenities(boolean wifi, boolean parking, boolean pool, boolean gym) {
        this.wifi = wifi;
        this.parking = parking;
        this.pool = pool;
        this.gym = gym;
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

    public boolean hasGym() {
        return gym;
    }

    public String describe() {
        return "WiFi: " + yesNo(wifi)
                + ", Parking: " + yesNo(parking)
                + ", Pool: " + yesNo(pool)
                + ", Gym: " + yesNo(gym);
    }

    private String yesNo(boolean value) {
        return value ? "Yes" : "No";
    }
}
