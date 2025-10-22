import model.Slot;
import repository.SlotRepository;
import repository.UserBookingRepository;
import repository.impl.InMemorySlotRepo;
import repository.impl.InMemoryUserRepo;
import service.BookingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

//Common CLI
public class FitnessBookingCLI {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        // Initialize repositories and service
        SlotRepository slotRepository = new InMemorySlotRepo();
        UserBookingRepository userBookingRepository = new InMemoryUserRepo();
        BookingService bookingService = new BookingService(slotRepository, userBookingRepository);

    /*
    ADD_SLOT S1 Yoga 2025-09-01T10:00 2025-09-01T11:00 2
    ADD_SLOT S2 HIIT 2025-09-01T08:00 2025-09-01T10:00 2
    LIST_SLOTS 2025-09-01
    BOOK user1 S1
    BOOK user2 S1
    BOOK user3 S1
    BOOK user1 S2
    LIST_BOOKINGS user1
    CANCEL user2 S1
    LIST_SLOTS 2025-09-01
    BOOK user3 S1
    LIST_BOOKINGS user3
    CANCEL user4 S1
    LIST_SLOTS
    exit
    */

        while (true) {
            System.out.print(" > ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (line.isBlank()) continue;

            String[] part = line.split(" ");

            try {
                switch (part[0]) {
                    case "ADD_SLOT" -> {
                        Slot slot = new Slot(
                                part[1],
                                part[2],
                                LocalDateTime.parse(part[3]),
                                LocalDateTime.parse(part[4]),
                                Integer.parseInt(part[5])
                        );
                        System.out.println(bookingService.addSlot(slot));
                    }

                    case "LIST_SLOTS" -> {
                        if (part.length == 2) {
                            LocalDate date = LocalDate.parse(part[1]);
                            var slots = bookingService.listSlots(date);
                            for(Slot slot : slots){
                                System.out.printf("%s %s %s-%s capacity=%d booked=%d%n",
                                        slot.getSlotId(),
                                        slot.getTitle(),
                                        slot.getStartTime(),
                                        slot.getEndTime(),
                                        slot.getCapacity(),
                                        slot.getBookedUser().size());
                            }
                        }
                    }

                    case "BOOK" -> {
                        String userId = part[1];
                        String slotId = part[2];
                        System.out.println(bookingService.bookSlot(userId, slotId));
                    }

                    case "LIST_BOOKINGS" -> {
                        String userId = part[1];
                        var bookings = bookingService.getUserBookings(userId);
                        if (bookings.isEmpty()) {
                            System.out.println("No upcoming bookings for " + userId);
                        } else {
                            bookings.forEach(System.out::println);
                        }
                    }

                    case "CANCEL" -> {
                        String userId = part[1];
                        String slotId = part[2];
                        System.out.println(bookingService.cancelBooking(userId, slotId));
                    }

                    default -> System.out.println("Invalid command: " + part[0]);
                }
            } catch (Exception e) {
                System.out.println("Error processing command: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
