@Override
public String getDetails() {
    return String.format("%s %s (%d seats) - $%s/day", make, model, seats, fmt(pricePerDay));

}

protected Vehicle(int vehicleId, String make, String model, int seats, float pricePerDay) {
    this.vehicleId = vehicleId;
    this.make = make;
    this.model = model;
    this.seats = seats;
    this.pricePerDay = pricePerDay;
}

protected String fmt(float value) {
    return String.format("%.2f", value);
}

protected String fmt(float value, int decimals) {
    return String.format("%." + decimals + "f", value);
}
