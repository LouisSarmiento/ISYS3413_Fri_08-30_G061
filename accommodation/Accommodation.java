package accommodation;

public class Accommodation {
    private String accommodationID;
    private String title;
    private String location;
    private int capacity;
    private float price;
    private Price priceDetails;
    private Location locationDetails;
    private BedType bedDetails;
    private Amenities amenities;
    private OptionalExtras optionalExtras;

    public Accommodation(String accommodationID, String title, String location, int capacity, float price) {
        this.accommodationID = accommodationID;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
    }

    // Getter and Setter methods
    public String getDetails() {
        return "Accommodation ID: " + accommodationID + ", Title: " + title + ", Location: " + location +
               ", Capacity: " + capacity + ", Price: " + price;
    }

    public void setPriceDetails(Price priceDetails) { this.priceDetails = priceDetails; }
    public void setLocationDetails(Location locationDetails) { this.locationDetails = locationDetails; }
    public void setBedDetails(BedType bedDetails) { this.bedDetails = bedDetails; }
    public void setAmenities(Amenities amenities) { this.amenities = amenities; }
    public void setOptionalExtras(OptionalExtras optionalExtras) { this.optionalExtras = optionalExtras; }
    public String getPriceDetails() { return priceDetails.getPrice(); }
    public String getLocationDetails() { return locationDetails.getLocationDetails(); }
    public Amenities getAmenities() { return amenities; }
}
