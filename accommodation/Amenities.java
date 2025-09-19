package accommodation;

public class Amenities {
    private boolean wifi;
    private boolean parking;
    private boolean pool;
    private boolean gym;

    public Amenities(boolean wifi, boolean parking, boolean pool, boolean gym) {
        this.wifi = wifi;
        this.parking = parking;
        this.pool = pool;
        this.gym = gym;
    }

    public boolean isWiFi() { return wifi; }
    public boolean isParking() { return parking; }
    public boolean isPool() { return pool; }
    public boolean isGym() { return gym; }
}
