package QStandProject;

public class Customer extends User {
    private boolean activeBooking;
    private boolean hasActiveBookingForRegularTaxi = false;
    private boolean hasActiveBookingForBigTaxi = false;
    private boolean hasActiveBookingForVan = false;
    
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

    private QueueManager queueManager; 
    
    public Customer(String uniqueUsername, String encryptedPassword) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = new QueueManager();
    }
    
    public void viewAvailability() {
        System.out.println("Displaying available taxis...");
    }

    public void displayVanSchedule() {
        queueManager.displayVanSchedule();
    	}

    @Override
    public void signUp() {
        System.out.println("Customer registered successfully.");
    }

    public void bookTaxi(String taxiType) {
        if (hasActiveBooking()) {
            System.out.println(
                    "You already have an active booking. Please complete or cancel the current booking before making a new one.");
            return;
        }
        activeBooking = true;
        System.out.println("Taxi booked successfully.");
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