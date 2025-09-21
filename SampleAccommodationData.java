// Contributed by Louis Sarmiento

import accommodation.Accommodation;
import accommodation.Amenities;
import accommodation.BedType;
import accommodation.Location;
import accommodation.OptionalExtras;
import accommodation.Price;
import java.util.ArrayList;
import java.util.List;

/**
 * Supplies a handful of hard-coded accommodations to exercise the skeleton features.
 */
public final class SampleAccommodationData {
    private SampleAccommodationData() {
        // Utility class
    }

    public static List<Accommodation> createSampleAccommodations() {
        List<Accommodation> accommodations = new ArrayList<>();

        Accommodation cityApartment = new Accommodation(
                "A101",
                "City Apartment",
                new Location("Melbourne", "Victoria", "Australia"),
                2,
                new Price(145f));
        cityApartment.setAmenities(new Amenities(true, true, false));
        cityApartment.setBedType(new BedType("Queen", 1));
        cityApartment.setOptionalExtras(new OptionalExtras("Late checkout", 30f));
        accommodations.add(cityApartment);

        Accommodation coastalRetreat = new Accommodation(
                "A102",
                "Coastal Retreat",
                new Location("Byron Bay", "New South Wales", "Australia"),
                4,
                new Price(220f));
        coastalRetreat.setAmenities(new Amenities(true, true, true));
        accommodations.add(coastalRetreat);

        Accommodation budgetStay = new Accommodation(
                "A103",
                "Budget Stay",
                new Location("Adelaide", "South Australia", "Australia"),
                3,
                new Price(95f));
        accommodations.add(budgetStay);

        return accommodations;
    }
}
