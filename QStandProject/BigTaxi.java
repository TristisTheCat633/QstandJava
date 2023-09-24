package QStandProject;

public class BigTaxi extends Vehicle {
	    public BigTaxi(String vehicleNumber) {
	        super(6, vehicleNumber);
	    }
	

    public void toggleAvailability() {
        setIsAvailable(!getIsAvailable());
    }

    public void confirmBooking(String bookingId) {
        if (bookingId != null && !bookingId.isEmpty()) {
            System.out.println("Booking confirmed for Big Taxi with ID: " + " and Booking ID: " + bookingId);
        } else {
            System.out.println("Booking confirmed for Big Taxi " );
        }
        this.setIsAvailable(false);
    }




    public void rejectBooking(String bookingID) {
        System.out.println("Big Taxi " + " has rejected booking with ID: " + bookingID);
    }

    
    public void cancelCurrentBooking(String bookingID) {
        if (!getIsAvailable()) {
            System.out.println("Big Taxi "+ " has canceled booking for ID: " + bookingID);
            toggleAvailability();
        } else {
            System.out.println("No active booking to cancel for Big Taxi " );
        }
    }
  
    public String toString() {
        return "Regular Taxi - ID: " + getVehicleNumber();
    }
}
