package repository.impl;

import model.Slot;
import repository.SlotRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InMemorySlotRepo implements SlotRepository {

    private final Map<String,Slot> slots =  new HashMap<>();

    @Override
    public boolean addSlot(Slot slot) {
        if(slots.containsKey(slot.getSlotId())) return false;
        slots.put(slot.getSlotId(),slot);
        return true;
    }

    @Override
    public Optional<Slot> getSlotById(String slotId) {
        return Optional.ofNullable(slots.get(slotId));
    }

    @Override
    public List<Slot> getSlotsByDate(LocalDate date) {
        return slots.values().stream()
                .filter(s -> date == null || s.getStartTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(Slot::getStartTime))
                .collect(Collectors.toList());
    }
}
