package QStandProject;

import java.util.*;

public class QueueManager {
    
    private List<RegularTaxi> availableRegularTaxis = new LinkedList<>();
    private List<BigTaxi> availableBigTaxis = new LinkedList<>();
    private List<Van> availableVans = new LinkedList<>();

    private Map<String, Integer> vanTimeSlotBookings = new HashMap<>();

    private static QueueManager instance;

    public QueueManager() {}

    public static QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

    public void addRegularTaxi(RegularTaxi taxi) {
        availableRegularTaxis.add(taxi);
    }

    public void addBigTaxi(BigTaxi taxi) {
        availableBigTaxis.add(taxi);
    }

    public void addVan(Van van) {
        availableVans.add(van);
    }

    public RegularTaxi bookRegularTaxi() {
        if (availableRegularTaxis.isEmpty()) {
            return null;
        } else {
            return availableRegularTaxis.remove(0);
        }
    }

    public BigTaxi bookBigTaxi() {
        if (availableBigTaxis.isEmpty()) {
            return null;
        } else {
            return availableBigTaxis.remove(0);
        }
    }

    public Van bookVan() {
        if (availableVans.isEmpty()) {
            return null;
        } else {
            return availableVans.remove(0);
        }
    }

    public void bookVanSlot(String timeSlot) {
        int currentBookings = vanTimeSlotBookings.getOrDefault(timeSlot, 0);
        vanTimeSlotBookings.put(timeSlot, currentBookings + 1);
        if (currentBookings + 1 == Van.VAN_CAPACITY) {
            bookVan();
        }
    }

    public void displayAvailableTaxis() {
        System.out.println("Available Taxis");
        System.out.println("Regular Taxi : " + availableRegularTaxis.size());
        System.out.println("Big Taxi : " + availableBigTaxis.size());
        System.out.println("Van : " + availableVans.size());
    }

    public void displayVanSchedule() {
        System.out.println("Van Schedule & Available Seats:");
        String[] timeSlots = {"09:00 AM", "11:00 AM", "01:00 PM", "03:00 PM", "05:00 PM", "07:00 PM", "09:00 PM"};
        for (String slot : timeSlots) {
            int bookedSeats = vanTimeSlotBookings.getOrDefault(slot, 0);
            int availableSeats = Van.VAN_CAPACITY - bookedSeats;
            System.out.println(slot + " - Available Seats: " + availableSeats);
        }
    }
}