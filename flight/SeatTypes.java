package flight;

public class SeatTypes {
    private String seatType;
    private String seatLocation;

    public SeatTypes(String seatType, String seatLocation) {
        this.seatType = seatType;
        this.seatLocation = seatLocation;
    }
    public String getSeatType() {
        return seatType;
    }
    public String getSeatLocation() {
        return seatLocation;
    }
    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }
    
}
