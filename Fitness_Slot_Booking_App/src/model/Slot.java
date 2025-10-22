package model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Slot {
    private final String slotId;
    private final String title;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int capacity;
    private final Set<String> bookedUser;

    public Slot(String slotId, String title, LocalDateTime startTime, LocalDateTime endTime, int capacity) {
        this.slotId = slotId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.bookedUser = new HashSet<>();
    }

    public String getSlotId() {
        return slotId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<String> getBookedUser() {
        return bookedUser;
    }

    public boolean addUser(String userId){
        if(bookedUser.size() >= capacity) return false;
        bookedUser.add(userId);
        return true;
    }

    public boolean removeBook(String userId){
        if(bookedUser.contains(userId)){
            bookedUser.remove(userId);
            return true;
        } else {
            return false;
        }
    }

    public int bookedCount(){
        return bookedUser.size();
    }

    public int getRemainingCapacity() {
        return capacity - bookedUser.size();
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", capacity=" + capacity +
                ", bookedUser=" + bookedUser +
                '}';
    }
}
