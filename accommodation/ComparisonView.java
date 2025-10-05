package accommodation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparisonView {
    private final List<ComparisonItem> items;
    private final String message;

    private ComparisonView(List<ComparisonItem> items, String message) {
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.message = message;
    }

    public static ComparisonView placeholder(List<AccommodationDetails> details) {
        List<ComparisonItem> placeholderItems = new ArrayList<>();
        for (AccommodationDetails detail : details) {
            placeholderItems.add(new ComparisonItem(detail));
        }
        return new ComparisonView(placeholderItems, "Comparison assembly pending implementation");
    }

    public List<ComparisonItem> getItems() {
        return items;
    }

    public String getMessage() {
        return message;
    }
}
