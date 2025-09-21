package model;

public class ReservationHold {
    private final int holdId;
    private boolean active;

    public ReservationHold(int holdId, boolean active) {
        this.holdId = holdId;
        this.active = active;
    }

    public int getHoldId() {
        return holdId;
    }

    public boolean isActive() {
        return active;
    }

    public void release() {
        active = false;
    }
}
