// Contributed by Louis Sarmiento
package accommodation;

/**
 * Simple value object describing add-ons that may accompany an accommodation.
 */
public class OptionalExtras {
    private final String name;
    private final float price;

    public OptionalExtras(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
