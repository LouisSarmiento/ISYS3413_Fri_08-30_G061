package flight;

public class Prices {
    private float totalPrice;

    public Prices(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public float getPrice() {
        return totalPrice;
    }
    public static float sumPrice(float locationPrice, float airline, float seatType) {
        return locationPrice * airline * seatType;
    }
    
}
