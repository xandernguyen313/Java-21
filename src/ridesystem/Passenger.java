package ridesystem;


public class Passenger implements Runnable {
    private final String passengerName;
    private final String from;
    private final String to;
    private final Ride ride;
    public Passenger(String passengerName, String from, String string, Ride ride) {
        this.passengerName = passengerName;
        this.from = from;
        this.to = string;
        this.ride = ride;
    }

    @Override
    public void run() {
        RideRequest rideRq = new RideRequest(passengerName, from, to);
        ride.addRideRequest(rideRq);
    }
}
