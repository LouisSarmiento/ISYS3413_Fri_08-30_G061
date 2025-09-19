package accommodation;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFilter {
    
    // Filter by location
    public static List<Accommodation> filterByLocation(List<Accommodation> accommodations, String location) {
        return accommodations.stream()
                             .filter(acc -> acc.getLocationDetails().contains(location))
                             .collect(Collectors.toList());
    }

    // Filter by price
    public static List<Accommodation> filterByPrice(List<Accommodation> accommodations, float maxPrice) {
        return accommodations.stream()
                             .filter(acc -> acc.getPriceDetails().contains(String.valueOf(maxPrice)))
                             .collect(Collectors.toList());
    }

    // Filter by amenities (WiFi, pool)
    public static List<Accommodation> filterByAmenities(List<Accommodation> accommodations, boolean wifi, boolean pool) {
        return accommodations.stream()
                             .filter(acc -> acc.getAmenities().isWiFi() == wifi && acc.getAmenities().isPool() == pool)
                             .collect(Collectors.toList());
    }
}
