package accommodation;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFilter {
    private String criteria;

    public SearchFilter(String criteria) {
        this.criteria = criteria;
    }

    public List<Accommodation> applyFilter(List<Accommodation> accommodations) {
        // Apply a filter to the accommodation list (For now, simple string filtering)
        return accommodations.stream()
            .filter(acc -> acc.getDetails().contains(criteria))
            .collect(Collectors.toList());
    }
}
