// Contributed by Louis Sarmiento
package accommodation;

import java.util.Locale;

/**
 * Basic location metadata for an accommodation.
 */
public class Location {
    private final String city;
    private final String region;
    private final String country;

    public Location(String city, String region, String country) {
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    /**
     * Small helper used by the skeleton search logic.
     */
    public boolean matches(String query) {
        if (query == null || query.isEmpty()) {
            return true;
        }

        String normalisedQuery = query.toLowerCase(Locale.ROOT);
        return toComparable(city).contains(normalisedQuery)
                || toComparable(region).contains(normalisedQuery)
                || toComparable(country).contains(normalisedQuery);
    }

    public String label() {
        StringBuilder builder = new StringBuilder();
        append(builder, city);
        append(builder, region);
        append(builder, country);
        return builder.toString();
    }

    private String toComparable(String value) {
        return value == null ? "" : value.toLowerCase(Locale.ROOT);
    }

    private void append(StringBuilder builder, String value) {
        if (value == null || value.isEmpty()) {
            return;
        }
        if (builder.length() > 0) {
            builder.append(", ");
        }
        builder.append(value);
    }
}
