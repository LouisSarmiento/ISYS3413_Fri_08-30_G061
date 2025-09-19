// Contributed by Louis Sarmiento
package accommodation;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchFilter {

    public static List<Accommodation> filterByLocation(List<Accommodation> accommodations, String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return accommodations;
        }

        String normalised = searchTerm.trim().toLowerCase(Locale.ROOT);

        return accommodations.stream()
                .filter(acc -> {
                    Location location = acc.getLocationInfo();
                    if (location != null) {
                        String city = location.getCity();
                        String region = location.getRegion();
                        String country = location.getCountry();
                        return (city != null && city.toLowerCase(Locale.ROOT).contains(normalised))
                                || (region != null && region.toLowerCase(Locale.ROOT).contains(normalised))
                                || (country != null && country.toLowerCase(Locale.ROOT).contains(normalised));
                    }
                    return acc.getLocationDetails().toLowerCase(Locale.ROOT).contains(normalised);
                })
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByPrice(List<Accommodation> accommodations, float maxPrice) {
        return accommodations.stream()
                .filter(acc -> acc.getPricePerNight() <= maxPrice)
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByPriceRange(List<Accommodation> accommodations, float minPrice, float maxPrice) {
        return accommodations.stream()
                .filter(acc -> acc.getPricePerNight() >= minPrice && acc.getPricePerNight() <= maxPrice)
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByAmenities(List<Accommodation> accommodations, boolean wifi, boolean pool) {
        return accommodations.stream()
                .filter(acc -> {
                    Amenities amenities = acc.getAmenities();
                    if (amenities == null) {
                        return false;
                    }
                    boolean wifiMatches = !wifi || amenities.isWiFi();
                    boolean poolMatches = !pool || amenities.isPool();
                    return wifiMatches && poolMatches;
                })
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByCapacity(List<Accommodation> accommodations, int minCapacity) {
        return accommodations.stream()
                .filter(acc -> acc.getCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByBedType(List<Accommodation> accommodations, String bedType) {
        if (bedType == null || bedType.isEmpty()) {
            return accommodations;
        }
        String normalised = bedType.trim().toLowerCase(Locale.ROOT);

        return accommodations.stream()
                .filter(acc -> acc.getBedDetails() != null
                        && acc.getBedDetails().getType().toLowerCase(Locale.ROOT).contains(normalised))
                .collect(Collectors.toList());
    }

    public static List<Accommodation> filterByOptionalExtra(List<Accommodation> accommodations, String extraName) {
        if (extraName == null || extraName.isEmpty()) {
            return accommodations;
        }
        String normalised = extraName.trim().toLowerCase(Locale.ROOT);

        return accommodations.stream()
                .filter(acc -> acc.getOptionalExtras() != null
                        && acc.getOptionalExtras().getExtraName().toLowerCase(Locale.ROOT).contains(normalised))
                .collect(Collectors.toList());
    }
}
