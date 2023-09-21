package QStandProject;

public class RegularTaxi extends Vehicle implements TaxiQueue {
	
	    public RegularTaxi(String vehicleNumber) {
	        super(4, vehicleNumber);}


    public void toggleAvailability() {
        setIsAvailable(!getIsAvailable());
    }

    public void confirmBooking(String bookingId) {
        if (bookingId != null && !bookingId.isEmpty()) {
            System.out.println("Booking confirmed for Regular Taxi " + " and Booking ID: " + bookingId);
        } else {
            System.out.println("Booking confirmed for Regular Taxi: ");
        }
        this.setIsAvailable(false);
    }

    public void rejectBooking(String bookingID) {
        System.out.println("Regular Taxi " + " has rejected booking with ID: " + bookingID);
    }


    public void cancelCurrentBooking(String bookingID) {
        if (!getIsAvailable()) {
            System.out.println("Regular Taxi " + " has canceled booking for ID: " + bookingID);
            toggleAvailability();
        } else {
            System.out.println("No active booking to cancel for Regular Taxi ");
        }
    }


    public String toString() {
        return "Regular Taxi - ID: " + getVehicleNumber();
    }
}

