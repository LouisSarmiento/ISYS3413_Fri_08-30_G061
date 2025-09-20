package model;

public class Car extends Vehicle {
    private boolean isConvertible;

    public Car(int vehicleId, String make, String model, int seats, float pricePerDay, boolean isConvertible) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.isConvertible = isConvertible;
    }

    public void openRoof() {
        // TODO: implement
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (Car, Convertible: " + isConvertible + ")";
    }
}
