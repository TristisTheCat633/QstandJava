package QStandProject;
import java.util.Scanner;
public class Customer extends User {
	
    private String destination;

    private String taxiType;
    private boolean activeBooking;
    private boolean hasActiveBookingForRegularTaxi = false;
    private boolean hasActiveBookingForBigTaxi = false;
    private boolean hasActiveBookingForVan = false;

    private static Scanner scanner = new Scanner(System.in);
    private QueueManager queueManager;
    
    public Customer(String uniqueUsername, String encryptedPassword) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = QueueManager.getInstance(); 
        this.destination = "";
        this.taxiType = "";
        this.activeBooking = false;
    }

    public boolean hasActiveBookingForRegularTaxi() {
        return hasActiveBookingForRegularTaxi;
    }

    public void setHasActiveBookingForRegularTaxi(boolean hasActiveBookingForRegularTaxi) {
        this.hasActiveBookingForRegularTaxi = hasActiveBookingForRegularTaxi;
    }

    public boolean hasActiveBookingForBigTaxi() {
        return hasActiveBookingForBigTaxi;
    }

    public void setHasActiveBookingForBigTaxi(boolean hasActiveBookingForBigTaxi) {
        this.hasActiveBookingForBigTaxi = hasActiveBookingForBigTaxi;
    }

    public boolean hasActiveBookingForVan() {
        return hasActiveBookingForVan;
    }

    public void setHasActiveBookingForVan(boolean hasActiveBookingForVan) {
        this.hasActiveBookingForVan = hasActiveBookingForVan;
    }

    public void displayVanSchedule() {
        queueManager.displayVanSchedule();
    }

    @Override
    public void signUp() {
        System.out.println("Customer registered successfully.");
    }

    public void viewAvailability() {
        QueueManager.getInstance().displayAvailableTaxis();
    }

    public void bookTaxi() {
        System.out.println("Enter destination:");
        String destination = scanner.nextLine();

        System.out.println("Select Taxi Type (regular/big/van):");
        String taxiType = scanner.nextLine().toLowerCase().trim();

        switch (taxiType) {
            case "regular":
                Vehicle regularTaxi = queueManager.bookRegularTaxi();
                if (regularTaxi != null) {
                    System.out.println("Regular taxi booked successfully.");
                } else {
                    System.out.println("No regular taxis available at the moment.");
                }
                break;
            case "big":
                Vehicle bigTaxi = queueManager.bookBigTaxi();
                if (bigTaxi != null) {
                    System.out.println("Big taxi booked successfully.");
                } else {
                    System.out.println("No big taxis available at the moment.");
                }
                break;
            case "van":
                queueManager.displayVanSchedule();
                System.out.println("Enter preferred time slot for Van (e.g., 09:00 AM):");
                String timeSlot = scanner.nextLine().trim();
                queueManager.bookVanSlot(timeSlot);
                System.out.println("Van pre-booked successfully!");
                break;
            default:
                System.out.println("Invalid taxi type selected.");
                break;
        }
    }
 
    public void cancelBooking() {
        if (!hasActiveBooking()) {
            System.out.println("You don't have any active bookings.");
            return;
        }
        activeBooking = false;
        System.out.println("Booking canceled successfully.");
    }

    public boolean hasActiveBooking() {
        return activeBooking;
    }

    public void prebookVan(String time) {
        System.out.println("Van pre-booked successfully!");
    }
    
}