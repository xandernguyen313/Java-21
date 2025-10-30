package ridesystem;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    private final List<RideRequest> rideRequests = new ArrayList<>();

    public synchronized void addRideRequest(RideRequest rideRequest) {
        System.out.println("New Request Added: " + rideRequest);
        rideRequests.add(rideRequest);

        notifyAll();
    }
    public synchronized RideRequest takeRideRequest() throws InterruptedException {
        while(rideRequests.isEmpty()) {
            System.out.println("Waiting for ride request");
            wait();
        }

        return rideRequests.remove(0);
    }
}
