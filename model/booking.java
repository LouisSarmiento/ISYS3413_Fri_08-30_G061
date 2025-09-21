package model;

import enums.BookingStatus;

public class Booking {
    private final int bookingId;
    private final String date;
    private BookingStatus status;
    private final User user;
    private final Vehicle vehicle;
    private final Payment payment;

    public Booking(int bookingId, String date, User user, Vehicle vehicle, Payment payment) {
        this.bookingId = bookingId;
        this.date = date;
        this.user = user;
        this.vehicle = vehicle;
        this.payment = payment;
        this.status = BookingStatus.PENDING;
    }

    public void setStatus(BookingStatus newStatus) {
        this.status = newStatus;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getDate() {
        return date;
    }
}
