package accommodation;

public class Price {
    private float pricePerNight;
    private float pricePerWeek;
    private float seasonalPrice;

    public Price(float pricePerNight, float pricePerWeek, float seasonalPrice) {
        this.pricePerNight = pricePerNight;
        this.pricePerWeek = pricePerWeek;
        this.seasonalPrice = seasonalPrice;
    }

    public String getPrice() {
        return "Price per night: " + pricePerNight + ", Price per week: " + pricePerWeek + ", Seasonal price: " + seasonalPrice;
    }
}
