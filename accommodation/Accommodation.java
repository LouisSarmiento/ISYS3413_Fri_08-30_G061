// Contributed by Louis Sarmiento
package accommodation;

/**
 * Skeleton representation of an accommodation entity.
 */
public class Accommodation {
    private final String accommodationId;
    private final String title;
    private final String location;
    private final int capacity;
    private final float pricePerNight;

    public Accommodation(String accommodationId, String title, String location, int capacity, float pricePerNight) {
        this.accommodationId = accommodationId;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    // TODO: Add additional fields (amenities, pricing tiers, etc.) as requirements emerge.

    public String getAccommodationId() {
        return accommodationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }
}
