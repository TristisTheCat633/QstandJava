
package QStandProject;

import java.util.HashMap;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {

    private Queue<Customer> regularTaxiQueue;
    private Queue<Customer> bigTaxiQueue;
    private Queue<Customer> vanQueue;
    private Map<String, Integer> vanTimeSlotBookings;

    private int availableRegularTaxis = 0;
    private int availableBigTaxis = 0;
    private int availableVans = 0;

    public QueueManager() {
        this.regularTaxiQueue = new LinkedList<>();
        this.bigTaxiQueue = new LinkedList<>();
        this.vanQueue = new LinkedList<>();
        this.vanTimeSlotBookings = new HashMap<>();
        initializeVanSlots();
    }

    private void initializeVanSlots() {
        vanTimeSlotBookings.put("09:00 AM", 0);
        vanTimeSlotBookings.put("11:00 AM", 0);
        vanTimeSlotBookings.put("01:00 PM", 0);
        vanTimeSlotBookings.put("03:00 PM", 0);
        vanTimeSlotBookings.put("05:00 PM", 0);
        vanTimeSlotBookings.put("07:00 PM", 0);
        vanTimeSlotBookings.put("09:00 PM", 0);
    }

    public int getAvailableRegularTaxis() {
        return availableRegularTaxis - regularTaxiQueueSize();
    }

    public int getAvailableBigTaxis() {
        return availableBigTaxis - bigTaxiQueueSize();
    }

    public int getAvailableVans() {
        return availableVans - vanQueueSize();
    }

    public void addRegularTaxi() {
        availableRegularTaxis++;
    }

    public void addBigTaxi() {
        availableBigTaxis++;
    }

    public void addVan() {
        availableVans++;
    }

    public void bookRegularTaxi() {
        if (availableRegularTaxis > 0) {
            availableRegularTaxis--;
        }
    }

    public void bookBigTaxi() {
        if (availableBigTaxis > 0) {
            availableBigTaxis--;
        }
    }


    public void bookVanSlot(Customer customer, String timeSlot) throws QueueManagerExceptions {
        if (vanTimeSlotBookings.getOrDefault(timeSlot, 0) < 10) {
            addToVanQueue(customer);
            vanTimeSlotBookings.put(timeSlot, vanTimeSlotBookings.getOrDefault(timeSlot, 0) + 1);
            if (vanTimeSlotBookings.get(timeSlot) == 10) { // Van is fully booked
                availableVans--;
            }
            assignTaxi(new Van(10, "UniqueVanID"), timeSlot);
        } else {
            sendNotification(customer, "Sorry, the Van for slot " + timeSlot + " is fully booked.");
        }
    }


    public void addToRegularTaxiQueue(Customer customer) throws QueueManagerExceptions {
        if (customer.hasActiveBookingForRegularTaxi()) {
            throw new QueueManagerExceptions("Customer already has an active booking for a Regular Taxi!");
        }
        regularTaxiQueue.add(customer);
        customer.setHasActiveBookingForRegularTaxi(true);
    }

    public void addToBigTaxiQueue(Customer customer) throws QueueManagerExceptions {
        if (customer.hasActiveBookingForBigTaxi()) {
            throw new QueueManagerExceptions("Customer already has an active booking for a Big Taxi!");
        }
        bigTaxiQueue.add(customer);
        customer.setHasActiveBookingForBigTaxi(true);
    }

    public void addToVanQueue(Customer customer) throws QueueManagerExceptions {
        if (customer.hasActiveBooking()) {
            throw new QueueManagerExceptions("Customer already has an active booking!");
        }
        vanQueue.add(customer);
    }
    
    public void assignTaxi(RegularTaxi taxi, String bookingId) {
        if (!regularTaxiQueue.isEmpty()) {
            Customer customer = regularTaxiQueue.poll();
            taxi.confirmBooking(bookingId);
            sendNotification(customer, "Your Regular Taxi is confirmed!");
        }
    }

    public void assignTaxi(BigTaxi taxi, String bookingId) {
        if (!bigTaxiQueue.isEmpty()) {
            Customer customer = bigTaxiQueue.poll();
            taxi.confirmBooking(bookingId);
            sendNotification(customer, "Your Big Taxi is confirmed!");
        }
    }

    public void assignTaxi(Van taxi, String timeSlot) {
        if (!vanQueue.isEmpty() && vanTimeSlotBookings.getOrDefault(timeSlot, 0) < 10) {
            Customer customer = vanQueue.poll();
            String bookingID = customer.getUsername() + "_" + System.currentTimeMillis(); // Generate a unique booking ID
            taxi.confirmBooking(bookingID);
            vanTimeSlotBookings.put(timeSlot, vanTimeSlotBookings.getOrDefault(timeSlot, 0) + 1);
            sendNotification(customer, "Your Van for slot " + timeSlot + " is confirmed with Booking ID: " + bookingID);
        }
    }

    
    public void sendNotification(Customer customer, String message) {
        System.out.println("Notification to " + customer.getUsername() + ": " + message);
    }

       
    public void displayVanSchedule() {
        System.out.println("Van Schedule & Available Seats:");
        String[] timeSlots = {"09:00 AM", "11:00 AM", "01:00 PM", "03:00 PM", "05:00 PM", "07:00 PM", "09:00 PM"};
        for (String timeSlot : timeSlots) {
            System.out.println(timeSlot + " - Available Seats: " + getAvailableSeatsForTimeSlot(timeSlot));
        }
    }
    
    public Customer getNextForRegularTaxi() {
        return regularTaxiQueue.poll();
    }

    public Customer getNextForBigTaxi() {
        return bigTaxiQueue.poll();
    }

    public Customer getNextForVan() {
        return vanQueue.poll();
    }

    public int regularTaxiQueueSize() {
        return regularTaxiQueue.size();
    }

    public int bigTaxiQueueSize() {
        return bigTaxiQueue.size();
    }

    public int vanQueueSize() {
        return vanQueue.size();
    }
    
    public int getAvailableSeatsForTimeSlot(String timeSlot) {
        return 10 - vanTimeSlotBookings.getOrDefault(timeSlot, 0);
    }
}
