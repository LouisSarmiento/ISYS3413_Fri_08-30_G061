// Contributed by Louis Sarmiento
package accommodation;

/**
 * Captures a simplified view of the bed configuration.
 */
public class BedType {
    private final String type;
    private final int count;

    public BedType(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}
