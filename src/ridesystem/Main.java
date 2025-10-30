package ridesystem;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Ride rideMatcher = new Ride();
        Thread driver1 = new Thread(new Driver("Driver-A", rideMatcher));
        Thread driver2 = new Thread(new Driver("Driver-B", rideMatcher));

        Thread passenger1 = new Thread(new Passenger("Passenger-A", "Location-A", "Location-B", rideMatcher));
        Thread passenger2 = new Thread(new Passenger("Passenger-B", "Location-H", "Location-N", rideMatcher));
        Thread passenger3 = new Thread(new Passenger("Passenger-C", "Location-C", "Location-F", rideMatcher));

        driver1.start();
        driver2.start();

        passenger1.start();
        Thread.sleep(10000);
        passenger2.start();

        passenger3.start();


    }
}
