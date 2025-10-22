package service;

import model.Slot;
import repository.SlotRepository;
import repository.UserBookingRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class BookingService {
    private final SlotRepository slotRepository;
    private final UserBookingRepository userBookingRepository;

    public BookingService(SlotRepository slotRepository, UserBookingRepository userBookingRepository) {
        this.slotRepository = slotRepository;
        this.userBookingRepository = userBookingRepository;
    }

    public String addSlot(Slot slot){
         slotRepository.addSlot(slot);
         return "Slot added successfully";
    }

    public List<Slot> listSlots(LocalDate date){
        return slotRepository.getSlotsByDate(date);
    }

    public String bookSlot(String userId, String slotId){
        var optSlot = slotRepository.getSlotById(slotId);
        if(optSlot.isEmpty()) return "Slot " + slotId + "does not Exist";
        Slot slot = optSlot.get();

        //check overlap
        for(Slot s : userBookingRepository.getUserBookings(userId)){
            if(overlaps(s,slot)) return "User " + userId + " already have overlapping booking";
        }

        if(!slot.addUser(userId)) return "Slot " + slotId + " is full";
        userBookingRepository.addBooking(userId,slot);
        return "Slot booked successfully for user " + userId + " and slot " + slotId + "capacity left " + slot.getRemainingCapacity();
    }

    public String cancelBooking(String userId,String slotId){
       var optSlot = slotRepository.getSlotById(slotId);
       if(optSlot.isEmpty()) return "Slot " + slotId + "does not Exist";
       Slot slot = optSlot.get();
       if(!slot.removeBook(userId)) return "User " + userId + " is not booked for this slot";
       userBookingRepository.removeBooking(userId,slot);
       return "Slot cancelled successfully";
    }

    public List<Slot> getUserBookings(String userId){
        return userBookingRepository.getUserBookings(userId)
                .stream()
//                .filter(s -> s.getStartTime().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(Slot::getStartTime))
                .toList();
    }

    private boolean overlaps(Slot slot1,Slot slot2){
        return slot1.getStartTime().isBefore(slot2.getEndTime()) && slot1.getEndTime().isAfter(slot2.getStartTime());
    }

}
