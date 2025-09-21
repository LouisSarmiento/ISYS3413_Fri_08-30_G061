// Contributed by Louis Sarmiento
package accommodation;

import java.util.Optional;

/**
 * Simplified accommodation entity used for the assessment skeleton.
 */
public class Accommodation {
    private final String accommodationId;
    private final String title;
    private final Location location;
    private final int capacity;
    private final Price price;

    private Amenities amenities; // Optional – not required for the basic flow
    private BedType bedType;     // Optional – populated later
    private OptionalExtras optionalExtras;

    public Accommodation(String accommodationId, String title, Location location, int capacity, Price price) {
        this.accommodationId = accommodationId;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public String getTitle() {
        return title;
    }

    public Location getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public Price getPrice() {
        return price;
    }

    public Optional<Amenities> getAmenities() {
        return Optional.ofNullable(amenities);
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public Optional<BedType> getBedType() {
        return Optional.ofNullable(bedType);
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Optional<OptionalExtras> getOptionalExtras() {
        return Optional.ofNullable(optionalExtras);
    }

    public void setOptionalExtras(OptionalExtras optionalExtras) {
        this.optionalExtras = optionalExtras;
    }

    /**
     * Light-weight summary used by the console stub.
     */
    public String summary() {
        return title + " (" + location.label() + ") - Sleeps " + capacity + ", $" + price.getNightlyRate() + " per night";
    }
}
