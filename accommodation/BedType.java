package accommodation;

public class BedType {
    private String bedType;
    private int bedCapacity;

    public BedType(String bedType, int bedCapacity) {
        this.bedType = bedType;
        this.bedCapacity = bedCapacity;
    }

    public String getBedDetails() {
        return "Bed Type: " + bedType + ", Bed Capacity: " + bedCapacity;
    }

    public String getType() {
        return bedType;
    }

    public int getCapacity() {
        return bedCapacity;
    }
}
