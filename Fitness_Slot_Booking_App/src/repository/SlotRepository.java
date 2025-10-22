package repository;

import model.Slot;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Common Interface
public interface SlotRepository {
    boolean addSlot(Slot slot);
    Optional<Slot> getSlotById(String slotId);
    List<Slot> getSlotsByDate(LocalDate date);
}
