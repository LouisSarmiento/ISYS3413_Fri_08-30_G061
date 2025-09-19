import accommodation.Accommodation;
import accommodation.Amenities;
import accommodation.BedType;
import accommodation.Location;
import accommodation.OptionalExtras;
import accommodation.Price;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a richer set of sample accommodations for the CLI demo.
 */
public final class SampleAccommodationData {
    private SampleAccommodationData() {
        // Utility class
    }

    public static List<Accommodation> createSampleAccommodations() {
        List<Accommodation> accommodations = new ArrayList<>();

        Accommodation accommodation1 = new Accommodation("A101", "Luxury Stay", "Sydney", 2, 150);
        accommodation1.setPriceDetails(new Price(150, 950, 1200));
        accommodation1.setLocationDetails(new Location("Sydney", "New South Wales", "Australia"));
        accommodation1.setBedDetails(new BedType("King", 2));
        accommodation1.setAmenities(new Amenities(true, true, true, false));
        accommodation1.setOptionalExtras(new OptionalExtras("Late Check-out", 30));
        accommodations.add(accommodation1);

        Accommodation accommodation2 = new Accommodation("A102", "Cozy Stay", "Melbourne", 2, 110);
        accommodation2.setPriceDetails(new Price(110, 720, 880));
        accommodation2.setLocationDetails(new Location("Melbourne", "Victoria", "Australia"));
        accommodation2.setBedDetails(new BedType("Queen", 2));
        accommodation2.setAmenities(new Amenities(true, false, true, true));
        accommodation2.setOptionalExtras(new OptionalExtras("Early Check-in", 20));
        accommodations.add(accommodation2);

        Accommodation accommodation3 = new Accommodation("A103", "Urban Loft", "Brisbane", 4, 180);
        accommodation3.setPriceDetails(new Price(180, 1150, 1350));
        accommodation3.setLocationDetails(new Location("Brisbane", "Queensland", "Australia"));
        accommodation3.setBedDetails(new BedType("Double", 4));
        accommodation3.setAmenities(new Amenities(true, true, false, true));
        accommodation3.setOptionalExtras(new OptionalExtras("Airport Transfer", 45));
        accommodations.add(accommodation3);

        Accommodation accommodation4 = new Accommodation("A104", "Beachside Retreat", "Gold Coast", 6, 240);
        accommodation4.setPriceDetails(new Price(240, 1500, 1800));
        accommodation4.setLocationDetails(new Location("Gold Coast", "Queensland", "Australia"));
        accommodation4.setBedDetails(new BedType("Mixed", 6));
        accommodation4.setAmenities(new Amenities(true, true, true, true));
        accommodation4.setOptionalExtras(new OptionalExtras("Surf Lessons", 65));
        accommodations.add(accommodation4);

        Accommodation accommodation5 = new Accommodation("A105", "City Apartment", "Adelaide", 3, 140);
        accommodation5.setPriceDetails(new Price(140, 880, 1050));
        accommodation5.setLocationDetails(new Location("Adelaide", "South Australia", "Australia"));
        accommodation5.setBedDetails(new BedType("Queen", 3));
        accommodation5.setAmenities(new Amenities(true, false, false, true));
        accommodation5.setOptionalExtras(new OptionalExtras("Parking Pass", 15));
        accommodations.add(accommodation5);

        Accommodation accommodation6 = new Accommodation("A106", "Vineyard Cottage", "Perth", 2, 200);
        accommodation6.setPriceDetails(new Price(200, 1250, 1500));
        accommodation6.setLocationDetails(new Location("Perth", "Western Australia", "Australia"));
        accommodation6.setBedDetails(new BedType("King", 2));
        accommodation6.setAmenities(new Amenities(false, true, false, false));
        accommodation6.setOptionalExtras(new OptionalExtras("Wine Tasting", 55));
        accommodations.add(accommodation6);

        Accommodation accommodation7 = new Accommodation("A107", "Lakeside Cabin", "Canberra", 5, 175);
        accommodation7.setPriceDetails(new Price(175, 1120, 1320));
        accommodation7.setLocationDetails(new Location("Canberra", "Australian Capital Territory", "Australia"));
        accommodation7.setBedDetails(new BedType("Twin", 5));
        accommodation7.setAmenities(new Amenities(true, true, false, false));
        accommodation7.setOptionalExtras(new OptionalExtras("Kayak Rental", 40));
        accommodations.add(accommodation7);

        return accommodations;
    }
}
