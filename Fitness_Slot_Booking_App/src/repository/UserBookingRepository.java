package repository;

import model.Slot;

import java.util.List;

public interface UserBookingRepository {
    List<Slot> getUserBookings(String userId);
    void addBooking(String userId, Slot slot);
    void removeBooking(String userId, Slot slot);
}
