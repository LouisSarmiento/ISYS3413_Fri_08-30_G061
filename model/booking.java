package model;

import enums.BookingStatus;

public class Booking {
    private int bookingId;
    private String date;
    private BookingStatus status;
    private User user;
    private Vehicle vehicle;
    private Payment payment;

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
}
