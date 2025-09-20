
private void validateExactlyOneListing() {
    int count = 0;
    if (vehicle != null) count++;
    if (flight != null) count++;
    if (accommodation != null) count++;
    if (count != 1) {
        throw new IllegalStateException("Booking must reference exactly one of Vehicle, Flight, or Accommodation.");
    }
}

public void setStatus(BookingStatus newStatus) {
    validateExactlyOneListing();
    this.status = newStatus;
}
