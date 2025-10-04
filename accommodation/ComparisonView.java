// Contributed by Louis Sarmiento
package accommodation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Result of a comparison request between selected accommodation options.
 */
public class ComparisonView {
    private final boolean valid;
    private final String message;
    private final List<ComparisonItem> items;
    private final List<String> missingAccommodationIds;
    private final Accommodation singleOption;

    private ComparisonView(boolean valid, String message, List<ComparisonItem> items,
                            List<String> missingAccommodationIds, Accommodation singleOption) {
        this.valid = valid;
        this.message = message;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.missingAccommodationIds = Collections.unmodifiableList(new ArrayList<>(missingAccommodationIds));
        this.singleOption = singleOption;
    }

    public static ComparisonView invalid(String message) {
        return new ComparisonView(false, message, Collections.emptyList(), Collections.emptyList(), null);
    }

    public static ComparisonView singleOptionOnly(Accommodation accommodation) {
        if (accommodation == null) {
            return invalid("Only one accommodation reference provided. Add another to compare.");
        }
        String msg = "Only one accommodation selected. Showing details for " + accommodation.getTitle() + ".";
        return new ComparisonView(false, msg, Collections.emptyList(), Collections.emptyList(), accommodation);
    }

    public static ComparisonView success(List<ComparisonItem> items, List<String> missingIds) {
        String message = missingIds.isEmpty() ? "Comparison ready" : "Comparison ready (missing: " + String.join(", ", missingIds) + ")";
        return new ComparisonView(true, message, items, missingIds, null);
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public List<ComparisonItem> getItems() {
        return items;
    }

    public List<String> getMissingAccommodationIds() {
        return missingAccommodationIds;
    }

    public Optional<Accommodation> getSingleOption() {
        return Optional.ofNullable(singleOption);
    }
}
