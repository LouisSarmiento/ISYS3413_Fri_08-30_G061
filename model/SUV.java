public SUV (int vehicleId, String make, String model, int seats, float price, boolean hasAWD) {
    super(vehicleId, make, model, seats, price);
    this.hasAWD = hasAWD;
}

public void toggleAWD(boolean on) {
    this.hasAWD = on;
    System.out.println(on ? "AWD enabled" : "AWD disabled");
}
