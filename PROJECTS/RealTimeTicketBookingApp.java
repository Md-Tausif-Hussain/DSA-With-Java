import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Seat class to represent each seat
class Seat {
    private boolean isBooked;

    public Seat() {
        this.isBooked = false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        if (!isBooked) {
            isBooked = true;
        } else {
            throw new IllegalStateException("Seat already booked");
        }
    }

    public void cancel() {
        if (isBooked) {
            isBooked = false;
        } else {
            throw new IllegalStateException("Seat not booked yet");
        }
    }
}

// Event class to represent each event
class Event {
    private String id;
    private String name;
    private Seat[] seats;

    public Event(String id, String name, int seatCount) {
        this.id = id;
        this.name = name;
        this.seats = new Seat[seatCount];
        for (int i = 0; i < seatCount; i++) {
            seats[i] = new Seat();
        }
    }

    public synchronized void bookSeat(int seatNumber) {
        seats[seatNumber].book();
    }

    public synchronized void cancelSeat(int seatNumber) {
        seats[seatNumber].cancel();
    }

    public boolean isSeatAvailable(int seatNumber) {
        return !seats[seatNumber].isBooked();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Seat[] getSeats() {
        return seats;
    }
}

// TicketBookingSystem class to manage events and bookings
class TicketBookingSystem {
    private Map<String, Event> events;

    public TicketBookingSystem() {
        events = new HashMap<>();
    }

    public void addEvent(Event event) {
        events.put(event.getId(), event);
    }

    public void bookSeat(String eventId, int seatNumber) {
        Event event = events.get(eventId);
        if (event != null) {
            event.bookSeat(seatNumber);
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }

    public void cancelSeat(String eventId, int seatNumber) {
        Event event = events.get(eventId);
        if (event != null) {
            event.cancelSeat(seatNumber);
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }

    public boolean isSeatAvailable(String eventId, int seatNumber) {
        Event event = events.get(eventId);
        if (event != null) {
            return event.isSeatAvailable(seatNumber);
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }

    public void listEvents() {
        System.out.println("Available Events:");
        for (Event event : events.values()) {
            System.out.println("Event ID: " + event.getId() + ", Name: " + event.getName());
        }
    }
}

// Main class
public class RealTimeTicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample event
        system.addEvent(new Event("E1", "Concert", 100));
        system.addEvent(new Event("E2", "Movie", 50));

        while (true) {
            System.out.println("\nReal-Time Ticket Booking System");
            System.out.println("1. List Events");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("4. Check Seat Availability");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    system.listEvents();
                    break;
                case 2:
                    System.out.print("Enter event ID: ");
                    String eventId = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    try {
                        system.bookSeat(eventId, seatNumber);
                        System.out.println("Seat booked successfully!");
                    } catch (IllegalStateException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter event ID: ");
                    eventId = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    seatNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    try {
                        system.cancelSeat(eventId, seatNumber);
                        System.out.println("Seat cancelled successfully!");
                    } catch (IllegalStateException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter event ID: ");
                    eventId = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    seatNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    try {
                        boolean available = system.isSeatAvailable(eventId, seatNumber);
                        System.out.println("Seat " + (available ? "is available" : "is not available"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
