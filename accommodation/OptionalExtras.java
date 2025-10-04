// Contributed by Louis Sarmiento
package accommodation;

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

    public String describe() {
        return name + " ($" + price + ")";
    }
}
