// Contributed by Louis Sarmiento
package accommodation;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchFilter {

    // Simplified filter method that uses a map of criteria
    public static List<Accommodation> applyFilter(List<Accommodation> accommodations, Map<String, Object> criteria) {
        return accommodations.stream()
                .filter(acc -> filterByCriteria(acc, criteria))
                .collect(Collectors.toList());
    }

    // Helper method to check if an accommodation meets all criteria
    private static boolean filterByCriteria(Accommodation accommodation, Map<String, Object> criteria) {
        boolean matches = true;

        // Filter by location
        if (criteria.containsKey("location")) {
            String locationSearch = (String) criteria.get("location");
            matches &= filterByLocation(accommodation, locationSearch);
        }

        // Filter by price
        if (criteria.containsKey("price")) {
            float maxPrice = (float) criteria.get("price");
            matches &= filterByPrice(accommodation, maxPrice);
        }

        // Filter by price range
        if (criteria.containsKey("priceRange")) {
            float[] priceRange = (float[]) criteria.get("priceRange");
            matches &= filterByPriceRange(accommodation, priceRange[0], priceRange[1]);
        }

        // Filter by amenities
        if (criteria.containsKey("wifi") || criteria.containsKey("pool")) {
            boolean wifi = (boolean) criteria.getOrDefault("wifi", false);
            boolean pool = (boolean) criteria.getOrDefault("pool", false);
            matches &= filterByAmenities(accommodation, wifi, pool);
        }

        // Filter by capacity
        if (criteria.containsKey("capacity")) {
            int minCapacity = (int) criteria.get("capacity");
            matches &= filterByCapacity(accommodation, minCapacity);
        }

        // Filter by bed type
        if (criteria.containsKey("bedType")) {
            String bedType = (String) criteria.get("bedType");
            matches &= filterByBedType(accommodation, bedType);
        }

        // Filter by optional extra
        if (criteria.containsKey("optionalExtra")) {
            String extraName = (String) criteria.get("optionalExtra");
            matches &= filterByOptionalExtra(accommodation, extraName);
        }

        return matches;
    }

    // Filters for location
    private static boolean filterByLocation(Accommodation accommodation, String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return true;
        }

        String normalised = searchTerm.trim().toLowerCase(Locale.ROOT);
        Location location = accommodation.getLocationInfo();

        if (location != null) {
            String city = location.getCity();
            String region = location.getRegion();
            String country = location.getCountry();
            return (city != null && city.toLowerCase(Locale.ROOT).contains(normalised))
                    || (region != null && region.toLowerCase(Locale.ROOT).contains(normalised))
                    || (country != null && country.toLowerCase(Locale.ROOT).contains(normalised));
        }

        return false;
    }

    // Filters by price
    private static boolean filterByPrice(Accommodation accommodation, float maxPrice) {
        return accommodation.getPricePerNight() <= maxPrice;
    }

    // Filters by price range
    private static boolean filterByPriceRange(Accommodation accommodation, float minPrice, float maxPrice) {
        return accommodation.getPricePerNight() >= minPrice && accommodation.getPricePerNight() <= maxPrice;
    }

    // Filters by amenities
    private static boolean filterByAmenities(Accommodation accommodation, boolean wifi, boolean pool) {
        Amenities amenities = accommodation.getAmenities();
        if (amenities == null) {
            return false;
        }
        boolean wifiMatches = !wifi || amenities.isWiFi();
        boolean poolMatches = !pool || amenities.isPool();
        return wifiMatches && poolMatches;
    }

    // Filters by capacity
    private static boolean filterByCapacity(Accommodation accommodation, int minCapacity) {
        return accommodation.getCapacity() >= minCapacity;
    }

    // Filters by bed type
    private static boolean filterByBedType(Accommodation accommodation, String bedType) {
        if (bedType == null || bedType.isEmpty()) {
            return true;
        }
        String normalised = bedType.trim().toLowerCase(Locale.ROOT);
        return accommodation.getBedDetails() != null
                && accommodation.getBedDetails().getType().toLowerCase(Locale.ROOT).contains(normalised);
    }

    // Filters by optional extra
    private static boolean filterByOptionalExtra(Accommodation accommodation, String extraName) {
        if (extraName == null || extraName.isEmpty()) {
            return true;
        }
        String normalised = extraName.trim().toLowerCase(Locale.ROOT);
        return accommodation.getOptionalExtras() != null
                && accommodation.getOptionalExtras().getExtraName().toLowerCase(Locale.ROOT).contains(normalised);
    }
}
