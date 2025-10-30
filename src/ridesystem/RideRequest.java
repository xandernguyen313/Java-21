package ridesystem;

public class RideRequest {
    private final String riderName;
    private final String pickUpLocation;
    private final String dropOffLocation;

    public RideRequest(String riderName, String pickUpLocation, String dropOffLocation) {
        this.riderName = riderName;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }
    public String getRiderName() {
        return riderName;
    }
    public String getPickUpLocation() {
        return pickUpLocation;
    }
    public String getDropOffLocation() {
        return dropOffLocation;
    }

    @Override
    public String toString() {
        return "RideRequest{rider=" + riderName +
                ", from=" + pickUpLocation +
                ", to=" + dropOffLocation + "}";
    }
}
