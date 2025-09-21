// Contributed by Louis Sarmiento
package accommodation;


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
