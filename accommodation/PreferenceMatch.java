// Contributed by Louis Sarmiento
package accommodation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reports how well an accommodation aligns with traveller preferences.
 */
public class PreferenceMatch {
    private final boolean matchesAll;
    private final List<String> satisfiedCriteria;
    private final List<String> unmetCriteria;

    public PreferenceMatch(boolean matchesAll, List<String> satisfiedCriteria, List<String> unmetCriteria) {
        this.matchesAll = matchesAll;
        this.satisfiedCriteria = Collections.unmodifiableList(new ArrayList<>(satisfiedCriteria));
        this.unmetCriteria = Collections.unmodifiableList(new ArrayList<>(unmetCriteria));
    }

    public boolean matchesAll() {
        return matchesAll;
    }

    public List<String> satisfiedCriteria() {
        return Collections.unmodifiableList(satisfiedCriteria);
    }

    public List<String> unmetCriteria() {
        return Collections.unmodifiableList(unmetCriteria);
    }
}
