// Contributed by Louis Sarmiento
package accommodation;

/**
 * Minimal set of filters supported by the accommodation search.
 */
public class SearchCriteria {
    private String locationQuery;
    private Float maxNightlyRate;
    private Integer minCapacity;

    public void clear() {
        locationQuery = null;
        maxNightlyRate = null;
        minCapacity = null;
    }

    public SearchCriteria copy() {
        SearchCriteria copy = new SearchCriteria();
        copy.locationQuery = locationQuery;
        copy.maxNightlyRate = maxNightlyRate;
        copy.minCapacity = minCapacity;
        return copy;
    }

    public boolean hasAny() {
        return locationQuery != null || maxNightlyRate != null || minCapacity != null;
    }

    public String describe() {
        StringBuilder builder = new StringBuilder();
        if (locationQuery != null) {
            builder.append("location contains '").append(locationQuery).append("'");
        }
        if (maxNightlyRate != null) {
            appendComma(builder);
            builder.append("<= $").append(String.format("%.0f", maxNightlyRate)).append(" per night");
        }
        if (minCapacity != null) {
            appendComma(builder);
            builder.append("capacity >= ").append(minCapacity);
        }
        return builder.length() == 0 ? "none" : builder.toString();
    }

    public String getLocationQuery() {
        return locationQuery;
    }

    public void setLocationQuery(String locationQuery) {
        this.locationQuery = normalise(locationQuery);
    }

    public Float getMaxNightlyRate() {
        return maxNightlyRate;
    }

    public void setMaxNightlyRate(Float maxNightlyRate) {
        this.maxNightlyRate = maxNightlyRate;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }

    private void appendComma(StringBuilder builder) {
        if (builder.length() > 0) {
            builder.append(", ");
        }
    }

    private String normalise(String value) {
        return value == null || value.isBlank() ? null : value.trim();
    }

    @Override
    public String toString() {
        return describe();
    }
}
