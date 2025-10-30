package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public static void main(String[] args) {
        MeetingRoom room = new MeetingRoom();
        MeetingRoom room2 = new MeetingRoom();
        MeetingRoom room3 = new MeetingRoom();
        ReentrantLock lock = new ReentrantLock();
        Thread e1 = new Employee("John", room, lock);
        Thread e2 = new Employee("Jane", room2, lock);
        Thread e3 = new Employee("Josh", room3, lock);

        e1.start();
        e2.start();
        e3.start();
    }
}
