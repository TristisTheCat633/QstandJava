
package QStandProject;
import java.util.Scanner;
public class Customer extends User {
    private String destination;
    private String taxiType;
    private boolean activeBooking;
    private boolean hasActiveBookingForRegularTaxi = false;
    private boolean hasActiveBookingForBigTaxi = false;
    private boolean hasActiveBookingForVan = false;
    private QueueManager queueManager;

    public Customer(String uniqueUsername, String encryptedPassword, QueueManager queueManager) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = queueManager; 
        this.destination = "";
        this.taxiType = "";
        this.activeBooking = false;
    }

    public void viewAvailability() {
        int regularTaxiCount = queueManager.getAvailableRegularTaxis();
        int bigTaxiCount = queueManager.getAvailableBigTaxis();
        int vanCount = queueManager.getAvailableVans();

        System.out.println("Available Taxis");
        System.out.println("Regular Taxi : " + regularTaxiCount);
        System.out.println("Big Taxi : " + bigTaxiCount);
        System.out.println("Van : " + vanCount);
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

    @SuppressWarnings("resource")
	public void bookTaxi() {
        if (!activeBooking) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter destination:");
            this.destination = scanner.nextLine();

            System.out.println("Select Taxi Type (regular/big/van):");
            this.taxiType = scanner.nextLine();

            switch (taxiType) {
                case "regular":
                    queueManager.bookRegularTaxi();
                    break;
                case "big":
                    queueManager.bookBigTaxi();
                    break;
                case "van":
                    System.out.println("Enter preferred time slot for Van (e.g., 09:00 AM):");
                    String timeSlot = scanner.nextLine();
                    try {
                        queueManager.bookVanSlot(this, timeSlot);
                    } catch (QueueManagerExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    break;  
                default:
                    System.out.println("Invalid taxi type selected.");
                    return;
            }
            scanner.close();
            this.activeBooking = true;
            System.out.println("Taxi booked successfully.");
        } else {
            System.out.println("You already have an active booking.");
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