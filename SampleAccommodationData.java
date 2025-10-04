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

        Accommodation luxuryStay = new Accommodation(
                "A101",
                "Luxury Stay",
                new Location("Sydney", "New South Wales", "Australia"),
                2,
                new Price(150f, 950f, 1200f));
        luxuryStay.setAmenities(new Amenities(true, true, true, false));
        luxuryStay.setBedType(new BedType("King", 1));
        luxuryStay.setOptionalExtras(new OptionalExtras("Late Check-out", 30f));
        accommodations.add(luxuryStay);

        Accommodation cozyStay = new Accommodation(
                "A102",
                "Cozy Stay",
                new Location("Melbourne", "Victoria", "Australia"),
                2,
                new Price(110f, 720f, 880f));
        cozyStay.setAmenities(new Amenities(true, false, true, true));
        cozyStay.setBedType(new BedType("Queen", 1));
        cozyStay.setOptionalExtras(new OptionalExtras("Early Check-in", 20f));
        accommodations.add(cozyStay);

        Accommodation urbanLoft = new Accommodation(
                "A103",
                "Urban Loft",
                new Location("Brisbane", "Queensland", "Australia"),
                4,
                new Price(180f, 1150f, 1350f));
        urbanLoft.setAmenities(new Amenities(true, true, false, true));
        urbanLoft.setBedType(new BedType("Double", 2));
        urbanLoft.setOptionalExtras(new OptionalExtras("Airport Transfer", 45f));
        accommodations.add(urbanLoft);

        Accommodation beachsideRetreat = new Accommodation(
                "A104",
                "Beachside Retreat",
                new Location("Gold Coast", "Queensland", "Australia"),
                6,
                new Price(240f, 1500f, 1800f));
        beachsideRetreat.setAmenities(new Amenities(true, true, true, true));
        beachsideRetreat.setBedType(new BedType("Mixed", 3));
        beachsideRetreat.setOptionalExtras(new OptionalExtras("Surf Lessons", 65f));
        accommodations.add(beachsideRetreat);

        Accommodation adelaideApartment = new Accommodation(
                "A105",
                "City Apartment",
                new Location("Adelaide", "South Australia", "Australia"),
                3,
                new Price(140f, 880f, 1050f));
        adelaideApartment.setAmenities(new Amenities(true, false, false, true));
        adelaideApartment.setBedType(new BedType("Queen", 2));
        adelaideApartment.setOptionalExtras(new OptionalExtras("Parking Pass", 15f));
        accommodations.add(adelaideApartment);

        Accommodation vineyardCottage = new Accommodation(
                "A106",
                "Vineyard Cottage",
                new Location("Perth", "Western Australia", "Australia"),
                2,
                new Price(200f, 1250f, 1500f));
        vineyardCottage.setAmenities(new Amenities(false, true, false, false));
        vineyardCottage.setBedType(new BedType("King", 1));
        vineyardCottage.setOptionalExtras(new OptionalExtras("Wine Tasting", 55f));
        accommodations.add(vineyardCottage);

        Accommodation lakesideCabin = new Accommodation(
                "A107",
                "Lakeside Cabin",
                new Location("Canberra", "Australian Capital Territory", "Australia"),
                5,
                new Price(175f, 1120f, 1320f));
        lakesideCabin.setAmenities(new Amenities(true, true, false, false));
        lakesideCabin.setBedType(new BedType("Twin", 3));
        lakesideCabin.setOptionalExtras(new OptionalExtras("Kayak Rental", 40f));
        accommodations.add(lakesideCabin);

        return accommodations;
    }
}
