package services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class SearchFilter {
    private SearchFilter() {
        // Utility class
    }

    public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }
}
