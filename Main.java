import accommodation.*;

public class Main {
    public static void main(String[] args) {
        // Example: Create an instance of Accommodation and print its details
        Price price = new Price(120, 800, 1000);
        Location location = new Location("Sydney", "New South Wales", "Australia");
        BedType bedType = new BedType("King", 2);
        Amenities amenities = new Amenities(true, true, true, true);
        OptionalExtras extras = new OptionalExtras("Late check-out", 30);

        Accommodation accommodation = new Accommodation("A101", "Luxury Stay", "Sydney", 2, 150);
        accommodation.setPriceDetails(price);
        accommodation.setLocationDetails(location);
        accommodation.setBedDetails(bedType);
        accommodation.setAmenities(amenities);
        accommodation.setOptionalExtras(extras);

        System.out.println(accommodation.getDetails());
        System.out.println(price.getPrice());
        System.out.println(location.getLocationDetails());
    }
}
