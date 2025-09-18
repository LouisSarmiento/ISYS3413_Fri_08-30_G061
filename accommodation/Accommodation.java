package accommodation;

public class Accommodation {
    private String accommodationID; // Primary Key
    private String title;
    private String location;
    private int capacity;
    private float price;
    private Price priceDetails;
    private Location locationDetails;
    private BedType bedDetails;
    private Amenities amenities;
    private OptionalExtras optionalExtras;
    private Review review;

    public Accommodation(String accommodationID, String title, String location, int capacity, float price) {
        this.accommodationID = accommodationID;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
    }

    public String getDetails() {
        return "Accommodation ID: " + accommodationID + ", Title: " + title + ", Location: " + location + 
               ", Capacity: " + capacity + ", Price: " + price;
    }

    // Getters and Setters
    public void setPriceDetails(Price priceDetails) {
        this.priceDetails = priceDetails;
    }

    public void setLocationDetails(Location locationDetails) {
        this.locationDetails = locationDetails;
    }

    public void setBedDetails(BedType bedDetails) {
        this.bedDetails = bedDetails;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public void setOptionalExtras(OptionalExtras optionalExtras) {
        this.optionalExtras = optionalExtras;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
