public static void main(String[] args) {
    List<Vehicle> stock = List.of(
        new Car(1, "Toyota", "Corolla", 5, 59.90f, false),
        new SUV(2, "Subaru", "Forester", 5, 79.00f, true)
    );

    stock.forEach(v -> System.out.println(v.getDetails()));

    Vehicle chosen = stock.get(0); // pretend user chose index 0

    Booking b = new Booking();
    b.setVehicle(chosen);                // add a setter
    b.setAmount(chosen.getPricePerDay()); // add getter
    Payment p = new Payment(chosen.getPricePerDay());
    b.setPayment(p);

    boolean ok = p.processPayment();
    b.setStatus(ok ? BookingStatus.CONFIRMED : BookingStatus.PENDING);

    System.out.println(ok ? "Booked: " + chosen.getDetails() : "Payment failed");
}
