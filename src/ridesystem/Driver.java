package ridesystem;


public class Driver implements Runnable{

    private final String driverName;
    private final Ride ride;
    public Driver(String driverName, Ride ride) {
        this.driverName = driverName;
        this.ride = ride;
    }

    @Override
    public void run() {
        try{
            while(true){
                RideRequest req = ride.takeRideRequest();

                System.out.println(driverName + " is driving to " + req.getPickUpLocation());
                Thread.sleep(2000);
                System.out.println(driverName + " is Driving " + req.getRiderName());
                Thread.sleep(6000);
                System.out.println("Completed Driving");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
