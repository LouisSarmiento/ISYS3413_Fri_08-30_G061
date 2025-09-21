package model;

public class Car extends Vehicle {
    private boolean convertible;

    public Car(int vehicleId, String make, String model, int seats, float pricePerDay, boolean isConvertible) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.convertible = isConvertible;
    }

    public void openRoof() {
        convertible = true;
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (Car, Convertible: " + convertible + ")";
    }

    public boolean isConvertible() {
        return convertible;
    }
}
