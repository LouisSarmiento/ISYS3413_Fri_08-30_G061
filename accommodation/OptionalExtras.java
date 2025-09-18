package accommodation;

public class OptionalExtras {
    private String extraName;
    private float extraPrice;

    public OptionalExtras(String extraName, float extraPrice) {
        this.extraName = extraName;
        this.extraPrice = extraPrice;
    }

    public String getExtras() {
        return "Extra: " + extraName + ", Extra price: " + extraPrice;
    }
}
