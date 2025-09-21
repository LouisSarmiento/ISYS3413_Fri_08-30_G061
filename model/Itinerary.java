package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Itinerary {
    private final List<String> stops = new ArrayList<>();

    public void addStop(String stop) {
        if (stop != null && !stop.isBlank()) {
            stops.add(stop.trim());
        }
    }

    public List<String> getStops() {
        return Collections.unmodifiableList(stops);
    }
}
