package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class MeetingRoom {
    public void enterRoom(Employee employee, ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Entering room " + employee.getName());

            try { Thread.sleep(500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
            System.out.println("Leaving room " + employee.getName());
        } finally {
            lock.unlock();
        }
    }

}
