package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Employee extends Thread {
    private String name;
    private MeetingRoom room;
    private ReentrantLock lock;
    public Employee(String name, MeetingRoom room,  ReentrantLock lock) {
        this.name = name;
        this.room = room;
        this.lock = lock;
    }

    public String getEmployeeName(){
        return name;
    }
    @Override
    public void run() {
        room.enterRoom(this, lock);

    }
}
