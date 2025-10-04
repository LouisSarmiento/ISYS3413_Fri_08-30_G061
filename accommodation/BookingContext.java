// Contributed by Louis Sarmiento
package accommodation;

/**
 * Represents the booking context created once a traveller chooses an accommodation.
 */
public class BookingContext {
    private final Accommodation accommodation;
    private final String bookingReference;

    public BookingContext(Accommodation accommodation, String bookingReference) {
        this.accommodation = accommodation;
        this.bookingReference = bookingReference;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public String describe() {
        return "Booking reference " + bookingReference + " for " + accommodation.getTitle()
                + " at $" + accommodation.getPrice().getNightlyRate() + " per night.";
    }
}
